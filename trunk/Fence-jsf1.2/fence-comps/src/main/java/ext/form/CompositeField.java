package ext.form;

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
<div class="description">Composite field allowing a number of
  form Fields to be rendered on the same row. The fields are
  rendered using an hbox layout internally, so all of the normal
  HBox layout config items are available. Example usage: 
<pre>
{
    xtype: 'compositefield',
    labelWidth: 120
    items: [
        {
            xtype     : 'textfield',
            fieldLabel: 'Title',
            width     : 20
        },
        {
            xtype     : 'textfield',
            fieldLabel: 'First',
            flex      : 1
        },
        {
            xtype     : 'textfield',
            fieldLabel: 'Last',
            flex      : 1
        }
    ]
}
  </pre>In the example above the composite's fieldLabel will be set
  to 'Title, First, Last' as it groups the fieldLabels of each of
  its children. This can be overridden by setting a fieldLabel on
  the compositefield itself: 
<pre>
{
    xtype: 'compositefield',
    fieldLabel: 'Custom label',
    items: [...]
}
  </pre>Any Ext.form.* component can be placed inside a composite
  field.</div>

 */
@XType("compositefield")
@InstanceOf("Ext.form.CompositeField")
public class CompositeField extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.CompositeField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.CompositeField} instance with default property values.
	 * </p>
	 */
	public CompositeField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			labelConnector
			,defaults
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
	
		
	private String labelConnector;
	
	/*
	 *
        
        
          labelConnector
         : String
        The string to use when joining segments
        of the built label together (defaults to ', ')
	 */
	
	public String getLabelConnector () {
		if (null != this.labelConnector) {
			return this.labelConnector;
		}
		ValueExpression _ve = getValueExpression("labelConnector");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>labelConnector</code> property.
	 * </p>
	 */
	public void setLabelConnector (String  labelConnector) {
		this.labelConnector = labelConnector;
		this.handleConfig("labelConnector", labelConnector);
	}
    	
	private Object defaults;
	
	/*
	 *
        
        
          defaults
         : Object
        Any default properties to assign to the
        child fields.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaults () {
		if (null != this.defaults) {
			return this.defaults;
		}
		ValueExpression _ve = getValueExpression("defaults");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaults</code> property.
	 * </p>
	 */
	public void setDefaults (Object  defaults) {
		this.defaults = defaults;
		this.handleConfig("defaults", defaults);
	}
	
	private Object items;

	/**
	 * An Array of <a href="output/Ext.form.Checkbox.html"
	 * ext:cls="Ext.form.Checkbox">Checkbox</a>es or Checkbox configobjects to
	 * arrange in the group.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getItems() {
		if (null != this.items) {
			return this.items;
		}
		ValueExpression _ve = getValueExpression("items");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>items</code> property.
	 * </p>
	 */
	public void setItems(Object items) {
		this.items = items;
		this.handleConfig("items", items);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
				_values[1] = labelConnector;	
				_values[2] = defaults;	
				_values[3] = items;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.labelConnector = (String) _values[1];
		this.handleConfig("labelConnector", this.labelConnector);
				this.defaults = (Object) _values[2];
		this.handleConfig("defaults", this.defaults);
		this.items = (Object) _values[3];
		this.handleConfig("items", this.items);
			}
}