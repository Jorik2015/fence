package ext.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.Panel;
import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * This class represents the primary interface of a component based grid control
 * to represent data in a tabular format of rows and columns. The GridPanel is
 * composed of the following:
 * </p>
 * 
 * <div class="mdetail-params">
 * <ul>
 * <li><b><a href="output/Ext.data.Store.html"
 * ext:cls="Ext.data.Store">Store</a></b> : The Model holding the data records
 * (rows)</li>
 * 
 * <li><b><a href="output/Ext.grid.ColumnModel.html"
 * ext:cls="Ext.grid.ColumnModel">Column model</a></b> : Column makeup</li>
 * 
 * <li><b><a href="output/Ext.grid.GridView.html"
 * ext:cls="Ext.grid.GridView">View</a></b> : Encapsulates the user interface</li>
 * 
 * <li><b><a href="output/Ext.grid.AbstractSelectionModel.html"
 * ext:cls="Ext.grid.AbstractSelectionModel">selection model</a></b> : Selection
 * behavior</li>
 * </ul>
 * </div>
 * 
 * <p>
 * Example usage:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; grid = &lt;b&gt;new&lt;/b&gt; Ext.grid.GridPanel({
 *     &lt;a href=&quot;output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-store&quot; ext:member=&quot;store&quot; ext:cls=&quot;Ext.grid.GridPanel&quot;&gt;store&lt;/a&gt;: &lt;b&gt;new&lt;/b&gt; (@link Ext.data.Store}({
 *         &lt;a href=&quot;output/Ext.data.Store.html#Ext.data.Store-autoDestroy&quot; ext:member=&quot;autoDestroy&quot; ext:cls=&quot;Ext.data.Store&quot;&gt;autoDestroy&lt;/a&gt;: true,
 *         &lt;a href=&quot;output/Ext.data.Store.html#Ext.data.Store-reader&quot; ext:member=&quot;reader&quot; ext:cls=&quot;Ext.data.Store&quot;&gt;reader&lt;/a&gt;: reader,
 *         &lt;a href=&quot;output/Ext.data.Store.html#Ext.data.Store-data&quot; ext:member=&quot;data&quot; ext:cls=&quot;Ext.data.Store&quot;&gt;data&lt;/a&gt;: xg.dummyData
 *     }),
 *     &lt;a href=&quot;output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-columns&quot; ext:member=&quot;columns&quot; ext:cls=&quot;Ext.grid.GridPanel&quot;&gt;columns&lt;/a&gt;: [
 *         {id: &lt;em&gt;'company'&lt;/em&gt;, header: &lt;em&gt;'Company'&lt;/em&gt;, width: 200, sortable: true, dataIndex: &lt;em&gt;'company'&lt;/em&gt;},
 *         {header: &lt;em&gt;'Price'&lt;/em&gt;, width: 120, sortable: true, renderer: Ext.util.Format.usMoney, dataIndex: &lt;em&gt;'price'&lt;/em&gt;},
 *         {header: &lt;em&gt;'Change'&lt;/em&gt;, width: 120, sortable: true, dataIndex: &lt;em&gt;'change'&lt;/em&gt;},
 *         {header: &lt;em&gt;'% Change'&lt;/em&gt;, width: 120, sortable: true, dataIndex: &lt;em&gt;'pctChange'&lt;/em&gt;},
 *         &lt;i&gt;// instead of specifying renderer: Ext.util.Format.dateRenderer(&lt;em&gt;'m/d/Y'&lt;/em&gt;) use xtype
 * &lt;/i&gt;
 *         {header: &lt;em&gt;'Last Updated'&lt;/em&gt;, width: 135, sortable: true, dataIndex: &lt;em&gt;'lastChange'&lt;/em&gt;, xtype: &lt;em&gt;'datecolumn'&lt;/em&gt;, format: &lt;em&gt;'M d, Y'&lt;/em&gt;}
 *     ],
 *     &lt;a href=&quot;output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-viewConfig&quot; ext:member=&quot;viewConfig&quot; ext:cls=&quot;Ext.grid.GridPanel&quot;&gt;viewConfig&lt;/a&gt;: {
 *         &lt;a href=&quot;output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit&quot; ext:member=&quot;forceFit&quot; ext:cls=&quot;Ext.grid.GridView&quot;&gt;forceFit&lt;/a&gt;: true,
 * 
 * &lt;i&gt;//      Return CSS class to apply to rows depending upon data values
 * &lt;/i&gt;
 *         &lt;a href=&quot;output/Ext.grid.GridView.html#Ext.grid.GridView-getRowClass&quot; ext:member=&quot;getRowClass&quot; ext:cls=&quot;Ext.grid.GridView&quot;&gt;getRowClass&lt;/a&gt;: &lt;b&gt;function&lt;/b&gt;(record, index) {
 *             &lt;b&gt;var&lt;/b&gt; c = record.&lt;a href=&quot;output/Ext.data.Record.html#Ext.data.Record-get&quot; ext:member=&quot;get&quot; ext:cls=&quot;Ext.data.Record&quot;&gt;get&lt;/a&gt;(&lt;em&gt;'change'&lt;/em&gt;);
 *             &lt;b&gt;if&lt;/b&gt; (c &lt; 0) {
 *                 &lt;b&gt;return&lt;/b&gt; &lt;em&gt;'price-fall'&lt;/em&gt;;
 *             } &lt;b&gt;else&lt;/b&gt; &lt;b&gt;if&lt;/b&gt; (c &gt; 0) {
 *                 &lt;b&gt;return&lt;/b&gt; &lt;em&gt;'price-rise'&lt;/em&gt;;
 *             }
 *         }
 *     },
 *     &lt;a href=&quot;output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-sm&quot; ext:member=&quot;sm&quot; ext:cls=&quot;Ext.grid.GridPanel&quot;&gt;sm&lt;/a&gt;: &lt;b&gt;new&lt;/b&gt; Ext.grid.RowSelectionModel({singleSelect:true}),
 *     width: 600,
 *     height: 300,
 *     frame: true,
 *     title: &lt;em&gt;'Framed &lt;b&gt;with&lt;/b&gt; Row Selection and Horizontal Scrolling'&lt;/em&gt;,
 *     iconCls: &lt;em&gt;'icon-grid'&lt;/em&gt;
 * });&lt;/code&gt;
 * </pre>
 * 
 * <p>
 * <b><u>Notes:</u></b>
 * </p>
 * 
 * <div class="mdetail-params">
 * <ul>
 * <li>Although this class inherits many configuration options from base
 * classes, some of them (such as autoScroll, autoWidth, layout, items, etc) are
 * not used by this class, and will have no effect.</li>
 * 
 * <li>A grid <b>requires</b> a width in which to scroll its columns, and a
 * height in which to scroll its rows. These dimensions can either be set
 * explicitly through the
 * <tt><a href="output/Ext.BoxComponent.html#Ext.BoxComponent-height" ext:member="height" ext:cls="Ext.BoxComponent">height</a></tt>
 * and
 * <tt><a href="output/Ext.BoxComponent.html#Ext.BoxComponent-width" ext:member="width" ext:cls="Ext.BoxComponent">width</a></tt>
 * configuration options or implicitly set by using the grid as a child item of
 * a <a href="output/Ext.Container.html" ext:cls="Ext.Container">Container</a>
 * which will have a <a href="output/Ext.Container.html#Ext.Container-layout"
 * ext:member="layout" ext:cls="Ext.Container">layout manager</a> provide the
 * sizing of its child items (for example the Container of the Grid may specify
 * <tt><a href="output/Ext.Container.html#Ext.Container-layout" ext:member="layout" ext:cls="Ext.Container">layout</a>:'fit'</tt>
 * ).</li>
 * 
 * <li>To access the data in a Grid, it is necessary to use the data model
 * encapsulated by the <a
 * href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-store"
 * ext:member="store" ext:cls="Ext.grid.GridPanel">Store</a>. See the <a
 * href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-cellclick"
 * ext:member="cellclick" ext:cls="Ext.grid.GridPanel">cellclick</a> event for
 * more details.</li>
 * </ul>
 * </div>
 */
