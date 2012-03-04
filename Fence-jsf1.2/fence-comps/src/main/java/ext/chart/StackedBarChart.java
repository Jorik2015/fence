package ext.chart;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 */
@XType("stackedbarchart")
@InstanceOf("Ext.chart.StackedBarChart")
public class StackedBarChart extends CartesianChart {
	public static final String COMPONENT_TYPE = "Ext.chart.StackedBarChart";
	public static final String COMPONENT_FAMILY = "Ext.chart.StackedBarChart";

	/**
	 * <p>
	 * Create a new {@link StackedBarChart} instance with default property
	 * values.
	 * </p>
	 */
	public StackedBarChart() {
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