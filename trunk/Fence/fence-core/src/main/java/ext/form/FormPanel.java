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
    <p>Standard form container.</p>
    <p>
      <b>
        <u>Layout</u>
      </b>
    </p>
    <p>By default, FormPanel is configured with 
    <tt>layout:'form'</tt> to use an 
    <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>
    layout manager, which styles and renders fields and labels
    correctly. When nesting additional Containers within a
    FormPanel, you should ensure that any descendant Containers
    which host input Fields use the 
    <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>
    layout manager.</p>
    <p>
      <b>
        <u>BasicForm</u>
      </b>
    </p>
    <p>Although 
    <b>not listed</b> as configuration options of FormPanel, the
    FormPanel class accepts all of the config options required to
    configure its internal 
    <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Ext.form.BasicForm</a> for:</p>
    <div class="mdetail-params">
      <ul>
        <li>
          <a ext:cls="Ext.form.BasicForm" ext:member="fileUpload" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-fileUpload">file uploads</a>
        </li>
        <li>functionality for 
        <a ext:cls="Ext.form.BasicForm" ext:member="doAction" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-doAction">loading, validating and
        submitting</a> the form</li>
      </ul>
    </div>
    <p>
    <b>Note</b>: If subclassing FormPanel, any configuration
    options for the BasicForm must be applied to the 
    <tt>
      <b>initialConfig</b>
    </tt> property of the FormPanel. Applying 
    <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">BasicForm</a> configuration
    settings to 
    <b>
      <tt>this</tt>
    </b> will 
    <b>not</b> affect the BasicForm's configuration.</p>
    <p>
      <b>
        <u>Form Validation</u>
      </b>
    </p>
    <p>For information on form validation see the following:</p>
    <div class="mdetail-params">
      <ul>
        <li>
          <a ext:cls="Ext.form.TextField" href="output/Ext.form.TextField.html">Ext.form.TextField</a>
        </li>
        <li>
          <a ext:cls="Ext.form.VTypes" href="output/Ext.form.VTypes.html">Ext.form.VTypes</a>
        </li>
        <li>
          <a ext:cls="Ext.form.BasicForm" ext:member="doAction" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-doAction">BasicForm.doAction 
          <b>clientValidation</b> notes</a>
        </li>
        <li>
          <tt>
            <a ext:cls="Ext.form.FormPanel" ext:member="monitorValid" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-monitorValid">monitorValid</a>
          </tt>
        </li>
      </ul>
    </div>
    <p>
      <b>
        <u>Form Submission</u>
      </b>
    </p>
    <p>By default, Ext Forms are submitted through Ajax, using 
    <a ext:cls="Ext.form.Action" href="output/Ext.form.Action.html">Ext.form.Action</a>. To enable normal
    browser submission of the 
    <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">BasicForm</a> contained in this
    FormPanel, see the 
    <tt>
      <b>
        <a ext:cls="Ext.form.BasicForm" ext:member="standardSubmit" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-standardSubmit">standardSubmit</a>
      </b>
    </tt> option.</p>
  </div>

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
			minButtonWidth
			,labelWidth
			,monitorValid
			,itemCls
			,formId
			,layout
			,labelSeparator
			,hideLabels
			,buttons
			,labelAlign
			,monitorPoll
			,labelPad
			,listeners
			,errorReader
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The width of labels in pixels. This
          property cascades to child containers and can be
          overridden on any child container (e.g., a fieldset can
          specify a different 
          <tt>labelWidth</tt> for its fields) (defaults to 
          <tt>100</tt>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If 
          <tt>true</tt>, the form monitors its valid state 
          <b>client-side</b> and regularly fires the 
          <a ext:cls="Ext.form.FormPanel" ext:member="clientvalidation" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-clientvalidation">clientvalidation</a> event
          passing that state.
          <br/>
          <p>When monitoring valid state, the FormPanel
          enables/disables any of its configured 
          <a ext:cls="Ext.form.FormPanel" ext:member="buttons" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-buttons">buttons</a> which have been
          configured with 
          <code>formBind: true</code> depending on whether the 
          <a ext:cls="Ext.form.BasicForm" ext:member="isValid" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-isValid">form
          is valid</a> or not. Defaults to 
          <tt>false</tt>
</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Defaults to 
          <tt>'form'</tt>. Normally this configuration property
          should not be altered. For additional details see 
          <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>
          and 
          <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">Ext.Container.layout</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array of 
          <a ext:cls="Ext.Button" href="output/Ext.Button.html">Ext.Button</a>s or 
          <a ext:cls="Ext.Button" href="output/Ext.Button.html">Ext.Button</a> configs used to add
          buttons to the footer of this FormPanel.
          <br/>
          <p>Buttons in the footer of a FormPanel may be configured
          with the option 
          <tt>formBind: true</tt>. This causes the form's 
          <a ext:cls="Ext.form.FormPanel" ext:member="monitorValid" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-monitorValid">valid state monitor task</a>
          to enable/disable those Buttons depending on the form's
          valid/invalid state.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The label alignment value used for the 
          <tt>text-align</tt> specification for the 
          <b>container</b>. Valid values are 
          <tt>"left</tt>", 
          <tt>"top"</tt> or 
          <tt>"right"</tt> (defaults to 
          <tt>"left"</tt>). This property cascades to child 
          <b>containers</b> and can be overridden on any child 
          <b>container</b> (e.g., a fieldset can specify a
          different 
          <tt>labelAlign</tt> for its fields).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The default padding in pixels for field
          labels (defaults to 
          <tt>5</tt>). 
          <tt>labelPad</tt> only applies if 
          <tt>
            <a ext:cls="Ext.form.FormPanel" ext:member="labelWidth" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-labelWidth">labelWidth</a>
          </tt> is also specified, otherwise it will be
          ignored.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A config object containing one or more event
            handlers to be added to this object during
            initialization. This should be a valid listeners config
            object as specified in the 
            <a ext:cls="Ext.util.Observable" ext:member="addListener" href="output/Ext.util.Observable.html#Ext.util.Observable-addListener">addListener</a> example
            for attaching multiple handlers at once.</p>
            <br/>
            <p>
              <b>
                <u>DOM events from ExtJs 
                <a ext:cls="Ext.Component" href="output/Ext.Component.html">Components</a>
</u>
              </b>
            </p>
            <br/>
            <p>While 
            <i>some</i> ExtJs Component classes export selected DOM
            events (e.g. "click", "mouseover" etc), this is usually
            only done when extra value can be added. For example
            the 
            <a ext:cls="Ext.DataView" href="output/Ext.DataView.html">DataView</a>'s 
            <b>
              <code>
                <a ext:cls="Ext.DataView" ext:member="click" href="output/Ext.DataView.html#Ext.DataView-click">click</a>
              </code>
            </b> event passing the node clicked on. To access DOM
            events directly from a Component's HTMLElement,
            listeners must be added to the 
            <i>
              <a ext:cls="Ext.Component" ext:member="getEl" href="output/Ext.Component.html#Ext.Component-getEl">Element</a>
            </i> after the Component has been rendered. A plugin
            can simplify this step:</p>
<pre>
<code>
<i>// Plugin is configured 
<b>with</b> a listeners config object.</i>
<i>// The Component is appended to the argument list of all handler
functions.</i>
Ext.DomObserver = Ext.extend(Object, {
    constructor: 
<b>function</b>(config) {
        this.listeners = config.listeners ? config.listeners :
config;
    },

    
<i>// Component passes itself into plugin's init method</i>
    init: 
<b>function</b>(c) {
        
<b>var</b> p, l = this.listeners;
        
<b>for</b> (p 
<b>in</b> l) {
            
<b>if</b> (Ext.isFunction(l[p])) {
                l[p] = this.createHandler(l[p], c);
            } 
<b>else</b> {
                l[p].fn = this.createHandler(l[p].fn, c);
            }
        }

        
<i>// Add the listeners to the Element immediately following the
render call</i>
        c.render = c.render.
<a ext:cls="Function" ext:member="createSequence" href="output/Function.html#Function-createSequence">createSequence</a>(
<b>function</b>() {
            
<b>var</b> e = c.getEl();
            
<b>if</b> (e) {
                e.on(l);
            }
        });
    },

    createHandler: 
<b>function</b>(fn, c) {
        
<b>return</b> 
<b>function</b>(e) {
            fn.call(this, e, c);
        };
    }
});

<b>var</b> combo = 
<b>new</b> Ext.form.ComboBox({

    
<i>// Collapse combo when its element is clicked on</i>
    plugins: [ 
<b>new</b> Ext.DomObserver({
        click: 
<b>function</b>(evt, comp) {
            comp.collapse();
        }
    })],
    store: myStore,
    typeAhead: true,
    mode: 
<em>'local'</em>,
    triggerAction: 
<em>'all'</em>
});</code>
            </pre>
            <br/>
            <br/>
          </div>

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
					 "clientvalidation"
				));
				return superEvent;
	}
}