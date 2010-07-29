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
  Formerly known as "SimpleStore".
  Small helper class to make creating 
  Ext.data.Stores from Array data
  easier. An ArrayStore will be automatically configured with a 
  Ext.data.ArrayReader.
  A store configuration would be something like:


var store = 
new Ext.data.ArrayStore({
    
// store configs
    autoDestroy: true,
    storeId: 
'myStore',
    
// reader configs
    idIndex: 0,  
    fields: [
       
'company',
       {name: 
'price', type: 
'float'},
       {name: 
'change', type: 
'float'},
       {name: 
'pctChange', type: 
'float'},
       {name: 
'lastChange', type: 
'date', dateFormat: 
'n/j h:ia'}
    ]
});
  
  
   
  This store is configured to consume a returned object of the
  form:


var myData = [
    [
'3m Co',71.72,0.02,0.03,
'9/1 12:00am'],
    [
'Alcoa Inc',29.01,0.42,1.47,
'9/1 12:00am'],
    [
'Boeing Co.',75.43,0.53,0.71,
'9/1 12:00am'],
    [
'Hewlett-Packard Co.',36.53,-0.03,-0.08,
'9/1 12:00am'],
    [
'Wal-Mart Stores, Inc.',45.45,0.73,1.63,
'9/1 12:00am']
];
  An object literal of this form could also be used as the 
  data config
  option.
  
   
  
  *Note: Although not listed here, this class accepts all of
  the configuration options of 
  
    ArrayReader
  .
 */
@XType("arraystore")
@InstanceOf("Ext.data.ArrayStore")
@ParseConfigMode(ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.ArrayStore")
public class ArrayStore extends Store {
	public static final String COMPONENT_FAMILY = "Ext.data.ArrayStore";

	/**
	 * <p>
	 * Create a new {@link Ext.data.ArrayStore} instance with default property values.
	 * </p>
	 */
	public ArrayStore() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			idIndex
			,totalProperty
			,messageProperty
			,idProperty
			,root
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
        
        
          idIndex
         : Number
        The subscript within row Array that
        provides an ID for the Record.
	 */
	
	public Integer getIdIndex () {
		return (Integer) getStateHelper().eval(PropertyKeys.idIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>idIndex</code> property.
	 * </p>
	 */
	public void setIdIndex ( Integer   idIndex ) {
		getStateHelper().put(PropertyKeys.idIndex, idIndex);
		handleAttribute("idIndex", idIndex);
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