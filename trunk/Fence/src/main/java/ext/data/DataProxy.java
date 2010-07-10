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
    Abstract base class for implementations which provide
    retrieval of unformatted data objects. This class is intended
    to be extended and should not be created directly. For existing
    implementations, see 
    Ext.data.DirectProxy, 
    Ext.data.HttpProxy, 
    Ext.data.ScriptTagProxy
    and 
    Ext.data.MemoryProxy.
    DataProxy implementations are usually used in conjunction
    with an implementation of 
    Ext.data.DataReader (of the
    appropriate type which knows how to parse the data object) to
    provide a block of 
    Ext.data.Records to an 
    Ext.data.Store.
    The parameter to a DataProxy constructor may be an 
    Ext.data.Connection or can
    also be the config object to an 
    Ext.data.Connection.
    Custom implementations must implement either the 
    
      doRequest
     method (preferred) or the 
    load method (deprecated). See 
    Ext.data.HttpProxy.
    doRequest or 
    Ext.data.HttpProxy.
    load for
    additional details.
    
      
        Example 1
      
    

proxy: 
new Ext.data.ScriptTagProxy({
    
url: 
'http:
//extjs.com/forum/topics-remote.php'

}),
    
    
      
        Example 2
      
    

proxy : 
new Ext.data.HttpProxy({
    
method: 
'GET',
    
prettyUrls: false,
    
url: 
'local/
default.php', 
// see options parameter 
for 
Ext.Ajax.request

    
api: {
        
// all actions except the following will use above url

        create  : 
'local/
new.php',
        update  : 
'local/update.php'
    }
}),
    
    And 
    new in Ext version 3, attach centralized event-listeners
    upon the DataProxy class itself! This is a great place to
    implement a 
    messaging system to centralize your application's
    user-feedback and error-handling.


// Listen to all 
"beforewrite" event fired by all proxies.

Ext.data.DataProxy.on(
'beforewrite', 
function(proxy, action) {
    console.log(
'beforewrite: ', action);
});

// Listen to 
"write" event fired by all proxies

Ext.data.DataProxy.on(
'write', 
function(proxy, action, data, res, rs) {
    console.info(
'write: ', action);
});

// Listen to 
"exception" event fired by all proxies

