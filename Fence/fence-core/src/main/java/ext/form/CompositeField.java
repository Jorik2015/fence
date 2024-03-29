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
<div class="description">Composite field allowing a number of
  form Fields to be rendered on the same row. The fields are
  rendered using an hbox layout internally, so all of the normal
  HBox layout config items are available. Example usage: 
<pre>
{
    xtype: 'compositefield',
    labelWidth: 120
    items: [
        {
            xtype     : 'textfield',
            fieldLabel: 'Title',
            width     : 20
        },
        {
            xtype     : 'textfield',
            fieldLabel: 'First',
            flex      : 1
        },
        {
            xtype     : 'textfield',
            fieldLabel: 'Last',
            flex      : 1
        }
    ]
}
  </pre>In the example above the composite's fieldLabel will be set
  to 'Title, First, Last' as it groups the fieldLabels of each of
  its children. This can be overridden by setting a fieldLabel on
  the compositefield itself: 
<pre>
{
    xtype: 'compositefield',
    fieldLabel: 'Custom label',
    items: [...]
}
  </pre>Any Ext.form.* component can be placed inside a composite
  field.</div>

 */
@XType("compositefield")
@InstanceOf("Ext.form.CompositeField")

@FacesComponent(value = "Ext.form.CompositeField")
public class CompositeField extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.CompositeField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.CompositeField} instance with default property values.
	 * </p>
	 */
	public CompositeField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			labelConnector
			,defaults
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
        
        
          labelConnector
         : String
        The string to use when joining segments
        of the built label together (defaults to ', ')
	 */
	
	public String getLabelConnector () {
		return (String) getStateHelper().eval(PropertyKeys.labelConnector);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelConnector</code> property.
	 * </p>
	 */
	public void setLabelConnector ( String   labelConnector ) {
		getStateHelper().put(PropertyKeys.labelConnector, labelConnector);
		handleAttribute("labelConnector", labelConnector);
	}
    	/*
	 *
        
        
          defaults
         : Object
        Any default properties to assign to the
        child fields.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaults () {
		return (Object) getStateHelper().eval(PropertyKeys.defaults);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaults</code> property.
	 * </p>
	 */
	public void setDefaults ( Object   defaults ) {
		getStateHelper().put(PropertyKeys.defaults, defaults);
		handleAttribute("defaults", defaults);
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