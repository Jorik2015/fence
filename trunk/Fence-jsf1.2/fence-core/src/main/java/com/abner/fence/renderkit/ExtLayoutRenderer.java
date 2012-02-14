package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import ext.Container;
import ext.Window;
import ext.annotation.Layout;
import ext.base.IExt;
import ext.layout.ContainerLayout;
import ext.util.ComponentUtil;

public class ExtLayoutRenderer extends ExtBasicRenderer<ContainerLayout> {

	@Override
	public void afterEncodeBegin(FacesContext context, ContainerLayout component)
			throws IOException {
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
			} else if (child instanceof Container
					&& ComponentUtil.isHaeresNatus((IExt) child)) {
				((Container) child).handleConfig("layout", layoutType.value().toString());
			} else if (child instanceof ContainerLayout) {
				this.encodeLayout((ContainerLayout) child);
			}
		}
	}
}
