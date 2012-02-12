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
<div class="description">Defines the interface and base operation
  of items that that can be dragged or can be drop targets. It was
  designed to be extended, overriding the event handlers for
  startDrag, onDrag, onDragOver and onDragOut. Up to three html
  elements can be associated with a DragDrop instance: 
  <ul>
    <li>linked element: the element that is passed into the
    constructor. This is the element which defines the boundaries
    for interaction with other DragDrop objects.</li>
    <li>handle element(s): The drag operation only occurs if the
    element that was clicked matches a handle element. By default
    this is the linked element, but there are times that you will
    want only a portion of the linked element to initiate the drag
    operation, and the setHandleElId() method provides a way to
    define this.</li>
    <li>drag element: this represents the element that would be
    moved along with the cursor during a drag operation. By
    default, this is the linked element itself as in 
    <a ext:cls="Ext.dd.DD" href="output/Ext.dd.DD.html">Ext.dd.DD</a>. setDragElId() lets you
    define a separate element that would be moved, as in 
    <a ext:cls="Ext.dd.DDProxy" href="output/Ext.dd.DDProxy.html">Ext.dd.DDProxy</a>.</li>
  </ul>This class should not be instantiated until the onload event
  to ensure that the associated elements are available. The
  following would define a DragDrop obj that would interact with
  any other DragDrop obj in the "group1" group: 
<pre>
dd = new Ext.dd.DragDrop("div1", "group1");
  </pre>Since none of the event handlers have been implemented,
  nothing would actually happen if you were to run the code above.
  Normally you would override this class or one of the default
  implementations, but you can also override the methods you want
  on an instance of the class... 
<pre>
dd.onDragDrop = function(e, id) {
  alert("dd was dropped on " + id);
}
  </pre>
</div>

 */

@InstanceOf("Ext.dd.DragDrop")

@FacesComponent(value = "Ext.dd.DragDrop")
public class DragDrop extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.dd.DragDrop";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.DragDrop} instance with default property values.
	 * </p>
	 */
	public DragDrop() {
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