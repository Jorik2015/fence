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
 * The base class for all items that render
  into menus. BaseItem provides default rendering, activated state
  management and base configuration options shared by all menu
  components.
 */
@XType("menubaseitem")
@InstanceOf("Ext.menu.BaseItem")
@ParseConfigMode(name="items",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.menu.BaseItem")
public class BaseItem extends ExtCommand {
	public static final String COMPONENT_FAMILY = "Ext.menu.BaseItem";

	/**
	 * <p>
	 * Create a new {@link Ext.menu.BaseItem} instance with default property values.
	 * </p>
	 */
	public BaseItem() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			canActivate
			,activeClass
			,hideOnClick
			,handler
			,scope
			,clickHideDelay
			,menu
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
        
        
          canActivate
         : Boolean
        True if this item can be visually
        activated (defaults to false)
	 */
	
	public Boolean getCanActivate () {
		return (Boolean) getStateHelper().eval(PropertyKeys.canActivate);
	}

	/**
	 * <p>
	 * Set the value of the <code>canActivate</code> property.
	 * </p>
	 */
	public void setCanActivate ( Boolean   canActivate ) {
		getStateHelper().put(PropertyKeys.canActivate, canActivate);
		handleAttribute("canActivate", canActivate);
	}
    	/*
	 *
        
        
          activeClass
         : String
        The CSS class to use when the item
        becomes activated (defaults to
        "x-menu-item-active")
	 */
	
	public String getActiveClass () {
		return (String) getStateHelper().eval(PropertyKeys.activeClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>activeClass</code> property.
	 * </p>
	 */
	public void setActiveClass ( String   activeClass ) {
		getStateHelper().put(PropertyKeys.activeClass, activeClass);
		handleAttribute("activeClass", activeClass);
	}
    	/*
	 *
        
        
          hideOnClick
         : Boolean
        True to hide the containing menu after
        this item is clicked (defaults to true)
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
	 *A function that will handle the click
          event of this menu item (optional). The handler is passed
          the following parameters:
          
            
              
              b : Item
              This menu Item.
              
              e : EventObject
              The click event.
            
          
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
         reference) in which the handler function will be
        called.
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
        
        
          clickHideDelay
         : Number
        Length of time in milliseconds to wait
        before hiding after a click (defaults to 1)
	 */
	
	public Integer getClickHideDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.clickHideDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>clickHideDelay</code> property.
	 * </p>
	 */
	public void setClickHideDelay ( Integer   clickHideDelay ) {
		getStateHelper().put(PropertyKeys.clickHideDelay, clickHideDelay);
		handleAttribute("clickHideDelay", clickHideDelay);
	}
    	/*
	 *$cfg.commonts
	 */
	@ClientConfig(JsonMode.Object)
	public Object getMenu () {
		return (Object) getStateHelper().eval(PropertyKeys.menu);
	}

	/**
	 * <p>
	 * Set the value of the <code>menu</code> property.
	 * </p>
	 */
	public void setMenu ( Object   menu ) {
		getStateHelper().put(PropertyKeys.menu, menu);
		handleAttribute("menu", menu);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "activate"
					, "click"
					, "deactivate"
				));
				return superEvent;
	}
}