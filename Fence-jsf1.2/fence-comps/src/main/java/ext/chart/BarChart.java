package ext.chart;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 */
@XType("barchart")
@InstanceOf("Ext.chart.BarChart")
public class BarChart extends CartesianChart {
	public static final String COMPONENT_TYPE = "Ext.chart.BarChart";
	public static final String COMPONENT_FAMILY = "Ext.chart.BarChart";

	/**
	 * <p>
	 * Create a new {@link BarChart} instance with default property values.
	 * </p>
	 */
	public BarChart() {
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