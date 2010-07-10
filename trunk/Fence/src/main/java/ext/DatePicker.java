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
    A popup date picker. This class is used by the 
    DateField class to allow
    browsing and selection of valid dates.
    All the string values documented below may be overridden by
    including an Ext locale file in your page.
  
 */
@XType("datepicker")
@InstanceOf("Ext.DatePicker")

@FacesComponent(value = "Ext.DatePicker")
public class DatePicker extends Component {
	public static final String COMPONENT_FAMILY = "Ext.DatePicker";

	/**
	 * <p>
	 * Create a new {@link Ext.DatePicker} instance with default property values.
	 * </p>
	 */
	public DatePicker() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			handler
			,todayText
			,monthNames
			,disabledDays
			,disabledDatesText
			,cancelText
			,nextText
			,minText
			,minDate
			,startDay
			,dayNames
			,maxDate
			,disabledDaysText
			,disabledDatesRE
			,showToday
			,maxText
			,scope
			,disabledDates
			,monthYearText
			,todayTip
			,prevText
			,okText
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
	 *Optional. A function that will handle
          the select event of this picker. The handler is passed
          the following parameters:
          
            
              
              picker : DatePicker
              This DatePicker.
              
              date : Date
              The selected date.
            
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getHandler () {
		return (Object) getStateHelper().eval(PropertyKeys.handler);
	}

	/**
	 * <p>
	 * Set the value of the <code>handler</code> property.
	 * </p>
	 */
	public void setHandler ( Object   handler ) {
		getStateHelper().put(PropertyKeys.handler, handler);
		handleAttribute("handler", handler);
	}
    	/*
	 *
        
        
          todayText
         : String
        The text to display on the button that
        selects the current date (defaults to 
        
          'Today'
        )
	 */
	
	public String getTodayText () {
		return (String) getStateHelper().eval(PropertyKeys.todayText);
	}

	/**
	 * <p>
	 * Set the value of the <code>todayText</code> property.
	 * </p>
	 */
	public void setTodayText ( String   todayText ) {
		getStateHelper().put(PropertyKeys.todayText, todayText);
		handleAttribute("todayText", todayText);
	}
    	/*
	 *
        
        
          monthNames
         : Array
        An array of textual month names which
        can be overriden for localization support (defaults to
        Date.monthNames)
	 */
	@ClientConfig(JsonMode.Array)

	public Object getMonthNames () {
		return (Object) getStateHelper().eval(PropertyKeys.monthNames);
	}

	/**
	 * <p>
	 * Set the value of the <code>monthNames</code> property.
	 * </p>
	 */
	public void setMonthNames ( Object   monthNames ) {
		getStateHelper().put(PropertyKeys.monthNames, monthNames);
		handleAttribute("monthNames", monthNames);
	}
    	/*
	 *
        
        
          disabledDays
         : Array
        An array of days to disable, 0-based.
        For example, [0, 6] disables Sunday and Saturday (defaults
        to null).
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
        
          'Disabled'
        )
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
        
        
          cancelText
         : String
        The text to display on the cancel button
        (defaults to 
        
          'Cancel'
        )
	 */
	
	public String getCancelText () {
		return (String) getStateHelper().eval(PropertyKeys.cancelText);
	}

	/**
	 * <p>
	 * Set the value of the <code>cancelText</code> property.
	 * </p>
	 */
	public void setCancelText ( String   cancelText ) {
		getStateHelper().put(PropertyKeys.cancelText, cancelText);
		handleAttribute("cancelText", cancelText);
	}
    	/*
	 *
        
        
          nextText
         : String
        The next month navigation button tooltip
        (defaults to 
        
          'Next Month (Control+Right)'
        )
	 */
	
	public String getNextText () {
		return (String) getStateHelper().eval(PropertyKeys.nextText);
	}

	/**
	 * <p>
	 * Set the value of the <code>nextText</code> property.
	 * </p>
	 */
	public void setNextText ( String   nextText ) {
		getStateHelper().put(PropertyKeys.nextText, nextText);
		handleAttribute("nextText", nextText);
	}
    	/*
	 *
        
        
          minText
         : String
        The error text to display if the minDate
        validation fails (defaults to 
        
          'This date is before the minimum date'
        )
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
        
        
          minDate
         : Date
        Minimum allowable date (JavaScript date
        object, defaults to null)
	 */
	
	public Date getMinDate () {
		return (Date) getStateHelper().eval(PropertyKeys.minDate);
	}

