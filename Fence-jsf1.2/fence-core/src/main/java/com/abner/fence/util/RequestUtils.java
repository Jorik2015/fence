package com.abner.fence.util;

import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.abner.fence.web.RequestContext;

import ext.util.FacesUtils;
import ext.util.StringUtil;

//TODO
public class RequestUtils {
	public static final String FACES_PREFIX = "EXT_";
	public static final String POWEREDBY_HEADER = "Powered-By";
	public final static String AJAX_PARAM = FACES_PREFIX + "AJAX";
	public static final String RENDER_PARAM = FACES_PREFIX + "RERENDER";
	public static final String IMMEDIATE_PARAM = FACES_PREFIX + "IMMEDIATE";
	public static final String EXECUTE_PARAM = FACES_PREFIX + "EXECUTE";
	public static final String HANDLER_PARAM = FACES_PREFIX + "HANDLER";
	public static final String UPDATER_PARAM = FACES_PREFIX + "UPDATER";
	
	public static final String VIEW_STATE_KEY = "javax.faces.ViewState";
	public static final String VIEW_STATE_RENDER = FACES_PREFIX	+ "ViewStateRender";

	public static final String METHOD_NAME_HEADER = FACES_PREFIX + "MethodName";
	public static final String FACES_EVENT_HEADER = FACES_PREFIX + "FacesEvent";
	public static final String FACES_EVENT_CONTEXT_PARAM = "ext.faces.FacesEvents";
	public static final String RENDERED_ZONE_LIST = "RENDERED_AJAX_COMPONENT_LIST";

	public static String getParam(String paramName) {
		ExternalContext ext = FacesUtils.extContext();
		Map<String, String> p = ext.getRequestParameterMap();
		if (p.containsKey(paramName))
			return p.get(paramName);

		return null;
	}

	public static String getAjaxActionPath() {
		ViewHandler viewHandler = FacesUtils.context().getApplication().getViewHandler();
		String viewId = FacesUtils.context().getViewRoot().getViewId();
		
		String queryString = FacesUtils.getRequest().getQueryString();
		queryString = StringUtil.ifEmpty(queryString, "");
		if(StringUtil.isEmpty(queryString)){
			queryString = "";
		}else{
			queryString = "?" + queryString;
		}
		return viewHandler.getActionURL(FacesUtils.context(), viewId) + queryString;
	}

	private static boolean symbolParam(String key) {
		ExternalContext ext = FacesUtils.extContext();
		boolean result = false;
		Map<String, Object> requestMap = ext.getRequestMap();
		Object value = requestMap.get(key);
		if (value != null && "true".equalsIgnoreCase(value.toString())) {
			return true;
		}

		Map<String, String> params = ext.getRequestParameterMap();
		value = params.get(key);
		if (value != null && "true".equalsIgnoreCase(value.toString())) {
			requestMap.put(key, Boolean.TRUE);
			result = true;
		}
		return result;
	}

	public static boolean isPostBack() {
		ExternalContext ext = FacesUtils.extContext();
		boolean result = false;
		Map<String, Object> requestMap = ext.getRequestMap();
		Object value = requestMap.get(VIEW_STATE_KEY);
		if (!StringUtil.isEmpty(value)) {
			return true;
		}

		Map<String, String> params = ext.getRequestParameterMap();
		value = params.get(VIEW_STATE_KEY);
		if (!StringUtil.isEmpty(value)) {
			requestMap.put(VIEW_STATE_KEY, Boolean.TRUE);
			result = true;
		}
		return result;
	}

	public static boolean isAjaxRequest() {
		return symbolParam(AJAX_PARAM);
	}
	
	public static boolean isUpdaterRequest() {
		return symbolParam(UPDATER_PARAM);
	}

	public static boolean isImmediateAjaxRequest() {
		return symbolParam(IMMEDIATE_PARAM);
	}


	public static boolean hasRenderViewState() {
		return RequestContext.instance().get(VIEW_STATE_RENDER) != null;
	}

	public static boolean isHandlerRequest() {
		if (!isAjaxRequest())
			return false;

		ExternalContext ext = FacesUtils.extContext();
		boolean result = false;
		Map<String, Object> requestMap = ext.getRequestMap();
		result = requestMap.containsKey(RequestUtils.HANDLER_PARAM);
		if (result) {
			return true;
		}

		Map<String, String> p = ext.getRequestParameterMap();
		result = p.containsKey(RequestUtils.HANDLER_PARAM);
		if (result) {
			requestMap.put(RequestUtils.HANDLER_PARAM, String.valueOf(true));
			return true;
		}

		return result;
	}

	public static boolean hasRender() {
		boolean result = false;
		String param = null;
		ExternalContext extContext = FacesUtils.extContext();
		Map<String, String> requestParamMap = extContext
				.getRequestParameterMap();
		Map<String, Object> requestMap = extContext.getRequestMap();

		if (requestMap.containsKey(RequestUtils.RENDER_PARAM)) {
			return true;
		}
		param = requestParamMap.get(RequestUtils.RENDER_PARAM);
		result = !StringUtil.isEmpty(param);
		if (result) {
			requestMap.put(RequestUtils.RENDER_PARAM, Boolean.TRUE);
		}

		return result;
	}

	public static boolean noneRender() {
		return !hasRender();
	}

	public static boolean noneExecute() {
		boolean result = false;
		String param = null;
		ExternalContext extContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, String> requestHeaderMap = extContext.getRequestHeaderMap();
		Map<String, Object> requestMap = extContext.getRequestMap();

		if (requestMap.containsKey(RequestUtils.EXECUTE_PARAM)) {
			return true;
		}
		param = requestHeaderMap.get(RequestUtils.EXECUTE_PARAM);
		result = null != param && param.equalsIgnoreCase("none");
		if (result) {
			requestMap.put(RequestUtils.EXECUTE_PARAM, Boolean.TRUE);
		}

		return result;
	}
}
