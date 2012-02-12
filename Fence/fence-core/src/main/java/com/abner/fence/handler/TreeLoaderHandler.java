package com.abner.fence.handler;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.abner.fence.commons.JsonCommonFilter;
import com.abner.fence.commons.JsonLevelFilter;
import com.abner.fence.component.Config;
import com.abner.fence.utils.ComponentUtils;
import com.abner.fence.utils.JsonUtils;

import ext.tree.TreeLoader;

public class TreeLoaderHandler implements ExtHandler {

	public final static String HANDLER_ID = "treeLoaderHandler";

	private TreeLoader loader;

	public void processHandler(FacesContext context, UIComponent target) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		response.setContentType("text/plain; charset=UTF-8");
		this.loader = (TreeLoader) target;

		assert loader != null;

		List<Config> configs = ComponentUtils.findComponents(loader, Config.class);
		for (Config config : configs) {
			config.encodeAll(context);
		}

		Object data = null;
		if (data == null)
			data = loader.getConfig("data");

		JsonConfig cfg = JsonUtils.getDateJsonConfig();
		cfg.setJsonPropertyFilter(new JsonCommonFilter(new JsonLevelFilter(1)));
		cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		writer.write(JsonUtils.getJSON(data, cfg).toString());
	}
}
