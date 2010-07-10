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
  Base class for any 
  Ext.BoxComponent that may contain
  other Components. Containers handle the basic behavior of
  containing items, namely adding, inserting and removing
  items.
  The most commonly used Container classes are 
  Ext.Panel, 
  Ext.Window and 
  Ext.TabPanel. If you do not need the
  capabilities offered by the aforementioned classes you can create
  a lightweight Container to be encapsulated by an HTML element to
  your specifications by using the 
  
    
      autoEl
    
   config option. This is a useful technique when creating
  embedded 
  column layouts inside 
  FormPanels for example.
  The code below illustrates both how to explicitly create a
  Container, and how to implicitly create one using the 
  
    
      'container'
    
   xtype:


// explicitly create a Container
var embeddedColumns = 
new Ext.Container({
    autoEl: 
'div',  
// This is the 
default
    layout: 
'column',
    defaults: {
        
// implicitly create Container by specifying xtype
        xtype: 
'container',
        autoEl: 
'div', 
// This is the 
default.
        layout: 
'form',
        columnWidth: 0.5,
        style: {
            padding: 
'10px'
        }
    },
//  The two items below will be Ext.Containers, each
encapsulated by a <DIV> element.
    items: [{
        items: {
            xtype: 
'datefield',
            name: 
'startDate',
            fieldLabel: 
'Start date'
        }
    }, {
        items: {
            xtype: 
'datefield',
            name: 
'endDate',
            fieldLabel: 
'End date'
        }
    }]
});
  
  
   
  
    
      Layout
    
  
  Container classes delegate the rendering of child Components
  to a layout manager class which must be configured into the
  Container using the 
  
    
      layout
    
   configuration property.
  When either specifying child 
  
    items
   of a Container, or dynamically 
  adding Components to
  a Container, remember to consider how you wish the Container to
  arrange those child elements, and whether those child elements
  need to be sized using one of Ext's built-in 
  
    
      layout
    
   schemes. By default, Containers use the 
  ContainerLayout scheme
  which only renders child components, appending them one after the
  other inside the Container, and 
  does not apply any sizing at all.
  A common mistake is when a developer neglects to specify a 
  
    
      layout
    
   (e.g. widgets like GridPanels or TreePanels are added to
  Containers for which no 
  
    
      layout
    
   has been specified). If a Container is left to use the
  default 
  ContainerLayout scheme,
  none of its child components will be resized, or changed in any
  way when the Container is resized.
  Certain layout managers allow dynamic addition of child
  components. Those that do include 
  Ext.layout.CardLayout, 
  Ext.layout.AnchorLayout, 
  Ext.layout.FormLayout, and 
  Ext.layout.TableLayout. For
  example:


//  Create the GridPanel.
var myNewGrid = 
new Ext.grid.GridPanel({
    store: myStore,
    columns: myColumnModel,
    title: 
'Results', 
// the title becomes the title of the tab
});

myTabPanel.add(myNewGrid); 
// 
Ext.TabPanel implicitly uses 
CardLayout
myTabPanel.
setActiveTab(myNewGrid);
  
  
   
  The example above adds a newly created GridPanel to a
  TabPanel. Note that a TabPanel uses 
  Ext.layout.CardLayout as its
  layout manager which means all its child items are sized to 
  fit exactly into its client
  area.
  
  
    Overnesting is a common problem
  . An example of overnesting occurs when a GridPanel is added
  to a TabPanel by wrapping the GridPanel 
  inside a wrapping Panel (that has no 
  
    
      layout
    
   specified) and then add that wrapping Panel to the
  TabPanel. The point to realize is that a GridPanel 
  is a Component which can be added directly to a Container.
  If the wrapping Panel has no 
  
    
      layout
    
   configuration, then the overnested GridPanel will not be
  sized as expected.
  
    
      Adding via remote configuration
    
  
  A server side script can be used to add Components which are
  generated dynamically on the server. An example of adding a
  GridPanel to a TabPanel where the GridPanel is generated by the
  server based on certain parameters:


