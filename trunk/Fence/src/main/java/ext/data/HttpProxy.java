package ext.data;

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
 * 
    An implementation of 
    Ext.data.DataProxy that
    processes data requests within the same domain of the
    originating page.
    
    Note: this class cannot be used to retrieve data from a
    domain other than the domain from which the running page was
    served. For cross-domain requests, use a 
    ScriptTagProxy.
    Be aware that to enable the browser to parse an XML
    document, the server must set the Content-Type header in the
    HTTP response to "
    text/xml".
  
 */

@InstanceOf("Ext.data.HttpProxy")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.HttpProxy")
public class HttpProxy extends DataProxy {
	public static final String COMPONENT_FAMILY = "Ext.data.HttpProxy";

	/**
	 * <p>
	 * Create a new {@link Ext.data.HttpProxy} instance with default property values.
	 * </p>
	 */
	public HttpProxy() {
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