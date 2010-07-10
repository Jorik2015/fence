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
 * Container for a group of buttons.
  Example usage: 


var p = 
new Ext.Panel({
    title: 
'Panel 
with Button Group',
    width: 300,
    height:200,
    renderTo: document.body,
    html: 
'whatever',
    tbar: [{
        xtype: 
'buttongroup',
        
columns: 3,
        title: 
'Clipboard',
        items: [{
            text: 
'Paste',
            scale: 
'large',
            rowspan: 3, iconCls: 
'add',
            iconAlign: 
'top',
            cls: 
'x-btn-as-arrow'
        },{
            xtype:
'splitbutton',
            text: 
'Menu Button',
            scale: 
'large',
            rowspan: 3,
            iconCls: 
'add',
            iconAlign: 
'top',
            arrowAlign:
'bottom',
            menu: [{text: 
'Menu Item 1'}]
        },{
            xtype:
'splitbutton', text: 
'Cut', iconCls: 
'add16', menu: [{text: 
'Cut Menu Item'}]
        },{
            text: 
'Copy', iconCls: 
'add16'
        },{
            text: 
'Format', iconCls: 
'add16'
        }]
    }]
});
  
 */
@XType("buttongroup")
@InstanceOf("Ext.ButtonGroup")

@FacesComponent(value = "Ext.ButtonGroup")
public class ButtonGroup extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.ButtonGroup";

	/**
	 * <p>
	 * Create a new {@link Ext.ButtonGroup} instance with default property values.
	 * </p>
	 */
	public ButtonGroup() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			frame
			,layout
			,columns
			,baseCls
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
	 *
        
        
          frame
         : Boolean
        Defaults to 
        true. See 
        Ext.Panel.frame.
	 */
	
	public Boolean getFrame () {
		return (Boolean) getStateHelper().eval(PropertyKeys.frame);
	}

	/**
	 * <p>
	 * Set the value of the <code>frame</code> property.
	 * </p>
	 */
	public void setFrame ( Boolean   frame ) {
		getStateHelper().put(PropertyKeys.frame, frame);
		handleAttribute("frame", frame);
	}
    	/*
	 *
        
        
          layout
         : String
        Defaults to 
        'table'. See 
        Ext.Container.layout.
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
	 *
        
        
          columns
         : Number
        The 
        columns configuration property passed to the 
        configured
        layout manager. See 
        Ext.layout.TableLayout.columns.
	 */
	
	public Integer getColumns () {
		return (Integer) getStateHelper().eval(PropertyKeys.columns);
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns ( Integer   columns ) {
		getStateHelper().put(PropertyKeys.columns, columns);
		handleAttribute("columns", columns);
	}
    	/*
	 *
        
        
          baseCls
         : String
        Defaults to 
        'x-btn-group'. See 
        Ext.Panel.baseCls.
	 */
	
	public String getBaseCls () {
		return (String) getStateHelper().eval(PropertyKeys.baseCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseCls</code> property.
	 * </p>
	 */
	public void setBaseCls ( String   baseCls ) {
		getStateHelper().put(PropertyKeys.baseCls, baseCls);
		handleAttribute("baseCls", baseCls);
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