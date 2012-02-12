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
<div class="description">Multi selection for a TreePanel.</div>

 */

@InstanceOf("Ext.tree.MultiSelectionModel")
@ParseConfigMode(name="selModel",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.tree.MultiSelectionModel")
public class MultiSelectionModel extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.tree.MultiSelectionModel";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.MultiSelectionModel} instance with default property values.
	 * </p>
	 */
	public MultiSelectionModel() {
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
				superEvent.addAll(Arrays.asList(
					 "selectionchange"
				));
				return superEvent;
	}
}