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
  <p>Encapsulates a DOM element, adding simple DOM manipulation
  facilities, normalizing for browser differences.</p>
  <p>All instances of this class inherit the methods of 
  <a ext:cls="Ext.Fx" href="output/Ext.Fx.html">Ext.Fx</a> making
  visual effects easily available to all DOM elements.</p>
  <p>Note that the events documented in this class are not Ext
  events, they encapsulate browser events. To access the underlying
  browser event, see 
  <a ext:cls="Ext.EventObject" ext:member="browserEvent" href="output/Ext.EventObject.html#Ext.EventObject-browserEvent">Ext.EventObject.browserEvent</a>. Some
  older browsers may not support the full range of events. Which
  events are supported is beyond the control of ExtJs.</p>Usage:
  <br/>
<pre>
<code>
<i>// by id</i>
<b>var</b> el = Ext.get(
<em>"my-div"</em>);

<i>// by DOM element reference</i>
<b>var</b> el = Ext.get(myDivElement);</code>
  </pre>
  <b>Animations</b>
  <br/>
  <p>When an element is manipulated, by default there is no
  animation.</p>
<pre>
<code>
<b>var</b> el = Ext.get(
<em>"my-div"</em>);

<i>// no animation</i>
el.setWidth(100);</code>
  </pre>
  <p>Many of the functions for manipulating an element have an
  optional "animate" parameter. This parameter can be specified as
  boolean (
  <tt>true</tt>) for default animation effects.</p>
<pre>
<code>
<i>// 
<b>default</b> animation</i>
el.setWidth(100, true);</code>
  </pre>
  <p>To configure the effects, an object literal with animation
  options to use as the Element animation configuration object can
  also be specified. Note that the supported Element animation
  configuration options are a subset of the 
  <a ext:cls="Ext.Fx" href="output/Ext.Fx.html">Ext.Fx</a>
  animation options specific to Fx effects. The supported Element
  animation configuration options are:</p>
<pre>
Option    Default   Description
--------- --------  ---------------------------------------------
<a ext:cls="Ext.Fx" ext:member="duration" href="output/Ext.Fx.html#Ext.Fx-duration">duration</a>  .35       The duration of the
animation in seconds
<a ext:cls="Ext.Fx" ext:member="easing" href="output/Ext.Fx.html#Ext.Fx-easing">easing</a>    easeOut   The easing method
<a ext:cls="Ext.Fx" ext:member="callback" href="output/Ext.Fx.html#Ext.Fx-callback">callback</a>  none      A function to execute when
the anim completes
<a ext:cls="Ext.Fx" ext:member="scope" href="output/Ext.Fx.html#Ext.Fx-scope">scope</a>     this      The scope (this) of the
callback function
  </pre>
<pre>
<code>
<i>// Element animation options object</i>
<b>var</b> opt = {
    
<a ext:cls="Ext.Fx" ext:member="duration" href="output/Ext.Fx.html#Ext.Fx-duration">duration</a>: 1,
    
<a ext:cls="Ext.Fx" ext:member="easing" href="output/Ext.Fx.html#Ext.Fx-easing">easing</a>: 
<em>'elasticIn'</em>,
    
<a ext:cls="Ext.Fx" ext:member="callback" href="output/Ext.Fx.html#Ext.Fx-callback">callback</a>: this.foo,
    
<a ext:cls="Ext.Fx" ext:member="scope" href="output/Ext.Fx.html#Ext.Fx-scope">scope</a>: this
};
<i>// animation 
<b>with</b> some options set</i>
el.setWidth(100, opt);</code>
  </pre>
  <p>The Element animation object being used for the animation will
  be set on the options object as "anim", which allows you to stop
  or manipulate the animation. Here is an example:</p>
<pre>
<code>
<i>// using the 
<em>"anim"</em> property to get the Anim object</i>
<b>if</b>(opt.anim.isAnimated()){
    opt.anim.stop();
}</code>
  </pre>
  <p>Also see the 
  <tt>
    <a ext:cls="Ext.Element" ext:member="animate" href="output/Ext.Element.html#Ext.Element-animate">animate</a>
  </tt> method for another animation technique.</p>
  <p>
    <b>Composite (Collections of) Elements</b>
  </p>
  <p>For working with collections of Elements, see 
  <a ext:cls="Ext.CompositeElement" href="output/Ext.CompositeElement.html">Ext.CompositeElement</a>
</p>
</div>

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