package ext.data;

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
  <p>The Store class encapsulates a client side cache of 
  <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a> objects which provide input
  data for Components such as the 
  <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">GridPanel</a>, the 
  <a ext:cls="Ext.form.ComboBox" href="output/Ext.form.ComboBox.html">ComboBox</a>, or the 
  <a ext:cls="Ext.DataView" href="output/Ext.DataView.html">DataView</a>.</p>
  <p>
    <u>Retrieving Data</u>
  </p>
  <p>A Store object may access a data object using:</p>
  <div class="mdetail-params">
    <ul>
      <li>
      <a ext:cls="Ext.data.Store" ext:member="proxy" href="output/Ext.data.Store.html#Ext.data.Store-proxy">configured
      implementation</a> of 
      <a ext:cls="Ext.data.DataProxy" href="output/Ext.data.DataProxy.html">DataProxy</a>
</li>
      <li>
      <a ext:cls="Ext.data.Store" ext:member="data" href="output/Ext.data.Store.html#Ext.data.Store-data">data</a> to
      automatically pass in data</li>
      <li>
      <a ext:cls="Ext.data.Store" ext:member="loadData" href="output/Ext.data.Store.html#Ext.data.Store-loadData">loadData</a>
      to manually pass in data</li>
    </ul>
  </div>
  <br/>
  <br/> 
  <p>
    <u>Reading Data</u>
  </p>
  <p>A Store object has no inherent knowledge of the format of the
  data object (it could be an Array, XML, or JSON). A Store object
  uses an appropriate 
  <a ext:cls="Ext.data.Store" ext:member="reader" href="output/Ext.data.Store.html#Ext.data.Store-reader">configured
  implementation</a> of a 
  <a ext:cls="Ext.data.DataReader" href="output/Ext.data.DataReader.html">DataReader</a> to create 
  <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a> instances from the data
  object.</p>
  <p>
    <u>Store Types</u>
  </p>
  <p>There are several implementations of Store available which are
  customized for use with a specific DataReader implementation.
  Here is an example using an ArrayStore which implicitly creates a
  reader commensurate to an Array data object.</p>
<pre>
<code>
<b>var</b> myStore = 
<b>new</b> Ext.data.ArrayStore({
    fields: [
<em>'fullname'</em>, 
<em>'first'</em>],
    idIndex: 0 
<i>// id 
<b>for</b> each record will be the first element</i>
});</code>
  </pre>
  <p>For custom implementations create a basic 
  <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a> configured as
  needed:</p>
<pre>
<code>
<i>// create a 
<a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a> constructor:</i>
<b>var</b> rt = Ext.data.Record.create([
    {name: 
<em>'fullname'</em>},
    {name: 
<em>'first'</em>}
]);
<b>var</b> myStore = 
<b>new</b> Ext.data.Store({
    
<i>// explicitly create reader</i>
    reader: 
<b>new</b> Ext.data.ArrayReader(
        {
            idIndex: 0  
<i>// id 
<b>for</b> each record will be the first element</i>
        },
        rt 
<i>// recordType</i>
    )
});</code>
  </pre>
  <p>Load some data into store (note the data object is an array
  which corresponds to the reader):</p>
<pre>
<code>
<b>var</b> myData = [
    [1, 
<em>'Fred Flintstone'</em>, 
<em>'Fred'</em>],  
<i>// note that id 
<b>for</b> the record is the first element</i>
    [2, 
<em>'Barney Rubble'</em>, 
<em>'Barney'</em>]
];
myStore.loadData(myData);</code>
  </pre>
  <p>Records are cached and made available through accessor
  functions. An example of adding a record to the store:</p>
