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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">DataWriter extension for writing an
  array or single 
  <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> object(s) in
  preparation for executing a remote CRUD action.</div>

 */

@InstanceOf("Ext.data.JsonWriter")
@ParseConfigMode(ui = false,name="writer",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.JsonWriter")
public class JsonWriter extends DataWriter {
	public static final String COMPONENT_FAMILY = "Ext.data.JsonWriter";

	/**
	 * <p>
	 * Create a new {@link Ext.data.JsonWriter} instance with default property values.
	 * </p>
	 */
	public JsonWriter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			encode
			,encodeDelete
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
            <tt>true</tt> to 
            <a ext:cls="Ext.util.JSON" ext:member="encode" href="output/Ext.util.JSON.html#Ext.util.JSON-encode">JSON
            encode</a> the 
            <a ext:cls="Ext.data.DataWriter" ext:member="toHash" href="output/Ext.data.DataWriter.html#Ext.data.DataWriter-toHash">hashed data</a> into a
            standard HTTP parameter named after this Reader's 
            <code>meta.root</code> property which, by default is
            imported from the associated Reader. Defaults to 
            <tt>true</tt>.</p>
            <p>If set to 
            <code>false</code>, the hashed data is 
            <a ext:cls="Ext.util.JSON" ext:member="encode" href="output/Ext.util.JSON.html#Ext.util.JSON-encode">JSON
            encoded</a>, along with the associated 
            <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>'s 
            <a ext:cls="Ext.data.Store" ext:member="baseParams" href="output/Ext.data.Store.html#Ext.data.Store-baseParams">baseParams</a>, into the POST
            body.</p>
            <p>When using 
            <a ext:cls="Ext.data.DirectProxy" href="output/Ext.data.DirectProxy.html">Ext.data.DirectProxy</a>,
            set this to 
            <tt>false</tt> since Ext.Direct.JsonProvider will
            perform its own json-encoding. In addition, if you're
            using 
            <a ext:cls="Ext.data.HttpProxy" href="output/Ext.data.HttpProxy.html">Ext.data.HttpProxy</a>,
            setting to 
            <tt>false</tt> will cause HttpProxy to transmit data
            using the 
            <b>jsonData</b> configuration-params of 
            <a ext:cls="Ext.Ajax" ext:member="request" href="output/Ext.Ajax.html#Ext.Ajax-request">Ext.Ajax.request</a> instead of 
            <b>params</b>.</p>
            <p>When using a 
            <a ext:cls="Ext.data.Store" ext:member="restful" href="output/Ext.data.Store.html#Ext.data.Store-restful">Ext.data.Store.restful</a>
            Store, some serverside frameworks are tuned to expect
            data through the jsonData mechanism. In those cases,
            one will want to set 
            <b>encode: 
            <tt>false</tt>
</b>, as in let the lower-level
            connection object (eg: Ext.Ajax) do the encoding.</p>
          </div>

	 */
	
	public Boolean getEncode () {
		return (Boolean) getStateHelper().eval(PropertyKeys.encode);
	}

	/**
	 * <p>
	 * Set the value of the <code>encode</code> property.
	 * </p>
	 */
	public void setEncode ( Boolean   encode ) {
		getStateHelper().put(PropertyKeys.encode, encode);
		handleAttribute("encode", encode);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">False to send only the id to the server
          on delete, true to encode it in an object literal, eg: 
<pre>
<code>{id: 1}</code>
          </pre>Defaults to 
          <tt>false</tt>
</div>

	 */
	
	public Boolean getEncodeDelete () {
		return (Boolean) getStateHelper().eval(PropertyKeys.encodeDelete);
	}

	/**
	 * <p>
	 * Set the value of the <code>encodeDelete</code> property.
	 * </p>
	 */
	public void setEncodeDelete ( Boolean   encodeDelete ) {
		getStateHelper().put(PropertyKeys.encodeDelete, encodeDelete);
		handleAttribute("encodeDelete", encodeDelete);
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