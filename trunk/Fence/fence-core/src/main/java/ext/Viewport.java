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
    <p>A specialized container representing the viewable
    application area (the browser viewport).</p>
    <p>The Viewport renders itself to the document body, and
    automatically sizes itself to the size of the browser viewport
    and manages window resizing. There may only be one Viewport
    created in a page. Inner layouts are available by virtue of the
    fact that all 
    <a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Panel</a>s
    added to the Viewport, either through its 
    <a ext:cls="Ext.Viewport" ext:member="items" href="output/Ext.Viewport.html#Ext.Viewport-items">items</a>, or through
    the items, or the 
    <a ext:cls="Ext.Viewport" ext:member="add" href="output/Ext.Viewport.html#Ext.Viewport-add">add</a> method of any
    of its child Panels may themselves have a layout.</p>
    <p>The Viewport does not provide scrolling, so child Panels
    within the Viewport should provide for scrolling if needed
    using the 
    <a ext:cls="Ext.Viewport" ext:member="autoScroll" href="output/Ext.Viewport.html#Ext.Viewport-autoScroll">autoScroll</a>
    config.</p>
    <p>An example showing a classic application border layout:</p>
<pre>
<code>
<b>new</b> Ext.Viewport({
    layout: 
<em>'border'</em>,
    items: [{
        region: 
<em>'north'</em>,
        html: 
<em>'&lt;h1 class=</em>"x-panel-header"</code>&gt;Page
Title&lt;/h1&gt;',
        autoHeight: true,
        border: false,
        margins: 
<em>'0 0 5 0'</em>
    }, {
        region: 
<em>'west'</em>,
        collapsible: true,
        title: 
<em>'Navigation'</em>,
        width: 200
        
<i>// the west region might typically utilize a 
<a ext:cls="Ext.tree.TreePanel" href="output/Ext.tree.TreePanel.html">TreePanel</a> or a Panel 
<b>with</b> 
<a ext:cls="Ext.layout.AccordionLayout" href="output/Ext.layout.AccordionLayout.html">Accordion layout</a>
</i>
    }, {
        region: 
<em>'south'</em>,
        title: 
<em>'Title 
<b>for</b> Panel'</em>,
        collapsible: true,
        html: 
<em>'Information goes here'</em>,
        split: true,
        height: 100,
        minHeight: 100
    }, {
        region: 
<em>'east'</em>,
        title: 
<em>'Title 
<b>for</b> the Grid Panel'</em>,
        collapsible: true,
        split: true,
        width: 200,
        xtype: 
<em>'grid'</em>,
        
<i>// remaining grid configuration not shown ...</i>
        
<i>// notice that the GridPanel is added directly as the region</i>
        
<i>// it is not 
<em>"overnested"</em> inside another Panel</i>
    }, {
        region: 
<em>'center'</em>,
        xtype: 
<em>'tabpanel'</em>, 
<i>// TabPanel itself has no title</i>
        items: {
            title: 
<em>'Default Tab'</em>,
            html: 
<em>'The first tab\'</em>s content. Others may be added dynamically
<em>'
        }
    }]
});</em>
    </pre>
  </div>

 */

@InstanceOf("Ext.Viewport")

@FacesComponent(value = "Ext.Viewport")
public class Viewport extends Container {
	public static final String COMPONENT_FAMILY = "Ext.Viewport";

	/**
	 * <p>
	 * Create a new {@link Ext.Viewport} instance with default property values.
	 * </p>
	 */
	public Viewport() {
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