// execute an Ajax request to invoke server side script:
Ext.Ajax.request({
    url: 
'gen-invoice-grid.php',
    
// send additional parameters to instruct server script
    params: {
        startDate: Ext.getCmp(
'start-date').getValue(),
        endDate: Ext.getCmp(
'end-date').getValue()
    },
    
// process the response object to add it to the TabPanel:
    success: 
function(xhr) {
        
var newComponent = eval(xhr.responseText); 
// see discussion below
        myTabPanel.add(newComponent); 
// add the component to the TabPanel
        myTabPanel.setActiveTab(newComponent);
    },
    failure: 
function() {
        Ext.Msg.alert(
"Grid create failed", 
"Server communication failure");
    }
});
  
  The server script needs to return an executable Javascript
  statement which, when processed using 
  eval(), will return either a config object with an 
  xtype, or an
  instantiated Component. The server might return this for
  example:

(
function() {
    
function formatDate(value){
        
return value ? value.dateFormat(
'M d, Y') : 
'';
    };

    
var store = 
new Ext.data.Store({
        url: 
'get-invoice-data.php',
        baseParams: {
            startDate: 
'01/01/2008',
            endDate: 
'01/31/2008'
        },
        reader: 
new Ext.data.JsonReader({
            record: 
'transaction',
            idProperty: 
'id',
            totalRecords: 
'total'
        }, [
           
'customer',
           
'invNo',
           {name: 
'date', type: 
'date', dateFormat: 
'm/d/Y'},
           {name: 
'value', type: 
'float'}
        ])
    });

    
var grid = 
new Ext.grid.GridPanel({
        title: 
'Invoice Report',
        bbar: 
new Ext.PagingToolbar(store),
        store: store,
        columns: [
            {header: 
"Customer", width: 250, dataIndex: 
'customer', sortable: true},
            {header: 
"Invoice Number", width: 120, dataIndex: 
'invNo', sortable: true},
            {header: 
"Invoice Date", width: 100, dataIndex: 
'date', renderer: formatDate, sortable: true},
            {header: 
"Value", width: 120, dataIndex: 
'value', renderer: 
'usMoney', sortable: true}
        ],
    });
    store.load();
    
return grid;  
// 
return instantiated component
})();
  
  When the above code fragment is passed through the 
  eval function in the success handler of the Ajax
  request, the code is executed by the Javascript processor, and
  the anonymous function runs, and returns the instantiated grid
  component.
  Note: since the code above is 
  generated by a server script, the 
  baseParams for the Store, the metadata to allow
  generation of the Record layout, and the ColumnModel can all be
  generated into the code since these are all known on the
  server.
 */
@XType("container")
@InstanceOf("Ext.Container")

@FacesComponent(value = "Ext.Container")
public class Container extends com.abner.fence.component.ExtLayout {
	public static final String COMPONENT_FAMILY = "Ext.Container";

