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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">Numeric text field that provides
  automatic keystroke filtering and numeric validation.</div>

 */
@XType("numberfield")
@InstanceOf("Ext.form.NumberField")

@FacesComponent(value = "Ext.form.NumberField")
public class NumberField extends TextField {
	public static final String COMPONENT_FAMILY = "Ext.form.NumberField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.NumberField} instance with default property values.
	 * </p>
	 */
	public NumberField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			decimalPrecision
			,fieldClass
			,nanText
			,minValue
			,maxText
			,baseChars
			,autoStripChars
			,allowNegative
			,allowDecimals
			,decimalSeparator
			,minText
			,maxValue
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
        
        
          decimalPrecision
         : Number
        The maximum precision to display after
        the decimal separator (defaults to 2)
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
        
        
          fieldClass
         : String
        The default CSS class for the field
        (defaults to "x-form-field x-form-num-field")
	 */
	
	public String getFieldClass () {
		return (String) getStateHelper().eval(PropertyKeys.fieldClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldClass</code> property.
	 * </p>
	 */
	public void setFieldClass ( String   fieldClass ) {
		getStateHelper().put(PropertyKeys.fieldClass, fieldClass);
		handleAttribute("fieldClass", fieldClass);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Error text to display if the value is
          not a valid number. For example, this can happen if a
          valid character like '.' or '-' is left in the field with
          no number (defaults to "{value} is not a valid
          number")</div>

	 */
	
	public String getNanText () {
		return (String) getStateHelper().eval(PropertyKeys.nanText);
	}

	/**
	 * <p>
	 * Set the value of the <code>nanText</code> property.
	 * </p>
	 */
	public void setNanText ( String   nanText ) {
		getStateHelper().put(PropertyKeys.nanText, nanText);
		handleAttribute("nanText", nanText);
	}
    	/*
	 *
        
        
          minValue
         : Number
        The minimum allowed value (defaults to
        Number.NEGATIVE_INFINITY)
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Error text to display if the maximum
          value validation fails (defaults to "The maximum value
          for this field is {maxValue}")</div>

	 */
	
	public String getMaxText () {
		return (String) getStateHelper().eval(PropertyKeys.maxText);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxText</code> property.
	 * </p>
	 */
	public void setMaxText ( String   maxText ) {
		getStateHelper().put(PropertyKeys.maxText, maxText);
		handleAttribute("maxText", maxText);
	}
    	/*
	 *
        
        
          baseChars
         : String
        The base set of characters to evaluate
        as valid numbers (defaults to '0123456789').
	 */
	
	public String getBaseChars () {
		return (String) getStateHelper().eval(PropertyKeys.baseChars);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseChars</code> property.
	 * </p>
	 */
	public void setBaseChars ( String   baseChars ) {
		getStateHelper().put(PropertyKeys.baseChars, baseChars);
		handleAttribute("baseChars", baseChars);
	}
    	/*
	 *
        
        
          autoStripChars
         : Boolean
        True to automatically strip not allowed
        characters from the field. Defaults to 
        false
	 */
	
	public Boolean getAutoStripChars () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoStripChars);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoStripChars</code> property.
	 * </p>
	 */
	public void setAutoStripChars ( Boolean   autoStripChars ) {
		getStateHelper().put(PropertyKeys.autoStripChars, autoStripChars);
		handleAttribute("autoStripChars", autoStripChars);
	}
    	/*
	 *
        
        
          allowNegative
         : Boolean
        False to prevent entering a negative
        sign (defaults to true)
	 */
	
	public Boolean getAllowNegative () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowNegative);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowNegative</code> property.
	 * </p>
	 */
	public void setAllowNegative ( Boolean   allowNegative ) {
		getStateHelper().put(PropertyKeys.allowNegative, allowNegative);
		handleAttribute("allowNegative", allowNegative);
	}
    	/*
	 *
        
        
          allowDecimals
         : Boolean
        False to disallow decimal values
        (defaults to true)
	 */
	
	public Boolean getAllowDecimals () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowDecimals);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDecimals</code> property.
	 * </p>
	 */
	public void setAllowDecimals ( Boolean   allowDecimals ) {
		getStateHelper().put(PropertyKeys.allowDecimals, allowDecimals);
		handleAttribute("allowDecimals", allowDecimals);
	}
    	/*
	 *
        
        
          decimalSeparator
         : String
        Character(s) to allow as the decimal
        separator (defaults to '.')
	 */
	
	public String getDecimalSeparator () {
		return (String) getStateHelper().eval(PropertyKeys.decimalSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>decimalSeparator</code> property.
	 * </p>
	 */
	public void setDecimalSeparator ( String   decimalSeparator ) {
		getStateHelper().put(PropertyKeys.decimalSeparator, decimalSeparator);
		handleAttribute("decimalSeparator", decimalSeparator);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Error text to display if the minimum
          value validation fails (defaults to "The minimum value
          for this field is {minValue}")</div>

	 */
	
	public String getMinText () {
		return (String) getStateHelper().eval(PropertyKeys.minText);
	}

	/**
	 * <p>
	 * Set the value of the <code>minText</code> property.
	 * </p>
	 */
	public void setMinText ( String   minText ) {
		getStateHelper().put(PropertyKeys.minText, minText);
		handleAttribute("minText", minText);
	}
    	/*
	 *
        
        
          maxValue
         : Number
        The maximum allowed value (defaults to
        Number.MAX_VALUE)
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