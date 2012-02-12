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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">An implementation of Ext.data.DataProxy
  that reads a data object from a URL which may be in a domain
  other than the originating domain of the running page.
  <br/>
  <p>
    <b>Note that if you are retrieving data from a page that is in
    a domain that is NOT the same as the originating domain of the
    running page, you must use this class, rather than
    HttpProxy.</b>
    <br/>
  </p>
  <p>The content passed back from a server resource requested by a
  ScriptTagProxy 
  <b>must</b> be executable JavaScript source code because it is
  used as the source inside a &lt;script&gt; tag.
  <br/>
</p>
  <p>In order for the browser to process the returned data, the
  server must wrap the data object with a call to a callback
  function, the name of which is passed as a parameter by the
  ScriptTagProxy. Below is a Java example for a servlet which
  returns data for either a ScriptTagProxy, or an HttpProxy
  depending on whether the callback name was passed:</p>
<pre>
<code>boolean scriptTag = false;
String cb = request.getParameter(
<em>"callback"</em>);
<b>if</b> (cb != null) {
    scriptTag = true;
    response.setContentType(
<em>"text/javascript"</em>);
} 
<b>else</b> {
    response.setContentType(
<em>"application/x-json"</em>);
}
Writer out = response.getWriter();
<b>if</b> (scriptTag) {
    out.write(cb + 
<em>"("</em>);
}
out.print(dataBlock.toJsonString());
<b>if</b> (scriptTag) {
    out.write(
<em>");"</em>);
}</code>
  </pre>
  <p>Below is a PHP example to do the same thing:</p>
<pre>
<code>$callback = $_REQUEST[
<em>'callback'</em>];

<i>// Create the output object.</i>
$output = array(
<em>'a'</em> =&gt; 
<em>'Apple'</em>, 
<em>'b'</em> =&gt; 
<em>'Banana'</em>);

<i>//start output</i>
<b>if</b> ($callback) {
    header(
<em>'Content-Type: text/javascript'</em>);
    echo $callback . 
<em>'('</em> . json_encode($output) . 
<em>');'</em>;
} 
<b>else</b> {
    header(
<em>'Content-Type: application/x-json'</em>);
    echo json_encode($output);
}</code>
  </pre>
  <p>Below is the ASP.Net code to do the same thing:</p>
<pre>
<code>String jsonString = 
<em>"{success: true}"</em>;
String cb = Request.Params.Get(
<em>"callback"</em>);
String responseString = 
<em>""</em>;
<b>if</b> (!String.IsNullOrEmpty(cb)) {
    responseString = cb + 
<em>"("</em> + jsonString + 
<em>")"</em>;
} 
<b>else</b> {
    responseString = jsonString;
}
Response.Write(responseString);</code>
  </pre>
</div>

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
			nocache
			,url
			,timeout
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The name of the parameter to pass to
          the server which tells the server the name of the
          callback function set up by the load call to process the
          returned data object. Defaults to "callback".
          <p>The server-side processing must read this parameter
          value, and generate javascript output which calls this
          named function passing the data object as its only
          parameter.</p>
</div>

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