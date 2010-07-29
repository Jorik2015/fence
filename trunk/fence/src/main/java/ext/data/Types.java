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
    This is s static class containing the system-supplied data
    types which may be given to a 
    Field.
    The properties in this class are used as type indicators in
    the 
    Field class, so to test whether a
    Field is of a certain type, compare the 
    type property
    against properties of this class.
    Developers may add their own application-specific data types
    to this class. Definition names must be UPPERCASE. each type
    definition must contain three properties:
    
      
        
        convert : 
        Function
        A function to convert raw data values
        from a data block into the data to be stored in the Field.
        The function is passed the collowing parameters: 
        
          
            
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
          
        
        
        sortType : 
        Function 
        A function to convert the stored data
        into comparable form, as defined by 
        Ext.data.SortTypes.
        
        type : 
        String 
        A textual data type name.
      
    
    For example, to create a VELatLong field (See the Microsoft
    Bing Mapping API) containing the latitude/longitude value of a
    datapoint on a map from a JsonReader data block which contained
    the properties 
    lat and 
    long, you would define a new data type like
    this:


// Add a 
new Field data type which stores a VELatLong object 
in the Record.
Ext.data.Types.VELATLONG = {
    convert: 
function(v, data) {
        
return 
new VELatLong(data.lat, data.long);
    },
    sortType: 
function(v) {
        
return v.Latitude;  
// When sorting, order by latitude
    },
    type: 
'VELatLong'
};
    
    Then, when declaring a Record, use


var types = Ext.data.Types; 
// allow shorthand type access
UnitRecord = Ext.data.Record.create([
    { name: 
'unitName', mapping: 
'UnitName' },
    { name: 
'curSpeed', mapping: 
'CurSpeed', type: types.INT },
    { name: 
'latitude', mapping: 
'lat', type: types.FLOAT },
    { name: 
'latitude', mapping: 
'lat', type: types.FLOAT },
    { name: 
'position', type: types.VELATLONG }
]);
    
    
    
    This class is a singleton and cannot be created
    directly.
  
 */

@InstanceOf("Ext.data.Types")

@FacesComponent(value = "Ext.data.Types")
public class Types extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.Types";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Types} instance with default property values.
	 * </p>
	 */
	public Types() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
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