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
 * The Ext.chart package provides the
  capability to visualize data with flash based charting. Each
  chart binds directly to an Ext.data.Store enabling automatic
  updates of the chart. To change the look and feel of a chart, see
  the 
  chartStyle
  and 
  extraStyle
  config options.
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
			chartStyle
			,seriesStyles
			,disableCaching
			,url
			,extraStyle
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
	 *Sets styles for this chart. This
          contains default styling, so modifying this property will
          
          override the built in styles of the chart. Use 
          extraStyle to add
          customizations to the default styling.
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
	 *The url to load the chart from. This
          defaults to Ext.chart.Chart.CHART_URL, which should be
          modified to point to the local charts resource.
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
	 *Contains extra styles that will be
          added or overwritten to the default chartStyle. Defaults
          to 
          null. For a detailed list of the options
          available, visit the YUI Charts site at 
          http://developer.yahoo.com/yui/charts/#basicstyles
          Some of the options availabe:
          
          
            
            padding - The space around the edge of the
            chart's contents. Padding does not increase the size of
            the chart.
            
            animationEnabled - A Boolean value that
            specifies whether marker animations are enabled or not.
            Enabled by default.
            
            font - An Object defining the font style to be
            used in the chart. Defaults to 
            { name: 'Tahoma', color: 0x444444, size: 11 }
            
            
              
              name - font name
              
              color - font color (hex code, ie: "#ff0000",
              "ff0000" or 0xff0000)
              
              size - font size in points (numeric portion
              only, ie: 11)
              
              bold - boolean
              
              italic - boolean
              
              underline - boolean
            
            
            border - An object defining the border style
            around the chart. The chart itself will decrease in
            dimensions to accomodate the border.
            
            
              
              color - border color (hex code, ie: "#ff0000",
              "ff0000" or 0xff0000)
              
              size - border size in pixels (numeric portion
              only, ie: 1)
            
            
            background - An object defining the background
            style of the chart.
            
            
              
              color - border color (hex code, ie: "#ff0000",
              "ff0000" or 0xff0000)
              
              image - an image URL. May be relative to the
              current document or absolute.
            
            
            legend - An object defining the legend style
            
            
              
              display - location of the legend. Possible
              values are "none", "left", "right", "top", and
              "bottom".
              
              spacing - an image URL. May be relative to the
              current document or absolute.
              
              padding, border, background, font - same
              options as described above.
            
            
            dataTip - An object defining the style of the
            data tip (tooltip).
            
            
              
              padding, border, background, font - same
              options as described above.
            
            
            xAxis and yAxis - An object defining the style
            of the style of either axis.
            
            
              
              color - same option as described above.
              
              size - same option as described above.
              
              showLabels - boolean
              
              labelRotation - a value in degrees from -90
              through 90. Default is zero.
            
            
            majorGridLines and minorGridLines - An object
            defining the style of the style of the grid lines.
            
            
              
              color, size - same options as described
              above.
            
            
            zeroGridLine - An object defining the style of
            the style of the zero grid line.
            
            
              
              color, size - same options as described
              above.
            
            
            majorTicks and minorTicks - An object defining
            the style of the style of ticks in the chart.
            
            
              
              color, size - same options as described
              above.
              
              length - the length of each tick in pixels
              extending from the axis.
              
              display - how the ticks are drawn. Possible
              values are "none", "inside", "outside", and
              "cross".
            
          
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