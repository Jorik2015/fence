package ext.tree;

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
 * ${ext.commonts}
 */

@InstanceOf("Ext.tree.TreeDragZone")

@FacesComponent(value = "Ext.tree.TreeDragZone")
public class TreeDragZone extends DragZone {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeDragZone";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreeDragZone} instance with default property values.
	 * </p>
	 */
	public TreeDragZone() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			ddGroup
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
<div class="long">A named drag drop group to which this
          object belongs. If a group is specified, then this object
          will only interact with other drag drop objects in the
          same group (defaults to 'TreeDD').</div>

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