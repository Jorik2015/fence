package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class ExtOnReadyRenderer extends Renderer {

	@Override
	public boolean getRendersChildren() {
		return true;
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.write("\n<script type=\"text/javascript\">\n");
		writer.write("//<![CDATA[\nExt.onReady(function(){");
		super.encodeChildren(context, component);
		writer.write("});\n//]]>\n</script>");
	}
}
