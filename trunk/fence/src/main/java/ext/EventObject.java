package ext;

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
import java.util.Date;

/**
 * Just as 
  Ext.Element wraps around a native DOM
  node, Ext.EventObject wraps the browser's native event-object
  normalizing cross-browser differences, such as which mouse button
  is clicked, keys pressed, mechanisms to stop event-propagation
  along with a method to prevent default actions from taking place.
  
  For example:


function handleClick(e, t){ 
// e is not a standard event object, it is a Ext.EventObject

    e.preventDefault();
    
var target = e.getTarget(); 
// same as t (the target HTMLElement)

    ...
}
var myDiv = 
Ext.get(
"myDiv");  
// get reference to an 
Ext.Element

myDiv.on(         
// 
'on' is shorthand 
for addListener

    
"click",      
// perform an action on click of myDiv

    handleClick   
// reference to the action handler

);
// other methods to 
do the same:

Ext.EventManager.on(
"myDiv", 
'click', handleClick);
Ext.EventManager.addListener(
"myDiv", 
'click', handleClick);
  
  
  
  This class is a singleton and cannot be created
  directly.
 */

@InstanceOf("Ext.EventObject")

@FacesComponent(value = "Ext.EventObject")
public class EventObject extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.EventObject";

	/**
	 * <p>
	 * Create a new {@link Ext.EventObject} instance with default property values.
	 * </p>
	 */
	public EventObject() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
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