package ext.list;

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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>Supporting Class for Ext.list.ListView</p>
  </div>

 */

@InstanceOf("Ext.list.Sorter")
public class Sorter extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.list.Sorter";

	/**
	 * <p>
	 * Create a new {@link Ext.list.Sorter} instance with default property values.
	 * </p>
	 */
	public Sorter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			sortClasses
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
	
		
	private Object sortClasses;
	
	/*
	 *
        
        
          sortClasses
         : Array
        The CSS classes applied to a header when
        it is sorted. (defaults to 
        ["sort-asc", "sort-desc"])
	 */
	@ClientConfig(JsonMode.Array)

	public Object getSortClasses () {
		if (null != this.sortClasses) {
			return this.sortClasses;
		}
		ValueExpression _ve = getValueExpression("sortClasses");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sortClasses</code> property.
	 * </p>
	 */
	public void setSortClasses (Object  sortClasses) {
		this.sortClasses = sortClasses;
		this.handleConfig("sortClasses", sortClasses);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
				_values[1] = sortClasses;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.sortClasses = (Object) _values[1];
		this.handleConfig("sortClasses", this.sortClasses);
			}
}