package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import com.abner.fence.util.ConfigHelper;
import com.abner.fence.util.Ext;

import ext.base.Config;
import ext.base.IExt;
import ext.util.ELUtils;
import ext.util.StringUtil;

public class ExtConfigRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		super.encodeBegin(context, component);
		UIComponent parent = component.getParent();
		if (!(parent instanceof IExt)) {
			return;
		}

		Config config = (Config) component;
		String name = config.getName();
		String value = config.getValue();
		String mode = config.getMode();
		if ( value == null) 
			return;
		
		if(!"json".equals(mode) && StringUtil.isEmpty(name))
			return;
		
		Object valueResult = value;
		if (!"json".equals(mode) && ELUtils.isEL(value)) {
			valueResult = ELUtils.evaluate(context, value);
		}

		if (valueResult == null)
			return;

		if ("value".equals(mode)) {
			ConfigHelper.valueTo(name, valueResult, config);
		} else if ("json".equals(mode)) {
			Ext.applyConfig((IExt) parent, valueResult);
		} else {
			ConfigHelper.configTo(name, valueResult.toString(), config);
		}
	}
}
