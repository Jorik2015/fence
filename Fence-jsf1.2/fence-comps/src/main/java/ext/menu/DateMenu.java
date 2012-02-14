package ext.menu;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * A menu containing an <a href="output/Ext.DatePicker.html"
 * ext:cls="Ext.DatePicker">Ext.DatePicker</a> Component.
 * </p>
 * 
 * <p>
 * Notes:
 * </p>
 * 
 * <div class="mdetail-params">
 * <ul>
 * <li>Although not listed here, the <b>constructor</b> for this class accepts
 * all of the configuration options of <b><a href="output/Ext.DatePicker.html"
 * ext:cls="Ext.DatePicker">Ext.DatePicker</a></b>.</li>
 * 
 * <li>If subclassing DateMenu, any configuration options for the DatePicker
 * must be applied to the <tt><b>initialConfig</b></tt> property of the
 * DateMenu. Applying <a href="output/Ext.DatePicker.html"
 * ext:cls="Ext.DatePicker">DatePicker</a> configuration settings to <b>
 * <tt>this</tt></b> will <b>not</b> affect the DatePicker's configuration.</li>
 * </ul>
 * </div>
 */
@XType("datemenu")
@InstanceOf("Ext.menu.DateMenu")
@ParseConfigMode(name = "menu", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class DateMenu extends Menu {
	public static final String COMPONENT_TYPE = "Ext.menu.DateMenu";
	public static final String COMPONENT_FAMILY = "Ext.menu.DateMenu";

	/**
	 * <p>
	 * Create a new {@link DateMenu} instance with default property values.
	 * </p>
	 */
	public DateMenu() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Object handler;

	/**
	 * Optional. A function that will handle the selectevent of this menu. The
	 * handler is passed the following parameters:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><code>picker</code> : DatePicker
	 * 
	 * <div class="sub-desc">The Ext.DatePicker.</div></li>
	 * 
	 * <li><code>date</code> : Date
	 * 
	 * <div class="sub-desc">The selected date.</div></li>
	 * </ul>
	 * </div>
	 */
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

	private Boolean hideOnClick;

	/**
	 * False to continue showing the menu after a dateis selected, defaults to
	 * true.
	 */
	public Boolean getHideOnClick() {
		if (null != this.hideOnClick) {
			return this.hideOnClick;
		}
		ValueExpression _ve = getValueExpression("hideOnClick");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hideOnClick</code> property.
	 * </p>
	 */
	public void setHideOnClick(Boolean hideOnClick) {
		this.hideOnClick = hideOnClick;
		this.handleConfig("hideOnClick", hideOnClick);
	}

	private Object scope;

	/**
	 * The scope (<tt><b>this</b></tt> reference) inwhich the
	 * <code><a href="output/Ext.menu.DateMenu.html#Ext.menu.DateMenu-handler" ext:member="handler" ext:cls="Ext.menu.DateMenu">handler</a></code>
	 * function will be called. Defaults to this DateMenu instance.
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

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = handler;
		_values[2] = hideOnClick;
		_values[3] = scope;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.handler = (Object) _values[1];
		this.handleConfig("handler", this.handler);
		this.hideOnClick = (Boolean) _values[2];
		this.handleConfig("hideOnClick", this.hideOnClick);
		this.scope = (Object) _values[3];
		this.handleConfig("scope", this.scope);

	}
}