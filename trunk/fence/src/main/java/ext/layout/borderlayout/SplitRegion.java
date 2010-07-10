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
 * 
    This is a specialized type of 
    BorderLayout
    region that has a built-in 
    Ext.SplitBar for user resizing of
    regions. The movement of the split bar is configurable to move
    either 
    smooth or
    incrementally.
  
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
			tickSize
			,collapsibleSplitTip
			,splitTip
			,useSplitTips
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
    	/*
	 *The tooltip to display when the user
          hovers over a 
          collapsible
          region's split bar (defaults to "Drag to resize. Double
          click to hide."). Only applies if 
          
          useSplitTips
          = true.
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
	 *The tooltip to display when the user
          hovers over a 
          non-collapsible
          region's split bar (defaults to 
          "Drag to resize."). Only applies if 
          
          useSplitTips
          = true.
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
	 *
          true to display a tooltip when the user hovers
          over a region's split bar (defaults to 
          false). The tooltip text will be the value of
          either 
          
            splitTip
           or 
          
            collapsibleSplitTip
           as appropriate.
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