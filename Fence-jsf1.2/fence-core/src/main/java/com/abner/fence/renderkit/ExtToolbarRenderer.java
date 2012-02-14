package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.abner.fence.util.ConfigHelper;

import ext.Toolbar;
import ext.util.StringUtil;

public class ExtToolbarRenderer extends ExtBasicRenderer<Toolbar> {

	@Override
	public void beforeEncodeBegin(FacesContext context, Toolbar component)
			throws IOException {
		String position = component.getPosition();
		if(StringUtil.isEmpty(position))
			position = "tbar";
		
		ConfigHelper.configTo(position, component.getVar(), component);
	}
}
