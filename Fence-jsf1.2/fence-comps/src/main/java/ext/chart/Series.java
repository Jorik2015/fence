package ext.chart;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.base.ExtOutput;

/**
 *Note:This java code is auto generated by abner,do not edit it. Series class
 * for the charts widget.
 */
@InstanceOf("Ext.chart.Series")
@ParseConfigMode(ui = false, name = "series", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class Series extends ExtOutput {
	public static final String COMPONENT_TYPE = "Ext.chart.Series";
	public static final String COMPONENT_FAMILY = "Ext.chart.Series";

	/**
	 * <p>
	 * Create a new {@link Series} instance with default property values.
	 * </p>
	 */
	public Series() {
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