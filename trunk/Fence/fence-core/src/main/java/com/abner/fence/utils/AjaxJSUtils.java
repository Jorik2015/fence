package com.abner.fence.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.abner.fence.ajax.RequestOptions;
import com.abner.fence.ajax.UpdateOptions;
import com.abner.fence.commons.ExtComponentMetaData;
import com.abner.fence.commons.Enums.ReferenceMode;
import com.abner.fence.component.ExtCommand;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.component.ScriptManager;
import com.abner.fence.renderkit.ExtBasicRenderer;

import ext.Action;
import ext.Button;
import ext.util.Observable;

public final class AjaxJSUtils {
	public final static String Div = "div";
	public final static String Span = "span";
	public final static String Input = "input";
	public final static String Render = "render";
	public final static String P = "p";
	public final static String UL = "ul";

	public static UpdateOptions updaterOptions(FacesContext context, Observable comp) {
		UpdateOptions updaterChild = ComponentUtils.getFirstExtChild(comp, UpdateOptions.class);
		UpdateOptions updater = new UpdateOptions();
		if (updaterChild != null) {
			updater.setUrl(updaterChild.getUrl());
			updater.setParams(updaterChild.getParams());
			updater.setCallback(updaterChild.getCallback());

			if (updaterChild.getInterval() == null) {
				updater.setMethod(updaterChild.getMethod());
				updater.setScope(updaterChild.getScope());
				updater.setDiscardUrl(updaterChild.getDiscardUrl());
				updater.setTimeout(updaterChild.getTimeout());
				updater.setText(updaterChild.getText());
				updater.setScripts(updaterChild.getScripts());
				updater.setNocache(updaterChild.getNocache());
			} else {
				updater.setInterval(updaterChild.getInterval());
				updater.setRefreshNow(updaterChild.getRefreshNow());
			}
		}

		Map<String, Object> params = new HashMap<String, Object>();
		Object origParams = updater.getParams();
		if (origParams != null) {
			// process the input params
			String parStr = null;
			if (origParams instanceof String) {
				parStr = origParams.toString();
			} else {
				parStr = JsonUtils.toJson(origParams).toString();
			}

			assert parStr != null;

			if (parStr.startsWith("&")) {
				String[] pars = parStr.split("&");
				for (String p : pars) {
					if (p.indexOf("=") > 0) {
						params.put(p.split("=")[0], p.split("=")[1]);
					}
				}
			} else if (JSONUtils.mayBeJSON(parStr)) {
				JSONObject jsonParams = JSONObject.fromObject(origParams);
				for (Iterator<?> iter = jsonParams.keys(); iter.hasNext();) {
					String key = (String) iter.next();
					params.put(key, jsonParams.get(key));
				}
			}
		}
		params.putAll(ExtBasicRenderer.getParamList(comp, true));
		if (updaterChild != null) {
			params.putAll(ExtBasicRenderer.getParamList(updaterChild, true));
		}

		params.put(RequestUtils.AJAX_PARAM, Boolean.TRUE);
		params.put(RequestUtils.UPDATER_PARAM, Boolean.TRUE);
		params.put(RequestUtils.RENDER_PARAM, comp.getClientId(context));
		params.put(RequestUtils.EXECUTE_PARAM, comp.getClientId(context));
		updater.handleConfig("params", getAjaxParamsConfig(context, null, false, params));

		if (updater.getUrl() == null)
			updater.setUrl(RequestUtils.getAjaxActionPath());

		if (updater.getCallback() == null)
			updater.setCallback(JSUtils.UpdaterCallBack);

		if (updater.getScripts() == null && updater.getInterval() == null)
			updater.setScripts(Boolean.TRUE);

		if (updater.getDiscardUrl() == null && updater.getInterval() == null)
			updater.setDiscardUrl(Boolean.TRUE);

		return updater;
	}

	public static String encodeUpdaterOptions(FacesContext context, Observable comp) {
		return ConfigUtils.interpretConfig(updaterOptions(context, comp));
	}

	public static String encodeAjaxRequestFn(FacesContext context, ExtCommand btn) {
		return encodeAjaxRequestFn(context, btn, false, null);
	}

