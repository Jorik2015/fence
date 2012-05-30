package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.el.MethodExpression;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.abner.fence.handler.FormHandler;
import com.abner.fence.resources.ScriptManager;
import com.abner.fence.util.AjaxJSUtils;
import com.abner.fence.util.RequestUtils;
import com.abner.fence.web.RequestContext;

import ext.base.ExtCommand;
import ext.form.FormPanel;
import ext.util.AttributeValue;
import ext.util.ComponentUtil;
import ext.util.FacesUtils;
import ext.util.StringUtil;

public class ExtCommandRenderer<T> extends ExtBasicRenderer<ExtCommand> {

	@Override
	public void beforeEncodeEnd(FacesContext context, ExtCommand commandBtn) throws IOException {
		FormPanel form = ComponentUtil.inNested(FormPanel.class, commandBtn);
		StringBuilder sb = new StringBuilder(256);

		if (form != null) {
			if (this.isTypeOf(commandBtn, "submit")) {
				Boolean stSubmit = form.getStandardSubmit();
				if (stSubmit != null && stSubmit.booleanValue()) {
					String hiddenId = form.getClientId(context) + ExtFormPanelRenderer.EVENT_SUFFIX;
					String funBody = hiddenId + ".setValue(src.getId());";
					sb.append(funBody);

					hiddenId = form.getClientId(context) + ExtFormPanelRenderer.VIEWSTATE_SUFFIX;
					funBody = hiddenId + ".setValue(Fence.getViewState());";
					sb.append(funBody);
				}
				sb.append(form.getVar());
				sb.append(".getForm().submit(");
				if (stSubmit == null || !stSubmit.booleanValue()) {
					sb.append(encodeFormCommandOptions(context, form, commandBtn, "submit"));
				}
				sb.append(");");
			} else if (this.isTypeOf(commandBtn, "load")) {
				sb.append(form.getVar());
				sb.append(".getForm().load(");
				sb.append(encodeFormCommandOptions(context, form, commandBtn, "load"));
				sb.append(");");
			} else if (this.isTypeOf(commandBtn, "reset")) {
				sb.append(form.getVar());
				sb.append(".getForm().reset();");
			}
		}

		if (this.isTypeOf(commandBtn, "button")) {
			sb.append(AjaxJSUtils.encodeAjaxRequestFn(context, commandBtn));
		} else if (this.isTypeOf(commandBtn, "download")) {
			sb.append("top.location.href =");
			sb.append(this.encodeDownloadUrl(context, commandBtn));
		} else if (this.isTypeOf(commandBtn, "client")) {
			MethodExpression me = commandBtn.getActionExpression();
			if (me != null) {
				sb.append(AjaxJSUtils.encodeAjaxCallFn(context, commandBtn,me));
			}else{
				AjaxJSUtils.handleEvent(commandBtn, "click", sb.toString(), true);
			}
		}

		if (sb.length() > 0) {
			sb.insert(0, "function(src,e){");
			sb.append("}");

			String[] eventTypes = commandBtn.getEventType().split(",");
			for (String eventType : eventTypes) {
				boolean isClick = "click".endsWith(eventType);
				AjaxJSUtils.handleEvent(commandBtn, eventType, sb.toString(), isClick);
			}
		}
	}

	private String encodeDownloadUrl(FacesContext context, ExtCommand component) {
		StringBuilder sb = new StringBuilder(128);
		sb.append(ScriptManager.AJAX_PATH + "+ '?");

		Map<String, String> params = FacesUtils.extContext().getRequestParameterMap();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue() + "&");
		}

		sb.append(RequestUtils.EXECUTE_PARAM);
		sb.append("=");
		sb.append(component.getClientId(context));
		sb.append("&st='+");
		sb.append("new Date().getTime() +'");
		sb.append("&");
		sb.append(RequestUtils.VIEW_STATE_KEY);
		sb.append("=' + Fence.getViewState()");
		return sb.toString();
	}

	@Override
	public void afterEncodeEnd(FacesContext context, ExtCommand component) throws IOException {
		if (ComponentUtil.inNested(FormPanel.class, component) == null) {
			if (!RequestUtils.hasRenderViewState()) {
				ViewHandler viewHandler = context.getApplication().getViewHandler();
				viewHandler.writeState(context);
				RequestContext.instance().put(RequestUtils.VIEW_STATE_RENDER, Boolean.TRUE);
			}
		}
	}

	private String encodeFormCommandOptions(FacesContext context, FormPanel form, ExtCommand btn, String type) {
		Map<String, Object> pars = new HashMap<String, Object>();
		if (this.isTypeOf(btn, "load")) {
			pars.put(RequestUtils.HANDLER_PARAM, FormHandler.HANDLER_ID);
			if (!StringUtil.isEmpty(form.getModel())) {
				btn.setRender(form.getClientId(context));
			} else {
				btn.setRender(btn.getClientId(context));
			}
		}

		return AjaxJSUtils.encodeFormAjaxOptions(context, btn, type, pars);
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		rendererParamsNotNull(context, component);

		if (!shouldDecode(component)) {
			return;
		}
		if (wasClicked(context, component) && !isReset(component) && !this.isTypeOf((ExtCommand) component, "load")) {
			component.queueEvent(new ActionEvent(component));
		}
	}

	private static boolean wasClicked(FacesContext context, UIComponent component) {
		String clientId = component.getClientId(context);
		Map<String, String> requestParameterMap = context.getExternalContext().getRequestParameterMap();
		String eventSourceId = requestParameterMap.get(RequestUtils.EXECUTE_PARAM);
		if (eventSourceId != null && clientId.equals(eventSourceId)) {
			return true;
		}
		Map<String, String> requestHeaderMap = context.getExternalContext().getRequestHeaderMap();
		eventSourceId = requestHeaderMap.get(RequestUtils.EXECUTE_PARAM);
		if (eventSourceId != null && clientId.equals(eventSourceId)) {
			return true;
		}

		return false;
	}

	private boolean isTypeOf(ExtCommand btn, String type) {
		AttributeValue av = btn.getConfigValue("type");
		if ("client".equals(type)) {
			return av == null || av.getStringValue().equals(type);
		}
		return av != null && av.getStringValue().equalsIgnoreCase(type);
	}

	private static boolean isReset(UIComponent component) {
		return ("reset".equals(component.getAttributes().get("type")));
	}
}
