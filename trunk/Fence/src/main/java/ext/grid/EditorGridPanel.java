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
 * 
  This class extends the 
  GridPanel Class to provide cell
  editing on selected 
  columns. The editable columns are
  specified by providing an 
  editor in
  the 
  column configuration.
  Editability of columns may be controlled programatically by
  inserting an implementation of 
  isCellEditable into the 
  ColumnModel.
  Editing is performed on the value of the 
  field specified by the column's 
  
    dataIndex
   in the backing 
  Store (so if you are using a 
  renderer in order to display
  transformed data, this must be accounted for).
  If a value-to-description mapping is used to render a column,
  then a 
  ComboBox which
  uses the same 
  value-to-
  description mapping would be an
  appropriate editor.If there is a more complex mismatch
  between the visible data in the grid, and the editable data in
  the 
  Store, then code to transform the
  data both before and after editing can be injected using the 
  beforeedit and 
  afteredit events.
 */
@XType("editorgrid")
@InstanceOf("Ext.grid.EditorGridPanel")

@FacesComponent(value = "Ext.grid.EditorGridPanel")
public class EditorGridPanel extends GridPanel {
	public static final String COMPONENT_FAMILY = "Ext.grid.EditorGridPanel";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.EditorGridPanel} instance with default property values.
	 * </p>
	 */
	public EditorGridPanel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			autoEncode
			,clicksToEdit
			,selModel
			,forceValidation
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
        
        
          autoEncode
         : Boolean
        True to automatically HTML encode and
        decode values pre and post edit (defaults to
        false)
	 */
	
	public Boolean getAutoEncode () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoEncode);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoEncode</code> property.
	 * </p>
	 */
	public void setAutoEncode ( Boolean   autoEncode ) {
		getStateHelper().put(PropertyKeys.autoEncode, autoEncode);
		handleAttribute("autoEncode", autoEncode);
	}
    	/*
	 *
            The number of clicks on a cell required to display
            the cell's editor (defaults to 2).
            Setting this option to 'auto' means that mousedown 
            on the selected cell starts editing that
            cell.
          
	 */
	
	public Integer getClicksToEdit () {
		return (Integer) getStateHelper().eval(PropertyKeys.clicksToEdit);
	}

	/**
	 * <p>
	 * Set the value of the <code>clicksToEdit</code> property.
	 * </p>
	 */
	public void setClicksToEdit ( Integer   clicksToEdit ) {
		getStateHelper().put(PropertyKeys.clicksToEdit, clicksToEdit);
		handleAttribute("clicksToEdit", clicksToEdit);
	}
    	/*
	 *Any subclass of AbstractSelectionModel
          that will provide the selection model for the grid
          (defaults to 
          Ext.grid.CellSelectionModel
          if not specified).
	 */
	@ClientConfig(JsonMode.Object)

	public Object getSelModel () {
		return (Object) getStateHelper().eval(PropertyKeys.selModel);
	}

	/**
	 * <p>
	 * Set the value of the <code>selModel</code> property.
	 * </p>
	 */
	public void setSelModel ( Object   selModel ) {
		getStateHelper().put(PropertyKeys.selModel, selModel);
		handleAttribute("selModel", selModel);
	}
    	/*
	 *
        
        
          forceValidation
         : Boolean
        True to force validation even if the
        value is unmodified (defaults to false)
	 */
	
	public Boolean getForceValidation () {
		return (Boolean) getStateHelper().eval(PropertyKeys.forceValidation);
	}

	/**
	 * <p>
	 * Set the value of the <code>forceValidation</code> property.
	 * </p>
	 */
	public void setForceValidation ( Boolean   forceValidation ) {
		getStateHelper().put(PropertyKeys.forceValidation, forceValidation);
		handleAttribute("forceValidation", forceValidation);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "afteredit"
					, "beforeedit"
					, "validateedit"
				));
				return superEvent;
	}
}