package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;

import com.abner.fence.util.ConfigHelper;
import com.abner.fence.util.RequestUtils;
import com.abner.fence.web.RequestContext;

import ext.BoxComponent;
import ext.form.FormPanel;
import ext.form.Hidden;

//TODO FIXED when a commandButton in formpanel
public class ExtFormPanelRenderer extends ExtPanelRenderer<FormPanel> {
	public static final String EVENT_SUFFIX = "_eventsrc";
	public static final String VIEWSTATE_SUFFIX = "_viewstate";

	@Override
	public void beforeEncodeBegin(FacesContext context, BoxComponent component)
			throws IOException {
		FormPanel form = (FormPanel) component;
		Boolean standSubmit = form.getStandardSubmit();
		if (standSubmit != null && standSubmit.booleanValue()) {
			//在标准提交时，添加的参数值需要在提交之前的button按钮事件中赋值
			//请见button的渲染器
			String hiddenId = component.getClientId(context) + EVENT_SUFFIX;
			appendScriptBefore(component,appendSubmitParam(hiddenId,RequestUtils.EXECUTE_PARAM));
			ConfigHelper.configToSelf("items", hiddenId, component);
			
			hiddenId = component.getClientId(context) + VIEWSTATE_SUFFIX;
			appendScriptBefore(component,appendSubmitParam(hiddenId,RequestUtils.VIEW_STATE_KEY));
			ConfigHelper.configToSelf("items", hiddenId, component);
		}
	}

	@Override
	public void afterEncodeEnd(FacesContext context, BoxComponent component)
			throws IOException {
		//write view state
		ViewHandler viewHandler = context.getApplication().getViewHandler();
		viewHandler.writeState(context);
		RequestContext.instance().put(RequestUtils.VIEW_STATE_RENDER,Boolean.TRUE);
		super.afterEncodeEnd(context, component);
	}

	protected String appendSubmitParam(String hiddenId,String paramName){
		Hidden hidden = new Hidden();
		hidden.setName(paramName);
		hidden.setId(hiddenId);
		return this.buildInstanceWithTemplate(hidden);
	}
}
