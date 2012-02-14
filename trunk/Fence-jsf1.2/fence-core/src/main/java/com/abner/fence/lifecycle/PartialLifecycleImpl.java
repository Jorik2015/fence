/*
 * PartialTraversalLifecycle.java
 *
 * Created on May 15, 2006, 4:31 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abner.fence.lifecycle;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;

import com.abner.fence.exception.ExceptionOutputMaker;
import com.abner.fence.util.JSUtils;
import com.abner.fence.util.RequestUtils;
import com.abner.fence.viewroot.PartialViewRoot;

import ext.util.FacesUtils;

/**
 * 
 * <p>
 * In order to preserve the ability to use server side template text to aid in
 * formatting the AJAX response, it is necessary to allow the <i>render response
 * phase</i> to execute "mostly" normally. The departures from normalcy include:
 * </p>
 * 
 * <ol>
 * 
 * <li>
 * <p>
 * The template text above and belowthe &lt;f:view&gt; tag must be discarded.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * Any output from <code>ResponseWriter.startDocument()</code> and
 * <code>endDocument()</code> must be discarded.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * A distinct set of subtrees of the view are rendered, rather than the whole
 * view.
 * </p>
 * </li>
 * 
 * </ol>
 * 
 * <p>
 * To accomodate these vagaries, this custom <code>Lifecycle</code>
 * implementation, in the {@link #render} method, if the
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
 * method returns <code>true</code>, replaces the <code>ResponseWriter</code>
 * and <code>ResponseStream</code> in the current <code>FacesContext</code> with
 * instances that take no action before calling the original
 * <code>render()</code> method. Otherwise, it simply calls the parent
 * implementation. Upon return from the render method it replaces the
 * <code>ResponseWriter</code> and <code>ResponseStream</code> instance with
 * their original values. The vital necessity of this operation being done in a
 * custom <code>Lifecycle</code> vs a mere <code>PhaseListener</code>: there is
 * no control over the ordering in which <code>PhaseListener</code>s are
 * invoked. Therefore, we need to ensure that <b>none</b> of them write to the
 * response, because doing so would confuse the client.
 * </p>
 * 
 * @author abner
 */
public class PartialLifecycleImpl extends Lifecycle {
	private ExceptionOutputMaker exceptionOutput;
	private Lifecycle parent = null;
	private boolean redundantPhaseListenersRemoved = false;

	public PartialLifecycleImpl(Lifecycle parent) {
		this.parent = parent;
	}

	public void execute(FacesContext context) throws FacesException {
		if (!redundantPhaseListenersRemoved) {
			PhaseListener[] listeners = getPhaseListeners();
			for (int i = 0; i < listeners.length; i++) {
				for (int j = i + 1; j < listeners.length; j++) {
					if (listeners[i].getClass().getName().equals(
							listeners[j].getClass().getName())
							|| listeners[i].equals(listeners[j])) {
						removePhaseListener(listeners[i]);
						break;
					}
				}
			}
			redundantPhaseListenersRemoved = true;
		}
		AsyncResponse async = AsyncResponse.getInstance();
		if (RequestUtils.isAjaxRequest()) {
			async.installOnOffResponse(context);
			async.setOnOffResponseEnabled(true);
		}
		try {
			parent.execute(context);
		} catch (Throwable e) {
			e.printStackTrace();
			handleException(e, "execute");
		} finally {
			PartialViewRoot root = async.getPartialViewRoot();
			if (null != root) {
				root.postExecuteCleanup(context);
			}
		}
	}

	public void render(FacesContext context) throws FacesException {
		if (!RequestUtils.isAjaxRequest()) {
			parent.render(context);
			return;
		}
		AsyncResponse async = AsyncResponse.getInstance();
		try {
			async.setOnOffResponseEnabled(false);
			parent.render(context);
		} catch (Throwable e) {
			e.printStackTrace();
			handleException(e, "render");
		} finally {
			async.removeOnOffResponse(context);
			AsyncResponse.clearInstance();
			JSUtils.getScriptReository().reset();
		}
	}

	private void handleException(Throwable e, String phaseId)
			throws FacesException {
		if (exceptionOutput == null)
			exceptionOutput = new ExceptionOutputMaker();
		if (RequestUtils.isAjaxRequest()) {
			try {
				exceptionOutput.writeErrorMessage(FacesUtils.context(), e,
						phaseId);
			} catch (IOException e1) {
				throw new FacesException(e1);
			}
		} else
			throw new FacesException(e);

	}

	public void removePhaseListener(PhaseListener phaseListener) {
		parent.removePhaseListener(phaseListener);
	}

	public void addPhaseListener(PhaseListener phaseListener) {
		if (!parentHasListener(phaseListener)) {
			parent.addPhaseListener(phaseListener);
		}
	}

	public PhaseListener[] getPhaseListeners() {
		PhaseListener[] result = parent.getPhaseListeners();
		return result;
	}

	private boolean parentHasListener(PhaseListener listener) {
		boolean result = false;
		PhaseListener[] listeners = getPhaseListeners();

		for (PhaseListener cur : listeners) {
			if (cur.getClass().getName().equals(listener.getClass().getName())
					|| cur.equals(listener)) {
				result = true;
				break;
			}
		}

		return result;
	}
}