	/**
	 * <p>
	 * Set the value of the <code>minDate</code> property.
	 * </p>
	 */
	public void setMinDate ( Date   minDate ) {
		getStateHelper().put(PropertyKeys.minDate, minDate);
		handleAttribute("minDate", minDate);
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
	 *
        
        
          dayNames
         : Array
        An array of textual day names which can
        be overriden for localization support (defaults to
        Date.dayNames)
	 */
	@ClientConfig(JsonMode.Array)

	public Object getDayNames () {
		return (Object) getStateHelper().eval(PropertyKeys.dayNames);
	}

	/**
	 * <p>
	 * Set the value of the <code>dayNames</code> property.
	 * </p>
	 */
	public void setDayNames ( Object   dayNames ) {
		getStateHelper().put(PropertyKeys.dayNames, dayNames);
		handleAttribute("dayNames", dayNames);
	}
    	/*
	 *
        
        
          maxDate
         : Date
        Maximum allowable date (JavaScript date
        object, defaults to null)
	 */
	
	public Date getMaxDate () {
		return (Date) getStateHelper().eval(PropertyKeys.maxDate);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxDate</code> property.
	 * </p>
	 */
	public void setMaxDate ( Date   maxDate ) {
		getStateHelper().put(PropertyKeys.maxDate, maxDate);
		handleAttribute("maxDate", maxDate);
	}
    	/*
	 *
        
        
          disabledDaysText
         : String
        The tooltip to display when the date
        falls on a disabled day (defaults to 
        
          'Disabled'
        )
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
	 *JavaScript regular expression used to
          disable a pattern of dates (defaults to null). The 
          disabledDates config will
          generate this regex internally, but if you specify
          disabledDatesRE it will take precedence over the
          disabledDates value.
	 */
	@ClientConfig(JsonMode.Object)

	public String getDisabledDatesRE () {
		return (String) getStateHelper().eval(PropertyKeys.disabledDatesRE);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDatesRE</code> property.
	 * </p>
	 */
	public void setDisabledDatesRE ( String   disabledDatesRE ) {
		getStateHelper().put(PropertyKeys.disabledDatesRE, disabledDatesRE);
		handleAttribute("disabledDatesRE", disabledDatesRE);
	}
    	/*
	 *False to hide the footer area
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
	 *
        
        
          maxText
         : String
        The error text to display if the maxDate
        validation fails (defaults to 
        
          'This date is after the maximum date'
        )
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
        
        
          scope
         : Object
        The scope (
        
          this
         reference) in which the 
        
          handler
         function will be called. Defaults to this
        DatePicker instance.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getScope () {
		return (Object) getStateHelper().eval(PropertyKeys.scope);
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope ( Object   scope ) {
		getStateHelper().put(PropertyKeys.scope, scope);
		handleAttribute("scope", scope);
	}
    	/*
	 *An array of 'dates' to disable, as
          strings. These strings will be used to build a dynamic
          regular expression so they are very powerful. Some
          examples: 
          
            ['03/08/2003', '09/16/2003'] would disable those
            exact dates
            ['03/08', '09/16'] would disable those days for
            every year
            ['^03/08'] would only match the beginning (useful
            if you are using short years)
            ['03/../2006'] would disable every day in March
            2006
            ['^03'] would disable every day in every March
          Note that the format of the dates included in the
          array should exactly match the 
          format
          config. In order to support regular expressions, if you
          are using a date format that has '.' in it, you will have
          to escape the dot when restricting dates. For example:
          ['03\\.08\\.03'].
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
	 *
        
        
          monthYearText
         : String
        The header month selector tooltip
        (defaults to 
        
          'Choose a month (Control+Up/Down to move years)'
        )
	 */
	
	public String getMonthYearText () {
		return (String) getStateHelper().eval(PropertyKeys.monthYearText);
	}

	/**
	 * <p>
	 * Set the value of the <code>monthYearText</code> property.
	 * </p>
	 */
	public void setMonthYearText ( String   monthYearText ) {
		getStateHelper().put(PropertyKeys.monthYearText, monthYearText);
		handleAttribute("monthYearText", monthYearText);
	}
    	/*
	 *A string used to format the message for
          displaying in a tooltip over the button that selects the
          current date. Defaults to 
          
            '{0} (Spacebar)'
           where the 
          {0} token is replaced by today's date.
	 */
	
	public String getTodayTip () {
		return (String) getStateHelper().eval(PropertyKeys.todayTip);
	}

	/**
	 * <p>
	 * Set the value of the <code>todayTip</code> property.
	 * </p>
	 */
	public void setTodayTip ( String   todayTip ) {
		getStateHelper().put(PropertyKeys.todayTip, todayTip);
		handleAttribute("todayTip", todayTip);
	}
    	/*
	 *
        
        
          prevText
         : String
        The previous month navigation button
        tooltip (defaults to 
        
          'Previous Month (Control+Left)'
        )
	 */
	
	public String getPrevText () {
		return (String) getStateHelper().eval(PropertyKeys.prevText);
	}

	/**
	 * <p>
	 * Set the value of the <code>prevText</code> property.
	 * </p>
	 */
	public void setPrevText ( String   prevText ) {
		getStateHelper().put(PropertyKeys.prevText, prevText);
		handleAttribute("prevText", prevText);
	}
    	/*
	 *
        
        
          okText
         : String
        The text to display on the ok button
        (defaults to 
        
          ' OK '
         to give the user extra clicking room)
	 */
	
	public String getOkText () {
		return (String) getStateHelper().eval(PropertyKeys.okText);
	}

	/**
	 * <p>
	 * Set the value of the <code>okText</code> property.
	 * </p>
	 */
	public void setOkText ( String   okText ) {
		getStateHelper().put(PropertyKeys.okText, okText);
		handleAttribute("okText", okText);
	}
    	/*
	 *The default date format string which
          can be overriden for localization support. The format
          must be valid according to 
          Date.parseDate
          (defaults to 
          
            'm/d/y'
          ).
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