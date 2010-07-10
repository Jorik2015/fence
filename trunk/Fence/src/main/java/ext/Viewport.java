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
    A specialized container representing the viewable
    application area (the browser viewport).
    The Viewport renders itself to the document body, and
    automatically sizes itself to the size of the browser viewport
    and manages window resizing. There may only be one Viewport
    created in a page. Inner layouts are available by virtue of the
    fact that all 
    Panels
    added to the Viewport, either through its 
    items, or through
    the items, or the 
    add method of any
    of its child Panels may themselves have a layout.
    The Viewport does not provide scrolling, so child Panels
    within the Viewport should provide for scrolling if needed
    using the 
    autoScroll
    config.
    An example showing a classic application border layout:


new Ext.Viewport({
    layout: 
'border',
    items: [{
        region: 
'north',
        html: 
'<h1 class="x-panel-header">Page
Title</h1>',
        autoHeight: true,
        border: false,
        margins: 
'0 0 5 0'
    }, {
        region: 
'west',
        collapsible: true,
        title: 
'Navigation',
        width: 200
        
// the west region might typically utilize a 
TreePanel or a Panel 
with 
Accordion layout

    }, {
        region: 
'south',
        title: 
'Title 
for Panel',
        collapsible: true,
        html: 
'Information goes here',
        split: true,
        height: 100,
        minHeight: 100
    }, {
        region: 
'east',
        title: 
'Title 
for the Grid Panel',
        collapsible: true,
        split: true,
        width: 200,
        xtype: 
'grid',
        
// remaining grid configuration not shown ...

        
// notice that the GridPanel is added directly as the region

        
// it is not 
"overnested" inside another Panel

    }, {
        region: 
'center',
        xtype: 
'tabpanel', 
// TabPanel itself has no title

        items: {
            title: 
'Default Tab',
            html: 
'The first tab\'s content. Others may be added dynamically
'
        }
    }]
});
    
  
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