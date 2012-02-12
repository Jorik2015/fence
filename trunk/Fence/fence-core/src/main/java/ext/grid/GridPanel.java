package ext.grid;

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
    <p>This class represents the primary interface of a component
    based grid control to represent data in a tabular format of
    rows and columns. The GridPanel is composed of the
    following:</p>
    <div class="mdetail-params">
      <ul>
        <li>
        <b>
          <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a>
        </b> : The Model holding the data records (rows)</li>
        <li>
        <b>
          <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">Column model</a>
        </b> : Column makeup</li>
        <li>
        <b>
          <a ext:cls="Ext.grid.GridView" href="output/Ext.grid.GridView.html">View</a>
        </b> : Encapsulates the user interface</li>
        <li>
        <b>
          <a ext:cls="Ext.grid.AbstractSelectionModel" href="output/Ext.grid.AbstractSelectionModel.html">selection
          model</a>
        </b> : Selection behavior</li>
      </ul>
    </div>
    <p>Example usage:</p>
<pre>
<code>
<b>var</b> grid = 
<b>new</b> Ext.grid.GridPanel({
    
<a ext:cls="Ext.grid.GridPanel" ext:member="store" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-store">store</a>: 
<b>new</b> 
<a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>({
        
<a ext:cls="Ext.data.Store" ext:member="autoDestroy" href="output/Ext.data.Store.html#Ext.data.Store-autoDestroy">autoDestroy</a>:
true,
        
<a ext:cls="Ext.data.Store" ext:member="reader" href="output/Ext.data.Store.html#Ext.data.Store-reader">reader</a>: reader,
        
<a ext:cls="Ext.data.Store" ext:member="data" href="output/Ext.data.Store.html#Ext.data.Store-data">data</a>: xg.dummyData
    }),
    
<a ext:cls="Ext.grid.GridPanel" ext:member="colModel" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-colModel">colModel</a>: 
<b>new</b> 
<a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">Ext.grid.ColumnModel</a>({
        
<a ext:cls="Ext.grid.ColumnModel" ext:member="defaults" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-defaults">defaults</a>:
{
            width: 120,
            sortable: true
        },
        
<a ext:cls="Ext.grid.ColumnModel" ext:member="columns" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-columns">columns</a>: [
            {id: 
<em>'company'</em>, header: 
<em>'Company'</em>, width: 200, sortable: true, dataIndex: 
<em>'company'</em>},
            {header: 
<em>'Price'</em>, renderer: Ext.util.Format.usMoney, dataIndex: 
<em>'price'</em>},
            {header: 
<em>'Change'</em>, dataIndex: 
<em>'change'</em>},
            {header: 
<em>'% Change'</em>, dataIndex: 
<em>'pctChange'</em>},
            
<i>// instead of specifying renderer: Ext.util.Format.dateRenderer(
<em>'m/d/Y'</em>) use xtype</i>
            {
                header: 
<em>'Last Updated'</em>, width: 135, dataIndex: 
<em>'lastChange'</em>,
                xtype: 
<em>'datecolumn'</em>, format: 
<em>'M d, Y'</em>
            }
        ]
    }),
    
<a ext:cls="Ext.grid.GridPanel" ext:member="viewConfig" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-viewConfig">viewConfig</a>: {
        
<a ext:cls="Ext.grid.GridView" ext:member="forceFit" href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit">forceFit</a>:
true,

<i>//      Return CSS class to apply to rows depending upon data
values</i>
        
<a ext:cls="Ext.grid.GridView" ext:member="getRowClass" href="output/Ext.grid.GridView.html#Ext.grid.GridView-getRowClass">getRowClass</a>: 
<b>function</b>(record, index) {
            
<b>var</b> c = record.
<a ext:cls="Ext.data.Record" ext:member="get" href="output/Ext.data.Record.html#Ext.data.Record-get">get</a>(
<em>'change'</em>);
            
<b>if</b> (c &lt; 0) {
                
<b>return</b> 
<em>'price-fall'</em>;
            } 
<b>else</b> 
<b>if</b> (c &gt; 0) {
                
<b>return</b> 
<em>'price-rise'</em>;
            }
        }
    },
    
