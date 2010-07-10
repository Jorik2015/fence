package ext.ux.grid;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
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
 GridFilter is a plugin ( ptype= 'gridfilters') for grids that allow for a slightly more robust representation of
 * filtering than what is provided by the default store. Filtering is adjusted by the user using the grid's column
 * header menu (this menu can be disabled through configuration). Through this menu users can configure, enable, and
 * disable filters for each column.
 * 
 * 
 * Features:
 * 
 * 
 * 
 * 
 * 
 * Filtering implementations : Default filtering for Strings, Numeric Ranges, Date Ranges, Lists (which can be backed by
 * a Ext.data.Store), and Boolean. Additional custom filter types and menus are easily created by extending
 * Ext.ux.grid.filter.Filter.
 * 
 * Graphical indicators : Columns that are filtered have a configurable css class applied to the column headers.
 * 
 * Paging : If specified as a plugin to the grid's configured PagingToolbar, the current page will be reset to page 1
 * whenever you update the filters.
 * 
 * Automatic Reconfiguration : Filters automatically reconfigure when the grid 'reconfigure' event fires.
 * 
 * Stateful : Filter information will be persisted across page loads by specifying a stateId in the Grid configuration.
 * The filter collection binds to the
 * 
 * beforestaterestore and
 * 
 * beforestatesave events in order to be stateful.
 * 
 * Grid Changes :
 * 
 * 
 * A filters property is added to the grid pointing to this plugin. A filterupdate event is added to the grid and is
 * fired upon onStateChange completion.
 * 
 * 
 * 
 * Server side code examples :
 * 
 * 
 * 
 * PHP - (Thanks VinylFox)
 * 
 * Ruby on Rails - (Thanks Zyclops)
 * 
 * Ruby on Rails - (Thanks Rotomaul)
 * 
 * Python - (Thanks Matt)
 * 
 * Grails - (Thanks Mike)
 * 
 * 
 * 
 * 
 * 
 * 
 * Example usage:
 * 
 * 
 * 
 * 
 * var store = new Ext.data.GroupingStore({ ... });
 * 
 * var filters = new Ext.ux.grid.GridFilters({ autoReload: false, //don't reload automatically
 * 
 * local: true, //only filter locally
 * 
 * 
 * // filters may be configured through the plugin,
 * 
 * 
 * // or in the column definition within the column model configuration
 * 
 * filters: [{ type: 'numeric', dataIndex: 'id' }, { type: 'string', dataIndex: 'name' }, { type: 'numeric', dataIndex:
 * 'price' }, { type: 'date', dataIndex: 'dateAdded' }, { type: 'list', dataIndex: 'size', options: [ 'extra small',
 * 'small', 'medium', 'large', 'extra large'], phpMode: true }, { type: 'boolean', dataIndex: 'visible' }] }); var cm =
 * new Ext.grid.ColumnModel([{ ... }]);
 * 
 * var grid = new Ext.grid.GridPanel({ ds: store, cm: cm, view: new Ext.grid.GroupingView(), plugins: [filters], height:
 * 400, width: 700, bbar: new Ext.PagingToolbar({ store: store, pageSize: 15, plugins: [filters] //reset page to page 1
 * if filters change
 * 
 * }) });
 * 
 * store.load({params: {start: 0, limit: 15}});
 * 
 * // a filters property is added to the grid
 * 
 * grid.filters
 */

@InstanceOf("Ext.ux.grid.GridFilters")
@ResourceDependencies( { @ResourceDependency(library = "ext#{ext.version}/ux/gridfilters", name = "GridFilters.js"),
		@ResourceDependency(library = "ext#{ext.version}/ux/menu", name = "ListMenu.js"),
		@ResourceDependency(library = "ext#{ext.version}/ux/menu", name = "RangeMenu.js"),
		@ResourceDependency(library = "ext#{ext.version}/ux/css", name = "GridFilters.css"),
		@ResourceDependency(library = "ext#{ext.version}/ux/css", name = "RangeMenu.css"),
		@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "Filter.js"), })
