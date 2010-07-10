package com.abner.fence.component.ux;

import com.abner.fence.annotation.InstanceOf;
import com.abner.fence.annotation.UXResources;
import com.abner.fence.annotation.XType;

@XType("iframeportlet")
@InstanceOf("Ext.ux.ManagedIFrame.Portlet")
@UXResources(js = { "ext-[version]/ux/miframe.js" })
public class MifPortlet extends MifComponentAdapter {
	public static final String COMPONENT_TYPE = "Ext.ux.ManagedIFrame.Portlet";
	public static final String COMPONENT_FAMILY = "Ext.ux.ManagedIFrame.Portlet";

	/**
	 * <p>
	 * Create a new {@link MifPortlet} instance with default property values.
	 * </p>
	 */
	public MifPortlet() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
}
