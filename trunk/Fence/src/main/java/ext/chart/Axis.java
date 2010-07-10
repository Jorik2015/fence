package ext.chart;

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
 * Defines a CartesianChart's vertical or
  horizontal axis.
 */

@InstanceOf("Ext.chart.Axis")
@ParseConfigMode(ui = false,pmode=PersistenceMode.Custom,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.chart.Axis")
public class Axis extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.chart.Axis";

	/**
	 * <p>
	 * Create a new {@link Ext.chart.Axis} instance with default property values.
	 * </p>
	 */
	public Axis() {
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