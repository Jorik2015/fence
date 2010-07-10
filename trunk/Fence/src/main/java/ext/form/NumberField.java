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
 * Numeric text field that provides
  automatic keystroke filtering and numeric validation.
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
			minValue
			,baseChars
			,allowNegative
			,maxValue
			,fieldClass
			,maxText
			,nanText
			,decimalSeparator
			,decimalPrecision
			,minText
			,allowDecimals
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
	 *Error text to display if the maximum
          value validation fails (defaults to "The maximum value
          for this field is {maxValue}")
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
	 *Error text to display if the value is
          not a valid number. For example, this can happen if a
          valid character like '.' or '-' is left in the field with
          no number (defaults to "{value} is not a valid
          number")
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
	 *Error text to display if the minimum
          value validation fails (defaults to "The minimum value
          for this field is {minValue}")
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