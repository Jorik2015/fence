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
    Data reader class to create an Array of 
    Ext.data.Record objects from a
    JSON packet based on mappings in a provided 
    Ext.data.Record constructor.
    Example code:


var myReader = 
new Ext.data.JsonReader({
    
// metadata configuration options:
    
idProperty: 
'id'
    
root: 
'rows',
    
totalProperty: 
'results',
    
Ext.data.DataReader.messageProperty:

"msg"  
// The element within the response that provides a user-feedback
message (optional)

    
// the fields config option will internally create an 
Ext.data.Record
    
// constructor that provides mapping 
for reading the record data objects
    
fields: [
        
// map Record's 
'firstname' field to data object's key of same name
        {name: 
'name'},
        
// map Record's 
'job' field to data object's 
'occupation' key
        {name: 
'job', mapping: 
'occupation'}
    ]
});
    
    This would consume a JSON data object of the form:

{
    results: 2000, 
// Reader's configured 
totalProperty
    rows: [        
// Reader's configured 
root
        
// record data objects:
        { 
id: 1,
firstname: 
'Bill', occupation: 
'Gardener' },
        { 
id: 2,
firstname: 
'Ben' , occupation: 
'Horticulturalist' },
        ...
    ]
}
    
    
      
        Automatic configuration using metaData
      
    
    It is possible to change a JsonReader's metadata at any time
    by including a 
    
      metaData
     property in the JSON data object. If the JSON data object
    has a 
    
      metaData
     property, a 
    Store object using this Reader
    will reconfigure itself to use the newly provided field
    definition and fire its 
    metachange
    event. The metachange event handler may interrogate the 
    
      metaData
     property to perform any configuration required.
    Note that reconfiguring a Store potentially invalidates
    objects which may refer to Fields or Records which no longer
    exist.
    To use this facility you would create the JsonReader like
    this:


var myReader = 
new Ext.data.JsonReader();
    
    The first data packet from the server would configure the
    reader by containing a 
    
      metaData
     property 
    and the data. For example, the JSON data object might
    take the form:

{
    metaData: {
        
"
idProperty": 
"id",
        
"
root": 
"rows",
        
"
totalProperty": 
"results"
        
"
successProperty": 
"success",
        
"
fields":
[
            {
"name": 
"name"},
            {
"name": 
"job", 
"mapping": 
"occupation"}
        ],
        
// used by store to set its sortInfo
        
"sortInfo":{
           
"field": 
"name",
           
"direction": 
"ASC"
        },
        
// 
paging data (
if applicable)
        
"start": 0,
        
"limit": 2,
        
// custom property
        
"foo": 
"bar"
    },
    
// Reader's configured 
successProperty
    
"success": true,
    
// Reader's configured 
totalProperty
    
"results": 2000,
    
// Reader's configured 
root
    
// (this data simulates 2 results 
per page)
    
"rows": [ 
// 
*Note: this must be an Array
        { 
"id": 1, 
"name": 
"Bill", 
"occupation": 
"Gardener" },
        { 
"id": 2, 
"name":  
"Ben", 
"occupation": 
"Horticulturalist" }
    ]
}
    
    The 
    
      metaData
     property in the JSON data object should contain:
    
      
        any of the configuration options for this class
        a 
        
          
            fields
          
         property which the JsonReader will use as an argument
        to the 
        data Record
        create method in order to configure the layout of the
        Records it will produce.
        a 
        
          
            sortInfo
          
         property which the JsonReader will use to set the 
        Ext.data.Store's 
        sortInfo
        property
        any custom properties needed
      
    
  
 */

@InstanceOf("Ext.data.JsonReader")
@ParseConfigMode(id=false,ui = false,name="reader",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
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
			,idProperty
			,root
			,successProperty
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