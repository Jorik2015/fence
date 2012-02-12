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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>Utility class for generating different styles of message
    boxes. The alias Ext.Msg can also be used.</p>
    <p>Note that the MessageBox is asynchronous. Unlike a regular
    JavaScript 
    <code>alert</code> (which will halt browser execution), showing
    a MessageBox will not cause the code to stop. For this reason,
    if you have code that should only run 
    <em>after</em> some user feedback from the MessageBox, you must
    use a callback function (see the 
    <code>
      <b>function</b>
    </code> parameter for 
    <a ext:cls="Ext.MessageBox" ext:member="show" href="output/Ext.MessageBox.html#Ext.MessageBox-show">show</a> for more
    details).</p>
    <p>Example usage:</p>
<pre>
<code>
<i>// Basic alert:</i>
Ext.Msg.alert(
<em>'Status'</em>, 
<em>'Changes saved successfully.'</em>);

<i>// Prompt 
<b>for</b> user data and process the result using a callback:</i>
Ext.Msg.prompt(
<em>'Name'</em>, 
<em>'Please enter your name:'</em>, 
<b>function</b>(btn, text){
    
<b>if</b> (btn == 
<em>'ok'</em>){
        
<i>// process text value and close...</i>
    }
});

<i>// Show a dialog using config options:</i>
Ext.Msg.show({
   title:
<em>'Save Changes?'</em>,
   msg: 
<em>'You are closing a tab that has unsaved changes. Would you like
to save your changes?'</em>,
   buttons: Ext.Msg.YESNOCANCEL,
   fn: processResult,
   animEl: 
<em>'elId'</em>,
   icon: Ext.MessageBox.QUESTION
});</code>
    </pre>
    <br/>
    <br/>
    <i>This class is a singleton and cannot be created
    directly.</i>
  </div>

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