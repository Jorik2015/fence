package ext.data;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 *Note:This java code is auto generated by abner,do not edit it. An
 * implementation of Ext.data.DataProxy that simply passes the data specified in
 * its constructor to the Reader when its load method is called.
 */
@InstanceOf("Ext.data.MemoryProxy")
@ParseConfigMode(ui = false, name = "proxy", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class MemoryProxy extends DataProxy {
	public static final String COMPONENT_TYPE = "Ext.data.MemoryProxy";
	public static final String COMPONENT_FAMILY = "Ext.data.MemoryProxy";

	/**
	 * <p>
	 * Create a new {@link MemoryProxy} instance with default property values.
	 * </p>
	 */
	public MemoryProxy() {
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