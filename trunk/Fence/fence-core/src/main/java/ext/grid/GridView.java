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
    <p>This class encapsulates the user interface of an 
    <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">Ext.grid.GridPanel</a>. Methods of
    this class may be used to access user interface elements to
    enable special display effects. Do not change the DOM structure
    of the user interface.</p>
    <p>This class does not provide ways to manipulate the
    underlying data. The data model of a Grid is held in an 
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>.</p>
  </div>

 */

@InstanceOf("Ext.grid.GridView")
@ParseConfigMode(ui = false,name="view",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.GridView")
public class GridView extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.grid.GridView";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.GridView} instance with default property values.
	 * </p>
	 */
	public GridView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			sortAscText
			,enableRowBody
			,autoFill
			,rowBodySelector
			,selectedRowClass
			,headersDisabled
			,markDirty
			,emptyText
			,rowSelectorDepth
			,forceFit
			,rowBodySelectorDepth
			,headerMenuOpenCls
			,sortClasses
			,sortDescText
			,columnsText
			,cellSelector
			,cellSelectorDepth
			,rowOverCls
			,scrollOffset
			,rowSelector
			,deferEmptyText
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
        
        
          sortAscText
         : String
        The text displayed in the 'Sort
        Ascending' menu item (defaults to 
        'Sort Ascending')
	 */
	
	public String getSortAscText () {
		return (String) getStateHelper().eval(PropertyKeys.sortAscText);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortAscText</code> property.
	 * </p>
	 */
	public void setSortAscText ( String   sortAscText ) {
		getStateHelper().put(PropertyKeys.sortAscText, sortAscText);
		handleAttribute("sortAscText", sortAscText);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to add a second TR element per row
          that can be used to provide a row body that spans beneath
          the data row. Use the 
          <a ext:cls="Ext.grid.GridView" ext:member="getRowClass" href="output/Ext.grid.GridView.html#Ext.grid.GridView-getRowClass">getRowClass</a> method's
          rowParams config to customize the row body.</div>

	 */
	
	public Boolean getEnableRowBody () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableRowBody);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableRowBody</code> property.
	 * </p>
	 */
	public void setEnableRowBody ( Boolean   enableRowBody ) {
		getStateHelper().put(PropertyKeys.enableRowBody, enableRowBody);
		handleAttribute("enableRowBody", enableRowBody);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Defaults to 
          <tt>false</tt>. Specify 
          <tt>true</tt> to have the column widths re-proportioned
          when the grid is 
          <b>initially rendered</b>. The 
          <a ext:cls="Ext.grid.Column" ext:member="width" href="output/Ext.grid.Column.html#Ext.grid.Column-width">initially
          configured width</a> of each column will be adjusted to
          fit the grid width and prevent horizontal scrolling. If
          columns are later resized (manually or programmatically),
          the other columns in the grid will 
          <b>not</b> be resized to fit the grid width. See 
          <tt>
            <a ext:cls="Ext.grid.GridView" ext:member="forceFit" href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit">forceFit</a>
          </tt> also.</div>

	 */
	
	public Boolean getAutoFill () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoFill);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoFill</code> property.
	 * </p>
	 */
	public void setAutoFill ( Boolean   autoFill ) {
		getStateHelper().put(PropertyKeys.autoFill, autoFill);
		handleAttribute("autoFill", autoFill);
	}
    	/*
	 *
        
        
          rowBodySelector
         : String
        The selector used to find row bodies
        internally (defaults to 
        'div.x-grid3-row')
	 */
	
	public String getRowBodySelector () {
		return (String) getStateHelper().eval(PropertyKeys.rowBodySelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>rowBodySelector</code> property.
	 * </p>
	 */
	public void setRowBodySelector ( String   rowBodySelector ) {
		getStateHelper().put(PropertyKeys.rowBodySelector, rowBodySelector);
		handleAttribute("rowBodySelector", rowBodySelector);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The CSS class applied to a selected row
          (defaults to 
          <tt>'x-grid3-row-selected'</tt>). An example overriding
          the default styling: 
<pre>
<code>.x-grid3-row-selected {background-color: yellow;}</code>
          </pre>Note that this only controls the row, and will not
          do anything for the text inside it. To style inner facets
          (like text) use something like: 
<pre>
<code>.x-grid3-row-selected .x-grid3-cell-inner {
        color: #FFCC00;
    }</code>
          </pre>
</div>

	 */
	
	public String getSelectedRowClass () {
		return (String) getStateHelper().eval(PropertyKeys.selectedRowClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>selectedRowClass</code> property.
	 * </p>
	 */
	public void setSelectedRowClass ( String   selectedRowClass ) {
		getStateHelper().put(PropertyKeys.selectedRowClass, selectedRowClass);
		handleAttribute("selectedRowClass", selectedRowClass);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to disable the grid column headers
          (defaults to 
          <tt>false</tt>). Use the 
          <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">ColumnModel</a> 
          <tt>
            <a ext:cls="Ext.grid.ColumnModel" ext:member="menuDisabled" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-menuDisabled">menuDisabled</a>
          </tt> config to disable the 
          <i>menu</i> for individual columns. While this config is
          true the following will be disabled:
          <div class="mdetail-params">
            <ul>
              <li>clicking on header to sort</li>
              <li>the trigger to reveal the menu.</li>
            </ul>
          </div>
</div>

	 */
	
	public Boolean getHeadersDisabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.headersDisabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>headersDisabled</code> property.
	 * </p>
	 */
	public void setHeadersDisabled ( Boolean   headersDisabled ) {
		getStateHelper().put(PropertyKeys.headersDisabled, headersDisabled);
		handleAttribute("headersDisabled", headersDisabled);
	}
    	/*
	 *
        
        
          markDirty
         : Boolean
        True to show the dirty cell indicator
        when a cell has been modified. Defaults to 
        true.
	 */
	
	public Boolean getMarkDirty () {
		return (Boolean) getStateHelper().eval(PropertyKeys.markDirty);
	}

	/**
	 * <p>
	 * Set the value of the <code>markDirty</code> property.
	 * </p>
	 */
	public void setMarkDirty ( Boolean   markDirty ) {
		getStateHelper().put(PropertyKeys.markDirty, markDirty);
		handleAttribute("markDirty", markDirty);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Default text (html tags are accepted)
          to display in the grid body when no rows are available
          (defaults to ''). This value will be used to update the 
          <tt>
            <a ext:cls="Ext.grid.GridView" ext:member="mainBody" href="output/Ext.grid.GridView.html#Ext.grid.GridView-mainBody">mainBody</a>
          </tt>: 
<pre>
<code>this.mainBody.update(
<em>'&lt;div class=</em>"x-grid-empty"</code>&gt;' + this.emptyText
+ 
<em>'&lt;/div&gt;'</em>);
          </pre>
</div>

	 */
	
	public String getEmptyText () {
		return (String) getStateHelper().eval(PropertyKeys.emptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyText</code> property.
	 * </p>
	 */
	public void setEmptyText ( String   emptyText ) {
		getStateHelper().put(PropertyKeys.emptyText, emptyText);
		handleAttribute("emptyText", emptyText);
	}
    	/*
	 *
        
        
          rowSelectorDepth
         : Number
        The number of levels to search for rows
        in event delegation (defaults to 
        10)
	 */
	
	public Integer getRowSelectorDepth () {
		return (Integer) getStateHelper().eval(PropertyKeys.rowSelectorDepth);
	}

	/**
	 * <p>
	 * Set the value of the <code>rowSelectorDepth</code> property.
	 * </p>
	 */
	public void setRowSelectorDepth ( Integer   rowSelectorDepth ) {
		getStateHelper().put(PropertyKeys.rowSelectorDepth, rowSelectorDepth);
		handleAttribute("rowSelectorDepth", rowSelectorDepth);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Defaults to 
            <tt>false</tt>. Specify 
            <tt>true</tt> to have the column widths re-proportioned
            at 
            <b>all times</b>.</p>
            <p>The 
            <a ext:cls="Ext.grid.Column" ext:member="width" href="output/Ext.grid.Column.html#Ext.grid.Column-width">initially
            configured width</a> of each column will be adjusted to
            fit the grid width and prevent horizontal scrolling. If
            columns are later resized (manually or
            programmatically), the other columns in the grid 
            <b>will</b> be resized to fit the grid width.</p>
            <p>Columns which are configured with 
            <code>fixed: true</code> are omitted from being
            resized.</p>
            <p>See 
            <tt>
              <a ext:cls="Ext.grid.GridView" ext:member="autoFill" href="output/Ext.grid.GridView.html#Ext.grid.GridView-autoFill">autoFill</a>
            </tt>.</p>
          </div>

	 */
	
	public Boolean getForceFit () {
		return (Boolean) getStateHelper().eval(PropertyKeys.forceFit);
	}

	/**
	 * <p>
	 * Set the value of the <code>forceFit</code> property.
	 * </p>
	 */
	public void setForceFit ( Boolean   forceFit ) {
		getStateHelper().put(PropertyKeys.forceFit, forceFit);
		handleAttribute("forceFit", forceFit);
	}
    	/*
	 *
        
        
          rowBodySelectorDepth
         : Number
        The number of levels to search for row
        bodies in event delegation (defaults to 
        10)
	 */
	
	public Integer getRowBodySelectorDepth () {
		return (Integer) getStateHelper().eval(PropertyKeys.rowBodySelectorDepth);
	}

	/**
	 * <p>
	 * Set the value of the <code>rowBodySelectorDepth</code> property.
	 * </p>
	 */
	public void setRowBodySelectorDepth ( Integer   rowBodySelectorDepth ) {
		getStateHelper().put(PropertyKeys.rowBodySelectorDepth, rowBodySelectorDepth);
		handleAttribute("rowBodySelectorDepth", rowBodySelectorDepth);
	}
    	/*
	 *
        
        
          headerMenuOpenCls
         : String
        The CSS class to add to the header cell
        when its menu is visible. Defaults to
        'x-grid3-hd-menu-open'
	 */
	
	public String getHeaderMenuOpenCls () {
		return (String) getStateHelper().eval(PropertyKeys.headerMenuOpenCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>headerMenuOpenCls</code> property.
	 * </p>
	 */
	public void setHeaderMenuOpenCls ( String   headerMenuOpenCls ) {
		getStateHelper().put(PropertyKeys.headerMenuOpenCls, headerMenuOpenCls);
		handleAttribute("headerMenuOpenCls", headerMenuOpenCls);
	}
    	/*
	 *
        
        
          sortClasses
         : Array
        The CSS classes applied to a header when
        it is sorted. (defaults to 
        ['sort-asc', 'sort-desc'])
	 */
	@ClientConfig(JsonMode.Array)

	public Object getSortClasses () {
		return (Object) getStateHelper().eval(PropertyKeys.sortClasses);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortClasses</code> property.
	 * </p>
	 */
	public void setSortClasses ( Object   sortClasses ) {
		getStateHelper().put(PropertyKeys.sortClasses, sortClasses);
		handleAttribute("sortClasses", sortClasses);
	}
    	/*
	 *
        
        
          sortDescText
         : String
        The text displayed in the 'Sort
        Descending' menu item (defaults to 
        'Sort Descending')
	 */
	
	public String getSortDescText () {
		return (String) getStateHelper().eval(PropertyKeys.sortDescText);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortDescText</code> property.
	 * </p>
	 */
	public void setSortDescText ( String   sortDescText ) {
		getStateHelper().put(PropertyKeys.sortDescText, sortDescText);
		handleAttribute("sortDescText", sortDescText);
	}
    	/*
	 *
        
        
          columnsText
         : String
        The text displayed in the 'Columns' menu
        item (defaults to 
        'Columns')
	 */
	
	public String getColumnsText () {
		return (String) getStateHelper().eval(PropertyKeys.columnsText);
	}

	/**
	 * <p>
	 * Set the value of the <code>columnsText</code> property.
	 * </p>
	 */
	public void setColumnsText ( String   columnsText ) {
		getStateHelper().put(PropertyKeys.columnsText, columnsText);
		handleAttribute("columnsText", columnsText);
	}
    	/*
	 *
        
        
          cellSelector
         : String
        The selector used to find cells
        internally (defaults to 
        'td.x-grid3-cell')
	 */
	
	public String getCellSelector () {
		return (String) getStateHelper().eval(PropertyKeys.cellSelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>cellSelector</code> property.
	 * </p>
	 */
	public void setCellSelector ( String   cellSelector ) {
		getStateHelper().put(PropertyKeys.cellSelector, cellSelector);
		handleAttribute("cellSelector", cellSelector);
	}
    	/*
	 *
        
        
          cellSelectorDepth
         : Number
        The number of levels to search for cells
        in event delegation (defaults to 
        4)
	 */
	
	public Integer getCellSelectorDepth () {
		return (Integer) getStateHelper().eval(PropertyKeys.cellSelectorDepth);
	}

	/**
	 * <p>
	 * Set the value of the <code>cellSelectorDepth</code> property.
	 * </p>
	 */
	public void setCellSelectorDepth ( Integer   cellSelectorDepth ) {
		getStateHelper().put(PropertyKeys.cellSelectorDepth, cellSelectorDepth);
		handleAttribute("cellSelectorDepth", cellSelectorDepth);
	}
    	/*
	 *
        
        
          rowOverCls
         : String
        The CSS class added to each row when it
        is hovered over. Defaults to 'x-grid3-row-over'
	 */
	
	public String getRowOverCls () {
		return (String) getStateHelper().eval(PropertyKeys.rowOverCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>rowOverCls</code> property.
	 * </p>
	 */
	public void setRowOverCls ( String   rowOverCls ) {
		getStateHelper().put(PropertyKeys.rowOverCls, rowOverCls);
		handleAttribute("rowOverCls", rowOverCls);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The amount of space to reserve for the
          vertical scrollbar (defaults to 
          <tt>undefined</tt>). If an explicit value isn't
          specified, this will be automatically calculated.</div>

	 */
	
	public Integer getScrollOffset () {
		return (Integer) getStateHelper().eval(PropertyKeys.scrollOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollOffset</code> property.
	 * </p>
	 */
	public void setScrollOffset ( Integer   scrollOffset ) {
		getStateHelper().put(PropertyKeys.scrollOffset, scrollOffset);
		handleAttribute("scrollOffset", scrollOffset);
	}
    	/*
	 *
        
        
          rowSelector
         : String
        The selector used to find rows
        internally (defaults to 
        'div.x-grid3-row')
	 */
	
	public String getRowSelector () {
		return (String) getStateHelper().eval(PropertyKeys.rowSelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>rowSelector</code> property.
	 * </p>
	 */
	public void setRowSelector ( String   rowSelector ) {
		getStateHelper().put(PropertyKeys.rowSelector, rowSelector);
		handleAttribute("rowSelector", rowSelector);
	}
    	/*
	 *
        
        
          deferEmptyText
         : Boolean
        True to defer 
        
          emptyText
         being applied until the store's first load (defaults
        to 
        true).
	 */
	
	public Boolean getDeferEmptyText () {
		return (Boolean) getStateHelper().eval(PropertyKeys.deferEmptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>deferEmptyText</code> property.
	 * </p>
	 */
	public void setDeferEmptyText ( Boolean   deferEmptyText ) {
		getStateHelper().put(PropertyKeys.deferEmptyText, deferEmptyText);
		handleAttribute("deferEmptyText", deferEmptyText);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforerefresh"
					, "beforerowremoved"
					, "beforerowsinserted"
					, "refresh"
					, "rowremoved"
					, "rowsinserted"
					, "rowupdated"
				));
				return superEvent;
	}
}