	/**
	 * <p>
	 * Create a new {@link Ext.Container} instance with default property values.
	 * </p>
	 */
	public Container() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			activeItem
			,layout
			,layoutConfig
			,monitorResize
			,defaultType
			,bufferResize
			,bubbleEvents
			,items
			,resizeEvent
			,autoDestroy
			,hideBorders
			,defaults
			,forceLayout
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
	 *A string component id or the numeric
          index of the component that should be initially activated
          within the container's layout on render. For example,
          activeItem: 'item-1' or activeItem: 0 (index 0 = the
          first item in the container's collection). activeItem
          only applies to layout styles that can display items one
          at a time (like 
          Ext.layout.AccordionLayout,
          
          Ext.layout.CardLayout
          and 
          Ext.layout.FitLayout).
          Related to 
          Ext.layout.ContainerLayout.activeItem.
	 */
	
	public String getActiveItem () {
		return (String) getStateHelper().eval(PropertyKeys.activeItem);
	}

	/**
	 * <p>
	 * Set the value of the <code>activeItem</code> property.
	 * </p>
	 */
	public void setActiveItem ( String   activeItem ) {
		getStateHelper().put(PropertyKeys.activeItem, activeItem);
		handleAttribute("activeItem", activeItem);
	}
    	/*
	 *
            
            *Important: In order for child items to be
            correctly sized and positioned, typically a layout
            manager 
            must be specified through the 
            layout configuration option.
            
            The sizing and positioning of child 
            items
            is the responsibility of the Container's layout manager
            which creates and manages the type of layout you have
            in mind. For example:


new Ext.Window({
    width:300, height: 300,
    layout: 
'fit', 
// explicitly set layout manager: override the 
default (layout:
'auto')
    items: [{
        title: 
'Panel inside a Window'
    }]
}).show();
            
            If the 
            layout
            configuration is not explicitly specified for a general
            purpose container (e.g. Container or Panel) the 
            default layout
            manager will be used which does nothing but render
            child components sequentially into the Container (no
            sizing or positioning will be performed in this
            situation). Some container classes implicitly specify a
            default layout (e.g. FormPanel specifies 
            layout:
            'form'). Other specific purpose classes
            internally specify/manage their internal layout (e.g.
            GridPanel, TabPanel, TreePanel, Toolbar, Menu,
            etc.).
            
            
            
              layout
             may be specified as either as an Object or as a
            String:
            
              
                
                  Specify as an Object
                
                
                  
                    
                      Example usage:
                      

layout: {
    type: 
'vbox',
    padding: 
'5',
    align: 
'left'
}
                        
                      
                      
                        
                          type
                        
                      
                      
                        
                        The layout type to be used for this
                        container. If not specified, a default 
                        Ext.layout.ContainerLayout
                        will be created and used.
                        
                        Valid layout 
                        type values are:
                        
                          
                            
                              
                                
                                  absolute
                                
                              
                            
                            
                              
                                
                                  accordion
                                
                              
                            
                            
                              
                                
                                  anchor
                                
                              
                            
                            
                            
                              
                                auto
                              
                                 
                            Default
                            
                              
                                
                                  border
                                
                              
                            
                            
                              
                                
                                  card
                                
                              
                            
                            
                              
                                
                                  column
                                
                              
                            
                            
                              
                                
                                  fit
                                
                              
                            
                            
                              
                                
                                  form
                                
                              
                            
                            
                              
                                
                                  hbox
                                
                              
                            
                            
                              
                                
                                  menu
                                
                              
                            
                            
                              
                                
                                  table
                                
                              
                            
                            
                              
                                
                                  toolbar
                                
                              
                            
                            
                              
                                
                                  vbox
                                
                              
                            
                          
                        
                      
                      Layout specific configuration
                      properties
                      
                        
                        Additional layout specific configuration
                        properties may also be specified. For
                        complete details regarding the valid config
                        options for each layout type, see the
                        layout class corresponding to the 
                        type specified.
                      
                    
                  
                
                
                  Specify as a String
                
                
                  
                    
                      Example usage:
                      

layout: 
'vbox',
layoutConfig: {
    padding: 
'5',
    align: 
'left'
}
                        
                      
                      
                        
                          layout
                        
                      
                      
                        
                        The layout 
                        type to be used for this
                        container (see list of valid layout type
                        values above).
                        
                      
                      
                        
                          
                            layoutConfig
                          
                        
                      
                      
                        
                        Additional layout specific configuration
                        properties. For complete details regarding
                        the valid config options for each layout
                        type, see the layout class corresponding to
                        the 
                        layout specified.
                      
                    
                  
                
              
            
          
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
	 *
        
        
          layoutConfig
         : Object
        This is a config object containing
        properties specific to the chosen 
        
          
            layout
          
         if 
        
          
            layout
          
         has been specified as a 
        string.
        
        
	 */
	@ClientConfig(JsonMode.Object)

	public Object getLayoutConfig () {
		return (Object) getStateHelper().eval(PropertyKeys.layoutConfig);
	}

	/**
	 * <p>
	 * Set the value of the <code>layoutConfig</code> property.
	 * </p>
	 */
	public void setLayoutConfig ( Object   layoutConfig ) {
		getStateHelper().put(PropertyKeys.layoutConfig, layoutConfig);
		handleAttribute("layoutConfig", layoutConfig);
	}
    	/*
	 *True to automatically monitor window
          resize events to handle anything that is sensitive to the
          current size of the viewport. This value is typically
          managed by the chosen 
          
            layout
           and should not need to be set manually.
	 */
	
	public Boolean getMonitorResize () {
		return (Boolean) getStateHelper().eval(PropertyKeys.monitorResize);
	}

	/**
	 * <p>
	 * Set the value of the <code>monitorResize</code> property.
	 * </p>
	 */
	public void setMonitorResize ( Boolean   monitorResize ) {
		getStateHelper().put(PropertyKeys.monitorResize, monitorResize);
		handleAttribute("monitorResize", monitorResize);
	}
    	/*
	 *
            The default 
            xtype of child Components
            to create in this Container when a child item is
            specified as a raw configuration object, rather than as
            an instantiated Component.
            Defaults to 
            
              'panel'
            , except 
            Ext.menu.Menu which
            defaults to 
            
              'menuitem'
            , and 
            Ext.Toolbar and 
            Ext.ButtonGroup which
            default to 
            
              'button'
            .
          
	 */
	
	public String getDefaultType () {
		return (String) getStateHelper().eval(PropertyKeys.defaultType);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultType</code> property.
	 * </p>
	 */
	public void setDefaultType ( String   defaultType ) {
		getStateHelper().put(PropertyKeys.defaultType, defaultType);
		handleAttribute("defaultType", defaultType);
	}
    	/*
	 *When set to true (50 milliseconds) or a
          number of milliseconds, the layout assigned for this
          container will buffer the frequency it calculates and
          does a re-layout of components. This is useful for heavy
          containers or containers with a large quantity of
          sub-components for which frequent layout calls would be
          expensive. Defaults to 
          50.
	 */
	
	public Boolean getBufferResize () {
		return (Boolean) getStateHelper().eval(PropertyKeys.bufferResize);
	}

	/**
	 * <p>
	 * Set the value of the <code>bufferResize</code> property.
	 * </p>
	 */
	public void setBufferResize ( Boolean   bufferResize ) {
		getStateHelper().put(PropertyKeys.bufferResize, bufferResize);
		handleAttribute("bufferResize", bufferResize);
	}
    	/*
	 *
            An array of events that, when fired, should be
            bubbled to any parent container. See 
            Ext.util.Observable.enableBubble.
            Defaults to 
            [
            'add', 
            'remove'].
          
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

** IMPORTANT: be sure to 

specify a 
layout if needed ! **
            
            A single item, or an array of child Components to be
            added to this container, for example:


// specifying a single item
items: {...},
layout: 
'fit',    
// specify a layout!

// specifying multiple items
items: [{...}, {...}],
layout: 
'anchor', 
// specify a layout!
            
            Each item may be:
            
              
                any type of object based on 
                Ext.Component
                a fully instanciated object or
                an object literal that:
                
                  
                    
                      has a specified 
                      
                        xtype
                      
                      the 
                      Ext.Component.xtype
                      specified is associated with the Component
                      desired and should be chosen from one of the
                      available xtypes as listed in 
                      Ext.Component.
                      If an 
                      
                        xtype
                       is not explicitly specified, the 
                      defaultType for
                      that Container is used.
                      will be "lazily instanciated", avoiding
                      the overhead of constructing a fully
                      instanciated Component object
                    
                  
                
              
            
            
            Notes:
            
              
                Ext uses lazy rendering. Child Components will
                only be rendered should it become necessary. Items
                are automatically laid out when they are first
                shown (no sizing is done while hidden), or in
                response to a 
                doLayout call.
                Do not specify 
                
                  contentEl
                / 
                
                  html
                 with 
                items.
              
            
          
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
	 *
        
        
          resizeEvent
         : String
        The event to listen to for resizing in
        layouts. Defaults to 
        
          'resize'
        .
	 */
	
	public String getResizeEvent () {
		return (String) getStateHelper().eval(PropertyKeys.resizeEvent);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizeEvent</code> property.
	 * </p>
	 */
	public void setResizeEvent ( String   resizeEvent ) {
		getStateHelper().put(PropertyKeys.resizeEvent, resizeEvent);
		handleAttribute("resizeEvent", resizeEvent);
	}
    	/*
	 *If true the container will
          automatically destroy any contained component that is
          removed from it, else destruction must be handled
          manually (defaults to true).
	 */
	
	public Boolean getAutoDestroy () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoDestroy);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoDestroy</code> property.
	 * </p>
	 */
	public void setAutoDestroy ( Boolean   autoDestroy ) {
		getStateHelper().put(PropertyKeys.autoDestroy, autoDestroy);
		handleAttribute("autoDestroy", autoDestroy);
	}
    	/*
	 *True to hide the borders of each
          contained component, false to defer to the component's
          existing border settings (defaults to false).
	 */
	
	public Boolean getHideBorders () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideBorders);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideBorders</code> property.
	 * </p>
	 */
	public void setHideBorders ( Boolean   hideBorders ) {
		getStateHelper().put(PropertyKeys.hideBorders, hideBorders);
		handleAttribute("hideBorders", hideBorders);
	}
    	/*
	 *
            This option is a means of applying default settings
            to all added items whether added through the 
            items
            config or via the 
            add or 
            insert
            methods.
            If an added item is a config object, and 
            not an instantiated Component, then the default
            properties are unconditionally applied. If the added
            item 
            is an instantiated Component, then the default
            properties are applied conditionally so as not to
            override existing properties in the item.
            If the defaults option is specified as a function,
            then the function will be called using this Container
            as the scope (
            this reference) and passing the added item
            as the first parameter. Any resulting object from that
            call is then applied to the item as default
            properties.
            For example, to automatically apply padding to the
            body of each of a set of contained 
            Ext.Panel items, you could
            pass: 
            defaults: {bodyStyle:
            'padding:15px'}.
            Usage:

defaults: {               
// defaults are applied to items, not the container
    autoScroll:true
},
items: [
    {
        xtype: 
'panel',   
// defaults 
do not have precedence over
        id: 
'panel1',     
// options 
in config objects, so the defaults
        autoScroll: false 
// will not be applied here, panel1 will be autoScroll:false
    },
    
new Ext.Panel({       
// defaults 
do have precedence over options
        id: 
'panel2',     
// options 
in components, so the defaults
        autoScroll: false 
// will be applied here, panel2 will be autoScroll:true.
    })
]
            
          
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
	 *If true the container will force a
          layout initially even if hidden or collapsed. This option
          is useful for forcing forms to render in collapsed or
          hidden containers. (defaults to false).
	 */
	
	public Boolean getForceLayout () {
		return (Boolean) getStateHelper().eval(PropertyKeys.forceLayout);
	}

	/**
	 * <p>
	 * Set the value of the <code>forceLayout</code> property.
	 * </p>
	 */
	public void setForceLayout ( Boolean   forceLayout ) {
		getStateHelper().put(PropertyKeys.forceLayout, forceLayout);
		handleAttribute("forceLayout", forceLayout);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "add"
					, "afterlayout"
					, "beforeadd"
					, "beforeremove"
					, "remove"
				));
				return superEvent;
	}
}