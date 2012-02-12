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
<div class="description">Provides a date input field with a 
  <a ext:cls="Ext.DatePicker" href="output/Ext.DatePicker.html">Ext.DatePicker</a> dropdown and
  automatic date validation.</div>

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
			disabledDays
			,autoCreate
			,minValue
			,maxText
			,format
			,invalidText
			,disabledDaysText
			,minText
			,disabledDatesText
			,startDay
			,altFormats
			,showToday
			,triggerClass
			,disabledDates
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array of days to disable, 0 based
          (defaults to null). Some examples:
<pre>
<code>
<i>// disable Sunday and Saturday:</i>
disabledDays:  [0, 6]
<i>// disable weekdays:</i>
disabledDays: [1,2,3,4,5]</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A 
          <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper element specification
          object</a>, or 
          <tt>true</tt> for the default element specification
          object:
<pre>
<code>autoCreate: {tag: 
<em>"input"</em>, type: 
<em>"text"</em>, size: 
<em>"10"</em>, autocomplete: 
<em>"off"</em>}</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The minimum allowed date. Can be either
          a Javascript date object or a string date in a valid
          format (defaults to null).</div>

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
<div class="long">The error text to display when the date
          in the cell is after 
          <tt>
            <a ext:cls="Ext.form.DateField" ext:member="maxValue" href="output/Ext.form.DateField.html#Ext.form.DateField-maxValue">maxValue</a>
          </tt> (defaults to 
          <tt>'The date in this field must be before
          {maxValue}'</tt>).</div>

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
<div class="long">The default date format string which
          can be overriden for localization support. The format
          must be valid according to 
          <a ext:cls="Date" ext:member="parseDate" href="output/Date.html#Date-parseDate">Date.parseDate</a>
          (defaults to 
          <tt>'m/d/Y'</tt>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The error text to display when the date
          in the field is invalid (defaults to 
          <tt>'{value} is not a valid date - it must be in the
          format {format}'</tt>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The error text to display when the date
          in the cell is before 
          <tt>
            <a ext:cls="Ext.form.DateField" ext:member="minValue" href="output/Ext.form.DateField.html#Ext.form.DateField-minValue">minValue</a>
          </tt> (defaults to 
          <tt>'The date in this field must be after
          {minValue}'</tt>).</div>

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
	 *
        
        
          startDay
         : Number
        Day index at which the week should
        begin, 0-based (defaults to 0, which is Sunday)
	 */
	
	public Integer getStartDay () {
		return (Integer) getStateHelper().eval(PropertyKeys.startDay);
	}

	/**
	 * <p>
	 * Set the value of the <code>startDay</code> property.
	 * </p>
	 */
	public void setStartDay ( Integer   startDay ) {
		getStateHelper().put(PropertyKeys.startDay, startDay);
		handleAttribute("startDay", startDay);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Multiple date formats separated by "
          <tt>|</tt>" to try when parsing a user input value and it
          does not match the defined format (defaults to 
          <tt>'m/d/Y|n/j/Y|n/j/y|m/j/y|n/d/y|m/j/Y|n/d/Y|m-d-y|m-d-Y|m/d|m-d|md|mdy|mdY|d|Y-m-d|n-j|n/j'</tt>).</div>

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
<div class="long">
          <tt>false</tt> to hide the footer area of the DatePicker
          containing the Today button and disable the keyboard
          handler for spacebar that selects the current date
          (defaults to 
          <tt>true</tt>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          <tt>'x-form-trigger'</tt> and 
          <tt>triggerClass</tt> will be 
          <b>appended</b> if specified (defaults to 
          <tt>'x-form-date-trigger'</tt> which displays a calendar
          icon).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array of "dates" to disable, as
          strings. These strings will be used to build a dynamic
          regular expression so they are very powerful. Some
          examples:
<pre>
<code>
<i>// disable these exact dates:</i>
disabledDates: [
<em>"03/08/2003"</em>, 
<em>"09/16/2003"</em>]
<i>// disable these days 
<b>for</b> every year:</i>
disabledDates: [
<em>"03/08"</em>, 
<em>"09/16"</em>]
<i>// only match the beginning (useful 
<b>if</b> you are using short years):</i>
disabledDates: [
<em>"^03/08"</em>]
<i>// disable every day 
<b>in</b> March 2006:</i>
disabledDates: [
<em>"03/../2006"</em>]
<i>// disable every day 
<b>in</b> every March:</i>
disabledDates: [
<em>"^03"</em>]</code>
          </pre>Note that the format of the dates included in the
          array should exactly match the 
          <a ext:cls="Ext.form.DateField" ext:member="format" href="output/Ext.form.DateField.html#Ext.form.DateField-format">format</a> config. In order
          to support regular expressions, if you are using a 
          <a ext:cls="Ext.form.DateField" ext:member="format" href="output/Ext.form.DateField.html#Ext.form.DateField-format">date
          format</a> that has "." in it, you will have to escape
          the dot when restricting dates. For example: 
          <tt>["03\\.08\\.03"]</tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The maximum allowed date. Can be either
          a Javascript date object or a string date in a valid
          format (defaults to null).</div>

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
				superEvent.addAll(Arrays.asList(
					 "select"
				));
				return superEvent;
	}
}