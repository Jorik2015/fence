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
 * The default SelectionModel used by 
  Ext.grid.GridPanel. It supports
  multiple selections and keyboard selection/navigation. The
  objects stored as selections and returned by 
  getSelected, and 
  getSelections are the 
  Records which provide the data for
  the selected rows.
 */

@InstanceOf("Ext.grid.RowSelectionModel")
@ParseConfigMode(name="selModel",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.RowSelectionModel")
public class RowSelectionModel extends AbstractSelectionModel {
	public static final String COMPONENT_FAMILY = "Ext.grid.RowSelectionModel";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.RowSelectionModel} instance with default property values.
	 * </p>
	 */
	public RowSelectionModel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			singleSelect
			,moveEditorOnEnter
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
        
        
          singleSelect
         : Boolean
        
        true to allow selection of only one row at a time
        (defaults to 
        false allowing multiple selections)
	 */
	
	public Boolean getSingleSelect () {
		return (Boolean) getStateHelper().eval(PropertyKeys.singleSelect);
	}

	/**
	 * <p>
	 * Set the value of the <code>singleSelect</code> property.
	 * </p>
	 */
	public void setSingleSelect ( Boolean   singleSelect ) {
		getStateHelper().put(PropertyKeys.singleSelect, singleSelect);
		handleAttribute("singleSelect", singleSelect);
	}
    	/*
	 *
          false to turn off moving the editor to the next
          row down when the enter key is pressed or the next row up
          when shift + enter keys are pressed.
	 */
	
	public Boolean getMoveEditorOnEnter () {
		return (Boolean) getStateHelper().eval(PropertyKeys.moveEditorOnEnter);
	}

	/**
	 * <p>
	 * Set the value of the <code>moveEditorOnEnter</code> property.
	 * </p>
	 */
	public void setMoveEditorOnEnter ( Boolean   moveEditorOnEnter ) {
		getStateHelper().put(PropertyKeys.moveEditorOnEnter, moveEditorOnEnter);
		handleAttribute("moveEditorOnEnter", moveEditorOnEnter);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforerowselect"
					, "rowdeselect"
					, "rowselect"
					, "selectionchange"
				));
				return superEvent;
	}
}