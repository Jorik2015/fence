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
  <p>After the data has been read into the client side cache (
  <b>
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a>
  </b>), the ColumnModel is used to configure how and what parts of
  that data will be displayed in the vertical slices (columns) of
  the grid. The Ext.grid.ColumnModel Class is the default
  implementation of a ColumnModel used by implentations of 
  <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">GridPanel</a>.</p>
  <p>Data is mapped into the store's records and then indexed into
  the ColumnModel using the 
  <tt>
    <a ext:cls="Ext.grid.Column" ext:member="dataIndex" href="output/Ext.grid.Column.html#Ext.grid.Column-dataIndex">dataIndex</a>
  </tt>:</p>
<pre>
<code>{data source} == mapping ==&gt; {data store} == 
<b>
  <tt>
    <a ext:cls="Ext.grid.Column" ext:member="dataIndex" href="output/Ext.grid.Column.html#Ext.grid.Column-dataIndex">dataIndex</a>
  </tt>
</b> ==&gt; {ColumnModel}</code>
  </pre>
  <p>Each 
  <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Column</a> in the grid's ColumnModel is
  configured with a 
  <tt>
    <a ext:cls="Ext.grid.Column" ext:member="dataIndex" href="output/Ext.grid.Column.html#Ext.grid.Column-dataIndex">dataIndex</a>
  </tt> to specify how the data within each record in the store is
  indexed into the ColumnModel.</p>
  <p>There are two ways to initialize the ColumnModel class:</p>
  <p>
    <u>Initialization Method 1: an Array</u>
  </p>
<pre>
<code>
<b>var</b> colModel = 
<b>new</b> Ext.grid.ColumnModel([
    { header: 
<em>"Ticker"</em>, width: 60, sortable: true},
    { header: 
<em>"Company Name"</em>, width: 150, sortable: true, id: 
<em>'company'</em>},
    { header: 
<em>"Market Cap."</em>, width: 100, sortable: true},
    { header: 
<em>"$ Sales"</em>, width: 100, sortable: true, renderer: money},
    { header: 
<em>"Employees"</em>, width: 100, sortable: true, resizable: false}
 ]);</code>
  </pre>
  <p>The ColumnModel may be initialized with an Array of 
  <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> column
  configuration objects to define the initial layout / display of
  the columns in the Grid. The order of each 
  <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> column
  configuration object within the specified Array defines the
  initial order of the column display. A Column's display may be
  initially hidden using the 
  <tt>
    <a ext:cls="Ext.grid.Column" ext:member="hidden" href="output/Ext.grid.Column.html#Ext.grid.Column-hidden">hidden</a>
  </tt> config property (and then shown using the column header
  menu). Fields that are not included in the ColumnModel will not
  be displayable at all.</p>
  <p>How each column in the grid correlates (maps) to the 
  <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> field in the 
  <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a> the column draws its data from
  is configured through the 
  <b>
    <tt>
      <a ext:cls="Ext.grid.Column" ext:member="dataIndex" href="output/Ext.grid.Column.html#Ext.grid.Column-dataIndex">dataIndex</a>
    </tt>
  </b>. If the 
  <b>
    <tt>
      <a ext:cls="Ext.grid.Column" ext:member="dataIndex" href="output/Ext.grid.Column.html#Ext.grid.Column-dataIndex">dataIndex</a>
    </tt>
  </b> is not explicitly defined (as shown in the example above) it
  will use the column configuration's index in the Array as the
  index.</p>
  <p>See 
  <b>
    <tt>
      <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a>
    </tt>
  </b> for additional configuration options for each column.</p>
  <p>
    <u>Initialization Method 2: an Object</u>
  </p>
  <p>In order to use configuration options from 
  <tt>Ext.grid.ColumnModel</tt>, an Object may be used to
  initialize the ColumnModel. The column configuration Array will
  be specified in the 
  <tt>
    <b>
      <a ext:cls="Ext.grid.ColumnModel" ext:member="columns" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-columns">columns</a>
    </b>
  </tt> config property. The 
  <tt>
    <b>
      <a ext:cls="Ext.grid.ColumnModel" ext:member="defaults" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-defaults">defaults</a>
    </b>
  </tt> config property can be used to apply defaults for all
  columns, e.g.:</p>
