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
    Standard form container.
    
      
        Layout
      
    
    By default, FormPanel is configured with 
    layout:'form' to use an 
    Ext.layout.FormLayout
    layout manager, which styles and renders fields and labels
    correctly. When nesting additional Containers within a
    FormPanel, you should ensure that any descendant Containers
    which host input Fields use the 
    Ext.layout.FormLayout
    layout manager.
    
      
        BasicForm
      
    
    Although 
    not listed as configuration options of FormPanel, the
    FormPanel class accepts all of the config options required to
    configure its internal 
    Ext.form.BasicForm for:
    
      
        
          file uploads
        
        functionality for 
        loading, validating and
        submitting the form
      
    
    
    Note: If subclassing FormPanel, any configuration
    options for the BasicForm must be applied to the 
    
      initialConfig
     property of the FormPanel. Applying 
    BasicForm configuration
    settings to 
    
      this
     will 
    not affect the BasicForm's configuration.
    
      
        Form Validation
      
    
    For information on form validation see the following:
    
      
        
          Ext.form.TextField
        
        
          Ext.form.VTypes
        
        
          BasicForm.doAction 
          clientValidation notes
        
        
          
            monitorValid
          
        
      
    
    
      
        Form Submission
      
    
    By default, Ext Forms are submitted through Ajax, using 
    Ext.form.Action. To enable normal
    browser submission of the 
    BasicForm contained in this
    FormPanel, see the 
    
      
        standardSubmit
      
     option.
  
 */
@XType("form")
@InstanceOf("Ext.form.FormPanel")

