package ext;

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
import java.util.Date;

/**
 * 
    An updateable progress bar component. The progress bar
    supports two different modes: manual and automatic.
    In manual mode, you are responsible for showing, updating
    (via 
    updateProgress) and clearing the
    progress bar as needed from your own code. This method is most
    appropriate when you want to show progress throughout an
    operation that has predictable points of interest at which you
    can update the control.
    In automatic mode, you simply call 
    wait and let
    the progress bar run indefinitely, only clearing it once the
    operation is complete. You can optionally have the progress bar
    wait for a specific amount of time and then clear itself.
    Automatic mode is most appropriate for timed operations or
    asynchronous operations in which you have no need for
    indicating intermediate progress.
  
 */
@XType("progress")
@InstanceOf("Ext.ProgressBar")

@FacesComponent(value = "Ext.ProgressBar")
public class ProgressBar extends BoxComponent {
	public static final String COMPONENT_FAMILY = "Ext.ProgressBar";

	/**
	 * <p>
	 * Create a new {@link Ext.ProgressBar} instance with default property values.
	 * </p>
	 */
	public ProgressBar() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			value
			,animate
			,text
			,textEl
			,baseCls
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
        
        
          value
         : Float
        A floating point value between 0 and 1
        (e.g., .5, defaults to 0)
	 */
	
	public Float getValue () {
		return (Float) getStateHelper().eval(PropertyKeys.value);
	}

	/**
	 * <p>
	 * Set the value of the <code>value</code> property.
	 * </p>
	 */
	public void setValue ( Float   value ) {
		getStateHelper().put(PropertyKeys.value, value);
		handleAttribute("value", value);
	}
    	/*
	 *
        
        
          animate
         : Boolean
        True to animate the progress bar during
        transitions (defaults to false)
	 */
	
	public Boolean getAnimate () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animate);
	}

	/**
	 * <p>
	 * Set the value of the <code>animate</code> property.
	 * </p>
	 */
	public void setAnimate ( Boolean   animate ) {
		getStateHelper().put(PropertyKeys.animate, animate);
		handleAttribute("animate", animate);
	}
    	/*
	 *
        
        
          text
         : String
        The progress bar text (defaults to
        '')
	 */
	
	public String getText () {
		return (String) getStateHelper().eval(PropertyKeys.text);
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText ( String   text ) {
		getStateHelper().put(PropertyKeys.text, text);
		handleAttribute("text", text);
	}
    	/*
	 *
        
        
          textEl
         : Mixed
        The element to render the progress text
        to (defaults to the progress bar's internal text
        element)
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTextEl () {
		return (Object) getStateHelper().eval(PropertyKeys.textEl);
	}

	/**
	 * <p>
	 * Set the value of the <code>textEl</code> property.
	 * </p>
	 */
	public void setTextEl ( Object   textEl ) {
		getStateHelper().put(PropertyKeys.textEl, textEl);
		handleAttribute("textEl", textEl);
	}
    	/*
	 *
        
        
          baseCls
         : String
        The base CSS class to apply to the
        progress bar's wrapper element (defaults to
        'x-progress')
	 */
	
	public String getBaseCls () {
		return (String) getStateHelper().eval(PropertyKeys.baseCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseCls</code> property.
	 * </p>
	 */
	public void setBaseCls ( String   baseCls ) {
		getStateHelper().put(PropertyKeys.baseCls, baseCls);
		handleAttribute("baseCls", baseCls);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "update"
				));
				return superEvent;
	}
}