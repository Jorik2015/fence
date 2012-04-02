package ext.menu;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.Container;
import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * A menu object. This is the container to which you may add menu items. Menu
 * can also serve as a base class when you want a specialized menu based off of
 * another component (like <a href="output/Ext.menu.DateMenu.html"
 * ext:cls="Ext.menu.DateMenu">Ext.menu.DateMenu</a> for example).
 * </p>
 * 
 * <p>
 * Menus may contain either <a href="output/Ext.menu.Item.html"
 * ext:cls="Ext.menu.Item">menu items</a>, or general <a
 * href="output/Ext.Component.html" ext:cls="Ext.Component">Component</a>s.
 * </p>
 * 
 * <p>
 * To make a contained general <a href="output/Ext.Component.html"
 * ext:cls="Ext.Component">Component</a> line up with other <a
 * href="output/Ext.menu.Item.html" ext:cls="Ext.menu.Item">menu items</a>
 * specify <tt>iconCls: 'no-icon'</tt>. This reserves a space for an icon, and indents the
 * Component in line with the other menu items. See <a
 * href="output/Ext.form.ComboBox.html"
 * ext:cls="Ext.form.ComboBox">Ext.form.ComboBox</a>.<a
 * href="output/Ext.form.ComboBox.html#Ext.form.ComboBox-getListParent"
 * ext:member="getListParent" ext:cls="Ext.form.ComboBox">getListParent</a> for
 * an example.
 * </p>
 * 
 * <p>
 * By default, Menus are absolutely positioned, floating Components. By
 * configuring a Menu with <b>
 * <tt><a href="output/Ext.menu.Menu.html#Ext.menu.Menu-floating" ext:member="floating" ext:cls="Ext.menu.Menu">floating</a>:false</tt>
 * </b>, a Menu may be used as child of a Container.
 * </p>
 */
