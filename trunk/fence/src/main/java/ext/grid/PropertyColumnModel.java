package ext.grid;

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
 * A custom column model for the 
  Ext.grid.PropertyGrid.
  Generally it should not need to be used directly.
 */

@InstanceOf("Ext.grid.PropertyColumnModel")
@ParseConfigMode(ui = false,name="cm",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.PropertyColumnModel")
public class PropertyColumnModel extends ColumnModel {
	public static final String COMPONENT_FAMILY = "Ext.grid.PropertyColumnModel";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PropertyColumnModel} instance with default property values.
	 * </p>
	 */
	public PropertyColumnModel() {
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