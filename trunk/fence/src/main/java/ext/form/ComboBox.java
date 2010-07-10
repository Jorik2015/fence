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
 * 
  A combobox control with support for autocomplete,
  remote-loading, paging and many other features.
  A ComboBox works in a similar manner to a traditional HTML
  <select> field. The difference is that to submit the 
  valueField, you must specify a 
  hiddenName to create a hidden
  input field to hold the value of the valueField. The 
  
    displayField
   is shown in the text field which is named according to the 
  name.
  
    
      Events
    
  
  To do something when something in ComboBox is selected,
  configure the select event:


var cb = 
new Ext.form.ComboBox({
    
// all of your config options
    listeners:{
         scope: yourScope,
         
'select': yourFunction
    }
});

// Alternatively, you can assign events after the object is
created:
var cb = 
new Ext.form.ComboBox(yourOptions);
cb.on(
'select', yourFunction, yourScope);
  
  
   
  
    
      ComboBox in Grid
    
  
  If using a ComboBox in an 
  Editor Grid a 
  renderer will
  be needed to show the displayField when the editor is not active.
  Set up the renderer manually, or implement a reusable render, for
  example:


// create reusable renderer
Ext.util.Format.comboRenderer = 
function(combo){
    
return 
function(value){
        
var record = combo.findRecord(combo.
valueField,
value);
        
return record ? record.get(combo.
displayField) : combo.
valueNotFoundText;
    }
}

// create the combo instance
var combo = 
new Ext.form.ComboBox({
    
typeAhead:
true,
    
triggerAction: 
'all',
    
lazyRender:true,
    
mode: 
'local',
    
store: 
new Ext.data.ArrayStore({
        id: 0,
        fields: [
            
'myId',
            
'displayText'
        ],
        data: [[1, 
'item1'], [2, 
'item2']]
    }),
    
valueField:

'myId',
    
displayField: 
'displayText'
});

// snippet of column model used within grid
var cm = 
new Ext.grid.ColumnModel([{
       ...
    },{
       header: 
"Some Header",
       dataIndex: 
'whatever',
       width: 130,
       editor: combo, 
// specify reference to combo instance
       renderer: Ext.util.Format.comboRenderer(combo) 
// pass combo instance to reusable renderer
    },
    ...
]);
  
  
   
  
    
      Filtering
    
  
  A ComboBox 
  uses filtering
  itself, for information about filtering the ComboBox store
  manually see 
  
    lastQuery
  .
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
			maxHeight
			,transform
			,hiddenName
			,title
			,itemSelector
			,allQuery
			,listEmptyText
			,valueNotFoundText
			,typeAhead
			,triggerAction
			,submitValue
			,listAlign
			,autoCreate
			,selectOnFocus
			,selectedClass
			,pageSize
			,handleHeight
			,listWidth
			,hiddenId
			,clearFilterOnReset
			,mode
			,queryDelay
			,forceSelection
			,valueField
			,displayField
			,tpl
			,lazyRender
			,minListWidth
			,resizable
			,store
			,typeAheadDelay
			,queryParam
			,hiddenValue
			,listClass
			,minChars
			,loadingText
			,triggerClass
			,shadow
			,minHeight
			,lazyInit
			,autoSelect
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
	 *The id, DOM node or element of an
          existing HTML SELECT to convert to a ComboBox. Note that
          if you specify this and the combo is going to be in an 
          Ext.form.BasicForm or 
          Ext.form.FormPanel, you
          must also set 
          
          lazyRender =
          true.
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
	 *If specified, a hidden form field with
          this name is dynamically generated to store the field's
          data value (defaults to the underlying DOM element's
          name). Required for the combo's value to automatically
          post during a form submission. See also 
          valueField. 
          
          Note: the hidden field's id will also default to
          this name if 
          hiddenId is not
          specified. The ComboBox 
          id and the 
          
            hiddenId
           
          should be different, since no two DOM nodes should
          share the same id. So, if the ComboBox 
          
            name
           and 
          hiddenName are the same, you should specify a
          unique 
          
            hiddenId
          .
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
	 *If supplied, a header element is
          created containing this text and added into the top of
          the dropdown list (defaults to undefined, with no header
          element)
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
	 *
          A simple CSS selector (e.g. div.some-class or
          span:first-child) that will be used to determine what
          nodes the 
          Ext.DataView which
          handles the dropdown display will be working with.
          
          Note: this setting is 
          required if a custom XTemplate has been specified
          in 
          tpl
          which assigns a class other than

