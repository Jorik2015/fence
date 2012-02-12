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
<div class="description">This class provides the basic
  implementation for 
  <i>single</i> 
  <b>cell</b> selection in a grid. The object stored as the
  selection contains the following properties: 
  <div class="mdetail-params">
    <ul>
      <li>
      <b>cell</b> : see 
      <a ext:cls="Ext.grid.CellSelectionModel" ext:member="getSelectedCell" href="output/Ext.grid.CellSelectionModel.html#Ext.grid.CellSelectionModel-getSelectedCell">getSelectedCell</a>
</li>
      <li>
      <b>record</b> : Ext.data.record The 
      <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a> which provides the data
      for the row containing the selection</li>
    </ul>
  </div>
</div>

 */

@InstanceOf("Ext.grid.CellSelectionModel")
@ParseConfigMode(name="selModel",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.CellSelectionModel")
public class CellSelectionModel extends AbstractSelectionModel {
	public static final String COMPONENT_FAMILY = "Ext.grid.CellSelectionModel";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.CellSelectionModel} instance with default property values.
	 * </p>
	 */
	public CellSelectionModel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
	
	    
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforecellselect"
					, "cellselect"
					, "selectionchange"
				));
				return superEvent;
	}
}