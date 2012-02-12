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
<div class="description">Adds the ability for single level
  grouping to the grid. A 
  <a ext:cls="Ext.data.GroupingStore" href="output/Ext.data.GroupingStore.html">GroupingStore</a> must be used
  to enable grouping. Some grouping characteristics may also be
  configured at the 
  <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Column level</a>
  <div class="mdetail-params">
    <ul>
      <li>
        <code>
          <a ext:cls="Ext.grid.Column" ext:member="emptyGroupText" href="output/Ext.grid.Column.html#Ext.grid.Column-emptyGroupText">emptyGroupText</a>
        </code>
      </li>
      <li>
        <code>
          <a ext:cls="Ext.grid.Column" ext:member="groupable" href="output/Ext.grid.Column.html#Ext.grid.Column-groupable">groupable</a>
        </code>
      </li>
      <li>
        <code>
          <a ext:cls="Ext.grid.Column" ext:member="groupName" href="output/Ext.grid.Column.html#Ext.grid.Column-groupName">groupName</a>
        </code>
      </li>
      <li>
        <code>
          <a ext:cls="Ext.grid.Column" ext:member="groupRender" href="output/Ext.grid.Column.html#Ext.grid.Column-groupRender">groupRender</a>
        </code>
      </li>
    </ul>
  </div>
  <p>Sample usage:</p>
<pre>
<code>
<b>var</b> grid = 
<b>new</b> Ext.grid.GridPanel({
    
<i>// A groupingStore is required 
<b>for</b> a GroupingView</i>
    store: 
<b>new</b> 
<a ext:cls="Ext.data.GroupingStore" href="output/Ext.data.GroupingStore.html">Ext.data.GroupingStore</a>({
        autoDestroy: true,
        reader: reader,
        data: xg.dummyData,
        sortInfo: {field: 
<em>'company'</em>, direction: 
<em>'ASC'</em>},
        
<a ext:cls="Ext.data.GroupingStore" ext:member="groupOnSort" href="output/Ext.data.GroupingStore.html#Ext.data.GroupingStore-groupOnSort">groupOnSort</a>: true,
        
<a ext:cls="Ext.data.GroupingStore" ext:member="remoteGroup" href="output/Ext.data.GroupingStore.html#Ext.data.GroupingStore-remoteGroup">remoteGroup</a>: true,
        
<a ext:cls="Ext.data.GroupingStore" ext:member="groupField" href="output/Ext.data.GroupingStore.html#Ext.data.GroupingStore-groupField">groupField</a>: 
<em>'industry'</em>
    }),
    colModel: 
<b>new</b> 
<a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">Ext.grid.ColumnModel</a>({
        columns:[
            {id:
<em>'company'</em>,header: 
<em>'Company'</em>, width: 60, dataIndex: 
<em>'company'</em>},
            
<i>// 
<a ext:cls="Ext.grid.Column" ext:member="groupable" href="output/Ext.grid.Column.html#Ext.grid.Column-groupable">groupable</a>, 
<a ext:cls="Ext.grid.Column" ext:member="groupName" href="output/Ext.grid.Column.html#Ext.grid.Column-groupName">groupName</a>, 
<a ext:cls="Ext.grid.Column" ext:member="groupRender" href="output/Ext.grid.Column.html#Ext.grid.Column-groupRender">groupRender</a>
are also configurable at column level</i>
            {header: 
<em>'Price'</em>, renderer: Ext.util.Format.usMoney, dataIndex: 
<em>'price'</em>, 
<a ext:cls="Ext.grid.Column" ext:member="groupable" href="output/Ext.grid.Column.html#Ext.grid.Column-groupable">groupable</a>:
false},
            {header: 
<em>'Change'</em>, dataIndex: 
<em>'change'</em>, renderer: Ext.util.Format.usMoney},
            {header: 
<em>'Industry'</em>, dataIndex: 
<em>'industry'</em>},
            {header: 
<em>'Last Updated'</em>, renderer: Ext.util.Format.dateRenderer(
<em>'m/d/Y'</em>), dataIndex: 
<em>'lastChange'</em>}
        ],
        defaults: {
            sortable: true,
            menuDisabled: false,
            width: 20
        }
    }),

    view: 
<b>new</b> Ext.grid.GroupingView({
        
<a ext:cls="Ext.grid.GridView" ext:member="forceFit" href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit">forceFit</a>:
true,
        
<i>// custom grouping text template to display the number of items
per group</i>
        
<a ext:cls="Ext.grid.GroupingView" ext:member="groupTextTpl" href="output/Ext.grid.GroupingView.html#Ext.grid.GroupingView-groupTextTpl">groupTextTpl</a>: 
<em>'{text} ({[values.rs.length]} {[values.rs.length &gt; 1 ?</em>
"Items"</code> : 
<em>"Item"</em>]})'
    }),

    frame:true,
    width: 700,
    height: 450,
    collapsible: true,
    animCollapse: false,
    title: 
<em>'Grouping Example'</em>,
    iconCls: 
