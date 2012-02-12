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
<div class="description">
    <p>Basic text field. Can be used as a direct replacement for
    traditional text inputs, or as the base class for more
    sophisticated input controls (like 
    <a ext:cls="Ext.form.TextArea" href="output/Ext.form.TextArea.html">Ext.form.TextArea</a> and 
    <a ext:cls="Ext.form.ComboBox" href="output/Ext.form.ComboBox.html">Ext.form.ComboBox</a>).</p>
    <p>
      <b>
        <u>Validation</u>
      </b>
    </p>
    <p>The validation procedure is described in the documentation
    for 
    <a ext:cls="Ext.form.TextField" ext:member="validateValue" href="output/Ext.form.TextField.html#Ext.form.TextField-validateValue">validateValue</a>.</p>
    <p>
      <b>
        <u>Alter Validation Behavior</u>
      </b>
    </p>
    <p>Validation behavior for each field can be configured:</p>
    <div class="mdetail-params">
      <ul>
        <li>
        <code>
          <a ext:cls="Ext.form.TextField" ext:member="invalidText" href="output/Ext.form.TextField.html#Ext.form.TextField-invalidText">invalidText</a>
        </code> : the default validation message to show if any
        validation step above does not provide a message when
        invalid</li>
        <li>
        <code>
          <a ext:cls="Ext.form.TextField" ext:member="maskRe" href="output/Ext.form.TextField.html#Ext.form.TextField-maskRe">maskRe</a>
        </code> : filter out keystrokes before any validation
        occurs</li>
        <li>
        <code>
          <a ext:cls="Ext.form.TextField" ext:member="stripCharsRe" href="output/Ext.form.TextField.html#Ext.form.TextField-stripCharsRe">stripCharsRe</a>
        </code> : filter characters after being typed in, but
        before being validated</li>
        <li>
        <code>
          <a ext:cls="Ext.form.Field" ext:member="invalidClass" href="output/Ext.form.Field.html#Ext.form.Field-invalidClass">invalidClass</a>
        </code> : alternate style when invalid</li>
        <li>
        <code>
          <a ext:cls="Ext.form.Field" ext:member="validateOnBlur" href="output/Ext.form.Field.html#Ext.form.Field-validateOnBlur">validateOnBlur</a>
        </code>, 
        <code>
          <a ext:cls="Ext.form.Field" ext:member="validationDelay" href="output/Ext.form.Field.html#Ext.form.Field-validationDelay">validationDelay</a>
        </code>, and 
        <code>
          <a ext:cls="Ext.form.Field" ext:member="validationEvent" href="output/Ext.form.Field.html#Ext.form.Field-validationEvent">validationEvent</a>
        </code> : modify how/when validation is triggered</li>
      </ul>
    </div>
  </div>

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
			eValidator
			,minLengthText
			,allowBlank
			,stripCharsRe
			,regexText
			,blankText
			,regex
			,vtype
			,disableKeyFilter
			,emptyText
			,growMin
			,maskRe
			,emptyClass
			,maxLength
			,growMax
			,minLength
			,enableKeyEvents
			,grow
			,vtypeText
			,maxLengthText
			,selectOnFocus
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
<div class="long">
            <p>A custom validation function to be called during
            field validation (
            <a ext:cls="Ext.form.TextField" ext:member="validateValue" href="output/Ext.form.TextField.html#Ext.form.TextField-validateValue">validateValue</a>)
            (defaults to 
            <tt>null</tt>). If specified, this function will be
            called first, allowing the developer to override the
            default validation process.</p>
            <br/>
            <p>This function will be passed the following
            Parameters:</p>
            <div class="mdetail-params">
              <ul>
                <li>
                <code>value</code>: 
                <i>Mixed</i> 
                <div class="sub-desc">The current field
                value</div>
</li>
              </ul>
            </div>
            <br/>
            <p>This function is to Return:</p>
            <div class="mdetail-params">
              <ul>
                <li>
                <code>true</code>: 
                <i>Boolean</i> 
                <div class="sub-desc">
                <code>true</code> if the value is valid</div>
