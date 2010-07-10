package com.abner.fence.renderkit;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.context.FacesContext;
import javax.faces.render.ClientBehaviorRenderer;
import javax.faces.render.FacesBehaviorRenderer;

import com.abner.fence.ajax.ExtAjaxBehavior;
import com.abner.fence.component.ExtCommand;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.utils.RenderKitUtils;

import ext.form.FormPanel;

@FacesBehaviorRenderer(rendererType = "com.fence.fence.behavior.Ajax")
public class ExtAjaxBehaviorRender extends ClientBehaviorRenderer {

	@Override
	public void decode(FacesContext context, UIComponent component, ClientBehavior behavior) {
	}

	@Override
	public String getScript(ClientBehaviorContext behaviorContext, ClientBehavior behavior) {
		if (!(behavior instanceof ExtAjaxBehavior))
			throw new IllegalArgumentException("Instance of ExtAjaxBehavior required:" + behavior);

		return buildAjaxCommand(behaviorContext, (ExtAjaxBehavior) behavior);
	}

	private String buildAjaxCommand(ClientBehaviorContext behaviorContext, ExtAjaxBehavior ajaxBehavior) {
		// First things first - if AjaxBehavior is disabled, we are done.
		if (ajaxBehavior.isDisabled()) {
			return null;
		}

		if (!ajaxBehavior.isSubmitting())
			return null;

		ExtComponent component = (ExtComponent) behaviorContext.getComponent();
		String eventName = behaviorContext.getEventName();

		StringBuilder ajaxCommand = new StringBuilder(256);
		Collection<String> execute = ajaxBehavior.getExecute();
		Collection<String> render = ajaxBehavior.getRender();
		String onevent = ajaxBehavior.getOnevent();
		String onerror = ajaxBehavior.getOnerror();
		String sourceId = behaviorContext.getSourceId();
		Collection<ClientBehaviorContext.Parameter> params = behaviorContext.getParameters();
		Collection<ClientBehaviorContext.Parameter> hiddens = RenderKitUtils.getBehaviorHiddens(component);

		ClientBehaviorContext.Parameter foundparam = null;
		for (ClientBehaviorContext.Parameter param : params) {
			if (param.getName().equals("incExec") && (Boolean) param.getValue()) {
				foundparam = param;
			}
		}
		if (foundparam != null && !execute.contains(sourceId)) {
			execute = new LinkedList<String>(execute);
			execute.add(component.getClientId());
		}
		if (foundparam != null) {
			try {
				// And since this is a hack, we now try to remove the param
				params.remove(foundparam);
			} catch (UnsupportedOperationException unop) {
				// nothing we can do about it
			}
		}

		String userRender = null;
		if (component instanceof ExtCommand) {
			ExtCommand command = (ExtCommand) component;
			userRender = command.getRender();
		}

		String args = RenderKitUtils.getArgs(component, Arrays.asList(ajaxBehavior));
		ajaxCommand.append("function(" + args + "){");
		ajaxCommand.append("Fence.request(");
		FormPanel form = RenderKitUtils.getFormPanel((ExtComponent) component);
		ajaxCommand.append("{");

		if (onevent != null)
			RenderKitUtils.appendProperty(ajaxCommand, "onevent", onevent, false);

		if (onerror != null)
			RenderKitUtils.appendProperty(ajaxCommand, "onerror", onerror, false);

		RenderKitUtils.appendProperty(ajaxCommand, "source", RenderKitUtils.getEventVar(component), false);
		RenderKitUtils.appendProperty(ajaxCommand, "formpanel", form == null ? null : form.getVar(), false);
		RenderKitUtils.appendProperty(ajaxCommand, "eventType", eventName);
		RenderKitUtils.appendParamsToOptions(ajaxCommand, ajaxBehavior, component, params, hiddens);

		ajaxCommand.append("})}");

		return ajaxCommand.toString();
	}
}
