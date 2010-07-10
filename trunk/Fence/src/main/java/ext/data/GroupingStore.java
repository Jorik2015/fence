package ext.data;

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
 * A specialized store implementation that
  provides for grouping records by one of the available fields.
  This is usually used in conjunction with an 
  Ext.grid.GroupingView to
  proved the data model for a grouped GridPanel.
 */
@XType("groupingstore")
@InstanceOf("Ext.data.GroupingStore")
@ParseConfigMode(id=false,ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.GroupingStore")
public class GroupingStore extends Store {
	public static final String COMPONENT_FAMILY = "Ext.data.GroupingStore";

	/**
	 * <p>
	 * Create a new {@link Ext.data.GroupingStore} instance with default property values.
	 * </p>
	 */
	public GroupingStore() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			groupOnSort
			,remoteGroup
			,groupField
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
	 *True to sort the data on the grouping
          field when a grouping operation occurs, false to sort
          based on the existing sort info (defaults to
          false).
	 */
	
	public Boolean getGroupOnSort () {
		return (Boolean) getStateHelper().eval(PropertyKeys.groupOnSort);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupOnSort</code> property.
	 * </p>
	 */
	public void setGroupOnSort ( Boolean   groupOnSort ) {
		getStateHelper().put(PropertyKeys.groupOnSort, groupOnSort);
		handleAttribute("groupOnSort", groupOnSort);
	}
    	/*
	 *True if the grouping should apply on
          the server side, false if it is local only (defaults to
          false). If the grouping is local, it can be applied
          immediately to the data. If it is remote, then it will
          simply act as a helper, automatically sending the
          grouping field name as the 'groupBy' param with each XHR
          call.
	 */
	
	public Boolean getRemoteGroup () {
		return (Boolean) getStateHelper().eval(PropertyKeys.remoteGroup);
	}

	/**
	 * <p>
	 * Set the value of the <code>remoteGroup</code> property.
	 * </p>
	 */
	public void setRemoteGroup ( Boolean   remoteGroup ) {
		getStateHelper().put(PropertyKeys.remoteGroup, remoteGroup);
		handleAttribute("remoteGroup", remoteGroup);
	}
    	/*
	 *
        
        
          groupField
         : String
        The field name by which to sort the
        store's data (defaults to '').
	 */
	
	public String getGroupField () {
		return (String) getStateHelper().eval(PropertyKeys.groupField);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupField</code> property.
	 * </p>
	 */
	public void setGroupField ( String   groupField ) {
		getStateHelper().put(PropertyKeys.groupField, groupField);
		handleAttribute("groupField", groupField);
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