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
<div class="description">A mechanism for displaying data using
  custom layout templates and formatting. DataView uses an 
  <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> as its internal
  templating mechanism, and is bound to an 
  <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a> so that as the data
  in the store changes the view is automatically updated to reflect
  the changes. The view also provides built-in behavior for many
  common events that can occur for its contained items including
  click, doubleclick, mouseover, mouseout, etc. as well as a
  built-in selection model. 
  <b>In order to use these features, an 
  <a ext:cls="Ext.DataView" ext:member="itemSelector" href="output/Ext.DataView.html#Ext.DataView-itemSelector">itemSelector</a>
  config must be provided for the DataView to determine what nodes
  it will be working with.</b> 
  <p>The example below binds a DataView to a 
  <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a> and renders it into
  an 
  <a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Ext.Panel</a>.</p>
<pre>
<code>
<b>var</b> store = 
<b>new</b> Ext.data.JsonStore({
    url: 
<em>'get-images.php'</em>,
    root: 
<em>'images'</em>,
    fields: [
        
<em>'name'</em>, 
<em>'url'</em>,
        {name:
<em>'size'</em>, type: 
<em>'float'</em>},
        {name:
<em>'lastmod'</em>, type:
<em>'date'</em>, dateFormat:
<em>'timestamp'</em>}
    ]
});
store.load();

<b>var</b> tpl = 
<b>new</b> Ext.XTemplate(
    
<em>'&lt;tpl 
<b>for</b>=</em>"."</code>&gt;',
        
<em>'&lt;div class=</em>"thumb-wrap" id=
<em>"{name}"</em>&gt;',
        
<em>'&lt;div class=</em>"thumb"&gt;&lt;img src=
<em>"{url}"</em> title=
<em>"{name}"</em>&gt;&lt;/div&gt;',
        
<em>'&lt;span
class=</em>"x-editable"&gt;{shortName}&lt;/span&gt;&lt;/div&gt;',
    
<em>'&lt;/tpl&gt;'</em>,
    
<em>'&lt;div class=</em>"x-clear"&gt;&lt;/div&gt;'
);

<b>var</b> panel = 
<b>new</b> Ext.Panel({
    id:
<em>'images-view'</em>,
    frame:true,
    width:535,
    autoHeight:true,
    collapsible:true,
    layout:
<em>'fit'</em>,
    title:
<em>'Simple DataView'</em>,

    items: 
<b>new</b> Ext.DataView({
        store: store,
        tpl: tpl,
        autoHeight:true,
        multiSelect: true,
        overClass:
<em>'x-view-over'</em>,
        itemSelector:
<em>'div.thumb-wrap'</em>,
        emptyText: 
<em>'No images to display'</em>
    })
});
panel.render(document.body);
  </pre>
</div>

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
			overClass
			,store
			,blockRefresh
			,loadingText
			,selectedClass
			,emptyText
			,itemSelector
			,multiSelect
			,trackOver
			,singleSelect
			,tpl
			,simpleSelect
			,deferEmptyText
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Set this to true to ignore datachanged
          events on the bound store. This is useful if you wish to
          provide custom transition animations via a plugin
          (defaults to false)</div>

	 */
	
	public Boolean getBlockRefresh () {
		return (Boolean) getStateHelper().eval(PropertyKeys.blockRefresh);
	}

	/**
	 * <p>
	 * Set the value of the <code>blockRefresh</code> property.
	 * </p>
	 */
	public void setBlockRefresh ( Boolean   blockRefresh ) {
		getStateHelper().put(PropertyKeys.blockRefresh, blockRefresh);
		handleAttribute("blockRefresh", blockRefresh);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A string to display during data load
          operations (defaults to undefined). If specified, this
          text will be displayed in a loading div and the view's
          contents will be cleared while loading, otherwise the
          view's contents will continue to display normally until
          the new data is loaded and the contents are
          replaced.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <b>This is a required setting</b>. A simple CSS selector
          (e.g. 
          <tt>div.some-class</tt> or 
          <tt>span:first-child</tt>) that will be used to determine
          what nodes this DataView will be working with.</div>

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
<div class="long">True to allow selection of more than
          one item at a time, false to allow selection of only a
          single item at a time or no selection at all, depending
          on the value of 
          <a ext:cls="Ext.DataView" ext:member="singleSelect" href="output/Ext.DataView.html#Ext.DataView-singleSelect">singleSelect</a> (defaults to
          false).</div>

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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to allow selection of exactly one
          item at a time, false to allow no selection at all
          (defaults to false). Note that if 
          <a ext:cls="Ext.DataView" ext:member="multiSelect" href="output/Ext.DataView.html#Ext.DataView-multiSelect">multiSelect</a> = true, this value
          will be ignored.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The HTML fragment or an array of
          fragments that will make up the template used by this
          DataView. This should be specified in the same format
          expected by the constructor of 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to enable multiselection by
          clicking on multiple items without requiring the user to
          hold Shift or Ctrl, false to force the user to hold Ctrl
          or Shift to select more than on item (defaults to
          false).</div>

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