package com.abner.fence.utils;

import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.PartialViewContext;

import com.abner.fence.context.ExtPartialViewContextImpl;

//TODO
public class RequestUtils {
	public static final String FACES_PREFIX = "EXT_";
	public static final String POWEREDBY_HEADER = "Powered-By";
	public static final String VIEW_STATE_KEY = "javax.faces.ViewState";
	public final static String AJAX_PARAM = "javax.faces.partial.ajax";
	public static final String RENDER_PARAM = "javax.faces.partial.render";
	public static final String EXECUTE_PARAM = "javax.faces.partial.execute";
	public static final String SOURCE_PARAM = "javax.faces.source";
	public static final String EVENT_PARAM = "javax.faces.partial.event";

	public static final String HANDLER_PARAM = "javax.faces.partial.handler";
	public static final String UPDATER_PARAM = "javax.faces.partial.updater";

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
		queryString = Strings.ifEmpty(queryString, "");
		if (Strings.isEmpty(queryString)) {
			queryString = "";
		} else {
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
		if (!Strings.isEmpty(value)) {
			return true;
		}

		Map<String, String> params = ext.getRequestParameterMap();
		value = params.get(VIEW_STATE_KEY);
		if (!Strings.isEmpty(value)) {
			requestMap.put(VIEW_STATE_KEY, Boolean.TRUE);
			result = true;
		}
		return result;
	}

	public static boolean isAjaxRequest() {
		PartialViewContext context = FacesUtils.context().getPartialViewContext();
		return context.isAjaxRequest();
	}

	public static boolean isUpdaterRequest() {
		return symbolParam(UPDATER_PARAM);
	}

	public static boolean isHandlerRequest() {
		PartialViewContext pcontext = FacesUtils.context().getPartialViewContext();
		if (pcontext instanceof ExtPartialViewContextImpl) {
			return ((ExtPartialViewContextImpl) pcontext).isHandlerRequest();
		}

		return false;
	}
}
