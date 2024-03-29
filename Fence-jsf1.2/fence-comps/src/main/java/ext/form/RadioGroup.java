package ext.form;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. A grouping
 * container for <a href="output/Ext.form.Radio.html"
 * ext:cls="Ext.form.Radio">Ext.form.Radio</a> controls.
 */
@XType("radiogroup")
@InstanceOf("Ext.form.RadioGroup")
public class RadioGroup extends CheckboxGroup {
	public static final String COMPONENT_TYPE = "Ext.form.RadioGroup";
	public static final String COMPONENT_FAMILY = "Ext.form.RadioGroup";

	/**
	 * <p>
	 * Create a new {@link RadioGroup} instance with default property values.
	 * </p>
	 */
	public RadioGroup() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean allowBlank;

	/**
	 * True to allow every item in the group to be blank(defaults to true). If
	 * allowBlank = false and no items are selected at validation time, {@link

	 */
	public Boolean getAllowBlank() {
		if (null != this.allowBlank) {
			return this.allowBlank;
		}
		ValueExpression _ve = getValueExpression("allowBlank");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowBlank</code> property.
	 * </p>
	 */
	public void setAllowBlank(Boolean allowBlank) {
		this.allowBlank = allowBlank;
		this.handleConfig("allowBlank", allowBlank);
	}

	private String blankText;

	/**
	 * Error text to display if the <a
	 * href="output/Ext.form.RadioGroup.html#Ext.form.RadioGroup-allowBlank"
	 * ext:member="allowBlank" ext:cls="Ext.form.RadioGroup">allowBlank</a>
	 * validation fails(defaults to 'You must select one item in this group')
	 */
	public String getBlankText() {
		if (null != this.blankText) {
			return this.blankText;
		}
		ValueExpression _ve = getValueExpression("blankText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>blankText</code> property.
	 * </p>
	 */
	public void setBlankText(String blankText) {
		this.blankText = blankText;
		this.handleConfig("blankText", blankText);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
		_values[1] = allowBlank;
		_values[2] = blankText;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.allowBlank = (Boolean) _values[1];
		this.handleConfig("allowBlank", this.allowBlank);
		this.blankText = (String) _values[2];
		this.handleConfig("blankText", this.blankText);

	}
}