package ext.form;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.JsonMode;
import ext.base.ExtOutput;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * The subclasses of this class provide actions to perform upon <a
 * href="output/Ext.form.BasicForm.html" ext:cls="Ext.form.BasicForm">Form</a>s.
 * </p>
 * 
 * <p>
 * Instances of this class are only created by a <a
 * href="output/Ext.form.BasicForm.html" ext:cls="Ext.form.BasicForm">Form</a>
 * when the Form needs to perform an action such as submit or load. The
 * Configuration options listed for this class are set through the Form's action
 * methods: <a href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit"
 * ext:member="submit" ext:cls="Ext.form.BasicForm">submit</a>, <a
 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-load"
 * ext:member="load" ext:cls="Ext.form.BasicForm">load</a> and <a
 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-doAction"
 * ext:member="doAction" ext:cls="Ext.form.BasicForm">doAction</a>
 * </p>
 * 
 * <p>
 * The instance of Action which performed the action is passed to the success
 * and failure callbacks of the Form's action methods (<a
 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit"
 * ext:member="submit" ext:cls="Ext.form.BasicForm">submit</a>, <a
 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-load"
 * ext:member="load" ext:cls="Ext.form.BasicForm">load</a> and <a
 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-doAction"
 * ext:member="doAction" ext:cls="Ext.form.BasicForm">doAction</a>), and to the
 * <a href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-actioncomplete"
 * ext:member="actioncomplete" ext:cls="Ext.form.BasicForm">actioncomplete</a>
 * and <a href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-actionfailed"
 * ext:member="actionfailed" ext:cls="Ext.form.BasicForm">actionfailed</a> event
 * handlers.
 * </p>
 */
public class Action extends ExtOutput {
	public static final String COMPONENT_TYPE = "Ext.form.Action";

	/**
	 * <p>
	 * Create a new {@link Action} instance with default property values.
	 * </p>
	 */
	public Action() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Object failure;

	/**
	 * The function to call when a failure packet wasrecieved, or when an error
	 * ocurred in the Ajax communication. The function is passed the following
	 * parameters:
	 * 
	 * <ul class="mdetail-params">
	 * <li><b>form</b> : Ext.form.BasicForm
	 * 
	 * <div class="sub-desc">The form that requested the action</div></li>
	 * 
	 * <li><b>action</b> : Ext.form.Action
	 * 
	 * <div class="sub-desc">The Action class. If an Ajax error ocurred, the
	 * failure type will be in <a
	 * href="output/Ext.form.Action.html#Ext.form.Action-failureType"
	 * ext:member="failureType" ext:cls="Ext.form.Action">failureType</a>. The
	 * <a href="output/Ext.form.Action.html#Ext.form.Action-result"
	 * ext:member="result" ext:cls="Ext.form.Action">result</a> property of this
	 * object may be examined to perform custom postprocessing.</div></li>
	 * </ul>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getFailure() {
		if (null != this.failure) {
			return this.failure;
		}
		ValueExpression _ve = getValueExpression("failure");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>failure</code> property.
	 * </p>
	 */
	public void setFailure(Object failure) {
		this.failure = failure;
		handleConfig("failure", failure);
	}

	private String method;

