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
    As the amount of records increases, the time required for
    the browser to render them increases. Paging is used to reduce
    the amount of data exchanged with the client. Note: if there
    are more records/rows than can be viewed in the available
    screen area, vertical scrollbars will be added.
    Paging is typically handled on the server side (see
    exception below). The client sends parameters to the server
    side, which the server needs to interpret and then respond with
    the approprate data.
    
    Ext.PagingToolbar is a specialized toolbar that is bound
    to a 
    Ext.data.Store and provides
    automatic paging control. This Component 
    loads blocks of
    data into the 
    
      store
     by passing 
    paramNames
    used for paging criteria.
    PagingToolbar is typically used as one of the Grid's
    toolbars:

Ext.QuickTips.init(); 
// to display button quicktips

var myStore = 
new Ext.data.Store({
    reader: 
new Ext.data.JsonReader({
        
totalProperty: 
'results', 
        ...
    }),
    ...
});

var myPageSize = 25;  
// server script should only send back 25 items at a time

var grid = 
new Ext.grid.GridPanel({
    ...
    store: myStore,
    bbar: 
new Ext.PagingToolbar({
        
store: myStore, 
     
// grid and PagingToolbar using same store
        
displayInfo: true,
        
pageSize:
myPageSize,
        
prependButtons: true,
        items: [
            
'text 1'
        ]
    })
});
    
    To use paging, pass the paging requirements to the server
    when the store is first loaded.

store.load({
    params: {
        
// specify params 
for the first page load 
if using paging
        start: 0,          
        limit: myPageSize,
        
// other params
        foo:   
'bar'
    }
});
    
    If using 
    store's
    autoLoad configuration:


var myStore = 
new Ext.data.Store({
    
autoLoad:
{params:{start: 0, limit: 25}},
    ...
});
    
    The packet sent back from the server would have this
    form:

{
    
"success": true,
    
"results": 2000, 
    
"rows": [ 
// 
*Note: this must be an Array 
        { 
"id":  1, 
"name": 
"Bill", 
"occupation": 
"Gardener" },
        { 
"id":  2, 
"name":  
"Ben", 
"occupation": 
"Horticulturalist" },
        ...
        { 
"id": 25, 
"name":  
"Sue", 
"occupation": 
"Botanist" }
    ]
}
    
    
      Paging with Local Data
    
    Paging can also be accomplished with local data using
    extensions:
    
      
        
          Ext.ux.data.PagingStore
        
        Paging Memory Proxy
        (examples/ux/PagingMemoryProxy.js)
      
    
  
 */
@XType("paging")
@InstanceOf("Ext.PagingToolbar")

@FacesComponent(value = "Ext.PagingToolbar")
public class PagingToolbar extends Toolbar {
	public static final String COMPONENT_FAMILY = "Ext.PagingToolbar";

	/**
	 * <p>
	 * Create a new {@link Ext.PagingToolbar} instance with default property values.
	 * </p>
	 */
	public PagingToolbar() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			afterPageText
			,displayInfo
			,beforePageText
			,displayMsg
			,firstText
			,emptyMsg
			,nextText
			,store
			,pageSize
			,lastText
			,refreshText
			,prependButtons
			,prevText
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
	 *Customizable piece of the default
          paging text (defaults to 
          'of {0}'). Note that this string is formatted
          using 
          {0} as a token that is replaced by the number of
          total pages. This token should be preserved when
          overriding this string if showing the total page count is
          desired.
	 */
	
	public String getAfterPageText () {
		return (String) getStateHelper().eval(PropertyKeys.afterPageText);
	}

	/**
	 * <p>
	 * Set the value of the <code>afterPageText</code> property.
	 * </p>
	 */
	public void setAfterPageText ( String   afterPageText ) {
		getStateHelper().put(PropertyKeys.afterPageText, afterPageText);
		handleAttribute("afterPageText", afterPageText);
	}
    	/*
	 *
        
        
          displayInfo
         : Boolean
        
        true to display the displayMsg (defaults to 
        false)
	 */
	
	public Boolean getDisplayInfo () {
		return (Boolean) getStateHelper().eval(PropertyKeys.displayInfo);
	}

	/**
	 * <p>
	 * Set the value of the <code>displayInfo</code> property.
	 * </p>
	 */
	public void setDisplayInfo ( Boolean   displayInfo ) {
		getStateHelper().put(PropertyKeys.displayInfo, displayInfo);
		handleAttribute("displayInfo", displayInfo);
	}
    	/*
	 *
        
        
          beforePageText
         : String
        The text displayed before the input item
        (defaults to 
        'Page').
	 */
	
	public String getBeforePageText () {
		return (String) getStateHelper().eval(PropertyKeys.beforePageText);
	}

