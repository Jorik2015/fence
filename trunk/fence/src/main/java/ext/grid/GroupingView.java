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
 * Adds the ability for single level
  grouping to the grid. A 
  GroupingStore must be used
  to enable grouping. Some grouping characteristics may also be
  configured at the 
  Column level
  
    
      
        
          emptyGroupText
        
      
      
        
          groupable
        
      
      
        
          groupName
        
      
      
        
          groupRender
        
      
    
  
  Sample usage:


var grid = 
new Ext.grid.GridPanel({
    
// A groupingStore is required 
for a GroupingView

    store: 
new 
Ext.data.GroupingStore({
        autoDestroy: true,
        reader: reader,
        data: xg.dummyData,
        sortInfo: {field: 
'company', direction: 
'ASC'},
        
groupOnSort: true,
        
remoteGroup: true,
        
groupField: 
'industry'
    }),
    colModel: 
new 
Ext.grid.ColumnModel({
        columns:[
            {id:
'company',header: 
'Company', width: 60, dataIndex: 
'company'},
            
// 
groupable, 
groupName, 
groupRender
are also configurable at column level

            {header: 
'Price', renderer: Ext.util.Format.usMoney, dataIndex: 
'price', 
groupable:
false},
            {header: 
'Change', dataIndex: 
'change', renderer: Ext.util.Format.usMoney},
            {header: 
'Industry', dataIndex: 
'industry'},
            {header: 
'Last Updated', renderer: Ext.util.Format.dateRenderer(
'm/d/Y'), dataIndex: 
'lastChange'}
        ],
        defaults: {
            sortable: true,
            menuDisabled: false,
            width: 20
        }
    }),

    view: 
new Ext.grid.GroupingView({
        
forceFit:
true,
        
// custom grouping text template to display the number of items
per group

        
groupTextTpl: 
'{text} ({[values.rs.length]} {[values.rs.length > 1 ?
"Items" : 
"Item"]})'
    }),

    frame:true,
    width: 700,
    height: 450,
    collapsible: true,
    animCollapse: false,
    title: 
'Grouping Example',
    iconCls: 
'icon-grid',
    renderTo: document.body
});
  
 */

