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
    Base class for all Ext components. All subclasses of
    Component may participate in the automated Ext component
    lifecycle of creation, rendering and destruction which is
    provided by the 
    Container class. Components may be
    added to a Container through the 
    items config
    option at the time the Container is created, or they may be
    added dynamically via the 
    add method.
    The Component base class has built-in support for basic
    hide/show and enable/disable behavior.
    All Components are registered with the 
    Ext.ComponentMgr on construction
    so that they can be referenced at any time via 
    Ext.getCmp, passing the 
    id.
    All user-developed visual widgets that are required to
    participate in automated lifecycle and size management should
    subclass Component (or 
    Ext.BoxComponent if managed box
    model handling is required, ie height and width
    management).
    See the 
    Creating
    new UI controls tutorial for details on how and to either
    extend or augment ExtJs base classes to create custom
    Components.
    Every component has a specific xtype, which is its
    Ext-specific type name, along with methods for checking the
    xtype like 
    getXType and 
    isXType. This
    is the list of all valid xtypes:

xtype            Class
-------------    ------------------
box              
Ext.BoxComponent
button           
Ext.Button
buttongroup      
Ext.ButtonGroup
colorpalette     
Ext.ColorPalette
component        
Ext.Component
container        
Ext.Container
cycle            
Ext.CycleButton
dataview         
Ext.DataView
datepicker       
Ext.DatePicker
editor           
Ext.Editor
editorgrid       
Ext.grid.EditorGridPanel
flash            
Ext.FlashComponent
grid             
Ext.grid.GridPanel
listview         
Ext.ListView
panel            
Ext.Panel
progress         
Ext.ProgressBar
propertygrid     
Ext.grid.PropertyGrid
slider           
Ext.Slider
spacer           
Ext.Spacer
splitbutton      
Ext.SplitButton
tabpanel         
Ext.TabPanel
treepanel        
Ext.tree.TreePanel
viewport         
Ext.ViewPort
window           
Ext.Window

Toolbar components
---------------------------------------
paging           
Ext.PagingToolbar
toolbar          
Ext.Toolbar
tbbutton         
Ext.Toolbar.Button       
(deprecated; use button)
tbfill           
Ext.Toolbar.Fill
tbitem           
Ext.Toolbar.Item
tbseparator      
Ext.Toolbar.Separator
tbspacer         
Ext.Toolbar.Spacer
tbsplit          
Ext.Toolbar.SplitButton  
(deprecated; use splitbutton)
tbtext           
Ext.Toolbar.TextItem

Menu components
---------------------------------------
menu             
Ext.menu.Menu
colormenu        
Ext.menu.ColorMenu
datemenu         
Ext.menu.DateMenu
menubaseitem     
Ext.menu.BaseItem
menucheckitem    
Ext.menu.CheckItem
menuitem         
Ext.menu.Item
menuseparator    
Ext.menu.Separator
menutextitem     
Ext.menu.TextItem

Form components
---------------------------------------
form             
Ext.form.FormPanel
checkbox         
Ext.form.Checkbox
checkboxgroup    
Ext.form.CheckboxGroup
combo            
Ext.form.ComboBox
datefield        
Ext.form.DateField
displayfield     
Ext.form.DisplayField
field            
Ext.form.Field
fieldset         
Ext.form.FieldSet
hidden           
Ext.form.Hidden
htmleditor       
Ext.form.HtmlEditor
label            
Ext.form.Label
numberfield      
Ext.form.NumberField
radio            
Ext.form.Radio
radiogroup       
Ext.form.RadioGroup
textarea         
Ext.form.TextArea
textfield        
Ext.form.TextField
timefield        
Ext.form.TimeField
trigger          
Ext.form.TriggerField

Chart components
---------------------------------------
chart            
Ext.chart.Chart
barchart         
Ext.chart.BarChart
cartesianchart   
Ext.chart.CartesianChart
columnchart      
Ext.chart.ColumnChart
linechart        
Ext.chart.LineChart
piechart         
Ext.chart.PieChart

Store xtypes
---------------------------------------
arraystore       
Ext.data.ArrayStore
directstore      
Ext.data.DirectStore
groupingstore    
Ext.data.GroupingStore
jsonstore        
Ext.data.JsonStore
simplestore      
Ext.data.SimpleStore     
(deprecated; use arraystore)
store            
Ext.data.Store
xmlstore         
Ext.data.XmlStore
    
  
 */
