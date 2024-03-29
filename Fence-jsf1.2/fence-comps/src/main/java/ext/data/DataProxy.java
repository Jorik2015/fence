package ext.data;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * Abstract base class for implementations which provide retrieval of
 * unformatted data objects. This class is intended to be extended and should
 * not be created directly. For existing implementations, see <a
 * href="output/Ext.data.DirectProxy.html"
 * ext:cls="Ext.data.DirectProxy">Ext.data.DirectProxy</a>, <a
 * href="output/Ext.data.HttpProxy.html"
 * ext:cls="Ext.data.HttpProxy">Ext.data.HttpProxy</a>, <a
 * href="output/Ext.data.ScriptTagProxy.html"
 * ext:cls="Ext.data.ScriptTagProxy">Ext.data.ScriptTagProxy</a> and <a
 * href="output/Ext.data.MemoryProxy.html"
 * ext:cls="Ext.data.MemoryProxy">Ext.data.MemoryProxy</a>.
 * </p>
 * 
 * <p>
 * DataProxy implementations are usually used in conjunction with an
 * implementation of <a href="output/Ext.data.DataReader.html"
 * ext:cls="Ext.data.DataReader">Ext.data.DataReader</a> (of the appropriate
 * type which knows how to parse the data object) to provide a block of <a
 * href="output/Ext.data.Records.html"
 * ext:cls="Ext.data.Records">Ext.data.Records</a> to an <a
 * href="output/Ext.data.Store.html"
 * ext:cls="Ext.data.Store">Ext.data.Store</a>.
 * </p>
 * 
 * <p>
 * The parameter to a DataProxy constructor may be an <a
 * href="output/Ext.data.Connection.html"
 * ext:cls="Ext.data.Connection">Ext.data.Connection</a> or can also be the
 * config object to an <a href="output/Ext.data.Connection.html"
 * ext:cls="Ext.data.Connection">Ext.data.Connection</a>.
 * </p>
 * 
 * <p>
 * Custom implementations must implement either the
 * <code><b>doRequest</b></code> method (preferred) or the <code>load</code>
 * method (deprecated). See <a href="output/Ext.data.HttpProxy.html"
 * ext:cls="Ext.data.HttpProxy">Ext.data.HttpProxy</a>.<a
 * href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-doRequest"
 * ext:member="doRequest" ext:cls="Ext.data.HttpProxy">doRequest</a> or <a
 * href="output/Ext.data.HttpProxy.html"
 * ext:cls="Ext.data.HttpProxy">Ext.data.HttpProxy</a>.<a
 * href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-load"
 * ext:member="load" ext:cls="Ext.data.HttpProxy">load</a> for additional
 * details.
 * </p>
 * 
 * <p>
 * <b><u>Example 1</u></b>
 * </p>
 * 
 * <pre>
 * &lt;code&gt;proxy: &lt;b&gt;new&lt;/b&gt; Ext.data.ScriptTagProxy({
 *     &lt;a href=&quot;output/Ext.data.Connection.html#Ext.data.Connection-url&quot; ext:member=&quot;url&quot; ext:cls=&quot;Ext.data.Connection&quot;&gt;url&lt;/a&gt;: &lt;em&gt;'http:&lt;i&gt;//extjs.com/forum/topics-remote.php'&lt;/i&gt;
 * &lt;/em&gt;
 * }),&lt;/code&gt;
 * </pre>
 * 
 * <p>
 * <b><u>Example 2</u></b>
 * </p>
 * 
 * <pre>
 * &lt;code&gt;proxy : &lt;b&gt;new&lt;/b&gt; Ext.data.HttpProxy({
 *     &lt;a href=&quot;output/Ext.data.Connection.html#Ext.data.Connection-method&quot; ext:member=&quot;method&quot; ext:cls=&quot;Ext.data.Connection&quot;&gt;method&lt;/a&gt;: &lt;em&gt;'GET'&lt;/em&gt;,
 *     &lt;a href=&quot;output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-prettyUrls&quot; ext:member=&quot;prettyUrls&quot; ext:cls=&quot;Ext.data.HttpProxy&quot;&gt;prettyUrls&lt;/a&gt;: false,
 *     &lt;a href=&quot;output/Ext.data.Connection.html#Ext.data.Connection-url&quot; ext:member=&quot;url&quot; ext:cls=&quot;Ext.data.Connection&quot;&gt;url&lt;/a&gt;: &lt;em&gt;'local/&lt;b&gt;default&lt;/b&gt;.php'&lt;/em&gt;, &lt;i&gt;// see options parameter &lt;b&gt;for&lt;/b&gt; &lt;a href=&quot;output/Ext.Ajax.html#Ext.Ajax-request&quot; ext:member=&quot;request&quot; ext:cls=&quot;Ext.Ajax&quot;&gt;Ext.Ajax.request&lt;/a&gt;
 * &lt;/i&gt;
 *     &lt;a href=&quot;output/Ext.data.DataProxy.html#Ext.data.DataProxy-api&quot; ext:member=&quot;api&quot; ext:cls=&quot;Ext.data.DataProxy&quot;&gt;api&lt;/a&gt;: {
 *         &lt;i&gt;// all actions except the following will use above url
 * &lt;/i&gt;
 *         create  : &lt;em&gt;'local/&lt;b&gt;new&lt;/b&gt;.php'&lt;/em&gt;,
 *         update  : &lt;em&gt;'local/update.php'&lt;/em&gt;
 *     }
 * }),&lt;/code&gt;
 * </pre>
 */
