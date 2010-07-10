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
 * Single checkbox field. Can be used as a
  direct replacement for traditional checkbox fields.
 */
@XType("checkbox")
@InstanceOf("Ext.form.Checkbox")

@FacesComponent(value = "Ext.form.Checkbox")
public class Checkbox extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.Checkbox";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Checkbox} instance with default property values.
	 * </p>
	 */
	public Checkbox() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			inputValue
			,handler
			,autoCreate
			,fieldClass
			,scope
			,checked
			,focusClass
			,boxLabel
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
        
        
          inputValue
         : String
        The value that should go into the
        generated input element's value attribute
	 */
	
	public String getInputValue () {
		return (String) getStateHelper().eval(PropertyKeys.inputValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>inputValue</code> property.
	 * </p>
	 */
	public void setInputValue ( String   inputValue ) {
		getStateHelper().put(PropertyKeys.inputValue, inputValue);
		handleAttribute("inputValue", inputValue);
	}
    	/*
	 *A function called when the 
          checked value changes
          (can be used instead of handling the check event). The
          handler is passed the following parameters: 
          
            
              
              checkbox : Ext.form.Checkbox
              The Checkbox being
              toggled.
              
              checked : Boolean
              The new checked state of the
              checkbox.
            
          
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
	 *A DomHelper element spec, or true for a
          default element spec (defaults to {tag: 'input', type:
          'checkbox', autocomplete: 'off'})
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
        
        
          fieldClass
         : String
        The default CSS class for the checkbox
        (defaults to 'x-form-field')
	 */
	
	public String getFieldClass () {
		return (String) getStateHelper().eval(PropertyKeys.fieldClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldClass</code> property.
	 * </p>
	 */
	public void setFieldClass ( String   fieldClass ) {
		getStateHelper().put(PropertyKeys.fieldClass, fieldClass);
		handleAttribute("fieldClass", fieldClass);
	}
    	/*
	 *
        
        
          scope
         : Object
        An object to use as the scope ('this'
        reference) of the 
        handler function (defaults
        to this Checkbox).
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
	 *
        
        
          checked
         : Boolean
        
        true if the checkbox should render initially
        checked (defaults to 
        false)
	 */
	
	public Boolean getChecked () {
		return (Boolean) getStateHelper().eval(PropertyKeys.checked);
	}

	/**
	 * <p>
	 * Set the value of the <code>checked</code> property.
	 * </p>
	 */
	public void setChecked ( Boolean   checked ) {
		getStateHelper().put(PropertyKeys.checked, checked);
		handleAttribute("checked", checked);
	}
    	/*
	 *
        
        
          focusClass
         : String
        The CSS class to use when the checkbox
        receives focus (defaults to undefined)
	 */
	
	public String getFocusClass () {
		return (String) getStateHelper().eval(PropertyKeys.focusClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>focusClass</code> property.
	 * </p>
	 */
	public void setFocusClass ( String   focusClass ) {
		getStateHelper().put(PropertyKeys.focusClass, focusClass);
		handleAttribute("focusClass", focusClass);
	}
    	/*
	 *
        
        
          boxLabel
         : String
        The text that appears beside the
        checkbox
	 */
	
	public String getBoxLabel () {
		return (String) getStateHelper().eval(PropertyKeys.boxLabel);
	}

	/**
	 * <p>
	 * Set the value of the <code>boxLabel</code> property.
	 * </p>
	 */
	public void setBoxLabel ( String   boxLabel ) {
		getStateHelper().put(PropertyKeys.boxLabel, boxLabel);
		handleAttribute("boxLabel", boxLabel);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "check"
				));
				return superEvent;
	}
}