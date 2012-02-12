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
    <p>As the amount of records increases, the time required for
    the browser to render them increases. Paging is used to reduce
    the amount of data exchanged with the client. Note: if there
    are more records/rows than can be viewed in the available
    screen area, vertical scrollbars will be added.</p>
    <p>Paging is typically handled on the server side (see
    exception below). The client sends parameters to the server
    side, which the server needs to interpret and then respond with
    the approprate data.</p>
    <p>
    <b>Ext.PagingToolbar</b> is a specialized toolbar that is bound
    to a 
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a> and provides
    automatic paging control. This Component 
    <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">load</a>s blocks of
    data into the 
    <tt>
      <a ext:cls="Ext.PagingToolbar" ext:member="store" href="output/Ext.PagingToolbar.html#Ext.PagingToolbar-store">store</a>
    </tt> by passing 
    <a ext:cls="Ext.data.Store" ext:member="paramNames" href="output/Ext.data.Store.html#Ext.data.Store-paramNames">paramNames</a>
    used for paging criteria.</p>
    <p>PagingToolbar is typically used as one of the Grid's
    toolbars:</p>
<pre>
<code>Ext.QuickTips.init(); 
<i>// to display button quicktips</i>

<b>var</b> myStore = 
<b>new</b> Ext.data.Store({
    reader: 
<b>new</b> Ext.data.JsonReader({
        
<a ext:cls="Ext.data.JsonReader" ext:member="totalProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-totalProperty">totalProperty</a>: 
<em>'results'</em>, 
        ...
    }),
    ...
});

<b>var</b> myPageSize = 25;  
<i>// server script should only send back 25 items at a time</i>

<b>var</b> grid = 
<b>new</b> Ext.grid.GridPanel({
    ...
    store: myStore,
    bbar: 
<b>new</b> Ext.PagingToolbar({
        
<a ext:cls="Ext.PagingToolbar" ext:member="store" href="output/Ext.PagingToolbar.html#Ext.PagingToolbar-store">store</a>: myStore, 
     
<i>// grid and PagingToolbar using same store</i>
        
<a ext:cls="Ext.PagingToolbar" ext:member="displayInfo" href="output/Ext.PagingToolbar.html#Ext.PagingToolbar-displayInfo">displayInfo</a>: true,
        
<a ext:cls="Ext.PagingToolbar" ext:member="pageSize" href="output/Ext.PagingToolbar.html#Ext.PagingToolbar-pageSize">pageSize</a>:
myPageSize,
        
<a ext:cls="Ext.PagingToolbar" ext:member="prependButtons" href="output/Ext.PagingToolbar.html#Ext.PagingToolbar-prependButtons">prependButtons</a>: true,
        items: [
            
<em>'text 1'</em>
        ]
    })
});</code>
    </pre>
    <p>To use paging, pass the paging requirements to the server
    when the store is first loaded.</p>
<pre>
<code>store.load({
    params: {
        
<i>// specify params 
<b>for</b> the first page load 
<b>if</b> using paging</i>
        start: 0,          
        limit: myPageSize,
        
<i>// other params</i>
        foo:   
<em>'bar'</em>
    }
});</code>
    </pre>
    <p>If using 
    <a ext:cls="Ext.data.Store" ext:member="autoLoad" href="output/Ext.data.Store.html#Ext.data.Store-autoLoad">store's
    autoLoad</a> configuration:</p>
<pre>
<code>
<b>var</b> myStore = 
<b>new</b> Ext.data.Store({
    
<a ext:cls="Ext.data.Store" ext:member="autoLoad" href="output/Ext.data.Store.html#Ext.data.Store-autoLoad">autoLoad</a>:
{params:{start: 0, limit: 25}},
    ...
});</code>
    </pre>
    <p>The packet sent back from the server would have this
    form:</p>
<pre>
<code>{
    
<em>"success"</em>: true,
    
<em>"results"</em>: 2000, 
    
<em>"rows"</em>: [ 
<i>// 
<b>*Note:</b> this must be an Array</i> 
        { 
<em>"id"</em>:  1, 
<em>"name"</em>: 
<em>"Bill"</em>, 
<em>"occupation"</em>: 
<em>"Gardener"</em> },
        { 
<em>"id"</em>:  2, 
<em>"name"</em>:  
<em>"Ben"</em>, 
<em>"occupation"</em>: 
<em>"Horticulturalist"</em> },
        ...
        { 
<em>"id"</em>: 25, 
<em>"name"</em>:  
<em>"Sue"</em>, 
<em>"occupation"</em>: 
<em>"Botanist"</em> }
    ]
}</code>
    </pre>
    <p>
      <u>Paging with Local Data</u>
    </p>
    <p>Paging can also be accomplished with local data using
    extensions:</p>
    <div class="mdetail-params">
      <ul>
        <li>
          <a href="http://extjs.com/forum/showthread.php?t=71532">Ext.ux.data.PagingStore</a>
        </li>
        <li>Paging Memory Proxy
        (examples/ux/PagingMemoryProxy.js)</li>
      </ul>
    </div>
  </div>

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
			displayInfo
			,store
			,displayMsg
			,emptyMsg
			,pageSize
			,nextText
			,prependButtons
			,beforePageText
			,afterPageText
			,lastText
			,refreshText
			,firstText
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The paging status message to display
          (defaults to 
          <tt>'Displaying {0} - {1} of {2}'</tt>). Note that this
          string is formatted using the braced numbers 
          <tt>{0}-{2}</tt> as tokens that are replaced by the
          values for start, end and total respectively. These
          tokens should be preserved when overriding this string if
          showing those values is desired.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The quicktip text displayed for the
          next page button (defaults to 
          <tt>'Next Page'</tt>). 
          <b>Note</b>: quick tips must be initialized for the
          quicktip to show.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Customizable piece of the default
          paging text (defaults to 
          <tt>'of {0}'</tt>). Note that this string is formatted
          using 
          <tt>{0}</tt> as a token that is replaced by the number of
          total pages. This token should be preserved when
          overriding this string if showing the total page count is
          desired.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The quicktip text displayed for the
          last page button (defaults to 
          <tt>'Last Page'</tt>). 
          <b>Note</b>: quick tips must be initialized for the
          quicktip to show.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The quicktip text displayed for the
          Refresh button (defaults to 
          <tt>'Refresh'</tt>). 
          <b>Note</b>: quick tips must be initialized for the
          quicktip to show.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The quicktip text displayed for the
          first page button (defaults to 
          <tt>'First Page'</tt>). 
          <b>Note</b>: quick tips must be initialized for the
          quicktip to show.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The quicktip text displayed for the
          previous page button (defaults to 
          <tt>'Previous Page'</tt>). 
          <b>Note</b>: quick tips must be initialized for the
          quicktip to show.</div>

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