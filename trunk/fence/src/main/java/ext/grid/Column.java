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
    This class encapsulates column configuration data to be used
    in the initialization of a 
    ColumnModel.
    While subclasses are provided to render data in different
    ways, this class renders a passed data field unchanged and is
    usually used for textual columns.
  
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
			editable
			,width
			,renderer
			,groupable
			,tooltip
			,menuDisabled
			,header
			,fixed
			,groupName
			,hideable
			,editor
			,groupRenderer
			,resizable
			,hidden
			,align
			,scope
			,xtype
			,dataIndex
			,sortable
			,css
			,emptyGroupText
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
	 *Optional. Defaults to 
          true, enabling the configured 
          
            editor
          . Set to 
          false to initially disable editing on this
          column. The initial configuration may be dynamically
          altered using 
          Ext.grid.ColumnModel.
          setEditable().
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
	 *Optional. The initial width in pixels
          of the column. The width of each column can also be
          affected if any of the following are configured: 
          
            
              
              Ext.grid.GridPanel.
              
                autoExpandColumn
              
              
              Ext.grid.GridView.
              
                forceFit
               
              
                By specifying 
                forceFit:true, 
                non-fixed width
                columns will be re-proportioned (based on the
                relative initial widths) to fill the width of the
                grid so that no horizontal scrollbar is shown.
              
              
              Ext.grid.GridView.
              
                autoFill
              
              
              Ext.grid.GridPanel.
              
                minColumnWidth
              
              
                
                
                Note: when the width of each column is
                determined, a space on the right side is reserved
                for the vertical scrollbar. The 
                Ext.grid.GridView.
                
                  scrollOffset
                 can be modified to reduce or eliminate the
                reserved offset.
              
            
          
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
	 *
          For an alternative to specifying a renderer see 
          
            xtype
          
          Optional. A renderer is an 'interceptor' method which
          can be used transform data (value, appearance, etc.)
          before it is rendered). This may be specified in either
          of three ways:
          
            
              A renderer function used to return HTML markup
              for a cell given the cell's data value.
              A string which references a property name of the 
              Ext.util.Format class
              which provides a renderer function.
              An object specifying both the renderer function,
              and its execution scope (
              
                this
               reference) e.g.:

{
    fn: this.gridRenderer,
    scope: this
}
              
            
          If not specified, the default renderer uses the raw
          data value.
          
           
          For information about the renderer function (passed
          parameters, etc.), see 
          Ext.grid.ColumnModel.setRenderer.
          An example of specifying renderer function inline:


