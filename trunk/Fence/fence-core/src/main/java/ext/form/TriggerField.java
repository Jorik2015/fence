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
<div class="description">Provides a convenient wrapper for
  TextFields that adds a clickable trigger button (looks like a
  combobox by default). The trigger has no default action, so you
  must assign a function to implement the trigger click handler by
  overriding 
  <a ext:cls="Ext.form.TriggerField" ext:member="onTriggerClick" href="output/Ext.form.TriggerField.html#Ext.form.TriggerField-onTriggerClick">onTriggerClick</a>. You can
  create a TriggerField directly, as it renders exactly like a
  combobox for which you can provide a custom implementation. For
  example: 
<pre>
<code>
<b>var</b> trigger = 
<b>new</b> Ext.form.TriggerField();
trigger.onTriggerClick = myTriggerFn;
trigger.applyToMarkup(
<em>'my-field'</em>);</code>
  </pre>However, in general you will most likely want to use
  TriggerField as the base class for a reusable component. 
  <a ext:cls="Ext.form.DateField" href="output/Ext.form.DateField.html">Ext.form.DateField</a> and 
  <a ext:cls="Ext.form.ComboBox" href="output/Ext.form.ComboBox.html">Ext.form.ComboBox</a> are perfect
  examples of this.</div>

 */
@XType("trigger")
@InstanceOf("Ext.form.TriggerField")

@FacesComponent(value = "Ext.form.TriggerField")
public class TriggerField extends TextField {
	public static final String COMPONENT_FAMILY = "Ext.form.TriggerField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.TriggerField} instance with default property values.
	 * </p>
	 */
	public TriggerField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			wrapFocusClass
			,triggerConfig
			,readOnly
			,hideTrigger
			,autoCreate
			,triggerClass
			,editable
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
        
        
          wrapFocusClass
         : String
        The class added to the to the wrap of
        the trigger element. Defaults to 
        x-trigger-wrap-focus.
	 */
	
	public String getWrapFocusClass () {
		return (String) getStateHelper().eval(PropertyKeys.wrapFocusClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>wrapFocusClass</code> property.
	 * </p>
	 */
	public void setWrapFocusClass ( String   wrapFocusClass ) {
		getStateHelper().put(PropertyKeys.wrapFocusClass, wrapFocusClass);
		handleAttribute("wrapFocusClass", wrapFocusClass);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> config object
            specifying the structure of the trigger element for
            this Field. (Optional).</p>
            <p>Specify this when you need a customized element to
            act as the trigger button for a TriggerField.</p>
            <p>Note that when using this option, it is the
            developer's responsibility to ensure correct sizing,
            positioning and appearance of the trigger. Defaults
            to:</p>
<pre>
<code>{tag: 
<em>"img"</em>, src: Ext.BLANK_IMAGE_URL, cls: 
<em>"x-form-trigger "</em> + this.triggerClass}</code>
            </pre>
          </div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getTriggerConfig () {
		return (Object) getStateHelper().eval(PropertyKeys.triggerConfig);
	}

	/**
	 * <p>
	 * Set the value of the <code>triggerConfig</code> property.
	 * </p>
	 */
	public void setTriggerConfig ( Object   triggerConfig ) {
		getStateHelper().put(PropertyKeys.triggerConfig, triggerConfig);
		handleAttribute("triggerConfig", triggerConfig);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to prevent the user from changing the
          field, and hides the trigger. Superceeds the editable and
          hideTrigger options if the value is true. (defaults to 
          <tt>false</tt>)</div>

	 */
	
	public Boolean getReadOnly () {
		return (Boolean) getStateHelper().eval(PropertyKeys.readOnly);
	}

	/**
	 * <p>
	 * Set the value of the <code>readOnly</code> property.
	 * </p>
	 */
	public void setReadOnly ( Boolean   readOnly ) {
		getStateHelper().put(PropertyKeys.readOnly, readOnly);
		handleAttribute("readOnly", readOnly);
	}
    	/*
	 *
        
        
          hideTrigger
         : Boolean
        
        true to hide the trigger element and display only
        the base text field (defaults to 
        false)
	 */
	
	public Boolean getHideTrigger () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideTrigger);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideTrigger</code> property.
	 * </p>
	 */
	public void setHideTrigger ( Boolean   hideTrigger ) {
		getStateHelper().put(PropertyKeys.hideTrigger, hideTrigger);
		handleAttribute("hideTrigger", hideTrigger);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element spec, or
            true for a default element spec. Used to create the 
            <a ext:cls="Ext.Component" ext:member="getEl" href="output/Ext.Component.html#Ext.Component-getEl">Element</a>
            which will encapsulate this Component. See 
            <tt>
              <a ext:cls="Ext.Component" ext:member="autoEl" href="output/Ext.Component.html#Ext.Component-autoEl">autoEl</a>
            </tt> for details. Defaults to:</p>
<pre>
<code>{tag: 
<em>"input"</em>, type: 
<em>"text"</em>, size: 
<em>"16"</em>, autocomplete: 
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
<div class="long">An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          <tt>'x-form-trigger'</tt> by default and 
          <tt>triggerClass</tt> will be 
          <b>appended</b> if specified.</div>

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
<div class="long">
          <tt>false</tt> to prevent the user from typing text
          directly into the field, the field will only respond to a
          click on the trigger to set the value. (defaults to 
          <tt>true</tt>).</div>

	 */
	
	public Boolean getEditable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.editable);
	}

	/**
	 * <p>
	 * Set the value of the <code>editable</code> property.
	 * </p>
	 */
	public void setEditable ( Boolean   editable ) {
		getStateHelper().put(PropertyKeys.editable, editable);
		handleAttribute("editable", editable);
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