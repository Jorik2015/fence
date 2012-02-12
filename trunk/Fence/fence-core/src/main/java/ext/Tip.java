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
 */

@InstanceOf("Ext.Tip")

@FacesComponent(value = "Ext.Tip")
public class Tip extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.Tip";

	/**
	 * <p>
	 * Create a new {@link Ext.Tip} instance with default property values.
	 * </p>
	 */
	public Tip() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			closable
			,minWidth
			,shadow
			,width
			,maxWidth
			,defaultAlign
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
        
        
          closable
         : Boolean
        True to render a close tool button into
        the tooltip header (defaults to false).
	 */
	
	public Boolean getClosable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.closable);
	}

	/**
	 * <p>
	 * Set the value of the <code>closable</code> property.
	 * </p>
	 */
	public void setClosable ( Boolean   closable ) {
		getStateHelper().put(PropertyKeys.closable, closable);
		handleAttribute("closable", closable);
	}
    	/*
	 *
        
        
          minWidth
         : Number
        The minimum width of the tip in pixels
        (defaults to 40).
	 */
	
	public Integer getMinWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth ( Integer   minWidth ) {
		getStateHelper().put(PropertyKeys.minWidth, minWidth);
		handleAttribute("minWidth", minWidth);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True or "sides" for the default effect,
          "frame" for 4-way shadow, and "drop" for bottom-right
          shadow (defaults to "sides").</div>

	 */
	
	public Boolean getShadow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.shadow);
	}

	/**
	 * <p>
	 * Set the value of the <code>shadow</code> property.
	 * </p>
	 */
	public void setShadow ( Boolean   shadow ) {
		getStateHelper().put(PropertyKeys.shadow, shadow);
		handleAttribute("shadow", shadow);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Width in pixels of the tip (defaults to
          auto). Width will be ignored if it exceeds the bounds of 
          <a ext:cls="Ext.Tip" ext:member="minWidth" href="output/Ext.Tip.html#Ext.Tip-minWidth">minWidth</a> or 
          <a ext:cls="Ext.Tip" ext:member="maxWidth" href="output/Ext.Tip.html#Ext.Tip-maxWidth">maxWidth</a>. The
          maximum supported value is 500.</div>

	 */
	
	public Integer getWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.width);
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth ( Integer   width ) {
		getStateHelper().put(PropertyKeys.width, width);
		handleAttribute("width", width);
	}
    	/*
	 *
        
        
          maxWidth
         : Number
        The maximum width of the tip in pixels
        (defaults to 300). The maximum supported value is
        500.
	 */
	
	public Integer getMaxWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxWidth</code> property.
	 * </p>
	 */
	public void setMaxWidth ( Integer   maxWidth ) {
		getStateHelper().put(PropertyKeys.maxWidth, maxWidth);
		handleAttribute("maxWidth", maxWidth);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <b>Experimental</b>. The default 
          <a ext:cls="Ext.Element" ext:member="alignTo" href="output/Ext.Element.html#Ext.Element-alignTo">Ext.Element.alignTo</a> anchor
          position value for this tip relative to its element of
          origin (defaults to "tl-bl?").</div>

	 */
	
	public String getDefaultAlign () {
		return (String) getStateHelper().eval(PropertyKeys.defaultAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultAlign</code> property.
	 * </p>
	 */
	public void setDefaultAlign ( String   defaultAlign ) {
		getStateHelper().put(PropertyKeys.defaultAlign, defaultAlign);
		handleAttribute("defaultAlign", defaultAlign);
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