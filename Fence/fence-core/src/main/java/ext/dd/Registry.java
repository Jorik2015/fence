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
<div class="description">Provides easy access to all drag drop
  components that are registered on a page. Items can be retrieved
  either directly by DOM node id, or by passing in the drag drop
  event that occurred and looking up the event target.
  <br/>
  <br/>
  <i>This class is a singleton and cannot be created
  directly.</i>
</div>

 */

@InstanceOf("Ext.dd.Registry")

@FacesComponent(value = "Ext.dd.Registry")
public class Registry extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.dd.Registry";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.Registry} instance with default property values.
	 * </p>
	 */
	public Registry() {
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