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
 * A split button that provides a built-in
  dropdown arrow that can fire an event separately from the default
  click event of the button. Typically this would be used to
  display a dropdown menu that provides additional options to the
  primary button action, but any custom handler can provide the
  arrowclick implementation. Example usage: 


// display a dropdown menu:
new Ext.SplitButton({
        renderTo: 
'button-ct', 
// the container id
        text: 
'Options',
        handler: optionsHandler, 
// handle a click on the button itself
        menu: 
new Ext.menu.Menu({
        items: [
                
// these items will render as dropdown menu items when the arrow
is clicked:
                {text: 
'Item 1', handler: item1Handler},
                {text: 
'Item 2', handler: item2Handler}
        ]
        })
});

// Instead of showing a menu, you provide any type of custom
// functionality you want when the dropdown arrow is
clicked:
new Ext.SplitButton({
        renderTo: 
'button-ct',
        text: 
'Options',
        handler: optionsHandler,
        arrowHandler: myCustomHandler
});
  
 */
@XType("splitbutton")
@InstanceOf("Ext.SplitButton")

@FacesComponent(value = "Ext.SplitButton")
public class SplitButton extends Button {
	public static final String COMPONENT_FAMILY = "Ext.SplitButton";

	/**
	 * <p>
	 * Create a new {@link Ext.SplitButton} instance with default property values.
	 * </p>
	 */
	public SplitButton() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			arrowHandler
			,arrowTooltip
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
        
        
          arrowHandler
         : Function
        A function called when the arrow button
        is clicked (can be used instead of click event)
	 */
	@ClientConfig(JsonMode.Function)

	public Object getArrowHandler () {
		return (Object) getStateHelper().eval(PropertyKeys.arrowHandler);
	}

	/**
	 * <p>
	 * Set the value of the <code>arrowHandler</code> property.
	 * </p>
	 */
	public void setArrowHandler ( Object   arrowHandler ) {
		getStateHelper().put(PropertyKeys.arrowHandler, arrowHandler);
		handleAttribute("arrowHandler", arrowHandler);
	}
    	/*
	 *
        
        
          arrowTooltip
         : String
        The title attribute of the
        arrow
	 */
	
	public String getArrowTooltip () {
		return (String) getStateHelper().eval(PropertyKeys.arrowTooltip);
	}

	/**
	 * <p>
	 * Set the value of the <code>arrowTooltip</code> property.
	 * </p>
	 */
	public void setArrowTooltip ( String   arrowTooltip ) {
		getStateHelper().put(PropertyKeys.arrowTooltip, arrowTooltip);
		handleAttribute("arrowTooltip", arrowTooltip);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "arrowclick"
				));
				return superEvent;
	}
}