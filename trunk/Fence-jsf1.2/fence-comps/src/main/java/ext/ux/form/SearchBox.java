package ext.ux.form;

import javax.el.ValueExpression;
import ext.annotation.*;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
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
 */
@XType("ux-searchbox")
@InstanceOf("Ext.ux.form.SearchBox")
public class SearchBox extends TwinTriggerField {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.SearchBox";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.form.SearchBox} instance with default property values.
	 * </p>
	 */
	public SearchBox() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			searchFunction
			,clearFunction
			,incremental
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
	
		
	private Object searchFunction;
	
	/*
	 *$cfg.commonts
	 */
	@ClientConfig(JsonMode.Function)
	public Object getSearchFunction () {
		if (null != this.searchFunction) {
			return this.searchFunction;
		}
		ValueExpression _ve = getValueExpression("searchFunction");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>searchFunction</code> property.
	 * </p>
	 */
	public void setSearchFunction (Object  searchFunction) {
		this.searchFunction = searchFunction;
		this.handleConfig("searchFunction", searchFunction);
	}
    	
	private Object clearFunction;
	
	/*
	 *$cfg.commonts
	 */
	@ClientConfig(JsonMode.Function)
	public Object getClearFunction () {
		if (null != this.clearFunction) {
			return this.clearFunction;
		}
		ValueExpression _ve = getValueExpression("clearFunction");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>clearFunction</code> property.
	 * </p>
	 */
	public void setClearFunction (Object  clearFunction) {
		this.clearFunction = clearFunction;
		this.handleConfig("clearFunction", clearFunction);
	}
    	
	private Boolean incremental;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getIncremental () {
		if (null != this.incremental) {
			return this.incremental;
		}
		ValueExpression _ve = getValueExpression("incremental");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>incremental</code> property.
	 * </p>
	 */
	public void setIncremental (Boolean  incremental) {
		this.incremental = incremental;
		this.handleConfig("incremental", incremental);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
				_values[1] = searchFunction;	
				_values[2] = clearFunction;	
				_values[3] = incremental;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.searchFunction = (Object) _values[1];
		this.handleConfig("searchFunction", this.searchFunction);
				this.clearFunction = (Object) _values[2];
		this.handleConfig("clearFunction", this.clearFunction);
				this.incremental = (Boolean) _values[3];
		this.handleConfig("incremental", this.incremental);
			}
}