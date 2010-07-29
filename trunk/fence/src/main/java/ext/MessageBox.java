package ext;

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
import java.util.Date;

/**
 * 
    Utility class for generating different styles of message
    boxes. The alias Ext.Msg can also be used.
    Note that the MessageBox is asynchronous. Unlike a regular
    JavaScript 
    alert (which will halt browser execution), showing
    a MessageBox will not cause the code to stop. For this reason,
    if you have code that should only run 
    after some user feedback from the MessageBox, you must
    use a callback function (see the 
    
      function
     parameter for 
    show for more
    details).
    Example usage:


// Basic alert:
Ext.Msg.alert(
'Status', 
'Changes saved successfully.');

// Prompt 
for user data and process the result using a callback:
Ext.Msg.prompt(
'Name', 
'Please enter your name:', 
function(btn, text){
    
if (btn == 
'ok'){
        
// process text value and close...
    }
});

// Show a dialog using config options:
Ext.Msg.show({
   title:
'Save Changes?',
   msg: 
'You are closing a tab that has unsaved changes. Would you like
to save your changes?',
   buttons: Ext.Msg.YESNOCANCEL,
   fn: processResult,
   animEl: 
'elId',
   icon: Ext.MessageBox.QUESTION
});
    
    
    
    This class is a singleton and cannot be created
    directly.
  
 */

@InstanceOf("Ext.MessageBox")

@FacesComponent(value = "Ext.MessageBox")
public class MessageBox extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.MessageBox";

	/**
	 * <p>
	 * Create a new {@link Ext.MessageBox} instance with default property values.
	 * </p>
	 */
	public MessageBox() {
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