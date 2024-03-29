package ext;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;

/**
 *Note:This java code is auto generated by abner,do not edit it. This is the
 * base class for <a href="output/Ext.QuickTip.html"
 * ext:cls="Ext.QuickTip">Ext.QuickTip</a> and <a href="output/Ext.Tooltip.html"
 * ext:cls="Ext.Tooltip">Ext.Tooltip</a> that provides the basic layout and
 * positioning that all tip-based classes require. This class can be used
 * directly for simple, statically-positioned tips that are displayed
 * programmatically, or it can be extended to provide custom tip
 * implementations.
 */
@InstanceOf("Ext.Tip")
public class Tip extends Panel {
	public static final String COMPONENT_TYPE = "Ext.Tip";
	public static final String COMPONENT_FAMILY = "Ext.Tip";

	/**
	 * <p>
	 * Create a new {@link Tip} instance with default property values.
	 * </p>
	 */
	public Tip() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean closable;

	/**
	 * True to render a close tool button into thetooltip header (defaults to
	 * false).
	 */
	public Boolean getClosable() {
		if (null != this.closable) {
			return this.closable;
		}
		ValueExpression _ve = getValueExpression("closable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>closable</code> property.
	 * </p>
	 */
	public void setClosable(Boolean closable) {
		this.closable = closable;
		this.handleConfig("closable", closable);
	}

	private String defaultAlign;

	/**
	 * <b>Experimental</b>. The default <a
	 * href="output/Ext.Element.html#Ext.Element-alignTo" ext:member="alignTo"
	 * ext:cls="Ext.Element">Ext.Element.alignTo</a>anchor position value for
	 * this tip relative to its element of origin (defaults to "tl-bl?").
	 */
	public String getDefaultAlign() {
		if (null != this.defaultAlign) {
			return this.defaultAlign;
		}
		ValueExpression _ve = getValueExpression("defaultAlign");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultAlign</code> property.
	 * </p>
	 */
	public void setDefaultAlign(String defaultAlign) {
		this.defaultAlign = defaultAlign;
		this.handleConfig("defaultAlign", defaultAlign);
	}

	private Integer maxWidth;

	/**
	 * The maximum width of the tip in pixels (defaultsto 300). The maximum
	 * supported value is 500.
	 */
	public Integer getMaxWidth() {
		if (null != this.maxWidth) {
			return this.maxWidth;
		}
		ValueExpression _ve = getValueExpression("maxWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxWidth</code> property.
	 * </p>
	 */
	public void setMaxWidth(Integer maxWidth) {
		this.maxWidth = maxWidth;
		this.handleConfig("maxWidth", maxWidth);
	}

	private Integer minWidth;

	/**
	 * The minimum width of the tip in pixels (defaultsto 40).
	 */
	public Integer getMinWidth() {
		if (null != this.minWidth) {
			return this.minWidth;
		}
		ValueExpression _ve = getValueExpression("minWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth(Integer minWidth) {
		this.minWidth = minWidth;
		this.handleConfig("minWidth", minWidth);
	}

	private Boolean shadow;

	/**
	 * True or "sides" for the default effect, "frame"for 4-way shadow, and
	 * "drop" for bottom-right shadow (defaults to "sides").
	 */
	public Boolean getShadow() {
		if (null != this.shadow) {
			return this.shadow;
		}
		ValueExpression _ve = getValueExpression("shadow");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>shadow</code> property.
	 * </p>
	 */
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
		this.handleConfig("shadow", shadow);
	}

	private Integer width;

	/**
	 * Width in pixels of the tip (defaults to auto).Width will be ignored if it
	 * exceeds the bounds of <a href="output/Ext.Tip.html#Ext.Tip-minWidth"
	 * ext:member="minWidth" ext:cls="Ext.Tip">minWidth</a> or <a
	 * href="output/Ext.Tip.html#Ext.Tip-maxWidth" ext:member="maxWidth"
	 * ext:cls="Ext.Tip">maxWidth</a>. The maximum supported value is 500.
	 */
	public Integer getWidth() {
		if (null != this.width) {
			return this.width;
		}
		ValueExpression _ve = getValueExpression("width");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth(Integer width) {
		this.width = width;
		this.handleConfig("width", width);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[7];
		}
		_values[0] = super.saveState(_context);
		_values[1] = closable;
		_values[2] = defaultAlign;
		_values[3] = maxWidth;
		_values[4] = minWidth;
		_values[5] = shadow;
		_values[6] = width;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.closable = (Boolean) _values[1];
		this.handleConfig("closable", this.closable);
		this.defaultAlign = (String) _values[2];
		this.handleConfig("defaultAlign", this.defaultAlign);
		this.maxWidth = (Integer) _values[3];
		this.handleConfig("maxWidth", this.maxWidth);
		this.minWidth = (Integer) _values[4];
		this.handleConfig("minWidth", this.minWidth);
		this.shadow = (Boolean) _values[5];
		this.handleConfig("shadow", this.shadow);
		this.width = (Integer) _values[6];
		this.handleConfig("width", this.width);

	}
}