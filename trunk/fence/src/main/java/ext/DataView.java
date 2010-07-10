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
 * A mechanism for displaying data using
  custom layout templates and formatting. DataView uses an 
  Ext.XTemplate as its internal
  templating mechanism, and is bound to an 
  Ext.data.Store so that as the data
  in the store changes the view is automatically updated to reflect
  the changes. The view also provides built-in behavior for many
  common events that can occur for its contained items including
  click, doubleclick, mouseover, mouseout, etc. as well as a
  built-in selection model. 
  In order to use these features, an 
  itemSelector
  config must be provided for the DataView to determine what nodes
  it will be working with. 
  The example below binds a DataView to a 
  Ext.data.Store and renders it into
  an 
  Ext.Panel.


var store = 
new Ext.data.JsonStore({
    url: 
'get-images.php',
    root: 
'images',
    fields: [
        
'name', 
'url',
        {name:
'size', type: 
'float'},
        {name:
'lastmod', type:
'date', dateFormat:
'timestamp'}
    ]
});
store.load();

var tpl = 
new Ext.XTemplate(
    
'<tpl 
for=".">',
        
'<div class="thumb-wrap" id=
"{name}">',
        
'<div class="thumb"><img src=
"{url}" title=
"{name}"></div>',
        
'<span
class="x-editable">{shortName}</span></div>',
    
'</tpl>',
    
'<div class="x-clear"></div>'
);

var panel = 
new Ext.Panel({
    id:
'images-view',
    frame:true,
    width:535,
    autoHeight:true,
    collapsible:true,
    layout:
'fit',
    title:
'Simple DataView',

    items: 
new Ext.DataView({
        store: store,
        tpl: tpl,
        autoHeight:true,
        multiSelect: true,
        overClass:
'x-view-over',
        itemSelector:
'div.thumb-wrap',
        emptyText: 
'No images to display'
    })
});
panel.render(document.body);
  
 */
