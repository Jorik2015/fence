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
  dragging of multiple child source nodes.
  This class does not move the drag target nodes, but a proxy
  element which may contain any DOM structure you wish. The DOM
  element to show in the proxy is provided by either a provided
  implementation of 
  getDragData, or by registered
  draggables registered with 
  Ext.dd.Registry
  If you wish to provide draggability for an arbitrary number of
  DOM nodes, each of which represent some application object (For
  example nodes in a 
  DataView) then use of this class is
  the most efficient way to "activate" those nodes.
  By default, this class requires that draggable child nodes are
  registered with 
  Ext.dd.Registry. However a simpler
  way to allow a DragZone to manage any number of draggable
  elements is to configure the DragZone with an implementation of
  the 
  getDragData method which
  interrogates the passed mouse event to see if it has taken place
  within an element, or class of elements. This is easily done by
  using the event's 
  getTarget
  method to identify a node based on a 
  Ext.DomQuery selector. For example, to
  make the nodes of a DataView draggable, use the following
  technique. Knowledge of the use of the DataView is required:

myDataView.on(
'render', 
function(v) {
    myDataView.dragZone = 
new Ext.dd.DragZone(v.getEl(), {

//      On receipt of a mousedown event, see 
if it is within a DataView node.
//      Return a drag data object 
if so.
        getDragData: 
function(e) {

//          Use the DataView
's own itemSelector (a mandatory property) to
//          test 
if the mousedown is within one of the DataView's
nodes.
            
var sourceEl = e.getTarget(v.itemSelector, 10);

//          If the mousedown is within a DataView node, clone
the node to produce
//          a ddel element 
for use by the drag proxy. Also add application data
//          to the returned data object.
            
if (sourceEl) {
                d = sourceEl.cloneNode(true);
                d.id = Ext.id();
                
return {
                    ddel: d,
                    sourceEl: sourceEl,
                    repairXY: Ext.fly(sourceEl).getXY(),
                    sourceStore: v.store,
                    draggedRecord: v.
getRecord(sourceEl)
                }
            }
        },

//      Provide coordinates 
for the proxy to slide back to on failed drag.
//      This is the original XY coordinates of the draggable
element captured
//      
in the getDragData method.
        getRepairXY: 
function() {
            
return this.dragData.repairXY;
        }
    });
});
  See the 
  DropZone documentation for details
  about building a DropZone which cooperates with this
  DragZone.
 */

@InstanceOf("Ext.dd.DragZone")

@FacesComponent(value = "Ext.dd.DragZone")
public class DragZone extends DragSource {
	public static final String COMPONENT_FAMILY = "Ext.dd.DragZone";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.DragZone} instance with default property values.
	 * </p>
	 */
	public DragZone() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			containerScroll
			,hlColor
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
        
        
          containerScroll
         : Boolean
        True to register this container with the
        Scrollmanager for auto scrolling during drag
        operations.
	 */
	
	public Boolean getContainerScroll () {
		return (Boolean) getStateHelper().eval(PropertyKeys.containerScroll);
	}

	/**
	 * <p>
	 * Set the value of the <code>containerScroll</code> property.
	 * </p>
	 */
	public void setContainerScroll ( Boolean   containerScroll ) {
		getStateHelper().put(PropertyKeys.containerScroll, containerScroll);
		handleAttribute("containerScroll", containerScroll);
	}
    	/*
	 *The color to use when visually
          highlighting the drag source in the afterRepair method
          after a failed drop (defaults to "c3daf9" - light
          blue)
	 */
	
	public String getHlColor () {
		return (String) getStateHelper().eval(PropertyKeys.hlColor);
	}

	/**
	 * <p>
	 * Set the value of the <code>hlColor</code> property.
	 * </p>
	 */
	public void setHlColor ( String   hlColor ) {
		getStateHelper().put(PropertyKeys.hlColor, hlColor);
		handleAttribute("hlColor", hlColor);
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