var companyColumn = {
   header: 
'Company Name',
   dataIndex: 
'company',
   renderer: 
function(value, metaData, record, rowIndex, colIndex, store)
{
      
// provide the logic depending on business rules
      
// name of your own choosing to manipulate the cell depending
upon
      
// the data 
in the underlying Record object.
      
if (value == 
'whatever') {
          
//metaData.css : String : A CSS class name to add to the TD
element of the cell.
          
//metaData.attr : String : An html attribute definition string
to apply to
          
//                         the data container element within the
table
          
//                         cell (e.g. 
'style="color:red;"').
          metaData.css = 
'name-of-css-class-you-will-define';
      }
      
return value;
   }
}
          See also 
          scope.
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
	 *Optional. If the grid is being rendered
          by an 
          Ext.grid.GroupingView,
          this option may be used to disable the header menu item
          to group by the column selected. Defaults to 
          true, which enables the header menu group
          option. Set to 
          false to disable (but still show) the group
          option in the header menu for the column. See also 
          
            groupName
          .
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
	 *Optional. A text string to use as the
          column header's tooltip. If Quicktips are enabled, this
          value will be used as the text of the quick tip,
          otherwise it will be set as the header's HTML title
          attribute. Defaults to ''.
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
	 *Optional. The header text to be used as
          innerHTML (html tags are accepted) to display in the Grid
          view. 
          Note: to have a clickable header with no text
          displayed use 
          ' '.
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
	 *Optional. If the grid is being rendered
          by an 
          Ext.grid.GroupingView,
          this option may be used to specify the text with which to
          prefix the group field value in the group header line.
          See also 
          groupRenderer and 
          Ext.grid.GroupingView.
          showGroupName.
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
	 *Optional. Specify as 
          false to prevent the user from hiding this
          column (defaults to true). To disallow column hiding
          globally for all columns in the grid, use 
          Ext.grid.GridPanel.enableColumnHide
          instead.
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
	 *Optional. The 
          Ext.form.Field to use when
          editing values in this column if editing is supported by
          the grid. See 
          
            editable
           also.
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
          Optional. If the grid is being rendered by an 
          Ext.grid.GroupingView,
          this option may be used to specify the function used to
          format the grouping field value for display in the group 
          header. If a 
          
            groupRenderer
           is not specified, the configured 
          
            
              renderer
            
           will be called; if a 
          
            
              renderer
            
           is also not specified the new value of the group
          field will be used.
          The called function (either the 
          
            groupRenderer
           or 
          
            
              renderer
            
          ) will be passed the following parameters:
          
            
              
              v : Object
              The new value of the group
              field.
              
              unused : undefined
              Unused parameter.
              
              r : Ext.data.Record
              The Record providing the data for
              the row which caused group change.
              
              rowIndex : Number
              The row index of the Record which
              caused group change.
              
              colIndex : Number
              The column index of the group
              field.
              
              ds : Ext.data.Store
              The Store which is providing the
              data Model.
            
          
          
           
          The function should return a string value.
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
	 *Optional. 
          true to initially hide this column. Defaults to 
          false. A hidden column 
          may be shown via the header
          row menu. If a column is never to be shown, simply do
          not include this column in the Column Model at all.
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
	 *Optional. A String which references a
          predefined 
          Ext.grid.Column subclass
          type which is preconfigured with an appropriate 
          
            renderer
           to be easily configured into a ColumnModel. The
          predefined 
          Ext.grid.Column subclass
          types are: 
          
            
              
              
                gridcolumn
               : 
              Ext.grid.Column (
              Default)
              
              
                booleancolumn
               : 
              Ext.grid.BooleanColumn
              
              
                numbercolumn
               : 
              Ext.grid.NumberColumn
              
              
                datecolumn
               : 
              Ext.grid.DateColumn
              
              
                templatecolumn
               : 
              Ext.grid.TemplateColumn
            
          
          Configuration properties for the specified 
          xtype may be specified with the Column
          configuration properties, for example:


var grid = 
new Ext.grid.GridPanel({
    ...
    columns: [{
        header: 
'Last Updated',
        dataIndex: 
'lastChange',
        width: 85,
        sortable: true,
        
//renderer: Ext.util.Format.dateRenderer(
'm/d/Y'),
        xtype: 
'datecolumn', 
// use xtype instead of renderer
        format: 
'M/d/Y' 
// configuration property 
for 
Ext.grid.DateColumn
    }, {
        ...
    }]
});
          
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
            
            Required. The name of the field in the grid's 
            Ext.data.Store's 
            Ext.data.Record
            definition from which to draw the column's value.
          
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
	 *Optional. 
          true if sorting is to be allowed on this column.
          Defaults to the value of the 
          
            Ext.grid.ColumnModel.defaultSortable
           property. Whether local/remote sorting is used is
          specified in 
          
            Ext.data.Store.remoteSort
          .
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
	 *Optional. An inline style definition
          string which is applied to all table cells in the column
          (excluding headers). Defaults to undefined.
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
	 *Optional. If the grid is being rendered
          by an 
          Ext.grid.GroupingView,
          this option may be used to specify the text to display
          when there is an empty group value. Defaults to the 
          Ext.grid.GroupingView.
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