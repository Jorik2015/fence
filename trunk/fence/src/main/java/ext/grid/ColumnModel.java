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
  After the data has been read into the client side cache (
  
    Store
  ), the ColumnModel is used to configure how and what parts of
  that data will be displayed in the vertical slices (columns) of
  the grid. The Ext.grid.ColumnModel Class is the default
  implementation of a ColumnModel used by implentations of 
  GridPanel.
  Data is mapped into the store's records and then indexed into
  the ColumnModel using the 
  
    dataIndex
  :

{data source} == mapping ==> {data store} == 

  
    dataIndex
  
 ==> {ColumnModel}
  
  Each 
  Column in the grid's ColumnModel is
  configured with a 
  
    dataIndex
   to specify how the data within each record in the store is
  indexed into the ColumnModel.
  There are two ways to initialize the ColumnModel class:
  
    Initialization Method 1: an Array
  


var colModel = 
new Ext.grid.ColumnModel([
    { header: 
"Ticker", width: 60, sortable: true},
    { header: 
"Company Name", width: 150, sortable: true, id: 
'company'},
    { header: 
"Market Cap.", width: 100, sortable: true},
    { header: 
"$ Sales", width: 100, sortable: true, renderer: money},
    { header: 
"Employees", width: 100, sortable: true, resizable: false}
 ]);
  
  The ColumnModel may be initialized with an Array of 
  Ext.grid.Column column
  configuration objects to define the initial layout / display of
  the columns in the Grid. The order of each 
  Ext.grid.Column column
  configuration object within the specified Array defines the
  initial order of the column display. A Column's display may be
  initially hidden using the 
  
    hidden
   config property (and then shown using the column header
  menu). Fields that are not included in the ColumnModel will not
  be displayable at all.
  How each column in the grid correlates (maps) to the 
  Ext.data.Record field in the 
  Store the column draws its data from
  is configured through the 
  
    
      dataIndex
    
  . If the 
  
    
      dataIndex
    
   is not explicitly defined (as shown in the example above) it
  will use the column configuration's index in the Array as the
  index.
  See 
  
    
      Ext.grid.Column
    
   for additional configuration options for each column.
  
    Initialization Method 2: an Object
  
  In order to use configuration options from 
  Ext.grid.ColumnModel, an Object may be used to
  initialize the ColumnModel. The column configuration Array will
  be specified in the 
  
    
      columns
    
   config property. The 
  
    
      defaults
    
   config property can be used to apply defaults for all
  columns, e.g.:


var colModel = 
new Ext.grid.ColumnModel({
    columns: [
        { header: 
"Ticker", width: 60, menuDisabled: false},
        { header: 
"Company Name", width: 150, id: 
'company'},
        { header: 
"Market Cap."},
        { header: 
"$ Sales", renderer: money},
        { header: 
"Employees", resizable: false}
    ],
    defaults: {
        sortable: true,
        menuDisabled: true,
        width: 100
    },
    listeners: {
        
hiddenchange: 
function(cm, colIndex, hidden) {
            saveConfig(colIndex, hidden);
        }
    }
});
  
  In both examples above, the ability to apply a CSS class to
  all cells in a column (including the header) is demonstrated
  through the use of the 
  
    
      id
    
   config option. This column could be styled by including the
  following css:


//add this css *after* the core css is loaded
.x-grid3-td-company {
    color: red; 
// entire column will have red font
}
// modify the header row only, adding an icon to the column
header
.x-grid3-hd-company {
    background: transparent
        url(../../resources/images/icons/silk/building.png)
        no-repeat 3px 3px ! important;
        padding-left:20px;
}
  Note that the "Company Name" column could be specified as
  the 
  
    
    Ext.grid.GridPanel.
    autoExpandColumn
  .
 */

@InstanceOf("Ext.grid.ColumnModel")
@ParseConfigMode(ui = false,name="cm",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.ColumnModel")
public class ColumnModel extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.grid.ColumnModel";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.ColumnModel} instance with default property values.
	 * </p>
	 */
	public ColumnModel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			defaultWidth
			,defaults
			,columns
			,defaultSortable
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
	 *The width of columns which have no 
          
            width
           specified (defaults to 
          100). This property shall preferably be
          configured through the 
          
            
              defaults
            
           config property.
	 */
	
	public Integer getDefaultWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.defaultWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultWidth</code> property.
	 * </p>
	 */
	public void setDefaultWidth ( Integer   defaultWidth ) {
		getStateHelper().put(PropertyKeys.defaultWidth, defaultWidth);
		handleAttribute("defaultWidth", defaultWidth);
	}
    	/*
	 *Object literal which will be used to
          apply 
          Ext.grid.Column
          configuration options to all 
          
            
              columns
            
          . Configuration options specified with individual 
          column configs will
          supersede these 
          
            
              defaults
            
          .
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaults () {
		return (Object) getStateHelper().eval(PropertyKeys.defaults);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaults</code> property.
	 * </p>
	 */
	public void setDefaults ( Object   defaults ) {
		getStateHelper().put(PropertyKeys.defaults, defaults);
		handleAttribute("defaults", defaults);
	}
    	/*
	 *An Array of object literals. The config
          options defined by 
          
            Ext.grid.Column
           are the options which may appear in the object
          literal for each individual column definition.
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
	 *Default sortable of columns which have
          no sortable specified (defaults to 
          false). This property shall preferably be
          configured through the 
          
            
              defaults
            
           config property.
	 */
	
	public Boolean getDefaultSortable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.defaultSortable);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultSortable</code> property.
	 * </p>
	 */
	public void setDefaultSortable ( Boolean   defaultSortable ) {
		getStateHelper().put(PropertyKeys.defaultSortable, defaultSortable);
		handleAttribute("defaultSortable", defaultSortable);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "columnmoved"
					, "configchange"
					, "headerchange"
					, "hiddenchange"
					, "widthchange"
				));
				return superEvent;
	}
}