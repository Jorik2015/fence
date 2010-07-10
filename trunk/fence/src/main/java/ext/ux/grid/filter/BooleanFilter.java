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
 * Boolean filters use unique radio group
  IDs (so you can have more than one!) 
  
    
      Example Usage:
    
  


var filters = 
new Ext.ux.grid.GridFilters({
    ...
    filters: [{
        
// required configs

        type: 
'boolean',
        dataIndex: 
'visible'

        
// optional configs

        defaultValue: null, 
// leave unselected (false selected by 
default)

        yesText: 
'Yes',     
// 
default

        noText: 
'No'        
// 
default

    }]
});
  
 */

@InstanceOf("Ext.ux.grid.filter.BooleanFilter")
@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "BooleanFilter.js")
@ParseConfigMode(ui = false,name="filters",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.ux.grid.filter.BooleanFilter")
public class BooleanFilter extends Filter {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.filter.BooleanFilter";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.filter.BooleanFilter} instance with default property values.
	 * </p>
	 */
	public BooleanFilter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			noText
			,defaultValue
			,yesText
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
        
        
          noText
         : String
        Defaults to 'No'.
	 */
	
	public String getNoText () {
		return (String) getStateHelper().eval(PropertyKeys.noText);
	}

	/**
	 * <p>
	 * Set the value of the <code>noText</code> property.
	 * </p>
	 */
	public void setNoText ( String   noText ) {
		getStateHelper().put(PropertyKeys.noText, noText);
		handleAttribute("noText", noText);
	}
    	/*
	 *
        
        
          defaultValue
         : Boolean
        Set this to null if you do not want
        either option to be checked by default. Defaults to
        false.
	 */
	
	public Boolean getDefaultValue () {
		return (Boolean) getStateHelper().eval(PropertyKeys.defaultValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultValue</code> property.
	 * </p>
	 */
	public void setDefaultValue ( Boolean   defaultValue ) {
		getStateHelper().put(PropertyKeys.defaultValue, defaultValue);
		handleAttribute("defaultValue", defaultValue);
	}
    	/*
	 *
        
        
          yesText
         : String
        Defaults to 'Yes'.
	 */
	
	public String getYesText () {
		return (String) getStateHelper().eval(PropertyKeys.yesText);
	}

	/**
	 * <p>
	 * Set the value of the <code>yesText</code> property.
	 * </p>
	 */
	public void setYesText ( String   yesText ) {
		getStateHelper().put(PropertyKeys.yesText, yesText);
		handleAttribute("yesText", yesText);
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