package ext.data;

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

@InstanceOf("Ext.data.Node")

@FacesComponent(value = "Ext.data.Node")
public class Node extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.data.Node";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Node} instance with default property values.
	 * </p>
	 */
	public Node() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			leaf
			,childs
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
        
        
          leaf
         : Boolean
        true if this node is a leaf and does not
        have children
	 */
	
	public Boolean getLeaf () {
		return (Boolean) getStateHelper().eval(PropertyKeys.leaf);
	}

	/**
	 * <p>
	 * Set the value of the <code>leaf</code> property.
	 * </p>
	 */
	public void setLeaf ( Boolean   leaf ) {
		getStateHelper().put(PropertyKeys.leaf, leaf);
		handleAttribute("leaf", leaf);
	}
    	/*
	 *$cfg.commonts
	 */
	@ClientConfig(value = JsonMode.Array, name = "children")
	public Object getChilds () {
		return (Object) getStateHelper().eval(PropertyKeys.childs);
	}

	/**
	 * <p>
	 * Set the value of the <code>childs</code> property.
	 * </p>
	 */
	public void setChilds ( Object   childs ) {
		getStateHelper().put(PropertyKeys.childs, childs);
		handleAttribute("childs", childs);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "append"
					, "beforeappend"
					, "beforeinsert"
					, "beforemove"
					, "beforeremove"
					, "insert"
					, "move"
					, "remove"
				));
				return superEvent;
	}
}