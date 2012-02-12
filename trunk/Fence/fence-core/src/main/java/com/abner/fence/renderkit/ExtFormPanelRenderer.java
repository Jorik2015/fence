package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.RequestUtils;

import ext.BoxComponent;
import ext.form.FormPanel;
import ext.form.Hidden;

//TODO FIXED when a commandButton in formpanel
public class ExtFormPanelRenderer extends ExtPanelRenderer<FormPanel> {
	public static final String EVENT_SUFFIX = "_eventsrc";
	public static final String VIEWSTATE_SUFFIX = "_viewstate";

	@Override
	public void beforeEncodeBegin(FacesContext context, BoxComponent component) throws IOException {
		super.beforeEncodeBegin(context, component);

		FormPanel form = (FormPanel) component;
		Boolean standSubmit = form.getStandardSubmit();
		if (standSubmit != null && standSubmit.booleanValue()) {
			// 在标准提交时，添加的参数值需要在提交之前的button按钮事件中赋值
			// 请见button的渲染器
			String hiddenId = component.getClientId(context) + EVENT_SUFFIX;
			ConfigUtils.configToSelf("items", hiddenId, component);

			hiddenId = component.getClientId(context) + VIEWSTATE_SUFFIX;
			appendScriptBefore(component, appendSubmitParam(hiddenId, RequestUtils.VIEW_STATE_KEY));
			ConfigUtils.configToSelf("items", hiddenId, component);
		}
		ResponseWriter writer = context.getResponseWriter();
		String clientId = component.getClientId(context);
		// this hidden field will be checked in the decode method to
		// determine if this form has been submitted.
		writer.startElement("input", component);
		writer.writeAttribute("type", "hidden", "type");
		writer.writeAttribute("name", clientId, "clientId");
		writer.writeAttribute("value", clientId, "value");
		writer.endElement("input");
		writer.write('\n');
	}

	@Override
	public void afterEncodeEnd(FacesContext context, BoxComponent component) throws IOException {
		ViewHandler viewHandler = context.getApplication().getViewHandler();
		viewHandler.writeState(context);
		super.afterEncodeEnd(context, component);
	}

	protected String appendSubmitParam(String hiddenId, String paramName) {
		Hidden hidden = new Hidden();
		hidden.setName(paramName);
		hidden.setId(hiddenId);
		return this.buildInstanceWithTemplate(hidden);
	}
}
