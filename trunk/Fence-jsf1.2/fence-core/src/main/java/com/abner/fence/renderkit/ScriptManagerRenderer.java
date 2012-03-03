package com.abner.fence.renderkit;

import java.io.IOException;
import java.text.MessageFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.abner.fence.resources.ExtResources;
import com.abner.fence.resources.ScriptManager;
import com.abner.fence.util.AdapterType;
import com.abner.fence.util.Ext;
import com.abner.fence.util.JSUtils;

import ext.util.FacesUtils;
import ext.util.StringUtil;

public class ScriptManagerRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		String prefix = FacesUtils.getAppPath();

		ResponseWriter writer = context.getResponseWriter();

		ScriptManager scriptManager = (ScriptManager) component;
		String adapter = scriptManager.getAdapter();
		if (StringUtil.isEmpty(adapter)) {
			adapter = AdapterType.EXT.toString();
			scriptManager.setAdapter(adapter);
		}

		String version = scriptManager.getVersion();
		if (StringUtil.isEmpty(version)) {
			version = Ext.VERSION;
			scriptManager.setVersion(version);
		}
		version = version.replaceAll("\\.", "");

		String library = scriptManager.getLibrary();
		prefix += library;

		//Ext css styles
		String theme = scriptManager.getTheme();
		if (!StringUtil.isEmpty(theme)) {
			writer.write(MessageFormat.format(ScriptManager.StyleIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_CSS_NOTHEME, version)));
			writer.write(MessageFormat.format(ScriptManager.StyleIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_CSS_THEME, version, theme.toLowerCase())));
		} else {
			writer.write(MessageFormat.format(ScriptManager.StyleIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_CSS_ALL, version)));
		}

		//Ext adapter
		String path = prefix + MessageFormat.format(ExtResources.ADAPTER_BASE, version, adapter.toLowerCase());
		writer.write(MessageFormat.format(ScriptManager.ScriptIncludeTemplate, path));

		path = prefix + MessageFormat.format(ExtResources.ADAPTER_EXT, version, adapter.toLowerCase());
		writer.write(MessageFormat.format(ScriptManager.ScriptIncludeTemplate, path));

		//Ext js
		if (scriptManager.isDebug()) {
			writer.write(MessageFormat.format(ScriptManager.ScriptIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_ALL_DEBUG, version)));
		} else {
			writer.write(MessageFormat.format(ScriptManager.ScriptIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_ALL, version)));
		}

		//Ext ux js and css
		if (scriptManager.isUx()) {
			if (scriptManager.isDebug()) {
				writer.write(MessageFormat.format(ScriptManager.ScriptIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_UX_JS_DEBUG, version)));
			} else {
				writer.write(MessageFormat.format(ScriptManager.ScriptIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_UX_JS, version)));
			}
			writer.write(MessageFormat.format(ScriptManager.StyleIncludeTemplate, prefix + MessageFormat.format(ExtResources.EXT_UX_CSS, version)));
		}
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		String prefix = FacesUtils.getAppPath();
		ResponseWriter writer = context.getResponseWriter();

		ScriptManager scriptManager = (ScriptManager) component;
		String temp = ScriptManager.ScriptIncludeTemplate;

		String version = scriptManager.getVersion();
		if (StringUtil.isEmpty(version)) {
			version = Ext.VERSION;
			scriptManager.setVersion(version);
		}
		version = version.replaceAll("\\.", "");

		String library = scriptManager.getLibrary();
		library = prefix + library;

		if (scriptManager.isDebug()) {
			writer.write(MessageFormat.format(temp, prefix + ExtResources.INNER_PROFIX + ExtResources.FENCE_BASE_DEBUG));
		} else {
			writer.write(MessageFormat.format(temp, prefix + ExtResources.INNER_PROFIX + ExtResources.FENCE_BASE));
		}
		writer.write(MessageFormat.format(temp, prefix + ExtResources.INNER_PROFIX + ScriptManager.ScriptManager + "?key=" + JSUtils.getKey()
				+ "&debug=" + scriptManager.isDebug() + "&st=" + System.currentTimeMillis()));

		// writer css
		temp = ScriptManager.StyleIncludeTemplate;
		writer.write("\n");
	}
}
