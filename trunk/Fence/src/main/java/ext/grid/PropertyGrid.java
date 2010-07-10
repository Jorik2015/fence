package ext.grid;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

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
 * A specialized grid implementation
  intended to mimic the traditional property grid as typically seen
  in development IDEs. Each row in the grid represents a property
  of some object, and the data is stored as a set of name/value
  pairs in 
  Ext.grid.PropertyRecords.
  Example usage: 


var grid = 
new Ext.grid.PropertyGrid({
    title: 
'Properties Grid',
    autoHeight: true,
    width: 300,
    renderTo: 
'grid-ct',
    source: {
        
"(name)": 
"My Object",
        
"Created": 
new Date(Date.parse(
'10/15/2006')),
        
"Available": false,
        
"Version": .01,
        
"Description": 
"A test object"
    }
});
  
 */
@XType("propertygrid")
@InstanceOf("Ext.grid.PropertyGrid")

@FacesComponent(value = "Ext.grid.PropertyGrid")
public class PropertyGrid extends EditorGridPanel {
	public static final String COMPONENT_FAMILY = "Ext.grid.PropertyGrid";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PropertyGrid} instance with default property values.
	 * </p>
	 */
	public PropertyGrid() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			propertyNames
			,customEditors
			,customRenderers
			,source
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
	 *An object containing property
          name/display name pairs. If specified, the display name
          will be shown in the name column instead of the property
          name.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getPropertyNames () {
		return (Object) getStateHelper().eval(PropertyKeys.propertyNames);
	}

	/**
	 * <p>
	 * Set the value of the <code>propertyNames</code> property.
	 * </p>
	 */
	public void setPropertyNames ( Object   propertyNames ) {
		getStateHelper().put(PropertyKeys.propertyNames, propertyNames);
		handleAttribute("propertyNames", propertyNames);
	}
    	/*
	 *An object containing name/value pairs
          of custom editor type definitions that allow the grid to
          support additional types of editable fields. By default,
          the grid supports strongly-typed editing of strings,
          dates, numbers and booleans using built-in form editors,
          but any custom type can be supported and associated with
          a custom input control by specifying a custom editor. The
          name of the editor type should correspond with the name
          of the property that will use the editor. Example usage: 


var grid = 
new Ext.grid.PropertyGrid({
    ...
    customEditors: {
        
'Start Time': 
new Ext.grid.GridEditor(
new Ext.form.TimeField({selectOnFocus:true}))
    },
    source: {
        
'Start Time': 
'10:00 AM'
    }
});
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getCustomEditors () {
		return (Object) getStateHelper().eval(PropertyKeys.customEditors);
	}

	/**
	 * <p>
	 * Set the value of the <code>customEditors</code> property.
	 * </p>
	 */
	public void setCustomEditors ( Object   customEditors ) {
		getStateHelper().put(PropertyKeys.customEditors, customEditors);
		handleAttribute("customEditors", customEditors);
	}
    	/*
	 *An object containing name/value pairs
          of custom renderer type definitions that allow the grid
          to support custom rendering of fields. By default, the
          grid supports strongly-typed rendering of strings, dates,
          numbers and booleans using built-in form editors, but any
          custom type can be supported and associated with the type
          of the value. The name of the renderer type should
          correspond with the name of the property that it will
          render. Example usage: 


var grid = 
new Ext.grid.PropertyGrid({
    ...
    customRenderers: {
        Available: 
function(v){
            
if(v){
                
return 
'
"color: green;">Yes';
            }
else{
                
return 
'
"color: red;">No';
            }
        }
    },
    source: {
        Available: true
    }
});
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getCustomRenderers () {
		return (Object) getStateHelper().eval(PropertyKeys.customRenderers);
	}

	/**
	 * <p>
	 * Set the value of the <code>customRenderers</code> property.
	 * </p>
	 */
	public void setCustomRenderers ( Object   customRenderers ) {
		getStateHelper().put(PropertyKeys.customRenderers, customRenderers);
		handleAttribute("customRenderers", customRenderers);
	}
    	/*
	 *
        
        
          source
         : Object
        A data object to use as the data source
        of the grid (see 
        setSource for
        details).
	 */
	@ClientConfig(JsonMode.Object)

	public Object getSource () {
		return (Object) getStateHelper().eval(PropertyKeys.source);
	}

	/**
	 * <p>
	 * Set the value of the <code>source</code> property.
	 * </p>
	 */
	public void setSource ( Object   source ) {
		getStateHelper().put(PropertyKeys.source, source);
		handleAttribute("source", source);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforepropertychange"
					, "propertychange"
				));
				return superEvent;
	}
}