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
<div class="description">
  <p>Base class for any 
  <a ext:cls="Ext.BoxComponent" href="output/Ext.BoxComponent.html">Ext.BoxComponent</a> that may contain
  other Components. Containers handle the basic behavior of
  containing items, namely adding, inserting and removing
  items.</p>
  <p>The most commonly used Container classes are 
  <a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Ext.Panel</a>, 
  <a ext:cls="Ext.Window" href="output/Ext.Window.html">Ext.Window</a> and 
  <a ext:cls="Ext.TabPanel" href="output/Ext.TabPanel.html">Ext.TabPanel</a>. If you do not need the
  capabilities offered by the aforementioned classes you can create
  a lightweight Container to be encapsulated by an HTML element to
  your specifications by using the 
  <code>
    <b>
      <a ext:cls="Ext.Component" ext:member="autoEl" href="output/Ext.Component.html#Ext.Component-autoEl">autoEl</a>
    </b>
  </code> config option. This is a useful technique when creating
  embedded 
  <a ext:cls="Ext.layout.ColumnLayout" href="output/Ext.layout.ColumnLayout.html">column</a> layouts inside 
  <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">FormPanels</a> for example.</p>
  <p>The code below illustrates both how to explicitly create a
  Container, and how to implicitly create one using the 
  <b>
    <code>
      <em>'container'</em>
    </code>
  </b> xtype:</p>
<pre>
<code>
<i>// explicitly create a Container</i>
<b>var</b> embeddedColumns = 
<b>new</b> Ext.Container({
    autoEl: 
<em>'div'</em>,  
<i>// This is the 
<b>default</b>
</i>
    layout: 
<em>'column'</em>,
    defaults: {
        
<i>// implicitly create Container by specifying xtype</i>
        xtype: 
<em>'container'</em>,
        autoEl: 
<em>'div'</em>, 
<i>// This is the 
<b>default</b>.</i>
        layout: 
<em>'form'</em>,
        columnWidth: 0.5,
        style: {
            padding: 
<em>'10px'</em>
        }
    },
<i>//  The two items below will be Ext.Containers, each
encapsulated by a &lt;DIV&gt; element.</i>
    items: [{
        items: {
            xtype: 
<em>'datefield'</em>,
            name: 
<em>'startDate'</em>,
            fieldLabel: 
<em>'Start date'</em>
        }
    }, {
        items: {
            xtype: 
<em>'datefield'</em>,
            name: 
<em>'endDate'</em>,
            fieldLabel: 
<em>'End date'</em>
        }
    }]
});</code>
  </pre>
  <br/>
  <br/> 
  <p>
    <u>
      <b>Layout</b>
    </u>
  </p>
  <p>Container classes delegate the rendering of child Components
  to a layout manager class which must be configured into the
  Container using the 
  <code>
    <b>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
    </b>
  </code> configuration property.</p>
  <p>When either specifying child 
  <code>
    <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>
  </code> of a Container, or dynamically 
  <a ext:cls="Ext.Container" ext:member="add" href="output/Ext.Container.html#Ext.Container-add">adding</a> Components to
  a Container, remember to consider how you wish the Container to
  arrange those child elements, and whether those child elements
  need to be sized using one of Ext's built-in 
  <b>
    <code>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
    </code>
  </b> schemes. By default, Containers use the 
  <a ext:cls="Ext.layout.ContainerLayout" href="output/Ext.layout.ContainerLayout.html">ContainerLayout</a> scheme
  which only renders child components, appending them one after the
  other inside the Container, and 
  <b>does not apply any sizing</b> at all.</p>
  <p>A common mistake is when a developer neglects to specify a 
  <b>
    <code>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
    </code>
  </b> (e.g. widgets like GridPanels or TreePanels are added to
  Containers for which no 
  <code>
    <b>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
    </b>
  </code> has been specified). If a Container is left to use the
  default 
  <a ext:cls="Ext.layout.ContainerLayout" href="output/Ext.layout.ContainerLayout.html">ContainerLayout</a> scheme,
  none of its child components will be resized, or changed in any
  way when the Container is resized.</p>
  <p>Certain layout managers allow dynamic addition of child
  components. Those that do include 
  <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">Ext.layout.CardLayout</a>, 
  <a ext:cls="Ext.layout.AnchorLayout" href="output/Ext.layout.AnchorLayout.html">Ext.layout.AnchorLayout</a>, 
  <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>, and 
  <a ext:cls="Ext.layout.TableLayout" href="output/Ext.layout.TableLayout.html">Ext.layout.TableLayout</a>. For
  example:</p>
