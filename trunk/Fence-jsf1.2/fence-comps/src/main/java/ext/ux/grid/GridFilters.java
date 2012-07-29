package ext.ux.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.UXResources;
import ext.util.Observable;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * GridFilter is a plugin (<code>ptype=<em>'gridfilters'</em></code>) for grids that allow for a slightly
 * more robust representation of filtering than what is provided by the default
 * store.
 * </p>
 * 
 * <p>
 * Filtering is adjusted by the user using the grid's column header menu (this
 * menu can be disabled through configuration). Through this menu users can
 * configure, enable, and disable filters for each column.
 * </p>
 * 
 * <p>
 * <b><u>Features:</u></b>
 * </p>
 * 
 * <div class="mdetail-params">
 * <ul>
 * <li><b>Filtering implementations</b> :
 * 
 * <div class="sub-desc">Default filtering for Strings, Numeric Ranges, Date
 * Ranges, Lists (which can be backed by a Ext.data.Store), and Boolean.
 * Additional custom filter types and menus are easily created by extending
 * Ext.ux.grid.filter.Filter.</div></li>
 * 
 * <li><b>Graphical indicators</b> :
 * 
 * <div class="sub-desc">Columns that are filtered have <a href=
 * "output/Ext.ux.grid.GridFilters.html#Ext.ux.grid.GridFilters-filterCls"
 * ext:member="filterCls" ext:cls="Ext.ux.grid.GridFilters">a configurable css
 * class</a> applied to the column headers.</div></li>
 * 
 * <li><b>Paging</b> :
 * 
 * <div class="sub-desc">If specified as a plugin to the grid's configured
 * PagingToolbar, the current page will be reset to page 1 whenever you update
 * the filters.</div></li>
 * 
 * <li><b>Automatic Reconfiguration</b> :
 * 
 * <div class="sub-desc">Filters automatically reconfigure when the grid
 * 'reconfigure' event fires.</div></li>
 * 
 * <li><b>Stateful</b> : Filter information will be persisted across page loads
 * by specifying a <code>stateId</code> in the Grid configuration.
 * 
 * <div class="sub-desc">The filter collection binds to the
 * 
 * <code><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-beforestaterestore" ext:member="beforestaterestore" ext:cls="Ext.grid.GridPanel">beforestaterestore</a></code>
 * and
 * 
 * <code><a href="output/Ext.grid.GridPanel.html#Ext.grid.GridPanel-beforestatesave" ext:member="beforestatesave" ext:cls="Ext.grid.GridPanel">beforestatesave</a></code>
 * events in order to be stateful.</div></li>
 * 
 * <li><b>Grid Changes</b> :
 * 
 * <div class="sub-desc">
 * <ul>
 * <li>A <code>filters</code> <i>property</i> is added to the grid pointing to
 * this plugin.</li>
 * 
 * <li>A <code>filterupdate</code> <i>event</i> is added to the grid and is
 * fired upon onStateChange completion.</li>
 * </ul>
 * </div></li>
 * 
 * <li><b>Server side code examples</b> :
 * 
 * <div class="sub-desc">
 * <ul>
 * <li><a href="http://www.vinylfox.com/extjs/grid-filter-php-backend-code.php">
 * PHP</a> - (Thanks VinylFox)</li>
 * 
 * <li><a href="http://extjs.com/forum/showthread.php?p=77326#post77326">Ruby on
 * Rails</a> - (Thanks Zyclops)</li>
 * 
 * <li><a href="http://extjs.com/forum/showthread.php?p=176596#post176596">Ruby
 * on Rails</a> - (Thanks Rotomaul)</li>
 * 
 * <li><a href=
 * "http://www.debatablybeta.com/posts/using-extjss-grid-filtering-with-django/"
 * > Python</a> - (Thanks Matt)</li>
 * 
 * <li><a
 * href="http://mcantrell.wordpress.com/2008/08/22/extjs-grids-and-grails/">
 * Grails</a> - (Thanks Mike)</li>
 * </ul>
 * </div></li>
 * </ul>
 * </div>
 * 
 * <p>
 * <b><u>Example usage:</u></b>
 * </p>
 * 
 * <pre>
 * <code><b>var</b> store = <b>new</b> Ext.data.GroupingStore({
 *     ...
 * });
 *  
 * <b>var</b> filters = <b>new</b> Ext.ux.grid.GridFilters({
 *     autoReload: false, <i>//don't reload automatically
 * </i>
 *     local: true, <i>//only filter locally
 * </i>
 *     <i>// filters may be configured through the plugin,
 * </i>
 *     <i>// or <b>in</b> the column definition within the column model configuration
 * </i>
 *     filters: [{
 *         type: <em>'numeric'</em>,
 *         dataIndex: <em>'id'</em>
 *     }, {
 *         type: <em>'string'</em>,
 *         dataIndex: <em>'name'</em>
 *     }, {
 *         type: <em>'numeric'</em>,
 *         dataIndex: <em>'price'</em>
 *     }, {
 *         type: <em>'date'</em>,
 *         dataIndex: <em>'dateAdded'</em>
 *     }, {
 *         type: <em>'list'</em>,
 *         dataIndex: <em>'size'</em>,
 *         options: [<em>'extra small'</em>, <em>'small'</em>, <em>'medium'</em>, <em>'large'</em>, <em>'extra large'</em>],
 *         phpMode: true
 *     }, {
 *         type: <em>'boolean'</em>,
 *         dataIndex: <em>'visible'</em>
 *     }]
 * });
 * <b>var</b> cm = <b>new</b> Ext.grid.ColumnModel([{
 *     ...
 * }]);
 *  
 * <b>var</b> grid = <b>new</b> Ext.grid.GridPanel({
 *      ds: store,
 *      cm: cm,
 *      view: <b>new</b> Ext.grid.GroupingView(),
 *      plugins: [filters],
 *      height: 400,
 *      width: 700,
 *      bbar: <b>new</b> Ext.PagingToolbar({
 *          store: store,
 *          pageSize: 15,
 *          plugins: [filters] <i>//reset page to page 1 <b>if</b> filters change
 * </i>
 *      })
 *  });
 * 
 * store.load({params: {start: 0, limit: 15}});
 * 
 * <i>// a filters property is added to the grid
 * </i>
 * grid.filters</code>
 * </pre>
 */
