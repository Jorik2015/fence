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
 * Provides editor functionality for inline
  tree node editing. Any valid 
  Ext.form.Field subclass can be used
  as the editor field.
 */

@InstanceOf("Ext.tree.TreeEditor")

@FacesComponent(value = "Ext.tree.TreeEditor")
public class TreeEditor extends Editor {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeEditor";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreeEditor} instance with default property values.
	 * </p>
	 */
	public TreeEditor() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			maxWidth
			,shim
			,cls
			,alignment
			,editDelay
			,hideEl
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
	 *The maximum width in pixels of the
          editor field (defaults to 250). Note that if the maxWidth
          would exceed the containing tree element's size, it will
          be automatically limited for you to the container width,
          taking scroll and client offsets into account prior to
          each edit.
	 */
	
	public Integer getMaxWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxWidth</code> property.
	 * </p>
	 */
	public void setMaxWidth ( Integer   maxWidth ) {
		getStateHelper().put(PropertyKeys.maxWidth, maxWidth);
		handleAttribute("maxWidth", maxWidth);
	}
    	/*
	 *
        
        
          shim
         : Boolean
        True to shim the editor if
        selects/iframes could be displayed beneath it (defaults to
        false)
	 */
	
	public Boolean getShim () {
		return (Boolean) getStateHelper().eval(PropertyKeys.shim);
	}

	/**
	 * <p>
	 * Set the value of the <code>shim</code> property.
	 * </p>
	 */
	public void setShim ( Boolean   shim ) {
		getStateHelper().put(PropertyKeys.shim, shim);
		handleAttribute("shim", shim);
	}
    	/*
	 *
        
        
          cls
         : String
        CSS class to apply to the editor
        (defaults to "x-small-editor x-tree-editor")
	 */
	
	public String getCls () {
		return (String) getStateHelper().eval(PropertyKeys.cls);
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls ( String   cls ) {
		getStateHelper().put(PropertyKeys.cls, cls);
		handleAttribute("cls", cls);
	}
    	/*
	 *
        
        
          alignment
         : String
        The position to align to (see 
        Ext.Element.alignTo for more
        details, defaults to "l-l").
	 */
	
	public String getAlignment () {
		return (String) getStateHelper().eval(PropertyKeys.alignment);
	}

	/**
	 * <p>
	 * Set the value of the <code>alignment</code> property.
	 * </p>
	 */
	public void setAlignment ( String   alignment ) {
		getStateHelper().put(PropertyKeys.alignment, alignment);
		handleAttribute("alignment", alignment);
	}
    	/*
	 *The number of milliseconds between
          clicks to register a double-click that will trigger
          editing on the current node (defaults to 350). If two
          clicks occur on the same node within this time span, the
          editor for the node will display, otherwise it will be
          processed as a regular click.
	 */
	
	public Integer getEditDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.editDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>editDelay</code> property.
	 * </p>
	 */
	public void setEditDelay ( Integer   editDelay ) {
		getStateHelper().put(PropertyKeys.editDelay, editDelay);
		handleAttribute("editDelay", editDelay);
	}
    	/*
	 *
        
        
          hideEl
         : Boolean
        True to hide the bound element while the
        editor is displayed (defaults to false)
	 */
	
	public Boolean getHideEl () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideEl);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideEl</code> property.
	 * </p>
	 */
	public void setHideEl ( Boolean   hideEl ) {
		getStateHelper().put(PropertyKeys.hideEl, hideEl);
		handleAttribute("hideEl", hideEl);
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