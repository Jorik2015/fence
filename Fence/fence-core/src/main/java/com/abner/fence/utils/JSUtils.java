package com.abner.fence.utils;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.util.JSONUtils;

import com.abner.fence.component.ExtComponent;
import com.abner.fence.web.RequestContext;
import com.abner.fence.web.ScriptReository;
import com.abner.fence.web.SessionContext;

public class JSUtils {
	public static final String JSF_SCRIPT_STATE = "JSF_SCRIPT_STATE";
	public static final String FENCE_BASE_INSTANCE = "Fence";
	public static final String FormSuccessCallBack = "Fence.Actions.formSuccess";
	public static final String FormFailureCallBack = "Fence.Actions.formFailure";
	public static final String ActionSuccessCallBack = "Fence.Actions.actionSuccess";
	public static final String ActionFailureCallBack = "Fence.Actions.actionFailure";
	public static final String AjaxSuccessCallBack = "Fence.Actions.ajaxSuccess";
	public static final String AjaxFailureCallBack = "Fence.Actions.ajaxFailure";
	public static final String UpdaterCallBack = "Fence.Actions.updaterCallBack";
	public static final String AjaxCallBack = "Fence.Actions.ajaxCallBack";
	public static final String StoreException = "Fence.Actions.storeException";

	public static final String getGlobalScript() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("Ext.Ajax.defaultHeaders = {'Powered-By': 'Abner.Fence','Faces-Request':'partial/ajax'};\n");
		sb.append("Ext.QuickTips.init();");
		sb.append("Ext.Ajax.timeout = 1200000;");
		return sb.toString();
	}

	public static void putGlobalVar(String... vars) {
		getScriptReository().putGlobalVar(vars);
	}

	public static boolean isRefFunction(String text) {
		if (Strings.isEmpty(text))
			return false;

		if (!JSONUtils.isFunction(text) && !text.trim().endsWith(");") && !text.trim().endsWith(")")) {
			return true;
		}

		return false;
	}

	public static boolean isFunction(String text) {
		if (Strings.isEmpty(text))
			return false;

		if (!text.trim().endsWith(";"))
			text += ";";

		// we believe the ref function is a function e.g 'fence.action.CallBack'
		if (!text.trim().endsWith(");") && !text.trim().endsWith("false;") && !text.trim().endsWith("true;")) {
			return true;
		}

		return JSONUtils.isFunction(text);
	}

	public static boolean isFunctionInstance(String text) {
		if (Strings.isEmpty(text))
			return false;

		if (text.trim().endsWith(")") || text.trim().endsWith(");")) {
			return true;
		}
		return false;
	}

	public static String getKey() {
		Object key = RequestContext.instance().get(ScriptReository.SCRIPT_REPOSITORY_KEY);
		if (key == null) {
			key = SessionContext.instance().genUniqueKey(ScriptReository.SCRIPT_REPOSITORY_KEY);
			RequestContext.instance().put(ScriptReository.SCRIPT_REPOSITORY_KEY, key);
		}
		return (String) key;
	}

	public static final ScriptReository getScriptReository(String requestKey, HttpServletRequest request) {
		Object obj = null;
		if (requestKey == null) {
			if (FacesUtils.context() == null) {
				throw new IllegalStateException("You must access the ScriptRepository in FacesContext or give a key.");
			} else {
				obj = SessionContext.instance().get(getKey());
				if (obj == null) {
					obj = new ScriptReository();
					SessionContext.instance().put(getKey(), obj);
				}
			}
		} else {
			assert request != null;

			obj = SessionContext.instance(request).get(requestKey);

			assert obj != null;
		}

		return (ScriptReository) obj;
	}

	public static final ScriptReository getScriptReository() {
		return getScriptReository(null, null);
	}

	public static void RegisterGlobalClientScript(String script) {
		ScriptReository sr = getScriptReository();
		if (sr == null)
			return;
		sr.RegisterGlobalClientScript(script);
	}

	public static void RegisterBeforeClientInitScript(String script) {
		ScriptReository sr = getScriptReository();
		if (sr == null)
			return;
		sr.RegisterBeforeClientInitScript(script);
	}

	public static void RegisterClientInitScript(String script) {
		ScriptReository sr = getScriptReository();
		if (sr == null)
			return;
		sr.RegisterClientInitScript(script);
	}

	public static void RegisterAfterClientInitScript(String script) {
		ScriptReository sr = getScriptReository();
		if (sr == null)
			return;
		sr.RegisterAfterClientInitScript(script);
	}

	public static void addClickListener(ExtComponent comp, String listener) {
		ScriptReository sr = getScriptReository();
		if (sr == null)
			return;
		sr.addClickListener(comp, listener);
	}
}
