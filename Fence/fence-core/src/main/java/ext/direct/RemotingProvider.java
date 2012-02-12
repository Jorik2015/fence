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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>The 
    <a ext:cls="Ext.direct.RemotingProvider" href="output/Ext.direct.RemotingProvider.html">RemotingProvider</a>
    exposes access to server side methods on the client (a remote
    procedure call (RPC) type of connection where the client can
    initiate a procedure on the server).</p>
    <p>This allows for code to be organized in a fashion that is
    maintainable, while providing a clear path between client and
    server, something that is not always apparent when using
    URLs.</p>
    <p>To accomplish this the server-side needs to describe what
    classes and methods are available on the client-side. This
    configuration will typically be outputted by the server-side
    Ext.Direct stack when the API description is built.</p>
  </div>

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
			maxRetries
			,enableUrlEncode
			,enableBuffer
			,url
			,timeout
			,actions
			,namespace
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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <tt>true</tt> or 
            <tt>false</tt> to enable or disable combining of method
            calls. If a number is specified this is the amount of
            time in milliseconds to wait before sending a batched
            request (defaults to 
            <tt>10</tt>).</p>
            <br/>
            <p>Calls which are received within the specified
            timeframe will be concatenated together and sent in a
            single request, optimizing the application by reducing
            the amount of round trips that have to be made to the
            server.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Object literal defining the server side
          actions and methods. For example, if the Provider is
          configured with: 
<pre>
<code>
<em>"actions"</em>:{ 
<i>// each property within the 
<em>'actions'</em> object represents a server side Class</i> 
    
<em>"TestAction"</em>:[ 
<i>// array of methods within each server side Class to be  </i> 
    {              
<i>// stubbed out on client</i>
        
<em>"name"</em>:
<em>"doEcho"</em>, 
        
<em>"len"</em>:1            
    },{
        
<em>"name"</em>:
<em>"multiply"</em>,
<i>// name of method</i>
        
<em>"len"</em>:2           
<i>// The number of parameters that will be used to create an</i>
                          
<i>// array of data to send to the server side 
<b>function</b>.</i>
                          
<i>// Ensure the server sends back a Number, not a String.</i> 
    },{
        
<em>"name"</em>:
<em>"doForm"</em>,
        
<em>"formHandler"</em>:true, 
<i>// direct the client to use specialized form handling method</i>

        
<em>"len"</em>:1
    }]
}</code>
          </pre>
          <p>Note that a Store is not required, a server method can
          be called at any time. In the following example a 
          <b>client side</b> handler is used to call the server
          side method "multiply" in the server-side "TestAction"
          Class:</p>
<pre>
<code>TestAction.multiply(
    2, 4, 
<i>// pass two arguments to server, so specify len=2</i>
    
<i>// callback 
<b>function</b> after the server is called</i>
    
<i>// result: the result returned by the server</i>
    
<i>//      e: Ext.Direct.RemotingEvent object</i>
    
<b>function</b>(result, e){
        
<b>var</b> t = e.getTransaction();
        
<b>var</b> action = t.action; 
<i>// server side Class called</i>
        
<b>var</b> method = t.method; 
<i>// server side method called</i>
        
<b>if</b>(e.status){
            
<b>var</b> answer = Ext.encode(result); 
<i>// 8</i>
    
        }
<b>else</b>{
            
<b>var</b> msg = e.message; 
<i>// failure message</i>
        }
    }
);</code>
          </pre>In the example above, the server side "multiply"
          function will be passed two arguments (2 and 4). The
          "multiply" method should return the value 8 which will be
          available as the 
          <tt>result</tt> in the example above.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Namespace for the Remoting Provider
          (defaults to the browser global scope of 
          <i>window</i>). Explicitly specify the namespace Object,
          or specify a String to have a 
          <a ext:cls="Ext" ext:member="namespace" href="output/Ext.html#Ext-namespace">namespace
          created</a> implicitly.</div>

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