<pre>
<code>
<b>var</b> colModel = 
<b>new</b> Ext.grid.ColumnModel({
    columns: [
        { header: 
<em>"Ticker"</em>, width: 60, menuDisabled: false},
        { header: 
<em>"Company Name"</em>, width: 150, id: 
<em>'company'</em>},
        { header: 
<em>"Market Cap."</em>},
        { header: 
<em>"$ Sales"</em>, renderer: money},
        { header: 
<em>"Employees"</em>, resizable: false}
    ],
    defaults: {
        sortable: true,
        menuDisabled: true,
        width: 100
    },
    listeners: {
        
<a ext:cls="Ext.grid.ColumnModel" ext:member="hiddenchange" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-hiddenchange">hiddenchange</a>: 
<b>function</b>(cm, colIndex, hidden) {
            saveConfig(colIndex, hidden);
        }
    }
});</code>
  </pre>
  <p>In both examples above, the ability to apply a CSS class to
  all cells in a column (including the header) is demonstrated
  through the use of the 
  <b>
    <tt>
      <a ext:cls="Ext.grid.Column" ext:member="id" href="output/Ext.grid.Column.html#Ext.grid.Column-id">id</a>
    </tt>
  </b> config option. This column could be styled by including the
  following css:</p>
<pre>
<code>
<i>//add this css *after* the core css is loaded</i>
.x-grid3-td-company {
    color: red; 
<i>// entire column will have red font</i>
}
<i>// modify the header row only, adding an icon to the column
header</i>
.x-grid3-hd-company {
    background: transparent
        url(../../resources/images/icons/silk/building.png)
        no-repeat 3px 3px ! important;
        padding-left:20px;
}</code>
  </pre>Note that the "Company Name" column could be specified as
  the 
  <b>
    <tt>
    <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">Ext.grid.GridPanel</a>.
    <a ext:cls="Ext.grid.GridPanel" ext:member="autoExpandColumn" href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-autoExpandColumn">autoExpandColumn</a>
</tt>
  </b>.</div>

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
			defaults
			,defaultSortable
			,columns
			,defaultWidth
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
<div class="long">Object literal which will be used to
          apply 
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a>
          configuration options to all 
          <tt>
            <b>
              <a ext:cls="Ext.grid.ColumnModel" ext:member="columns" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-columns">columns</a>
            </b>
          </tt>. Configuration options specified with individual 
          <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">column</a> configs will
          supersede these 
          <tt>
            <b>
              <a ext:cls="Ext.grid.ColumnModel" ext:member="defaults" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-defaults">defaults</a>
            </b>
          </tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Default sortable of columns which have
          no sortable specified (defaults to 
          <tt>false</tt>). This property shall preferably be
          configured through the 
          <tt>
            <b>
              <a ext:cls="Ext.grid.ColumnModel" ext:member="defaults" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-defaults">defaults</a>
            </b>
          </tt> config property.</div>

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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An Array of object literals. The config
          options defined by 
          <b>
            <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a>
          </b> are the options which may appear in the object
          literal for each individual column definition.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The width of columns which have no 
          <tt>
            <a ext:cls="Ext.grid.ColumnModel" ext:member="width" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-width">width</a>
          </tt> specified (defaults to 
          <tt>100</tt>). This property shall preferably be
          configured through the 
          <tt>
            <b>
              <a ext:cls="Ext.grid.ColumnModel" ext:member="defaults" href="output/Ext.grid.ColumnModel.html#Ext.grid.ColumnModel-defaults">defaults</a>
            </b>
          </tt> config property.</div>

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