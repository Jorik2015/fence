package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.Strings;

import ext.Toolbar;

public class ExtToolbarRenderer extends ExtBasicRenderer<Toolbar> {

	@Override
	public void beforeEncodeBegin(FacesContext context, Toolbar component) throws IOException {
		String position = (String) component.getConfig("position");
		if (Strings.isEmpty(position))
			position = "tbar";

		ConfigUtils.configTo(position, component.getVar(), component);
	}
}
