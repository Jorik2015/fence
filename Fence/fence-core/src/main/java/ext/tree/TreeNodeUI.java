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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">This class provides the default UI
  implementation for Ext TreeNodes. The TreeNode UI implementation
  is separate from the tree implementation, and allows customizing
  of the appearance of tree nodes.
  <br/>
  <p>If you are customizing the Tree's user interface, you may need
  to extend this class, but you should never need to instantiate
  this class.
  <br/>
</p>
  <p>This class provides access to the user interface components of
  an Ext TreeNode, through 
  <a ext:cls="Ext.tree.TreeNode" ext:member="getUI" href="output/Ext.tree.TreeNode.html#Ext.tree.TreeNode-getUI">Ext.tree.TreeNode.getUI</a>
</p>
</div>

 */

@InstanceOf("Ext.tree.TreeNodeUI")

@FacesComponent(value = "Ext.tree.TreeNodeUI")
public class TreeNodeUI extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeNodeUI";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreeNodeUI} instance with default property values.
	 * </p>
	 */
	public TreeNodeUI() {
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