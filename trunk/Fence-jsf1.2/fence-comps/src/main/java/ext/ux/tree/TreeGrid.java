package ext.ux.tree;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.JsonMode;
import ext.annotation.UXResources;
import ext.tree.TreePanel;

@UXResources(js = {"ext[version]/ux/treegrid/TreeGridSorter.js",
		"ext[version]/ux/treegrid/TreeGridColumnResizer.js",
		"ext[version]/ux/treegrid/TreeGridColumns.js",
		"ext[version]/ux/treegrid/TreeGridLoader.js",
		"ext[version]/ux/treegrid/TreeGridNodeUI.js",
		"ext[version]/ux/treegrid/TreeGrid.js" }, css = "ext[version]/ux/treegrid/treegrid.css")
public class TreeGrid extends TreePanel {
	public static final String COMPONENT_TYPE = "Ext.ux.tree.TreeGrid";
	public static final String COMPONENT_FAMILY = "Ext.ux.tree.TreeGrid";

	/**
	 * <p>
	 * Create a new {@link TreePanel} instance with default property values.
	 * </p>
	 */
	public TreeGrid() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
	
	private Object columns;

	/**
	 * An Array of object literals. The config optionsdefined by <b><a
	 * href="output/Ext.grid.Column.html"
	 * ext:cls="Ext.grid.Column">Ext.grid.Column</a></b> are the options which
	 * may appear in the object literal for each individual column definition.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getColumns() {
		if (null != this.columns) {
			return this.columns;
		}
		ValueExpression _ve = getValueExpression("columns");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns(Object columns) {
		this.columns = columns;
		this.handleConfig("columns", columns);
	}
	
	private Object store;

	/**
	 * The <a href="output/Ext.data.Store.html"
	 * ext:cls="Ext.data.Store">Ext.data.Store</a> the grid should use asits
	 * data source (required).
	 */
	@ClientConfig(JsonMode.Object)
	public Object getStore() {
		if (null != this.store) {
			return this.store;
		}
		ValueExpression _ve = getValueExpression("store");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>store</code> property.
	 * </p>
	 */
	public void setStore(Object store) {
		this.store = store;
		this.handleConfig("store", store);
	}
	
	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
		_values[1] = columns;
		_values[2] = store;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.columns = (Object) _values[1];
		this.handleConfig("columns", this.columns);
		
		this.store = (Object) _values[2];
		this.handleConfig("store", this.store);
	}
}
