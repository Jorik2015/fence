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
 * 
  The Store class encapsulates a client side cache of 
  Record objects which provide input
  data for Components such as the 
  GridPanel, the 
  ComboBox, or the 
  DataView.
  
    Retrieving Data
  
  A Store object may access a data object using:
  
    
      
      configured
      implementation of 
      DataProxy
      
      data to
      automatically pass in data
      
      loadData
      to manually pass in data
    
  
  
   
  
    Reading Data
  
  A Store object has no inherent knowledge of the format of the
  data object (it could be an Array, XML, or JSON). A Store object
  uses an appropriate 
  configured
  implementation of a 
  DataReader to create 
  Record instances from the data
  object.
  
    Store Types
  
  There are several implementations of Store available which are
  customized for use with a specific DataReader implementation.
  Here is an example using an ArrayStore which implicitly creates a
  reader commensurate to an Array data object.


var myStore = 
new Ext.data.ArrayStore({
    fields: [
'fullname', 
'first'],
    idIndex: 0 
// id 
for each record will be the first element
});
  
  For custom implementations create a basic 
  Ext.data.Store configured as
  needed:


// create a 
Record constructor:
var rt = Ext.data.Record.create([
    {name: 
'fullname'},
    {name: 
'first'}
]);
var myStore = 
new Ext.data.Store({
    
// explicitly create reader
    reader: 
new Ext.data.ArrayReader(
        {
            idIndex: 0  
// id 
for each record will be the first element
        },
        rt 
// recordType
    )
});
  
  Load some data into store (note the data object is an array
  which corresponds to the reader):


var myData = [
    [1, 
'Fred Flintstone', 
'Fred'],  
// note that id 
for the record is the first element
    [2, 
'Barney Rubble', 
'Barney']
];
myStore.loadData(myData);
  
  Records are cached and made available through accessor
  functions. An example of adding a record to the store:


var defaultData = {
    fullname: 
'Full Name',
    first: 
'First Name'
};
var recId = 100; 
// provide unique id 
for the record
var r = 
new myStore.recordType(defaultData, ++recId); 
// create 
new record
myStore.
insert(0, r); 
// insert a 
new record into the store (also see 
add)
  
  
    Writing Data
  
  And 
  new in Ext version 3, use the new 
  DataWriter to create an
  automated, 
  Writable
  Store along with 
  RESTful
  features.
 */