	/**
	 * The HTTP method to use to access the requestedURL. Defaults to the <a
	 * href="output/Ext.form.BasicForm.html"
	 * ext:cls="Ext.form.BasicForm">Ext.form.BasicForm</a>'s method, or if that
	 * is not specified, the underlying DOM form's method.
	 */
	public String getMethod() {
		if (null != this.method) {
			return this.method;
		}
		ValueExpression _ve = getValueExpression("method");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>method</code> property.
	 * </p>
	 */
	public void setMethod(String method) {
		this.method = method;
		handleConfig("method", method);
	}

	private Object params;

	/**
	 * <p>
	 * Extra parameter values to pass. These are added to the Form's <a
	 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-baseParams"
	 * ext:member="baseParams"
	 * ext:cls="Ext.form.BasicForm">Ext.form.BasicForm.baseParams</a> and passed
	 * to the specified URL along with the Form's input fields.
	 * </p>
	 * 
	 * <p>
	 * Parameters are encoded as standard HTTP parameters using <a
	 * href="output/Ext.html#Ext-urlEncode" ext:member="urlEncode"
	 * ext:cls="Ext">Ext.urlEncode</a>.
	 * </p>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getParams() {
		if (null != this.params) {
			return this.params;
		}
		ValueExpression _ve = getValueExpression("params");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>params</code> property.
	 * </p>
	 */
	public void setParams(Object params) {
		this.params = params;
		handleConfig("params", params);
	}

	private Boolean reset;

	/**
	 * When set to <tt><b>true</b></tt>, causes the Formto be <a
	 * href="output/Ext.form.BasicForm.reset.html"
	 * ext:cls="Ext.form.BasicForm.reset">reset</a> on Action success. If
	 * specified, this happens <b>before</b> the <a
	 * href="output/Ext.form.Action.html#Ext.form.Action-success"
	 * ext:member="success" ext:cls="Ext.form.Action">success</a> callback is
	 * called and before the Form's <a
	 * href="output/Ext.form.BasicForm.actioncomplete.html"
	 * ext:cls="Ext.form.BasicForm.actioncomplete">actioncomplete</a> event
	 * fires.
	 */
	public Boolean getReset() {
		if (null != this.reset) {
			return this.reset;
		}
		ValueExpression _ve = getValueExpression("reset");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>reset</code> property.
	 * </p>
	 */
	public void setReset(Boolean reset) {
		this.reset = reset;
		handleConfig("reset", reset);
	}

	private Object scope;

	/**
	 * The scope in which to call the callbackfunctions (The <tt>this</tt>
	 * reference for the callback functions).
	 */
	@ClientConfig(JsonMode.Object)
	public Object getScope() {
		if (null != this.scope) {
			return this.scope;
		}
		ValueExpression _ve = getValueExpression("scope");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope(Object scope) {
		this.scope = scope;
		handleConfig("scope", scope);
	}

	private Object success;

	/**
	 * The function to call when a valid success returnpacket is recieved. The
	 * function is passed the following parameters:
	 * 
	 * <ul class="mdetail-params">
	 * <li><b>form</b> : Ext.form.BasicForm
	 * 
	 * <div class="sub-desc">The form that requested the action</div></li>
	 * 
	 * <li><b>action</b> : Ext.form.Action
	 * 
	 * <div class="sub-desc">The Action class. The <a
	 * href="output/Ext.form.Action.html#Ext.form.Action-result"
	 * ext:member="result" ext:cls="Ext.form.Action">result</a> property of this
	 * object may be examined to perform custom postprocessing.</div></li>
	 * </ul>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getSuccess() {
		if (null != this.success) {
			return this.success;
		}
		ValueExpression _ve = getValueExpression("success");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>success</code> property.
	 * </p>
	 */
	public void setSuccess(Object success) {
		this.success = success;
		handleConfig("success", success);
	}

	private Integer timeout;

	/**
	 * The number of seconds to wait for a serverresponse before failing with
	 * the <a href="output/Ext.form.Action.html#Ext.form.Action-failureType"
	 * ext:member="failureType" ext:cls="Ext.form.Action">failureType</a> as <a
	 * href="output/Ext.form.Action.html#Ext.form.Action-Action.CONNECT_FAILURE"
	 * ext:member="Action.CONNECT_FAILURE"
	 * ext:cls="Ext.form.Action">Action.CONNECT_FAILURE</a>. If not specified,
	 * defaults to the configured
	 * <tt><a href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-timeout" ext:member="timeout" ext:cls="Ext.form.BasicForm">timeout</a></tt>
	 * of the <a href="output/Ext.form.BasicForm.html"
	 * ext:cls="Ext.form.BasicForm">form</a>.
	 */
	public Integer getTimeout() {
		if (null != this.timeout) {
			return this.timeout;
		}
		ValueExpression _ve = getValueExpression("timeout");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>timeout</code> property.
	 * </p>
	 */
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
		handleConfig("timeout", timeout);
	}

	private String url;

	/**
	 * The URL that the Action is to invoke.
	 */
	public String getUrl() {
		if (null != this.url) {
			return this.url;
		}
		ValueExpression _ve = getValueExpression("url");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>url</code> property.
	 * </p>
	 */
	public void setUrl(String url) {
		this.url = url;
		handleConfig("url", url);
	}

	private String waitMsg;

	/**
	 * The message to be displayed by a call to <a
	 * href="output/Ext.MessageBox.html#Ext.MessageBox-wait" ext:member="wait"
	 * ext:cls="Ext.MessageBox">Ext.MessageBox.wait</a>during the time the
	 * action is being processed.
	 */
	public String getWaitMsg() {
		if (null != this.waitMsg) {
			return this.waitMsg;
		}
		ValueExpression _ve = getValueExpression("waitMsg");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>waitMsg</code> property.
	 * </p>
	 */
	public void setWaitMsg(String waitMsg) {
		this.waitMsg = waitMsg;
		handleConfig("waitMsg", waitMsg);
	}

	private String waitTitle;

	/**
	 * The title to be displayed by a call to <a
	 * href="output/Ext.MessageBox.html#Ext.MessageBox-wait" ext:member="wait"
	 * ext:cls="Ext.MessageBox">Ext.MessageBox.wait</a>during the time the
	 * action is being processed.
	 */
	public String getWaitTitle() {
		if (null != this.waitTitle) {
			return this.waitTitle;
		}
		ValueExpression _ve = getValueExpression("waitTitle");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>waitTitle</code> property.
	 * </p>
	 */
	public void setWaitTitle(String waitTitle) {
		this.waitTitle = waitTitle;
		handleConfig("waitTitle", waitTitle);
	}

	
	private Object successFn;

	@ClientConfig(JsonMode.Function)
	public Object getSuccessFn() {
		if (null != this.successFn) {
			return this.successFn;
		}
		ValueExpression _ve = getValueExpression("successFn");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setSuccessFn(Object successFn) {
		this.successFn = successFn;
		this.handleConfig("successFn", successFn);
	}
	
	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[12];
		}
		_values[0] = super.saveState(_context);
		_values[1] = failure;
		_values[2] = method;
		_values[3] = params;
		_values[4] = reset;
		_values[5] = scope;
		_values[6] = success;
		_values[7] = timeout;
		_values[8] = url;
		_values[9] = waitMsg;
		_values[10] = waitTitle;
		_values[11] = successFn;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.failure = (Object) _values[1];
		this.handleConfig("failure", this.failure);
		this.method = (String) _values[2];
		this.handleConfig("method", this.method);
		this.params = (Object) _values[3];
		this.handleConfig("params", this.params);
		this.reset = (Boolean) _values[4];
		this.handleConfig("reset", this.reset);
		this.scope = (Object) _values[5];
		this.handleConfig("scope", this.scope);
		this.success = (Object) _values[6];
		this.handleConfig("success", this.success);
		this.timeout = (Integer) _values[7];
		this.handleConfig("timeout", this.timeout);
		this.url = (String) _values[8];
		this.handleConfig("url", this.url);
		this.waitMsg = (String) _values[9];
		this.handleConfig("waitMsg", this.waitMsg);
		this.waitTitle = (String) _values[10];
		this.handleConfig("waitTitle", this.waitTitle);
		this.successFn =  _values[11];
		this.handleConfig("successFn", this.successFn);
	}
}