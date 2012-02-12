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
    <p>Base class for all Ext components. All subclasses of
    Component may participate in the automated Ext component
    lifecycle of creation, rendering and destruction which is
    provided by the 
    <a ext:cls="Ext.Container" href="output/Ext.Container.html">Container</a> class. Components may be
    added to a Container through the 
    <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a> config
    option at the time the Container is created, or they may be
    added dynamically via the 
    <a ext:cls="Ext.Container" ext:member="add" href="output/Ext.Container.html#Ext.Container-add">add</a> method.</p>
    <p>The Component base class has built-in support for basic
    hide/show and enable/disable behavior.</p>
    <p>All Components are registered with the 
    <a ext:cls="Ext.ComponentMgr" href="output/Ext.ComponentMgr.html">Ext.ComponentMgr</a> on construction
    so that they can be referenced at any time via 
    <a ext:cls="Ext" ext:member="getCmp" href="output/Ext.html#Ext-getCmp">Ext.getCmp</a>, passing the 
    <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>.</p>
    <p>All user-developed visual widgets that are required to
    participate in automated lifecycle and size management should
    subclass Component (or 
    <a ext:cls="Ext.BoxComponent" href="output/Ext.BoxComponent.html">Ext.BoxComponent</a> if managed box
    model handling is required, ie height and width
    management).</p>
    <p>See the 
    <a href="http://extjs.com/learn/Tutorial:Creating_new_UI_controls">Creating
    new UI controls</a> tutorial for details on how and to either
    extend or augment ExtJs base classes to create custom
    Components.</p>
    <p>Every component has a specific xtype, which is its
    Ext-specific type name, along with methods for checking the
    xtype like 
    <a ext:cls="Ext.Component" ext:member="getXType" href="output/Ext.Component.html#Ext.Component-getXType">getXType</a> and 
    <a ext:cls="Ext.Component" ext:member="isXType" href="output/Ext.Component.html#Ext.Component-isXType">isXType</a>. This
    is the list of all valid xtypes:</p>
<pre>
xtype            Class
-------------    ------------------
box              
<a ext:cls="Ext.BoxComponent" href="output/Ext.BoxComponent.html">Ext.BoxComponent</a>
button           
<a ext:cls="Ext.Button" href="output/Ext.Button.html">Ext.Button</a>
buttongroup      
<a ext:cls="Ext.ButtonGroup" href="output/Ext.ButtonGroup.html">Ext.ButtonGroup</a>
colorpalette     
<a ext:cls="Ext.ColorPalette" href="output/Ext.ColorPalette.html">Ext.ColorPalette</a>
component        
<a ext:cls="Ext.Component" href="output/Ext.Component.html">Ext.Component</a>
container        
<a ext:cls="Ext.Container" href="output/Ext.Container.html">Ext.Container</a>
cycle            
<a ext:cls="Ext.CycleButton" href="output/Ext.CycleButton.html">Ext.CycleButton</a>
dataview         
<a ext:cls="Ext.DataView" href="output/Ext.DataView.html">Ext.DataView</a>
datepicker       
<a ext:cls="Ext.DatePicker" href="output/Ext.DatePicker.html">Ext.DatePicker</a>
editor           
<a ext:cls="Ext.Editor" href="output/Ext.Editor.html">Ext.Editor</a>
editorgrid       
<a ext:cls="Ext.grid.EditorGridPanel" href="output/Ext.grid.EditorGridPanel.html">Ext.grid.EditorGridPanel</a>
flash            
<a ext:cls="Ext.FlashComponent" href="output/Ext.FlashComponent.html">Ext.FlashComponent</a>
grid             
<a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">Ext.grid.GridPanel</a>
listview         
<a ext:cls="Ext.ListView" href="output/Ext.ListView.html">Ext.ListView</a>
multislider      
<a ext:cls="Ext.slider.MultiSlider" href="output/Ext.slider.MultiSlider.html">Ext.slider.MultiSlider</a>
panel            
<a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Ext.Panel</a>
progress         
<a ext:cls="Ext.ProgressBar" href="output/Ext.ProgressBar.html">Ext.ProgressBar</a>
propertygrid     
<a ext:cls="Ext.grid.PropertyGrid" href="output/Ext.grid.PropertyGrid.html">Ext.grid.PropertyGrid</a>
slider           
<a ext:cls="Ext.slider.SingleSlider" href="output/Ext.slider.SingleSlider.html">Ext.slider.SingleSlider</a>
spacer           
<a ext:cls="Ext.Spacer" href="output/Ext.Spacer.html">Ext.Spacer</a>
splitbutton      
<a ext:cls="Ext.SplitButton" href="output/Ext.SplitButton.html">Ext.SplitButton</a>
tabpanel         
<a ext:cls="Ext.TabPanel" href="output/Ext.TabPanel.html">Ext.TabPanel</a>
treepanel        
<a ext:cls="Ext.tree.TreePanel" href="output/Ext.tree.TreePanel.html">Ext.tree.TreePanel</a>
viewport         
<a ext:cls="Ext.ViewPort" href="output/Ext.ViewPort.html">Ext.ViewPort</a>
window           
<a ext:cls="Ext.Window" href="output/Ext.Window.html">Ext.Window</a>

