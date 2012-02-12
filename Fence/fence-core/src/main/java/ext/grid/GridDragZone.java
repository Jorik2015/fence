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
  <p>A customized implementation of a 
  <a ext:cls="Ext.dd.DragZone" href="output/Ext.dd.DragZone.html">DragZone</a> which provides default
  implementations of two of the template methods of DragZone to
  enable dragging of the selected rows of a GridPanel.</p>
  <p>A cooperating 
  <a ext:cls="Ext.dd.DropZone" href="output/Ext.dd.DropZone.html">DropZone</a> must be created who's
  template method implementations of 
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeEnter" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeEnter">onNodeEnter</a>, 
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeOver" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOver">onNodeOver</a>,
  
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeOut" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOut">onNodeOut</a>
  and 
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeDrop" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeDrop">onNodeDrop</a>
</p>are able to process
  the 
  <a ext:cls="Ext.grid.GridDragZone" ext:member="getDragData" href="output/Ext.grid.GridDragZone.html#Ext.grid.GridDragZone-getDragData">data</a> which is provided.</div>

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