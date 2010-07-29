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
    This class encapsulates the field definition information
    specified in the field definition objects passed to 
    Ext.data.Record.create.
    Developers do not need to instantiate this class. Instances
    are created by 
    Ext.data.Record.create and
    cached in the 
    fields
    property of the created Record constructor's 
    prototype.
  
 */

@InstanceOf("Ext.data.Field")
@ParseConfigMode(ui = false,name="fields",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.data.Field")
public class Field extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.Field";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Field} instance with default property values.
	 * </p>
	 */
	public Field() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			convert
			,mapping
			,defaultValue
			,type
			,allowBlank
			,dateFormat
			,sortType
			,sortDir
			,name
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
	 *A function which converts the value
          provided by the Reader into an object that will be stored
          in the Record. It is passed the following parameters:
          
            
              
              v : Mixed
              The data value as read by the
              Reader, if undefined will use the configured 
              
                defaultValue
              .
              
              rec : Mixed
              The data object containing the
              row as read by the Reader. Depending on the Reader
              type, this could be an Array (
              ArrayReader), an
              object (
              JsonReader), or an
              XML element (
              XMLReader).
            
          


// example of convert 
function
function fullName(v, record){
    
return record.name.last + 
', ' + record.name.first;
}

function location(v, record){
    
return !record.city ? 
'' : (record.city + 
', ' + record.state);
}

var Dude = Ext.data.Record.create([
    {name: 
'fullname',  convert: fullName},
    {name: 
'firstname', mapping: 
'name.first'},
    {name: 
'lastname',  mapping: 
'name.last'},
    {name: 
'city', defaultValue: 
'homeless'},
    
'state',
    {name: 
'location',  convert: location}
]);

// create the data store
var store = 
new Ext.data.Store({
    reader: 
new Ext.data.JsonReader(
        {
            idProperty: 
'key',
            root: 
'daRoot',
            totalProperty: 
'total'
        },
        Dude  
// recordType
    )
});

var myData = [
    { key: 1,
      name: { first: 
'Fat',    last:  
'Albert' }
      
// notice no city, state provided 
in data object
    },
    { key: 2,
      name: { first: 
'Barney', last:  
'Rubble' },
      city: 
'Bedrock', state: 
'Stoneridge'
    },
    { key: 3,
      name: { first: 
'Cliff',  last:  
'Claven' },
      city: 
'Boston',  state: 
'MA'
    }
];
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getConvert () {
		return (Object) getStateHelper().eval(PropertyKeys.convert);
	}

	/**
	 * <p>
	 * Set the value of the <code>convert</code> property.
	 * </p>
	 */
	public void setConvert ( Object   convert ) {
		getStateHelper().put(PropertyKeys.convert, convert);
		handleAttribute("convert", convert);
	}
    	/*
	 *
            (Optional) A path expression for use by the 
            Ext.data.DataReader
            implementation that is creating the 
            Record to extract the
            Field value from the data object. If the path
            expression is the same as the field name, the mapping
            may be omitted.
            The form of the mapping expression depends on the
            Reader being used.
            
              
                
                  Ext.data.JsonReader
                  The mapping is a string
                  containing the javascript expression to reference
                  the data from an element of the data item's 
                  root Array.
                  Defaults to the field name.
                
                
                  Ext.data.XmlReader
                  The mapping is an 
                  Ext.DomQuery path to
                  the data item relative to the DOM element that
                  represents the 
                  record. Defaults
                  to the field name.
                
                
                  Ext.data.ArrayReader
                  The mapping is a number
                  indicating the Array index of the field's value.
                  Defaults to the field specification's Array
                  position.
                
              
            
            If a more complex value extraction strategy is
            required, then configure the Field with a 
            convert function. This is
            passed the whole row object, and may interrogate it in
            whatever way is necessary in order to return the
            desired data.
          
	 */
	
	public String getMapping () {
		return (String) getStateHelper().eval(PropertyKeys.mapping);
	}

	/**
	 * <p>
	 * Set the value of the <code>mapping</code> property.
	 * </p>
	 */
	public void setMapping ( String   mapping ) {
		getStateHelper().put(PropertyKeys.mapping, mapping);
		handleAttribute("mapping", mapping);
	}
    	/*
	 *The default value used 
          when a Record is being created by a 
          Reader when the item
          referenced by the 
          
            mapping
           does not exist in the data object (i.e.
          undefined). (defaults to "")
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaultValue () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultValue</code> property.
	 * </p>
	 */
	public void setDefaultValue ( Object   defaultValue ) {
		getStateHelper().put(PropertyKeys.defaultValue, defaultValue);
		handleAttribute("defaultValue", defaultValue);
	}
    	/*
	 *The data type for automatic conversion
          from received data to the 
          stored value if 
          
            convert
           has not been specified. This may be specified as
          a string value. Possible values are 
          
            
              auto (Default, implies no conversion)
              string
              int
              float
              boolean
              date
            
          
          This may also be specified by referencing a member of
          the 
          Ext.data.Types class.
          Developers may create their own application-specific
          data types by defining new members of the 
          Ext.data.Types
          class.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getType () {
		return (Object) getStateHelper().eval(PropertyKeys.type);
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType ( Object   type ) {
		getStateHelper().put(PropertyKeys.type, type);
		handleAttribute("type", type);
	}
    	/*
	 *Used for validating a 
          record, defaults to 
          true. An empty value here will cause 
          Ext.data.Record.
          isValid to evaluate to 
          false.
	 */
	
	public Boolean getAllowBlank () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowBlank);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowBlank</code> property.
	 * </p>
	 */
	public void setAllowBlank ( Boolean   allowBlank ) {
		getStateHelper().put(PropertyKeys.allowBlank, allowBlank);
		handleAttribute("allowBlank", allowBlank);
	}
    	/*
	 *
            (Optional) Used when converting received data into a
            Date when the 
            type is
            specified as 
            
              "date"
            .
            A format string for the 
            Date.parseDate function, or
            "timestamp" if the value provided by the Reader is a
            UNIX timestamp, or "time" if the value provided by the
            Reader is a javascript millisecond timestamp. See 
            Date
          
	 */
	
	public String getDateFormat () {
		return (String) getStateHelper().eval(PropertyKeys.dateFormat);
	}

	/**
	 * <p>
	 * Set the value of the <code>dateFormat</code> property.
	 * </p>
	 */
	public void setDateFormat ( String   dateFormat ) {
		getStateHelper().put(PropertyKeys.dateFormat, dateFormat);
		handleAttribute("dateFormat", dateFormat);
	}
    	/*
	 *A function which converts a Field's
          value to a comparable value in order to ensure correct
          sort ordering. Predefined functions are provided in 
          Ext.data.SortTypes. A
          custom sort example:


// current sort     after sort we want
// +-+------+          +-+------+
// |1|First |          |1|First |
// |2|Last  |          |3|Second|
// |3|Second|          |2|Last  |
// +-+------+          +-+------+

sortType: 
function(value) {
   
switch (value.toLowerCase()) 
// native toLowerCase():
   {
      
case 
'first': 
return 1;
      
case 
'second': 
return 2;
      
default: 
return 3;
   }
}
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getSortType () {
		return (Object) getStateHelper().eval(PropertyKeys.sortType);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortType</code> property.
	 * </p>
	 */
	public void setSortType ( Object   sortType ) {
		getStateHelper().put(PropertyKeys.sortType, sortType);
		handleAttribute("sortType", sortType);
	}
    	/*
	 *
        
        
          sortDir
         : String
        Initial direction to sort (
        
          "ASC"
         or 
        
          "DESC"
        ). Defaults to 
        
          "ASC"
        .
	 */
	
	public String getSortDir () {
		return (String) getStateHelper().eval(PropertyKeys.sortDir);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortDir</code> property.
	 * </p>
	 */
	public void setSortDir ( String   sortDir ) {
		getStateHelper().put(PropertyKeys.sortDir, sortDir);
		handleAttribute("sortDir", sortDir);
	}
    	/*
	 *The name by which the field is
          referenced within the Record. This is referenced by, for
          example, the 
          dataIndex property in column definition
          objects passed to 
          Ext.grid.ColumnModel. 
          Note: In the simplest case, if no properties other
          than 
          name are required, a field definition may
          consist of just a String for the field name.
	 */
	
	public String getName () {
		return (String) getStateHelper().eval(PropertyKeys.name);
	}

	/**
	 * <p>
	 * Set the value of the <code>name</code> property.
	 * </p>
	 */
	public void setName ( String   name ) {
		getStateHelper().put(PropertyKeys.name, name);
		handleAttribute("name", name);
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