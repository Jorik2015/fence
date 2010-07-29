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
 * Slider which supports vertical or
  horizontal orientation, keyboard adjustments, configurable
  snapping, axis clicking and animation. Can be added as an item to
  any container. Example usage: 

new Ext.Slider({
    renderTo: Ext.getBody(),
    width: 200,
    value: 50,
    increment: 10,
    minValue: 0,
    maxValue: 100
});
  Sliders can be created with more than one thumb handle by
  passing an array of values instead of a single one: 

new Ext.Slider({
    renderTo: Ext.getBody(),
    width: 200,
    values: [25, 50, 75],
    minValue: 0,
    maxValue: 100,

    //this defaults to true, setting to false allows the thumbs to
pass each other
    
constrainThumbs: false
});
  
 */

@InstanceOf("Ext.slider.MultiSlider")

@FacesComponent(value = "Ext.slider.MultiSlider")
public class MultiSlider extends BoxComponent {
	public static final String COMPONENT_FAMILY = "Ext.slider.MultiSlider";

	/**
	 * <p>
	 * Create a new {@link Ext.slider.MultiSlider} instance with default property values.
	 * </p>
	 */
	public MultiSlider() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			clickToChange
			,value
			,increment
			,animate
			,minValue
			,maxValue
			,decimalPrecision
			,constrainThumbs
			,vertical
			,keyIncrement
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
        
        
          clickToChange
         : Boolean
        Determines whether or not clicking on
        the Slider axis will change the slider. Defaults to
        true
	 */
	
	public Boolean getClickToChange () {
		return (Boolean) getStateHelper().eval(PropertyKeys.clickToChange);
	}

	/**
	 * <p>
	 * Set the value of the <code>clickToChange</code> property.
	 * </p>
	 */
	public void setClickToChange ( Boolean   clickToChange ) {
		getStateHelper().put(PropertyKeys.clickToChange, clickToChange);
		handleAttribute("clickToChange", clickToChange);
	}
    	/*
	 *
        
        
          value
         : Number
        The value to initialize the slider with.
        Defaults to minValue.
	 */
	
	public Integer getValue () {
		return (Integer) getStateHelper().eval(PropertyKeys.value);
	}

	/**
	 * <p>
	 * Set the value of the <code>value</code> property.
	 * </p>
	 */
	public void setValue ( Integer   value ) {
		getStateHelper().put(PropertyKeys.value, value);
		handleAttribute("value", value);
	}
    	/*
	 *
        
        
          increment
         : Number
        How many units to change the slider when
        adjusting by drag and drop. Use this option to enable
        'snapping'.
	 */
	
	public Integer getIncrement () {
		return (Integer) getStateHelper().eval(PropertyKeys.increment);
	}

	/**
	 * <p>
	 * Set the value of the <code>increment</code> property.
	 * </p>
	 */
	public void setIncrement ( Integer   increment ) {
		getStateHelper().put(PropertyKeys.increment, increment);
		handleAttribute("increment", increment);
	}
    	/*
	 *
        
        
          animate
         : Boolean
        Turn on or off animation. Defaults to
        true
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
        
        
          minValue
         : Number
        The minimum value for the Slider.
        Defaults to 0.
	 */
	
	public Integer getMinValue () {
		return (Integer) getStateHelper().eval(PropertyKeys.minValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>minValue</code> property.
	 * </p>
	 */
	public void setMinValue ( Integer   minValue ) {
		getStateHelper().put(PropertyKeys.minValue, minValue);
		handleAttribute("minValue", minValue);
	}
    	/*
	 *
        
        
          maxValue
         : Number
        The maximum value for the Slider.
        Defaults to 100.
	 */
	
	public Integer getMaxValue () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxValue</code> property.
	 * </p>
	 */
	public void setMaxValue ( Integer   maxValue ) {
		getStateHelper().put(PropertyKeys.maxValue, maxValue);
		handleAttribute("maxValue", maxValue);
	}
    	/*
	 *
            The number of decimal places to which to round the
            Slider's value. Defaults to 0.
            To disable rounding, configure as 
            
              false
            .
          
	 */
	
	public Integer getDecimalPrecision () {
		return (Integer) getStateHelper().eval(PropertyKeys.decimalPrecision);
	}

	/**
	 * <p>
	 * Set the value of the <code>decimalPrecision</code> property.
	 * </p>
	 */
	public void setDecimalPrecision ( Integer   decimalPrecision ) {
		getStateHelper().put(PropertyKeys.decimalPrecision, decimalPrecision);
		handleAttribute("decimalPrecision", decimalPrecision);
	}
    	/*
	 *
        
        
          constrainThumbs
         : Boolean
        True to disallow thumbs from overlapping
        one another. Defaults to true
	 */
	
	public Boolean getConstrainThumbs () {
		return (Boolean) getStateHelper().eval(PropertyKeys.constrainThumbs);
	}

	/**
	 * <p>
	 * Set the value of the <code>constrainThumbs</code> property.
	 * </p>
	 */
	public void setConstrainThumbs ( Boolean   constrainThumbs ) {
		getStateHelper().put(PropertyKeys.constrainThumbs, constrainThumbs);
		handleAttribute("constrainThumbs", constrainThumbs);
	}
    	/*
	 *
        
        
          vertical
         : Boolean
        Orient the Slider vertically rather than
        horizontally, defaults to false.
	 */
	
	public Boolean getVertical () {
		return (Boolean) getStateHelper().eval(PropertyKeys.vertical);
	}

	/**
	 * <p>
	 * Set the value of the <code>vertical</code> property.
	 * </p>
	 */
	public void setVertical ( Boolean   vertical ) {
		getStateHelper().put(PropertyKeys.vertical, vertical);
		handleAttribute("vertical", vertical);
	}
    	/*
	 *How many units to change the Slider
          when adjusting with keyboard navigation. Defaults to 1.
          If the increment config is larger, it will be used
          instead.
	 */
	
	public Integer getKeyIncrement () {
		return (Integer) getStateHelper().eval(PropertyKeys.keyIncrement);
	}

	/**
	 * <p>
	 * Set the value of the <code>keyIncrement</code> property.
	 * </p>
	 */
	public void setKeyIncrement ( Integer   keyIncrement ) {
		getStateHelper().put(PropertyKeys.keyIncrement, keyIncrement);
		handleAttribute("keyIncrement", keyIncrement);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforechange"
					, "change"
					, "changecomplete"
					, "drag"
					, "dragend"
					, "dragstart"
				));
				return superEvent;
	}
}