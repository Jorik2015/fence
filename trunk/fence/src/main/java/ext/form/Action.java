package ext.form;

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
import java.util.Date;

/**
 * 
    The subclasses of this class provide actions to perform upon
    
    Forms.
    Instances of this class are only created by a 
    Form when the Form needs to
    perform an action such as submit or load. The Configuration
    options listed for this class are set through the Form's action
    methods: 
    submit, 
    load and 
    doAction
    The instance of Action which performed the action is passed
    to the success and failure callbacks of the Form's action
    methods (
    submit, 
    load and 
    doAction), and to the 
    actioncomplete and 
    actionfailed event
    handlers.
  
 */

@InstanceOf("Ext.form.Action")

@FacesComponent(value = "Ext.form.Action")
public class Action extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.form.Action";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Action} instance with default property values.
	 * </p>
	 */
	public Action() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			waitTitle
			,timeout
			,submitEmptyText
			,params
			,scope
			,reset
			,waitMsg
			,url
			,success
			,method
			,failure
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
        
        
          waitTitle
         : String
        The title to be displayed by a call to 
        Ext.MessageBox.wait during the
        time the action is being processed.
	 */
	
	public String getWaitTitle () {
		return (String) getStateHelper().eval(PropertyKeys.waitTitle);
	}

	/**
	 * <p>
	 * Set the value of the <code>waitTitle</code> property.
	 * </p>
	 */
	public void setWaitTitle ( String   waitTitle ) {
		getStateHelper().put(PropertyKeys.waitTitle, waitTitle);
		handleAttribute("waitTitle", waitTitle);
	}
    	/*
	 *The number of seconds to wait for a
          server response before failing with the 
          failureType as 
          Action.CONNECT_FAILURE. If
          not specified, defaults to the configured 
          
            timeout
           of the 
          form.
	 */
	
	public Integer getTimeout () {
		return (Integer) getStateHelper().eval(PropertyKeys.timeout);
	}

	/**
	 * <p>
	 * Set the value of the <code>timeout</code> property.
	 * </p>
	 */
	public void setTimeout ( Integer   timeout ) {
		getStateHelper().put(PropertyKeys.timeout, timeout);
		handleAttribute("timeout", timeout);
	}
    	/*
	 *
        
        
          submitEmptyText
         : Boolean
        If set to 
        true, the emptyText value will be sent with the
        form when it is submitted. Defaults to 
        true.
	 */
	
	public Boolean getSubmitEmptyText () {
		return (Boolean) getStateHelper().eval(PropertyKeys.submitEmptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>submitEmptyText</code> property.
	 * </p>
	 */
	public void setSubmitEmptyText ( Boolean   submitEmptyText ) {
		getStateHelper().put(PropertyKeys.submitEmptyText, submitEmptyText);
		handleAttribute("submitEmptyText", submitEmptyText);
	}
    	/*
	 *
            Extra parameter values to pass. These are added to
            the Form's 
            Ext.form.BasicForm.baseParams
            and passed to the specified URL along with the Form's
            input fields.
            Parameters are encoded as standard HTTP parameters
            using 
            Ext.urlEncode.
          
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
        The scope in which to call the callback
        functions (The 
        this reference for the callback
        functions).
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
	 *When set to 
          
            true
          , causes the Form to be 
          reset on Action
          success. If specified, this happens 
          before the 
          success callback is called
          and before the Form's 
          actioncomplete
          event fires.
	 */
	
	public Boolean getReset () {
		return (Boolean) getStateHelper().eval(PropertyKeys.reset);
	}

	/**
	 * <p>
	 * Set the value of the <code>reset</code> property.
	 * </p>
	 */
	public void setReset ( Boolean   reset ) {
		getStateHelper().put(PropertyKeys.reset, reset);
		handleAttribute("reset", reset);
	}
    	/*
	 *
        
        
          waitMsg
         : String
        The message to be displayed by a call to
        
        Ext.MessageBox.wait during the
        time the action is being processed.
	 */
	
	public String getWaitMsg () {
		return (String) getStateHelper().eval(PropertyKeys.waitMsg);
	}

	/**
	 * <p>
	 * Set the value of the <code>waitMsg</code> property.
	 * </p>
	 */
	public void setWaitMsg ( String   waitMsg ) {
		getStateHelper().put(PropertyKeys.waitMsg, waitMsg);
		handleAttribute("waitMsg", waitMsg);
	}
    	/*
	 *
        
        
          url
         : String
        The URL that the Action is to
        invoke.
	 */
	
	public String getUrl () {
		return (String) getStateHelper().eval(PropertyKeys.url);
	}

	/**
	 * <p>
	 * Set the value of the <code>url</code> property.
	 * </p>
	 */
	public void setUrl ( String   url ) {
		getStateHelper().put(PropertyKeys.url, url);
		handleAttribute("url", url);
	}
    	/*
	 *The function to call when a valid
          success return packet is recieved. The function is passed
          the following parameters:
          
            
            form : Ext.form.BasicForm
            The form that requested the
            action
            
            action : Ext.form.Action
            The Action class. The 
            result property of this
            object may be examined to perform custom
            postprocessing.
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getSuccess () {
		return (Object) getStateHelper().eval(PropertyKeys.success);
	}

	/**
	 * <p>
	 * Set the value of the <code>success</code> property.
	 * </p>
	 */
	public void setSuccess ( Object   success ) {
		getStateHelper().put(PropertyKeys.success, success);
		handleAttribute("success", success);
	}
    	/*
	 *The HTTP method to use to access the
          requested URL. Defaults to the 
          Ext.form.BasicForm's
          method, or if that is not specified, the underlying DOM
          form's method.
	 */
	
	public String getMethod () {
		return (String) getStateHelper().eval(PropertyKeys.method);
	}

	/**
	 * <p>
	 * Set the value of the <code>method</code> property.
	 * </p>
	 */
	public void setMethod ( String   method ) {
		getStateHelper().put(PropertyKeys.method, method);
		handleAttribute("method", method);
	}
    	/*
	 *The function to call when a failure
          packet was recieved, or when an error ocurred in the Ajax
          communication. The function is passed the following
          parameters:
          
            
            form : Ext.form.BasicForm
            The form that requested the
            action
            
            action : Ext.form.Action
            The Action class. If an Ajax
            error ocurred, the failure type will be in 
            failureType. The 
            result property of this
            object may be examined to perform custom
            postprocessing.
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getFailure () {
		return (Object) getStateHelper().eval(PropertyKeys.failure);
	}

	/**
	 * <p>
	 * Set the value of the <code>failure</code> property.
	 * </p>
	 */
	public void setFailure ( Object   failure ) {
		getStateHelper().put(PropertyKeys.failure, failure);
		handleAttribute("failure", failure);
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