Ext.data.DataProxy.on(
'exception', 
function(proxy, type, action) {
    console.error(type + action + 
' exception);
});
    
    
    Note: These three events are all fired with the
    signature of the corresponding 
    DataProxy instance event 
    beforewrite, 
    write and 
    exception.
  
 */

@InstanceOf("Ext.data.DataProxy")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.DataProxy")
public class DataProxy extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.data.DataProxy";

	/**
	 * <p>
	 * Create a new {@link Ext.data.DataProxy} instance with default property values.
	 * </p>
	 */
	public DataProxy() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			restful
			,api
			,onWrite
			,onRead
			,doRequest
			,extraParams
			,timeout
			,disableCachingParam
			,autoAbort
			,disableCaching
			,url
			,listeners
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
	 *
          Defaults to 
          false. Set to 
          true to operate in a RESTful manner.
          
          Note: this parameter will automatically be set to 
          true if the 
          Ext.data.Store it is plugged
          into is set to 
          restful: true. If the Store is RESTful,
          there is no need to set this option on the proxy.
          
          RESTful implementations enable the serverside
          framework to automatically route actions sent to one url
          based upon the HTTP method, for example:

store: 
new Ext.data.Store({
    restful: true,
    proxy: 
new Ext.data.HttpProxy({url:
'/users'}); 
// all requests sent to /users

    ...
)}
          If there is no 
          
            api
           specified in the configuration of the proxy, all
          requests will be marshalled to a single RESTful url
          (/users) so the serverside framework can inspect the HTTP
          Method and act accordingly: 

Method   
url        
action
POST     /users     create
GET      /users     read
PUT      /users/23  update
DESTROY  /users/23  delete
          
          
           
          If set to 
          true, a 
          non-phantom record's 
          id will be
          appended to the url. Some MVC (e.g., Ruby on Rails, Merb
          and Django) support segment based urls where the segments
          in the URL follow the Model-View-Controller approach:

someSite.com/controller/action/id
          Where the segments in the url are typically:
          
            
              The first segment : represents the controller
              class that should be invoked.
              The second segment : represents the class
              function, or method, that should be called.
              The third segment : represents the ID (a variable
              typically passed to the method).
            
          
          
          
          
          Refer to 
          
            Ext.data.DataProxy.api
           for additional information.
	 */
	
	public Boolean getRestful () {
		return (Boolean) getStateHelper().eval(PropertyKeys.restful);
	}

	/**
	 * <p>
	 * Set the value of the <code>restful</code> property.
	 * </p>
	 */
	public void setRestful ( Boolean   restful ) {
		getStateHelper().put(PropertyKeys.restful, restful);
		handleAttribute("restful", restful);
	}
    	/*
	 *Specific urls to call on CRUD action
          methods "read", "create", "update" and "destroy".
          Defaults to:

api: {
    read    : undefined,
    create  : undefined,
    update  : undefined,
    destroy : undefined
}
          
          The url is built based upon the action being executed 
          [load|create|save|destroy] using the
          commensurate 
          
            api
           property, or if undefined default to the configured
          
          Ext.data.Store.
          url.
          
          For example:

api: {
    load :    
'/controller/load',
    create :  
'/controller/
new',  
// Server MUST 
return idProperty of 
new record

    save :    
'/controller/update',
    destroy : 
'/controller/destroy_action'
}

// Alternatively, one can use the object-form to specify each
API-action

api: {
    load: {url: 
'read.php', method: 
'GET'},
    create: 
'create.php',
    destroy: 
'destroy.php',
    save: 
'update.php'
}
          
          If the specific URL for a given CRUD action is
          undefined, the CRUD action request will be directed to
          the configured 
          
            url
          .
          
          
          Note: To modify the URL for an action dynamically
          the appropriate API property should be modified before
          the action is requested using the corresponding before
          action event. For example to modify the URL associated
          with the load action:


// modify the url 
for the action

myStore.on({
    beforeload: {
        fn: 
function (store, options) {
            
// use 

  setUrl
 to change the URL 
for *just* this request.

            store.proxy.setUrl(
'changed1.php');

            
// set optional second parameter to true to make this URL change

            
// permanent, applying this URL 
for all subsequent requests.

            store.proxy.setUrl(
'changed1.php', true);

            
// Altering the proxy API should be done using the public

            
// method 

  setApi
.

            store.proxy.setApi(
'read', 
'changed2.php');

            
// Or set the entire API 
with a config-object.

            
// When using the config-object option, you must redefine the 
entire

            
// API -- not just a specific action of it.

            store.proxy.setApi({
                read    : 
'changed_read.php',
                create  : 
'changed_create.php',
                update  : 
'changed_update.php',
                destroy : 
'changed_destroy.php'
            });
        }
    }
});
          
          
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getApi () {
		return (Object) getStateHelper().eval(PropertyKeys.api);
	}

	/**
	 * <p>
	 * Set the value of the <code>api</code> property.
	 * </p>
	 */
	public void setApi ( Object   api ) {
		getStateHelper().put(PropertyKeys.api, api);
		handleAttribute("api", api);
	}
    	/*
	 *Abstract method that should be
          implemented in all subclasses. 
          Note: Should only be used by custom-proxy
          developers. Callback for 
          create, update and destroy 
          actions.
	 */
	@ClientConfig(JsonMode.Function)

	public Object getOnWrite () {
		return (Object) getStateHelper().eval(PropertyKeys.onWrite);
	}

	/**
	 * <p>
	 * Set the value of the <code>onWrite</code> property.
	 * </p>
	 */
	public void setOnWrite ( Object   onWrite ) {
		getStateHelper().put(PropertyKeys.onWrite, onWrite);
		handleAttribute("onWrite", onWrite);
	}
    	/*
	 *Abstract method that should be
          implemented in all subclasses. 
          Note: Should only be used by custom-proxy
          developers. Callback for read 
          action.
	 */
	@ClientConfig(JsonMode.Function)

	public Object getOnRead () {
		return (Object) getStateHelper().eval(PropertyKeys.onRead);
	}

	/**
	 * <p>
	 * Set the value of the <code>onRead</code> property.
	 * </p>
	 */
	public void setOnRead ( Object   onRead ) {
		getStateHelper().put(PropertyKeys.onRead, onRead);
		handleAttribute("onRead", onRead);
	}
    	/*
	 *Abstract method that should be
          implemented in all subclasses. 
          Note: Should only be used by custom-proxy
          developers. (e.g.: 
          HttpProxy.doRequest, 
          DirectProxy.doRequest).
	 */
	@ClientConfig(JsonMode.Function)

	public Object getDoRequest () {
		return (Object) getStateHelper().eval(PropertyKeys.doRequest);
	}

	/**
	 * <p>
	 * Set the value of the <code>doRequest</code> property.
	 * </p>
	 */
	public void setDoRequest ( Object   doRequest ) {
		getStateHelper().put(PropertyKeys.doRequest, doRequest);
		handleAttribute("doRequest", doRequest);
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
            A config object containing one or more event
            handlers to be added to this object during
            initialization. This should be a valid listeners config
            object as specified in the 
            addListener example
            for attaching multiple handlers at once.
            
            
              
                DOM events from ExtJs 
                Components
              
            
            
            While 
            some ExtJs Component classes export selected DOM
            events (e.g. "click", "mouseover" etc), this is usually
            only done when extra value can be added. For example
            the 
            DataView's 
            
              
                click
              
             event passing the node clicked on. To access DOM
            events directly from a Component's HTMLElement,
            listeners must be added to the 
            
              Element
             after the Component has been rendered. A plugin
            can simplify this step:


// Plugin is configured 
with a listeners config object.
// The Component is appended to the argument list of all handler
functions.
Ext.DomObserver = Ext.extend(Object, {
    constructor: 
function(config) {
        this.listeners = config.listeners ? config.listeners :
config;
    },

    
// Component passes itself into plugin's init method
    init: 
function(c) {
        
var p, l = this.listeners;
        
for (p 
in l) {
            
if (Ext.isFunction(l[p])) {
                l[p] = this.createHandler(l[p], c);
            } 
else {
                l[p].fn = this.createHandler(l[p].fn, c);
            }
        }

        
// Add the listeners to the Element immediately following the
render call
        c.render = c.render.
createSequence(
function() {
            
var e = c.getEl();
            
if (e) {
                e.on(l);
            }
        });
    },

    createHandler: 
function(fn, c) {
        
return 
function(e) {
            fn.call(this, e, c);
        };
    }
});

var combo = 
new Ext.form.ComboBox({

    
// Collapse combo when its element is clicked on
    plugins: [ 
new Ext.DomObserver({
        click: 
function(evt, comp) {
            comp.collapse();
        }
    })],
    store: myStore,
    typeAhead: true,
    mode: 
'local',
    triggerAction: 
'all'
});
            
            
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getListeners () {
		return (Object) getStateHelper().eval(PropertyKeys.listeners);
	}

	/**
	 * <p>
	 * Set the value of the <code>listeners</code> property.
	 * </p>
	 */
	public void setListeners ( Object   listeners ) {
		getStateHelper().put(PropertyKeys.listeners, listeners);
		handleAttribute("listeners", listeners);
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
					 "beforeload"
					, "beforewrite"
					, "exception"
					, "load"
					, "loadexception"
					, "write"
				));
				return superEvent;
	}
}