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
    A plugin for Field Components which renders standard Ext
    form wrapping and labels round the Field at render time
    regardless of the layout of the Container.
    Usage:

{
        xtype: 
'combo',
        plugins: [ Ext.ux.FieldLabeler ],
        triggerAction: 
'all',
        fieldLabel: 
'Select type',
        store: typeStore
    }
    
  
 */

@InstanceOf("Ext.ux.FieldLabeler")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "FieldLabeler.js")
@ParseConfigMode(ui = false,name="plugins",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Name)
@FacesComponent(value = "Ext.ux.FieldLabeler")
public class FieldLabeler extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.ux.FieldLabeler";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.FieldLabeler} instance with default property values.
	 * </p>
	 */
	public FieldLabeler() {
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