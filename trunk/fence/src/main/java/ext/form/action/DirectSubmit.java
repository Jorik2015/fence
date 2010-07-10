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
  Provides Ext.direct support for submitting form data.
  This example illustrates usage of Ext.Direct to 
  submit a form through Ext.Direct.


var myFormPanel = 
new Ext.form.FormPanel({
    
// configs 
for FormPanel
    title: 
'Basic Information',
    renderTo: document.body,
    width: 300, height: 160,
    padding: 10,
    buttons:[{
        text: 
'Submit',
        handler: 
function(){
            myFormPanel.getForm().submit({
                params: {
                    foo: 
'bar',
                    uid: 34
                }
            });
        }
    }],

    
// configs apply to child items
    defaults: {anchor: 
'100%'},
    defaultType: 
'textfield',
    items: [{
        fieldLabel: 
'Name',
        name: 
'name'
    },{
        fieldLabel: 
'Email',
        name: 
'email'
    },{
        fieldLabel: 
'Company',
        name: 
'company'
    }],

    
// configs 
for BasicForm
    api: {
        
// The server-side method to call 
for load() requests
        load: Profile.getBasicInfo,
        
// The server-side must mark the submit handler as a 
'formHandler'
        submit: Profile.updateBasicInfo
    },
    
// specify the order 
for the passed params
    paramOrder: [
'uid', 
'foo']
});
  The data packet sent to the server will resemble something
  like: 

{
    
"action":
"Profile",
"method":
"updateBasicInfo",
"type":
"rpc",
"tid":
"6",
    
"result":{
        
"success":true,
        
"id":{
            
"extAction":
"Profile",
"extMethod":
"updateBasicInfo",
            
"extType":
"rpc",
"extTID":
"6",
"extUpload":
"false",
            
"name":
"Aaron Conran",
"email":
"aaron@extjs.com",
"company":
"Ext JS, LLC"
        }
    }
}
  The form will process a data packet returned by the server
  that is similar to the following: 


// sample success packet (batched requests)
[
    {
        
"action":
"Profile",
"method":
"updateBasicInfo",
"type":
"rpc",
"tid":3,
        
"result":{
            
"success":true
        }
    }
]

// sample failure packet (one request)
{
        
"action":
"Profile",
"method":
"updateBasicInfo",
"type":
"rpc",
"tid":
"6",
        
"result":{
            
"errors":{
                
"email":
"already taken"
            },
            
"success":false,
            
"foo":
"bar"
        }
}
  Also see the discussion in 
  Ext.form.Action.DirectLoad.
 */

@InstanceOf("Ext.form.Action.DirectSubmit")

@FacesComponent(value = "Ext.form.Action.DirectSubmit")
public class DirectSubmit extends Submit {
	public static final String COMPONENT_FAMILY = "Ext.form.Action.DirectSubmit";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Action.DirectSubmit} instance with default property values.
	 * </p>
	 */
	public DirectSubmit() {
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