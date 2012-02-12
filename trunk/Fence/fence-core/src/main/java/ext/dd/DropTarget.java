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
<div class="description">A simple class that provides the basic
  implementation needed to make any element a drop target that can
  have draggable items dropped onto it. The drop has no effect
  until an implementation of notifyDrop is provided.</div>

 */

@InstanceOf("Ext.dd.DropTarget")

@FacesComponent(value = "Ext.dd.DropTarget")
public class DropTarget extends DDTarget {
	public static final String COMPONENT_FAMILY = "Ext.dd.DropTarget";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.DropTarget} instance with default property values.
	 * </p>
	 */
	public DropTarget() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			overClass
			,ddGroup
			,dropNotAllowed
			,dropAllowed
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
        
        
          overClass
         : String
        The CSS class applied to the drop target
        element while the drag source is over it (defaults to
        "").
	 */
	
	public String getOverClass () {
		return (String) getStateHelper().eval(PropertyKeys.overClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>overClass</code> property.
	 * </p>
	 */
	public void setOverClass ( String   overClass ) {
		getStateHelper().put(PropertyKeys.overClass, overClass);
		handleAttribute("overClass", overClass);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A named drag drop group to which this
          object belongs. If a group is specified, then this object
          will only interact with other drag drop objects in the
          same group (defaults to undefined).</div>

	 */
	
	public String getDdGroup () {
		return (String) getStateHelper().eval(PropertyKeys.ddGroup);
	}

	/**
	 * <p>
	 * Set the value of the <code>ddGroup</code> property.
	 * </p>
	 */
	public void setDdGroup ( String   ddGroup ) {
		getStateHelper().put(PropertyKeys.ddGroup, ddGroup);
		handleAttribute("ddGroup", ddGroup);
	}
    	/*
	 *
        
        
          dropNotAllowed
         : String
        The CSS class returned to the drag
        source when drop is not allowed (defaults to
        "x-dd-drop-nodrop").
	 */
	
	public String getDropNotAllowed () {
		return (String) getStateHelper().eval(PropertyKeys.dropNotAllowed);
	}

	/**
	 * <p>
	 * Set the value of the <code>dropNotAllowed</code> property.
	 * </p>
	 */
	public void setDropNotAllowed ( String   dropNotAllowed ) {
		getStateHelper().put(PropertyKeys.dropNotAllowed, dropNotAllowed);
		handleAttribute("dropNotAllowed", dropNotAllowed);
	}
    	/*
	 *
        
        
          dropAllowed
         : String
        The CSS class returned to the drag
        source when drop is allowed (defaults to
        "x-dd-drop-ok").
	 */
	
	public String getDropAllowed () {
		return (String) getStateHelper().eval(PropertyKeys.dropAllowed);
	}

	/**
	 * <p>
	 * Set the value of the <code>dropAllowed</code> property.
	 * </p>
	 */
	public void setDropAllowed ( String   dropAllowed ) {
		getStateHelper().put(PropertyKeys.dropAllowed, dropAllowed);
		handleAttribute("dropAllowed", dropAllowed);
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