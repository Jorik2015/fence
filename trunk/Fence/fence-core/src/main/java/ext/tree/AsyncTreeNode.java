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
 * 
 */

@InstanceOf("Ext.tree.AsyncTreeNode")
@ParseConfigMode(ui = false,name="root",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.tree.AsyncTreeNode")
public class AsyncTreeNode extends TreeNode {
	public static final String COMPONENT_FAMILY = "Ext.tree.AsyncTreeNode";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.AsyncTreeNode} instance with default property values.
	 * </p>
	 */
	public AsyncTreeNode() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			loader
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
        
        
          loader
         : TreeLoader
        A TreeLoader to be used by this node
        (defaults to the loader defined on the tree)
	 */
	
	public TreeLoader getLoader () {
		return (TreeLoader) getStateHelper().eval(PropertyKeys.loader);
	}

	/**
	 * <p>
	 * Set the value of the <code>loader</code> property.
	 * </p>
	 */
	public void setLoader ( TreeLoader   loader ) {
		getStateHelper().put(PropertyKeys.loader, loader);
		handleAttribute("loader", loader);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforeload"
					, "load"
				));
				return superEvent;
	}
}