Toolbar components
---------------------------------------
paging           
<a ext:cls="Ext.PagingToolbar" href="output/Ext.PagingToolbar.html">Ext.PagingToolbar</a>
toolbar          
<a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Ext.Toolbar</a>
tbbutton         
<a ext:cls="Ext.Toolbar.Button" href="output/Ext.Toolbar.Button.html">Ext.Toolbar.Button</a>       
(deprecated; use button)
tbfill           
<a ext:cls="Ext.Toolbar.Fill" href="output/Ext.Toolbar.Fill.html">Ext.Toolbar.Fill</a>
tbitem           
<a ext:cls="Ext.Toolbar.Item" href="output/Ext.Toolbar.Item.html">Ext.Toolbar.Item</a>
tbseparator      
<a ext:cls="Ext.Toolbar.Separator" href="output/Ext.Toolbar.Separator.html">Ext.Toolbar.Separator</a>
tbspacer         
<a ext:cls="Ext.Toolbar.Spacer" href="output/Ext.Toolbar.Spacer.html">Ext.Toolbar.Spacer</a>
tbsplit          
<a ext:cls="Ext.Toolbar.SplitButton" href="output/Ext.Toolbar.SplitButton.html">Ext.Toolbar.SplitButton</a>  
(deprecated; use splitbutton)
tbtext           
<a ext:cls="Ext.Toolbar.TextItem" href="output/Ext.Toolbar.TextItem.html">Ext.Toolbar.TextItem</a>

Menu components
---------------------------------------
menu             
<a ext:cls="Ext.menu.Menu" href="output/Ext.menu.Menu.html">Ext.menu.Menu</a>
colormenu        
<a ext:cls="Ext.menu.ColorMenu" href="output/Ext.menu.ColorMenu.html">Ext.menu.ColorMenu</a>
datemenu         
<a ext:cls="Ext.menu.DateMenu" href="output/Ext.menu.DateMenu.html">Ext.menu.DateMenu</a>
menubaseitem     
<a ext:cls="Ext.menu.BaseItem" href="output/Ext.menu.BaseItem.html">Ext.menu.BaseItem</a>
menucheckitem    
<a ext:cls="Ext.menu.CheckItem" href="output/Ext.menu.CheckItem.html">Ext.menu.CheckItem</a>
menuitem         
<a ext:cls="Ext.menu.Item" href="output/Ext.menu.Item.html">Ext.menu.Item</a>
menuseparator    
<a ext:cls="Ext.menu.Separator" href="output/Ext.menu.Separator.html">Ext.menu.Separator</a>
menutextitem     
<a ext:cls="Ext.menu.TextItem" href="output/Ext.menu.TextItem.html">Ext.menu.TextItem</a>

Form components
---------------------------------------
form             
<a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">Ext.form.FormPanel</a>
checkbox         
<a ext:cls="Ext.form.Checkbox" href="output/Ext.form.Checkbox.html">Ext.form.Checkbox</a>
checkboxgroup    
<a ext:cls="Ext.form.CheckboxGroup" href="output/Ext.form.CheckboxGroup.html">Ext.form.CheckboxGroup</a>
combo            
<a ext:cls="Ext.form.ComboBox" href="output/Ext.form.ComboBox.html">Ext.form.ComboBox</a>
compositefield   
<a ext:cls="Ext.form.CompositeField" href="output/Ext.form.CompositeField.html">Ext.form.CompositeField</a>
datefield        
<a ext:cls="Ext.form.DateField" href="output/Ext.form.DateField.html">Ext.form.DateField</a>
displayfield     
<a ext:cls="Ext.form.DisplayField" href="output/Ext.form.DisplayField.html">Ext.form.DisplayField</a>
field            
<a ext:cls="Ext.form.Field" href="output/Ext.form.Field.html">Ext.form.Field</a>
fieldset         
<a ext:cls="Ext.form.FieldSet" href="output/Ext.form.FieldSet.html">Ext.form.FieldSet</a>
hidden           
<a ext:cls="Ext.form.Hidden" href="output/Ext.form.Hidden.html">Ext.form.Hidden</a>
htmleditor       
<a ext:cls="Ext.form.HtmlEditor" href="output/Ext.form.HtmlEditor.html">Ext.form.HtmlEditor</a>
label            
<a ext:cls="Ext.form.Label" href="output/Ext.form.Label.html">Ext.form.Label</a>
numberfield      
<a ext:cls="Ext.form.NumberField" href="output/Ext.form.NumberField.html">Ext.form.NumberField</a>
radio            
<a ext:cls="Ext.form.Radio" href="output/Ext.form.Radio.html">Ext.form.Radio</a>
radiogroup       
<a ext:cls="Ext.form.RadioGroup" href="output/Ext.form.RadioGroup.html">Ext.form.RadioGroup</a>
textarea         
<a ext:cls="Ext.form.TextArea" href="output/Ext.form.TextArea.html">Ext.form.TextArea</a>
textfield        
<a ext:cls="Ext.form.TextField" href="output/Ext.form.TextField.html">Ext.form.TextField</a>
timefield        
<a ext:cls="Ext.form.TimeField" href="output/Ext.form.TimeField.html">Ext.form.TimeField</a>
trigger          
<a ext:cls="Ext.form.TriggerField" href="output/Ext.form.TriggerField.html">Ext.form.TriggerField</a>

Chart components
---------------------------------------
chart            
<a ext:cls="Ext.chart.Chart" href="output/Ext.chart.Chart.html">Ext.chart.Chart</a>
barchart         
<a ext:cls="Ext.chart.BarChart" href="output/Ext.chart.BarChart.html">Ext.chart.BarChart</a>
cartesianchart   
<a ext:cls="Ext.chart.CartesianChart" href="output/Ext.chart.CartesianChart.html">Ext.chart.CartesianChart</a>
columnchart      
<a ext:cls="Ext.chart.ColumnChart" href="output/Ext.chart.ColumnChart.html">Ext.chart.ColumnChart</a>
linechart        
<a ext:cls="Ext.chart.LineChart" href="output/Ext.chart.LineChart.html">Ext.chart.LineChart</a>
piechart         
<a ext:cls="Ext.chart.PieChart" href="output/Ext.chart.PieChart.html">Ext.chart.PieChart</a>