<pre>
<code>
<i>//  Create the GridPanel.</i>
<b>var</b> myNewGrid = 
<b>new</b> Ext.grid.GridPanel({
    store: myStore,
    columns: myColumnModel,
    title: 
<em>'Results'</em>, 
<i>// the title becomes the title of the tab</i>
});

myTabPanel.add(myNewGrid); 
<i>// 
<a ext:cls="Ext.TabPanel" href="output/Ext.TabPanel.html">Ext.TabPanel</a> implicitly uses 
<a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">CardLayout</a>
</i>
myTabPanel.
<a ext:cls="Ext.TabPanel" ext:member="setActiveTab" href="output/Ext.TabPanel.html#Ext.TabPanel-setActiveTab">setActiveTab</a>(myNewGrid);</code>
  </pre>
  <br/>
  <br/> 
  <p>The example above adds a newly created GridPanel to a
  TabPanel. Note that a TabPanel uses 
  <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">Ext.layout.CardLayout</a> as its
  layout manager which means all its child items are sized to 
  <a ext:cls="Ext.layout.FitLayout" href="output/Ext.layout.FitLayout.html">fit</a> exactly into its client
  area.</p>
  <p>
  <b>
    <u>Overnesting is a common problem</u>
  </b>. An example of overnesting occurs when a GridPanel is added
  to a TabPanel by wrapping the GridPanel 
  <i>inside</i> a wrapping Panel (that has no 
  <code>
    <b>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
    </b>
  </code> specified) and then add that wrapping Panel to the
  TabPanel. The point to realize is that a GridPanel 
  <b>is</b> a Component which can be added directly to a Container.
  If the wrapping Panel has no 
  <code>
    <b>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
    </b>
  </code> configuration, then the overnested GridPanel will not be
  sized as expected.</p>
  <p>
    <u>
      <b>Adding via remote configuration</b>
    </u>
  </p>
  <p>A server side script can be used to add Components which are
  generated dynamically on the server. An example of adding a
  GridPanel to a TabPanel where the GridPanel is generated by the
  server based on certain parameters:</p>
<pre>
<code>
<i>// execute an Ajax request to invoke server side script:</i>
Ext.Ajax.request({
    url: 
<em>'gen-invoice-grid.php'</em>,
    
<i>// send additional parameters to instruct server script</i>
    params: {
        startDate: Ext.getCmp(
<em>'start-date'</em>).getValue(),
        endDate: Ext.getCmp(
<em>'end-date'</em>).getValue()
    },
    
<i>// process the response object to add it to the TabPanel:</i>
    success: 
<b>function</b>(xhr) {
        
<b>var</b> newComponent = eval(xhr.responseText); 
<i>// see discussion below</i>
        myTabPanel.add(newComponent); 
<i>// add the component to the TabPanel</i>
        myTabPanel.setActiveTab(newComponent);
    },
    failure: 
<b>function</b>() {
        Ext.Msg.alert(
<em>"Grid create failed"</em>, 
<em>"Server communication failure"</em>);
    }
});</code>
  </pre>
  <p>The server script needs to return an executable Javascript
  statement which, when processed using 
  <code>eval()</code>, will return either a config object with an 
  <a ext:cls="Ext.Component" ext:member="xtype" href="output/Ext.Component.html#Ext.Component-xtype">xtype</a>, or an
  instantiated Component. The server might return this for
  example:</p>
