package ext.form.action;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.form.Action;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * A class which handles submission of data from <a
 * href="output/Ext.form.BasicForm.html" ext:cls="Ext.form.BasicForm">Form</a>s
 * and processes the returned response.
 * </p>
 * 
 * <p>
 * Instances of this class are only created by a <a
 * href="output/Ext.form.BasicForm.html" ext:cls="Ext.form.BasicForm">Form</a>
 * when <a href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-submit"
 * ext:member="submit" ext:cls="Ext.form.BasicForm">submit</a>ting.
 * </p>
 * 
 * <p>
 * <u><b>Response Packet Criteria</b></u>
 * </p>
 * 
 * <p>
 * A response packet may contain:
 * </p>
 * 
 * <div class="mdetail-params">
 * <ul>
 * <li><b><code>success</code></b> property : Boolean
 * 
 * <div class="sub-desc">The <code>success</code> property is required.</div></li>
 * 
 * <li><b><code>errors</code></b> property : Object
 * 
 * <div class="sub-desc"> <div class="sub-desc">The <code>errors</code>
 * property, which is optional, contains error messages for invalid
 * fields.</div> </div></li>
 * </ul>
 * </div>
 * 
 * <p>
 * <u><b>JSON Packets</b></u>
 * </p>
 * 
 * <p>
 * By default, response packets are assumed to be JSON, so a typical response
 * packet may look like this:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;{
 *     success: false,
 *     errors: {
 *         clientCode: &lt;em&gt;&quot;Client not found&quot;&lt;/em&gt;,
 *         portOfLoading: &lt;em&gt;&quot;This field must not be null&quot;&lt;/em&gt;
 *     }
 * }&lt;/code&gt;
 * </pre>
 * 
 * <p>
 * Other data may be placed into the response for processing by the <a
 * href="output/Ext.form.BasicForm.html"
 * ext:cls="Ext.form.BasicForm">Ext.form.BasicForm</a>'s callback or event
 * handler methods. The object decoded from this JSON is available in the <a
 * href="output/Ext.form.Action.html#Ext.form.Action-result" ext:member="result"
 * ext:cls="Ext.form.Action">result</a> property.
 * </p>
 * 
 * <p>
 * Alternatively, if an <a href=
 * "output/Ext.form.Action.Submit.html#Ext.form.Action.Submit-errorReader"
 * ext:member="errorReader" ext:cls="Ext.form.Action.Submit">errorReader</a> is
 * specified as an <a href="output/Ext.data.XmlReader.html"
 * ext:cls="Ext.data.XmlReader">XmlReader</a>:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;errorReader: &lt;b&gt;new&lt;/b&gt; Ext.data.XmlReader({
 *             record : &lt;em&gt;'field'&lt;/em&gt;,
 *             success: &lt;em&gt;'@success'&lt;/em&gt;
 *         }, [
 *             &lt;em&gt;'id'&lt;/em&gt;, &lt;em&gt;'msg'&lt;/em&gt;
 *         ]
 *     )&lt;/code&gt;
 * </pre>
 * 
 * <p>
 * then the results may be sent back in XML format:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;&lt;?xml version=&lt;em&gt;&quot;1.0&quot;&lt;/em&gt; encoding=&lt;em&gt;&quot;UTF-8&quot;&lt;/em&gt;?&gt;
 * &lt;message success=&lt;em&gt;&quot;false&quot;&lt;/em&gt;&gt;
 * &lt;errors&gt;
 *     &lt;field&gt;
 *         &lt;id&gt;clientCode&lt;/id&gt;
 *         &lt;msg&gt;&lt;![CDATA[Code not found. &lt;br /&gt;&lt;i&gt;This is a test validation message from the server &lt;/i&gt;]]&gt;&lt;/msg&gt;
 *     &lt;/field&gt;
 *     &lt;field&gt;
 *         &lt;id&gt;portOfLoading&lt;/id&gt;
 *         &lt;msg&gt;&lt;![CDATA[Port not found. &lt;br /&gt;&lt;i&gt;This is a test validation message from the server &lt;/i&gt;]]&gt;&lt;/msg&gt;
 *     &lt;/field&gt;
 * &lt;/errors&gt;
 * &lt;/message&gt;&lt;/code&gt;
 * </pre>
 * 
 * <p>
 * Other elements may be placed into the response XML for processing by the <a
 * href="output/Ext.form.BasicForm.html"
 * ext:cls="Ext.form.BasicForm">Ext.form.BasicForm</a>'s callback or event
 * handler methods. The XML document is available in the <a href=
 * "output/Ext.form.Action.Submit.html#Ext.form.Action.Submit-errorReader"
 * ext:member="errorReader" ext:cls="Ext.form.Action.Submit">errorReader</a>'s
 * <a href="output/Ext.data.XmlReader.html#Ext.data.XmlReader-xmlData"
 * ext:member="xmlData" ext:cls="Ext.data.XmlReader">xmlData</a> property.
 * </p>
 */
@InstanceOf("Ext.form.Action.Submit")
@ParseConfigMode(id = false, name = "params", ui = false, pmode = PersistenceMode.Custom, rmode = ReferenceMode.Config)
public class Submit extends Action {
	public static final String COMPONENT_TYPE = "Ext.form.Action.Submit";
	public static final String COMPONENT_FAMILY = "Ext.form.Action.Submit";

	/**
	 * <p>
	 * Create a new {@link Submit} instance with default property values.
	 * </p>
	 */
	public Submit() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean clientValidation;

	/**
	 * Determines whether a Form's fields are validatedin a final call to <a
	 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-isValid"
	 * ext:member="isValid" ext:cls="Ext.form.BasicForm">isValid</a> prior to
	 * submission. Pass <tt>false</tt> in the Form's submit options to prevent
	 * this. If not defined, pre-submission field validation is performed.
	 */
	public Boolean getClientValidation() {
		if (null != this.clientValidation) {
			return this.clientValidation;
		}
		ValueExpression _ve = getValueExpression("clientValidation");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>clientValidation</code> property.
	 * </p>
	 */
	public void setClientValidation(Boolean clientValidation) {
		this.clientValidation = clientValidation;
		this.handleConfig("clientValidation", clientValidation);
	}

	private Object errorReader;

	/**
	 * <p>
	 * <b>Optional. JSON is interpreted with no need for an errorReader.</b>
	 * </p>
	 * 
	 * <p>
	 * A Reader which reads a single record from the returned data. The
	 * DataReader's <b>success</b> property specifies how submission success is
	 * determined. The Record's data provides the error messages to apply to any
	 * invalid form Fields.
	 * </p>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getErrorReader() {
		if (null != this.errorReader) {
			return this.errorReader;
		}
		ValueExpression _ve = getValueExpression("errorReader");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>errorReader</code> property.
	 * </p>
	 */
	public void setErrorReader(Object errorReader) {
		this.errorReader = errorReader;
		this.handleConfig("errorReader", errorReader);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
		_values[1] = clientValidation;
		_values[2] = errorReader;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.clientValidation = (Boolean) _values[1];
		this.handleConfig("clientValidation", this.clientValidation);
		this.errorReader = (Object) _values[2];
		this.handleConfig("errorReader", this.errorReader);

	}
}