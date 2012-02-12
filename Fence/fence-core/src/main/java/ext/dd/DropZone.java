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
  dropping on multiple child target nodes.</p>
  <p>By default, this class requires that child nodes accepting
  drop are registered with 
  <a ext:cls="Ext.dd.Registry" href="output/Ext.dd.Registry.html">Ext.dd.Registry</a>. However a simpler
  way to allow a DropZone to manage any number of target elements
  is to configure the DropZone with an implementation of 
  <a ext:cls="Ext.dd.DropZone" ext:member="getTargetFromEvent" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-getTargetFromEvent">getTargetFromEvent</a> which
  interrogates the passed mouse event to see if it has taken place
  within an element, or class of elements. This is easily done by
  using the event's 
  <a ext:cls="Ext.EventObject" ext:member="getTarget" href="output/Ext.EventObject.html#Ext.EventObject-getTarget">getTarget</a>
  method to identify a node based on a 
  <a ext:cls="Ext.DomQuery" href="output/Ext.DomQuery.html">Ext.DomQuery</a> selector.</p>
  <p>Once the DropZone has detected through calling
  getTargetFromEvent, that the mouse is over a drop target, that
  target is passed as the first parameter to 
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeEnter" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeEnter">onNodeEnter</a>, 
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeOver" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOver">onNodeOver</a>,
  
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeOut" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOut">onNodeOut</a>, 
  <a ext:cls="Ext.dd.DropZone" ext:member="onNodeDrop" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeDrop">onNodeDrop</a>.
  You may configure the instance of DropZone with implementations
  of these methods to provide application-specific behaviour for
  these events to update both application state, and UI state.</p>
  <p>For example to make a GridPanel a cooperating target with the
  example illustrated in 
  <a ext:cls="Ext.dd.DragZone" href="output/Ext.dd.DragZone.html">DragZone</a>, the following technique
  might be used:</p>
<pre>
<code>myGridPanel.on(
<em>'render'</em>, 
<b>function</b>() {
    myGridPanel.dropZone = 
<b>new</b> Ext.dd.DropZone(myGridPanel.getView().scroller, {

<i>//      If the mouse is over a grid row, 
<b>return</b> that node. This is</i>
<i>//      provided as the 
<em>"target"</em> parameter 
<b>in</b> all 
<em>"onNodeXXXX"</em> node event handling functions</i>
        getTargetFromEvent: 
<b>function</b>(e) {
            
<b>return</b> e.getTarget(myGridPanel.getView().rowSelector);
        },

<i>//      On entry into a target node, highlight that node.</i>
        onNodeEnter : 
<b>function</b>(target, dd, e, data){ 
            Ext.fly(target).addClass(
<em>'my-row-highlight-class'</em>);
        },

<i>//      On exit from a target node, unhighlight that node.</i>
        onNodeOut : 
<b>function</b>(target, dd, e, data){ 
            Ext.fly(target).removeClass(
<em>'my-row-highlight-class'</em>);
        },

<i>//      While over a target node, 
<b>return</b> the 
<b>default</b> drop allowed class which</i>
<i>//      places a 
<em>"tick"</em> icon into the drag proxy.</i>
        onNodeOver : 
<b>function</b>(target, dd, e, data){ 
            
<b>return</b> Ext.dd.DropZone.prototype.dropAllowed;
        },

<i>//      On node drop we can interrogate the target to find the
underlying</i>
<i>//      application object that is the real target of the
dragged data.</i>
<i>//      In this 
<b>case</b>, it is a Record 
<b>in</b> the GridPanel
<em>'s Store.</em>
</i>//      We can use the data set up by the DragZone'</code>s
getDragData method to read
<i>//      any data we decided to attach 
<b>in</b> the DragZone
<em>'s getDragData method.</em>
        onNodeDrop : 
<b>function</b>(target, dd, e, data){
            
<b>var</b> rowIndex = myGridPanel.getView().findRowIndex(target);
            
<b>var</b> r = myGridPanel.getStore().getAt(rowIndex);
            Ext.Msg.alert('</i>Drop gesture
<em>', '</em>Dropped Record id 
<em>' + data.draggedRecord.id +
                '</em> on Record id 
<em>' + r.id);
            
<b>return</b> true;
        }
    });
}</em>
  </pre>See the 
  <a ext:cls="Ext.dd.DragZone" href="output/Ext.dd.DragZone.html">DragZone</a> documentation for details
  about building a DragZone which cooperates with this
  DropZone.</div>

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