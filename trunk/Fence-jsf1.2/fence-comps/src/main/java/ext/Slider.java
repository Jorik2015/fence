package ext;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;

/**
 *Note:This java code is auto generated by abner,do not edit it. Slider which
 * supports vertical or horizontal orientation, keyboard adjustments,
 * configurable snapping, axis clicking and animation. Can be added as an item
 * to any container. Example usage:
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;new&lt;/b&gt; Ext.Slider({
 *     renderTo: Ext.getBody(),
 *     width: 200,
 *     value: 50,
 *     increment: 10,
 *     minValue: 0,
 *     maxValue: 100
 * });&lt;/code&gt;
 * </pre>
 */
@InstanceOf("Ext.Slider")
public class Slider extends BoxComponent {
	public static final String COMPONENT_TYPE = "Ext.Slider";
	public static final String COMPONENT_FAMILY = "Ext.Slider";

	/**
	 * <p>
	 * Create a new {@link Slider} instance with default property values.
	 * </p>
	 */
	public Slider() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean animate;

	/**
	 * Turn on or off animation. Defaults to true
	 */
	public Boolean getAnimate() {
		if (null != this.animate) {
			return this.animate;
		}
		ValueExpression _ve = getValueExpression("animate");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>animate</code> property.
	 * </p>
	 */
	public void setAnimate(Boolean animate) {
		this.animate = animate;
		this.handleConfig("animate", animate);
	}

	private Boolean clickToChange;

	/**
	 * Determines whether or not clicking on the Slideraxis will change the
	 * slider. Defaults to true
	 */
	public Boolean getClickToChange() {
		if (null != this.clickToChange) {
			return this.clickToChange;
		}
		ValueExpression _ve = getValueExpression("clickToChange");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>clickToChange</code> property.
	 * </p>
	 */
	public void setClickToChange(Boolean clickToChange) {
		this.clickToChange = clickToChange;
		this.handleConfig("clickToChange", clickToChange);
	}

	private Integer decimalPrecision;

	/**
	 * <p>
	 * The number of decimal places to which to round the Slider's value.
	 * Defaults to 0.
	 * </p>
	 * 
	 * <p>
	 * To disable rounding, configure as <tt><b>false</b></tt>.
	 * </p>
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

	private Integer increment;

	/**
	 * How many units to change the slider whenadjusting by drag and drop. Use
	 * this option to enable 'snapping'.
	 */
	public Integer getIncrement() {
		if (null != this.increment) {
			return this.increment;
		}
		ValueExpression _ve = getValueExpression("increment");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>increment</code> property.
	 * </p>
	 */
	public void setIncrement(Integer increment) {
		this.increment = increment;
		this.handleConfig("increment", increment);
	}

	private Integer keyIncrement;

	/**
	 * How many units to change the Slider whenadjusting with keyboard
	 * navigation. Defaults to 1. If the increment config is larger, it will be
	 * used instead.
	 */
	public Integer getKeyIncrement() {
		if (null != this.keyIncrement) {
			return this.keyIncrement;
		}
		ValueExpression _ve = getValueExpression("keyIncrement");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>keyIncrement</code> property.
	 * </p>
	 */
	public void setKeyIncrement(Integer keyIncrement) {
		this.keyIncrement = keyIncrement;
		this.handleConfig("keyIncrement", keyIncrement);
	}

	private Integer maxValue;

	/**
	 * The maximum value for the Slider. Defaults to100.
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

	private Integer minValue;

	/**
	 * The minimum value for the Slider. Defaults to0.
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

	private Integer value;

	/**
	 * The value to initialize the slider with.Defaults to minValue.
	 */
	public Integer getValue() {
		if (null != this.value) {
			return this.value;
		}
		ValueExpression _ve = getValueExpression("value");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>value</code> property.
	 * </p>
	 */
	public void setValue(Integer value) {
		this.value = value;
		this.handleConfig("value", value);
	}

	private Boolean vertical;

	/**
	 * Orient the Slider vertically rather thanhorizontally, defaults to false.
	 */
	public Boolean getVertical() {
		if (null != this.vertical) {
			return this.vertical;
		}
		ValueExpression _ve = getValueExpression("vertical");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>vertical</code> property.
	 * </p>
	 */
	public void setVertical(Boolean vertical) {
		this.vertical = vertical;
		this.handleConfig("vertical", vertical);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[10];
		}
		_values[0] = super.saveState(_context);
		_values[1] = animate;
		_values[2] = clickToChange;
		_values[3] = decimalPrecision;
		_values[4] = increment;
		_values[5] = keyIncrement;
		_values[6] = maxValue;
		_values[7] = minValue;
		_values[8] = value;
		_values[9] = vertical;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.animate = (Boolean) _values[1];
		this.handleConfig("animate", this.animate);
		this.clickToChange = (Boolean) _values[2];
		this.handleConfig("clickToChange", this.clickToChange);
		this.decimalPrecision = (Integer) _values[3];
		this.handleConfig("decimalPrecision", this.decimalPrecision);
		this.increment = (Integer) _values[4];
		this.handleConfig("increment", this.increment);
		this.keyIncrement = (Integer) _values[5];
		this.handleConfig("keyIncrement", this.keyIncrement);
		this.maxValue = (Integer) _values[6];
		this.handleConfig("maxValue", this.maxValue);
		this.minValue = (Integer) _values[7];
		this.handleConfig("minValue", this.minValue);
		this.value = (Integer) _values[8];
		this.handleConfig("value", this.value);
		this.vertical = (Boolean) _values[9];
		this.handleConfig("vertical", this.vertical);

	}
}