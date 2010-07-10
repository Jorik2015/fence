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
import ext.form.Action;
import java.util.Date;

/**
 * 
    Encapsulates the DOM <form> element at the heart of
    the 
    FormPanel class, and provides
    input field management, validation, submission, and form
    loading services.
    By default, Ext Forms are submitted through Ajax, using an
    instance of 
    Ext.form.Action.Submit. To
    enable normal browser submission of an Ext Form, use the 
    standardSubmit config
    option.
    
      
        File Uploads
      
    
    
    File
    uploads are not performed using Ajax submission, that is
    they are 
    not performed using XMLHttpRequests. Instead the form is
    submitted in the standard manner with the DOM 
    <form> element temporarily modified to have its 
    target
    set to refer to a dynamically generated, hidden 
    <iframe> which is inserted into the document but
    removed after the return data has been gathered.
    The server response is parsed by the browser to create the
    document for the IFRAME. If the server is using JSON to send
    the return object, then the 
    Content-Type
    header must be set to "text/html" in order to tell the browser
    to insert the text unchanged into the document body.
    Characters which are significant to an HTML parser must be
    sent as HTML entities, so encode "<" as "&lt;", "&"
    as "&amp;" etc.
    The response text is retrieved from the document, and a fake
    XMLHttpRequest object is created containing a 
    responseText property in order to conform to the
    requirements of event handlers and callbacks.
    Be aware that file upload packets are sent with the content
    type 
    multipart/form
    and some server technologies (notably JEE) may require some
    custom processing in order to retrieve parameter names and
    parameter values from the packet content.
  
 */

@InstanceOf("Ext.form.BasicForm")

@FacesComponent(value = "Ext.form.BasicForm")
public class BasicForm extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.form.BasicForm";

	/**
	 * <p>
	 * Create a new {@link Ext.form.BasicForm} instance with default property values.
	 * </p>
	 */
	public BasicForm() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			timeout
			,paramOrder
			,baseParams
			,api
			,trackResetOnLoad
			,paramsAsHash
			,standardSubmit
			,waitTitle
			,errorReader
			,reader
			,url
			,fileUpload
			,method
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
        
        
          timeout
         : Number
        Timeout for form actions in seconds
        (default is 30 seconds).
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
            A list of params to be executed server side.
            Defaults to 
            undefined. Only used for the 
            
              api
             
            load configuration.
            
            Specify the params in the order in which they must
            be executed on the server-side as either (1) an Array
            of String values, or (2) a String of params delimited
            by either whitespace, comma, or pipe. For example, any
            of the following would be acceptable:

