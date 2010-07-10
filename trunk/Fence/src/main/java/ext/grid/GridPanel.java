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
 * 
    This class represents the primary interface of a component
    based grid control to represent data in a tabular format of
    rows and columns. The GridPanel is composed of the
    following:
    
      
        
        
          Store
         : The Model holding the data records (rows)
        
        
          Column model
         : Column makeup
        
        
          View
         : Encapsulates the user interface
        
        
          selection
          model
         : Selection behavior
      
    
    Example usage:


var grid = 
new Ext.grid.GridPanel({
    
store: 
new 
Ext.data.Store({
        
autoDestroy:
true,
        
reader: reader,
        
data: xg.dummyData
    }),
    
colModel: 
new 
Ext.grid.ColumnModel({
        
defaults:
{
            width: 120,
            sortable: true
        },
        
columns: [
            {id: 
'company', header: 
'Company', width: 200, sortable: true, dataIndex: 
'company'},
            {header: 
'Price', renderer: Ext.util.Format.usMoney, dataIndex: 
'price'},
            {header: 
'Change', dataIndex: 
'change'},
            {header: 
'% Change', dataIndex: 
'pctChange'},
            
// instead of specifying renderer: Ext.util.Format.dateRenderer(
'm/d/Y') use xtype

            {
                header: 
'Last Updated', width: 135, dataIndex: 
'lastChange',
                xtype: 
'datecolumn', format: 
'M d, Y'
            }
        ],
    }),
    
viewConfig: {
        
forceFit:
true,

//      Return CSS class to apply to rows depending upon data
values

        
getRowClass: 
function(record, index) {
            
var c = record.
get(
'change');
            
if (c < 0) {
                
return 
'price-fall';
            } 
else 
if (c > 0) {
                
return 
'price-rise';
            }
        }
    },
    
sm: 
new Ext.grid.RowSelectionModel({singleSelect:true}),
    width: 600,
    height: 300,
    frame: true,
    title: 
'Framed 
with Row Selection and Horizontal Scrolling',
    iconCls: 
'icon-grid'
});
    
    
      
        Notes:
      
    
    
      
        Although this class inherits many configuration options
        from base classes, some of them (such as autoScroll,
        autoWidth, layout, items, etc) are not used by this class,
        and will have no effect.
        A grid 
        requires a width in which to scroll its columns, and
        a height in which to scroll its rows. These dimensions can
        either be set explicitly through the 
        
          height
         and 
        
          width
         configuration options or implicitly set by using the
        grid as a child item of a 
        Container which will have a 
        layout
        manager provide the sizing of its child items (for
        example the Container of the Grid may specify 
        
        layout:'fit').
        To access the data in a Grid, it is necessary to use
        the data model encapsulated by the 
        Store.
        See the 
        cellclick event for more
        details.
      
    
  
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
			maxHeight
			,deferRowRender
			,hideHeaders
			,enableDragDrop
			,trackMouseOver
			,columns
			,ddGroup
			,disableSelection
			,autoExpandColumn
			,autoExpandMin
			,enableColumnResize
			,stripeRows
			,enableColumnHide
			,colModel
			,autoExpandMax
			,stateEvents
			,view
			,minColumnWidth
			,selModel
			,cm
			,sm
			,ddText
			,enableHdMenu
			,columnLines
			,store
			,bubbleEvents
			,loadMask
			,viewConfig
			,enableColumnMove
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
            Defaults to 
            true to enable deferred row rendering.
            This allows the GridPanel to be initially rendered
            empty, with the expensive update of the row structure
            deferred so that layouts with GridPanels appear more
            quickly.
          
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
            Enables dragging of the selected rows of the
            GridPanel. Defaults to 
            false.
            Setting this to 
            
              true
             causes this GridPanel's 
            GridView to create an
            instance of 
            Ext.grid.GridDragZone.
            
            Note: this is available only 
            after the Grid has been rendered as the
            GridView's 
            
              dragZone
             property.
            A cooperating 
            DropZone must be created
            who's implementations of 
            onNodeEnter, 
            onNodeOver, 
            onNodeOut and 
            onNodeDrop are able to
            process the 
            data which is
            provided.
          
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
	 *An array of 
          columns to auto create a 
          Ext.grid.ColumnModel.
          The ColumnModel may be explicitly created via the 
          
            colModel
           configuration property.
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
            The 
            
              id
             of a 
            column in this grid that
            should expand to fill unused space. This value
            specified here can not be 
            0.
            
            
            Note: If the Grid's 
            view is configured with
            
            
            forceFit=true the 
            autoExpandColumn is ignored. See 
            Ext.grid.Column.
            
              width
             for additional details.
            See 
            
              autoExpandMax
             and 
            
              autoExpandMin
             also.
          
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
	 *
          true to stripe the rows. Default is 
          false. 
          This causes the CSS class 
          
            x-grid3-row-alt
           to be added to alternate rows of the grid. A
          default CSS rule is provided which sets a background
          colour, but you can override this with a rule which
          either overrides the 
          background-color style using the '!important'
          modifier, or which uses a CSS selector of higher
          specificity.
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
	 *An array of events that, when fired,
          should trigger this component to save its state. Defaults
          to:

stateEvents: [
'columnmove', 
'columnresize', 
'sortchange', 
'groupchange']
          
          These can be any types of events supported by this
          component, including browser or custom events (e.g., 
          ['click', 'customerchange']).
          See 
          Ext.Component.stateful for an
          explanation of saving and restoring Component
          state.
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
	 *Any subclass of 
          Ext.grid.AbstractSelectionModel
          that will provide the selection model for the grid
          (defaults to 
          Ext.grid.RowSelectionModel
          if not specified).
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
	 *Configures the text in the drag proxy.
          Defaults to: 

ddText : 
'{0} selected row{1}'
          
          {0} is replaced with the number of selected
          rows.
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
	 *
            An array of events that, when fired, should be
            bubbled to any parent container. See 
            Ext.util.Observable.enableBubble.
            Defaults to 
            [].
          
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
	 *A config object that will be applied to
          the grid's UI view. Any of the config options available
          for 
          Ext.grid.GridView can be
          specified here. This option is ignored if 
          
            view
           is specified.
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