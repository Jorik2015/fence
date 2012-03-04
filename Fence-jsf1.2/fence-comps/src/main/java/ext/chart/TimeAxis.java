package ext.chart;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 *Note:This java code is auto generated by abner,do not edit it. A type of axis
 * whose units are measured in time-based values.
 */
@InstanceOf("Ext.chart.TimeAxis")
@ParseConfigMode(ui = false, pmode = PersistenceMode.Custom, rmode = ReferenceMode.Var)
public class TimeAxis extends Axis {
	public static final String COMPONENT_TYPE = "Ext.chart.TimeAxis";
	public static final String COMPONENT_FAMILY = "Ext.chart.TimeAxis";

	/**
	 * <p>
	 * Create a new {@link TimeAxis} instance with default property values.
	 * </p>
	 */
	public TimeAxis() {
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