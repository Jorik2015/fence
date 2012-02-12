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
    <p>This is s static class containing the system-supplied data
    types which may be given to a 
    <a ext:cls="Ext.data.Field" href="output/Ext.data.Field.html">Field</a>.</p>
    <p>The properties in this class are used as type indicators in
    the 
    <a ext:cls="Ext.data.Field" href="output/Ext.data.Field.html">Field</a> class, so to test whether a
    Field is of a certain type, compare the 
    <a ext:cls="Ext.data.Field" ext:member="type" href="output/Ext.data.Field.html#Ext.data.Field-type">type</a> property
    against properties of this class.</p>
    <p>Developers may add their own application-specific data types
    to this class. Definition names must be UPPERCASE. each type
    definition must contain three properties:</p>
    <div class="mdetail-params">
      <ul>
        <li>
        <code>convert</code> : 
        <i>Function</i>
        <div class="sub-desc">A function to convert raw data values
        from a data block into the data to be stored in the Field.
        The function is passed the collowing parameters: 
        <div class="mdetail-params">
          <ul>
            <li>
            <b>v</b> : Mixed
            <div class="sub-desc">The data value as read by the
            Reader, if undefined will use the configured 
            <tt>
              <a ext:cls="Ext.data.Field" ext:member="defaultValue" href="output/Ext.data.Field.html#Ext.data.Field-defaultValue">defaultValue</a>
            </tt>.</div>
</li>
            <li>
            <b>rec</b> : Mixed
            <div class="sub-desc">The data object containing the
            row as read by the Reader. Depending on the Reader
            type, this could be an Array (
            <a ext:cls="Ext.data.ArrayReader" href="output/Ext.data.ArrayReader.html">ArrayReader</a>), an
            object (
            <a ext:cls="Ext.data.JsonReader" href="output/Ext.data.JsonReader.html">JsonReader</a>), or an
            XML element (
            <a ext:cls="Ext.data.XMLReader" href="output/Ext.data.XMLReader.html">XMLReader</a>).</div>
</li>
          </ul>
        </div>
</div>
</li>
        <li>
        <code>sortType</code> : 
        <i>Function</i> 
        <div class="sub-desc">A function to convert the stored data
        into comparable form, as defined by 
        <a ext:cls="Ext.data.SortTypes" href="output/Ext.data.SortTypes.html">Ext.data.SortTypes</a>.</div>
</li>
        <li>
        <code>type</code> : 
        <i>String</i> 
        <div class="sub-desc">A textual data type name.</div>
</li>
      </ul>
    </div>
    <p>For example, to create a VELatLong field (See the Microsoft
    Bing Mapping API) containing the latitude/longitude value of a
    datapoint on a map from a JsonReader data block which contained
    the properties 
    <code>lat</code> and 
    <code>long</code>, you would define a new data type like
    this:</p>
<pre>
<code>
<i>// Add a 
<b>new</b> Field data type which stores a VELatLong object 
<b>in</b> the Record.</i>
Ext.data.Types.VELATLONG = {
    convert: 
<b>function</b>(v, data) {
        
<b>return</b> 
<b>new</b> VELatLong(data.lat, data.long);
    },
    sortType: 
<b>function</b>(v) {
        
<b>return</b> v.Latitude;  
<i>// When sorting, order by latitude</i>
    },
    type: 
<em>'VELatLong'</em>
};</code>
    </pre>
    <p>Then, when declaring a Record, use</p>
<pre>
<code>
<b>var</b> types = Ext.data.Types; 
<i>// allow shorthand type access</i>
UnitRecord = Ext.data.Record.create([
    { name: 
<em>'unitName'</em>, mapping: 
<em>'UnitName'</em> },
    { name: 
<em>'curSpeed'</em>, mapping: 
<em>'CurSpeed'</em>, type: types.INT },
    { name: 
<em>'latitude'</em>, mapping: 
<em>'lat'</em>, type: types.FLOAT },
    { name: 
<em>'latitude'</em>, mapping: 
<em>'lat'</em>, type: types.FLOAT },
    { name: 
<em>'position'</em>, type: types.VELATLONG }
]);</code>
    </pre>
    <br/>
    <br/>
    <i>This class is a singleton and cannot be created
    directly.</i>
  </div>

 */

@InstanceOf("Ext.data.Types")

@FacesComponent(value = "Ext.data.Types")
public class Types extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.Types";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Types} instance with default property values.
	 * </p>
	 */
	public Types() {
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