/**
 * 
 */
package com.abner.fence.renderkit;

import java.io.IOException;
import java.text.MessageFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import org.apache.commons.lang.StringUtils;

import com.abner.fence.resources.ExtIncludeResource;
import com.abner.fence.resources.ScriptManager;

import ext.util.FacesUtils;

/**
 * @author Administrator
 * 
 */
public class ExtIncludeResourceRenderer extends Renderer {

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ExtIncludeResource resource = (ExtIncludeResource) component;
		String library = resource.getLibrary();
		String src = resource.getSrc();
		if (StringUtils.isBlank(src)) {
			return;
		}
		String prefix = FacesUtils.getAppPath();
		ResponseWriter writer = context.getResponseWriter();
		String[] srcs = src.split(";");
		for (String s : srcs) {
			String resSrc = prefix + "/" + library + s;
			if (s.endsWith(".js")) {
				writer.write(MessageFormat.format(ScriptManager.ScriptIncludeTemplate, resSrc));
			} else if (s.endsWith(".css")) {
				writer.write(MessageFormat.format(ScriptManager.StyleIncludeTemplate, resSrc));
			}
		}

		super.encodeEnd(context, component);
	}
}
