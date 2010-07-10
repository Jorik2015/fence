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
 * 
    Supporting Class for Ext.list.ListView
  
 */

@InstanceOf("Ext.list.ColumnResizer")

@FacesComponent(value = "Ext.list.ColumnResizer")
public class ColumnResizer extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.list.ColumnResizer";

	/**
	 * <p>
	 * Create a new {@link Ext.list.ColumnResizer} instance with default property values.
	 * </p>
	 */
	public ColumnResizer() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			minPct
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
        
        
          minPct
         : Number
        The minimum percentage to allot for any
        column (defaults to 
        .05)
	 */
	
	public Integer getMinPct () {
		return (Integer) getStateHelper().eval(PropertyKeys.minPct);
	}

	/**
	 * <p>
	 * Set the value of the <code>minPct</code> property.
	 * </p>
	 */
	public void setMinPct ( Integer   minPct ) {
		getStateHelper().put(PropertyKeys.minPct, minPct);
		handleAttribute("minPct", minPct);
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