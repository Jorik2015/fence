package ext.menu;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. Adds a menu
 * item that contains a checkbox by default, but can also be part of a radio
 * group.
 */
@XType("menucheckitem")
@InstanceOf("Ext.menu.CheckItem")
@ParseConfigMode(name = "items", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class CheckItem extends Item {
	private static final long serialVersionUID = -7278882817419838007L;
	public static final String COMPONENT_TYPE = "Ext.menu.CheckItem";
	public static final String COMPONENT_FAMILY = "Ext.menu.CheckItem";

	/**
	 * <p>
	 * Create a new {@link CheckItem} instance with default property values.
	 * </p>
	 */
	public CheckItem() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean checked;

	/**
	 * True to initialize this checkbox as checked(defaults to false). Note that
	 * if this checkbox is part of a radio group (group = true) only the last
	 * item in the group that is initialized with checked = true will be
	 * rendered as checked.
	 */
	public Boolean getChecked() {
		if (null != this.checked) {
			return this.checked;
		}
		ValueExpression _ve = getValueExpression("checked");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>checked</code> property.
	 * </p>
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
		this.handleConfig("checked", checked);
	}

	private String group;

	/**
	 * All check items with the same group name willautomatically be grouped
	 * into a single-select radio button group (defaults to '')
	 */
	public String getGroup() {
		if (null != this.group) {
			return this.group;
		}
		ValueExpression _ve = getValueExpression("group");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>group</code> property.
	 * </p>
	 */
	public void setGroup(String group) {
		this.group = group;
		this.handleConfig("group", group);
	}

	private String groupClass;

	/**
	 * The default CSS class to use for radio groupcheck items (defaults to
	 * "x-menu-group-item")
	 */
	public String getGroupClass() {
		if (null != this.groupClass) {
			return this.groupClass;
		}
		ValueExpression _ve = getValueExpression("groupClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>groupClass</code> property.
	 * </p>
	 */
	public void setGroupClass(String groupClass) {
		this.groupClass = groupClass;
		this.handleConfig("groupClass", groupClass);
	}

	private String itemCls;

	/**
	 * The default CSS class to use for check items(defaults to
	 * "x-menu-item x-menu-check-item")
	 */
	public String getItemCls() {
		if (null != this.itemCls) {
			return this.itemCls;
		}
		ValueExpression _ve = getValueExpression("itemCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>itemCls</code> property.
	 * </p>
	 */
	public void setItemCls(String itemCls) {
		this.itemCls = itemCls;
		this.handleConfig("itemCls", itemCls);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[5];
		}
		_values[0] = super.saveState(_context);
		_values[1] = checked;
		_values[2] = group;
		_values[3] = groupClass;
		_values[4] = itemCls;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.checked = (Boolean) _values[1];
		this.handleConfig("checked", this.checked);
		this.group = (String) _values[2];
		this.handleConfig("group", this.group);
		this.groupClass = (String) _values[3];
		this.handleConfig("groupClass", this.groupClass);
		this.itemCls = (String) _values[4];
		this.handleConfig("itemCls", this.itemCls);

	}
}