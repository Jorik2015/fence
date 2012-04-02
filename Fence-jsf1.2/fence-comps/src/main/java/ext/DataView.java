package ext;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. A mechanism
 * for displaying data using custom layout templates and formatting. DataView
 * uses an <a href="output/Ext.XTemplate.html"
 * ext:cls="Ext.XTemplate">Ext.XTemplate</a> as its internal templating
 * mechanism, and is bound to an <a href="output/Ext.data.Store.html"
 * ext:cls="Ext.data.Store">Ext.data.Store</a> so that as the data in the store
 * changes the view is automatically updated to reflect the changes. The view
 * also provides built-in behavior for many common events that can occur for its
 * contained items including click, doubleclick, mouseover, mouseout, etc. as
 * well as a built-in selection model. <b>In order to use these features, an <a
 * href="output/Ext.DataView.html#Ext.DataView-itemSelector"
 * ext:member="itemSelector" ext:cls="Ext.DataView">itemSelector</a> config must
 * be provided for the DataView to determine what nodes it will be working
 * with.</b>
 * 
 * <p>
 * The example below binds a DataView to a <a href="output/Ext.data.Store.html"
 * ext:cls="Ext.data.Store">Ext.data.Store</a> and renders it into an <a
 * href="output/Ext.Panel.html" ext:cls="Ext.Panel">Ext.Panel</a>.
 * </p>
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; store = &lt;b&gt;new&lt;/b&gt; Ext.data.JsonStore({
 *     url: &lt;em&gt;'get-images.php'&lt;/em&gt;,
 *     root: &lt;em&gt;'images'&lt;/em&gt;,
 *     fields: [
 *         &lt;em&gt;'name'&lt;/em&gt;, &lt;em&gt;'url'&lt;/em&gt;,
 *         {name:&lt;em&gt;'size'&lt;/em&gt;, type: &lt;em&gt;'float'&lt;/em&gt;},
 *         {name:&lt;em&gt;'lastmod'&lt;/em&gt;, type:&lt;em&gt;'date'&lt;/em&gt;, dateFormat:&lt;em&gt;'timestamp'&lt;/em&gt;}
 *     ]
 * });
 * store.load();
 * 
 * &lt;b&gt;var&lt;/b&gt; tpl = &lt;b&gt;new&lt;/b&gt; Ext.XTemplate(
 *     &lt;em&gt;'&lt;tpl &lt;b&gt;for&lt;/b&gt;=&lt;/em&gt;&quot;.&quot;&lt;/code&gt;&gt;',
 *         &lt;em&gt;'&lt;div class=&lt;/em&gt;&quot;thumb-wrap&quot; id=&lt;em&gt;&quot;{name}&quot;&lt;/em&gt;&gt;',
 *         &lt;em&gt;'&lt;div class=&lt;/em&gt;&quot;thumb&quot;&gt;&lt;img src=&lt;em&gt;&quot;{url}&quot;&lt;/em&gt; title=&lt;em&gt;&quot;{name}&quot;&lt;/em&gt;&gt;&lt;/div&gt;',
 *         &lt;em&gt;'&lt;span class=&lt;/em&gt;&quot;x-editable&quot;&gt;{shortName}&lt;/span&gt;&lt;/div&gt;',
 *     &lt;em&gt;'&lt;/tpl&gt;'&lt;/em&gt;,
 *     &lt;em&gt;'&lt;div class=&lt;/em&gt;&quot;x-clear&quot;&gt;&lt;/div&gt;'
 * );
 * 
 * &lt;b&gt;var&lt;/b&gt; panel = &lt;b&gt;new&lt;/b&gt; Ext.Panel({
 *     id:&lt;em&gt;'images-view'&lt;/em&gt;,
 *     frame:true,
 *     width:535,
 *     autoHeight:true,
 *     collapsible:true,
 *     layout:&lt;em&gt;'fit'&lt;/em&gt;,
 *     title:&lt;em&gt;'Simple DataView'&lt;/em&gt;,
 * 
 *     items: &lt;b&gt;new&lt;/b&gt; Ext.DataView({
 *         store: store,
 *         tpl: tpl,
 *         autoHeight:true,
 *         multiSelect: true,
 *         overClass:&lt;em&gt;'x-view-over'&lt;/em&gt;,
 *         itemSelector:&lt;em&gt;'div.thumb-wrap'&lt;/em&gt;,
 *         emptyText: &lt;em&gt;'No images to display'&lt;/em&gt;
 *     })
 * });
 * panel.render(document.body);
 * </pre>
 */
