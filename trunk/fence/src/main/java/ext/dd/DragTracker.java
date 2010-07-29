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
 * A DragTracker listens for drag events on
  an Element and fires events at the start and end of the drag, as
  well as during the drag. This is useful for components such as 
  Ext.Slider, where there is an element
  that can be dragged around to change the Slider's value.
  DragTracker provides a series of template methods that should be
  overridden to provide functionality in response to detected drag
  operations. These are onBeforeStart, onStart, onDrag and onEnd.
  See 
  Ext.Slider's initEvents function for an
  example implementation.
 */

@InstanceOf("Ext.dd.DragTracker")

@FacesComponent(value = "Ext.dd.DragTracker")
public class DragTracker extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.dd.DragTracker";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.DragTracker} instance with default property values.
	 * </p>
	 */
	public DragTracker() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			active
			,tolerance
			,autoStart
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
        
        
          active
         : Boolean
        Defaults to 
        false.
	 */
	
	public Boolean getActive () {
		return (Boolean) getStateHelper().eval(PropertyKeys.active);
	}

	/**
	 * <p>
	 * Set the value of the <code>active</code> property.
	 * </p>
	 */
	public void setActive ( Boolean   active ) {
		getStateHelper().put(PropertyKeys.active, active);
		handleAttribute("active", active);
	}
    	/*
	 *
        
        
          tolerance
         : Number
        Number of pixels the drag target must be
        moved before dragging is considered to have started.
        Defaults to 
        5.
	 */
	
	public Integer getTolerance () {
		return (Integer) getStateHelper().eval(PropertyKeys.tolerance);
	}

	/**
	 * <p>
	 * Set the value of the <code>tolerance</code> property.
	 * </p>
	 */
	public void setTolerance ( Integer   tolerance ) {
		getStateHelper().put(PropertyKeys.tolerance, tolerance);
		handleAttribute("tolerance", tolerance);
	}
    	/*
	 *Defaults to 
          false. Specify 
          true to defer trigger start by 1000 ms. Specify
          a Number for the number of milliseconds to defer trigger
          start.
	 */
	
	public Boolean getAutoStart () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoStart);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoStart</code> property.
	 * </p>
	 */
	public void setAutoStart ( Boolean   autoStart ) {
		getStateHelper().put(PropertyKeys.autoStart, autoStart);
		handleAttribute("autoStart", autoStart);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "drag"
					, "dragend"
					, "dragstart"
					, "mousedown"
					, "mousemove"
					, "mouseup"
				));
				return superEvent;
	}
}