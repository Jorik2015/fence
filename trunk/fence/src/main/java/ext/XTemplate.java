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
 * 
  A template class that supports advanced functionality
  like:
  
    
      Autofilling arrays using templates and sub-templates
      Conditional processing with basic comparison
      operators
      Basic math function support
      Execute arbitrary inline code with special built-in
      template variables
      Custom member functions
      Many special tags and built-in operators that aren't
      defined as part of the API, but are supported in the
      templates that can be created
    
  
  
   
  XTemplate provides the templating mechanism built into:
  
    
      
        Ext.DataView
      
      
        Ext.ListView
      
      
        Ext.form.ComboBox
      
      
        Ext.grid.TemplateColumn
      
      
        Ext.grid.GroupingView
      
      
        Ext.menu.Item
      
      
        Ext.layout.MenuLayout
      
      
        Ext.ColorPalette
      
    
  
  
   
  For example usage 
  see the
  constructor.
 */

@InstanceOf("Ext.XTemplate")

@FacesComponent(value = "Ext.XTemplate")
public class XTemplate extends Template {
	public static final String COMPONENT_FAMILY = "Ext.XTemplate";

	/**
	 * <p>
	 * Create a new {@link Ext.XTemplate} instance with default property values.
	 * </p>
	 */
	public XTemplate() {
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