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
 * Adds a separator bar to a menu, used to
  divide logical groups of menu items. Generally you will add one
  of these by using "-" in you call to add() or in your items
  config rather than creating one directly.
 */
@XType("menuseparator")
@InstanceOf("Ext.menu.Separator")

@FacesComponent(value = "Ext.menu.Separator")
public class Separator extends BaseItem {
	public static final String COMPONENT_FAMILY = "Ext.menu.Separator";

	/**
	 * <p>
	 * Create a new {@link Ext.menu.Separator} instance with default property values.
	 * </p>
	 */
	public Separator() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			hideOnClick
			,itemCls
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
        True to hide the containing menu after
        this item is clicked (defaults to false)
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
	 *
        
        
          itemCls
         : String
        The default CSS class to use for
        separators (defaults to "x-menu-sep")
	 */
	
	public String getItemCls () {
		return (String) getStateHelper().eval(PropertyKeys.itemCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemCls</code> property.
	 * </p>
	 */
	public void setItemCls ( String   itemCls ) {
		getStateHelper().put(PropertyKeys.itemCls, itemCls);
		handleAttribute("itemCls", itemCls);
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