package ext.list;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?> <div
 * class="description">
 * <p>
 * Supporting Class for Ext.list.ListView
 * </p>
 * </div>
 */

@InstanceOf("Ext.list.ColumnResizer")
public class ColumnResizer extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.list.ColumnResizer";

	/**
	 * <p>
	 * Create a new {@link Ext.list.ColumnResizer} instance with default
	 * property values.
	 * </p>
	 */
	public ColumnResizer() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	enum PropertyKeys {
		minPct;
		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((toString != null) ? toString : super.toString());
		}
	}

	private Integer minPct;

	/*
	 * 
	 * 
	 * 
	 * minPct : Number The minimum percentage to allot for any column (defaults
	 * to .05)
	 */

	public Integer getMinPct() {
		if (null != this.minPct) {
			return this.minPct;
		}
		ValueExpression _ve = getValueExpression("minPct");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minPct</code> property.
	 * </p>
	 */
	public void setMinPct(Integer minPct) {
		this.minPct = minPct;
		this.handleConfig("minPct", minPct);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
		_values[1] = minPct;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.minPct = (Integer) _values[1];
		this.handleConfig("minPct", this.minPct);
	}
}