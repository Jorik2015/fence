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
 * A specialized SplitButton that contains
  a menu of 
  Ext.menu.CheckItem elements. The
  button automatically cycles through each menu item on click,
  raising the button's 
  change event
  (or calling the button's 
  changeHandler function, if
  supplied) for the active menu item. Clicking on the arrow section
  of the button displays the dropdown menu just like a normal
  SplitButton. Example usage: 


var btn = 
new Ext.CycleButton({
    showText: true,
    prependText: 
'View as ',
    items: [{
        text:
'text only',
        iconCls:
'view-text',
        checked:true
    },{
        text:
'HTML',
        iconCls:
'view-html'
    }],
    changeHandler:
function(btn, item){
        Ext.Msg.alert(
'Change View', item.text);
    }
});
  
 */
@XType("cycle")
@InstanceOf("Ext.CycleButton")

@FacesComponent(value = "Ext.CycleButton")
public class CycleButton extends SplitButton {
	public static final String COMPONENT_FAMILY = "Ext.CycleButton";

	/**
	 * <p>
	 * Create a new {@link Ext.CycleButton} instance with default property values.
	 * </p>
	 */
	public CycleButton() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			changeHandler
			,prependText
			,items
			,forceIcon
			,showText
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
	 *A callback function that will be
          invoked each time the active menu item in the button's
          menu has changed. If this callback is not supplied, the
          SplitButton will instead fire the 
          change
          event on active item change. The changeHandler function
          will be called with the following argument list:
          (SplitButton this, Ext.menu.CheckItem item)
	 */
	@ClientConfig(JsonMode.Function)

	public Object getChangeHandler () {
		return (Object) getStateHelper().eval(PropertyKeys.changeHandler);
	}

	/**
	 * <p>
	 * Set the value of the <code>changeHandler</code> property.
	 * </p>
	 */
	public void setChangeHandler ( Object   changeHandler ) {
		getStateHelper().put(PropertyKeys.changeHandler, changeHandler);
		handleAttribute("changeHandler", changeHandler);
	}
    	/*
	 *A static string to prepend before the
          active item's text when displayed as the button's text
          (only applies when showText = true, defaults to '')
	 */
	
	public String getPrependText () {
		return (String) getStateHelper().eval(PropertyKeys.prependText);
	}

	/**
	 * <p>
	 * Set the value of the <code>prependText</code> property.
	 * </p>
	 */
	public void setPrependText ( String   prependText ) {
		getStateHelper().put(PropertyKeys.prependText, prependText);
		handleAttribute("prependText", prependText);
	}
    	/*
	 *An array of 
          Ext.menu.CheckItem 
          config objects to be used when creating the
          button's menu items (e.g., {text:'Foo',
          iconCls:'foo-icon'})
	 */
	@ClientConfig(JsonMode.Array)

	public Object getItems () {
		return (Object) getStateHelper().eval(PropertyKeys.items);
	}

	/**
	 * <p>
	 * Set the value of the <code>items</code> property.
	 * </p>
	 */
	public void setItems ( Object   items ) {
		getStateHelper().put(PropertyKeys.items, items);
		handleAttribute("items", items);
	}
    	/*
	 *A css class which sets an image to be
          used as the static icon for this button. This icon will
          always be displayed regardless of which item is selected
          in the dropdown list. This overrides the default behavior
          of changing the button's icon to match the selected
          item's icon on change.
	 */
	
	public String getForceIcon () {
		return (String) getStateHelper().eval(PropertyKeys.forceIcon);
	}

	/**
	 * <p>
	 * Set the value of the <code>forceIcon</code> property.
	 * </p>
	 */
	public void setForceIcon ( String   forceIcon ) {
		getStateHelper().put(PropertyKeys.forceIcon, forceIcon);
		handleAttribute("forceIcon", forceIcon);
	}
    	/*
	 *
        
        
          showText
         : Boolean
        True to display the active item's text
        as the button text (defaults to false)
	 */
	
	public Boolean getShowText () {
		return (Boolean) getStateHelper().eval(PropertyKeys.showText);
	}

	/**
	 * <p>
	 * Set the value of the <code>showText</code> property.
	 * </p>
	 */
	public void setShowText ( Boolean   showText ) {
		getStateHelper().put(PropertyKeys.showText, showText);
		handleAttribute("showText", showText);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "change"
				));
				return superEvent;
	}
}