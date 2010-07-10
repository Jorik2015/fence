package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import com.abner.fence.component.Config;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.ELUtils;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.Strings;

public class ExtConfigRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		super.encodeBegin(context, component);
		UIComponent parent = component.getParent();
		if (!(parent instanceof ExtComponent)) {
			return;
		}

		Config config = (Config) component;
		String name = config.getName();
		String value = config.getValue();
		String mode = config.getMode();
		if (value == null)
			return;

		if (!"json".equals(mode) && Strings.isEmpty(name))
			return;

		Object valueResult = value;
		if (!"json".equals(mode) && ELUtils.isEL(value)) {
			valueResult = ELUtils.evaluate(context, value);
		}

		if (valueResult == null)
			return;

		if ("value".equals(mode)) {
			ConfigUtils.valueTo(name, valueResult, config);
		} else if ("json".equals(mode)) {
			ExtUtils.applyConfig((ExtComponent) parent, valueResult);
		} else {
			ConfigUtils.configTo(name, valueResult.toString(), config);
		}
	}
}
