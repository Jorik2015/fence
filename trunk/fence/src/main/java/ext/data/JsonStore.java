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
  Small helper class to make creating 
  Ext.data.Stores from JSON data
  easier. A JsonStore will be automatically configured with a 
  Ext.data.JsonReader.
  A store configuration would be something like:


var store = 
new Ext.data.JsonStore({
    
// store configs
    autoDestroy: true,
    url: 
'get-images.php',
    storeId: 
'myStore',
    
// reader configs
    root: 
'images',
    idProperty: 
'name',
    fields: [
'name', 
'url', {name:
'size', type: 
'float'}, {name:
'lastmod', type:
'date'}]
});
  
  
   
  This store is configured to consume a returned object of the
  form:

{
    images: [
        {name: 
'Image one', url:
'/GetImage.php?id=1', size:46.5, lastmod: 
new Date(2007, 10, 29)},
        {name: 
'Image Two', url:
'/GetImage.php?id=2', size:43.2, lastmod: 
new Date(2007, 10, 30)}
    ]
}
  An object literal of this form could also be used as the 
  data config
  option.
  
   
  
  *Note: Although not listed here, this class accepts all of
  the configuration options of 
  
    JsonReader
  .
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
			totalProperty
			,messageProperty
			,idProperty
			,root
			,successProperty
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
	 *[total] Name of the property from which
          to retrieve the total number of records in the dataset.
          This is only needed if the whole dataset is not passed in
          one go, but is being paged from the remote server.
          Defaults to 
          total.
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
	 *[undefined] 
          Required. The name of the property which contains
          the Array of row objects. Defaults to 
          undefined. An exception will be thrown if the
          root property is undefined. The data packet value for
          this property should be an empty array to clear the data
          or show no data.
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
	 *[success] Name of the property from
          which to retrieve the success attribute. Defaults to 
          success. See 
          Ext.data.DataProxy.
          exception for additional
          information.
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
            Either an Array of 
            Field definition objects
            (which will be passed to 
            Ext.data.Record.create,
            or a 
            Record constructor
            created from 
            Ext.data.Record.create.
          
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