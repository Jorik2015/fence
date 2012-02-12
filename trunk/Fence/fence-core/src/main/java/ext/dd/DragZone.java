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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
  <p>This class provides a container DD instance that allows
  dragging of multiple child source nodes.</p>
  <p>This class does not move the drag target nodes, but a proxy
  element which may contain any DOM structure you wish. The DOM
  element to show in the proxy is provided by either a provided
  implementation of 
  <a ext:cls="Ext.dd.DragZone" ext:member="getDragData" href="output/Ext.dd.DragZone.html#Ext.dd.DragZone-getDragData">getDragData</a>, or by registered
  draggables registered with 
  <a ext:cls="Ext.dd.Registry" href="output/Ext.dd.Registry.html">Ext.dd.Registry</a>
</p>
  <p>If you wish to provide draggability for an arbitrary number of
  DOM nodes, each of which represent some application object (For
  example nodes in a 
  <a ext:cls="Ext.DataView" href="output/Ext.DataView.html">DataView</a>) then use of this class is
  the most efficient way to "activate" those nodes.</p>
  <p>By default, this class requires that draggable child nodes are
  registered with 
  <a ext:cls="Ext.dd.Registry" href="output/Ext.dd.Registry.html">Ext.dd.Registry</a>. However a simpler
  way to allow a DragZone to manage any number of draggable
  elements is to configure the DragZone with an implementation of
  the 
  <a ext:cls="Ext.dd.DragZone" ext:member="getDragData" href="output/Ext.dd.DragZone.html#Ext.dd.DragZone-getDragData">getDragData</a> method which
  interrogates the passed mouse event to see if it has taken place
  within an element, or class of elements. This is easily done by
  using the event's 
  <a ext:cls="Ext.EventObject" ext:member="getTarget" href="output/Ext.EventObject.html#Ext.EventObject-getTarget">getTarget</a>
  method to identify a node based on a 
  <a ext:cls="Ext.DomQuery" href="output/Ext.DomQuery.html">Ext.DomQuery</a> selector. For example, to
  make the nodes of a DataView draggable, use the following
  technique. Knowledge of the use of the DataView is required:</p>
<pre>
<code>myDataView.on(
<em>'render'</em>, 
<b>function</b>(v) {
    myDataView.dragZone = 
<b>new</b> Ext.dd.DragZone(v.getEl(), {

<i>//      On receipt of a mousedown event, see 
<b>if</b> it is within a DataView node.</i>
<i>//      Return a drag data object 
<b>if</b> so.</i>
        getDragData: 
<b>function</b>(e) {

<i>//          Use the DataView
<em>'s own itemSelector (a mandatory property) to</em>
</i>//          test 
<b>if</b> the mousedown is within one of the DataView'</code>s
nodes.
            
<b>var</b> sourceEl = e.getTarget(v.itemSelector, 10);

<i>//          If the mousedown is within a DataView node, clone
the node to produce</i>
<i>//          a ddel element 
<b>for</b> use by the drag proxy. Also add application data</i>
<i>//          to the returned data object.</i>
            
<b>if</b> (sourceEl) {
                d = sourceEl.cloneNode(true);
                d.id = Ext.id();
                
<b>return</b> {
                    ddel: d,
                    sourceEl: sourceEl,
                    repairXY: Ext.fly(sourceEl).getXY(),
                    sourceStore: v.store,
                    draggedRecord: v.
<a ext:cls="Ext.DataView" ext:member="getRecord" href="output/Ext.DataView.html#Ext.DataView-getRecord">getRecord</a>(sourceEl)
                }
            }
        },

<i>//      Provide coordinates 
<b>for</b> the proxy to slide back to on failed drag.</i>
<i>//      This is the original XY coordinates of the draggable
element captured</i>
<i>//      
<b>in</b> the getDragData method.</i>
        getRepairXY: 
<b>function</b>() {
            
<b>return</b> this.dragData.repairXY;
        }
    });
});
  </pre>See the 
  <a ext:cls="Ext.dd.DropZone" href="output/Ext.dd.DropZone.html">DropZone</a> documentation for details
  about building a DropZone which cooperates with this
  DragZone.</div>

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
			hlColor
			,containerScroll
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
<div class="long">The color to use when visually
          highlighting the drag source in the afterRepair method
          after a failed drop (defaults to "c3daf9" - light
          blue)</div>

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