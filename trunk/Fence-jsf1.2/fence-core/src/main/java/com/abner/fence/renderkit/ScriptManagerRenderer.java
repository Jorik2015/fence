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
import com.abner.fence.web.RequestContext;

import ext.util.FacesUtils;
import ext.util.StringUtil;

public class ScriptManagerRenderer extends Renderer {

	@Override 
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		String prefix = FacesUtils.getHostAppPath();

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
		version = version.replaceAll("\\.","");
		
		String temp = ScriptManager.ScriptIncludeTemplate;
		if (adapter.equalsIgnoreCase(AdapterType.YUI.toString())) {
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.YUI_UTILITIES,version,AdapterType.YUI.toString().toLowerCase())));
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.YUI_ADAPTER,version,
							AdapterType.YUI.toString().toLowerCase())));
		} else if (adapter.equalsIgnoreCase(AdapterType.JQUERY.toString())) {
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.JQUERY,version,
							AdapterType.JQUERY.toString().toLowerCase())));
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.JQUERY_ADAPTER,version,
							AdapterType.JQUERY.toString().toLowerCase())));
		} else if (adapter.equalsIgnoreCase(AdapterType.PROTOTYPE.toString())) {
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.PROTOTYPE,version,
							AdapterType.PROTOTYPE.toString().toLowerCase())));
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.PROTOTYPE_ADAPTER,version,
							AdapterType.PROTOTYPE.toString().toLowerCase())));
		} else {
			if (scriptManager.isDebug()){
				writer.write(MessageFormat.format(temp, prefix
						+ MessageFormat.format(ExtResources.EXT_BASE_DEBUG,version,
								AdapterType.EXT.toString().toLowerCase())));
			}else{
				writer.write(MessageFormat.format(temp, prefix
						+ MessageFormat.format(ExtResources.EXT_BASE,version,
								AdapterType.EXT.toString().toLowerCase())));
			}
		}
		if (scriptManager.isDebug())
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.EXT_ALL_DEBUG,version)));
		else
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.EXT_ALL,version)));
		
		if(scriptManager.isUx()){
			if (scriptManager.isDebug()){
			writer.write(MessageFormat.format(temp, prefix
					+ MessageFormat.format(ExtResources.EXT_UX_JS_DEBUG,version)));
			}else{
				writer.write(MessageFormat.format(temp, prefix
						+ MessageFormat.format(ExtResources.EXT_UX_JS,version)));
			}
			writer.write(MessageFormat.format(ScriptManager.StyleIncludeTemplate, prefix
					+ MessageFormat.format(ExtResources.EXT_UX_CSS,version)));
		}

		if (scriptManager.isDebug())
			writer.write(MessageFormat.format(temp, prefix + ExtResources.FENCE_BASE_DEBUG));
		else
			writer.write(MessageFormat.format(temp, prefix + ExtResources.FENCE_BASE));
		
		writer.write(MessageFormat.format(temp, prefix + ExtResources.PREFIX 
								+ ScriptManager.ScriptManager 
								+ "?key=" + JSUtils.getKey() 
								+ "&debug=" + scriptManager.isDebug()
								+ "&st=" + System.currentTimeMillis()));
		
		temp = ScriptManager.StyleIncludeTemplate;
		//writer css
		writer.write("\n");
		

		String theme = scriptManager.getTheme();
		if (!StringUtil.isEmpty(theme)) {
			writer.write(MessageFormat.format(temp, prefix	+ MessageFormat.format(ExtResources.EXT_CSS_NOTHEME,version)));
			writer.write(MessageFormat.format(temp, prefix	+ MessageFormat.format(ExtResources.EXT_CSS_THEME,version, theme.toLowerCase())));
		}else{
			writer.write(MessageFormat.format(temp, prefix	+ MessageFormat.format(ExtResources.EXT_CSS_ALL,version)));
		}
	}
}
