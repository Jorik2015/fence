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
<div class="description">
    <p>Data reader class to create an Array of 
    <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> objects from an
    XML document based on mappings in a provided 
    <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> constructor.</p>
    <p>
    <b>Note</b>: that in order for the browser to parse a returned
    XML document, the Content-Type header in the HTTP response must
    be set to "text/xml" or "application/xml".</p>
    <p>Example code:</p>
<pre>
<code>
<b>var</b> Employee = Ext.data.Record.create([
   {name: 
<em>'name'</em>, mapping: 
<em>'name'</em>},     
<i>// 
<em>"mapping"</em> property not needed 
<b>if</b> it is the same as 
<em>"name"</em>
</i>
   {name: 
<em>'occupation'</em>}                 
<i>// This field will use 
<em>"occupation"</em> as the mapping.</i>
]);
<b>var</b> myReader = 
<b>new</b> Ext.data.XmlReader({
   totalProperty: 
<em>"results"</em>, 
<i>// The element which contains the total dataset size
(optional)</i>
   record: 
<em>"row"</em>,           
<i>// The repeated element which contains row information</i>
   idProperty: 
<em>"id"</em>         
<i>// The element within the row that provides an ID 
<b>for</b> the record (optional)</i>
   messageProperty: 
<em>"msg"</em>   
<i>// The element within the response that provides a user-feedback
message (optional)</i>
}, Employee);</code>
    </pre>
    <p>This would consume an XML file like this:</p>
<pre>
<code>&lt;?xml version=
<em>"1.0"</em> encoding=
<em>"UTF-8"</em>?&gt;
&lt;dataset&gt;
 &lt;results&gt;2&lt;/results&gt;
 &lt;row&gt;
   &lt;id&gt;1&lt;/id&gt;
   &lt;name&gt;Bill&lt;/name&gt;
   &lt;occupation&gt;Gardener&lt;/occupation&gt;
 &lt;/row&gt;
 &lt;row&gt;
   &lt;id&gt;2&lt;/id&gt;
   &lt;name&gt;Ben&lt;/name&gt;
   &lt;occupation&gt;Horticulturalist&lt;/occupation&gt;
 &lt;/row&gt;
&lt;/dataset&gt;</code>
    </pre>
  </div>

 */

@InstanceOf("Ext.data.XmlReader")
@ParseConfigMode(ui = false,name="reader",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.XmlReader")
public class XmlReader extends DataReader {
	public static final String COMPONENT_FAMILY = "Ext.data.XmlReader";

	/**
	 * <p>
	 * Create a new {@link Ext.data.XmlReader} instance with default property values.
	 * </p>
	 */
	public XmlReader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			record
			,totalProperty
			,successProperty
			,idPath
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
        
        
          record
         : String
        The DomQuery path to the repeated
        element which contains record information.
	 */
	
	public String getRecord () {
		return (String) getStateHelper().eval(PropertyKeys.record);
	}

	/**
	 * <p>
	 * Set the value of the <code>record</code> property.
	 * </p>
	 */
	public void setRecord ( String   record ) {
		getStateHelper().put(PropertyKeys.record, record);
		handleAttribute("record", record);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The DomQuery path from which to
          retrieve the total number of records in the dataset. This
          is only needed if the whole dataset is not passed in one
          go, but is being paged from the remote server.</div>

	 */
	
	public String getTotalProperty () {
		return (String) getStateHelper().eval(PropertyKeys.totalProperty);
	}

	/**
	 * <p>
	 * Set the value of the <code>totalProperty</code> property.
	 * </p>
	 */
	public void setTotalProperty ( String   totalProperty ) {
		getStateHelper().put(PropertyKeys.totalProperty, totalProperty);
		handleAttribute("totalProperty", totalProperty);
	}
    	/*
	 *
        
        
          successProperty
         : String
        The DomQuery path to the success
        attribute used by forms.
	 */
	
	public String getSuccessProperty () {
		return (String) getStateHelper().eval(PropertyKeys.successProperty);
	}

	/**
	 * <p>
	 * Set the value of the <code>successProperty</code> property.
	 * </p>
	 */
	public void setSuccessProperty ( String   successProperty ) {
		getStateHelper().put(PropertyKeys.successProperty, successProperty);
		handleAttribute("successProperty", successProperty);
	}
    	/*
	 *
        
        
          idPath
         : String
        The DomQuery path relative from the
        record element to the element that contains a record
        identifier value.
	 */
	
	public String getIdPath () {
		return (String) getStateHelper().eval(PropertyKeys.idPath);
	}

	/**
	 * <p>
	 * Set the value of the <code>idPath</code> property.
	 * </p>
	 */
	public void setIdPath ( String   idPath ) {
		getStateHelper().put(PropertyKeys.idPath, idPath);
		handleAttribute("idPath", idPath);
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