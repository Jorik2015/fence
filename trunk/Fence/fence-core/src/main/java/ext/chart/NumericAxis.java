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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">A type of axis whose units are measured
  in numeric values.</div>

 */

@InstanceOf("Ext.chart.NumericAxis")
@ParseConfigMode(ui = false,pmode=PersistenceMode.Custom,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.chart.NumericAxis")
public class NumericAxis extends Axis {
	public static final String COMPONENT_FAMILY = "Ext.chart.NumericAxis";

	/**
	 * <p>
	 * Create a new {@link Ext.chart.NumericAxis} instance with default property values.
	 * </p>
	 */
	public NumericAxis() {
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