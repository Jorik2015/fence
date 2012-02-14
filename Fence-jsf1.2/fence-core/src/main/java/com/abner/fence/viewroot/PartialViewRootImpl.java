/*
 * $Id: PartialTraversalViewRoot.java,v 1.4 2005/12/21 22:38:09 edburns Exp $
 */

/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * https://javaserverfaces.dev.java.net/CDDL.html or
 * legal/CDDLv1.0.txt.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at legal/CDDLv1.0.txt.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * [Name of File] [ver.__] [Date]
 *
 * Copyright 2005 Sun Microsystems Inc. All Rights Reserved
 */

package com.abner.fence.viewroot;

import java.io.IOException;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.web.RequestContext;

/**
 * 
 * <p>
 * Request Processing Lifecycle Operation
 * </p>
 * 
 * <p>
 * On initial request, this instance behaves effectively like the
 * <code>UIViewRoot</code> from which it extends, delegating all behavior to the
 * superclass.
 * </p>
 * 
 * <p>
 * On postback, the {@link #processDecodes}, {@link #processValidators}, and
 * {@link #processUpdates} methods have special behaviour. If
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
 * returns <code>false</code>, the superclass implementation of the respective
 * method is called. Otherwise,
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#getExecuteSubtrees}
 * is called. This returns a list of client ids suitable for the
 * <code>execute</code> portion of the request processing lifecycle. If the list
 * is empty, call through to the superclass implementation of the respective
 * method. Otherwise, for each client id in the list, using
 * <code>invokeOnComponent</code>, call the respective <code>process*</code>
 * method on the component with that clientId. After all the client ids in the
 * list have been handled for the current phase, reflectively call
 * <code>broadcastEvents()</code> on the superclass passing the current
 * <code>PhaseId</code>.
 * </p>
 * 
 * <p>
 * On postback, the {@link #encodeBegin}, {@link #encodeChildren} and
 * {@link #encodeEnd} methods have special behavior. If
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
 * returns <code>false</code>, the superclass <code>encode*</code> methods are
 * called. Otherwise,
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#getRenderSubtrees}
 * is called. This returns a list of client ids suitable for the
 * {@link javax.faces.lifecycle.Lifecycle#render} portion of the request
 * processing lifecycle. If the list is empty, call through to the superclass
 * implementation of <code>encode*</code>. Otherwise, for each client id in the
 * list, using {@link javax.faces.component.UIComponent#invokeOnComponent}, call
 * the <code>encode*</code> methods on the component with that clientId. If the
 * list of subtrees to render for this request is non-empty, set the response
 * content-type and headers approriately for XML, and wrap the rendered output
 * from the components in the list as in the following example.
 * </p>
 * 
 * <pre>
 * &lt;code&gt;
 * &lt;partial-response&gt;
 *   &lt;components&gt;
 *     &lt;render id=&quot;form:table&quot;/&gt;
 *       &lt;markup&gt;&lt;![CDATA[
 *         Rendered content from component
 *       ]]&gt;&lt;/markup&gt;
 *       &lt;messages&gt;
 *         &lt;message&gt;The messages element is optional.  If present,
 *                  it is a list of FacesMessage.getSummary() output
 *         &lt;/message&gt;
 *       &lt;/messages&gt;
 *     &lt;/render&gt;
 *     &lt;!-- repeat for the appropriate number of components --&gt;
 *   &lt;/components&gt;
 *   &lt;state&gt;&lt;![CDATA[state information for this view ]]&gt;&lt;/state&gt;
 * &lt;/partial-response&gt;
 * &lt;/code&gt;
 * </pre>
 * 
 * if the <code>isRenderXML</code> value is <code>false</code>, assume the
 * renderers are handling the content-type, header, and component encapsulation
 * details and write nothing to the response.</p>
 * 
 * <p>
 * See {@link com.abner.fence.lifecycle.PartialLifecycleImpl} for additional
 * information about how this class helps <code>PartialTraversalViewRoot</code>
 * get its job done.
 * </p>
 * 
 * <p>
 * This class extends <code>UIViewRoot</code>, which is a local copy of
 * <code>UIViewRoot</code> that makes the <code>broadcastEvents</code> method
 * public. This is necessary to allow easily broadcasting events during the AJAX
 * lifecycle.
 * </p>
 * 
 * @author abner
 */
public class PartialViewRootImpl extends UIViewRoot implements PartialViewRoot {

	private PartialViewRootHelper helper = null;

	public PartialViewRootImpl() {
		helper = new PartialViewRootHelper(this);
	}

	public void processDecodes(FacesContext context) {
		RequestContext.instance().put(AsyncResponse.VIEW_ID,context.getViewRoot().getViewId());

		if (helper.processDecodes(context)) {
			super.processDecodes(context);
		}
	}

	public void processValidators(FacesContext context) {
		if (helper.processValidators(context)) {
			super.processValidators(context);
		}
	}

	public void processUpdates(FacesContext context) {
		if (helper.processUpdates(context)) {
			super.processUpdates(context);
		}
	}

	@Override
	public void processApplication(FacesContext context) {
		if (helper.processApplication(context)) {
			super.processApplication(context);
		}
		AsyncResponse.handleRedirect(context);
	}

	public boolean getRendersChildren() {
		return helper.getRendersChildren(super.getRendersChildren());
	}

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		if (helper.encodeAll(context)) {
			super.encodeAll(context);
		}
	}

	public void encodeBegin(FacesContext context) throws IOException {
		if (helper.encodeBegin(context)) {
			super.encodeBegin(context);
		}
	}

	public void encodeChildren(FacesContext context) throws IOException {
		if (helper.encodeChildren(context)) {
			super.encodeChildren(context);
		}
	}

	public void encodeEnd(FacesContext context) throws IOException {
		if (helper.encodeEnd(context)) {
			super.encodeEnd(context);
		}
	}

	public void postExecuteCleanup(FacesContext context) {
		helper.postExecuteCleanup(context);
	}

	public void encodePartialResponseBegin(FacesContext context)
			throws IOException {
		helper.encodePartialResponseBegin(context);
	}

	public void encodePartialResponseEnd(FacesContext context)
			throws IOException {
		helper.encodePartialResponseEnd(context);
	}
}
