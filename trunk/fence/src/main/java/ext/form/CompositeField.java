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
 * Composite field allowing a number of
  form Fields to be rendered on the same row. The fields are
  rendered using an hbox layout internally, so all of the normal
  HBox layout config items are available. Example usage: 

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
  In the example above the composite's fieldLabel will be set
  to 'Title, First, Last' as it groups the fieldLabels of each of
  its children. This can be overridden by setting a fieldLabel on
  the compositefield itself: 

{
    xtype: 'compositefield',
    fieldLabel: 'Custom label',
    items: [...]
}
  Any Ext.form.* component can be placed inside a composite
  field.
 */

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