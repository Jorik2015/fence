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
 * Represents a single thumb element on a
  Slider. This would not usually be created manually and would
  instead be created internally by an 
  Ext.Slider.
 */

@InstanceOf("Ext.slider.Thumb")

@FacesComponent(value = "Ext.slider.Thumb")
public class Thumb extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.slider.Thumb";

	/**
	 * <p>
	 * Create a new {@link Ext.slider.Thumb} instance with default property values.
	 * </p>
	 */
	public Thumb() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			constrain
			,slider
		;
		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((toString != null) ? toString : super.toString());
		}
	}
	
		/*
	 *
        
        
          constrain
         : Boolean
        True to constrain the thumb so that it
        cannot overlap its siblings
	 */
	
	public Boolean getConstrain () {
		return (Boolean) getStateHelper().eval(PropertyKeys.constrain);
	}

	/**
	 * <p>
	 * Set the value of the <code>constrain</code> property.
	 * </p>
	 */
	public void setConstrain ( Boolean   constrain ) {
		getStateHelper().put(PropertyKeys.constrain, constrain);
		handleAttribute("constrain", constrain);
	}
    	/*
	 *
        
        
          slider
         : Ext.slider.MultiSlider
        The Slider to render to
        (required)
	 */
	@ClientConfig(JsonMode.Object)

	public Object getSlider () {
		return (Object) getStateHelper().eval(PropertyKeys.slider);
	}

	/**
	 * <p>
	 * Set the value of the <code>slider</code> property.
	 * </p>
	 */
	public void setSlider ( Object   slider ) {
		getStateHelper().put(PropertyKeys.slider, slider);
		handleAttribute("slider", slider);
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