@InstanceOf("Ext.grid.GroupingView")
@ParseConfigMode(ui = false,name="view",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.GroupingView")
public class GroupingView extends GridView {
	public static final String COMPONENT_FAMILY = "Ext.grid.GroupingView";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.GroupingView} instance with default property values.
	 * </p>
	 */
	public GroupingView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			hideGroupedColumn
			,showGroupName
			,enableGrouping
			,showGroupsText
			,enableNoGroups
			,enableGroupingMenu
			,startCollapsed
			,groupTextTpl
			,groupRenderer
			,groupMode
			,ignoreAdd
			,emptyGroupText
			,groupByText
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
        
        
          hideGroupedColumn
         : Boolean
        
        true to hide the column that is currently grouped
        (defaults to 
        false)
	 */
	
	public Boolean getHideGroupedColumn () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideGroupedColumn);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideGroupedColumn</code> property.
	 * </p>
	 */
	public void setHideGroupedColumn ( Boolean   hideGroupedColumn ) {
		getStateHelper().put(PropertyKeys.hideGroupedColumn, hideGroupedColumn);
		handleAttribute("hideGroupedColumn", hideGroupedColumn);
	}
    	/*
	 *If 
          true will display a prefix plus a ': ' before
          the group field value in the group header line. The
          prefix will consist of the 
          
            
              groupName
            
           (or the configured 
          
            
              header
            
           if not provided) configured in the 
          Ext.grid.Column for each
          set of grouped rows (defaults to 
          true).
	 */
	
	public Boolean getShowGroupName () {
		return (Boolean) getStateHelper().eval(PropertyKeys.showGroupName);
	}

	/**
	 * <p>
	 * Set the value of the <code>showGroupName</code> property.
	 * </p>
	 */
	public void setShowGroupName ( Boolean   showGroupName ) {
		getStateHelper().put(PropertyKeys.showGroupName, showGroupName);
		handleAttribute("showGroupName", showGroupName);
	}
    	/*
	 *
        
        
          enableGrouping
         : Boolean
        
        false to disable grouping functionality (defaults
        to 
        true)
	 */
	
	public Boolean getEnableGrouping () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableGrouping);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableGrouping</code> property.
	 * </p>
	 */
	public void setEnableGrouping ( Boolean   enableGrouping ) {
		getStateHelper().put(PropertyKeys.enableGrouping, enableGrouping);
		handleAttribute("enableGrouping", enableGrouping);
	}
    	/*
	 *
        
        
          showGroupsText
         : String
        Text displayed in the grid header for
        enabling/disabling grouping (defaults to 'Show in
        Groups').
	 */
	
	public String getShowGroupsText () {
		return (String) getStateHelper().eval(PropertyKeys.showGroupsText);
	}

	/**
	 * <p>
	 * Set the value of the <code>showGroupsText</code> property.
	 * </p>
	 */
	public void setShowGroupsText ( String   showGroupsText ) {
		getStateHelper().put(PropertyKeys.showGroupsText, showGroupsText);
		handleAttribute("showGroupsText", showGroupsText);
	}
    	/*
	 *
        
        
          enableNoGroups
         : Boolean
        
        true to allow the user to turn off grouping
        (defaults to 
        true)
	 */
	
	public Boolean getEnableNoGroups () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableNoGroups);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableNoGroups</code> property.
	 * </p>
	 */
	public void setEnableNoGroups ( Boolean   enableNoGroups ) {
		getStateHelper().put(PropertyKeys.enableNoGroups, enableNoGroups);
		handleAttribute("enableNoGroups", enableNoGroups);
	}
    	/*
	 *
        
        
          enableGroupingMenu
         : Boolean
        
        true to enable the grouping control in the column
        menu (defaults to 
        true)
	 */
	
	public Boolean getEnableGroupingMenu () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableGroupingMenu);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableGroupingMenu</code> property.
	 * </p>
	 */
	public void setEnableGroupingMenu ( Boolean   enableGroupingMenu ) {
		getStateHelper().put(PropertyKeys.enableGroupingMenu, enableGroupingMenu);
		handleAttribute("enableGroupingMenu", enableGroupingMenu);
	}
    	/*
	 *
        
        
          startCollapsed
         : Boolean
        
        true to start all groups collapsed (defaults to 
        false)
	 */
	
	public Boolean getStartCollapsed () {
		return (Boolean) getStateHelper().eval(PropertyKeys.startCollapsed);
	}

	/**
	 * <p>
	 * Set the value of the <code>startCollapsed</code> property.
	 * </p>
	 */
	public void setStartCollapsed ( Boolean   startCollapsed ) {
		getStateHelper().put(PropertyKeys.startCollapsed, startCollapsed);
		handleAttribute("startCollapsed", startCollapsed);
	}
    	/*
	 *The template used to render the group
          header (defaults to 
          '{text}'). This is used to format an object
          which contains the following properties: 
          
            
              
              group : String
              The 
              rendered value of the group field. By default
              this is the unchanged value of the group field. If a 
              
                
                  groupRenderer
                
               is specified, it is the result of a call to
              that function.
              
              gvalue : Object
              The 
              raw value of the group field.
              
              text : String
              The configured header (as
              described in 
              
              showGroupName)
              if 
              
                showGroupName
               is 
              true) plus the 
              rendered group field value.
              
              groupId : String
              A unique, generated ID which is
              applied to the View Element which contains the
              group.
              
              startRow : Number
              The row index of the Record which
              caused group change.
              
              rs : Array
              Contains a single element: The
              Record providing the data for the row which caused
              group change.
              
              cls : String
              The generated class name string
              to apply to the group header Element.
              
              style : String
              The inline style rules to apply
              to the group header Element.
            
          
          
           See 
          Ext.XTemplate for information
          on how to format data using a template. Possible usage:


var grid = 
new Ext.grid.GridPanel({
    ...
    view: 
new Ext.grid.GroupingView({
        groupTextTpl: 
'{text} ({[values.rs.length]} {[values.rs.length > 1 ?
"Items" : 
"Item"]})'
    }),
});
          
	 */
	
	public String getGroupTextTpl () {
		return (String) getStateHelper().eval(PropertyKeys.groupTextTpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupTextTpl</code> property.
	 * </p>
	 */
	public void setGroupTextTpl ( String   groupTextTpl ) {
		getStateHelper().put(PropertyKeys.groupTextTpl, groupTextTpl);
		handleAttribute("groupTextTpl", groupTextTpl);
	}
    	/*
	 *
        
        
          groupRenderer
         : Function
        This property must be configured in the 
        Ext.grid.Column for each
        column.
	 */
	@ClientConfig(JsonMode.Function)

	public Object getGroupRenderer () {
		return (Object) getStateHelper().eval(PropertyKeys.groupRenderer);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupRenderer</code> property.
	 * </p>
	 */
	public void setGroupRenderer ( Object   groupRenderer ) {
		getStateHelper().put(PropertyKeys.groupRenderer, groupRenderer);
		handleAttribute("groupRenderer", groupRenderer);
	}
    	/*
	 *Indicates how to construct the group
          identifier. 
          'value' constructs the id using raw value, 
          'display' constructs the id using the rendered
          value. Defaults to 
          'value'.
	 */
	
	public String getGroupMode () {
		return (String) getStateHelper().eval(PropertyKeys.groupMode);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupMode</code> property.
	 * </p>
	 */
	public void setGroupMode ( String   groupMode ) {
		getStateHelper().put(PropertyKeys.groupMode, groupMode);
		handleAttribute("groupMode", groupMode);
	}
    	/*
	 *
        
        
          ignoreAdd
         : Boolean
        
        true to skip refreshing the view when new rows are
        added (defaults to 
        false)
	 */
	
	public Boolean getIgnoreAdd () {
		return (Boolean) getStateHelper().eval(PropertyKeys.ignoreAdd);
	}

	/**
	 * <p>
	 * Set the value of the <code>ignoreAdd</code> property.
	 * </p>
	 */
	public void setIgnoreAdd ( Boolean   ignoreAdd ) {
		getStateHelper().put(PropertyKeys.ignoreAdd, ignoreAdd);
		handleAttribute("ignoreAdd", ignoreAdd);
	}
    	/*
	 *The text to display when there is an
          empty group value (defaults to 
          '(None)'). May also be specified per column, see
          
          Ext.grid.Column.
          emptyGroupText.
	 */
	
	public String getEmptyGroupText () {
		return (String) getStateHelper().eval(PropertyKeys.emptyGroupText);
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyGroupText</code> property.
	 * </p>
	 */
	public void setEmptyGroupText ( String   emptyGroupText ) {
		getStateHelper().put(PropertyKeys.emptyGroupText, emptyGroupText);
		handleAttribute("emptyGroupText", emptyGroupText);
	}
    	/*
	 *
        
        
          groupByText
         : String
        Text displayed in the grid header menu
        for grouping by a column (defaults to 'Group By This
        Field').
	 */
	
	public String getGroupByText () {
		return (String) getStateHelper().eval(PropertyKeys.groupByText);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupByText</code> property.
	 * </p>
	 */
	public void setGroupByText ( String   groupByText ) {
		getStateHelper().put(PropertyKeys.groupByText, groupByText);
		handleAttribute("groupByText", groupByText);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				return superEvent;
	}
}