@InstanceOf("Ext.data.DataProxy")
public abstract class DataProxy extends Connection {
	public static final String COMPONENT_TYPE = "Ext.data.DataProxy";
	public static final String COMPONENT_FAMILY = "Ext.data.DataProxy";

	/**
	 * <p>
	 * Create a new {@link DataProxy} instance with default property values.
	 * </p>
	 */
	public DataProxy() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Object api;

	/**
	 * Specific urls to call on CRUD action methods"read", "create", "update"
	 * and "destroy". Defaults to:
	 * 
	 * <pre>
	 * &lt;code&gt;api: {
	 *     read    : undefined,
	 *     create  : undefined,
	 *     update  : undefined,
	 *     destroy : undefined
	 * }&lt;/code&gt;
	 * </pre>
	 * 
	 * <p>
	 * If the specific URL for a given CRUD action is undefined, the CRUD action
	 * request will be directed to the configured
	 * <tt><a href="output/Ext.data.Connection.html#Ext.data.Connection-url" ext:member="url" ext:cls="Ext.data.Connection">url</a></tt>
	 * .
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * <b>Note</b>: To modify the URL for an action dynamically the appropriate
	 * API property should be modified before the action is requested using the
	 * corresponding before action event. For example to modify the URL
	 * associated with the load action:
	 * </p>
	 * 
	 * <pre>
	 * &lt;code&gt;&lt;i&gt;// modify the url &lt;b&gt;for&lt;/b&gt; the action
	 * &lt;/i&gt;
	 * myStore.on({
	 *     beforeload: {
	 *         fn: &lt;b&gt;function&lt;/b&gt; (store, options) {
	 *             &lt;i&gt;// use &lt;tt&gt;&lt;a href=&quot;output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-setUrl&quot; ext:member=&quot;setUrl&quot; ext:cls=&quot;Ext.data.HttpProxy&quot;&gt;setUrl&lt;/a&gt;&lt;/tt&gt; to change the URL &lt;b&gt;for&lt;/b&gt; *just* this request.
	 * &lt;/i&gt;
	 *             store.proxy.setUrl(&lt;em&gt;'changed1.php'&lt;/em&gt;);
	 * 
	 *             &lt;i&gt;// set optional second parameter to true to make this URL change
	 * &lt;/i&gt;
	 *             &lt;i&gt;// permanent, applying this URL &lt;b&gt;for&lt;/b&gt; all subsequent requests.
	 * &lt;/i&gt;
	 *             store.proxy.setUrl(&lt;em&gt;'changed1.php'&lt;/em&gt;, true);
	 * 
	 *             &lt;i&gt;// manually set the &lt;b&gt;private&lt;/b&gt; connection URL.
	 * &lt;/i&gt;
	 *             &lt;i&gt;// &lt;b&gt;Warning:&lt;/b&gt;  Accessing the private URL property should be avoided.
	 * &lt;/i&gt;
	 *             &lt;i&gt;// Use the public method &lt;tt&gt;&lt;a href=&quot;output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-setUrl&quot; ext:member=&quot;setUrl&quot; ext:cls=&quot;Ext.data.HttpProxy&quot;&gt;setUrl&lt;/a&gt;&lt;/tt&gt; instead, shown above.
	 * &lt;/i&gt;
	 *             &lt;i&gt;// It should be noted that changing the URL like this will affect
	 * &lt;/i&gt;
	 *             &lt;i&gt;// the URL &lt;b&gt;for&lt;/b&gt; just this request.  Subsequent requests will use the
	 * &lt;/i&gt;
	 *             &lt;i&gt;// API or URL defined &lt;b&gt;in&lt;/b&gt; your initial proxy configuration.
	 * &lt;/i&gt;
	 *             store.proxy.conn.url = &lt;em&gt;'changed1.php'&lt;/em&gt;;
	 * 
	 *             &lt;i&gt;// proxy URL will be superseded by API (only &lt;b&gt;if&lt;/b&gt; proxy created to use ajax):
	 * &lt;/i&gt;
	 *             &lt;i&gt;// It should be noted that proxy API changes are permanent and will
	 * &lt;/i&gt;
	 *             &lt;i&gt;// be used &lt;b&gt;for&lt;/b&gt; all subsequent requests.
	 * &lt;/i&gt;
	 *             store.proxy.api.load = &lt;em&gt;'changed2.php'&lt;/em&gt;;
	 * 
	 *             &lt;i&gt;// However, altering the proxy API should be done using the public
	 * &lt;/i&gt;
	 *             &lt;i&gt;// method &lt;tt&gt;&lt;a href=&quot;output/Ext.data.DataProxy.html#Ext.data.DataProxy-setApi&quot; ext:member=&quot;setApi&quot; ext:cls=&quot;Ext.data.DataProxy&quot;&gt;setApi&lt;/a&gt;&lt;/tt&gt; instead.
	 * &lt;/i&gt;
	 *             store.proxy.setApi(&lt;em&gt;'load'&lt;/em&gt;, &lt;em&gt;'changed2.php'&lt;/em&gt;);
	 * 
	 *             &lt;i&gt;// Or set the entire API &lt;b&gt;with&lt;/b&gt; a config-object.
	 * &lt;/i&gt;
	 *             &lt;i&gt;// When using the config-object option, you must redefine the &lt;b&gt;entire&lt;/b&gt;
	 * &lt;/i&gt;
	 *             &lt;i&gt;// API -- not just a specific action of it.
	 * &lt;/i&gt;
	 *             store.proxy.setApi({
	 *                 read    : &lt;em&gt;'changed_read.php'&lt;/em&gt;,
	 *                 create  : &lt;em&gt;'changed_create.php'&lt;/em&gt;,
	 *                 update  : &lt;em&gt;'changed_update.php'&lt;/em&gt;,
	 *                 destroy : &lt;em&gt;'changed_destroy.php'&lt;/em&gt;
	 *             });
	 *         }
	 *     }
	 * });&lt;/code&gt;
	 * </pre>
	 * 
	 * <br>
	 * <br>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getApi() {
		if (null != this.api) {
			return this.api;
		}
		ValueExpression _ve = getValueExpression("api");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>api</code> property.
	 * </p>
	 */
	public void setApi(Object api) {
		this.api = api;
		this.handleConfig("api", api);
	}

