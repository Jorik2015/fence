package ext.list;

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
    Ext.list.ListView is a fast and light-weight implentation of
    a 
    Grid like view with the
    following characteristics:
    
      
        resizable columns
        selectable
        column widths are initially proportioned by percentage
        based on the container width and number of columns
        uses templates to render the data in any required
        format
        no horizontal scrolling
        no editing
      
    
    Example usage:


// consume JSON of this form:
{
   
"images":[
      {
         
"name":
"dance_fever.jpg",
         
"size":2067,
         
"lastmod":1236974993000,
         
"url":
"images\/thumbs\/dance_fever.jpg"
      },
      {
         
"name":
"zack_sink.jpg",
         
"size":2303,
         
"lastmod":1236974993000,
         
"url":
"images\/thumbs\/zack_sink.jpg"
      }
   ]
}
var store = 
new Ext.data.JsonStore({
    url: 
'get-images.php',
    root: 
'images',
    fields: [
        
'name', 
'url',
        {name:
'size', type: 
'float'},
        {name:
'lastmod', type:
'date', dateFormat:
'timestamp'}
    ]
});
store.load();

var listView = 
new Ext.list.ListView({
    store: store,
    multiSelect: true,
    emptyText: 
'No images to display',
    reserveScrollOffset: true,
    columns: [{
        header: 
'File',
        width: .5,
        dataIndex: 
'name'
    },{
        header: 
'Last Modified',
        width: .35,
        dataIndex: 
'lastmod',
        tpl: 
'{lastmod:date("m-d h:i a")}'
    },{
        header: 
'Size',
        dataIndex: 
'size',
        tpl: 
'{size:fileSize}', 
// format using Ext.util.Format.fileSize()
        align: 
'right'
    }]
});

// put it 
in a Panel so it looks pretty
var panel = 
new Ext.Panel({
    id:
'images-view',
    width:425,
    height:250,
    collapsible:true,
    layout:
'fit',
    title:
'Simple ListView 
(0 items selected)',
    items: listView
});
panel.render(document.body);

