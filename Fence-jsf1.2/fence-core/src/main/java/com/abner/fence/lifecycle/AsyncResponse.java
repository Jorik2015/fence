package com.abner.fence.lifecycle;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.FactoryFinder;
import javax.faces.application.ViewHandler;
import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.context.ResponseWriterWrapper;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;
import javax.faces.render.ResponseStateManager;
import javax.servlet.http.HttpServletResponse;

import com.abner.fence.application.DeferredStateManager;
import com.abner.fence.util.FastWriter;
import com.abner.fence.util.RequestUtils;
import com.abner.fence.viewroot.PartialViewRoot;
import com.abner.fence.web.RequestContext;

import ext.util.FacesUtils;

public final class AsyncResponse {

	private final static String ASYNC_RESPONSE = "ExtAsyncResponse";
	public static final String VIEW_ID = "PreViewID";
	private ResponseWriter extResponseWriter = null;
	private PartialViewRoot partialViewRoot;
	private transient List<String> execute;
	private transient List<String> renderSubtrees;
	private Object origResponse = null;
	private OnOffResponseWrapper noOffResponse = null;
	private String viewState;
	private boolean hasRedirect = false;

	private AsyncResponse() {
		super();
	}

	public static AsyncResponse getInstance(boolean create) {
		RequestContext requestCtx = RequestContext.instance();
		AsyncResponse async = (AsyncResponse) requestCtx.get(ASYNC_RESPONSE);
		if (async == null && create) {
			async = new AsyncResponse();
			requestCtx.put(ASYNC_RESPONSE, async);
		}
		return async;
	}

	public static AsyncResponse getInstance() {
		return getInstance(true);
	}

	public static void clearInstance() {
		AsyncResponse instance = getInstance(false);
		if (null != instance) {
			instance.clearSubtrees();
			instance.extResponseWriter = null;
			instance.removeOnOffResponse(FacesContext.getCurrentInstance());
		}
	}

	public String getViewState(FacesContext context) {
		if (null == this.viewState) {
			Object stateManagerObj = null;
			if (null != (stateManagerObj = context.getApplication()
					.getStateManager())
					&& stateManagerObj instanceof DeferredStateManager) {
				DeferredStateManager dsm = (DeferredStateManager) stateManagerObj;
				ResponseWriter rw = null;
				try {
					rw = this.getResponseWriter();
					FastWriter fw = new FastWriter(256);
					StateCapture sc = new StateCapture(rw.cloneWithWriter(fw),fw);
					context.setResponseWriter(sc);
					Object stateObj = dsm.getWrapped().saveView(context);
					dsm.getWrapped().writeState(context, stateObj);
					this.viewState = sc.getState();
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					context.setResponseWriter(rw);
				}
			}
		}
		return this.viewState;
	}

	public ResponseWriter getResponseWriter() throws IOException {
		if (null == extResponseWriter) {
			ResponseWriter origWriter = FacesUtils.context().getResponseWriter();

			if (origWriter == null)
				extResponseWriter = this.createAjaxResponseWriter();
			else
				extResponseWriter = new ExtResponseWriter(origWriter);
		}
		return extResponseWriter;
	}

	private ResponseWriter createAjaxResponseWriter() {
		ResponseWriter responseWriter = null;
		RenderKitFactory renderFactory = (RenderKitFactory) FactoryFinder
				.getFactory(FactoryFinder.RENDER_KIT_FACTORY);
		FacesContext context = FacesUtils.context();
		String vireId = context.getViewRoot().getRenderKitId();
		RenderKit renderKit = renderFactory.getRenderKit(context, vireId);
		Writer out = null;
		ExternalContext extContext = context.getExternalContext();
		Object response = (null != origResponse) ? origResponse : extContext
				.getResponse();

		if (null != extContext.getSession(false)) {
			String charEnc = (String) extContext.getSessionMap().get(
					ViewHandler.CHARACTER_ENCODING_KEY);
			try {
				Class<?>[] paramTypes = new Class[] { String.class };
				Method setCharacterEncoding = response.getClass().getMethod(
						"setCharacterEncoding", paramTypes);
				if (null != setCharacterEncoding) {
					Object[] params = { charEnc };
					setCharacterEncoding.invoke(response, params);
				}
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			} catch (SecurityException ex) {
				ex.printStackTrace();
			} catch (InvocationTargetException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			} catch (NoSuchMethodException ex) {
				ex.printStackTrace();
			}
		}
		try {
			Method getWriter = response.getClass().getMethod("getWriter",
					(Class[]) null);
			if (null != getWriter) {
				out = (Writer) getWriter.invoke(response);
			}
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		} catch (SecurityException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		}
		if (null != out) {
			responseWriter = renderKit.createResponseWriter(out, "text/xml",
					context.getExternalContext().getRequestCharacterEncoding());
		}

		return new ExtResponseWriter(responseWriter);
	}

