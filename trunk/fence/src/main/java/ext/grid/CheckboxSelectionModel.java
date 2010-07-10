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
 * A custom selection model that renders a
  column of checkboxes that can be toggled to select or deselect
  rows.
 */

@InstanceOf("Ext.grid.CheckboxSelectionModel")
@ParseConfigMode(name="selModel",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.CheckboxSelectionModel")
public class CheckboxSelectionModel extends RowSelectionModel {
	public static final String COMPONENT_FAMILY = "Ext.grid.CheckboxSelectionModel";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.CheckboxSelectionModel} instance with default property values.
	 * </p>
	 */
	public CheckboxSelectionModel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			width
			,checkOnly
			,header
			,sortable
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
        
        
          width
         : Number
        The default width in pixels of the
        checkbox column (defaults to 
        20).
	 */
	
	public Integer getWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.width);
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth ( Integer   width ) {
		getStateHelper().put(PropertyKeys.width, width);
		handleAttribute("width", width);
	}
    	/*
	 *
        
        
          checkOnly
         : Boolean
        
        true if rows can only be selected by clicking on
        the checkbox column (defaults to 
        false).
	 */
	
	public Boolean getCheckOnly () {
		return (Boolean) getStateHelper().eval(PropertyKeys.checkOnly);
	}

	/**
	 * <p>
	 * Set the value of the <code>checkOnly</code> property.
	 * </p>
	 */
	public void setCheckOnly ( Boolean   checkOnly ) {
		getStateHelper().put(PropertyKeys.checkOnly, checkOnly);
		handleAttribute("checkOnly", checkOnly);
	}
    	/*
	 *Any valid text or HTML fragment to
          display in the header cell for the checkbox column.
          Defaults to:


'<div
class="x-grid3-hd-checker">&#160;</div>'
          The default CSS class of 
          'x-grid3-hd-checker' displays a checkbox in the
          header and provides support for automatic check all/none
          behavior on header click. This string can be replaced by
          any valid HTML fragment, including a simple text string
          (e.g., 
          'Select Rows'), but the automatic check all/none
          behavior will only work if the 
          'x-grid3-hd-checker' class is supplied.
	 */
	
	public String getHeader () {
		return (String) getStateHelper().eval(PropertyKeys.header);
	}

	/**
	 * <p>
	 * Set the value of the <code>header</code> property.
	 * </p>
	 */
	public void setHeader ( String   header ) {
		getStateHelper().put(PropertyKeys.header, header);
		handleAttribute("header", header);
	}
    	/*
	 *
        
        
          sortable
         : Boolean
        
        true if the checkbox column is sortable (defaults
        to 
        false).
	 */
	
	public Boolean getSortable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.sortable);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortable</code> property.
	 * </p>
	 */
	public void setSortable ( Boolean   sortable ) {
		getStateHelper().put(PropertyKeys.sortable, sortable);
		handleAttribute("sortable", sortable);
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