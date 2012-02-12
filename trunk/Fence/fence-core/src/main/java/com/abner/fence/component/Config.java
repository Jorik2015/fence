package com.abner.fence.component;

import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.abner.fence.annotation.ParseConfigMode;
import com.abner.fence.commons.Enums.PersistenceMode;

import ext.util.Observable;

@ParseConfigMode(pmode = PersistenceMode.Custom)
@FacesComponent("Ext.Config")
public class Config extends Observable {
	public static final String COMPONENT_TYPE = "Ext.Config";

	public Config() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private String name;
	private String value;
	private String mode;

	public String getName() {
		if (null != this.name) {
			return this.name;
		}
		ValueExpression _ve = getValueExpression("name");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		if (null != this.value) {
			return this.value;
		}
		ValueExpression _ve = getValueExpression("value");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMode() {
		if (null != this.mode) {
			return this.mode;
		}
		ValueExpression _ve = getValueExpression("mode");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.name;
		_values[2] = this.value;
		_values[3] = this.mode;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.name = (String) _values[1];
		this.value = (String) _values[2];
		this.mode = (String) _values[3];
	}
}
