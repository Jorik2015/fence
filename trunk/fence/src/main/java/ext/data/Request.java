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
 * A simple Request class used internally
  to the data package to provide more generalized remote-requests
  to a DataProxy. TODO Not yet implemented. Implement in
  Ext.data.Store#execute
 */

@InstanceOf("Ext.data.Request")

@FacesComponent(value = "Ext.data.Request")
public class Request extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.Request";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Request} instance with default property values.
	 * </p>
	 */
	public Request() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			callback
			,action
			,params
			,scope
			,reader
			,rs
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
        
        
          callback
         : Function
        The function to call when request is
        complete
	 */
	@ClientConfig(JsonMode.Function)

	public Object getCallback () {
		return (Object) getStateHelper().eval(PropertyKeys.callback);
	}

	/**
	 * <p>
	 * Set the value of the <code>callback</code> property.
	 * </p>
	 */
	public void setCallback ( Object   callback ) {
		getStateHelper().put(PropertyKeys.callback, callback);
		handleAttribute("callback", callback);
	}
    	/*
	 *
        
        
          action
         : String
	 */
	
	public String getAction () {
		return (String) getStateHelper().eval(PropertyKeys.action);
	}

	/**
	 * <p>
	 * Set the value of the <code>action</code> property.
	 * </p>
	 */
	public void setAction ( String   action ) {
		getStateHelper().put(PropertyKeys.action, action);
		handleAttribute("action", action);
	}
    	/*
	 *
        
        
          params
         : Object
        HTTP request params
	 */
	@ClientConfig(JsonMode.Object)

	public Object getParams () {
		return (Object) getStateHelper().eval(PropertyKeys.params);
	}

	/**
	 * <p>
	 * Set the value of the <code>params</code> property.
	 * </p>
	 */
	public void setParams ( Object   params ) {
		getStateHelper().put(PropertyKeys.params, params);
		handleAttribute("params", params);
	}
    	/*
	 *
        
        
          scope
         : Object
        The scope of the callback
        funtion
	 */
	@ClientConfig(JsonMode.Object)

	public Object getScope () {
		return (Object) getStateHelper().eval(PropertyKeys.scope);
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope ( Object   scope ) {
		getStateHelper().put(PropertyKeys.scope, scope);
		handleAttribute("scope", scope);
	}
    	/*
	 *
        
        
          reader
         : Ext.data.DataReader
        The DataReader instance which will parse
        the received response
	 */
	@ClientConfig(JsonMode.Object)

	public Object getReader () {
		return (Object) getStateHelper().eval(PropertyKeys.reader);
	}

	/**
	 * <p>
	 * Set the value of the <code>reader</code> property.
	 * </p>
	 */
	public void setReader ( Object   reader ) {
		getStateHelper().put(PropertyKeys.reader, reader);
		handleAttribute("reader", reader);
	}
    	/*
	 *
        
        
          rs
         : Ext.data.Record[]/Ext.data.Record
        The Store recordset associated with the
        request.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getRs () {
		return (Object) getStateHelper().eval(PropertyKeys.rs);
	}

	/**
	 * <p>
	 * Set the value of the <code>rs</code> property.
	 * </p>
	 */
	public void setRs ( Object   rs ) {
		getStateHelper().put(PropertyKeys.rs, rs);
		handleAttribute("rs", rs);
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