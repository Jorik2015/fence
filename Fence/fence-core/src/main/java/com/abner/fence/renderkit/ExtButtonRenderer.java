package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.abner.fence.component.ExtCommand;
import com.abner.fence.utils.ComponentUtils;
import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.Strings;

import ext.Panel;
import ext.Toolbar;

public class ExtButtonRenderer extends ExtCommandRenderer<ExtCommand> {

	@Override
	public void beforeEncodeBegin(FacesContext context, ExtCommand btn) throws IOException {
		String configTo = null;
		Panel panel = ComponentUtils.inNested(Panel.class, btn, true);

		if (panel != null) {
			if (ComponentUtils.isHaeresNatus(btn))
				configTo = "buttons";
		}

		Toolbar tb = ComponentUtils.inNested(Toolbar.class, btn, true);
		if (tb != null) {
			if (ComponentUtils.isHaeresNatus(btn))
				configTo = "items";
		}

		if (!Strings.isEmpty(configTo)) {
			ConfigUtils.configTo(configTo, btn.getVar(), btn);
		}
	}
}