<a ext:cls="Ext.grid.GridPanel" ext:member="sm" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-sm">sm</a>: 
<b>new</b> Ext.grid.RowSelectionModel({singleSelect:true}),
    width: 600,
    height: 300,
    frame: true,
    title: 
<em>'Framed 
<b>with</b> Row Selection and Horizontal Scrolling'</em>,
    iconCls: 
<em>'icon-grid'</em>
});</code>
    </pre>
    <p>
      <b>
        <u>Notes:</u>
      </b>
    </p>
    <div class="mdetail-params">
      <ul>
        <li>Although this class inherits many configuration options
        from base classes, some of them (such as autoScroll,
        autoWidth, layout, items, etc) are not used by this class,
        and will have no effect.</li>
        <li>A grid 
        <b>requires</b> a width in which to scroll its columns, and
        a height in which to scroll its rows. These dimensions can
        either be set explicitly through the 
        <tt>
          <a ext:cls="Ext.BoxComponent" ext:member="height" href="output/Ext.BoxComponent.html#Ext.BoxComponent-height">height</a>
        </tt> and 
        <tt>
          <a ext:cls="Ext.BoxComponent" ext:member="width" href="output/Ext.BoxComponent.html#Ext.BoxComponent-width">width</a>
        </tt> configuration options or implicitly set by using the
        grid as a child item of a 
        <a ext:cls="Ext.Container" href="output/Ext.Container.html">Container</a> which will have a 
        <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout
        manager</a> provide the sizing of its child items (for
        example the Container of the Grid may specify 
        <tt>
        <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>:'fit'</tt>).</li>
        <li>To access the data in a Grid, it is necessary to use
        the data model encapsulated by the 
        <a ext:cls="Ext.grid.GridPanel" ext:member="store" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-store">Store</a>.
        See the 
        <a ext:cls="Ext.grid.GridPanel" ext:member="cellclick" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-cellclick">cellclick</a> event for more
        details.</li>
      </ul>
    </div>
  </div>

 */
@XType("grid")
@InstanceOf("Ext.grid.GridPanel")

