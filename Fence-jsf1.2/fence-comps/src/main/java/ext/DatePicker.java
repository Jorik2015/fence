package ext;

import java.util.Date;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. Simple date
 * picker class.
 */
@XType("datepicker")
@InstanceOf("Ext.DatePicker")
public class DatePicker extends Component {
	public static final String COMPONENT_TYPE = "Ext.DatePicker";
	public static final String COMPONENT_FAMILY = "Ext.DatePicker";

	/**
	 * <p>
	 * Create a new {@link DatePicker} instance with default property values.
	 * </p>
	 */
	public DatePicker() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String cancelText;

	/**
	 * The text to display on the cancel button(defaults to <tt>'Cancel'</tt>)
	 */
	public String getCancelText() {
		if (null != this.cancelText) {
			return this.cancelText;
		}
		ValueExpression _ve = getValueExpression("cancelText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cancelText</code> property.
	 * </p>
	 */
	public void setCancelText(String cancelText) {
		this.cancelText = cancelText;
		this.handleConfig("cancelText", cancelText);
	}

	private Object dayNames;

	/**
	 * An array of textual day names which can beoverriden for localization
	 * support (defaults to Date.dayNames)
	 */
	@ClientConfig(JsonMode.Array)
	public Object getDayNames() {
		if (null != this.dayNames) {
			return this.dayNames;
		}
		ValueExpression _ve = getValueExpression("dayNames");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>dayNames</code> property.
	 * </p>
	 */
	public void setDayNames(Object dayNames) {
		this.dayNames = dayNames;
		this.handleConfig("dayNames", dayNames);
	}

	private Object disabledDates;

	/**
	 * An array of 'dates' to disable, as strings. Thesestrings will be used to
	 * build a dynamic regular expression so they are very powerful. Some
	 * examples:
	 * 
	 * <ul>
	 * <li>['03/08/2003', '09/16/2003'] would disable those exact dates</li>
	 * 
	 * <li>['03/08', '09/16'] would disable those days for every year</li>
	 * 
	 * <li>['^03/08'] would only match the beginning (useful if you are using
	 * short years)</li>
	 * 
	 * <li>['03/../2006'] would disable every day in March 2006</li>
	 * 
	 * <li>['^03'] would disable every day in every March</li>
	 * </ul>
	 * 
	 * Note that the format of the dates included in the array should exactly
	 * match the <a href="output/Ext.DatePicker.html#Ext.DatePicker-format"
	 * ext:member="format" ext:cls="Ext.DatePicker">format</a> config. In order
	 * to support regular expressions, if you are using a date format that has
	 * '.' in it, you will have to escape the dot when restricting dates. For
	 * example: ['03\\.08\\.03'].
	 */
	@ClientConfig(JsonMode.Array)
	public Object getDisabledDates() {
		if (null != this.disabledDates) {
			return this.disabledDates;
		}
		ValueExpression _ve = getValueExpression("disabledDates");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDates</code> property.
	 * </p>
	 */
	public void setDisabledDates(Object disabledDates) {
		this.disabledDates = disabledDates;
		this.handleConfig("disabledDates", disabledDates);
	}

	private String disabledDatesRE;

	/**
	 * JavaScript regular expression used to disable apattern of dates (defaults
	 * to null). The <a
	 * href="output/Ext.DatePicker.html#Ext.DatePicker-disabledDates"
	 * ext:member="disabledDates" ext:cls="Ext.DatePicker">disabledDates</a>
	 * config will generate this regex internally, but if you specify
	 * disabledDatesRE it will take precedence over the disabledDates value.
	 */
	@ClientConfig(JsonMode.Object)
	public String getDisabledDatesRE() {
		if (null != this.disabledDatesRE) {
			return this.disabledDatesRE;
		}
		ValueExpression _ve = getValueExpression("disabledDatesRE");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDatesRE</code> property.
	 * </p>
	 */
	public void setDisabledDatesRE(String disabledDatesRE) {
		this.disabledDatesRE = disabledDatesRE;
		this.handleConfig("disabledDatesRE", disabledDatesRE);
	}

	private String disabledDatesText;

	/**
	 * The tooltip text to display when the date fallson a disabled date
	 * (defaults to <tt>'Disabled'</tt>)
	 */
	public String getDisabledDatesText() {
		if (null != this.disabledDatesText) {
			return this.disabledDatesText;
		}
		ValueExpression _ve = getValueExpression("disabledDatesText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDatesText</code> property.
	 * </p>
	 */
	public void setDisabledDatesText(String disabledDatesText) {
		this.disabledDatesText = disabledDatesText;
		this.handleConfig("disabledDatesText", disabledDatesText);
	}

	private Object disabledDays;

	/**
	 * An array of days to disable, 0-based. Forexample, [0, 6] disables Sunday
	 * and Saturday (defaults to null).
	 */
	@ClientConfig(JsonMode.Array)
	public Object getDisabledDays() {
		if (null != this.disabledDays) {
			return this.disabledDays;
		}
		ValueExpression _ve = getValueExpression("disabledDays");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDays</code> property.
	 * </p>
	 */
	public void setDisabledDays(Object disabledDays) {
		this.disabledDays = disabledDays;
		this.handleConfig("disabledDays", disabledDays);
	}

	private String disabledDaysText;

	/**
	 * The tooltip to display when the date falls on adisabled day (defaults to
	 * <tt>'Disabled'</tt>)
	 */
	public String getDisabledDaysText() {
		if (null != this.disabledDaysText) {
			return this.disabledDaysText;
		}
		ValueExpression _ve = getValueExpression("disabledDaysText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disabledDaysText</code> property.
	 * </p>
	 */
	public void setDisabledDaysText(String disabledDaysText) {
		this.disabledDaysText = disabledDaysText;
		this.handleConfig("disabledDaysText", disabledDaysText);
	}

	private String format;

	/**
	 * The default date format string which can beoverriden for localization
	 * support. The format must be valid according to <a
	 * href="output/Date.html#Date-parseDate" ext:member="parseDate"
	 * ext:cls="Date">Date.parseDate</a> (defaults to <tt>'m/d/y'</tt>).
	 */
	public String getFormat() {
		if (null != this.format) {
			return this.format;
		}
		ValueExpression _ve = getValueExpression("format");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>format</code> property.
	 * </p>
	 */
	public void setFormat(String format) {
		this.format = format;
		this.handleConfig("format", format);
	}

	private Object handler;

	/**
	 * Optional. A function that will handle the selectevent of this picker. The
	 * handler is passed the following parameters:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><code>picker</code> : DatePicker
	 * 
	 * <div class="sub-desc">The Ext.DatePicker.</div></li>
	 * 
	 * <li><code>date</code> : Date
	 * 
	 * <div class="sub-desc">The selected date.</div></li>
	 * </ul>
	 * </div>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getHandler() {
		if (null != this.handler) {
			return this.handler;
		}
		ValueExpression _ve = getValueExpression("handler");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>handler</code> property.
	 * </p>
	 */
	public void setHandler(Object handler) {
		this.handler = handler;
		this.handleConfig("handler", handler);
	}

	private Date maxDate;

	/**
	 * Maximum allowable date (JavaScript date object,defaults to null)
	 */
	public Date getMaxDate() {
		if (null != this.maxDate) {
			return this.maxDate;
		}
		ValueExpression _ve = getValueExpression("maxDate");
		if (_ve != null) {
			return (Date) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxDate</code> property.
	 * </p>
	 */
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
		this.handleConfig("maxDate", maxDate);
	}

	private String maxText;

	/**
	 * The error text to display if the maxDatevalidation fails (defaults to <tt>'This date is after the maximum
date'</tt>)
	 */
	public String getMaxText() {
		if (null != this.maxText) {
			return this.maxText;
		}
		ValueExpression _ve = getValueExpression("maxText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxText</code> property.
	 * </p>
	 */
	public void setMaxText(String maxText) {
		this.maxText = maxText;
		this.handleConfig("maxText", maxText);
	}

	private Date minDate;

	/**
	 * Minimum allowable date (JavaScript date object,defaults to null)
	 */
	public Date getMinDate() {
		if (null != this.minDate) {
			return this.minDate;
		}
		ValueExpression _ve = getValueExpression("minDate");
		if (_ve != null) {
			return (Date) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minDate</code> property.
	 * </p>
	 */
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
		this.handleConfig("minDate", minDate);
	}

	private String minText;

	/**
	 * The error text to display if the minDatevalidation fails (defaults to <tt>'This date is before the minimum
date'</tt>)
	 */
	public String getMinText() {
		if (null != this.minText) {
			return this.minText;
		}
		ValueExpression _ve = getValueExpression("minText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minText</code> property.
	 * </p>
	 */
	public void setMinText(String minText) {
		this.minText = minText;
		this.handleConfig("minText", minText);
	}

	private Object monthNames;

	/**
	 * An array of textual month names which can beoverriden for localization
	 * support (defaults to Date.monthNames)
	 */
	@ClientConfig(JsonMode.Array)
	public Object getMonthNames() {
		if (null != this.monthNames) {
			return this.monthNames;
		}
		ValueExpression _ve = getValueExpression("monthNames");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>monthNames</code> property.
	 * </p>
	 */
	public void setMonthNames(Object monthNames) {
		this.monthNames = monthNames;
		this.handleConfig("monthNames", monthNames);
	}

	private String monthYearText;

	/**
	 * The header month selector tooltip (defaults to<tt>'Choose a month (Control+Up/Down to move years)'</tt>)
	 */
	public String getMonthYearText() {
		if (null != this.monthYearText) {
			return this.monthYearText;
		}
		ValueExpression _ve = getValueExpression("monthYearText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>monthYearText</code> property.
	 * </p>
	 */
	public void setMonthYearText(String monthYearText) {
		this.monthYearText = monthYearText;
		this.handleConfig("monthYearText", monthYearText);
	}

	private String nextText;

	/**
	 * The next month navigation button tooltip(defaults to <tt>'Next Month (Control+Right)'</tt>)
	 */
	public String getNextText() {
		if (null != this.nextText) {
			return this.nextText;
		}
		ValueExpression _ve = getValueExpression("nextText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>nextText</code> property.
	 * </p>
	 */
	public void setNextText(String nextText) {
		this.nextText = nextText;
		this.handleConfig("nextText", nextText);
	}

	private String okText;

	/**
	 * The text to display on the ok button (defaultsto <tt>'&nbsp;OK&nbsp;'</tt> to give the user
	 * extra clicking room)
	 */
	public String getOkText() {
		if (null != this.okText) {
			return this.okText;
		}
		ValueExpression _ve = getValueExpression("okText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>okText</code> property.
	 * </p>
	 */
	public void setOkText(String okText) {
		this.okText = okText;
		this.handleConfig("okText", okText);
	}

	private String prevText;

	/**
	 * The previous month navigation button tooltip(defaults to <tt>'Previous Month (Control+Left)'</tt>)
	 */
	public String getPrevText() {
		if (null != this.prevText) {
			return this.prevText;
		}
		ValueExpression _ve = getValueExpression("prevText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>prevText</code> property.
	 * </p>
	 */
	public void setPrevText(String prevText) {
		this.prevText = prevText;
		this.handleConfig("prevText", prevText);
	}

	private Object scope;

	/**
	 * The scope (<tt><b>this</b></tt> reference) inwhich the
	 * <code><a href="output/Ext.DatePicker.html#Ext.DatePicker-handler" ext:member="handler" ext:cls="Ext.DatePicker">handler</a></code>
	 * function will be called. Defaults to this DatePicker instance.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getScope() {
		if (null != this.scope) {
			return this.scope;
		}
		ValueExpression _ve = getValueExpression("scope");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope(Object scope) {
		this.scope = scope;
		this.handleConfig("scope", scope);
	}

	private Boolean showToday;

	/**
	 * False to hide the footer area containing theToday button and disable the
	 * keyboard handler for spacebar that selects the current date (defaults to
	 * <tt>true</tt>).
	 */
	public Boolean getShowToday() {
		if (null != this.showToday) {
			return this.showToday;
		}
		ValueExpression _ve = getValueExpression("showToday");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>showToday</code> property.
	 * </p>
	 */
	public void setShowToday(Boolean showToday) {
		this.showToday = showToday;
		this.handleConfig("showToday", showToday);
	}

	private Integer startDay;

	/**
	 * Day index at which the week should begin,0-based (defaults to 0, which is
	 * Sunday)
	 */
	public Integer getStartDay() {
		if (null != this.startDay) {
			return this.startDay;
		}
		ValueExpression _ve = getValueExpression("startDay");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>startDay</code> property.
	 * </p>
	 */
	public void setStartDay(Integer startDay) {
		this.startDay = startDay;
		this.handleConfig("startDay", startDay);
	}

	private String todayText;

	/**
	 * The text to display on the button that selectsthe current date (defaults
	 * to <tt>'Today'</tt>)
	 */
	public String getTodayText() {
		if (null != this.todayText) {
			return this.todayText;
		}
		ValueExpression _ve = getValueExpression("todayText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>todayText</code> property.
	 * </p>
	 */
	public void setTodayText(String todayText) {
		this.todayText = todayText;
		this.handleConfig("todayText", todayText);
	}

	private String todayTip;

	/**
	 * The tooltip to display for the button thatselects the current date
	 * (defaults to <tt>'{current date}
(Spacebar)'</tt>)
	 */
	public String getTodayTip() {
		if (null != this.todayTip) {
			return this.todayTip;
		}
		ValueExpression _ve = getValueExpression("todayTip");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>todayTip</code> property.
	 * </p>
	 */
	public void setTodayTip(String todayTip) {
		this.todayTip = todayTip;
		this.handleConfig("todayTip", todayTip);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[24];
		}
		_values[0] = super.saveState(_context);
		_values[1] = cancelText;
		_values[2] = dayNames;
		_values[3] = disabledDates;
		_values[4] = disabledDatesRE;
		_values[5] = disabledDatesText;
		_values[6] = disabledDays;
		_values[7] = disabledDaysText;
		_values[8] = format;
		_values[9] = handler;
		_values[10] = maxDate;
		_values[11] = maxText;
		_values[12] = minDate;
		_values[13] = minText;
		_values[14] = monthNames;
		_values[15] = monthYearText;
		_values[16] = nextText;
		_values[17] = okText;
		_values[18] = prevText;
		_values[19] = scope;
		_values[20] = showToday;
		_values[21] = startDay;
		_values[22] = todayText;
		_values[23] = todayTip;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.cancelText = (String) _values[1];
		this.handleConfig("cancelText", this.cancelText);
		this.dayNames = (Object) _values[2];
		this.handleConfig("dayNames", this.dayNames);
		this.disabledDates = (Object) _values[3];
		this.handleConfig("disabledDates", this.disabledDates);
		this.disabledDatesRE = (String) _values[4];
		this.handleConfig("disabledDatesRE", this.disabledDatesRE);
		this.disabledDatesText = (String) _values[5];
		this.handleConfig("disabledDatesText", this.disabledDatesText);
		this.disabledDays = (Object) _values[6];
		this.handleConfig("disabledDays", this.disabledDays);
		this.disabledDaysText = (String) _values[7];
		this.handleConfig("disabledDaysText", this.disabledDaysText);
		this.format = (String) _values[8];
		this.handleConfig("format", this.format);
		this.handler = (Object) _values[9];
		this.handleConfig("handler", this.handler);
		this.maxDate = (Date) _values[10];
		this.handleConfig("maxDate", this.maxDate);
		this.maxText = (String) _values[11];
		this.handleConfig("maxText", this.maxText);
		this.minDate = (Date) _values[12];
		this.handleConfig("minDate", this.minDate);
		this.minText = (String) _values[13];
		this.handleConfig("minText", this.minText);
		this.monthNames = (Object) _values[14];
		this.handleConfig("monthNames", this.monthNames);
		this.monthYearText = (String) _values[15];
		this.handleConfig("monthYearText", this.monthYearText);
		this.nextText = (String) _values[16];
		this.handleConfig("nextText", this.nextText);
		this.okText = (String) _values[17];
		this.handleConfig("okText", this.okText);
		this.prevText = (String) _values[18];
		this.handleConfig("prevText", this.prevText);
		this.scope = (Object) _values[19];
		this.handleConfig("scope", this.scope);
		this.showToday = (Boolean) _values[20];
		this.handleConfig("showToday", this.showToday);
		this.startDay = (Integer) _values[21];
		this.handleConfig("startDay", this.startDay);
		this.todayText = (String) _values[22];
		this.handleConfig("todayText", this.todayText);
		this.todayTip = (String) _values[23];
		this.handleConfig("todayTip", this.todayTip);

	}
}