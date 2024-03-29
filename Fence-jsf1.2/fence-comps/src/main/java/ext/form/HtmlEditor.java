package ext.form;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. Provides a
 * lightweight HTML Editor component. Some toolbar features are not supported by
 * Safari and will be automatically hidden when needed. These are noted in the
 * config options where appropriate.<br>
 * <br>
 * The editor's toolbar buttons have tooltips defined in the <a
 * href="output/Ext.form.HtmlEditor.html#Ext.form.HtmlEditor-buttonTips"
 * ext:member="buttonTips" ext:cls="Ext.form.HtmlEditor">buttonTips</a>
 * property, but they are not enabled by default unless the global <a
 * href="output/Ext.QuickTips.html" ext:cls="Ext.QuickTips">Ext.QuickTips</a>
 * singleton is <a href="output/Ext.QuickTips.html#Ext.QuickTips-init"
 * ext:member="init" ext:cls="Ext.QuickTips">initialized</a>.<br>
 * <br>
 * <b>Note: The focus/blur and validation marking functionality inherited from
 * Ext.form.Field is NOT supported by this editor.</b><br>
 * <br>
 * An Editor is a sensitive component that can't be used in all spots standard
 * fields can be used. Putting an Editor within any element that has display set
 * to 'none' can cause problems in Safari and Firefox due to their default
 * iframe reloading bugs.<br>
 * <br>
 * Example usage:
 * 
 * <pre>
 * &lt;code&gt;&lt;i&gt;// Simple example rendered &lt;b&gt;with&lt;/b&gt; &lt;b&gt;default&lt;/b&gt; options:
 * &lt;/i&gt;
 * Ext.QuickTips.init();  &lt;i&gt;// enable tooltips
 * &lt;/i&gt;
 * &lt;b&gt;new&lt;/b&gt; Ext.form.HtmlEditor({
 *     renderTo: Ext.getBody(),
 *     width: 800,
 *     height: 300
 * });
 * 
 * &lt;i&gt;// Passed via xtype into a container and &lt;b&gt;with&lt;/b&gt; custom options:
 * &lt;/i&gt;
 * Ext.QuickTips.init();  &lt;i&gt;// enable tooltips
 * &lt;/i&gt;
 * &lt;b&gt;new&lt;/b&gt; Ext.Panel({
 *     title: &lt;em&gt;'HTML Editor'&lt;/em&gt;,
 *     renderTo: Ext.getBody(),
 *     width: 600,
 *     height: 300,
 *     frame: true,
 *     layout: &lt;em&gt;'fit'&lt;/em&gt;,
 *     items: {
 *         xtype: &lt;em&gt;'htmleditor'&lt;/em&gt;,
 *         enableColors: false,
 *         enableAlignments: false
 *     }
 * });&lt;/code&gt;
 * </pre>
 */
@XType("htmleditor")
@InstanceOf("Ext.form.HtmlEditor")
public class HtmlEditor extends Field {
	public static final String COMPONENT_TYPE = "Ext.form.HtmlEditor";
	public static final String COMPONENT_FAMILY = "Ext.form.HtmlEditor";

	/**
	 * <p>
	 * Create a new {@link HtmlEditor} instance with default property values.
	 * </p>
	 */
	public HtmlEditor() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String createLinkText;

