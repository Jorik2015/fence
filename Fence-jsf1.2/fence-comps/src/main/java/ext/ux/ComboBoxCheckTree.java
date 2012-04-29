package ext.ux;

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
@XType("combochecktree")
@InstanceOf("Ext.ux.ComboBoxCheckTree")
public class ComboBoxCheckTree extends ComboBox {
	public static final String COMPONENT_FAMILY = "Ext.ux.ComboBoxCheckTree";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.ComboBoxCheckTree} instance with default property values.
	 * </p>
	 */
	public ComboBoxCheckTree() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			checkModel
			,onlyLeafCheckable
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
	
		
	private String checkModel;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getCheckModel () {
		if (null != this.checkModel) {
			return this.checkModel;
		}
		ValueExpression _ve = getValueExpression("checkModel");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>checkModel</code> property.
	 * </p>
	 */
	public void setCheckModel (String  checkModel) {
		this.checkModel = checkModel;
		this.handleConfig("checkModel", checkModel);
	}
    	
	private Boolean onlyLeafCheckable;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getOnlyLeafCheckable () {
		if (null != this.onlyLeafCheckable) {
			return this.onlyLeafCheckable;
		}
		ValueExpression _ve = getValueExpression("onlyLeafCheckable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>onlyLeafCheckable</code> property.
	 * </p>
	 */
	public void setOnlyLeafCheckable (Boolean  onlyLeafCheckable) {
		this.onlyLeafCheckable = onlyLeafCheckable;
		this.handleConfig("onlyLeafCheckable", onlyLeafCheckable);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
				_values[1] = checkModel;	
				_values[2] = onlyLeafCheckable;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.checkModel = (String) _values[1];
		this.handleConfig("checkModel", this.checkModel);
				this.onlyLeafCheckable = (Boolean) _values[2];
		this.handleConfig("onlyLeafCheckable", this.onlyLeafCheckable);
			}
}