// little bit of feedback
listView.on(
'selectionchange', 
function(view, nodes){
    
var l = nodes.length;
    
var s = l != 1 ? 
's' : 
'';
    panel.setTitle(
'Simple ListView 
('+l+' item'+s+
' selected)');
});
    
  
 */

@InstanceOf("Ext.list.ListView")
@ParseConfigMode(ui = false,name="view",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.list.ListView")
public class ListView extends DataView {
	public static final String COMPONENT_FAMILY = "Ext.list.ListView";

	/**
	 * <p>
	 * Create a new {@link Ext.list.ListView} instance with default property values.
	 * </p>
	 */
	public ListView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			internalTpl
			,hideHeaders
			,reserveScrollOffset
			,itemSelector
			,columnSort
			,selectedClass
			,overClass
			,columns
			,scrollOffset
			,columnResize
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
        
        
          internalTpl
         : String/Array
        The template to be used for the header
        row. See 
        tpl for
        more details.
	 */
	@ClientConfig(JsonMode.Array)

	public Object getInternalTpl () {
		return (Object) getStateHelper().eval(PropertyKeys.internalTpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>internalTpl</code> property.
	 * </p>
	 */
	public void setInternalTpl ( Object   internalTpl ) {
		getStateHelper().put(PropertyKeys.internalTpl, internalTpl);
		handleAttribute("internalTpl", internalTpl);
	}
    	/*
	 *
        
        
          hideHeaders
         : Boolean
        
        true to hide the 
        header row (defaults to 
        false so the 
        header row will be
        shown).
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
	 *By default will defer accounting for
          the configured 
          
            
              scrollOffset
            
           for 10 milliseconds. Specify 
          true to account for the configured 
          
            
              scrollOffset
            
           immediately.
	 */
	
	public Boolean getReserveScrollOffset () {
		return (Boolean) getStateHelper().eval(PropertyKeys.reserveScrollOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>reserveScrollOffset</code> property.
	 * </p>
	 */
	public void setReserveScrollOffset ( Boolean   reserveScrollOffset ) {
		getStateHelper().put(PropertyKeys.reserveScrollOffset, reserveScrollOffset);
		handleAttribute("reserveScrollOffset", reserveScrollOffset);
	}
    	/*
	 *Defaults to 
          'dl' to work with the preconfigured 
          
            
              tpl
            
          . This setting specifies the CSS selector (e.g. 
          div.some-class or 
          span:first-child) that will be used to determine
          what nodes the ListView will be working with.
	 */
	
	public String getItemSelector () {
		return (String) getStateHelper().eval(PropertyKeys.itemSelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemSelector</code> property.
	 * </p>
	 */
	public void setItemSelector ( String   itemSelector ) {
		getStateHelper().put(PropertyKeys.itemSelector, itemSelector);
		handleAttribute("itemSelector", itemSelector);
	}
    	/*
	 *Specify 
          true or specify a configuration object for 
          Ext.list.ListView.Sorter
          to enable the columns to be sortable (defaults to 
          true).
	 */
	
	public Boolean getColumnSort () {
		return (Boolean) getStateHelper().eval(PropertyKeys.columnSort);
	}

	/**
	 * <p>
	 * Set the value of the <code>columnSort</code> property.
	 * </p>
	 */
	public void setColumnSort ( Boolean   columnSort ) {
		getStateHelper().put(PropertyKeys.columnSort, columnSort);
		handleAttribute("columnSort", columnSort);
	}
    	/*
	 *The CSS class applied to a selected row
          (defaults to 
          'x-list-selected'). An example overriding the
          default styling: 

.x-list-selected {background-color: yellow;}
          
	 */
	
	public String getSelectedClass () {
		return (String) getStateHelper().eval(PropertyKeys.selectedClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>selectedClass</code> property.
	 * </p>
	 */
	public void setSelectedClass ( String   selectedClass ) {
		getStateHelper().put(PropertyKeys.selectedClass, selectedClass);
		handleAttribute("selectedClass", selectedClass);
	}
    	/*
	 *The CSS class applied when over a row
          (defaults to 
          'x-list-over'). An example overriding the
          default styling: 

.x-list-over {background-color: orange;}
          
	 */
	
	public String getOverClass () {
		return (String) getStateHelper().eval(PropertyKeys.overClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>overClass</code> property.
	 * </p>
	 */
	public void setOverClass ( String   overClass ) {
		getStateHelper().put(PropertyKeys.overClass, overClass);
		handleAttribute("overClass", overClass);
	}
    	/*
	 *An array of column configuration
          objects, for example: 

{
    align: 
'right',
    dataIndex: 
'size',
    header: 
'Size',
    tpl: 
'{size:fileSize}',
    width: .35
}
          Acceptable properties for each column configuration
          object are: 
          
            
              
              
                align
               : String
              Set the CSS text-align property
              of the column. Defaults to 
              'left'.
              
              
                dataIndex
               : String
              See 
              Ext.grid.Column. 
              dataIndex for
              details.
              
              
                header
               : String
              See 
              Ext.grid.Column. 
              header for
              details.
              
              
                tpl
               : String
              Specify a string to pass as the
              configuration string for 
              Ext.XTemplate. By default
              an 
              Ext.XTemplate will be
              implicitly created using the 
              dataIndex.
              
              
                width
               : Number
              Percentage of the container
              width this column should be allocated. Columns that
              have no width specified will be allocated with an
              equal percentage to fill 100% of the container width.
              To easily take advantage of the full container width,
              leave the width of at least one column undefined.
              Note that if you do not want to take up the full
              width of the container, the width of every column
              needs to be explicitly defined.
            
          
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
	 *The amount of space to reserve for the
          scrollbar (defaults to 
          undefined). If an explicit value isn't
          specified, this will be automatically calculated.
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
	 *Specify 
          true or specify a configuration object for 
          Ext.list.ListView.ColumnResizer
          to enable the columns to be resizable (defaults to 
          true).
	 */
	
	public Boolean getColumnResize () {
		return (Boolean) getStateHelper().eval(PropertyKeys.columnResize);
	}

	/**
	 * <p>
	 * Set the value of the <code>columnResize</code> property.
	 * </p>
	 */
	public void setColumnResize ( Boolean   columnResize ) {
		getStateHelper().put(PropertyKeys.columnResize, columnResize);
		handleAttribute("columnResize", columnResize);
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