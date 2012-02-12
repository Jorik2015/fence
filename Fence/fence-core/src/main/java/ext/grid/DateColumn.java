package ext.grid;

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
    <p>A Column definition class which renders a passed date
    according to the default locale, or a configured 
    <a ext:cls="Ext.grid.DateColumn" ext:member="format" href="output/Ext.grid.DateColumn.html#Ext.grid.DateColumn-format">format</a>.
    See the 
    <a ext:cls="Ext.grid.Column" ext:member="xtype" href="output/Ext.grid.Column.html#Ext.grid.Column-xtype">xtype</a> config
    option of 
    <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> for more
    details.</p>
  </div>

 */

@InstanceOf("Ext.grid.DateColumn")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.DateColumn")
public class DateColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.grid.DateColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.DateColumn} instance with default property values.
	 * </p>
	 */
	public DateColumn() {
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
	 *
        
        
          format
         : String
        A formatting string as used by 
        Date.format to format a Date for this
        Column (defaults to 
        'm/d/Y').
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