'x-combo-list-item'
          to dropdown list items
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
	 *When using a name/value combo, if the
          value passed to setValue is not found in the store,
          valueNotFoundText will be displayed as the field text if
          defined (defaults to undefined). If this default text is
          used, it means there is no value set and no validation
          will occur on this field.
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
	 *
          true to populate and autoselect the remainder of
          the text being typed after a configurable delay (
          typeAheadDelay) if it
          matches a known value (defaults to 
          false)
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
	 *The action to execute when the trigger
          is clicked. 
          
            
              
              
                'query'
               : 
              Default 
              
              run
              the query using the 
              raw value.
              
              
                'all'
               : 
              
              run
              the query specified by the 
              
                allQuery
               config option
            
          
          See also 
          
            queryParam
          .
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
	 *False to clear the name attribute on
          the field so that it is not submitted during a form post.
          If a hiddenName is specified, setting this to true will
          cause both the hidden field and the element to be
          submitted. Defaults to 
          undefined.
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
	 *A valid anchor position value. See 
          
            Ext.Element.alignTo
           for details on supported anchor positions and
          offsets. To specify x/y offsets as well, this value may
          be specified as an Array of 
          
            Ext.Element.alignTo
           method arguments.
          
           

[ 
'tl-bl?', [6,0] ]
          (defaults to 
          'tl-bl?')
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
    	/*
	 *
            A 
            DomHelper element spec, or 
            true for a default element spec. Used to
            create the 
            Element
            which will encapsulate this Component. See 
            
              autoEl
             for details. Defaults to:

{tag: 
"input", type: 
"text", size: 
"24", autocomplete: 
"off"}
            
          
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
	 *
          true to select any existing text in the field
          immediately on focus. Only applies when 
          
          editable = true
          (defaults to 
          false).
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
	 *If greater than 
          0, a 
          Ext.PagingToolbar is
          displayed in the footer of the dropdown list and the 
          filter
          queries will execute with page start and 
          limit parameters. Only
          applies when 
          
          mode =
          'remote' (defaults to 
          0).
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
	 *The width (used as a parameter to 
          Ext.Element.setWidth) of the
          dropdown list (defaults to the width of the ComboBox
          field). See also 
          
            minListWidth
          
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
	 *If 
          
            hiddenName
           is specified, 
          hiddenId can also be provided to give the hidden
          field a unique id (defaults to the 
          
            hiddenName
          ). The 
          hiddenId and combo 
          id should be
          different, since no two DOM nodes should share the same
          id.
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
	 *Acceptable values are: 
          
            
              
              
                'remote'
               : 
              Default 
              Automatically loads the 
              
                store
               the 
              first time the trigger is clicked. If you do
              not want the store to be automatically loaded the
              first time the trigger is clicked, set to 
              'local' and manually load the store. To
              force a requery of the store 
              every time the trigger is clicked see 
              
                lastQuery
              .
              
              
                'local'
               : 
              ComboBox loads local data


var combo = 
new Ext.form.ComboBox({
    renderTo: document.body,
    mode: 
'local',
    store: 
new Ext.data.ArrayStore({
        id: 0,
        fields: [
            
'myId',  
// numeric value is the key
            
'displayText'
        ],
        data: [[1, 
'item1'], [2, 
'item2']]  
// data is local
    }),
    valueField: 
'myId',
    displayField: 
'displayText',
    triggerAction: 
'all'
});
              
            
          
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
	 *The length of time in milliseconds to
          delay between the start of typing and sending the query
          to filter the dropdown list (defaults to 
          500 if 
          
          mode =
          'remote' or 
          10 if 
          
          mode =
          'local')
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
	 *
          true to restrict the selected value to one of
          the values in the list, 
          false to allow the user to set arbitrary text
          into the field (defaults to 
          false)
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
	 *The underlying 
          data value
          name to bind to this ComboBox (defaults to undefined
          if 
          
          mode =
          'remote' or 
          'field2' if 
          transforming a select or
          if the 
          field
          name is autogenerated based on the store
          configuration). 
          
          Note: use of a 
          valueField requires the user to make a selection
          in order for a value to be mapped. See also 
          
            hiddenName
          , 
          
            hiddenValue
          , and 
          
            displayField
          .
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
	 *The underlying 
          data field
          name to bind to this ComboBox (defaults to undefined
          if 
          
          mode =
          'remote' or 
          'field1' if 
          transforming a select or
          if the 
          field
          name is autogenerated based on the store
          configuration). 
          See also 
          
            valueField
          .
          
          Note: if using a ComboBox in an 
          Editor Grid a 
          renderer will be needed to
          show the displayField when the editor is not
          active.
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
          The template string, or 
          Ext.XTemplate instance to use
          to display each item in the dropdown list. The dropdown
          list is displayed in a DataView. See 
          view.
          The default template string is:


'<tpl 
for="."><div class=
"x-combo-list-item">{' + this.displayField + 
'}</div></tpl>'
          
          Override the default value to create custom UI layouts
          for items in the list. For example:


'<tpl 
for="."><div ext:qtip=
"{state}. {nick}" class=
"x-combo-list-item">{state}</div></tpl>'
          
          The template 
          must contain one or more substitution parameters
          using field names from the Combo's 
          Store. In the example
          above an

ext:qtip
          attribute is added to display other fields from the
          Store.
          
           
          To preserve the default visual look of list items, add
          the CSS class name

x-combo-list-item
          to the template's container element.
          
           
          Also see 
          itemSelector for
          additional details.
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
          true to prevent the ComboBox from rendering
          until requested (should always be used when rendering
          into an 
          Ext.Editor (e.g. 
          Grids), defaults
          to 
          false).
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
	 *
          true to add a resize handle to the bottom of the
          dropdown list (creates an 
          Ext.Resizable with 'se' 
          pinned
          handles). Defaults to 
          false.
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
	 *The data source to which this combo is
          bound (defaults to 
          undefined). Acceptable values for this property
          are: 
          
            
              
                any 
                Store subclass
              
              
              an Array : Arrays will be converted to a 
              Ext.data.ArrayStore
              internally, automatically generating 
              field
              names to work with all data components. 
              
                
                  
                  1-dimensional array : (e.g., 
                  ['Foo','Bar'])
                  A 1-dimensional array will
                  automatically be expanded (each array item will
                  be used for both the combo 
                  valueField and 
                  displayField)
                  
                  2-dimensional array : (e.g., 
                  [['f','Foo'],['b','Bar']])
                  For a multi-dimensional
                  array, the value in index 0 of each item will be
                  assumed to be the combo 
                  valueField, while
                  the value at index 1 is assumed to be the combo 
                  displayField.
                
              
            
          
          See also 
          
            mode
          .
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
	 *The length of time in milliseconds to
          wait until the typeahead text is displayed if 
          
          typeAhead = true
          (defaults to 
          250)
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
	 *Sets the initial value of the hidden
          field if 
          hiddenName is specified
          to contain the selected 
          valueField, from the
          Store. Defaults to the configured 
          
            value
          .
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
	 *The minimum number of characters the
          user must type before autocomplete and 
          typeAhead activate
          (defaults to 
          4 if 
          
          mode =
          'remote' or 
          0 if 
          
          mode =
          'local', does not apply if 
          
          editable =
          false).
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
	 *The text to display in the dropdown
          list while data is loading. Only applies when 
          
          mode =
          'remote' (defaults to 
          'Loading...')
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
	 *An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          'x-form-trigger' and 
          triggerClass will be 
          appended if specified (defaults to 
          'x-form-arrow-trigger' which displays a downward
          arrow icon).
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
	 *The minimum height in pixels of the
          dropdown list when the list is constrained by its
          distance to the viewport edges (defaults to 
          90)
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
	 *
          true to select the first result gathered by the
          data store (defaults to 
          true). A false value would require a manual
          selection from the dropdown list to set the components
          value unless the value of (
          typeAheadDelay) were
          true.
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