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
@XType("combotree")
@InstanceOf("Ext.ux.ComboBoxTree")
public class ComboBoxTree extends ComboBox {
	public static final String COMPONENT_FAMILY = "Ext.ux.ComboBoxTree";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.ComboBoxTree} instance with default property values.
	 * </p>
	 */
	public ComboBoxTree() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			selectNodeModel
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
	
		
	private String selectNodeModel;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getSelectNodeModel () {
		if (null != this.selectNodeModel) {
			return this.selectNodeModel;
		}
		ValueExpression _ve = getValueExpression("selectNodeModel");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>selectNodeModel</code> property.
	 * </p>
	 */
	public void setSelectNodeModel (String  selectNodeModel) {
		this.selectNodeModel = selectNodeModel;
		this.handleConfig("selectNodeModel", selectNodeModel);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
				_values[1] = selectNodeModel;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.selectNodeModel = (String) _values[1];
		this.handleConfig("selectNodeModel", this.selectNodeModel);
			}
}