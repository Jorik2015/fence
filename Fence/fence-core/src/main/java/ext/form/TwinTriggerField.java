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
<div class="description">TwinTriggerField is not a public class
  to be used directly. It is meant as an abstract base class to be
  extended by an implementing class. For an example of implementing
  this class, see the custom SearchField implementation here: 
  <a href="http://extjs.com/deploy/ext/examples/form/custom.html">http://extjs.com/deploy/ext/examples/form/custom.html</a>
</div>

 */

@InstanceOf("Ext.form.TwinTriggerField")

@FacesComponent(value = "Ext.form.TwinTriggerField")
public class TwinTriggerField extends TriggerField {
	public static final String COMPONENT_FAMILY = "Ext.form.TwinTriggerField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.TwinTriggerField} instance with default property values.
	 * </p>
	 */
	public TwinTriggerField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			triggerConfig
			,trigger2Class
			,trigger1Class
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
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> config object
            specifying the structure of the trigger elements for
            this Field. (Optional).</p>
            <p>Specify this when you need a customized element to
            contain the two trigger elements for this Field. Each
            trigger element must be marked by the CSS class 
            <tt>x-form-trigger</tt> (also see 
            <tt>
              <a ext:cls="Ext.form.TwinTriggerField" ext:member="trigger1Class" href="output/Ext.form.TwinTriggerField.html#Ext.form.TwinTriggerField-trigger1Class">trigger1Class</a>
            </tt> and 
            <tt>
              <a ext:cls="Ext.form.TwinTriggerField" ext:member="trigger2Class" href="output/Ext.form.TwinTriggerField.html#Ext.form.TwinTriggerField-trigger2Class">trigger2Class</a>
            </tt>).</p>
            <p>Note that when using this option, it is the
            developer's responsibility to ensure correct sizing,
            positioning and appearance of the triggers.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          <tt>'x-form-trigger'</tt> by default and 
          <tt>triggerClass</tt> will be 
          <b>appended</b> if specified.</div>

	 */
	
	public String getTrigger2Class () {
		return (String) getStateHelper().eval(PropertyKeys.trigger2Class);
	}

	/**
	 * <p>
	 * Set the value of the <code>trigger2Class</code> property.
	 * </p>
	 */
	public void setTrigger2Class ( String   trigger2Class ) {
		getStateHelper().put(PropertyKeys.trigger2Class, trigger2Class);
		handleAttribute("trigger2Class", trigger2Class);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An additional CSS class used to style
          the trigger button. The trigger will always get the class
          
          <tt>'x-form-trigger'</tt> by default and 
          <tt>triggerClass</tt> will be 
          <b>appended</b> if specified.</div>

	 */
	
	public String getTrigger1Class () {
		return (String) getStateHelper().eval(PropertyKeys.trigger1Class);
	}

	/**
	 * <p>
	 * Set the value of the <code>trigger1Class</code> property.
	 * </p>
	 */
	public void setTrigger1Class ( String   trigger1Class ) {
		getStateHelper().put(PropertyKeys.trigger1Class, trigger1Class);
		handleAttribute("trigger1Class", trigger1Class);
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