@XType("menu")
@InstanceOf("Ext.menu.Menu")
@ParseConfigMode(name = "menu", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class Menu extends Container {
	public static final String COMPONENT_TYPE = "Ext.menu.Menu";
	public static final String COMPONENT_FAMILY = "Ext.menu.Menu";

	/**
	 * <p>
	 * Create a new {@link Menu} instance with default property values.
	 * </p>
	 */
	public Menu() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean allowOtherMenus;

	/**
	 * True to allow multiple menus to be displayed atthe same time (defaults to
	 * false)
	 */
	public Boolean getAllowOtherMenus() {
		if (null != this.allowOtherMenus) {
			return this.allowOtherMenus;
		}
		ValueExpression _ve = getValueExpression("allowOtherMenus");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowOtherMenus</code> property.
	 * </p>
	 */
	public void setAllowOtherMenus(Boolean allowOtherMenus) {
		this.allowOtherMenus = allowOtherMenus;
		this.handleConfig("allowOtherMenus", allowOtherMenus);
	}

	private String defaultAlign;

	/**
	 * The default <a href="output/Ext.Element.html#Ext.Element-alignTo"
	 * ext:member="alignTo" ext:cls="Ext.Element">Ext.Element.alignTo</a>anchor
	 * position value for this menu relative to its element of origin (defaults
	 * to 'tl-bl?')
	 */
	public String getDefaultAlign() {
		if (null != this.defaultAlign) {
			return this.defaultAlign;
		}
		ValueExpression _ve = getValueExpression("defaultAlign");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultAlign</code> property.
	 * </p>
	 */
	public void setDefaultAlign(String defaultAlign) {
		this.defaultAlign = defaultAlign;
		this.handleConfig("defaultAlign", defaultAlign);
	}

	private Object defaultOffsets;

	/**
	 * An array specifying the [x, y] offset in pixelsby which to change the
	 * default Menu popup position after aligning according to the <a
	 * href="output/Ext.menu.Menu.html#Ext.menu.Menu-defaultAlign"
	 * ext:member="defaultAlign" ext:cls="Ext.menu.Menu">defaultAlign</a>
	 * configuration. Defaults to <tt>[0, 0]</tt>.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getDefaultOffsets() {
		if (null != this.defaultOffsets) {
			return this.defaultOffsets;
		}
		ValueExpression _ve = getValueExpression("defaultOffsets");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultOffsets</code> property.
	 * </p>
	 */
	public void setDefaultOffsets(Object defaultOffsets) {
		this.defaultOffsets = defaultOffsets;
		this.handleConfig("defaultOffsets", defaultOffsets);
	}

	private Object defaults;

	/**
	 * A config object that will be applied to all itemsadded to this container
	 * either via the <a href="output/Ext.menu.Menu.html#Ext.menu.Menu-items"
	 * ext:member="items" ext:cls="Ext.menu.Menu">items</a> config or via the <a
	 * href="output/Ext.menu.Menu.html#Ext.menu.Menu-add" ext:member="add"
	 * ext:cls="Ext.menu.Menu">add</a> method. The defaults config can contain
	 * any number of name/value property pairs to be added to each item, and
	 * should be valid for the types of items being added to the menu.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getDefaults() {
		if (null != this.defaults) {
			return this.defaults;
		}
		ValueExpression _ve = getValueExpression("defaults");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaults</code> property.
	 * </p>
	 */
	public void setDefaults(Object defaults) {
		this.defaults = defaults;
		this.handleConfig("defaults", defaults);
	}

	private Boolean enableScrolling;

	/**
	 * True to allow the menu container to havescroller controls if the menu is
	 * too long (defaults to true).
	 */
	public Boolean getEnableScrolling() {
		if (null != this.enableScrolling) {
			return this.enableScrolling;
		}
		ValueExpression _ve = getValueExpression("enableScrolling");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableScrolling</code> property.
	 * </p>
	 */
	public void setEnableScrolling(Boolean enableScrolling) {
		this.enableScrolling = enableScrolling;
		this.handleConfig("enableScrolling", enableScrolling);
	}

	private Boolean floating;

	/**
	 * <p>
	 * By default, a Menu configured as <b><code>floating:true</code></b> will
	 * be rendered as an <a href="output/Ext.Layer.html"
	 * ext:cls="Ext.Layer">Ext.Layer</a> (an absolutely positioned, floating
	 * Component with zindex=15000). If configured as <b>
	 * <code>floating:false</code></b>, the Menu may be used as child item of
	 * another Container instead of a free-floating <a
	 * href="output/Ext.Layer.html" ext:cls="Ext.Layer">Layer</a>.
	 * </p>
	 */
	public Boolean getFloating() {
		if (null != this.floating) {
			return this.floating;
		}
		ValueExpression _ve = getValueExpression("floating");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>floating</code> property.
	 * </p>
	 */
	public void setFloating(Boolean floating) {
		this.floating = floating;
		this.handleConfig("floating", floating);
	}

	private Boolean ignoreParentClicks;

	/**
	 * True to ignore clicks on any item in this menuthat is a parent item
	 * (displays a submenu) so that the submenu is not dismissed when clicking
	 * the parent item (defaults to false).
	 */
	public Boolean getIgnoreParentClicks() {
		if (null != this.ignoreParentClicks) {
			return this.ignoreParentClicks;
		}
		ValueExpression _ve = getValueExpression("ignoreParentClicks");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>ignoreParentClicks</code> property.
	 * </p>
	 */
	public void setIgnoreParentClicks(Boolean ignoreParentClicks) {
		this.ignoreParentClicks = ignoreParentClicks;
		this.handleConfig("ignoreParentClicks", ignoreParentClicks);
	}

	private Object items;

	/**
	 * An array of items to be added to this menu.Menus may contain either <a
	 * href="output/Ext.menu.Item.html" ext:cls="Ext.menu.Item">menu items</a>,
	 * or general <a href="output/Ext.Component.html"
	 * ext:cls="Ext.Component">Component</a>s.
	 */
	@ClientConfig(JsonMode.Array)
	public Object getItems() {
		if (null != this.items) {
			return this.items;
		}
		ValueExpression _ve = getValueExpression("items");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>items</code> property.
	 * </p>
	 */
	public void setItems(Object items) {
		this.items = items;
		this.handleConfig("items", items);
	}

	private String layout;

	/**
	 * This class assigns a default layout(<code>layout:<em>'<b>menu</b>'</em></code>). Developers
	 * <i>may</i> override this configuration option if another layout is
	 * required. See <a href="output/Ext.Container.html#Ext.Container-layout"
	 * ext:member="layout" ext:cls="Ext.Container">Ext.Container.layout</a> for
	 * additional information.
	 */
	public String getLayout() {
		if (null != this.layout) {
			return this.layout;
		}
		ValueExpression _ve = getValueExpression("layout");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>layout</code> property.
	 * </p>
	 */
	public void setLayout(String layout) {
		this.layout = layout;
		this.handleConfig("layout", layout);
	}

	private Integer maxHeight;

	/**
	 * The maximum height of the menu. Only applieswhen enableScrolling is set
	 * to True (defaults to null).
	 */
	public Integer getMaxHeight() {
		if (null != this.maxHeight) {
			return this.maxHeight;
		}
		ValueExpression _ve = getValueExpression("maxHeight");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>maxHeight</code> property.
	 * </p>
	 */
	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
		this.handleConfig("maxHeight", maxHeight);
	}

	private Integer minWidth;

	/**
	 * The minimum width of the menu in pixels(defaults to 120)
	 */
	public Integer getMinWidth() {
		if (null != this.minWidth) {
			return this.minWidth;
		}
		ValueExpression _ve = getValueExpression("minWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth(Integer minWidth) {
		this.minWidth = minWidth;
		this.handleConfig("minWidth", minWidth);
	}

	private Integer scrollIncrement;

	/**
	 * The amount to scroll the menu. Only applies whenenableScrolling is set to
	 * True (defaults to 24).
	 */
	public Integer getScrollIncrement() {
		if (null != this.scrollIncrement) {
			return this.scrollIncrement;
		}
		ValueExpression _ve = getValueExpression("scrollIncrement");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollIncrement</code> property.
	 * </p>
	 */
	public void setScrollIncrement(Integer scrollIncrement) {
		this.scrollIncrement = scrollIncrement;
		this.handleConfig("scrollIncrement", scrollIncrement);
	}

	private Boolean shadow;

	/**
	 * True or 'sides' for the default effect, 'frame'for 4-way shadow, and
	 * 'drop' for bottom-right shadow (defaults to 'sides')
	 */
	public Boolean getShadow() {
		if (null != this.shadow) {
			return this.shadow;
		}
		ValueExpression _ve = getValueExpression("shadow");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>shadow</code> property.
	 * </p>
	 */
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
		this.handleConfig("shadow", shadow);
	}

	private Boolean showSeparator;

	/**
	 * True to show the icon separator. (defaults totrue).
	 */
	public Boolean getShowSeparator() {
		if (null != this.showSeparator) {
			return this.showSeparator;
		}
		ValueExpression _ve = getValueExpression("showSeparator");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>showSeparator</code> property.
	 * </p>
	 */
	public void setShowSeparator(Boolean showSeparator) {
		this.showSeparator = showSeparator;
		this.handleConfig("showSeparator", showSeparator);
	}

	private String subMenuAlign;

	/**
	 * The <a href="output/Ext.Element.html#Ext.Element-alignTo"
	 * ext:member="alignTo" ext:cls="Ext.Element">Ext.Element.alignTo</a>anchor
	 * position value to use for submenus of this menu (defaults to 'tl-tr?')
	 */
	public String getSubMenuAlign() {
		if (null != this.subMenuAlign) {
			return this.subMenuAlign;
		}
		ValueExpression _ve = getValueExpression("subMenuAlign");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>subMenuAlign</code> property.
	 * </p>
	 */
	public void setSubMenuAlign(String subMenuAlign) {
		this.subMenuAlign = subMenuAlign;
		this.handleConfig("subMenuAlign", subMenuAlign);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[16];
		}
		_values[0] = super.saveState(_context);
		_values[1] = allowOtherMenus;
		_values[2] = defaultAlign;
		_values[3] = defaultOffsets;
		_values[4] = defaults;
		_values[5] = enableScrolling;
		_values[6] = floating;
		_values[7] = ignoreParentClicks;
		_values[8] = items;
		_values[9] = layout;
		_values[10] = maxHeight;
		_values[11] = minWidth;
		_values[12] = scrollIncrement;
		_values[13] = shadow;
		_values[14] = showSeparator;
		_values[15] = subMenuAlign;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.allowOtherMenus = (Boolean) _values[1];
		this.handleConfig("allowOtherMenus", this.allowOtherMenus);
		this.defaultAlign = (String) _values[2];
		this.handleConfig("defaultAlign", this.defaultAlign);
		this.defaultOffsets = (Object) _values[3];
		this.handleConfig("defaultOffsets", this.defaultOffsets);
		this.defaults = (Object) _values[4];
		this.handleConfig("defaults", this.defaults);
		this.enableScrolling = (Boolean) _values[5];
		this.handleConfig("enableScrolling", this.enableScrolling);
		this.floating = (Boolean) _values[6];
		this.handleConfig("floating", this.floating);
		this.ignoreParentClicks = (Boolean) _values[7];
		this.handleConfig("ignoreParentClicks", this.ignoreParentClicks);
		this.items = (Object) _values[8];
		this.handleConfig("items", this.items);
		this.layout = (String) _values[9];
		this.handleConfig("layout", this.layout);
		this.maxHeight = (Integer) _values[10];
		this.handleConfig("maxHeight", this.maxHeight);
		this.minWidth = (Integer) _values[11];
		this.handleConfig("minWidth", this.minWidth);
		this.scrollIncrement = (Integer) _values[12];
		this.handleConfig("scrollIncrement", this.scrollIncrement);
		this.shadow = (Boolean) _values[13];
		this.handleConfig("shadow", this.shadow);
		this.showSeparator = (Boolean) _values[14];
		this.handleConfig("showSeparator", this.showSeparator);
		this.subMenuAlign = (String) _values[15];
		this.handleConfig("subMenuAlign", this.subMenuAlign);

	}
}