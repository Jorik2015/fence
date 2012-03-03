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
 */

@InstanceOf("Ext.data.DirectProxy")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.DirectProxy")
public class DirectProxy extends DataProxy {
	public static final String COMPONENT_FAMILY = "Ext.data.DirectProxy";

	/**
	 * <p>
	 * Create a new {@link Ext.data.DirectProxy} instance with default property values.
	 * </p>
	 */
	public DirectProxy() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			paramOrder
			,paramsAsHash
			,directFn
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
<div class="long">Defaults to 
          <tt>undefined</tt>. A list of params to be executed
          server side. Specify the params in the order in which
          they must be executed on the server-side as either (1) an
          Array of String values, or (2) a String of params
          delimited by either whitespace, comma, or pipe. For
          example, any of the following would be acceptable:
<pre>
<code>paramOrder: [
<em>'param1'</em>,
<em>'param2'</em>,
<em>'param3'</em>]
paramOrder: 
<em>'param1 param2 param3'</em>
paramOrder: 
<em>'param1,param2,param3'</em>
paramOrder: 
<em>'param1|param2|param'</em>
</code>
          </pre>
</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getParamOrder () {
		return (Object) getStateHelper().eval(PropertyKeys.paramOrder);
	}

	/**
	 * <p>
	 * Set the value of the <code>paramOrder</code> property.
	 * </p>
	 */
	public void setParamOrder ( Object   paramOrder ) {
		getStateHelper().put(PropertyKeys.paramOrder, paramOrder);
		handleAttribute("paramOrder", paramOrder);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Send parameters as a collection of
          named arguments (defaults to 
          <tt>true</tt>). Providing a 
          <tt>
            <a ext:cls="Ext.data.DirectProxy" ext:member="paramOrder" href="output/Ext.data.DirectProxy.html#Ext.data.DirectProxy-paramOrder">paramOrder</a>
          </tt> nullifies this configuration.</div>

	 */
	
	public Boolean getParamsAsHash () {
		return (Boolean) getStateHelper().eval(PropertyKeys.paramsAsHash);
	}

	/**
	 * <p>
	 * Set the value of the <code>paramsAsHash</code> property.
	 * </p>
	 */
	public void setParamsAsHash ( Boolean   paramsAsHash ) {
		getStateHelper().put(PropertyKeys.paramsAsHash, paramsAsHash);
		handleAttribute("paramsAsHash", paramsAsHash);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Function to call when executing a
          request. directFn is a simple alternative to defining the
          api configuration-parameter for Store's which will not
          implement a full CRUD api.</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getDirectFn () {
		return (Object) getStateHelper().eval(PropertyKeys.directFn);
	}

	/**
	 * <p>
	 * Set the value of the <code>directFn</code> property.
	 * </p>
	 */
	public void setDirectFn ( Object   directFn ) {
		getStateHelper().put(PropertyKeys.directFn, directFn);
		handleAttribute("directFn", directFn);
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