package ext.chart;

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
<div class="description">The Ext.chart package provides the
  capability to visualize data with flash based charting. Each
  chart binds directly to an Ext.data.Store enabling automatic
  updates of the chart. To change the look and feel of a chart, see
  the 
  <a ext:cls="Ext.chart.Chart" ext:member="chartStyle" href="output/Ext.chart.Chart.html#Ext.chart.Chart-chartStyle">chartStyle</a>
  and 
  <a ext:cls="Ext.chart.Chart" ext:member="extraStyle" href="output/Ext.chart.Chart.html#Ext.chart.Chart-extraStyle">extraStyle</a>
  config options.</div>

 */
@XType("chart")
@InstanceOf("Ext.chart.Chart")

@FacesComponent(value = "Ext.chart.Chart")
public class Chart extends FlashComponent {
	public static final String COMPONENT_FAMILY = "Ext.chart.Chart";

	/**
	 * <p>
	 * Create a new {@link Ext.chart.Chart} instance with default property values.
	 * </p>
	 */
	public Chart() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			seriesStyles
			,extraStyle
			,disableCaching
			,chartStyle
			,url
			,store
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
        
        
          seriesStyles
         : Object
        Contains styles to apply to the series
        after a refresh. Defaults to 
        null.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getSeriesStyles () {
		return (Object) getStateHelper().eval(PropertyKeys.seriesStyles);
	}

