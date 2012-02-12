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
    <p>Data reader class to create an Array of 
    <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> objects from a
    JSON packet based on mappings in a provided 
    <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> constructor.</p>
    <p>Example code:</p>
<pre>
<code>
<b>var</b> myReader = 
<b>new</b> Ext.data.JsonReader({
    
<i>// metadata configuration options:</i>
    
<a ext:cls="Ext.data.JsonReader" ext:member="idProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-idProperty">idProperty</a>: 
<em>'id'</em>
    
<a ext:cls="Ext.data.JsonReader" ext:member="root" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-root">root</a>: 
<em>'rows'</em>,
    
<a ext:cls="Ext.data.JsonReader" ext:member="totalProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-totalProperty">totalProperty</a>: 
<em>'results'</em>,
    
<a ext:cls="Ext.data.DataReader" ext:member="messageProperty" href="output/Ext.data.DataReader.html#Ext.data.DataReader-messageProperty">Ext.data.DataReader.messageProperty</a>:

<em>"msg"</em>  
<i>// The element within the response that provides a user-feedback
message (optional)</i>

    
<i>// the fields config option will internally create an 
<a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a>
</i>
    
<i>// constructor that provides mapping 
<b>for</b> reading the record data objects</i>
    
<a ext:cls="Ext.data.DataReader" ext:member="fields" href="output/Ext.data.DataReader.html#Ext.data.DataReader-fields">fields</a>: [
        
<i>// map Record's 
<em>'firstname'</em> field to data object's key of same name</i>
        {name: 
<em>'name'</em>, mapping: 
<em>'firstname'</em>},
        
<i>// map Record's 
<em>'job'</em> field to data object's 
<em>'occupation'</em> key</i>
        {name: 
<em>'job'</em>, mapping: 
<em>'occupation'</em>}
    ]
});</code>
    </pre>
    <p>This would consume a JSON data object of the form:</p>
<pre>
<code>{
    results: 2000, 
<i>// Reader's configured 
<a ext:cls="Ext.data.JsonReader" ext:member="totalProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-totalProperty">totalProperty</a>
</i>
    rows: [        
<i>// Reader's configured 
<a ext:cls="Ext.data.JsonReader" ext:member="root" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-root">root</a>
</i>
        
<i>// record data objects:</i>
        { 
<a ext:cls="Ext.data.JsonReader" ext:member="idProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-idProperty">id</a>: 1,
firstname: 
<em>'Bill'</em>, occupation: 
<em>'Gardener'</em> },
        { 
<a ext:cls="Ext.data.JsonReader" ext:member="idProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-idProperty">id</a>: 2,
firstname: 
<em>'Ben'</em> , occupation: 
<em>'Horticulturalist'</em> },
        ...
    ]
}</code>
    </pre>
    <p>
      <b>
        <u>Automatic configuration using metaData</u>
      </b>
    </p>
    <p>It is possible to change a JsonReader's metadata at any time
    by including a 
    <b>
      <tt>metaData</tt>
    </b> property in the JSON data object. If the JSON data object
    has a 
    <b>
      <tt>metaData</tt>
    </b> property, a 
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a> object using this Reader
    will reconfigure itself to use the newly provided field
    definition and fire its 
    <a ext:cls="Ext.data.Store" ext:member="metachange" href="output/Ext.data.Store.html#Ext.data.Store-metachange">metachange</a>
    event. The metachange event handler may interrogate the 
    <b>
      <tt>metaData</tt>
    </b> property to perform any configuration required.</p>
    <p>Note that reconfiguring a Store potentially invalidates
    objects which may refer to Fields or Records which no longer
    exist.</p>
    <p>To use this facility you would create the JsonReader like
    this:</p>
<pre>
<code>
<b>var</b> myReader = 
<b>new</b> Ext.data.JsonReader();</code>
    </pre>
    <p>The first data packet from the server would configure the
    reader by containing a 
    <b>
      <tt>metaData</tt>
    </b> property 
    <b>and</b> the data. For example, the JSON data object might
    take the form:</p>
<pre>
<code>{
    metaData: {
        
<em>"
<a ext:cls="Ext.data.JsonReader" ext:member="idProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-idProperty">idProperty</a>"</em>: 
<em>"id"</em>,
        
<em>"
<a ext:cls="Ext.data.JsonReader" ext:member="root" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-root">root</a>"</em>: 
<em>"rows"</em>,
        
<em>"
<a ext:cls="Ext.data.JsonReader" ext:member="totalProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-totalProperty">totalProperty</a>"</em>: 
<em>"results"</em>
        
<em>"
<a ext:cls="Ext.data.JsonReader" ext:member="successProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-successProperty">successProperty</a>"</em>: 
<em>"success"</em>,
        
<em>"
<a ext:cls="Ext.data.DataReader" ext:member="fields" href="output/Ext.data.DataReader.html#Ext.data.DataReader-fields">fields</a>"</em>:
[
            {
<em>"name"</em>: 
<em>"name"</em>},
            {
<em>"name"</em>: 
<em>"job"</em>, 
<em>"mapping"</em>: 
<em>"occupation"</em>}
        ],
        
<i>// used by store to set its sortInfo</i>
        
<em>"sortInfo"</em>:{
           
<em>"field"</em>: 
<em>"name"</em>,
           
<em>"direction"</em>: 
<em>"ASC"</em>
        },
        
<i>// 
<a ext:cls="Ext.PagingToolbar" href="output/Ext.PagingToolbar.html">paging data</a> (
<b>if</b> applicable)</i>
        
<em>"start"</em>: 0,
        
<em>"limit"</em>: 2,
        
<i>// custom property</i>
        
<em>"foo"</em>: 
<em>"bar"</em>
    },
    
<i>// Reader's configured 
<a ext:cls="Ext.data.JsonReader" ext:member="successProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-successProperty">successProperty</a>
</i>
    
<em>"success"</em>: true,
    
<i>// Reader's configured 
<a ext:cls="Ext.data.JsonReader" ext:member="totalProperty" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-totalProperty">totalProperty</a>
</i>
    
<em>"results"</em>: 2000,
    
<i>// Reader's configured 
<a ext:cls="Ext.data.JsonReader" ext:member="root" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-root">root</a>
</i>
    
<i>// (this data simulates 2 results 
<a ext:cls="Ext.PagingToolbar" href="output/Ext.PagingToolbar.html">per page</a>)</i>
    
