package ext.dd;

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
<div class="description">A DragDrop implementation that does not
  move, but can be a drop target. You would get the same result by
  simply omitting implementation for the event callbacks, but this
  way we reduce the processing cost of the event listener and the
  callbacks.</div>

 */

@InstanceOf("Ext.dd.DDTarget")

@FacesComponent(value = "Ext.dd.DDTarget")
public class DDTarget extends DragDrop {
	public static final String COMPONENT_FAMILY = "Ext.dd.DDTarget";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.DDTarget} instance with default property values.
	 * </p>
	 */
	public DDTarget() {
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