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
    <p>Abstract base class for implementations which provide
    retrieval of unformatted data objects. This class is intended
    to be extended and should not be created directly. For existing
    implementations, see 
    <a ext:cls="Ext.data.DirectProxy" href="output/Ext.data.DirectProxy.html">Ext.data.DirectProxy</a>, 
    <a ext:cls="Ext.data.HttpProxy" href="output/Ext.data.HttpProxy.html">Ext.data.HttpProxy</a>, 
    <a ext:cls="Ext.data.ScriptTagProxy" href="output/Ext.data.ScriptTagProxy.html">Ext.data.ScriptTagProxy</a>
    and 
    <a ext:cls="Ext.data.MemoryProxy" href="output/Ext.data.MemoryProxy.html">Ext.data.MemoryProxy</a>.</p>
    <p>DataProxy implementations are usually used in conjunction
    with an implementation of 
    <a ext:cls="Ext.data.DataReader" href="output/Ext.data.DataReader.html">Ext.data.DataReader</a> (of the
    appropriate type which knows how to parse the data object) to
    provide a block of 
    <a ext:cls="Ext.data.Records" href="output/Ext.data.Records.html">Ext.data.Records</a> to an 
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>.</p>
    <p>The parameter to a DataProxy constructor may be an 
    <a ext:cls="Ext.data.Connection" href="output/Ext.data.Connection.html">Ext.data.Connection</a> or can
    also be the config object to an 
    <a ext:cls="Ext.data.Connection" href="output/Ext.data.Connection.html">Ext.data.Connection</a>.</p>
    <p>Custom implementations must implement either the 
    <code>
      <b>doRequest</b>
    </code> method (preferred) or the 
    <code>load</code> method (deprecated). See 
    <a ext:cls="Ext.data.HttpProxy" href="output/Ext.data.HttpProxy.html">Ext.data.HttpProxy</a>.
    <a ext:cls="Ext.data.HttpProxy" ext:member="doRequest" href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-doRequest">doRequest</a> or 
    <a ext:cls="Ext.data.HttpProxy" href="output/Ext.data.HttpProxy.html">Ext.data.HttpProxy</a>.
    <a ext:cls="Ext.data.HttpProxy" ext:member="load" href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-load">load</a> for
    additional details.</p>
    <p>
      <b>
        <u>Example 1</u>
      </b>
    </p>
<pre>
<code>proxy: 
<b>new</b> Ext.data.ScriptTagProxy({
    
<a ext:cls="Ext.data.Connection" ext:member="url" href="output/Ext.data.Connection.html#Ext.data.Connection-url">url</a>: 
<em>'http:
<i>//extjs.com/forum/topics-remote.php'</i>
</em>
}),</code>
    </pre>
    <p>
      <b>
        <u>Example 2</u>
      </b>
    </p>
<pre>
<code>proxy : 
<b>new</b> Ext.data.HttpProxy({
    
<a ext:cls="Ext.data.Connection" ext:member="method" href="output/Ext.data.Connection.html#Ext.data.Connection-method">method</a>: 
<em>'GET'</em>,
    
<a ext:cls="Ext.data.HttpProxy" ext:member="prettyUrls" href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-prettyUrls">prettyUrls</a>: false,
    
<a ext:cls="Ext.data.Connection" ext:member="url" href="output/Ext.data.Connection.html#Ext.data.Connection-url">url</a>: 
<em>'local/
<b>default</b>.php'</em>, 
<i>// see options parameter 
<b>for</b> 
<a ext:cls="Ext.Ajax" ext:member="request" href="output/Ext.Ajax.html#Ext.Ajax-request">Ext.Ajax.request</a>
</i>
    
<a ext:cls="Ext.data.DataProxy" ext:member="api" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-api">api</a>: {
        
<i>// all actions except the following will use above url</i>
        create  : 
<em>'local/
<b>new</b>.php'</em>,
        update  : 
<em>'local/update.php'</em>
    }
}),</code>
    </pre>
    <p>And 
    <b>new in Ext version 3</b>, attach centralized event-listeners
    upon the DataProxy class itself! This is a great place to
    implement a 
    <i>messaging system</i> to centralize your application's
    user-feedback and error-handling.</p>