	private static String encodeAjaxRequestFn(FacesContext context, ExtCommand btn, boolean post,
			Map<String, Object> params) {
		if (params == null)
			params = new HashMap<String, Object>();

		RequestOptions reqOpts = ComponentUtils.getFirstExtChild(btn, RequestOptions.class);
		if (reqOpts != null && reqOpts.getParams() != null) {
			JSONObject origParams = JSONObject.fromObject(reqOpts.getParams());
			for (Iterator<?> iter = origParams.keys(); iter.hasNext();) {
				String key = (String) iter.next();
				params.put(key, origParams.get(key));
			}
		}
		params.putAll(ExtBasicRenderer.getParamList(btn));
		if (reqOpts != null) {
			if (reqOpts.getFailure() == null)
				reqOpts.setFailure(JSUtils.AjaxFailureCallBack);

			if (reqOpts.getSuccess() == null)
				reqOpts.setSuccess(JSUtils.AjaxSuccessCallBack);

			if (reqOpts.getCallback() == null)
				reqOpts.setCallback(JSUtils.AjaxCallBack);

			if (reqOpts.getUrl() == null)
				reqOpts.setUrl(ExtUtils.PREFIX_RAW_VALUE + ScriptManager.AJAX_PATH);

			if (reqOpts.getWaitMsg() == null)
				reqOpts.setWaitMsg("Loading...");

			params.putAll(ExtBasicRenderer.getParamList(reqOpts));
		} else {
			reqOpts = new RequestOptions();
			reqOpts.setWaitMsg("Loading...");
		}

		reqOpts.handleConfig("params", getAjaxParamsConfig(context, btn, post, params));

		/*
		 * if (reqOpts.getSuccessFn() == null) reqOpts.setSuccessFn(btn.getSuccessFn());
		 */

		// reqOpts.handleConfig("src", Ext.PREFIX_RAW_VALUE + "src");

		return MessageFormat.format(ScriptManager.AJAX_REQUEST_TEMP, "src", "e", ConfigUtils.interpretConfig(reqOpts));
	}

	private static String getAjaxParamsConfig(FacesContext context, ExtCommand btn, boolean post,
			Map<String, Object> par) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(RequestUtils.AJAX_PARAM, Boolean.TRUE);
		if (btn != null) {
			// params.put(RequestUtils.RENDER_PARAM, btn.getRender());
			params.put(RequestUtils.EXECUTE_PARAM, btn.getClientId(context));
		}

		if (post)
			params.put(RequestUtils.VIEW_STATE_KEY, ExtUtils.PREFIX_RAW_VALUE + "Fence.getViewState()");

		if (par != null && !par.isEmpty())
			params.putAll(par);

		StringBuilder sb = new StringBuilder(128);
		int i = 0;
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (null == entry.getValue())
				continue;

			if (i > 0)
				sb.append(",");

			boolean useRaw = false;
			if (!useRaw && value instanceof String && value.toString().startsWith(ExtUtils.PREFIX_RAW_VALUE)) {
				useRaw = true;
				value = value.toString().replaceAll(ExtUtils.PREFIX_RAW_VALUE, "");
			}

			if (!useRaw && value instanceof Boolean)
				useRaw = true;

			if (!useRaw && value instanceof String && NumberUtils.isNumber((String) value))
				useRaw = true;

