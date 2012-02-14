package ext.ux.mif;

import ext.annotation.InstanceOf;
import ext.annotation.UXResources;
import ext.annotation.XType;

@XType("iframewindow")
@InstanceOf("Ext.ux.ManagedIFrame.Window")
@UXResources(js = { "ext[version]/ux/miframe.js"})
public class MifWindow extends MifComponentAdapter {
	public static final String COMPONENT_TYPE = "Ext.ux.ManagedIFrame.Window";
	public static final String COMPONENT_FAMILY = "Ext.ux.ManagedIFrame.Window";

	/**
	 * <p>
	 * Create a new {@link MifWindow} instance with default property
	 * values.
	 * </p>
	 */
	public MifWindow() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
}