Store xtypes
---------------------------------------
arraystore       
<a ext:cls="Ext.data.ArrayStore" href="output/Ext.data.ArrayStore.html">Ext.data.ArrayStore</a>
directstore      
<a ext:cls="Ext.data.DirectStore" href="output/Ext.data.DirectStore.html">Ext.data.DirectStore</a>
groupingstore    
<a ext:cls="Ext.data.GroupingStore" href="output/Ext.data.GroupingStore.html">Ext.data.GroupingStore</a>
jsonstore        
<a ext:cls="Ext.data.JsonStore" href="output/Ext.data.JsonStore.html">Ext.data.JsonStore</a>
simplestore      
<a ext:cls="Ext.data.SimpleStore" href="output/Ext.data.SimpleStore.html">Ext.data.SimpleStore</a>     
(deprecated; use arraystore)
store            
<a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>
xmlstore         
<a ext:cls="Ext.data.XmlStore" href="output/Ext.data.XmlStore.html">Ext.data.XmlStore</a>
    </pre>
  </div>

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
			disabledClass
			,plugins
			,labelStyle
			,data
			,clearCls
			,overCls
			,fieldLabel
			,autoShow
			,stateful
			,style
			,xtype
			,stateEvents
			,applyTo
			,bubbleEvents
			,allowDomMove
			,cls
			,hideMode
			,hideParent
			,ctCls
			,itemId
			,hideLabel
			,autoEl
			,ref
			,renderTo
			,itemCls
			,stateId
			,hidden
			,tpl
			,labelSeparator
			,tplWriteMode
			,html
			,contentEl
			,disabled
			,ptype
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An object or array of objects that will
          provide custom functionality for this component. The only
          requirement for a valid plugin is that it contain an init
          method that accepts a reference of type Ext.Component.
          When a component is created, if any plugins are
          available, the component will call the init method on
          each plugin, passing a reference to itself. Each plugin
          can then call methods or respond to events on the
          component as needed to provide its functionality.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>A CSS style specification string to apply directly to
          this field's label. Defaults to the container's
          labelStyle value if set (e.g., 
          <tt>
            <a ext:cls="Ext.layout.FormLayout" ext:member="labelStyle" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelStyle">Ext.layout.FormLayout.labelStyle</a>
          </tt> , or '').</p>
          <br/>
          <p>
          <b>Note</b>: see the note for 
          <code>
            <a ext:cls="Ext.Component" ext:member="clearCls" href="output/Ext.Component.html#Ext.Component-clearCls">clearCls</a>
          </code>.</p>
          <br/>
          <p>Also see 
          <code>
            <a ext:cls="Ext.Component" ext:member="hideLabel" href="output/Ext.Component.html#Ext.Component-hideLabel">hideLabel</a>
          </code> and 
          <code>
          <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>.
          <a ext:cls="Ext.layout.FormLayout" ext:member="fieldTpl" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-fieldTpl">fieldTpl</a>.</code>
</p>Example
          use:
<pre>
<code>
<b>new</b> Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
<em>'textfield'</em>,
        fieldLabel: 
<em>'Name'</em>,
        labelStyle: 
<em>'font-weight:bold;'</em>
    }]
});</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The CSS class used to to apply to the special
            clearing div rendered directly after each form field
            wrapper to provide field clearing (defaults to 
            <tt>'x-form-clear-left'</tt>).</p>
            <br/>
            <p>
            <b>Note</b>: this config is only used when this
            Component is rendered by a Container which has been
            configured to use the 
            <b>
              <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">FormLayout</a>
            </b> layout manager (e.g. 
            <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">Ext.form.FormPanel</a> or
            specifying 
            <tt>layout:'form'</tt>) and either a 
            <tt>
              <a ext:cls="Ext.Component" ext:member="fieldLabel" href="output/Ext.Component.html#Ext.Component-fieldLabel">fieldLabel</a>
            </tt> is specified or 
            <tt>isFormField=true</tt> is specified.</p>
            <br/>
            <p>See 
            <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>.
            <a ext:cls="Ext.layout.FormLayout" ext:member="fieldTpl" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-fieldTpl">fieldTpl</a> also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An optional extra CSS class that will
          be added to this component's Element when the mouse moves
          over the Element, and removed when the mouse moves out.
          (defaults to ''). This can be useful for adding
          customized 'active' or 'hover' styles to the component or
          any of its children using standard CSS rules.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>The label text to display next to this Component
          (defaults to '').</p>
          <br/>
          <p>
          <b>Note</b>: this config is only used when this Component
          is rendered by a Container which has been configured to
          use the 
          <b>
            <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">FormLayout</a>
          </b> layout manager (e.g. 
          <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">Ext.form.FormPanel</a> or
          specifying 
          <tt>layout:'form'</tt>).</p>
          <br/>
          <p>Also see 
          <tt>
            <a ext:cls="Ext.Component" ext:member="hideLabel" href="output/Ext.Component.html#Ext.Component-hideLabel">hideLabel</a>
          </tt> and 
          <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>.
          <a ext:cls="Ext.layout.FormLayout" ext:member="fieldTpl" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-fieldTpl">fieldTpl</a>.</p>Example
          use:
<pre>
<code>
<b>new</b> Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
<em>'textfield'</em>,
        fieldLabel: 
<em>'Name'</em>
    }]
});</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True if the component should check for
          hidden classes (e.g. 'x-hidden' or 'x-hide-display') and
          remove them on render (defaults to false).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A flag which causes the Component to attempt to
            restore the state of internal properties from a saved
            state on startup. The component must have either a 
            <code>
              <a ext:cls="Ext.Component" ext:member="stateId" href="output/Ext.Component.html#Ext.Component-stateId">stateId</a>
            </code> or 
            <code>
              <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>
            </code> assigned for state to be managed.
            Auto-generated ids are not guaranteed to be stable
            across page loads and cannot be relied upon to save and
            restore the same state for a component.</p>
            <p>For state saving to work, the state manager's
            provider must have been set to an implementation of 
            <a ext:cls="Ext.state.Provider" href="output/Ext.state.Provider.html">Ext.state.Provider</a>
            which overrides the 
            <a ext:cls="Ext.state.Provider" ext:member="set" href="output/Ext.state.Provider.html#Ext.state.Provider-set">set</a>
            and 
            <a ext:cls="Ext.state.Provider" ext:member="get" href="output/Ext.state.Provider.html#Ext.state.Provider-get">get</a>
            methods to save and recall name/value pairs. A built-in
            implementation, 
            <a ext:cls="Ext.state.CookieProvider" href="output/Ext.state.CookieProvider.html">Ext.state.CookieProvider</a>
            is available.</p>
            <p>To set the state provider for the current page:</p>
<pre>
<code>Ext.state.Manager.setProvider(
<b>new</b> Ext.state.CookieProvider({
    expires: 
<b>new</b> Date(
<b>new</b> Date().getTime()+(1000*60*60*24*7)), 
<i>//7 days from now</i>
}));</code>
            </pre>
            <p>A stateful Component attempts to save state when one
            of the events listed in the 
            <code>
              <a ext:cls="Ext.Component" ext:member="stateEvents" href="output/Ext.Component.html#Ext.Component-stateEvents">stateEvents</a>
            </code> configuration fires.</p>
            <p>To save state, a stateful Component first serializes
            its state by calling 
            <b>
              <code>getState</code>
            </b>. By default, this function does nothing. The
            developer must provide an implementation which returns
            an object hash which represents the Component's
            restorable state.</p>
            <p>The value yielded by getState is passed to 
            <a ext:cls="Ext.state.Manager" ext:member="set" href="output/Ext.state.Manager.html#Ext.state.Manager-set">Ext.state.Manager.set</a>
            which uses the configured 
            <a ext:cls="Ext.state.Provider" href="output/Ext.state.Provider.html">Ext.state.Provider</a> to
            save the object keyed by the Component's 
            <code>
              <a ext:cls="stateId" href="output/stateId.html">stateId</a>
            </code>, or, if that is not specified, its 
            <code>
              <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>
            </code>.</p>
            <p>During construction, a stateful Component attempts
            to 
            <i>restore</i> its state by calling 
            <a ext:cls="Ext.state.Manager" ext:member="get" href="output/Ext.state.Manager.html#Ext.state.Manager-get">Ext.state.Manager.get</a>
            passing the 
            <code>
              <a ext:cls="Ext.Component" ext:member="stateId" href="output/Ext.Component.html#Ext.Component-stateId">stateId</a>
            </code>, or, if that is not specified, the 
            <code>
              <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>
            </code>.</p>
            <p>The resulting object is passed to 
            <b>
              <code>applyState</code>
            </b>. The default implementation of 
            <code>applyState</code> simply copies properties into
            the object, but a developer may override this to
            support more behaviour.</p>
            <p>You can perform extra processing on state save and
            restore by attaching handlers to the 
            <a ext:cls="Ext.Component" ext:member="beforestaterestore" href="output/Ext.Component.html#Ext.Component-beforestaterestore">beforestaterestore</a>, 
            <a ext:cls="Ext.Component" ext:member="staterestore" href="output/Ext.Component.html#Ext.Component-staterestore">staterestore</a>, 
            <a ext:cls="Ext.Component" ext:member="beforestatesave" href="output/Ext.Component.html#Ext.Component-beforestatesave">beforestatesave</a> and 
            <a ext:cls="Ext.Component" ext:member="statesave" href="output/Ext.Component.html#Ext.Component-statesave">statesave</a> events.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A custom style specification to be
          applied to this component's Element. Should be a valid
          argument to 
          <a ext:cls="Ext.Element" ext:member="applyStyles" href="output/Ext.Element.html#Ext.Element-applyStyles">Ext.Element.applyStyles</a>. 
