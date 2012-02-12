package ext.form;

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
  <p>A combobox control with support for autocomplete,
  remote-loading, paging and many other features.</p>
  <p>A ComboBox works in a similar manner to a traditional HTML
  &lt;select&gt; field. The difference is that to submit the 
  <a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a>, you must specify a 
  <a ext:cls="Ext.form.ComboBox" ext:member="hiddenName" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-hiddenName">hiddenName</a> to create a hidden
  input field to hold the value of the valueField. The 
  <i>
    <a ext:cls="Ext.form.ComboBox" ext:member="displayField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-displayField">displayField</a>
  </i> is shown in the text field which is named according to the 
  <a ext:cls="Ext.form.ComboBox" ext:member="name" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-name">name</a>.</p>
  <p>
    <b>
      <u>Events</u>
    </b>
  </p>
  <p>To do something when something in ComboBox is selected,
  configure the select event:</p>
<pre>
<code>
<b>var</b> cb = 
<b>new</b> Ext.form.ComboBox({
    
<i>// all of your config options</i>
    listeners:{
         scope: yourScope,
         
<em>'select'</em>: yourFunction
    }
});

<i>// Alternatively, you can assign events after the object is
created:</i>
<b>var</b> cb = 
<b>new</b> Ext.form.ComboBox(yourOptions);
cb.on(
<em>'select'</em>, yourFunction, yourScope);</code>
  </pre>
  <br/>
  <br/> 
  <p>
    <b>
      <u>ComboBox in Grid</u>
    </b>
  </p>
  <p>If using a ComboBox in an 
  <a ext:cls="Ext.grid.EditorGridPanel" href="output/Ext.grid.EditorGridPanel.html">Editor Grid</a> a 
  <a ext:cls="Ext.grid.Column" ext:member="renderer" href="output/Ext.grid.Column.html#Ext.grid.Column-renderer">renderer</a> will
  be needed to show the displayField when the editor is not active.
  Set up the renderer manually, or implement a reusable render, for
  example:</p>
<pre>
<code>
<i>// create reusable renderer</i>
Ext.util.Format.comboRenderer = 
<b>function</b>(combo){
    
<b>return</b> 
<b>function</b>(value){
        
<b>var</b> record = combo.findRecord(combo.
<a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a>,
value);
        
<b>return</b> record ? record.get(combo.
<a ext:cls="Ext.form.ComboBox" ext:member="displayField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-displayField">displayField</a>) : combo.
<a ext:cls="Ext.form.ComboBox" ext:member="valueNotFoundText" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueNotFoundText">valueNotFoundText</a>;
    }
}

<i>// create the combo instance</i>
<b>var</b> combo = 
<b>new</b> Ext.form.ComboBox({
    
<a ext:cls="Ext.form.ComboBox" ext:member="typeAhead" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-typeAhead">typeAhead</a>:
true,
    
<a ext:cls="Ext.form.ComboBox" ext:member="triggerAction" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-triggerAction">triggerAction</a>: 
<em>'all'</em>,
    
<a ext:cls="Ext.form.ComboBox" ext:member="lazyRender" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-lazyRender">lazyRender</a>:true,
    
<a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a>: 
<em>'local'</em>,
    
<a ext:cls="Ext.form.ComboBox" ext:member="store" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-store">store</a>: 
<b>new</b> Ext.data.ArrayStore({
        id: 0,
        fields: [
            
<em>'myId'</em>,
            
<em>'displayText'</em>
        ],
        data: [[1, 
<em>'item1'</em>], [2, 
<em>'item2'</em>]]
    }),
    
<a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a>:

<em>'myId'</em>,
    
<a ext:cls="Ext.form.ComboBox" ext:member="displayField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-displayField">displayField</a>: 
<em>'displayText'</em>
});

<i>// snippet of column model used within grid</i>
<b>var</b> cm = 
<b>new</b> Ext.grid.ColumnModel([{
       ...
    },{
       header: 
<em>"Some Header"</em>,
       dataIndex: 
<em>'whatever'</em>,
       width: 130,
       editor: combo, 
<i>// specify reference to combo instance</i>
       renderer: Ext.util.Format.comboRenderer(combo) 
<i>// pass combo instance to reusable renderer</i>
    },
    ...
]);</code>
  </pre>
  <br/>
  <br/> 
  <p>
    <b>
      <u>Filtering</u>
    </b>
  </p>
  <p>A ComboBox 
  <a ext:cls="Ext.form.ComboBox" ext:member="doQuery" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-doQuery">uses filtering
  itself</a>, for information about filtering the ComboBox store
  manually see 
  <tt>
    <a ext:cls="Ext.form.ComboBox" ext:member="lastQuery" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-lastQuery">lastQuery</a>
  </tt>.</p>
</div>

 */
@XType("combo")
@InstanceOf("Ext.form.ComboBox")

@FacesComponent(value = "Ext.form.ComboBox")
public class ComboBox extends TriggerField {
	public static final String COMPONENT_FAMILY = "Ext.form.ComboBox";