//TODO others resources
@InstanceOf("Ext.ux.grid.GridFilters")
@ParseConfigMode(ui = false, name = "plugins", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
//@UXResources(js = "ext[version]/ux/gridfilters/GridFilters.js",css="ext[version]/ux/gridfilters/GridFilters.css")
public class GridFilters extends Observable {
	public static final String COMPONENT_TYPE = "Ext.ux.grid.GridFilters";
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.GridFilters";

	/**
	 * <p>
	 * Create a new {@link GridFilters} instance with default property values.
	 * </p>
	 */
	public GridFilters() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean autoReload;

	/**
	 * Defaults to true, reloading the datasource when afilter change happens.
	 * Set this to false to prevent the datastore from being reloaded if there
	 * are changes to the filters. See
	 * <code><a href="output/updateBuffer.html" ext:cls="updateBuffer">updateBuffer</a></code>
	 * .
	 */
	public Boolean getAutoReload() {
		if (null != this.autoReload) {
			return this.autoReload;
		}
		ValueExpression _ve = getValueExpression("autoReload");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoReload</code> property.
	 * </p>
	 */
	public void setAutoReload(Boolean autoReload) {
		this.autoReload = autoReload;
		this.handleConfig("autoReload", autoReload);
	}

	private Boolean encode;

	/**
	 * Specify true for <a href=
	 * "output/Ext.ux.grid.GridFilters.html#Ext.ux.grid.GridFilters-buildQuery"
	 * ext:member="buildQuery" ext:cls="Ext.ux.grid.GridFilters">buildQuery</a>
	 * to useExt.util.JSON.encode to encode the filter query parameter sent with
	 * a remote request. Defaults to false.
	 */
	public Boolean getEncode() {
		if (null != this.encode) {
			return this.encode;
		}
		ValueExpression _ve = getValueExpression("encode");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>encode</code> property.
	 * </p>
	 */
	public void setEncode(Boolean encode) {
		this.encode = encode;
		this.handleConfig("encode", encode);
	}

	private String filterCls;

	/**
	 * The css class to be applied to column headerswith active filters.
	 * Defaults to <tt>'ux-filterd-column'</tt>.
	 */
	public String getFilterCls() {
		if (null != this.filterCls) {
			return this.filterCls;
		}
		ValueExpression _ve = getValueExpression("filterCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>filterCls</code> property.
	 * </p>
	 */
	public void setFilterCls(String filterCls) {
		this.filterCls = filterCls;
		this.handleConfig("filterCls", filterCls);
	}

	private Object filters;

	/**
	 * An Array of filters config objects. Refer to eachfilter type class for
	 * configuration details specific to each filter type. Filters for Strings,
	 * Numeric Ranges, Date Ranges, Lists, and Boolean are the standard filters
	 * available.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getFilters() {
		if (null != this.filters) {
			return this.filters;
		}
		ValueExpression _ve = getValueExpression("filters");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>filters</code> property.
	 * </p>
	 */
	public void setFilters(Object filters) {
		this.filters = filters;
		this.handleConfig("filters", filters);
	}

	private Boolean local;

	/**
	 * <tt>true</tt> to use Ext.data.Store filterfunctions (local filtering)
	 * instead of the default (<tt>false</tt>) server side filtering.
	 */
	public Boolean getLocal() {
		if (null != this.local) {
			return this.local;
		}
		ValueExpression _ve = getValueExpression("local");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>local</code> property.
	 * </p>
	 */
	public void setLocal(Boolean local) {
		this.local = local;
		this.handleConfig("local", local);
	}

	private String menuFilterText;

	/**
	 * defaults to <tt>'Filters'</tt>.
	 */
	public String getMenuFilterText() {
		if (null != this.menuFilterText) {
			return this.menuFilterText;
		}
		ValueExpression _ve = getValueExpression("menuFilterText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>menuFilterText</code> property.
	 * </p>
	 */
	public void setMenuFilterText(String menuFilterText) {
		this.menuFilterText = menuFilterText;
		this.handleConfig("menuFilterText", menuFilterText);
	}

	private String paramPrefix;

	/**
	 * The url parameter prefix for the filters.Defaults to <tt>'filter'</tt>.
	 */
	public String getParamPrefix() {
		if (null != this.paramPrefix) {
			return this.paramPrefix;
		}
		ValueExpression _ve = getValueExpression("paramPrefix");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>paramPrefix</code> property.
	 * </p>
	 */
	public void setParamPrefix(String paramPrefix) {
		this.paramPrefix = paramPrefix;
		this.handleConfig("paramPrefix", paramPrefix);
	}

	private Boolean showMenu;

	/**
	 * Defaults to true, including a filter submenu inthe default header menu.
	 */
	public Boolean getShowMenu() {
		if (null != this.showMenu) {
			return this.showMenu;
		}
		ValueExpression _ve = getValueExpression("showMenu");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>showMenu</code> property.
	 * </p>
	 */
	public void setShowMenu(Boolean showMenu) {
		this.showMenu = showMenu;
		this.handleConfig("showMenu", showMenu);
	}

	private String stateId;

	/**
	 * Name of the value to be used to store stateinformation.
	 */
	public String getStateId() {
		if (null != this.stateId) {
			return this.stateId;
		}
		ValueExpression _ve = getValueExpression("stateId");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>stateId</code> property.
	 * </p>
	 */
	public void setStateId(String stateId) {
		this.stateId = stateId;
		this.handleConfig("stateId", stateId);
	}

	private Integer updateBuffer;

	/**
	 * Number of milliseconds to defer store updatessince the last filter
	 * change.
	 */
	public Integer getUpdateBuffer() {
		if (null != this.updateBuffer) {
			return this.updateBuffer;
		}
		ValueExpression _ve = getValueExpression("updateBuffer");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>updateBuffer</code> property.
	 * </p>
	 */
	public void setUpdateBuffer(Integer updateBuffer) {
		this.updateBuffer = updateBuffer;
		this.handleConfig("updateBuffer", updateBuffer);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[11];
		}
		_values[0] = super.saveState(_context);
		_values[1] = autoReload;
		_values[2] = encode;
		_values[3] = filterCls;
		_values[4] = filters;
		_values[5] = local;
		_values[6] = menuFilterText;
		_values[7] = paramPrefix;
		_values[8] = showMenu;
		_values[9] = stateId;
		_values[10] = updateBuffer;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.autoReload = (Boolean) _values[1];
		this.handleConfig("autoReload", this.autoReload);
		this.encode = (Boolean) _values[2];
		this.handleConfig("encode", this.encode);
		this.filterCls = (String) _values[3];
		this.handleConfig("filterCls", this.filterCls);
		this.filters = (Object) _values[4];
		this.handleConfig("filters", this.filters);
		this.local = (Boolean) _values[5];
		this.handleConfig("local", this.local);
		this.menuFilterText = (String) _values[6];
		this.handleConfig("menuFilterText", this.menuFilterText);
		this.paramPrefix = (String) _values[7];
		this.handleConfig("paramPrefix", this.paramPrefix);
		this.showMenu = (Boolean) _values[8];
		this.handleConfig("showMenu", this.showMenu);
		this.stateId = (String) _values[9];
		this.handleConfig("stateId", this.stateId);
		this.updateBuffer = (Integer) _values[10];
		this.handleConfig("updateBuffer", this.updateBuffer);

	}
}