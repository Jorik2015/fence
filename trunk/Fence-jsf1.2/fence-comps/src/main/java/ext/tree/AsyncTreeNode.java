package ext.tree;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 */
@InstanceOf("Ext.tree.AsyncTreeNode")
@ParseConfigMode(name = "root", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class AsyncTreeNode extends TreeNode {
	public static final String COMPONENT_TYPE = "Ext.tree.AsyncTreeNode";
	public static final String COMPONENT_FAMILY = "Ext.tree.AsyncTreeNode";

	/**
	 * <p>
	 * Create a new {@link AsyncTreeNode} instance with default property values.
	 * </p>
	 */
	public AsyncTreeNode() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private TreeLoader loader;

	/**
	 * A TreeLoader to be used by this node (defaultsto the loader defined on
	 * the tree)
	 */
	public TreeLoader getLoader() {
		if (null != this.loader) {
			return this.loader;
		}
		ValueExpression _ve = getValueExpression("loader");
		if (_ve != null) {
			return (TreeLoader) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>loader</code> property.
	 * </p>
	 */
	public void setLoader(TreeLoader loader) {
		this.loader = loader;
		this.handleConfig("loader", loader);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
		_values[1] = loader;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.loader = (TreeLoader) _values[1];
		this.handleConfig("loader", this.loader);

	}
}