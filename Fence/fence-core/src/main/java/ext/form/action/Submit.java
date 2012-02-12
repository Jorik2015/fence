package ext.form.action;

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
    <p>A class which handles submission of data from 
    <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Form</a>s and processes the
    returned response.</p>
    <p>Instances of this class are only created by a 
    <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Form</a> when 
    <a ext:cls="Ext.form.BasicForm" ext:member="submit" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit">submit</a>ting.</p>
    <p>
      <u>
        <b>Response Packet Criteria</b>
      </u>
    </p>
    <p>A response packet may contain:</p>
    <div class="mdetail-params">
      <ul>
        <li>
        <b>
          <code>success</code>
        </b> property : Boolean 
        <div class="sub-desc">The 
        <code>success</code> property is required.</div>
</li>
        <li>
        <b>
          <code>errors</code>
        </b> property : Object 
        <div class="sub-desc">
          <div class="sub-desc">The 
          <code>errors</code> property, which is optional, contains
          error messages for invalid fields.</div>
        </div>
</li>
      </ul>
    </div>
    <p>
      <u>
        <b>JSON Packets</b>
      </u>
    </p>
    <p>By default, response packets are assumed to be JSON, so a
    typical response packet may look like this:</p>
<pre>
<code>{
    success: false,
    errors: {
        clientCode: 
<em>"Client not found"</em>,
        portOfLoading: 
<em>"This field must not be null"</em>
    }
}</code>
    </pre>
    <p>Other data may be placed into the response for processing by
    the 
    <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Ext.form.BasicForm</a>'s callback
    or event handler methods. The object decoded from this JSON is
    available in the 
    <a ext:cls="Ext.form.Action" ext:member="result" href="output/Ext.form.Action.html#Ext.form.Action-result">result</a>
    property.</p>
    <p>Alternatively, if an 
    <a ext:cls="Ext.form.Action.Submit" ext:member="errorReader" href="output/Ext.form.Action.Submit.html#Ext.form.Action.Submit-errorReader">errorReader</a> is specified
    as an 
    <a ext:cls="Ext.data.XmlReader" href="output/Ext.data.XmlReader.html">XmlReader</a>:</p>
<pre>
<code>errorReader: 
<b>new</b> Ext.data.XmlReader({
            record : 
<em>'field'</em>,
            success: 
<em>'@success'</em>
        }, [
            
<em>'id'</em>, 
<em>'msg'</em>
        ]
    )</code>
    </pre>
    <p>then the results may be sent back in XML format:</p>
<pre>
<code>&lt;?xml version=
<em>"1.0"</em> encoding=
<em>"UTF-8"</em>?&gt;
&lt;message success=
<em>"false"</em>&gt;
&lt;errors&gt;
    &lt;field&gt;
        &lt;id&gt;clientCode&lt;/id&gt;
        &lt;msg&gt;&lt;![CDATA[Code not found. &lt;br
/&gt;&lt;i&gt;This is a test validation message from the server
&lt;/i&gt;]]&gt;&lt;/msg&gt;
    &lt;/field&gt;
    &lt;field&gt;
        &lt;id&gt;portOfLoading&lt;/id&gt;
        &lt;msg&gt;&lt;![CDATA[Port not found. &lt;br
/&gt;&lt;i&gt;This is a test validation message from the server
&lt;/i&gt;]]&gt;&lt;/msg&gt;
    &lt;/field&gt;
&lt;/errors&gt;
&lt;/message&gt;</code>
    </pre>
    <p>Other elements may be placed into the response XML for
    processing by the 
    <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Ext.form.BasicForm</a>'s callback
    or event handler methods. The XML document is available in the 
    <a ext:cls="Ext.form.Action.Submit" ext:member="errorReader" href="output/Ext.form.Action.Submit.html#Ext.form.Action.Submit-errorReader">errorReader</a>'s 
    <a ext:cls="Ext.data.XmlReader" ext:member="xmlData" href="output/Ext.data.XmlReader.html#Ext.data.XmlReader-xmlData">xmlData</a>
    property.</p>
  </div>

 */

@InstanceOf("Ext.form.Action.Submit")

@FacesComponent(value = "Ext.form.Action.Submit")
public class Submit extends Action {
	public static final String COMPONENT_FAMILY = "Ext.form.Action.Submit";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Action.Submit} instance with default property values.
	 * </p>
	 */
	public Submit() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			errorReader
			,clientValidation
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
            <p>
              <b>Optional. JSON is interpreted with no need for an
              errorReader.</b>
            </p>
            <p>A Reader which reads a single record from the
            returned data. The DataReader's 
            <b>success</b> property specifies how submission
            success is determined. The Record's data provides the
            error messages to apply to any invalid form Fields.</p>
          </div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getErrorReader () {
		return (Object) getStateHelper().eval(PropertyKeys.errorReader);
	}

	/**
	 * <p>
	 * Set the value of the <code>errorReader</code> property.
	 * </p>
	 */
	public void setErrorReader ( Object   errorReader ) {
		getStateHelper().put(PropertyKeys.errorReader, errorReader);
		handleAttribute("errorReader", errorReader);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Determines whether a Form's fields are
          validated in a final call to 
          <a ext:cls="Ext.form.BasicForm" ext:member="isValid" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-isValid">isValid</a> prior to
          submission. Pass 
          <tt>false</tt> in the Form's submit options to prevent
          this. If not defined, pre-submission field validation is
          performed.</div>

	 */
	
	public Boolean getClientValidation () {
		return (Boolean) getStateHelper().eval(PropertyKeys.clientValidation);
	}

	/**
	 * <p>
	 * Set the value of the <code>clientValidation</code> property.
	 * </p>
	 */
	public void setClientValidation ( Boolean   clientValidation ) {
		getStateHelper().put(PropertyKeys.clientValidation, clientValidation);
		handleAttribute("clientValidation", clientValidation);
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