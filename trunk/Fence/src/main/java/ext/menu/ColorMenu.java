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
  A menu containing a 
  Ext.ColorPalette Component.
  Notes:
  
    
      Although not listed here, the 
      constructor for this class accepts all of the
      configuration options of 
      
        Ext.ColorPalette
      .
      If subclassing ColorMenu, any configuration options for
      the ColorPalette must be applied to the 
      
        initialConfig
       property of the ColorMenu. Applying 
      ColorPalette configuration
      settings to 
      
        this
       will 
      not affect the ColorPalette's configuration.
    
  *
 */
@XType("colormenu")
@InstanceOf("Ext.menu.ColorMenu")
@ParseConfigMode(name="menu",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.menu.ColorMenu")
public class ColorMenu extends Menu {
	public static final String COMPONENT_FAMILY = "Ext.menu.ColorMenu";

	/**
	 * <p>
	 * Create a new {@link Ext.menu.ColorMenu} instance with default property values.
	 * </p>
	 */
	public ColorMenu() {
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
			,paletteId
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
        a color is selected, defaults to true.
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
          
            
              
              palette : ColorPalette
              The 
              Ext.ColorPalette.
              
              color : String
              The 6-digit color hex code
              (without the # symbol).
            
          
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
         function will be called. Defaults to this ColorMenu
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
        
        
          paletteId
         : String
        An id to assign to the underlying color
        palette. Defaults to 
        null.
	 */
	
	public String getPaletteId () {
		return (String) getStateHelper().eval(PropertyKeys.paletteId);
	}

	/**
	 * <p>
	 * Set the value of the <code>paletteId</code> property.
	 * </p>
	 */
	public void setPaletteId ( String   paletteId ) {
		getStateHelper().put(PropertyKeys.paletteId, paletteId);
		handleAttribute("paletteId", paletteId);
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