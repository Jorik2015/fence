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
<div class="description">Simple Button class</div>

 */
@XType("button")
@InstanceOf("Ext.Button")

@FacesComponent(value = "Ext.Button")
public class Button extends HackButton {
	public static final String COMPONENT_FAMILY = "Ext.Button";

	/**
	 * <p>
	 * Create a new {@link Ext.Button} instance with default property values.
	 * </p>
	 */
	public Button() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			buttonSelector
			,scale
			,scope
			,minWidth
			,pressed
			,tabIndex
			,autoWidth
			,toggleGroup
			,repeat
			,type
			,iconCls
			,arrowAlign
			,handleMouseEvents
			,overflowText
			,allowDepress
			,template
			,icon
			,text
			,cls
			,menu
			,menuAlign
			,toggleHandler
			,tooltipType
			,enableToggle
			,clickEvent
			,iconAlign
			,hidden
			,disabled
			,tooltip
			,handler
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
<div class="long">
            <p>(Optional) A 
            <a ext:cls="Ext.DomQuery" href="output/Ext.DomQuery.html">DomQuery</a> selector which is
            used to extract the active, clickable element from the
            DOM structure created.</p>
            <p>When a custom 
            <a ext:cls="Ext.Button" ext:member="template" href="output/Ext.Button.html#Ext.Button-template">template</a>
            is used, you must ensure that this selector results in
            the selection of a focussable element.</p>
            <p>Defaults to 
            <b>
              <tt>'button:first-child'</tt>
            </b>.</p>
          </div>

	 */
	
