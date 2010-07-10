package ext.dd;

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
 * A specialized drag proxy that supports a
  drop status icon, 
  Ext.Layer
  styles and auto-repair. This is the default drag proxy used by
  all Ext.dd components.
 */

@InstanceOf("Ext.dd.StatusProxy")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.dd.StatusProxy")
public class StatusProxy extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.dd.StatusProxy";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.StatusProxy} instance with default property values.
	 * </p>
	 */
	public StatusProxy() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			dropNotAllowed
			,dropAllowed
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
        
        
          dropNotAllowed
         : String
        The CSS class to apply to the status
        element when drop is not allowed (defaults to
        "x-dd-drop-nodrop").
	 */
	
	public String getDropNotAllowed () {
		return (String) getStateHelper().eval(PropertyKeys.dropNotAllowed);
	}

	/**
	 * <p>
	 * Set the value of the <code>dropNotAllowed</code> property.
	 * </p>
	 */
	public void setDropNotAllowed ( String   dropNotAllowed ) {
		getStateHelper().put(PropertyKeys.dropNotAllowed, dropNotAllowed);
		handleAttribute("dropNotAllowed", dropNotAllowed);
	}
    	/*
	 *
        
        
          dropAllowed
         : String
        The CSS class to apply to the status
        element when drop is allowed (defaults to
        "x-dd-drop-ok").
	 */
	
	public String getDropAllowed () {
		return (String) getStateHelper().eval(PropertyKeys.dropAllowed);
	}

	/**
	 * <p>
	 * Set the value of the <code>dropAllowed</code> property.
	 * </p>
	 */
	public void setDropAllowed ( String   dropAllowed ) {
		getStateHelper().put(PropertyKeys.dropAllowed, dropAllowed);
		handleAttribute("dropAllowed", dropAllowed);
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