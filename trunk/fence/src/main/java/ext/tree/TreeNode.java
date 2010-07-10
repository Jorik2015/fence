package ext.tree;

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
 * ${ext.commonts}
 */

@InstanceOf("Ext.tree.TreeNode")

@FacesComponent(value = "Ext.tree.TreeNode")
public class TreeNode extends Node {
	public static final String COMPONENT_FAMILY = "Ext.tree.TreeNode";

	/**
	 * <p>
	 * Create a new {@link Ext.tree.TreeNode} instance with default property values.
	 * </p>
	 */
	public TreeNode() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			editable
			,qtipCfg
			,allowDrop
			,href
			,isTarget
			,iconCls
			,disabled
			,cls
			,qtip
			,draggable
			,singleClickExpand
			,expandable
			,text
			,hidden
			,icon
			,allowChildren
			,allowDrag
			,expanded
			,checked
			,hrefTarget
			,uiProvider
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
        
        
          editable
         : Boolean
        False to not allow this node to be
        edited by an 
        Ext.tree.TreeEditor
        (defaults to true)
	 */
	
	public Boolean getEditable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.editable);
	}

	/**
	 * <p>
	 * Set the value of the <code>editable</code> property.
	 * </p>
	 */
	public void setEditable ( Boolean   editable ) {
		getStateHelper().put(PropertyKeys.editable, editable);
		handleAttribute("editable", editable);
	}
    	/*
	 *
        
        
          qtipCfg
         : String
        An Ext QuickTip config for the node
        (used instead of qtip)
	 */
	
	public String getQtipCfg () {
		return (String) getStateHelper().eval(PropertyKeys.qtipCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>qtipCfg</code> property.
	 * </p>
	 */
	public void setQtipCfg ( String   qtipCfg ) {
		getStateHelper().put(PropertyKeys.qtipCfg, qtipCfg);
		handleAttribute("qtipCfg", qtipCfg);
	}
    	/*
	 *
        
        
          allowDrop
         : Boolean
        False if this node cannot have child
        nodes dropped on it (defaults to true)
	 */
	
	public Boolean getAllowDrop () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowDrop);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDrop</code> property.
	 * </p>
	 */
	public void setAllowDrop ( Boolean   allowDrop ) {
		getStateHelper().put(PropertyKeys.allowDrop, allowDrop);
		handleAttribute("allowDrop", allowDrop);
	}
    	/*
	 *
        
        
          href
         : String
        URL of the link used for the node
        (defaults to #)
	 */
	
	public String getHref () {
		return (String) getStateHelper().eval(PropertyKeys.href);
	}

	/**
	 * <p>
	 * Set the value of the <code>href</code> property.
	 * </p>
	 */
	public void setHref ( String   href ) {
		getStateHelper().put(PropertyKeys.href, href);
		handleAttribute("href", href);
	}
    	/*
	 *
        
        
          isTarget
         : Boolean
        False to not allow this node to act as a
        drop target (defaults to true)
	 */
	
	public Boolean getIsTarget () {
		return (Boolean) getStateHelper().eval(PropertyKeys.isTarget);
	}

	/**
	 * <p>
	 * Set the value of the <code>isTarget</code> property.
	 * </p>
	 */
	public void setIsTarget ( Boolean   isTarget ) {
		getStateHelper().put(PropertyKeys.isTarget, isTarget);
		handleAttribute("isTarget", isTarget);
	}
    	/*
	 *
        
        
          iconCls
         : String
        A css class to be added to the nodes
        icon element for applying css background images
	 */
	
	public String getIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.iconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>iconCls</code> property.
	 * </p>
	 */
	public void setIconCls ( String   iconCls ) {
		getStateHelper().put(PropertyKeys.iconCls, iconCls);
		handleAttribute("iconCls", iconCls);
	}
    	/*
	 *
        
        
          disabled
         : Boolean
        true to start the node
        disabled
	 */
	
	public Boolean getDisabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setDisabled ( Boolean   disabled ) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
		handleAttribute("disabled", disabled);
	}
    	/*
	 *
        
        
          cls
         : String
        A css class to be added to the
        node
	 */
	
	public String getCls () {
		return (String) getStateHelper().eval(PropertyKeys.cls);
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls ( String   cls ) {
		getStateHelper().put(PropertyKeys.cls, cls);
		handleAttribute("cls", cls);
	}
    	/*
	 *
        
        
          qtip
         : String
        An Ext QuickTip for the node
	 */
	
	public String getQtip () {
		return (String) getStateHelper().eval(PropertyKeys.qtip);
	}

	/**
	 * <p>
	 * Set the value of the <code>qtip</code> property.
	 * </p>
	 */
	public void setQtip ( String   qtip ) {
		getStateHelper().put(PropertyKeys.qtip, qtip);
		handleAttribute("qtip", qtip);
	}
    	/*
	 *
        
        
          draggable
         : Boolean
        True to make this node draggable
        (defaults to false)
	 */
	
	public Boolean getDraggable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.draggable);
	}

	/**
	 * <p>
	 * Set the value of the <code>draggable</code> property.
	 * </p>
	 */
	public void setDraggable ( Boolean   draggable ) {
		getStateHelper().put(PropertyKeys.draggable, draggable);
		handleAttribute("draggable", draggable);
	}
    	/*
	 *
        
        
          singleClickExpand
         : Boolean
        True for single click expand on this
        node
	 */
	
	public Boolean getSingleClickExpand () {
		return (Boolean) getStateHelper().eval(PropertyKeys.singleClickExpand);
	}

	/**
	 * <p>
	 * Set the value of the <code>singleClickExpand</code> property.
	 * </p>
	 */
	public void setSingleClickExpand ( Boolean   singleClickExpand ) {
		getStateHelper().put(PropertyKeys.singleClickExpand, singleClickExpand);
		handleAttribute("singleClickExpand", singleClickExpand);
	}
    	/*
	 *
        
        
          expandable
         : Boolean
        If set to true, the node will always
        show a plus/minus icon, even when empty
	 */
	
	public Boolean getExpandable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.expandable);
	}

	/**
	 * <p>
	 * Set the value of the <code>expandable</code> property.
	 * </p>
	 */
	public void setExpandable ( Boolean   expandable ) {
		getStateHelper().put(PropertyKeys.expandable, expandable);
		handleAttribute("expandable", expandable);
	}
    	/*
	 *
        
        
          text
         : String
        The text for this node
	 */
	
	public String getText () {
		return (String) getStateHelper().eval(PropertyKeys.text);
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText ( String   text ) {
		getStateHelper().put(PropertyKeys.text, text);
		handleAttribute("text", text);
	}
    	/*
	 *
        
        
          hidden
         : Boolean
        True to render hidden. (Defaults to
        false).
	 */
	
	public Boolean getHidden () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hidden);
	}

	/**
	 * <p>
	 * Set the value of the <code>hidden</code> property.
	 * </p>
	 */
	public void setHidden ( Boolean   hidden ) {
		getStateHelper().put(PropertyKeys.hidden, hidden);
		handleAttribute("hidden", hidden);
	}
    	/*
	 *The path to an icon for the node. The
          preferred way to do this is to use the cls or iconCls
          attributes and add the icon via a CSS background
          image.
	 */
	
	public String getIcon () {
		return (String) getStateHelper().eval(PropertyKeys.icon);
	}

	/**
	 * <p>
	 * Set the value of the <code>icon</code> property.
	 * </p>
	 */
	public void setIcon ( String   icon ) {
		getStateHelper().put(PropertyKeys.icon, icon);
		handleAttribute("icon", icon);
	}
    	/*
	 *
        
        
          allowChildren
         : Boolean
        False to not allow this node to have
        child nodes (defaults to true)
	 */
	
	public Boolean getAllowChildren () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowChildren);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowChildren</code> property.
	 * </p>
	 */
	public void setAllowChildren ( Boolean   allowChildren ) {
		getStateHelper().put(PropertyKeys.allowChildren, allowChildren);
		handleAttribute("allowChildren", allowChildren);
	}
    	/*
	 *
        
        
          allowDrag
         : Boolean
        False to make this node undraggable if 
        draggable = true (defaults
        to true)
	 */
	
	public Boolean getAllowDrag () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowDrag);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowDrag</code> property.
	 * </p>
	 */
	public void setAllowDrag ( Boolean   allowDrag ) {
		getStateHelper().put(PropertyKeys.allowDrag, allowDrag);
		handleAttribute("allowDrag", allowDrag);
	}
    	/*
	 *
        
        
          expanded
         : Boolean
        true to start the node
        expanded
	 */
	
	public Boolean getExpanded () {
		return (Boolean) getStateHelper().eval(PropertyKeys.expanded);
	}

	/**
	 * <p>
	 * Set the value of the <code>expanded</code> property.
	 * </p>
	 */
	public void setExpanded ( Boolean   expanded ) {
		getStateHelper().put(PropertyKeys.expanded, expanded);
		handleAttribute("expanded", expanded);
	}
    	/*
	 *True to render a checked checkbox for
          this node, false to render an unchecked checkbox
          (defaults to undefined with no checkbox rendered)
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
    	/*
	 *
        
        
          hrefTarget
         : String
        target frame for the link
	 */
	
	public String getHrefTarget () {
		return (String) getStateHelper().eval(PropertyKeys.hrefTarget);
	}

	/**
	 * <p>
	 * Set the value of the <code>hrefTarget</code> property.
	 * </p>
	 */
	public void setHrefTarget ( String   hrefTarget ) {
		getStateHelper().put(PropertyKeys.hrefTarget, hrefTarget);
		handleAttribute("hrefTarget", hrefTarget);
	}
    	/*
	 *
        
        
          uiProvider
         : Function
        A UI 
        class to use for this node (defaults to
        Ext.tree.TreeNodeUI)
	 */
	@ClientConfig(JsonMode.Function)

	public Object getUiProvider () {
		return (Object) getStateHelper().eval(PropertyKeys.uiProvider);
	}

	/**
	 * <p>
	 * Set the value of the <code>uiProvider</code> property.
	 * </p>
	 */
	public void setUiProvider ( Object   uiProvider ) {
		getStateHelper().put(PropertyKeys.uiProvider, uiProvider);
		handleAttribute("uiProvider", uiProvider);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforechildrenrendered"
					, "beforeclick"
					, "beforecollapse"
					, "beforedblclick"
					, "beforeexpand"
					, "checkchange"
					, "click"
					, "collapse"
					, "contextmenu"
					, "dblclick"
					, "disabledchange"
					, "expand"
					, "textchange"
				));
				return superEvent;
	}
}