package ext.list;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
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
    <p>A Column definition class which renders a numeric data field
    according to a 
    <a ext:cls="Ext.list.NumberColumn" ext:member="format" href="output/Ext.list.NumberColumn.html#Ext.list.NumberColumn-format">format</a>
    string. See the 
    <a ext:cls="Ext.list.Column" ext:member="xtype" href="output/Ext.list.Column.html#Ext.list.Column-xtype">xtype</a> config
    option of 
    <a ext:cls="Ext.list.Column" href="output/Ext.list.Column.html">Ext.list.Column</a> for more
    details.</p>
  </div>

 */

@InstanceOf("Ext.list.NumberColumn")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.list.NumberColumn")
public class NumberColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.list.NumberColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.list.NumberColumn} instance with default property values.
	 * </p>
	 */
	public NumberColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			format
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
	
		/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A formatting string as used by 
          <a ext:cls="Ext.util.Format" ext:member="number" href="output/Ext.util.Format.html#Ext.util.Format-number">Ext.util.Format.number</a> to
          format a numeric value for this Column (defaults to 
          <tt>'0,000.00'</tt>).</div>

	 */
	
	public String getFormat () {
		return (String) getStateHelper().eval(PropertyKeys.format);
	}

	/**
	 * <p>
	 * Set the value of the <code>format</code> property.
	 * </p>
	 */
	public void setFormat ( String   format ) {
		getStateHelper().put(PropertyKeys.format, format);
		handleAttribute("format", format);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				return superEvent;
	}
}