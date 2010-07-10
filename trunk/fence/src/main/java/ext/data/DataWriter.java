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
    Ext.data.DataWriter facilitates create, update, and destroy
    actions between an Ext.data.Store and a server-side framework.
    A Writer enabled Store will automatically manage the Ajax
    requests to perform CRUD actions on a Store.
    Ext.data.DataWriter is an abstract base class which is
    intended to be extended and should not be created directly. For
    existing implementations, see 
    Ext.data.JsonWriter.
    Creating a writer is simple:


var writer = 
new Ext.data.JsonWriter({
    encode: false   
// <--- false causes data to be printed to jsonData
config-property of Ext.Ajax#reqeust
});
    
    Same old JsonReader as Ext-2.x:


var reader = 
new Ext.data.JsonReader({idProperty: 
'id'}, [{name: 
'first'}, {name: 
'last'}, {name: 
'email'}]);
    
    The proxy for a writer enabled store can be configured with
    a simple 
    url:


// Create a standard HttpProxy instance.
var proxy = 
new Ext.data.HttpProxy({
    url: 
'app.php/users'    
// <--- Supports 
"provides"-type urls, such as 
'/users.json', 
'/products.xml' (Hello Rails/Merb)
});
    
    For finer grained control, the proxy may also be configured
    with an 
    API:


// Maximum flexibility 
with the API-configuration
var proxy = 
new Ext.data.HttpProxy({
    api: {
        read    : 
'app.php/users/read',
        create  : 
'app.php/users/create',
        update  : 
'app.php/users/update',
        destroy : {  
// <--- Supports object-syntax as well
            url: 
'app.php/users/destroy',
            method: 
"DELETE"
        }
    }
});
    
    Pulling it all together into a Writer-enabled Store:


var store = 
new Ext.data.Store({
    proxy: proxy,
    reader: reader,
    writer: writer,
    autoLoad: true,
    autoSave: true  
// -- Cell-level updates.
});
    
    Initiating write-actions 
    automatically, using the existing Ext2.0 Store/Record
    API:


var rec = store.getAt(0);
rec.set(
'email', 
'foo@bar.com');  
// <--- Immediately initiates an UPDATE action through
configured proxy.

store.remove(rec);  
// <---- Immediately initiates a DESTROY action through
configured proxy.
    
    For 
    record/batch updates, use the Store-configuration 
    autoSave:false


var store = 
new Ext.data.Store({
    proxy: proxy,
    reader: reader,
    writer: writer,
    autoLoad: true,
    autoSave: false  
// -- disable cell-updates
});

var urec = store.getAt(0);
urec.set(
'email', 
'foo@bar.com');

var drec = store.getAt(1);
store.remove(drec);

// Push the button!
store.save();
    
  
 */

@InstanceOf("Ext.data.DataWriter")
@ParseConfigMode(ui = false,name="writer",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.DataWriter")
public class DataWriter extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.DataWriter";

	/**
	 * <p>
	 * Create a new {@link Ext.data.DataWriter} instance with default property values.
	 * </p>
	 */
	public DataWriter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			createRecord
			,writeAllFields
			,listful
			,destroyRecord
			,updateRecord
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
        
        
          createRecord
         : Function
        Abstract method that should be
        implemented in all subclasses (e.g.: 
        JsonWriter.createRecord)
	 */
	@ClientConfig(JsonMode.Function)

	public Object getCreateRecord () {
		return (Object) getStateHelper().eval(PropertyKeys.createRecord);
	}

	/**
	 * <p>
	 * Set the value of the <code>createRecord</code> property.
	 * </p>
	 */
	public void setCreateRecord ( Object   createRecord ) {
		getStateHelper().put(PropertyKeys.createRecord, createRecord);
		handleAttribute("createRecord", createRecord);
	}
    	/*
	 *
          false by default. Set 
          true to have DataWriter return ALL fields of a
          modified record -- not just those that changed. 
          false to have DataWriter only request modified
          fields from a record.
	 */
	
	public Boolean getWriteAllFields () {
		return (Boolean) getStateHelper().eval(PropertyKeys.writeAllFields);
	}

	/**
	 * <p>
	 * Set the value of the <code>writeAllFields</code> property.
	 * </p>
	 */
	public void setWriteAllFields ( Boolean   writeAllFields ) {
		getStateHelper().put(PropertyKeys.writeAllFields, writeAllFields);
		handleAttribute("writeAllFields", writeAllFields);
	}
    	/*
	 *
          false by default. Set 
          true to have the DataWriter 
          always write HTTP params as a list, even when
          acting upon a single record.
	 */
	
	public Boolean getListful () {
		return (Boolean) getStateHelper().eval(PropertyKeys.listful);
	}

	/**
	 * <p>
	 * Set the value of the <code>listful</code> property.
	 * </p>
	 */
	public void setListful ( Boolean   listful ) {
		getStateHelper().put(PropertyKeys.listful, listful);
		handleAttribute("listful", listful);
	}
    	/*
	 *
        
        
          destroyRecord
         : Function
        Abstract method that should be
        implemented in all subclasses (e.g.: 
        JsonWriter.destroyRecord)
	 */
	@ClientConfig(JsonMode.Function)

	public Object getDestroyRecord () {
		return (Object) getStateHelper().eval(PropertyKeys.destroyRecord);
	}

	/**
	 * <p>
	 * Set the value of the <code>destroyRecord</code> property.
	 * </p>
	 */
	public void setDestroyRecord ( Object   destroyRecord ) {
		getStateHelper().put(PropertyKeys.destroyRecord, destroyRecord);
		handleAttribute("destroyRecord", destroyRecord);
	}
    	/*
	 *
        
        
          updateRecord
         : Function
        Abstract method that should be
        implemented in all subclasses (e.g.: 
        JsonWriter.updateRecord
	 */
	@ClientConfig(JsonMode.Function)

	public Object getUpdateRecord () {
		return (Object) getStateHelper().eval(PropertyKeys.updateRecord);
	}

	/**
	 * <p>
	 * Set the value of the <code>updateRecord</code> property.
	 * </p>
	 */
	public void setUpdateRecord ( Object   updateRecord ) {
		getStateHelper().put(PropertyKeys.updateRecord, updateRecord);
		handleAttribute("updateRecord", updateRecord);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				return superEvent;
	}
}