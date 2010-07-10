package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.abner.fence.handler.TreeLoaderHandler;
import com.abner.fence.utils.RequestUtils;
import com.abner.fence.utils.Strings;

import ext.tree.TreeLoader;

public class ExtTreeLoaderRenderer extends ExtBasicRenderer<TreeLoader> {

	@Override
	public void beforeEncodeBegin(FacesContext context, TreeLoader component) throws IOException {
		component.handleConfig("baseParams", encodeBaseParams(context, component));
	}

	private String encodeBaseParams(FacesContext context, TreeLoader loader) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(RequestUtils.AJAX_PARAM, String.valueOf(true));
		params.put(RequestUtils.RENDER_PARAM, loader.getClientId(context));
		params.put(RequestUtils.HANDLER_PARAM, TreeLoaderHandler.HANDLER_ID);
		StringBuilder sb = new StringBuilder(128);
		int i = 0;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (Strings.isEmpty(entry.getValue()))
				continue;
			if (i > 0)
				sb.append(",");

			if (!RequestUtils.VIEW_STATE_KEY.equals(key)) {
				value = "\"" + value + "\"";
			}
			sb.append("\"" + key + "\":" + value);
			i++;
		}
		sb.insert(0, "{");
		sb.append("}");
		return sb.toString();
	}
}
