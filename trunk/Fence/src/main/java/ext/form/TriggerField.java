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
 * Provides a convenient wrapper for
  TextFields that adds a clickable trigger button (looks like a
  combobox by default). The trigger has no default action, so you
  must assign a function to implement the trigger click handler by
  overriding 
  onTriggerClick. You can
  create a TriggerField directly, as it renders exactly like a
  combobox for which you can provide a custom implementation. For
  example: 


var trigger = 
new Ext.form.TriggerField();
trigger.onTriggerClick = myTriggerFn;
trigger.applyToMarkup(
'my-field');
  However, in general you will most likely want to use
  TriggerField as the base class for a reusable component. 
  Ext.form.DateField and 
  Ext.form.ComboBox are perfect
  examples of this.
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
			editable
			,wrapFocusClass
			,autoCreate
			,hideTrigger
			,triggerConfig
			,readOnly
			,triggerClass
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
          false to prevent the user from typing text
          directly into the field, the field will only respond to a
          click on the trigger to set the value. (defaults to 
          true).
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
	 *
            A 
            DomHelper element spec, or
            true for a default element spec. Used to create the 
            Element
            which will encapsulate this Component. See 
            
              autoEl
             for details. Defaults to:

{tag: 
"input", type: 
"text", size: 
"16", autocomplete: 
"off"}
            
          
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
	 *
            A 
            DomHelper config object
            specifying the structure of the trigger element for
            this Field. (Optional).
            Specify this when you need a customized element to
            act as the trigger button for a TriggerField.
            Note that when using this option, it is the
            developer's responsibility to ensure correct sizing,
            positioning and appearance of the trigger. Defaults
            to:

{tag: 
"img", src: Ext.BLANK_IMAGE_URL, cls: 
"x-form-trigger " + this.triggerClass}
            
          
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
	 *
          true to prevent the user from changing the
          field, and hides the trigger. Superceeds the editable and
          hideTrigger options if the value is true. (defaults to 
          false)
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
	 *An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          'x-form-trigger' by default and 
          triggerClass will be 
          appended if specified.
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