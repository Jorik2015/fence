package ext.ux;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.UXResources;
import ext.util.Observable;

//@UXResources(js = "ext[version]/ux/menu.js", css = "ext[version]/ux/css/menu.css")
@InstanceOf("Ext.ux.Menu")
@ParseConfigMode(id = false)
public class Menu extends Observable {
	public static final String COMPONENT_TYPE = "Ext.ux.Menu";

	/**
	 * <p>
	 * Create a new {@link GMapPanel} instance with default property values.
	 * </p>
	 */
	public Menu() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private String transitionType;
	private String direction;
	private Double delay;
	private Boolean autoWidth;
	private Double transitionDuration;
	private Boolean animate;
	private String currentClass;
	private Object data;

	public String getTransitionType() {
		if (null != this.transitionType) {
			return this.transitionType;
		}
		ValueExpression _ve = getValueExpression("transitionType");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setTransitionType(String transitionType) {
		this.transitionType = transitionType;
		this.handleConfig("transitionType", transitionType);
	}

	public String getDirection() {
		if (null != this.direction) {
			return this.direction;
		}
		ValueExpression _ve = getValueExpression("direction");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setDirection(String direction) {
		this.direction = direction;
		this.handleConfig("direction", direction);
	}

	public Double getDelay() {
		if (null != this.delay) {
			return this.delay;
		}
		ValueExpression _ve = getValueExpression("delay");
		if (_ve != null) {
			return (Double) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setDelay(Double delay) {
		this.delay = delay;
		this.handleConfig("delay", delay);
	}

	public Double getTransitionDuration() {
		if (null != this.transitionDuration) {
			return this.transitionDuration;
		}
		ValueExpression _ve = getValueExpression("transitionDuration");
		if (_ve != null) {
			return (Double) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setTransitionDuration(Double transitionDuration) {
		this.transitionDuration = transitionDuration;
		this.handleConfig("transitionDuration", transitionDuration);
	}

	public String getCurrentClass() {
		if (null != this.currentClass) {
			return this.currentClass;
		}
		ValueExpression _ve = getValueExpression("currentClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
		this.handleConfig("currentClass", currentClass);
	}

	public Boolean getAutoWidth() {
		if (null != this.autoWidth) {
			return this.autoWidth;
		}
		ValueExpression _ve = getValueExpression("autoWidth");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setAutoWidth(Boolean autoWidth) {
		this.autoWidth = autoWidth;
		this.handleConfig("autoWidth", autoWidth);
	}

	public Boolean getAnimate() {
		if (null != this.animate) {
			return this.animate;
		}
		ValueExpression _ve = getValueExpression("animate");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setAnimate(Boolean animate) {
		this.animate = animate;
		this.handleConfig("animate", animate);
	}

	@ClientConfig(value = JsonMode.Ignore)
	public Object getData() {
		if (null != this.data) {
			return this.data;
		}
		ValueExpression _ve = getValueExpression("data");
		if (_ve != null) {
			return _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setData(Object data) {
		this.data = data;
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[9];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.transitionType;
		_values[2] = this.direction;
		_values[3] = this.delay;
		_values[4] = this.autoWidth;
		_values[5] = this.transitionDuration;
		_values[6] = this.animate;
		_values[7] = this.currentClass;
		_values[8] = this.data;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.transitionType = (String) _values[1];
		this.handleConfig("transitionType", transitionType);

		this.direction = (String) _values[2];
		this.handleConfig("direction", direction);

		this.delay = (Double) _values[3];
		this.handleConfig("delay", delay);

		this.autoWidth = (Boolean) _values[4];
		this.handleConfig("autoWidth", autoWidth);

		this.transitionDuration = (Double) _values[5];
		this.handleConfig("transitionDuration", transitionDuration);

		this.animate = (Boolean) _values[6];
		this.handleConfig("animate", animate);

		this.currentClass = (String) _values[7];
		this.handleConfig("currentClass", currentClass);

		this.data = _values[8];
	}
}