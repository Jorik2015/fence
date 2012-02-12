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
<div class="description">
    <p>A menu object. This is the container to which you may add
    menu items. Menu can also serve as a base class when you want a
    specialized menu based off of another component (like 
    <a ext:cls="Ext.menu.DateMenu" href="output/Ext.menu.DateMenu.html">Ext.menu.DateMenu</a> for
    example).</p>
    <p>Menus may contain either 
    <a ext:cls="Ext.menu.Item" href="output/Ext.menu.Item.html">menu items</a>, or general 
    <a ext:cls="Ext.Component" href="output/Ext.Component.html">Component</a>s.</p>
    <p>To make a contained general 
    <a ext:cls="Ext.Component" href="output/Ext.Component.html">Component</a> line up with other 
    <a ext:cls="Ext.menu.Item" href="output/Ext.menu.Item.html">menu items</a> specify 
    <tt>iconCls: 'no-icon'</tt>. This reserves a space for an icon,
    and indents the Component in line with the other menu items.
    See 
    <a ext:cls="Ext.form.ComboBox" href="output/Ext.form.ComboBox.html">Ext.form.ComboBox</a>.
    <a ext:cls="Ext.form.ComboBox" ext:member="getListParent" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-getListParent">getListParent</a> for an
    example.</p>
    <p>By default, Menus are absolutely positioned, floating
    Components. By configuring a Menu with 
    <b>
      <tt>
      <a ext:cls="Ext.menu.Menu" ext:member="floating" href="output/Ext.menu.Menu.html#Ext.menu.Menu-floating">floating</a>:false</tt>
    </b>, a Menu may be used as child of a Container.</p>
  </div>

 */
