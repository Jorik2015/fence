package ext.ux.tree;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.UXResources;
import ext.tree.TreeLoader;

@InstanceOf("Ext.ux.tree.TreeGridLoader")
@UXResources(js = {"ext[version]/ux/treegrid/TreeGridLoader.js"})
@ParseConfigMode(name = "loader", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class TreeGridLoader extends TreeLoader {
	public static final String COMPONENT_TYPE = "Ext.ux.tree.TreeGridLoader";
	public static final String COMPONENT_FAMILY = "Ext.ux.tree.TreeGridLoader";

	/**
	 * <p>
	 * Create a new {@link TreeLoader} instance with default property values.
	 * </p>
	 */
	public TreeGridLoader() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
}
