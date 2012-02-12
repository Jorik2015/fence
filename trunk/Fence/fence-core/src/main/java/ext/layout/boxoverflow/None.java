package ext.layout.boxoverflow;

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
<div class="description">Base class for Box Layout overflow
  handlers. These specialized classes are invoked when a Box Layout
  (either an HBox or a VBox) has child items that are either too
  wide (for HBox) or too tall (for VBox) for its container.</div>

 */

@InstanceOf("Ext.layout.boxOverflow.None")

@FacesComponent(value = "Ext.layout.boxOverflow.None")
public class None extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.layout.boxOverflow.None";

	/**
	 * <p>
	 * Create a new {@link Ext.layout.boxOverflow.None} instance with default property values.
	 * </p>
	 */
	public None() {
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