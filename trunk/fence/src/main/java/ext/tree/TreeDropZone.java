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

@InstanceOf("Ext.tree.TreeDropZone")

@FacesComponent(value = "Ext.tree.TreeDropZone")
public class TreeDropZone extends DropZone {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeDropZone";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreeDropZone} instance with default property values.
	 * </p>
	 */
	public TreeDropZone() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			appendOnly
			,expandDelay
			,allowParentInsert
			,allowContainerDrop
			,ddGroup
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
        
        
          appendOnly
         : String
        True if the tree should only allow
        append drops (use for trees which are sorted, defaults to
        false)
	 */
	
	public String getAppendOnly () {
		return (String) getStateHelper().eval(PropertyKeys.appendOnly);
	}

	/**
	 * <p>
	 * Set the value of the <code>appendOnly</code> property.
	 * </p>
	 */
	public void setAppendOnly ( String   appendOnly ) {
		getStateHelper().put(PropertyKeys.appendOnly, appendOnly);
		handleAttribute("appendOnly", appendOnly);
	}
    	/*
	 *The delay in milliseconds to wait
          before expanding a target tree node while dragging a
          droppable node over the target (defaults to 1000)
	 */
	
	public String getExpandDelay () {
		return (String) getStateHelper().eval(PropertyKeys.expandDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>expandDelay</code> property.
	 * </p>
	 */
	public void setExpandDelay ( String   expandDelay ) {
		getStateHelper().put(PropertyKeys.expandDelay, expandDelay);
		handleAttribute("expandDelay", expandDelay);
	}
    	/*
	 *Allow inserting a dragged node between
          an expanded parent node and its first child that will
          become a sibling of the parent when dropped (defaults to
          false)
	 */
	
	public Boolean getAllowParentInsert () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowParentInsert);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowParentInsert</code> property.
	 * </p>
	 */
	public void setAllowParentInsert ( Boolean   allowParentInsert ) {
		getStateHelper().put(PropertyKeys.allowParentInsert, allowParentInsert);
		handleAttribute("allowParentInsert", allowParentInsert);
	}
    	/*
	 *
        
        
          allowContainerDrop
         : String
        True if drops on the tree container
        (outside of a specific tree node) are allowed (defaults to
        false)
	 */
	
	public String getAllowContainerDrop () {
		return (String) getStateHelper().eval(PropertyKeys.allowContainerDrop);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowContainerDrop</code> property.
	 * </p>
	 */
	public void setAllowContainerDrop ( String   allowContainerDrop ) {
		getStateHelper().put(PropertyKeys.allowContainerDrop, allowContainerDrop);
		handleAttribute("allowContainerDrop", allowContainerDrop);
	}
    	/*
	 *A named drag drop group to which this
          object belongs. If a group is specified, then this object
          will only interact with other drag drop objects in the
          same group (defaults to 'TreeDD').
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