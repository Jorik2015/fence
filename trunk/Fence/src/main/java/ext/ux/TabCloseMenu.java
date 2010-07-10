package ext.ux;

import java.util.Collection;

import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;

import com.abner.fence.annotation.InstanceOf;
import com.abner.fence.annotation.ParseConfigMode;
import com.abner.fence.commons.Enums.PersistenceMode;
import com.abner.fence.commons.Enums.ReferenceMode;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.utils.ExtUtils;

/**
 * Plugin (ptype = 'tabclosemenu') for adding a close context menu to tabs.
 */

@InstanceOf("Ext.ux.TabCloseMenu")
@ParseConfigMode(name = "plugins", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
@FacesComponent(value = "Ext.ux.TabCloseMenu")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "TabCloseMenu.js")
public class TabCloseMenu extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.ux.TabCloseMenu";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.TabCloseMenu} instance with default property
	 * values.
	 * </p>
	 */
	public TabCloseMenu() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	@Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
		return superEvent;
	}
}