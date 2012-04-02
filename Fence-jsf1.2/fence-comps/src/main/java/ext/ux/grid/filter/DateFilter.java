package ext.ux.grid.filter;

import java.util.Date;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.UXResources;

/**
 *Note:This java code is auto generated by abner,do not edit it. Filter by a
 * configurable Ext.menu.DateMenu
 * 
 * 
 * <p>
 * <b><u>Example Usage:</u></b>
 * </p>
 * 
 * <pre>
 * <code><b>var</b> filters = <b>new</b> Ext.ux.grid.GridFilters({
 *     ...
 *     filters: [{
 *         <i>// required configs
 * </i>
 *         type: <em>'date'</em>,
 *         dataIndex: <em>'dateAdded'</em>,
 *         
 *         <i>// optional configs
 * </i>
 *         dateFormat: <em>'m/d/Y'</em>,  <i>// <b>default</b>
 * </i>
 *         beforeText: <em>'Before'</em>, <i>// <b>default</b>
 * </i>
 *         afterText: <em>'After'</em>,   <i>// <b>default</b>
 * </i>
 *         onText: <em>'On'</em>,         <i>// <b>default</b>
 * </i>
 *         pickerOpts: {
 *             <i>// any DateMenu configs
 * </i>
 *         },
 * 
 *         active: true <i>// <b>default</b> is false
 * </i>
 *     }]
 * });</code>
 * </pre>
 */