<pre>
<code>
<b>new</b> Ext.Panel({
    title: 
<em>'Some Title'</em>,
    renderTo: Ext.getBody(),
    width: 400, height: 300,
    layout: 
<em>'form'</em>,
    items: [{
        xtype: 
<em>'textarea'</em>,
        style: {
            width: 
<em>'95%'</em>,
            marginBottom: 
<em>'10px'</em>
        }
    },
        
<b>new</b> Ext.Button({
            text: 
<em>'Send'</em>,
            minWidth: 
<em>'100'</em>,
            style: {
                marginBottom: 
<em>'10px'</em>
            }
        })
    ]
});</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The registered 
          <tt>xtype</tt> to create. This config option is not used
          when passing a config object into a constructor. This
          config option is used only when lazy instantiation is
          being used, and a child item of a Container is being
          specified not as a fully instantiated Component, but as a
          
          <i>Component config object</i>. The 
          <tt>xtype</tt> will be looked up at render time up to
          determine what type of child Component to create.
          <br/>
          <br/>The predefined xtypes are listed 
          <a ext:cls="Ext.Component" href="output/Ext.Component.html">here</a>.
          <br/>
          <br/>If you subclass Components to create your own
          Components, you may register them using 
          <a ext:cls="Ext.ComponentMgr" ext:member="registerType" href="output/Ext.ComponentMgr.html#Ext.ComponentMgr-registerType">Ext.ComponentMgr.registerType</a>
          in order to be able to take advantage of lazy
          instantiation and rendering.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An array of events that, when fired, should trigger
            this component to save its state (defaults to none). 
            <code>stateEvents</code> may be any type of event
            supported by this component, including browser or
            custom events (e.g., 
            <tt>['click', 'customerchange']</tt>).</p>
            <p>See 
            <code>
              <a ext:cls="Ext.Component" ext:member="stateful" href="output/Ext.Component.html#Ext.Component-stateful">stateful</a>
            </code> for an explanation of saving and restoring
            Component state.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Specify the id of the element, a DOM element or an
            existing Element corresponding to a DIV that is already
            present in the document that specifies some structural
            markup for this component.</p>
            <div>
              <ul>
                <li>
                <b>Description</b> : 
                <div style="margin-left: 2em">
                  <div class="sub-desc">When 
                  <tt>applyTo</tt> is used, constituent parts of
                  the component can also be specified by id or CSS
                  class name within the main element, and the
                  component being created may attempt to create its
                  subcomponents from that markup if
                  applicable.</div>
                </div>
</li>
                <li>
                <b>Notes</b> : 
                <div style="margin-left: 2em">
                  <div class="sub-desc">When using this config, a
                  call to render() is not required.</div>
                  <div class="sub-desc">If applyTo is specified,
                  any value passed for 
                  <a ext:cls="Ext.Component" ext:member="renderTo" href="output/Ext.Component.html#Ext.Component-renderTo">renderTo</a> will be
                  ignored and the target element's parent node will
                  automatically be used as the component's
                  container.</div>
                </div>
</li>
              </ul>
            </div>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An array of events that, when fired, should be
            bubbled to any parent container. See 
            <a ext:cls="Ext.util.Observable" ext:member="enableBubble" href="output/Ext.util.Observable.html#Ext.util.Observable-enableBubble">Ext.util.Observable.enableBubble</a>.
            Defaults to 
            <tt>[]</tt>.</p>
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An optional extra CSS class that will
          be added to this component's Element (defaults to '').
          This can be useful for adding customized styles to the
          component or any of its children using standard CSS
          rules.</div>

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
<div class="long">
            <p>How this component should be hidden. Supported
            values are 
            <tt>'visibility'</tt> (css visibility), 
            <tt>'offsets'</tt> (negative offset position) and 
            <tt>'display'</tt> (css display).</p>
            <br/>
            <p>
            <b>Note</b>: the default of 
            <tt>'display'</tt> is generally preferred since items
            are automatically laid out when they are first shown
            (no sizing is done while hidden).</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to hide and show the component's
          container when hide/show is called on the component,
          false to hide and show the component itself (defaults to
          false). For example, this can be used as a shortcut for a
          hide button on a window by setting hide:true on the
          button when adding it to its parent container.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>An optional extra CSS class that will be added to this
          component's container. This can be useful for adding
          customized styles to the container or any of its children
          using standard CSS rules. See 
          <a ext:cls="Ext.layout.ContainerLayout" href="output/Ext.layout.ContainerLayout.html">Ext.layout.ContainerLayout</a>.
          <a ext:cls="Ext.layout.ContainerLayout" ext:member="extraCls" href="output/Ext.layout.ContainerLayout.html#Ext.layout.ContainerLayout-extraCls">extraCls</a>
          also.</p>
          <p>
          <b>Note</b>: 
          <tt>ctCls</tt> defaults to 
          <tt>''</tt> except for the following class which assigns
          a value by default:</p>
          <div class="mdetail-params">
            <ul>
              <li>
              <a ext:cls="Ext.layout.Box" href="output/Ext.layout.Box.html">Box Layout</a> : 
              <tt>'x-box-layout-ct'</tt>
</li>
            </ul>
          </div>To configure the above Class with an extra CSS
          class append to the default. For example, for BoxLayout
          (Hbox and Vbox):
<pre>
<code>ctCls: 
<em>'x-box-layout-ct custom-class'</em>
</code>
          </pre>
          <br/>
          <br/>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An 
            <tt>itemId</tt> can be used as an alternative way to
            get a reference to a component when no object reference
            is available. Instead of using an 
            <code>
              <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>
            </code> with 
            <a ext:cls="Ext" href="output/Ext.html">Ext</a>.
            <a ext:cls="Ext" ext:member="getCmp" href="output/Ext.html#Ext-getCmp">getCmp</a>, use 
            <code>itemId</code> with 
            <a ext:cls="Ext.Container" href="output/Ext.Container.html">Ext.Container</a>.
            <a ext:cls="Ext.Container" ext:member="getComponent" href="output/Ext.Container.html#Ext.Container-getComponent">getComponent</a> which will
            retrieve 
            <code>itemId</code>'s or 
            <tt>
              <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>
            </tt>'s. Since 
            <code>itemId</code>'s are an index to the container's
            internal MixedCollection, the 
            <code>itemId</code> is scoped locally to the container
            -- avoiding potential conflicts with 
            <a ext:cls="Ext.ComponentMgr" href="output/Ext.ComponentMgr.html">Ext.ComponentMgr</a> which
            requires a 
            <b>unique</b> 
            <code>
              <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>
            </code>.</p>
