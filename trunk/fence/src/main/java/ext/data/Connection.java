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
 * 
  The class encapsulates a connection to the page's originating
  domain, allowing requests to be made either to a configured URL,
  or to a URL specified at request time.
  Requests made by this class are asynchronous, and will return
  immediately. No data from the server will be available to the
  statement immediately following the 
  request
  call. To process returned data, use a 
  success callback in the request
  options object, or an 
  event
  listener.
  File Uploads
  File uploads are not performed
  using normal "Ajax" techniques, that is they are 
  not performed using XMLHttpRequests. Instead the form is
  submitted in the standard manner with the DOM 
  <form> element temporarily modified to have its 
  target
  set to refer to a dynamically generated, hidden 
  <iframe> which is inserted into the document but
  removed after the return data has been gathered.
  
   
  The server response is parsed by the browser to create the
  document for the IFRAME. If the server is using JSON to send the
  return object, then the 
  Content-Type
  header must be set to "text/html" in order to tell the browser to
  insert the text unchanged into the document body.
  Characters which are significant to an HTML parser must be
  sent as HTML entities, so encode "<" as "&lt;", "&" as
  "&amp;" etc.
  The response text is retrieved from the document, and a fake
  XMLHttpRequest object is created containing a 
  responseText property in order to conform to the
  requirements of event handlers and callbacks.
  Be aware that file upload packets are sent with the content
  type 
  multipart/form
  and some server technologies (notably JEE) may require some
  custom processing in order to retrieve parameter names and
  parameter values from the packet content.
 */

@InstanceOf("Ext.data.Connection")

@FacesComponent(value = "Ext.data.Connection")
public class Connection extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.data.Connection";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Connection} instance with default property values.
	 * </p>
	 */
	public Connection() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			extraParams
			,timeout
			,disableCachingParam
			,autoAbort
			,disableCaching
			,url
			,defaultHeaders
			,method
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
	 *An object containing properties which
          are used as extra parameters to each request made by this
          object. (defaults to undefined)
	 */
	@ClientConfig(JsonMode.Object)

	public Object getExtraParams () {
		return (Object) getStateHelper().eval(PropertyKeys.extraParams);
	}

	/**
	 * <p>
	 * Set the value of the <code>extraParams</code> property.
	 * </p>
	 */
	public void setExtraParams ( Object   extraParams ) {
		getStateHelper().put(PropertyKeys.extraParams, extraParams);
		handleAttribute("extraParams", extraParams);
	}
    	/*
	 *
        
        
          timeout
         : Number
        The timeout in milliseconds to be used
        for requests. (defaults to 30000)
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
        
        
          disableCachingParam
         : String
        Change the parameter which is sent went
        disabling caching through a cache buster. Defaults to
        '_dc'
	 */
	
	public String getDisableCachingParam () {
		return (String) getStateHelper().eval(PropertyKeys.disableCachingParam);
	}

	/**
	 * <p>
	 * Set the value of the <code>disableCachingParam</code> property.
	 * </p>
	 */
	public void setDisableCachingParam ( String   disableCachingParam ) {
		getStateHelper().put(PropertyKeys.disableCachingParam, disableCachingParam);
		handleAttribute("disableCachingParam", disableCachingParam);
	}
    	/*
	 *
        
        
          autoAbort
         : Boolean
        Whether this request should abort any
        pending requests. (defaults to false)
	 */
	
	public Boolean getAutoAbort () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoAbort);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoAbort</code> property.
	 * </p>
	 */
	public void setAutoAbort ( Boolean   autoAbort ) {
		getStateHelper().put(PropertyKeys.autoAbort, autoAbort);
		handleAttribute("autoAbort", autoAbort);
	}
    	/*
	 *
        
        
          disableCaching
         : Boolean
        True to add a unique cache-buster param
        to GET requests. (defaults to true)
	 */
	
	public Boolean getDisableCaching () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disableCaching);
	}

	/**
	 * <p>
	 * Set the value of the <code>disableCaching</code> property.
	 * </p>
	 */
	public void setDisableCaching ( Boolean   disableCaching ) {
		getStateHelper().put(PropertyKeys.disableCaching, disableCaching);
		handleAttribute("disableCaching", disableCaching);
	}
    	/*
	 *
            The default URL to be used for requests to the
            server. Defaults to undefined.
            The 
            url config may be a function which 
            returns the URL to use for the Ajax request. The
            scope (
            
              this
             reference) of the function is the 
            scope option passed to the 
            request method.
          
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
        
        
          defaultHeaders
         : Object
        An object containing request headers
        which are added to each request made by this object.
        (defaults to undefined)
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaultHeaders () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultHeaders);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultHeaders</code> property.
	 * </p>
	 */
	public void setDefaultHeaders ( Object   defaultHeaders ) {
		getStateHelper().put(PropertyKeys.defaultHeaders, defaultHeaders);
		handleAttribute("defaultHeaders", defaultHeaders);
	}
    	/*
	 *The default HTTP method to be used for
          requests. (defaults to undefined; if not set, but 
          request params are
          present, POST will be used; otherwise, GET will be
          used.)
	 */
	
	public String getMethod () {
		return (String) getStateHelper().eval(PropertyKeys.method);
	}

	/**
	 * <p>
	 * Set the value of the <code>method</code> property.
	 * </p>
	 */
	public void setMethod ( String   method ) {
		getStateHelper().put(PropertyKeys.method, method);
		handleAttribute("method", method);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforerequest"
					, "requestcomplete"
					, "requestexception"
				));
				return superEvent;
	}
}