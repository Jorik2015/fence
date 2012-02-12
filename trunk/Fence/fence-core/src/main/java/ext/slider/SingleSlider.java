package ext.slider;

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
<div class="description">Slider which supports vertical or
  horizontal orientation, keyboard adjustments, configurable
  snapping, axis clicking and animation. Can be added as an item to
  any container. Example usage: 
<pre>
<code>
<b>new</b> Ext.slider.SingleSlider({
    renderTo: Ext.getBody(),
    width: 200,
    value: 50,
    increment: 10,
    minValue: 0,
    maxValue: 100
});</code>
  </pre>The class Ext.slider.SingleSlider is aliased to Ext.Slider
  for backwards compatibility.</div>

 */

@InstanceOf("Ext.slider.SingleSlider")

@FacesComponent(value = "Ext.slider.SingleSlider")
public class SingleSlider extends MultiSlider {
	public static final String COMPONENT_FAMILY = "Ext.slider.SingleSlider";

	/**
	 * <p>
	 * Create a new {@link Ext.slider.SingleSlider} instance with default property values.
	 * </p>
	 */
	public SingleSlider() {
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