	/**
	 * <p>
	 * Create a new {@link Ext.form.ComboBox} instance with default property values.
	 * </p>
	 */
	public ComboBox() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			hiddenValue
			,handleHeight
			,store
			,allQuery
			,valueNotFoundText
			,autoSelect
			,autoCreate
			,listWidth
			,loadingText
			,clearFilterOnReset
			,forceSelection
			,mode
			,itemSelector
			,transform
			,title
			,submitValue
			,queryParam
			,displayField
			,shadow
			,valueField
			,resizable
			,triggerAction
			,selectOnFocus
			,listClass
			,minChars
			,lazyInit
			,queryDelay
			,typeAheadDelay
			,hiddenId
			,pageSize
			,selectedClass
			,listEmptyText
			,minListWidth
			,minHeight
			,hiddenName
			,lazyRender
			,tpl
			,maxHeight
			,typeAhead
			,triggerClass
			,listAlign
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
<div class="long">Sets the initial value of the hidden
          field if 
          <a ext:cls="Ext.form.ComboBox" ext:member="hiddenName" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-hiddenName">hiddenName</a> is specified
          to contain the selected 
          <a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a>, from the
          Store. Defaults to the configured 
          <tt>
            <a ext:cls="Ext.form.Field" ext:member="value" href="output/Ext.form.Field.html#Ext.form.Field-value">value</a>
          </tt>.</div>

	 */
	
