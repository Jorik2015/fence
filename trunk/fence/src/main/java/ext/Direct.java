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
    
      
        Overview
      
    
    Ext.Direct aims to streamline communication between the
    client and server by providing a single interface that reduces
    the amount of common code typically required to validate data
    and handle returned data packets (reading data, error
    conditions, etc).
    The Ext.direct namespace includes several classes for a
    closer integration with the server-side. The Ext.data namespace
    also includes classes for working with Ext.data.Stores which
    are backed by data from an Ext.Direct method.
    
      
        Specification
      
    
    For additional information consult the 
    Ext.Direct
    Specification.
    
      
        Providers
      
    
    Ext.Direct uses a provider architecture, where one or more
    providers are used to transport data to and from the server.
    There are several providers that exist in the core at the
    moment:
    
      
        
        JsonProvider for
        simple JSON operations
        
        PollingProvider
        for repeated requests
        
        RemotingProvider
        exposes server side on the client.
      
    
    A provider does not need to be invoked directly, providers
    are added via 
    Ext.Direct.
    add.
    
      
        Router
      
    
    Ext.Direct utilizes a "router" on the server to direct
    requests from the client to the appropriate server-side method.
    Because the Ext.Direct API is completely platform-agnostic, you
    could completely swap out a Java based server solution and
    replace it with one that uses C# without changing the client
    side JavaScript at all.
    
      
        Server side events
      
    
    Custom events from the server may be handled by the client
    by adding listeners, for example:

{
"type":
"event",
"name":
"message",
"data":
"Successfully polled at: 11:19:30 am"}

// add a handler 
for a 
'message' event sent by the server
Ext.Direct.on(
'message', 
function(e){
    out.append(String.format(
'<p><i>{0}</i></p>', e.data));
            out.el.scrollTo(
't', 100000, true);
});
    
    
    
    This class is a singleton and cannot be created
    directly.
  
 */

@InstanceOf("Ext.Direct")

@FacesComponent(value = "Ext.Direct")
public class Direct extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.Direct";

	/**
	 * <p>
	 * Create a new {@link Ext.Direct} instance with default property values.
	 * </p>
	 */
	public Direct() {
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
				superEvent.addAll(Arrays.asList(
					 "event"
					, "exception"
				));
				return superEvent;
	}
}