package ext.ux.grid.filter;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import ext.*;
import ext.dd.*;
import ext.util.*;
import ext.data.*;
import ext.grid.*;
import ext.form.*;
import ext.tree.*;
import ext.layout.*;
import ext.menu.*;
import java.util.*;
import ext.form.Action;
import java.util.Date;

/**
 * Filter by a configurable Ext.menu.DateMenu
 * 
 * 
 * Example Usage:
 * 
 * 
 * 
 * 
 * var filters = new Ext.ux.grid.GridFilters({ ... filters: [{
 * 
 * // required configs
 * 
 * type: 'date', dataIndex: 'dateAdded',
 * 
 * 
 * // optional configs
 * 
 * dateFormat: 'm/d/Y', // default
 * 
 * beforeText: 'Before', // default
 * 
 * afterText: 'After', // default
 * 
 * onText: 'On', // default
 * 
 * pickerOpts: {
 * 
 * // any DateMenu configs
 * 
 * },
 * 
 * active: true // default is false
 * 
 * }] });
 */

@InstanceOf("Ext.ux.grid.filter.DateFilter")
@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "DateFilter.js")
@FacesComponent(value = "Ext.ux.grid.filter.DateFilter")
@ParseConfigMode(ui = false,name="filters",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
public class DateFilter extends Filter {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.filter.DateFilter";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.filter.DateFilter} instance with default property values.
	 * </p>
	 */
	public DateFilter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	enum PropertyKeys {
		maxDate, afterText, dateFormat, pickerOpts, menuItemCfgs, compareMap, menuItems, beforeText, onText, minDate;
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

	/*
	 * 
	 * 
	 * 
	 * maxDate : Date Allowable date as passed to the Ext.DatePicker Defaults to undefined.
	 */

	public Date getMaxDate() {
		return (Date) getStateHelper().eval(PropertyKeys.maxDate);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxDate</code> property.
	 * </p>
	 */
	public void setMaxDate(Date maxDate) {
		getStateHelper().put(PropertyKeys.maxDate, maxDate);
		handleAttribute("maxDate", maxDate);
	}

	/*
	 * 
	 * 
	 * 
	 * afterText : String Defaults to 'After'.
	 */

	public String getAfterText() {
		return (String) getStateHelper().eval(PropertyKeys.afterText);
	}

	/**
	 * <p>
	 * Set the value of the <code>afterText</code> property.
	 * </p>
	 */
	public void setAfterText(String afterText) {
		getStateHelper().put(PropertyKeys.afterText, afterText);
		handleAttribute("afterText", afterText);
	}

	/*
	 * 
	 * 
	 * 
	 * dateFormat : String The date format to return when using getValue. Defaults to 'm/d/Y'.
	 */

	public String getDateFormat() {
		return (String) getStateHelper().eval(PropertyKeys.dateFormat);
	}

	/**
	 * <p>
	 * Set the value of the <code>dateFormat</code> property.
	 * </p>
	 */
	public void setDateFormat(String dateFormat) {
		getStateHelper().put(PropertyKeys.dateFormat, dateFormat);
		handleAttribute("dateFormat", dateFormat);
	}

	/*
	 * 
	 * 
	 * 
	 * pickerOpts : Object Configuration options for the date picker associated with each field.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getPickerOpts() {
		return (Object) getStateHelper().eval(PropertyKeys.pickerOpts);
	}

	/**
	 * <p>
	 * Set the value of the <code>pickerOpts</code> property.
	 * </p>
	 */
	public void setPickerOpts(Object pickerOpts) {
		getStateHelper().put(PropertyKeys.pickerOpts, pickerOpts);
		handleAttribute("pickerOpts", pickerOpts);
	}

	/*
	 * 
	 * 
	 * 
	 * menuItemCfgs : Object Default configuration options for each menu item
	 */
	@ClientConfig(JsonMode.Object)
	public Object getMenuItemCfgs() {
		return (Object) getStateHelper().eval(PropertyKeys.menuItemCfgs);
	}

	/**
	 * <p>
	 * Set the value of the <code>menuItemCfgs</code> property.
	 * </p>
	 */
	public void setMenuItemCfgs(Object menuItemCfgs) {
		getStateHelper().put(PropertyKeys.menuItemCfgs, menuItemCfgs);
		handleAttribute("menuItemCfgs", menuItemCfgs);
	}

	/*
	 * 
	 * 
	 * 
	 * compareMap : Object Map for assigning the comparison values used in serialization.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getCompareMap() {
		return (Object) getStateHelper().eval(PropertyKeys.compareMap);
	}

	/**
	 * <p>
	 * Set the value of the <code>compareMap</code> property.
	 * </p>
	 */
	public void setCompareMap(Object compareMap) {
		getStateHelper().put(PropertyKeys.compareMap, compareMap);
		handleAttribute("compareMap", compareMap);
	}

	/*
	 * 
	 * 
	 * 
	 * menuItems : Array The items to be shown in this menu Defaults to:
	 * 
	 * menuItems : ['before', 'after', '-', 'on'],
	 */
	@ClientConfig(JsonMode.Array)
	public Object getMenuItems() {
		return (Object) getStateHelper().eval(PropertyKeys.menuItems);
	}

	/**
	 * <p>
	 * Set the value of the <code>menuItems</code> property.
	 * </p>
	 */
	public void setMenuItems(Object menuItems) {
		getStateHelper().put(PropertyKeys.menuItems, menuItems);
		handleAttribute("menuItems", menuItems);
	}

	/*
	 * 
	 * 
	 * 
	 * beforeText : String Defaults to 'Before'.
	 */

	public String getBeforeText() {
		return (String) getStateHelper().eval(PropertyKeys.beforeText);
	}

	/**
	 * <p>
	 * Set the value of the <code>beforeText</code> property.
	 * </p>
	 */
	public void setBeforeText(String beforeText) {
		getStateHelper().put(PropertyKeys.beforeText, beforeText);
		handleAttribute("beforeText", beforeText);
	}

	/*
	 * 
	 * 
	 * 
	 * onText : String Defaults to 'On'.
	 */

	public String getOnText() {
		return (String) getStateHelper().eval(PropertyKeys.onText);
	}

	/**
	 * <p>
	 * Set the value of the <code>onText</code> property.
	 * </p>
	 */
	public void setOnText(String onText) {
		getStateHelper().put(PropertyKeys.onText, onText);
		handleAttribute("onText", onText);
	}

	/*
	 * 
	 * 
	 * 
	 * minDate : Date Allowable date as passed to the Ext.DatePicker Defaults to undefined.
	 */

	public Date getMinDate() {
		return (Date) getStateHelper().eval(PropertyKeys.minDate);
	}

	/**
	 * <p>
	 * Set the value of the <code>minDate</code> property.
	 * </p>
	 */
	public void setMinDate(Date minDate) {
		getStateHelper().put(PropertyKeys.minDate, minDate);
		handleAttribute("minDate", minDate);
	}

	@Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
		return superEvent;
	}
}