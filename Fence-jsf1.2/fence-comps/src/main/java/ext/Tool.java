package ext;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.form.NumberField;

@ParseConfigMode(name = "tools",id=false, pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class Tool extends Component {
	public static final String COMPONENT_TYPE = "Ext.Tool";
	public static final String COMPONENT_FAMILY = "Ext.Tool";
	
	
	/**
	 * <p>
	 * Create a new {@link NumberField} instance with default property values.
	 * </p>
	 */
	public Tool() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String key;

	@ClientConfig(name = "id")
	public String getKey() {
		if (null != this.key) {
			return this.key;
		}
		ValueExpression _ve = getValueExpression("key");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setKey(String key) {
		this.key = key;
		this.handleConfig("key", key);
	}

	private Object handler;

	@ClientConfig(JsonMode.Function)
	public Object getHandler() {
		if (null != this.handler) {
			return this.handler;
		}
		ValueExpression _ve = getValueExpression("handler");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>handler</code> property.
	 * </p>
	 */
	public void setHandler(Object handler) {
		this.handler = handler;
		this.handleConfig("handler", handler);
	}

	private Boolean stopEvent;

	/**
	 * True to start stopEvent (defaults to false)
	 */
	public Boolean getStopEvent() {
		if (null != this.stopEvent) {
			return this.stopEvent;
		}
		ValueExpression _ve = getValueExpression("stopEvent");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>stopEvent</code> property.
	 * </p>
	 */
	public void setStopEvent(Boolean stopEvent) {
		this.stopEvent = stopEvent;
		this.handleConfig("stopEvent", stopEvent);
	}

	private Object scope;

	/**
	 * The scope (<tt><b>this</b></tt> reference) in which the
	 * <code><a href="output/Ext.Button.html#Ext.Button-handler" ext:member="handler" ext:cls="Ext.Button">handler</a></code>
	 * and
	 * <code><a href="output/Ext.Button.html#Ext.Button-toggleHandler" ext:member="toggleHandler" ext:cls="Ext.Button">toggleHandler</a></code>
	 * is executed. Defaults to this Button.
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
		this.handleConfig("scope", scope);
	}

	private String qtip;

	public String getQtip() {
		if (null != this.qtip) {
			return this.qtip;
		}
		ValueExpression _ve = getValueExpression("qtip");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>qtip</code> property.
	 * </p>
	 */
	public void setQtip(String qtip) {
		this.qtip = qtip;
		this.handleConfig("qtip", qtip);
	}

	private Boolean hidden;

	/**
	 * True to start hidden (defaults to false)
	 */
	public Boolean getHidden() {
		if (null != this.hidden) {
			return this.hidden;
		}
		ValueExpression _ve = getValueExpression("hidden");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hidden</code> property.
	 * </p>
	 */
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
		this.handleConfig("hidden", hidden);
	}

	private Object on;

	@ClientConfig(JsonMode.Object)
	public Object getOn() {
		if (null != this.on) {
			return this.on;
		}
		ValueExpression _ve = getValueExpression("on");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>on</code> property.
	 * </p>
	 */
	public void setOn(Object on) {
		this.on = on;
		this.handleConfig("on", on);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[8];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.key;
		_values[2] = this.handler;
		_values[3] = this.stopEvent;
		_values[4] = this.scope;
		_values[5] = this.qtip;
		_values[6] = this.hidden;
		_values[7] = this.on;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.key = (String) _values[1];
		this.handleConfig("key", this.key);
		this.handler = _values[2];
		this.handleConfig("handler", this.handler);
		this.stopEvent = (Boolean) _values[3];
		this.handleConfig("stopEvent ", this.stopEvent);
		this.scope = _values[4];
		this.handleConfig("scope", this.scope);
		this.qtip = (String) _values[5];
		this.handleConfig("qtip", this.qtip);
		this.hidden = (Boolean) _values[6];
		this.handleConfig("hidden", this.hidden);
		this.on = _values[7];
		this.handleConfig("on", this.on);
	}
}
