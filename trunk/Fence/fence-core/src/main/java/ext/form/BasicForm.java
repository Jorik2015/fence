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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>Encapsulates the DOM &lt;form&gt; element at the heart of
    the 
    <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">FormPanel</a> class, and provides
    input field management, validation, submission, and form
    loading services.</p>
    <p>By default, Ext Forms are submitted through Ajax, using an
    instance of 
    <a ext:cls="Ext.form.Action.Submit" href="output/Ext.form.Action.Submit.html">Ext.form.Action.Submit</a>. To
    enable normal browser submission of an Ext Form, use the 
    <a ext:cls="Ext.form.BasicForm" ext:member="standardSubmit" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-standardSubmit">standardSubmit</a> config
    option.</p>
    <p>
      <b>
        <u>File Uploads</u>
      </b>
    </p>
    <p>
    <a ext:cls="Ext.form.BasicForm" ext:member="fileUpload" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-fileUpload">File
    uploads</a> are not performed using Ajax submission, that is
    they are 
    <b>not</b> performed using XMLHttpRequests. Instead the form is
    submitted in the standard manner with the DOM 
    <tt>&lt;form&gt;</tt> element temporarily modified to have its 
    <a href="http://www.w3.org/TR/REC-html40/present/frames.html#adef-target">target</a>
    set to refer to a dynamically generated, hidden 
    <tt>&lt;iframe&gt;</tt> which is inserted into the document but
    removed after the return data has been gathered.</p>
    <p>The server response is parsed by the browser to create the
    document for the IFRAME. If the server is using JSON to send
    the return object, then the 
    <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17">Content-Type</a>
    header must be set to "text/html" in order to tell the browser
    to insert the text unchanged into the document body.</p>
    <p>Characters which are significant to an HTML parser must be
    sent as HTML entities, so encode "&lt;" as "&amp;lt;", "&amp;"
    as "&amp;amp;" etc.</p>
    <p>The response text is retrieved from the document, and a fake
    XMLHttpRequest object is created containing a 
    <tt>responseText</tt> property in order to conform to the
    requirements of event handlers and callbacks.</p>
    <p>Be aware that file upload packets are sent with the content
    type 
    <a href="http://www.faqs.org/rfcs/rfc2388.html">multipart/form</a>
    and some server technologies (notably JEE) may require some
    custom processing in order to retrieve parameter names and
    parameter values from the packet content.</p>
  </div>

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
			errorReader
			,paramOrder
			,trackResetOnLoad
			,fileUpload
			,url
			,standardSubmit
			,baseParams
			,reader
			,paramsAsHash
			,api
			,method
			,waitTitle
			,timeout
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
<div class="long">
            <p>An Ext.data.DataReader (e.g. 
            <a ext:cls="Ext.data.XmlReader" href="output/Ext.data.XmlReader.html">Ext.data.XmlReader</a>) to
            be used to read field error messages returned from
            'submit' actions. This is optional as there is built-in
            support for processing JSON.</p>
            <p>The Records which provide messages for the invalid
            Fields must use the Field name (or id) as the Record
            ID, and must contain a field called 'msg' which
            contains the error message.</p>
            <p>The errorReader does not have to be a full-blown
            implementation of a DataReader. It simply needs to
            implement a 
            <tt>read(xhr)</tt> function which returns an Array of
            Records in an object with the following structure:</p>
<pre>
<code>{
    records: recordArray
}</code>
            </pre>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A list of params to be executed server side.
            Defaults to 
            <tt>undefined</tt>. Only used for the 
            <code>
              <a ext:cls="Ext.form.BasicForm" ext:member="api" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-api">api</a>
            </code> 
            <code>load</code> configuration.</p>
            <br/>
            <p>Specify the params in the order in which they must
            be executed on the server-side as either (1) an Array
            of String values, or (2) a String of params delimited
            by either whitespace, comma, or pipe. For example, any
            of the following would be acceptable:</p>
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
<div class="long">If set to 
          <tt>true</tt>, 
          <a ext:cls="Ext.form.BasicForm" ext:member="reset" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-reset">reset</a>() resets to the
          last loaded or 
          <a ext:cls="Ext.form.BasicForm" ext:member="setValues" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-setValues">setValues</a>() data instead
          of when the form was first created. Defaults to 
          <tt>false</tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Set to true if this form is a file
          upload. 
          <p>File uploads are not performed using normal 'Ajax'
          techniques, that is they are 
          <b>not</b> performed using XMLHttpRequests. Instead the
          form is submitted in the standard manner with the DOM 
          <tt>&lt;form&gt;</tt> element temporarily modified to
          have its 
          <a href="http://www.w3.org/TR/REC-html40/present/frames.html#adef-target">target</a>
          set to refer to a dynamically generated, hidden 
          <tt>&lt;iframe&gt;</tt> which is inserted into the
          document but removed after the return data has been
          gathered.</p>
          <p>The server response is parsed by the browser to create
          the document for the IFRAME. If the server is using JSON
          to send the return object, then the 
          <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17">Content-Type</a>
          header must be set to "text/html" in order to tell the
          browser to insert the text unchanged into the document
          body.</p>
          <p>Characters which are significant to an HTML parser
          must be sent as HTML entities, so encode "&lt;" as
          "&amp;lt;", "&amp;" as "&amp;amp;" etc.</p>
          <p>The response text is retrieved from the document, and
          a fake XMLHttpRequest object is created containing a 
          <tt>responseText</tt> property in order to conform to the
          requirements of event handlers and callbacks.</p>
          <p>Be aware that file upload packets are sent with the
          content type 
          <a href="http://www.faqs.org/rfcs/rfc2388.html">multipart/form</a>
          and some server technologies (notably JEE) may require
          some custom processing in order to retrieve parameter
          names and parameter values from the packet
          content.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>If set to 
            <tt>true</tt>, standard HTML form submits are used
            instead of XHR (Ajax) style form submissions. Defaults
            to 
            <tt>false</tt>.</p>
            <br/>
            <p>
            <b>Note:</b> When using 
            <code>standardSubmit</code>, the 
            <code>options</code> to 
            <code>
              <a ext:cls="Ext.form.BasicForm" ext:member="submit" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit">submit</a>
            </code> are ignored because Ext's Ajax infrastracture
            is bypassed. To pass extra parameters (e.g. 
            <code>baseParams</code> and 
            <code>params</code>), utilize hidden fields to submit
            extra data, for example:</p>