	private Object doRequest;

	/**
	 * Abstract method that should be implemented inall subclasses (e.g.: <a
	 * href="output/Ext.data.HttpProxy.html#Ext.data.HttpProxy-doRequest"
	 * ext:member="doRequest"
	 * ext:cls="Ext.data.HttpProxy">HttpProxy.doRequest</a>, <a
	 * href="output/Ext.data.DirectProxy.html#Ext.data.DirectProxy-doRequest"
	 * ext:member="doRequest"
	 * ext:cls="Ext.data.DirectProxy">DirectProxy.doRequest</a>).
	 */
	@ClientConfig(JsonMode.Function)
	public Object getDoRequest() {
		if (null != this.doRequest) {
			return this.doRequest;
		}
		ValueExpression _ve = getValueExpression("doRequest");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>doRequest</code> property.
	 * </p>
	 */
	public void setDoRequest(Object doRequest) {
		this.doRequest = doRequest;
		this.handleConfig("doRequest", doRequest);
	}

	private Boolean restful;

	/**
	 * <p>
	 * Defaults to <tt>false</tt>. Set to <tt>true</tt> to operate in a RESTful
	 * manner.
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * Note: this parameter will automatically be set to <tt>true</tt> if the <a
	 * href="output/Ext.data.Store.html"
	 * ext:cls="Ext.data.Store">Ext.data.Store</a> it is plugged into is set to
	 * <code>restful: true</code>. If the Store is RESTful, there is no need to
	 * set this option on the proxy.
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * RESTful implementations enable the serverside framework to automatically
	 * route actions sent to one url based upon the HTTP method, for example:
	 * </p>
	 * 
	 * <pre>
	 * &lt;code&gt;store: &lt;b&gt;new&lt;/b&gt; Ext.data.Store({
	 *     restful: true,
	 *     proxy: &lt;b&gt;new&lt;/b&gt; Ext.data.HttpProxy({url:&lt;em&gt;'/users'&lt;/em&gt;}); &lt;i&gt;// all requests sent to /users
	 * &lt;/i&gt;
	 *     ...
	 * )}&lt;/code&gt;
	 * </pre>
	 * 
	 * There is no
	 * <code><a href="output/Ext.data.DataProxy.html#Ext.data.DataProxy-api" ext:member="api" ext:cls="Ext.data.DataProxy">api</a></code>
	 * specified in the configuration of the proxy, all requests will be
	 * marshalled to a single RESTful url (/users) so the serverside framework
	 * can inspect the HTTP Method and act accordingly:
	 * 
	 * <pre>
	 * &lt;u&gt;Method&lt;/u&gt;   &lt;u&gt;url&lt;/u&gt;        &lt;u&gt;action&lt;/u&gt;
	 * POST     /users     create
	 * GET      /users     read
	 * PUT      /users/23  update
	 * DESTROY  /users/23  delete
	 * </pre>
	 * 
	 * <br>
	 * <br>
	 */
	public Boolean getRestful() {
		if (null != this.restful) {
			return this.restful;
		}
		ValueExpression _ve = getValueExpression("restful");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>restful</code> property.
	 * </p>
	 */
	public void setRestful(Boolean restful) {
		this.restful = restful;
		this.handleConfig("restful", restful);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = api;
		_values[2] = doRequest;
		_values[3] = restful;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.api = (Object) _values[1];
		this.handleConfig("api", this.api);
		this.doRequest = (Object) _values[2];
		this.handleConfig("doRequest", this.doRequest);
		this.restful = (Boolean) _values[3];
		this.handleConfig("restful", this.restful);

	}
}