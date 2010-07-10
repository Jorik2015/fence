package ext.ux.form;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
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
 * Creates a file upload field.
 */

@InstanceOf("Ext.ux.form.FileUploadField")
@ResourceDependencies({
	@ResourceDependency(library = "ext#{ext.version}/ux/fileuploadfield", name = "FileUploadField.js"),
	@ResourceDependency(library = "ext#{ext.version}/ux/fileuploadfield/css", name = "fileuploadfield.css")
})
@FacesComponent(value = "Ext.ux.form.FileUploadField")
public class FileUploadField extends TextField {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.FileUploadField";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.form.FileUploadField} instance with default property values.
	 * </p>
	 */
	public FileUploadField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			buttonText
			,buttonOffset
			,buttonOnly
			,enableTabbing
			,buttonCfg
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
	 *The button text to display on the
          upload button (defaults to 'Browse...'). Note that if you
          supply a value for 
          buttonCfg, the
          buttonCfg.text value will be used instead if
          available.
	 */
	
	public String getButtonText () {
		return (String) getStateHelper().eval(PropertyKeys.buttonText);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonText</code> property.
	 * </p>
	 */
	public void setButtonText ( String   buttonText ) {
		getStateHelper().put(PropertyKeys.buttonText, buttonText);
		handleAttribute("buttonText", buttonText);
	}
    	/*
	 *The number of pixels of space reserved
          between the button and the text field (defaults to 3).
          Note that this only applies if 
          buttonOnly =
          false.
	 */
	
	public Integer getButtonOffset () {
		return (Integer) getStateHelper().eval(PropertyKeys.buttonOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonOffset</code> property.
	 * </p>
	 */
	public void setButtonOffset ( Integer   buttonOffset ) {
		getStateHelper().put(PropertyKeys.buttonOffset, buttonOffset);
		handleAttribute("buttonOffset", buttonOffset);
	}
    	/*
	 *True to display the file upload field
          as a button with no visible text field (defaults to
          false). If true, all inherited TextField members will
          still be available.
	 */
	
	public Boolean getButtonOnly () {
		return (Boolean) getStateHelper().eval(PropertyKeys.buttonOnly);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonOnly</code> property.
	 * </p>
	 */
	public void setButtonOnly ( Boolean   buttonOnly ) {
		getStateHelper().put(PropertyKeys.buttonOnly, buttonOnly);
		handleAttribute("buttonOnly", buttonOnly);
	}
    	/*
	 *
        
        
          enableTabbing
         : Boolean
        
        true to enable tabbing. Default is 
        false.
	 */
	
	public Boolean getEnableTabbing () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableTabbing);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableTabbing</code> property.
	 * </p>
	 */
	public void setEnableTabbing ( Boolean   enableTabbing ) {
		getStateHelper().put(PropertyKeys.enableTabbing, enableTabbing);
		handleAttribute("enableTabbing", enableTabbing);
	}
    	/*
	 *
        
        
          buttonCfg
         : Object
        A standard 
        Ext.Button config
        object.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getButtonCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.buttonCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonCfg</code> property.
	 * </p>
	 */
	public void setButtonCfg ( Object   buttonCfg ) {
		getStateHelper().put(PropertyKeys.buttonCfg, buttonCfg);
		handleAttribute("buttonCfg", buttonCfg);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "fileselected"
				));
				return superEvent;
	}
}