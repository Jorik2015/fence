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
<div class="description">
  <p>The class encapsulates a connection to the page's originating
  domain, allowing requests to be made either to a configured URL,
  or to a URL specified at request time.</p>
  <p>Requests made by this class are asynchronous, and will return
  immediately. No data from the server will be available to the
  statement immediately following the 
  <a ext:cls="Ext.data.Connection" ext:member="request" href="output/Ext.data.Connection.html#Ext.data.Connection-request">request</a>
  call. To process returned data, use a 
  <a ext:cls="Ext.data.Connection" ext:member="request-option-success" href="#request-option-success">success callback</a> in the request
  options object, or an 
  <a ext:cls="Ext.data.Connection" ext:member="requestcomplete" href="output/Ext.data.Connection.html#Ext.data.Connection-requestcomplete">event
  listener</a>.</p>
  <h3>File Uploads</h3>
  <a ext:cls="Ext.data.Connection" ext:member="request-option-isUpload" href="#request-option-isUpload">File uploads</a> are not performed
  using normal "Ajax" techniques, that is they are 
  <b>not</b> performed using XMLHttpRequests. Instead the form is
  submitted in the standard manner with the DOM 
  <tt>&lt;form&gt;</tt> element temporarily modified to have its 
  <a href="http://www.w3.org/TR/REC-html40/present/frames.html#adef-target">target</a>
  set to refer to a dynamically generated, hidden 
  <tt>&lt;iframe&gt;</tt> which is inserted into the document but
  removed after the return data has been gathered.
  <br/>
  <br/> 
  <p>The server response is parsed by the browser to create the
  document for the IFRAME. If the server is using JSON to send the
  return object, then the 
  <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17">Content-Type</a>
  header must be set to "text/html" in order to tell the browser to
  insert the text unchanged into the document body.</p>
  <p>Characters which are significant to an HTML parser must be
  sent as HTML entities, so encode "&lt;" as "&amp;lt;", "&amp;" as
  "&amp;amp;" etc.</p>
  <p>The response text is retrieved from the document, and a fake
  XMLHttpRequest object is created containing a 
  <tt>responseText</tt> property in order to conform to the
  requirements of event handlers and callbacks.</p>
  <p>Be aware that file upload packets are sent with the content
  type 
  <a href="http://www.faqs.org/rfcs/rfc2388.html">multipart/form</a>
  and some server technologies (notably JEE) may require some
  custom processing in order to retrieve parameter names and
  parameter values from the packet content.</p>
  <p>Also note that it's not possible to check the response code of
  the hidden iframe, so the success handler will ALWAYS
  fire.</p>
</div>

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
			autoAbort
			,disableCaching
			,method
			,defaultHeaders
			,disableCachingParam
			,url
			,timeout
			,extraParams
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The default HTTP method to be used for
          requests. (defaults to undefined; if not set, but 
          <a ext:cls="Ext.data.Connection" ext:member="request" href="output/Ext.data.Connection.html#Ext.data.Connection-request">request</a> params are
          present, POST will be used; otherwise, GET will be
          used.)</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The default URL to be used for requests to the
            server. Defaults to undefined.</p>
            <p>The 
            <code>url</code> config may be a function which 
            <i>returns</i> the URL to use for the Ajax request. The
            scope (
            <code>
              <b>this</b>
            </code> reference) of the function is the 
            <code>scope</code> option passed to the 
            <a ext:cls="Ext.data.Connection" ext:member="request" href="output/Ext.data.Connection.html#Ext.data.Connection-request">request</a> method.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An object containing properties which
          are used as extra parameters to each request made by this
          object. (defaults to undefined)</div>

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