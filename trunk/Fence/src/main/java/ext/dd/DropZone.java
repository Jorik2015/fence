package ext.dd;

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
  This class provides a container DD instance that allows
  dropping on multiple child target nodes.
  By default, this class requires that child nodes accepting
  drop are registered with 
  Ext.dd.Registry. However a simpler
  way to allow a DropZone to manage any number of target elements
  is to configure the DropZone with an implementation of 
  getTargetFromEvent which
  interrogates the passed mouse event to see if it has taken place
  within an element, or class of elements. This is easily done by
  using the event's 
  getTarget
  method to identify a node based on a 
  Ext.DomQuery selector.
  Once the DropZone has detected through calling
  getTargetFromEvent, that the mouse is over a drop target, that
  target is passed as the first parameter to 
  onNodeEnter, 
  onNodeOver,
  
  onNodeOut, 
  onNodeDrop.
  You may configure the instance of DropZone with implementations
  of these methods to provide application-specific behaviour for
  these events to update both application state, and UI state.
  For example to make a GridPanel a cooperating target with the
  example illustrated in 
  DragZone, the following technique
  might be used:

myGridPanel.on(
'render', 
function() {
    myGridPanel.dropZone = 
new Ext.dd.DropZone(myGridPanel.getView().scroller, {

//      If the mouse is over a grid row, 
return that node. This is

//      provided as the 
"target" parameter 
in all 
"onNodeXXXX" node event handling functions

        getTargetFromEvent: 
function(e) {
            
return e.getTarget(myGridPanel.getView().rowSelector);
        },

//      On entry into a target node, highlight that node.

        onNodeEnter : 
function(target, dd, e, data){ 
            Ext.fly(target).addClass(
'my-row-highlight-class');
        },

//      On exit from a target node, unhighlight that node.

        onNodeOut : 
function(target, dd, e, data){ 
            Ext.fly(target).removeClass(
'my-row-highlight-class');
        },

//      While over a target node, 
return the 
default drop allowed class which

//      places a 
"tick" icon into the drag proxy.

        onNodeOver : 
function(target, dd, e, data){ 
            
return Ext.dd.DropZone.prototype.dropAllowed;
        },

//      On node drop we can interrogate the target to find the
underlying

//      application object that is the real target of the
dragged data.

//      In this 
case, it is a Record 
in the GridPanel
's Store.

//      We can use the data set up by the DragZone's
getDragData method to read

//      any data we decided to attach 
in the DragZone
's getDragData method.

        onNodeDrop : 
function(target, dd, e, data){
            
var rowIndex = myGridPanel.getView().findRowIndex(target);
            
var r = myGridPanel.getStore().getAt(rowIndex);
            Ext.Msg.alert('Drop gesture
', 'Dropped Record id 
' + data.draggedRecord.id +
                ' on Record id 
' + r.id);
            
return true;
        }
    });
}
  See the 
  DragZone documentation for details
  about building a DragZone which cooperates with this
  DropZone.
 */

@InstanceOf("Ext.dd.DropZone")

@FacesComponent(value = "Ext.dd.DropZone")
public class DropZone extends DropTarget {
	public static final String COMPONENT_FAMILY = "Ext.dd.DropZone";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.DropZone} instance with default property values.
	 * </p>
	 */
	public DropZone() {
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