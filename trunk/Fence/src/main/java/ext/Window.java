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
    A specialized panel intended for use as an application
    window. Windows are floated, 
    resizable, and 
    draggable by
    default. Windows can be 
    maximized to
    fill the viewport, restored to their prior size, and can be 
    minimized.
    Windows can also be linked to a 
    Ext.WindowGroup or managed by the
    
    Ext.WindowMgr to provide grouping,
    activation, to front, to back and other application-specific
    behavior.
    By default, Windows will be rendered to document.body. To 
    constrain a
    Window to another element specify 
    renderTo.
    
    Note: By default, the 
    
      close
     header tool 
    destroys the Window resulting in destruction of any
    child Components. This makes the Window object, and all its
    descendants 
    unusable. To enable re-use of a Window, use 
    
      
        closeAction: 
        'hide'
      
    .
  
 */
@XType("window")
@InstanceOf("Ext.Window")

@FacesComponent(value = "Ext.Window")
public class Window extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.Window";

	/**
	 * <p>
	 * Create a new {@link Ext.Window} instance with default property values.
	 * </p>
	 */
	public Window() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			animateTarget
			,closable
			,manager
			,draggable
			,constrainHeader
			,maximizable
			,hidden
			,initHidden
			,modal
			,constrain
			,plain
			,baseCls
			,minWidth
			,closeAction
			,resizable
			,collapsed
			,y
			,onEsc
			,resizeHandles
			,expandOnShow
			,defaultButton
			,maximized
			,minHeight
			,x
			,minimizable
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
        
        
          animateTarget
         : String/Element
        Id or element from which the window
        should animate while opening (defaults to null with no
        animation).
	 */
	
	public String getAnimateTarget () {
		return (String) getStateHelper().eval(PropertyKeys.animateTarget);
	}

	/**
	 * <p>
	 * Set the value of the <code>animateTarget</code> property.
	 * </p>
	 */
	public void setAnimateTarget ( String   animateTarget ) {
		getStateHelper().put(PropertyKeys.animateTarget, animateTarget);
		handleAttribute("animateTarget", animateTarget);
	}
    	/*
	 *
            True to display the 'close' tool button and allow
            the user to close the window, false to hide the button
            and disallow closing the window (defaults to true).
            By default, when close is requested by either
            clicking the close button in the header or pressing ESC
            when the Window has focus, the 
            close
            method will be called. This will 
            
              destroy
             the Window and its content meaning that it may not
            be reused.
            To make closing a Window 
            hide the Window so that it may be reused, set 
            closeAction to 'hide'.
          
	 */
	
	public Boolean getClosable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.closable);
	}

	/**
	 * <p>
	 * Set the value of the <code>closable</code> property.
	 * </p>
	 */
	public void setClosable ( Boolean   closable ) {
		getStateHelper().put(PropertyKeys.closable, closable);
		handleAttribute("closable", closable);
	}
    	/*
	 *
        
        
          manager
         : Ext.WindowGroup
        A reference to the WindowGroup that
        should manage this window (defaults to 
        Ext.WindowMgr).
	 */
	@ClientConfig(JsonMode.Object)

	public Object getManager () {
		return (Object) getStateHelper().eval(PropertyKeys.manager);
	}

	/**
	 * <p>
	 * Set the value of the <code>manager</code> property.
	 * </p>
	 */
	public void setManager ( Object   manager ) {
		getStateHelper().put(PropertyKeys.manager, manager);
		handleAttribute("manager", manager);
	}
    	/*
	 *True to allow the window to be dragged
          by the header bar, false to disable dragging (defaults to
          true). Note that by default the window will be centered
          in the viewport, so if dragging is disabled the window
          may need to be positioned programmatically after render
          (e.g., myWindow.setPosition(100, 100);).
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
	 *True to constrain the window header
          within its containing element (allowing the window body
          to fall outside of its containing element) or false to
          allow the header to fall outside its containing element
          (defaults to false). Optionally the entire window can be
          constrained using 
          constrain.
	 */
	
	public Boolean getConstrainHeader () {
		return (Boolean) getStateHelper().eval(PropertyKeys.constrainHeader);
	}

	/**
	 * <p>
	 * Set the value of the <code>constrainHeader</code> property.
	 * </p>
	 */
	public void setConstrainHeader ( Boolean   constrainHeader ) {
		getStateHelper().put(PropertyKeys.constrainHeader, constrainHeader);
		handleAttribute("constrainHeader", constrainHeader);
	}
    	/*
	 *True to display the 'maximize' tool
          button and allow the user to maximize the window, false
          to hide the button and disallow maximizing the window
          (defaults to false). Note that when a window is
          maximized, the tool button will automatically change to a
          'restore' button with the appropriate behavior already
          built-in that will restore the window to its previous
          size.
	 */
	
	public Boolean getMaximizable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.maximizable);
	}

	/**
	 * <p>
	 * Set the value of the <code>maximizable</code> property.
	 * </p>
	 */
	public void setMaximizable ( Boolean   maximizable ) {
		getStateHelper().put(PropertyKeys.maximizable, maximizable);
		handleAttribute("maximizable", maximizable);
	}
    	/*
	 *
        
        
          hidden
         : Boolean
        Render this component hidden (default is
        
        true). If 
        true, the 
        hide method will
        be called internally.
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
	 *
        
        
          initHidden
         : Boolean
        True to hide the window until show() is
        explicitly called (defaults to true).
	 */
	
	public Boolean getInitHidden () {
		return (Boolean) getStateHelper().eval(PropertyKeys.initHidden);
	}

	/**
	 * <p>
	 * Set the value of the <code>initHidden</code> property.
	 * </p>
	 */
	public void setInitHidden ( Boolean   initHidden ) {
		getStateHelper().put(PropertyKeys.initHidden, initHidden);
		handleAttribute("initHidden", initHidden);
	}
    	/*
	 *True to make the window modal and mask
          everything behind it when displayed, false to display it
          without restricting access to other UI elements (defaults
          to false).
	 */
	
	public Boolean getModal () {
		return (Boolean) getStateHelper().eval(PropertyKeys.modal);
	}

	/**
	 * <p>
	 * Set the value of the <code>modal</code> property.
	 * </p>
	 */
	public void setModal ( Boolean   modal ) {
		getStateHelper().put(PropertyKeys.modal, modal);
		handleAttribute("modal", modal);
	}
    	/*
	 *True to constrain the window within its
          containing element, false to allow it to fall outside of
          its containing element. By default the window will be
          rendered to document.body. To render and constrain the
          window within another element specify 
          renderTo.
          (defaults to false). Optionally the header only can be
          constrained using 
          constrainHeader.
	 */
	
	public Boolean getConstrain () {
		return (Boolean) getStateHelper().eval(PropertyKeys.constrain);
	}

	/**
	 * <p>
	 * Set the value of the <code>constrain</code> property.
	 * </p>
	 */
	public void setConstrain ( Boolean   constrain ) {
		getStateHelper().put(PropertyKeys.constrain, constrain);
		handleAttribute("constrain", constrain);
	}
    	/*
	 *True to render the window body with a
          transparent background so that it will blend into the
          framing elements, false to add a lighter background color
          to visually highlight the body element and separate it
          more distinctly from the surrounding frame (defaults to
          false).
	 */
	
	public Boolean getPlain () {
		return (Boolean) getStateHelper().eval(PropertyKeys.plain);
	}

	/**
	 * <p>
	 * Set the value of the <code>plain</code> property.
	 * </p>
	 */
	public void setPlain ( Boolean   plain ) {
		getStateHelper().put(PropertyKeys.plain, plain);
		handleAttribute("plain", plain);
	}
    	/*
	 *
        
        
          baseCls
         : String
        The base CSS class to apply to this
        panel's element (defaults to 'x-window').
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
    	/*
	 *
        
        
          minWidth
         : Number
        The minimum width in pixels allowed for
        this window (defaults to 200). Only applies when resizable
        = true.
	 */
	
	public Integer getMinWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth ( Integer   minWidth ) {
		getStateHelper().put(PropertyKeys.minWidth, minWidth);
		handleAttribute("minWidth", minWidth);
	}
    	/*
	 *
            The action to take when the close header tool is
            clicked:
            
              
                
                
                  
                    '
                    close'
                  
                 : 
                Default
                
                remove
                the window from the DOM and 
                destroy it and all
                descendant Components. The window will 
                not be available to be redisplayed via the 
                show
                method.
                
                
                  
                    '
                    hide'
                  
                 : 
                
                hide the
                window by setting visibility to hidden and applying
                negative offsets. The window will be available to
                be redisplayed via the 
                show
                method.
              
            
            
            Note: This setting does not affect the 
            close
            method which will always 
            destroy the window. To
            programatically 
            hide a window, call 
            hide.
          
	 */
	
	public String getCloseAction () {
		return (String) getStateHelper().eval(PropertyKeys.closeAction);
	}

	/**
	 * <p>
	 * Set the value of the <code>closeAction</code> property.
	 * </p>
	 */
	public void setCloseAction ( String   closeAction ) {
		getStateHelper().put(PropertyKeys.closeAction, closeAction);
		handleAttribute("closeAction", closeAction);
	}
    	/*
	 *
        
        
          resizable
         : Boolean
        True to allow user resizing at each edge
        and corner of the window, false to disable resizing
        (defaults to true).
	 */
	
	public Boolean getResizable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.resizable);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizable</code> property.
	 * </p>
	 */
	public void setResizable ( Boolean   resizable ) {
		getStateHelper().put(PropertyKeys.resizable, resizable);
		handleAttribute("resizable", resizable);
	}
    	/*
	 *True to render the window collapsed,
          false to render it expanded (defaults to false). Note
          that if 
          expandOnShow is true (the
          default) it will override the 
          collapsed config and the window will always be
          expanded when shown.
	 */
	
	public Boolean getCollapsed () {
		return (Boolean) getStateHelper().eval(PropertyKeys.collapsed);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsed</code> property.
	 * </p>
	 */
	public void setCollapsed ( Boolean   collapsed ) {
		getStateHelper().put(PropertyKeys.collapsed, collapsed);
		handleAttribute("collapsed", collapsed);
	}
    	/*
	 *The Y position of the top edge of the
          window on initial showing. Defaults to centering the
          Window within the height of the Window's container
          Ext.Element Element) (The Element that the Window is
          rendered to).
	 */
	
	public Integer getY () {
		return (Integer) getStateHelper().eval(PropertyKeys.y);
	}

	/**
	 * <p>
	 * Set the value of the <code>y</code> property.
	 * </p>
	 */
	public void setY ( Integer   y ) {
		getStateHelper().put(PropertyKeys.y, y);
		handleAttribute("y", y);
	}
    	/*
	 *Allows override of the built-in
          processing for the escape key. Default action is to close
          the Window (performing whatever action is specified in 
          closeAction. To prevent the
          Window closing when the escape key is pressed, specify
          this as Ext.emptyFn (See 
          Ext.emptyFn).
	 */
	@ClientConfig(JsonMode.Function)

	public Object getOnEsc () {
		return (Object) getStateHelper().eval(PropertyKeys.onEsc);
	}

	/**
	 * <p>
	 * Set the value of the <code>onEsc</code> property.
	 * </p>
	 */
	public void setOnEsc ( Object   onEsc ) {
		getStateHelper().put(PropertyKeys.onEsc, onEsc);
		handleAttribute("onEsc", onEsc);
	}
    	/*
	 *
        
        
          resizeHandles
         : String
        A valid 
        Ext.Resizable handles config
        string (defaults to 'all'). Only applies when resizable =
        true.
	 */
	
	public String getResizeHandles () {
		return (String) getStateHelper().eval(PropertyKeys.resizeHandles);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizeHandles</code> property.
	 * </p>
	 */
	public void setResizeHandles ( String   resizeHandles ) {
		getStateHelper().put(PropertyKeys.resizeHandles, resizeHandles);
		handleAttribute("resizeHandles", resizeHandles);
	}
    	/*
	 *True to always expand the window when
          it is displayed, false to keep it in its current state
          (which may be 
          collapsed) when displayed
          (defaults to true).
	 */
	
	public Boolean getExpandOnShow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.expandOnShow);
	}

	/**
	 * <p>
	 * Set the value of the <code>expandOnShow</code> property.
	 * </p>
	 */
	public void setExpandOnShow ( Boolean   expandOnShow ) {
		getStateHelper().put(PropertyKeys.expandOnShow, expandOnShow);
		handleAttribute("expandOnShow", expandOnShow);
	}
    	/*
	 *
            Specifies a Component to receive focus when this
            Window is focussed.
            This may be one of:
            
              
                The index of a footer Button.
                The id of a Component.
                A Component.
              
            
          
	 */
	
	public String getDefaultButton () {
		return (String) getStateHelper().eval(PropertyKeys.defaultButton);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultButton</code> property.
	 * </p>
	 */
	public void setDefaultButton ( String   defaultButton ) {
		getStateHelper().put(PropertyKeys.defaultButton, defaultButton);
		handleAttribute("defaultButton", defaultButton);
	}
    	/*
	 *
        
        
          maximized
         : Boolean
        True to initially display the window in
        a maximized state. (Defaults to false).
	 */
	
	public Boolean getMaximized () {
		return (Boolean) getStateHelper().eval(PropertyKeys.maximized);
	}

	/**
	 * <p>
	 * Set the value of the <code>maximized</code> property.
	 * </p>
	 */
	public void setMaximized ( Boolean   maximized ) {
		getStateHelper().put(PropertyKeys.maximized, maximized);
		handleAttribute("maximized", maximized);
	}
    	/*
	 *
        
        
          minHeight
         : Number
        The minimum height in pixels allowed for
        this window (defaults to 100). Only applies when resizable
        = true.
	 */
	
	public Integer getMinHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.minHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>minHeight</code> property.
	 * </p>
	 */
	public void setMinHeight ( Integer   minHeight ) {
		getStateHelper().put(PropertyKeys.minHeight, minHeight);
		handleAttribute("minHeight", minHeight);
	}
    	/*
	 *The X position of the left edge of the
          window on initial showing. Defaults to centering the
          Window within the width of the Window's container
          Ext.Element Element) (The Element that the Window is
          rendered to).
	 */
	
	public Integer getX () {
		return (Integer) getStateHelper().eval(PropertyKeys.x);
	}

	/**
	 * <p>
	 * Set the value of the <code>x</code> property.
	 * </p>
	 */
	public void setX ( Integer   x ) {
		getStateHelper().put(PropertyKeys.x, x);
		handleAttribute("x", x);
	}
    	/*
	 *True to display the 'minimize' tool
          button and allow the user to minimize the window, false
          to hide the button and disallow minimizing the window
          (defaults to false). Note that this button provides no
          implementation -- the behavior of minimizing a window is
          implementation-specific, so the minimize event must be
          handled and a custom minimize behavior implemented for
          this option to be useful.
	 */
	
	public Boolean getMinimizable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.minimizable);
	}

	/**
	 * <p>
	 * Set the value of the <code>minimizable</code> property.
	 * </p>
	 */
	public void setMinimizable ( Boolean   minimizable ) {
		getStateHelper().put(PropertyKeys.minimizable, minimizable);
		handleAttribute("minimizable", minimizable);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "activate"
					, "deactivate"
					, "maximize"
					, "minimize"
					, "resize"
					, "restore"
				));
				return superEvent;
	}
}