@XType("store")
@InstanceOf("Ext.data.Store")
@ParseConfigMode(id=false,ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
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
			sortInfo
			,baseParams
			,proxy
			,batch
			,autoLoad
			,restful
			,defaultParamNames
			,storeId
			,data
			,autoDestroy
			,reader
			,writer
			,url
			,paramNames
			,autoSave
			,pruneModifiedRecords
			,remoteSort
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
	 *A config object to specify the sort
          order in the request of a Store's 
          load
          operation. Note that for local sorting, the 
          direction property is case-sensitive. See also 
          remoteSort and 
          paramNames. For example:

sortInfo: {
    field: 
'fieldName',
    direction: 
'ASC' 
// or 
'DESC' (
case sensitive 
for local sorting)
}
          
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
    	/*
	 *
          An object containing properties which are to be sent
          as parameters for 
          every HTTP request.
          Parameters are encoded as standard HTTP parameters
          using 
          Ext.urlEncode.
          
          Note: 
          baseParams may be superseded by any 
          params specified in a 
          
            load
           request, see 
          
            load
           for more details.This property may be
          modified after creation using the 
          
            setBaseParam
           method.
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
	 *
            Defaults to 
            true (unless 
            
            restful:true).
            Multiple requests for each CRUD action (CREATE, READ,
            UPDATE and DESTROY) will be combined and sent as one
            transaction. Only applies when 
            
              autoSave
             is set to 
            false.
            
            If Store is RESTful, the DataProxy is also RESTful,
            and a unique transaction is generated for each
            record.
          
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
	 *If 
          
            data
           is not specified, and if 
          autoLoad is 
          true or an 
          Object, this store's 
          load
          method is automatically called after creation. If the
          value of 
          autoLoad is an 
          Object, this 
          Object will be passed to the store's 
          load
          method.
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
	 *Defaults to 
          false. Set to 
          true to have the Store and the set Proxy operate
          in a RESTful manner. The store will automatically
          generate GET, POST, PUT and DELETE requests to the
          server. The HTTP method used for any given CRUD action is
          described in 
          Ext.data.Api.restActions. For
          additional information see 
          Ext.data.DataProxy.restful.
          
          
          Note: if 
          
          restful:true 
          batch will internally be set to 
          false.
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
	 *Provides the default values for the 
          paramNames property. To
          globally modify the parameters for all stores, this
          object should be changed on the store prototype.
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
	 *If passed, the id to use to register
          with the 
          
            StoreMgr
          . 
          
          Note: if a (deprecated) 
          
            id
           is specified it will supersede the 
          storeId assignment.
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
	 *
          true to destroy the store when the component the
          store is bound to is destroyed (defaults to 
          false). 
          
          Note: this should be set to true when using stores
          that are bound to only 1 component.
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
	 *The 
          Reader object which
          processes the data object and returns an Array of 
          Ext.data.Record objects
          which are cached keyed by their 
          
            
              id
            
           property.
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
	 *
            The 
            Writer object which
            processes a record object for being written to the
            server-side database.
            
            When a writer is installed into a Store the 
            add, 
            remove, and 
            update
            events on the store are monitored in order to remotely 
            create records, 
            destroy records, or 
            update records.
            
            The proxy for this store will relay any 
            writexception events to
            this store.
            
            Sample implementation:


var writer = 
new 
Ext.data.JsonWriter({
    encode: true,
    writeAllFields: true 
// write all fields, not just those that changed
});

// Typical Store collecting the Proxy, Reader and Writer
together.
var store = 
new Ext.data.Store({
    storeId: 
'user',
    root: 
'records',
    proxy: proxy,
    reader: reader,
    writer: writer,     
// <-- plug a DataWriter into the store just as you would a
Reader
    paramsAsHash: true,
    autoSave: false    
// <-- false to delay executing create, update, destroy
requests
                        
//     until specifically told to 
do so.
});
            
            
            
          
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
	 *If a 
          
            proxy
           is not specified the 
          url will be used to implicitly configure a 
          HttpProxy if an 
          url is specified. Typically this option, or the 
          
            data
           option will be specified.
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
	 *
            An object containing properties which specify the
            names of the paging and sorting parameters passed to
            remote servers when loading blocks of data. By default,
            this object takes the following form:

{
    start : 
'start',  
// The parameter name which specifies the start row
    limit : 
'limit',  
// The parameter name which specifies number of rows to 
return
    sort : 
'sort',    
// The parameter name which specifies the column to sort on
    dir : 
'dir'       
// The parameter name which specifies the sort direction
}
            
            The server must produce the requested data block
            upon receipt of these parameter names. If different
            parameter names are required, this property can be
            overriden using a configuration property.
            A 
            PagingToolbar bound to
            this Store uses this property to determine the
            parameter names to use in its 
            requests.
          
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
	 *
            Defaults to 
            true causing the store to automatically 
            save
            records to the server when a record is modified (ie:
            becomes 'dirty'). Specify 
            false to manually call 
            save to
            send all modifiedRecords to the server.
            
            
            Note: each CRUD action will be sent as a
            separate request.
          
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
          true to clear all modified record information
          each time the store is loaded or when a record is removed
          (defaults to 
          false). See 
          getModifiedRecords for the
          accessor method to retrieve the modified records.
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
	 *
          true if sorting is to be handled by requesting
          the 
          
            Proxy
           to provide a refreshed version of the data object
          in sorted order, as opposed to sorting the Record cache
          in place (defaults to 
          false). 
          If 
          remoteSort is 
          true, then clicking on a 
          Grid Column's 
          header
          causes the current page to be requested from the server
          appending the following two parameters to the 
          
            
              params
            
          :
          
            
              
              
                sort
               : String
              The 
              name (as specified in the Record's 
              Field definition) of the
              field to sort on.
              
              
                dir
               : String
              The direction of the sort, 'ASC'
              or 'DESC' (case-sensitive).
            
          
          
          
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