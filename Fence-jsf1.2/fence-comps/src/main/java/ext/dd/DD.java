package ext.dd;

import javax.faces.context.FacesContext;

/**
 *Note:This java code is auto generated by abner,do not edit it. A DragDrop
 * implementation where the linked element follows the mouse cursor during a
 * drag.
 */
public class DD extends DragDrop {
	public static final String COMPONENT_TYPE = "Ext.dd.DD";

	/**
	 * <p>
	 * Create a new {@link DD} instance with default property values.
	 * </p>
	 */
	public DD() {
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