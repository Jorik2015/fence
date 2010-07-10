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
 * Multiline text field. Can be used as a
  direct replacement for traditional textarea fields, plus adds
  support for auto-sizing.
 */
@XType("textarea")
@InstanceOf("Ext.form.TextArea")

@FacesComponent(value = "Ext.form.TextArea")
public class TextArea extends TextField {
	public static final String COMPONENT_FAMILY = "Ext.form.TextArea";

	/**
	 * <p>
	 * Create a new {@link Ext.form.TextArea} instance with default property values.
	 * </p>
	 */
	public TextArea() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			autoCreate
			,growMin
			,preventScrollbars
			,growMax
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
            A 
            DomHelper element spec, or
            true for a default element spec. Used to create the 
            Element
            which will encapsulate this Component. See 
            
              autoEl
             for details. Defaults to:

{tag: 
"textarea", style: 
"width:100px;height:60px;", autocomplete: 
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
        
        
          growMin
         : Number
        The minimum height to allow when 
        
        grow=true (defaults
        to 
        60)
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
          true to prevent scrollbars from appearing
          regardless of how much text is in the field. This option
          is only relevant when 
          grow
          is 
          true. Equivalent to setting overflow: hidden,
          defaults to 
          false.
	 */
	
	public Boolean getPreventScrollbars () {
		return (Boolean) getStateHelper().eval(PropertyKeys.preventScrollbars);
	}

	/**
	 * <p>
	 * Set the value of the <code>preventScrollbars</code> property.
	 * </p>
	 */
	public void setPreventScrollbars ( Boolean   preventScrollbars ) {
		getStateHelper().put(PropertyKeys.preventScrollbars, preventScrollbars);
		handleAttribute("preventScrollbars", preventScrollbars);
	}
    	/*
	 *
        
        
          growMax
         : Number
        The maximum height to allow when 
        
        grow=true (defaults
        to 
        1000)
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