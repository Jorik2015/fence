package com.abner.fence.ajax;

import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.abner.fence.annotation.ParseConfigMode;
import com.abner.fence.commons.Enums.PersistenceMode;
import com.abner.fence.commons.Enums.ReferenceMode;

@FacesComponent("Ext.ajax.Updater")
@ParseConfigMode(id = false, ui = false, pmode = PersistenceMode.Custom, rmode = ReferenceMode.Config)
public class UpdateOptions extends RequestOptions {
	public static final String COMPONENT_TYPE = "Ext.ajax.Updater";

	/**
	 * <p>
	 * Create a new {@link RequestOptions} instance with default property values.
	 * </p>
	 */
	public UpdateOptions() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Boolean scripts;
	private Boolean discardUrl;
	private String text;
	private Boolean nocache;
	private Integer interval;
	private Boolean refreshNow;

	public String getText() {
		if (null != this.text) {
			return this.text;
		}
		ValueExpression _ve = getValueExpression("text");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText(String text) {
		this.text = text;
		handleConfig("text", text);
	}

	public Boolean getScripts() {
		if (null != this.scripts) {
			return this.scripts;
		}
		ValueExpression _ve = getValueExpression("scripts");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scripts</code> property.
	 * </p>
	 */
	public void setScripts(Boolean scripts) {
		this.scripts = scripts;
		handleConfig("scripts", scripts);
	}

	public Boolean getDiscardUrl() {
		if (null != this.discardUrl) {
			return this.discardUrl;
		}
		ValueExpression _ve = getValueExpression("discardUrl");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>discardUrl</code> property.
	 * </p>
	 */
	public void setDiscardUrl(Boolean discardUrl) {
		this.discardUrl = discardUrl;
		handleConfig("discardUrl", discardUrl);
	}

	public Boolean getNocache() {
		if (null != this.nocache) {
			return this.nocache;
		}
		ValueExpression _ve = getValueExpression("nocache");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>nocache</code> property.
	 * </p>
	 */
	public void setNocache(Boolean nocache) {
		this.nocache = nocache;
		handleConfig("nocache", nocache);
	}

	public Integer getInterval() {
		if (null != this.interval) {
			return this.interval;
		}
		ValueExpression _ve = getValueExpression("interval");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public Boolean getRefreshNow() {
		if (null != this.refreshNow) {
			return this.refreshNow;
		}
		ValueExpression _ve = getValueExpression("refreshNow");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>refreshNow</code> property.
	 * </p>
	 */
	public void setRefreshNow(Boolean refreshNow) {
		this.refreshNow = refreshNow;
		handleConfig("refreshNow", refreshNow);
	}

	/**
	 * <p>
	 * Set the value of the <code>interval </code> property.
	 * </p>
	 */
	public void setInterval(Integer interval) {
		this.interval = interval;
		handleConfig("interval", interval);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[7];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.text;
		_values[2] = this.scripts;
		_values[3] = this.discardUrl;
		_values[4] = this.nocache;
		_values[5] = this.interval;
		_values[6] = this.refreshNow;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.text = (String) _values[1];
		this.handleConfig("text", this.text);
		this.scripts = (Boolean) _values[2];
		this.handleConfig("scripts", this.scripts);
		this.discardUrl = (Boolean) _values[3];
		this.handleConfig("discardUrl", this.discardUrl);
		this.nocache = (Boolean) _values[4];
		this.handleConfig("nocache", this.nocache);
		this.interval = (Integer) _values[5];
		this.handleConfig("interval", this.interval);
		this.refreshNow = (Boolean) _values[6];
		this.handleConfig("refreshNow", this.refreshNow);
	}
}