<pre>
<code>
<b>var</b> c = 
<b>new</b> Ext.Panel({ 
<i>//</i>
    
<a ext:cls="Ext.BoxComponent" ext:member="height" href="output/Ext.BoxComponent.html#Ext.BoxComponent-height">height</a>: 300,
    
<a ext:cls="Ext.Component" ext:member="renderTo" href="output/Ext.Component.html#Ext.Component-renderTo">renderTo</a>:
document.body,
    
<a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>: 
<em>'auto'</em>,
    
<a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>: [
        {
            itemId: 
<em>'p1'</em>,
            
<a ext:cls="Ext.Panel" ext:member="title" href="output/Ext.Panel.html#Ext.Panel-title">title</a>: 
<em>'Panel 1'</em>,
            
<a ext:cls="Ext.BoxComponent" ext:member="height" href="output/Ext.BoxComponent.html#Ext.BoxComponent-height">height</a>: 150
        },
        {
            itemId: 
<em>'p2'</em>,
            
<a ext:cls="Ext.Panel" ext:member="title" href="output/Ext.Panel.html#Ext.Panel-title">title</a>: 
<em>'Panel 2'</em>,
            
<a ext:cls="Ext.BoxComponent" ext:member="height" href="output/Ext.BoxComponent.html#Ext.BoxComponent-height">height</a>: 150
        }
    ]
})
p1 = c.
<a ext:cls="Ext.Container" ext:member="getComponent" href="output/Ext.Container.html#Ext.Container-getComponent">getComponent</a>(
<em>'p1'</em>); 
<i>// not the same as 
<a ext:cls="Ext" ext:member="getCmp" href="output/Ext.html#Ext-getCmp">Ext.getCmp()</a>
</i>
p2 = p1.
<a ext:cls="Ext.Component" ext:member="ownerCt" href="output/Ext.Component.html#Ext.Component-ownerCt">ownerCt</a>.
<a ext:cls="Ext.Container" ext:member="getComponent" href="output/Ext.Container.html#Ext.Container-getComponent">getComponent</a>(
<em>'p2'</em>); 
<i>// reference via a sibling</i>
</code>
            </pre>
            <p>Also see 
            <tt>
              <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a>
            </tt> and 
            <code>
              <a ext:cls="Ext.Component" ext:member="ref" href="output/Ext.Component.html#Ext.Component-ref">ref</a>
            </code>.</p>
            <p>
            <b>Note</b>: to access the container of an item see 
            <tt>
              <a ext:cls="Ext.Component" ext:member="ownerCt" href="output/Ext.Component.html#Ext.Component-ownerCt">ownerCt</a>
            </tt>.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>
          <tt>true</tt> to completely hide the label element (
          <a ext:cls="Ext.Component" ext:member="fieldLabel" href="output/Ext.Component.html#Ext.Component-fieldLabel">label</a>
          and 
          <a ext:cls="Ext.Component" ext:member="labelSeparator" href="output/Ext.Component.html#Ext.Component-labelSeparator">separator</a>). Defaults to 
          <tt>false</tt>. By default, even if you do not specify a 
          <tt>
            <a ext:cls="Ext.Component" ext:member="fieldLabel" href="output/Ext.Component.html#Ext.Component-fieldLabel">fieldLabel</a>
          </tt> the space will still be reserved so that the field
          will line up with other fields that do have labels.
          Setting this to 
          <tt>true</tt> will cause the field to not reserve that
          space.</p>
          <br/>
          <p>
          <b>Note</b>: see the note for 
          <tt>
            <a ext:cls="Ext.Component" ext:member="clearCls" href="output/Ext.Component.html#Ext.Component-clearCls">clearCls</a>
          </tt>.</p>
          <br/>Example use:
<pre>
<code>
<b>new</b> Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
<em>'textfield'</em>
        hideLabel: true
    }]
});</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A tag name or 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> spec used to
            create the 
            <a ext:cls="Ext.Component" ext:member="getEl" href="output/Ext.Component.html#Ext.Component-getEl">Element</a>
            which will encapsulate this Component.</p>
            <p>You do not normally need to specify this. For the
            base classes 
            <a ext:cls="Ext.Component" href="output/Ext.Component.html">Ext.Component</a>, 
            <a ext:cls="Ext.BoxComponent" href="output/Ext.BoxComponent.html">Ext.BoxComponent</a>, and 
            <a ext:cls="Ext.Container" href="output/Ext.Container.html">Ext.Container</a>, this
            defaults to 
            <b>
              <tt>'div'</tt>
            </b>. The more complex Ext classes use a more complex
            DOM structure created by their own onRender
            methods.</p>
            <p>This is intended to allow the developer to create
            application-specific utility Components encapsulated by
            different DOM elements. Example usage:</p>
<pre>
<code>{
    xtype: 
<em>'box'</em>,
    autoEl: {
        tag: 
<em>'img'</em>,
        src: 
<em>'http:
<i>//www.example.com/example.jpg'</i>
</em>
    }
}, {
    xtype: 
<em>'box'</em>,
    autoEl: {
        tag: 
<em>'blockquote'</em>,
        html: 
<em>'autoEl is cool!'</em>
    }
}, {
    xtype: 
<em>'container'</em>,
    autoEl: 
<em>'ul'</em>,
    cls: 
<em>'ux-unordered-list'</em>,
    items: {
        xtype: 
<em>'box'</em>,
        autoEl: 
<em>'li'</em>,
        html: 
<em>'First list item'</em>
    }
}</code>
            </pre>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A path specification, relative to the Component's 
            <code>
              <a ext:cls="Ext.Component" ext:member="ownerCt" href="output/Ext.Component.html#Ext.Component-ownerCt">ownerCt</a>
            </code> specifying into which ancestor Container to
            place a named reference to this Component.</p>
            <p>The ancestor axis can be traversed by using '/'
            characters in the path. For example, to put a reference
            to a Toolbar Button into 
            <i>the Panel which owns the Toolbar</i>:</p>
