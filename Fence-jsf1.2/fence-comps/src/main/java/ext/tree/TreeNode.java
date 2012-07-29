package ext.tree;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.data.Node;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 */
@InstanceOf("Ext.tree.TreeNode")
public class TreeNode extends Node {
	public static final String COMPONENT_TYPE = "Ext.tree.TreeNode";
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeNode";

	/**
	 * <p>
	 * Create a new {@link TreeNode} instance with default property values.
	 * </p>
	 */
	public TreeNode() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean allowChildren;

	/**
	 * False to not allow this node to have child nodes(defaults to true)
	 */
	public Boolean getAllowChildren() {
		if (null != this.allowChildren) {
			return this.allowChildren;
		}
		ValueExpression _ve = getValueExpression("allowChildren");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowChildren</code> property.
	 * </p>
	 */
	public void setAllowChildren(Boolean allowChildren) {
		this.allowChildren = allowChildren;
		this.handleConfig("allowChildren", allowChildren);
	}

	private Boolean allowDrag;

	/**
	 * False to make this node undraggable if <a
	 * href="output/Ext.tree.TreeNode.html#Ext.tree.TreeNode-draggable"
	 * ext:member="draggable" ext:cls="Ext.tree.TreeNode">draggable</a> =true
	 * (defaults to true)
	 */
	public Boolean getAllowDrag() {
		if (null != this.allowDrag) {
			return this.allowDrag;
		}
		ValueExpression _ve = getValueExpression("allowDrag");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDrag</code> property.
	 * </p>
	 */
	public void setAllowDrag(Boolean allowDrag) {
		this.allowDrag = allowDrag;
		this.handleConfig("allowDrag", allowDrag);
	}

	private Boolean allowDrop;

	/**
	 * False if this node cannot have child nodesdropped on it (defaults to
	 * true)
	 */
	public Boolean getAllowDrop() {
		if (null != this.allowDrop) {
			return this.allowDrop;
		}
		ValueExpression _ve = getValueExpression("allowDrop");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDrop</code> property.
	 * </p>
	 */
	public void setAllowDrop(Boolean allowDrop) {
		this.allowDrop = allowDrop;
		this.handleConfig("allowDrop", allowDrop);
	}

	private Boolean checked;

	/**
	 * True to render a checked checkbox for this node,false to render an
	 * unchecked checkbox (defaults to undefined with no checkbox rendered)
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

	private String cls;

	/**
	 * A css class to be added to the node
	 */
	public String getCls() {
		if (null != this.cls) {
			return this.cls;
		}
		ValueExpression _ve = getValueExpression("cls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls(String cls) {
		this.cls = cls;
		this.handleConfig("cls", cls);
	}

	private Boolean disabled;

	/**
	 * true to start the node disabled
	 */
	@ClientConfig(value = JsonMode.Ignore)
	public Boolean getDisabled() {
		if (null != this.disabled) {
			return this.disabled;
		}
		ValueExpression _ve = getValueExpression("disabled");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
		this.handleConfig("disabled", disabled);
	}
	
	private Boolean extDisabled;

	/**
	 * True to disable all components using this action, false to enable them
	 * (defaults to false).
	 */
	@ClientConfig(name="disabled")
	public Boolean getExtDisabled() {
		if (null != this.extDisabled) {
			return this.extDisabled;
		}
		ValueExpression _ve = getValueExpression("extDisabled");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setExtDisabled(Boolean extDisabled) {
		this.extDisabled = extDisabled;
		this.handleConfig("extDisabled", extDisabled);
	}

	private Boolean draggable;

	/**
	 * True to make this node draggable (defaults tofalse)
	 */
	public Boolean getDraggable() {
		if (null != this.draggable) {
			return this.draggable;
		}
		ValueExpression _ve = getValueExpression("draggable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>draggable</code> property.
	 * </p>
	 */
	public void setDraggable(Boolean draggable) {
		this.draggable = draggable;
		this.handleConfig("draggable", draggable);
	}

	private Boolean editable;

	/**
	 * False to not allow this node to be edited by an(@link
	 * Ext.tree.TreeEditor} (defaults to true)
	 */
	public Boolean getEditable() {
		if (null != this.editable) {
			return this.editable;
		}
		ValueExpression _ve = getValueExpression("editable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>editable</code> property.
	 * </p>
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
		this.handleConfig("editable", editable);
	}

	private Boolean expandable;

	/**
	 * If set to true, the node will always show aplus/minus icon, even when
	 * empty
	 */
	public Boolean getExpandable() {
		if (null != this.expandable) {
			return this.expandable;
		}
		ValueExpression _ve = getValueExpression("expandable");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>expandable</code> property.
	 * </p>
	 */
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
		this.handleConfig("expandable", expandable);
	}

	private Boolean expanded;

	/**
	 * true to start the node expanded
	 */
	public Boolean getExpanded() {
		if (null != this.expanded) {
			return this.expanded;
		}
		ValueExpression _ve = getValueExpression("expanded");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>expanded</code> property.
	 * </p>
	 */
	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
		this.handleConfig("expanded", expanded);
	}

	private Boolean hidden;

	/**
	 * True to render hidden. (Defaults tofalse).
	 */
	public Boolean getHidden() {
		if (null != this.hidden) {
			return this.hidden;
		}
		ValueExpression _ve = getValueExpression("hidden");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hidden</code> property.
	 * </p>
	 */
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
		this.handleConfig("hidden", hidden);
	}

	private String href;

	/**
	 * URL of the link used for the node (defaults to#)
	 */
	public String getHref() {
		if (null != this.href) {
			return this.href;
		}
		ValueExpression _ve = getValueExpression("href");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>href</code> property.
	 * </p>
	 */
	public void setHref(String href) {
		this.href = href;
		this.handleConfig("href", href);
	}

	private String hrefTarget;

	/**
	 * target frame for the link
	 */
	public String getHrefTarget() {
		if (null != this.hrefTarget) {
			return this.hrefTarget;
		}
		ValueExpression _ve = getValueExpression("hrefTarget");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hrefTarget</code> property.
	 * </p>
	 */
	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
		this.handleConfig("hrefTarget", hrefTarget);
	}

	private String icon;

	/**
	 * The path to an icon for the node. The preferredway to do this is to use
	 * the cls or iconCls attributes and add the icon via a CSS background
	 * image.
	 */
	public String getIcon() {
		if (null != this.icon) {
			return this.icon;
		}
		ValueExpression _ve = getValueExpression("icon");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>icon</code> property.
	 * </p>
	 */
	public void setIcon(String icon) {
		this.icon = icon;
		this.handleConfig("icon", icon);
	}

	private String iconCls;

	/**
	 * A css class to be added to the nodes iconelement for applying css
	 * background images
	 */
	public String getIconCls() {
		if (null != this.iconCls) {
			return this.iconCls;
		}
		ValueExpression _ve = getValueExpression("iconCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>iconCls</code> property.
	 * </p>
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
		this.handleConfig("iconCls", iconCls);
	}

	private Boolean isTarget;

	/**
	 * False to not allow this node to act as a droptarget (defaults to true)
	 */
	public Boolean getIsTarget() {
		if (null != this.isTarget) {
			return this.isTarget;
		}
		ValueExpression _ve = getValueExpression("isTarget");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>isTarget</code> property.
	 * </p>
	 */
	public void setIsTarget(Boolean isTarget) {
		this.isTarget = isTarget;
		this.handleConfig("isTarget", isTarget);
	}

	private String qtip;

	/**
	 * An Ext QuickTip for the node
	 */
	public String getQtip() {
		if (null != this.qtip) {
			return this.qtip;
		}
		ValueExpression _ve = getValueExpression("qtip");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>qtip</code> property.
	 * </p>
	 */
	public void setQtip(String qtip) {
		this.qtip = qtip;
		this.handleConfig("qtip", qtip);
	}

	private String qtipCfg;

	/**
	 * An Ext QuickTip config for the node (usedinstead of qtip)
	 */
	public String getQtipCfg() {
		if (null != this.qtipCfg) {
			return this.qtipCfg;
		}
		ValueExpression _ve = getValueExpression("qtipCfg");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>qtipCfg</code> property.
	 * </p>
	 */
	public void setQtipCfg(String qtipCfg) {
		this.qtipCfg = qtipCfg;
		this.handleConfig("qtipCfg", qtipCfg);
	}

	private Boolean singleClickExpand;

	/**
	 * True for single click expand on this node
	 */
	public Boolean getSingleClickExpand() {
		if (null != this.singleClickExpand) {
			return this.singleClickExpand;
		}
		ValueExpression _ve = getValueExpression("singleClickExpand");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>singleClickExpand</code> property.
	 * </p>
	 */
	public void setSingleClickExpand(Boolean singleClickExpand) {
		this.singleClickExpand = singleClickExpand;
		this.handleConfig("singleClickExpand", singleClickExpand);
	}

	private String text;

	/**
	 * The text for this node
	 */
	public String getText() {
		if (null != this.text) {
			return this.text;
		}
		ValueExpression _ve = getValueExpression("text");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText(String text) {
		this.text = text;
		this.handleConfig("text", text);
	}

	private Object uiProvider;

	/**
	 * A UI <b>class</b> to use for this node (defaultsto Ext.tree.TreeNodeUI)
	 */
	@ClientConfig(JsonMode.Object)
	public Object getUiProvider() {
		if (null != this.uiProvider) {
			return this.uiProvider;
		}
		ValueExpression _ve = getValueExpression("uiProvider");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>uiProvider</code> property.
	 * </p>
	 */
	public void setUiProvider(Object uiProvider) {
		this.uiProvider = uiProvider;
		this.handleConfig("uiProvider", uiProvider);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[23];
		}
		_values[0] = super.saveState(_context);
		_values[1] = allowChildren;
		_values[2] = allowDrag;
		_values[3] = allowDrop;
		_values[4] = checked;
		_values[5] = cls;
		_values[6] = disabled;
		_values[7] = draggable;
		_values[8] = editable;
		_values[9] = expandable;
		_values[10] = expanded;
		_values[11] = hidden;
		_values[12] = href;
		_values[13] = hrefTarget;
		_values[14] = icon;
		_values[15] = iconCls;
		_values[16] = isTarget;
		_values[17] = qtip;
		_values[18] = qtipCfg;
		_values[19] = singleClickExpand;
		_values[20] = text;
		_values[21] = uiProvider;
		_values[22] = extDisabled;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.allowChildren = (Boolean) _values[1];
		this.handleConfig("allowChildren", this.allowChildren);
		this.allowDrag = (Boolean) _values[2];
		this.handleConfig("allowDrag", this.allowDrag);
		this.allowDrop = (Boolean) _values[3];
		this.handleConfig("allowDrop", this.allowDrop);
		this.checked = (Boolean) _values[4];
		this.handleConfig("checked", this.checked);
		this.cls = (String) _values[5];
		this.handleConfig("cls", this.cls);
		this.disabled = (Boolean) _values[6];
		this.handleConfig("disabled", this.disabled);
		this.draggable = (Boolean) _values[7];
		this.handleConfig("draggable", this.draggable);
		this.editable = (Boolean) _values[8];
		this.handleConfig("editable", this.editable);
		this.expandable = (Boolean) _values[9];
		this.handleConfig("expandable", this.expandable);
		this.expanded = (Boolean) _values[10];
		this.handleConfig("expanded", this.expanded);
		this.hidden = (Boolean) _values[11];
		this.handleConfig("hidden", this.hidden);
		this.href = (String) _values[12];
		this.handleConfig("href", this.href);
		this.hrefTarget = (String) _values[13];
		this.handleConfig("hrefTarget", this.hrefTarget);
		this.icon = (String) _values[14];
		this.handleConfig("icon", this.icon);
		this.iconCls = (String) _values[15];
		this.handleConfig("iconCls", this.iconCls);
		this.isTarget = (Boolean) _values[16];
		this.handleConfig("isTarget", this.isTarget);
		this.qtip = (String) _values[17];
		this.handleConfig("qtip", this.qtip);
		this.qtipCfg = (String) _values[18];
		this.handleConfig("qtipCfg", this.qtipCfg);
		this.singleClickExpand = (Boolean) _values[19];
		this.handleConfig("singleClickExpand", this.singleClickExpand);
		this.text = (String) _values[20];
		this.handleConfig("text", this.text);
		this.uiProvider = (Object) _values[21];
		this.handleConfig("uiProvider", this.uiProvider);
		this.extDisabled = (Boolean) _values[22];
		this.handleConfig("extDisabled", this.extDisabled);
	}
}