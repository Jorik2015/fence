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

@InstanceOf("Ext.list.Sorter")

@FacesComponent(value = "Ext.list.Sorter")
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
		return (Object) getStateHelper().eval(PropertyKeys.sortClasses);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortClasses</code> property.
	 * </p>
	 */
	public void setSortClasses ( Object   sortClasses ) {
		getStateHelper().put(PropertyKeys.sortClasses, sortClasses);
		handleAttribute("sortClasses", sortClasses);
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