@XType("component")
@InstanceOf("Ext.Component")

@FacesComponent(value = "Ext.Component")
public class Component extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.Component";

	/**
	 * <p>
	 * Create a new {@link Ext.Component} instance with default property values.
	 * </p>
	 */
	public Component() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			autoEl
			,html
			,labelSeparator
			,itemId
			,ptype
			,itemCls
			,applyTo
			,autoShow
			,stateful
			,fieldLabel
			,hidden
			,style
			,renderTo
			,plugins
			,stateId
			,stateEvents
			,hideMode
			,disabledClass
			,disabled
			,allowDomMove
			,cls
			,hideLabel
			,hideParent
			,tpl
			,tplWriteMode
			,ref
			,overCls
			,clearCls
			,bubbleEvents
			,data
			,contentEl
			,xtype
			,ctCls
			,labelStyle
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
            A tag name or 
            DomHelper spec used to
            create the 
            Element
            which will encapsulate this Component.
            You do not normally need to specify this. For the
            base classes 
            Ext.Component, 
            Ext.BoxComponent, and 
            Ext.Container, this
            defaults to 
            
              'div'
            . The more complex Ext classes use a more complex
            DOM structure created by their own onRender
            methods.
            This is intended to allow the developer to create
            application-specific utility Components encapsulated by
            different DOM elements. Example usage:

{
    xtype: 
'box',
    autoEl: {
        tag: 
'img',
        src: 
'http:
//www.example.com/example.jpg'
    }
}, {
    xtype: 
'box',
    autoEl: {
        tag: 
'blockquote',
        html: 
'autoEl is cool!'
    }
}, {
    xtype: 
'container',
    autoEl: 
'ul',
    cls: 
'ux-unordered-list',
    items: {
        xtype: 
'box',
        autoEl: 
'li',
        html: 
'First list item'
    }
}
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getAutoEl () {
		return (Object) getStateHelper().eval(PropertyKeys.autoEl);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoEl</code> property.
	 * </p>
	 */
	public void setAutoEl ( Object   autoEl ) {
		getStateHelper().put(PropertyKeys.autoEl, autoEl);
		handleAttribute("autoEl", autoEl);
	}
    	/*
	 *An HTML fragment, or a 
          DomHelper specification to
          use as the layout element content (defaults to ''). The
          HTML content is added after the component is rendered, so
          the document will not contain this HTML at the time the 
          render
          event is fired. This content is inserted into the body 
          before any configured 
          contentEl is appended.
	 */
	
	public String getHtml () {
		return (String) getStateHelper().eval(PropertyKeys.html);
	}

	/**
	 * <p>
	 * Set the value of the <code>html</code> property.
	 * </p>
	 */
	public void setHtml ( String   html ) {
		getStateHelper().put(PropertyKeys.html, html);
		handleAttribute("html", html);
	}
    	/*
	 *
          The separator to display after the text of each 
          
            fieldLabel
          . This property may be configured at various levels.
          The order of precedence is:
          
            
              field / component level
              container level
              
              layout level
              (defaults to colon 
              ':')
            
          To display no separator for this field's label
          specify empty string ''.
          
          
          
          
          Note: see the note for 
          
            clearCls
          .
          
          Also see 
          
            hideLabel
           and 
          Ext.layout.FormLayout.
          fieldTpl.Example
          use:


new Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    layoutConfig: {
        labelSeparator: 
'~'   
// layout config has lowest priority (defaults to 
':')
    },
    
labelSeparator: 
'>>',     
// config at container level
    items: [{
        xtype: 
'textfield',
        fieldLabel: 
'Field 1',
        labelSeparator: 
'...' 
// field/component level config supersedes others
    },{
        xtype: 
'textfield',
        fieldLabel: 
'Field 2' 
// labelSeparator will be 
'='
    }]
});
          
	 */
	
	public String getLabelSeparator () {
		return (String) getStateHelper().eval(PropertyKeys.labelSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelSeparator</code> property.
	 * </p>
	 */
	public void setLabelSeparator ( String   labelSeparator ) {
		getStateHelper().put(PropertyKeys.labelSeparator, labelSeparator);
		handleAttribute("labelSeparator", labelSeparator);
	}
    	/*
	 *
            An 
            itemId can be used as an alternative way to
            get a reference to a component when no object reference
            is available. Instead of using an 
            
              id
             with 
            Ext.
            getCmp, use 
            itemId with 
            Ext.Container.
            getComponent which will
            retrieve 
            itemId's or 
            
              id
            's. Since 
            itemId's are an index to the container's
            internal MixedCollection, the 
            itemId is scoped locally to the container
            -- avoiding potential conflicts with 
            Ext.ComponentMgr which
            requires a 
            unique 
            
              id
            .


var c = 
new Ext.Panel({ 
//
    
height: 300,
    
renderTo:
document.body,
    
layout: 
'auto',
    
items: [
        {
            itemId: 
'p1',
            
title: 
'Panel 1',
            
height: 150
        },
        {
            itemId: 
'p2',
            
title: 
'Panel 2',
            
height: 150
        }
    ]
})
p1 = c.
getComponent(
'p1'); 
// not the same as 
Ext.getCmp()
p2 = p1.
ownerCt.
getComponent(
'p2'); 
// reference via a sibling
            
            Also see 
            
              id
             and 
            
              ref
            .
            
            Note: to access the container of an item see 
            
              ownerCt
            .
          
	 */
	
	public String getItemId () {
		return (String) getStateHelper().eval(PropertyKeys.itemId);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemId</code> property.
	 * </p>
	 */
	public void setItemId ( String   itemId ) {
		getStateHelper().put(PropertyKeys.itemId, itemId);
		handleAttribute("itemId", itemId);
	}
    	/*
	 *The registered 
          ptype to create. This config option is not used
          when passing a config object into a constructor. This
          config option is used only when lazy instantiation is
          being used, and a Plugin is being specified not as a
          fully instantiated Component, but as a 
          Component config object. The 
          ptype will be looked up at render time up to
          determine what type of Plugin to create.
          
          If you create your own Plugins, you may register
          them using 
          Ext.ComponentMgr.registerPlugin
          in order to be able to take advantage of lazy
          instantiation and rendering.
	 */
	
	public String getPtype () {
		return (String) getStateHelper().eval(PropertyKeys.ptype);
	}

	/**
	 * <p>
	 * Set the value of the <code>ptype</code> property.
	 * </p>
	 */
	public void setPtype ( String   ptype ) {
		getStateHelper().put(PropertyKeys.ptype, ptype);
		handleAttribute("ptype", ptype);
	}
    	/*
	 *
          
          Note: this config is only used when this Component
          is rendered by a Container which has been configured to
          use the 
          
            FormLayout
           layout manager (e.g. 
          Ext.form.FormPanel or
          specifying 
          layout:'form').
          
          An additional CSS class to apply to the div wrapping
          the form item element of this field. If supplied, 
          itemCls at the 
          field level will override the default 
          itemCls supplied at the 
          container level. The value specified for 
          itemCls will be added to the default class (
          'x-form-item').
          Since it is applied to the item wrapper (see 
          Ext.layout.FormLayout.
          fieldTpl), it allows
          you to write standard CSS rules that can apply to the
          field, the label (if specified), or any other element
          within the markup for the field.
          
          
          Note: see the note for 
          
            fieldLabel
          .
          Example use:


// Apply a style to the field's 
label:
<style>
    .required .x-form-item-
label {font-weight:bold;color:red;}
</style>

new Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
'textfield',
        fieldLabel: 
'Name',
        itemCls: 
'required' 
//this 
label will be styled
    },{
        xtype: 
'textfield',
        fieldLabel: 
'Favorite Color'
    }]
});
          
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
	 *
            Specify the id of the element, a DOM element or an
            existing Element corresponding to a DIV that is already
            present in the document that specifies some structural
            markup for this component.
            
              
                
                Description : 
                
                  When 
                  applyTo is used, constituent parts of
                  the component can also be specified by id or CSS
                  class name within the main element, and the
                  component being created may attempt to create its
                  subcomponents from that markup if
                  applicable.
                
                
                Notes : 
                
                  When using this config, a
                  call to render() is not required.
                  If applyTo is specified,
                  any value passed for 
                  renderTo will be
                  ignored and the target element's parent node will
                  automatically be used as the component's
                  container.
                
              
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getApplyTo () {
		return (Object) getStateHelper().eval(PropertyKeys.applyTo);
	}

	/**
	 * <p>
	 * Set the value of the <code>applyTo</code> property.
	 * </p>
	 */
	public void setApplyTo ( Object   applyTo ) {
		getStateHelper().put(PropertyKeys.applyTo, applyTo);
		handleAttribute("applyTo", applyTo);
	}
    	/*
	 *True if the component should check for
          hidden classes (e.g. 'x-hidden' or 'x-hide-display') and
          remove them on render (defaults to false).
	 */
	
	public Boolean getAutoShow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoShow);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoShow</code> property.
	 * </p>
	 */
	public void setAutoShow ( Boolean   autoShow ) {
		getStateHelper().put(PropertyKeys.autoShow, autoShow);
		handleAttribute("autoShow", autoShow);
	}
    	/*
	 *
            A flag which causes the Component to attempt to
            restore the state of internal properties from a saved
            state on startup. The component must have either a 
            
              stateId
             or 
            
              id
             assigned for state to be managed.
            Auto-generated ids are not guaranteed to be stable
            across page loads and cannot be relied upon to save and
            restore the same state for a component.
            For state saving to work, the state manager's
            provider must have been set to an implementation of 
            Ext.state.Provider
            which overrides the 
            set
            and 
            get
            methods to save and recall name/value pairs. A built-in
            implementation, 
            Ext.state.CookieProvider
            is available.
            To set the state provider for the current page:

Ext.state.Manager.setProvider(
new Ext.state.CookieProvider({
    expires: 
new Date(
new Date().getTime()+(1000*60*60*24*7)), 
//7 days from now
}));
            
            A stateful Component attempts to save state when one
            of the events listed in the 
            
              stateEvents
             configuration fires.
            To save state, a stateful Component first serializes
            its state by calling 
            
              getState
            . By default, this function does nothing. The
            developer must provide an implementation which returns
            an object hash which represents the Component's
            restorable state.
            The value yielded by getState is passed to 
            Ext.state.Manager.set
            which uses the configured 
            Ext.state.Provider to
            save the object keyed by the Component's 
            
              stateId
            , or, if that is not specified, its 
            
              id
            .
            During construction, a stateful Component attempts
            to 
            restore its state by calling 
            Ext.state.Manager.get
            passing the 
            
              stateId
            , or, if that is not specified, the 
            
              id
            .
            The resulting object is passed to 
            
              applyState
            . The default implementation of 
            applyState simply copies properties into
            the object, but a developer may override this to
            support more behaviour.
            You can perform extra processing on state save and
            restore by attaching handlers to the 
            beforestaterestore, 
            staterestore, 
            beforestatesave and 
            statesave events.
          
	 */
	
	public Boolean getStateful () {
		return (Boolean) getStateHelper().eval(PropertyKeys.stateful);
	}

	/**
	 * <p>
	 * Set the value of the <code>stateful</code> property.
	 * </p>
	 */
	public void setStateful ( Boolean   stateful ) {
		getStateHelper().put(PropertyKeys.stateful, stateful);
		handleAttribute("stateful", stateful);
	}
    	/*
	 *
          The label text to display next to this Component
          (defaults to '').
          
          
          Note: this config is only used when this Component
          is rendered by a Container which has been configured to
          use the 
          
            FormLayout
           layout manager (e.g. 
          Ext.form.FormPanel or
          specifying 
          layout:'form').
          
          Also see 
          
            hideLabel
           and 
          Ext.layout.FormLayout.
          fieldTpl.Example
          use:


new Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
'textfield',
        fieldLabel: 
'Name'
    }]
});
          
	 */
	
	public String getFieldLabel () {
		return (String) getStateHelper().eval(PropertyKeys.fieldLabel);
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldLabel</code> property.
	 * </p>
	 */
	public void setFieldLabel ( String   fieldLabel ) {
		getStateHelper().put(PropertyKeys.fieldLabel, fieldLabel);
		handleAttribute("fieldLabel", fieldLabel);
	}
    	/*
	 *
        
        
          hidden
         : Boolean
        Render this component hidden (default is
        false). If 
        true, the 
        hide method
        will be called internally.
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
	 *A custom style specification to be
          applied to this component's Element. Should be a valid
          argument to 
          Ext.Element.applyStyles. 


new Ext.Panel({
    title: 
'Some Title',
    renderTo: Ext.getBody(),
    width: 400, height: 300,
    layout: 
'form',
    items: [{
        xtype: 
'textarea',
        style: {
            width: 
'95%',
            marginBottom: 
'10px'
        }
    },
        
new Ext.Button({
            text: 
'Send',
            minWidth: 
'100',
            style: {
                marginBottom: 
'10px'
            }
        })
    ]
});
          
	 */
	
	public String getStyle () {
		return (String) getStateHelper().eval(PropertyKeys.style);
	}

	/**
	 * <p>
	 * Set the value of the <code>style</code> property.
	 * </p>
	 */
	public void setStyle ( String   style ) {
		getStateHelper().put(PropertyKeys.style, style);
		handleAttribute("style", style);
	}
    	/*
	 *
            Specify the id of the element, a DOM element or an
            existing Element that this component will be rendered
            into.
            
              
                
                Notes : 
                
                  Do 
                  not use this option if the Component is to
                  be a child item of a 
                  Container. It is the
                  responsibility of the 
                  Container's 
                  layout manager to
                  render and manage its child items.
                  When using this config, a
                  call to render() is not required.
                
              
            
            See 
            
              render
             also.
          
	 */
	
	public String getRenderTo () {
		return (String) getStateHelper().eval(PropertyKeys.renderTo);
	}

	/**
	 * <p>
	 * Set the value of the <code>renderTo</code> property.
	 * </p>
	 */
	public void setRenderTo ( String   renderTo ) {
		getStateHelper().put(PropertyKeys.renderTo, renderTo);
		handleAttribute("renderTo", renderTo);
	}
    	/*
	 *An object or array of objects that will
          provide custom functionality for this component. The only
          requirement for a valid plugin is that it contain an init
          method that accepts a reference of type Ext.Component.
          When a component is created, if any plugins are
          available, the component will call the init method on
          each plugin, passing a reference to itself. Each plugin
          can then call methods or respond to events on the
          component as needed to provide its functionality.
	 */
	@ClientConfig(JsonMode.Array)

	public Object getPlugins () {
		return (Object) getStateHelper().eval(PropertyKeys.plugins);
	}

	/**
	 * <p>
	 * Set the value of the <code>plugins</code> property.
	 * </p>
	 */
	public void setPlugins ( Object   plugins ) {
		getStateHelper().put(PropertyKeys.plugins, plugins);
		handleAttribute("plugins", plugins);
	}
    	/*
	 *The unique id for this component to use
          for state management purposes (defaults to the component
          id if one was set, otherwise null if the component is
          using a generated id). 
          See 
          
            stateful
           for an explanation of saving and restoring
          Component state.
	 */
	
	public String getStateId () {
		return (String) getStateHelper().eval(PropertyKeys.stateId);
	}

	/**
	 * <p>
	 * Set the value of the <code>stateId</code> property.
	 * </p>
	 */
	public void setStateId ( String   stateId ) {
		getStateHelper().put(PropertyKeys.stateId, stateId);
		handleAttribute("stateId", stateId);
	}
    	/*
	 *
            An array of events that, when fired, should trigger
            this component to save its state (defaults to none). 
            stateEvents may be any type of event
            supported by this component, including browser or
            custom events (e.g., 
            ['click', 'customerchange']).
            See 
            
              stateful
             for an explanation of saving and restoring
            Component state.
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getStateEvents () {
		return (Object) getStateHelper().eval(PropertyKeys.stateEvents);
	}

	/**
	 * <p>
	 * Set the value of the <code>stateEvents</code> property.
	 * </p>
	 */
	public void setStateEvents ( Object   stateEvents ) {
		getStateHelper().put(PropertyKeys.stateEvents, stateEvents);
		handleAttribute("stateEvents", stateEvents);
	}
    	/*
	 *
            How this component should be hidden. Supported
            values are 
            'visibility' (css visibility), 
            'offsets' (negative offset position) and 
            'display' (css display).
            
            
            Note: the default of 
            'display' is generally preferred since items
            are automatically laid out when they are first shown
            (no sizing is done while hidden).
          
	 */
	
	public String getHideMode () {
		return (String) getStateHelper().eval(PropertyKeys.hideMode);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideMode</code> property.
	 * </p>
	 */
	public void setHideMode ( String   hideMode ) {
		getStateHelper().put(PropertyKeys.hideMode, hideMode);
		handleAttribute("hideMode", hideMode);
	}
    	/*
	 *
        
        
          disabledClass
         : String
        CSS class added to the component when it
        is disabled (defaults to 'x-item-disabled').
	 */
	
	public String getDisabledClass () {
		return (String) getStateHelper().eval(PropertyKeys.disabledClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledClass</code> property.
	 * </p>
	 */
	public void setDisabledClass ( String   disabledClass ) {
		getStateHelper().put(PropertyKeys.disabledClass, disabledClass);
		handleAttribute("disabledClass", disabledClass);
	}
    	/*
	 *
        
        
          disabled
         : Boolean
        Render this component disabled (default
        is false).
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
        
        
          allowDomMove
         : Boolean
        Whether the component can move the Dom
        node when rendering (defaults to true).
	 */
	
	public Boolean getAllowDomMove () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowDomMove);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDomMove</code> property.
	 * </p>
	 */
	public void setAllowDomMove ( Boolean   allowDomMove ) {
		getStateHelper().put(PropertyKeys.allowDomMove, allowDomMove);
		handleAttribute("allowDomMove", allowDomMove);
	}
    	/*
	 *An optional extra CSS class that will
          be added to this component's Element (defaults to '').
          This can be useful for adding customized styles to the
          component or any of its children using standard CSS
          rules.
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
          
          true to completely hide the label element (
          label
          and 
          separator). Defaults to 
          false. By default, even if you do not specify a 
          
            fieldLabel
           the space will still be reserved so that the field
          will line up with other fields that do have labels.
          Setting this to 
          true will cause the field to not reserve that
          space.
          
          
          Note: see the note for 
          
            clearCls
          .
          Example use:


new Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
'textfield'
        hideLabel: true
    }]
});
          
	 */
	
	public Boolean getHideLabel () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideLabel);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideLabel</code> property.
	 * </p>
	 */
	public void setHideLabel ( Boolean   hideLabel ) {
		getStateHelper().put(PropertyKeys.hideLabel, hideLabel);
		handleAttribute("hideLabel", hideLabel);
	}
    	/*
	 *True to hide and show the component's
          container when hide/show is called on the component,
          false to hide and show the component itself (defaults to
          false). For example, this can be used as a shortcut for a
          hide button on a window by setting hide:true on the
          button when adding it to its parent container.
	 */
	
	public Boolean getHideParent () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideParent);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideParent</code> property.
	 * </p>
	 */
	public void setHideParent ( Boolean   hideParent ) {
		getStateHelper().put(PropertyKeys.hideParent, hideParent);
		handleAttribute("hideParent", hideParent);
	}
    	/*
	 *An 
          Ext.Template, 
          Ext.XTemplate or an array of
          strings to form an Ext.XTemplate. Used in conjunction
          with the 
          
            data
           and 
          
            tplWriteMode
           configurations.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTpl () {
		return (Object) getStateHelper().eval(PropertyKeys.tpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>tpl</code> property.
	 * </p>
	 */
	public void setTpl ( Object   tpl ) {
		getStateHelper().put(PropertyKeys.tpl, tpl);
		handleAttribute("tpl", tpl);
	}
    	/*
	 *The Ext.(X)Template method to use when
          updating the content area of the Component. Defaults to 
          'overwrite' (see 
          
            Ext.XTemplate.overwrite
          ).
	 */
	
	public String getTplWriteMode () {
		return (String) getStateHelper().eval(PropertyKeys.tplWriteMode);
	}

	/**
	 * <p>
	 * Set the value of the <code>tplWriteMode</code> property.
	 * </p>
	 */
	public void setTplWriteMode ( String   tplWriteMode ) {
		getStateHelper().put(PropertyKeys.tplWriteMode, tplWriteMode);
		handleAttribute("tplWriteMode", tplWriteMode);
	}
    	/*
	 *
            A path specification, relative to the Component's 
            
              ownerCt
             specifying into which ancestor Container to
            place a named reference to this Component.
            The ancestor axis can be traversed by using '/'
            characters in the path. For example, to put a reference
            to a Toolbar Button into 
            the Panel which owns the Toolbar:


var myGrid = 
new Ext.grid.EditorGridPanel({
    title: 
'My EditorGridPanel',
    store: myStore,
    colModel: myColModel,
    tbar: [{
        text: 
'Save',
        handler: saveChanges,
        disabled: true,
        ref: 
'../saveButton'
    }],
    listeners: {
        afteredit: 
function() {
//          The button reference is 
in the GridPanel
            myGrid.saveButton.enable();
        }
    }
});
            
            In the code above, if the 
            ref had been 
            
              'saveButton'
             the reference would have been placed into the
            Toolbar. Each '/' in the 
            ref moves up one level from the
            Component's 
            
              ownerCt
            .
            Also see the 
            
              added
             and 
            
              removed
             events.
          
	 */
	
	public String getRef () {
		return (String) getStateHelper().eval(PropertyKeys.ref);
	}

	/**
	 * <p>
	 * Set the value of the <code>ref</code> property.
	 * </p>
	 */
	public void setRef ( String   ref ) {
		getStateHelper().put(PropertyKeys.ref, ref);
		handleAttribute("ref", ref);
	}
    	/*
	 *An optional extra CSS class that will
          be added to this component's Element when the mouse moves
          over the Element, and removed when the mouse moves out.
          (defaults to ''). This can be useful for adding
          customized 'active' or 'hover' styles to the component or
          any of its children using standard CSS rules.
	 */
	
	public String getOverCls () {
		return (String) getStateHelper().eval(PropertyKeys.overCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>overCls</code> property.
	 * </p>
	 */
	public void setOverCls ( String   overCls ) {
		getStateHelper().put(PropertyKeys.overCls, overCls);
		handleAttribute("overCls", overCls);
	}
    	/*
	 *
            The CSS class used to to apply to the special
            clearing div rendered directly after each form field
            wrapper to provide field clearing (defaults to 
            'x-form-clear-left').
            
            
            Note: this config is only used when this
            Component is rendered by a Container which has been
            configured to use the 
            
              FormLayout
             layout manager (e.g. 
            Ext.form.FormPanel or
            specifying 
            layout:'form') and either a 
            
              fieldLabel
             is specified or 
            isFormField=true is specified.
            
            See 
            Ext.layout.FormLayout.
            fieldTpl also.
          
	 */
	
	public String getClearCls () {
		return (String) getStateHelper().eval(PropertyKeys.clearCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>clearCls</code> property.
	 * </p>
	 */
	public void setClearCls ( String   clearCls ) {
		getStateHelper().put(PropertyKeys.clearCls, clearCls);
		handleAttribute("clearCls", clearCls);
	}
    	/*
	 *
            An array of events that, when fired, should be
            bubbled to any parent container. See 
            Ext.util.Observable.enableBubble.
            Defaults to 
            [].
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getBubbleEvents () {
		return (Object) getStateHelper().eval(PropertyKeys.bubbleEvents);
	}

	/**
	 * <p>
	 * Set the value of the <code>bubbleEvents</code> property.
	 * </p>
	 */
	public void setBubbleEvents ( Object   bubbleEvents ) {
		getStateHelper().put(PropertyKeys.bubbleEvents, bubbleEvents);
		handleAttribute("bubbleEvents", bubbleEvents);
	}
    	/*
	 *
        
        
          data
         : Mixed
        The initial set of data to apply to the 
        
          tpl
         to update the content area of the
        Component.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getData () {
		return (Object) getStateHelper().eval(PropertyKeys.data);
	}

	/**
	 * <p>
	 * Set the value of the <code>data</code> property.
	 * </p>
	 */
	public void setData ( Object   data ) {
		getStateHelper().put(PropertyKeys.data, data);
		handleAttribute("data", data);
	}
    	/*
	 *
            Optional. Specify an existing HTML element, or the 
            id of an existing HTML element to use as
            the content for this component.
            
              
              Description : 
              This config option is used to
              take an existing HTML element and place it in the
              layout element of a new component (it simply moves
              the specified DOM element 
              after the Component is rendered to use as the
              content.
              
              Notes : 
              The specified HTML element is
              appended to the layout element of the component 
              after any configured 
              HTML
              has been inserted, and so the document will not
              contain this element at the time the 
              render event is
              fired.
              The specified HTML element used
              will not participate in any 
              
                
                  layout
                
               scheme that the Component may use. It is just
              HTML. Layouts operate on child 
              
                
                  items
                
              .
              Add either the 
              x-hidden or the 
              x-hide-display CSS class to prevent a
              brief flicker of the content before it is rendered to
              the panel.
            
          
	 */
	
	public String getContentEl () {
		return (String) getStateHelper().eval(PropertyKeys.contentEl);
	}

	/**
	 * <p>
	 * Set the value of the <code>contentEl</code> property.
	 * </p>
	 */
	public void setContentEl ( String   contentEl ) {
		getStateHelper().put(PropertyKeys.contentEl, contentEl);
		handleAttribute("contentEl", contentEl);
	}
    	/*
	 *The registered 
          xtype to create. This config option is not used
          when passing a config object into a constructor. This
          config option is used only when lazy instantiation is
          being used, and a child item of a Container is being
          specified not as a fully instantiated Component, but as a
          
          Component config object. The 
          xtype will be looked up at render time up to
          determine what type of child Component to create.
          
          The predefined xtypes are listed 
          here.
          
          If you subclass Components to create your own
          Components, you may register them using 
          Ext.ComponentMgr.registerType
          in order to be able to take advantage of lazy
          instantiation and rendering.
	 */
	
	public String getXtype () {
		return (String) getStateHelper().eval(PropertyKeys.xtype);
	}

	/**
	 * <p>
	 * Set the value of the <code>xtype</code> property.
	 * </p>
	 */
	public void setXtype ( String   xtype ) {
		getStateHelper().put(PropertyKeys.xtype, xtype);
		handleAttribute("xtype", xtype);
	}
    	/*
	 *
          An optional extra CSS class that will be added to this
          component's container. This can be useful for adding
          customized styles to the container or any of its children
          using standard CSS rules. See 
          Ext.layout.ContainerLayout.
          extraCls
          also.
          
          Note: 
          ctCls defaults to 
          '' except for the following class which assigns
          a value by default:
          
            
              
              Box Layout : 
              'x-box-layout-ct'
            
          To configure the above Class with an extra CSS
          class append to the default. For example, for BoxLayout
          (Hbox and Vbox):

ctCls: 
'x-box-layout-ct custom-class'
          
          
          
	 */
	
	public String getCtCls () {
		return (String) getStateHelper().eval(PropertyKeys.ctCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>ctCls</code> property.
	 * </p>
	 */
	public void setCtCls ( String   ctCls ) {
		getStateHelper().put(PropertyKeys.ctCls, ctCls);
		handleAttribute("ctCls", ctCls);
	}
    	/*
	 *
          A CSS style specification string to apply directly to
          this field's label. Defaults to the container's
          labelStyle value if set (e.g., 
          
            Ext.layout.FormLayout.labelStyle
           , or '').
          
          
          Note: see the note for 
          
            clearCls
          .
          
          Also see 
          
            hideLabel
           and 
          
          Ext.layout.FormLayout.
          fieldTpl.Example
          use:


new Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
'textfield',
        fieldLabel: 
'Name',
        labelStyle: 
'font-weight:bold;'
    }]
});
          
	 */
	
	public String getLabelStyle () {
		return (String) getStateHelper().eval(PropertyKeys.labelStyle);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelStyle</code> property.
	 * </p>
	 */
	public void setLabelStyle ( String   labelStyle ) {
		getStateHelper().put(PropertyKeys.labelStyle, labelStyle);
		handleAttribute("labelStyle", labelStyle);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "added"
					, "afterrender"
					, "beforedestroy"
					, "beforehide"
					, "beforerender"
					, "beforeshow"
					, "beforestaterestore"
					, "beforestatesave"
					, "destroy"
					, "disable"
					, "enable"
					, "hide"
					, "removed"
					, "render"
					, "show"
					, "staterestore"
					, "statesave"
				));
				return superEvent;
	}
}