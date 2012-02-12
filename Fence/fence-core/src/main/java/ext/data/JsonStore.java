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
  <p>Small helper class to make creating 
  <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>s from JSON data
  easier. A JsonStore will be automatically configured with a 
  <a ext:cls="Ext.data.JsonReader" href="output/Ext.data.JsonReader.html">Ext.data.JsonReader</a>.</p>
  <p>A store configuration would be something like:</p>
<pre>
<code>
<b>var</b> store = 
<b>new</b> Ext.data.JsonStore({
    
<i>// store configs</i>
    autoDestroy: true,
    url: 
<em>'get-images.php'</em>,
    storeId: 
<em>'myStore'</em>,
    
<i>// reader configs</i>
    root: 
<em>'images'</em>,
    idProperty: 
<em>'name'</em>,
    fields: [
<em>'name'</em>, 
<em>'url'</em>, {name:
<em>'size'</em>, type: 
<em>'float'</em>}, {name:
<em>'lastmod'</em>, type:
<em>'date'</em>}]
});</code>
  </pre>
  <br/>
  <br/> 
  <p>This store is configured to consume a returned object of the
  form:</p>
<pre>
<code>{
    images: [
        {name: 
<em>'Image one'</em>, url:
<em>'/GetImage.php?id=1'</em>, size:46.5, lastmod: 
<b>new</b> Date(2007, 10, 29)},
        {name: 
<em>'Image Two'</em>, url:
<em>'/GetImage.php?id=2'</em>, size:43.2, lastmod: 
<b>new</b> Date(2007, 10, 30)}
    ]
}</code>
  </pre>An object literal of this form could also be used as the 
  <a ext:cls="Ext.data.JsonStore" ext:member="data" href="output/Ext.data.JsonStore.html#Ext.data.JsonStore-data">data</a> config
  option.
  <br/>
  <br/> 
  <p>
  <b>*Note:</b> Although not listed here, this class accepts all of
  the configuration options of 
  <b>
    <a ext:cls="Ext.data.JsonReader" href="output/Ext.data.JsonReader.html">JsonReader</a>
  </b>.</p>
</div>

 */
@XType("jsonstore")
@InstanceOf("Ext.data.JsonStore")
@ParseConfigMode(ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.JsonStore")
public class JsonStore extends Store {
	public static final String COMPONENT_FAMILY = "Ext.data.JsonStore";

	/**
	 * <p>
	 * Create a new {@link Ext.data.JsonStore} instance with default property values.
	 * </p>
	 */
	public JsonStore() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			messageProperty
			,totalProperty
			,root
			,successProperty
			,idProperty
			,fields
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
        
        
          messageProperty
         : String
        [undefined] Optional name of a property
        within a server-response that represents a user-feedback
        message.
	 */
	
	public String getMessageProperty () {
		return (String) getStateHelper().eval(PropertyKeys.messageProperty);
	}

	/**
	 * <p>
	 * Set the value of the <code>messageProperty</code> property.
	 * </p>
	 */
	public void setMessageProperty ( String   messageProperty ) {
		getStateHelper().put(PropertyKeys.messageProperty, messageProperty);
		handleAttribute("messageProperty", messageProperty);
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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Either an Array of 
            <a ext:cls="Ext.data.Field" href="output/Ext.data.Field.html">Field</a> definition objects
            (which will be passed to 
            <a ext:cls="Ext.data.Record" ext:member="create" href="output/Ext.data.Record.html#Ext.data.Record-create">Ext.data.Record.create</a>,
            or a 
            <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a> constructor
            created from 
            <a ext:cls="Ext.data.Record" ext:member="create" href="output/Ext.data.Record.html#Ext.data.Record-create">Ext.data.Record.create</a>.</p>
          </div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getFields () {
		return (Object) getStateHelper().eval(PropertyKeys.fields);
	}

	/**
	 * <p>
	 * Set the value of the <code>fields</code> property.
	 * </p>
	 */
	public void setFields ( Object   fields ) {
		getStateHelper().put(PropertyKeys.fields, fields);
		handleAttribute("fields", fields);
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