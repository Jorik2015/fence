package ext;

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
import java.util.Date;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?> <div
 * class="description">
 * <p>
 * An Action is a piece of reusable functionality that can be abstracted out of
 * any particular component so that it can be usefully shared among multiple
 * components. Actions let you share handlers, configuration options and UI
 * updates across any components that support the Action interface (primarily <a
 * ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Ext.Toolbar</a>, <a
 * ext:cls="Ext.Button" href="output/Ext.Button.html">Ext.Button</a> and <a
 * ext:cls="Ext.menu.Menu" href="output/Ext.menu.Menu.html">Ext.menu.Menu</a>
 * components).
 * </p>
 * <p>
 * Aside from supporting the config object interface, any component that needs
 * to use Actions must also support the following method list, as these will be
 * called as needed by the Action class: setText(string), setIconCls(string),
 * setDisabled(boolean), setVisible(boolean) and setHandler(function).
 * </p>
 * Example usage: <br/>
 * 
 * <pre>
 * <code>
 * <i>// Define the shared action.  Each component below will have the
 * same</i>
 * <i>// display text and icon, and will display the same message on
 * click.</i>
 * <b>var</b> action = 
 * <b>new</b> Ext.Action({
 *     
 * <a ext:cls="Ext.Action" ext:member="text" href="output/Ext.Action.html#Ext.Action-text">text</a>: 
 * <em>'Do something'</em>,
 *     
 * <a ext:cls="Ext.Action" ext:member="handler" href="output/Ext.Action.html#Ext.Action-handler">handler</a>: 
 * <b>function</b>(){
 *         Ext.Msg.alert(
 * <em>'Click'</em>, 
 * <em>'You did something.'</em>);
 *     },
 *     
 * <a ext:cls="Ext.Action" ext:member="iconCls" href="output/Ext.Action.html#Ext.Action-iconCls">iconCls</a>: 
 * <em>'
 * <b>do</b>-something'</em>,
 *     
 * <a ext:cls="Ext.Action" ext:member="itemId" href="output/Ext.Action.html#Ext.Action-itemId">itemId</a>: 
 * <em>'myAction'</em>
 * });
 * 
 * <b>var</b> panel = 
 * <b>new</b> Ext.Panel({
 *     title: 
 * <em>'Actions'</em>,
 *     width: 500,
 *     height: 300,
 *     tbar: [
 *         
 * <i>// Add the action directly to a toolbar as a menu button</i>
 *         action,
 *         {
 *             text: 
 * <em>'Action Menu'</em>,
 *             
 * <i>// Add the action to a menu as a text item</i>
 *             menu: [action]
 *         }
 *     ],
 *     items: [
 *         
 * <i>// Add the action to the panel body as a standard button</i>
 *         
 * <b>new</b> Ext.Button(action)
 *     ],
 *     renderTo: Ext.getBody()
 * });
 * 
 * <i>// Change the text 
 * <b>for</b> all components using the action</i>
 * action.setText(
 * <em>'Something 
 * <b>else</b>'</em>);
 * 
 * <i>// Reference an action through a container using the itemId</i>
 * <b>var</b> btn = panel.getComponent(
 * <em>'myAction'</em>);
 * <b>var</b> aRef = btn.baseAction;
 * aRef.setText(
 * <em>'New text'</em>);</code>
 * </pre>
 * 
 * </div>
 */

@InstanceOf("Ext.Action")
@ParseConfigMode(ui = false, pmode = PersistenceMode.Custom, rmode = ReferenceMode.Var)
@FacesComponent(value = "Ext.Action")
public class Action extends HackAction {
	public static final String COMPONENT_FAMILY = "Ext.Action";

	/**
	 * <p>
	 * Create a new {@link Ext.Action} instance with default property values.
	 * </p>
	 */
	public Action() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	enum PropertyKeys {
		text, scope, hidden, itemId, iconCls, disabled, handler;
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
	 * text : String The text to set for all components using this action
	 * (defaults to '').
	 */

	public String getText() {
		return (String) getStateHelper().eval(PropertyKeys.text);
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText(String text) {
		getStateHelper().put(PropertyKeys.text, text);
		handleAttribute("text", text);
	}

	/*
	 * 
	 * 
	 * 
	 * scope : Object The scope (
	 * 
	 * this reference) in which the
	 * 
	 * handler is executed. Defaults to this Button.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getScope() {
		return (Object) getStateHelper().eval(PropertyKeys.scope);
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope(Object scope) {
		getStateHelper().put(PropertyKeys.scope, scope);
		handleAttribute("scope", scope);
	}

	/*
	 * 
	 * 
	 * 
	 * hidden : Boolean True to hide all components using this action, false to
	 * show them (defaults to false).
	 */

	public Boolean getHidden() {
		return (Boolean) getStateHelper().eval(PropertyKeys.hidden);
	}

	/**
	 * <p>
	 * Set the value of the <code>hidden</code> property.
	 * </p>
	 */
	public void setHidden(Boolean hidden) {
		getStateHelper().put(PropertyKeys.hidden, hidden);
		handleAttribute("hidden", hidden);
	}

	/*
	 * 
	 * 
	 * 
	 * itemId : String See Ext.Component. itemId.
	 */

	public String getItemId() {
		return (String) getStateHelper().eval(PropertyKeys.itemId);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemId</code> property.
	 * </p>
	 */
	public void setItemId(String itemId) {
		getStateHelper().put(PropertyKeys.itemId, itemId);
		handleAttribute("itemId", itemId);
	}

	/*
	 *  <div
	 * class="long">The CSS class selector that specifies a background image to
	 * be used as the header icon for all components using this action (defaults
	 * to ''). <p>An example of specifying a custom icon class would be
	 * something like:</p> <pre> <code> <i>// specify the property <b>in</b> the
	 * config <b>for</b> the class:</i> ... iconCls: <em>'
	 * <b>do</b>-something'</em>
	 * 
	 * <i>// css class that specifies background image to be used as the icon
	 * image:</i> . <b>do</b>-something { background-image:
	 * url(../images/my-icon.gif) 0 6px no-repeat !important; }</code> </pre>
	 * </div>
	 */

	public String getIconCls() {
		return (String) getStateHelper().eval(PropertyKeys.iconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>iconCls</code> property.
	 * </p>
	 */
	public void setIconCls(String iconCls) {
		getStateHelper().put(PropertyKeys.iconCls, iconCls);
		handleAttribute("iconCls", iconCls);
	}

	/*
	 * 
	 * 
	 * 
	 * disabled : Boolean True to disable all components using this action,
	 * false to enable them (defaults to false).
	 */

	public Boolean getDisabled() {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setDisabled(Boolean disabled) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
		handleAttribute("disabled", disabled);
	}

	/*
	 * <?xml version="1.0" encoding="UTF-8" standalone="no"?> <div
	 * class="long">The function that will be invoked by each component tied to
	 * this action when the component's primary event is triggered (defaults to
	 * undefined).</div>
	 */
	@ClientConfig(JsonMode.Function)
	public Object getHandler() {
		return (Object) getStateHelper().eval(PropertyKeys.handler);
	}

	/**
	 * <p>
	 * Set the value of the <code>handler</code> property.
	 * </p>
	 */
	public void setHandler(Object handler) {
		getStateHelper().put(PropertyKeys.handler, handler);
		handleAttribute("handler", handler);
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