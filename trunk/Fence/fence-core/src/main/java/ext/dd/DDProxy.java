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
<div class="description">A DragDrop implementation that inserts
  an empty, bordered div into the document that follows the cursor
  during drag operations. At the time of the click, the frame div
  is resized to the dimensions of the linked html element, and
  moved to the exact location of the linked element. References to
  the "frame" element refer to the single proxy element that was
  created to be dragged in place of all DDProxy elements on the
  page.</div>

 */

@InstanceOf("Ext.dd.DDProxy")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.dd.DDProxy")
public class DDProxy extends DD {
	public static final String COMPONENT_FAMILY = "Ext.dd.DDProxy";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.DDProxy} instance with default property values.
	 * </p>
	 */
	public DDProxy() {
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