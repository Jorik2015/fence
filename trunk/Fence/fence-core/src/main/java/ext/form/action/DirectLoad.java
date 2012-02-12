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
  <p>Provides Ext.direct support for loading form data.</p>
  <p>This example illustrates usage of Ext.Direct to 
  <b>load</b> a form through Ext.Direct.</p>
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
});

<i>// load the form</i>
myFormPanel.getForm().load({
    
<i>// pass 2 arguments to server side getBasicInfo method
(len=2)</i>
    params: {
        foo: 
<em>'bar'</em>,
        uid: 34
    }
});</code>
  </pre>The data packet sent to the server will resemble something
  like: 
<pre>
<code>[
    {
        
<em>"action"</em>:
<em>"Profile"</em>,
<em>"method"</em>:
<em>"getBasicInfo"</em>,
<em>"type"</em>:
<em>"rpc"</em>,
<em>"tid"</em>:2,
        
<em>"data"</em>:[34,
<em>"bar"</em>] 
<i>// note the order of the params</i>
    }
]</code>
  </pre>The form will process a data packet returned by the server
  that is similar to the following format: 
<pre>
<code>[
    {
        
<em>"action"</em>:
<em>"Profile"</em>,
<em>"method"</em>:
<em>"getBasicInfo"</em>,
<em>"type"</em>:
<em>"rpc"</em>,
<em>"tid"</em>:2,
        
<em>"result"</em>:{
            
<em>"success"</em>:true,
            
<em>"data"</em>:{
                
<em>"name"</em>:
<em>"Fred Flintstone"</em>,
                
<em>"company"</em>:
<em>"Slate Rock and Gravel"</em>,
                
<em>"email"</em>:
<em>"fred.flintstone@slaterg.com"</em>
            }
        }
    }
]</code>
  </pre>
</div>

 */

@InstanceOf("Ext.form.Action.DirectLoad")

@FacesComponent(value = "Ext.form.Action.DirectLoad")
public class DirectLoad extends Load {
	public static final String COMPONENT_FAMILY = "Ext.form.Action.DirectLoad";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Action.DirectLoad} instance with default property values.
	 * </p>
	 */
	public DirectLoad() {
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