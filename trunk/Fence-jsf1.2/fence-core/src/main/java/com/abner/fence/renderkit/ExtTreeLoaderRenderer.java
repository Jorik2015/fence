package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.abner.fence.handler.TreeLoaderHandler;
import com.abner.fence.util.RequestUtils;

import ext.tree.TreeLoader;
import ext.util.FacesUtils;
import ext.util.StringUtil;

public class ExtTreeLoaderRenderer extends ExtBasicRenderer<TreeLoader> {

	@Override
	public void afterEncodeBegin(FacesContext context, TreeLoader component) throws IOException {
		component.handleConfig("baseParams", encodeBaseParams(context, component));
		String dataUrl = component.getDataUrl();
		if (StringUtils.isBlank(dataUrl)) {
			dataUrl = component.getUrl();
		}

		if (StringUtils.isBlank(dataUrl)) {
			component.handleConfig("dataUrl", FacesUtils.getCurrentRequestPath());
		}
	}

	@SuppressWarnings("unchecked")
	private String encodeBaseParams(FacesContext context, TreeLoader loader) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(RequestUtils.AJAX_PARAM, String.valueOf(true));
		params.put(RequestUtils.RENDER_PARAM, loader.getClientId(context));
		params.put(RequestUtils.IMMEDIATE_PARAM, String.valueOf(true));
		params.put(RequestUtils.HANDLER_PARAM, TreeLoaderHandler.HANDLER_ID);
		
		Object rawParams = loader.getBaseParams();
		if(rawParams != null){
			JSONObject rawParamJson = JSONObject.fromObject(rawParams);
			params.putAll(rawParamJson);
		}
		
		StringBuilder sb = new StringBuilder(128);
		int i = 0;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (StringUtil.isEmpty(entry.getValue()))
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
