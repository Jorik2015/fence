package ext.ux.mif;

import ext.annotation.InstanceOf;
import ext.annotation.UXResources;
import ext.annotation.XType;

@XType("iframepanel")
@InstanceOf("Ext.ux.ManagedIFrame.Panel")
@UXResources(js = { "ext[version]/ux/miframe-debug.js"})
public class MifPanel extends MifComponentAdapter {
	public static final String COMPONENT_TYPE = "Ext.ux.ManagedIFrame.Panel";
	public static final String COMPONENT_FAMILY = "Ext.ux.ManagedIFrame.Panel";

	/**
	 * <p>
	 * Create a new {@link MifPanel} instance with default property
	 * values.
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