@XType("grid")
@InstanceOf("Ext.grid.GridPanel")
public class GridPanel extends Panel {
	public static final String COMPONENT_TYPE = "Ext.grid.GridPanel";
	public static final String COMPONENT_FAMILY = "Ext.grid.GridPanel";

	/**
	 * <p>
	 * Create a new {@link GridPanel} instance with default property values.
	 * </p>
	 */
	public GridPanel() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String autoExpandColumn;

	/**
	 * <p>
	 * The
	 * <tt><a href="output/Ext.grid.Column.html#Ext.grid.Column-id" ext:member="id" ext:cls="Ext.grid.Column">id</a></tt>
	 * of a <a href="output/Ext.grid.Column.html"
	 * ext:cls="Ext.grid.Column">column</a> in this grid that should expand to
	 * fill unused space. This value specified here can not be <tt>0</tt>.
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * <b>Note</b>: If the Grid's <a href="output/Ext.grid.GridView.html"
	 * ext:cls="Ext.grid.GridView">view</a> is configured with
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit" ext:member="forceFit" ext:cls="Ext.grid.GridView">forceFit</a>=true</tt>
	 * the <tt>autoExpandColumn</tt> is ignored. See <a
	 * href="output/Ext.grid.Column.html"
	 * ext:cls="Ext.grid.Column">Ext.grid.Column</a>.
	 * <tt><a href="output/Ext.grid.Column.html#Ext.grid.Column-width" ext:member="width" ext:cls="Ext.grid.Column">width</a></tt>
	 * for additional details.
	 * </p>
	 * 
	 * <p>
	 * See
	 * 
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandMax" ext:member="autoExpandMax" ext:cls="Ext.grid.GridPanel">autoExpandMax</a></tt>
	 * and
	 * 
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandMin" ext:member="autoExpandMin" ext:cls="Ext.grid.GridPanel">autoExpandMin</a></tt>
	 * also.
	 * </p>
	 */
	public String getAutoExpandColumn() {
		if (null != this.autoExpandColumn) {
			return this.autoExpandColumn;
		}
		ValueExpression _ve = getValueExpression("autoExpandColumn");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoExpandColumn</code> property.
	 * </p>
	 */
	public void setAutoExpandColumn(String autoExpandColumn) {
		this.autoExpandColumn = autoExpandColumn;
		this.handleConfig("autoExpandColumn", autoExpandColumn);
	}

	private Integer autoExpandMax;

	/**
	 * The maximum width the
	 * 
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandColumn" ext:member="autoExpandColumn" ext:cls="Ext.grid.GridPanel">autoExpandColumn</a></tt>
	 * can have (ifenabled). Defaults to <tt>1000</tt>.
	 */
	public Integer getAutoExpandMax() {
		if (null != this.autoExpandMax) {
			return this.autoExpandMax;
		}
		ValueExpression _ve = getValueExpression("autoExpandMax");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoExpandMax</code> property.
	 * </p>
	 */
	public void setAutoExpandMax(Integer autoExpandMax) {
		this.autoExpandMax = autoExpandMax;
		this.handleConfig("autoExpandMax", autoExpandMax);
	}

	private Integer autoExpandMin;

	/**
	 * The minimum width the
	 * 
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandColumn" ext:member="autoExpandColumn" ext:cls="Ext.grid.GridPanel">autoExpandColumn</a></tt>
	 * can have (ifenabled). Defaults to <tt>50</tt>.
	 */
	public Integer getAutoExpandMin() {
		if (null != this.autoExpandMin) {
			return this.autoExpandMin;
		}
		ValueExpression _ve = getValueExpression("autoExpandMin");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoExpandMin</code> property.
	 * </p>
	 */
	public void setAutoExpandMin(Integer autoExpandMin) {
		this.autoExpandMin = autoExpandMin;
		this.handleConfig("autoExpandMin", autoExpandMin);
	}

	private Object cm;

	/**
	 * Shorthand for
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-colModel" ext:member="colModel" ext:cls="Ext.grid.GridPanel">colModel</a></tt>
	 * .
	 */
	@ClientConfig(JsonMode.Object)
	public Object getCm() {
		if (null != this.cm) {
			return this.cm;
		}
		ValueExpression _ve = getValueExpression("cm");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cm</code> property.
	 * </p>
	 */
	public void setCm(Object cm) {
		this.cm = cm;
		this.handleConfig("cm", cm);
	}

	private Object colModel;

	/**
	 * The <a href="output/Ext.grid.ColumnModel.html"
	 * ext:cls="Ext.grid.ColumnModel">Ext.grid.ColumnModel</a> to use
	 * whenrendering the grid (required).
	 */
	@ClientConfig(JsonMode.Object)
	public Object getColModel() {
		if (null != this.colModel) {
			return this.colModel;
		}
		ValueExpression _ve = getValueExpression("colModel");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>colModel</code> property.
	 * </p>
	 */
	public void setColModel(Object colModel) {
		this.colModel = colModel;
		this.handleConfig("colModel", colModel);
	}

	private Boolean columnLines;

	/**
	 * <tt>true</tt> to add css for column separationlines. Default is
	 * <tt>false</tt>.
	 */
	public Boolean getColumnLines() {
		if (null != this.columnLines) {
			return this.columnLines;
		}
		ValueExpression _ve = getValueExpression("columnLines");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>columnLines</code> property.
	 * </p>
	 */
	public void setColumnLines(Boolean columnLines) {
		this.columnLines = columnLines;
		this.handleConfig("columnLines", columnLines);
	}

	private Object columns;

	/**
	 * An array of <a href="output/Ext.grid.Column.html"
	 * ext:cls="Ext.grid.Column">columns</a> to auto create a <a
	 * href="output/Ext.grid.ColumnModel.html"
	 * ext:cls="Ext.grid.ColumnModel">Ext.grid.ColumnModel</a>. TheColumnModel
	 * may be explicitly created via the
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-colModel" ext:member="colModel" ext:cls="Ext.grid.GridPanel">colModel</a></tt>
	 * configuration property.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getColumns() {
		if (null != this.columns) {
			return this.columns;
		}
		ValueExpression _ve = getValueExpression("columns");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns(Object columns) {
		this.columns = columns;
		this.handleConfig("columns", columns);
	}

	private String ddGroup;

	/**
	 * The DD group this GridPanel belongs to. Defaultsto <tt>'GridDD'</tt> if not specified.
	 */
	public String getDdGroup() {
		if (null != this.ddGroup) {
			return this.ddGroup;
		}
		ValueExpression _ve = getValueExpression("ddGroup");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>ddGroup</code> property.
	 * </p>
	 */
	public void setDdGroup(String ddGroup) {
		this.ddGroup = ddGroup;
		this.handleConfig("ddGroup", ddGroup);
	}

	private String ddText;

	/**
	 * Configures the text in the drag proxy. Defaultsto:
	 * 
	 * <pre>
	 * &lt;code&gt;ddText : &lt;em&gt;'{0} selected row{1}'&lt;/em&gt;&lt;/code&gt;
	 * </pre>
	 * 
	 * <tt>{0}</tt> is replaced with the number of selected rows.
	 */
	public String getDdText() {
		if (null != this.ddText) {
			return this.ddText;
		}
		ValueExpression _ve = getValueExpression("ddText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>ddText</code> property.
	 * </p>
	 */
	public void setDdText(String ddText) {
		this.ddText = ddText;
		this.handleConfig("ddText", ddText);
	}

	private Boolean deferRowRender;

	/**
	 * <p>
	 * Defaults to <tt>true</tt> to enable deferred row rendering.
	 * </p>
	 * 
	 * <p>
	 * This allows the GridPanel to be initially rendered empty, with the
	 * expensive update of the row structure deferred so that layouts with
	 * GridPanels appear more quickly.
	 * </p>
	 */
	public Boolean getDeferRowRender() {
		if (null != this.deferRowRender) {
			return this.deferRowRender;
		}
		ValueExpression _ve = getValueExpression("deferRowRender");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>deferRowRender</code> property.
	 * </p>
	 */
	public void setDeferRowRender(Boolean deferRowRender) {
		this.deferRowRender = deferRowRender;
		this.handleConfig("deferRowRender", deferRowRender);
	}

	private Boolean disableSelection;

	/**
	 * <p>
	 * <tt>true</tt> to disable selections in the grid. Defaults to
	 * <tt>false</tt>.
	 * </p>
	 * 
	 * <p>
	 * Ignored if a <a
	 * href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-selModel"
	 * ext:member="selModel" ext:cls="Ext.grid.GridPanel">SelectionModel</a> is
	 * specified.
	 * </p>
	 */
	public Boolean getDisableSelection() {
		if (null != this.disableSelection) {
			return this.disableSelection;
		}
		ValueExpression _ve = getValueExpression("disableSelection");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disableSelection</code> property.
	 * </p>
	 */
	public void setDisableSelection(Boolean disableSelection) {
		this.disableSelection = disableSelection;
		this.handleConfig("disableSelection", disableSelection);
	}

	private Boolean enableColumnHide;

	/**
	 * Defaults to <tt>true</tt> to enable hiding ofcolumns with the header
	 * context menu.
	 */
	public Boolean getEnableColumnHide() {
		if (null != this.enableColumnHide) {
			return this.enableColumnHide;
		}
		ValueExpression _ve = getValueExpression("enableColumnHide");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColumnHide</code> property.
	 * </p>
	 */
	public void setEnableColumnHide(Boolean enableColumnHide) {
		this.enableColumnHide = enableColumnHide;
		this.handleConfig("enableColumnHide", enableColumnHide);
	}

	private Boolean enableColumnMove;

	/**
	 * Defaults to <tt>true</tt> to enable drag anddrop reorder of columns.
	 * <tt>false</tt> to turn off column reordering via drag drop.
	 */
	public Boolean getEnableColumnMove() {
		if (null != this.enableColumnMove) {
			return this.enableColumnMove;
		}
		ValueExpression _ve = getValueExpression("enableColumnMove");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColumnMove</code> property.
	 * </p>
	 */
	public void setEnableColumnMove(Boolean enableColumnMove) {
		this.enableColumnMove = enableColumnMove;
		this.handleConfig("enableColumnMove", enableColumnMove);
	}

	private Boolean enableColumnResize;

	/**
	 * <tt>false</tt> to turn off column resizing forthe whole grid. Defaults to
	 * <tt>true</tt>.
	 */
	public Boolean getEnableColumnResize() {
		if (null != this.enableColumnResize) {
			return this.enableColumnResize;
		}
		ValueExpression _ve = getValueExpression("enableColumnResize");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColumnResize</code> property.
	 * </p>
	 */
	public void setEnableColumnResize(Boolean enableColumnResize) {
		this.enableColumnResize = enableColumnResize;
		this.handleConfig("enableColumnResize", enableColumnResize);
	}

	private Boolean enableDragDrop;

	/**
	 * <p>
	 * Enables dragging of the selected rows of the GridPanel. Defaults to
	 * <tt>false</tt>.
	 * </p>
	 * 
	 * <p>
	 * Setting this to <b><tt>true</tt></b> causes this GridPanel's <a
	 * href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-getView"
	 * ext:member="getView" ext:cls="Ext.grid.GridPanel">GridView</a> to create
	 * an instance of <a href="output/Ext.grid.GridDragZone.html"
	 * ext:cls="Ext.grid.GridDragZone">Ext.grid.GridDragZone</a>. <b>Note</b>:
	 * this is available only <b>after</b> the Grid has been rendered as the
	 * GridView's
	 * <tt><a href="output/Ext.grid.GridView.html#Ext.grid.GridView-dragZone" ext:member="dragZone" ext:cls="Ext.grid.GridView">dragZone</a></tt>
	 * property.
	 * </p>
	 * 
	 * <p>
	 * A cooperating <a href="output/Ext.dd.DropZone.html"
	 * ext:cls="Ext.dd.DropZone">DropZone</a> must be created who's
	 * implementations of <a
	 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeEnter"
	 * ext:member="onNodeEnter" ext:cls="Ext.dd.DropZone">onNodeEnter</a>, <a
	 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOver"
	 * ext:member="onNodeOver" ext:cls="Ext.dd.DropZone">onNodeOver</a>, <a
	 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOut"
	 * ext:member="onNodeOut" ext:cls="Ext.dd.DropZone">onNodeOut</a> and <a
	 * href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeDrop"
	 * ext:member="onNodeDrop" ext:cls="Ext.dd.DropZone">onNodeDrop</a> are able
	 * to process the <a href=
	 * "output/Ext.grid.GridDragZone.html#Ext.grid.GridDragZone-getDragData"
	 * ext:member="getDragData" ext:cls="Ext.grid.GridDragZone">data</a> which
	 * is provided.
	 * </p>
	 */
	public Boolean getEnableDragDrop() {
		if (null != this.enableDragDrop) {
			return this.enableDragDrop;
		}
		ValueExpression _ve = getValueExpression("enableDragDrop");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableDragDrop</code> property.
	 * </p>
	 */
	public void setEnableDragDrop(Boolean enableDragDrop) {
		this.enableDragDrop = enableDragDrop;
		this.handleConfig("enableDragDrop", enableDragDrop);
	}

	private Boolean enableHdMenu;

	/**
	 * Defaults to <tt>true</tt> to enable the dropdown button for menu in the
	 * headers.
	 */
	public Boolean getEnableHdMenu() {
		if (null != this.enableHdMenu) {
			return this.enableHdMenu;
		}
		ValueExpression _ve = getValueExpression("enableHdMenu");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableHdMenu</code> property.
	 * </p>
	 */
	public void setEnableHdMenu(Boolean enableHdMenu) {
		this.enableHdMenu = enableHdMenu;
		this.handleConfig("enableHdMenu", enableHdMenu);
	}

	private Boolean hideHeaders;

	/**
	 * True to hide the grid's header. Defaults to<code>false</code>.
	 */
	public Boolean getHideHeaders() {
		if (null != this.hideHeaders) {
			return this.hideHeaders;
		}
		ValueExpression _ve = getValueExpression("hideHeaders");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hideHeaders</code> property.
	 * </p>
	 */
	public void setHideHeaders(Boolean hideHeaders) {
		this.hideHeaders = hideHeaders;
		this.handleConfig("hideHeaders", hideHeaders);
	}

	private Object loadMask;

	/**
	 * An <a href="output/Ext.LoadMask.html"
	 * ext:cls="Ext.LoadMask">Ext.LoadMask</a> config or true to mask thegrid
	 * while loading. Defaults to <code>false</code>.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getLoadMask() {
		if (null != this.loadMask) {
			return this.loadMask;
		}
		ValueExpression _ve = getValueExpression("loadMask");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>loadMask</code> property.
	 * </p>
	 */
	public void setLoadMask(Object loadMask) {
		this.loadMask = loadMask;
		this.handleConfig("loadMask", loadMask);
	}

	private Integer maxHeight;

	/**
	 * Sets the maximum height of the grid - ignored if<tt>autoHeight</tt> is
	 * not on.
	 */
	public Integer getMaxHeight() {
		if (null != this.maxHeight) {
			return this.maxHeight;
		}
		ValueExpression _ve = getValueExpression("maxHeight");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxHeight</code> property.
	 * </p>
	 */
	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
		this.handleConfig("maxHeight", maxHeight);
	}

	private Integer minColumnWidth;

	/**
	 * The minimum width a column can be resized to.Defaults to <tt>25</tt>.
	 */
	public Integer getMinColumnWidth() {
		if (null != this.minColumnWidth) {
			return this.minColumnWidth;
		}
		ValueExpression _ve = getValueExpression("minColumnWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minColumnWidth</code> property.
	 * </p>
	 */
	public void setMinColumnWidth(Integer minColumnWidth) {
		this.minColumnWidth = minColumnWidth;
		this.handleConfig("minColumnWidth", minColumnWidth);
	}

	private Object selModel;

	/**
	 * Any subclass of <a href="output/Ext.grid.AbstractSelectionModel.html"
	 * ext:
	 * cls="Ext.grid.AbstractSelectionModel">Ext.grid.AbstractSelectionModel<
	 * /a>that will provide the selection model for the grid (defaults to <a
	 * href="output/Ext.grid.RowSelectionModel.html"
	 * ext:cls="Ext.grid.RowSelectionModel">Ext.grid.RowSelectionModel</a> if
	 * not specified).
	 */
	@ClientConfig(JsonMode.Object)
	public Object getSelModel() {
		if (null != this.selModel) {
			return this.selModel;
		}
		ValueExpression _ve = getValueExpression("selModel");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>selModel</code> property.
	 * </p>
	 */
	public void setSelModel(Object selModel) {
		this.selModel = selModel;
		this.handleConfig("selModel", selModel);
	}

	private Object sm;

	/**
	 * Shorthand for
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-selModel" ext:member="selModel" ext:cls="Ext.grid.GridPanel">selModel</a></tt>
	 * .
	 */
	@ClientConfig(JsonMode.Object)
	public Object getSm() {
		if (null != this.sm) {
			return this.sm;
		}
		ValueExpression _ve = getValueExpression("sm");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>sm</code> property.
	 * </p>
	 */
	public void setSm(Object sm) {
		this.sm = sm;
		this.handleConfig("sm", sm);
	}

	private Object stateEvents;

	/**
	 * An array of events that, when fired, shouldtrigger this component to save
	 * its state. Defaults to:
	 * 
	 * <pre>
	 * &lt;code&gt;stateEvents: [&lt;em&gt;'columnmove'&lt;/em&gt;, &lt;em&gt;'columnresize'&lt;/em&gt;, &lt;em&gt;'sortchange'&lt;/em&gt;]&lt;/code&gt;
	 * </pre>
	 * 
	 * <p>
	 * These can be any types of events supported by this component, including
	 * browser or custom events (e.g., <tt>['click',
'customerchange']</tt>).
	 * </p>
	 * 
	 * <p>
	 * See <a href="output/Ext.Component.html#Ext.Component-stateful"
	 * ext:member="stateful" ext:cls="Ext.Component">Ext.Component.stateful</a>
	 * for an explanation of saving and restoring Component state.
	 * </p>
	 */
	@ClientConfig(JsonMode.Array)
	public Object getStateEvents() {
		if (null != this.stateEvents) {
			return this.stateEvents;
		}
		ValueExpression _ve = getValueExpression("stateEvents");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>stateEvents</code> property.
	 * </p>
	 */
	public void setStateEvents(Object stateEvents) {
		this.stateEvents = stateEvents;
		this.handleConfig("stateEvents", stateEvents);
	}

	private Object store;

	/**
	 * The <a href="output/Ext.data.Store.html"
	 * ext:cls="Ext.data.Store">Ext.data.Store</a> the grid should use asits
	 * data source (required).
	 */
	@ClientConfig(JsonMode.Object)
	public Object getStore() {
		if (null != this.store) {
			return this.store;
		}
		ValueExpression _ve = getValueExpression("store");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>store</code> property.
	 * </p>
	 */
	public void setStore(Object store) {
		this.store = store;
		this.handleConfig("store", store);
	}

	private Boolean stripeRows;

	/**
	 * <tt>true</tt> to stripe the rows. Default is<tt>false</tt>.
	 * 
	 * <p>
	 * This causes the CSS class <tt><b>x-grid3-row-alt</b></tt> to be added to
	 * alternate rows of the grid. A default CSS rule is provided which sets a
	 * background colour, but you can override this with a rule which either
	 * overrides the <b>background-color</b> style using the '!important'
	 * modifier, or which uses a CSS selector of higher specificity.
	 * </p>
	 */
	public Boolean getStripeRows() {
		if (null != this.stripeRows) {
			return this.stripeRows;
		}
		ValueExpression _ve = getValueExpression("stripeRows");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>stripeRows</code> property.
	 * </p>
	 */
	public void setStripeRows(Boolean stripeRows) {
		this.stripeRows = stripeRows;
		this.handleConfig("stripeRows", stripeRows);
	}

	private Boolean trackMouseOver;

	/**
	 * True to highlight rows when the mouse is over.Default is <tt>true</tt>
	 * for GridPanel, but <tt>false</tt> for EditorGridPanel.
	 */
	public Boolean getTrackMouseOver() {
		if (null != this.trackMouseOver) {
			return this.trackMouseOver;
		}
		ValueExpression _ve = getValueExpression("trackMouseOver");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>trackMouseOver</code> property.
	 * </p>
	 */
	public void setTrackMouseOver(Boolean trackMouseOver) {
		this.trackMouseOver = trackMouseOver;
		this.handleConfig("trackMouseOver", trackMouseOver);
	}

	private Object view;

	/**
	 * The <a href="output/Ext.grid.GridView.html"
	 * ext:cls="Ext.grid.GridView">Ext.grid.GridView</a> used by the grid.This
	 * can be set before a call to <a
	 * href="output/Ext.Component.html#Ext.Component-render" ext:member="render"
	 * ext:cls="Ext.Component">render()</a>.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getView() {
		if (null != this.view) {
			return this.view;
		}
		ValueExpression _ve = getValueExpression("view");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>view</code> property.
	 * </p>
	 */
	public void setView(Object view) {
		this.view = view;
		this.handleConfig("view", view);
	}

	private Object viewConfig;

	/**
	 * A config object that will be applied to thegrid's UI view. Any of the
	 * config options available for <a href="output/Ext.grid.GridView.html"
	 * ext:cls="Ext.grid.GridView">Ext.grid.GridView</a> can be specified here.
	 * This option is ignored if
	 * <tt><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-view" ext:member="view" ext:cls="Ext.grid.GridPanel">view</a></tt>
	 * is specified.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getViewConfig() {
		if (null != this.viewConfig) {
			return this.viewConfig;
		}
		ValueExpression _ve = getValueExpression("viewConfig");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>viewConfig</code> property.
	 * </p>
	 */
	public void setViewConfig(Object viewConfig) {
		this.viewConfig = viewConfig;
		this.handleConfig("viewConfig", viewConfig);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[29];
		}
		_values[0] = super.saveState(_context);
		_values[1] = autoExpandColumn;
		_values[2] = autoExpandMax;
		_values[3] = autoExpandMin;
		_values[4] = cm;
		_values[5] = colModel;
		_values[6] = columnLines;
		_values[7] = columns;
		_values[8] = ddGroup;
		_values[9] = ddText;
		_values[10] = deferRowRender;
		_values[11] = disableSelection;
		_values[12] = enableColumnHide;
		_values[13] = enableColumnMove;
		_values[14] = enableColumnResize;
		_values[15] = enableDragDrop;
		_values[16] = enableHdMenu;
		_values[17] = hideHeaders;
		_values[18] = loadMask;
		_values[19] = maxHeight;
		_values[20] = minColumnWidth;
		_values[21] = selModel;
		_values[22] = sm;
		_values[23] = stateEvents;
		_values[24] = store;
		_values[25] = stripeRows;
		_values[26] = trackMouseOver;
		_values[27] = view;
		_values[28] = viewConfig;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.autoExpandColumn = (String) _values[1];
		this.handleConfig("autoExpandColumn", this.autoExpandColumn);
		this.autoExpandMax = (Integer) _values[2];
		this.handleConfig("autoExpandMax", this.autoExpandMax);
		this.autoExpandMin = (Integer) _values[3];
		this.handleConfig("autoExpandMin", this.autoExpandMin);
		this.cm = (Object) _values[4];
		this.handleConfig("cm", this.cm);
		this.colModel = (Object) _values[5];
		this.handleConfig("colModel", this.colModel);
		this.columnLines = (Boolean) _values[6];
		this.handleConfig("columnLines", this.columnLines);
		this.columns = (Object) _values[7];
		this.handleConfig("columns", this.columns);
		this.ddGroup = (String) _values[8];
		this.handleConfig("ddGroup", this.ddGroup);
		this.ddText = (String) _values[9];
		this.handleConfig("ddText", this.ddText);
		this.deferRowRender = (Boolean) _values[10];
		this.handleConfig("deferRowRender", this.deferRowRender);
		this.disableSelection = (Boolean) _values[11];
		this.handleConfig("disableSelection", this.disableSelection);
		this.enableColumnHide = (Boolean) _values[12];
		this.handleConfig("enableColumnHide", this.enableColumnHide);
		this.enableColumnMove = (Boolean) _values[13];
		this.handleConfig("enableColumnMove", this.enableColumnMove);
		this.enableColumnResize = (Boolean) _values[14];
		this.handleConfig("enableColumnResize", this.enableColumnResize);
		this.enableDragDrop = (Boolean) _values[15];
		this.handleConfig("enableDragDrop", this.enableDragDrop);
		this.enableHdMenu = (Boolean) _values[16];
		this.handleConfig("enableHdMenu", this.enableHdMenu);
		this.hideHeaders = (Boolean) _values[17];
		this.handleConfig("hideHeaders", this.hideHeaders);
		this.loadMask = (Object) _values[18];
		this.handleConfig("loadMask", this.loadMask);
		this.maxHeight = (Integer) _values[19];
		this.handleConfig("maxHeight", this.maxHeight);
		this.minColumnWidth = (Integer) _values[20];
		this.handleConfig("minColumnWidth", this.minColumnWidth);
		this.selModel = (Object) _values[21];
		this.handleConfig("selModel", this.selModel);
		this.sm = (Object) _values[22];
		this.handleConfig("sm", this.sm);
		this.stateEvents = (Object) _values[23];
		this.handleConfig("stateEvents", this.stateEvents);
		this.store = (Object) _values[24];
		this.handleConfig("store", this.store);
		this.stripeRows = (Boolean) _values[25];
		this.handleConfig("stripeRows", this.stripeRows);
		this.trackMouseOver = (Boolean) _values[26];
		this.handleConfig("trackMouseOver", this.trackMouseOver);
		this.view = (Object) _values[27];
		this.handleConfig("view", this.view);
		this.viewConfig = (Object) _values[28];
		this.handleConfig("viewConfig", this.viewConfig);

	}
}