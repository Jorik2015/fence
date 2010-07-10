package ext.ux;

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
 * A 
  Ext.StatusBar plugin that provides
  automatic error notification when the associated form contains
  validation errors.
 */

@InstanceOf("Ext.ux.ValidationStatus")

@FacesComponent(value = "Ext.ux.ValidationStatus")
public class ValidationStatus extends Component {
	public static final String COMPONENT_FAMILY = "Ext.ux.ValidationStatus";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.ValidationStatus} instance with default property values.
	 * </p>
	 */
	public ValidationStatus() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			validIconCls
			,submitText
			,showText
			,errorListCls
			,errorIconCls
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
        
        
          validIconCls
         : String
        The 
        iconCls value to be
        applied to the status message when the form validates.
        Defaults to 
        'x-status-valid'.
	 */
	
	public String getValidIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.validIconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>validIconCls</code> property.
	 * </p>
	 */
	public void setValidIconCls ( String   validIconCls ) {
		getStateHelper().put(PropertyKeys.validIconCls, validIconCls);
		handleAttribute("validIconCls", validIconCls);
	}
    	/*
	 *
        
        
          submitText
         : String
        The 
        text value to be
        applied when the form is being submitted. Defaults to 
        'Saving...'.
	 */
	
	public String getSubmitText () {
		return (String) getStateHelper().eval(PropertyKeys.submitText);
	}

	/**
	 * <p>
	 * Set the value of the <code>submitText</code> property.
	 * </p>
	 */
	public void setSubmitText ( String   submitText ) {
		getStateHelper().put(PropertyKeys.submitText, submitText);
		handleAttribute("submitText", submitText);
	}
    	/*
	 *
        
        
          showText
         : String
        The 
        text value to display
        when the error list is displayed. Defaults to 
        'Click again to hide the error list'.
	 */
	
	public String getShowText () {
		return (String) getStateHelper().eval(PropertyKeys.showText);
	}

	/**
	 * <p>
	 * Set the value of the <code>showText</code> property.
	 * </p>
	 */
	public void setShowText ( String   showText ) {
		getStateHelper().put(PropertyKeys.showText, showText);
		handleAttribute("showText", showText);
	}
    	/*
	 *
        
        
          errorListCls
         : String
        The css class to be used for the error
        list when there are validation errors. Defaults to 
        'x-status-error-list'.
	 */
	
	public String getErrorListCls () {
		return (String) getStateHelper().eval(PropertyKeys.errorListCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>errorListCls</code> property.
	 * </p>
	 */
	public void setErrorListCls ( String   errorListCls ) {
		getStateHelper().put(PropertyKeys.errorListCls, errorListCls);
		handleAttribute("errorListCls", errorListCls);
	}
    	/*
	 *
        
        
          errorIconCls
         : String
        The 
        iconCls value to be
        applied to the status message when there is a validation
        error. Defaults to 
        'x-status-error'.
	 */
	
	public String getErrorIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.errorIconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>errorIconCls</code> property.
	 * </p>
	 */
	public void setErrorIconCls ( String   errorIconCls ) {
		getStateHelper().put(PropertyKeys.errorIconCls, errorIconCls);
		handleAttribute("errorIconCls", errorIconCls);
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