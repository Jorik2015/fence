package ext.menu;

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
import ext.form.Action;
import java.util.Date;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">Adds a menu item that contains a
  checkbox by default, but can also be part of a radio group.</div>

 */
@XType("menucheckitem")
@InstanceOf("Ext.menu.CheckItem")
@ParseConfigMode(name="items",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.menu.CheckItem")
public class CheckItem extends Item {
	public static final String COMPONENT_FAMILY = "Ext.menu.CheckItem";

	/**
	 * <p>
	 * Create a new {@link Ext.menu.CheckItem} instance with default property values.
	 * </p>
	 */
	public CheckItem() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			groupClass
			,itemCls
			,group
			,checked
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
        
        
          groupClass
         : String
        The default CSS class to use for radio
        group check items (defaults to
        "x-menu-group-item")
	 */
	
	public String getGroupClass () {
		return (String) getStateHelper().eval(PropertyKeys.groupClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>groupClass</code> property.
	 * </p>
	 */
	public void setGroupClass ( String   groupClass ) {
		getStateHelper().put(PropertyKeys.groupClass, groupClass);
		handleAttribute("groupClass", groupClass);
	}
    	/*
	 *
        
        
          itemCls
         : String
        The default CSS class to use for check
        items (defaults to "x-menu-item
        x-menu-check-item")
	 */
	
	public String getItemCls () {
		return (String) getStateHelper().eval(PropertyKeys.itemCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemCls</code> property.
	 * </p>
	 */
	public void setItemCls ( String   itemCls ) {
		getStateHelper().put(PropertyKeys.itemCls, itemCls);
		handleAttribute("itemCls", itemCls);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">All check items with the same group
          name will automatically be grouped into a single-select
          radio button group (defaults to '')</div>

	 */
	
	public String getGroup () {
		return (String) getStateHelper().eval(PropertyKeys.group);
	}

	/**
	 * <p>
	 * Set the value of the <code>group</code> property.
	 * </p>
	 */
	public void setGroup ( String   group ) {
		getStateHelper().put(PropertyKeys.group, group);
		handleAttribute("group", group);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to initialize this checkbox as
          checked (defaults to false). Note that if this checkbox
          is part of a radio group (group = true) only the first
          item in the group that is initialized with checked = true
          will be rendered as checked.</div>

	 */
	
	public Boolean getChecked () {
		return (Boolean) getStateHelper().eval(PropertyKeys.checked);
	}

	/**
	 * <p>
	 * Set the value of the <code>checked</code> property.
	 * </p>
	 */
	public void setChecked ( Boolean   checked ) {
		getStateHelper().put(PropertyKeys.checked, checked);
		handleAttribute("checked", checked);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforecheckchange"
					, "checkchange"
				));
				return superEvent;
	}
}