	/**
	 * <p>
	 * Set the value of the <code>beforePageText</code> property.
	 * </p>
	 */
	public void setBeforePageText ( String   beforePageText ) {
		getStateHelper().put(PropertyKeys.beforePageText, beforePageText);
		handleAttribute("beforePageText", beforePageText);
	}
    	/*
	 *The paging status message to display
          (defaults to 
          'Displaying {0} - {1} of {2}'). Note that this
          string is formatted using the braced numbers 
          {0}-{2} as tokens that are replaced by the
          values for start, end and total respectively. These
          tokens should be preserved when overriding this string if
          showing those values is desired.
	 */
	
	public String getDisplayMsg () {
		return (String) getStateHelper().eval(PropertyKeys.displayMsg);
	}

	/**
	 * <p>
	 * Set the value of the <code>displayMsg</code> property.
	 * </p>
	 */
	public void setDisplayMsg ( String   displayMsg ) {
		getStateHelper().put(PropertyKeys.displayMsg, displayMsg);
		handleAttribute("displayMsg", displayMsg);
	}
    	/*
	 *The quicktip text displayed for the
          first page button (defaults to 
          'First Page'). 
          Note: quick tips must be initialized for the
          quicktip to show.
	 */
	
	public String getFirstText () {
		return (String) getStateHelper().eval(PropertyKeys.firstText);
	}

	/**
	 * <p>
	 * Set the value of the <code>firstText</code> property.
	 * </p>
	 */
	public void setFirstText ( String   firstText ) {
		getStateHelper().put(PropertyKeys.firstText, firstText);
		handleAttribute("firstText", firstText);
	}
    	/*
	 *
        
        
          emptyMsg
         : String
        The message to display when no records
        are found (defaults to 'No data to display')
	 */
	
	public String getEmptyMsg () {
		return (String) getStateHelper().eval(PropertyKeys.emptyMsg);
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyMsg</code> property.
	 * </p>
	 */
	public void setEmptyMsg ( String   emptyMsg ) {
		getStateHelper().put(PropertyKeys.emptyMsg, emptyMsg);
		handleAttribute("emptyMsg", emptyMsg);
	}
    	/*
	 *The quicktip text displayed for the
          next page button (defaults to 
          'Next Page'). 
          Note: quick tips must be initialized for the
          quicktip to show.
	 */
	
	public String getNextText () {
		return (String) getStateHelper().eval(PropertyKeys.nextText);
	}

	/**
	 * <p>
	 * Set the value of the <code>nextText</code> property.
	 * </p>
	 */
	public void setNextText ( String   nextText ) {
		getStateHelper().put(PropertyKeys.nextText, nextText);
		handleAttribute("nextText", nextText);
	}
    	/*
	 *
        
        
          store
         : Ext.data.Store
        The 
        Ext.data.Store the paging
        toolbar should use as its data source
        (required).
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
	 *
        
        
          pageSize
         : Number
        The number of records to display per
        page (defaults to 
        20)
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
	 *The quicktip text displayed for the
          last page button (defaults to 
          'Last Page'). 
          Note: quick tips must be initialized for the
          quicktip to show.
	 */
	
	public String getLastText () {
		return (String) getStateHelper().eval(PropertyKeys.lastText);
	}

	/**
	 * <p>
	 * Set the value of the <code>lastText</code> property.
	 * </p>
	 */
	public void setLastText ( String   lastText ) {
		getStateHelper().put(PropertyKeys.lastText, lastText);
		handleAttribute("lastText", lastText);
	}
    	/*
	 *The quicktip text displayed for the
          Refresh button (defaults to 
          'Refresh'). 
          Note: quick tips must be initialized for the
          quicktip to show.
	 */
	
	public String getRefreshText () {
		return (String) getStateHelper().eval(PropertyKeys.refreshText);
	}

	/**
	 * <p>
	 * Set the value of the <code>refreshText</code> property.
	 * </p>
	 */
	public void setRefreshText ( String   refreshText ) {
		getStateHelper().put(PropertyKeys.refreshText, refreshText);
		handleAttribute("refreshText", refreshText);
	}
    	/*
	 *
        
        
          prependButtons
         : Boolean
        
        true to insert any configured 
        items 
        before the paging buttons. Defaults to 
        false.
	 */
	
	public Boolean getPrependButtons () {
		return (Boolean) getStateHelper().eval(PropertyKeys.prependButtons);
	}

	/**
	 * <p>
	 * Set the value of the <code>prependButtons</code> property.
	 * </p>
	 */
	public void setPrependButtons ( Boolean   prependButtons ) {
		getStateHelper().put(PropertyKeys.prependButtons, prependButtons);
		handleAttribute("prependButtons", prependButtons);
	}
    	/*
	 *The quicktip text displayed for the
          previous page button (defaults to 
          'Previous Page'). 
          Note: quick tips must be initialized for the
          quicktip to show.
	 */
	
	public String getPrevText () {
		return (String) getStateHelper().eval(PropertyKeys.prevText);
	}

	/**
	 * <p>
	 * Set the value of the <code>prevText</code> property.
	 * </p>
	 */
	public void setPrevText ( String   prevText ) {
		getStateHelper().put(PropertyKeys.prevText, prevText);
		handleAttribute("prevText", prevText);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforechange"
					, "change"
				));
				return superEvent;
	}
}