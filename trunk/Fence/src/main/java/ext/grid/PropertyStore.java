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
 * A custom wrapper for the 
  Ext.grid.PropertyGrid's 
  Ext.data.Store. This class handles
  the mapping between the custom data source objects supported by
  the grid and the 
  Ext.grid.PropertyRecord
  format required for compatibility with the underlying store.
  Generally this class should not need to be used directly -- the
  grid's data should be accessed from the underlying store via the 
  store
  property.
 */

@InstanceOf("Ext.grid.PropertyStore")
@ParseConfigMode(id=false,ui = false,name="store",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.PropertyStore")
public class PropertyStore extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.grid.PropertyStore";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PropertyStore} instance with default property values.
	 * </p>
	 */
	public PropertyStore() {
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