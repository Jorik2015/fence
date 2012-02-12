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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">A base class for all menu items that
  require menu-related functionality (like sub-menus) and are not
  static display items. Item extends the base functionality of 
  <a ext:cls="Ext.menu.BaseItem" href="output/Ext.menu.BaseItem.html">Ext.menu.BaseItem</a> by adding
  menu-specific activation and click handling.</div>

 */
@XType("menuitem")
@InstanceOf("Ext.menu.Item")
@ParseConfigMode(name="items",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.menu.Item")
public class Item extends BaseItem {
	public static final String COMPONENT_FAMILY = "Ext.menu.Item";

	/**
	 * <p>
	 * Create a new {@link Ext.menu.Item} instance with default property values.
	 * </p>
	 */
	public Item() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			icon
			,hrefTarget
			,text
			,canActivate
			,showDelay
			,itemCls
			,menu
			,altText
			,href
			,iconCls
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The path to an icon to display in this
          item (defaults to Ext.BLANK_IMAGE_URL). If icon is
          specified 
          <a ext:cls="Ext.menu.Item" ext:member="iconCls" href="output/Ext.menu.Item.html#Ext.menu.Item-iconCls">iconCls</a>
          should not be.</div>

	 */
	
	public String getIcon () {
		return (String) getStateHelper().eval(PropertyKeys.icon);
	}

	/**
	 * <p>
	 * Set the value of the <code>icon</code> property.
	 * </p>
	 */
	public void setIcon ( String   icon ) {
		getStateHelper().put(PropertyKeys.icon, icon);
		handleAttribute("icon", icon);
	}
    	/*
	 *
        
        
          hrefTarget
         : String
        The target attribute to use for the
        underlying anchor link (defaults to '').
	 */
	
	public String getHrefTarget () {
		return (String) getStateHelper().eval(PropertyKeys.hrefTarget);
	}

	/**
	 * <p>
	 * Set the value of the <code>hrefTarget</code> property.
	 * </p>
	 */
	public void setHrefTarget ( String   hrefTarget ) {
		getStateHelper().put(PropertyKeys.hrefTarget, hrefTarget);
		handleAttribute("hrefTarget", hrefTarget);
	}
    	/*
	 *
        
        
          text
         : String
        The text to display in this item
        (defaults to '').
	 */
	
	public String getText () {
		return (String) getStateHelper().eval(PropertyKeys.text);
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText ( String   text ) {
		getStateHelper().put(PropertyKeys.text, text);
		handleAttribute("text", text);
	}
    	/*
	 *
        
        
          canActivate
         : Boolean
        True if this item can be visually
        activated (defaults to true)
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
        
        
          showDelay
         : Number
        Length of time in milliseconds to wait
        before showing this item (defaults to 200)
	 */
	
	public Integer getShowDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.showDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>showDelay</code> property.
	 * </p>
	 */
	public void setShowDelay ( Integer   showDelay ) {
		getStateHelper().put(PropertyKeys.showDelay, showDelay);
		handleAttribute("showDelay", showDelay);
	}
    	/*
	 *
        
        
          itemCls
         : String
        The default CSS class to use for menu
        items (defaults to 'x-menu-item')
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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Either an instance of 
          <a ext:cls="Ext.menu.Menu" href="output/Ext.menu.Menu.html">Ext.menu.Menu</a> or the config
          object for an 
          <a ext:cls="Ext.menu.Menu" href="output/Ext.menu.Menu.html">Ext.menu.Menu</a> which acts as
          the submenu when this item is activated.</div>

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
    	/*
	 *
        
        
          altText
         : String
        The altText to use for the icon, if it
        exists. Defaults to 
        ''.
	 */
	
	public String getAltText () {
		return (String) getStateHelper().eval(PropertyKeys.altText);
	}

	/**
	 * <p>
	 * Set the value of the <code>altText</code> property.
	 * </p>
	 */
	public void setAltText ( String   altText ) {
		getStateHelper().put(PropertyKeys.altText, altText);
		handleAttribute("altText", altText);
	}
    	/*
	 *
        
        
          href
         : String
        The href attribute to use for the
        underlying anchor link (defaults to '#').
	 */
	
	public String getHref () {
		return (String) getStateHelper().eval(PropertyKeys.href);
	}

	/**
	 * <p>
	 * Set the value of the <code>href</code> property.
	 * </p>
	 */
	public void setHref ( String   href ) {
		getStateHelper().put(PropertyKeys.href, href);
		handleAttribute("href", href);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A CSS class that specifies a background
          image that will be used as the icon for this item
          (defaults to ''). If iconCls is specified 
          <a ext:cls="Ext.menu.Item" ext:member="icon" href="output/Ext.menu.Item.html#Ext.menu.Item-icon">icon</a> should
          not be.</div>

	 */
	
	public String getIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.iconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>iconCls</code> property.
	 * </p>
	 */
	public void setIconCls ( String   iconCls ) {
		getStateHelper().put(PropertyKeys.iconCls, iconCls);
		handleAttribute("iconCls", iconCls);
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