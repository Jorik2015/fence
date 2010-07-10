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
 * Filters using an Ext.ux.menu.RangeMenu. 
  
    
      Example Usage:
    
  


var filters = 
new Ext.ux.grid.GridFilters({
    ...
    filters: [{
        type: 
'numeric',
        dataIndex: 
'price'
    }]
});
  
 */

@InstanceOf("Ext.ux.grid.filter.NumericFilter")
@ParseConfigMode(ui = false,name="filters",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "NumericFilter.js")
@FacesComponent(value = "Ext.ux.grid.filter.NumericFilter")
public class NumericFilter extends Filter {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.filter.NumericFilter";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.filter.NumericFilter} instance with default property values.
	 * </p>
	 */
	public NumericFilter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			fieldCls
			,fieldCfg
			,iconCls
			,fields
			,menuItemCfgs
			,menuItems
		;
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
        
        
          fieldCls
         : Object
        The Class to use to construct each field
        item within this menu Defaults to:

fieldCls : Ext.form.NumberField
        
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFieldCls () {
		return (Object) getStateHelper().eval(PropertyKeys.fieldCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldCls</code> property.
	 * </p>
	 */
	public void setFieldCls ( Object   fieldCls ) {
		getStateHelper().put(PropertyKeys.fieldCls, fieldCls);
		handleAttribute("fieldCls", fieldCls);
	}
    	/*
	 *The default configuration options for
          any field item unless superseded by the 
          
            fields
           configuration. Defaults to:

fieldCfg : {}
          Example usage: 

fieldCfg : {
    width: 150,
},
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFieldCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.fieldCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldCfg</code> property.
	 * </p>
	 */
	public void setFieldCfg ( Object   fieldCfg ) {
		getStateHelper().put(PropertyKeys.fieldCfg, fieldCfg);
		handleAttribute("fieldCfg", fieldCfg);
	}
    	/*
	 *The iconCls to be applied to each
          comparator field item. Defaults to:

iconCls : {
    gt : 'ux-rangemenu-gt',
    lt : 'ux-rangemenu-lt',
    eq : 'ux-rangemenu-eq'
}
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getIconCls () {
		return (Object) getStateHelper().eval(PropertyKeys.iconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>iconCls</code> property.
	 * </p>
	 */
	public void setIconCls ( Object   iconCls ) {
		getStateHelper().put(PropertyKeys.iconCls, iconCls);
		handleAttribute("iconCls", iconCls);
	}
    	/*
	 *The field items may be configured
          individually Defaults to 
          undefined. Example usage: 

fields : {
    gt: { 
// override fieldCfg options

        width: 200,
        fieldCls: Ext.ux.form.CustomNumberField 
// to override 
default 
fieldCls

    }
},
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFields () {
		return (Object) getStateHelper().eval(PropertyKeys.fields);
	}

	/**
	 * <p>
	 * Set the value of the <code>fields</code> property.
	 * </p>
	 */
	public void setFields ( Object   fields ) {
		getStateHelper().put(PropertyKeys.fields, fields);
		handleAttribute("fields", fields);
	}
    	/*
	 *Default configuration options for each
          menu item Defaults to:

menuItemCfgs : {
    emptyText: 'Enter Filter Text...',
    selectOnFocus: true,
    width: 125
}
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getMenuItemCfgs () {
		return (Object) getStateHelper().eval(PropertyKeys.menuItemCfgs);
	}

	/**
	 * <p>
	 * Set the value of the <code>menuItemCfgs</code> property.
	 * </p>
	 */
	public void setMenuItemCfgs ( Object   menuItemCfgs ) {
		getStateHelper().put(PropertyKeys.menuItemCfgs, menuItemCfgs);
		handleAttribute("menuItemCfgs", menuItemCfgs);
	}
    	/*
	 *The items to be shown in this menu.
          Items are added to the menu according to their position
          within this array. Defaults to:

menuItems : ['lt','gt','-','eq']
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getMenuItems () {
		return (Object) getStateHelper().eval(PropertyKeys.menuItems);
	}

	/**
	 * <p>
	 * Set the value of the <code>menuItems</code> property.
	 * </p>
	 */
	public void setMenuItems ( Object   menuItems ) {
		getStateHelper().put(PropertyKeys.menuItems, menuItems);
		handleAttribute("menuItems", menuItems);
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