package ext.grid;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.util.Observable;

/**
 *Note:This java code is auto generated by abner,do not edit it. Abstract base
 * class for grid SelectionModels. It provides the interface that should be
 * implemented by descendant classes. This class should not be directly
 * instantiated.
 */
@InstanceOf("Ext.grid.AbstractSelectionModel")
@ParseConfigMode(name = "selModel", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class AbstractSelectionModel extends Observable {
	public static final String COMPONENT_TYPE = "Ext.grid.AbstractSelectionModel";
	public static final String COMPONENT_FAMILY = "Ext.grid.AbstractSelectionModel";

	/**
	 * <p>
	 * Create a new {@link AbstractSelectionModel} instance with default
	 * property values.
	 * </p>
	 */
	public AbstractSelectionModel() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
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