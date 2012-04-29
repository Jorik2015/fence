package com.abner.fence.handler;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import ext.base.Config;
import ext.tree.TreeLoader;
import ext.util.AttributeValue;
import ext.util.ComponentUtil;
import ext.util.JsonCommonFilter;
import ext.util.JsonLevelFilter;
import ext.util.JsonUtils;

public class TreeLoaderHandler implements ExtHandler {

	public final static String HANDLER_ID = "treeLoaderHandler";

	private TreeLoader loader;

	public void render(FacesContext context, UIComponent target) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		response.setContentType("text/plain; charset=UTF-8");
		this.loader = (TreeLoader) target;

		assert loader != null;

		List<Config> configs = ComponentUtil.findComponents(loader, Config.class);
		for (Config config : configs) {
			config.encodeAll(context);
		}

		Object data = loader.getData();
		if (data == null)
			data = loader.getConfig("data");

		int levelValue = 3;
		AttributeValue av = loader.getConfigValue("levelFilter");
		if (av != null) {
			levelValue = av.getIntValue();
		}

		if (levelValue == 0) {
			levelValue = 3;
		}

		JsonConfig cfg = JsonUtils.getDateJsonConfig();
		cfg.setJsonPropertyFilter(new JsonCommonFilter(new JsonLevelFilter(3)));
		cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		writer.write(JsonUtils.getJSON(data, cfg).toString());
	}
}