	public String getButtonSelector () {
		return (String) getStateHelper().eval(PropertyKeys.buttonSelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonSelector</code> property.
	 * </p>
	 */
	public void setButtonSelector ( String   buttonSelector ) {
		getStateHelper().put(PropertyKeys.buttonSelector, buttonSelector);
		handleAttribute("buttonSelector", buttonSelector);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>(Optional) The size of the Button. Three values are
            allowed:</p>
            <ul class="mdetail-params">
              <li>'small'
              <div class="sub-desc">Results in the button element
              being 16px high.</div>
</li>
              <li>'medium'
              <div class="sub-desc">Results in the button element
              being 24px high.</div>
</li>
              <li>'large'
              <div class="sub-desc">Results in the button element
              being 32px high.</div>
</li>
            </ul>
            <p>Defaults to 
            <b>
              <tt>'small'</tt>
            </b>.</p>
          </div>

	 */
	
	public String getScale () {
		return (String) getStateHelper().eval(PropertyKeys.scale);
	}

	/**
	 * <p>
	 * Set the value of the <code>scale</code> property.
	 * </p>
	 */
	public void setScale ( String   scale ) {
		getStateHelper().put(PropertyKeys.scale, scale);
		handleAttribute("scale", scale);
	}
    	/*
	 *
        
        
          scope
         : Object
        The scope (
        
          this
         reference) in which the 
        
          handler
         and 
        
          toggleHandler
         is executed. Defaults to this Button.
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
        
        
          minWidth
         : Number
        The minimum width for this button (used
        to give a set of buttons a common width). See also 
        Ext.Panel.
        
          minButtonWidth
        .
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
        
        
          pressed
         : Boolean
        True to start pressed (only if
        enableToggle = true)
	 */
	
	public Boolean getPressed () {
		return (Boolean) getStateHelper().eval(PropertyKeys.pressed);
	}

	/**
	 * <p>
	 * Set the value of the <code>pressed</code> property.
	 * </p>
	 */
	public void setPressed ( Boolean   pressed ) {
		getStateHelper().put(PropertyKeys.pressed, pressed);
		handleAttribute("pressed", pressed);
	}
    	/*
	 *
        
        
          tabIndex
         : Number
        Set a DOM tabIndex for this button
        (defaults to undefined)
	 */
	
	public Integer getTabIndex () {
		return (Integer) getStateHelper().eval(PropertyKeys.tabIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>tabIndex</code> property.
	 * </p>
	 */
	public void setTabIndex ( Integer   tabIndex ) {
		getStateHelper().put(PropertyKeys.tabIndex, tabIndex);
		handleAttribute("tabIndex", tabIndex);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">By default, if a width is not specified
          the button will attempt to stretch horizontally to fit
          its content. If the button is being managed by a width
          sizing layout (hbox, fit, anchor), set this to false to
          prevent the button from doing this automatic sizing.
          Defaults to 
          <tt>undefined</tt>.</div>

	 */
	
	public Boolean getAutoWidth () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoWidth</code> property.
	 * </p>
	 */
	public void setAutoWidth ( Boolean   autoWidth ) {
		getStateHelper().put(PropertyKeys.autoWidth, autoWidth);
		handleAttribute("autoWidth", autoWidth);
	}
    	/*
	 *
        
        
          toggleGroup
         : String
        The group this toggle button is a member
        of (only 1 per group can be pressed)
	 */
	
	public String getToggleGroup () {
		return (String) getStateHelper().eval(PropertyKeys.toggleGroup);
	}

	/**
	 * <p>
	 * Set the value of the <code>toggleGroup</code> property.
	 * </p>
	 */
	public void setToggleGroup ( String   toggleGroup ) {
		getStateHelper().put(PropertyKeys.toggleGroup, toggleGroup);
		handleAttribute("toggleGroup", toggleGroup);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to repeat fire the click event
          while the mouse is down. This can also be a 
          <a ext:cls="Ext.util.ClickRepeater" href="output/Ext.util.ClickRepeater.html">ClickRepeater</a> config
          object (defaults to false).</div>

	 */
	
	public Boolean getRepeat () {
		return (Boolean) getStateHelper().eval(PropertyKeys.repeat);
	}

	/**
	 * <p>
	 * Set the value of the <code>repeat</code> property.
	 * </p>
	 */
	public void setRepeat ( Boolean   repeat ) {
		getStateHelper().put(PropertyKeys.repeat, repeat);
		handleAttribute("repeat", repeat);
	}
    	/*
	 *
        
        
          type
         : String
        submit, reset or button - defaults to
        'button'
	 */
	
	public String getType () {
		return (String) getStateHelper().eval(PropertyKeys.type);
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType ( String   type ) {
		getStateHelper().put(PropertyKeys.type, type);
		handleAttribute("type", type);
	}
    	/*
	 *
        
        
          iconCls
         : String
        A css class which sets a background
        image to be used as the icon for this button
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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>(Optional) The side of the Button box to render the
            arrow if the button has an associated 
            <a ext:cls="Ext.Button" ext:member="menu" href="output/Ext.Button.html#Ext.Button-menu">menu</a>. Two
            values are allowed:</p>
            <ul class="mdetail-params">
              <li>'right'</li>
              <li>'bottom'</li>
            </ul>
            <p>Defaults to 
            <b>
              <tt>'right'</tt>
            </b>.</p>
          </div>

	 */
	
	public String getArrowAlign () {
		return (String) getStateHelper().eval(PropertyKeys.arrowAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>arrowAlign</code> property.
	 * </p>
	 */
	public void setArrowAlign ( String   arrowAlign ) {
		getStateHelper().put(PropertyKeys.arrowAlign, arrowAlign);
		handleAttribute("arrowAlign", arrowAlign);
	}
    	/*
	 *
        
        
          handleMouseEvents
         : Boolean
        False to disable visual cues on
        mouseover, mouseout and mousedown (defaults to
        true)
	 */
	
	public Boolean getHandleMouseEvents () {
		return (Boolean) getStateHelper().eval(PropertyKeys.handleMouseEvents);
	}

	/**
	 * <p>
	 * Set the value of the <code>handleMouseEvents</code> property.
	 * </p>
	 */
	public void setHandleMouseEvents ( Boolean   handleMouseEvents ) {
		getStateHelper().put(PropertyKeys.handleMouseEvents, handleMouseEvents);
		handleAttribute("handleMouseEvents", handleMouseEvents);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If used in a 
          <a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Toolbar</a>, the text to be used if
          this item is shown in the overflow menu. See also 
          <a ext:cls="Ext.Toolbar.Item" href="output/Ext.Toolbar.Item.html">Ext.Toolbar.Item</a>.
          <code>
            <a ext:cls="Ext.Toolbar.Item" ext:member="overflowText" href="output/Ext.Toolbar.Item.html#Ext.Toolbar.Item-overflowText">overflowText</a>
          </code>.</div>

	 */
	
	public String getOverflowText () {
		return (String) getStateHelper().eval(PropertyKeys.overflowText);
	}

	/**
	 * <p>
	 * Set the value of the <code>overflowText</code> property.
	 * </p>
	 */
	public void setOverflowText ( String   overflowText ) {
		getStateHelper().put(PropertyKeys.overflowText, overflowText);
		handleAttribute("overflowText", overflowText);
	}
    	/*
	 *
        
        
          allowDepress
         : Boolean
        False to not allow a pressed Button to
        be depressed (defaults to undefined). Only valid when 
        enableToggle is true.
	 */
	
	public Boolean getAllowDepress () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowDepress);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDepress</code> property.
	 * </p>
	 */
	public void setAllowDepress ( Boolean   allowDepress ) {
		getStateHelper().put(PropertyKeys.allowDepress, allowDepress);
		handleAttribute("allowDepress", allowDepress);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>A 
          <a ext:cls="Ext.Template" href="output/Ext.Template.html">Template</a> used to create the
          Button's DOM structure.</p>Instances, or subclasses which
          need a different DOM structure may provide a different
          template layout in conjunction with an implementation of 
          <a ext:cls="Ext.Button" ext:member="getTemplateArgs" href="output/Ext.Button.html#Ext.Button-getTemplateArgs">getTemplateArgs</a>.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getTemplate () {
		return (Object) getStateHelper().eval(PropertyKeys.template);
	}

	/**
	 * <p>
	 * Set the value of the <code>template</code> property.
	 * </p>
	 */
	public void setTemplate ( Object   template ) {
		getStateHelper().put(PropertyKeys.template, template);
		handleAttribute("template", template);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The path to an image to display in the
          button (the image will be set as the background-image CSS
          property of the button by default, so if you want a mixed
          icon/text button, set cls:'x-btn-text-icon')</div>

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
        
        
          text
         : String
        The button text to be used as innerHTML
        (html tags are accepted)
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
        
        
          cls
         : String
        A CSS class string to apply to the
        button's main element.
	 */
	
	public String getCls () {
		return (String) getStateHelper().eval(PropertyKeys.cls);
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls ( String   cls ) {
		getStateHelper().put(PropertyKeys.cls, cls);
		handleAttribute("cls", cls);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Standard menu attribute consisting of a
          reference to a menu object, a menu id or a menu config
          blob (defaults to undefined).</div>

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
        
        
          menuAlign
         : String
        The position to align the menu to (see 
        Ext.Element.alignTo for more
        details, defaults to 'tl-bl?').
	 */
	
	public String getMenuAlign () {
		return (String) getStateHelper().eval(PropertyKeys.menuAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>menuAlign</code> property.
	 * </p>
	 */
	public void setMenuAlign ( String   menuAlign ) {
		getStateHelper().put(PropertyKeys.menuAlign, menuAlign);
		handleAttribute("menuAlign", menuAlign);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Function called when a Button with 
          <a ext:cls="Ext.Button" ext:member="enableToggle" href="output/Ext.Button.html#Ext.Button-enableToggle">enableToggle</a> set to true is
          clicked. Two arguments are passed:
          <ul class="mdetail-params">
            <li>
            <b>button</b> : Ext.Button
            <div class="sub-desc">this Button object</div>
</li>
            <li>
            <b>state</b> : Boolean
            <div class="sub-desc">The next state of the Button,
            true means pressed.</div>
</li>
          </ul>
</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getToggleHandler () {
		return (Object) getStateHelper().eval(PropertyKeys.toggleHandler);
	}

	/**
	 * <p>
	 * Set the value of the <code>toggleHandler</code> property.
	 * </p>
	 */
	public void setToggleHandler ( Object   toggleHandler ) {
		getStateHelper().put(PropertyKeys.toggleHandler, toggleHandler);
		handleAttribute("toggleHandler", toggleHandler);
	}
    	/*
	 *
        
        
          tooltipType
         : String
        The type of tooltip to use. Either
        'qtip' (default) for QuickTips or 'title' for title
        attribute.
	 */
	
	public String getTooltipType () {
		return (String) getStateHelper().eval(PropertyKeys.tooltipType);
	}

	/**
	 * <p>
	 * Set the value of the <code>tooltipType</code> property.
	 * </p>
	 */
	public void setTooltipType ( String   tooltipType ) {
		getStateHelper().put(PropertyKeys.tooltipType, tooltipType);
		handleAttribute("tooltipType", tooltipType);
	}
    	/*
	 *
        
        
          enableToggle
         : Boolean
        True to enable pressed/not pressed
        toggling (defaults to false)
	 */
	
	public Boolean getEnableToggle () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableToggle);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableToggle</code> property.
	 * </p>
	 */
	public void setEnableToggle ( Boolean   enableToggle ) {
		getStateHelper().put(PropertyKeys.enableToggle, enableToggle);
		handleAttribute("enableToggle", enableToggle);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The DOM event that will fire the
          handler of the button. This can be any valid event name
          (dblclick, contextmenu). Defaults to 
          <tt>'click'</tt>.</div>

	 */
	
	public String getClickEvent () {
		return (String) getStateHelper().eval(PropertyKeys.clickEvent);
	}

	/**
	 * <p>
	 * Set the value of the <code>clickEvent</code> property.
	 * </p>
	 */
	public void setClickEvent ( String   clickEvent ) {
		getStateHelper().put(PropertyKeys.clickEvent, clickEvent);
		handleAttribute("clickEvent", clickEvent);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>(Optional) The side of the Button box to render the
            icon. Four values are allowed:</p>
            <ul class="mdetail-params">
              <li>'top'</li>
              <li>'right'</li>
              <li>'bottom'</li>
              <li>'left'</li>
            </ul>
            <p>Defaults to 
            <b>
              <tt>'left'</tt>
            </b>.</p>
          </div>

	 */
	
	public String getIconAlign () {
		return (String) getStateHelper().eval(PropertyKeys.iconAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>iconAlign</code> property.
	 * </p>
	 */
	public void setIconAlign ( String   iconAlign ) {
		getStateHelper().put(PropertyKeys.iconAlign, iconAlign);
		handleAttribute("iconAlign", iconAlign);
	}
    	/*
	 *
        
        
          hidden
         : Boolean
        True to start hidden (defaults to
        false)
	 */
	
	public Boolean getHidden () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hidden);
	}

	/**
	 * <p>
	 * Set the value of the <code>hidden</code> property.
	 * </p>
	 */
	public void setHidden ( Boolean   hidden ) {
		getStateHelper().put(PropertyKeys.hidden, hidden);
		handleAttribute("hidden", hidden);
	}
    	/*
	 *
        
        
          disabled
         : Boolean
        True to start disabled (defaults to
        false)
	 */
	
	public Boolean getDisabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setDisabled ( Boolean   disabled ) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
		handleAttribute("disabled", disabled);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The tooltip for the button - can be a
          string to be used as innerHTML (html tags are accepted)
          or QuickTips config object</div>

	 */
	
	public String getTooltip () {
		return (String) getStateHelper().eval(PropertyKeys.tooltip);
	}

	/**
	 * <p>
	 * Set the value of the <code>tooltip</code> property.
	 * </p>
	 */
	public void setTooltip ( String   tooltip ) {
		getStateHelper().put(PropertyKeys.tooltip, tooltip);
		handleAttribute("tooltip", tooltip);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A function called when the button is
          clicked (can be used instead of click event). The handler
          is passed the following parameters:
          <div class="mdetail-params">
            <ul>
              <li>
              <code>b</code> : Button
              <div class="sub-desc">This Button.</div>
</li>
              <li>
              <code>e</code> : EventObject
              <div class="sub-desc">The click event.</div>
</li>
            </ul>
          </div>
</div>

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
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "click"
					, "menuhide"
					, "menushow"
					, "menutriggerout"
					, "menutriggerover"
					, "mouseout"
					, "mouseover"
					, "toggle"
				));
				return superEvent;
	}
}