package ext.ux.data;

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
    Paging Memory Proxy, allows to use paging grid with in
    memory dataset
  
 */

@InstanceOf("Ext.ux.data.PagingMemoryProxy")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "PagingMemoryProxy.js")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.ux.data.PagingMemoryProxy")
public class PagingMemoryProxy extends MemoryProxy {
	public static final String COMPONENT_FAMILY = "Ext.ux.data.PagingMemoryProxy";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.data.PagingMemoryProxy} instance with default property values.
	 * </p>
	 */
	public PagingMemoryProxy() {
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