</li>
                <li>
                <code>msg</code>: 
                <i>String</i> 
                <div class="sub-desc">An error message if the value
                is invalid</div>
</li>
              </ul>
            </div>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Error text to display if the 
          <b>
            <tt>
              <a ext:cls="Ext.form.TextField" ext:member="minLength" href="output/Ext.form.TextField.html#Ext.form.TextField-minLength">minimum length</a>
            </tt>
          </b> validation fails (defaults to 
          <tt>'The minimum length for this field is
          {minLength}'</tt>)</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A JavaScript RegExp object to be tested
          against the field value during validation (defaults to 
          <tt>null</tt>). If the test fails, the field will be
          marked invalid using 
          <b>
            <tt>
              <a ext:cls="Ext.form.TextField" ext:member="regexText" href="output/Ext.form.TextField.html#Ext.form.TextField-regexText">regexText</a>
            </tt>
          </b>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The default text to place into an empty
          field (defaults to 
          <tt>null</tt>). 
          <b>Note</b>: that this value will be submitted to the
          server if this field is enabled and configured with a 
          <a ext:cls="Ext.form.TextField" ext:member="name" href="output/Ext.form.TextField.html#Ext.form.TextField-name">name</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An input mask regular expression that
          will be used to filter keystrokes that do not match
          (defaults to 
          <tt>null</tt>). The maskRe will not operate on any paste
          events.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The CSS class to apply to an empty
          field to style the 
          <b>
            <tt>
              <a ext:cls="Ext.form.TextField" ext:member="emptyText" href="output/Ext.form.TextField.html#Ext.form.TextField-emptyText">emptyText</a>
            </tt>
          </b> (defaults to 
          <tt>'x-form-empty-field'</tt>). This class is
          automatically added and removed as needed depending on
          the current field value.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Maximum input field length allowed by
          validation (defaults to Number.MAX_VALUE). This behavior
          is intended to provide instant feedback to the user by
          improving usability to allow pasting and editing or
          overtyping and back tracking. To restrict the maximum
          number of characters that can be entered into the field
          use 
          <tt>
            <b>
              <a ext:cls="Ext.form.Field" ext:member="autoCreate" href="output/Ext.form.Field.html#Ext.form.Field-autoCreate">autoCreate</a>
            </b>
          </tt> to add any attributes you want to a field, for
          example:
<pre>
<code>
<b>var</b> myField = 
<b>new</b> Ext.form.NumberField({
    id: 
<em>'mobile'</em>,
    anchor:
<em>'90%'</em>,
    fieldLabel: 
<em>'Mobile'</em>,
    maxLength: 16, 
<i>// 
<b>for</b> validation</i>
    autoCreate: {tag: 
<em>'input'</em>, type: 
<em>'text'</em>, size: 
<em>'20'</em>, autocomplete: 
<em>'off'</em>, maxlength: 
<em>'10'</em>}
});</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A custom error message to display in
          place of the default message provided for the 
          <b>
            <code>
              <a ext:cls="Ext.form.TextField" ext:member="vtype" href="output/Ext.form.TextField.html#Ext.form.TextField-vtype">vtype</a>
            </code>
          </b> currently set for this field (defaults to 
          <tt>''</tt>). 
          <b>Note</b>: only applies if 
          <b>
            <code>
              <a ext:cls="Ext.form.TextField" ext:member="vtype" href="output/Ext.form.TextField.html#Ext.form.TextField-vtype">vtype</a>
            </code>
          </b> is set, else ignored.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Error text to display if the 
          <b>
            <tt>
              <a ext:cls="Ext.form.TextField" ext:member="maxLength" href="output/Ext.form.TextField.html#Ext.form.TextField-maxLength">maximum length</a>
            </tt>
          </b> validation fails (defaults to 
          <tt>'The maximum length for this field is
          {maxLength}'</tt>)</div>

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