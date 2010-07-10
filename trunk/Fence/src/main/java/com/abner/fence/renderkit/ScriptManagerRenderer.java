package com.abner.fence.renderkit;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.abner.fence.commons.Enums.AdapterType;
import com.abner.fence.component.ScriptManager;
import com.abner.fence.resources.ExtResources;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.Strings;

import ext.Button;
import ext.Panel;
import ext.menu.Item;

public class ScriptManagerRenderer extends Renderer {

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		String prefix = FacesUtils.getHostAppPath();

		ResponseWriter writer = context.getResponseWriter();

		ScriptManager scriptManager = (ScriptManager) component;
		String adapter = scriptManager.getAdapter();
		if (Strings.isEmpty(adapter)) {
			adapter = AdapterType.EXT.toString();
			scriptManager.setAdapter(adapter);
		}

		String version = scriptManager.getVersion();
		if (Strings.isEmpty(version)) {
			version = ExtUtils.VERSION;
			scriptManager.setVersion(version);
		}
		version = version.replaceAll("\\.", "");

		String temp = ScriptManager.ScriptIncludeTemplate;
		writer.write(MessageFormat.format(temp, prefix + ExtResources.PREFIX + ScriptManager.ScriptManager + "?key="
				+ JSUtils.getKey() + "&debug=" + scriptManager.isDebug() + "&st=" + System.currentTimeMillis()));

		// 收集图标
		outputIcons(context, scriptManager);
	}

	private void outputIcons(FacesContext context, ScriptManager component) throws IOException {
		String temp = ScriptManager.StyleBlockTemplate;
		StringBuilder sb = new StringBuilder(256);
		ResponseWriter writer = context.getResponseWriter();

		UIViewRoot viewRoot = context.getViewRoot();
		this.findIcons(viewRoot, component);

		String prefix = FacesUtils.getAppPath() + "/resources/";
		String t = "\t.{0}'{'background-image:url(''" + prefix + "icons/{1}'') !important;'}'\n";
		List<String> icons = component.getIcons();
		for (String icon : icons) {
			String name = "";
			if (!Strings.isEmpty(icon)) {
				name = icon;
				if (icon.endsWith("-gif")) {
					icon = icon.replaceAll("-gif", ".gif");
				} else if (icon.endsWith("-png")) {
					icon = icon.replaceAll("-png", ".png");
				} else {
					icon += ".png";
				}
			}
			sb.append(MessageFormat.format(t, name, icon));
		}
		writer.write(MessageFormat.format(temp, sb));
	}

	private void findIcons(UIComponent comp, ScriptManager sm) {
		String icon = this.getIcon(comp);
		if (icon != null)
			sm.addIcons(icon);

		List<UIComponent> childs = comp.getChildren();
		for (UIComponent child : childs) {
			this.findIcons(child, sm);
		}
	}

	private String getIcon(UIComponent comp) {
		if (comp instanceof Panel) {
			Panel panel = (Panel) comp;
			return panel.getIconCls();
		}

		if (comp instanceof Item) {
			Item item = (Item) comp;
			return item.getIconCls();
		}

		if (comp instanceof Button) {
			Button btn = (Button) comp;
			return btn.getIconCls();
		}

		return null;
	}
}
