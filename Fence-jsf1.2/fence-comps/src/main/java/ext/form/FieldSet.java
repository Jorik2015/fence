package ext.form;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.Panel;
import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. Standard
 * container used for grouping items within a <a
 * href="output/Ext.form.FormPanel.html" ext:cls="Ext.form.FormPanel">form</a>.
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; form = &lt;b&gt;new&lt;/b&gt; Ext.FormPanel({
 *     title: &lt;em&gt;'Simple Form &lt;b&gt;with&lt;/b&gt; FieldSets'&lt;/em&gt;,
 *     labelWidth: 75, &lt;i&gt;// &lt;b&gt;label&lt;/b&gt; settings here cascade unless overridden
 * &lt;/i&gt;
 *     url: &lt;em&gt;'save-form.php'&lt;/em&gt;,
 *     frame:true,
 *     bodyStyle:&lt;em&gt;'padding:5px 5px 0'&lt;/em&gt;,
 *     width: 700,
 *     renderTo: document.body,
 *     layout:&lt;em&gt;'column'&lt;/em&gt;, &lt;i&gt;// arrange items &lt;b&gt;in&lt;/b&gt; columns
 * &lt;/i&gt;
 *     defaults: {      &lt;i&gt;// defaults applied to items
 * &lt;/i&gt;
 *         layout: &lt;em&gt;'form'&lt;/em&gt;,
 *         border: false,
 *         bodyStyle: &lt;em&gt;'padding:4px'&lt;/em&gt;
 *     },
 *     items: [{
 *         &lt;i&gt;// Fieldset &lt;b&gt;in&lt;/b&gt; Column 1
 * &lt;/i&gt;
 *         xtype:&lt;em&gt;'fieldset'&lt;/em&gt;,
 *         columnWidth: 0.5,
 *         title: &lt;em&gt;'Fieldset 1'&lt;/em&gt;,
 *         collapsible: true,
 *         autoHeight:true,
 *         defaults: {
 *             anchor: &lt;em&gt;'-20'&lt;/em&gt; &lt;i&gt;// leave room &lt;b&gt;for&lt;/b&gt; error icon
 * &lt;/i&gt;
 *         },
 *         defaultType: &lt;em&gt;'textfield'&lt;/em&gt;,
 *         items :[{
 *                 fieldLabel: &lt;em&gt;'Field 1'&lt;/em&gt;
 *             }, {
 *                 fieldLabel: &lt;em&gt;'Field 2'&lt;/em&gt;
 *             }, {
 *                 fieldLabel: &lt;em&gt;'Field 3'&lt;/em&gt;
 *             }
 *         ]
 *     },{
 *         &lt;i&gt;// Fieldset &lt;b&gt;in&lt;/b&gt; Column 2 - Panel inside
 * &lt;/i&gt;
 *         xtype:&lt;em&gt;'fieldset'&lt;/em&gt;,
 *         title: &lt;em&gt;'Show Panel'&lt;/em&gt;, &lt;i&gt;// title, header, or checkboxToggle creates fieldset header
 * &lt;/i&gt;
 *         autoHeight:true,
 *         columnWidth: 0.5,
 *         checkboxToggle: true,
 *         collapsed: true, &lt;i&gt;// fieldset initially collapsed
 * &lt;/i&gt;
 *         layout:&lt;em&gt;'anchor'&lt;/em&gt;,
 *         items :[{
 *             xtype: &lt;em&gt;'panel'&lt;/em&gt;,
 *             anchor: &lt;em&gt;'100%'&lt;/em&gt;,
 *             title: &lt;em&gt;'Panel inside a fieldset'&lt;/em&gt;,
 *             frame: true,
 *             height: 100
 *         }]
 *     }]
 * });&lt;/code&gt;
 * </pre>
 */
@XType("fieldset")
@InstanceOf("Ext.form.FieldSet")
public class FieldSet extends Panel {
	public static final String COMPONENT_TYPE = "Ext.form.FieldSet";
	public static final String COMPONENT_FAMILY = "Ext.form.FieldSet";

	/**
	 * <p>
	 * Create a new {@link FieldSet} instance with default property values.
	 * </p>
	 */
	public FieldSet() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean animCollapse;

