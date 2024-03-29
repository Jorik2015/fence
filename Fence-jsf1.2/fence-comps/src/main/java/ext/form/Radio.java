package ext.form;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. Single radio
 * field. Same as Checkbox, but provided as a convenience for automatically
 * setting the input type. Radio grouping is handled automatically by the
 * browser if you give each radio in a group the same name.
 */
@XType("radio")
@InstanceOf("Ext.form.Radio")
public class Radio extends Checkbox {
	public static final String COMPONENT_TYPE = "Ext.form.Radio";
	public static final String COMPONENT_FAMILY = "Ext.form.Radio";

	/**
	 * <p>
	 * Create a new {@link Radio} instance with default property values.
	 * </p>
	 */
	public Radio() {
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