package ext.form.action;

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
    A class which handles submission of data from 
    Forms and processes the
    returned response.
    Instances of this class are only created by a 
    Form when 
    submitting.
    
      
        Response Packet Criteria
      
    
    A response packet may contain:
    
      
        
        
          success
         property : Boolean 
        The 
        success property is required.
        
        
          errors
         property : Object 
        
          The 
          errors property, which is optional, contains
          error messages for invalid fields.
        
      
    
    
      
        JSON Packets
      
    
    By default, response packets are assumed to be JSON, so a
    typical response packet may look like this:

{
    success: false,
    errors: {
        clientCode: 
"Client not found",
        portOfLoading: 
"This field must not be null"
    }
}
    
    Other data may be placed into the response for processing by
    the 
    Ext.form.BasicForm's callback
    or event handler methods. The object decoded from this JSON is
    available in the 
    result
    property.
    Alternatively, if an 
    errorReader is specified
    as an 
    XmlReader:

errorReader: 
new Ext.data.XmlReader({
            record : 
'field',
            success: 
'@success'
        }, [
            
'id', 
'msg'
        ]
    )
    
    then the results may be sent back in XML format:

<?xml version=
"1.0" encoding=
"UTF-8"?>
<message success=
"false">
<errors>
    <field>
        <id>clientCode</id>
        <msg><![CDATA[Code not found. <br
/><i>This is a test validation message from the server
</i>]]></msg>
    </field>
    <field>
        <id>portOfLoading</id>
        <msg><![CDATA[Port not found. <br
/><i>This is a test validation message from the server
</i>]]></msg>
    </field>
</errors>
</message>
    
    Other elements may be placed into the response XML for
    processing by the 
    Ext.form.BasicForm's callback
    or event handler methods. The XML document is available in the 
    errorReader's 
    xmlData
    property.
  
 */

@InstanceOf("Ext.form.Action.Submit")

@FacesComponent(value = "Ext.form.Action.Submit")
public class Submit extends Action {
	public static final String COMPONENT_FAMILY = "Ext.form.Action.Submit";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Action.Submit} instance with default property values.
	 * </p>
	 */
	public Submit() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			errorReader
			,clientValidation
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
            
              Optional. JSON is interpreted with no need for an
              errorReader.
            
            A Reader which reads a single record from the
            returned data. The DataReader's 
            success property specifies how submission
            success is determined. The Record's data provides the
            error messages to apply to any invalid form Fields.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getErrorReader () {
		return (Object) getStateHelper().eval(PropertyKeys.errorReader);
	}

	/**
	 * <p>
	 * Set the value of the <code>errorReader</code> property.
	 * </p>
	 */
	public void setErrorReader ( Object   errorReader ) {
		getStateHelper().put(PropertyKeys.errorReader, errorReader);
		handleAttribute("errorReader", errorReader);
	}
    	/*
	 *Determines whether a Form's fields are
          validated in a final call to 
          isValid prior to
          submission. Pass 
          false in the Form's submit options to prevent
          this. If not defined, pre-submission field validation is
          performed.
	 */
	
	public Boolean getClientValidation () {
		return (Boolean) getStateHelper().eval(PropertyKeys.clientValidation);
	}

	/**
	 * <p>
	 * Set the value of the <code>clientValidation</code> property.
	 * </p>
	 */
	public void setClientValidation ( Boolean   clientValidation ) {
		getStateHelper().put(PropertyKeys.clientValidation, clientValidation);
		handleAttribute("clientValidation", clientValidation);
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