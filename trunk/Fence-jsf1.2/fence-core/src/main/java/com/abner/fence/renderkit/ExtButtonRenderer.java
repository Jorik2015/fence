package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.abner.fence.util.ConfigHelper;

import ext.Panel;
import ext.Toolbar;
import ext.base.ExtCommand;
import ext.util.ComponentUtil;
import ext.util.StringUtil;

public class ExtButtonRenderer extends ExtCommandRenderer<ExtCommand> {

	@Override
	public void afterEncodeBegin(FacesContext context, ExtCommand btn)
			throws IOException {
		String configTo = null;
		Panel panel = ComponentUtil.inNested(Panel.class, btn, true);

		if (panel != null) {
			if (ComponentUtil.isHaeresNatus(btn))
				configTo = "buttons";
		}

		Toolbar tb = ComponentUtil.inNested(Toolbar.class, btn, true);
		if (tb != null) {
			if (ComponentUtil.isHaeresNatus(btn))
				configTo = "items";
		}

		if (!StringUtil.isEmpty(configTo)) {
			ConfigHelper.configTo(configTo, btn.getVar(), btn);
		}
		super.afterEncodeBegin(context, btn);
	}
}
