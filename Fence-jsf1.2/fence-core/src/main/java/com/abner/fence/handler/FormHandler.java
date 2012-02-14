package com.abner.fence.handler;

import java.io.IOException;

import javax.el.MethodExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import net.sf.json.JSONObject;
import ext.base.ExtCommand;
import ext.form.FormPanel;
import ext.util.ELUtils;
import ext.util.FacesUtils;
import ext.util.JsonUtils;

public class FormHandler implements ExtHandler {
	public static final String HANDLER_ID = "formHandler";

	public void render(FacesContext context, UIComponent target)
			throws IOException {
		// note the encodeFormCommandOptions method in ExtCommandRenderer.
		ResponseWriter writer = context.getResponseWriter();
		JSONObject resJson = new JSONObject();
		resJson.put("success", Boolean.TRUE);
		if (target instanceof FormPanel) {
			FormPanel form = (FormPanel) target;

			assert form.getModel() != null;

			Object result = ELUtils.evaluate(context, form.getModel());
			resJson.put("data", JsonUtils.getJSON(result,JsonUtils.getDateJsonConfig("yyyy/MM/dd HH:mm:ss")));
			writer.write(resJson.toString());
		} else if (target instanceof ExtCommand) {
			ExtCommand btn = (ExtCommand) target;
			MethodExpression mexp = btn.getActionExpression();
			if (mexp != null) {
				Object result = mexp.invoke(FacesUtils.context().getELContext(), new Object[0]);
				resJson.put("data",JsonUtils.getJSON(result,JsonUtils.getDateJsonConfig("yyyy/MM/dd HH:mm:ss")));
				writer.write(resJson.toString());
			}else{
				writer.write(JsonUtils.EMPTY_JSON);
			}
		} else {
			writer.write(JsonUtils.EMPTY_JSON);
		}
	}
}
