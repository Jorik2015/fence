package ext.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * A Column definition class which renders boolean data fields. See the <a
 * href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-xtype"
 * ext:member="xtype" ext:cls="Ext.grid.ColumnModel">xtype</a> config option of
 * <a href="output/Ext.grid.ColumnModel.html"
 * ext:cls="Ext.grid.ColumnModel">Ext.grid.ColumnModel</a> for more details.
 * </p>
 */
@InstanceOf("Ext.grid.BooleanColumn")
@ParseConfigMode(ui = false, name = "columns", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class BooleanColumn extends Column {
	public static final String COMPONENT_TYPE = "Ext.grid.BooleanColumn";
	public static final String COMPONENT_FAMILY = "Ext.grid.BooleanColumn";

	/**
	 * <p>
	 * Create a new {@link BooleanColumn} instance with default property values.
	 * </p>
	 */
	public BooleanColumn() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String falseText;

	/**
	 * The string returned by the renderer when thecolumn value is falsey (but
	 * not undefined) (defaults to <tt>'false'</tt>).
	 */
	public String getFalseText() {
		if (null != this.falseText) {
			return this.falseText;
		}
		ValueExpression _ve = getValueExpression("falseText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>falseText</code> property.
	 * </p>
	 */
	public void setFalseText(String falseText) {
		this.falseText = falseText;
		this.handleConfig("falseText", falseText);
	}

	private String trueText;

	/**
	 * The string returned by the renderer when thecolumn value is not falsey
	 * (defaults to <tt>'true'</tt>).
	 */
	public String getTrueText() {
		if (null != this.trueText) {
			return this.trueText;
		}
		ValueExpression _ve = getValueExpression("trueText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>trueText</code> property.
	 * </p>
	 */
	public void setTrueText(String trueText) {
		this.trueText = trueText;
		this.handleConfig("trueText", trueText);
	}

	private String undefinedText;

	/**
	 * The string returned by the renderer when thecolumn value is undefined
	 * (defaults to <tt>'&nbsp;'</tt>).
	 */
	public String getUndefinedText() {
		if (null != this.undefinedText) {
			return this.undefinedText;
		}
		ValueExpression _ve = getValueExpression("undefinedText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>undefinedText</code> property.
	 * </p>
	 */
	public void setUndefinedText(String undefinedText) {
		this.undefinedText = undefinedText;
		this.handleConfig("undefinedText", undefinedText);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = falseText;
		_values[2] = trueText;
		_values[3] = undefinedText;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.falseText = (String) _values[1];
		this.handleConfig("falseText", this.falseText);
		this.trueText = (String) _values[2];
		this.handleConfig("trueText", this.trueText);
		this.undefinedText = (String) _values[3];
		this.handleConfig("undefinedText", this.undefinedText);

	}
}