@ParseConfigMode(ui = false, name = "plugins", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
@FacesComponent(value = "Ext.ux.grid.GridFilters")
public class GridFilters extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.GridFilters";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.GridFilters} instance with default property values.
	 * </p>
	 */
	public GridFilters() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	enum PropertyKeys {
		showMenu, autoReload, local, filterCls, paramPrefix, menuFilterText, updateBuffer, filters, stateId, encode;
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
	 * 
	 * 
	 * showMenu : Boolean Defaults to true, including a filter submenu in the default header menu.
	 */

	public Boolean getShowMenu() {
		return (Boolean) getStateHelper().eval(PropertyKeys.showMenu);
	}

	/**
	 * <p>
	 * Set the value of the <code>showMenu</code> property.
	 * </p>
	 */
	public void setShowMenu(Boolean showMenu) {
		getStateHelper().put(PropertyKeys.showMenu, showMenu);
		handleAttribute("showMenu", showMenu);
	}

	/*
	 * Defaults to true, reloading the datasource when a filter change happens. Set this to false to prevent the
	 * datastore from being reloaded if there are changes to the filters. See
	 * 
	 * updateBuffer .
	 */

	public Boolean getAutoReload() {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoReload);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoReload</code> property.
	 * </p>
	 */
	public void setAutoReload(Boolean autoReload) {
		getStateHelper().put(PropertyKeys.autoReload, autoReload);
		handleAttribute("autoReload", autoReload);
	}

	/*
	 * 
	 * 
	 * 
	 * local : Boolean
	 * 
	 * true to use Ext.data.Store filter functions (local filtering) instead of the default ( false) server side
	 * filtering.
	 */

	public Boolean getLocal() {
		return (Boolean) getStateHelper().eval(PropertyKeys.local);
	}

	/**
	 * <p>
	 * Set the value of the <code>local</code> property.
	 * </p>
	 */
	public void setLocal(Boolean local) {
		getStateHelper().put(PropertyKeys.local, local);
		handleAttribute("local", local);
	}

	/*
	 * 
	 * 
	 * 
	 * filterCls : String The css class to be applied to column headers with active filters. Defaults to
	 * 'ux-filterd-column'.
	 */

	public String getFilterCls() {
		return (String) getStateHelper().eval(PropertyKeys.filterCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>filterCls</code> property.
	 * </p>
	 */
	public void setFilterCls(String filterCls) {
		getStateHelper().put(PropertyKeys.filterCls, filterCls);
		handleAttribute("filterCls", filterCls);
	}

	/*
	 * 
	 * 
	 * 
	 * paramPrefix : String The url parameter prefix for the filters. Defaults to 'filter'.
	 */

	public String getParamPrefix() {
		return (String) getStateHelper().eval(PropertyKeys.paramPrefix);
	}

	/**
	 * <p>
	 * Set the value of the <code>paramPrefix</code> property.
	 * </p>
	 */
	public void setParamPrefix(String paramPrefix) {
		getStateHelper().put(PropertyKeys.paramPrefix, paramPrefix);
		handleAttribute("paramPrefix", paramPrefix);
	}

	/*
	 * 
	 * 
	 * 
	 * menuFilterText : String defaults to 'Filters'.
	 */

	public String getMenuFilterText() {
		return (String) getStateHelper().eval(PropertyKeys.menuFilterText);
	}

	/**
	 * <p>
	 * Set the value of the <code>menuFilterText</code> property.
	 * </p>
	 */
	public void setMenuFilterText(String menuFilterText) {
		getStateHelper().put(PropertyKeys.menuFilterText, menuFilterText);
		handleAttribute("menuFilterText", menuFilterText);
	}

	/*
	 * 
	 * 
	 * 
	 * updateBuffer : Integer Number of milliseconds to defer store updates since the last filter change.
	 */

	public Integer getUpdateBuffer() {
		return (Integer) getStateHelper().eval(PropertyKeys.updateBuffer);
	}

	/**
	 * <p>
	 * Set the value of the <code>updateBuffer</code> property.
	 * </p>
	 */
	public void setUpdateBuffer(Integer updateBuffer) {
		getStateHelper().put(PropertyKeys.updateBuffer, updateBuffer);
		handleAttribute("updateBuffer", updateBuffer);
	}

	/*
	 * An Array of filters config objects. Refer to each filter type class for configuration details specific to each
	 * filter type. Filters for Strings, Numeric Ranges, Date Ranges, Lists, and Boolean are the standard filters
	 * available.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getFilters() {
		return (Object) getStateHelper().eval(PropertyKeys.filters);
	}

	/**
	 * <p>
	 * Set the value of the <code>filters</code> property.
	 * </p>
	 */
	public void setFilters(Object filters) {
		getStateHelper().put(PropertyKeys.filters, filters);
		handleAttribute("filters", filters);
	}

	/*
	 * 
	 * 
	 * 
	 * stateId : String Name of the value to be used to store state information.
	 */

	public String getStateId() {
		return (String) getStateHelper().eval(PropertyKeys.stateId);
	}

	/**
	 * <p>
	 * Set the value of the <code>stateId</code> property.
	 * </p>
	 */
	public void setStateId(String stateId) {
		getStateHelper().put(PropertyKeys.stateId, stateId);
		handleAttribute("stateId", stateId);
	}

	/*
	 * Specify true for buildQuery to use Ext.util.JSON.encode to encode the filter query parameter sent with a remote
	 * request. Defaults to false.
	 */

	public Boolean getEncode() {
		return (Boolean) getStateHelper().eval(PropertyKeys.encode);
	}

	/**
	 * <p>
	 * Set the value of the <code>encode</code> property.
	 * </p>
	 */
	public void setEncode(Boolean encode) {
		getStateHelper().put(PropertyKeys.encode, encode);
		handleAttribute("encode", encode);
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