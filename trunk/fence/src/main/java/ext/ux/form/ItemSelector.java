package ext.ux.form;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
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
 * A control that allows selection of
  between two Ext.ux.form.MultiSelect controls.
 */

@InstanceOf("Ext.ux.form.ItemSelector")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "ItemSelector.js")
@FacesComponent(value = "Ext.ux.form.ItemSelector")
public class ItemSelector extends ext.form.Field {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.ItemSelector";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.form.ItemSelector} instance with default property values.
	 * </p>
	 */
	public ItemSelector() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			multiselects
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
        
        
          multiselects
         : Array
        An array of 
        Ext.ux.form.MultiSelect
        config objects, with at least all required parameters
        (e.g., store)
	 */
	@ClientConfig(JsonMode.Array)

	public Object getMultiselects () {
		return (Object) getStateHelper().eval(PropertyKeys.multiselects);
	}

	/**
	 * <p>
	 * Set the value of the <code>multiselects</code> property.
	 * </p>
	 */
	public void setMultiselects ( Object   multiselects ) {
		getStateHelper().put(PropertyKeys.multiselects, multiselects);
		handleAttribute("multiselects", multiselects);
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