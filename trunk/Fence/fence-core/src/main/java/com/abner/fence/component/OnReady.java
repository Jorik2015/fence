package com.abner.fence.component;

import javax.faces.component.FacesComponent;

@FacesComponent("Ext.OnReady")
public class OnReady extends ExtComponent {
	public static final String COMPONENT_TYPE = "Ext.OnReady";
	public static final String COMPONENT_FAMILY = "Ext.OnReady";

	/**
	 * <p>
	 * Create a new {@link Component} instance with default property values.
	 * </p>
	 */
	public OnReady() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
}
