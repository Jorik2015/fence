package ext.ux;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
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
 * Creates a Spinner control utilized by
  Ext.ux.form.SpinnerField
 */

@InstanceOf("Ext.ux.Spinner")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "Spinner.js")
@FacesComponent(value = "Ext.ux.Spinner")
public class Spinner extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.ux.Spinner";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.Spinner} instance with default property values.
	 * </p>
	 */
	public Spinner() {
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