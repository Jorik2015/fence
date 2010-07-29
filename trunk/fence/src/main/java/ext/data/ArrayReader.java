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
    Ext.data.Record objects from an
    Array. Each element of that Array represents a row of data
    fields. The fields are pulled into a Record object using as a
    subscript, the 
    mapping property of the field definition if it
    exists, or the field's ordinal position in the definition.
    Example code:


var Employee = Ext.data.Record.create([
    {name: 
'name', mapping: 1},         
// 
"mapping" only needed 
if an 
"id" field is present which
    {name: 
'occupation', mapping: 2}    
// precludes using the ordinal position as the index.
]);
var myReader = 
new Ext.data.ArrayReader({
    
idIndex: 0
}, Employee);
    
    This would consume an Array like this:

[ [1, 
'Bill', 
'Gardener'], [2, 
'Ben', 
'Horticulturalist'] ]
    
  
 */

@InstanceOf("Ext.data.ArrayReader")
@ParseConfigMode(ui = false,name="reader",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.ArrayReader")
public class ArrayReader extends JsonReader {
	public static final String COMPONENT_FAMILY = "Ext.data.ArrayReader";

	/**
	 * <p>
	 * Create a new {@link Ext.data.ArrayReader} instance with default property values.
	 * </p>
	 */
	public ArrayReader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			idIndex
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