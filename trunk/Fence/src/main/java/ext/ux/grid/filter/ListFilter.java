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
 * 
    List filters are able to be preloaded/backed by an
    Ext.data.Store to load their options the first time they are
    shown. ListFilter utilizes the 
    Ext.ux.menu.ListMenu
    component.
    Although not shown here, this class accepts all
    configuration options for 
    Ext.ux.menu.ListMenu.
    
      
        Example Usage:
      
    


var filters = 
new Ext.ux.grid.GridFilters({
    ...
    filters: [{
        type: 
'list',
        dataIndex: 
'size',
        phpMode: true,
        
// options will be used as data to implicitly creates an
ArrayStore

        options: [
'extra small', 
'small', 
'medium', 
'large', 
'extra large']
    }]
});
    
  
 */

@InstanceOf("Ext.ux.grid.filter.ListFilter")
@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "ListFilter.js")
@FacesComponent(value = "Ext.ux.grid.filter.ListFilter")
@ParseConfigMode(ui = false,name="filters",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
public class ListFilter extends Filter {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.filter.ListFilter";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.filter.ListFilter} instance with default property values.
	 * </p>
	 */
	public ListFilter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			store
			,phpMode
			,options
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
	 *The 
          Ext.data.Store this list
          should use as its data source when the data source is 
          remote. If the data for the list is local, use the
          
          
            options
           config instead.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getStore () {
		return (Object) getStateHelper().eval(PropertyKeys.store);
	}

	/**
	 * <p>
	 * Set the value of the <code>store</code> property.
	 * </p>
	 */
	public void setStore ( Object   store ) {
		getStateHelper().put(PropertyKeys.store, store);
		handleAttribute("store", store);
	}
    	/*
	 *
          Adjust the format of this filter. Defaults to
          false.
          
          When GridFilters 
          @cfg encode = false (default):


// phpMode == false (
default):

filter[0][data][type] list
filter[0][data][value] value1
filter[0][data][value] value2
filter[0][field] prod 

// phpMode == true:

filter[0][data][type] list
filter[0][data][value] value1, value2
filter[0][field] prod
          When GridFilters 
          @cfg encode = true: 


// phpMode == false (
default):

filter : [{
"type":
"list",
"value":[
"small",
"medium"],
"field":
"size"}]

// phpMode == true:

filter : [{
"type":
"list",
"value":
"small,medium",
"field":
"size"}]
          
	 */
	
	public Boolean getPhpMode () {
		return (Boolean) getStateHelper().eval(PropertyKeys.phpMode);
	}

	/**
	 * <p>
	 * Set the value of the <code>phpMode</code> property.
	 * </p>
	 */
	public void setPhpMode ( Boolean   phpMode ) {
		getStateHelper().put(PropertyKeys.phpMode, phpMode);
		handleAttribute("phpMode", phpMode);
	}
    	/*
	 *
            
            data to be used to implicitly create a
            data store to back this list when the data source is 
            local. If the data for the list is remote, use
            the 
            
              store
             config instead.
            
            Each item within the provided array may be in one of
            the following formats:
            
              
                
                Array : 

options: [
    [11, 
'extra small'], 
    [18, 
'small'],
    [22, 
'medium'],
    [35, 
'large'],
    [44, 
'extra large']
]
                
                
                Object : 

labelField: 
'name', 
// override 
default of 
'text'

options: [
    {id: 11, name:
'extra small'}, 
    {id: 18, name:
'small'}, 
    {id: 22, name:
'medium'}, 
    {id: 35, name:
'large'}, 
    {id: 44, name:
'extra large'} 
]
                
                
                String : 

options: [
'extra small', 
'small', 
'medium', 
'large', 
'extra large']
                
              
            
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getOptions () {
		return (Object) getStateHelper().eval(PropertyKeys.options);
	}

	/**
	 * <p>
	 * Set the value of the <code>options</code> property.
	 * </p>
	 */
	public void setOptions ( Object   options ) {
		getStateHelper().put(PropertyKeys.options, options);
		handleAttribute("options", options);
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