package ext.ux.menu;

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
 * Custom implementation of Ext.menu.Menu
  that has preconfigured items for gt, lt, eq. 
  
    
      Example Usage:
    
  
 */

@InstanceOf("Ext.ux.menu.RangeMenu")

@FacesComponent(value = "Ext.ux.menu.RangeMenu")
public class RangeMenu extends Menu {
	public static final String COMPONENT_FAMILY = "Ext.ux.menu.RangeMenu";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.menu.RangeMenu} instance with default property values.
	 * </p>
	 */
	public RangeMenu() {
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
				superEvent.addAll(Arrays.asList(
					 "update"
				));
				return superEvent;
	}
}