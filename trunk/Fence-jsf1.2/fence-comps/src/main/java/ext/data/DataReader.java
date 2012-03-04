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
 *Note:This java code is auto generated by abner,do not edit it. Abstract base
 * class for reading structured data from a data source and converting it into
 * an object containing <a href="output/Ext.data.Record.html"
 * ext:cls="Ext.data.Record">Ext.data.Record</a> objects and metadata for use by
 * an <a href="output/Ext.data.Store.html"
 * ext:cls="Ext.data.Store">Ext.data.Store</a>. This class is intended to be
 * extended and should not be created directly. For existing implementations,
 * see <a href="output/Ext.data.ArrayReader.html"
 * ext:cls="Ext.data.ArrayReader">Ext.data.ArrayReader</a>, <a
 * href="output/Ext.data.JsonReader.html"
 * ext:cls="Ext.data.JsonReader">Ext.data.JsonReader</a> and <a
 * href="output/Ext.data.XmlReader.html"
 * ext:cls="Ext.data.XmlReader">Ext.data.XmlReader</a>.
 */
@InstanceOf("Ext.data.DataReader")
@ParseConfigMode(ui = false, name = "reader", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class DataReader extends ExtOutput {
	public static final String COMPONENT_TYPE = "Ext.data.DataReader";
	public static final String COMPONENT_FAMILY = "Ext.data.DataReader";

	/**
	 * <p>
	 * Create a new {@link DataReader} instance with default property values.
	 * </p>
	 */
	public DataReader() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Object fields;

	/**
	 * <p>
	 * Either an Array of <a href="output/Ext.data.Field.html"
	 * ext:cls="Ext.data.Field">Field</a> definition objects (which will be
	 * passed to <a href="output/Ext.data.Record.html#Ext.data.Record-create"
	 * ext:member="create" ext:cls="Ext.data.Record">Ext.data.Record.create</a>,
	 * or a <a href="output/Ext.data.Record.html"
	 * ext:cls="Ext.data.Record">Record</a> constructor created from <a
	 * href="output/Ext.data.Record.html#Ext.data.Record-create"
	 * ext:member="create" ext:cls="Ext.data.Record">Ext.data.Record.create</a>.
	 * </p>
	 */
	@ClientConfig(JsonMode.Array)
	public Object getFields() {
		if (null != this.fields) {
			return this.fields;
		}
		ValueExpression _ve = getValueExpression("fields");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>fields</code> property.
	 * </p>
	 */
	public void setFields(Object fields) {
		this.fields = fields;
		this.handleConfig("fields", fields);
	}

	private String messageProperty;

	/**
	 * [undefined] Optional name of a property within aserver-response that
	 * represents a user-feedback message.
	 */
	public String getMessageProperty() {
		if (null != this.messageProperty) {
			return this.messageProperty;
		}
		ValueExpression _ve = getValueExpression("messageProperty");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>messageProperty</code> property.
	 * </p>
	 */
	public void setMessageProperty(String messageProperty) {
		this.messageProperty = messageProperty;
		this.handleConfig("messageProperty", messageProperty);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
		_values[1] = fields;
		_values[2] = messageProperty;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.fields = (Object) _values[1];
		this.handleConfig("fields", this.fields);
		this.messageProperty = (String) _values[2];
		this.handleConfig("messageProperty", this.messageProperty);

	}
}