<pre>
<code>(
<b>function</b>() {
    
<b>function</b> formatDate(value){
        
<b>return</b> value ? value.dateFormat(
<em>'M d, Y'</em>) : 
<em>''</em>;
    };

    
<b>var</b> store = 
<b>new</b> Ext.data.Store({
        url: 
<em>'get-invoice-data.php'</em>,
        baseParams: {
            startDate: 
<em>'01/01/2008'</em>,
            endDate: 
<em>'01/31/2008'</em>
        },
        reader: 
<b>new</b> Ext.data.JsonReader({
            record: 
<em>'transaction'</em>,
            idProperty: 
<em>'id'</em>,
            totalRecords: 
<em>'total'</em>
        }, [
           
<em>'customer'</em>,
           
<em>'invNo'</em>,
           {name: 
<em>'date'</em>, type: 
<em>'date'</em>, dateFormat: 
<em>'m/d/Y'</em>},
           {name: 
<em>'value'</em>, type: 
<em>'float'</em>}
        ])
    });

    
<b>var</b> grid = 
<b>new</b> Ext.grid.GridPanel({
        title: 
<em>'Invoice Report'</em>,
        bbar: 
<b>new</b> Ext.PagingToolbar(store),
        store: store,
        columns: [
            {header: 
<em>"Customer"</em>, width: 250, dataIndex: 
<em>'customer'</em>, sortable: true},
            {header: 
<em>"Invoice Number"</em>, width: 120, dataIndex: 
<em>'invNo'</em>, sortable: true},
            {header: 
<em>"Invoice Date"</em>, width: 100, dataIndex: 
<em>'date'</em>, renderer: formatDate, sortable: true},
            {header: 
<em>"Value"</em>, width: 120, dataIndex: 
<em>'value'</em>, renderer: 
<em>'usMoney'</em>, sortable: true}
        ],
    });
    store.load();
    
<b>return</b> grid;  
<i>// 
<b>return</b> instantiated component</i>
})();</code>
  </pre>
  <p>When the above code fragment is passed through the 
  <code>eval</code> function in the success handler of the Ajax
  request, the code is executed by the Javascript processor, and
  the anonymous function runs, and returns the instantiated grid
  component.</p>
  <p>Note: since the code above is 
  <i>generated</i> by a server script, the 
  <code>baseParams</code> for the Store, the metadata to allow
  generation of the Record layout, and the ColumnModel can all be
  generated into the code since these are all known on the
  server.</p>
</div>

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
			layoutConfig
			,monitorResize
			,autoDestroy
			,defaultType
			,resizeEvent
			,hideBorders
			,defaults
			,items
			,activeItem
			,layout
			,forceLayout
			,bufferResize
			,bubbleEvents
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to automatically monitor window
          resize events to handle anything that is sensitive to the
          current size of the viewport. This value is typically
          managed by the chosen 
          <code>
            <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
          </code> and should not need to be set manually.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If true the container will
          automatically destroy any contained component that is
          removed from it, else destruction must be handled
          manually (defaults to true).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The default 
            <a ext:cls="Ext.Component" href="output/Ext.Component.html">xtype</a> of child Components
            to create in this Container when a child item is
            specified as a raw configuration object, rather than as
            an instantiated Component.</p>
            <p>Defaults to 
            <code>
              <em>'panel'</em>
            </code>, except 
            <a ext:cls="Ext.menu.Menu" href="output/Ext.menu.Menu.html">Ext.menu.Menu</a> which
            defaults to 
            <code>
              <em>'menuitem'</em>
            </code>, and 
            <a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Ext.Toolbar</a> and 
            <a ext:cls="Ext.ButtonGroup" href="output/Ext.ButtonGroup.html">Ext.ButtonGroup</a> which
            default to 
            <code>
              <em>'button'</em>
            </code>.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to hide the borders of each
          contained component, false to defer to the component's
          existing border settings (defaults to false).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>This option is a means of applying default settings
            to all added items whether added through the 
            <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>
            config or via the 
            <a ext:cls="Ext.Container" ext:member="add" href="output/Ext.Container.html#Ext.Container-add">add</a> or 
            <a ext:cls="Ext.Container" ext:member="insert" href="output/Ext.Container.html#Ext.Container-insert">insert</a>
            methods.</p>
            <p>If an added item is a config object, and 
            <b>not</b> an instantiated Component, then the default
            properties are unconditionally applied. If the added
            item 
            <b>is</b> an instantiated Component, then the default
            properties are applied conditionally so as not to
            override existing properties in the item.</p>
            <p>If the defaults option is specified as a function,
            then the function will be called using this Container
            as the scope (
            <code>this</code> reference) and passing the added item
            as the first parameter. Any resulting object from that
            call is then applied to the item as default
            properties.</p>
            <p>For example, to automatically apply padding to the
            body of each of a set of contained 
            <a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Ext.Panel</a> items, you could
            pass: 
            <code>defaults: {bodyStyle:
            <em>'padding:15px'</em>}</code>.</p>
            <p>Usage:</p>
