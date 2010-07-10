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
 * A display-only text field which is not
  validated and not submitted.
 */
@XType("displayfield")
@InstanceOf("Ext.form.DisplayField")

@FacesComponent(value = "Ext.form.DisplayField")
public class DisplayField extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.DisplayField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.DisplayField} instance with default property values.
	 * </p>
	 */
	public DisplayField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			fieldClass
			,htmlEncode
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
        
        
          fieldClass
         : String
        The default CSS class for the field
        (defaults to 
        "x-form-display-field")
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
          false to skip HTML-encoding the text when
          rendering it (defaults to 
          false). This might be useful if you want to
          include tags in the field's innerHTML rather than
          rendering them as string literals per the default
          logic.
	 */
	
	public Boolean getHtmlEncode () {
		return (Boolean) getStateHelper().eval(PropertyKeys.htmlEncode);
	}

	/**
	 * <p>
	 * Set the value of the <code>htmlEncode</code> property.
	 * </p>
	 */
	public void setHtmlEncode ( Boolean   htmlEncode ) {
		getStateHelper().put(PropertyKeys.htmlEncode, htmlEncode);
		handleAttribute("htmlEncode", htmlEncode);
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