package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.abner.fence.util.ConfigHelper;
import com.abner.fence.util.Ext;

import ext.BoxComponent;
import ext.Window;
import ext.util.ComponentUtil;

public class ExtWindowRenderer extends ExtBasicRenderer<Window> {
	private static final String CONTENT_TAG = "div";
	
	private boolean canRenderContentEl(FacesContext context,
			BoxComponent component) {
		if (!Window.class.isAssignableFrom(component.getClass()))
			return false;

		if (!ComponentUtil.hasNotExtComponetChild(component))
			return false;

		if (component.getChildCount() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public void beforeEncodeBegin(FacesContext context, Window component)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("p", component);
		writer.endElement("p");	
		component.setRenderTo(null);
		component.setApplyTo(null);
	}
	@Override
	public void afterEncodeBegin(FacesContext context, Window component)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		if (canRenderContentEl(context, component)) {
			String contentId = this.getContainerId() + Ext.SUFFIX_CONTENT_ID;
			writer.startElement(CONTENT_TAG, component);
			writer.writeAttribute("id", contentId, "id");
			ConfigHelper.configToSelf("contentEl", contentId, component);
		}
	}
	
	@Override
	public void afterEncodeEnd(FacesContext context, Window component)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		if (canRenderContentEl(context, component)) {
			writer.endElement(CONTENT_TAG);
		}
		Boolean autoShow = component.getAutoShow();
		if (autoShow != null && autoShow.booleanValue()) {
			this.appendScriptAfter(component,component.getVar() + ".show();\n");
		}
	}
}