<pre>
<code>
<b>var</b> myGrid = 
<b>new</b> Ext.grid.EditorGridPanel({
    title: 
<em>'My EditorGridPanel'</em>,
    store: myStore,
    colModel: myColModel,
    tbar: [{
        text: 
<em>'Save'</em>,
        handler: saveChanges,
        disabled: true,
        ref: 
<em>'../saveButton'</em>
    }],
    listeners: {
        afteredit: 
<b>function</b>() {
<i>//          The button reference is 
<b>in</b> the GridPanel</i>
            myGrid.saveButton.enable();
        }
    }
});</code>
            </pre>
            <p>In the code above, if the 
            <code>ref</code> had been 
            <code>
              <em>'saveButton'</em>
            </code> the reference would have been placed into the
            Toolbar. Each '/' in the 
            <code>ref</code> moves up one level from the
            Component's 
            <code>
              <a ext:cls="Ext.Component" ext:member="ownerCt" href="output/Ext.Component.html#Ext.Component-ownerCt">ownerCt</a>
            </code>.</p>
            <p>Also see the 
            <code>
              <a ext:cls="Ext.Component" ext:member="added" href="output/Ext.Component.html#Ext.Component-added">added</a>
            </code> and 
            <code>
              <a ext:cls="Ext.Component" ext:member="removed" href="output/Ext.Component.html#Ext.Component-removed">removed</a>
            </code> events.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Specify the id of the element, a DOM element or an
            existing Element that this component will be rendered
            into.</p>
            <div>
              <ul>
                <li>
                <b>Notes</b> : 
                <div style="margin-left: 2em">
                  <div class="sub-desc">Do 
                  <u>not</u> use this option if the Component is to
                  be a child item of a 
                  <a ext:cls="Ext.Container" href="output/Ext.Container.html">Container</a>. It is the
                  responsibility of the 
                  <a ext:cls="Ext.Container" href="output/Ext.Container.html">Container</a>'s 
                  <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout manager</a> to
                  render and manage its child items.</div>
                  <div class="sub-desc">When using this config, a
                  call to render() is not required.</div>
                </div>
</li>
              </ul>
            </div>
            <p>See 
            <tt>
              <a ext:cls="Ext.Component" ext:member="render" href="output/Ext.Component.html#Ext.Component-render">render</a>
            </tt> also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>
          <b>Note</b>: this config is only used when this Component
          is rendered by a Container which has been configured to
          use the 
          <b>
            <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">FormLayout</a>
          </b> layout manager (e.g. 
          <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">Ext.form.FormPanel</a> or
          specifying 
          <tt>layout:'form'</tt>).</p>
          <br/>
          <p>An additional CSS class to apply to the div wrapping
          the form item element of this field. If supplied, 
          <tt>itemCls</tt> at the 
          <b>field</b> level will override the default 
          <tt>itemCls</tt> supplied at the 
          <b>container</b> level. The value specified for 
          <tt>itemCls</tt> will be added to the default class (
          <tt>'x-form-item'</tt>).</p>
          <p>Since it is applied to the item wrapper (see 
          <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>.
          <a ext:cls="Ext.layout.FormLayout" ext:member="fieldTpl" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-fieldTpl">fieldTpl</a>), it allows
          you to write standard CSS rules that can apply to the
          field, the label (if specified), or any other element
          within the markup for the field.</p>
          <br/>
          <p>
          <b>Note</b>: see the note for 
          <tt>
            <a ext:cls="Ext.Component" ext:member="fieldLabel" href="output/Ext.Component.html#Ext.Component-fieldLabel">fieldLabel</a>
          </tt>.</p>
          <br/>Example use:
<pre>
<code>
<i>// Apply a style to the field's 
<b>label</b>:</i>
&lt;style&gt;
    .required .x-form-item-
<b>label</b> {font-weight:bold;color:red;}
&lt;/style&gt;

<b>new</b> Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    items: [{
        xtype: 
<em>'textfield'</em>,
        fieldLabel: 
<em>'Name'</em>,
        itemCls: 
<em>'required'</em> 
<i>//this 
<b>label</b> will be styled</i>
    },{
        xtype: 
<em>'textfield'</em>,
        fieldLabel: 
<em>'Favorite Color'</em>
    }]
});</code>
          </pre>