	/**
	 * The default text for the create linkprompt
	 */
	public String getCreateLinkText() {
		if (null != this.createLinkText) {
			return this.createLinkText;
		}
		ValueExpression _ve = getValueExpression("createLinkText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>createLinkText</code> property.
	 * </p>
	 */
	public void setCreateLinkText(String createLinkText) {
		this.createLinkText = createLinkText;
		this.handleConfig("createLinkText", createLinkText);
	}

	private String defaultLinkValue;

	/**
	 * The default value for the create link prompt(defaults to http:/ /)
	 */
	public String getDefaultLinkValue() {
		if (null != this.defaultLinkValue) {
			return this.defaultLinkValue;
		}
		ValueExpression _ve = getValueExpression("defaultLinkValue");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultLinkValue</code> property.
	 * </p>
	 */
	public void setDefaultLinkValue(String defaultLinkValue) {
		this.defaultLinkValue = defaultLinkValue;
		this.handleConfig("defaultLinkValue", defaultLinkValue);
	}

	private String defaultValue;

	/**
	 * A default value to be put into the editor toresolve focus issues
	 * (defaults to ​ (Zero-width space), &nbsp; (Non-breaking space) in Opera
	 * and IE6).
	 */
	public String getDefaultValue() {
		if (null != this.defaultValue) {
			return this.defaultValue;
		}
		ValueExpression _ve = getValueExpression("defaultValue");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultValue</code> property.
	 * </p>
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		this.handleConfig("defaultValue", defaultValue);
	}

	private Boolean enableAlignments;

	/**
	 * Enable the left, center, right alignment buttons(defaults to true)
	 */
	public Boolean getEnableAlignments() {
		if (null != this.enableAlignments) {
			return this.enableAlignments;
		}
		ValueExpression _ve = getValueExpression("enableAlignments");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableAlignments</code> property.
	 * </p>
	 */
	public void setEnableAlignments(Boolean enableAlignments) {
		this.enableAlignments = enableAlignments;
		this.handleConfig("enableAlignments", enableAlignments);
	}

	private Boolean enableColors;

	/**
	 * Enable the fore/highlight color buttons(defaults to true)
	 */
	public Boolean getEnableColors() {
		if (null != this.enableColors) {
			return this.enableColors;
		}
		ValueExpression _ve = getValueExpression("enableColors");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColors</code> property.
	 * </p>
	 */
	public void setEnableColors(Boolean enableColors) {
		this.enableColors = enableColors;
		this.handleConfig("enableColors", enableColors);
	}

	private Boolean enableFont;

	/**
	 * Enable font selection. Not available in Safari.(defaults to true)
	 */
	public Boolean getEnableFont() {
		if (null != this.enableFont) {
			return this.enableFont;
		}
		ValueExpression _ve = getValueExpression("enableFont");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableFont</code> property.
	 * </p>
	 */
	public void setEnableFont(Boolean enableFont) {
		this.enableFont = enableFont;
		this.handleConfig("enableFont", enableFont);
	}

	private Boolean enableFontSize;

	/**
	 * Enable the increase/decrease font size buttons(defaults to true)
	 */
	public Boolean getEnableFontSize() {
		if (null != this.enableFontSize) {
			return this.enableFontSize;
		}
		ValueExpression _ve = getValueExpression("enableFontSize");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableFontSize</code> property.
	 * </p>
	 */
	public void setEnableFontSize(Boolean enableFontSize) {
		this.enableFontSize = enableFontSize;
		this.handleConfig("enableFontSize", enableFontSize);
	}

	private Boolean enableFormat;

	/**
	 * Enable the bold, italic and underline buttons(defaults to true)
	 */
	public Boolean getEnableFormat() {
		if (null != this.enableFormat) {
			return this.enableFormat;
		}
		ValueExpression _ve = getValueExpression("enableFormat");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableFormat</code> property.
	 * </p>
	 */
	public void setEnableFormat(Boolean enableFormat) {
		this.enableFormat = enableFormat;
		this.handleConfig("enableFormat", enableFormat);
	}

	private Boolean enableLinks;

	/**
	 * Enable the create link button. Not available inSafari. (defaults to true)
	 */
	public Boolean getEnableLinks() {
		if (null != this.enableLinks) {
			return this.enableLinks;
		}
		ValueExpression _ve = getValueExpression("enableLinks");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableLinks</code> property.
	 * </p>
	 */
	public void setEnableLinks(Boolean enableLinks) {
		this.enableLinks = enableLinks;
		this.handleConfig("enableLinks", enableLinks);
	}

	private Boolean enableLists;

	/**
	 * Enable the bullet and numbered list buttons. Notavailable in Safari.
	 * (defaults to true)
	 */
	public Boolean getEnableLists() {
		if (null != this.enableLists) {
			return this.enableLists;
		}
		ValueExpression _ve = getValueExpression("enableLists");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableLists</code> property.
	 * </p>
	 */
	public void setEnableLists(Boolean enableLists) {
		this.enableLists = enableLists;
		this.handleConfig("enableLists", enableLists);
	}

	private Boolean enableSourceEdit;

	/**
	 * Enable the switch to source edit button. Notavailable in Safari.
	 * (defaults to true)
	 */
	public Boolean getEnableSourceEdit() {
		if (null != this.enableSourceEdit) {
			return this.enableSourceEdit;
		}
		ValueExpression _ve = getValueExpression("enableSourceEdit");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableSourceEdit</code> property.
	 * </p>
	 */
	public void setEnableSourceEdit(Boolean enableSourceEdit) {
		this.enableSourceEdit = enableSourceEdit;
		this.handleConfig("enableSourceEdit", enableSourceEdit);
	}

	private Object fontFamilies;

	/**
	 * An array of available font families
	 */
	@ClientConfig(JsonMode.Array)
	public Object getFontFamilies() {
		if (null != this.fontFamilies) {
			return this.fontFamilies;
		}
		ValueExpression _ve = getValueExpression("fontFamilies");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>fontFamilies</code> property.
	 * </p>
	 */
	public void setFontFamilies(Object fontFamilies) {
		this.fontFamilies = fontFamilies;
		this.handleConfig("fontFamilies", fontFamilies);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[13];
		}
		_values[0] = super.saveState(_context);
		_values[1] = createLinkText;
		_values[2] = defaultLinkValue;
		_values[3] = defaultValue;
		_values[4] = enableAlignments;
		_values[5] = enableColors;
		_values[6] = enableFont;
		_values[7] = enableFontSize;
		_values[8] = enableFormat;
		_values[9] = enableLinks;
		_values[10] = enableLists;
		_values[11] = enableSourceEdit;
		_values[12] = fontFamilies;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.createLinkText = (String) _values[1];
		this.handleConfig("createLinkText", this.createLinkText);
		this.defaultLinkValue = (String) _values[2];
		this.handleConfig("defaultLinkValue", this.defaultLinkValue);
		this.defaultValue = (String) _values[3];
		this.handleConfig("defaultValue", this.defaultValue);
		this.enableAlignments = (Boolean) _values[4];
		this.handleConfig("enableAlignments", this.enableAlignments);
		this.enableColors = (Boolean) _values[5];
		this.handleConfig("enableColors", this.enableColors);
		this.enableFont = (Boolean) _values[6];
		this.handleConfig("enableFont", this.enableFont);
		this.enableFontSize = (Boolean) _values[7];
		this.handleConfig("enableFontSize", this.enableFontSize);
		this.enableFormat = (Boolean) _values[8];
		this.handleConfig("enableFormat", this.enableFormat);
		this.enableLinks = (Boolean) _values[9];
		this.handleConfig("enableLinks", this.enableLinks);
		this.enableLists = (Boolean) _values[10];
		this.handleConfig("enableLists", this.enableLists);
		this.enableSourceEdit = (Boolean) _values[11];
		this.handleConfig("enableSourceEdit", this.enableSourceEdit);
		this.fontFamilies = (Object) _values[12];
		this.handleConfig("fontFamilies", this.fontFamilies);

	}
}