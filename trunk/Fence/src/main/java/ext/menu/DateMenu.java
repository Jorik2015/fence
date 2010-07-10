package ext.menu;

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
 * 
    A menu containing an 
    Ext.DatePicker Component.
    Notes:
    
      
        Although not listed here, the 
        constructor for this class accepts all of the
        configuration options of 
        
          Ext.DatePicker
        .
        If subclassing DateMenu, any configuration options for
        the DatePicker must be applied to the 
        
          initialConfig
         property of the DateMenu. Applying 
        DatePicker configuration
        settings to 
        
          this
         will 
        not affect the DatePicker's configuration.
      
    
  
 */
@XType("datemenu")
@InstanceOf("Ext.menu.DateMenu")
@ParseConfigMode(name="menu",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.menu.DateMenu")
public class DateMenu extends Menu {
	public static final String COMPONENT_FAMILY = "Ext.menu.DateMenu";

	/**
	 * <p>
	 * Create a new {@link Ext.menu.DateMenu} instance with default property values.
	 * </p>
	 */
	public DateMenu() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			hideOnClick
			,handler
			,scope
			,pickerId
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
        
        
          hideOnClick
         : Boolean
        False to continue showing the menu after
        a date is selected, defaults to true.
	 */
	
	public Boolean getHideOnClick () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideOnClick);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideOnClick</code> property.
	 * </p>
	 */
	public void setHideOnClick ( Boolean   hideOnClick ) {
		getStateHelper().put(PropertyKeys.hideOnClick, hideOnClick);
		handleAttribute("hideOnClick", hideOnClick);
	}
    	/*
	 *Optional. A function that will handle
          the select event of this menu. The handler is passed the
          following parameters:
          
            
              
              picker : DatePicker
              The Ext.DatePicker.
              
              date : Date
              The selected date.
            
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getHandler () {
		return (Object) getStateHelper().eval(PropertyKeys.handler);
	}

	/**
	 * <p>
	 * Set the value of the <code>handler</code> property.
	 * </p>
	 */
	public void setHandler ( Object   handler ) {
		getStateHelper().put(PropertyKeys.handler, handler);
		handleAttribute("handler", handler);
	}
    	/*
	 *
        
        
          scope
         : Object
        The scope (
        
          this
         reference) in which the 
        
          handler
         function will be called. Defaults to this DateMenu
        instance.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getScope () {
		return (Object) getStateHelper().eval(PropertyKeys.scope);
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope ( Object   scope ) {
		getStateHelper().put(PropertyKeys.scope, scope);
		handleAttribute("scope", scope);
	}
    	/*
	 *
        
        
          pickerId
         : String
        An id to assign to the underlying date
        picker. Defaults to 
        null.
	 */
	
	public String getPickerId () {
		return (String) getStateHelper().eval(PropertyKeys.pickerId);
	}

	/**
	 * <p>
	 * Set the value of the <code>pickerId</code> property.
	 * </p>
	 */
	public void setPickerId ( String   pickerId ) {
		getStateHelper().put(PropertyKeys.pickerId, pickerId);
		handleAttribute("pickerId", pickerId);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "select"
				));
				return superEvent;
	}
}