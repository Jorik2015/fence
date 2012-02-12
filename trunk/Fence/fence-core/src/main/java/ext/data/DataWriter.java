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
    <p>Ext.data.DataWriter facilitates create, update, and destroy
    actions between an Ext.data.Store and a server-side framework.
    A Writer enabled Store will automatically manage the Ajax
    requests to perform CRUD actions on a Store.</p>
    <p>Ext.data.DataWriter is an abstract base class which is
    intended to be extended and should not be created directly. For
    existing implementations, see 
    <a ext:cls="Ext.data.JsonWriter" href="output/Ext.data.JsonWriter.html">Ext.data.JsonWriter</a>.</p>
    <p>Creating a writer is simple:</p>
<pre>
<code>
<b>var</b> writer = 
<b>new</b> Ext.data.JsonWriter({
    encode: false   
<i>// &lt;--- false causes data to be printed to jsonData
config-property of Ext.Ajax#reqeust</i>
});</code>
    </pre>
    <p>Same old JsonReader as Ext-2.x:</p>
<pre>
<code>
<b>var</b> reader = 
<b>new</b> Ext.data.JsonReader({idProperty: 
<em>'id'</em>}, [{name: 
<em>'first'</em>}, {name: 
<em>'last'</em>}, {name: 
<em>'email'</em>}]);</code>
    </pre>
    <p>The proxy for a writer enabled store can be configured with
    a simple 
    <code>url</code>:</p>
<pre>
<code>
<i>// Create a standard HttpProxy instance.</i>
<b>var</b> proxy = 
<b>new</b> Ext.data.HttpProxy({
    url: 
<em>'app.php/users'</em>    
<i>// &lt;--- Supports 
<em>"provides"</em>-type urls, such as 
<em>'/users.json'</em>, 
<em>'/products.xml'</em> (Hello Rails/Merb)</i>
});</code>
    </pre>
    <p>For finer grained control, the proxy may also be configured
    with an 
    <code>API</code>:</p>
<pre>
<code>
<i>// Maximum flexibility 
<b>with</b> the API-configuration</i>
<b>var</b> proxy = 
<b>new</b> Ext.data.HttpProxy({
    api: {
        read    : 
<em>'app.php/users/read'</em>,
        create  : 
<em>'app.php/users/create'</em>,
        update  : 
<em>'app.php/users/update'</em>,
        destroy : {  
<i>// &lt;--- Supports object-syntax as well</i>
            url: 
<em>'app.php/users/destroy'</em>,
            method: 
<em>"DELETE"</em>
        }
    }
});</code>
    </pre>
    <p>Pulling it all together into a Writer-enabled Store:</p>
<pre>
<code>
<b>var</b> store = 
<b>new</b> Ext.data.Store({
    proxy: proxy,
    reader: reader,
    writer: writer,
    autoLoad: true,
    autoSave: true  
<i>// -- Cell-level updates.</i>
});</code>
    </pre>
    <p>Initiating write-actions 
    <b>automatically</b>, using the existing Ext2.0 Store/Record
    API:</p>
<pre>
<code>
<b>var</b> rec = store.getAt(0);
rec.set(
<em>'email'</em>, 
<em>'foo@bar.com'</em>);  
<i>// &lt;--- Immediately initiates an UPDATE action through
configured proxy.</i>

store.remove(rec);  
<i>// &lt;---- Immediately initiates a DESTROY action through
configured proxy.</i>
</code>
    </pre>
    <p>For 
    <b>record/batch</b> updates, use the Store-configuration 
    <a ext:cls="Ext.data.Store" ext:member="autoSave" href="output/Ext.data.Store.html#Ext.data.Store-autoSave">autoSave:false</a>
</p>
<pre>
<code>
<b>var</b> store = 
<b>new</b> Ext.data.Store({
    proxy: proxy,
    reader: reader,
    writer: writer,
    autoLoad: true,
    autoSave: false  
<i>// -- disable cell-updates</i>
});

<b>var</b> urec = store.getAt(0);
urec.set(
<em>'email'</em>, 
<em>'foo@bar.com'</em>);

<b>var</b> drec = store.getAt(1);
store.remove(drec);

<i>// Push the button!</i>
store.save();</code>
    </pre>
  </div>

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
			listful
			,destroyRecord
			,updateRecord
			,writeAllFields
			,createRecord
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
          <tt>false</tt> by default. Set 
          <tt>true</tt> to have the DataWriter 
          <b>always</b> write HTTP params as a list, even when
          acting upon a single record.</div>

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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>false</tt> by default. Set 
          <tt>true</tt> to have DataWriter return ALL fields of a
          modified record -- not just those that changed. 
          <tt>false</tt> to have DataWriter only request modified
          fields from a record.</div>

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