@InstanceOf("Ext.ux.grid.filter.DateFilter")
@UXResources(js = "ext[version]/ux/gridfilters/filter/DateFilter.js")
@ParseConfigMode(ui = false, name = "filters", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class DateFilter extends Filter {
	public static final String COMPONENT_TYPE = "Ext.ux.grid.filter.DateFilter";
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.filter.DateFilter";

	/**
	 * <p>
	 * Create a new {@link DateFilter} instance with default property values.
	 * </p>
	 */
	public DateFilter() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String afterText;

	/**
	 * Defaults to 'After'.
	 */
	public String getAfterText() {
		if (null != this.afterText) {
			return this.afterText;
		}
		ValueExpression _ve = getValueExpression("afterText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>afterText</code> property.
	 * </p>
	 */
	public void setAfterText(String afterText) {
		this.afterText = afterText;
		this.handleConfig("afterText", afterText);
	}

	private String beforeText;

	/**
	 * Defaults to 'Before'.
	 */
	public String getBeforeText() {
		if (null != this.beforeText) {
			return this.beforeText;
		}
		ValueExpression _ve = getValueExpression("beforeText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>beforeText</code> property.
	 * </p>
	 */
	public void setBeforeText(String beforeText) {
		this.beforeText = beforeText;
		this.handleConfig("beforeText", beforeText);
	}

	private Object compareMap;

	/**
	 * Map for assigning the comparison values used inserialization.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getCompareMap() {
		if (null != this.compareMap) {
			return this.compareMap;
		}
		ValueExpression _ve = getValueExpression("compareMap");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>compareMap</code> property.
	 * </p>
	 */
	public void setCompareMap(Object compareMap) {
		this.compareMap = compareMap;
		this.handleConfig("compareMap", compareMap);
	}

	private String dateFormat;

	/**
	 * The date format to return when using getValue.Defaults to 'm/d/Y'.
	 */
	public String getDateFormat() {
		if (null != this.dateFormat) {
			return this.dateFormat;
		}
		ValueExpression _ve = getValueExpression("dateFormat");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>dateFormat</code> property.
	 * </p>
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
		this.handleConfig("dateFormat", dateFormat);
	}

	private Date maxDate;

	/**
	 * Allowable date as passed to the Ext.DatePickerDefaults to undefined.
	 */
	public Date getMaxDate() {
		if (null != this.maxDate) {
			return this.maxDate;
		}
		ValueExpression _ve = getValueExpression("maxDate");
		if (_ve != null) {
			return (Date) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxDate</code> property.
	 * </p>
	 */
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
		this.handleConfig("maxDate", maxDate);
	}

	private Object menuItemCfgs;

	/**
	 * Default configuration options for each menuitem
	 */
	@ClientConfig(JsonMode.Object)
	public Object getMenuItemCfgs() {
		if (null != this.menuItemCfgs) {
			return this.menuItemCfgs;
		}
		ValueExpression _ve = getValueExpression("menuItemCfgs");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>menuItemCfgs</code> property.
	 * </p>
	 */
	public void setMenuItemCfgs(Object menuItemCfgs) {
		this.menuItemCfgs = menuItemCfgs;
		this.handleConfig("menuItemCfgs", menuItemCfgs);
	}

	private Object menuItems;

	/**
	 * The items to be shown in this menu Defaults to:
	 * 
	 * <pre>
	 * menuItems : ['before', 'after', '-', 'on'],
	 * </pre>
	 */
	@ClientConfig(JsonMode.Array)
	public Object getMenuItems() {
		if (null != this.menuItems) {
			return this.menuItems;
		}
		ValueExpression _ve = getValueExpression("menuItems");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>menuItems</code> property.
	 * </p>
	 */
	public void setMenuItems(Object menuItems) {
		this.menuItems = menuItems;
		this.handleConfig("menuItems", menuItems);
	}

	private Date minDate;

	/**
	 * Allowable date as passed to the Ext.DatePickerDefaults to undefined.
	 */
	public Date getMinDate() {
		if (null != this.minDate) {
			return this.minDate;
		}
		ValueExpression _ve = getValueExpression("minDate");
		if (_ve != null) {
			return (Date) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minDate</code> property.
	 * </p>
	 */
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
		this.handleConfig("minDate", minDate);
	}

	private String onText;

	/**
	 * Defaults to 'On'.
	 */
	public String getOnText() {
		if (null != this.onText) {
			return this.onText;
		}
		ValueExpression _ve = getValueExpression("onText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>onText</code> property.
	 * </p>
	 */
	public void setOnText(String onText) {
		this.onText = onText;
		this.handleConfig("onText", onText);
	}

	private Object pickerOpts;

	/**
	 * Configuration options for the date pickerassociated with each field.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getPickerOpts() {
		if (null != this.pickerOpts) {
			return this.pickerOpts;
		}
		ValueExpression _ve = getValueExpression("pickerOpts");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>pickerOpts</code> property.
	 * </p>
	 */
	public void setPickerOpts(Object pickerOpts) {
		this.pickerOpts = pickerOpts;
		this.handleConfig("pickerOpts", pickerOpts);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[11];
		}
		_values[0] = super.saveState(_context);
		_values[1] = afterText;
		_values[2] = beforeText;
		_values[3] = compareMap;
		_values[4] = dateFormat;
		_values[5] = maxDate;
		_values[6] = menuItemCfgs;
		_values[7] = menuItems;
		_values[8] = minDate;
		_values[9] = onText;
		_values[10] = pickerOpts;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.afterText = (String) _values[1];
		this.handleConfig("afterText", this.afterText);
		this.beforeText = (String) _values[2];
		this.handleConfig("beforeText", this.beforeText);
		this.compareMap = (Object) _values[3];
		this.handleConfig("compareMap", this.compareMap);
		this.dateFormat = (String) _values[4];
		this.handleConfig("dateFormat", this.dateFormat);
		this.maxDate = (Date) _values[5];
		this.handleConfig("maxDate", this.maxDate);
		this.menuItemCfgs = (Object) _values[6];
		this.handleConfig("menuItemCfgs", this.menuItemCfgs);
		this.menuItems = (Object) _values[7];
		this.handleConfig("menuItems", this.menuItems);
		this.minDate = (Date) _values[8];
		this.handleConfig("minDate", this.minDate);
		this.onText = (String) _values[9];
		this.handleConfig("onText", this.onText);
		this.pickerOpts = (Object) _values[10];
		this.handleConfig("pickerOpts", this.pickerOpts);

	}
}