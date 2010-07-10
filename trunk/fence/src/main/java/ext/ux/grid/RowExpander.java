package ext.ux.grid;

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
 * Plugin (ptype = 'rowexpander') that adds
  the ability to have a Column in a grid which enables a second row
  body which expands/contracts. The expand/contract behavior is
  configurable to react on clicking of the column, double click of
  the row, and/or hitting enter while a row is selected.
 */

@InstanceOf("Ext.ux.grid.RowExpander")
@ParseConfigMode(ui = false,name="plugins",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@ResourceDependency(library = "ext#{ext.version}/ux", name = "RowExpander.js")
@FacesComponent(value = "Ext.ux.grid.RowExpander")
public class RowExpander extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.RowExpander";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.RowExpander} instance with default property values.
	 * </p>
	 */
	public RowExpander() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			expandOnEnter
			,expandOnDblClick
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
        
        
          expandOnEnter
         : Boolean
        
        true to toggle selected row(s) between
        expanded/collapsed when the enter key is pressed (defaults
        to 
        true).
	 */
	
	public Boolean getExpandOnEnter () {
		return (Boolean) getStateHelper().eval(PropertyKeys.expandOnEnter);
	}

	/**
	 * <p>
	 * Set the value of the <code>expandOnEnter</code> property.
	 * </p>
	 */
	public void setExpandOnEnter ( Boolean   expandOnEnter ) {
		getStateHelper().put(PropertyKeys.expandOnEnter, expandOnEnter);
		handleAttribute("expandOnEnter", expandOnEnter);
	}
    	/*
	 *
        
        
          expandOnDblClick
         : Boolean
        
        true to toggle a row between expanded/collapsed
        when double clicked (defaults to 
        true).
	 */
	
	public Boolean getExpandOnDblClick () {
		return (Boolean) getStateHelper().eval(PropertyKeys.expandOnDblClick);
	}

	/**
	 * <p>
	 * Set the value of the <code>expandOnDblClick</code> property.
	 * </p>
	 */
	public void setExpandOnDblClick ( Boolean   expandOnDblClick ) {
		getStateHelper().put(PropertyKeys.expandOnDblClick, expandOnDblClick);
		handleAttribute("expandOnDblClick", expandOnDblClick);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforecollapse"
					, "beforeexpand"
					, "collapse"
					, "expand"
				));
				return superEvent;
	}
}