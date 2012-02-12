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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
  <p>Provides Ext.direct support for submitting form data.</p>
  <p>This example illustrates usage of Ext.Direct to 
  <b>submit</b> a form through Ext.Direct.</p>
<pre>
<code>
<b>var</b> myFormPanel = 
<b>new</b> Ext.form.FormPanel({
    
<i>// configs 
<b>for</b> FormPanel</i>
    title: 
<em>'Basic Information'</em>,
    renderTo: document.body,
    width: 300, height: 160,
    padding: 10,
    buttons:[{
        text: 
<em>'Submit'</em>,
        handler: 
<b>function</b>(){
            myFormPanel.getForm().submit({
                params: {
                    foo: 
<em>'bar'</em>,
                    uid: 34
                }
            });
        }
    }],

    
<i>// configs apply to child items</i>
    defaults: {anchor: 
<em>'100%'</em>},
    defaultType: 
<em>'textfield'</em>,
    items: [{
        fieldLabel: 
<em>'Name'</em>,
        name: 
<em>'name'</em>
    },{
        fieldLabel: 
<em>'Email'</em>,
        name: 
<em>'email'</em>
    },{
        fieldLabel: 
<em>'Company'</em>,
        name: 
<em>'company'</em>
    }],

    
<i>// configs 
<b>for</b> BasicForm</i>
    api: {
        
<i>// The server-side method to call 
<b>for</b> load() requests</i>
        load: Profile.getBasicInfo,
        
<i>// The server-side must mark the submit handler as a 
<em>'formHandler'</em>
</i>
        submit: Profile.updateBasicInfo
    },
    
<i>// specify the order 
<b>for</b> the passed params</i>
    paramOrder: [
<em>'uid'</em>, 
<em>'foo'</em>]
});</code>
  </pre>The data packet sent to the server will resemble something
  like: 
<pre>
<code>{
    
<em>"action"</em>:
<em>"Profile"</em>,
<em>"method"</em>:
<em>"updateBasicInfo"</em>,
<em>"type"</em>:
<em>"rpc"</em>,
<em>"tid"</em>:
<em>"6"</em>,
    
<em>"result"</em>:{
        
<em>"success"</em>:true,
        
<em>"id"</em>:{
            
<em>"extAction"</em>:
<em>"Profile"</em>,
<em>"extMethod"</em>:
<em>"updateBasicInfo"</em>,
            
<em>"extType"</em>:
<em>"rpc"</em>,
<em>"extTID"</em>:
<em>"6"</em>,
<em>"extUpload"</em>:
<em>"false"</em>,
            
<em>"name"</em>:
<em>"Aaron Conran"</em>,
<em>"email"</em>:
<em>"aaron@extjs.com"</em>,
<em>"company"</em>:
<em>"Ext JS, LLC"</em>
        }
    }
}</code>
  </pre>The form will process a data packet returned by the server
  that is similar to the following: 
<pre>
<code>
<i>// sample success packet (batched requests)</i>
[
    {
        
<em>"action"</em>:
<em>"Profile"</em>,
<em>"method"</em>:
<em>"updateBasicInfo"</em>,
<em>"type"</em>:
<em>"rpc"</em>,
<em>"tid"</em>:3,
        
<em>"result"</em>:{
            
<em>"success"</em>:true
        }
    }
]

<i>// sample failure packet (one request)</i>
{
        
<em>"action"</em>:
<em>"Profile"</em>,
<em>"method"</em>:
<em>"updateBasicInfo"</em>,
<em>"type"</em>:
<em>"rpc"</em>,
<em>"tid"</em>:
<em>"6"</em>,
        
<em>"result"</em>:{
            
<em>"errors"</em>:{
                
<em>"email"</em>:
<em>"already taken"</em>
            },
            
<em>"success"</em>:false,
            
<em>"foo"</em>:
<em>"bar"</em>
        }
}</code>
  </pre>Also see the discussion in 
  <a ext:cls="Ext.form.Action.DirectLoad" href="output/Ext.form.Action.DirectLoad.html">Ext.form.Action.DirectLoad</a>.</div>

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