	/**
	 * <p>
	 * Set the value of the <code>seriesStyles</code> property.
	 * </p>
	 */
	public void setSeriesStyles ( Object   seriesStyles ) {
		getStateHelper().put(PropertyKeys.seriesStyles, seriesStyles);
		handleAttribute("seriesStyles", seriesStyles);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Contains extra styles that will be
          added or overwritten to the default chartStyle. Defaults
          to 
          <tt>null</tt>. For a detailed list of the options
          available, visit the YUI Charts site at 
          <a href="http://developer.yahoo.com/yui/charts/#basicstyles">http://developer.yahoo.com/yui/charts/#basicstyles</a>
          <br/>Some of the options availabe:
          <br/>
          <ul style="padding:5px;padding-left:16px;list-style-type:inherit;">
            <li>
            <b>padding</b> - The space around the edge of the
            chart's contents. Padding does not increase the size of
            the chart.</li>
            <li>
            <b>animationEnabled</b> - A Boolean value that
            specifies whether marker animations are enabled or not.
            Enabled by default.</li>
            <li>
            <b>font</b> - An Object defining the font style to be
            used in the chart. Defaults to 
            <tt>{ name: 'Tahoma', color: 0x444444, size: 11 }</tt>
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>name</b> - font name</li>
              <li>
              <b>color</b> - font color (hex code, ie: "#ff0000",
              "ff0000" or 0xff0000)</li>
              <li>
              <b>size</b> - font size in points (numeric portion
              only, ie: 11)</li>
              <li>
              <b>bold</b> - boolean</li>
              <li>
              <b>italic</b> - boolean</li>
              <li>
              <b>underline</b> - boolean</li>
            </ul>
</li>
            <li>
            <b>border</b> - An object defining the border style
            around the chart. The chart itself will decrease in
            dimensions to accomodate the border.
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>color</b> - border color (hex code, ie: "#ff0000",
              "ff0000" or 0xff0000)</li>
              <li>
              <b>size</b> - border size in pixels (numeric portion
              only, ie: 1)</li>
            </ul>
</li>
            <li>
            <b>background</b> - An object defining the background
            style of the chart.
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>color</b> - border color (hex code, ie: "#ff0000",
              "ff0000" or 0xff0000)</li>
              <li>
              <b>image</b> - an image URL. May be relative to the
              current document or absolute.</li>
            </ul>
</li>
            <li>
            <b>legend</b> - An object defining the legend style
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>display</b> - location of the legend. Possible
              values are "none", "left", "right", "top", and
              "bottom".</li>
              <li>
              <b>spacing</b> - an image URL. May be relative to the
              current document or absolute.</li>
              <li>
              <b>padding, border, background, font</b> - same
              options as described above.</li>
            </ul>
</li>
            <li>
            <b>dataTip</b> - An object defining the style of the
            data tip (tooltip).
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>padding, border, background, font</b> - same
              options as described above.</li>
            </ul>
</li>
            <li>
            <b>xAxis and yAxis</b> - An object defining the style
            of the style of either axis.
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>color</b> - same option as described above.</li>
              <li>
              <b>size</b> - same option as described above.</li>
              <li>
              <b>showLabels</b> - boolean</li>
              <li>
              <b>labelRotation</b> - a value in degrees from -90
              through 90. Default is zero.</li>
            </ul>
</li>
            <li>
            <b>majorGridLines and minorGridLines</b> - An object
            defining the style of the style of the grid lines.
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>color, size</b> - same options as described
              above.</li>
            </ul>
</li>
            <li>
            <b>zeroGridLine</b> - An object defining the style of
            the style of the zero grid line.
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>color, size</b> - same options as described
              above.</li>
            </ul>
</li>
            <li>
            <b>majorTicks and minorTicks</b> - An object defining
            the style of the style of ticks in the chart.
            <br/>
            <ul style="padding:5px;padding-left:26px;list-style-type:circle;">
              <li>
              <b>color, size</b> - same options as described
              above.</li>
              <li>
              <b>length</b> - the length of each tick in pixels
              extending from the axis.</li>
              <li>
              <b>display</b> - how the ticks are drawn. Possible
              values are "none", "inside", "outside", and
              "cross".</li>
            </ul>
</li>
          </ul>
</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getExtraStyle () {
		return (Object) getStateHelper().eval(PropertyKeys.extraStyle);
	}

	/**
	 * <p>
	 * Set the value of the <code>extraStyle</code> property.
	 * </p>
	 */
	public void setExtraStyle ( Object   extraStyle ) {
		getStateHelper().put(PropertyKeys.extraStyle, extraStyle);
		handleAttribute("extraStyle", extraStyle);
	}
    	/*
	 *
        
        
          disableCaching
         : Boolean
        True to add a "cache buster" to the end
        of the chart url. Defaults to true for Opera and
        IE.
	 */
	
	public Boolean getDisableCaching () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disableCaching);
	}

	/**
	 * <p>
	 * Set the value of the <code>disableCaching</code> property.
	 * </p>
	 */
	public void setDisableCaching ( Boolean   disableCaching ) {
		getStateHelper().put(PropertyKeys.disableCaching, disableCaching);
		handleAttribute("disableCaching", disableCaching);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Sets styles for this chart. This
          contains default styling, so modifying this property will
          
          <b>override</b> the built in styles of the chart. Use 
          <a ext:cls="Ext.chart.Chart" ext:member="extraStyle" href="output/Ext.chart.Chart.html#Ext.chart.Chart-extraStyle">extraStyle</a> to add
          customizations to the default styling.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getChartStyle () {
		return (Object) getStateHelper().eval(PropertyKeys.chartStyle);
	}

	/**
	 * <p>
	 * Set the value of the <code>chartStyle</code> property.
	 * </p>
	 */
	public void setChartStyle ( Object   chartStyle ) {
		getStateHelper().put(PropertyKeys.chartStyle, chartStyle);
		handleAttribute("chartStyle", chartStyle);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The url to load the chart from. This
          defaults to Ext.chart.Chart.CHART_URL, which should be
          modified to point to the local charts resource.</div>

	 */
	
	public String getUrl () {
		return (String) getStateHelper().eval(PropertyKeys.url);
	}

	/**
	 * <p>
	 * Set the value of the <code>url</code> property.
	 * </p>
	 */
	public void setUrl ( String   url ) {
		getStateHelper().put(PropertyKeys.url, url);
		handleAttribute("url", url);
	}
    	/*
	 *$cfg.commonts
	 */
	@ClientConfig(value = JsonMode.Object)
	public Object getStore () {
		return (Object) getStateHelper().eval(PropertyKeys.store);
	}

	/**
	 * <p>
	 * Set the value of the <code>store</code> property.
	 * </p>
	 */
	public void setStore ( Object   store ) {
		getStateHelper().put(PropertyKeys.store, store);
		handleAttribute("store", store);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforerefresh"
					, "refresh"
				));
				return superEvent;
	}
}