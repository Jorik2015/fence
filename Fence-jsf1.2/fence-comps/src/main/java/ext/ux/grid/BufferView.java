package ext.ux.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.UXResources;
import ext.grid.GridView;

/**
 *Note:This java code is auto generated by abner,do not edit it. A custom
 * GridView which renders rows on an as-needed basis.
 */
@InstanceOf("Ext.ux.grid.BufferView")
@ParseConfigMode(ui = false, name = "view", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
@UXResources(js = "ext[version]/ux/BufferView.js")
public class BufferView extends GridView {
	public static final String COMPONENT_TYPE = "Ext.ux.grid.BufferView";

	/**
	 * <p>
	 * Create a new {@link BufferView} instance with default property values.
	 * </p>
	 */
	public BufferView() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Integer borderHeight;

	/**
	 * The combined height of border-top andborder-bottom of a row.
	 */
	public Integer getBorderHeight() {
		if (null != this.borderHeight) {
			return this.borderHeight;
		}
		ValueExpression _ve = getValueExpression("borderHeight");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>borderHeight</code> property.
	 * </p>
	 */
	public void setBorderHeight(Integer borderHeight) {
		this.borderHeight = borderHeight;
		handleConfig("borderHeight", borderHeight);
	}

	private Integer cacheSize;

	/**
	 * The number of rows to look forward and backwardsfrom the currently
	 * viewable area. The cache applies only to rows that have been rendered
	 * already.
	 */
	public Integer getCacheSize() {
		if (null != this.cacheSize) {
			return this.cacheSize;
		}
		ValueExpression _ve = getValueExpression("cacheSize");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cacheSize</code> property.
	 * </p>
	 */
	public void setCacheSize(Integer cacheSize) {
		this.cacheSize = cacheSize;
		handleConfig("cacheSize", cacheSize);
	}

	private Integer cleanDelay;

	/**
	 * The number of milliseconds to buffer cleaning ofextra rows not in the
	 * cache.
	 */
	public Integer getCleanDelay() {
		if (null != this.cleanDelay) {
			return this.cleanDelay;
		}
		ValueExpression _ve = getValueExpression("cleanDelay");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cleanDelay</code> property.
	 * </p>
	 */
	public void setCleanDelay(Integer cleanDelay) {
		this.cleanDelay = cleanDelay;
		handleConfig("cleanDelay", cleanDelay);
	}

	private Integer rowHeight;

	/**
	 * The height of a row in the grid.
	 */
	public Integer getRowHeight() {
		if (null != this.rowHeight) {
			return this.rowHeight;
		}
		ValueExpression _ve = getValueExpression("rowHeight");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>rowHeight</code> property.
	 * </p>
	 */
	public void setRowHeight(Integer rowHeight) {
		this.rowHeight = rowHeight;
		handleConfig("rowHeight", rowHeight);
	}

	private Boolean scrollDelay;

	/**
	 * The number of milliseconds before rendering rowsout of the visible
	 * viewing area. Defaults to 100. Rows will render immediately with a config
	 * of false.
	 */
	public Boolean getScrollDelay() {
		if (null != this.scrollDelay) {
			return this.scrollDelay;
		}
		ValueExpression _ve = getValueExpression("scrollDelay");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollDelay</code> property.
	 * </p>
	 */
	public void setScrollDelay(Boolean scrollDelay) {
		this.scrollDelay = scrollDelay;
		handleConfig("scrollDelay", scrollDelay);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[6];
		}
		_values[0] = super.saveState(_context);
		_values[1] = borderHeight;
		_values[2] = cacheSize;
		_values[3] = cleanDelay;
		_values[4] = rowHeight;
		_values[5] = scrollDelay;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.borderHeight = (Integer) _values[1];
		this.handleConfig("borderHeight", this.borderHeight);
		this.cacheSize = (Integer) _values[2];
		this.handleConfig("cacheSize", this.cacheSize);
		this.cleanDelay = (Integer) _values[3];
		this.handleConfig("cleanDelay", this.cleanDelay);
		this.rowHeight = (Integer) _values[4];
		this.handleConfig("rowHeight", this.rowHeight);
		this.scrollDelay = (Boolean) _values[5];
		this.handleConfig("scrollDelay", this.scrollDelay);

	}
}