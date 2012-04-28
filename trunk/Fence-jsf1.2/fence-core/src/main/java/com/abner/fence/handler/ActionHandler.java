package com.abner.fence.handler;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.abner.fence.web.Params;

import ext.util.ELUtils;
import ext.util.JsonCommonFilter;
import ext.util.JsonLevelFilter;
import ext.util.JsonUtils;

public class ActionHandler implements ExtHandler {
	public static String HANDLER_ID = "actionHandler";

	public void render(FacesContext context, UIComponent target)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String action = Params.getParam("action").getStringValue();

		Object result = ELUtils.evaluate(context, action);

		if (result != null) {
			JsonConfig cfg = JsonUtils.getDateJsonConfig();
			cfg.setJsonPropertyFilter(new JsonCommonFilter(new JsonLevelFilter(3)));
			cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			writer.write(JsonUtils.toJson(result, cfg));
		}
	}
}