@XType("dataview")
@InstanceOf("Ext.DataView")
@ParseConfigMode(name = "view", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class DataView extends BoxComponent {
	public static final String COMPONENT_TYPE = "Ext.DataView";
	public static final String COMPONENT_FAMILY = "Ext.DataView";

	/**
	 * <p>
	 * Create a new {@link DataView} instance with default property values.
	 * </p>
	 */
	public DataView() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean deferEmptyText;

	/**
	 * True to defer emptyText being applied until thestore's first load
	 */
	public Boolean getDeferEmptyText() {
		if (null != this.deferEmptyText) {
			return this.deferEmptyText;
		}
		ValueExpression _ve = getValueExpression("deferEmptyText");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>deferEmptyText</code> property.
	 * </p>
	 */
	public void setDeferEmptyText(Boolean deferEmptyText) {
		this.deferEmptyText = deferEmptyText;
		this.handleConfig("deferEmptyText", deferEmptyText);
	}

	private String emptyText;

	/**
	 * The text to display in the view when there is nodata to display (defaults
	 * to '').
	 */
	public String getEmptyText() {
		if (null != this.emptyText) {
			return this.emptyText;
		}
		ValueExpression _ve = getValueExpression("emptyText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyText</code> property.
	 * </p>
	 */
	public void setEmptyText(String emptyText) {
		this.emptyText = emptyText;
		this.handleConfig("emptyText", emptyText);
	}

	private String itemSelector;

	/**
	 * <b>This is a required setting</b>. A simple CSSselector (e.g.
	 * <tt>div.some-class</tt> or <tt>span:first-child</tt>) that will be used
	 * to determine what nodes this DataView will be working with.
	 */
	public String getItemSelector() {
		if (null != this.itemSelector) {
			return this.itemSelector;
		}
		ValueExpression _ve = getValueExpression("itemSelector");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>itemSelector</code> property.
	 * </p>
	 */
	public void setItemSelector(String itemSelector) {
		this.itemSelector = itemSelector;
		this.handleConfig("itemSelector", itemSelector);
	}

	private String loadingText;

	/**
	 * A string to display during data load operations(defaults to undefined).
	 * If specified, this text will be displayed in a loading div and the view's
	 * contents will be cleared while loading, otherwise the view's contents
	 * will continue to display normally until the new data is loaded and the
	 * contents are replaced.
	 */
	public String getLoadingText() {
		if (null != this.loadingText) {
			return this.loadingText;
		}
		ValueExpression _ve = getValueExpression("loadingText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>loadingText</code> property.
	 * </p>
	 */
	public void setLoadingText(String loadingText) {
		this.loadingText = loadingText;
		this.handleConfig("loadingText", loadingText);
	}

	private Boolean multiSelect;

	/**
	 * True to allow selection of more than one item ata time, false to allow
	 * selection of only a single item at a time or no selection at all,
	 * depending on the value of <a
	 * href="output/Ext.DataView.html#Ext.DataView-singleSelect"
	 * ext:member="singleSelect" ext:cls="Ext.DataView">singleSelect</a>
	 * (defaults to false).
	 */
	public Boolean getMultiSelect() {
		if (null != this.multiSelect) {
			return this.multiSelect;
		}
		ValueExpression _ve = getValueExpression("multiSelect");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>multiSelect</code> property.
	 * </p>
	 */
	public void setMultiSelect(Boolean multiSelect) {
		this.multiSelect = multiSelect;
		this.handleConfig("multiSelect", multiSelect);
	}

	private String overClass;

	/**
	 * A CSS class to apply to each item in the view onmouseover (defaults to
	 * undefined).
	 */
	public String getOverClass() {
		if (null != this.overClass) {
			return this.overClass;
		}
		ValueExpression _ve = getValueExpression("overClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>overClass</code> property.
	 * </p>
	 */
	public void setOverClass(String overClass) {
		this.overClass = overClass;
		this.handleConfig("overClass", overClass);
	}

	private String selectedClass;

	/**
	 * A CSS class to apply to each selected item inthe view (defaults to
	 * 'x-view-selected').
	 */
	public String getSelectedClass() {
		if (null != this.selectedClass) {
			return this.selectedClass;
		}
		ValueExpression _ve = getValueExpression("selectedClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>selectedClass</code> property.
	 * </p>
	 */
	public void setSelectedClass(String selectedClass) {
		this.selectedClass = selectedClass;
		this.handleConfig("selectedClass", selectedClass);
	}

	private Boolean simpleSelect;

	/**
	 * True to enable multiselection by clicking onmultiple items without
	 * requiring the user to hold Shift or Ctrl, false to force the user to hold
	 * Ctrl or Shift to select more than on item (defaults to false).
	 */
	public Boolean getSimpleSelect() {
		if (null != this.simpleSelect) {
			return this.simpleSelect;
		}
		ValueExpression _ve = getValueExpression("simpleSelect");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>simpleSelect</code> property.
	 * </p>
	 */
	public void setSimpleSelect(Boolean simpleSelect) {
		this.simpleSelect = simpleSelect;
		this.handleConfig("simpleSelect", simpleSelect);
	}

	private Boolean singleSelect;

	/**
	 * True to allow selection of exactly one item at atime, false to allow no
	 * selection at all (defaults to false). Note that if <a
	 * href="output/Ext.DataView.html#Ext.DataView-multiSelect"
	 * ext:member="multiSelect" ext:cls="Ext.DataView">multiSelect</a> = true,
	 * this value will be ignored.
	 */
	public Boolean getSingleSelect() {
		if (null != this.singleSelect) {
			return this.singleSelect;
		}
		ValueExpression _ve = getValueExpression("singleSelect");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>singleSelect</code> property.
	 * </p>
	 */
	public void setSingleSelect(Boolean singleSelect) {
		this.singleSelect = singleSelect;
		this.handleConfig("singleSelect", singleSelect);
	}

	private Object store;

	/**
	 * The <a href="output/Ext.data.Store.html"
	 * ext:cls="Ext.data.Store">Ext.data.Store</a> to bind this DataViewto.
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

	private Object tpl;

	/**
	 * The HTML fragment or an array of fragments thatwill make up the template
	 * used by this DataView. This should be specified in the same format
	 * expected by the constructor of <a href="output/Ext.XTemplate.html"
	 * ext:cls="Ext.XTemplate">Ext.XTemplate</a>.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getTpl() {
		if (null != this.tpl) {
			return this.tpl;
		}
		ValueExpression _ve = getValueExpression("tpl");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tpl</code> property.
	 * </p>
	 */
	public void setTpl(Object tpl) {
		this.tpl = tpl;
		this.handleConfig("tpl", tpl);
	}

	private Boolean trackOver;

	/**
	 * True to enable mouseenter and mouseleaveevents
	 */
	public Boolean getTrackOver() {
		if (null != this.trackOver) {
			return this.trackOver;
		}
		ValueExpression _ve = getValueExpression("trackOver");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>trackOver</code> property.
	 * </p>
	 */
	public void setTrackOver(Boolean trackOver) {
		this.trackOver = trackOver;
		this.handleConfig("trackOver", trackOver);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[13];
		}
		_values[0] = super.saveState(_context);
		_values[1] = deferEmptyText;
		_values[2] = emptyText;
		_values[3] = itemSelector;
		_values[4] = loadingText;
		_values[5] = multiSelect;
		_values[6] = overClass;
		_values[7] = selectedClass;
		_values[8] = simpleSelect;
		_values[9] = singleSelect;
		_values[10] = store;
		_values[11] = tpl;
		_values[12] = trackOver;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.deferEmptyText = (Boolean) _values[1];
		this.handleConfig("deferEmptyText", this.deferEmptyText);
		this.emptyText = (String) _values[2];
		this.handleConfig("emptyText", this.emptyText);
		this.itemSelector = (String) _values[3];
		this.handleConfig("itemSelector", this.itemSelector);
		this.loadingText = (String) _values[4];
		this.handleConfig("loadingText", this.loadingText);
		this.multiSelect = (Boolean) _values[5];
		this.handleConfig("multiSelect", this.multiSelect);
		this.overClass = (String) _values[6];
		this.handleConfig("overClass", this.overClass);
		this.selectedClass = (String) _values[7];
		this.handleConfig("selectedClass", this.selectedClass);
		this.simpleSelect = (Boolean) _values[8];
		this.handleConfig("simpleSelect", this.simpleSelect);
		this.singleSelect = (Boolean) _values[9];
		this.handleConfig("singleSelect", this.singleSelect);
		this.store = (Object) _values[10];
		this.handleConfig("store", this.store);
		this.tpl = (Object) _values[11];
		this.handleConfig("tpl", this.tpl);
		this.trackOver = (Boolean) _values[12];
		this.handleConfig("trackOver", this.trackOver);

	}
}