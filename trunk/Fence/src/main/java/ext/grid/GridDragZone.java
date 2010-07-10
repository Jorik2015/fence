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
  A customized implementation of a 
  DragZone which provides default
  implementations of two of the template methods of DragZone to
  enable dragging of the selected rows of a GridPanel.
  A cooperating 
  DropZone must be created who's
  template method implementations of 
  onNodeEnter, 
  onNodeOver,
  
  onNodeOut
  and 
  onNodeDropare able to process
  the 
  data which is provided.
 */

@InstanceOf("Ext.grid.GridDragZone")

@FacesComponent(value = "Ext.grid.GridDragZone")
public class GridDragZone extends DragZone {
	public static final String COMPONENT_FAMILY = "Ext.grid.GridDragZone";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.GridDragZone} instance with default property values.
	 * </p>
	 */
	public GridDragZone() {
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
				return superEvent;
	}
}