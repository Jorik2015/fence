package ext.direct;

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
    The 
    RemotingProvider
    exposes access to server side methods on the client (a remote
    procedure call (RPC) type of connection where the client can
    initiate a procedure on the server).
    This allows for code to be organized in a fashion that is
    maintainable, while providing a clear path between client and
    server, something that is not always apparent when using
    URLs.
    To accomplish this the server-side needs to describe what
    classes and methods are available on the client-side. This
    configuration will typically be outputted by the server-side
    Ext.Direct stack when the API description is built.
  
 */

@InstanceOf("Ext.direct.RemotingProvider")

@FacesComponent(value = "Ext.direct.RemotingProvider")
public class RemotingProvider extends JsonProvider {
	public static final String COMPONENT_FAMILY = "Ext.direct.RemotingProvider";

	/**
	 * <p>
	 * Create a new {@link Ext.direct.RemotingProvider} instance with default property values.
	 * </p>
	 */
	public RemotingProvider() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			namespace
			,timeout
			,enableBuffer
			,actions
			,url
			,maxRetries
			,enableUrlEncode
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
	 *Namespace for the Remoting Provider
          (defaults to the browser global scope of 
          window). Explicitly specify the namespace Object,
          or specify a String to have a 
          namespace
          created implicitly.
	 */
	
	public String getNamespace () {
		return (String) getStateHelper().eval(PropertyKeys.namespace);
	}

	/**
	 * <p>
	 * Set the value of the <code>namespace</code> property.
	 * </p>
	 */
	public void setNamespace ( String   namespace ) {
		getStateHelper().put(PropertyKeys.namespace, namespace);
		handleAttribute("namespace", namespace);
	}
    	/*
	 *
        
        
          timeout
         : Number
        The timeout to use for each request.
        Defaults to 
        undefined.
	 */
	
	public Integer getTimeout () {
		return (Integer) getStateHelper().eval(PropertyKeys.timeout);
	}

	/**
	 * <p>
	 * Set the value of the <code>timeout</code> property.
	 * </p>
	 */
	public void setTimeout ( Integer   timeout ) {
		getStateHelper().put(PropertyKeys.timeout, timeout);
		handleAttribute("timeout", timeout);
	}
    	/*
	 *
            
            true or 
            false to enable or disable combining of method
            calls. If a number is specified this is the amount of
            time in milliseconds to wait before sending a batched
            request (defaults to 
            10).
            
            Calls which are received within the specified
            timeframe will be concatenated together and sent in a
            single request, optimizing the application by reducing
            the amount of round trips that have to be made to the
            server.
          
	 */
	
	public Integer getEnableBuffer () {
		return (Integer) getStateHelper().eval(PropertyKeys.enableBuffer);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableBuffer</code> property.
	 * </p>
	 */
	public void setEnableBuffer ( Integer   enableBuffer ) {
		getStateHelper().put(PropertyKeys.enableBuffer, enableBuffer);
		handleAttribute("enableBuffer", enableBuffer);
	}
    	/*
	 *Object literal defining the server side
          actions and methods. For example, if the Provider is
          configured with: 


"actions":{ 
// each property within the 
'actions' object represents a server side Class 
    
"TestAction":[ 
// array of methods within each server side Class to be   
    {              
// stubbed out on client
        
"name":
"doEcho", 
        
"len":1            
    },{
        
"name":
"multiply",
// name of method
        
"len":2           
// The number of parameters that will be used to create an
                          
// array of data to send to the server side 
function.
                          
// Ensure the server sends back a Number, not a String. 
    },{
        
"name":
"doForm",
        
"formHandler":true, 
// direct the client to use specialized form handling method

        
"len":1
    }]
}
          
          Note that a Store is not required, a server method can
          be called at any time. In the following example a 
          client side handler is used to call the server
          side method "multiply" in the server-side "TestAction"
          Class:

TestAction.multiply(
    2, 4, 
// pass two arguments to server, so specify len=2
    
// callback 
function after the server is called
    
// result: the result returned by the server
    
//      e: Ext.Direct.RemotingEvent object
    
function(result, e){
        
var t = e.getTransaction();
        
var action = t.action; 
// server side Class called
        
var method = t.method; 
// server side method called
        
if(e.status){
            
var answer = Ext.encode(result); 
// 8
    
        }
else{
            
var msg = e.message; 
// failure message
        }
    }
);
          In the example above, the server side "multiply"
          function will be passed two arguments (2 and 4). The
          "multiply" method should return the value 8 which will be
          available as the 
          result in the example above.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getActions () {
		return (Object) getStateHelper().eval(PropertyKeys.actions);
	}

	/**
	 * <p>
	 * Set the value of the <code>actions</code> property.
	 * </p>
	 */
	public void setActions ( Object   actions ) {
		getStateHelper().put(PropertyKeys.actions, actions);
		handleAttribute("actions", actions);
	}
    	/*
	 *
        
        
          url
         : String
        
        Required. The url to connect to the 
        Ext.Direct server-side
        router.
	 */
	
	public String getUrl () {
		return (String) getStateHelper().eval(PropertyKeys.url);
	}

	/**
	 * <p>
	 * Set the value of the <code>url</code> property.
	 * </p>
	 */
	public void setUrl ( String   url ) {
		getStateHelper().put(PropertyKeys.url, url);
		handleAttribute("url", url);
	}
    	/*
	 *
        
        
          maxRetries
         : Number
        Number of times to re-attempt delivery
        on failure of a call. Defaults to 
        1.
	 */
	
	public Integer getMaxRetries () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxRetries);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxRetries</code> property.
	 * </p>
	 */
	public void setMaxRetries ( Integer   maxRetries ) {
		getStateHelper().put(PropertyKeys.maxRetries, maxRetries);
		handleAttribute("maxRetries", maxRetries);
	}
    	/*
	 *
        
        
          enableUrlEncode
         : String
        Specify which param will hold the
        arguments for the method. Defaults to 
        'data'.
	 */
	
	public String getEnableUrlEncode () {
		return (String) getStateHelper().eval(PropertyKeys.enableUrlEncode);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableUrlEncode</code> property.
	 * </p>
	 */
	public void setEnableUrlEncode ( String   enableUrlEncode ) {
		getStateHelper().put(PropertyKeys.enableUrlEncode, enableUrlEncode);
		handleAttribute("enableUrlEncode", enableUrlEncode);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforecall"
					, "call"
				));
				return superEvent;
	}
}