<em>"rows"</em>: [ 
<i>// 
<b>*Note:</b> this must be an Array</i>
        { 
<em>"id"</em>: 1, 
<em>"name"</em>: 
<em>"Bill"</em>, 
<em>"occupation"</em>: 
<em>"Gardener"</em> },
        { 
<em>"id"</em>: 2, 
<em>"name"</em>:  
<em>"Ben"</em>, 
<em>"occupation"</em>: 
<em>"Horticulturalist"</em> }
    ]
}</code>
    </pre>
    <p>The 
    <b>
      <tt>metaData</tt>
    </b> property in the JSON data object should contain:</p>
    <div class="mdetail-params">
      <ul>
        <li>any of the configuration options for this class</li>
        <li>a 
        <b>
          <tt>
            <a ext:cls="Ext.data.Record" ext:member="fields" href="output/Ext.data.Record.html#Ext.data.Record-fields">fields</a>
          </tt>
        </b> property which the JsonReader will use as an argument
        to the 
        <a ext:cls="Ext.data.Record" ext:member="create" href="output/Ext.data.Record.html#Ext.data.Record-create">data Record
        create method</a> in order to configure the layout of the
        Records it will produce.</li>
        <li>a 
        <b>
          <tt>
            <a ext:cls="Ext.data.Store" ext:member="sortInfo" href="output/Ext.data.Store.html#Ext.data.Store-sortInfo">sortInfo</a>
          </tt>
        </b> property which the JsonReader will use to set the 
        <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>'s 
        <a ext:cls="Ext.data.Store" ext:member="sortInfo" href="output/Ext.data.Store.html#Ext.data.Store-sortInfo">sortInfo</a>
        property</li>
        <li>any custom properties needed</li>
      </ul>
    </div>
  </div>

 */

@InstanceOf("Ext.data.JsonReader")
@ParseConfigMode(ui = false,name="reader",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.JsonReader")
public class JsonReader extends DataReader {
	public static final String COMPONENT_FAMILY = "Ext.data.JsonReader";

	/**
	 * <p>
	 * Create a new {@link Ext.data.JsonReader} instance with default property values.
	 * </p>
	 */
	public JsonReader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			totalProperty
			,root
			,successProperty
			,idProperty
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
<div class="long">[total] Name of the property from which
          to retrieve the total number of records in the dataset.
          This is only needed if the whole dataset is not passed in
          one go, but is being paged from the remote server.
          Defaults to 
          <tt>total</tt>.</div>

	 */
	
	public String getTotalProperty () {
		return (String) getStateHelper().eval(PropertyKeys.totalProperty);
	}

	/**
	 * <p>
	 * Set the value of the <code>totalProperty</code> property.
	 * </p>
	 */
	public void setTotalProperty ( String   totalProperty ) {
		getStateHelper().put(PropertyKeys.totalProperty, totalProperty);
		handleAttribute("totalProperty", totalProperty);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">[undefined] 
          <b>Required</b>. The name of the property which contains
          the Array of row objects. Defaults to 
          <tt>undefined</tt>. An exception will be thrown if the
          root property is undefined. The data packet value for
          this property should be an empty array to clear the data
          or show no data.</div>

	 */
	
	public String getRoot () {
		return (String) getStateHelper().eval(PropertyKeys.root);
	}

	/**
	 * <p>
	 * Set the value of the <code>root</code> property.
	 * </p>
	 */
	public void setRoot ( String   root ) {
		getStateHelper().put(PropertyKeys.root, root);
		handleAttribute("root", root);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">[success] Name of the property from
          which to retrieve the success attribute. Defaults to 
          <tt>success</tt>. See 
          <a ext:cls="Ext.data.DataProxy" href="output/Ext.data.DataProxy.html">Ext.data.DataProxy</a>.
          <a ext:cls="Ext.data.DataProxy" ext:member="exception" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-exception">exception</a> for additional
          information.</div>

	 */
	
	public String getSuccessProperty () {
		return (String) getStateHelper().eval(PropertyKeys.successProperty);
	}

	/**
	 * <p>
	 * Set the value of the <code>successProperty</code> property.
	 * </p>
	 */
	public void setSuccessProperty ( String   successProperty ) {
		getStateHelper().put(PropertyKeys.successProperty, successProperty);
		handleAttribute("successProperty", successProperty);
	}
    	/*
	 *
        
        
          idProperty
         : String
        [id] Name of the property within a row
        object that contains a record identifier value. Defaults to
        
        id
	 */
	
	public String getIdProperty () {
		return (String) getStateHelper().eval(PropertyKeys.idProperty);
	}

	/**
	 * <p>
	 * Set the value of the <code>idProperty</code> property.
	 * </p>
	 */
	public void setIdProperty ( String   idProperty ) {
		getStateHelper().put(PropertyKeys.idProperty, idProperty);
		handleAttribute("idProperty", idProperty);
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