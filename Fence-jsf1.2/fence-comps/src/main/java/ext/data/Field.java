package ext.data;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.base.ExtOutput;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This class encapsulates the field definition information specified in the
 * field definition objects passed to <a
 * href="output/Ext.data.Record.html#Ext.data.Record-create" ext:member="create"
 * ext:cls="Ext.data.Record">Ext.data.Record.create</a>.
 * </p>
 * 
 * <p>
 * Developers do not need to instantiate this class. Instances are created by <a
 * href="output/Ext.data.Record.create.html"
 * ext:cls="Ext.data.Record.create">Ext.data.Record.create</a> and cached in the
 * <a href="output/Ext.data.Record.html#Ext.data.Record-fields"
 * ext:member="fields" ext:cls="Ext.data.Record">fields</a> property of the
 * created Record constructor's <b>prototype.</b>
 * </p>
 */
@InstanceOf("Ext.data.Field")
@ParseConfigMode(ui = false,name="fields", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class Field extends ExtOutput {
	public static final String COMPONENT_TYPE = "Ext.data.Field";
	public static final String COMPONENT_FAMILY = "Ext.data.Field";

	/**
	 * <p>
	 * Create a new {@link Field} instance with default property values.
	 * </p>
	 */
	public Field() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean allowBlank;

	/**
	 * Used for validating a <a href="output/Ext.data.Record.html"
	 * ext:cls="Ext.data.Record">record</a>, defaults to <tt>true</tt>. Anempty
	 * value here will cause <a href="output/Ext.data.Record.html"
	 * ext:cls="Ext.data.Record">Ext.data.Record</a>.<a
	 * href="output/Ext.data.Record.html#Ext.data.Record-isValid"
	 * ext:member="isValid" ext:cls="Ext.data.Record">isValid</a> to evaluate to
	 * <tt>false</tt>.
	 */
	public Boolean getAllowBlank() {
		if (null != this.allowBlank) {
			return this.allowBlank;
		}
		ValueExpression _ve = getValueExpression("allowBlank");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowBlank</code> property.
	 * </p>
	 */
	public void setAllowBlank(Boolean allowBlank) {
		this.allowBlank = allowBlank;
		this.handleConfig("allowBlank", allowBlank);
	}

	private Object convert;

	/**
	 * A function which converts the value provided bythe Reader into an object
	 * that will be stored in the Record. It is passed the following parameters:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><b>v</b> : Mixed
	 * 
	 * <div class="sub-desc">The data value as read by the Reader, if undefined
	 * will use the configured
	 * <tt><a href="output/Ext.data.Field.html#Ext.data.Field-defaultValue" ext:member="defaultValue" ext:cls="Ext.data.Field">defaultValue</a></tt>
	 * .</div></li>
	 * 
	 * <li><b>rec</b> : Mixed
	 * 
	 * <div class="sub-desc">The data object containing the row as read by the
	 * Reader. Depending on the Reader type, this could be an Array (<a
	 * href="output/Ext.data.ArrayReader.html"
	 * ext:cls="Ext.data.ArrayReader">ArrayReader</a>), an object (<a
	 * href="output/Ext.data.JsonReader.html"
	 * ext:cls="Ext.data.JsonReader">JsonReader</a>), or an XML element (<a
	 * href="output/Ext.data.XMLReader.html"
	 * ext:cls="Ext.data.XMLReader">XMLReader</a>).</div></li>
	 * </ul>
	 * </div>
	 * 
	 * <pre>
	 * &lt;code&gt;&lt;i&gt;// example of convert &lt;b&gt;function&lt;/b&gt;&lt;/i&gt;
	 * &lt;b&gt;function&lt;/b&gt; fullName(v, record){
	 *     &lt;b&gt;return&lt;/b&gt; record.name.last + &lt;em&gt;', '&lt;/em&gt; + record.name.first;
	 * }
	 * 
	 * &lt;b&gt;function&lt;/b&gt; location(v, record){
	 *     &lt;b&gt;return&lt;/b&gt; !record.city ? &lt;em&gt;''&lt;/em&gt; : (record.city + &lt;em&gt;', '&lt;/em&gt; + record.state);
	 * }
	 * 
	 * &lt;b&gt;var&lt;/b&gt; Dude = Ext.data.Record.create([
	 *     {name: &lt;em&gt;'fullname'&lt;/em&gt;,  convert: fullName},
	 *     {name: &lt;em&gt;'firstname'&lt;/em&gt;, mapping: &lt;em&gt;'name.first'&lt;/em&gt;},
	 *     {name: &lt;em&gt;'lastname'&lt;/em&gt;,  mapping: &lt;em&gt;'name.last'&lt;/em&gt;},
	 *     {name: &lt;em&gt;'city'&lt;/em&gt;, defaultValue: &lt;em&gt;'homeless'&lt;/em&gt;},
	 *     &lt;em&gt;'state'&lt;/em&gt;,
	 *     {name: &lt;em&gt;'location'&lt;/em&gt;,  convert: location}
	 * ]);
	 * 
	 * &lt;i&gt;// create the data store&lt;/i&gt;
	 * &lt;b&gt;var&lt;/b&gt; store = &lt;b&gt;new&lt;/b&gt; Ext.data.Store({
	 *     reader: &lt;b&gt;new&lt;/b&gt; Ext.data.JsonReader(
	 *         {
	 *             idProperty: &lt;em&gt;'key'&lt;/em&gt;,
	 *             root: &lt;em&gt;'daRoot'&lt;/em&gt;,  
	 *             totalProperty: &lt;em&gt;'total'&lt;/em&gt;
	 *         },
	 *         Dude  &lt;i&gt;// recordType&lt;/i&gt;
	 *     )
	 * });
	 * 
	 * &lt;b&gt;var&lt;/b&gt; myData = [
	 *     { key: 1,
	 *       name: { first: &lt;em&gt;'Fat'&lt;/em&gt;,    last:  &lt;em&gt;'Albert'&lt;/em&gt; }
	 *       &lt;i&gt;// notice no city, state provided &lt;b&gt;in&lt;/b&gt; data object&lt;/i&gt;
	 *     },
	 *     { key: 2,
	 *       name: { first: &lt;em&gt;'Barney'&lt;/em&gt;, last:  &lt;em&gt;'Rubble'&lt;/em&gt; },
	 *       city: &lt;em&gt;'Bedrock'&lt;/em&gt;, state: &lt;em&gt;'Stoneridge'&lt;/em&gt;
	 *     },
	 *     { key: 3,
	 *       name: { first: &lt;em&gt;'Cliff'&lt;/em&gt;,  last:  &lt;em&gt;'Claven'&lt;/em&gt; },
	 *       city: &lt;em&gt;'Boston'&lt;/em&gt;,  state: &lt;em&gt;'MA'&lt;/em&gt;
	 *     }
	 * ];&lt;/code&gt;
	 * </pre>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getConvert() {
		if (null != this.convert) {
			return this.convert;
		}
		ValueExpression _ve = getValueExpression("convert");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>convert</code> property.
	 * </p>
	 */
	public void setConvert(Object convert) {
		this.convert = convert;
		this.handleConfig("convert", convert);
	}

	private String dateFormat;

	/**
	 * A format string for the <a href="output/Date.html#Date-parseDate"
	 * ext:member="parseDate" ext:cls="Date">Date.parseDate</a> function, or
	 * "timestamp" if thevalue provided by the Reader is a UNIX timestamp, or
	 * "time" if the value provided by the Reader is a javascript millisecond
	 * timestamp.
	 */
	public String getDateFormat() {
		if (null != this.dateFormat) {
			return this.dateFormat;
		}
		ValueExpression _ve = getValueExpression("dateFormat");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>dateFormat</code> property.
	 * </p>
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
		this.handleConfig("dateFormat", dateFormat);
	}

	private Object defaultValue;

	/**
	 * The default value used <b>when a Record is beingcreated by a <a
	 * href="output/Ext.data.Reader.html"
	 * ext:cls="Ext.data.Reader">Reader</a></b> when the item referenced by the
	 * 
	 * <tt><a href="output/Ext.data.Field.html#Ext.data.Field-mapping" ext:member="mapping" ext:cls="Ext.data.Field">mapping</a></tt>
	 * does not exist in the data object (i.e. undefined). (defaults to "")
	 */
	@ClientConfig(JsonMode.Object)
	public Object getDefaultValue() {
		if (null != this.defaultValue) {
			return this.defaultValue;
		}
		ValueExpression _ve = getValueExpression("defaultValue");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultValue</code> property.
	 * </p>
	 */
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
		this.handleConfig("defaultValue", defaultValue);
	}

	private String mapping;

	/**
	 * <p>
	 * (Optional) A path expression for use by the <a
	 * href="output/Ext.data.DataReader.html"
	 * ext:cls="Ext.data.DataReader">Ext.data.DataReader</a> implementation that
	 * is creating the <a href="output/Ext.data.Record.html"
	 * ext:cls="Ext.data.Record">Record</a> to extract the Field value from the
	 * data object. If the path expression is the same as the field name, the
	 * mapping may be omitted.
	 * </p>
	 * 
	 * <p>
	 * The form of the mapping expression depends on the Reader being used.
	 * </p>
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><a href="output/Ext.data.JsonReader.html"
	 * ext:cls="Ext.data.JsonReader">Ext.data.JsonReader</a> <div
	 * class="sub-desc">The mapping is a string containing the javascript
	 * expression to reference the data from an element of the data item's <a
	 * href="output/Ext.data.JsonReader.html#Ext.data.JsonReader-root"
	 * ext:member="root" ext:cls="Ext.data.JsonReader">root</a> Array. Defaults
	 * to the field name.</div></li>
	 * 
	 * <li><a href="output/Ext.data.XmlReader.html"
	 * ext:cls="Ext.data.XmlReader">Ext.data.XmlReader</a> <div
	 * class="sub-desc">The mapping is an <a href="output/Ext.DomQuery.html"
	 * ext:cls="Ext.DomQuery">Ext.DomQuery</a> path to the data item relative to
	 * the DOM element that represents the <a
	 * href="output/Ext.data.XmlReader.html#Ext.data.XmlReader-record"
	 * ext:member="record" ext:cls="Ext.data.XmlReader">record</a>. Defaults to
	 * the field name.</div></li>
	 * 
	 * <li><a href="output/Ext.data.ArrayReader.html"
	 * ext:cls="Ext.data.ArrayReader">Ext.data.ArrayReader</a> <div
	 * class="sub-desc">The mapping is a number indicating the Array index of
	 * the field's value. Defaults to the field specification's Array
	 * position.</div></li>
	 * </ul>
	 * </div>
	 * 
	 * <p>
	 * If a more complex value extraction strategy is required, then configure
	 * the Field with a <a
	 * href="output/Ext.data.Field.html#Ext.data.Field-convert"
	 * ext:member="convert" ext:cls="Ext.data.Field">convert</a> function. This
	 * is passed the whole row object, and may interrogate it in whatever way is
	 * necessary in order to return the desired data.
	 * </p>
	 */
	public String getMapping() {
		if (null != this.mapping) {
			return this.mapping;
		}
		ValueExpression _ve = getValueExpression("mapping");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>mapping</code> property.
	 * </p>
	 */
	public void setMapping(String mapping) {
		this.mapping = mapping;
		this.handleConfig("mapping", mapping);
	}

	private String name;

	/**
	 * The name by which the field is referenced withinthe Record. This is
	 * referenced by, for example, the <tt>dataIndex</tt> property in column
	 * definition objects passed to <a href="output/Ext.grid.ColumnModel.html"
	 * ext:cls="Ext.grid.ColumnModel">Ext.grid.ColumnModel</a>.
	 * 
	 * <p>
	 * Note: In the simplest case, if no properties other than <tt>name</tt> are
	 * required, a field definition may consist of just a String for the field
	 * name.
	 * </p>
	 */
	public String getName() {
		if (null != this.name) {
			return this.name;
		}
		ValueExpression _ve = getValueExpression("name");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>name</code> property.
	 * </p>
	 */
	public void setName(String name) {
		this.name = name;
		this.handleConfig("name", name);
	}

	private String sortDir;

	/**
	 * Initial direction to sort (<tt>"ASC"</tt> or<tt>"DESC"</tt>). Defaults to
	 * <tt>"ASC"</tt>.
	 */
	public String getSortDir() {
		if (null != this.sortDir) {
			return this.sortDir;
		}
		ValueExpression _ve = getValueExpression("sortDir");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sortDir</code> property.
	 * </p>
	 */
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
		this.handleConfig("sortDir", sortDir);
	}

	private Object sortType;

	/**
	 * A function which converts a Field's value to acomparable value in order
	 * to ensure correct sort ordering. Predefined functions are provided in <a
	 * href="output/Ext.data.SortTypes.html"
	 * ext:cls="Ext.data.SortTypes">Ext.data.SortTypes</a>. A custom sort
	 * example:
	 * 
	 * <pre>
	 * &lt;code&gt;&lt;i&gt;// current sort     after sort we want&lt;/i&gt;
	 * &lt;i&gt;// +-+------+          +-+------+&lt;/i&gt;
	 * &lt;i&gt;// |1|First |          |1|First |&lt;/i&gt;
	 * &lt;i&gt;// |2|Last  |          |3|Second|&lt;/i&gt;
	 * &lt;i&gt;// |3|Second|          |2|Last  |&lt;/i&gt;
	 * &lt;i&gt;// +-+------+          +-+------+&lt;/i&gt;
	 * 
	 * sortType: &lt;b&gt;function&lt;/b&gt;(value) {
	 *    &lt;b&gt;switch&lt;/b&gt; (value.toLowerCase()) &lt;i&gt;// native toLowerCase():&lt;/i&gt;
	 *    {
	 *       &lt;b&gt;case&lt;/b&gt; &lt;em&gt;'first'&lt;/em&gt;: &lt;b&gt;return&lt;/b&gt; 1;
	 *       &lt;b&gt;case&lt;/b&gt; &lt;em&gt;'second'&lt;/em&gt;: &lt;b&gt;return&lt;/b&gt; 2;
	 *       &lt;b&gt;default&lt;/b&gt;: &lt;b&gt;return&lt;/b&gt; 3;
	 *    }
	 * }&lt;/code&gt;
	 * </pre>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getSortType() {
		if (null != this.sortType) {
			return this.sortType;
		}
		ValueExpression _ve = getValueExpression("sortType");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sortType</code> property.
	 * </p>
	 */
	public void setSortType(Object sortType) {
		this.sortType = sortType;
		this.handleConfig("sortType", sortType);
	}

	private String type;

	/**
	 * The data type for conversion to displayable valueif
	 * <tt><a href="output/Ext.data.Field.html#Ext.data.Field-convert" ext:member="convert" ext:cls="Ext.data.Field">convert</a></tt>
	 * has not been specified. Possible values are
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li>auto (Default, implies no conversion)</li>
	 * 
	 * <li>string</li>
	 * 
	 * <li>int</li>
	 * 
	 * <li>float</li>
	 * 
	 * <li>boolean</li>
	 * 
	 * <li>date</li>
	 * </ul>
	 * </div>
	 */
	public String getType() {
		if (null != this.type) {
			return this.type;
		}
		ValueExpression _ve = getValueExpression("type");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType(String type) {
		this.type = type;
		this.handleConfig("type", type);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[10];
		}
		_values[0] = super.saveState(_context);
		_values[1] = allowBlank;
		_values[2] = convert;
		_values[3] = dateFormat;
		_values[4] = defaultValue;
		_values[5] = mapping;
		_values[6] = name;
		_values[7] = sortDir;
		_values[8] = sortType;
		_values[9] = type;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.allowBlank = (Boolean) _values[1];
		this.handleConfig("allowBlank", this.allowBlank);
		this.convert = (Object) _values[2];
		this.handleConfig("convert", this.convert);
		this.dateFormat = (String) _values[3];
		this.handleConfig("dateFormat", this.dateFormat);
		this.defaultValue = (Object) _values[4];
		this.handleConfig("defaultValue", this.defaultValue);
		this.mapping = (String) _values[5];
		this.handleConfig("mapping", this.mapping);
		this.name = (String) _values[6];
		this.handleConfig("name", this.name);
		this.sortDir = (String) _values[7];
		this.handleConfig("sortDir", this.sortDir);
		this.sortType = (Object) _values[8];
		this.handleConfig("sortType", this.sortType);
		this.type = (String) _values[9];
		this.handleConfig("type", this.type);

	}
}