<em>'icon-grid'</em>,
    renderTo: document.body
});
  </pre>
</div>

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
			enableGrouping
			,enableGroupingMenu
			,groupByText
			,groupTextTpl
			,emptyGroupText
			,showGroupsText
			,groupMode
			,enableNoGroups
			,cancelEditOnToggle
			,startCollapsed
			,hideGroupedColumn
			,ignoreAdd
			,showGroupName
			,groupRenderer
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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The template used to render the group
          header (defaults to 
          <tt>'{text}'</tt>). This is used to format an object
          which contains the following properties: 
          <div class="mdetail-params">
            <ul>
              <li>
              <b>group</b> : String
              <p class="sub-desc">The 
              <i>rendered</i> value of the group field. By default
              this is the unchanged value of the group field. If a 
              <tt>
                <b>
                  <a ext:cls="Ext.grid.Column" ext:member="groupRenderer" href="output/Ext.grid.Column.html#Ext.grid.Column-groupRenderer">groupRenderer</a>
                </b>
              </tt> is specified, it is the result of a call to
              that function.</p>
</li>
              <li>
              <b>gvalue</b> : Object
              <p class="sub-desc">The 
              <i>raw</i> value of the group field.</p>
</li>
              <li>
              <b>text</b> : String
              <p class="sub-desc">The configured header (as
              described in 
              <tt>
              <a ext:cls="Ext.grid.GroupingView" ext:member="showGroupName" href="output/Ext.grid.GroupingView.html#Ext.grid.GroupingView-showGroupName">showGroupName</a>)</tt>
              if 
              <tt>
                <a ext:cls="Ext.grid.GroupingView" ext:member="showGroupName" href="output/Ext.grid.GroupingView.html#Ext.grid.GroupingView-showGroupName">showGroupName</a>
              </tt> is 
              <tt>true</tt>) plus the 
              <i>rendered</i> group field value.</p>
</li>
              <li>
              <b>groupId</b> : String
              <p class="sub-desc">A unique, generated ID which is
              applied to the View Element which contains the
              group.</p>
</li>
              <li>
              <b>startRow</b> : Number
              <p class="sub-desc">The row index of the Record which
              caused group change.</p>
</li>
              <li>
              <b>rs</b> : Array
              <p class="sub-desc">Contains a single element: The
              Record providing the data for the row which caused
              group change.</p>
</li>
              <li>
              <b>cls</b> : String
              <p class="sub-desc">The generated class name string
              to apply to the group header Element.</p>
</li>
              <li>
              <b>style</b> : String
              <p class="sub-desc">The inline style rules to apply
              to the group header Element.</p>
</li>
            </ul>
          </div>
          <br/>
          <br/> See 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> for information
          on how to format data using a template. Possible usage:
<pre>
<code>
<b>var</b> grid = 
<b>new</b> Ext.grid.GridPanel({
    ...
    view: 
<b>new</b> Ext.grid.GroupingView({
        groupTextTpl: 
<em>'{text} ({[values.rs.length]} {[values.rs.length &gt; 1 ?</em>
"Items"</code> : 
<em>"Item"</em>]})'
    }),
});
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The text to display when there is an
          empty group value (defaults to 
          <tt>'(None)'</tt>). May also be specified per column, see
          
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a>.
          <a ext:cls="Ext.grid.Column" ext:member="emptyGroupText" href="output/Ext.grid.Column.html#Ext.grid.Column-emptyGroupText">emptyGroupText</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Indicates how to construct the group
          identifier. 
          <tt>'value'</tt> constructs the id using raw value, 
          <tt>'display'</tt> constructs the id using the rendered
          value. Defaults to 
          <tt>'value'</tt>.</div>

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
        
        
          cancelEditOnToggle
         : Boolean
        True to cancel any editing when the
        group header is toggled. Defaults to 
        true.
	 */
	
	public Boolean getCancelEditOnToggle () {
		return (Boolean) getStateHelper().eval(PropertyKeys.cancelEditOnToggle);
	}

	/**
	 * <p>
	 * Set the value of the <code>cancelEditOnToggle</code> property.
	 * </p>
	 */
	public void setCancelEditOnToggle ( Boolean   cancelEditOnToggle ) {
		getStateHelper().put(PropertyKeys.cancelEditOnToggle, cancelEditOnToggle);
		handleAttribute("cancelEditOnToggle", cancelEditOnToggle);
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">If 
          <tt>true</tt> will display a prefix plus a ': ' before
          the group field value in the group header line. The
          prefix will consist of the 
          <tt>
            <b>
              <a ext:cls="Ext.grid.Column" ext:member="groupName" href="output/Ext.grid.Column.html#Ext.grid.Column-groupName">groupName</a>
            </b>
          </tt> (or the configured 
          <tt>
            <b>
              <a ext:cls="Ext.grid.Column" ext:member="header" href="output/Ext.grid.Column.html#Ext.grid.Column-header">header</a>
            </b>
          </tt> if not provided) configured in the 
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> for each
          set of grouped rows (defaults to 
          <tt>true</tt>).</div>

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