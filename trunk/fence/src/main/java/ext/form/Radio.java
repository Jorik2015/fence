package ext.form;

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
 * Single radio field. Same as Checkbox,
  but provided as a convenience for automatically setting the input
  type. Radio grouping is handled automatically by the browser if
  you give each radio in a group the same name.
 */
@XType("radio")
@InstanceOf("Ext.form.Radio")

@FacesComponent(value = "Ext.form.Radio")
public class Radio extends Checkbox {
	public static final String COMPONENT_FAMILY = "Ext.form.Radio";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Radio} instance with default property values.
	 * </p>
	 */
	public Radio() {
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