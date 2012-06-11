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
@XType("portalcolumn")
@InstanceOf("Ext.ux.PortalColumn")
public class PortalColumn extends Container {
	public static final String COMPONENT_FAMILY = "Ext.ux.PortalColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.PortalColumn} instance with default property values.
	 * </p>
	 */
	public PortalColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
	
	    
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[1];
		}
		_values[0] = super.saveState(_context);
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
			}
}