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
    XML document based on mappings in a provided 
    Ext.data.Record constructor.
    
    Note: that in order for the browser to parse a returned
    XML document, the Content-Type header in the HTTP response must
    be set to "text/xml" or "application/xml".
    Example code:


var Employee = Ext.data.Record.create([
   {name: 
'name', mapping: 
'name'},     
// 
"mapping" property not needed 
if it is the same as 
"name"
   {name: 
'occupation'}                 
// This field will use 
"occupation" as the mapping.
]);
var myReader = 
new Ext.data.XmlReader({
   totalProperty: 
"results", 
// The element which contains the total dataset size
(optional)
   record: 
"row",           
// The repeated element which contains row information
   idProperty: 
"id"         
// The element within the row that provides an ID 
for the record (optional)
   messageProperty: 
"msg"   
// The element within the response that provides a user-feedback
message (optional)
}, Employee);
    
    This would consume an XML file like this:

<?xml version=
"1.0" encoding=
"UTF-8"?>
<dataset>
 <results>2</results>
 <row>
   <id>1</id>
   <name>Bill</name>
   <occupation>Gardener</occupation>
 </row>
 <row>
   <id>2</id>
   <name>Ben</name>
   <occupation>Horticulturalist</occupation>
 </row>
</dataset>
    
  
 */

@InstanceOf("Ext.data.XmlReader")
@ParseConfigMode(id=false,ui = false,name="reader",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.XmlReader")
public class XmlReader extends DataReader {
	public static final String COMPONENT_FAMILY = "Ext.data.XmlReader";

	/**
	 * <p>
	 * Create a new {@link Ext.data.XmlReader} instance with default property values.
	 * </p>
	 */
	public XmlReader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			record
			,totalProperty
			,idPath
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
	 *
        
        
          record
         : String
        The DomQuery path to the repeated
        element which contains record information.
	 */
	
	public String getRecord () {
		return (String) getStateHelper().eval(PropertyKeys.record);
	}

	/**
	 * <p>
	 * Set the value of the <code>record</code> property.
	 * </p>
	 */
	public void setRecord ( String   record ) {
		getStateHelper().put(PropertyKeys.record, record);
		handleAttribute("record", record);
	}
    	/*
	 *The DomQuery path from which to
          retrieve the total number of records in the dataset. This
          is only needed if the whole dataset is not passed in one
          go, but is being paged from the remote server.
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
        
        
          idPath
         : String
        The DomQuery path relative from the
        record element to the element that contains a record
        identifier value.
	 */
	
	public String getIdPath () {
		return (String) getStateHelper().eval(PropertyKeys.idPath);
	}

	/**
	 * <p>
	 * Set the value of the <code>idPath</code> property.
	 * </p>
	 */
	public void setIdPath ( String   idPath ) {
		getStateHelper().put(PropertyKeys.idPath, idPath);
		handleAttribute("idPath", idPath);
	}
    	/*
	 *
        
        
          successProperty
         : String
        The DomQuery path to the success
        attribute used by forms.
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