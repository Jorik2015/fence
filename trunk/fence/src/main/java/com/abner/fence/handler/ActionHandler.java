package com.abner.fence.handler;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.abner.fence.commons.JsonCommonFilter;
import com.abner.fence.commons.JsonLevelFilter;
import com.abner.fence.utils.ELUtils;
import com.abner.fence.utils.JsonUtils;
import com.abner.fence.web.Params;

@ManagedBean(name = "actionHandler")
@RequestScoped
public class ActionHandler implements ExtHandler {
	public static String HANDLER_ID = "actionHandler";

	public void processHandler(FacesContext context, UIComponent target) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String action = Params.getParam("javax.faces.partial.action").getStringValue();

		Object result = ELUtils.evaluate(context, action);

		if (result != null) {
			JsonConfig cfg = JsonUtils.getDateJsonConfig();
			cfg.setJsonPropertyFilter(new JsonCommonFilter(new JsonLevelFilter(2)));
			cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			writer.write(JsonUtils.toJson(result, cfg));
		}
	}
}