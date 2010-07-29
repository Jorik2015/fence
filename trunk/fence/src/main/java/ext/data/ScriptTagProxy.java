package ext.data;

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
 * An implementation of Ext.data.DataProxy
  that reads a data object from a URL which may be in a domain
  other than the originating domain of the running page.
  
  
    Note that if you are retrieving data from a page that is in
    a domain that is NOT the same as the originating domain of the
    running page, you must use this class, rather than
    HttpProxy.
    
  
  The content passed back from a server resource requested by a
  ScriptTagProxy 
  must be executable JavaScript source code because it is
  used as the source inside a <script> tag.
  
  In order for the browser to process the returned data, the
  server must wrap the data object with a call to a callback
  function, the name of which is passed as a parameter by the
  ScriptTagProxy. Below is a Java example for a servlet which
  returns data for either a ScriptTagProxy, or an HttpProxy
  depending on whether the callback name was passed:

boolean scriptTag = false;
String cb = request.getParameter(
"callback");
if (cb != null) {
    scriptTag = true;
    response.setContentType(
"text/javascript");
} 
else {
    response.setContentType(
"application/x-json");
}
Writer out = response.getWriter();
if (scriptTag) {
    out.write(cb + 
"(");
}
out.print(dataBlock.toJsonString());
if (scriptTag) {
    out.write(
");");
}
  
  Below is a PHP example to do the same thing:

$callback = $_REQUEST[
'callback'];

// Create the output object.
$output = array(
'a' => 
'Apple', 
'b' => 
'Banana');

//start output
if ($callback) {
    header(
'Content-Type: text/javascript');
    echo $callback . 
'(' . json_encode($output) . 
');';
} 
else {
    header(
'Content-Type: application/x-json');
    echo json_encode($output);
}
  
  Below is the ASP.Net code to do the same thing:

String jsonString = 
"{success: true}";
String cb = Request.Params.Get(
"callback");
String responseString = 
"";
if (!String.IsNullOrEmpty(cb)) {
    responseString = cb + 
"(" + jsonString + 
")";
} 
else {
    responseString = jsonString;
}
Response.Write(responseString);
  
 */

@InstanceOf("Ext.data.ScriptTagProxy")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.ScriptTagProxy")
public class ScriptTagProxy extends DataProxy {
	public static final String COMPONENT_FAMILY = "Ext.data.ScriptTagProxy";

	/**
	 * <p>
	 * Create a new {@link Ext.data.ScriptTagProxy} instance with default property values.
	 * </p>
	 */
	public ScriptTagProxy() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			timeout
			,nocache
			,url
			,callbackParam
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
        
        
          timeout
         : Number
        The number of milliseconds to wait for a
        response. Defaults to 30 seconds.
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
        
        
          nocache
         : Boolean
        Defaults to true. Disable caching by
        adding a unique parameter name to the request.
	 */
	
	public Boolean getNocache () {
		return (Boolean) getStateHelper().eval(PropertyKeys.nocache);
	}

	/**
	 * <p>
	 * Set the value of the <code>nocache</code> property.
	 * </p>
	 */
	public void setNocache ( Boolean   nocache ) {
		getStateHelper().put(PropertyKeys.nocache, nocache);
		handleAttribute("nocache", nocache);
	}
    	/*
	 *
        
        
          url
         : String
        The URL from which to request the data
        object.
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
	 *The name of the parameter to pass to
          the server which tells the server the name of the
          callback function set up by the load call to process the
          returned data object. Defaults to "callback".
          The server-side processing must read this parameter
          value, and generate javascript output which calls this
          named function passing the data object as its only
          parameter.
	 */
	
	public String getCallbackParam () {
		return (String) getStateHelper().eval(PropertyKeys.callbackParam);
	}

	/**
	 * <p>
	 * Set the value of the <code>callbackParam</code> property.
	 * </p>
	 */
	public void setCallbackParam ( String   callbackParam ) {
		getStateHelper().put(PropertyKeys.callbackParam, callbackParam);
		handleAttribute("callbackParam", callbackParam);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "loadexception"
				));
				return superEvent;
	}
}