<pre>
<code>
<b>new</b> Ext.FormPanel({
    standardSubmit: true,
    baseParams: {
        foo: 
<em>'bar'</em>
    },
    
<a ext:cls="url" href="output/url.html">url</a>: 
<em>'myProcess.php'</em>,
    items: [{
        xtype: 
<em>'textfield'</em>,
        name: 
<em>'userName'</em>
    }],
    buttons: [{
        text: 
<em>'Save'</em>,
        handler: 
<b>function</b>(){
            
<b>var</b> fp = this.ownerCt.ownerCt,
                form = fp.getForm();
            
<b>if</b> (form.isValid()) {
                
<i>// check 
<b>if</b> there are baseParams and 
<b>if</b>
</i>
                
<i>// hiddent items have been added already</i>
                
<b>if</b> (fp.baseParams &amp;&amp; !fp.paramsAdded) {
                    
<i>// add hidden items 
<b>for</b> all baseParams</i>
                    
<b>for</b> (i 
<b>in</b> fp.baseParams) {
                        fp.add({
                            xtype: 
<em>'hidden'</em>,
                            name: i,
                            value: fp.baseParams[i]
                        });
                    }
                    fp.doLayout();
                    
<i>// set a custom flag to prevent re-adding</i>
                    fp.paramsAdded = true;
                }
                form.
<a ext:cls="Ext.form.BasicForm" ext:member="submit" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit">submit</a>();
            }
        }
    }]
});</code>
            </pre>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Parameters to pass with all requests. e.g.
            baseParams: {id: '123', foo: 'bar'}.</p>
            <p>Parameters are encoded as standard HTTP parameters
            using 
            <a ext:cls="Ext" ext:member="urlEncode" href="output/Ext.html#Ext-urlEncode">Ext.urlEncode</a>.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An Ext.data.DataReader (e.g. 
          <a ext:cls="Ext.data.XmlReader" href="output/Ext.data.XmlReader.html">Ext.data.XmlReader</a>) to
          be used to read data when executing 'load' actions. This
          is optional as there is built-in support for processing
          JSON. For additional information on using an XMLReader
          see the example provided in
          examples/form/xml-form.html.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Only used for the 
          <code>
            <a ext:cls="Ext.form.BasicForm" ext:member="api" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-api">api</a>
          </code> 
          <code>load</code> configuration. Send parameters as a
          collection of named arguments (defaults to 
          <tt>false</tt>). Providing a 
          <tt>
            <a ext:cls="Ext.form.BasicForm" ext:member="paramOrder" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-paramOrder">paramOrder</a>
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
<div class="long">If specified load and submit actions
          will be handled with 
          <a ext:cls="Ext.form.Action.DirectLoad" href="output/Ext.form.Action.DirectLoad.html">Ext.form.Action.DirectLoad</a>
          and 
          <a ext:cls="Ext.form.Action.DirectSubmit" href="output/Ext.form.Action.DirectSubmit.html">Ext.form.Action.DirectSubmit</a>.
          Methods which have been imported by Ext.Direct can be
          specified here to load and submit forms. Such as the
          following:
<pre>
<code>api: {
    load: App.ss.MyProfile.load,
    submit: App.ss.MyProfile.submit
}</code>
          </pre>
          <p>Load actions can use 
          <code>
            <a ext:cls="Ext.form.BasicForm" ext:member="paramOrder" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-paramOrder">paramOrder</a>
          </code> or 
          <code>
            <a ext:cls="Ext.form.BasicForm" ext:member="paramsAsHash" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-paramsAsHash">paramsAsHash</a>
          </code> to customize how the load method is invoked.
          Submit actions will always use a standard form submit.
          The formHandler configuration must be set on the
          associated server-side method which has been imported by
          Ext.Direct</p>
</div>

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