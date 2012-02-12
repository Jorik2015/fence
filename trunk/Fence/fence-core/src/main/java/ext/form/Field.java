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
<div class="description">Base class for form fields that provides
  default event handling, sizing, value handling and other
  functionality.</div>

 */
@XType("field")
@InstanceOf("Ext.form.Field")

@FacesComponent(value = "Ext.form.Field")
public class Field extends com.abner.fence.component.ExtInput {
	public static final String COMPONENT_FAMILY = "Ext.form.Field";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Field} instance with default property values.
	 * </p>
	 */
	public Field() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			cls
			,fieldClass
			,tabIndex
			,autoCreate
			,msgTarget
			,invalidText
			,invalidClass
			,focusClass
			,validationDelay
			,msgFx
			,readOnly
			,validationEvent
			,submitValue
			,inputType
			,name
			,validateOnBlur
			,preventMark
			,disabled
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
        
        
          cls
         : String
        A custom CSS class to apply to the
        field's underlying element (defaults to '').
	 */
	
	public String getCls () {
		return (String) getStateHelper().eval(PropertyKeys.cls);
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls ( String   cls ) {
		getStateHelper().put(PropertyKeys.cls, cls);
		handleAttribute("cls", cls);
	}
    	/*
	 *
        
        
          fieldClass
         : String
        The default CSS class for the field
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The tabIndex for this field. Note this
          only applies to fields that are rendered, not those which
          are built via applyTo (defaults to undefined).</div>

	 */
	
	public Integer getTabIndex () {
		return (Integer) getStateHelper().eval(PropertyKeys.tabIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>tabIndex</code> property.
	 * </p>
	 */
	public void setTabIndex ( Integer   tabIndex ) {
		getStateHelper().put(PropertyKeys.tabIndex, tabIndex);
		handleAttribute("tabIndex", tabIndex);
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
<em>'input'</em>, type: 
<em>'text'</em>, size: 
<em>'20'</em>, autocomplete: 
<em>'off'</em>}</code>
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
<div class="long">
            <p>The location where the message text set through 
            <a ext:cls="Ext.form.Field" ext:member="markInvalid" href="output/Ext.form.Field.html#Ext.form.Field-markInvalid">markInvalid</a> should
            display. Must be one of the following values:</p>
            <div class="mdetail-params">
              <ul>
                <li>
                <code>qtip</code> Display a quick tip containing
                the message when the user hovers over the field.
                This is the default. 
                <div class="subdesc">
                  <b>
                  <a ext:cls="Ext.QuickTips" ext:member="init" href="output/Ext.QuickTips.html#Ext.QuickTips-init">Ext.QuickTips.init</a>
                  must have been called for this setting to
                  work.</b>
                </div>
</li>
                <li>
                <code>title</code> Display the message in a default
                browser title attribute popup.</li>
                <li>
                <code>under</code> Add a block div beneath the
                field containing the error message.</li>
                <li>
                <code>side</code> Add an error icon to the right of
                the field, displaying the message in a popup on
                hover.</li>
                <li>
                <code>[element id]</code> Add the error message
                directly to the innerHTML of the specified
                element.</li>
              </ul>
            </div>
          </div>

	 */
	
	public String getMsgTarget () {
		return (String) getStateHelper().eval(PropertyKeys.msgTarget);
	}

	/**
	 * <p>
	 * Set the value of the <code>msgTarget</code> property.
	 * </p>
	 */
	public void setMsgTarget ( String   msgTarget ) {
		getStateHelper().put(PropertyKeys.msgTarget, msgTarget);
		handleAttribute("msgTarget", msgTarget);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The error text to use when marking a
          field invalid and no message is provided (defaults to
          'The value in this field is invalid')</div>

	 */
	
	public String getInvalidText () {
		return (String) getStateHelper().eval(PropertyKeys.invalidText);
	}

	/**
	 * <p>
	 * Set the value of the <code>invalidText</code> property.
	 * </p>
	 */
	public void setInvalidText ( String   invalidText ) {
		getStateHelper().put(PropertyKeys.invalidText, invalidText);
		handleAttribute("invalidText", invalidText);
	}
    	/*
	 *
        
        
          invalidClass
         : String
        The CSS class to use when marking a
        field invalid (defaults to 'x-form-invalid')
	 */
	
	public String getInvalidClass () {
		return (String) getStateHelper().eval(PropertyKeys.invalidClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>invalidClass</code> property.
	 * </p>
	 */
	public void setInvalidClass ( String   invalidClass ) {
		getStateHelper().put(PropertyKeys.invalidClass, invalidClass);
		handleAttribute("invalidClass", invalidClass);
	}
    	/*
	 *
        
        
          focusClass
         : String
        The CSS class to use when the field
        receives focus (defaults to 'x-form-focus')
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
        
        
          validationDelay
         : Number
        The length of time in milliseconds after
        user input begins until validation is initiated (defaults
        to 250)
	 */
	
	public Integer getValidationDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.validationDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>validationDelay</code> property.
	 * </p>
	 */
	public void setValidationDelay ( Integer   validationDelay ) {
		getStateHelper().put(PropertyKeys.validationDelay, validationDelay);
		handleAttribute("validationDelay", validationDelay);
	}
    	/*
	 *
        
        
          msgFx
         : String
        
        Experimental The effect used when displaying a
        validation message under the field (defaults to
        'normal').
	 */
	
	public String getMsgFx () {
		return (String) getStateHelper().eval(PropertyKeys.msgFx);
	}

	/**
	 * <p>
	 * Set the value of the <code>msgFx</code> property.
	 * </p>
	 */
	public void setMsgFx ( String   msgFx ) {
		getStateHelper().put(PropertyKeys.msgFx, msgFx);
		handleAttribute("msgFx", msgFx);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to mark the field as readOnly in HTML
          (defaults to 
          <tt>false</tt>).
          <br/>
          <p>
          <b>Note</b>: this only sets the element's readOnly DOM
          attribute. Setting 
          <code>readOnly=true</code>, for example, will not disable
          triggering a ComboBox or DateField; it gives you the
          option of forcing the user to choose via the trigger
          without typing in the text box. To hide the trigger use 
          <code>
            <a ext:cls="Ext.form.TriggerField" ext:member="hideTrigger" href="output/Ext.form.TriggerField.html#Ext.form.TriggerField-hideTrigger">hideTrigger</a>
          </code>.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The event that should initiate field
          validation. Set to false to disable automatic validation
          (defaults to 'keyup').</div>

	 */
	
	public String getValidationEvent () {
		return (String) getStateHelper().eval(PropertyKeys.validationEvent);
	}

	/**
	 * <p>
	 * Set the value of the <code>validationEvent</code> property.
	 * </p>
	 */
	public void setValidationEvent ( String   validationEvent ) {
		getStateHelper().put(PropertyKeys.validationEvent, validationEvent);
		handleAttribute("validationEvent", validationEvent);
	}
    	/*
	 *
        
        
          submitValue
         : Boolean
        False to clear the name attribute on the
        field so that it is not submitted during a form post.
        Defaults to 
        true.
	 */
	
	public Boolean getSubmitValue () {
		return (Boolean) getStateHelper().eval(PropertyKeys.submitValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>submitValue</code> property.
	 * </p>
	 */
	public void setSubmitValue ( Boolean   submitValue ) {
		getStateHelper().put(PropertyKeys.submitValue, submitValue);
		handleAttribute("submitValue", submitValue);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The type attribute for input fields --
          e.g. radio, text, password, file (defaults to 'text').
          The types 'file' and 'password' must be used to render
          those field types currently -- there are no separate Ext
          components for those. Note that if you use 
          <tt>inputType:'file'</tt>, 
          <a ext:cls="Ext.form.Field" ext:member="emptyText" href="output/Ext.form.Field.html#Ext.form.Field-emptyText">emptyText</a> is not supported
          and should be avoided.</div>

	 */
	
	public String getInputType () {
		return (String) getStateHelper().eval(PropertyKeys.inputType);
	}

	/**
	 * <p>
	 * Set the value of the <code>inputType</code> property.
	 * </p>
	 */
	public void setInputType ( String   inputType ) {
		getStateHelper().put(PropertyKeys.inputType, inputType);
		handleAttribute("inputType", inputType);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The field's HTML name attribute
          (defaults to ''). 
          <b>Note</b>: this property must be set if this field is
          to be automatically included with 
          <a ext:cls="Ext.form.BasicForm" ext:member="submit" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit">form
          submit()</a>.</div>

	 */
	
	public String getName () {
		return (String) getStateHelper().eval(PropertyKeys.name);
	}

	/**
	 * <p>
	 * Set the value of the <code>name</code> property.
	 * </p>
	 */
	public void setName ( String   name ) {
		getStateHelper().put(PropertyKeys.name, name);
		handleAttribute("name", name);
	}
    	/*
	 *
        
        
          validateOnBlur
         : Boolean
        Whether the field should validate when
        it loses focus (defaults to true).
	 */
	
	public Boolean getValidateOnBlur () {
		return (Boolean) getStateHelper().eval(PropertyKeys.validateOnBlur);
	}

	/**
	 * <p>
	 * Set the value of the <code>validateOnBlur</code> property.
	 * </p>
	 */
	public void setValidateOnBlur ( Boolean   validateOnBlur ) {
		getStateHelper().put(PropertyKeys.validateOnBlur, validateOnBlur);
		handleAttribute("validateOnBlur", validateOnBlur);
	}
    	/*
	 *
        
        
          preventMark
         : Boolean
        
        true to disable 
        marking
        the field invalid. Defaults to 
        false.
	 */
	
	public Boolean getPreventMark () {
		return (Boolean) getStateHelper().eval(PropertyKeys.preventMark);
	}

	/**
	 * <p>
	 * Set the value of the <code>preventMark</code> property.
	 * </p>
	 */
	public void setPreventMark ( Boolean   preventMark ) {
		getStateHelper().put(PropertyKeys.preventMark, preventMark);
		handleAttribute("preventMark", preventMark);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to disable the field (defaults to
          false). 
          <p>Be aware that conformant with the 
          <a href="http://www.w3.org/TR/html401/interact/forms.html#h-17.12.1">HTML
          specification</a>, disabled Fields will not be 
          <a ext:cls="Ext.form.BasicForm" ext:member="submit" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit">submitted</a>.</p>
</div>

	 */
	
	public Boolean getDisabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setDisabled ( Boolean   disabled ) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
		handleAttribute("disabled", disabled);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "blur"
					, "change"
					, "focus"
					, "invalid"
					, "specialkey"
					, "valid"
				));
				return superEvent;
	}
}