<pre>
<code>defaults: {               
<i>// defaults are applied to items, not the container</i>
    autoScroll:true
},
items: [
    {
        xtype: 
<em>'panel'</em>,   
<i>// defaults 
<b>do not</b> have precedence over</i>
        id: 
<em>'panel1'</em>,     
<i>// options 
<b>in</b> config objects, so the defaults</i>
        autoScroll: false 
<i>// will not be applied here, panel1 will be autoScroll:false</i>
    },
    
<b>new</b> Ext.Panel({       
<i>// defaults 
<b>do</b> have precedence over options</i>
        id: 
<em>'panel2'</em>,     
<i>// options 
<b>in</b> components, so the defaults</i>
        autoScroll: false 
<i>// will be applied here, panel2 will be autoScroll:true.</i>
    })
]</code>
            </pre>
          </div>

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
<div class="long">
<pre>
<b>** IMPORTANT</b>: be sure to 
<b>
<a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">specify a 
<code>layout</code>
</a> if needed ! **</b>
            </pre>
            <p>A single item, or an array of child Components to be
            added to this container, for example:</p>
<pre>
<code>
<i>// specifying a single item</i>
items: {...},
layout: 
<em>'fit'</em>,    
<i>// specify a layout!</i>

<i>// specifying multiple items</i>
items: [{...}, {...}],
layout: 
<em>'anchor'</em>, 
<i>// specify a layout!</i>
</code>
            </pre>
            <p>Each item may be:</p>
            <div>
              <ul class="mdetail-params">
                <li>any type of object based on 
                <a ext:cls="Ext.Component" href="output/Ext.Component.html">Ext.Component</a>
</li>
                <li>a fully instanciated object or</li>
                <li>an object literal that:</li>
                <li style="list-style: none">
                  <div>
                    <ul class="mdetail-params">
                      <li>has a specified 
                      <code>
                        <a ext:cls="Ext.Component" ext:member="xtype" href="output/Ext.Component.html#Ext.Component-xtype">xtype</a>
                      </code>
