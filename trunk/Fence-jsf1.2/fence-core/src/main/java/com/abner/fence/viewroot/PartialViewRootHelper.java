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
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.ActionSource;
import javax.faces.component.ContextCallback;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletResponse;

import com.abner.fence.event.EventParser;
import com.abner.fence.handler.ExtHandler;
import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.util.RequestUtils;
import com.abner.fence.util.WriterUtils;
import com.abner.fence.web.ExtMessage;

import ext.util.ExtFacesMessage;
import ext.util.FacesUtils;
import ext.util.Utils;

/**
 * 
 * <p>
 * Request Processing Lifecycle Operation
 * </p>
 * 
 * <p>
 * This class contains the implementation details needed for a
 * {@link PartialViewRoot} implementation. On initial request, it provides
 * behavior that is the same as a standard <code>UIViewRoot</code>, delegating
 * all behavior to the UIViewRoot. However, since it is unable to call
 * viewRoot.super.method(), it instead returns true from methods that should
 * delegate this. So it is up to the caller to correctly invoke super.method()
 * in these cases.
 * </p>
 * 
 * <p>
 * On postback, the {@link #processDecodes}, {@link #processValidators}, and
 * {@link #processUpdates} methods have special behaviour. If
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
 * returns <code>false</code>, the UIViewRoot superclass implementation of the
 * respective method is called. Otherwise,
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#getExecuteSubtrees}
 * is called. This returns a list of client ids suitable for the
 * <code>execute</code> portion of the request processing lifecycle. If the list
 * is empty, call through to the UIViewRoot superclass implementation of the
 * respective method. Otherwise, for each client id in the list, using
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
 * returns <code>false</code>, the UIViewRoot superclass <code>encode*</code>
 * methods are called. Otherwise,
 * {@link com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#getRenderSubtrees}
 * is called. This returns a list of client ids suitable for the
 * {@link javax.faces.lifecycle.Lifecycle#render} portion of the request
 * processing lifecycle. If the list is empty, call through to the UIViewRoot
 * superclass implementation of <code>encode*</code>. Otherwise, for each client
 * id in the list, using
 * {@link javax.faces.component.UIComponent#invokeOnComponent}, call the
 * <code>encode*</code> methods on the component with that clientId. If the list
 * of subtrees to render for this request is non-empty, set the response
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
 * If the <code>isRenderXML</code> value is <code>false</code>, assume the
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
 * This class uses a hack to make the <code>UIViewRoot.broadcastEvents</code>
 * method public. This is necessary to allow easy broadcasting events during the
 * AJAX lifecycle.
 * </p>
 * 
 */
public class PartialViewRootHelper implements Serializable {
	private static final long serialVersionUID = 8741814854300728897L;
	private PartialViewRoot _viewRoot = null;
	/**
	 * <p>
	 * Request scoped key to hold the original ResponseWriter between
	 * encodeBegin and encodeEnd during Ajax requests.
	 * </p>
	 */
	private static final String ORIGINAL_WRITER = RequestUtils.FACES_PREFIX
			+ "origWriter";

	private transient List<UIComponent> modifiedComponents;
	private transient Utils.TreeTraversalCallback markImmediate;
	private transient Method broadcastEventsMethod = null;
	private boolean hasFacesErrors = false;

	/**
	 * Constructor.
	 */
	public PartialViewRootHelper(PartialViewRoot viewRoot) {
		if (viewRoot == null) {
			throw new IllegalArgumentException(
					"PartialViewRoot cannot be null!");
		}
		setUIViewRoot(viewRoot);

		modifiedComponents = new ArrayList<UIComponent>();

		markImmediate = new Utils.TreeTraversalCallback() {
			public boolean takeActionOnNode(FacesContext context,
					UIComponent comp) throws FacesException {
				if (comp instanceof ActionSource) {
					ActionSource as = (ActionSource) comp;
					if (!as.isImmediate()) {
						as.setImmediate(true);
						modifiedComponents.add(comp);
					}
				} else if (comp instanceof EditableValueHolder) {
					EditableValueHolder ev = (EditableValueHolder) comp;
					if (!ev.isImmediate()) {
						ev.setImmediate(true);
						modifiedComponents.add(comp);
					}
				}

				return true;
			}

		};
	}

