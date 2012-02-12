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
    <p>This class encapsulates the field definition information
    specified in the field definition objects passed to 
    <a ext:cls="Ext.data.Record" ext:member="create" href="output/Ext.data.Record.html#Ext.data.Record-create">Ext.data.Record.create</a>.</p>
    <p>Developers do not need to instantiate this class. Instances
    are created by 
    <a ext:cls="Ext.data.Record.create" href="output/Ext.data.Record.create.html">Ext.data.Record.create</a> and
    cached in the 
    <a ext:cls="Ext.data.Record" ext:member="fields" href="output/Ext.data.Record.html#Ext.data.Record-fields">fields</a>
    property of the created Record constructor's 
    <b>prototype.</b>
</p>
  </div>

 */

@InstanceOf("Ext.data.Field")
@ParseConfigMode(ui = false,name="fields",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.data.Field")
public class Field extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.Field";

	/**
	 * <p>
	 * Create a new {@link Ext.data.Field} instance with default property values.
	 * </p>
	 */
	public Field() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			allowBlank
			,name
			,sortType
			,useNull
			,convert
			,mapping
			,dateFormat
			,type
			,defaultValue
			,sortDir
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
<div class="long">Used for validating a 
          <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">record</a>, defaults to 
          <code>true</code>. An empty value here will cause 
          <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a>.
          <a ext:cls="Ext.data.Record" ext:member="isValid" href="output/Ext.data.Record.html#Ext.data.Record-isValid">isValid</a> to evaluate to 
          <code>false</code>.</div>

	 */
	
	public Boolean getAllowBlank () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowBlank);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowBlank</code> property.
	 * </p>
	 */
	public void setAllowBlank ( Boolean   allowBlank ) {
		getStateHelper().put(PropertyKeys.allowBlank, allowBlank);
		handleAttribute("allowBlank", allowBlank);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The name by which the field is
          referenced within the Record. This is referenced by, for
          example, the 
          <code>dataIndex</code> property in column definition
          objects passed to 
          <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">Ext.grid.ColumnModel</a>. 
          <p>Note: In the simplest case, if no properties other
          than 
          <code>name</code> are required, a field definition may
          consist of just a String for the field name.</p>
</div>

	 */
	
	public String getName () {
		return (String) getStateHelper().eval(PropertyKeys.name);
	}

	/**
	 * <p>
	 * Set the value of the <code>name</code> property.
	 * </p>
	 */
	public void setName ( String   name ) {
		getStateHelper().put(PropertyKeys.name, name);
		handleAttribute("name", name);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A function which converts a Field's
          value to a comparable value in order to ensure correct
          sort ordering. Predefined functions are provided in 
          <a ext:cls="Ext.data.SortTypes" href="output/Ext.data.SortTypes.html">Ext.data.SortTypes</a>. A
          custom sort example:
<pre>
<code>
<i>// current sort     after sort we want</i>
<i>// +-+------+          +-+------+</i>
<i>// |1|First |          |1|First |</i>
<i>// |2|Last  |          |3|Second|</i>
<i>// |3|Second|          |2|Last  |</i>
<i>// +-+------+          +-+------+</i>

sortType: 
<b>function</b>(value) {
   
<b>switch</b> (value.toLowerCase()) 
<i>// native toLowerCase():</i>
   {
      
<b>case</b> 
<em>'first'</em>: 
<b>return</b> 1;
      
<b>case</b> 
<em>'second'</em>: 
<b>return</b> 2;
      
<b>default</b>: 
<b>return</b> 3;
   }
}</code>
          </pre>
</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getSortType () {
		return (Object) getStateHelper().eval(PropertyKeys.sortType);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortType</code> property.
	 * </p>
	 */
	public void setSortType ( Object   sortType ) {
		getStateHelper().put(PropertyKeys.sortType, sortType);
		handleAttribute("sortType", sortType);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>(Optional) Use when converting received data into a
            Number type (either int or float). If the value cannot
            be parsed, null will be used if useNull is true,
            otherwise the value will be 0. Defaults to 
            <tt>false</tt>
</p>
          </div>

	 */
	
	public Boolean getUseNull () {
		return (Boolean) getStateHelper().eval(PropertyKeys.useNull);
	}

	/**
	 * <p>
	 * Set the value of the <code>useNull</code> property.
	 * </p>
	 */
	public void setUseNull ( Boolean   useNull ) {
		getStateHelper().put(PropertyKeys.useNull, useNull);
		handleAttribute("useNull", useNull);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A function which converts the value
          provided by the Reader into an object that will be stored
          in the Record. It is passed the following parameters:
          <div class="mdetail-params">
            <ul>
              <li>
              <b>v</b> : Mixed
              <div class="sub-desc">The data value as read by the
              Reader, if undefined will use the configured 
              <code>
                <a ext:cls="Ext.data.Field" ext:member="defaultValue" href="output/Ext.data.Field.html#Ext.data.Field-defaultValue">defaultValue</a>
              </code>.</div>
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
<pre>
<code>
<i>// example of convert 
<b>function</b>
</i>
<b>function</b> fullName(v, record){
    
<b>return</b> record.name.last + 
<em>', '</em> + record.name.first;
}

<b>function</b> location(v, record){
    
<b>return</b> !record.city ? 
<em>''</em> : (record.city + 
<em>', '</em> + record.state);
}

<b>var</b> Dude = Ext.data.Record.create([
    {name: 
<em>'fullname'</em>,  convert: fullName},
    {name: 
<em>'firstname'</em>, mapping: 
<em>'name.first'</em>},
    {name: 
<em>'lastname'</em>,  mapping: 
<em>'name.last'</em>},
    {name: 
<em>'city'</em>, defaultValue: 
<em>'homeless'</em>},
    
<em>'state'</em>,
    {name: 
<em>'location'</em>,  convert: location}
]);

<i>// create the data store</i>
<b>var</b> store = 
<b>new</b> Ext.data.Store({
    reader: 
<b>new</b> Ext.data.JsonReader(
        {
            idProperty: 
<em>'key'</em>,
            root: 
<em>'daRoot'</em>,
            totalProperty: 
<em>'total'</em>
        },
        Dude  
<i>// recordType</i>
    )
});

<b>var</b> myData = [
    { key: 1,
      name: { first: 
<em>'Fat'</em>,    last:  
<em>'Albert'</em> }
      
<i>// notice no city, state provided 
<b>in</b> data object</i>
    },
    { key: 2,
      name: { first: 
<em>'Barney'</em>, last:  
<em>'Rubble'</em> },
      city: 
<em>'Bedrock'</em>, state: 
<em>'Stoneridge'</em>
    },
    { key: 3,
      name: { first: 
<em>'Cliff'</em>,  last:  
<em>'Claven'</em> },
      city: 
<em>'Boston'</em>,  state: 
<em>'MA'</em>
    }
];</code>
          </pre>
</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getConvert () {
		return (Object) getStateHelper().eval(PropertyKeys.convert);
	}

	/**
	 * <p>
	 * Set the value of the <code>convert</code> property.
	 * </p>
	 */
	public void setConvert ( Object   convert ) {
		getStateHelper().put(PropertyKeys.convert, convert);
		handleAttribute("convert", convert);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>(Optional) A path expression for use by the 
            <a ext:cls="Ext.data.DataReader" href="output/Ext.data.DataReader.html">Ext.data.DataReader</a>
            implementation that is creating the 
            <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a> to extract the
            Field value from the data object. If the path
            expression is the same as the field name, the mapping
            may be omitted.</p>
            <p>The form of the mapping expression depends on the
            Reader being used.</p>
            <div class="mdetail-params">
              <ul>
                <li>
                  <a ext:cls="Ext.data.JsonReader" href="output/Ext.data.JsonReader.html">Ext.data.JsonReader</a>
                  <div class="sub-desc">The mapping is a string
                  containing the javascript expression to reference
                  the data from an element of the data item's 
                  <a ext:cls="Ext.data.JsonReader" ext:member="root" href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-root">root</a> Array.
                  Defaults to the field name.</div>
                </li>
                <li>
                  <a ext:cls="Ext.data.XmlReader" href="output/Ext.data.XmlReader.html">Ext.data.XmlReader</a>
                  <div class="sub-desc">The mapping is an 
                  <a ext:cls="Ext.DomQuery" href="output/Ext.DomQuery.html">Ext.DomQuery</a> path to
                  the data item relative to the DOM element that
                  represents the 
                  <a ext:cls="Ext.data.XmlReader" ext:member="record" href="output/Ext.data.XmlReader.html#Ext.data.XmlReader-record">record</a>. Defaults
                  to the field name.</div>
                </li>
                <li>
                  <a ext:cls="Ext.data.ArrayReader" href="output/Ext.data.ArrayReader.html">Ext.data.ArrayReader</a>
                  <div class="sub-desc">The mapping is a number
                  indicating the Array index of the field's value.
                  Defaults to the field specification's Array
                  position.</div>
                </li>
              </ul>
            </div>
            <p>If a more complex value extraction strategy is
            required, then configure the Field with a 
            <a ext:cls="Ext.data.Field" ext:member="convert" href="output/Ext.data.Field.html#Ext.data.Field-convert">convert</a> function. This is
            passed the whole row object, and may interrogate it in
            whatever way is necessary in order to return the
            desired data.</p>
          </div>

	 */
	
	public String getMapping () {
		return (String) getStateHelper().eval(PropertyKeys.mapping);
	}

	/**
	 * <p>
	 * Set the value of the <code>mapping</code> property.
	 * </p>
	 */
	public void setMapping ( String   mapping ) {
		getStateHelper().put(PropertyKeys.mapping, mapping);
		handleAttribute("mapping", mapping);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>(Optional) Used when converting received data into a
            Date when the 
            <a ext:cls="Ext.data.Field" ext:member="type" href="output/Ext.data.Field.html#Ext.data.Field-type">type</a> is
            specified as 
            <code>
              <em>"date"</em>
            </code>.</p>
            <p>A format string for the 
            <a ext:cls="Date" ext:member="parseDate" href="output/Date.html#Date-parseDate">Date.parseDate</a> function, or
            "timestamp" if the value provided by the Reader is a
            UNIX timestamp, or "time" if the value provided by the
            Reader is a javascript millisecond timestamp. See 
            <a ext:cls="Date" href="output/Date.html">Date</a>
</p>
          </div>

	 */
	
	public String getDateFormat () {
		return (String) getStateHelper().eval(PropertyKeys.dateFormat);
	}

	/**
	 * <p>
	 * Set the value of the <code>dateFormat</code> property.
	 * </p>
	 */
	public void setDateFormat ( String   dateFormat ) {
		getStateHelper().put(PropertyKeys.dateFormat, dateFormat);
		handleAttribute("dateFormat", dateFormat);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The data type for automatic conversion
          from received data to the 
          <i>stored</i> value if 
          <code>
            <a ext:cls="Ext.data.Field" ext:member="convert" href="output/Ext.data.Field.html#Ext.data.Field-convert">convert</a>
          </code> has not been specified. This may be specified as
          a string value. Possible values are 
          <div class="mdetail-params">
            <ul>
              <li>auto (Default, implies no conversion)</li>
              <li>string</li>
              <li>int</li>
              <li>float</li>
              <li>boolean</li>
              <li>date</li>
            </ul>
          </div>
          <p>This may also be specified by referencing a member of
          the 
          <a ext:cls="Ext.data.Types" href="output/Ext.data.Types.html">Ext.data.Types</a> class.</p>
          <p>Developers may create their own application-specific
          data types by defining new members of the 
          <a ext:cls="Ext.data.Types" href="output/Ext.data.Types.html">Ext.data.Types</a>
          class.</p>
</div>

	 */
	
	public Object getType () {
		return (Object) getStateHelper().eval(PropertyKeys.type);
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType ( Object   type ) {
		getStateHelper().put(PropertyKeys.type, type);
		handleAttribute("type", type);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The default value used 
          <b>when a Record is being created by a 
          <a ext:cls="Ext.data.Reader" href="output/Ext.data.Reader.html">Reader</a>
</b> when the item
          referenced by the 
          <code>
            <a ext:cls="Ext.data.Field" ext:member="mapping" href="output/Ext.data.Field.html#Ext.data.Field-mapping">mapping</a>
          </code> does not exist in the data object (i.e.
          undefined). (defaults to "")</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaultValue () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultValue);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultValue</code> property.
	 * </p>
	 */
	public void setDefaultValue ( Object   defaultValue ) {
		getStateHelper().put(PropertyKeys.defaultValue, defaultValue);
		handleAttribute("defaultValue", defaultValue);
	}
    	/*
	 *
        
        
          sortDir
         : String
        Initial direction to sort (
        
          "ASC"
         or 
        
          "DESC"
        ). Defaults to 
        
          "ASC"
        .
	 */
	
	public String getSortDir () {
		return (String) getStateHelper().eval(PropertyKeys.sortDir);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortDir</code> property.
	 * </p>
	 */
	public void setSortDir ( String   sortDir ) {
		getStateHelper().put(PropertyKeys.sortDir, sortDir);
		handleAttribute("sortDir", sortDir);
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