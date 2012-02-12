package ext.ux;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

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
 * 
    A plugin for Field Components which creates clones of the
    Field for as long as the user keeps filling them. Leaving the
    final one blank ends the repeating series.
    Usage:

{
        xtype: 
'combo',
        plugins: [ Ext.ux.FieldReplicator ],
        triggerAction: 
'all',
        fieldLabel: 
'Select recipient',
        store: recipientStore
    }
    
  
 */

@InstanceOf("Ext.ux.FieldReplicator")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "FieldReplicator.js")
@ParseConfigMode(ui = false,name="plugins",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Name)
@FacesComponent(value = "Ext.ux.FieldReplicator")
public class FieldReplicator extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.ux.FieldReplicator";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.FieldReplicator} instance with default property values.
	 * </p>
	 */
	public FieldReplicator() {
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