	protected PartialViewRoot getUIViewRoot() {
		return _viewRoot;
	}

	protected void setUIViewRoot(PartialViewRoot viewRoot) {
		_viewRoot = viewRoot;
	}

	public void postExecuteCleanup(FacesContext context) {
		for (UIComponent comp : modifiedComponents) {
			if (comp instanceof ActionSource) {
				ActionSource as = (ActionSource) comp;
				assert (as.isImmediate());
				as.setImmediate(false);
			} else if (comp instanceof EditableValueHolder) {
				EditableValueHolder ev = (EditableValueHolder) comp;
				assert (ev.isImmediate());
				ev.setImmediate(false);
			}
		}
		modifiedComponents.clear();
	}

	public boolean processDecodes(FacesContext context) {
		UIComponent comp = (UIComponent) getUIViewRoot();
		AsyncResponse async = AsyncResponse.getInstance();
		modifiedComponents.clear();

		if (RequestUtils.isImmediateAjaxRequest() && RequestUtils.noneRender()
				&& async.getExecute().isEmpty() && !RequestUtils.noneExecute()) {
			Utils.prefixViewTraversal(context, comp, markImmediate);
		}
		EventParser.queueFacesEvents(context);

		return true;
	}

	public boolean processValidators(FacesContext context) {
		return true;
	}

	public boolean processUpdates(FacesContext context) {
		return true;
	}

