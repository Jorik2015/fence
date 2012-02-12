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
<div class="description">Provides a time input field with a time
  dropdown and automatic time validation. Example usage: 
<pre>
<code>
<b>new</b> Ext.form.TimeField({
    minValue: 
<em>'9:00 AM'</em>,
    maxValue: 
<em>'6:00 PM'</em>,
    increment: 30
});</code>
  </pre>
</div>

 */
@XType("timefield")
@InstanceOf("Ext.form.TimeField")

@FacesComponent(value = "Ext.form.TimeField")
public class TimeField extends ComboBox {
	public static final String COMPONENT_FAMILY = "Ext.form.TimeField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.TimeField} instance with default property values.
	 * </p>
	 */
	public TimeField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			increment
			,minValue
			,maxText
			,altFormats
			,format
			,invalidText
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
        
        
          increment
         : Number
        The number of minutes between each time
        value in the list (defaults to 15).
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The minimum allowed time. Can be either
          a Javascript date object with a valid time value or a
          string time in a valid format -- see 
          <a ext:cls="Ext.form.TimeField" ext:member="format" href="output/Ext.form.TimeField.html#Ext.form.TimeField-format">format</a> and 
          <a ext:cls="Ext.form.TimeField" ext:member="altFormats" href="output/Ext.form.TimeField.html#Ext.form.TimeField-altFormats">altFormats</a> (defaults to
          undefined).</div>

	 */
	
	public Date getMinValue () {
		return (Date) getStateHelper().eval(PropertyKeys.minValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>minValue</code> property.
	 * </p>
	 */
	public void setMinValue ( Date   minValue ) {
		getStateHelper().put(PropertyKeys.minValue, minValue);
		handleAttribute("minValue", minValue);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The error text to display when the time
          is after maxValue (defaults to 'The time in this field
          must be equal to or before {0}').</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Multiple date formats separated by "|"
          to try when parsing a user input value and it doesn't
          match the defined format (defaults to 'g:ia|g:iA|g:i
          a|g:i A|h:i|g:i|H:i|ga|ha|gA|h a|g a|g
          A|gi|hi|gia|hia|g|H|gi a|hi a|giA|hiA|gi A|hi A').</div>

	 */
	
	public String getAltFormats () {
		return (String) getStateHelper().eval(PropertyKeys.altFormats);
	}

	/**
	 * <p>
	 * Set the value of the <code>altFormats</code> property.
	 * </p>
	 */
	public void setAltFormats ( String   altFormats ) {
		getStateHelper().put(PropertyKeys.altFormats, altFormats);
		handleAttribute("altFormats", altFormats);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The default time format string which
          can be overriden for localization support. The format
          must be valid according to 
          <a ext:cls="Date" ext:member="parseDate" href="output/Date.html#Date-parseDate">Date.parseDate</a>
          (defaults to 'g:i A', e.g., '3:15 PM'). For 24-hour time
          format try 'H:i' instead.</div>

	 */
	
	public String getFormat () {
		return (String) getStateHelper().eval(PropertyKeys.format);
	}

	/**
	 * <p>
	 * Set the value of the <code>format</code> property.
	 * </p>
	 */
	public void setFormat ( String   format ) {
		getStateHelper().put(PropertyKeys.format, format);
		handleAttribute("format", format);
	}
    	/*
	 *
        
        
          invalidText
         : String
        The error text to display when the time
        in the field is invalid (defaults to '{value} is not a
        valid time').
	 */
	
	public String getInvalidText () {
		return (String) getStateHelper().eval(PropertyKeys.invalidText);
	}

	/**
	 * <p>
	 * Set the value of the <code>invalidText</code> property.
	 * </p>
	 */
	public void setInvalidText ( String   invalidText ) {
		getStateHelper().put(PropertyKeys.invalidText, invalidText);
		handleAttribute("invalidText", invalidText);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The error text to display when the date
          in the cell is before minValue (defaults to 'The time in
          this field must be equal to or after {0}').</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The maximum allowed time. Can be either
          a Javascript date object with a valid time value or a
          string time in a valid format -- see 
          <a ext:cls="Ext.form.TimeField" ext:member="format" href="output/Ext.form.TimeField.html#Ext.form.TimeField-format">format</a> and 
          <a ext:cls="Ext.form.TimeField" ext:member="altFormats" href="output/Ext.form.TimeField.html#Ext.form.TimeField-altFormats">altFormats</a> (defaults to
          undefined).</div>

	 */
	
	public Date getMaxValue () {
		return (Date) getStateHelper().eval(PropertyKeys.maxValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxValue</code> property.
	 * </p>
	 */
	public void setMaxValue ( Date   maxValue ) {
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