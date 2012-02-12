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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>A specialized panel intended for use as an application
    window. Windows are floated, 
    <a ext:cls="Ext.Window" ext:member="resizable" href="output/Ext.Window.html#Ext.Window-resizable">resizable</a>, and 
    <a ext:cls="Ext.Window" ext:member="draggable" href="output/Ext.Window.html#Ext.Window-draggable">draggable</a> by
    default. Windows can be 
    <a ext:cls="Ext.Window" ext:member="maximizable" href="output/Ext.Window.html#Ext.Window-maximizable">maximized</a> to
    fill the viewport, restored to their prior size, and can be 
    <a ext:cls="Ext.Window" ext:member="minimize" href="output/Ext.Window.html#Ext.Window-minimize">minimize</a>d.</p>
    <p>Windows can also be linked to a 
    <a ext:cls="Ext.WindowGroup" href="output/Ext.WindowGroup.html">Ext.WindowGroup</a> or managed by the
    
    <a ext:cls="Ext.WindowMgr" href="output/Ext.WindowMgr.html">Ext.WindowMgr</a> to provide grouping,
    activation, to front, to back and other application-specific
    behavior.</p>
    <p>By default, Windows will be rendered to document.body. To 
    <a ext:cls="Ext.Window" ext:member="constrain" href="output/Ext.Window.html#Ext.Window-constrain">constrain</a> a
    Window to another element specify 
    <a ext:cls="Ext.Component" ext:member="renderTo" href="output/Ext.Component.html#Ext.Component-renderTo">renderTo</a>.</p>
    <p>
    <b>Note:</b> By default, the 
    <code>
      <a ext:cls="Ext.Window" ext:member="closable" href="output/Ext.Window.html#Ext.Window-closable">close</a>
    </code> header tool 
    <i>destroys</i> the Window resulting in destruction of any
    child Components. This makes the Window object, and all its
    descendants 
    <b>unusable</b>. To enable re-use of a Window, use 
    <b>
      <code>
        <a ext:cls="Ext.Window" ext:member="closeAction" href="output/Ext.Window.html#Ext.Window-closeAction">closeAction: 
        <em>'hide'</em>
</a>
      </code>
    </b>.</p>
  </div>

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
			constrain
			,manager
			,minWidth
			,baseCls
			,closeAction
			,animateTarget
			,closable
			,initHidden
			,resizable
			,plain
			,modal
			,constrainHeader
			,showAnimDuration
			,hideAnimDuration
			,collapsed
			,maximized
			,onEsc
			,minHeight
			,expandOnShow
			,hidden
			,minimizable
			,resizeHandles
			,defaultButton
			,y
			,draggable
			,x
			,maximizable
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to constrain the window within its
          containing element, false to allow it to fall outside of
          its containing element. By default the window will be
          rendered to document.body. To render and constrain the
          window within another element specify 
          <a ext:cls="Ext.Window" ext:member="renderTo" href="output/Ext.Window.html#Ext.Window-renderTo">renderTo</a>.
          (defaults to false). Optionally the header only can be
          constrained using 
          <a ext:cls="Ext.Window" ext:member="constrainHeader" href="output/Ext.Window.html#Ext.Window-constrainHeader">constrainHeader</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The action to take when the close header tool is
            clicked:</p>
            <div class="mdetail-params">
              <ul>
                <li>
                <b>
                  <code>
                    <em>'
                    <a ext:cls="Ext.Window" ext:member="close" href="output/Ext.Window.html#Ext.Window-close">close</a>'</em>
                  </code>
                </b> : 
                <b>Default</b>
                <div class="sub-desc">
                <a ext:cls="Ext.Window" ext:member="close" href="output/Ext.Window.html#Ext.Window-close">remove</a>
                the window from the DOM and 
                <a ext:cls="Ext.Component" ext:member="destroy" href="output/Ext.Component.html#Ext.Component-destroy">destroy</a> it and all
                descendant Components. The window will 
                <b>not</b> be available to be redisplayed via the 
                <a ext:cls="Ext.Window" ext:member="show" href="output/Ext.Window.html#Ext.Window-show">show</a>
                method.</div>
</li>
                <li>
                <b>
                  <code>
                    <em>'
                    <a ext:cls="Ext.Window" ext:member="hide" href="output/Ext.Window.html#Ext.Window-hide">hide</a>'</em>
                  </code>
                </b> : 
                <div class="sub-desc">
                <a ext:cls="Ext.Window" ext:member="hide" href="output/Ext.Window.html#Ext.Window-hide">hide</a> the
                window by setting visibility to hidden and applying
                negative offsets. The window will be available to
                be redisplayed via the 
                <a ext:cls="Ext.Window" ext:member="show" href="output/Ext.Window.html#Ext.Window-show">show</a>
                method.</div>
