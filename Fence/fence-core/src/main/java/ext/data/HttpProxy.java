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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>An implementation of 
    <a ext:cls="Ext.data.DataProxy" href="output/Ext.data.DataProxy.html">Ext.data.DataProxy</a> that
    processes data requests within the same domain of the
    originating page.</p>
    <p>
    <b>Note</b>: this class cannot be used to retrieve data from a
    domain other than the domain from which the running page was
    served. For cross-domain requests, use a 
    <a ext:cls="Ext.data.ScriptTagProxy" href="output/Ext.data.ScriptTagProxy.html">ScriptTagProxy</a>.</p>
    <p>Be aware that to enable the browser to parse an XML
    document, the server must set the Content-Type header in the
    HTTP response to "
    <tt>text/xml</tt>".</p>
  </div>

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