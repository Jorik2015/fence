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
 * Simple plugin for using an Ext.Tip with
  a slider to show the slider value
 */

@InstanceOf("Ext.ux.SliderTip")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "SliderTip.js")
@FacesComponent(value = "Ext.ux.SliderTip")
public class SliderTip extends Tip {
	public static final String COMPONENT_FAMILY = "Ext.ux.SliderTip";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.SliderTip} instance with default property values.
	 * </p>
	 */
	public SliderTip() {
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