<pre>
<code>
<i>// Listen to all 
<em>"beforewrite"</em> event fired by all proxies.</i>
Ext.data.DataProxy.on(
<em>'beforewrite'</em>, 
<b>function</b>(proxy, action) {
    console.log(
<em>'beforewrite: '</em>, action);
});

<i>// Listen to 
<em>"write"</em> event fired by all proxies</i>
Ext.data.DataProxy.on(
<em>'write'</em>, 
<b>function</b>(proxy, action, data, res, rs) {
    console.info(
<em>'write: '</em>, action);
});

<i>// Listen to 
<em>"exception"</em> event fired by all proxies</i>
Ext.data.DataProxy.on(
<em>'exception'</em>, 
<b>function</b>(proxy, type, action, exception) {
    console.error(type + action + 
<em>' exception);
});</em>
</code>
    </pre>
    <code>
    <b>Note:</b> These three events are all fired with the
    signature of the corresponding 
    <i>DataProxy instance</i> event 
    <a ext:cls="Ext.data.DataProxy" ext:member="beforewrite" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-beforewrite">beforewrite</a>, 
    <a ext:cls="Ext.data.DataProxy" ext:member="write" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-write">write</a> and 
    <a ext:cls="Ext.data.DataProxy" ext:member="exception" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-exception">exception</a>.</code>
  </div>

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
			doRequest
			,api
			,restful
			,onWrite
			,onRead
			,listeners
			,autoAbort
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Abstract method that should be
          implemented in all subclasses. 
          <b>Note:</b> Should only be used by custom-proxy
          developers. (e.g.: 
          <a ext:cls="Ext.data.HttpProxy" ext:member="doRequest" href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-doRequest">HttpProxy.doRequest</a>, 
          <a ext:cls="Ext.data.DirectProxy" ext:member="doRequest" href="output/Ext.data.DirectProxy.html#Ext.data.DirectProxy-doRequest">DirectProxy.doRequest</a>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Specific urls to call on CRUD action
          methods "read", "create", "update" and "destroy".
          Defaults to:
<pre>
<code>api: {
    read    : undefined,
    create  : undefined,
    update  : undefined,
    destroy : undefined
}</code>
          </pre>
          <p>The url is built based upon the action being executed 
          <tt>[load|create|save|destroy]</tt> using the
          commensurate 
          <tt>
            <a ext:cls="Ext.data.DataProxy" ext:member="api" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-api">api</a>
          </tt> property, or if undefined default to the configured
          
          <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>.
          <a ext:cls="Ext.data.Store" ext:member="url" href="output/Ext.data.Store.html#Ext.data.Store-url">url</a>.</p>
          <br/>
          <p>For example:</p>
<pre>
<code>api: {
    load :    
<em>'/controller/load'</em>,
    create :  
<em>'/controller/
<b>new</b>'</em>,  
<i>// Server MUST 
<b>return</b> idProperty of 
<b>new</b> record</i>
    save :    
<em>'/controller/update'</em>,
    destroy : 
<em>'/controller/destroy_action'</em>
}

<i>// Alternatively, one can use the object-form to specify each
API-action</i>
api: {
    load: {url: 
<em>'read.php'</em>, method: 
<em>'GET'</em>},
    create: 
<em>'create.php'</em>,
    destroy: 
<em>'destroy.php'</em>,
    save: 
<em>'update.php'</em>
}</code>
          </pre>
          <p>If the specific URL for a given CRUD action is
          undefined, the CRUD action request will be directed to
          the configured 
          <tt>
            <a ext:cls="Ext.data.Connection" ext:member="url" href="output/Ext.data.Connection.html#Ext.data.Connection-url">url</a>
          </tt>.</p>
          <br/>
          <p>
          <b>Note</b>: To modify the URL for an action dynamically
          the appropriate API property should be modified before
          the action is requested using the corresponding before
          action event. For example to modify the URL associated
          with the load action:</p>
<pre>
<code>
<i>// modify the url 
<b>for</b> the action</i>
myStore.on({
    beforeload: {
        fn: 
<b>function</b> (store, options) {
            
<i>// use 
<tt>
  <a ext:cls="Ext.data.HttpProxy" ext:member="setUrl" href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-setUrl">setUrl</a>
</tt> to change the URL 
<b>for</b> *just* this request.</i>
            store.proxy.setUrl(
<em>'changed1.php'</em>);

            
<i>// set optional second parameter to true to make this URL
change</i>
            
<i>// permanent, applying this URL 
<b>for</b> all subsequent requests.</i>
            store.proxy.setUrl(
<em>'changed1.php'</em>, true);

            
<i>// Altering the proxy API should be done using the public</i>
            
<i>// method 
<tt>
  <a ext:cls="Ext.data.DataProxy" ext:member="setApi" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-setApi">setApi</a>
</tt>.</i>
            store.proxy.setApi(
<em>'read'</em>, 
<em>'changed2.php'</em>);

            
<i>// Or set the entire API 
<b>with</b> a config-object.</i>
            
<i>// When using the config-object option, you must redefine the 
<b>entire</b>
</i>
            
<i>// API -- not just a specific action of it.</i>
            store.proxy.setApi({
                read    : 
<em>'changed_read.php'</em>,
                create  : 
<em>'changed_create.php'</em>,
                update  : 
<em>'changed_update.php'</em>,
                destroy : 
<em>'changed_destroy.php'</em>
            });
        }
    }
});</code>
          </pre>
          <br/>
          <br/>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>Defaults to 
          <tt>false</tt>. Set to 
          <tt>true</tt> to operate in a RESTful manner.</p>
          <br/>
          <p>Note: this parameter will automatically be set to 
          <tt>true</tt> if the 
          <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a> it is plugged
          into is set to 
          <code>restful: true</code>. If the Store is RESTful,
          there is no need to set this option on the proxy.</p>
          <br/>
          <p>RESTful implementations enable the serverside
          framework to automatically route actions sent to one url
          based upon the HTTP method, for example:</p>
<pre>
<code>store: 
<b>new</b> Ext.data.Store({
    restful: true,
    proxy: 
<b>new</b> Ext.data.HttpProxy({url:
<em>'/users'</em>}); 
<i>// all requests sent to /users</i>
    ...
)}</code>
          </pre>If there is no 
          <code>
            <a ext:cls="Ext.data.DataProxy" ext:member="api" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-api">api</a>
          </code> specified in the configuration of the proxy, all
          requests will be marshalled to a single RESTful url
          (/users) so the serverside framework can inspect the HTTP
          Method and act accordingly: 
<pre>
<u>Method</u>   
<u>url</u>        
<u>action</u>
POST     /users     create
GET      /users     read
PUT      /users/23  update
DESTROY  /users/23  delete
          </pre>
          <br/>
          <br/> 
          <p>If set to 
          <tt>true</tt>, a 
          <a ext:cls="Ext.data.Record" ext:member="phantom" href="output/Ext.data.Record.html#Ext.data.Record-phantom">non-phantom</a> record's 
          <a ext:cls="Ext.data.Record" ext:member="id" href="output/Ext.data.Record.html#Ext.data.Record-id">id</a> will be
          appended to the url. Some MVC (e.g., Ruby on Rails, Merb
          and Django) support segment based urls where the segments
          in the URL follow the Model-View-Controller approach:</p>
<pre>
<code>someSite.com/controller/action/id</code>
          </pre>Where the segments in the url are typically:
          <div class="mdetail-params">
            <ul>
              <li>The first segment : represents the controller
              class that should be invoked.</li>
              <li>The second segment : represents the class
              function, or method, that should be called.</li>
              <li>The third segment : represents the ID (a variable
              typically passed to the method).</li>
            </ul>
          </div>
          <br/>
          <br/>
          <br/>
          <p>Refer to 
          <code>
            <a ext:cls="Ext.data.DataProxy" ext:member="api" href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-api">Ext.data.DataProxy.api</a>
          </code> for additional information.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Abstract method that should be
          implemented in all subclasses. 
          <b>Note:</b> Should only be used by custom-proxy
          developers. Callback for 
          <i>create, update and destroy</i> 
          <a ext:cls="Ext.data.Api" ext:member="actions" href="output/Ext.data.Api.html#Ext.data.Api-actions">actions</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Abstract method that should be
          implemented in all subclasses. 
          <b>Note:</b> Should only be used by custom-proxy
          developers. Callback for read 
          <a ext:cls="Ext.data.Api" ext:member="actions" href="output/Ext.data.Api.html#Ext.data.Api-actions">action</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A config object containing one or more event
            handlers to be added to this object during
            initialization. This should be a valid listeners config
            object as specified in the 
            <a ext:cls="Ext.util.Observable" ext:member="addListener" href="output/Ext.util.Observable.html#Ext.util.Observable-addListener">addListener</a> example
            for attaching multiple handlers at once.</p>
            <br/>
            <p>
              <b>
                <u>DOM events from ExtJs 
                <a ext:cls="Ext.Component" href="output/Ext.Component.html">Components</a>
</u>
              </b>
            </p>
            <br/>
            <p>While 
            <i>some</i> ExtJs Component classes export selected DOM
            events (e.g. "click", "mouseover" etc), this is usually
            only done when extra value can be added. For example
            the 
            <a ext:cls="Ext.DataView" href="output/Ext.DataView.html">DataView</a>'s 
            <b>
              <code>
                <a ext:cls="Ext.DataView" ext:member="click" href="output/Ext.DataView.html#Ext.DataView-click">click</a>
              </code>
            </b> event passing the node clicked on. To access DOM
            events directly from a Component's HTMLElement,
            listeners must be added to the 
            <i>
              <a ext:cls="Ext.Component" ext:member="getEl" href="output/Ext.Component.html#Ext.Component-getEl">Element</a>
            </i> after the Component has been rendered. A plugin
            can simplify this step:</p>
<pre>
<code>
<i>// Plugin is configured 
<b>with</b> a listeners config object.</i>
<i>// The Component is appended to the argument list of all handler
functions.</i>
Ext.DomObserver = Ext.extend(Object, {
    constructor: 
<b>function</b>(config) {
        this.listeners = config.listeners ? config.listeners :
config;
    },

    
<i>// Component passes itself into plugin's init method</i>
    init: 
<b>function</b>(c) {
        
<b>var</b> p, l = this.listeners;
        
<b>for</b> (p 
<b>in</b> l) {
            
<b>if</b> (Ext.isFunction(l[p])) {
                l[p] = this.createHandler(l[p], c);
            } 
<b>else</b> {
                l[p].fn = this.createHandler(l[p].fn, c);
            }
        }

        
<i>// Add the listeners to the Element immediately following the
render call</i>
        c.render = c.render.
<a ext:cls="Function" ext:member="createSequence" href="output/Function.html#Function-createSequence">createSequence</a>(
<b>function</b>() {
            
<b>var</b> e = c.getEl();
            
<b>if</b> (e) {
                e.on(l);
            }
        });
    },

    createHandler: 
<b>function</b>(fn, c) {
        
<b>return</b> 
<b>function</b>(e) {
            fn.call(this, e, c);
        };
    }
});

<b>var</b> combo = 
<b>new</b> Ext.form.ComboBox({

    
<i>// Collapse combo when its element is clicked on</i>
    plugins: [ 
<b>new</b> Ext.DomObserver({
        click: 
<b>function</b>(evt, comp) {
            comp.collapse();
        }
    })],
    store: myStore,
    typeAhead: true,
    mode: 
<em>'local'</em>,
    triggerAction: 
<em>'all'</em>
});</code>
            </pre>
            <br/>
            <br/>
          </div>

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