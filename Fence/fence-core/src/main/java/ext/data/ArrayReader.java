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
    Array. Each element of that Array represents a row of data
    fields. The fields are pulled into a Record object using as a
    subscript, the 
    <code>mapping</code> property of the field definition if it
    exists, or the field's ordinal position in the definition.</p>
    <p>Example code:</p>
<pre>
<code>
<b>var</b> Employee = Ext.data.Record.create([
    {name: 
<em>'name'</em>, mapping: 1},         
<i>// 
<em>"mapping"</em> only needed 
<b>if</b> an 
<em>"id"</em> field is present which</i>
    {name: 
<em>'occupation'</em>, mapping: 2}    
<i>// precludes using the ordinal position as the index.</i>
]);
<b>var</b> myReader = 
<b>new</b> Ext.data.ArrayReader({
    
<a ext:cls="Ext.data.ArrayReader" ext:member="idIndex" href="output/Ext.data.ArrayReader.html#Ext.data.ArrayReader-idIndex">idIndex</a>: 0
}, Employee);</code>
    </pre>
    <p>This would consume an Array like this:</p>
<pre>
<code>[ [1, 
<em>'Bill'</em>, 
<em>'Gardener'</em>], [2, 
<em>'Ben'</em>, 
<em>'Horticulturalist'</em>] ]</code>
    </pre>
  </div>

 */

@InstanceOf("Ext.data.ArrayReader")
@ParseConfigMode(ui = false,name="reader",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.ArrayReader")
public class ArrayReader extends JsonReader {
	public static final String COMPONENT_FAMILY = "Ext.data.ArrayReader";

	/**
	 * <p>
	 * Create a new {@link Ext.data.ArrayReader} instance with default property values.
	 * </p>
	 */
	public ArrayReader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			idIndex
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
        
        
          idIndex
         : Number
        The subscript within row Array that
        provides an ID for the Record.
	 */
	
	public Integer getIdIndex () {
		return (Integer) getStateHelper().eval(PropertyKeys.idIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>idIndex</code> property.
	 * </p>
	 */
	public void setIdIndex ( Integer   idIndex ) {
		getStateHelper().put(PropertyKeys.idIndex, idIndex);
		handleAttribute("idIndex", idIndex);
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