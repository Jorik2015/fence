package ext.ux;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.XType;
import ext.chart.Chart;

/**
 * 
 */
@XType("highchart")
@InstanceOf("Ext.ux.HighChart")
public class HighChart extends Chart {
	public static final String COMPONENT_FAMILY = "Ext.ux.HighChart";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.HighChart} instance with default property
	 * values.
	 * </p>
	 */
	public HighChart() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	enum PropertyKeys {
		defaultSerieType, resizable, updateDelay, loadMask, animShift;
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

	private String defaultSerieType;

	/*
	 * $cfg.commonts
	 */

	public String getDefaultSerieType() {
		if (null != this.defaultSerieType) {
			return this.defaultSerieType;
		}
		ValueExpression _ve = getValueExpression("defaultSerieType");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultSerieType</code> property.
	 * </p>
	 */
	public void setDefaultSerieType(String defaultSerieType) {
		this.defaultSerieType = defaultSerieType;
		this.handleConfig("defaultSerieType", defaultSerieType);
	}

	private Boolean resizable;

	/*
	 * $cfg.commonts
	 */

	public Boolean getResizable() {
		if (null != this.resizable) {
			return this.resizable;
		}
		ValueExpression _ve = getValueExpression("resizable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>resizable</code> property.
	 * </p>
	 */
	public void setResizable(Boolean resizable) {
		this.resizable = resizable;
		this.handleConfig("resizable", resizable);
	}

	private Number updateDelay;

	/*
	 * $cfg.commonts
	 */

	public Number getUpdateDelay() {
		if (null != this.updateDelay) {
			return this.updateDelay;
		}
		ValueExpression _ve = getValueExpression("updateDelay");
		if (_ve != null) {
			return (Number) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>updateDelay</code> property.
	 * </p>
	 */
	public void setUpdateDelay(Number updateDelay) {
		this.updateDelay = updateDelay;
		this.handleConfig("updateDelay", updateDelay);
	}

	private Boolean loadMask;

	/*
	 * $cfg.commonts
	 */

	public Boolean getLoadMask() {
		if (null != this.loadMask) {
			return this.loadMask;
		}
		ValueExpression _ve = getValueExpression("loadMask");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>loadMask</code> property.
	 * </p>
	 */
	public void setLoadMask(Boolean loadMask) {
		this.loadMask = loadMask;
		this.handleConfig("loadMask", loadMask);
	}

	private Boolean animShift;

	/*
	 * $cfg.commonts
	 */

	public Boolean getAnimShift() {
		if (null != this.animShift) {
			return this.animShift;
		}
		ValueExpression _ve = getValueExpression("animShift");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>animShift</code> property.
	 * </p>
	 */
	public void setAnimShift(Boolean animShift) {
		this.animShift = animShift;
		this.handleConfig("animShift", animShift);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[6];
		}
		_values[0] = super.saveState(_context);
		_values[1] = defaultSerieType;
		_values[2] = resizable;
		_values[3] = updateDelay;
		_values[4] = loadMask;
		_values[5] = animShift;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.defaultSerieType = (String) _values[1];
		this.handleConfig("defaultSerieType", this.defaultSerieType);
		this.resizable = (Boolean) _values[2];
		this.handleConfig("resizable", this.resizable);
		this.updateDelay = (Number) _values[3];
		this.handleConfig("updateDelay", this.updateDelay);
		this.loadMask = (Boolean) _values[4];
		this.handleConfig("loadMask", this.loadMask);
		this.animShift = (Boolean) _values[5];
		this.handleConfig("animShift", this.animShift);
	}
}