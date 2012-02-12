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
  <p>This class extends the 
  <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">GridPanel Class</a> to provide cell
  editing on selected 
  <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">columns</a>. The editable columns are
  specified by providing an 
  <a ext:cls="Ext.grid.ColumnModel" ext:member="editor" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-editor">editor</a> in
  the 
  <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">column configuration</a>.</p>
  <p>Editability of columns may be controlled programatically by
  inserting an implementation of 
  <a ext:cls="Ext.grid.ColumnModel" ext:member="isCellEditable" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-isCellEditable">isCellEditable</a> into the 
  <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">ColumnModel</a>.</p>
  <p>Editing is performed on the value of the 
  <i>field</i> specified by the column's 
  <tt>
    <a ext:cls="Ext.grid.ColumnModel" ext:member="dataIndex" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-dataIndex">dataIndex</a>
  </tt> in the backing 
  <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a> (so if you are using a 
  <a ext:cls="Ext.grid.ColumnModel" ext:member="setRenderer" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-setRenderer">renderer</a> in order to display
  transformed data, this must be accounted for).</p>
  <p>If a value-to-description mapping is used to render a column,
  then a 
  <a ext:cls="Ext.form.Field" ext:member="ComboBox" href="output/Ext.form.Field.html#Ext.form.Field-ComboBox">ComboBox</a> which
  uses the same 
  <a ext:cls="Ext.form.Field" ext:member="valueField" href="output/Ext.form.Field.html#Ext.form.Field-valueField">value</a>-to-
  <a ext:cls="Ext.form.Field" ext:member="displayFieldField" href="output/Ext.form.Field.html#Ext.form.Field-displayFieldField">description</a> mapping would be an
  appropriate editor.</p>If there is a more complex mismatch
  between the visible data in the grid, and the editable data in
  the 
  <a ext:cls="Edt.data.Store" href="output/Edt.data.Store.html">Store</a>, then code to transform the
  data both before and after editing can be injected using the 
  <a ext:cls="Ext.grid.EditorGridPanel" ext:member="beforeedit" href="output/Ext.grid.EditorGridPanel.html#Ext.grid.EditorGridPanel-beforeedit">beforeedit</a> and 
  <a ext:cls="Ext.grid.EditorGridPanel" ext:member="afteredit" href="output/Ext.grid.EditorGridPanel.html#Ext.grid.EditorGridPanel-afteredit">afteredit</a> events.</div>

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
			clicksToEdit
			,autoEncode
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The number of clicks on a cell required to display
            the cell's editor (defaults to 2).</p>
            <p>Setting this option to 'auto' means that mousedown 
            <i>on the selected cell</i> starts editing that
            cell.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Any subclass of AbstractSelectionModel
          that will provide the selection model for the grid
          (defaults to 
          <a ext:cls="Ext.grid.CellSelectionModel" href="output/Ext.grid.CellSelectionModel.html">Ext.grid.CellSelectionModel</a>
          if not specified).</div>

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