</li>
              </ul>
            </div>
            <p>
            <b>Note:</b> This setting does not affect the 
            <a ext:cls="Ext.Window" ext:member="close" href="output/Ext.Window.html#Ext.Window-close">close</a>
            method which will always 
            <a ext:cls="Ext.Component" ext:member="destroy" href="output/Ext.Component.html#Ext.Component-destroy">destroy</a> the window. To
            programatically 
            <i>hide</i> a window, call 
            <a ext:cls="Ext.Window" ext:member="hide" href="output/Ext.Window.html#Ext.Window-hide">hide</a>.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>True to display the 'close' tool button and allow
            the user to close the window, false to hide the button
            and disallow closing the window (defaults to true).</p>
            <p>By default, when close is requested by either
            clicking the close button in the header or pressing ESC
            when the Window has focus, the 
            <a ext:cls="Ext.Window" ext:member="close" href="output/Ext.Window.html#Ext.Window-close">close</a>
            method will be called. This will 
            <i>
              <a ext:cls="Ext.Component" ext:member="destroy" href="output/Ext.Component.html#Ext.Component-destroy">destroy</a>
            </i> the Window and its content meaning that it may not
            be reused.</p>
            <p>To make closing a Window 
            <i>hide</i> the Window so that it may be reused, set 
            <a ext:cls="Ext.Window" ext:member="closeAction" href="output/Ext.Window.html#Ext.Window-closeAction">closeAction</a> to 'hide'.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to render the window body with a
          transparent background so that it will blend into the
          framing elements, false to add a lighter background color
          to visually highlight the body element and separate it
          more distinctly from the surrounding frame (defaults to
          false).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to make the window modal and mask
          everything behind it when displayed, false to display it
          without restricting access to other UI elements (defaults
          to false).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to constrain the window header
          within its containing element (allowing the window body
          to fall outside of its containing element) or false to
          allow the header to fall outside its containing element
          (defaults to false). Optionally the entire window can be
          constrained using 
          <a ext:cls="Ext.Window" ext:member="constrain" href="output/Ext.Window.html#Ext.Window-constrain">constrain</a>.</div>

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
	 *
        
        
          showAnimDuration
         : Number
        The number of seconds that the window
        show animation takes if enabled. Defaults to
        0.25
	 */
	
	public Integer getShowAnimDuration () {
		return (Integer) getStateHelper().eval(PropertyKeys.showAnimDuration);
	}

	/**
	 * <p>
	 * Set the value of the <code>showAnimDuration</code> property.
	 * </p>
	 */
	public void setShowAnimDuration ( Integer   showAnimDuration ) {
		getStateHelper().put(PropertyKeys.showAnimDuration, showAnimDuration);
		handleAttribute("showAnimDuration", showAnimDuration);
	}
    	/*
	 *
        
        
          hideAnimDuration
         : Number
        The number of seconds that the window
        hide animation takes if enabled. Defaults to
        0.25
	 */
	
	public Integer getHideAnimDuration () {
		return (Integer) getStateHelper().eval(PropertyKeys.hideAnimDuration);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideAnimDuration</code> property.
	 * </p>
	 */
	public void setHideAnimDuration ( Integer   hideAnimDuration ) {
		getStateHelper().put(PropertyKeys.hideAnimDuration, hideAnimDuration);
		handleAttribute("hideAnimDuration", hideAnimDuration);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to render the window collapsed,
          false to render it expanded (defaults to false). Note
          that if 
          <a ext:cls="Ext.Window" ext:member="expandOnShow" href="output/Ext.Window.html#Ext.Window-expandOnShow">expandOnShow</a> is true (the
          default) it will override the 
          <tt>collapsed</tt> config and the window will always be
          expanded when shown.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Allows override of the built-in
          processing for the escape key. Default action is to close
          the Window (performing whatever action is specified in 
          <a ext:cls="Ext.Window" ext:member="closeAction" href="output/Ext.Window.html#Ext.Window-closeAction">closeAction</a>. To prevent the
          Window closing when the escape key is pressed, specify
          this as Ext.emptyFn (See 
          <a ext:cls="Ext" ext:member="emptyFn" href="output/Ext.html#Ext-emptyFn">Ext.emptyFn</a>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to always expand the window when
          it is displayed, false to keep it in its current state
          (which may be 
          <a ext:cls="Ext.Window" ext:member="collapsed" href="output/Ext.Window.html#Ext.Window-collapsed">collapsed</a>) when displayed
          (defaults to true).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to display the 'minimize' tool
          button and allow the user to minimize the window, false
          to hide the button and disallow minimizing the window
          (defaults to false). Note that this button provides no
          implementation -- the behavior of minimizing a window is
          implementation-specific, so the minimize event must be
          handled and a custom minimize behavior implemented for
          this option to be useful.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Specifies a Component to receive focus when this
            Window is focussed.</p>
            <p>This may be one of:</p>
            <div class="mdetail-params">
              <ul>
                <li>The index of a footer Button.</li>
                <li>The id of a Component.</li>
                <li>A Component.</li>
              </ul>
            </div>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The Y position of the top edge of the
          window on initial showing. Defaults to centering the
          Window within the height of the Window's container
          Ext.Element Element) (The Element that the Window is
          rendered to).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to allow the window to be dragged
          by the header bar, false to disable dragging (defaults to
          true). Note that by default the window will be centered
          in the viewport, so if dragging is disabled the window
          may need to be positioned programmatically after render
          (e.g., myWindow.setPosition(100, 100);).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The X position of the left edge of the
          window on initial showing. Defaults to centering the
          Window within the width of the Window's container
          Ext.Element Element) (The Element that the Window is
          rendered to).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to display the 'maximize' tool
          button and allow the user to maximize the window, false
          to hide the button and disallow maximizing the window
          (defaults to false). Note that when a window is
          maximized, the tool button will automatically change to a
          'restore' button with the appropriate behavior already
          built-in that will restore the window to its previous
          size.</div>

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