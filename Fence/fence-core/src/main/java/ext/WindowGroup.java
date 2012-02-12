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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">An object that manages a group of 
  <a ext:cls="Ext.Window" href="output/Ext.Window.html">Ext.Window</a> instances and provides
  z-order management and window activation behavior.</div>

 */

@InstanceOf("Ext.WindowGroup")

@FacesComponent(value = "Ext.WindowGroup")
public class WindowGroup extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.WindowGroup";

	/**
	 * <p>
	 * Create a new {@link Ext.WindowGroup} instance with default property values.
	 * </p>
	 */
	public WindowGroup() {
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