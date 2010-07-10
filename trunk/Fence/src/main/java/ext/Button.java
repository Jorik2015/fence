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
 * Simple Button class
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
			clickEvent
			,iconAlign
			,arrowAlign
			,iconCls
			,tooltip
			,template
			,hidden
			,icon
			,scale
			,scope
			,menu
			,pressed
			,handler
			,toggleHandler
			,type
			,repeat
			,handleMouseEvents
			,allowDepress
			,disabled
			,cls
			,menuAlign
			,minWidth
			,tooltipType
			,enableToggle
			,text
			,overflowText
			,toggleGroup
			,tabIndex
			,buttonSelector
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
	 *The DOM event that will fire the
          handler of the button. This can be any valid event name
          (dblclick, contextmenu). Defaults to 
          'click'.
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
	 *
            (Optional) The side of the Button box to render the
            icon. Four values are allowed:
            
              'top'
              'right'
              'bottom'
              'left'
            
            Defaults to 
            
              'left'
            .
          
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
            (Optional) The side of the Button box to render the
            arrow if the button has an associated 
            menu. Two
            values are allowed:
            
              'right'
              'bottom'
            
            Defaults to 
            
              'right'
            .
          
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
	 *The tooltip for the button - can be a
          string to be used as innerHTML (html tags are accepted)
          or QuickTips config object
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
	 *
          A 
          Template used to create the
          Button's DOM structure.Instances, or subclasses which
          need a different DOM structure may provide a different
          template layout in conjunction with an implementation of 
          getTemplateArgs.
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
	 *The path to an image to display in the
          button (the image will be set as the background-image CSS
          property of the button by default, so if you want a mixed
          icon/text button, set cls:'x-btn-text-icon')
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
            (Optional) The size of the Button. Three values are
            allowed:
            
              'small'
              Results in the button element
              being 16px high.
              'medium'
              Results in the button element
              being 24px high.
              'large'
              Results in the button element
              being 32px high.
            
            Defaults to 
            
              'small'
            .
          
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
	 *Standard menu attribute consisting of a
          reference to a menu object, a menu id or a menu config
          blob (defaults to undefined).
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
	 *A function called when the button is
          clicked (can be used instead of click event). The handler
          is passed the following parameters:
          
            
              
              b : Button
              This Button.
              
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
	 *Function called when a Button with 
          enableToggle set to true is
          clicked. Two arguments are passed:
          
            
            button : Ext.Button
            this Button object
            
            state : Boolean
            The next state of the Button,
            true means pressed.
          
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
	 *True to repeat fire the click event
          while the mouse is down. This can also be a 
          ClickRepeater config
          object (defaults to false).
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
	 *If used in a 
          Toolbar, the text to be used if
          this item is shown in the overflow menu. See also 
          Ext.Toolbar.Item.
          
            overflowText
          .
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
	 *
            (Optional) A 
            DomQuery selector which is
            used to extract the active, clickable element from the
            DOM structure created.
            When a custom 
            template
            is used, you must ensure that this selector results in
            the selection of a focussable element.
            Defaults to 
            
              'button:first-child'
            .
          
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