	public void clearSubtrees() {
		if (null != execute) {
			execute.clear();
		}
		execute = null;
		if (null != renderSubtrees) {
			renderSubtrees.clear();
		}
		renderSubtrees = null;
	}

	public String getHandlerId() {
		Map<String, String> paramsMap = FacesUtils.extContext()
				.getRequestParameterMap();
		return paramsMap.get(RequestUtils.HANDLER_PARAM);
	}

	public List<String> getExecute() {
		if (null != execute) {
			return execute;
		}
		execute = populateListFromParams(RequestUtils.EXECUTE_PARAM);
		return this.execute;
	}

	public boolean isRenderRoot(UIComponent component) {
		String clientId = component.getClientId(FacesUtils.context());
		return getRenderSubtrees().contains(clientId);
	}

	public List<String> getRenderSubtrees() {
		if (null != renderSubtrees) {
			return renderSubtrees;
		}
		renderSubtrees = populateListFromParams(RequestUtils.RENDER_PARAM);
		return this.renderSubtrees;
	}

	private List<String> populateListFromParams(String paramName) {
		String param = null;
		String[] pcs = null;
		Map<String, String> requestMap = FacesUtils.extContext().getRequestParameterMap();
		List<String> result = null;
		result = new ArrayList<String>();

		if (!requestMap.containsKey(paramName)) {
			return result;
		}
		param = requestMap.get(paramName).toString();
		if (null != param && param.equalsIgnoreCase("none")) {
			return result;
		}
		if (null != (pcs = param.split(",[ \t]*"))) {
			for (String cur : pcs) {
				cur = cur.trim();
				result.add(cur);
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<UIComponent> getRenderedComponentSubtrees() {
		Map<String, Object> requestMap = FacesUtils.extContext().getRequestMap();
		List<UIComponent> zoneList = (List<UIComponent>) requestMap
				.get(RequestUtils.RENDERED_ZONE_LIST);
		if (null == zoneList) {
			zoneList = getComponentSubtrees(this.getRenderSubtrees());
			requestMap.put(RequestUtils.RENDERED_ZONE_LIST, zoneList);
		}

		return zoneList;
	}

	@SuppressWarnings("unchecked")
	private List<UIComponent> getComponentSubtrees(List<String> subtrees) {
		Map<String, Object> requestMap = FacesUtils.extContext().getRequestMap();
		List<UIComponent> zoneList = (List<UIComponent>) requestMap
				.get(RequestUtils.RENDERED_ZONE_LIST);
		if (null != zoneList)
			return zoneList;

		zoneList = new ArrayList<UIComponent>();
		requestMap.put(RequestUtils.RENDERED_ZONE_LIST, zoneList);
		final UIComponent curZone[] = new UIComponent[1];
		UIViewRoot viewRoot = FacesUtils.context().getViewRoot();
		for (String cur : subtrees) {
			if (viewRoot.invokeOnComponent(FacesUtils.context(), cur,
					new ContextCallback() {
						public void invokeContextCallback(
								FacesContext facesContext,
								UIComponent uIComponent) {
							curZone[0] = uIComponent;
						}

					})) {
				zoneList.add(curZone[0]);
			}
		}

		return zoneList;
	}

	public static void addToRenderList(UIComponent component) {
		AsyncResponse async = AsyncResponse.getInstance();
		FacesContext context = FacesContext.getCurrentInstance();
		List<String> list = async.getRenderSubtrees();
		list.add(component.getClientId(context));
	}

	public void installOnOffResponse(FacesContext context) {
		origResponse = context.getExternalContext().getResponse();
		context.getExternalContext().setResponse(getOnOffResponse(origResponse));
	}

	public void removeOnOffResponse(FacesContext context) {
		if (null != origResponse) {
			context.getExternalContext().setResponse(origResponse);
			origResponse = null;
		}
		noOffResponse = null;
	}

	public boolean isOnOffResponseEnabled() {
		boolean result = false;
		if (null != this.noOffResponse) {
			result = this.noOffResponse.isEnabled();
		}
		return result;
	}

	public void setOnOffResponseEnabled(boolean newValue) {
		if (null != this.noOffResponse) {
			this.noOffResponse.setEnabled(newValue);
		}
	}

	private Object getOnOffResponse(Object orig) {
		if (null == noOffResponse) {
			if (orig instanceof HttpServletResponse) {
				noOffResponse = new OnOffResponseWrapper((HttpServletResponse) orig);
				noOffResponse.setEnabled(false);
			} else {
				// support portlet TODO
				throw new UnsupportedOperationException();
			}
		}
		return noOffResponse;
	}

	private static class StateCapture extends ResponseWriterWrapper {

		protected final ResponseWriter orig;
		private Object state;
		private FastWriter fw;
		private boolean writeState;

		public StateCapture(ResponseWriter orig, FastWriter fw) {
			this.orig = orig;
			this.fw = fw;
		}

		protected ResponseWriter getWrapped() {
			return this.orig;
		}

		public void writeAttribute(String name, Object value, String property)
				throws IOException {
			// if we don't do this, we are ending with the
			// DefaultRenderkitId-value in the state hidden-input field
			if (ResponseStateManager.VIEW_STATE_PARAM.equals(name)) {
				writeState = true;
			}
			if ("value".equals(name) && writeState) {
				this.state = value;
				writeState = false;
			}
		}

		public String getState() {
			String buf = null;
			int i, j;
			if (null == this.state && null != (buf = fw.toString())) {
				if (-1 != (i = buf
						.indexOf(ResponseStateManager.VIEW_STATE_PARAM))) {
					if (-1 != (i = buf.lastIndexOf("<", i))) {
						if (-1 != (i = buf.indexOf("value", i))) {
							if (-1 != (i = buf.indexOf("\"", i))) {
								if (-1 != (j = buf.indexOf("\"", ++i))) {
									state = buf.substring(i, j);
								}
							}
						}
					}
				}
			}
			return this.state != null ? this.state.toString() : "";
		}
	}

	public PartialViewRoot getPartialViewRoot() {
		PartialViewRoot result = this.partialViewRoot;
		if (null == result) {
			UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
			if (root instanceof PartialViewRoot) {
				result = (PartialViewRoot) root;
			}
		}
		return result;
	}

	public void setPartialViewRoot(PartialViewRoot partialViewRoot) {
		this.partialViewRoot = partialViewRoot;
	}
	
	
	public static void handleRedirect(FacesContext context,String location) {
		if (!RequestUtils.isAjaxRequest() || getInstance(false).hasRedirect)
			return;
		
		ViewHandler viewHandler = FacesUtils.getViewHandler(context);

		Object preViewId = RequestContext.instance().get(VIEW_ID);
		boolean needRedirect = false;
		if(location == null){
			location = context.getViewRoot().getViewId();
			needRedirect = preViewId != null && !preViewId.equals(location);
			if(needRedirect)
				location = viewHandler.getActionURL(context, location);
		}else{
			needRedirect = true;
		}
		
		if (preViewId != null && needRedirect) {
			HttpServletResponse servletResponse = (HttpServletResponse) FacesUtils.extContext().getResponse();
			//note:the reset can't execute,because the cookies can't reset
			//servletResponse.reset();
			servletResponse.setContentType("text/xml");
			servletResponse.setHeader("Cache-Control", "no-cache");
			servletResponse.setHeader(RequestUtils.POWEREDBY_HEADER,"Abner.Fence");
			ResponseWriter writer = context.getResponseWriter();

			try {
				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				writer.write("<redirect>");
				writer.write(location);
				writer.write("</redirect>");
				
				getInstance(false).setHasRedirect(true);
				context.responseComplete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void handleRedirect(FacesContext context) {
		handleRedirect(context,null);
	}

	public boolean isHasRedirect() {
		return hasRedirect;
	}

	public void setHasRedirect(boolean hasRedirect) {
		this.hasRedirect = hasRedirect;
	}
}
