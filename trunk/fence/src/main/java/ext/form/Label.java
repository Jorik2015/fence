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
 * Basic Label field.
 */
@XType("label")
@InstanceOf("Ext.form.Label")

@FacesComponent(value = "Ext.form.Label")
public class Label extends BoxComponent {
	public static final String COMPONENT_FAMILY = "Ext.form.Label";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Label} instance with default property values.
	 * </p>
	 */
	public Label() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			text
			,html
			,forId
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
	 *The plain text to display within the
          label (defaults to ''). If you need to include HTML tags
          within the label's innerHTML, use the 
          html
          config instead.
	 */
	
	public String getText () {
		return (String) getStateHelper().eval(PropertyKeys.text);
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText ( String   text ) {
		getStateHelper().put(PropertyKeys.text, text);
		handleAttribute("text", text);
	}
    	/*
	 *An HTML fragment that will be used as
          the label's innerHTML (defaults to ''). Note that if 
          text is
          specified it will take precedence and this value will be
          ignored.
	 */
	
	public String getHtml () {
		return (String) getStateHelper().eval(PropertyKeys.html);
	}

	/**
	 * <p>
	 * Set the value of the <code>html</code> property.
	 * </p>
	 */
	public void setHtml ( String   html ) {
		getStateHelper().put(PropertyKeys.html, html);
		handleAttribute("html", html);
	}
    	/*
	 *The id of the input element to which
          this label will be bound via the standard HTML 'for'
          attribute. If not specified, the attribute will not be
          added to the label.
	 */
	
	public String getForId () {
		return (String) getStateHelper().eval(PropertyKeys.forId);
	}

	/**
	 * <p>
	 * Set the value of the <code>forId</code> property.
	 * </p>
	 */
	public void setForId ( String   forId ) {
		getStateHelper().put(PropertyKeys.forId, forId);
		handleAttribute("forId", forId);
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