	public boolean processApplication(FacesContext context) {
		//有可能在此阶段就需要使用RespinseWriter
		AsyncResponse async = AsyncResponse.getInstance();
		try {
			context.setResponseWriter(async.getResponseWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean getRendersChildren(boolean value) {
		if (RequestUtils.isAjaxRequest()) {
			value = true;
		}
		return value;
	}

	public boolean encodeAll(FacesContext context) throws IOException {
		if (RequestUtils.isAjaxRequest()) {
			Iterator<FacesMessage> messages = context.getMessages();
			this.hasFacesErrors = messages.hasNext();
		}
		//hack the contentType for ext use document.compatMode
		//link http://www.greytower.net/archive/articles/xhtmlcontent.html
		HttpServletResponse response = FacesUtils.getResponse();
		
		assert response != null;
		String contentType = response.getContentType();
		if(contentType != null && contentType.indexOf("application/xhtml+xml") >=0){
			contentType = contentType.replace("application/xhtml+xml", "text/html");
		}
		response.setContentType(contentType);
		return true;
	}

	public boolean encodeBegin(FacesContext context) throws IOException {
		AsyncResponse async = AsyncResponse.getInstance();
		PartialViewRoot root = getUIViewRoot();
		if (!RequestUtils.isAjaxRequest()) {
			return true;
		}
		ResponseWriter orig = null, writer = null;

		try {
			async.setOnOffResponseEnabled(true);

			//交由Handler渲染返回结果
			if (RequestUtils.isHandlerRequest())
				return false;
			
			//交由UpdaterContextCallback渲染
			if(RequestUtils.isUpdaterRequest())
				return false;

			if (RequestUtils.hasRender()) {
				writer = async.getResponseWriter();
				orig = context.getResponseWriter();
				FacesUtils.extContext().getRequestMap().put(ORIGINAL_WRITER,orig);
				context.setResponseWriter(writer);
			}

			root.encodePartialResponseBegin(context);
		} catch (IOException ex) {
			throw ex;
		} finally {
			this.cleanupAfterView(context);
		}
		return false;
	}

	public boolean encodeChildren(FacesContext context) throws IOException {
		AsyncResponse async = AsyncResponse.getInstance(false);
		if ((async == null) || !RequestUtils.isAjaxRequest()) {
			return true;
		}

		//有错误的时候在ajax方式时不渲染任何rerender内容。
		//主要是校验转换错误
		if (RequestUtils.isAjaxRequest()) {
			Severity severity = FacesUtils.context().getMaximumSeverity();
			if (severity != null && severity.compareTo(FacesMessage.SEVERITY_WARN) >= 0) {
				return false;
			}
		}

		if (RequestUtils.isHandlerRequest()) {
			String handlerId = async.getHandlerId();
			List<String> renders = async.getRenderSubtrees();

			assert renders.size() <= 1;

			if (handlerId != null) {
				ExtHandler handler = FacesUtils.getBean(handlerId);
				final UIComponent[] comp = new UIComponent[1];
				if (renders.size() == 1) {
					((UIComponent) getUIViewRoot()).invokeOnComponent(context,
							renders.get(0), new ContextCallback() {
								public void invokeContextCallback(FacesContext context, UIComponent target) {
									comp[0] = target;
								}
							});
				}
				if (handler != null)
					handler.render(context, comp[0]);
			}
			return false;
		}else if(RequestUtils.isUpdaterRequest()){
			ContextCallback ctxCallback = new UpdaterContextCallback(PhaseId.RENDER_RESPONSE);
			if (!invokeContextCallbackOnSubtrees(context,ctxCallback) && RequestUtils.hasRender()) {
				assert (false);
			}
			return false;
		}

		if (RequestUtils.isAjaxRequest() && RequestUtils.noneRender()) {
			return false;
		}

		ContextCallback ctxCallback = new RerenderContextCallback(PhaseId.RENDER_RESPONSE);
		if (!invokeContextCallbackOnSubtrees(context,ctxCallback) && RequestUtils.hasRender()) {
			assert (false);
		}

		return false;
	}

	private void displayFacesMessage(FacesContext context) throws IOException {
		AsyncResponse async = AsyncResponse.getInstance();
		ResponseWriter writer = async.getResponseWriter();
		Iterator<FacesMessage> messages = context.getMessages();
		StringBuilder sb = new StringBuilder(256);
		sb.append("<validator>");
		while (messages.hasNext()) {
			FacesMessage message = messages.next();
			if (message instanceof ExtFacesMessage) {
				ExtFacesMessage extMessage = (ExtFacesMessage) message;
				sb.append("<field>");
				sb.append("<id>");
				sb.append(extMessage.getCompId());
				sb.append("</id>");
				sb.append("<msg><![CDATA[");
				sb.append(message.getSummary());
				sb.append("]]></msg>");
				sb.append("</field>");
			} else {
				message.getSummary();
				ExtMessage.show(message,false);
			}
		}
		sb.append("</validator>");
		writer.write(sb.toString());
	}

	/**
	 * 
	 * @return true If super.encodeEnd() should be called.
	 */
	public boolean encodeEnd(FacesContext context) throws IOException {
		AsyncResponse async = AsyncResponse.getInstance(false);
		PartialViewRoot root = getUIViewRoot();
		if ((async == null) || !RequestUtils.isAjaxRequest()) {
			return true;
		}

		try {
			//交由Handler渲染返回结果
			if (RequestUtils.isHandlerRequest())
				return false;
			
			//交由UpdaterContextCallback渲染
			if(RequestUtils.isUpdaterRequest())
				return false;

			root.encodePartialResponseEnd(context);
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			this.cleanupAfterView(context);
		}

		return false;
	}

	public void encodePartialResponseBegin(FacesContext context)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		ExternalContext extContext = context.getExternalContext();

		if (FacesUtils.extContext().getResponse() instanceof HttpServletResponse) {
			HttpServletResponse servletResponse = (HttpServletResponse) extContext.getResponse();
			servletResponse.setContentType("text/xml");
			servletResponse.setCharacterEncoding("utf-8");
			servletResponse.setHeader("Cache-Control", "no-cache");
			servletResponse.setHeader(RequestUtils.POWEREDBY_HEADER,"Abner.Fence");

			UIComponent root = (UIComponent) getUIViewRoot();
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			writer.startElement(WriterUtils.PARTIAL_TAG, root);
			writer.writeAttribute("success", String.valueOf(!this.hasFacesErrors), "success");
			writer.write("<components>");
		}
	}

	public void encodePartialResponseEnd(FacesContext context)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		AsyncResponse async = AsyncResponse.getInstance();
		PartialViewRoot root = async.getPartialViewRoot();

		this.broadcastEvents(context, PhaseId.RENDER_RESPONSE);

		writer = async.getResponseWriter();
		if (!(root instanceof UIComponent)) {
			throw new IllegalStateException("Class returned from"
					+ " AsyncResponse.getPartialViewRoot"
					+ " must be a UIComponent");
		}

		if (FacesUtils.extContext().getResponse() instanceof HttpServletResponse) {
			writer.write("</components>");

			if (this.hasFacesErrors) {
				this.displayFacesMessage(context);
			}
			
			WriterUtils.writerState(writer);
			WriterUtils.writerAjaxScript(writer);
			writer.write("<success>" + !this.hasFacesErrors + "</success>");
			writer.endElement(WriterUtils.PARTIAL_TAG);
		}
	}

	private void broadcastEvents(FacesContext ctx, PhaseId phaseId) {
		// Broadcast the regular FacesEvents
		try {
			getBroadcastEventsMethod().invoke(getUIViewRoot(), ctx, phaseId);
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		}

		// Do our extra special MethodExpression invocation
		EventParser.invokeComponentMethodCallbackForPhase(ctx, phaseId);
	}

	@SuppressWarnings("unchecked")
	private void cleanupAfterView(FacesContext context) {
		ResponseWriter orig = (ResponseWriter) context.getExternalContext()
				.getRequestMap().get(ORIGINAL_WRITER);
		assert (null != orig);

		// PENDING(edburns): this is a big hack to get around the
		// way the JSP based faces implementation handles the
		// after view content.
		// We will have to do something different for other implementations.
		// This is not a problem for Facelets.
		Map<String, Object> reqStateMap = (Map<String, Object>) context
				.getExternalContext().getRequestMap().get(
						"com.sun.faces.util.RequestStateManager");
		if (null != reqStateMap) {
			reqStateMap.remove("com.sun.faces.AFTER_VIEW_CONTENT");
		} else {
			context.getExternalContext().getRequestMap().remove(
					"com.sun.faces.AFTER_VIEW_CONTENT");
		}

		// move aside the AjaxResponseWriter
		if (null != orig) {
			context.setResponseWriter(orig);
		}
	}

	private boolean invokeContextCallbackOnSubtrees(FacesContext context,ContextCallback cb) {
		AsyncResponse async = AsyncResponse.getInstance();
		List<String> subtrees = async.getRenderSubtrees();

		boolean result = false;

		for (String cur : subtrees) {
			if (((UIComponent) getUIViewRoot()).invokeOnComponent(context, cur,	cb)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * <p>
	 * This method returns a publicly usable broadcastEvents method.
	 * </p>
	 */
	private Method getBroadcastEventsMethod() {
		if (broadcastEventsMethod == null) {
			try {
				broadcastEventsMethod = UIViewRoot.class.getDeclaredMethod(
						"broadcastEvents", FacesContext.class, PhaseId.class);
				broadcastEventsMethod.setAccessible(true);
			} catch (NoSuchMethodException ex) {
				throw new RuntimeException(
						"broadcastEvents method not found on UIViewRoot!", ex);
			}
		}
		return broadcastEventsMethod;
	}
}
