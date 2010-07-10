package com.abner.fence.component.ux;

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
 * ${ext.commonts}
 */
@XType("mif")
@InstanceOf("Ext.ux.ManagedIFrame.Component")

@FacesComponent(value = "Ext.ux.ManagedIFrame.Component")
public class MifComponentAdapter extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.ux.ManagedIFrame.Component";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.ManagedIFrame.Component} instance with default property values.
	 * </p>
	 */
	public MifComponentAdapter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			autoScroll
			,defaultSrc
			,focusOnLoad
			,frameConfig
			,unsupportedText
			,useShim
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
	 *$cfg.commonts
	 */
	
	public Boolean getAutoScroll () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoScroll);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoScroll</code> property.
	 * </p>
	 */
	public void setAutoScroll ( Boolean   autoScroll ) {
		getStateHelper().put(PropertyKeys.autoScroll, autoScroll);
		handleAttribute("autoScroll", autoScroll);
	}
    	/*
	 *$cfg.commonts
	 */
	
	public String getDefaultSrc () {
		return (String) getStateHelper().eval(PropertyKeys.defaultSrc);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultSrc</code> property.
	 * </p>
	 */
	public void setDefaultSrc ( String   defaultSrc ) {
		getStateHelper().put(PropertyKeys.defaultSrc, defaultSrc);
		handleAttribute("defaultSrc", defaultSrc);
	}
    	/*
	 *$cfg.commonts
	 */
	
	public Boolean getFocusOnLoad () {
		return (Boolean) getStateHelper().eval(PropertyKeys.focusOnLoad);
	}

	/**
	 * <p>
	 * Set the value of the <code>focusOnLoad</code> property.
	 * </p>
	 */
	public void setFocusOnLoad ( Boolean   focusOnLoad ) {
		getStateHelper().put(PropertyKeys.focusOnLoad, focusOnLoad);
		handleAttribute("focusOnLoad", focusOnLoad);
	}
    	/*
	 *$cfg.commonts
	 */
	@ClientConfig(JsonMode.Object)
	public Object getFrameConfig () {
		return (Object) getStateHelper().eval(PropertyKeys.frameConfig);
	}

	/**
	 * <p>
	 * Set the value of the <code>frameConfig</code> property.
	 * </p>
	 */
	public void setFrameConfig ( Object   frameConfig ) {
		getStateHelper().put(PropertyKeys.frameConfig, frameConfig);
		handleAttribute("frameConfig", frameConfig);
	}
    	/*
	 *$cfg.commonts
	 */
	
	public String getUnsupportedText () {
		return (String) getStateHelper().eval(PropertyKeys.unsupportedText);
	}

	/**
	 * <p>
	 * Set the value of the <code>unsupportedText</code> property.
	 * </p>
	 */
	public void setUnsupportedText ( String   unsupportedText ) {
		getStateHelper().put(PropertyKeys.unsupportedText, unsupportedText);
		handleAttribute("unsupportedText", unsupportedText);
	}
    	/*
	 *$cfg.commonts
	 */
	
	public Boolean getUseShim () {
		return (Boolean) getStateHelper().eval(PropertyKeys.useShim);
	}

	/**
	 * <p>
	 * Set the value of the <code>useShim</code> property.
	 * </p>
	 */
	public void setUseShim ( Boolean   useShim ) {
		getStateHelper().put(PropertyKeys.useShim, useShim);
		handleAttribute("useShim", useShim);
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