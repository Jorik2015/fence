/**
 * 
 */
package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import ext.Template;
import ext.util.StringUtil;

/**
 * @author Administrator
 * 
 */
public class ExtTemplateRenderer extends ExtBasicRenderer<Template> {

	private static final String TPL_TAG = "_tpl_";

	@Override
	public String getStructureTemplate() {
		return "{0} = new {1}(" + TPL_TAG + "{2});";
	}

	@Override
	protected StringBuilder processAfterReadyScript(UIComponent comp, StringBuilder script) {
		StringBuilder sb = new StringBuilder();
		List<UIComponent> childs = comp.getChildren();
		for (UIComponent child : childs) {
			if (StringUtil.isEmpty(child))
				continue;

			String str = child.toString().trim();
			String[] strs = str.split("\n");
			for (String s : strs) {
				sb.append("'");
				sb.append(s.trim());
				sb.append("',");
			}
		}
		return new StringBuilder(script.toString().replaceAll(TPL_TAG, sb.toString()));
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		// super.encodeChildren(context, component);
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}
}