	/**
	 * <tt>true</tt> to animate the transition when thepanel is collapsed,
	 * <tt>false</tt> to skip the animation (defaults to <tt>false</tt>).
	 */
	public Boolean getAnimCollapse() {
		if (null != this.animCollapse) {
			return this.animCollapse;
		}
		ValueExpression _ve = getValueExpression("animCollapse");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>animCollapse</code> property.
	 * </p>
	 */
	public void setAnimCollapse(Boolean animCollapse) {
		this.animCollapse = animCollapse;
		this.handleConfig("animCollapse", animCollapse);
	}

	private String baseCls;

	/**
	 * The base CSS class applied to the fieldset(defaults to <tt>'x-fieldset'</tt>).
	 */
	public String getBaseCls() {
		if (null != this.baseCls) {
			return this.baseCls;
		}
		ValueExpression _ve = getValueExpression("baseCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>baseCls</code> property.
	 * </p>
	 */
	public void setBaseCls(String baseCls) {
		this.baseCls = baseCls;
		this.handleConfig("baseCls", baseCls);
	}

	private String checkboxName;

	/**
	 * The name to assign to the fieldset's checkbox if
	 * 
	 * <tt><a href="output/Ext.form.FieldSet.html#Ext.form.FieldSet-checkboxToggle" ext:member="checkboxToggle" ext:cls="Ext.form.FieldSet">checkboxToggle</a> = true</tt>
	 * (defaults to <tt>'[checkbox id]-checkbox'</tt>).
	 */
	public String getCheckboxName() {
		if (null != this.checkboxName) {
			return this.checkboxName;
		}
		ValueExpression _ve = getValueExpression("checkboxName");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>checkboxName</code> property.
	 * </p>
	 */
	public void setCheckboxName(String checkboxName) {
		this.checkboxName = checkboxName;
		this.handleConfig("checkboxName", checkboxName);
	}

	private Object checkboxToggle;

	/**
	 * <tt>true</tt> to render a checkbox into thefieldset frame just in front
	 * of the legend to expand/collapse the fieldset when the checkbox is
	 * toggled. (defaults to <tt>false</tt>).
	 * 
	 * <p>
	 * A <a href="output/Ext.DomHelper.html"
	 * ext:cls="Ext.DomHelper">DomHelper</a> element spec may also be specified
	 * to create the checkbox. If <tt>true</tt> is specified, the default
	 * DomHelper config object used to create the element is:
	 * </p>
	 * 
	 * <pre>
	 * &lt;code&gt;{tag: &lt;em&gt;'input'&lt;/em&gt;, type: &lt;em&gt;'checkbox'&lt;/em&gt;, name: this.checkboxName || this.id+&lt;em&gt;'-checkbox'&lt;/em&gt;}&lt;/code&gt;
	 * </pre>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getCheckboxToggle() {
		if (null != this.checkboxToggle) {
			return this.checkboxToggle;
		}
		ValueExpression _ve = getValueExpression("checkboxToggle");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>checkboxToggle</code> property.
	 * </p>
	 */
	public void setCheckboxToggle(Object checkboxToggle) {
		this.checkboxToggle = checkboxToggle;
		this.handleConfig("checkboxToggle", checkboxToggle);
	}

	private Boolean collapsible;

	/**
	 * <tt>true</tt> to make the fieldset collapsibleand have the
	 * expand/collapse toggle button automatically rendered into the legend
	 * element, <tt>false</tt> to keep the fieldset statically sized with no
	 * collapse button (defaults to <tt>false</tt>). Another option is to
	 * configure
	 * 
	 * <tt><a href="output/Ext.form.FieldSet.html#Ext.form.FieldSet-checkboxToggle" ext:member="checkboxToggle" ext:cls="Ext.form.FieldSet">checkboxToggle</a></tt>
	 * .
	 */
	public Boolean getCollapsible() {
		if (null != this.collapsible) {
			return this.collapsible;
		}
		ValueExpression _ve = getValueExpression("collapsible");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsible</code> property.
	 * </p>
	 */
	public void setCollapsible(Boolean collapsible) {
		this.collapsible = collapsible;
		this.handleConfig("collapsible", collapsible);
	}

	private String itemCls;

	/**
	 * A css class to apply to the <tt>x-form-item</tt>of fields (see <a
	 * href="output/Ext.layout.FormLayout.html"
	 * ext:cls="Ext.layout.FormLayout">Ext.layout.FormLayout</a>.<a
	 * href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-fieldTpl"
	 * ext:member="fieldTpl" ext:cls="Ext.layout.FormLayout">fieldTpl</a> for
	 * details). This property cascades to child containers.
	 */
	public String getItemCls() {
		if (null != this.itemCls) {
			return this.itemCls;
		}
		ValueExpression _ve = getValueExpression("itemCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>itemCls</code> property.
	 * </p>
	 */
	public void setItemCls(String itemCls) {
		this.itemCls = itemCls;
		this.handleConfig("itemCls", itemCls);
	}

	private Integer labelWidth;

	/**
	 * The width of labels. This property cascades tochild containers.
	 */
	public Integer getLabelWidth() {
		if (null != this.labelWidth) {
			return this.labelWidth;
		}
		ValueExpression _ve = getValueExpression("labelWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>labelWidth</code> property.
	 * </p>
	 */
	public void setLabelWidth(Integer labelWidth) {
		this.labelWidth = labelWidth;
		this.handleConfig("labelWidth", labelWidth);
	}

	private String layout;

	/**
	 * The <a href="output/Ext.Container.html#Ext.Container-layout"
	 * ext:member="layout" ext:cls="Ext.Container">Ext.Container.layout</a> to
	 * use inside thefieldset (defaults to <tt>'form'</tt>).
	 */
	public String getLayout() {
		if (null != this.layout) {
			return this.layout;
		}
		ValueExpression _ve = getValueExpression("layout");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>layout</code> property.
	 * </p>
	 */
	public void setLayout(String layout) {
		this.layout = layout;
		this.handleConfig("layout", layout);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[9];
		}
		_values[0] = super.saveState(_context);
		_values[1] = animCollapse;
		_values[2] = baseCls;
		_values[3] = checkboxName;
		_values[4] = checkboxToggle;
		_values[5] = collapsible;
		_values[6] = itemCls;
		_values[7] = labelWidth;
		_values[8] = layout;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.animCollapse = (Boolean) _values[1];
		this.handleConfig("animCollapse", this.animCollapse);
		this.baseCls = (String) _values[2];
		this.handleConfig("baseCls", this.baseCls);
		this.checkboxName = (String) _values[3];
		this.handleConfig("checkboxName", this.checkboxName);
		this.checkboxToggle = (Object) _values[4];
		this.handleConfig("checkboxToggle", this.checkboxToggle);
		this.collapsible = (Boolean) _values[5];
		this.handleConfig("collapsible", this.collapsible);
		this.itemCls = (String) _values[6];
		this.handleConfig("itemCls", this.itemCls);
		this.labelWidth = (Integer) _values[7];
		this.handleConfig("labelWidth", this.labelWidth);
		this.layout = (String) _values[8];
		this.handleConfig("layout", this.layout);

	}
}