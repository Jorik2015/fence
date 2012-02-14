package ext.form;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.BoxComponent;
import ext.annotation.InstanceOf;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. Basic Label
 * field.
 */
@XType("label")
@InstanceOf("Ext.form.Label")
public class Label extends BoxComponent {
	public static final String COMPONENT_TYPE = "Ext.form.Label";
	public static final String COMPONENT_FAMILY = "Ext.form.Label";

	/**
	 * <p>
	 * Create a new {@link Label} instance with default property values.
	 * </p>
	 */
	public Label() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String forId;

	/**
	 * The id of the input element to which this labelwill be bound via the
	 * standard HTML 'for' attribute. If not specified, the attribute will not
	 * be added to the label.
	 */
	public String getForId() {
		if (null != this.forId) {
			return this.forId;
		}
		ValueExpression _ve = getValueExpression("forId");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>forId</code> property.
	 * </p>
	 */
	public void setForId(String forId) {
		this.forId = forId;
		this.handleConfig("forId", forId);
	}

	private String html;

	/**
	 * An HTML fragment that will be used as the label'sinnerHTML (defaults to
	 * ''). Note that if <a
	 * href="output/Ext.form.Label.html#Ext.form.Label-text" ext:member="text"
	 * ext:cls="Ext.form.Label">text</a> is specified it will take precedence
	 * and this value will be ignored.
	 */
	public String getHtml() {
		if (null != this.html) {
			return this.html;
		}
		ValueExpression _ve = getValueExpression("html");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>html</code> property.
	 * </p>
	 */
	public void setHtml(String html) {
		this.html = html;
		this.handleConfig("html", html);
	}

	private String text;

	/**
	 * The plain text to display within the label(defaults to ''). If you need
	 * to include HTML tags within the label's innerHTML, use the <a
	 * href="output/Ext.form.Label.html#Ext.form.Label-html" ext:member="html"
	 * ext:cls="Ext.form.Label">html</a> config instead.
	 */
	public String getText() {
		if (null != this.text) {
			return this.text;
		}
		ValueExpression _ve = getValueExpression("text");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText(String text) {
		this.text = text;
		this.handleConfig("text", text);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = forId;
		_values[2] = html;
		_values[3] = text;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.forId = (String) _values[1];
		this.handleConfig("forId", this.forId);
		this.html = (String) _values[2];
		this.handleConfig("html", this.html);
		this.text = (String) _values[3];
		this.handleConfig("text", this.text);

	}
}