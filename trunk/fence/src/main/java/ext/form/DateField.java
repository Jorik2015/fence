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
 * Provides a date input field with a 
  Ext.DatePicker dropdown and
  automatic date validation.
 */
@XType("datefield")
@InstanceOf("Ext.form.DateField")

@FacesComponent(value = "Ext.form.DateField")
public class DateField extends TriggerField {
	public static final String COMPONENT_FAMILY = "Ext.form.DateField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.DateField} instance with default property values.
	 * </p>
	 */
	public DateField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			maxValue
			,invalidText
			,disabledDays
			,disabledDatesText
			,minText
			,autoCreate
			,disabledDaysText
			,minValue
			,altFormats
			,maxText
			,showToday
			,disabledDates
			,triggerClass
			,format
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
	 *The maximum allowed date. Can be either
          a Javascript date object or a string date in a valid
          format (defaults to null).
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
    	/*
	 *The error text to display when the date
          in the field is invalid (defaults to 
          '{value} is not a valid date - it must be in the
          format {format}').
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
	 *An array of days to disable, 0 based
          (defaults to null). Some examples:


// disable Sunday and Saturday:
disabledDays:  [0, 6]
// disable weekdays:
disabledDays: [1,2,3,4,5]
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getDisabledDays () {
		return (Object) getStateHelper().eval(PropertyKeys.disabledDays);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDays</code> property.
	 * </p>
	 */
	public void setDisabledDays ( Object   disabledDays ) {
		getStateHelper().put(PropertyKeys.disabledDays, disabledDays);
		handleAttribute("disabledDays", disabledDays);
	}
    	/*
	 *
        
        
          disabledDatesText
         : String
        The tooltip text to display when the
        date falls on a disabled date (defaults to 
        'Disabled')
	 */
	
	public String getDisabledDatesText () {
		return (String) getStateHelper().eval(PropertyKeys.disabledDatesText);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDatesText</code> property.
	 * </p>
	 */
	public void setDisabledDatesText ( String   disabledDatesText ) {
		getStateHelper().put(PropertyKeys.disabledDatesText, disabledDatesText);
		handleAttribute("disabledDatesText", disabledDatesText);
	}
    	/*
	 *The error text to display when the date
          in the cell is before 
          
            minValue
           (defaults to 
          'The date in this field must be after
          {minValue}').
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
	 *A 
          DomHelper element specification
          object, or 
          true for the default element specification
          object:

autoCreate: {tag: 
"input", type: 
"text", size: 
"10", autocomplete: 
"off"}
          
	 */
	
	public String getAutoCreate () {
		return (String) getStateHelper().eval(PropertyKeys.autoCreate);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoCreate</code> property.
	 * </p>
	 */
	public void setAutoCreate ( String   autoCreate ) {
		getStateHelper().put(PropertyKeys.autoCreate, autoCreate);
		handleAttribute("autoCreate", autoCreate);
	}
    	/*
	 *
        
        
          disabledDaysText
         : String
        The tooltip to display when the date
        falls on a disabled day (defaults to 
        'Disabled')
	 */
	
	public String getDisabledDaysText () {
		return (String) getStateHelper().eval(PropertyKeys.disabledDaysText);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDaysText</code> property.
	 * </p>
	 */
	public void setDisabledDaysText ( String   disabledDaysText ) {
		getStateHelper().put(PropertyKeys.disabledDaysText, disabledDaysText);
		handleAttribute("disabledDaysText", disabledDaysText);
	}
    	/*
	 *The minimum allowed date. Can be either
          a Javascript date object or a string date in a valid
          format (defaults to null).
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
	 *Multiple date formats separated by "
          |" to try when parsing a user input value and it
          does not match the defined format (defaults to 
          'm/d/Y|n/j/Y|n/j/y|m/j/y|n/d/y|m/j/Y|n/d/Y|m-d-y|m-d-Y|m/d|m-d|md|mdy|mdY|d|Y-m-d').
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
	 *The error text to display when the date
          in the cell is after 
          
            maxValue
           (defaults to 
          'The date in this field must be before
          {maxValue}').
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
          false to hide the footer area of the DatePicker
          containing the Today button and disable the keyboard
          handler for spacebar that selects the current date
          (defaults to 
          true).
	 */
	
	public Boolean getShowToday () {
		return (Boolean) getStateHelper().eval(PropertyKeys.showToday);
	}

	/**
	 * <p>
	 * Set the value of the <code>showToday</code> property.
	 * </p>
	 */
	public void setShowToday ( Boolean   showToday ) {
		getStateHelper().put(PropertyKeys.showToday, showToday);
		handleAttribute("showToday", showToday);
	}
    	/*
	 *An array of "dates" to disable, as
          strings. These strings will be used to build a dynamic
          regular expression so they are very powerful. Some
          examples:


// disable these exact dates:
disabledDates: [
"03/08/2003", 
"09/16/2003"]
// disable these days 
for every year:
disabledDates: [
"03/08", 
"09/16"]
// only match the beginning (useful 
if you are using short years):
disabledDates: [
"^03/08"]
// disable every day 
in March 2006:
disabledDates: [
"03/../2006"]
// disable every day 
in every March:
disabledDates: [
"^03"]
          Note that the format of the dates included in the
          array should exactly match the 
          format config. In order
          to support regular expressions, if you are using a 
          date
          format that has "." in it, you will have to escape
          the dot when restricting dates. For example: 
          ["03\\.08\\.03"].
	 */
	@ClientConfig(JsonMode.Array)

	public Object getDisabledDates () {
		return (Object) getStateHelper().eval(PropertyKeys.disabledDates);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDates</code> property.
	 * </p>
	 */
	public void setDisabledDates ( Object   disabledDates ) {
		getStateHelper().put(PropertyKeys.disabledDates, disabledDates);
		handleAttribute("disabledDates", disabledDates);
	}
    	/*
	 *An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          'x-form-trigger' and 
          triggerClass will be 
          appended if specified (defaults to 
          'x-form-date-trigger' which displays a calendar
          icon).
	 */
	
	public String getTriggerClass () {
		return (String) getStateHelper().eval(PropertyKeys.triggerClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>triggerClass</code> property.
	 * </p>
	 */
	public void setTriggerClass ( String   triggerClass ) {
		getStateHelper().put(PropertyKeys.triggerClass, triggerClass);
		handleAttribute("triggerClass", triggerClass);
	}
    	/*
	 *The default date format string which
          can be overriden for localization support. The format
          must be valid according to 
          Date.parseDate
          (defaults to 
          'm/d/Y').
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
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "select"
				));
				return superEvent;
	}
}