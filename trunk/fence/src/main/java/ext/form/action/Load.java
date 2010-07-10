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
  A class which handles loading of data from a server into the
  Fields of an 
  Ext.form.BasicForm.
  Instances of this class are only created by a 
  Form when 
  loading.
  
    
      Response Packet Criteria
    
  
  A response packet 
  must contain:
  
    
      
      
        success
       property : Boolean
      
      
        data
       property : Object
      
        The 
        data property contains the values of Fields to
        load. The individual value object for each Field is passed
        to the Field's 
        setValue
        method.
      
    
  
  
    
      JSON Packets
    
  
  By default, response packets are assumed to be JSON, so for
  the following form load call:


var myFormPanel = 
new Ext.form.FormPanel({
    title: 
'Client and routing info',
    items: [{
        fieldLabel: 
'Client',
        name: 
'clientName'
    }, {
        fieldLabel: 
'Port of loading',
        name: 
'portOfLoading'
    }, {
        fieldLabel: 
'Port of discharge',
        name: 
'portOfDischarge'
    }]
});
myFormPanel.
getForm().
load({
    url: 
'/getRoutingInfo.php',
    params: {
        consignmentRef: myConsignmentRef
    },
    failure: 
function(form, action) {
        Ext.Msg.alert(
"Load failed", action.result.errorMessage);
    }
});
  a 
  success response packet may look like this:
  
  

{
    success: true,
    data: {
        clientName: 
"Fred. Olsen Lines",
        portOfLoading: 
"FXT",
        portOfDischarge: 
"OSL"
    }
}
  while a 
  failure response packet may look like this:
  
  

{
    success: false,
    errorMessage: 
"Consignment reference not found"
}
  
  Other data may be placed into the response for processing the 
  Form's callback or event handler
  methods. The object decoded from this JSON is available in the 
  result
  property.
 */

@InstanceOf("Ext.form.Action.Load")

@FacesComponent(value = "Ext.form.Action.Load")
public class Load extends Action {
	public static final String COMPONENT_FAMILY = "Ext.form.Action.Load";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Action.Load} instance with default property values.
	 * </p>
	 */
	public Load() {
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