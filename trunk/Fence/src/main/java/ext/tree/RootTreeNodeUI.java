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
 * This class provides the default UI
  implementation for 
  root Ext TreeNodes. The RootTreeNode UI implementation
  allows customizing the appearance of the root tree node.
  
  If you are customizing the Tree's user interface, you may need
  to extend this class, but you should never need to instantiate
  this class.
  
 */

@InstanceOf("Ext.tree.RootTreeNodeUI")

@FacesComponent(value = "Ext.tree.RootTreeNodeUI")
public class RootTreeNodeUI extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.tree.RootTreeNodeUI";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.RootTreeNodeUI} instance with default property values.
	 * </p>
	 */
	public RootTreeNodeUI() {
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