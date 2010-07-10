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
 * 
    Basic text field. Can be used as a direct replacement for
    traditional text inputs, or as the base class for more
    sophisticated input controls (like 
    Ext.form.TextArea and 
    Ext.form.ComboBox).
    
      
        Validation
      
    
    The validation procedure is described in the documentation
    for 
    validateValue.
    
      
        Alter Validation Behavior
      
    
    Validation behavior for each field can be configured:
    
      
        
        
          invalidText
         : the default validation message to show if any
        validation step above does not provide a message when
        invalid
        
        
          maskRe
         : filter out keystrokes before any validation
        occurs
        
        
          stripCharsRe
         : filter characters after being typed in, but
        before being validated
        
        
          invalidClass
         : alternate style when invalid
        
        
          validateOnBlur
        , 
        
          validationDelay
        , and 
        
          validationEvent
         : modify how/when validation is triggered
      
    
  
 */
@XType("textfield")
@InstanceOf("Ext.form.TextField")

@FacesComponent(value = "Ext.form.TextField")
public class TextField extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.TextField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.TextField} instance with default property values.
	 * </p>
	 */
	public TextField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			maxLengthText
			,vtypeText
			,emptyClass
			,maxLength
			,maskRe
			,allowBlank
			,emptyText
			,minLengthText
			,disableKeyFilter
			,minLength
			,stripCharsRe
			,growMax
			,eValidator
			,grow
			,selectOnFocus
			,growMin
			,vtype
			,regexText
			,blankText
			,enableKeyEvents
			,regex
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
	 *Error text to display if the 
          
            
              maximum length
            
           validation fails (defaults to 
          'The maximum length for this field is
          {maxLength}')
	 */
	
	public String getMaxLengthText () {
		return (String) getStateHelper().eval(PropertyKeys.maxLengthText);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxLengthText</code> property.
	 * </p>
	 */
	public void setMaxLengthText ( String   maxLengthText ) {
		getStateHelper().put(PropertyKeys.maxLengthText, maxLengthText);
		handleAttribute("maxLengthText", maxLengthText);
	}
    	/*
	 *A custom error message to display in
          place of the default message provided for the 
          
            
              vtype
            
           currently set for this field (defaults to 
          ''). 
          Note: only applies if 
          
            
              vtype
            
           is set, else ignored.
	 */
	
	public String getVtypeText () {
		return (String) getStateHelper().eval(PropertyKeys.vtypeText);
	}

	/**
	 * <p>
	 * Set the value of the <code>vtypeText</code> property.
	 * </p>
	 */
	public void setVtypeText ( String   vtypeText ) {
		getStateHelper().put(PropertyKeys.vtypeText, vtypeText);
		handleAttribute("vtypeText", vtypeText);
	}
    	/*
	 *The CSS class to apply to an empty
          field to style the 
          
            
              emptyText
            
           (defaults to 
          'x-form-empty-field'). This class is
          automatically added and removed as needed depending on
          the current field value.
	 */
	
	public String getEmptyClass () {
		return (String) getStateHelper().eval(PropertyKeys.emptyClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyClass</code> property.
	 * </p>
	 */
	public void setEmptyClass ( String   emptyClass ) {
		getStateHelper().put(PropertyKeys.emptyClass, emptyClass);
		handleAttribute("emptyClass", emptyClass);
	}
    	/*
	 *Maximum input field length allowed by
          validation (defaults to Number.MAX_VALUE). This behavior
          is intended to provide instant feedback to the user by
          improving usability to allow pasting and editing or
          overtyping and back tracking. To restrict the maximum
          number of characters that can be entered into the field
          use 
          
            
              autoCreate
            
           to add any attributes you want to a field, for
          example:


var myField = 
new Ext.form.NumberField({
    id: 
'mobile',
    anchor:
'90%',
    fieldLabel: 
'Mobile',
    maxLength: 16, 
// 
for validation
    autoCreate: {tag: 
'input', type: 
'text', size: 
'20', autocomplete: 
'off', maxlength: 
'10'}
});
          
	 */
	
	public Integer getMaxLength () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxLength);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxLength</code> property.
	 * </p>
	 */
	public void setMaxLength ( Integer   maxLength ) {
		getStateHelper().put(PropertyKeys.maxLength, maxLength);
		handleAttribute("maxLength", maxLength);
	}
    	/*
	 *
        
        
          maskRe
         : RegExp
        An input mask regular expression that
        will be used to filter keystrokes that do not match
        (defaults to 
        null)
	 */
	@ClientConfig(JsonMode.Object)

	public String getMaskRe () {
		return (String) getStateHelper().eval(PropertyKeys.maskRe);
	}

	/**
	 * <p>
	 * Set the value of the <code>maskRe</code> property.
	 * </p>
	 */
	public void setMaskRe ( String   maskRe ) {
		getStateHelper().put(PropertyKeys.maskRe, maskRe);
		handleAttribute("maskRe", maskRe);
	}
    	/*
	 *
        
        
          allowBlank
         : Boolean
        Specify 
        false to validate that the value's length is >
        0 (defaults to 
        true)
	 */
	
	public Boolean getAllowBlank () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowBlank);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowBlank</code> property.
	 * </p>
	 */
	public void setAllowBlank ( Boolean   allowBlank ) {
		getStateHelper().put(PropertyKeys.allowBlank, allowBlank);
		handleAttribute("allowBlank", allowBlank);
	}
    	/*
	 *The default text to place into an empty
          field (defaults to 
          null). 
          Note: that this value will be submitted to the
          server if this field is enabled and configured with a 
          name.
	 */
	
	public String getEmptyText () {
		return (String) getStateHelper().eval(PropertyKeys.emptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyText</code> property.
	 * </p>
	 */
	public void setEmptyText ( String   emptyText ) {
		getStateHelper().put(PropertyKeys.emptyText, emptyText);
		handleAttribute("emptyText", emptyText);
	}
    	/*
	 *Error text to display if the 
          
            
              minimum length
            
           validation fails (defaults to 
          'The minimum length for this field is
          {minLength}')
	 */
	
	public String getMinLengthText () {
		return (String) getStateHelper().eval(PropertyKeys.minLengthText);
	}

	/**
	 * <p>
	 * Set the value of the <code>minLengthText</code> property.
	 * </p>
	 */
	public void setMinLengthText ( String   minLengthText ) {
		getStateHelper().put(PropertyKeys.minLengthText, minLengthText);
		handleAttribute("minLengthText", minLengthText);
	}
    	/*
	 *
        
        
          disableKeyFilter
         : Boolean
        Specify 
        true to disable input keystroke filtering
        (defaults to 
        false)
	 */
	
	public Boolean getDisableKeyFilter () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disableKeyFilter);
	}

	/**
	 * <p>
	 * Set the value of the <code>disableKeyFilter</code> property.
	 * </p>
	 */
	public void setDisableKeyFilter ( Boolean   disableKeyFilter ) {
		getStateHelper().put(PropertyKeys.disableKeyFilter, disableKeyFilter);
		handleAttribute("disableKeyFilter", disableKeyFilter);
	}
    	/*
	 *
        
        
          minLength
         : Number
        Minimum input field length required
        (defaults to 
        0)
	 */
	
	public Integer getMinLength () {
		return (Integer) getStateHelper().eval(PropertyKeys.minLength);
	}

	/**
	 * <p>
	 * Set the value of the <code>minLength</code> property.
	 * </p>
	 */
	public void setMinLength ( Integer   minLength ) {
		getStateHelper().put(PropertyKeys.minLength, minLength);
		handleAttribute("minLength", minLength);
	}
    	/*
	 *
        
        
          stripCharsRe
         : RegExp
        A JavaScript RegExp object used to strip
        unwanted content from the value before validation (defaults
        to 
        null).
	 */
	@ClientConfig(JsonMode.Object)

	public String getStripCharsRe () {
		return (String) getStateHelper().eval(PropertyKeys.stripCharsRe);
	}

	/**
	 * <p>
	 * Set the value of the <code>stripCharsRe</code> property.
	 * </p>
	 */
	public void setStripCharsRe ( String   stripCharsRe ) {
		getStateHelper().put(PropertyKeys.stripCharsRe, stripCharsRe);
		handleAttribute("stripCharsRe", stripCharsRe);
	}
    	/*
	 *
        
        
          growMax
         : Number
        The maximum width to allow when 
        
        
          grow
         = true (defaults to 
        800)
	 */
	
	public Integer getGrowMax () {
		return (Integer) getStateHelper().eval(PropertyKeys.growMax);
	}

	/**
	 * <p>
	 * Set the value of the <code>growMax</code> property.
	 * </p>
	 */
	public void setGrowMax ( Integer   growMax ) {
		getStateHelper().put(PropertyKeys.growMax, growMax);
		handleAttribute("growMax", growMax);
	}
    	/*
	 *
            A custom validation function to be called during
            field validation (
            validateValue)
            (defaults to 
            null). If specified, this function will be
            called first, allowing the developer to override the
            default validation process.
            
            This function will be passed the following
            Parameters:
            
              
                
                value: 
                Mixed 
                The current field
                value
              
            
            
            This function is to Return:
            
              
                
                true: 
                Boolean 
                
                true if the value is valid
                
                msg: 
                String 
                An error message if the value
                is invalid
              
            
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getEValidator () {
		return (Object) getStateHelper().eval(PropertyKeys.eValidator);
	}

	/**
	 * <p>
	 * Set the value of the <code>eValidator</code> property.
	 * </p>
	 */
	public void setEValidator ( Object   eValidator ) {
		getStateHelper().put(PropertyKeys.eValidator, eValidator);
		handleAttribute("eValidator", eValidator);
	}
    	/*
	 *
        
        
          grow
         : Boolean
        
        true if this field should automatically grow and
        shrink to its content (defaults to 
        false)
	 */
	
	public Boolean getGrow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.grow);
	}

	/**
	 * <p>
	 * Set the value of the <code>grow</code> property.
	 * </p>
	 */
	public void setGrow ( Boolean   grow ) {
		getStateHelper().put(PropertyKeys.grow, grow);
		handleAttribute("grow", grow);
	}
    	/*
	 *
        
        
          selectOnFocus
         : Boolean
        
        true to automatically select any existing field
        text when the field receives input focus (defaults to 
        false)
	 */
	
	public Boolean getSelectOnFocus () {
		return (Boolean) getStateHelper().eval(PropertyKeys.selectOnFocus);
	}

	/**
	 * <p>
	 * Set the value of the <code>selectOnFocus</code> property.
	 * </p>
	 */
	public void setSelectOnFocus ( Boolean   selectOnFocus ) {
		getStateHelper().put(PropertyKeys.selectOnFocus, selectOnFocus);
		handleAttribute("selectOnFocus", selectOnFocus);
	}
    	/*
	 *
        
        
          growMin
         : Number
        The minimum width to allow when 
        
        
          grow
         = true (defaults to 
        30)
	 */
	
	public Integer getGrowMin () {
		return (Integer) getStateHelper().eval(PropertyKeys.growMin);
	}

	/**
	 * <p>
	 * Set the value of the <code>growMin</code> property.
	 * </p>
	 */
	public void setGrowMin ( Integer   growMin ) {
		getStateHelper().put(PropertyKeys.growMin, growMin);
		handleAttribute("growMin", growMin);
	}
    	/*
	 *
        
        
          vtype
         : String
        A validation type name as defined in 
        Ext.form.VTypes (defaults to 
        null)
	 */
	
	public String getVtype () {
		return (String) getStateHelper().eval(PropertyKeys.vtype);
	}

	/**
	 * <p>
	 * Set the value of the <code>vtype</code> property.
	 * </p>
	 */
	public void setVtype ( String   vtype ) {
		getStateHelper().put(PropertyKeys.vtype, vtype);
		handleAttribute("vtype", vtype);
	}
    	/*
	 *
        
        
          regexText
         : String
        The error text to display if 
        
          
            regex
          
         is used and the test fails during validation (defaults
        to 
        '')
	 */
	
	public String getRegexText () {
		return (String) getStateHelper().eval(PropertyKeys.regexText);
	}

	/**
	 * <p>
	 * Set the value of the <code>regexText</code> property.
	 * </p>
	 */
	public void setRegexText ( String   regexText ) {
		getStateHelper().put(PropertyKeys.regexText, regexText);
		handleAttribute("regexText", regexText);
	}
    	/*
	 *
        
        
          blankText
         : String
        The error text to display if the 
        
          
            allowBlank
          
         validation fails (defaults to 
        'This field is required')
	 */
	
	public String getBlankText () {
		return (String) getStateHelper().eval(PropertyKeys.blankText);
	}

	/**
	 * <p>
	 * Set the value of the <code>blankText</code> property.
	 * </p>
	 */
	public void setBlankText ( String   blankText ) {
		getStateHelper().put(PropertyKeys.blankText, blankText);
		handleAttribute("blankText", blankText);
	}
    	/*
	 *
        
        
          enableKeyEvents
         : Boolean
        
        true to enable the proxying of key events for the
        HTML input field (defaults to 
        false)
	 */
	
	public Boolean getEnableKeyEvents () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableKeyEvents);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableKeyEvents</code> property.
	 * </p>
	 */
	public void setEnableKeyEvents ( Boolean   enableKeyEvents ) {
		getStateHelper().put(PropertyKeys.enableKeyEvents, enableKeyEvents);
		handleAttribute("enableKeyEvents", enableKeyEvents);
	}
    	/*
	 *A JavaScript RegExp object to be tested
          against the field value during validation (defaults to 
          null). If the test fails, the field will be
          marked invalid using 
          
            
              regexText
            
          .
	 */
	@ClientConfig(JsonMode.Object)

	public String getRegex () {
		return (String) getStateHelper().eval(PropertyKeys.regex);
	}

	/**
	 * <p>
	 * Set the value of the <code>regex</code> property.
	 * </p>
	 */
	public void setRegex ( String   regex ) {
		getStateHelper().put(PropertyKeys.regex, regex);
		handleAttribute("regex", regex);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "autosize"
					, "keydown"
					, "keypress"
					, "keyup"
				));
				return superEvent;
	}
}