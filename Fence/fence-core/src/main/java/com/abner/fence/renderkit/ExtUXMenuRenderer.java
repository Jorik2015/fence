package com.abner.fence.renderkit;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.abner.fence.component.ExtComponent;
import com.abner.fence.utils.AjaxJSUtils;
import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.web.ExtNode;

import ext.menu.Menu;

public class ExtUXMenuRenderer extends ExtBasicRenderer<Menu> {
	private static Log log = LogFactory.getLog(ExtUXMenuRenderer.class);

	@Override
	public void beforeEncodeEnd(FacesContext context, Menu component) throws IOException {
		Object data = component.getData();
		if (data == null)
			return;

		if (data instanceof Collection<?>) {
			Collection<?> cdata = (Collection<?>) data;
			for (Object node : cdata) {
				if (node instanceof ExtNode) {
					writeMenuNode(context, component, (ExtNode) node);
				} else {
					log.warn("the menu data must implements ExtNode.");
				}
			}
		} else if (data.getClass().isArray()) {
			Object[] adata = (Object[]) data;
			for (Object node : adata) {
				if (node instanceof ExtNode) {
					writeMenuNode(context, component, (ExtNode) node);
				} else {
					log.warn("the menu data must implements ExtNode.");
				}
			}
		} else {
			throw new IllegalArgumentException("The menu data must collection or array.");
		}

		component.handleConfig("renderTo", null);
	}

	private void writeMenuNode(FacesContext context, Menu component, ExtNode node) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("li", component);
		writer.startElement("a", component);
		writer.writeAttribute("href", node.getHref(), "href");
		writer.write(node.getText());
		writer.endElement("a");

		Set<? extends ExtNode> childs = node.getChildren();
		if (!childs.isEmpty()) {
			writer.startElement("ul", component);

			for (Iterator<? extends ExtNode> iter = childs.iterator(); iter.hasNext();) {
				writeMenuNode(context, component, iter.next());
			}
			writer.endElement("ul");
		}

		writer.endElement("li");
	}

	@Override
	protected String buildInstanceWithTemplate(ExtComponent component) {
		String instance = component.getFamily();
		String clientId = component.getContainerId();
		String config = ConfigUtils.interpretConfig(component);
		return MessageFormat.format(this.getStructureTemplate(), component.getVar(), instance, clientId, config);
	}

	@Override
	public String getStructureTemplate() {
		return "{0} = new {1}(''{2}'',{3});";
	}

	@Override
	protected String getRenderHtmlTag() {
		return AjaxJSUtils.UL;
	}
}