			if (!useRaw) {
				value = "\"" + value + "\"";
			}
			sb.append("\"" + key + "\":" + value);
			i++;
		}
		sb.insert(0, "{");
		sb.append("}");
		return sb.toString();
	}

	public static void handleEvent(ExtComponent comp, String name, String handlerString) {
		handleEvent(comp, name, handlerString, false);
	}

	public static void handleEvent(ExtComponent comp, String name, String handlerString, boolean finalClick) {
		if (Strings.isEmpty(name))
			return;

		if (handlerString == null)
			return;

		ExtComponentMetaData metadata = ComponentUtils.getMetadata(comp);
		String var = comp.getVar();
		if (metadata != null && metadata.getRmode() == ReferenceMode.Config) {
			var = "Ext.getCmp('" + var + "')";
		}

		boolean isCommand = comp instanceof ExtCommand;
		String confirmText = isCommand ? ((ExtCommand) comp).getConfirmText() : null;

		boolean isConfirm = !Strings.isEmpty(confirmText);
		boolean isClick = "click".equals(name) || "handler".equals(name);
		if (isCommand && isClick && isConfirm) {
			confirmText = StringEscapeUtils.escapeJavaScript(confirmText);
			// only the click event handler the confirm.
			if (finalClick) {
				StringBuilder sb = new StringBuilder(256);
				sb.append("if(btn != 'yes') return;");

				// first handler
				Object handler = null;
				if (comp instanceof Button) {
					handler = ((Button) comp).getHandler();
				} else if (comp instanceof Action) {
					handler = ((Action) comp).getHandler();
				}

				if (!Strings.isEmpty(handler)) {
					sb.append("Ext.callback(");
					if (JSONUtils.isFunction(handler) || JSUtils.isRefFunction(handler.toString())) {
						sb.append(handler);
					} else {
						sb.append(new JSONFunction(handler.toString()));
					}
					sb.append(",null");
					sb.append(",[src,e]);");
					comp.handleConfig("handler", null);
				}

				// second the click event
				List<String> clickListener = JSUtils.getScriptReository().getClickListener(comp);
				for (String script : clickListener) {
					sb.append("Ext.callback(");
					if (JSONUtils.isFunction(script) || JSUtils.isRefFunction(script)) {
						sb.append(script);
					} else {
						sb.append(new JSONFunction(script.toString()));
					}
					sb.append(",null");
					sb.append(",[src,e]);");
				}

				// three the encode ajax request
				if (JSONUtils.isFunction(handlerString)) {
					handlerString = JSONFunction.parse(handlerString).getText();
				}
				sb.append(handlerString);

				String confirm = ScriptManager.ConfirmTemp;
				confirm = MessageFormat.format(confirm, confirmText, new JSONFunction(new String[] { "btn" }, sb
						.toString()));

				if (comp instanceof Action) {
					encodeActionHandler((Action) comp, confirm, true);
				} else {
					confirm = MessageFormat.format(ScriptManager.ADDLISTENER_TEMP, var, "click", new JSONFunction(
							new String[] { "src", "e" }, confirm));

					JSUtils.RegisterAfterClientInitScript(confirm);
				}
			} else {
				if (handlerString.length() == 0)
					return;

				JSUtils.addClickListener(comp, handlerString);
			}
		} else {
			if (handlerString.length() == 0)
				return;

			// the action no event and extend from Object ,so not the on method
			if (comp instanceof Action) {
				encodeActionHandler((Action) comp, handlerString, false);
			} else {
				JSUtils.RegisterAfterClientInitScript(MessageFormat.format(ScriptManager.ADDLISTENER_TEMP, var, name,
						handlerString));
			}
		}
	}

	private static void encodeActionHandler(Action comp, String handlerString, boolean isConfirm) {
		if (isConfirm) {
			comp.handleConfig("handler", new JSONFunction(new String[] { "src", "e" }, handlerString));
			return;
		}
		StringBuilder sb = new StringBuilder(256);
		Object handler = comp.getHandler();

		if (!Strings.isEmpty(handler)) {
			sb.append("Ext.callback(");
			if (JSONUtils.isFunction(handler) || JSUtils.isRefFunction(handler.toString())) {
				sb.append(handler);
			} else {
				sb.append(new JSONFunction(handler.toString()));
			}
			sb.append(",null");
			sb.append(",[src,e]);");
			comp.handleConfig("handler", null);
		}

		// three the encode ajax request
		if (JSONUtils.isFunction(handlerString)) {
			handlerString = JSONFunction.parse(handlerString).getText();
		}
		sb.append(handlerString);
		sb.insert(0, "function(src,e){");
		sb.append("}");

		comp.handleConfig("handler", sb);
	}

	public static void showAllContentDiv() {
		JSONFunction fun = new JSONFunction(new String[] { "item", "index", "length" }, "Ext.get(item).show();");
		JSUtils.RegisterAfterClientInitScript("(function(){" + ScriptManager.All_HTML_CONTENT_DIV_VAR + ".each("
				+ fun.toString() + ");}).defer(10);");
	}
}
