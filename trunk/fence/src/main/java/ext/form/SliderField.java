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
 * Wraps a 
  Slider
  so it can be used as a form field.
 */

@InstanceOf("Ext.form.SliderField")

@FacesComponent(value = "Ext.form.SliderField")
public class SliderField extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.SliderField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.SliderField} instance with default property values.
	 * </p>
	 */
	public SliderField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			useTips
			,tipText
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
        
        
          useTips
         : Boolean
        True to use an Ext.slider.Tip to display
        tips for the value. Defaults to 
        true.
	 */
	
	public Boolean getUseTips () {
		return (Boolean) getStateHelper().eval(PropertyKeys.useTips);
	}

	/**
	 * <p>
	 * Set the value of the <code>useTips</code> property.
	 * </p>
	 */
	public void setUseTips ( Boolean   useTips ) {
		getStateHelper().put(PropertyKeys.useTips, useTips);
		handleAttribute("useTips", useTips);
	}
    	/*
	 *A function used to display custom text
          for the slider tip. Defaults to 
          null, which will use the default on the
          plugin.
	 */
	@ClientConfig(JsonMode.Function)

	public Object getTipText () {
		return (Object) getStateHelper().eval(PropertyKeys.tipText);
	}

	/**
	 * <p>
	 * Set the value of the <code>tipText</code> property.
	 * </p>
	 */
	public void setTipText ( Object   tipText ) {
		getStateHelper().put(PropertyKeys.tipText, tipText);
		handleAttribute("tipText", tipText);
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