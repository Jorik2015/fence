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
 * 
  Basic Toolbar class. Although the 
  
    defaultType
   for Toolbar is 
  
    button
  , Toolbar elements (child items for the Toolbar container)
  may be virtually any type of Component. Toolbar elements can be
  created explicitly via their constructors, or implicitly via
  their xtypes, and can be 
  
    add
  ed dynamically.
  Some items have shortcut strings for creation:

Shortcut  
xtype          
Class                  
Description
'->'      'tbfill'       
Ext.Toolbar.Fill       begin using
the right-justified button container
'-'       'tbseparator'  
Ext.Toolbar.Separator  add a
vertical separator bar between toolbar items
' '       'tbspacer'     
Ext.Toolbar.Spacer     add
horiztonal space between elements
  Example usage of various elements: 


var tb = 
new Ext.Toolbar({
    renderTo: document.body,
    width: 600,
    height: 100,
    items: [
        {
            
// xtype: 
'button', // 
default 
for Toolbars, same as 
'tbbutton'
            text: 
'Button'
        },
        {
            xtype: 
'splitbutton', 
// same as 
'tbsplitbutton'
            text: 
'Split Button'
        },
        
// begin using the right-justified button container
        
'->', 
// same as {xtype: 
'tbfill'}, // Ext.Toolbar.Fill
        {
            xtype: 
'textfield',
            name: 
'field1',
            emptyText: 
'enter search term'
        },
        
// add a vertical separator bar between toolbar items
        
'-', 
// same as {xtype: 
'tbseparator'} to create Ext.Toolbar.Separator
        
'text 1', 
// same as {xtype: 
'tbtext', text: 
'text1'} to create Ext.Toolbar.TextItem
        {xtype: 
'tbspacer'},
// same as 
' ' to create Ext.Toolbar.Spacer
        
'text 2',
        {xtype: 
'tbspacer', width: 50}, 
// add a 50px space
        
'text 3'
    ]
});
  Example adding a ComboBox within a menu of a button: 


// ComboBox creation
var combo = 
new Ext.form.ComboBox({
    store: 
new Ext.data.ArrayStore({
        autoDestroy: true,
        fields: [
'initials', 
'fullname'],
        data : [
            [
'FF', 
'Fred Flintstone'],
            [
'BR', 
'Barney Rubble']
        ]
    }),
    displayField: 
'fullname',
    typeAhead: true,
    mode: 
'local',
    forceSelection: true,
    triggerAction: 
'all',
    emptyText: 
'Select a name...',
    selectOnFocus: true,
    width: 135,
    getListParent: 
function() {
        
return this.el.up(
'.x-menu');
    },
    iconCls: 
'no-icon' 
//use iconCls 
if placing within menu to shift to right side of menu
});

// put ComboBox 
in a Menu
var menu = 
new Ext.menu.Menu({
    id: 
'mainMenu',
    items: [
        combo 
// A Field 
in a Menu
    ]
});

// add a Button 
with the menu
tb.add({
        text:
'Button w/ Menu',
        menu: menu  
// assign menu by instance
    });
tb.doLayout();
  
 */
@XType("toolbar")
@InstanceOf("Ext.Toolbar")

@FacesComponent(value = "Ext.Toolbar")
public class Toolbar extends Container {
	public static final String COMPONENT_FAMILY = "Ext.Toolbar";

	/**
	 * <p>
	 * Create a new {@link Ext.Toolbar} instance with default property values.
	 * </p>
	 */
	public Toolbar() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			layout
			,enableOverflow
			,buttonAlign
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
	 *This class assigns a default layout (
          layout:
          '
          toolbar'). Developers 
          may override this configuration option if another
          layout is required (the constructor must be passed a
          configuration object in this case instead of an array).
          See 
          Ext.Container.layout for
          additional information.
	 */
	
	public String getLayout () {
		return (String) getStateHelper().eval(PropertyKeys.layout);
	}

	/**
	 * <p>
	 * Set the value of the <code>layout</code> property.
	 * </p>
	 */
	public void setLayout ( String   layout ) {
		getStateHelper().put(PropertyKeys.layout, layout);
		handleAttribute("layout", layout);
	}
    	/*
	 *Defaults to false. Configure 
          true to make the toolbar provide a button
          which activates a dropdown Menu to show items which
          overflow the Toolbar
          's width.
	 */
	
	public Boolean getEnableOverflow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableOverflow);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableOverflow</code> property.
	 * </p>
	 */
	public void setEnableOverflow ( Boolean   enableOverflow ) {
		getStateHelper().put(PropertyKeys.enableOverflow, enableOverflow);
		handleAttribute("enableOverflow", enableOverflow);
	}
    	/*
	 *
            The default position at which to align child items.
            Defaults to 
            
              "left"
            
            May be specified as 
            
              "center"
             to cause items added before a Fill (A 
            
              "->"
            ) item to be centered in the Toolbar. Items
            added after a Fill are still right-aligned.
            Specify as 
            
              "right"
             to right align all child items.
          
	 */
	
	public String getButtonAlign () {
		return (String) getStateHelper().eval(PropertyKeys.buttonAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonAlign</code> property.
	 * </p>
	 */
	public void setButtonAlign ( String   buttonAlign ) {
		getStateHelper().put(PropertyKeys.buttonAlign, buttonAlign);
		handleAttribute("buttonAlign", buttonAlign);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "overflowchange"
				));
				return superEvent;
	}
}