@FacesComponent(value = "Ext.form.FormPanel")
public class FormPanel extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.form.FormPanel";

	/**
	 * <p>
	 * Create a new {@link Ext.form.FormPanel} instance with default property values.
	 * </p>
	 */
	public FormPanel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			formId
			,labelWidth
			,hideLabels
			,layout
			,labelSeparator
			,labelAlign
			,labelPad
			,minButtonWidth
			,monitorPoll
			,itemCls
			,buttons
			,monitorValid
			,timeout
			,paramOrder
			,baseParams
			,api
			,trackResetOnLoad
			,paramsAsHash
			,standardSubmit
			,waitTitle
			,errorReader
			,reader
			,listeners
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
        
        
          formId
         : String
        The id of the FORM tag (defaults to an
        auto-generated id).
	 */
	
	public String getFormId () {
		return (String) getStateHelper().eval(PropertyKeys.formId);
	}

	/**
	 * <p>
	 * Set the value of the <code>formId</code> property.
	 * </p>
	 */
	public void setFormId ( String   formId ) {
		getStateHelper().put(PropertyKeys.formId, formId);
		handleAttribute("formId", formId);
	}
    	/*
	 *The width of labels in pixels. This
          property cascades to child containers and can be
          overridden on any child container (e.g., a fieldset can
          specify a different 
          labelWidth for its fields) (defaults to 
          100).
	 */
	
	public Integer getLabelWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.labelWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelWidth</code> property.
	 * </p>
	 */
	public void setLabelWidth ( Integer   labelWidth ) {
		getStateHelper().put(PropertyKeys.labelWidth, labelWidth);
		handleAttribute("labelWidth", labelWidth);
	}
    	/*
	 *
        
        
          hideLabels
         : Boolean
        
          
          true to hide field labels by default (sets 
          display:none). Defaults to 
          false.
          Also see 
          Ext.Component.
          
            hideLabel
          .
        
	 */
	
	public Boolean getHideLabels () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideLabels);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideLabels</code> property.
	 * </p>
	 */
	public void setHideLabels ( Boolean   hideLabels ) {
		getStateHelper().put(PropertyKeys.hideLabels, hideLabels);
		handleAttribute("hideLabels", hideLabels);
	}
    	/*
	 *Defaults to 
          'form'. Normally this configuration property
          should not be altered. For additional details see 
          Ext.layout.FormLayout
          and 
          Ext.Container.layout.
	 */
	
	public String getLayout () {
		return (String) getStateHelper().eval(PropertyKeys.layout);
	}

	/**
	 * <p>
	 * Set the value of the <code>layout</code> property.
	 * </p>
	 */
	public void setLayout ( String   layout ) {
		getStateHelper().put(PropertyKeys.layout, layout);
		handleAttribute("layout", layout);
	}
    	/*
	 *
        
        
          labelSeparator
         : String
        See 
        Ext.Component.
        
          labelSeparator
        
	 */
	
	public String getLabelSeparator () {
		return (String) getStateHelper().eval(PropertyKeys.labelSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelSeparator</code> property.
	 * </p>
	 */
	public void setLabelSeparator ( String   labelSeparator ) {
		getStateHelper().put(PropertyKeys.labelSeparator, labelSeparator);
		handleAttribute("labelSeparator", labelSeparator);
	}
    	/*
	 *The label alignment value used for the 
          text-align specification for the 
          container. Valid values are 
          "left", 
          "top" or 
          "right" (defaults to 
          "left"). This property cascades to child 
          containers and can be overridden on any child 
          container (e.g., a fieldset can specify a
          different 
          labelAlign for its fields).
	 */
	
	public String getLabelAlign () {
		return (String) getStateHelper().eval(PropertyKeys.labelAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelAlign</code> property.
	 * </p>
	 */
	public void setLabelAlign ( String   labelAlign ) {
		getStateHelper().put(PropertyKeys.labelAlign, labelAlign);
		handleAttribute("labelAlign", labelAlign);
	}
    	/*
	 *The default padding in pixels for field
          labels (defaults to 
          5). 
          labelPad only applies if 
          
            labelWidth
           is also specified, otherwise it will be
          ignored.
	 */
	
	public Integer getLabelPad () {
		return (Integer) getStateHelper().eval(PropertyKeys.labelPad);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelPad</code> property.
	 * </p>
	 */
	public void setLabelPad ( Integer   labelPad ) {
		getStateHelper().put(PropertyKeys.labelPad, labelPad);
		handleAttribute("labelPad", labelPad);
	}
    	/*
	 *
        
        
          minButtonWidth
         : Number
        Minimum width of all buttons in pixels
        (defaults to 
        75).
	 */
	
	public Integer getMinButtonWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minButtonWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minButtonWidth</code> property.
	 * </p>
	 */
	public void setMinButtonWidth ( Integer   minButtonWidth ) {
		getStateHelper().put(PropertyKeys.minButtonWidth, minButtonWidth);
		handleAttribute("minButtonWidth", minButtonWidth);
	}
    	/*
	 *
        
        
          monitorPoll
         : Number
        The milliseconds to poll valid state,
        ignored if monitorValid is not true (defaults to
        200)
	 */
	
	public Integer getMonitorPoll () {
		return (Integer) getStateHelper().eval(PropertyKeys.monitorPoll);
	}

	/**
	 * <p>
	 * Set the value of the <code>monitorPoll</code> property.
	 * </p>
	 */
	public void setMonitorPoll ( Integer   monitorPoll ) {
		getStateHelper().put(PropertyKeys.monitorPoll, monitorPoll);
		handleAttribute("monitorPoll", monitorPoll);
	}
    	/*
	 *
        
        
          itemCls
         : String
        A css class to apply to the x-form-item
        of fields. This property cascades to child
        containers.
	 */
	
	public String getItemCls () {
		return (String) getStateHelper().eval(PropertyKeys.itemCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemCls</code> property.
	 * </p>
	 */
	public void setItemCls ( String   itemCls ) {
		getStateHelper().put(PropertyKeys.itemCls, itemCls);
		handleAttribute("itemCls", itemCls);
	}
    	/*
	 *An array of 
          Ext.Buttons or 
          Ext.Button configs used to add
          buttons to the footer of this FormPanel.
          
          Buttons in the footer of a FormPanel may be configured
          with the option 
          formBind: true. This causes the form's 
          valid state monitor task
          to enable/disable those Buttons depending on the form's
          valid/invalid state.
	 */
	@ClientConfig(JsonMode.Array)

	public Object getButtons () {
		return (Object) getStateHelper().eval(PropertyKeys.buttons);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttons</code> property.
	 * </p>
	 */
	public void setButtons ( Object   buttons ) {
		getStateHelper().put(PropertyKeys.buttons, buttons);
		handleAttribute("buttons", buttons);
	}
    	/*
	 *If 
          true, the form monitors its valid state 
          client-side and regularly fires the 
          clientvalidation event
          passing that state.
          
          When monitoring valid state, the FormPanel
          enables/disables any of its configured 
          buttons which have been
          configured with 
          formBind: true depending on whether the 
          form
          is valid or not. Defaults to 
          false
	 */
	
	public Boolean getMonitorValid () {
		return (Boolean) getStateHelper().eval(PropertyKeys.monitorValid);
	}

	/**
	 * <p>
	 * Set the value of the <code>monitorValid</code> property.
	 * </p>
	 */
	public void setMonitorValid ( Boolean   monitorValid ) {
		getStateHelper().put(PropertyKeys.monitorValid, monitorValid);
		handleAttribute("monitorValid", monitorValid);
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
            A config object containing one or more event
            handlers to be added to this object during
            initialization. This should be a valid listeners config
            object as specified in the 
            addListener example
            for attaching multiple handlers at once.
            
            
              
                DOM events from ExtJs 
                Components
              
            
            
            While 
            some ExtJs Component classes export selected DOM
            events (e.g. "click", "mouseover" etc), this is usually
            only done when extra value can be added. For example
            the 
            DataView's 
            
              
                click
              
             event passing the node clicked on. To access DOM
            events directly from a Component's HTMLElement,
            listeners must be added to the 
            
              Element
             after the Component has been rendered. A plugin
            can simplify this step:


// Plugin is configured 
with a listeners config object.
// The Component is appended to the argument list of all handler
functions.
Ext.DomObserver = Ext.extend(Object, {
    constructor: 
function(config) {
        this.listeners = config.listeners ? config.listeners :
config;
    },

    
// Component passes itself into plugin's init method
    init: 
function(c) {
        
var p, l = this.listeners;
        
for (p 
in l) {
            
if (Ext.isFunction(l[p])) {
                l[p] = this.createHandler(l[p], c);
            } 
else {
                l[p].fn = this.createHandler(l[p].fn, c);
            }
        }

        
// Add the listeners to the Element immediately following the
render call
        c.render = c.render.
createSequence(
function() {
            
var e = c.getEl();
            
if (e) {
                e.on(l);
            }
        });
    },

    createHandler: 
function(fn, c) {
        
return 
function(e) {
            fn.call(this, e, c);
        };
    }
});

var combo = 
new Ext.form.ComboBox({

    
// Collapse combo when its element is clicked on
    plugins: [ 
new Ext.DomObserver({
        click: 
function(evt, comp) {
            comp.collapse();
        }
    })],
    store: myStore,
    typeAhead: true,
    mode: 
'local',
    triggerAction: 
'all'
});
            
            
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getListeners () {
		return (Object) getStateHelper().eval(PropertyKeys.listeners);
	}

	/**
	 * <p>
	 * Set the value of the <code>listeners</code> property.
	 * </p>
	 */
	public void setListeners ( Object   listeners ) {
		getStateHelper().put(PropertyKeys.listeners, listeners);
		handleAttribute("listeners", listeners);
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
					 "clientvalidation"
				));
				return superEvent;
	}
}