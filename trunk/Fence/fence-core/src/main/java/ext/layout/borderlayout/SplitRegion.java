package ext.layout.borderlayout;

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
<div class="description">
    <p>This is a specialized type of 
    <a ext:cls="Ext.layout.BorderLayout.Region" href="output/Ext.layout.BorderLayout.Region.html">BorderLayout
    region</a> that has a built-in 
    <a ext:cls="Ext.SplitBar" href="output/Ext.SplitBar.html">Ext.SplitBar</a> for user resizing of
    regions. The movement of the split bar is configurable to move
    either 
    <a ext:cls="Ext.layout.BorderLayout.SplitRegion" ext:member="tickSize" href="output/Ext.layout.BorderLayout.SplitRegion.html#Ext.layout.BorderLayout.SplitRegion-tickSize">smooth or
    incrementally</a>.</p>
  </div>

 */

@InstanceOf("Ext.layout.BorderLayout.SplitRegion")
@ParseConfigMode(ui = false,pmode=PersistenceMode.InnerProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.layout.BorderLayout.SplitRegion")
public class SplitRegion extends Region {
	public static final String COMPONENT_FAMILY = "Ext.layout.BorderLayout.SplitRegion";

	/**
	 * <p>
	 * Create a new {@link Ext.layout.BorderLayout.SplitRegion} instance with default property values.
	 * </p>
	 */
	public SplitRegion() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			collapsibleSplitTip
			,splitTip
			,useSplitTips
			,tickSize
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
<div class="long">The tooltip to display when the user
          hovers over a 
          <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="collapsible" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapsible">collapsible</a>
          region's split bar (defaults to "Drag to resize. Double
          click to hide."). Only applies if 
          <tt>
          <a ext:cls="Ext.layout.BorderLayout.SplitRegion" ext:member="useSplitTips" href="output/Ext.layout.BorderLayout.SplitRegion.html#Ext.layout.BorderLayout.SplitRegion-useSplitTips">useSplitTips</a>
          = true</tt>.</div>

	 */
	
	public String getCollapsibleSplitTip () {
		return (String) getStateHelper().eval(PropertyKeys.collapsibleSplitTip);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsibleSplitTip</code> property.
	 * </p>
	 */
	public void setCollapsibleSplitTip ( String   collapsibleSplitTip ) {
		getStateHelper().put(PropertyKeys.collapsibleSplitTip, collapsibleSplitTip);
		handleAttribute("collapsibleSplitTip", collapsibleSplitTip);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The tooltip to display when the user
          hovers over a 
          <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="collapsible" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapsible">non-collapsible</a>
          region's split bar (defaults to 
          <tt>"Drag to resize."</tt>). Only applies if 
          <tt>
          <a ext:cls="Ext.layout.BorderLayout.SplitRegion" ext:member="useSplitTips" href="output/Ext.layout.BorderLayout.SplitRegion.html#Ext.layout.BorderLayout.SplitRegion-useSplitTips">useSplitTips</a>
          = true</tt>.</div>

	 */
	
	public String getSplitTip () {
		return (String) getStateHelper().eval(PropertyKeys.splitTip);
	}

	/**
	 * <p>
	 * Set the value of the <code>splitTip</code> property.
	 * </p>
	 */
	public void setSplitTip ( String   splitTip ) {
		getStateHelper().put(PropertyKeys.splitTip, splitTip);
		handleAttribute("splitTip", splitTip);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to display a tooltip when the user hovers
          over a region's split bar (defaults to 
          <tt>false</tt>). The tooltip text will be the value of
          either 
          <tt>
            <a ext:cls="Ext.layout.BorderLayout.SplitRegion" ext:member="splitTip" href="output/Ext.layout.BorderLayout.SplitRegion.html#Ext.layout.BorderLayout.SplitRegion-splitTip">splitTip</a>
          </tt> or 
          <tt>
            <a ext:cls="Ext.layout.BorderLayout.SplitRegion" ext:member="collapsibleSplitTip" href="output/Ext.layout.BorderLayout.SplitRegion.html#Ext.layout.BorderLayout.SplitRegion-collapsibleSplitTip">collapsibleSplitTip</a>
          </tt> as appropriate.</div>

	 */
	
	public Boolean getUseSplitTips () {
		return (Boolean) getStateHelper().eval(PropertyKeys.useSplitTips);
	}

	/**
	 * <p>
	 * Set the value of the <code>useSplitTips</code> property.
	 * </p>
	 */
	public void setUseSplitTips ( Boolean   useSplitTips ) {
		getStateHelper().put(PropertyKeys.useSplitTips, useSplitTips);
		handleAttribute("useSplitTips", useSplitTips);
	}
    	/*
	 *
        
        
          tickSize
         : Number
        The increment, in pixels by which to
        move this Region's 
        SplitBar. By default, the 
        SplitBar moves
        smoothly.
	 */
	
	public Integer getTickSize () {
		return (Integer) getStateHelper().eval(PropertyKeys.tickSize);
	}

	/**
	 * <p>
	 * Set the value of the <code>tickSize</code> property.
	 * </p>
	 */
	public void setTickSize ( Integer   tickSize ) {
		getStateHelper().put(PropertyKeys.tickSize, tickSize);
		handleAttribute("tickSize", tickSize);
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