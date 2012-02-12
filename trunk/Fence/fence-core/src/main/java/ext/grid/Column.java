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
    <p>This class encapsulates column configuration data to be used
    in the initialization of a 
    <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">ColumnModel</a>.</p>
    <p>While subclasses are provided to render data in different
    ways, this class renders a passed data field unchanged and is
    usually used for textual columns.</p>
  </div>

 */

@InstanceOf("Ext.grid.Column")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.grid.Column")
public class Column extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.grid.Column";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.Column} instance with default property values.
	 * </p>
	 */
	public Column() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			groupName
			,scope
			,hideable
			,width
			,sortable
			,align
			,emptyGroupText
			,dataIndex
			,fixed
			,editable
			,header
			,editor
			,menuDisabled
			,hidden
			,xtype
			,resizable
			,groupable
			,renderer
			,css
			,groupRenderer
			,tooltip
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. If the grid is being rendered
          by an 
          <a ext:cls="Ext.grid.GroupingView" href="output/Ext.grid.GroupingView.html">Ext.grid.GroupingView</a>,
          this option may be used to specify the text with which to
          prefix the group field value in the group header line.
          See also 
          <a ext:cls="Ext.grid.Column" ext:member="groupRenderer" href="output/Ext.grid.Column.html#Ext.grid.Column-groupRenderer">groupRenderer</a> and 
          <a ext:cls="Ext.grid.GroupingView" href="output/Ext.grid.GroupingView.html">Ext.grid.GroupingView</a>.
          <a ext:cls="Ext.grid.GroupingView" ext:member="showGroupName" href="output/Ext.grid.GroupingView.html#Ext.grid.GroupingView-showGroupName">showGroupName</a>.</div>

	 */
	
	public String getGroupName () {
		return (String) getStateHelper().eval(PropertyKeys.groupName);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupName</code> property.
	 * </p>
	 */
	public void setGroupName ( String   groupName ) {
		getStateHelper().put(PropertyKeys.groupName, groupName);
		handleAttribute("groupName", groupName);
	}
    	/*
	 *
        
        
          scope
         : Object
        Optional. The scope (
        
          this
         reference) in which to execute the renderer. Defaults
        to the Column configuration object.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getScope () {
		return (Object) getStateHelper().eval(PropertyKeys.scope);
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope ( Object   scope ) {
		getStateHelper().put(PropertyKeys.scope, scope);
		handleAttribute("scope", scope);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. Specify as 
          <tt>false</tt> to prevent the user from hiding this
          column (defaults to true). To disallow column hiding
          globally for all columns in the grid, use 
          <a ext:cls="Ext.grid.GridPanel" ext:member="enableColumnHide" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-enableColumnHide">Ext.grid.GridPanel.enableColumnHide</a>
          instead.</div>

	 */
	
	public Boolean getHideable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideable);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideable</code> property.
	 * </p>
	 */
	public void setHideable ( Boolean   hideable ) {
		getStateHelper().put(PropertyKeys.hideable, hideable);
		handleAttribute("hideable", hideable);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. The initial width in pixels
          of the column. The width of each column can also be
          affected if any of the following are configured: 
          <div class="mdetail-params">
            <ul>
              <li>
              <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">Ext.grid.GridPanel</a>.
              <tt>
                <a ext:cls="Ext.grid.GridPanel" ext:member="autoExpandColumn" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandColumn">autoExpandColumn</a>
              </tt>
</li>
              <li>
              <a ext:cls="Ext.grid.GridView" href="output/Ext.grid.GridView.html">Ext.grid.GridView</a>.
              <tt>
                <a ext:cls="Ext.grid.GridView" ext:member="forceFit" href="output/Ext.grid.GridView.html#Ext.grid.GridView-forceFit">forceFit</a>
              </tt> 
              <div class="sub-desc">
                <p>By specifying 
                <tt>forceFit:true</tt>, 
                <a ext:cls="Ext.grid.Column" ext:member="fixed" href="output/Ext.grid.Column.html#Ext.grid.Column-fixed">non-fixed width</a>
                columns will be re-proportioned (based on the
                relative initial widths) to fill the width of the
                grid so that no horizontal scrollbar is shown.</p>
              </div>
</li>
              <li>
              <a ext:cls="Ext.grid.GridView" href="output/Ext.grid.GridView.html">Ext.grid.GridView</a>.
              <tt>
                <a ext:cls="Ext.grid.GridView" ext:member="autoFill" href="output/Ext.grid.GridView.html#Ext.grid.GridView-autoFill">autoFill</a>
              </tt>
</li>
              <li>
              <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">Ext.grid.GridPanel</a>.
              <tt>
                <a ext:cls="Ext.grid.GridPanel" ext:member="minColumnWidth" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-minColumnWidth">minColumnWidth</a>
              </tt>
</li>
              <li style="list-style: none">
                <br/>
                <p>
                <b>Note</b>: when the width of each column is
                determined, a space on the right side is reserved
                for the vertical scrollbar. The 
                <a ext:cls="Ext.grid.GridView" href="output/Ext.grid.GridView.html">Ext.grid.GridView</a>.
                <tt>
                  <a ext:cls="Ext.grid.GridView" ext:member="scrollOffset" href="output/Ext.grid.GridView.html#Ext.grid.GridView-scrollOffset">scrollOffset</a>
                </tt> can be modified to reduce or eliminate the
                reserved offset.</p>
              </li>
            </ul>
          </div>
</div>

	 */
	
	public Integer getWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.width);
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth ( Integer   width ) {
		getStateHelper().put(PropertyKeys.width, width);
		handleAttribute("width", width);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. 
          <tt>true</tt> if sorting is to be allowed on this column.
          Defaults to the value of the 
          <code>
            <a ext:cls="Ext.grid.ColumnModel" ext:member="defaultSortable" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-defaultSortable">Ext.grid.ColumnModel.defaultSortable</a>
          </code> property. Whether local/remote sorting is used is
          specified in 
          <code>
            <a ext:cls="Ext.data.Store" ext:member="remoteSort" href="output/Ext.data.Store.html#Ext.data.Store-remoteSort">Ext.data.Store.remoteSort</a>
          </code>.</div>

	 */
	
	public Boolean getSortable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.sortable);
	}

	/**
	 * <p>
	 * Set the value of the <code>sortable</code> property.
	 * </p>
	 */
	public void setSortable ( Boolean   sortable ) {
		getStateHelper().put(PropertyKeys.sortable, sortable);
		handleAttribute("sortable", sortable);
	}
    	/*
	 *
        
        
          align
         : String
        Optional. Set the CSS text-align
        property of the column. Defaults to undefined.
	 */
	
	public String getAlign () {
		return (String) getStateHelper().eval(PropertyKeys.align);
	}

	/**
	 * <p>
	 * Set the value of the <code>align</code> property.
	 * </p>
	 */
	public void setAlign ( String   align ) {
		getStateHelper().put(PropertyKeys.align, align);
		handleAttribute("align", align);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. If the grid is being rendered
          by an 
          <a ext:cls="Ext.grid.GroupingView" href="output/Ext.grid.GroupingView.html">Ext.grid.GroupingView</a>,
          this option may be used to specify the text to display
          when there is an empty group value. Defaults to the 
          <a ext:cls="Ext.grid.GroupingView" href="output/Ext.grid.GroupingView.html">Ext.grid.GroupingView</a>.
          <a ext:cls="Ext.grid.GroupingView" ext:member="emptyGroupText" href="output/Ext.grid.GroupingView.html#Ext.grid.GroupingView-emptyGroupText">emptyGroupText</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <b>Required</b>. The name of the field in the grid's 
            <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>'s 
            <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a>
            definition from which to draw the column's value.</p>
          </div>

	 */
	
	public String getDataIndex () {
		return (String) getStateHelper().eval(PropertyKeys.dataIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>dataIndex</code> property.
	 * </p>
	 */
	public void setDataIndex ( String   dataIndex ) {
		getStateHelper().put(PropertyKeys.dataIndex, dataIndex);
		handleAttribute("dataIndex", dataIndex);
	}
    	/*
	 *
        
        
          fixed
         : Boolean
        Optional. 
        true if the column width cannot be changed.
        Defaults to 
        false.
	 */
	
	public Boolean getFixed () {
		return (Boolean) getStateHelper().eval(PropertyKeys.fixed);
	}

	/**
	 * <p>
	 * Set the value of the <code>fixed</code> property.
	 * </p>
	 */
	public void setFixed ( Boolean   fixed ) {
		getStateHelper().put(PropertyKeys.fixed, fixed);
		handleAttribute("fixed", fixed);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. Defaults to 
          <tt>true</tt>, enabling the configured 
          <tt>
            <a ext:cls="Ext.grid.Column" ext:member="editor" href="output/Ext.grid.Column.html#Ext.grid.Column-editor">editor</a>
          </tt>. Set to 
          <tt>false</tt> to initially disable editing on this
          column. The initial configuration may be dynamically
          altered using 
          <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">Ext.grid.ColumnModel</a>.
          <a ext:cls="Ext.grid.ColumnModel" ext:member="setEditable" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-setEditable">setEditable()</a>.</div>

	 */
	
	public Boolean getEditable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.editable);
	}

	/**
	 * <p>
	 * Set the value of the <code>editable</code> property.
	 * </p>
	 */
	public void setEditable ( Boolean   editable ) {
		getStateHelper().put(PropertyKeys.editable, editable);
		handleAttribute("editable", editable);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. The header text to be used as
          innerHTML (html tags are accepted) to display in the Grid
          view. 
          <b>Note</b>: to have a clickable header with no text
          displayed use 
          <tt>'&amp;#160;'</tt>.</div>

	 */
	
	public String getHeader () {
		return (String) getStateHelper().eval(PropertyKeys.header);
	}

	/**
	 * <p>
	 * Set the value of the <code>header</code> property.
	 * </p>
	 */
	public void setHeader ( String   header ) {
		getStateHelper().put(PropertyKeys.header, header);
		handleAttribute("header", header);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. The 
          <a ext:cls="Ext.form.Field" href="output/Ext.form.Field.html">Ext.form.Field</a> to use when
          editing values in this column if editing is supported by
          the grid. See 
          <tt>
            <a ext:cls="Ext.grid.Column" ext:member="editable" href="output/Ext.grid.Column.html#Ext.grid.Column-editable">editable</a>
          </tt> also.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getEditor () {
		return (Object) getStateHelper().eval(PropertyKeys.editor);
	}

	/**
	 * <p>
	 * Set the value of the <code>editor</code> property.
	 * </p>
	 */
	public void setEditor ( Object   editor ) {
		getStateHelper().put(PropertyKeys.editor, editor);
		handleAttribute("editor", editor);
	}
    	/*
	 *
        
        
          menuDisabled
         : Boolean
        Optional. 
        true to disable the column menu. Defaults to 
        false.
	 */
	
	public Boolean getMenuDisabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.menuDisabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>menuDisabled</code> property.
	 * </p>
	 */
	public void setMenuDisabled ( Boolean   menuDisabled ) {
		getStateHelper().put(PropertyKeys.menuDisabled, menuDisabled);
		handleAttribute("menuDisabled", menuDisabled);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. 
          <tt>true</tt> to initially hide this column. Defaults to 
          <tt>false</tt>. A hidden column 
          <a ext:cls="Ext.grid.GridPanel" ext:member="enableColumnHide" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-enableColumnHide">may be shown via the header
          row menu</a>. If a column is never to be shown, simply do
          not include this column in the Column Model at all.</div>

	 */
	
	public Boolean getHidden () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hidden);
	}

	/**
	 * <p>
	 * Set the value of the <code>hidden</code> property.
	 * </p>
	 */
	public void setHidden ( Boolean   hidden ) {
		getStateHelper().put(PropertyKeys.hidden, hidden);
		handleAttribute("hidden", hidden);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. A String which references a
          predefined 
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> subclass
          type which is preconfigured with an appropriate 
          <code>
            <a ext:cls="Ext.grid.Column" ext:member="renderer" href="output/Ext.grid.Column.html#Ext.grid.Column-renderer">renderer</a>
          </code> to be easily configured into a ColumnModel. The
          predefined 
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> subclass
          types are: 
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>gridcolumn</tt>
              </b> : 
              <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> (
              <b>Default</b>)</li>
              <li>
              <b>
                <tt>booleancolumn</tt>
              </b> : 
              <a ext:cls="Ext.grid.BooleanColumn" href="output/Ext.grid.BooleanColumn.html">Ext.grid.BooleanColumn</a>
</li>
              <li>
              <b>
                <tt>numbercolumn</tt>
              </b> : 
              <a ext:cls="Ext.grid.NumberColumn" href="output/Ext.grid.NumberColumn.html">Ext.grid.NumberColumn</a>
</li>
              <li>
              <b>
                <tt>datecolumn</tt>
              </b> : 
              <a ext:cls="Ext.grid.DateColumn" href="output/Ext.grid.DateColumn.html">Ext.grid.DateColumn</a>
</li>
              <li>
              <b>
                <tt>templatecolumn</tt>
              </b> : 
              <a ext:cls="Ext.grid.TemplateColumn" href="output/Ext.grid.TemplateColumn.html">Ext.grid.TemplateColumn</a>
</li>
            </ul>
          </div>
          <p>Configuration properties for the specified 
          <code>xtype</code> may be specified with the Column
          configuration properties, for example:</p>
<pre>
<code>
<b>var</b> grid = 
<b>new</b> Ext.grid.GridPanel({
    ...
    columns: [{
        header: 
<em>'Last Updated'</em>,
        dataIndex: 
<em>'lastChange'</em>,
        width: 85,
        sortable: true,
        
<i>//renderer: Ext.util.Format.dateRenderer(
<em>'m/d/Y'</em>),</i>
        xtype: 
<em>'datecolumn'</em>, 
<i>// use xtype instead of renderer</i>
        format: 
<em>'M/d/Y'</em> 
<i>// configuration property 
<b>for</b> 
<a ext:cls="Ext.grid.DateColumn" href="output/Ext.grid.DateColumn.html">Ext.grid.DateColumn</a>
</i>
    }, {
        ...
    }]
});</code>
          </pre>
</div>

	 */
	
	public String getXtype () {
		return (String) getStateHelper().eval(PropertyKeys.xtype);
	}

	/**
	 * <p>
	 * Set the value of the <code>xtype</code> property.
	 * </p>
	 */
	public void setXtype ( String   xtype ) {
		getStateHelper().put(PropertyKeys.xtype, xtype);
		handleAttribute("xtype", xtype);
	}
    	/*
	 *
        
        
          resizable
         : Boolean
        Optional. 
        false to disable column resizing. Defaults to 
        true.
	 */
	
	public Boolean getResizable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.resizable);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizable</code> property.
	 * </p>
	 */
	public void setResizable ( Boolean   resizable ) {
		getStateHelper().put(PropertyKeys.resizable, resizable);
		handleAttribute("resizable", resizable);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. If the grid is being rendered
          by an 
          <a ext:cls="Ext.grid.GroupingView" href="output/Ext.grid.GroupingView.html">Ext.grid.GroupingView</a>,
          this option may be used to disable the header menu item
          to group by the column selected. Defaults to 
          <tt>true</tt>, which enables the header menu group
          option. Set to 
          <tt>false</tt> to disable (but still show) the group
          option in the header menu for the column. See also 
          <code>
            <a ext:cls="Ext.grid.Column" ext:member="groupName" href="output/Ext.grid.Column.html#Ext.grid.Column-groupName">groupName</a>
          </code>.</div>

	 */
	
	public Boolean getGroupable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.groupable);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupable</code> property.
	 * </p>
	 */
	public void setGroupable ( Boolean   groupable ) {
		getStateHelper().put(PropertyKeys.groupable, groupable);
		handleAttribute("groupable", groupable);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>For an alternative to specifying a renderer see 
          <code>
            <a ext:cls="Ext.grid.Column" ext:member="xtype" href="output/Ext.grid.Column.html#Ext.grid.Column-xtype">xtype</a>
          </code>
</p>
          <p>Optional. A renderer is an 'interceptor' method which
          can be used transform data (value, appearance, etc.)
          before it is rendered). This may be specified in either
          of three ways:</p>
          <div class="mdetail-params">
            <ul>
              <li>A renderer function used to return HTML markup
              for a cell given the cell's data value.</li>
              <li>A string which references a property name of the 
              <a ext:cls="Ext.util.Format" href="output/Ext.util.Format.html">Ext.util.Format</a> class
              which provides a renderer function.</li>
              <li>An object specifying both the renderer function,
              and its execution scope (
              <tt>
                <b>this</b>
              </tt> reference) e.g.:
<pre style="margin-left:1.2em">
<code>{
    fn: this.gridRenderer,
    scope: this
}</code>
              </pre>
</li>
            </ul>
          </div>If not specified, the default renderer uses the raw
          data value.
          <br/>
          <br/> 
          <p>For information about the renderer function (passed
          parameters, etc.), see 
          <a ext:cls="Ext.grid.ColumnModel" ext:member="setRenderer" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-setRenderer">Ext.grid.ColumnModel.setRenderer</a>.
          An example of specifying renderer function inline:</p>
<pre>
<code>
<b>var</b> companyColumn = {
   header: 
<em>'Company Name'</em>,
   dataIndex: 
<em>'company'</em>,
   renderer: 
<b>function</b>(value, metaData, record, rowIndex, colIndex, store)
{
      
<i>// provide the logic depending on business rules</i>
      
<i>// name of your own choosing to manipulate the cell depending
upon</i>
      
<i>// the data 
<b>in</b> the underlying Record object.</i>
      
<b>if</b> (value == 
<em>'whatever'</em>) {
          
<i>//metaData.css : String : A CSS class name to add to the TD
element of the cell.</i>
          
<i>//metaData.attr : String : An html attribute definition string
to apply to</i>
          
<i>//                         the data container element within the
table</i>
          
<i>//                         cell (e.g. 
<em>'style=</em>"color:red;"</i>'</code>).
          metaData.css = 
<em>'name-of-css-class-you-will-define'</em>;
      }
      
<b>return</b> value;
   }
}
          </pre>See also 
          <a ext:cls="Ext.grid.Column" ext:member="scope" href="output/Ext.grid.Column.html#Ext.grid.Column-scope">scope</a>.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getRenderer () {
		return (Object) getStateHelper().eval(PropertyKeys.renderer);
	}

	/**
	 * <p>
	 * Set the value of the <code>renderer</code> property.
	 * </p>
	 */
	public void setRenderer ( Object   renderer ) {
		getStateHelper().put(PropertyKeys.renderer, renderer);
		handleAttribute("renderer", renderer);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. An inline style definition
          string which is applied to all table cells in the column
          (excluding headers). Defaults to undefined.</div>

	 */
	
	public String getCss () {
		return (String) getStateHelper().eval(PropertyKeys.css);
	}

	/**
	 * <p>
	 * Set the value of the <code>css</code> property.
	 * </p>
	 */
	public void setCss ( String   css ) {
		getStateHelper().put(PropertyKeys.css, css);
		handleAttribute("css", css);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>Optional. If the grid is being rendered by an 
          <a ext:cls="Ext.grid.GroupingView" href="output/Ext.grid.GroupingView.html">Ext.grid.GroupingView</a>,
          this option may be used to specify the function used to
          format the grouping field value for display in the group 
          <a ext:cls="Ext.grid.Column" ext:member="groupName" href="output/Ext.grid.Column.html#Ext.grid.Column-groupName">header</a>. If a 
          <tt>
            <b>groupRenderer</b>
          </tt> is not specified, the configured 
          <tt>
            <b>
              <a ext:cls="Ext.grid.Column" ext:member="renderer" href="output/Ext.grid.Column.html#Ext.grid.Column-renderer">renderer</a>
            </b>
          </tt> will be called; if a 
          <tt>
            <b>
              <a ext:cls="Ext.grid.Column" ext:member="renderer" href="output/Ext.grid.Column.html#Ext.grid.Column-renderer">renderer</a>
            </b>
          </tt> is also not specified the new value of the group
          field will be used.</p>
          <p>The called function (either the 
          <tt>
            <b>groupRenderer</b>
          </tt> or 
          <tt>
            <b>
              <a ext:cls="Ext.grid.Column" ext:member="renderer" href="output/Ext.grid.Column.html#Ext.grid.Column-renderer">renderer</a>
            </b>
          </tt>) will be passed the following parameters:</p>
          <div class="mdetail-params">
            <ul>
              <li>
              <b>v</b> : Object
              <p class="sub-desc">The new value of the group
              field.</p>
</li>
              <li>
              <b>unused</b> : undefined
              <p class="sub-desc">Unused parameter.</p>
</li>
              <li>
              <b>r</b> : Ext.data.Record
              <p class="sub-desc">The Record providing the data for
              the row which caused group change.</p>
</li>
              <li>
              <b>rowIndex</b> : Number
              <p class="sub-desc">The row index of the Record which
              caused group change.</p>
</li>
              <li>
              <b>colIndex</b> : Number
              <p class="sub-desc">The column index of the group
              field.</p>
</li>
              <li>
              <b>ds</b> : Ext.data.Store
              <p class="sub-desc">The Store which is providing the
              data Model.</p>
</li>
            </ul>
          </div>
          <br/>
          <br/> 
          <p>The function should return a string value.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. A text string to use as the
          column header's tooltip. If Quicktips are enabled, this
          value will be used as the text of the quick tip,
          otherwise it will be set as the header's HTML title
          attribute. Defaults to ''.</div>

	 */
	
	public String getTooltip () {
		return (String) getStateHelper().eval(PropertyKeys.tooltip);
	}

	/**
	 * <p>
	 * Set the value of the <code>tooltip</code> property.
	 * </p>
	 */
	public void setTooltip ( String   tooltip ) {
		getStateHelper().put(PropertyKeys.tooltip, tooltip);
		handleAttribute("tooltip", tooltip);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "click"
					, "contextmenu"
					, "dblclick"
					, "mousedown"
				));
				return superEvent;
	}
}