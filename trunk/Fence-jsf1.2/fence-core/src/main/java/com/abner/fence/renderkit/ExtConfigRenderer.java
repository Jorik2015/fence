package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import com.abner.fence.util.ConfigHelper;
import com.abner.fence.util.Ext;

import ext.base.Config;
import ext.base.IExt;
import ext.util.ComponentUtil;
import ext.util.ELUtils;
import ext.util.JsonUtils;
import ext.util.StringUtil;

public class ExtConfigRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		super.encodeBegin(context, component);

		Config configComp = (Config) component;
		String name = configComp.getName();
		Object value = configComp.getValue();
		String mode = configComp.getMode();
		if (value == null || name == null)
			return;

		IExt parent = ComponentUtil.getFirstExtParent(configComp);
		if (parent == null) {
			return;
		}

		if (!"json".equals(mode) && StringUtil.isEmpty(name))
			return;

		if ("value".equals(mode)) {
			ConfigHelper.valueTo(name, value, configComp);
		} else if ("json".equals(mode)) {
			Ext.applyConfig((IExt) parent, value);
		} else if ("object".equals(mode)) {
			ConfigHelper.configTo(name, Ext.PREFIX_RAW_VALUE + JsonUtils.getJSON(value).toString(), configComp, parent);
		} else {
			ConfigHelper.configTo(name, value.toString(), configComp);
		}
	}
}