</div>

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
<div class="long">The unique id for this component to use
          for state management purposes (defaults to the component
          id if one was set, otherwise null if the component is
          using a generated id). 
          <p>See 
          <code>
            <a ext:cls="Ext.Component" ext:member="stateful" href="output/Ext.Component.html#Ext.Component-stateful">stateful</a>
          </code> for an explanation of saving and restoring
          Component state.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An 
          <a ext:cls="Ext.Template" href="output/Ext.Template.html">Ext.Template</a>, 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> or an array of
          strings to form an Ext.XTemplate. Used in conjunction
          with the 
          <code>
            <a ext:cls="Ext.Component" ext:member="data" href="output/Ext.Component.html#Ext.Component-data">data</a>
          </code> and 
          <code>
            <a ext:cls="Ext.Component" ext:member="tplWriteMode" href="output/Ext.Component.html#Ext.Component-tplWriteMode">tplWriteMode</a>
          </code> configurations.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>The separator to display after the text of each 
          <tt>
            <a ext:cls="Ext.Component" ext:member="fieldLabel" href="output/Ext.Component.html#Ext.Component-fieldLabel">fieldLabel</a>
          </tt>. This property may be configured at various levels.
          The order of precedence is:</p>
          <div class="mdetail-params">
            <ul>
              <li>field / component level</li>
              <li>container level</li>
              <li>
              <a ext:cls="Ext.layout.FormLayout" ext:member="labelSeparator" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelSeparator">layout level</a>
              (defaults to colon 
              <tt>':'</tt>)</li>
            </ul>
          </div>To display no separator for this field's label
          specify empty string ''.
          <br/>
          <br/>
          <br/>
          <p>
          <b>Note</b>: see the note for 
          <tt>
            <a ext:cls="Ext.Component" ext:member="clearCls" href="output/Ext.Component.html#Ext.Component-clearCls">clearCls</a>
          </tt>.</p>
          <br/>
          <p>Also see 
          <tt>
            <a ext:cls="Ext.Component" ext:member="hideLabel" href="output/Ext.Component.html#Ext.Component-hideLabel">hideLabel</a>
          </tt> and 
          <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>.
          <a ext:cls="Ext.layout.FormLayout" ext:member="fieldTpl" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-fieldTpl">fieldTpl</a>.</p>Example
          use:
<pre>
<code>
<b>new</b> Ext.FormPanel({
    height: 100,
    renderTo: Ext.getBody(),
    layoutConfig: {
        labelSeparator: 
<em>'~'</em>   
<i>// layout config has lowest priority (defaults to 
<em>':'</em>)</i>
    },
    
<a ext:cls="Ext.layout.FormLayout" ext:member="labelSeparator" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelSeparator">labelSeparator</a>: 
<em>'&gt;&gt;'</em>,     
<i>// config at container level</i>
    items: [{
        xtype: 
<em>'textfield'</em>,
        fieldLabel: 
<em>'Field 1'</em>,
        labelSeparator: 
<em>'...'</em> 
<i>// field/component level config supersedes others</i>
    },{
        xtype: 
<em>'textfield'</em>,
        fieldLabel: 
<em>'Field 2'</em> 
<i>// labelSeparator will be 
<em>'='</em>
</i>
    }]
});</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The Ext.(X)Template method to use when
          updating the content area of the Component. Defaults to 
          <tt>'overwrite'</tt> (see 
          <code>
            <a ext:cls="Ext.XTemplate" ext:member="overwrite" href="output/Ext.XTemplate.html#Ext.XTemplate-overwrite">Ext.XTemplate.overwrite</a>
          </code>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An HTML fragment, or a 
          <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> specification to
          use as the layout element content (defaults to ''). The
          HTML content is added after the component is rendered, so
          the document will not contain this HTML at the time the 
          <a ext:cls="Ext.Component" ext:member="render" href="output/Ext.Component.html#Ext.Component-render">render</a>
          event is fired. This content is inserted into the body 
          <i>before</i> any configured 
          <a ext:cls="Ext.Component" ext:member="contentEl" href="output/Ext.Component.html#Ext.Component-contentEl">contentEl</a> is appended.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Optional. Specify an existing HTML element, or the 
            <code>id</code> of an existing HTML element to use as
            the content for this component.</p>
            <ul>
              <li>
              <b>Description</b> : 
              <div class="sub-desc">This config option is used to
              take an existing HTML element and place it in the
              layout element of a new component (it simply moves
              the specified DOM element 
              <i>after the Component is rendered</i> to use as the
              content.</div>
</li>
              <li>
              <b>Notes</b> : 
              <div class="sub-desc">The specified HTML element is
              appended to the layout element of the component 
              <i>after any configured 
              <a ext:cls="Ext.Component" ext:member="html" href="output/Ext.Component.html#Ext.Component-html">HTML</a>
              has been inserted</i>, and so the document will not
              contain this element at the time the 
              <a ext:cls="Ext.Component" ext:member="render" href="output/Ext.Component.html#Ext.Component-render">render</a> event is
              fired.</div>
              <div class="sub-desc">The specified HTML element used
              will not participate in any 
              <code>
                <b>
                  <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
                </b>
              </code> scheme that the Component may use. It is just
              HTML. Layouts operate on child 
              <code>
                <b>
                  <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>
                </b>
              </code>.</div>
              <div class="sub-desc">Add either the 
              <code>x-hidden</code> or the 
              <code>x-hide-display</code> CSS class to prevent a
              brief flicker of the content before it is rendered to
              the panel.</div>
</li>
            </ul>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The registered 
          <tt>ptype</tt> to create. This config option is not used
          when passing a config object into a constructor. This
          config option is used only when lazy instantiation is
          being used, and a Plugin is being specified not as a
          fully instantiated Component, but as a 
          <i>Component config object</i>. The 
          <tt>ptype</tt> will be looked up at render time up to
          determine what type of Plugin to create.
          <br/>
          <br/>If you create your own Plugins, you may register
          them using 
          <a ext:cls="Ext.ComponentMgr" ext:member="registerPlugin" href="output/Ext.ComponentMgr.html#Ext.ComponentMgr-registerPlugin">Ext.ComponentMgr.registerPlugin</a>
          in order to be able to take advantage of lazy
          instantiation and rendering.</div>

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