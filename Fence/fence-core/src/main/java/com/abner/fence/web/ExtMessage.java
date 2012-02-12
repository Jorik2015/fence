package com.abner.fence.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

import org.apache.commons.lang.StringEscapeUtils;

import com.abner.fence.exception.ExtMessageException;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.Strings;

public final class ExtMessage {
	public static final String ID = "Fence_Msg";
	private static ExtMessage instance = null;
	private List<String> msgScript = new ArrayList<String>();

	private ExtMessage() {
	}

	public static ExtMessage instance() {
		instance = (ExtMessage) RequestContext.instance().get(ID);
		if (instance == null) {
			instance = new ExtMessage();
			RequestContext.instance().put(ID, instance);
		}
		return instance;
	}

	public List<String> getMsgScript() {
		return msgScript;
	}

	public void add(String script) {
		if (this.msgScript.contains(script))
			return;

		this.msgScript.add(script);
	}

	public void clear() {
		this.msgScript.clear();
	}

	public boolean isEmpty() {
		return this.msgScript.isEmpty();
	}

	/*
	 * note：此方法将不会中断程序的执行
	 */
	public static void info(String msg) {
		msg = StringEscapeUtils.escapeJavaScript(msg);
		JSUtils.RegisterAfterClientInitScript(JSUtils.FENCE_BASE_INSTANCE + ".info(\"" + msg + "\");");
	}

	public static void warn(String msg) {
		show(new ExtFacesMessage(FacesMessage.SEVERITY_WARN, null, msg, msg));
	}

	public static void error(String msg) {
		show(new ExtFacesMessage(FacesMessage.SEVERITY_ERROR, null, msg, msg));
	}

	public static void show(FacesMessage facesMsg, boolean throwex) {
		String summary = facesMsg.getSummary();
		String detail = facesMsg.getDetail();

		detail = Strings.ifEmpty(detail, summary);

		Severity sev = facesMsg.getSeverity();
		sev = sev == null ? FacesMessage.SEVERITY_INFO : sev;
		if (sev.compareTo(FacesMessage.SEVERITY_WARN) >= 0) {
			if (throwex)
				throw new ExtMessageException(facesMsg);
			else {
				String script = JSUtils.FENCE_BASE_INSTANCE;
				if (FacesMessage.SEVERITY_WARN.equals(sev)) {
					script += ".warn(\"" + summary + "\");";
				} else {
					script += ".error(\"" + summary + "\");";
				}
				JSUtils.RegisterAfterClientInitScript(script);
			}
		} else {
			info(detail);
		}
	}

	public static void show(FacesMessage facesMsg) {
		show(facesMsg, true);
	}
}
