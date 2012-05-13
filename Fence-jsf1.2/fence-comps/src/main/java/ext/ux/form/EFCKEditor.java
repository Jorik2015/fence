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
@XType("efckeidtor")
@InstanceOf("Ext.ux.form.EFCKEditor")
public class EFCKEditor extends TextArea {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.EFCKEditor";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.form.EFCKEditor} instance with default property values.
	 * </p>
	 */
	public EFCKEditor() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			basePath
			,toolbarSet
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
	
		
	private String basePath;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getBasePath () {
		if (null != this.basePath) {
			return this.basePath;
		}
		ValueExpression _ve = getValueExpression("basePath");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>basePath</code> property.
	 * </p>
	 */
	public void setBasePath (String  basePath) {
		this.basePath = basePath;
		this.handleConfig("basePath", basePath);
	}
    	
	private String toolbarSet;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getToolbarSet () {
		if (null != this.toolbarSet) {
			return this.toolbarSet;
		}
		ValueExpression _ve = getValueExpression("toolbarSet");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>toolbarSet</code> property.
	 * </p>
	 */
	public void setToolbarSet (String  toolbarSet) {
		this.toolbarSet = toolbarSet;
		this.handleConfig("toolbarSet", toolbarSet);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
				_values[1] = basePath;	
				_values[2] = toolbarSet;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.basePath = (String) _values[1];
		this.handleConfig("basePath", this.basePath);
				this.toolbarSet = (String) _values[2];
		this.handleConfig("toolbarSet", this.toolbarSet);
			}
}