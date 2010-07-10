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
 * Filter by a configurable
  Ext.form.TextField 
  
    
      Example Usage:
    
  


var filters = 
new Ext.ux.grid.GridFilters({
    ...
    filters: [{
        
// required configs

        type: 
'string',
        dataIndex: 
'name',
        
        
// optional configs

        value: 
'foo',
        active: true, 
// 
default is false

        iconCls: 
'ux-gridfilter-text-icon' 
// 
default

        
// any Ext.form.TextField configs accepted

    }]
});
  
 */

@InstanceOf("Ext.ux.grid.filter.StringFilter")
@ParseConfigMode(ui = false,name="filters",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "StringFilter.js")
@FacesComponent(value = "Ext.ux.grid.filter.StringFilter")
public class StringFilter extends Filter {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.filter.StringFilter";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.filter.StringFilter} instance with default property values.
	 * </p>
	 */
	public StringFilter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			iconCls
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
        
        
          iconCls
         : String
        The iconCls to be applied to the menu
        item. Defaults to 
        'ux-gridfilter-text-icon'.
	 */
	
	public String getIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.iconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>iconCls</code> property.
	 * </p>
	 */
	public void setIconCls ( String   iconCls ) {
		getStateHelper().put(PropertyKeys.iconCls, iconCls);
		handleAttribute("iconCls", iconCls);
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