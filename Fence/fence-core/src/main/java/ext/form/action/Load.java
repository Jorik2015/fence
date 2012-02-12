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
  <p>A class which handles loading of data from a server into the
  Fields of an 
  <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Ext.form.BasicForm</a>.</p>
  <p>Instances of this class are only created by a 
  <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Form</a> when 
  <a ext:cls="Ext.form.BasicForm" ext:member="load" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-load">load</a>ing.</p>
  <p>
    <u>
      <b>Response Packet Criteria</b>
    </u>
  </p>
  <p>A response packet 
  <b>must</b> contain:</p>
  <div class="mdetail-params">
    <ul>
      <li>
      <b>
        <code>success</code>
      </b> property : Boolean</li>
      <li>
      <b>
        <code>data</code>
      </b> property : Object</li>
      <li style="list-style: none">
        <div class="sub-desc">The 
        <code>data</code> property contains the values of Fields to
        load. The individual value object for each Field is passed
        to the Field's 
        <a ext:cls="Ext.form.Field" ext:member="setValue" href="output/Ext.form.Field.html#Ext.form.Field-setValue">setValue</a>
        method.</div>
      </li>
    </ul>
  </div>
  <p>
    <u>
      <b>JSON Packets</b>
    </u>
  </p>
  <p>By default, response packets are assumed to be JSON, so for
  the following form load call:</p>
<pre>
<code>
<b>var</b> myFormPanel = 
<b>new</b> Ext.form.FormPanel({
    title: 
<em>'Client and routing info'</em>,
    items: [{
        fieldLabel: 
<em>'Client'</em>,
        name: 
<em>'clientName'</em>
    }, {
        fieldLabel: 
<em>'Port of loading'</em>,
        name: 
<em>'portOfLoading'</em>
    }, {
        fieldLabel: 
<em>'Port of discharge'</em>,
        name: 
<em>'portOfDischarge'</em>
    }]
});
myFormPanel.
<a ext:cls="Ext.form.FormPanel" ext:member="getForm" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-getForm">getForm</a>().
<a ext:cls="Ext.form.BasicForm" ext:member="load" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-load">load</a>({
    url: 
<em>'/getRoutingInfo.php'</em>,
    params: {
        consignmentRef: myConsignmentRef
    },
    failure: 
<b>function</b>(form, action) {
        Ext.Msg.alert(
<em>"Load failed"</em>, action.result.errorMessage);
    }
});</code>
  </pre>a 
  <b>success response</b> packet may look like this:
  <br/>
  <br/>
<pre>
<code>{
    success: true,
    data: {
        clientName: 
<em>"Fred. Olsen Lines"</em>,
        portOfLoading: 
<em>"FXT"</em>,
        portOfDischarge: 
<em>"OSL"</em>
    }
}</code>
  </pre>while a 
  <b>failure response</b> packet may look like this:
  <br/>
  <br/>
<pre>
<code>{
    success: false,
    errorMessage: 
<em>"Consignment reference not found"</em>
}</code>
  </pre>
  <p>Other data may be placed into the response for processing the 
  <a ext:cls="Ext.form.BasicForm" href="output/Ext.form.BasicForm.html">Form</a>'s callback or event handler
  methods. The object decoded from this JSON is available in the 
  <a ext:cls="Ext.form.Action" ext:member="result" href="output/Ext.form.Action.html#Ext.form.Action-result">result</a>
  property.</p>
</div>

 */

@InstanceOf("Ext.form.Action.Load")

@FacesComponent(value = "Ext.form.Action.Load")
public class Load extends Action {
	public static final String COMPONENT_FAMILY = "Ext.form.Action.Load";

	/**
	 * <p>
	 * Create a new {@link Ext.form.Action.Load} instance with default property values.
	 * </p>
	 */
	public Load() {
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