</li>
                      <li>the 
                      <a ext:cls="Ext.Component" ext:member="xtype" href="output/Ext.Component.html#Ext.Component-xtype">Ext.Component.xtype</a>
                      specified is associated with the Component
                      desired and should be chosen from one of the
                      available xtypes as listed in 
                      <a ext:cls="Ext.Component" href="output/Ext.Component.html">Ext.Component</a>.</li>
                      <li>If an 
                      <code>
                        <a ext:cls="Ext.Component" ext:member="xtype" href="output/Ext.Component.html#Ext.Component-xtype">xtype</a>
                      </code> is not explicitly specified, the 
                      <a ext:cls="Ext.Container" ext:member="defaultType" href="output/Ext.Container.html#Ext.Container-defaultType">defaultType</a> for
                      that Container is used.</li>
                      <li>will be "lazily instanciated", avoiding
                      the overhead of constructing a fully
                      instanciated Component object</li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
            <p>
            <b>Notes</b>:</p>
            <div>
              <ul class="mdetail-params">
                <li>Ext uses lazy rendering. Child Components will
                only be rendered should it become necessary. Items
                are automatically laid out when they are first
                shown (no sizing is done while hidden), or in
                response to a 
                <a ext:cls="Ext.Container" ext:member="doLayout" href="output/Ext.Container.html#Ext.Container-doLayout">doLayout</a> call.</li>
                <li>Do not specify 
                <code>
                  <a ext:cls="Ext.Panel" ext:member="contentEl" href="output/Ext.Panel.html#Ext.Panel-contentEl">contentEl</a>
                </code>/ 
                <code>
                  <a ext:cls="Ext.Panel" ext:member="html" href="output/Ext.Panel.html#Ext.Panel-html">html</a>
                </code> with 
                <code>items</code>.</li>
              </ul>
            </div>
          </div>

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
<div class="long">A string component id or the numeric
          index of the component that should be initially activated
          within the container's layout on render. For example,
          activeItem: 'item-1' or activeItem: 0 (index 0 = the
          first item in the container's collection). activeItem
          only applies to layout styles that can display items one
          at a time (like 
          <a ext:cls="Ext.layout.AccordionLayout" href="output/Ext.layout.AccordionLayout.html">Ext.layout.AccordionLayout</a>,
          
          <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">Ext.layout.CardLayout</a>
          and 
          <a ext:cls="Ext.layout.FitLayout" href="output/Ext.layout.FitLayout.html">Ext.layout.FitLayout</a>).
          Related to 
          <a ext:cls="Ext.layout.ContainerLayout" ext:member="activeItem" href="output/Ext.layout.ContainerLayout.html#Ext.layout.ContainerLayout-activeItem">Ext.layout.ContainerLayout.activeItem</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <b>*Important</b>: In order for child items to be
            correctly sized and positioned, typically a layout
            manager 
            <b>must</b> be specified through the 
            <code>layout</code> configuration option.</p>
            <br/>
            <p>The sizing and positioning of child 
            <a ext:cls="items" href="output/items.html">items</a>
            is the responsibility of the Container's layout manager
            which creates and manages the type of layout you have
            in mind. For example:</p>
<pre>
<code>
<b>new</b> Ext.Window({
    width:300, height: 300,
    layout: 
<em>'fit'</em>, 
<i>// explicitly set layout manager: override the 
<b>default</b> (layout:
<em>'auto'</em>)</i>
    items: [{
        title: 
<em>'Panel inside a Window'</em>
    }]
}).show();</code>
            </pre>
            <p>If the 
            <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
            configuration is not explicitly specified for a general
            purpose container (e.g. Container or Panel) the 
            <a ext:cls="Ext.layout.ContainerLayout" href="output/Ext.layout.ContainerLayout.html">default layout
            manager</a> will be used which does nothing but render
            child components sequentially into the Container (no
            sizing or positioning will be performed in this
            situation). Some container classes implicitly specify a
            default layout (e.g. FormPanel specifies 
            <code>layout:
            <em>'form'</em>
</code>). Other specific purpose classes
            internally specify/manage their internal layout (e.g.
            GridPanel, TabPanel, TreePanel, Toolbar, Menu,
            etc.).</p>
            <br/>
            <p>
            <b>
              <code>layout</code>
            </b> may be specified as either as an Object or as a
            String:</p>
            <div>
              <ul class="mdetail-params">
                <li>
                  <u>Specify as an Object</u>
                </li>
                <li style="list-style: none">
                  <div>
                    <ul class="mdetail-params">
                      <li>Example usage:</li>
                      <li style="list-style: none">
<pre>
<code>layout: {
    type: 
<em>'vbox'</em>,
    padding: 
<em>'5'</em>,
    align: 
<em>'left'</em>
}</code>
                        </pre>
                      </li>
                      <li>
                        <code>
                          <b>type</b>
                        </code>
                      </li>
                      <li style="list-style: none">
                        <br/>
                        <p>The layout type to be used for this
                        container. If not specified, a default 
                        <a ext:cls="Ext.layout.ContainerLayout" href="output/Ext.layout.ContainerLayout.html">Ext.layout.ContainerLayout</a>
                        will be created and used.</p>
                        <br/>
                        <p>Valid layout 
                        <code>type</code> values are:</p>
                        <div class="sub-desc">
                          <ul class="mdetail-params">
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.AbsoluteLayout" href="output/Ext.layout.AbsoluteLayout.html">absolute</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.AccordionLayout" href="output/Ext.layout.AccordionLayout.html">accordion</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.AnchorLayout" href="output/Ext.layout.AnchorLayout.html">anchor</a>
                                </b>
                              </code>
                            </li>
                            <li>
                            <code>
                              <b>
                                <a ext:cls="Ext.layout.ContainerLayout" href="output/Ext.layout.ContainerLayout.html">auto</a>
                              </b>
                            </code>     
                            <b>Default</b>
</li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.BorderLayout" href="output/Ext.layout.BorderLayout.html">border</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">card</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.ColumnLayout" href="output/Ext.layout.ColumnLayout.html">column</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.FitLayout" href="output/Ext.layout.FitLayout.html">fit</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">form</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.HBoxLayout" href="output/Ext.layout.HBoxLayout.html">hbox</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.MenuLayout" href="output/Ext.layout.MenuLayout.html">menu</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.TableLayout" href="output/Ext.layout.TableLayout.html">table</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.ToolbarLayout" href="output/Ext.layout.ToolbarLayout.html">toolbar</a>
                                </b>
                              </code>
                            </li>
                            <li>
                              <code>
                                <b>
                                  <a ext:cls="Ext.layout.VBoxLayout" href="output/Ext.layout.VBoxLayout.html">vbox</a>
                                </b>
                              </code>
                            </li>
                          </ul>
                        </div>
                      </li>
                      <li>Layout specific configuration
                      properties</li>
                      <li style="list-style: none">
                        <br/>
                        <p>Additional layout specific configuration
                        properties may also be specified. For
                        complete details regarding the valid config
                        options for each layout type, see the
                        layout class corresponding to the 
                        <code>type</code> specified.</p>
                      </li>
                    </ul>
                  </div>
                </li>
                <li>
                  <u>Specify as a String</u>
                </li>
                <li style="list-style: none">
                  <div>
                    <ul class="mdetail-params">
                      <li>Example usage:</li>
                      <li style="list-style: none">
<pre>
<code>layout: 
<em>'vbox'</em>,
layoutConfig: {
    padding: 
<em>'5'</em>,
    align: 
<em>'left'</em>
}</code>
                        </pre>
                      </li>
                      <li>
                        <code>
                          <b>layout</b>
                        </code>
                      </li>
                      <li style="list-style: none">
                        <br/>
                        <p>The layout 
                        <code>type</code> to be used for this
                        container (see list of valid layout type
                        values above).</p>
                        <br/>
                      </li>
                      <li>
                        <code>
                          <b>
                            <a ext:cls="Ext.Container" ext:member="layoutConfig" href="output/Ext.Container.html#Ext.Container-layoutConfig">layoutConfig</a>
                          </b>
                        </code>
                      </li>
                      <li style="list-style: none">
                        <br/>
                        <p>Additional layout specific configuration
                        properties. For complete details regarding
                        the valid config options for each layout
                        type, see the layout class corresponding to
                        the 
                        <code>layout</code> specified.</p>
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
          </div>

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
<div class="long">If true the container will force a
          layout initially even if hidden or collapsed. This option
          is useful for forcing forms to render in collapsed or
          hidden containers. (defaults to false).</div>

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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">When set to true (50 milliseconds) or a
          number of milliseconds, the layout assigned for this
          container will buffer the frequency it calculates and
          does a re-layout of components. This is useful for heavy
          containers or containers with a large quantity of
          sub-components for which frequent layout calls would be
          expensive. Defaults to 
          <code>50</code>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An array of events that, when fired, should be
            bubbled to any parent container. See 
            <a ext:cls="Ext.util.Observable" ext:member="enableBubble" href="output/Ext.util.Observable.html#Ext.util.Observable-enableBubble">Ext.util.Observable.enableBubble</a>.
            Defaults to 
            <code>[
            <em>'add'</em>, 
            <em>'remove'</em>]</code>.</p>
          </div>

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