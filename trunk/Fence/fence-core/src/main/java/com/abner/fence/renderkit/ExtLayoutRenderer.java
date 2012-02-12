package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.abner.fence.annotation.Layout;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.utils.ComponentUtils;

import ext.Container;
import ext.Window;
import ext.layout.ContainerLayout;

public class ExtLayoutRenderer extends ExtBasicRenderer<ContainerLayout> {

	@Override
	public void beforeEncodeBegin(FacesContext context, ContainerLayout component) throws IOException {
		this.encodeLayout(component);
	}

	private void encodeLayout(ContainerLayout layout) {
		Layout layoutType = layout.getClass().getAnnotation(Layout.class);
		if (layoutType == null)
			return;

		List<UIComponent> childs = layout.getChildren();
		for (UIComponent child : childs) {
			if (child instanceof Window) {
				continue;
			} else if (child instanceof Container && ComponentUtils.isHaeresNatus((ExtComponent) child)) {
				((Container) child).handleConfig("layout", layoutType.value().toString());
			} else if (child instanceof ContainerLayout) {
				this.encodeLayout((ContainerLayout) child);
			}
		}
	}
}