@XType("dataview")
@InstanceOf("Ext.DataView")
@ParseConfigMode(ui = false,name="view",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.DataView")
public class DataView extends BoxComponent {
	public static final String COMPONENT_FAMILY = "Ext.DataView";

	/**
	 * <p>
	 * Create a new {@link Ext.DataView} instance with default property values.
	 * </p>
	 */
	public DataView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			singleSelect
			,store
			,multiSelect
			,itemSelector
			,emptyText
			,selectedClass
			,overClass
			,loadingText
			,deferEmptyText
			,tpl
			,simpleSelect
			,trackOver
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
	 *True to allow selection of exactly one
          item at a time, false to allow no selection at all
          (defaults to false). Note that if 
          multiSelect = true, this value
          will be ignored.
	 */
	
	public Boolean getSingleSelect () {
		return (Boolean) getStateHelper().eval(PropertyKeys.singleSelect);
	}

	/**
	 * <p>
	 * Set the value of the <code>singleSelect</code> property.
	 * </p>
	 */
	public void setSingleSelect ( Boolean   singleSelect ) {
		getStateHelper().put(PropertyKeys.singleSelect, singleSelect);
		handleAttribute("singleSelect", singleSelect);
	}
    	/*
	 *
        
        
          store
         : Ext.data.Store
        The 
        Ext.data.Store to bind this
        DataView to.
	 */
	@ClientConfig(JsonMode.Object)

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
	 *True to allow selection of more than
          one item at a time, false to allow selection of only a
          single item at a time or no selection at all, depending
          on the value of 
          singleSelect (defaults to
          false).
	 */
	
	public Boolean getMultiSelect () {
		return (Boolean) getStateHelper().eval(PropertyKeys.multiSelect);
	}

	/**
	 * <p>
	 * Set the value of the <code>multiSelect</code> property.
	 * </p>
	 */
	public void setMultiSelect ( Boolean   multiSelect ) {
		getStateHelper().put(PropertyKeys.multiSelect, multiSelect);
		handleAttribute("multiSelect", multiSelect);
	}
    	/*
	 *
          This is a required setting. A simple CSS selector
          (e.g. 
          div.some-class or 
          span:first-child) that will be used to determine
          what nodes this DataView will be working with.
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
        
        
          emptyText
         : String
        The text to display in the view when
        there is no data to display (defaults to '').
	 */
	
	public String getEmptyText () {
		return (String) getStateHelper().eval(PropertyKeys.emptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyText</code> property.
	 * </p>
	 */
	public void setEmptyText ( String   emptyText ) {
		getStateHelper().put(PropertyKeys.emptyText, emptyText);
		handleAttribute("emptyText", emptyText);
	}
    	/*
	 *
        
        
          selectedClass
         : String
        A CSS class to apply to each selected
        item in the view (defaults to
        'x-view-selected').
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
        
        
          overClass
         : String
        A CSS class to apply to each item in the
        view on mouseover (defaults to undefined).
	 */
	
	public String getOverClass () {
		return (String) getStateHelper().eval(PropertyKeys.overClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>overClass</code> property.
	 * </p>
	 */
	public void setOverClass ( String   overClass ) {
		getStateHelper().put(PropertyKeys.overClass, overClass);
		handleAttribute("overClass", overClass);
	}
    	/*
	 *A string to display during data load
          operations (defaults to undefined). If specified, this
          text will be displayed in a loading div and the view's
          contents will be cleared while loading, otherwise the
          view's contents will continue to display normally until
          the new data is loaded and the contents are
          replaced.
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
        
        
          deferEmptyText
         : Boolean
        True to defer emptyText being applied
        until the store's first load
	 */
	
	public Boolean getDeferEmptyText () {
		return (Boolean) getStateHelper().eval(PropertyKeys.deferEmptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>deferEmptyText</code> property.
	 * </p>
	 */
	public void setDeferEmptyText ( Boolean   deferEmptyText ) {
		getStateHelper().put(PropertyKeys.deferEmptyText, deferEmptyText);
		handleAttribute("deferEmptyText", deferEmptyText);
	}
    	/*
	 *The HTML fragment or an array of
          fragments that will make up the template used by this
          DataView. This should be specified in the same format
          expected by the constructor of 
          Ext.XTemplate.
	 */
	@ClientConfig(JsonMode.Array)

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
	 *True to enable multiselection by
          clicking on multiple items without requiring the user to
          hold Shift or Ctrl, false to force the user to hold Ctrl
          or Shift to select more than on item (defaults to
          false).
	 */
	
	public Boolean getSimpleSelect () {
		return (Boolean) getStateHelper().eval(PropertyKeys.simpleSelect);
	}

	/**
	 * <p>
	 * Set the value of the <code>simpleSelect</code> property.
	 * </p>
	 */
	public void setSimpleSelect ( Boolean   simpleSelect ) {
		getStateHelper().put(PropertyKeys.simpleSelect, simpleSelect);
		handleAttribute("simpleSelect", simpleSelect);
	}
    	/*
	 *
        
        
          trackOver
         : Boolean
        True to enable mouseenter and mouseleave
        events
	 */
	
	public Boolean getTrackOver () {
		return (Boolean) getStateHelper().eval(PropertyKeys.trackOver);
	}

	/**
	 * <p>
	 * Set the value of the <code>trackOver</code> property.
	 * </p>
	 */
	public void setTrackOver ( Boolean   trackOver ) {
		getStateHelper().put(PropertyKeys.trackOver, trackOver);
		handleAttribute("trackOver", trackOver);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforeclick"
					, "beforeselect"
					, "click"
					, "containerclick"
					, "containercontextmenu"
					, "contextmenu"
					, "dblclick"
					, "mouseenter"
					, "mouseleave"
					, "selectionchange"
				));
				return superEvent;
	}
}