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
 * Registers event handlers that want to
  receive a normalized EventObject instead of the standard browser
  event and provides several useful events directly. See 
  Ext.EventObject for more details on
  normalized event objects.
  
  
  This class is a singleton and cannot be created
  directly.
 */

@InstanceOf("Ext.EventManager")

@FacesComponent(value = "Ext.EventManager")
public class EventManager extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.EventManager";

	/**
	 * <p>
	 * Create a new {@link Ext.EventManager} instance with default property values.
	 * </p>
	 */
	public EventManager() {
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