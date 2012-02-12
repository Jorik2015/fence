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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">Represents a tree data structure and
  bubbles all the events for its nodes. The nodes in the tree have
  most standard DOM functionality.</div>

 */

@InstanceOf("Ext.data.Tree")

@FacesComponent(value = "Ext.data.Tree")
public class Tree extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.data.Tree";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Tree} instance with default property values.
	 * </p>
	 */
	public Tree() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			pathSeparator
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
        
        
          pathSeparator
         : String
        The token used to separate paths in node
        ids (defaults to '/').
	 */
	
	public String getPathSeparator () {
		return (String) getStateHelper().eval(PropertyKeys.pathSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>pathSeparator</code> property.
	 * </p>
	 */
	public void setPathSeparator ( String   pathSeparator ) {
		getStateHelper().put(PropertyKeys.pathSeparator, pathSeparator);
		handleAttribute("pathSeparator", pathSeparator);
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