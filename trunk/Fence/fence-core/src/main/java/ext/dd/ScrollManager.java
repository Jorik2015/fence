package ext.dd;

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
<div class="description">
    <p>Provides automatic scrolling of overflow regions in the page
    during drag operations.</p>
    <p>The ScrollManager configs will be used as the defaults for
    any scroll container registered with it, but you can also
    override most of the configs per scroll container by adding a 
    <tt>ddScrollConfig</tt> object to the target element that
    contains these properties: 
    <a ext:cls="Ext.dd.ScrollManager" ext:member="hthresh" href="output/Ext.dd.ScrollManager.html#Ext.dd.ScrollManager-hthresh">hthresh</a>, 
    <a ext:cls="Ext.dd.ScrollManager" ext:member="vthresh" href="output/Ext.dd.ScrollManager.html#Ext.dd.ScrollManager-vthresh">vthresh</a>, 
    <a ext:cls="Ext.dd.ScrollManager" ext:member="increment" href="output/Ext.dd.ScrollManager.html#Ext.dd.ScrollManager-increment">increment</a> and 
    <a ext:cls="Ext.dd.ScrollManager" ext:member="frequency" href="output/Ext.dd.ScrollManager.html#Ext.dd.ScrollManager-frequency">frequency</a>. Example
    usage:</p>
<pre>
<code>
<b>var</b> el = Ext.get(
<em>'scroll-ct'</em>);
el.ddScrollConfig = {
    vthresh: 50,
    hthresh: -1,
    frequency: 100,
    increment: 200
};
Ext.dd.ScrollManager.register(el);</code>
    </pre>
    <b>Note: This class uses "Point Mode" and is untested in
    "Intersect Mode".</b>
    <br/>
    <br/>
    <i>This class is a singleton and cannot be created
    directly.</i>
  </div>

 */

@InstanceOf("Ext.dd.ScrollManager")

@FacesComponent(value = "Ext.dd.ScrollManager")
public class ScrollManager extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.dd.ScrollManager";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.ScrollManager} instance with default property values.
	 * </p>
	 */
	public ScrollManager() {
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
				return superEvent;
	}
}