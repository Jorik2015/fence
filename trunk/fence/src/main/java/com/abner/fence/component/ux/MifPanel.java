package com.abner.fence.component.ux;

import javax.faces.application.ResourceDependency;

import com.abner.fence.annotation.InstanceOf;
import com.abner.fence.annotation.XType;

@XType("iframepanel")
@InstanceOf("Ext.ux.ManagedIFrame.Panel")
@ResourceDependency(library = "ext#{ext.version}/uux", name = "miframe#{ext.debugSuffix}.js")
public class MifPanel extends MifComponentAdapter {
	public static final String COMPONENT_TYPE = "Ext.ux.ManagedIFrame.Panel";
	public static final String COMPONENT_FAMILY = "Ext.ux.ManagedIFrame.Panel";

	/**
	 * <p>
	 * Create a new {@link MifPanel} instance with default property values.
	 * </p>
	 */
	public MifPanel() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
}
