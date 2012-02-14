package ext.form;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. Numeric text
 * field that provides automatic keystroke filtering and numeric validation.
 */
@XType("numberfield")
@InstanceOf("Ext.form.NumberField")
public class NumberField extends TextField {
	public static final String COMPONENT_TYPE = "Ext.form.NumberField";
	public static final String COMPONENT_FAMILY = "Ext.form.NumberField";

	/**
	 * <p>
	 * Create a new {@link NumberField} instance with default property values.
	 * </p>
	 */
	public NumberField() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean allowDecimals;

	/**
	 * False to disallow decimal values (defaults totrue)
	 */
	public Boolean getAllowDecimals() {
		if (null != this.allowDecimals) {
			return this.allowDecimals;
		}
		ValueExpression _ve = getValueExpression("allowDecimals");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDecimals</code> property.
	 * </p>
	 */
	public void setAllowDecimals(Boolean allowDecimals) {
		this.allowDecimals = allowDecimals;
		this.handleConfig("allowDecimals", allowDecimals);
	}

	private Boolean allowNegative;

	/**
	 * False to prevent entering a negative sign(defaults to true)
	 */
	public Boolean getAllowNegative() {
		if (null != this.allowNegative) {
			return this.allowNegative;
		}
		ValueExpression _ve = getValueExpression("allowNegative");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowNegative</code> property.
	 * </p>
	 */
	public void setAllowNegative(Boolean allowNegative) {
		this.allowNegative = allowNegative;
		this.handleConfig("allowNegative", allowNegative);
	}

	private String baseChars;

	/**
	 * The base set of characters to evaluate as validnumbers (defaults to
	 * '0123456789').
	 */
	public String getBaseChars() {
		if (null != this.baseChars) {
			return this.baseChars;
		}
		ValueExpression _ve = getValueExpression("baseChars");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>baseChars</code> property.
	 * </p>
	 */
	public void setBaseChars(String baseChars) {
		this.baseChars = baseChars;
		this.handleConfig("baseChars", baseChars);
	}

	private Integer decimalPrecision;

	/**
	 * The maximum precision to display after thedecimal separator (defaults to
	 * 2)
	 */
	public Integer getDecimalPrecision() {
		if (null != this.decimalPrecision) {
			return this.decimalPrecision;
		}
		ValueExpression _ve = getValueExpression("decimalPrecision");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>decimalPrecision</code> property.
	 * </p>
	 */
	public void setDecimalPrecision(Integer decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
		this.handleConfig("decimalPrecision", decimalPrecision);
	}

	private String decimalSeparator;

	/**
	 * Character(s) to allow as the decimal separator(defaults to '.')
	 */
	public String getDecimalSeparator() {
		if (null != this.decimalSeparator) {
			return this.decimalSeparator;
		}
		ValueExpression _ve = getValueExpression("decimalSeparator");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>decimalSeparator</code> property.
	 * </p>
	 */
	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
		this.handleConfig("decimalSeparator", decimalSeparator);
	}

	private String fieldClass;

	/**
	 * The default CSS class for the field (defaults
	 * to"x-form-field x-form-num-field")
	 */
	public String getFieldClass() {
		if (null != this.fieldClass) {
			return this.fieldClass;
		}
		ValueExpression _ve = getValueExpression("fieldClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldClass</code> property.
	 * </p>
	 */
	public void setFieldClass(String fieldClass) {
		this.fieldClass = fieldClass;
		this.handleConfig("fieldClass", fieldClass);
	}

	private String maxText;

	/**
	 * Error text to display if the maximum valuevalidation fails (defaults to
	 * "The maximum value for this field is {maxValue}")
	 */
	public String getMaxText() {
		if (null != this.maxText) {
			return this.maxText;
		}
		ValueExpression _ve = getValueExpression("maxText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxText</code> property.
	 * </p>
	 */
	public void setMaxText(String maxText) {
		this.maxText = maxText;
		this.handleConfig("maxText", maxText);
	}

	private Integer maxValue;

	/**
	 * The maximum allowed value (defaults toNumber.MAX_VALUE)
	 */
	public Integer getMaxValue() {
		if (null != this.maxValue) {
			return this.maxValue;
		}
		ValueExpression _ve = getValueExpression("maxValue");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxValue</code> property.
	 * </p>
	 */
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
		this.handleConfig("maxValue", maxValue);
	}

	private String minText;

	/**
	 * Error text to display if the minimum valuevalidation fails (defaults to
	 * "The minimum value for this field is {minValue}")
	 */
	public String getMinText() {
		if (null != this.minText) {
			return this.minText;
		}
		ValueExpression _ve = getValueExpression("minText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minText</code> property.
	 * </p>
	 */
	public void setMinText(String minText) {
		this.minText = minText;
		this.handleConfig("minText", minText);
	}

	private Integer minValue;

	/**
	 * The minimum allowed value (defaults toNumber.NEGATIVE_INFINITY)
	 */
	public Integer getMinValue() {
		if (null != this.minValue) {
			return this.minValue;
		}
		ValueExpression _ve = getValueExpression("minValue");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minValue</code> property.
	 * </p>
	 */
	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
		this.handleConfig("minValue", minValue);
	}

	private String nanText;

	/**
	 * Error text to display if the value is not a validnumber. For example,
	 * this can happen if a valid character like '.' or '-' is left in the field
	 * with no number (defaults to "{value} is not a valid number")
	 */
	public String getNanText() {
		if (null != this.nanText) {
			return this.nanText;
		}
		ValueExpression _ve = getValueExpression("nanText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>nanText</code> property.
	 * </p>
	 */
	public void setNanText(String nanText) {
		this.nanText = nanText;
		this.handleConfig("nanText", nanText);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[12];
		}
		_values[0] = super.saveState(_context);
		_values[1] = allowDecimals;
		_values[2] = allowNegative;
		_values[3] = baseChars;
		_values[4] = decimalPrecision;
		_values[5] = decimalSeparator;
		_values[6] = fieldClass;
		_values[7] = maxText;
		_values[8] = maxValue;
		_values[9] = minText;
		_values[10] = minValue;
		_values[11] = nanText;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.allowDecimals = (Boolean) _values[1];
		this.handleConfig("allowDecimals", this.allowDecimals);
		this.allowNegative = (Boolean) _values[2];
		this.handleConfig("allowNegative", this.allowNegative);
		this.baseChars = (String) _values[3];
		this.handleConfig("baseChars", this.baseChars);
		this.decimalPrecision = (Integer) _values[4];
		this.handleConfig("decimalPrecision", this.decimalPrecision);
		this.decimalSeparator = (String) _values[5];
		this.handleConfig("decimalSeparator", this.decimalSeparator);
		this.fieldClass = (String) _values[6];
		this.handleConfig("fieldClass", this.fieldClass);
		this.maxText = (String) _values[7];
		this.handleConfig("maxText", this.maxText);
		this.maxValue = (Integer) _values[8];
		this.handleConfig("maxValue", this.maxValue);
		this.minText = (String) _values[9];
		this.handleConfig("minText", this.minText);
		this.minValue = (Integer) _values[10];
		this.handleConfig("minValue", this.minValue);
		this.nanText = (String) _values[11];
		this.handleConfig("nanText", this.nanText);

	}
}