@FacesComponent(value = "Ext.grid.GridPanel")
public class GridPanel extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.grid.GridPanel";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.GridPanel} instance with default property values.
	 * </p>
	 */
	public GridPanel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			trackMouseOver
			,store
			,columns
			,autoExpandMax
			,enableColumnMove
			,columnLines
			,minColumnWidth
			,enableColumnHide
			,deferRowRender
			,stateEvents
			,disableSelection
			,colModel
			,autoExpandColumn
			,bubbleEvents
			,hideHeaders
			,loadMask
			,sm
			,ddText
			,stripeRows
			,ddGroup
			,enableHdMenu
			,cm
			,autoExpandMin
			,maxHeight
			,enableColumnResize
			,enableDragDrop
			,selModel
			,view
			,viewConfig
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
	 *
        
        
          trackMouseOver
         : Boolean
        True to highlight rows when the mouse is
        over. Default is 
        true for GridPanel, but 
        false for EditorGridPanel.
	 */
	
	public Boolean getTrackMouseOver () {
		return (Boolean) getStateHelper().eval(PropertyKeys.trackMouseOver);
	}

	/**
	 * <p>
	 * Set the value of the <code>trackMouseOver</code> property.
	 * </p>
	 */
	public void setTrackMouseOver ( Boolean   trackMouseOver ) {
		getStateHelper().put(PropertyKeys.trackMouseOver, trackMouseOver);
		handleAttribute("trackMouseOver", trackMouseOver);
	}
    	/*
	 *
        
        
          store
         : Ext.data.Store
        The 
        Ext.data.Store the grid should
        use as its data source (required).
	 */
	@ClientConfig(JsonMode.Object)

	public Object getStore () {
		return (Object) getStateHelper().eval(PropertyKeys.store);
	}

	/**
	 * <p>
	 * Set the value of the <code>store</code> property.
	 * </p>
	 */
	public void setStore ( Object   store ) {
		getStateHelper().put(PropertyKeys.store, store);
		handleAttribute("store", store);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array of 
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">columns</a> to auto create a 
          <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">Ext.grid.ColumnModel</a>.
          The ColumnModel may be explicitly created via the 
          <tt>
            <a ext:cls="Ext.grid.GridPanel" ext:member="colModel" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-colModel">colModel</a>
          </tt> configuration property.</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getColumns () {
		return (Object) getStateHelper().eval(PropertyKeys.columns);
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns ( Object   columns ) {
		getStateHelper().put(PropertyKeys.columns, columns);
		handleAttribute("columns", columns);
	}
    	/*
	 *
        
        
          autoExpandMax
         : Number
        The maximum width the 
        
          autoExpandColumn
         can have (if enabled). Defaults to 
        1000.
	 */
	
	public Integer getAutoExpandMax () {
		return (Integer) getStateHelper().eval(PropertyKeys.autoExpandMax);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoExpandMax</code> property.
	 * </p>
	 */
	public void setAutoExpandMax ( Integer   autoExpandMax ) {
		getStateHelper().put(PropertyKeys.autoExpandMax, autoExpandMax);
		handleAttribute("autoExpandMax", autoExpandMax);
	}
    	/*
	 *
        
        
          enableColumnMove
         : Boolean
        Defaults to 
        true to enable drag and drop reorder of columns. 
        false to turn off column reordering via drag
        drop.
	 */
	
	public Boolean getEnableColumnMove () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableColumnMove);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColumnMove</code> property.
	 * </p>
	 */
	public void setEnableColumnMove ( Boolean   enableColumnMove ) {
		getStateHelper().put(PropertyKeys.enableColumnMove, enableColumnMove);
		handleAttribute("enableColumnMove", enableColumnMove);
	}
    	/*
	 *
        
        
          columnLines
         : Boolean
        
        true to add css for column separation lines.
        Default is 
        false.
	 */
	
	public Boolean getColumnLines () {
		return (Boolean) getStateHelper().eval(PropertyKeys.columnLines);
	}

	/**
	 * <p>
	 * Set the value of the <code>columnLines</code> property.
	 * </p>
	 */
	public void setColumnLines ( Boolean   columnLines ) {
		getStateHelper().put(PropertyKeys.columnLines, columnLines);
		handleAttribute("columnLines", columnLines);
	}
    	/*
	 *
        
        
          minColumnWidth
         : Number
        The minimum width a column can be
        resized to. Defaults to 
        25.
	 */
	
	public Integer getMinColumnWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minColumnWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minColumnWidth</code> property.
	 * </p>
	 */
	public void setMinColumnWidth ( Integer   minColumnWidth ) {
		getStateHelper().put(PropertyKeys.minColumnWidth, minColumnWidth);
		handleAttribute("minColumnWidth", minColumnWidth);
	}
    	/*
	 *
        
        
          enableColumnHide
         : Boolean
        Defaults to 
        true to enable 
        hiding of
        columns with the 
        header menu.
	 */
	
	public Boolean getEnableColumnHide () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableColumnHide);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColumnHide</code> property.
	 * </p>
	 */
	public void setEnableColumnHide ( Boolean   enableColumnHide ) {
		getStateHelper().put(PropertyKeys.enableColumnHide, enableColumnHide);
		handleAttribute("enableColumnHide", enableColumnHide);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Defaults to 
            <tt>true</tt> to enable deferred row rendering.</p>
            <p>This allows the GridPanel to be initially rendered
            empty, with the expensive update of the row structure
            deferred so that layouts with GridPanels appear more
            quickly.</p>
          </div>

	 */
	
	public Boolean getDeferRowRender () {
		return (Boolean) getStateHelper().eval(PropertyKeys.deferRowRender);
	}

	/**
	 * <p>
	 * Set the value of the <code>deferRowRender</code> property.
	 * </p>
	 */
	public void setDeferRowRender ( Boolean   deferRowRender ) {
		getStateHelper().put(PropertyKeys.deferRowRender, deferRowRender);
		handleAttribute("deferRowRender", deferRowRender);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array of events that, when fired,
          should trigger this component to save its state. Defaults
          to:
<pre>
<code>stateEvents: [
<em>'columnmove'</em>, 
<em>'columnresize'</em>, 
<em>'sortchange'</em>, 
<em>'groupchange'</em>]</code>
          </pre>
          <p>These can be any types of events supported by this
          component, including browser or custom events (e.g., 
          <tt>['click', 'customerchange']</tt>).</p>
          <p>See 
          <a ext:cls="Ext.Component" ext:member="stateful" href="output/Ext.Component.html#Ext.Component-stateful">Ext.Component.stateful</a> for an
          explanation of saving and restoring Component
          state.</p>
</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getStateEvents () {
		return (Object) getStateHelper().eval(PropertyKeys.stateEvents);
	}

	/**
	 * <p>
	 * Set the value of the <code>stateEvents</code> property.
	 * </p>
	 */
	public void setStateEvents ( Object   stateEvents ) {
		getStateHelper().put(PropertyKeys.stateEvents, stateEvents);
		handleAttribute("stateEvents", stateEvents);
	}
    	/*
	 *
        
        
          disableSelection
         : Boolean
        
          
          true to disable selections in the grid. Defaults
          to 
          false.
          Ignored if a 
          SelectionModel is
          specified.
        
	 */
	
	public Boolean getDisableSelection () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disableSelection);
	}

	/**
	 * <p>
	 * Set the value of the <code>disableSelection</code> property.
	 * </p>
	 */
	public void setDisableSelection ( Boolean   disableSelection ) {
		getStateHelper().put(PropertyKeys.disableSelection, disableSelection);
		handleAttribute("disableSelection", disableSelection);
	}
    	/*
	 *
        
        
          colModel
         : Object
        The 
        Ext.grid.ColumnModel to
        use when rendering the grid (required).
	 */
	@ClientConfig(JsonMode.Object)

	public Object getColModel () {
		return (Object) getStateHelper().eval(PropertyKeys.colModel);
	}

	/**
	 * <p>
	 * Set the value of the <code>colModel</code> property.
	 * </p>
	 */
	public void setColModel ( Object   colModel ) {
		getStateHelper().put(PropertyKeys.colModel, colModel);
		handleAttribute("colModel", colModel);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The 
            <tt>
              <a ext:cls="Ext.grid.Column" ext:member="id" href="output/Ext.grid.Column.html#Ext.grid.Column-id">id</a>
            </tt> of a 
            <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">column</a> in this grid that
            should expand to fill unused space. This value
            specified here can not be 
            <tt>0</tt>.</p>
            <br/>
            <p>
            <b>Note</b>: If the Grid's 
            <a ext:cls="Ext.grid.GridView" href="output/Ext.grid.GridView.html">view</a> is configured with
            
            <tt>
            <a ext:cls="Ext.grid.GridView" ext:member="forceFit" href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit">forceFit</a>=true</tt> the 
            <tt>autoExpandColumn</tt> is ignored. See 
            <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a>.
            <tt>
              <a ext:cls="Ext.grid.Column" ext:member="width" href="output/Ext.grid.Column.html#Ext.grid.Column-width">width</a>
            </tt> for additional details.</p>
            <p>See 
            <tt>
              <a ext:cls="Ext.grid.GridPanel" ext:member="autoExpandMax" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandMax">autoExpandMax</a>
            </tt> and 
            <tt>
              <a ext:cls="Ext.grid.GridPanel" ext:member="autoExpandMin" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandMin">autoExpandMin</a>
            </tt> also.</p>
          </div>

	 */
	
	public String getAutoExpandColumn () {
		return (String) getStateHelper().eval(PropertyKeys.autoExpandColumn);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoExpandColumn</code> property.
	 * </p>
	 */
	public void setAutoExpandColumn ( String   autoExpandColumn ) {
		getStateHelper().put(PropertyKeys.autoExpandColumn, autoExpandColumn);
		handleAttribute("autoExpandColumn", autoExpandColumn);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An array of events that, when fired, should be
            bubbled to any parent container. See 
            <a ext:cls="Ext.util.Observable" ext:member="enableBubble" href="output/Ext.util.Observable.html#Ext.util.Observable-enableBubble">Ext.util.Observable.enableBubble</a>.
            Defaults to 
            <tt>[]</tt>.</p>
          </div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getBubbleEvents () {
		return (Object) getStateHelper().eval(PropertyKeys.bubbleEvents);
	}

	/**
	 * <p>
	 * Set the value of the <code>bubbleEvents</code> property.
	 * </p>
	 */
	public void setBubbleEvents ( Object   bubbleEvents ) {
		getStateHelper().put(PropertyKeys.bubbleEvents, bubbleEvents);
		handleAttribute("bubbleEvents", bubbleEvents);
	}
    	/*
	 *
        
        
          hideHeaders
         : Boolean
        True to hide the grid's header. Defaults
        to 
        false.
	 */
	
	public Boolean getHideHeaders () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideHeaders);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideHeaders</code> property.
	 * </p>
	 */
	public void setHideHeaders ( Boolean   hideHeaders ) {
		getStateHelper().put(PropertyKeys.hideHeaders, hideHeaders);
		handleAttribute("hideHeaders", hideHeaders);
	}
    	/*
	 *
        
        
          loadMask
         : Object
        An 
        Ext.LoadMask config or true to
        mask the grid while loading. Defaults to 
        false.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getLoadMask () {
		return (Object) getStateHelper().eval(PropertyKeys.loadMask);
	}

	/**
	 * <p>
	 * Set the value of the <code>loadMask</code> property.
	 * </p>
	 */
	public void setLoadMask ( Object   loadMask ) {
		getStateHelper().put(PropertyKeys.loadMask, loadMask);
		handleAttribute("loadMask", loadMask);
	}
    	/*
	 *
        
        
          sm
         : Object
        Shorthand for 
        
          selModel
        .
	 */
	@ClientConfig(JsonMode.Object)

	public Object getSm () {
		return (Object) getStateHelper().eval(PropertyKeys.sm);
	}

	/**
	 * <p>
	 * Set the value of the <code>sm</code> property.
	 * </p>
	 */
	public void setSm ( Object   sm ) {
		getStateHelper().put(PropertyKeys.sm, sm);
		handleAttribute("sm", sm);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Configures the text in the drag proxy.
          Defaults to: 
<pre>
<code>ddText : 
<em>'{0} selected row{1}'</em>
</code>
          </pre>
          <tt>{0}</tt> is replaced with the number of selected
          rows.</div>

	 */
	
	public String getDdText () {
		return (String) getStateHelper().eval(PropertyKeys.ddText);
	}

	/**
	 * <p>
	 * Set the value of the <code>ddText</code> property.
	 * </p>
	 */
	public void setDdText ( String   ddText ) {
		getStateHelper().put(PropertyKeys.ddText, ddText);
		handleAttribute("ddText", ddText);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to stripe the rows. Default is 
          <tt>false</tt>. 
          <p>This causes the CSS class 
          <tt>
            <b>x-grid3-row-alt</b>
          </tt> to be added to alternate rows of the grid. A
          default CSS rule is provided which sets a background
          colour, but you can override this with a rule which
          either overrides the 
          <b>background-color</b> style using the '!important'
          modifier, or which uses a CSS selector of higher
          specificity.</p>
</div>

	 */
	
	public Boolean getStripeRows () {
		return (Boolean) getStateHelper().eval(PropertyKeys.stripeRows);
	}

	/**
	 * <p>
	 * Set the value of the <code>stripeRows</code> property.
	 * </p>
	 */
	public void setStripeRows ( Boolean   stripeRows ) {
		getStateHelper().put(PropertyKeys.stripeRows, stripeRows);
		handleAttribute("stripeRows", stripeRows);
	}
    	/*
	 *
        
        
          ddGroup
         : String
        The DD group this GridPanel belongs to.
        Defaults to 
        'GridDD' if not specified.
	 */
	
	public String getDdGroup () {
		return (String) getStateHelper().eval(PropertyKeys.ddGroup);
	}

	/**
	 * <p>
	 * Set the value of the <code>ddGroup</code> property.
	 * </p>
	 */
	public void setDdGroup ( String   ddGroup ) {
		getStateHelper().put(PropertyKeys.ddGroup, ddGroup);
		handleAttribute("ddGroup", ddGroup);
	}
    	/*
	 *
        
        
          enableHdMenu
         : Boolean
        Defaults to 
        true to enable the drop down button for menu in
        the headers.
	 */
	
	public Boolean getEnableHdMenu () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableHdMenu);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableHdMenu</code> property.
	 * </p>
	 */
	public void setEnableHdMenu ( Boolean   enableHdMenu ) {
		getStateHelper().put(PropertyKeys.enableHdMenu, enableHdMenu);
		handleAttribute("enableHdMenu", enableHdMenu);
	}
    	/*
	 *
        
        
          cm
         : Object
        Shorthand for 
        
          colModel
        .
	 */
	@ClientConfig(JsonMode.Object)

	public Object getCm () {
		return (Object) getStateHelper().eval(PropertyKeys.cm);
	}

	/**
	 * <p>
	 * Set the value of the <code>cm</code> property.
	 * </p>
	 */
	public void setCm ( Object   cm ) {
		getStateHelper().put(PropertyKeys.cm, cm);
		handleAttribute("cm", cm);
	}
    	/*
	 *
        
        
          autoExpandMin
         : Number
        The minimum width the 
        
          autoExpandColumn
         can have (if enabled). Defaults to 
        50.
	 */
	
	public Integer getAutoExpandMin () {
		return (Integer) getStateHelper().eval(PropertyKeys.autoExpandMin);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoExpandMin</code> property.
	 * </p>
	 */
	public void setAutoExpandMin ( Integer   autoExpandMin ) {
		getStateHelper().put(PropertyKeys.autoExpandMin, autoExpandMin);
		handleAttribute("autoExpandMin", autoExpandMin);
	}
    	/*
	 *
        
        
          maxHeight
         : Number
        Sets the maximum height of the grid -
        ignored if 
        autoHeight is not on.
	 */
	
	public Integer getMaxHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxHeight</code> property.
	 * </p>
	 */
	public void setMaxHeight ( Integer   maxHeight ) {
		getStateHelper().put(PropertyKeys.maxHeight, maxHeight);
		handleAttribute("maxHeight", maxHeight);
	}
    	/*
	 *
        
        
          enableColumnResize
         : Boolean
        
        false to turn off column resizing for the whole
        grid. Defaults to 
        true.
	 */
	
	public Boolean getEnableColumnResize () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableColumnResize);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableColumnResize</code> property.
	 * </p>
	 */
	public void setEnableColumnResize ( Boolean   enableColumnResize ) {
		getStateHelper().put(PropertyKeys.enableColumnResize, enableColumnResize);
		handleAttribute("enableColumnResize", enableColumnResize);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Enables dragging of the selected rows of the
            GridPanel. Defaults to 
            <tt>false</tt>.</p>
            <p>Setting this to 
            <b>
              <tt>true</tt>
            </b> causes this GridPanel's 
            <a ext:cls="Ext.grid.GridPanel" ext:member="getView" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-getView">GridView</a> to create an
            instance of 
            <a ext:cls="Ext.grid.GridDragZone" href="output/Ext.grid.GridDragZone.html">Ext.grid.GridDragZone</a>.
            
            <b>Note</b>: this is available only 
            <b>after</b> the Grid has been rendered as the
            GridView's 
            <tt>
              <a ext:cls="Ext.grid.GridView" ext:member="dragZone" href="output/Ext.grid.GridView.html#Ext.grid.GridView-dragZone">dragZone</a>
            </tt> property.</p>
            <p>A cooperating 
            <a ext:cls="Ext.dd.DropZone" href="output/Ext.dd.DropZone.html">DropZone</a> must be created
            who's implementations of 
            <a ext:cls="Ext.dd.DropZone" ext:member="onNodeEnter" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeEnter">onNodeEnter</a>, 
            <a ext:cls="Ext.dd.DropZone" ext:member="onNodeOver" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOver">onNodeOver</a>, 
            <a ext:cls="Ext.dd.DropZone" ext:member="onNodeOut" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeOut">onNodeOut</a> and 
            <a ext:cls="Ext.dd.DropZone" ext:member="onNodeDrop" href="output/Ext.dd.DropZone.html#Ext.dd.DropZone-onNodeDrop">onNodeDrop</a> are able to
            process the 
            <a ext:cls="Ext.grid.GridDragZone" ext:member="getDragData" href="output/Ext.grid.GridDragZone.html#Ext.grid.GridDragZone-getDragData">data</a> which is
            provided.</p>
          </div>

	 */
	
	public Boolean getEnableDragDrop () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableDragDrop);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableDragDrop</code> property.
	 * </p>
	 */
	public void setEnableDragDrop ( Boolean   enableDragDrop ) {
		getStateHelper().put(PropertyKeys.enableDragDrop, enableDragDrop);
		handleAttribute("enableDragDrop", enableDragDrop);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Any subclass of 
          <a ext:cls="Ext.grid.AbstractSelectionModel" href="output/Ext.grid.AbstractSelectionModel.html">Ext.grid.AbstractSelectionModel</a>
          that will provide the selection model for the grid
          (defaults to 
          <a ext:cls="Ext.grid.RowSelectionModel" href="output/Ext.grid.RowSelectionModel.html">Ext.grid.RowSelectionModel</a>
          if not specified).</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getSelModel () {
		return (Object) getStateHelper().eval(PropertyKeys.selModel);
	}

	/**
	 * <p>
	 * Set the value of the <code>selModel</code> property.
	 * </p>
	 */
	public void setSelModel ( Object   selModel ) {
		getStateHelper().put(PropertyKeys.selModel, selModel);
		handleAttribute("selModel", selModel);
	}
    	/*
	 *
        
        
          view
         : Object
        The 
        Ext.grid.GridView used by
        the grid. This can be set before a call to 
        render().
	 */
	@ClientConfig(JsonMode.Object)

	public Object getView () {
		return (Object) getStateHelper().eval(PropertyKeys.view);
	}

	/**
	 * <p>
	 * Set the value of the <code>view</code> property.
	 * </p>
	 */
	public void setView ( Object   view ) {
		getStateHelper().put(PropertyKeys.view, view);
		handleAttribute("view", view);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A config object that will be applied to
          the grid's UI view. Any of the config options available
          for 
          <a ext:cls="Ext.grid.GridView" href="output/Ext.grid.GridView.html">Ext.grid.GridView</a> can be
          specified here. This option is ignored if 
          <tt>
            <a ext:cls="Ext.grid.GridPanel" ext:member="view" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-view">view</a>
          </tt> is specified.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getViewConfig () {
		return (Object) getStateHelper().eval(PropertyKeys.viewConfig);
	}

	/**
	 * <p>
	 * Set the value of the <code>viewConfig</code> property.
	 * </p>
	 */
	public void setViewConfig ( Object   viewConfig ) {
		getStateHelper().put(PropertyKeys.viewConfig, viewConfig);
		handleAttribute("viewConfig", viewConfig);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "bodyscroll"
					, "cellclick"
					, "cellcontextmenu"
					, "celldblclick"
					, "cellmousedown"
					, "click"
					, "columnmove"
					, "columnresize"
					, "containerclick"
					, "containercontextmenu"
					, "containerdblclick"
					, "containermousedown"
					, "contextmenu"
					, "dblclick"
					, "groupchange"
					, "groupclick"
					, "groupcontextmenu"
					, "groupdblclick"
					, "groupmousedown"
					, "headerclick"
					, "headercontextmenu"
					, "headerdblclick"
					, "headermousedown"
					, "keydown"
					, "keypress"
					, "mousedown"
					, "mouseout"
					, "mouseover"
					, "mouseup"
					, "reconfigure"
					, "rowbodyclick"
					, "rowbodycontextmenu"
					, "rowbodydblclick"
					, "rowbodymousedown"
					, "rowclick"
					, "rowcontextmenu"
					, "rowdblclick"
					, "rowmousedown"
					, "sortchange"
					, "viewready"
				));
				return superEvent;
	}
}