<pre>
<code>
<b>var</b> defaultData = {
    fullname: 
<em>'Full Name'</em>,
    first: 
<em>'First Name'</em>
};
<b>var</b> recId = 100; 
<i>// provide unique id 
<b>for</b> the record</i>
<b>var</b> r = 
<b>new</b> myStore.recordType(defaultData, ++recId); 
<i>// create 
<b>new</b> record</i>
myStore.
<a ext:cls="Ext.data.Store" ext:member="insert" href="output/Ext.data.Store.html#Ext.data.Store-insert">insert</a>(0, r); 
<i>// insert a 
<b>new</b> record into the store (also see 
<a ext:cls="Ext.data.Store" ext:member="add" href="output/Ext.data.Store.html#Ext.data.Store-add">add</a>)</i>
</code>
  </pre>
  <p>
    <u>Writing Data</u>
  </p>
  <p>And 
  <b>new in Ext version 3</b>, use the new 
  <a ext:cls="Ext.data.DataWriter" href="output/Ext.data.DataWriter.html">DataWriter</a> to create an
  automated, 
  <a href="http://extjs.com/deploy/dev/examples/writer/writer.html">Writable
  Store</a> along with 
  <a href="http://extjs.com/deploy/dev/examples/restful/restful.html">RESTful
  features.</a>
</p>
</div>

 */
