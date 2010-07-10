package ext.direct;

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
    Ext.direct.Provider is an abstract class meant to be
    extended.
    For example ExtJs implements the following subclasses:

Provider
|
+---
JsonProvider 
    |
    +---
PollingProvider   
    |
    +---
RemotingProvider
    
  
 */

@InstanceOf("Ext.direct.Provider")

@FacesComponent(value = "Ext.direct.Provider")
public class Provider extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.direct.Provider";

	/**
	 * <p>
	 * Create a new {@link Ext.direct.Provider} instance with default property values.
	 * </p>
	 */
	public Provider() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			type
			,priority
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
          Required, 
          undefined by default. The 
          type of provider specified to 
          Ext.Direct.
          addProvider to create a new
          Provider. Acceptable values by default are:
          
            
              
              
                polling
               : 
              PollingProvider
              
              
                remoting
               : 
              RemotingProvider
            
          
	 */
	
	public String getType () {
		return (String) getStateHelper().eval(PropertyKeys.type);
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType ( String   type ) {
		getStateHelper().put(PropertyKeys.type, type);
		handleAttribute("type", type);
	}
    	/*
	 *Priority of the request. Lower is
          higher priority, 
          0 means "duplex" (always on). All Providers
          default to 
          1 except for PollingProvider which defaults to 
          3.
	 */
	
	public Integer getPriority () {
		return (Integer) getStateHelper().eval(PropertyKeys.priority);
	}

	/**
	 * <p>
	 * Set the value of the <code>priority</code> property.
	 * </p>
	 */
	public void setPriority ( Integer   priority ) {
		getStateHelper().put(PropertyKeys.priority, priority);
		handleAttribute("priority", priority);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "connect"
					, "data"
					, "disconnect"
					, "exception"
				));
				return superEvent;
	}
}