	public String getHiddenValue () {
		return (String) getStateHelper().eval(PropertyKeys.hiddenValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>hiddenValue</code> property.
	 * </p>
	 */
	public void setHiddenValue ( String   hiddenValue ) {
		getStateHelper().put(PropertyKeys.hiddenValue, hiddenValue);
		handleAttribute("hiddenValue", hiddenValue);
	}
    	/*
	 *
        
        
          handleHeight
         : Number
        The height in pixels of the dropdown
        list resize handle if 
        
        resizable = true
        (defaults to 
        8)
	 */
	
	public Integer getHandleHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.handleHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>handleHeight</code> property.
	 * </p>
	 */
	public void setHandleHeight ( Integer   handleHeight ) {
		getStateHelper().put(PropertyKeys.handleHeight, handleHeight);
		handleAttribute("handleHeight", handleHeight);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The data source to which this combo is
          bound (defaults to 
          <tt>undefined</tt>). Acceptable values for this property
          are: 
          <div class="mdetail-params">
            <ul>
              <li>
                <b>any 
                <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a> subclass</b>
              </li>
              <li>
              <b>an Array</b> : Arrays will be converted to a 
              <a ext:cls="Ext.data.ArrayStore" href="output/Ext.data.ArrayStore.html">Ext.data.ArrayStore</a>
              internally, automatically generating 
              <a ext:cls="Ext.data.Field" ext:member="name" href="output/Ext.data.Field.html#Ext.data.Field-name">field
              names</a> to work with all data components. 
              <div class="mdetail-params">
                <ul>
                  <li>
                  <b>1-dimensional array</b> : (e.g., 
                  <tt>['Foo','Bar']</tt>)
                  <div class="sub-desc">A 1-dimensional array will
                  automatically be expanded (each array item will
                  be used for both the combo 
                  <a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a> and 
                  <a ext:cls="Ext.form.ComboBox" ext:member="displayField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-displayField">displayField</a>)</div>
</li>
                  <li>
                  <b>2-dimensional array</b> : (e.g., 
                  <tt>[['f','Foo'],['b','Bar']]</tt>)
                  <div class="sub-desc">For a multi-dimensional
                  array, the value in index 0 of each item will be
                  assumed to be the combo 
                  <a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a>, while
                  the value at index 1 is assumed to be the combo 
                  <a ext:cls="Ext.form.ComboBox" ext:member="displayField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-displayField">displayField</a>.</div>
</li>
                </ul>
              </div>
</li>
            </ul>
          </div>
          <p>See also 
          <tt>
            <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a>
          </tt>.</p>
</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getStore () {
		return (Object) getStateHelper().eval(PropertyKeys.store);
	}

	/**
	 * <p>
	 * Set the value of the <code>store</code> property.
	 * </p>
	 */
	public void setStore ( Object   store ) {
		getStateHelper().put(PropertyKeys.store, store);
		handleAttribute("store", store);
	}
    	/*
	 *
        
        
          allQuery
         : String
        The text query to send to the server to
        return all records for the list with no filtering (defaults
        to '')
	 */
	
	public String getAllQuery () {
		return (String) getStateHelper().eval(PropertyKeys.allQuery);
	}

	/**
	 * <p>
	 * Set the value of the <code>allQuery</code> property.
	 * </p>
	 */
	public void setAllQuery ( String   allQuery ) {
		getStateHelper().put(PropertyKeys.allQuery, allQuery);
		handleAttribute("allQuery", allQuery);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">When using a name/value combo, if the
          value passed to setValue is not found in the store,
          valueNotFoundText will be displayed as the field text if
          defined (defaults to undefined). If this default text is
          used, it means there is no value set and no validation
          will occur on this field.</div>

	 */
	
	public String getValueNotFoundText () {
		return (String) getStateHelper().eval(PropertyKeys.valueNotFoundText);
	}

	/**
	 * <p>
	 * Set the value of the <code>valueNotFoundText</code> property.
	 * </p>
	 */
	public void setValueNotFoundText ( String   valueNotFoundText ) {
		getStateHelper().put(PropertyKeys.valueNotFoundText, valueNotFoundText);
		handleAttribute("valueNotFoundText", valueNotFoundText);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to select the first result gathered by the
          data store (defaults to 
          <tt>true</tt>). A false value would require a manual
          selection from the dropdown list to set the components
          value unless the value of (
          <a ext:cls="Ext.form.ComboBox" ext:member="typeAheadDelay" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-typeAheadDelay">typeAheadDelay</a>) were
          true.</div>

	 */
	
	public Boolean getAutoSelect () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoSelect);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoSelect</code> property.
	 * </p>
	 */
	public void setAutoSelect ( Boolean   autoSelect ) {
		getStateHelper().put(PropertyKeys.autoSelect, autoSelect);
		handleAttribute("autoSelect", autoSelect);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element spec, or 
            <tt>true</tt> for a default element spec. Used to
            create the 
            <a ext:cls="Ext.Component" ext:member="getEl" href="output/Ext.Component.html#Ext.Component-getEl">Element</a>
            which will encapsulate this Component. See 
            <tt>
              <a ext:cls="Ext.Component" ext:member="autoEl" href="output/Ext.Component.html#Ext.Component-autoEl">autoEl</a>
            </tt> for details. Defaults to:</p>
<pre>
<code>{tag: 
<em>"input"</em>, type: 
<em>"text"</em>, size: 
<em>"24"</em>, autocomplete: 
<em>"off"</em>}</code>
            </pre>
          </div>

	 */
	
	public String getAutoCreate () {
		return (String) getStateHelper().eval(PropertyKeys.autoCreate);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoCreate</code> property.
	 * </p>
	 */
	public void setAutoCreate ( String   autoCreate ) {
		getStateHelper().put(PropertyKeys.autoCreate, autoCreate);
		handleAttribute("autoCreate", autoCreate);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The width (used as a parameter to 
          <a ext:cls="Ext.Element" ext:member="setWidth" href="output/Ext.Element.html#Ext.Element-setWidth">Ext.Element.setWidth</a>) of the
          dropdown list (defaults to the width of the ComboBox
          field). See also 
          <tt>
            <a ext:cls="Ext.form.ComboBox" ext:member="minListWidth" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-minListWidth">minListWidth</a>
          </tt>
</div>

	 */
	
	public Integer getListWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.listWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>listWidth</code> property.
	 * </p>
	 */
	public void setListWidth ( Integer   listWidth ) {
		getStateHelper().put(PropertyKeys.listWidth, listWidth);
		handleAttribute("listWidth", listWidth);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The text to display in the dropdown
          list while data is loading. Only applies when 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'remote'</tt> (defaults to 
          <tt>'Loading...'</tt>)</div>

	 */
	
	public String getLoadingText () {
		return (String) getStateHelper().eval(PropertyKeys.loadingText);
	}

	/**
	 * <p>
	 * Set the value of the <code>loadingText</code> property.
	 * </p>
	 */
	public void setLoadingText ( String   loadingText ) {
		getStateHelper().put(PropertyKeys.loadingText, loadingText);
		handleAttribute("loadingText", loadingText);
	}
    	/*
	 *
        
        
          clearFilterOnReset
         : Boolean
        
        true to clear any filters on the store (when in
        local mode) when reset is called (defaults to 
        true)
	 */
	
	public Boolean getClearFilterOnReset () {
		return (Boolean) getStateHelper().eval(PropertyKeys.clearFilterOnReset);
	}

	/**
	 * <p>
	 * Set the value of the <code>clearFilterOnReset</code> property.
	 * </p>
	 */
	public void setClearFilterOnReset ( Boolean   clearFilterOnReset ) {
		getStateHelper().put(PropertyKeys.clearFilterOnReset, clearFilterOnReset);
		handleAttribute("clearFilterOnReset", clearFilterOnReset);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to restrict the selected value to one of
          the values in the list, 
          <tt>false</tt> to allow the user to set arbitrary text
          into the field (defaults to 
          <tt>false</tt>)</div>

	 */
	
	public Boolean getForceSelection () {
		return (Boolean) getStateHelper().eval(PropertyKeys.forceSelection);
	}

	/**
	 * <p>
	 * Set the value of the <code>forceSelection</code> property.
	 * </p>
	 */
	public void setForceSelection ( Boolean   forceSelection ) {
		getStateHelper().put(PropertyKeys.forceSelection, forceSelection);
		handleAttribute("forceSelection", forceSelection);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Acceptable values are: 
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>'remote'</tt>
              </b> : 
              <b>Default</b> 
              <p class="sub-desc">Automatically loads the 
              <tt>
                <a ext:cls="Ext.form.ComboBox" ext:member="store" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-store">store</a>
              </tt> the 
              <b>first</b> time the trigger is clicked. If you do
              not want the store to be automatically loaded the
              first time the trigger is clicked, set to 
              <tt>'local'</tt> and manually load the store. To
              force a requery of the store 
              <b>every</b> time the trigger is clicked see 
              <tt>
                <a ext:cls="Ext.form.ComboBox" ext:member="lastQuery" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-lastQuery">lastQuery</a>
              </tt>.</p>
</li>
              <li>
              <b>
                <tt>'local'</tt>
              </b> : 
              <p class="sub-desc">ComboBox loads local data</p>
<pre>
<code>
<b>var</b> combo = 
<b>new</b> Ext.form.ComboBox({
    renderTo: document.body,
    mode: 
<em>'local'</em>,
    store: 
<b>new</b> Ext.data.ArrayStore({
        id: 0,
        fields: [
            
<em>'myId'</em>,  
<i>// numeric value is the key</i>
            
<em>'displayText'</em>
        ],
        data: [[1, 
<em>'item1'</em>], [2, 
<em>'item2'</em>]]  
<i>// data is local</i>
    }),
    valueField: 
<em>'myId'</em>,
    displayField: 
<em>'displayText'</em>,
    triggerAction: 
<em>'all'</em>
});</code>
              </pre>
</li>
            </ul>
          </div>
</div>

	 */
	
	public String getMode () {
		return (String) getStateHelper().eval(PropertyKeys.mode);
	}

	/**
	 * <p>
	 * Set the value of the <code>mode</code> property.
	 * </p>
	 */
	public void setMode ( String   mode ) {
		getStateHelper().put(PropertyKeys.mode, mode);
		handleAttribute("mode", mode);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>A simple CSS selector (e.g. div.some-class or
          span:first-child) that will be used to determine what
          nodes the 
          <a ext:cls="Ext.form.ComboBox" ext:member="view" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-view">Ext.DataView</a> which
          handles the dropdown display will be working with.</p>
          <p>
          <b>Note</b>: this setting is 
          <b>required</b> if a custom XTemplate has been specified
          in 
          <a ext:cls="Ext.form.ComboBox" ext:member="tpl" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-tpl">tpl</a>
          which assigns a class other than</p>
<pre>
'x-combo-list-item'
          </pre>to dropdown list items</div>

	 */
	
	public String getItemSelector () {
		return (String) getStateHelper().eval(PropertyKeys.itemSelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemSelector</code> property.
	 * </p>
	 */
	public void setItemSelector ( String   itemSelector ) {
		getStateHelper().put(PropertyKeys.itemSelector, itemSelector);
		handleAttribute("itemSelector", itemSelector);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The id, DOM node or element of an
          existing HTML SELECT to convert to a ComboBox. Note that
          if you specify this and the combo is going to be in an 
          <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Ext.form.BasicForm</a> or 
          <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">Ext.form.FormPanel</a>, you
          must also set 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="lazyRender" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-lazyRender">lazyRender</a> =
          true</tt>.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getTransform () {
		return (Object) getStateHelper().eval(PropertyKeys.transform);
	}

	/**
	 * <p>
	 * Set the value of the <code>transform</code> property.
	 * </p>
	 */
	public void setTransform ( Object   transform ) {
		getStateHelper().put(PropertyKeys.transform, transform);
		handleAttribute("transform", transform);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If supplied, a header element is
          created containing this text and added into the top of
          the dropdown list (defaults to undefined, with no header
          element)</div>

	 */
	
	public String getTitle () {
		return (String) getStateHelper().eval(PropertyKeys.title);
	}

	/**
	 * <p>
	 * Set the value of the <code>title</code> property.
	 * </p>
	 */
	public void setTitle ( String   title ) {
		getStateHelper().put(PropertyKeys.title, title);
		handleAttribute("title", title);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">False to clear the name attribute on
          the field so that it is not submitted during a form post.
          If a hiddenName is specified, setting this to true will
          cause both the hidden field and the element to be
          submitted. Defaults to 
          <tt>undefined</tt>.</div>

	 */
	
	public Boolean getSubmitValue () {
		return (Boolean) getStateHelper().eval(PropertyKeys.submitValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>submitValue</code> property.
	 * </p>
	 */
	public void setSubmitValue ( Boolean   submitValue ) {
		getStateHelper().put(PropertyKeys.submitValue, submitValue);
		handleAttribute("submitValue", submitValue);
	}
    	/*
	 *
        
        
          queryParam
         : String
        Name of the query (
        baseParam name for the store)
        as it will be passed on the querystring (defaults to 
        'query')
	 */
	
	public String getQueryParam () {
		return (String) getStateHelper().eval(PropertyKeys.queryParam);
	}

	/**
	 * <p>
	 * Set the value of the <code>queryParam</code> property.
	 * </p>
	 */
	public void setQueryParam ( String   queryParam ) {
		getStateHelper().put(PropertyKeys.queryParam, queryParam);
		handleAttribute("queryParam", queryParam);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The underlying 
          <a ext:cls="Ext.data.Field" ext:member="name" href="output/Ext.data.Field.html#Ext.data.Field-name">data field
          name</a> to bind to this ComboBox (defaults to undefined
          if 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'remote'</tt> or 
          <tt>'field1'</tt> if 
          <a ext:cls="Ext.form.ComboBox" ext:member="transform" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-transform">transforming a select</a> or
          if the 
          <a ext:cls="Ext.form.ComboBox" ext:member="store" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-store">field
          name is autogenerated based on the store
          configuration</a>). 
          <p>See also 
          <tt>
            <a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a>
          </tt>.</p>
          <p>
          <b>Note</b>: if using a ComboBox in an 
          <a ext:cls="Ext.grid.EditorGridPanel" href="output/Ext.grid.EditorGridPanel.html">Editor Grid</a> a 
          <a ext:cls="Ext.grid.Column" ext:member="renderer" href="output/Ext.grid.Column.html#Ext.grid.Column-renderer">renderer</a> will be needed to
          show the displayField when the editor is not
          active.</p>
</div>

	 */
	
	public String getDisplayField () {
		return (String) getStateHelper().eval(PropertyKeys.displayField);
	}

	/**
	 * <p>
	 * Set the value of the <code>displayField</code> property.
	 * </p>
	 */
	public void setDisplayField ( String   displayField ) {
		getStateHelper().put(PropertyKeys.displayField, displayField);
		handleAttribute("displayField", displayField);
	}
    	/*
	 *
        
        
          shadow
         : Boolean/String
        
        true or 
        "sides" for the default effect, 
        "frame" for 4-way shadow, and 
        "drop" for bottom-right
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The underlying 
          <a ext:cls="Ext.data.Field" ext:member="name" href="output/Ext.data.Field.html#Ext.data.Field-name">data value
          name</a> to bind to this ComboBox (defaults to undefined
          if 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'remote'</tt> or 
          <tt>'field2'</tt> if 
          <a ext:cls="Ext.form.ComboBox" ext:member="transform" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-transform">transforming a select</a> or
          if the 
          <a ext:cls="Ext.form.ComboBox" ext:member="store" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-store">field
          name is autogenerated based on the store
          configuration</a>). 
          <p>
          <b>Note</b>: use of a 
          <tt>valueField</tt> requires the user to make a selection
          in order for a value to be mapped. See also 
          <tt>
            <a ext:cls="Ext.form.ComboBox" ext:member="hiddenName" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-hiddenName">hiddenName</a>
          </tt>, 
          <tt>
            <a ext:cls="Ext.form.ComboBox" ext:member="hiddenValue" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-hiddenValue">hiddenValue</a>
          </tt>, and 
          <tt>
            <a ext:cls="Ext.form.ComboBox" ext:member="displayField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-displayField">displayField</a>
          </tt>.</p>
</div>

	 */
	
	public String getValueField () {
		return (String) getStateHelper().eval(PropertyKeys.valueField);
	}

	/**
	 * <p>
	 * Set the value of the <code>valueField</code> property.
	 * </p>
	 */
	public void setValueField ( String   valueField ) {
		getStateHelper().put(PropertyKeys.valueField, valueField);
		handleAttribute("valueField", valueField);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to add a resize handle to the bottom of the
          dropdown list (creates an 
          <a ext:cls="Ext.Resizable" href="output/Ext.Resizable.html">Ext.Resizable</a> with 'se' 
          <a ext:cls="Ext.Resizable" ext:member="pinned" href="output/Ext.Resizable.html#Ext.Resizable-pinned">pinned</a>
          handles). Defaults to 
          <tt>false</tt>.</div>

	 */
	
	public Boolean getResizable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.resizable);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizable</code> property.
	 * </p>
	 */
	public void setResizable ( Boolean   resizable ) {
		getStateHelper().put(PropertyKeys.resizable, resizable);
		handleAttribute("resizable", resizable);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The action to execute when the trigger
          is clicked. 
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>'query'</tt>
              </b> : 
              <b>Default</b> 
              <p class="sub-desc">
              <a ext:cls="Ext.form.ComboBox" ext:member="doQuery" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-doQuery">run
              the query</a> using the 
              <a ext:cls="Ext.form.Field" ext:member="getRawValue" href="output/Ext.form.Field.html#Ext.form.Field-getRawValue">raw value</a>.</p>
</li>
              <li>
              <b>
                <tt>'all'</tt>
              </b> : 
              <p class="sub-desc">
              <a ext:cls="Ext.form.ComboBox" ext:member="doQuery" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-doQuery">run
              the query</a> specified by the 
              <tt>
                <a ext:cls="Ext.form.ComboBox" ext:member="allQuery" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-allQuery">allQuery</a>
              </tt> config option</p>
</li>
            </ul>
          </div>
          <p>See also 
          <code>
            <a ext:cls="Ext.form.ComboBox" ext:member="queryParam" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-queryParam">queryParam</a>
          </code>.</p>
</div>

	 */
	
	public String getTriggerAction () {
		return (String) getStateHelper().eval(PropertyKeys.triggerAction);
	}

	/**
	 * <p>
	 * Set the value of the <code>triggerAction</code> property.
	 * </p>
	 */
	public void setTriggerAction ( String   triggerAction ) {
		getStateHelper().put(PropertyKeys.triggerAction, triggerAction);
		handleAttribute("triggerAction", triggerAction);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to select any existing text in the field
          immediately on focus. Only applies when 
          <tt>
          <a ext:cls="Ext.form.TriggerField" ext:member="editable" href="output/Ext.form.TriggerField.html#Ext.form.TriggerField-editable">editable</a> = true</tt>
          (defaults to 
          <tt>false</tt>).</div>

	 */
	
	public Boolean getSelectOnFocus () {
		return (Boolean) getStateHelper().eval(PropertyKeys.selectOnFocus);
	}

	/**
	 * <p>
	 * Set the value of the <code>selectOnFocus</code> property.
	 * </p>
	 */
	public void setSelectOnFocus ( Boolean   selectOnFocus ) {
		getStateHelper().put(PropertyKeys.selectOnFocus, selectOnFocus);
		handleAttribute("selectOnFocus", selectOnFocus);
	}
    	/*
	 *
        
        
          listClass
         : String
        The CSS class to add to the predefined 
        'x-combo-list' class applied the dropdown list
        element (defaults to '').
	 */
	
	public String getListClass () {
		return (String) getStateHelper().eval(PropertyKeys.listClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>listClass</code> property.
	 * </p>
	 */
	public void setListClass ( String   listClass ) {
		getStateHelper().put(PropertyKeys.listClass, listClass);
		handleAttribute("listClass", listClass);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The minimum number of characters the
          user must type before autocomplete and 
          <a ext:cls="Ext.form.ComboBox" ext:member="typeAhead" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-typeAhead">typeAhead</a> activate
          (defaults to 
          <tt>4</tt> if 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'remote'</tt> or 
          <tt>0</tt> if 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'local'</tt>, does not apply if 
          <tt>
          <a ext:cls="Ext.form.TriggerField" ext:member="editable" href="output/Ext.form.TriggerField.html#Ext.form.TriggerField-editable">editable</a> =
          false</tt>).</div>

	 */
	
	public Integer getMinChars () {
		return (Integer) getStateHelper().eval(PropertyKeys.minChars);
	}

	/**
	 * <p>
	 * Set the value of the <code>minChars</code> property.
	 * </p>
	 */
	public void setMinChars ( Integer   minChars ) {
		getStateHelper().put(PropertyKeys.minChars, minChars);
		handleAttribute("minChars", minChars);
	}
    	/*
	 *
        
        
          lazyInit
         : Boolean
        
        true to not initialize the list for this combo
        until the field is focused (defaults to 
        true)
	 */
	
	public Boolean getLazyInit () {
		return (Boolean) getStateHelper().eval(PropertyKeys.lazyInit);
	}

	/**
	 * <p>
	 * Set the value of the <code>lazyInit</code> property.
	 * </p>
	 */
	public void setLazyInit ( Boolean   lazyInit ) {
		getStateHelper().put(PropertyKeys.lazyInit, lazyInit);
		handleAttribute("lazyInit", lazyInit);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The length of time in milliseconds to
          delay between the start of typing and sending the query
          to filter the dropdown list (defaults to 
          <tt>500</tt> if 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'remote'</tt> or 
          <tt>10</tt> if 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'local'</tt>)</div>

	 */
	
	public Integer getQueryDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.queryDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>queryDelay</code> property.
	 * </p>
	 */
	public void setQueryDelay ( Integer   queryDelay ) {
		getStateHelper().put(PropertyKeys.queryDelay, queryDelay);
		handleAttribute("queryDelay", queryDelay);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The length of time in milliseconds to
          wait until the typeahead text is displayed if 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="typeAhead" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-typeAhead">typeAhead</a> = true</tt>
          (defaults to 
          <tt>250</tt>)</div>

	 */
	
	public Integer getTypeAheadDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.typeAheadDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>typeAheadDelay</code> property.
	 * </p>
	 */
	public void setTypeAheadDelay ( Integer   typeAheadDelay ) {
		getStateHelper().put(PropertyKeys.typeAheadDelay, typeAheadDelay);
		handleAttribute("typeAheadDelay", typeAheadDelay);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If 
          <tt>
            <a ext:cls="Ext.form.ComboBox" ext:member="hiddenName" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-hiddenName">hiddenName</a>
          </tt> is specified, 
          <tt>hiddenId</tt> can also be provided to give the hidden
          field a unique id. The 
          <tt>hiddenId</tt> and combo 
          <a ext:cls="Ext.Component" ext:member="id" href="output/Ext.Component.html#Ext.Component-id">id</a> should be
          different, since no two DOM nodes should share the same
          id.</div>

	 */
	
	public String getHiddenId () {
		return (String) getStateHelper().eval(PropertyKeys.hiddenId);
	}

	/**
	 * <p>
	 * Set the value of the <code>hiddenId</code> property.
	 * </p>
	 */
	public void setHiddenId ( String   hiddenId ) {
		getStateHelper().put(PropertyKeys.hiddenId, hiddenId);
		handleAttribute("hiddenId", hiddenId);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If greater than 
          <tt>0</tt>, a 
          <a ext:cls="Ext.PagingToolbar" href="output/Ext.PagingToolbar.html">Ext.PagingToolbar</a> is
          displayed in the footer of the dropdown list and the 
          <a ext:cls="Ext.form.ComboBox" ext:member="doQuery" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-doQuery">filter
          queries</a> will execute with page start and 
          <a ext:cls="Ext.PagingToolbar" ext:member="pageSize" href="output/Ext.PagingToolbar.html#Ext.PagingToolbar-pageSize">limit</a> parameters. Only
          applies when 
          <tt>
          <a ext:cls="Ext.form.ComboBox" ext:member="mode" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-mode">mode</a> =
          'remote'</tt> (defaults to 
          <tt>0</tt>).</div>

	 */
	
	public Integer getPageSize () {
		return (Integer) getStateHelper().eval(PropertyKeys.pageSize);
	}

	/**
	 * <p>
	 * Set the value of the <code>pageSize</code> property.
	 * </p>
	 */
	public void setPageSize ( Integer   pageSize ) {
		getStateHelper().put(PropertyKeys.pageSize, pageSize);
		handleAttribute("pageSize", pageSize);
	}
    	/*
	 *
        
        
          selectedClass
         : String
        CSS class to apply to the selected item
        in the dropdown list (defaults to 
        'x-combo-selected')
	 */
	
	public String getSelectedClass () {
		return (String) getStateHelper().eval(PropertyKeys.selectedClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>selectedClass</code> property.
	 * </p>
	 */
	public void setSelectedClass ( String   selectedClass ) {
		getStateHelper().put(PropertyKeys.selectedClass, selectedClass);
		handleAttribute("selectedClass", selectedClass);
	}
    	/*
	 *
        
        
          listEmptyText
         : String
        The empty text to display in the data
        view if no items are found. (defaults to '')
	 */
	
	public String getListEmptyText () {
		return (String) getStateHelper().eval(PropertyKeys.listEmptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>listEmptyText</code> property.
	 * </p>
	 */
	public void setListEmptyText ( String   listEmptyText ) {
		getStateHelper().put(PropertyKeys.listEmptyText, listEmptyText);
		handleAttribute("listEmptyText", listEmptyText);
	}
    	/*
	 *
        
        
          minListWidth
         : Number
        The minimum width of the dropdown list
        in pixels (defaults to 
        70, will be ignored if 
        
          listWidth
         has a higher value)
	 */
	
	public Integer getMinListWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minListWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minListWidth</code> property.
	 * </p>
	 */
	public void setMinListWidth ( Integer   minListWidth ) {
		getStateHelper().put(PropertyKeys.minListWidth, minListWidth);
		handleAttribute("minListWidth", minListWidth);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The minimum height in pixels of the
          dropdown list when the list is constrained by its
          distance to the viewport edges (defaults to 
          <tt>90</tt>)</div>

	 */
	
	public Integer getMinHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.minHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>minHeight</code> property.
	 * </p>
	 */
	public void setMinHeight ( Integer   minHeight ) {
		getStateHelper().put(PropertyKeys.minHeight, minHeight);
		handleAttribute("minHeight", minHeight);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If specified, a hidden form field with
          this name is dynamically generated to store the field's
          data value (defaults to the underlying DOM element's
          name). Required for the combo's value to automatically
          post during a form submission. See also 
          <a ext:cls="Ext.form.ComboBox" ext:member="valueField" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-valueField">valueField</a>.</div>

	 */
	
	public String getHiddenName () {
		return (String) getStateHelper().eval(PropertyKeys.hiddenName);
	}

	/**
	 * <p>
	 * Set the value of the <code>hiddenName</code> property.
	 * </p>
	 */
	public void setHiddenName ( String   hiddenName ) {
		getStateHelper().put(PropertyKeys.hiddenName, hiddenName);
		handleAttribute("hiddenName", hiddenName);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to prevent the ComboBox from rendering
          until requested (should always be used when rendering
          into an 
          <a ext:cls="Ext.Editor" href="output/Ext.Editor.html">Ext.Editor</a> (e.g. 
          <a ext:cls="Ext.grid.EditorGridPanel" href="output/Ext.grid.EditorGridPanel.html">Grids</a>), defaults
          to 
          <tt>false</tt>).</div>

	 */
	
	public Boolean getLazyRender () {
		return (Boolean) getStateHelper().eval(PropertyKeys.lazyRender);
	}

	/**
	 * <p>
	 * Set the value of the <code>lazyRender</code> property.
	 * </p>
	 */
	public void setLazyRender ( Boolean   lazyRender ) {
		getStateHelper().put(PropertyKeys.lazyRender, lazyRender);
		handleAttribute("lazyRender", lazyRender);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>The template string, or 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> instance to use
          to display each item in the dropdown list. The dropdown
          list is displayed in a DataView. See 
          <a ext:cls="Ext.form.ComboBox" ext:member="view" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-view">view</a>.</p>
          <p>The default template string is:</p>
<pre>
<code>
<em>'&lt;tpl 
<b>for</b>=</em>"."</code>&gt;&lt;div class=
<em>"x-combo-list-item"</em>&gt;{' + this.displayField + 
<em>'}&lt;/div&gt;&lt;/tpl&gt;'</em>
          </pre>
          <p>Override the default value to create custom UI layouts
          for items in the list. For example:</p>
<pre>
<code>
<em>'&lt;tpl 
<b>for</b>=</em>"."</code>&gt;&lt;div ext:qtip=
<em>"{state}. {nick}"</em> class=
<em>"x-combo-list-item"</em>&gt;{state}&lt;/div&gt;&lt;/tpl&gt;'
          </pre>
          <p>The template 
          <b>must</b> contain one or more substitution parameters
          using field names from the Combo's 
          <a ext:cls="Ext.form.ComboBox" ext:member="store" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-store">Store</a>. In the example
          above an</p>
<pre>
ext:qtip
          </pre>attribute is added to display other fields from the
          Store.
          <br/>
          <br/> 
          <p>To preserve the default visual look of list items, add
          the CSS class name</p>
<pre>
x-combo-list-item
          </pre>to the template's container element.
          <br/>
          <br/> 
          <p>Also see 
          <a ext:cls="Ext.form.ComboBox" ext:member="itemSelector" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-itemSelector">itemSelector</a> for
          additional details.</p>
</div>

	 */
	
	public String getTpl () {
		return (String) getStateHelper().eval(PropertyKeys.tpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>tpl</code> property.
	 * </p>
	 */
	public void setTpl ( String   tpl ) {
		getStateHelper().put(PropertyKeys.tpl, tpl);
		handleAttribute("tpl", tpl);
	}
    	/*
	 *
        
        
          maxHeight
         : Number
        The maximum height in pixels of the
        dropdown list before scrollbars are shown (defaults to 
        300)
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to populate and autoselect the remainder of
          the text being typed after a configurable delay (
          <a ext:cls="Ext.form.ComboBox" ext:member="typeAheadDelay" href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-typeAheadDelay">typeAheadDelay</a>) if it
          matches a known value (defaults to 
          <tt>false</tt>)</div>

	 */
	
	public Boolean getTypeAhead () {
		return (Boolean) getStateHelper().eval(PropertyKeys.typeAhead);
	}

	/**
	 * <p>
	 * Set the value of the <code>typeAhead</code> property.
	 * </p>
	 */
	public void setTypeAhead ( Boolean   typeAhead ) {
		getStateHelper().put(PropertyKeys.typeAhead, typeAhead);
		handleAttribute("typeAhead", typeAhead);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          <tt>'x-form-trigger'</tt> and 
          <tt>triggerClass</tt> will be 
          <b>appended</b> if specified (defaults to 
          <tt>'x-form-arrow-trigger'</tt> which displays a downward
          arrow icon).</div>

	 */
	
	public String getTriggerClass () {
		return (String) getStateHelper().eval(PropertyKeys.triggerClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>triggerClass</code> property.
	 * </p>
	 */
	public void setTriggerClass ( String   triggerClass ) {
		getStateHelper().put(PropertyKeys.triggerClass, triggerClass);
		handleAttribute("triggerClass", triggerClass);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A valid anchor position value. See 
          <tt>
            <a ext:cls="Ext.Element" ext:member="alignTo" href="output/Ext.Element.html#Ext.Element-alignTo">Ext.Element.alignTo</a>
          </tt> for details on supported anchor positions and
          offsets. To specify x/y offsets as well, this value may
          be specified as an Array of 
          <tt>
            <a ext:cls="Ext.Element" ext:member="alignTo" href="output/Ext.Element.html#Ext.Element-alignTo">Ext.Element.alignTo</a>
          </tt> method arguments.
          <br/>
          <br/> 
<pre>
<code>[ 
<em>'tl-bl?'</em>, [6,0] ]</code>
          </pre>(defaults to 
          <tt>'tl-bl?'</tt>)</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getListAlign () {
		return (Object) getStateHelper().eval(PropertyKeys.listAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>listAlign</code> property.
	 * </p>
	 */
	public void setListAlign ( Object   listAlign ) {
		getStateHelper().put(PropertyKeys.listAlign, listAlign);
		handleAttribute("listAlign", listAlign);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforequery"
					, "beforeselect"
					, "collapse"
					, "expand"
					, "select"
				));
				return superEvent;
	}
}