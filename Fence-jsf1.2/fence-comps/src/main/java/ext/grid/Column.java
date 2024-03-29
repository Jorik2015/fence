package ext.grid;

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
 * Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This class encapsulates column configuration data to be used in the
 * initialization of a <a href="output/Ext.grid.ColumnModel.html"
 * ext:cls="Ext.grid.ColumnModel">ColumnModel</a>.
 * </p>
 * 
 * <p>
 * While subclasses are provided to render data in different ways, this class
 * renders a passed data field unchanged and is usually used for textual
 * columns.
 * </p>
 */
@InstanceOf("Ext.grid.Column")
@ParseConfigMode(ui = false, name = "columns", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class Column extends ExtOutput {
	public static final String COMPONENT_TYPE = "Ext.grid.Column";
	public static final String COMPONENT_FAMILY = "Ext.grid.Column";

	/**
	 * <p>
	 * Create a new {@link Column} instance with default property values.
	 * </p>
	 */
	public Column() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String align;

	/**
	 * Optional. Set the CSS text-align property of thecolumn. Defaults to
	 * undefined.
	 */
	public String getAlign() {
		if (null != this.align) {
			return this.align;
		}
		ValueExpression _ve = getValueExpression("align");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>align</code> property.
	 * </p>
	 */
	public void setAlign(String align) {
		this.align = align;
		this.handleConfig("align", align);
	}

	private String css;

	/**
	 * Optional. An inline style definition string whichis applied to all table
	 * cells in the column (excluding headers). Defaults to undefined.
	 */
	public String getCss() {
		if (null != this.css) {
			return this.css;
		}
		ValueExpression _ve = getValueExpression("css");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>css</code> property.
	 * </p>
	 */
	public void setCss(String css) {
		this.css = css;
		this.handleConfig("css", css);
	}

	private String dataIndex;

	/**
	 * <p>
	 * <b>Required</b>. The name of the field in the grid's <a
	 * href="output/Ext.data.Store.html"
	 * ext:cls="Ext.data.Store">Ext.data.Store</a>'s <a
	 * href="output/Ext.data.Record.html"
	 * ext:cls="Ext.data.Record">Ext.data.Record</a> definition from which to
	 * draw the column's value.
	 * </p>
	 */
	public String getDataIndex() {
		if (null != this.dataIndex) {
			return this.dataIndex;
		}
		ValueExpression _ve = getValueExpression("dataIndex");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>dataIndex</code> property.
	 * </p>
	 */
	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
		this.handleConfig("dataIndex", dataIndex);
	}

	private Boolean editable;

	/**
	 * Optional. Defaults to <tt>true</tt>, enabling theconfigured
	 * <tt><a href="output/Ext.grid.Column.html#Ext.grid.Column-editor" ext:member="editor" ext:cls="Ext.grid.Column">editor</a></tt>
	 * . Set to <tt>false</tt> to initially disable editing on this column. The
	 * initial configuration may be dynamically altered using <a
	 * href="output/Ext.grid.ColumnModel.html"
	 * ext:cls="Ext.grid.ColumnModel">Ext.grid.ColumnModel</a>.<a href=
	 * "output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-setEditable"
	 * ext:member="setEditable"
	 * ext:cls="Ext.grid.ColumnModel">setEditable()</a>.
	 */
	public Boolean getEditable() {
		if (null != this.editable) {
			return this.editable;
		}
		ValueExpression _ve = getValueExpression("editable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>editable</code> property.
	 * </p>
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
		this.handleConfig("editable", editable);
	}

	private Object editor;

	/**
	 * Optional. The <a href="output/Ext.form.Field.html"
	 * ext:cls="Ext.form.Field">Ext.form.Field</a> to use when editingvalues in
	 * this column if editing is supported by the grid. See
	 * <tt><a href="output/Ext.grid.Column.html#Ext.grid.Column-editable" ext:member="editable" ext:cls="Ext.grid.Column">editable</a></tt>
	 * also.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getEditor() {
		if (null != this.editor) {
			return this.editor;
		}
		ValueExpression _ve = getValueExpression("editor");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>editor</code> property.
	 * </p>
	 */
	public void setEditor(Object editor) {
		this.editor = editor;
		this.handleConfig("editor", editor);
	}

	private String emptyGroupText;

	/**
	 * Optional. If the grid is being rendered by an <a
	 * href="output/Ext.grid.GroupingView.html"
	 * ext:cls="Ext.grid.GroupingView">Ext.grid.GroupingView</a>, thisoption may
	 * be used to specify the text to display when there is an empty group
	 * value. Defaults to the <a href="output/Ext.grid.GroupingView.html"
	 * ext:cls="Ext.grid.GroupingView">Ext.grid.GroupingView</a>.<a href=
	 * "output/Ext.grid.GroupingView.html#Ext.grid.GroupingView-emptyGroupText"
	 * ext:member="emptyGroupText"
	 * ext:cls="Ext.grid.GroupingView">emptyGroupText</a>.
	 */
	public String getEmptyGroupText() {
		if (null != this.emptyGroupText) {
			return this.emptyGroupText;
		}
		ValueExpression _ve = getValueExpression("emptyGroupText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyGroupText</code> property.
	 * </p>
	 */
	public void setEmptyGroupText(String emptyGroupText) {
		this.emptyGroupText = emptyGroupText;
		this.handleConfig("emptyGroupText", emptyGroupText);
	}

	private Boolean fixed;

	/**
	 * Optional. <tt>true</tt> if the column widthcannot be changed. Defaults to
	 * <tt>false</tt>.
	 */
	public Boolean getFixed() {
		if (null != this.fixed) {
			return this.fixed;
		}
		ValueExpression _ve = getValueExpression("fixed");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>fixed</code> property.
	 * </p>
	 */
	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
		this.handleConfig("fixed", fixed);
	}

	private String groupName;

	/**
	 * Optional. If the grid is being rendered by an <a
	 * href="output/Ext.grid.GroupingView.html"
	 * ext:cls="Ext.grid.GroupingView">Ext.grid.GroupingView</a>, thisoption may
	 * be used to specify the text with which to prefix the group field value in
	 * the group header line. See also <a
	 * href="output/Ext.grid.Column.html#Ext.grid.Column-groupRenderer"
	 * ext:member="groupRenderer" ext:cls="Ext.grid.Column">groupRenderer</a>
	 * and <a href="output/Ext.grid.GroupingView.html"
	 * ext:cls="Ext.grid.GroupingView">Ext.grid.GroupingView</a>.<a href=
	 * "output/Ext.grid.GroupingView.html#Ext.grid.GroupingView-showGroupName"
	 * ext:member="showGroupName"
	 * ext:cls="Ext.grid.GroupingView">showGroupName</a>.
	 */
	public String getGroupName() {
		if (null != this.groupName) {
			return this.groupName;
		}
		ValueExpression _ve = getValueExpression("groupName");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>groupName</code> property.
	 * </p>
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
		this.handleConfig("groupName", groupName);
	}

	private Object groupRenderer;

	/**
	 * <p>
	 * Optional. If the grid is being rendered by an <a
	 * href="output/Ext.grid.GroupingView.html"
	 * ext:cls="Ext.grid.GroupingView">Ext.grid.GroupingView</a>, this option
	 * may be used to specify the function used to format the grouping field
	 * value for display in the group <a
	 * href="output/Ext.grid.Column.html#Ext.grid.Column-groupName"
	 * ext:member="groupName" ext:cls="Ext.grid.Column">header</a>. If a
	 * <tt><b>groupRenderer</b></tt> is not specified, the configured
	 * 
	 * <tt><b><a href="output/Ext.grid.Column.html#Ext.grid.Column-renderer" ext:member="renderer" ext:cls="Ext.grid.Column">renderer</a></b></tt>
	 * will be called; if a
	 * <tt><b><a href="output/Ext.grid.Column.html#Ext.grid.Column-renderer" ext:member="renderer" ext:cls="Ext.grid.Column">renderer</a></b></tt>
	 * is also not specified the new value of the group field will be used.
	 * </p>
	 * 
	 * <p>
	 * The called function (either the <tt><b>groupRenderer</b></tt> or
	 * 
	 * <tt><b><a href="output/Ext.grid.Column.html#Ext.grid.Column-renderer" ext:member="renderer" ext:cls="Ext.grid.Column">renderer</a></b></tt>
	 * ) will be passed the following parameters:
	 * </p>
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><b>v</b> : Object
	 * 
	 * <p class="sub-desc">
	 * The new value of the group field.
	 * </p>
	 * </li>
	 * 
	 * <li><b>unused</b> : undefined
	 * 
	 * <p class="sub-desc">
	 * Unused parameter.
	 * </p>
	 * </li>
	 * 
	 * <li><b>r</b> : Ext.data.Record
	 * 
	 * <p class="sub-desc">
	 * The Record providing the data for the row which caused group change.
	 * </p>
	 * </li>
	 * 
	 * <li><b>rowIndex</b> : Number
	 * 
	 * <p class="sub-desc">
	 * The row index of the Record which caused group change.
	 * </p>
	 * </li>
	 * 
	 * <li><b>colIndex</b> : Number
	 * 
	 * <p class="sub-desc">
	 * The column index of the group field.
	 * </p>
	 * </li>
	 * 
	 * <li><b>ds</b> : Ext.data.Store
	 * 
	 * <p class="sub-desc">
	 * The Store which is providing the data Model.
	 * </p>
	 * </li>
	 * </ul>
	 * </div>
	 * 
	 * <br>
	 * <br>
	 * 
	 * 
	 * <p>
	 * The function should return a string value.
	 * </p>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getGroupRenderer() {
		if (null != this.groupRenderer) {
			return this.groupRenderer;
		}
		ValueExpression _ve = getValueExpression("groupRenderer");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>groupRenderer</code> property.
	 * </p>
	 */
	public void setGroupRenderer(Object groupRenderer) {
		this.groupRenderer = groupRenderer;
		this.handleConfig("groupRenderer", groupRenderer);
	}

	private Boolean groupable;

	/**
	 * Optional. If the grid is being rendered by an <a
	 * href="output/Ext.grid.GroupingView.html"
	 * ext:cls="Ext.grid.GroupingView">Ext.grid.GroupingView</a>, thisoption may
	 * be used to disable the header menu item to group by the column selected.
	 * Defaults to <tt>true</tt>, which enables the header menu group option.
	 * Set to <tt>false</tt> to disable (but still show) the group option in the
	 * header menu for the column. See also
	 * <code><a href="output/Ext.grid.Column.html#Ext.grid.Column-groupName" ext:member="groupName" ext:cls="Ext.grid.Column">groupName</a></code>
	 * .
	 */
	public Boolean getGroupable() {
		if (null != this.groupable) {
			return this.groupable;
		}
		ValueExpression _ve = getValueExpression("groupable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>groupable</code> property.
	 * </p>
	 */
	public void setGroupable(Boolean groupable) {
		this.groupable = groupable;
		this.handleConfig("groupable", groupable);
	}

	private String header;

	/**
	 * Optional. The header text to be used as innerHTML(html tags are accepted)
	 * to display in the Grid view. <b>Note</b>: to have a clickable header with
	 * no text displayed use <tt>'&nbsp;'</tt>.
	 */
	public String getHeader() {
		if (null != this.header) {
			return this.header;
		}
		ValueExpression _ve = getValueExpression("header");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>header</code> property.
	 * </p>
	 */
	public void setHeader(String header) {
		this.header = header;
		this.handleConfig("header", header);
	}

	private Boolean hidden;

	/**
	 * Optional. <tt>true</tt> to hide the column.Defaults to <tt>false</tt>.
	 */
	public Boolean getHidden() {
		if (null != this.hidden) {
			return this.hidden;
		}
		ValueExpression _ve = getValueExpression("hidden");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hidden</code> property.
	 * </p>
	 */
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
		this.handleConfig("hidden", hidden);
	}

	private Boolean hideable;

	/**
	 * Optional. Specify as <tt>false</tt> to preventthe user from hiding this
	 * column (defaults to true). To disallow column hiding globally for all
	 * columns in the grid, use <a href=
	 * "output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-enableColumnHide"
	 * ext:member="enableColumnHide"
	 * ext:cls="Ext.grid.GridPanel">Ext.grid.GridPanel.enableColumnHide</a>
	 * instead.
	 */
	public Boolean getHideable() {
		if (null != this.hideable) {
			return this.hideable;
		}
		ValueExpression _ve = getValueExpression("hideable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hideable</code> property.
	 * </p>
	 */
	public void setHideable(Boolean hideable) {
		this.hideable = hideable;
		this.handleConfig("hideable", hideable);
	}

	private String id;

	/**
	 * Optional. A name which identifies this column(defaults to the column's
	 * initial ordinal position.) The <tt>id</tt> is used to create a CSS
	 * <b>class</b> name which is applied to all table cells (including headers)
	 * in that column (in this context the <tt>id</tt> does not need to be
	 * unique). The class name takes the form of
	 * 
	 * <pre>
	 * x-grid3-td-&lt;b&gt;id&lt;/b&gt;
	 * </pre>
	 * 
	 * Header cells will also receive this class name, but will also have the
	 * class
	 * 
	 * <pre>
	 * x - grid3 - hd
	 * </pre>
	 * 
	 * So, to target header cells, use CSS selectors such as:
	 * 
	 * <pre>
	 * .x-grid3-hd-row .x-grid3-td-&lt;b&gt;id&lt;/b&gt;
	 * </pre>
	 * 
	 * The <a href=
	 * "output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandColumn"
	 * ext:member="autoExpandColumn"
	 * ext:cls="Ext.grid.GridPanel">Ext.grid.GridPanel.autoExpandColumn</a> grid
	 * config option references the column via this unique identifier.
	 */
	public String getId() {
		if (null != this.id) {
			return this.id;
		}
		ValueExpression _ve = getValueExpression("id");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>id</code> property.
	 * </p>
	 */
	public void setId(String id) {
		this.id = id;
		this.handleConfig("id", id);
	}

	private Boolean menuDisabled;

	/**
	 * Optional. <tt>true</tt> to disable the columnmenu. Defaults to
	 * <tt>false</tt>.
	 */
	public Boolean getMenuDisabled() {
		if (null != this.menuDisabled) {
			return this.menuDisabled;
		}
		ValueExpression _ve = getValueExpression("menuDisabled");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>menuDisabled</code> property.
	 * </p>
	 */
	public void setMenuDisabled(Boolean menuDisabled) {
		this.menuDisabled = menuDisabled;
		this.handleConfig("menuDisabled", menuDisabled);
	}

	private Object renderer;

	/**
	 * <p>
	 * For an alternative to specifying a renderer see
	 * <code><a href="output/Ext.grid.Column.html#Ext.grid.Column-xtype" ext:member="xtype" ext:cls="Ext.grid.Column">xtype</a></code>
	 * </p>
	 * 
	 * <p>
	 * Optional. A renderer is an 'interceptor' method which can be used
	 * transform data (value, appearance, etc.) before it is rendered). This may
	 * be specified in either of three ways:
	 * </p>
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li>A renderer function used to return HTML markup for a cell given the
	 * cell's data value.</li>
	 * 
	 * <li>A string which references a property name of the <a
	 * href="output/Ext.util.Format.html"
	 * ext:cls="Ext.util.Format">Ext.util.Format</a> class which provides a
	 * renderer function.</li>
	 * 
	 * <li>An object specifying both the renderer function, and its execution
	 * scope (<tt><b>this</b></tt> reference) e.g.:
	 * 
	 * <pre style="margin-left:1.2em">
	 * &lt;code&gt;{
	 *     fn: this.gridRenderer,
	 *     scope: this
	 * }&lt;/code&gt;
	 * </pre>
	 * 
	 * </li>
	 * </ul>
	 * </div>
	 * 
	 * If not specified, the default renderer uses the raw data value.<br>
	 * <br>
	 * 
	 * 
	 * <p>
	 * For information about the renderer function (passed parameters, etc.),
	 * see <a href=
	 * "output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-setRenderer"
	 * ext:member="setRenderer"
	 * ext:cls="Ext.grid.ColumnModel">Ext.grid.ColumnModel.setRenderer</a>. An
	 * example of specifying renderer function inline:
	 * </p>
	 * 
	 * <pre>
	 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; companyColumn = {
	 *    header: &lt;em&gt;'Company Name'&lt;/em&gt;,
	 *    dataIndex: &lt;em&gt;'company'&lt;/em&gt;,
	 *    renderer: &lt;b&gt;function&lt;/b&gt;(value, metaData, record, rowIndex, colIndex, store) {
	 *       &lt;i&gt;// provide the logic depending on business rules
	 * &lt;/i&gt;
	 *       &lt;i&gt;// name of your own choosing to manipulate the cell depending upon
	 * &lt;/i&gt;
	 *       &lt;i&gt;// the data &lt;b&gt;in&lt;/b&gt; the underlying Record object.
	 * &lt;/i&gt;
	 *       &lt;b&gt;if&lt;/b&gt; (value == &lt;em&gt;'whatever'&lt;/em&gt;) {
	 *           &lt;i&gt;//metaData.css : String : A CSS class name to add to the TD element of the cell.
	 * &lt;/i&gt;
	 *           &lt;i&gt;//metaData.attr : String : An html attribute definition string to apply to
	 * &lt;/i&gt;
	 *           &lt;i&gt;//                         the data container element within the table
	 * &lt;/i&gt;
	 *           &lt;i&gt;//                         cell (e.g. &lt;em&gt;'style=&lt;/em&gt;&quot;color:red;&quot;&lt;/i&gt;'&lt;/code&gt;).
	 * 
	 *           metaData.css = &lt;em&gt;'name-of-css-class-you-will-define'&lt;/em&gt;;
	 *       }
	 *       &lt;b&gt;return&lt;/b&gt; value;
	 *    }
	 * }
	 * </pre>
	 * 
	 * See also <a href="output/Ext.grid.Column.html#Ext.grid.Column-scope"
	 * ext:member="scope" ext:cls="Ext.grid.Column">scope</a>.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getRenderer() {
		if (null != this.renderer) {
			return this.renderer;
		}
		ValueExpression _ve = getValueExpression("renderer");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>renderer</code> property.
	 * </p>
	 */
	public void setRenderer(Object renderer) {
		this.renderer = renderer;
		this.handleConfig("renderer", renderer);
	}

	private Boolean resizable;

	/**
	 * Optional. <tt>false</tt> to disable columnresizing. Defaults to
	 * <tt>true</tt>.
	 */
	public Boolean getResizable() {
		if (null != this.resizable) {
			return this.resizable;
		}
		ValueExpression _ve = getValueExpression("resizable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>resizable</code> property.
	 * </p>
	 */
	public void setResizable(Boolean resizable) {
		this.resizable = resizable;
		this.handleConfig("resizable", resizable);
	}

	private Object scope;

	/**
	 * Optional. The scope (<tt><b>this</b></tt>reference) in which to execute
	 * the renderer. Defaults to the Column configuration object.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getScope() {
		if (null != this.scope) {
			return this.scope;
		}
		ValueExpression _ve = getValueExpression("scope");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope(Object scope) {
		this.scope = scope;
		this.handleConfig("scope", scope);
	}

	private Boolean sortable;

	/**
	 * Optional. <tt>true</tt> if sorting is to beallowed on this column.
	 * Defaults to the value of the <a
	 * href="output/Ext.grid.Column.html#Ext.grid.Column-defaultSortable"
	 * ext:member="defaultSortable"
	 * ext:cls="Ext.grid.Column">defaultSortable</a> property. Whether
	 * local/remote sorting is used is specified in <a
	 * href="output/Ext.data.Store.html#Ext.data.Store-remoteSort"
	 * ext:member="remoteSort"
	 * ext:cls="Ext.data.Store">Ext.data.Store.remoteSort</a>.
	 */
	public Boolean getSortable() {
		if (null != this.sortable) {
			return this.sortable;
		}
		ValueExpression _ve = getValueExpression("sortable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sortable</code> property.
	 * </p>
	 */
	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
		this.handleConfig("sortable", sortable);
	}

	private String tooltip;

	/**
	 * Optional. A text string to use as the columnheader's tooltip. If
	 * Quicktips are enabled, this value will be used as the text of the quick
	 * tip, otherwise it will be set as the header's HTML title attribute.
	 * Defaults to ''.
	 */
	public String getTooltip() {
		if (null != this.tooltip) {
			return this.tooltip;
		}
		ValueExpression _ve = getValueExpression("tooltip");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tooltip</code> property.
	 * </p>
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
		this.handleConfig("tooltip", tooltip);
	}

	private Integer width;

	/**
	 * Optional. The initial width in pixels of thecolumn. The width of each
	 * column can also be affected if any of the following are configured:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><a href="output/Ext.grid.GridPanel.html"
	 * ext:cls="Ext.grid.GridPanel">Ext.grid.GridPanel</a>.
	 * 
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandColumn" ext:member="autoExpandColumn" ext:cls="Ext.grid.GridPanel">autoExpandColumn</a></tt>
	 * </li>
	 * 
	 * <li><a href="output/Ext.grid.GridView.html"
	 * ext:cls="Ext.grid.GridView">Ext.grid.GridView</a>.
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit" ext:member="forceFit" ext:cls="Ext.grid.GridView">forceFit</a></tt>
	 * 
	 * 
	 * <div class="sub-desc">
	 * <p>
	 * By specifying <tt>forceFit:true</tt>, <a
	 * href="output/Ext.grid.Column.html#Ext.grid.Column-fixed"
	 * ext:member="fixed" ext:cls="Ext.grid.Column">non-fixed width</a> columns
	 * will be re-proportioned (based on the relative initial widths) to fill
	 * the width of the grid so that no horizontal scrollbar is shown.
	 * </p>
	 * </div></li>
	 * 
	 * <li><a href="output/Ext.grid.GridView.html"
	 * ext:cls="Ext.grid.GridView">Ext.grid.GridView</a>.
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-autoFill" ext:member="autoFill" ext:cls="Ext.grid.GridView">autoFill</a></tt>
	 * </li>
	 * 
	 * <li><a href="output/Ext.grid.GridPanel.html"
	 * ext:cls="Ext.grid.GridPanel">Ext.grid.GridPanel</a>.
	 * 
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-minColumnWidth" ext:member="minColumnWidth" ext:cls="Ext.grid.GridPanel">minColumnWidth</a></tt>
	 * </li>
	 * 
	 * <li style="list-style: none"><br>
	 * <p>
	 * <b>Note</b>: when the width of each column is determined, a space on the
	 * right side is reserved for the vertical scrollbar. The <a
	 * href="output/Ext.grid.GridView.html"
	 * ext:cls="Ext.grid.GridView">Ext.grid.GridView</a>.
	 * 
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-scrollOffset" ext:member="scrollOffset" ext:cls="Ext.grid.GridView">scrollOffset</a></tt>
	 * can be modified to reduce or eliminate the reserved offset.
	 * </p>
	 * </li>
	 * </ul>
	 * </div>
	 */
	public Integer getWidth() {
		if (null != this.width) {
			return this.width;
		}
		ValueExpression _ve = getValueExpression("width");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth(Integer width) {
		this.width = width;
		this.handleConfig("width", width);
	}

	private String xtype;

	/**
	 * Optional. A String which references a predefined<a
	 * href="output/Ext.grid.Column.html"
	 * ext:cls="Ext.grid.Column">Ext.grid.Column</a> subclass type which is
	 * preconfigured with an appropriate
	 * <code><a href="output/Ext.grid.Column.html#Ext.grid.Column-renderer" ext:member="renderer" ext:cls="Ext.grid.Column">renderer</a></code>
	 * to be easily configured into a ColumnModel. The predefined <a
	 * href="output/Ext.grid.Column.html"
	 * ext:cls="Ext.grid.Column">Ext.grid.Column</a> subclass types are:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><b><tt>gridcolumn</tt></b> : <a href="output/Ext.grid.Column.html"
	 * ext:cls="Ext.grid.Column">Ext.grid.Column</a> (<b>Default</b>)</li>
	 * 
	 * <li><b><tt>booleancolumn</tt></b> : <a
	 * href="output/Ext.grid.BooleanColumn.html"
	 * ext:cls="Ext.grid.BooleanColumn">Ext.grid.BooleanColumn</a></li>
	 * 
	 * <li><b><tt>numbercolumn</tt></b> : <a
	 * href="output/Ext.grid.NumberColumn.html"
	 * ext:cls="Ext.grid.NumberColumn">Ext.grid.NumberColumn</a></li>
	 * 
	 * <li><b><tt>datecolumn</tt></b> : <a
	 * href="output/Ext.grid.DateColumn.html"
	 * ext:cls="Ext.grid.DateColumn">Ext.grid.DateColumn</a></li>
	 * 
	 * <li><b><tt>templatecolumn</tt></b> : <a
	 * href="output/Ext.grid.TemplateColumn.html"
	 * ext:cls="Ext.grid.TemplateColumn">Ext.grid.TemplateColumn</a></li>
	 * </ul>
	 * </div>
	 * 
	 * <p>
	 * Configuration properties for the specified <code>xtype</code> may be
	 * specified with the Column configuration properties, for example:
	 * </p>
	 * 
	 * <pre>
	 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; grid = &lt;b&gt;new&lt;/b&gt; Ext.grid.GridPanel({
	 *     ...
	 *     columns: [{
	 *         header: &lt;em&gt;'Last Updated'&lt;/em&gt;,
	 *         dataIndex: &lt;em&gt;'lastChange'&lt;/em&gt;,
	 *         width: 85,
	 *         sortable: true,
	 *         &lt;i&gt;//renderer: Ext.util.Format.dateRenderer(&lt;em&gt;'m/d/Y'&lt;/em&gt;),
	 * &lt;/i&gt;
	 *         xtype: &lt;em&gt;'datecolumn'&lt;/em&gt;, &lt;i&gt;// use xtype instead of renderer
	 * &lt;/i&gt;
	 *         format: &lt;em&gt;'M/d/Y'&lt;/em&gt; &lt;i&gt;// configuration property &lt;b&gt;for&lt;/b&gt; &lt;a href=&quot;output/Ext.grid.DateColumn.html&quot; ext:cls=&quot;Ext.grid.DateColumn&quot;&gt;Ext.grid.DateColumn&lt;/a&gt;
	 * &lt;/i&gt;
	 *     }, {
	 *         ...
	 *     }]
	 * });&lt;/code&gt;
	 * </pre>
	 */
	public String getXtype() {
		if (null != this.xtype) {
			return this.xtype;
		}
		ValueExpression _ve = getValueExpression("xtype");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>xtype</code> property.
	 * </p>
	 */
	public void setXtype(String xtype) {
		this.xtype = xtype;
		this.handleConfig("xtype", xtype);
	}

	private Boolean locked;

	/**
	 * Optional. <tt>false</tt> to disable columnresizing. Defaults to
	 * <tt>true</tt>.
	 */
	public Boolean getLocked() {
		if (null != this.locked) {
			return this.locked;
		}
		ValueExpression _ve = getValueExpression("locked");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>locked</code> property.
	 * </p>
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
		this.handleConfig("locked", locked);
	}

	private String summaryType;
	private Object summaryRenderer;

	public String getSummaryType() {
		if (null != this.summaryType) {
			return this.summaryType;
		}
		ValueExpression _ve = getValueExpression("summaryType");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setSummaryType(String summaryType) {
		this.summaryType = summaryType;
		this.handleConfig("summaryType", summaryType);
	}

	public Object getSummaryRenderer() {
		if (null != this.summaryRenderer) {
			return this.summaryRenderer;
		}
		ValueExpression _ve = getValueExpression("summaryRenderer");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setSummaryRenderer(Object summaryRenderer) {
		this.summaryRenderer = summaryRenderer;
		this.handleConfig("summaryRenderer", summaryRenderer);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[26];
		}
		_values[0] = super.saveState(_context);
		_values[1] = align;
		_values[2] = css;
		_values[3] = dataIndex;
		_values[4] = editable;
		_values[5] = editor;
		_values[6] = emptyGroupText;
		_values[7] = fixed;
		_values[8] = groupName;
		_values[9] = groupRenderer;
		_values[10] = groupable;
		_values[11] = header;
		_values[12] = hidden;
		_values[13] = hideable;
		_values[14] = id;
		_values[15] = menuDisabled;
		_values[16] = renderer;
		_values[17] = resizable;
		_values[18] = scope;
		_values[19] = sortable;
		_values[20] = tooltip;
		_values[21] = width;
		_values[22] = xtype;
		_values[23] = locked;
		_values[24] = summaryType;
		_values[25] = summaryRenderer;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.align = (String) _values[1];
		this.handleConfig("align", this.align);
		this.css = (String) _values[2];
		this.handleConfig("css", this.css);
		this.dataIndex = (String) _values[3];
		this.handleConfig("dataIndex", this.dataIndex);
		this.editable = (Boolean) _values[4];
		this.handleConfig("editable", this.editable);
		this.editor = (Object) _values[5];
		this.handleConfig("editor", this.editor);
		this.emptyGroupText = (String) _values[6];
		this.handleConfig("emptyGroupText", this.emptyGroupText);
		this.fixed = (Boolean) _values[7];
		this.handleConfig("fixed", this.fixed);
		this.groupName = (String) _values[8];
		this.handleConfig("groupName", this.groupName);
		this.groupRenderer = (Object) _values[9];
		this.handleConfig("groupRenderer", this.groupRenderer);
		this.groupable = (Boolean) _values[10];
		this.handleConfig("groupable", this.groupable);
		this.header = (String) _values[11];
		this.handleConfig("header", this.header);
		this.hidden = (Boolean) _values[12];
		this.handleConfig("hidden", this.hidden);
		this.hideable = (Boolean) _values[13];
		this.handleConfig("hideable", this.hideable);
		this.id = (String) _values[14];
		this.handleConfig("id", this.id);
		this.menuDisabled = (Boolean) _values[15];
		this.handleConfig("menuDisabled", this.menuDisabled);
		this.renderer = (Object) _values[16];
		this.handleConfig("renderer", this.renderer);
		this.resizable = (Boolean) _values[17];
		this.handleConfig("resizable", this.resizable);
		this.scope = (Object) _values[18];
		this.handleConfig("scope", this.scope);
		this.sortable = (Boolean) _values[19];
		this.handleConfig("sortable", this.sortable);
		this.tooltip = (String) _values[20];
		this.handleConfig("tooltip", this.tooltip);
		this.width = (Integer) _values[21];
		this.handleConfig("width", this.width);
		this.xtype = (String) _values[22];
		this.handleConfig("xtype", this.xtype);
		this.locked = (Boolean) _values[23];
		this.handleConfig("locked", this.locked);
		
		this.summaryType = (String) _values[24];
		this.handleConfig("summaryType", this.summaryType);
		this.summaryRenderer = (Object) _values[25];
		this.handleConfig("summaryRenderer", this.summaryRenderer);
	}
}