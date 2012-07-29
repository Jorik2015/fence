package ext;

import java.io.Serializable;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.XType;
import ext.base.ExtCommand;

/**
 *Note:This java code is auto generated by abner,do not edit it. Simple Button
 * class
 */
@XType("button")
@InstanceOf("Ext.Button")
public class Button extends ExtCommand implements Serializable{
	private static final long serialVersionUID = -5978087474404901538L;
	public static final String COMPONENT_TYPE = "Ext.Button";
	public static final String COMPONENT_FAMILY = "Ext.Button";

	/**
	 * <p>
	 * Create a new {@link Button} instance with default property values.
	 * </p>
	 */
	public Button() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean allowDepress;

	/**
	 * False to not allow a pressed Button to be depressed (defaults to
	 * undefined). Only valid when <a
	 * href="output/Ext.Button.html#Ext.Button-enableToggle"
	 * ext:member="enableToggle" ext:cls="Ext.Button">enableToggle</a> is true.
	 */
	public Boolean getAllowDepress() {
		if (null != this.allowDepress) {
			return this.allowDepress;
		}
		ValueExpression _ve = getValueExpression("allowDepress");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDepress</code> property.
	 * </p>
	 */
	public void setAllowDepress(Boolean allowDepress) {
		this.allowDepress = allowDepress;
		this.handleConfig("allowDepress", allowDepress);
	}

	private String arrowAlign;

	/**
	 * <p>
	 * (Optional) The side of the Button box to render the arrow if the button
	 * has an associated <a href="output/Ext.Button.html#Ext.Button-menu"
	 * ext:member="menu" ext:cls="Ext.Button">menu</a>. Two values are allowed:
	 * </p>
	 * 
	 * <ul class="mdetail-params">
	 * <li>'right'</li>
	 * 
	 * <li>'bottom'</li>
	 * </ul>
	 * 
	 * <p>
	 * Defaults to <b><tt>'right'</tt></b>.
	 * </p>
	 */
	public String getArrowAlign() {
		if (null != this.arrowAlign) {
			return this.arrowAlign;
		}
		ValueExpression _ve = getValueExpression("arrowAlign");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>arrowAlign</code> property.
	 * </p>
	 */
	public void setArrowAlign(String arrowAlign) {
		this.arrowAlign = arrowAlign;
		this.handleConfig("arrowAlign", arrowAlign);
	}

	private String buttonSelector;

	/**
	 * <p>
	 * (Optional) A <a href="output/Ext.DomQuery.html"
	 * ext:cls="Ext.DomQuery">DomQuery</a> selector which is used to extract the
	 * active, clickable element from the DOM structure created.
	 * </p>
	 * 
	 * <p>
	 * When a custom <a href="output/Ext.Button.html#Ext.Button-template"
	 * ext:member="template" ext:cls="Ext.Button">template</a> is used, you must
	 * ensure that this selector results in the selection of a focussable
	 * element.
	 * </p>
	 * 
	 * <p>
	 * Defaults to <b><tt>'button:first-child'</tt></b>.
	 * </p>
	 */
	public String getButtonSelector() {
		if (null != this.buttonSelector) {
			return this.buttonSelector;
		}
		ValueExpression _ve = getValueExpression("buttonSelector");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonSelector</code> property.
	 * </p>
	 */
	public void setButtonSelector(String buttonSelector) {
		this.buttonSelector = buttonSelector;
		this.handleConfig("buttonSelector", buttonSelector);
	}

	private String clickEvent;

	/**
	 * The type of event to map to the button's event handler (defaults to
	 * 'click')
	 */
	public String getClickEvent() {
		if (null != this.clickEvent) {
			return this.clickEvent;
		}
		ValueExpression _ve = getValueExpression("clickEvent");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>clickEvent</code> property.
	 * </p>
	 */
	public void setClickEvent(String clickEvent) {
		this.clickEvent = clickEvent;
		this.handleConfig("clickEvent", clickEvent);
	}

	private String cls;

	/**
	 * A CSS class string to apply to the button's main element.
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
	 * True to start disabled (defaults to false)
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
	
	private Boolean enableToggle;

	/**
	 * True to enable pressed/not pressed toggling (defaults to false)
	 */
	public Boolean getEnableToggle() {
		if (null != this.enableToggle) {
			return this.enableToggle;
		}
		ValueExpression _ve = getValueExpression("enableToggle");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableToggle</code> property.
	 * </p>
	 */
	public void setEnableToggle(Boolean enableToggle) {
		this.enableToggle = enableToggle;
		this.handleConfig("enableToggle", enableToggle);
	}

	private Boolean handleMouseEvents;

	/**
	 * False to disable visual cues on mouseover, mouseout and mousedown
	 * (defaults to true)
	 */
	public Boolean getHandleMouseEvents() {
		if (null != this.handleMouseEvents) {
			return this.handleMouseEvents;
		}
		ValueExpression _ve = getValueExpression("handleMouseEvents");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>handleMouseEvents</code> property.
	 * </p>
	 */
	public void setHandleMouseEvents(Boolean handleMouseEvents) {
		this.handleMouseEvents = handleMouseEvents;
		this.handleConfig("handleMouseEvents", handleMouseEvents);
	}

	private Object handler;

	/**
	 * A function called when the button is clicked (can be used instead of
	 * click event). The handler is passed the following parameters:
	 * 
	 * <div class="mdetail-params">
	 * <ul>
	 * <li><code>b</code> : Button
	 * 
	 * <div class="sub-desc">This Button.</div></li>
	 * 
	 * <li><code>e</code> : EventObject
	 * 
	 * <div class="sub-desc">The click event.</div></li>
	 * </ul>
	 * </div>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getHandler() {
		if (null != this.handler) {
			return this.handler;
		}
		ValueExpression _ve = getValueExpression("handler");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>handler</code> property.
	 * </p>
	 */
	public void setHandler(Object handler) {
		this.handler = handler;
		this.handleConfig("handler", handler);
	}

	private Boolean hidden;

	/**
	 * True to start hidden (defaults to false)
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

	private String icon;

	/**
	 * The path to an image to display in the button (the image will be set as
	 * the background-image CSS property of the button by default, so if you
	 * want a mixed icon/text button, set cls:'x-btn-text-icon')
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

	private String iconAlign;

	/**
	 * <p>
	 * (Optional) The side of the Button box to render the icon. Four values are
	 * allowed:
	 * </p>
	 * 
	 * <ul class="mdetail-params">
	 * <li>'top'</li>
	 * 
	 * <li>'right'</li>
	 * 
	 * <li>'bottom'</li>
	 * 
	 * <li>'left'</li>
	 * </ul>
	 * 
	 * <p>
	 * Defaults to <b><tt>'left'</tt></b>.
	 * </p>
	 */
	public String getIconAlign() {
		if (null != this.iconAlign) {
			return this.iconAlign;
		}
		ValueExpression _ve = getValueExpression("iconAlign");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>iconAlign</code> property.
	 * </p>
	 */
	public void setIconAlign(String iconAlign) {
		this.iconAlign = iconAlign;
		this.handleConfig("iconAlign", iconAlign);
	}

	private String iconCls;

	/**
	 * A css class which sets a background image to be used as the icon for this
	 * button
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

	private Object menu;

	/**
	 * Standard menu attribute consisting of a reference to a menu object, a
	 * menu id or a menu config blob (defaults to undefined).
	 */
	@ClientConfig(JsonMode.Object)
	public Object getMenu() {
		if (null != this.menu) {
			return this.menu;
		}
		ValueExpression _ve = getValueExpression("menu");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>menu</code> property.
	 * </p>
	 */
	public void setMenu(Object menu) {
		this.menu = menu;
		this.handleConfig("menu", menu);
	}

	private String menuAlign;

	/**
	 * The position to align the menu to (see <a
	 * href="output/Ext.Element.html#Ext.Element-alignTo" ext:member="alignTo"
	 * ext:cls="Ext.Element">Ext.Element.alignTo</a> for more details, defaults
	 * to 'tl-bl?').
	 */
	public String getMenuAlign() {
		if (null != this.menuAlign) {
			return this.menuAlign;
		}
		ValueExpression _ve = getValueExpression("menuAlign");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>menuAlign</code> property.
	 * </p>
	 */
	public void setMenuAlign(String menuAlign) {
		this.menuAlign = menuAlign;
		this.handleConfig("menuAlign", menuAlign);
	}

	private Integer minWidth;

	/**
	 * The minimum width for this button (used to give a set of buttons a common
	 * width). See also <a href="output/Ext.Panel.html"
	 * ext:cls="Ext.Panel">Ext.Panel</a>.
	 * <tt><a href="output/Ext.Panel.html#Ext.Panel-minButtonWidth" ext:member="minButtonWidth" ext:cls="Ext.Panel">minButtonWidth</a></tt>
	 * .
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

	private String overflowText;

	/**
	 * If used in a <a href="output/Ext.Toolbar.html"
	 * ext:cls="Ext.Toolbar">Toolbar</a>, the text to be used if this item is
	 * shown in the overflow menu. See also <a
	 * href="output/Ext.Toolbar.Item.html"
	 * ext:cls="Ext.Toolbar.Item">Ext.Toolbar.Item</a>.
	 * 
	 * <code><a href="output/Ext.Toolbar.Item.html#Ext.Toolbar.Item-overflowText" ext:member="overflowText" ext:cls="Ext.Toolbar.Item">overflowText</a></code>
	 * .
	 */
	public String getOverflowText() {
		if (null != this.overflowText) {
			return this.overflowText;
		}
		ValueExpression _ve = getValueExpression("overflowText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>overflowText</code> property.
	 * </p>
	 */
	public void setOverflowText(String overflowText) {
		this.overflowText = overflowText;
		this.handleConfig("overflowText", overflowText);
	}

	private Boolean pressed;

	/**
	 * True to start pressed (only if enableToggle = true)
	 */
	public Boolean getPressed() {
		if (null != this.pressed) {
			return this.pressed;
		}
		ValueExpression _ve = getValueExpression("pressed");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>pressed</code> property.
	 * </p>
	 */
	public void setPressed(Boolean pressed) {
		this.pressed = pressed;
		this.handleConfig("pressed", pressed);
	}

	private Boolean repeat;

	/**
	 * True to repeat fire the click event while the mouse is down. This can
	 * also be a <a href="output/Ext.util.ClickRepeater.html"
	 * ext:cls="Ext.util.ClickRepeater">ClickRepeater</a> config object
	 * (defaults to false).
	 */
	public Boolean getRepeat() {
		if (null != this.repeat) {
			return this.repeat;
		}
		ValueExpression _ve = getValueExpression("repeat");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>repeat</code> property.
	 * </p>
	 */
	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
		this.handleConfig("repeat", repeat);
	}

	private String scale;

	/**
	 * <p>
	 * (Optional) The size of the Button. Three values are allowed:
	 * </p>
	 * 
	 * <ul class="mdetail-params">
	 * <li>'small'
	 * 
	 * <div class="sub-desc">Results in the button element being 16px
	 * high.</div></li>
	 * 
	 * <li>'medium'
	 * 
	 * <div class="sub-desc">Results in the button element being 24px
	 * high.</div></li>
	 * 
	 * <li>'large'
	 * 
	 * <div class="sub-desc">Results in the button element being 32px
	 * high.</div></li>
	 * </ul>
	 * 
	 * <p>
	 * Defaults to <b><tt>'small'</tt></b>.
	 * </p>
	 */
	public String getScale() {
		if (null != this.scale) {
			return this.scale;
		}
		ValueExpression _ve = getValueExpression("scale");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scale</code> property.
	 * </p>
	 */
	public void setScale(String scale) {
		this.scale = scale;
		this.handleConfig("scale", scale);
	}

	private Object scope;

	/**
	 * The scope (<tt><b>this</b></tt> reference) in which the
	 * <code><a href="output/Ext.Button.html#Ext.Button-handler" ext:member="handler" ext:cls="Ext.Button">handler</a></code>
	 * and
	 * <code><a href="output/Ext.Button.html#Ext.Button-toggleHandler" ext:member="toggleHandler" ext:cls="Ext.Button">toggleHandler</a></code>
	 * is executed. Defaults to this Button.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getScope() {
		if (null != this.scope) {
			return this.scope;
		}
		ValueExpression _ve = getValueExpression("scope");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope(Object scope) {
		this.scope = scope;
		this.handleConfig("scope", scope);
	}

	private Integer tabIndex;

	/**
	 * Set a DOM tabIndex for this button (defaults to undefined)
	 */
	public Integer getTabIndex() {
		if (null != this.tabIndex) {
			return this.tabIndex;
		}
		ValueExpression _ve = getValueExpression("tabIndex");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tabIndex</code> property.
	 * </p>
	 */
	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
		this.handleConfig("tabIndex", tabIndex);
	}

	private Object template;

	/**
	 * <p>
	 * A <a href="output/Ext.Template.html" ext:cls="Ext.Template">Template</a>
	 * used to create the Button's DOM structure.
	 * </p>
	 * 
	 * Instances, or subclasses which need a different DOM structure may provide
	 * a different template layout in conjunction with an implementation of <a
	 * href="output/Ext.Button.html#Ext.Button-getTemplateArgs"
	 * ext:member="getTemplateArgs" ext:cls="Ext.Button">getTemplateArgs</a>.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getTemplate() {
		if (null != this.template) {
			return this.template;
		}
		ValueExpression _ve = getValueExpression("template");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>template</code> property.
	 * </p>
	 */
	public void setTemplate(Object template) {
		this.template = template;
		this.handleConfig("template", template);
	}

	private String text;

	/**
	 * The button text to be used as innerHTML (html tags are accepted)
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

	private String toggleGroup;

	/**
	 * The group this toggle button is a member of (only 1 per group can be
	 * pressed)
	 */
	public String getToggleGroup() {
		if (null != this.toggleGroup) {
			return this.toggleGroup;
		}
		ValueExpression _ve = getValueExpression("toggleGroup");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>toggleGroup</code> property.
	 * </p>
	 */
	public void setToggleGroup(String toggleGroup) {
		this.toggleGroup = toggleGroup;
		this.handleConfig("toggleGroup", toggleGroup);
	}

	private Object toggleHandler;

	/**
	 * Function called when a Button with <a
	 * href="output/Ext.Button.html#Ext.Button-enableToggle"
	 * ext:member="enableToggle" ext:cls="Ext.Button">enableToggle</a> set to
	 * true is clicked. Two arguments are passed:
	 * 
	 * <ul class="mdetail-params">
	 * <li><b>button</b> : Ext.Button
	 * 
	 * <div class="sub-desc">this Button object</div></li>
	 * 
	 * <li><b>state</b> : Boolean
	 * 
	 * <div class="sub-desc">The next state if the Button, true means
	 * pressed.</div></li>
	 * </ul>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getToggleHandler() {
		if (null != this.toggleHandler) {
			return this.toggleHandler;
		}
		ValueExpression _ve = getValueExpression("toggleHandler");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>toggleHandler</code> property.
	 * </p>
	 */
	public void setToggleHandler(Object toggleHandler) {
		this.toggleHandler = toggleHandler;
		this.handleConfig("toggleHandler", toggleHandler);
	}

	private String tooltip;

	/**
	 * The tooltip for the button - can be a string to be used as innerHTML
	 * (html tags are accepted) or QuickTips config object
	 */
	public String getTooltip() {
		if (null != this.tooltip) {
			return this.tooltip;
		}
		ValueExpression _ve = getValueExpression("tooltip");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tooltip</code> property.
	 * </p>
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
		this.handleConfig("tooltip", tooltip);
	}

	private String tooltipType;

	/**
	 * The type of tooltip to use. Either 'qtip' (default) for QuickTips or
	 * 'title' for title attribute.
	 */
	public String getTooltipType() {
		if (null != this.tooltipType) {
			return this.tooltipType;
		}
		ValueExpression _ve = getValueExpression("tooltipType");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tooltipType</code> property.
	 * </p>
	 */
	public void setTooltipType(String tooltipType) {
		this.tooltipType = tooltipType;
		this.handleConfig("tooltipType", tooltipType);
	}

	private String type;

	/**
	 * submit, reset or button - defaults to 'button'
	 */
	public String getType() {
		if (null != this.type) {
			return this.type;
		}
		ValueExpression _ve = getValueExpression("type");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType(String type) {
		this.type = type;
		this.handleConfig("type", type);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[31];
		}
		_values[0] = super.saveState(_context);
		_values[1] = allowDepress;
		_values[2] = arrowAlign;
		_values[3] = buttonSelector;
		_values[4] = clickEvent;
		_values[5] = cls;
		_values[6] = disabled;
		_values[7] = enableToggle;
		_values[8] = handleMouseEvents;
		_values[9] = handler;
		_values[10] = hidden;
		_values[11] = icon;
		_values[12] = iconAlign;
		_values[13] = iconCls;
		_values[14] = menu;
		_values[15] = menuAlign;
		_values[16] = minWidth;
		_values[17] = overflowText;
		_values[18] = pressed;
		_values[19] = repeat;
		_values[20] = scale;
		_values[21] = scope;
		_values[22] = tabIndex;
		_values[23] = template;
		_values[24] = text;
		_values[25] = toggleGroup;
		_values[26] = toggleHandler;
		_values[27] = tooltip;
		_values[28] = tooltipType;
		_values[29] = type;
		_values[30] = extDisabled;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.allowDepress = (Boolean) _values[1];
		this.handleConfig("allowDepress", this.allowDepress);
		this.arrowAlign = (String) _values[2];
		this.handleConfig("arrowAlign", this.arrowAlign);
		this.buttonSelector = (String) _values[3];
		this.handleConfig("buttonSelector", this.buttonSelector);
		this.clickEvent = (String) _values[4];
		this.handleConfig("clickEvent", this.clickEvent);
		this.cls = (String) _values[5];
		this.handleConfig("cls", this.cls);
		this.disabled = (Boolean) _values[6];
		this.handleConfig("disabled", this.disabled);
		this.enableToggle = (Boolean) _values[7];
		this.handleConfig("enableToggle", this.enableToggle);
		this.handleMouseEvents = (Boolean) _values[8];
		this.handleConfig("handleMouseEvents", this.handleMouseEvents);
		this.handler = (Object) _values[9];
		this.handleConfig("handler", this.handler);
		this.hidden = (Boolean) _values[10];
		this.handleConfig("hidden", this.hidden);
		this.icon = (String) _values[11];
		this.handleConfig("icon", this.icon);
		this.iconAlign = (String) _values[12];
		this.handleConfig("iconAlign", this.iconAlign);
		this.iconCls = (String) _values[13];
		this.handleConfig("iconCls", this.iconCls);
		this.menu = (Object) _values[14];
		this.handleConfig("menu", this.menu);
		this.menuAlign = (String) _values[15];
		this.handleConfig("menuAlign", this.menuAlign);
		this.minWidth = (Integer) _values[16];
		this.handleConfig("minWidth", this.minWidth);
		this.overflowText = (String) _values[17];
		this.handleConfig("overflowText", this.overflowText);
		this.pressed = (Boolean) _values[18];
		this.handleConfig("pressed", this.pressed);
		this.repeat = (Boolean) _values[19];
		this.handleConfig("repeat", this.repeat);
		this.scale = (String) _values[20];
		this.handleConfig("scale", this.scale);
		this.scope = (Object) _values[21];
		this.handleConfig("scope", this.scope);
		this.tabIndex = (Integer) _values[22];
		this.handleConfig("tabIndex", this.tabIndex);
		this.template = (Object) _values[23];
		this.handleConfig("template", this.template);
		this.text = (String) _values[24];
		this.handleConfig("text", this.text);
		this.toggleGroup = (String) _values[25];
		this.handleConfig("toggleGroup", this.toggleGroup);
		this.toggleHandler = (Object) _values[26];
		this.handleConfig("toggleHandler", this.toggleHandler);
		this.tooltip = (String) _values[27];
		this.handleConfig("tooltip", this.tooltip);
		this.tooltipType = (String) _values[28];
		this.handleConfig("tooltipType", this.tooltipType);
		this.type = (String) _values[29];
		this.handleConfig("type", this.type);
		this.extDisabled = (Boolean) _values[30];
		this.handleConfig("extDisabled", this.extDisabled);
	}
}