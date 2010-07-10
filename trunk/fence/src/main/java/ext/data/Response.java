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
 * A generic response class to normalize
  response-handling internally to the framework.
 */

@InstanceOf("Ext.data.Response")

@FacesComponent(value = "Ext.data.Response")
public class Response extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.Response";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Response} instance with default property values.
	 * </p>
	 */
	public Response() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			action
			,records
			,message
			,data
			,success
			,raw
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
        
        
          action
         : String
        
          Ext.data.Api.actions
        
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
        
        
          records
         : Ext.data.Record/Ext.data.Record[]
        related to the Request action
	 */
	@ClientConfig(JsonMode.Object)

	public Object getRecords () {
		return (Object) getStateHelper().eval(PropertyKeys.records);
	}

	/**
	 * <p>
	 * Set the value of the <code>records</code> property.
	 * </p>
	 */
	public void setRecords ( Object   records ) {
		getStateHelper().put(PropertyKeys.records, records);
		handleAttribute("records", records);
	}
    	/*
	 *
        
        
          message
         : String
	 */
	
	public String getMessage () {
		return (String) getStateHelper().eval(PropertyKeys.message);
	}

	/**
	 * <p>
	 * Set the value of the <code>message</code> property.
	 * </p>
	 */
	public void setMessage ( String   message ) {
		getStateHelper().put(PropertyKeys.message, message);
		handleAttribute("message", message);
	}
    	/*
	 *
        
        
          data
         : Array/Object
	 */
	@ClientConfig(JsonMode.Array)

	public Object getData () {
		return (Object) getStateHelper().eval(PropertyKeys.data);
	}

	/**
	 * <p>
	 * Set the value of the <code>data</code> property.
	 * </p>
	 */
	public void setData ( Object   data ) {
		getStateHelper().put(PropertyKeys.data, data);
		handleAttribute("data", data);
	}
    	/*
	 *
        
        
          success
         : Boolean
	 */
	
	public Boolean getSuccess () {
		return (Boolean) getStateHelper().eval(PropertyKeys.success);
	}

	/**
	 * <p>
	 * Set the value of the <code>success</code> property.
	 * </p>
	 */
	public void setSuccess ( Boolean   success ) {
		getStateHelper().put(PropertyKeys.success, success);
		handleAttribute("success", success);
	}
    	/*
	 *
        
        
          raw
         : Object
        The raw response returned from
        server-code
	 */
	@ClientConfig(JsonMode.Object)

	public Object getRaw () {
		return (Object) getStateHelper().eval(PropertyKeys.raw);
	}

	/**
	 * <p>
	 * Set the value of the <code>raw</code> property.
	 * </p>
	 */
	public void setRaw ( Object   raw ) {
		getStateHelper().put(PropertyKeys.raw, raw);
		handleAttribute("raw", raw);
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