package ext.updater;

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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>This class is a base class implementing a simple render
    method which updates an element using results from an Ajax
    request.</p>
    <p>The BasicRenderer updates the element's innerHTML with the
    responseText. To perform a custom render (i.e. XML or JSON
    processing), create an object with a conforming 
    <a ext:cls="Ext.Updater.BasicRenderer" ext:member="render" href="output/Ext.Updater.BasicRenderer.html#Ext.Updater.BasicRenderer-render">render</a> method and pass
    it to setRenderer on the Updater.</p>
  </div>

 */

@InstanceOf("Ext.Updater.BasicRenderer")

@FacesComponent(value = "Ext.Updater.BasicRenderer")
public class BasicRenderer extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.Updater.BasicRenderer";

	/**
	 * <p>
	 * Create a new {@link Ext.Updater.BasicRenderer} instance with default property values.
	 * </p>
	 */
	public BasicRenderer() {
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