package ext.ux.tree;

import javax.faces.context.FacesContext;

import ext.tree.TreeNodeUI;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 */
public class ColumnNodeUI extends TreeNodeUI {
	public static final String COMPONENT_TYPE = "Ext.ux.tree.ColumnNodeUI";

	/**
	 * <p>
	 * Create a new {@link ColumnNodeUI} instance with default property values.
	 * </p>
	 */
	public ColumnNodeUI() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[1];
		}
		_values[0] = super.saveState(_context);

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);

	}
}