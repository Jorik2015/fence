package ext.ux.grid.filter;

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
 * Abstract base class for filter
  implementations.
 */

@InstanceOf("Ext.ux.grid.filter.Filter")
@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "Filter.js")
@FacesComponent(value = "Ext.ux.grid.filter.Filter")
@ParseConfigMode(ui = false,name="filters",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
public class Filter extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.filter.Filter";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.filter.Filter} instance with default property values.
	 * </p>
	 */
	public Filter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			active
			,dataIndex
			,updateBuffer
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
        
        
          active
         : Boolean
        Indicates the initial status of the
        filter (defaults to false).
	 */
	
	public Boolean getActive () {
		return (Boolean) getStateHelper().eval(PropertyKeys.active);
	}

	/**
	 * <p>
	 * Set the value of the <code>active</code> property.
	 * </p>
	 */
	public void setActive ( Boolean   active ) {
		getStateHelper().put(PropertyKeys.active, active);
		handleAttribute("active", active);
	}
    	/*
	 *The 
          Ext.data.Store dataIndex of
          the field this filter represents. The dataIndex does not
          actually have to exist in the store.
	 */
	
	public String getDataIndex () {
		return (String) getStateHelper().eval(PropertyKeys.dataIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>dataIndex</code> property.
	 * </p>
	 */
	public void setDataIndex ( String   dataIndex ) {
		getStateHelper().put(PropertyKeys.dataIndex, dataIndex);
		handleAttribute("dataIndex", dataIndex);
	}
    	/*
	 *Number of milliseconds to wait after
          user interaction to fire an update. Only supported by
          filters: 'list', 'numeric', and 'string'. Defaults to
          500.
	 */
	
	public Integer getUpdateBuffer () {
		return (Integer) getStateHelper().eval(PropertyKeys.updateBuffer);
	}

	/**
	 * <p>
	 * Set the value of the <code>updateBuffer</code> property.
	 * </p>
	 */
	public void setUpdateBuffer ( Integer   updateBuffer ) {
		getStateHelper().put(PropertyKeys.updateBuffer, updateBuffer);
		handleAttribute("updateBuffer", updateBuffer);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "activate"
					, "deactivate"
					, "serialize"
					, "update"
				));
				return superEvent;
	}
}