@XType("store")
@InstanceOf("Ext.data.Store")
@ParseConfigMode(ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.Store")
public class Store extends com.abner.fence.component.ExtCommand {
	public static final String COMPONENT_FAMILY = "Ext.data.Store";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Store} instance with default property values.
	 * </p>
	 */
	public Store() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			autoDestroy
			,autoSave
			,data
			,pruneModifiedRecords
			,restful
			,remoteSort
			,url
			,paramNames
			,baseParams
			,reader
			,defaultParamNames
			,batch
			,proxy
			,writer
			,autoLoad
			,storeId
			,sortInfo
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
<div class="long">
          <tt>true</tt> to destroy the store when the component the
          store is bound to is destroyed (defaults to 
          <tt>false</tt>). 
          <p>
          <b>Note</b>: this should be set to true when using stores
          that are bound to only 1 component.</p>
</div>

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
            <p>Defaults to 
            <tt>true</tt> causing the store to automatically 
            <a ext:cls="Ext.data.Store" ext:member="save" href="output/Ext.data.Store.html#Ext.data.Store-save">save</a>
            records to the server when a record is modified (ie:
            becomes 'dirty'). Specify 
            <tt>false</tt> to manually call 
            <a ext:cls="Ext.data.Store" ext:member="save" href="output/Ext.data.Store.html#Ext.data.Store-save">save</a> to
            send all modifiedRecords to the server.</p>
            <br/>
            <p>
            <b>Note</b>: each CRUD action will be sent as a
            separate request.</p>
          </div>

	 */
	
	public Boolean getAutoSave () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoSave);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoSave</code> property.
	 * </p>
	 */
	public void setAutoSave ( Boolean   autoSave ) {
		getStateHelper().put(PropertyKeys.autoSave, autoSave);
		handleAttribute("autoSave", autoSave);
	}
    	/*
	 *
        
        
          data
         : Array
        An inline data object readable by the 
        
          reader
        . Typically this option, or the 
        
          url
         option will be specified.
	 */
	@ClientConfig(value = JsonMode.Object)
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
          <tt>true</tt> to clear all modified record information
          each time the store is loaded or when a record is removed
          (defaults to 
          <tt>false</tt>). See 
          <a ext:cls="Ext.data.Store" ext:member="getModifiedRecords" href="output/Ext.data.Store.html#Ext.data.Store-getModifiedRecords">getModifiedRecords</a> for the
          accessor method to retrieve the modified records.</div>

	 */
	
	public Boolean getPruneModifiedRecords () {
		return (Boolean) getStateHelper().eval(PropertyKeys.pruneModifiedRecords);
	}

	/**
	 * <p>
	 * Set the value of the <code>pruneModifiedRecords</code> property.
	 * </p>
	 */
	public void setPruneModifiedRecords ( Boolean   pruneModifiedRecords ) {
		getStateHelper().put(PropertyKeys.pruneModifiedRecords, pruneModifiedRecords);
		handleAttribute("pruneModifiedRecords", pruneModifiedRecords);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Defaults to 
          <tt>false</tt>. Set to 
          <tt>true</tt> to have the Store and the set Proxy operate
          in a RESTful manner. The store will automatically
          generate GET, POST, PUT and DELETE requests to the
          server. The HTTP method used for any given CRUD action is
          described in 
          <a ext:cls="Ext.data.Api" ext:member="restActions" href="output/Ext.data.Api.html#Ext.data.Api-restActions">Ext.data.Api.restActions</a>. For
          additional information see 
          <a ext:cls="Ext.data.DataProxy" ext:member="restful" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-restful">Ext.data.DataProxy.restful</a>.
          
          <p>
          <b>Note</b>: if 
          <code>
          <a ext:cls="Ext.data.Store" ext:member="restful" href="output/Ext.data.Store.html#Ext.data.Store-restful">restful</a>:true</code> 
          <code>batch</code> will internally be set to 
          <tt>false</tt>.</p>
</div>

	 */
	
	public Boolean getRestful () {
		return (Boolean) getStateHelper().eval(PropertyKeys.restful);
	}

	/**
	 * <p>
	 * Set the value of the <code>restful</code> property.
	 * </p>
	 */
	public void setRestful ( Boolean   restful ) {
		getStateHelper().put(PropertyKeys.restful, restful);
		handleAttribute("restful", restful);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> if sorting is to be handled by requesting
          the 
          <tt>
            <a ext:cls="Ext.data.Store" ext:member="proxy" href="output/Ext.data.Store.html#Ext.data.Store-proxy">Proxy</a>
          </tt> to provide a refreshed version of the data object
          in sorted order, as opposed to sorting the Record cache
          in place (defaults to 
          <tt>false</tt>). 
          <p>If 
          <tt>remoteSort</tt> is 
          <tt>true</tt>, then clicking on a 
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Grid Column</a>'s 
          <a ext:cls="Ext.grid.Column" ext:member="header" href="output/Ext.grid.Column.html#Ext.grid.Column-header">header</a>
          causes the current page to be requested from the server
          appending the following two parameters to the 
          <b>
            <tt>
              <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">params</a>
            </tt>
          </b>:</p>
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>sort</tt>
              </b> : String
              <p class="sub-desc">The 
              <tt>name</tt> (as specified in the Record's 
              <a ext:cls="Ext.data.Field" href="output/Ext.data.Field.html">Field definition</a>) of the
              field to sort on.</p>
</li>
              <li>
              <b>
                <tt>dir</tt>
              </b> : String
              <p class="sub-desc">The direction of the sort, 'ASC'
              or 'DESC' (case-sensitive).</p>
</li>
            </ul>
          </div>
          <br/>
          <br/>
</div>

	 */
	
	public Boolean getRemoteSort () {
		return (Boolean) getStateHelper().eval(PropertyKeys.remoteSort);
	}

	/**
	 * <p>
	 * Set the value of the <code>remoteSort</code> property.
	 * </p>
	 */
	public void setRemoteSort ( Boolean   remoteSort ) {
		getStateHelper().put(PropertyKeys.remoteSort, remoteSort);
		handleAttribute("remoteSort", remoteSort);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If a 
          <tt>
            <a ext:cls="Ext.data.Store" ext:member="proxy" href="output/Ext.data.Store.html#Ext.data.Store-proxy">proxy</a>
          </tt> is not specified the 
          <tt>url</tt> will be used to implicitly configure a 
          <a ext:cls="Ext.data.HttpProxy" href="output/Ext.data.HttpProxy.html">HttpProxy</a> if an 
          <tt>url</tt> is specified. Typically this option, or the 
          <code>
            <a ext:cls="Ext.data.Store" ext:member="data" href="output/Ext.data.Store.html#Ext.data.Store-data">data</a>
          </code> option will be specified.</div>

	 */
	
	public String getUrl () {
		return (String) getStateHelper().eval(PropertyKeys.url);
	}

	/**
	 * <p>
	 * Set the value of the <code>url</code> property.
	 * </p>
	 */
	public void setUrl ( String   url ) {
		getStateHelper().put(PropertyKeys.url, url);
		handleAttribute("url", url);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An object containing properties which specify the
            names of the paging and sorting parameters passed to
            remote servers when loading blocks of data. By default,
            this object takes the following form:</p>
<pre>
<code>{
    start : 
<em>'start'</em>,  
<i>// The parameter name which specifies the start row</i>
    limit : 
<em>'limit'</em>,  
<i>// The parameter name which specifies number of rows to 
<b>return</b>
</i>
    sort : 
<em>'sort'</em>,    
<i>// The parameter name which specifies the column to sort on</i>
    dir : 
<em>'dir'</em>       
<i>// The parameter name which specifies the sort direction</i>
}</code>
            </pre>
            <p>The server must produce the requested data block
            upon receipt of these parameter names. If different
            parameter names are required, this property can be
            overriden using a configuration property.</p>
            <p>A 
            <a ext:cls="Ext.PagingToolbar" href="output/Ext.PagingToolbar.html">PagingToolbar</a> bound to
            this Store uses this property to determine the
            parameter names to use in its 
            <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">requests</a>.</p>
          </div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getParamNames () {
		return (Object) getStateHelper().eval(PropertyKeys.paramNames);
	}

	/**
	 * <p>
	 * Set the value of the <code>paramNames</code> property.
	 * </p>
	 */
	public void setParamNames ( Object   paramNames ) {
		getStateHelper().put(PropertyKeys.paramNames, paramNames);
		handleAttribute("paramNames", paramNames);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>An object containing properties which are to be sent
          as parameters for 
          <i>every</i> HTTP request.</p>
          <p>Parameters are encoded as standard HTTP parameters
          using 
          <a ext:cls="Ext" ext:member="urlEncode" href="output/Ext.html#Ext-urlEncode">Ext.urlEncode</a>.</p>
          <p>
          <b>Note</b>: 
          <code>baseParams</code> may be superseded by any 
          <code>params</code> specified in a 
          <code>
            <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">load</a>
          </code> request, see 
          <code>
            <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">load</a>
          </code> for more details.</p>This property may be
          modified after creation using the 
          <code>
            <a ext:cls="Ext.data.Store" ext:member="setBaseParam" href="output/Ext.data.Store.html#Ext.data.Store-setBaseParam">setBaseParam</a>
          </code> method.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getBaseParams () {
		return (Object) getStateHelper().eval(PropertyKeys.baseParams);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseParams</code> property.
	 * </p>
	 */
	public void setBaseParams ( Object   baseParams ) {
		getStateHelper().put(PropertyKeys.baseParams, baseParams);
		handleAttribute("baseParams", baseParams);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The 
          <a ext:cls="Ext.data.DataReader" href="output/Ext.data.DataReader.html">Reader</a> object which
          processes the data object and returns an Array of 
          <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> objects
          which are cached keyed by their 
          <b>
            <tt>
              <a ext:cls="Ext.data.Record" ext:member="id" href="output/Ext.data.Record.html#Ext.data.Record-id">id</a>
            </tt>
          </b> property.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getReader () {
		return (Object) getStateHelper().eval(PropertyKeys.reader);
	}

	/**
	 * <p>
	 * Set the value of the <code>reader</code> property.
	 * </p>
	 */
	public void setReader ( Object   reader ) {
		getStateHelper().put(PropertyKeys.reader, reader);
		handleAttribute("reader", reader);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Provides the default values for the 
          <a ext:cls="Ext.data.Store" ext:member="paramNames" href="output/Ext.data.Store.html#Ext.data.Store-paramNames">paramNames</a> property. To
          globally modify the parameters for all stores, this
          object should be changed on the store prototype.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaultParamNames () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultParamNames);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultParamNames</code> property.
	 * </p>
	 */
	public void setDefaultParamNames ( Object   defaultParamNames ) {
		getStateHelper().put(PropertyKeys.defaultParamNames, defaultParamNames);
		handleAttribute("defaultParamNames", defaultParamNames);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Defaults to 
            <tt>true</tt> (unless 
            <code>
            <a ext:cls="Ext.data.Store" ext:member="restful" href="output/Ext.data.Store.html#Ext.data.Store-restful">restful</a>:true</code>).
            Multiple requests for each CRUD action (CREATE, READ,
            UPDATE and DESTROY) will be combined and sent as one
            transaction. Only applies when 
            <code>
              <a ext:cls="Ext.data.Store" ext:member="autoSave" href="output/Ext.data.Store.html#Ext.data.Store-autoSave">autoSave</a>
            </code> is set to 
            <tt>false</tt>.</p>
            <br/>
            <p>If Store is RESTful, the DataProxy is also RESTful,
            and a unique transaction is generated for each
            record.</p>
          </div>

	 */
	
	public Boolean getBatch () {
		return (Boolean) getStateHelper().eval(PropertyKeys.batch);
	}

	/**
	 * <p>
	 * Set the value of the <code>batch</code> property.
	 * </p>
	 */
	public void setBatch ( Boolean   batch ) {
		getStateHelper().put(PropertyKeys.batch, batch);
		handleAttribute("batch", batch);
	}
    	/*
	 *
        
        
          proxy
         : Ext.data.DataProxy
        The 
        DataProxy object which
        provides access to a data object. See 
        
          url
        .
	 */
	@ClientConfig(JsonMode.Object)

	public Object getProxy () {
		return (Object) getStateHelper().eval(PropertyKeys.proxy);
	}

	/**
	 * <p>
	 * Set the value of the <code>proxy</code> property.
	 * </p>
	 */
	public void setProxy ( Object   proxy ) {
		getStateHelper().put(PropertyKeys.proxy, proxy);
		handleAttribute("proxy", proxy);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The 
            <a ext:cls="Ext.data.DataWriter" href="output/Ext.data.DataWriter.html">Writer</a> object which
            processes a record object for being written to the
            server-side database.</p>
            <br/>
            <p>When a writer is installed into a Store the 
            <a ext:cls="Ext.data.Store" ext:member="add" href="output/Ext.data.Store.html#Ext.data.Store-add">add</a>, 
            <a ext:cls="Ext.data.Store" ext:member="remove" href="output/Ext.data.Store.html#Ext.data.Store-remove">remove</a>, and 
            <a ext:cls="Ext.data.Store" ext:member="update" href="output/Ext.data.Store.html#Ext.data.Store-update">update</a>
            events on the store are monitored in order to remotely 
            <a ext:cls="Ext.data.Store" ext:member="createRecords" href="output/Ext.data.Store.html#Ext.data.Store-createRecords">create records</a>, 
            <a ext:cls="Ext.data.Store" ext:member="destroyRecord" href="output/Ext.data.Store.html#Ext.data.Store-destroyRecord">destroy records</a>, or 
            <a ext:cls="Ext.data.Store" ext:member="updateRecord" href="output/Ext.data.Store.html#Ext.data.Store-updateRecord">update records</a>.</p>
            <br/>
            <p>The proxy for this store will relay any 
            <a ext:cls="Ext.data.Store" ext:member="writexception" href="output/Ext.data.Store.html#Ext.data.Store-writexception">writexception</a> events to
            this store.</p>
            <br/>
            <p>Sample implementation:</p>
<pre>
<code>
<b>var</b> writer = 
<b>new</b> 
<a ext:cls="Ext.data.JsonWriter" href="output/Ext.data.JsonWriter.html">Ext.data.JsonWriter</a>({
    encode: true,
    writeAllFields: true 
<i>// write all fields, not just those that changed</i>
});

<i>// Typical Store collecting the Proxy, Reader and Writer
together.</i>
<b>var</b> store = 
<b>new</b> Ext.data.Store({
    storeId: 
<em>'user'</em>,
    root: 
<em>'records'</em>,
    proxy: proxy,
    reader: reader,
    writer: writer,     
<i>// &lt;-- plug a DataWriter into the store just as you would a
Reader</i>
    paramsAsHash: true,
    autoSave: false    
<i>// &lt;-- false to delay executing create, update, destroy
requests</i>
                        
<i>//     until specifically told to 
<b>do</b> so.</i>
});</code>
            </pre>
            <br/>
            <br/>
          </div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getWriter () {
		return (Object) getStateHelper().eval(PropertyKeys.writer);
	}

	/**
	 * <p>
	 * Set the value of the <code>writer</code> property.
	 * </p>
	 */
	public void setWriter ( Object   writer ) {
		getStateHelper().put(PropertyKeys.writer, writer);
		handleAttribute("writer", writer);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If 
          <tt>
            <a ext:cls="Ext.data.Store" ext:member="data" href="output/Ext.data.Store.html#Ext.data.Store-data">data</a>
          </tt> is not specified, and if 
          <tt>autoLoad</tt> is 
          <tt>true</tt> or an 
          <tt>Object</tt>, this store's 
          <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">load</a>
          method is automatically called after creation. If the
          value of 
          <tt>autoLoad</tt> is an 
          <tt>Object</tt>, this 
          <tt>Object</tt> will be passed to the store's 
          <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">load</a>
          method.</div>

	 */
	
	public Boolean getAutoLoad () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoLoad);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoLoad</code> property.
	 * </p>
	 */
	public void setAutoLoad ( Boolean   autoLoad ) {
		getStateHelper().put(PropertyKeys.autoLoad, autoLoad);
		handleAttribute("autoLoad", autoLoad);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If passed, the id to use to register
          with the 
          <b>
            <a ext:cls="Ext.StoreMgr" href="output/Ext.StoreMgr.html">StoreMgr</a>
          </b>. 
          <p>
          <b>Note</b>: if a (deprecated) 
          <tt>
            <a ext:cls="Ext.data.Store" ext:member="id" href="output/Ext.data.Store.html#Ext.data.Store-id">id</a>
          </tt> is specified it will supersede the 
          <tt>storeId</tt> assignment.</p>
</div>

	 */
	
	public String getStoreId () {
		return (String) getStateHelper().eval(PropertyKeys.storeId);
	}

	/**
	 * <p>
	 * Set the value of the <code>storeId</code> property.
	 * </p>
	 */
	public void setStoreId ( String   storeId ) {
		getStateHelper().put(PropertyKeys.storeId, storeId);
		handleAttribute("storeId", storeId);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A config object to specify the sort
          order in the request of a Store's 
          <a ext:cls="Ext.data.Store" ext:member="load" href="output/Ext.data.Store.html#Ext.data.Store-load">load</a>
          operation. Note that for local sorting, the 
          <tt>direction</tt> property is case-sensitive. See also 
          <a ext:cls="Ext.data.Store" ext:member="remoteSort" href="output/Ext.data.Store.html#Ext.data.Store-remoteSort">remoteSort</a> and 
          <a ext:cls="Ext.data.Store" ext:member="paramNames" href="output/Ext.data.Store.html#Ext.data.Store-paramNames">paramNames</a>. For example:
<pre>
<code>sortInfo: {
    field: 
<em>'fieldName'</em>,
    direction: 
<em>'ASC'</em> 
<i>// or 
<em>'DESC'</em> (
<b>case</b> sensitive 
<b>for</b> local sorting)</i>
}</code>
          </pre>
</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getSortInfo () {
		return (Object) getStateHelper().eval(PropertyKeys.sortInfo);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortInfo</code> property.
	 * </p>
	 */
	public void setSortInfo ( Object   sortInfo ) {
		getStateHelper().put(PropertyKeys.sortInfo, sortInfo);
		handleAttribute("sortInfo", sortInfo);
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
					, "beforeload"
					, "beforesave"
					, "beforewrite"
					, "clear"
					, "datachanged"
					, "exception"
					, "load"
					, "loadexception"
					, "metachange"
					, "remove"
					, "save"
					, "update"
					, "write"
				));
				return superEvent;
	}
}