paramOrder: [
'param1',
'param2',
'param3']
paramOrder: 
'param1 param2 param3'
paramOrder: 
'param1,param2,param3'
paramOrder: 
'param1|param2|param'
            
          
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
	 *
            Parameters to pass with all requests. e.g.
            baseParams: {id: '123', foo: 'bar'}.
            Parameters are encoded as standard HTTP parameters
            using 
            Ext.urlEncode.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getBaseParams () {
		return (Object) getStateHelper().eval(PropertyKeys.baseParams);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseParams</code> property.
	 * </p>
	 */
	public void setBaseParams ( Object   baseParams ) {
		getStateHelper().put(PropertyKeys.baseParams, baseParams);
		handleAttribute("baseParams", baseParams);
	}
    	/*
	 *If specified load and submit actions
          will be handled with 
          Ext.form.Action.DirectLoad
          and 
          Ext.form.Action.DirectSubmit.
          Methods which have been imported by Ext.Direct can be
          specified here to load and submit forms. Such as the
          following:

api: {
    load: App.ss.MyProfile.load,
    submit: App.ss.MyProfile.submit
}
          
          Load actions can use 
          
            paramOrder
           or 
          
            paramsAsHash
           to customize how the load method is invoked.
          Submit actions will always use a standard form submit.
          The formHandler configuration must be set on the
          associated server-side method which has been imported by
          Ext.Direct
	 */
	@ClientConfig(JsonMode.Object)

	public Object getApi () {
		return (Object) getStateHelper().eval(PropertyKeys.api);
	}

	/**
	 * <p>
	 * Set the value of the <code>api</code> property.
	 * </p>
	 */
	public void setApi ( Object   api ) {
		getStateHelper().put(PropertyKeys.api, api);
		handleAttribute("api", api);
	}
    	/*
	 *If set to 
          true, 
          reset() resets to the
          last loaded or 
          setValues() data instead
          of when the form was first created. Defaults to 
          false.
	 */
	
	public Boolean getTrackResetOnLoad () {
		return (Boolean) getStateHelper().eval(PropertyKeys.trackResetOnLoad);
	}

	/**
	 * <p>
	 * Set the value of the <code>trackResetOnLoad</code> property.
	 * </p>
	 */
	public void setTrackResetOnLoad ( Boolean   trackResetOnLoad ) {
		getStateHelper().put(PropertyKeys.trackResetOnLoad, trackResetOnLoad);
		handleAttribute("trackResetOnLoad", trackResetOnLoad);
	}
    	/*
	 *Only used for the 
          
            api
           
          load configuration. Send parameters as a
          collection of named arguments (defaults to 
          false). Providing a 
          
            paramOrder
           nullifies this configuration.
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
	 *
            If set to 
            true, standard HTML form submits are used
            instead of XHR (Ajax) style form submissions. Defaults
            to 
            false.
            
            
            Note: When using 
            standardSubmit, the 
            options to 
            
              submit
             are ignored because Ext's Ajax infrastracture
            is bypassed. To pass extra parameters (e.g. 
            baseParams and 
            params), utilize hidden fields to submit
            extra data, for example:


new Ext.FormPanel({
    standardSubmit: true,
    baseParams: {
        foo: 
'bar'
    },
    
url: 
'myProcess.php',
    items: [{
        xtype: 
'textfield',
        name: 
'userName'
    }],
    buttons: [{
        text: 
'Save',
        handler: 
function(){
            
var fp = this.ownerCt.ownerCt,
                form = fp.getForm();
            
if (form.isValid()) {
                
// check 
if there are baseParams and 
if
                
// hiddent items have been added already
                
if (fp.baseParams && !fp.paramsAdded) {
                    
// add hidden items 
for all baseParams
                    
for (i 
in fp.baseParams) {
                        fp.add({
                            xtype: 
'hidden',
                            name: i,
                            value: fp.baseParams[i]
                        });
                    }
                    fp.doLayout();
                    
// set a custom flag to prevent re-adding
                    fp.paramsAdded = true;
                }
                form.
submit();
            }
        }
    }]
});
            
          
	 */
	
	public Boolean getStandardSubmit () {
		return (Boolean) getStateHelper().eval(PropertyKeys.standardSubmit);
	}

	/**
	 * <p>
	 * Set the value of the <code>standardSubmit</code> property.
	 * </p>
	 */
	public void setStandardSubmit ( Boolean   standardSubmit ) {
		getStateHelper().put(PropertyKeys.standardSubmit, standardSubmit);
		handleAttribute("standardSubmit", standardSubmit);
	}
    	/*
	 *
        
        
          waitTitle
         : String
        The default title to show for the
        waiting message box (defaults to 
        'Please Wait...')
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
	 *
            An Ext.data.DataReader (e.g. 
            Ext.data.XmlReader) to
            be used to read field error messages returned from
            'submit' actions. This is optional as there is built-in
            support for processing JSON.
            The Records which provide messages for the invalid
            Fields must use the Field name (or id) as the Record
            ID, and must contain a field called 'msg' which
            contains the error message.
            The errorReader does not have to be a full-blown
            implementation of a DataReader. It simply needs to
            implement a 
            read(xhr) function which returns an Array of
            Records in an object with the following structure:

{
    records: recordArray
}
            
          
	 */
	
	public DataReader getErrorReader () {
		return (DataReader) getStateHelper().eval(PropertyKeys.errorReader);
	}

	/**
	 * <p>
	 * Set the value of the <code>errorReader</code> property.
	 * </p>
	 */
	public void setErrorReader ( DataReader   errorReader ) {
		getStateHelper().put(PropertyKeys.errorReader, errorReader);
		handleAttribute("errorReader", errorReader);
	}
    	/*
	 *An Ext.data.DataReader (e.g. 
          Ext.data.XmlReader) to
          be used to read data when executing 'load' actions. This
          is optional as there is built-in support for processing
          JSON. For additional information on using an XMLReader
          see the example provided in
          examples/form/xml-form.html.
	 */
	
	public DataReader getReader () {
		return (DataReader) getStateHelper().eval(PropertyKeys.reader);
	}

	/**
	 * <p>
	 * Set the value of the <code>reader</code> property.
	 * </p>
	 */
	public void setReader ( DataReader   reader ) {
		getStateHelper().put(PropertyKeys.reader, reader);
		handleAttribute("reader", reader);
	}
    	/*
	 *
        
        
          url
         : String
        The URL to use for form actions if one
        isn't supplied in the 
        
        doAction
        options.
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
	 *Set to true if this form is a file
          upload. 
          File uploads are not performed using normal 'Ajax'
          techniques, that is they are 
          not performed using XMLHttpRequests. Instead the
          form is submitted in the standard manner with the DOM 
          <form> element temporarily modified to
          have its 
          target
          set to refer to a dynamically generated, hidden 
          <iframe> which is inserted into the
          document but removed after the return data has been
          gathered.
          The server response is parsed by the browser to create
          the document for the IFRAME. If the server is using JSON
          to send the return object, then the 
          Content-Type
          header must be set to "text/html" in order to tell the
          browser to insert the text unchanged into the document
          body.
          Characters which are significant to an HTML parser
          must be sent as HTML entities, so encode "<" as
          "&lt;", "&" as "&amp;" etc.
          The response text is retrieved from the document, and
          a fake XMLHttpRequest object is created containing a 
          responseText property in order to conform to the
          requirements of event handlers and callbacks.
          Be aware that file upload packets are sent with the
          content type 
          multipart/form
          and some server technologies (notably JEE) may require
          some custom processing in order to retrieve parameter
          names and parameter values from the packet
          content.
	 */
	
	public Boolean getFileUpload () {
		return (Boolean) getStateHelper().eval(PropertyKeys.fileUpload);
	}

	/**
	 * <p>
	 * Set the value of the <code>fileUpload</code> property.
	 * </p>
	 */
	public void setFileUpload ( Boolean   fileUpload ) {
		getStateHelper().put(PropertyKeys.fileUpload, fileUpload);
		handleAttribute("fileUpload", fileUpload);
	}
    	/*
	 *
        
        
          method
         : String
        The request method to use (GET or POST)
        for form actions if one isn't supplied in the action
        options.
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
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "actioncomplete"
					, "actionfailed"
					, "beforeaction"
				));
				return superEvent;
	}
}