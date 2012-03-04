package ext.list;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?> <div
 * class="description">
 * <p>
 * A Column definition class which renders a numeric data field according to a
 * <a ext:cls="Ext.list.NumberColumn" ext:member="format"
 * href="output/Ext.list.NumberColumn.html#Ext.list.NumberColumn-format"
 * >format</a> string. See the <a ext:cls="Ext.list.Column" ext:member="xtype"
 * href="output/Ext.list.Column.html#Ext.list.Column-xtype">xtype</a> config
 * option of <a ext:cls="Ext.list.Column"
 * href="output/Ext.list.Column.html">Ext.list.Column</a> for more details.
 * </p>
 * </div>
 */

@InstanceOf("Ext.list.NumberColumn")
@ParseConfigMode(ui = false, name = "columns", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class NumberColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.list.NumberColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.list.NumberColumn} instance with default property
	 * values.
	 * </p>
	 */
	public NumberColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	enum PropertyKeys {
		format;
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

	private String format;

	/*
	 * <?xml version="1.0" encoding="UTF-8" standalone="no"?> <div
	 * class="long">A formatting string as used by <a ext:cls="Ext.util.Format"
	 * ext:member="number"
	 * href="output/Ext.util.Format.html#Ext.util.Format-number"
	 * >Ext.util.Format.number</a> to format a numeric value for this Column
	 * (defaults to <tt>'0,000.00'</tt>).</div>
	 */

	public String getFormat() {
		if (null != this.format) {
			return this.format;
		}
		ValueExpression _ve = getValueExpression("format");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>format</code> property.
	 * </p>
	 */
	public void setFormat(String format) {
		this.format = format;
		this.handleConfig("format", format);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
		_values[1] = format;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.format = (String) _values[1];
		this.handleConfig("format", this.format);
	}
}