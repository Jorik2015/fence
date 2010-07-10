package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.abner.fence.commons.Enums.ButtonType;
import com.abner.fence.component.ExtCommand;
import com.abner.fence.utils.RenderKitUtils;

import ext.form.FormPanel;

public class ExtCommandRenderer<T> extends ExtBasicRenderer<ExtCommand> {

	@Override
	public void beforeEncodeEnd(FacesContext context, ExtCommand commandBtn) throws IOException {
		ButtonType type = RenderKitUtils.getButtonType(commandBtn);
		FormPanel form = RenderKitUtils.getFormPanel(commandBtn);
		if (form == null && (ButtonType.SUBMIT == type || ButtonType.LOAD == type))
			throw new IllegalArgumentException("the submit/load button must in a formpanel.");
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		rendererParamsNotNull(context, component);

		if (!shouldDecode(component)) {
			return;
		}

		String clientId = decodeBehaviors(context, component);

		if (wasClicked(context, component, clientId) && !isReset(component)) {
			component.queueEvent(new ActionEvent(component));
		}
	}

	private static boolean wasClicked(FacesContext context, UIComponent component, String clientId) {
		if (clientId == null) {
			clientId = component.getClientId(context);
		}

		Map<String, String> requestParameterMap = context.getExternalContext().getRequestParameterMap();
		if (requestParameterMap.get(clientId) == null) {
			// Check to see whether we've got an action event
			// as a result of a partial/behavior postback.
			if (RenderKitUtils.isPartialOrBehaviorAction(context, clientId)) {
				return true;
			}

			StringBuilder builder = new StringBuilder(clientId);
			String xValue = builder.append(".x").toString();
			builder.setLength(clientId.length());
			String yValue = builder.append(".y").toString();
			return (requestParameterMap.get(xValue) != null && requestParameterMap.get(yValue) != null);
		}
		return true;
	}

	private static boolean isReset(UIComponent component) {
		return ("reset".equals(component.getAttributes().get("type")));
	}
}
