package ext.ux.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;
import ext.base.ExtOutput;

/**
 * 
 */
@XType("columnheadergroup")
@InstanceOf("Ext.ux.grid.ColumnHeaderGroup")
@ParseConfigMode(ui = false, name = "plugins", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class ColumnHeaderGroup extends ExtOutput {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.ColumnHeaderGroup";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.grid.ColumnHeaderGroup} instance with default
	 * property values.
	 * </p>
	 */
	public ColumnHeaderGroup() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	enum PropertyKeys {
		rows;
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

	private Object rows;

	/*
	 * $cfg.commonts
	 */
	@ClientConfig(JsonMode.Array)
	public Object getRows() {
		if (null != this.rows) {
			return this.rows;
		}
		ValueExpression _ve = getValueExpression("rows");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>rows</code> property.
	 * </p>
	 */
	public void setRows(Object rows) {
		this.rows = rows;
		this.handleConfig("rows", rows);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
		_values[1] = rows;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.rows = (Object) _values[1];
		this.handleConfig("rows", this.rows);
	}
}