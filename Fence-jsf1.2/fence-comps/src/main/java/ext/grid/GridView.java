package ext.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.util.Observable;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This class encapsulates the user interface of an <a
 * href="output/Ext.grid.GridPanel.html"
 * ext:cls="Ext.grid.GridPanel">Ext.grid.GridPanel</a>. Methods of this class
 * may be used to access user interface elements to enable special display
 * effects. Do not change the DOM structure of the user interface.
 * </p>
 * 
 * <p>
 * This class does not provide ways to manipulate the underlying data. The data
 * model of a Grid is held in an <a href="output/Ext.data.Store.html"
 * ext:cls="Ext.data.Store">Ext.data.Store</a>.
 * </p>
 */
@InstanceOf("Ext.grid.GridView")
@ParseConfigMode(ui = false, name = "view", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class GridView extends Observable {
	public static final String COMPONENT_TYPE = "Ext.grid.GridView";
	public static final String COMPONENT_FAMILY = "Ext.grid.GridView";

	/**
	 * <p>
	 * Create a new {@link GridView} instance with default property values.
	 * </p>
	 */
	public GridView() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean autoFill;

	/**
	 * Defaults to <tt>false</tt>. Specify <tt>true</tt>to have the column
	 * widths re-proportioned when the grid is <b>initially rendered</b>. The <a
	 * href="output/Ext.grid.Column.html#Ext.grid.Column-width"
	 * ext:member="width" ext:cls="Ext.grid.Column">initially configured
	 * width</a> of each column will be adjusted to fit the grid width and
	 * prevent horizontal scrolling. If columns are later resized (manually or
	 * programmatically), the other columns in the grid will <b>not</b> be
	 * resized to fit the grid width. See
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit" ext:member="forceFit" ext:cls="Ext.grid.GridView">forceFit</a></tt>
	 * also.
	 */
	public Boolean getAutoFill() {
		if (null != this.autoFill) {
			return this.autoFill;
		}
		ValueExpression _ve = getValueExpression("autoFill");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoFill</code> property.
	 * </p>
	 */
	public void setAutoFill(Boolean autoFill) {
		this.autoFill = autoFill;
		this.handleConfig("autoFill", autoFill);
	}

	private String cellSelector;

	/**
	 * The selector used to find cells internally(defaults to <tt>'td.x-grid3-cell'</tt>)
	 */
	public String getCellSelector() {
		if (null != this.cellSelector) {
			return this.cellSelector;
		}
		ValueExpression _ve = getValueExpression("cellSelector");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cellSelector</code> property.
	 * </p>
	 */
	public void setCellSelector(String cellSelector) {
		this.cellSelector = cellSelector;
		this.handleConfig("cellSelector", cellSelector);
	}

	private Integer cellSelectorDepth;

	/**
	 * The number of levels to search for cells inevent delegation (defaults to
	 * <tt>4</tt>)
	 */
	public Integer getCellSelectorDepth() {
		if (null != this.cellSelectorDepth) {
			return this.cellSelectorDepth;
		}
		ValueExpression _ve = getValueExpression("cellSelectorDepth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cellSelectorDepth</code> property.
	 * </p>
	 */
	public void setCellSelectorDepth(Integer cellSelectorDepth) {
		this.cellSelectorDepth = cellSelectorDepth;
		this.handleConfig("cellSelectorDepth", cellSelectorDepth);
	}

	private String columnsText;

	/**
	 * The text displayed in the "Columns" menu item(defaults to
	 * <tt>"Columns"</tt>)
	 */
	public String getColumnsText() {
		if (null != this.columnsText) {
			return this.columnsText;
		}
		ValueExpression _ve = getValueExpression("columnsText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>columnsText</code> property.
	 * </p>
	 */
	public void setColumnsText(String columnsText) {
		this.columnsText = columnsText;
		this.handleConfig("columnsText", columnsText);
	}

	private Boolean deferEmptyText;

	/**
	 * True to defer
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-emptyText" ext:member="emptyText" ext:cls="Ext.grid.GridView">emptyText</a></tt>
	 * being applied untilthe store's first load (defaults to <tt>true</tt>).
	 */
	public Boolean getDeferEmptyText() {
		if (null != this.deferEmptyText) {
			return this.deferEmptyText;
		}
		ValueExpression _ve = getValueExpression("deferEmptyText");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>deferEmptyText</code> property.
	 * </p>
	 */
	public void setDeferEmptyText(Boolean deferEmptyText) {
		this.deferEmptyText = deferEmptyText;
		this.handleConfig("deferEmptyText", deferEmptyText);
	}

	private String emptyText;

	/**
	 * Default text (html tags are accepted) to displayin the grid body when no
	 * rows are available (defaults to ''). This value will be used to update
	 * the
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-mainBody" ext:member="mainBody" ext:cls="Ext.grid.GridView">mainBody</a></tt>
	 * :
	 * 
	 * <pre>
	 * &lt;code&gt;this.mainBody.update(&lt;em&gt;'&lt;div class=&lt;/em&gt;&quot;x-grid-empty&quot;&lt;/code&gt;&gt;' + this.emptyText + &lt;em&gt;'&lt;/div&gt;'&lt;/em&gt;);
	 * </pre>
	 */
	public String getEmptyText() {
		if (null != this.emptyText) {
			return this.emptyText;
		}
		ValueExpression _ve = getValueExpression("emptyText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyText</code> property.
	 * </p>
	 */
	public void setEmptyText(String emptyText) {
		this.emptyText = emptyText;
		this.handleConfig("emptyText", emptyText);
	}

	private Boolean enableRowBody;

	/**
	 * True to add a second TR element per row that canbe used to provide a row
	 * body that spans beneath the data row. Use the <a
	 * href="output/Ext.grid.GridView.html#Ext.grid.GridView-getRowClass"
	 * ext:member="getRowClass" ext:cls="Ext.grid.GridView">getRowClass</a>
	 * method's rowParams config to customize the row body.
	 */
	public Boolean getEnableRowBody() {
		if (null != this.enableRowBody) {
			return this.enableRowBody;
		}
		ValueExpression _ve = getValueExpression("enableRowBody");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableRowBody</code> property.
	 * </p>
	 */
	public void setEnableRowBody(Boolean enableRowBody) {
		this.enableRowBody = enableRowBody;
		this.handleConfig("enableRowBody", enableRowBody);
	}

	private Boolean forceFit;

	/**
	 * Defaults to <tt>false</tt>. Specify <tt>true</tt>to have the column
	 * widths re-proportioned at <b>all times</b>. The <a
	 * href="output/Ext.grid.Column.html#Ext.grid.Column-width"
	 * ext:member="width" ext:cls="Ext.grid.Column">initially configured
	 * width</a> of each column will be adjusted to fit the grid width and
	 * prevent horizontal scrolling. If columns are later resized (manually or
	 * programmatically), the other columns in the grid <b>will</b> be resized
	 * to fit the grid width. See
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-autoFill" ext:member="autoFill" ext:cls="Ext.grid.GridView">autoFill</a></tt>
	 * also.
	 */
	public Boolean getForceFit() {
		if (null != this.forceFit) {
			return this.forceFit;
		}
		ValueExpression _ve = getValueExpression("forceFit");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>forceFit</code> property.
	 * </p>
	 */
	public void setForceFit(Boolean forceFit) {
		this.forceFit = forceFit;
		this.handleConfig("forceFit", forceFit);
	}

	private Boolean headersDisabled;

	/**
	 * True to disable the grid column headers (defaultsto <tt>false</tt>). Use
	 * the <a href="output/Ext.grid.ColumnModel.html"
	 * ext:cls="Ext.grid.ColumnModel">ColumnModel</a>
	 * 
	 * <tt><a href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-menuDisabled" ext:member="menuDisabled" ext:cls="Ext.grid.ColumnModel">menuDisabled</a></tt>
	 * config to disable the <i>menu</i> for individual columns. While this
	 * config is true the following will be disabled:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li>clicking on header to sort</li>
	 * 
	 * <li>the trigger to reveal the menu.</li>
	 * </ul>
	 * </div>
	 */
	public Boolean getHeadersDisabled() {
		if (null != this.headersDisabled) {
			return this.headersDisabled;
		}
		ValueExpression _ve = getValueExpression("headersDisabled");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>headersDisabled</code> property.
	 * </p>
	 */
	public void setHeadersDisabled(Boolean headersDisabled) {
		this.headersDisabled = headersDisabled;
		this.handleConfig("headersDisabled", headersDisabled);
	}

	private String rowSelector;

	/**
	 * The selector used to find rows internally(defaults to <tt>'div.x-grid3-row'</tt>)
	 */
	public String getRowSelector() {
		if (null != this.rowSelector) {
			return this.rowSelector;
		}
		ValueExpression _ve = getValueExpression("rowSelector");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>rowSelector</code> property.
	 * </p>
	 */
	public void setRowSelector(String rowSelector) {
		this.rowSelector = rowSelector;
		this.handleConfig("rowSelector", rowSelector);
	}

	private Integer rowSelectorDepth;

	/**
	 * The number of levels to search for rows in eventdelegation (defaults to
	 * <tt>10</tt>)
	 */
	public Integer getRowSelectorDepth() {
		if (null != this.rowSelectorDepth) {
			return this.rowSelectorDepth;
		}
		ValueExpression _ve = getValueExpression("rowSelectorDepth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>rowSelectorDepth</code> property.
	 * </p>
	 */
	public void setRowSelectorDepth(Integer rowSelectorDepth) {
		this.rowSelectorDepth = rowSelectorDepth;
		this.handleConfig("rowSelectorDepth", rowSelectorDepth);
	}

	private Integer scrollOffset;

	/**
	 * The amount of space to reserve for the verticalscrollbar (defaults to
	 * <tt>19</tt> pixels).
	 */
	public Integer getScrollOffset() {
		if (null != this.scrollOffset) {
			return this.scrollOffset;
		}
		ValueExpression _ve = getValueExpression("scrollOffset");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollOffset</code> property.
	 * </p>
	 */
	public void setScrollOffset(Integer scrollOffset) {
		this.scrollOffset = scrollOffset;
		this.handleConfig("scrollOffset", scrollOffset);
	}

	private String selectedRowClass;

	/**
	 * The CSS class applied to a selected row (defaultsto
	 * <tt>"x-grid3-row-selected"</tt>). An example overriding the default
	 * styling:
	 * 
	 * <pre>
	 * &lt;code&gt;.x-grid3-row-selected {background-color: yellow;}&lt;/code&gt;
	 * </pre>
	 * 
	 * Note that this only controls the row, and will not do anything for the
	 * text inside it. To style inner facets (like text) use something like:
	 * 
	 * <pre>
	 * &lt;code&gt;.x-grid3-row-selected .x-grid3-cell-inner {
	 *         color: #FFCC00;
	 *     }&lt;/code&gt;
	 * </pre>
	 */
	public String getSelectedRowClass() {
		if (null != this.selectedRowClass) {
			return this.selectedRowClass;
		}
		ValueExpression _ve = getValueExpression("selectedRowClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>selectedRowClass</code> property.
	 * </p>
	 */
	public void setSelectedRowClass(String selectedRowClass) {
		this.selectedRowClass = selectedRowClass;
		this.handleConfig("selectedRowClass", selectedRowClass);
	}

	private String sortAscText;

	/**
	 * The text displayed in the "Sort Ascending" menuitem (defaults to
	 * <tt>"Sort Ascending"</tt>)
	 */
	public String getSortAscText() {
		if (null != this.sortAscText) {
			return this.sortAscText;
		}
		ValueExpression _ve = getValueExpression("sortAscText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sortAscText</code> property.
	 * </p>
	 */
	public void setSortAscText(String sortAscText) {
		this.sortAscText = sortAscText;
		this.handleConfig("sortAscText", sortAscText);
	}

	private Object sortClasses;

	/**
	 * The CSS classes applied to a header when it issorted. (defaults to
	 * <tt>["sort-asc", "sort-desc"]</tt>)
	 */
	@ClientConfig(JsonMode.Array)
	public Object getSortClasses() {
		if (null != this.sortClasses) {
			return this.sortClasses;
		}
		ValueExpression _ve = getValueExpression("sortClasses");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sortClasses</code> property.
	 * </p>
	 */
	public void setSortClasses(Object sortClasses) {
		this.sortClasses = sortClasses;
		this.handleConfig("sortClasses", sortClasses);
	}

	private String sortDescText;

	/**
	 * The text displayed in the "Sort Descending" menuitem (defaults to
	 * <tt>"Sort Descending"</tt>)
	 */
	public String getSortDescText() {
		if (null != this.sortDescText) {
			return this.sortDescText;
		}
		ValueExpression _ve = getValueExpression("sortDescText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sortDescText</code> property.
	 * </p>
	 */
	public void setSortDescText(String sortDescText) {
		this.sortDescText = sortDescText;
		this.handleConfig("sortDescText", sortDescText);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[17];
		}
		_values[0] = super.saveState(_context);
		_values[1] = autoFill;
		_values[2] = cellSelector;
		_values[3] = cellSelectorDepth;
		_values[4] = columnsText;
		_values[5] = deferEmptyText;
		_values[6] = emptyText;
		_values[7] = enableRowBody;
		_values[8] = forceFit;
		_values[9] = headersDisabled;
		_values[10] = rowSelector;
		_values[11] = rowSelectorDepth;
		_values[12] = scrollOffset;
		_values[13] = selectedRowClass;
		_values[14] = sortAscText;
		_values[15] = sortClasses;
		_values[16] = sortDescText;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.autoFill = (Boolean) _values[1];
		this.handleConfig("autoFill", this.autoFill);
		this.cellSelector = (String) _values[2];
		this.handleConfig("cellSelector", this.cellSelector);
		this.cellSelectorDepth = (Integer) _values[3];
		this.handleConfig("cellSelectorDepth", this.cellSelectorDepth);
		this.columnsText = (String) _values[4];
		this.handleConfig("columnsText", this.columnsText);
		this.deferEmptyText = (Boolean) _values[5];
		this.handleConfig("deferEmptyText", this.deferEmptyText);
		this.emptyText = (String) _values[6];
		this.handleConfig("emptyText", this.emptyText);
		this.enableRowBody = (Boolean) _values[7];
		this.handleConfig("enableRowBody", this.enableRowBody);
		this.forceFit = (Boolean) _values[8];
		this.handleConfig("forceFit", this.forceFit);
		this.headersDisabled = (Boolean) _values[9];
		this.handleConfig("headersDisabled", this.headersDisabled);
		this.rowSelector = (String) _values[10];
		this.handleConfig("rowSelector", this.rowSelector);
		this.rowSelectorDepth = (Integer) _values[11];
		this.handleConfig("rowSelectorDepth", this.rowSelectorDepth);
		this.scrollOffset = (Integer) _values[12];
		this.handleConfig("scrollOffset", this.scrollOffset);
		this.selectedRowClass = (String) _values[13];
		this.handleConfig("selectedRowClass", this.selectedRowClass);
		this.sortAscText = (String) _values[14];
		this.handleConfig("sortAscText", this.sortAscText);
		this.sortClasses = (Object) _values[15];
		this.handleConfig("sortClasses", this.sortClasses);
		this.sortDescText = (String) _values[16];
		this.handleConfig("sortDescText", this.sortDescText);

	}
}