@XType("menu")
@InstanceOf("Ext.menu.Menu")
@ParseConfigMode(name="menu",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.menu.Menu")
public class Menu extends Container {
	public static final String COMPONENT_FAMILY = "Ext.menu.Menu";

	/**
	 * <p>
	 * Create a new {@link Ext.menu.Menu} instance with default property values.
	 * </p>
	 */
	public Menu() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			allowOtherMenus
			,showSeparator
			,defaultOffsets
			,zIndex
			,enableScrolling
			,minWidth
			,subMenuAlign
			,defaults
			,ignoreParentClicks
			,items
			,shadow
			,scrollIncrement
			,layout
			,floating
			,maxHeight
			,plain
			,defaultAlign
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
        
        
          allowOtherMenus
         : Boolean
        True to allow multiple menus to be
        displayed at the same time (defaults to false)
	 */
	
	public Boolean getAllowOtherMenus () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowOtherMenus);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowOtherMenus</code> property.
	 * </p>
	 */
	public void setAllowOtherMenus ( Boolean   allowOtherMenus ) {
		getStateHelper().put(PropertyKeys.allowOtherMenus, allowOtherMenus);
		handleAttribute("allowOtherMenus", allowOtherMenus);
	}
    	/*
	 *
        
        
          showSeparator
         : Boolean
        True to show the icon separator.
        (defaults to true).
	 */
	
	public Boolean getShowSeparator () {
		return (Boolean) getStateHelper().eval(PropertyKeys.showSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>showSeparator</code> property.
	 * </p>
	 */
	public void setShowSeparator ( Boolean   showSeparator ) {
		getStateHelper().put(PropertyKeys.showSeparator, showSeparator);
		handleAttribute("showSeparator", showSeparator);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array specifying the [x, y] offset
          in pixels by which to change the default Menu popup
          position after aligning according to the 
          <a ext:cls="Ext.menu.Menu" ext:member="defaultAlign" href="output/Ext.menu.Menu.html#Ext.menu.Menu-defaultAlign">defaultAlign</a> configuration.
          Defaults to 
          <tt>[0, 0]</tt>.</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getDefaultOffsets () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultOffsets);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultOffsets</code> property.
	 * </p>
	 */
	public void setDefaultOffsets ( Object   defaultOffsets ) {
		getStateHelper().put(PropertyKeys.defaultOffsets, defaultOffsets);
		handleAttribute("defaultOffsets", defaultOffsets);
	}
    	/*
	 *
        
        
          zIndex
         : Number
        zIndex to use when the menu is
        floating.
	 */
	
	public Integer getZIndex () {
		return (Integer) getStateHelper().eval(PropertyKeys.zIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>zIndex</code> property.
	 * </p>
	 */
	public void setZIndex ( Integer   zIndex ) {
		getStateHelper().put(PropertyKeys.zIndex, zIndex);
		handleAttribute("zIndex", zIndex);
	}
    	/*
	 *
        
        
          enableScrolling
         : Boolean
        True to allow the menu container to have
        scroller controls if the menu is too long (defaults to
        true).
	 */
	
	public Boolean getEnableScrolling () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableScrolling);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableScrolling</code> property.
	 * </p>
	 */
	public void setEnableScrolling ( Boolean   enableScrolling ) {
		getStateHelper().put(PropertyKeys.enableScrolling, enableScrolling);
		handleAttribute("enableScrolling", enableScrolling);
	}
    	/*
	 *
        
        
          minWidth
         : Number
        The minimum width of the menu in pixels
        (defaults to 120)
	 */
	
	public Integer getMinWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth ( Integer   minWidth ) {
		getStateHelper().put(PropertyKeys.minWidth, minWidth);
		handleAttribute("minWidth", minWidth);
	}
    	/*
	 *
        
        
          subMenuAlign
         : String
        The 
        Ext.Element.alignTo anchor
        position value to use for submenus of this menu (defaults
        to 'tl-tr?')
	 */
	
	public String getSubMenuAlign () {
		return (String) getStateHelper().eval(PropertyKeys.subMenuAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>subMenuAlign</code> property.
	 * </p>
	 */
	public void setSubMenuAlign ( String   subMenuAlign ) {
		getStateHelper().put(PropertyKeys.subMenuAlign, subMenuAlign);
		handleAttribute("subMenuAlign", subMenuAlign);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A config object that will be applied to
          all items added to this container either via the 
          <a ext:cls="Ext.menu.Menu" ext:member="items" href="output/Ext.menu.Menu.html#Ext.menu.Menu-items">items</a>
          config or via the 
          <a ext:cls="Ext.menu.Menu" ext:member="add" href="output/Ext.menu.Menu.html#Ext.menu.Menu-add">add</a> method.
          The defaults config can contain any number of name/value
          property pairs to be added to each item, and should be
          valid for the types of items being added to the
          menu.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaults () {
		return (Object) getStateHelper().eval(PropertyKeys.defaults);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaults</code> property.
	 * </p>
	 */
	public void setDefaults ( Object   defaults ) {
		getStateHelper().put(PropertyKeys.defaults, defaults);
		handleAttribute("defaults", defaults);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to ignore clicks on any item in
          this menu that is a parent item (displays a submenu) so
          that the submenu is not dismissed when clicking the
          parent item (defaults to false).</div>

	 */
	
	public Boolean getIgnoreParentClicks () {
		return (Boolean) getStateHelper().eval(PropertyKeys.ignoreParentClicks);
	}

	/**
	 * <p>
	 * Set the value of the <code>ignoreParentClicks</code> property.
	 * </p>
	 */
	public void setIgnoreParentClicks ( Boolean   ignoreParentClicks ) {
		getStateHelper().put(PropertyKeys.ignoreParentClicks, ignoreParentClicks);
		handleAttribute("ignoreParentClicks", ignoreParentClicks);
	}
    	/*
	 *
        
        
          items
         : Mixed
        An array of items to be added to this
        menu. Menus may contain either 
        menu items, or general 
        Components.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getItems () {
		return (Object) getStateHelper().eval(PropertyKeys.items);
	}

	/**
	 * <p>
	 * Set the value of the <code>items</code> property.
	 * </p>
	 */
	public void setItems ( Object   items ) {
		getStateHelper().put(PropertyKeys.items, items);
		handleAttribute("items", items);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True or 'sides' for the default effect,
          'frame' for 4-way shadow, and 'drop' for bottom-right
          shadow (defaults to 'sides')</div>

	 */
	
	public Boolean getShadow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.shadow);
	}

	/**
	 * <p>
	 * Set the value of the <code>shadow</code> property.
	 * </p>
	 */
	public void setShadow ( Boolean   shadow ) {
		getStateHelper().put(PropertyKeys.shadow, shadow);
		handleAttribute("shadow", shadow);
	}
    	/*
	 *
        
        
          scrollIncrement
         : Number
        The amount to scroll the menu. Only
        applies when enableScrolling is set to True (defaults to
        24).
	 */
	
	public Integer getScrollIncrement () {
		return (Integer) getStateHelper().eval(PropertyKeys.scrollIncrement);
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollIncrement</code> property.
	 * </p>
	 */
	public void setScrollIncrement ( Integer   scrollIncrement ) {
		getStateHelper().put(PropertyKeys.scrollIncrement, scrollIncrement);
		handleAttribute("scrollIncrement", scrollIncrement);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">This class assigns a default layout (
          <code>layout:
          <em>'
          <b>menu</b>'</em>
</code>). Developers 
          <i>may</i> override this configuration option if another
          layout is required. See 
          <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">Ext.Container.layout</a> for
          additional information.</div>

	 */
	
	public String getLayout () {
		return (String) getStateHelper().eval(PropertyKeys.layout);
	}

	/**
	 * <p>
	 * Set the value of the <code>layout</code> property.
	 * </p>
	 */
	public void setLayout ( String   layout ) {
		getStateHelper().put(PropertyKeys.layout, layout);
		handleAttribute("layout", layout);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>By default, a Menu configured as 
            <b>
              <code>floating:true</code>
            </b> will be rendered as an 
            <a ext:cls="Ext.Layer" href="output/Ext.Layer.html">Ext.Layer</a> (an absolutely
            positioned, floating Component with zindex=15000). If
            configured as 
            <b>
              <code>floating:false</code>
            </b>, the Menu may be used as child item of another
            Container instead of a free-floating 
            <a ext:cls="Ext.Layer" href="output/Ext.Layer.html">Layer</a>.</p>
          </div>

	 */
	
	public Boolean getFloating () {
		return (Boolean) getStateHelper().eval(PropertyKeys.floating);
	}

	/**
	 * <p>
	 * Set the value of the <code>floating</code> property.
	 * </p>
	 */
	public void setFloating ( Boolean   floating ) {
		getStateHelper().put(PropertyKeys.floating, floating);
		handleAttribute("floating", floating);
	}
    	/*
	 *
        
        
          maxHeight
         : Number
        The maximum height of the menu. Only
        applies when enableScrolling is set to True (defaults to
        null).
	 */
	
	public Integer getMaxHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxHeight</code> property.
	 * </p>
	 */
	public void setMaxHeight ( Integer   maxHeight ) {
		getStateHelper().put(PropertyKeys.maxHeight, maxHeight);
		handleAttribute("maxHeight", maxHeight);
	}
    	/*
	 *
        
        
          plain
         : Boolean
        True to remove the incised line down the
        left side of the menu. Defaults to 
        false.
	 */
	
	public Boolean getPlain () {
		return (Boolean) getStateHelper().eval(PropertyKeys.plain);
	}

	/**
	 * <p>
	 * Set the value of the <code>plain</code> property.
	 * </p>
	 */
	public void setPlain ( Boolean   plain ) {
		getStateHelper().put(PropertyKeys.plain, plain);
		handleAttribute("plain", plain);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The default 
          <a ext:cls="Ext.Element" ext:member="alignTo" href="output/Ext.Element.html#Ext.Element-alignTo">Ext.Element.alignTo</a> anchor
          position value for this menu relative to its element of
          origin (defaults to 'tl-bl?')</div>

	 */
	
	public String getDefaultAlign () {
		return (String) getStateHelper().eval(PropertyKeys.defaultAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultAlign</code> property.
	 * </p>
	 */
	public void setDefaultAlign ( String   defaultAlign ) {
		getStateHelper().put(PropertyKeys.defaultAlign, defaultAlign);
		handleAttribute("defaultAlign", defaultAlign);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "click"
					, "itemclick"
					, "mouseout"
					, "mouseover"
				));
				return superEvent;
	}
}