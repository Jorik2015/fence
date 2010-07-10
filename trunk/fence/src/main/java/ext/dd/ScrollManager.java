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
 * 
    Provides automatic scrolling of overflow regions in the page
    during drag operations.
    The ScrollManager configs will be used as the defaults for
    any scroll container registered with it, but you can also
    override most of the configs per scroll container by adding a 
    ddScrollConfig object to the target element that
    contains these properties: 
    hthresh, 
    vthresh, 
    increment and 
    frequency. Example
    usage:


var el = Ext.get(
'scroll-ct');
el.ddScrollConfig = {
    vthresh: 50,
    hthresh: -1,
    frequency: 100,
    increment: 200
};
Ext.dd.ScrollManager.register(el);
    
    Note: This class uses "Point Mode" and is untested in
    "Intersect Mode".
    
    
    This class is a singleton and cannot be created
    directly.
  
 */

@InstanceOf("Ext.dd.ScrollManager")

@FacesComponent(value = "Ext.dd.ScrollManager")
public class ScrollManager extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.dd.ScrollManager";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.ScrollManager} instance with default property values.
	 * </p>
	 */
	public ScrollManager() {
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