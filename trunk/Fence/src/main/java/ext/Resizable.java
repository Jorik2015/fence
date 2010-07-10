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
    Applies drag handles to an element to make it resizable. The
    drag handles are inserted into the element and positioned
    absolute. Some elements, such as a textarea or image, don't
    support this. To overcome that, you can wrap the textarea in a
    div and set 'resizeChild' to true (or to the id of the
    element), 
    or set wrap:true in your config and the element will be
    wrapped for you automatically.
    Here is the list of valid resize handles:

Value   Description
------  -------------------
 'n'     north
 's'     south
 'e'     east
 'w'     west
 'nw'    northwest
 'sw'    southwest
 'se'    southeast
 'ne'    northeast
 'all'   all
    
    Here's an example showing the creation of a typical
    Resizable:


var resizer = 
new Ext.Resizable(
'element-id', {
    handles: 
'all',
    minWidth: 200,
    minHeight: 100,
    maxWidth: 500,
    maxHeight: 400,
    pinned: true
});
resizer.on(
'resize', myHandler);
    
    To hide a particular handle, set its display to none in CSS,
    or through script:
    resizer.east.setDisplayed(false);
  
 */

@InstanceOf("Ext.Resizable")

@FacesComponent(value = "Ext.Resizable")
public class Resizable extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.Resizable";

	/**
	 * <p>
	 * Create a new {@link Ext.Resizable} instance with default property values.
	 * </p>
	 */
	public Resizable() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			dynamic
			,maxHeight
			,animate
			,width
			,multiDirectional
			,pinned
			,transparent
			,resizeRegion
			,easing
			,wrap
			,draggable
			,widthIncrement
			,heightIncrement
			,height
			,minY
			,disableTrackOver
			,constrainTo
			,resizeChild
			,handleCls
			,minX
			,maxWidth
			,adjustments
			,minWidth
			,enabled
			,handles
			,duration
			,minHeight
			,preserveRatio
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
        
        
          dynamic
         : Boolean
        True to resize the element while
        dragging instead of using a proxy (defaults to
        false)
	 */
	
	public Boolean getDynamic () {
		return (Boolean) getStateHelper().eval(PropertyKeys.dynamic);
	}

	/**
	 * <p>
	 * Set the value of the <code>dynamic</code> property.
	 * </p>
	 */
	public void setDynamic ( Boolean   dynamic ) {
		getStateHelper().put(PropertyKeys.dynamic, dynamic);
		handleAttribute("dynamic", dynamic);
	}
    	/*
	 *
        
        
          maxHeight
         : Number
        The maximum height for the element
        (defaults to 10000)
	 */
	
	public Integer getMaxHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxHeight</code> property.
	 * </p>
	 */
	public void setMaxHeight ( Integer   maxHeight ) {
		getStateHelper().put(PropertyKeys.maxHeight, maxHeight);
		handleAttribute("maxHeight", maxHeight);
	}
    	/*
	 *
        
        
          animate
         : Boolean
        True to animate the resize (not
        compatible with dynamic sizing, defaults to
        false)
	 */
	
	public Boolean getAnimate () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animate);
	}

	/**
	 * <p>
	 * Set the value of the <code>animate</code> property.
	 * </p>
	 */
	public void setAnimate ( Boolean   animate ) {
		getStateHelper().put(PropertyKeys.animate, animate);
		handleAttribute("animate", animate);
	}
    	/*
	 *
        
        
          width
         : Number
        The width of the element in pixels
        (defaults to null)
	 */
	
	public Integer getWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.width);
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth ( Integer   width ) {
		getStateHelper().put(PropertyKeys.width, width);
		handleAttribute("width", width);
	}
    	/*
	 *
        
        
          multiDirectional
         : Boolean
        
        Deprecated. Deprecated style of adding
        multi-direction resize handles.
	 */
	
	public Boolean getMultiDirectional () {
		return (Boolean) getStateHelper().eval(PropertyKeys.multiDirectional);
	}

	/**
	 * <p>
	 * Set the value of the <code>multiDirectional</code> property.
	 * </p>
	 */
	public void setMultiDirectional ( Boolean   multiDirectional ) {
		getStateHelper().put(PropertyKeys.multiDirectional, multiDirectional);
		handleAttribute("multiDirectional", multiDirectional);
	}
    	/*
	 *True to ensure that the resize handles
          are always visible, false to display them only when the
          user mouses over the resizable borders. This is only
          applied at config time. (defaults to false)
	 */
	
	public Boolean getPinned () {
		return (Boolean) getStateHelper().eval(PropertyKeys.pinned);
	}

	/**
	 * <p>
	 * Set the value of the <code>pinned</code> property.
	 * </p>
	 */
	public void setPinned ( Boolean   pinned ) {
		getStateHelper().put(PropertyKeys.pinned, pinned);
		handleAttribute("pinned", pinned);
	}
    	/*
	 *
        
        
          transparent
         : Boolean
        True for transparent handles. This is
        only applied at config time. (defaults to false)
	 */
	
	public Boolean getTransparent () {
		return (Boolean) getStateHelper().eval(PropertyKeys.transparent);
	}

	/**
	 * <p>
	 * Set the value of the <code>transparent</code> property.
	 * </p>
	 */
	public void setTransparent ( Boolean   transparent ) {
		getStateHelper().put(PropertyKeys.transparent, transparent);
		handleAttribute("transparent", transparent);
	}
    	/*
	 *
        
        
          resizeRegion
         : Ext.lib.Region
        Constrain the resize to a particular
        region
	 */
	@ClientConfig(JsonMode.Object)

	public Object getResizeRegion () {
		return (Object) getStateHelper().eval(PropertyKeys.resizeRegion);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizeRegion</code> property.
	 * </p>
	 */
	public void setResizeRegion ( Object   resizeRegion ) {
		getStateHelper().put(PropertyKeys.resizeRegion, resizeRegion);
		handleAttribute("resizeRegion", resizeRegion);
	}
    	/*
	 *
        
        
          easing
         : String
        Animation easing if animate = true
        (defaults to 
        'easingOutStrong')
	 */
	
	public String getEasing () {
		return (String) getStateHelper().eval(PropertyKeys.easing);
	}

	/**
	 * <p>
	 * Set the value of the <code>easing</code> property.
	 * </p>
	 */
	public void setEasing ( String   easing ) {
		getStateHelper().put(PropertyKeys.easing, easing);
		handleAttribute("easing", easing);
	}
    	/*
	 *True to wrap an element with a div if
          needed (required for textareas and images, defaults to
          false) in favor of the handles config option (defaults to
          false)
	 */
	
	public Boolean getWrap () {
		return (Boolean) getStateHelper().eval(PropertyKeys.wrap);
	}

	/**
	 * <p>
	 * Set the value of the <code>wrap</code> property.
	 * </p>
	 */
	public void setWrap ( Boolean   wrap ) {
		getStateHelper().put(PropertyKeys.wrap, wrap);
		handleAttribute("wrap", wrap);
	}
    	/*
	 *
        
        
          draggable
         : Boolean
        Convenience to initialize drag drop
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
        
        
          widthIncrement
         : Number
        The increment to snap the width resize
        in pixels (only applies if 
        
        dynamic==true). Defaults
        to 
        0.
	 */
	
	public Integer getWidthIncrement () {
		return (Integer) getStateHelper().eval(PropertyKeys.widthIncrement);
	}

	/**
	 * <p>
	 * Set the value of the <code>widthIncrement</code> property.
	 * </p>
	 */
	public void setWidthIncrement ( Integer   widthIncrement ) {
		getStateHelper().put(PropertyKeys.widthIncrement, widthIncrement);
		handleAttribute("widthIncrement", widthIncrement);
	}
    	/*
	 *
        
        
          heightIncrement
         : Number
        The increment to snap the height resize
        in pixels (only applies if 
        
        dynamic==true). Defaults
        to 
        0.
	 */
	
	public Integer getHeightIncrement () {
		return (Integer) getStateHelper().eval(PropertyKeys.heightIncrement);
	}

	/**
	 * <p>
	 * Set the value of the <code>heightIncrement</code> property.
	 * </p>
	 */
	public void setHeightIncrement ( Integer   heightIncrement ) {
		getStateHelper().put(PropertyKeys.heightIncrement, heightIncrement);
		handleAttribute("heightIncrement", heightIncrement);
	}
    	/*
	 *
        
        
          height
         : Number
        The height of the element in pixels
        (defaults to null)
	 */
	
	public Integer getHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.height);
	}

	/**
	 * <p>
	 * Set the value of the <code>height</code> property.
	 * </p>
	 */
	public void setHeight ( Integer   height ) {
		getStateHelper().put(PropertyKeys.height, height);
		handleAttribute("height", height);
	}
    	/*
	 *
        
        
          minY
         : Number
        The minimum x for the element (defaults
        to 0)
	 */
	
	public Integer getMinY () {
		return (Integer) getStateHelper().eval(PropertyKeys.minY);
	}

	/**
	 * <p>
	 * Set the value of the <code>minY</code> property.
	 * </p>
	 */
	public void setMinY ( Integer   minY ) {
		getStateHelper().put(PropertyKeys.minY, minY);
		handleAttribute("minY", minY);
	}
    	/*
	 *
        
        
          disableTrackOver
         : Boolean
        True to disable mouse tracking. This is
        only applied at config time. (defaults to false)
	 */
	
	public Boolean getDisableTrackOver () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disableTrackOver);
	}

	/**
	 * <p>
	 * Set the value of the <code>disableTrackOver</code> property.
	 * </p>
	 */
	public void setDisableTrackOver ( Boolean   disableTrackOver ) {
		getStateHelper().put(PropertyKeys.disableTrackOver, disableTrackOver);
		handleAttribute("disableTrackOver", disableTrackOver);
	}
    	/*
	 *
        
        
          constrainTo
         : Mixed
        Constrain the resize to a particular
        element
	 */
	@ClientConfig(JsonMode.Object)

	public Object getConstrainTo () {
		return (Object) getStateHelper().eval(PropertyKeys.constrainTo);
	}

	/**
	 * <p>
	 * Set the value of the <code>constrainTo</code> property.
	 * </p>
	 */
	public void setConstrainTo ( Object   constrainTo ) {
		getStateHelper().put(PropertyKeys.constrainTo, constrainTo);
		handleAttribute("constrainTo", constrainTo);
	}
    	/*
	 *
        
        
          resizeChild
         : Boolean/String/Element
        True to resize the first child, or
        id/element to resize (defaults to false)
	 */
	
	public Boolean getResizeChild () {
		return (Boolean) getStateHelper().eval(PropertyKeys.resizeChild);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizeChild</code> property.
	 * </p>
	 */
	public void setResizeChild ( Boolean   resizeChild ) {
		getStateHelper().put(PropertyKeys.resizeChild, resizeChild);
		handleAttribute("resizeChild", resizeChild);
	}
    	/*
	 *
        
        
          handleCls
         : String
        A css class to add to each handle.
        Defaults to 
        ''.
	 */
	
	public String getHandleCls () {
		return (String) getStateHelper().eval(PropertyKeys.handleCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>handleCls</code> property.
	 * </p>
	 */
	public void setHandleCls ( String   handleCls ) {
		getStateHelper().put(PropertyKeys.handleCls, handleCls);
		handleAttribute("handleCls", handleCls);
	}
    	/*
	 *
        
        
          minX
         : Number
        The minimum x for the element (defaults
        to 0)
	 */
	
	public Integer getMinX () {
		return (Integer) getStateHelper().eval(PropertyKeys.minX);
	}

	/**
	 * <p>
	 * Set the value of the <code>minX</code> property.
	 * </p>
	 */
	public void setMinX ( Integer   minX ) {
		getStateHelper().put(PropertyKeys.minX, minX);
		handleAttribute("minX", minX);
	}
    	/*
	 *
        
        
          maxWidth
         : Number
        The maximum width for the element
        (defaults to 10000)
	 */
	
	public Integer getMaxWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxWidth</code> property.
	 * </p>
	 */
	public void setMaxWidth ( Integer   maxWidth ) {
		getStateHelper().put(PropertyKeys.maxWidth, maxWidth);
		handleAttribute("maxWidth", maxWidth);
	}
    	/*
	 *String 'auto' or an array [width,
          height] with values to be 
          added to the resize operation's new size (defaults
          to 
          [0, 0])
	 */
	@ClientConfig(JsonMode.Array)

	public Object getAdjustments () {
		return (Object) getStateHelper().eval(PropertyKeys.adjustments);
	}

	/**
	 * <p>
	 * Set the value of the <code>adjustments</code> property.
	 * </p>
	 */
	public void setAdjustments ( Object   adjustments ) {
		getStateHelper().put(PropertyKeys.adjustments, adjustments);
		handleAttribute("adjustments", adjustments);
	}
    	/*
	 *
        
        
          minWidth
         : Number
        The minimum width for the element
        (defaults to 5)
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
        
        
          enabled
         : Boolean
        False to disable resizing (defaults to
        true)
	 */
	
	public Boolean getEnabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>enabled</code> property.
	 * </p>
	 */
	public void setEnabled ( Boolean   enabled ) {
		getStateHelper().put(PropertyKeys.enabled, enabled);
		handleAttribute("enabled", enabled);
	}
    	/*
	 *String consisting of the resize handles
          to display (defaults to undefined). Specify either 
          'all' or any of 
          'n s e w ne nw se sw'.
	 */
	
	public String getHandles () {
		return (String) getStateHelper().eval(PropertyKeys.handles);
	}

	/**
	 * <p>
	 * Set the value of the <code>handles</code> property.
	 * </p>
	 */
	public void setHandles ( String   handles ) {
		getStateHelper().put(PropertyKeys.handles, handles);
		handleAttribute("handles", handles);
	}
    	/*
	 *
        
        
          duration
         : Number
        Animation duration if animate = true
        (defaults to 0.35)
	 */
	
	public Integer getDuration () {
		return (Integer) getStateHelper().eval(PropertyKeys.duration);
	}

	/**
	 * <p>
	 * Set the value of the <code>duration</code> property.
	 * </p>
	 */
	public void setDuration ( Integer   duration ) {
		getStateHelper().put(PropertyKeys.duration, duration);
		handleAttribute("duration", duration);
	}
    	/*
	 *
        
        
          minHeight
         : Number
        The minimum height for the element
        (defaults to 5)
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
	 *
        
        
          preserveRatio
         : Boolean
        True to preserve the original ratio
        between height and width during resize (defaults to
        false)
	 */
	
	public Boolean getPreserveRatio () {
		return (Boolean) getStateHelper().eval(PropertyKeys.preserveRatio);
	}

	/**
	 * <p>
	 * Set the value of the <code>preserveRatio</code> property.
	 * </p>
	 */
	public void setPreserveRatio ( Boolean   preserveRatio ) {
		getStateHelper().put(PropertyKeys.preserveRatio, preserveRatio);
		handleAttribute("preserveRatio", preserveRatio);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforeresize"
					, "resize"
				));
				return superEvent;
	}
}