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
  Encapsulates a DOM element, adding simple DOM manipulation
  facilities, normalizing for browser differences.
  All instances of this class inherit the methods of 
  Ext.Fx making
  visual effects easily available to all DOM elements.
  Note that the events documented in this class are not Ext
  events, they encapsulate browser events. To access the underlying
  browser event, see 
  Ext.EventObject.browserEvent. Some
  older browsers may not support the full range of events. Which
  events are supported is beyond the control of ExtJs.Usage:
  


// by id
var el = Ext.get(
"my-div");

// by DOM element reference
var el = Ext.get(myDivElement);
  
  Animations
  
  When an element is manipulated, by default there is no
  animation.


var el = Ext.get(
"my-div");

// no animation
el.setWidth(100);
  
  Many of the functions for manipulating an element have an
  optional "animate" parameter. This parameter can be specified as
  boolean (
  true) for default animation effects.


// 
default animation
el.setWidth(100, true);
  
  To configure the effects, an object literal with animation
  options to use as the Element animation configuration object can
  also be specified. Note that the supported Element animation
  configuration options are a subset of the 
  Ext.Fx
  animation options specific to Fx effects. The supported Element
  animation configuration options are:

Option    Default   Description
--------- --------  ---------------------------------------------
duration  .35       The duration of the
animation in seconds
easing    easeOut   The easing method
callback  none      A function to execute when
the anim completes
scope     this      The scope (this) of the
callback function
  


// Element animation options object
var opt = {
    
duration: 1,
    
easing: 
'elasticIn',
    
callback: this.foo,
    
scope: this
};
// animation 
with some options set
el.setWidth(100, opt);
  
  The Element animation object being used for the animation will
  be set on the options object as "anim", which allows you to stop
  or manipulate the animation. Here is an example:


// using the 
"anim" property to get the Anim object
if(opt.anim.isAnimated()){
    opt.anim.stop();
}
  
  Also see the 
  
    animate
   method for another animation technique.
  
    Composite (Collections of) Elements
  
  For working with collections of Elements, see 
  Ext.CompositeElement
 */

@InstanceOf("Ext.Element")

@FacesComponent(value = "Ext.Element")
public class Element extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.Element";

	/**
	 * <p>
	 * Create a new {@link Ext.Element} instance with default property values.
	 * </p>
	 */
	public Element() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
	
	    
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "DOMActivate"
					, "DOMAttrModified"
					, "DOMCharacterDataModified"
					, "DOMFocusIn"
					, "DOMFocusOut"
					, "DOMNodeInserted"
					, "DOMNodeInsertedIntoDocument"
					, "DOMNodeRemoved"
					, "DOMNodeRemovedFromDocument"
					, "DOMSubtreeModified"
					, "abort"
					, "blur"
					, "change"
					, "click"
					, "contextmenu"
					, "dblclick"
					, "error"
					, "focus"
					, "keydown"
					, "keypress"
					, "keyup"
					, "load"
					, "mousedown"
					, "mouseenter"
					, "mouseleave"
					, "mousemove"
					, "mouseout"
					, "mouseover"
					, "mouseup"
					, "reset"
					, "resize"
					, "scroll"
					, "select"
					, "submit"
					, "unload"
				));
				return superEvent;
	}
}