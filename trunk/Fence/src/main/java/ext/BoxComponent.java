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
  Base class for any 
  Component that is to be sized as a
  box, using width and height.
  BoxComponent provides automatic box model adjustments for
  sizing and positioning and will work correctly within the
  Component rendering model.
  A BoxComponent may be created as a custom Component which
  encapsulates any HTML element, either a pre-existing element, or
  one that is created to your specifications at render time.
  Usually, to participate in layouts, a Component will need to be a
  
  BoxComponent in order to have its width and height
  managed.
  To use a pre-existing element as a BoxComponent, configure it
  so that you preset the 
  el property to the element to reference:


var pageHeader = 
new Ext.BoxComponent({
    el: 
'my-header-div'
});
  This may then be 
  added to a 
  Container as a child item.
  
   
  To create a BoxComponent based around a HTML element to be
  created at render time, use the 
  autoEl config
  option which takes the form of a 
  DomHelper specification:


var myImage = 
new Ext.BoxComponent({
    autoEl: {
        tag: 
'img',
        src: 
'/images/my-image.jpg'
    }
});
  
  
  
 */
@XType("box")
@InstanceOf("Ext.BoxComponent")

@FacesComponent(value = "Ext.BoxComponent")
public class BoxComponent extends Component {
	public static final String COMPONENT_FAMILY = "Ext.BoxComponent";

	/**
	 * <p>
	 * Create a new {@link Ext.BoxComponent} instance with default property values.
	 * </p>
	 */
	public BoxComponent() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			width
			,boxMinWidth
			,region
			,boxMinHeight
			,tabTip
			,autoWidth
			,boxMaxHeight
			,boxMaxWidth
			,height
			,autoScroll
			,margins
			,pageX
			,y
			,autoHeight
			,pageY
			,x
			,anchor
			,flex
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
	 *The width of this component in pixels
          (defaults to auto). 
          Note to express this dimension as a percentage or
          offset see 
          Ext.Component.anchor.
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
            The minimum value in pixels which this BoxComponent
            will set its width to.
            
            Warning: This will override any size management
            applied by layout managers.
          
	 */
	
	public Integer getBoxMinWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.boxMinWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>boxMinWidth</code> property.
	 * </p>
	 */
	public void setBoxMinWidth ( Integer   boxMinWidth ) {
		getStateHelper().put(PropertyKeys.boxMinWidth, boxMinWidth);
		handleAttribute("boxMinWidth", boxMinWidth);
	}
    	/*
	 *
            
            Note: this config is only used when this
            BoxComponent is rendered by a Container which has been
            configured to use the 
            
              BorderLayout
             layout manager (e.g. specifying 
            layout:'border').
            
            See 
            Ext.layout.BorderLayout
            also.
          
	 */
	
	public String getRegion () {
		return (String) getStateHelper().eval(PropertyKeys.region);
	}

	/**
	 * <p>
	 * Set the value of the <code>region</code> property.
	 * </p>
	 */
	public void setRegion ( String   region ) {
		getStateHelper().put(PropertyKeys.region, region);
		handleAttribute("region", region);
	}
    	/*
	 *
            The minimum value in pixels which this BoxComponent
            will set its height to.
            
            Warning: This will override any size management
            applied by layout managers.
          
	 */
	
	public Integer getBoxMinHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.boxMinHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>boxMinHeight</code> property.
	 * </p>
	 */
	public void setBoxMinHeight ( Integer   boxMinHeight ) {
		getStateHelper().put(PropertyKeys.boxMinHeight, boxMinHeight);
		handleAttribute("boxMinHeight", boxMinHeight);
	}
    	/*
	 *
          
          Note: this config is only used when this
          BoxComponent is a child item of a TabPanel.A string
          to be used as innerHTML (html tags are accepted) to show
          in a tooltip when mousing over the associated tab
          selector element. 
          Ext.QuickTips.init() must be
          called in order for the tips to render.
	 */
	
	public String getTabTip () {
		return (String) getStateHelper().eval(PropertyKeys.tabTip);
	}

	/**
	 * <p>
	 * Set the value of the <code>tabTip</code> property.
	 * </p>
	 */
	public void setTabTip ( String   tabTip ) {
		getStateHelper().put(PropertyKeys.tabTip, tabTip);
		handleAttribute("tabTip", tabTip);
	}
    	/*
	 *
          True to use width:'auto', false to use fixed width (or
          allow it to be managed by its parent Container's 
          layout
          manager. Defaults to false.
          
          Note: Although many components inherit this config
          option, not all will function as expected with a width of
          'auto'. Setting autoWidth:true means that the browser
          will manage width based on the element's contents, and
          that Ext will not manage it at all.
          If the 
          browser is managing the width, be aware that
          resizes performed by the browser in response to changes
          within the structure of the Component cannot be detected.
          Therefore changes to the width might result in elements
          needing to be synchronized with the new width. For
          example, where the target element is:

<div id=
'grid-container' style=
'margin-left:25%;width:50%'></div>
          A Panel rendered into that target element must
          listen for browser window resize in order to relay its
          child items when the browser changes its width:


var myPanel = 
new Ext.Panel({
    renderTo: 
'grid-container',
    monitorResize: true, 
// relay on browser resize
    title: 
'Panel',
    height: 400,
    autoWidth: true,
    layout: 
'hbox',
    layoutConfig: {
        align: 
'stretch'
    },
    defaults: {
        flex: 1
    },
    items: [{
        title: 
'Box 1',
    }, {
        title: 
'Box 2'
    }, {
        title: 
'Box 3'
    }],
});
          
	 */
	
	public Boolean getAutoWidth () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoWidth</code> property.
	 * </p>
	 */
	public void setAutoWidth ( Boolean   autoWidth ) {
		getStateHelper().put(PropertyKeys.autoWidth, autoWidth);
		handleAttribute("autoWidth", autoWidth);
	}
    	/*
	 *
            The maximum value in pixels which this BoxComponent
            will set its height to.
            
            Warning: This will override any size management
            applied by layout managers.
          
	 */
	
	public Integer getBoxMaxHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.boxMaxHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>boxMaxHeight</code> property.
	 * </p>
	 */
	public void setBoxMaxHeight ( Integer   boxMaxHeight ) {
		getStateHelper().put(PropertyKeys.boxMaxHeight, boxMaxHeight);
		handleAttribute("boxMaxHeight", boxMaxHeight);
	}
    	/*
	 *
            The maximum value in pixels which this BoxComponent
            will set its width to.
            
            Warning: This will override any size management
            applied by layout managers.
          
	 */
	
	public Integer getBoxMaxWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.boxMaxWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>boxMaxWidth</code> property.
	 * </p>
	 */
	public void setBoxMaxWidth ( Integer   boxMaxWidth ) {
		getStateHelper().put(PropertyKeys.boxMaxWidth, boxMaxWidth);
		handleAttribute("boxMaxWidth", boxMaxWidth);
	}
    	/*
	 *The height of this component in pixels
          (defaults to auto). 
          Note to express this dimension as a percentage or
          offset see 
          Ext.Component.anchor.
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
          true to use overflow:'auto' on the
          components layout element and show scroll bars
          automatically when necessary, 
          false to clip any overflowing content
          (defaults to 
          false).
	 */
	
	public Boolean getAutoScroll () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoScroll);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoScroll</code> property.
	 * </p>
	 */
	public void setAutoScroll ( Boolean   autoScroll ) {
		getStateHelper().put(PropertyKeys.autoScroll, autoScroll);
		handleAttribute("autoScroll", autoScroll);
	}
    	/*
	 *
          
          Note: this config is only used when this
          BoxComponent is rendered by a Container which has been
          configured to use the 
          
            BorderLayout
           or one of the two 
          
          BoxLayout
          subclasses.
          An object containing margins to apply to this
          BoxComponent in the format:

{
    top: (top margin),
    right: (right margin),
    bottom: (bottom margin),
    left: (left margin)
}
          
          May also be a string containing space-separated,
          numeric margin values. The order of the sides associated
          with each value matches the way CSS processes margin
          values:
          
            
              If there is only one value, it applies to all
              sides.
              If there are two values, the top and bottom
              borders are set to the first value and the right and
              left are set to the second.
              If there are three values, the top is set to the
              first value, the left and right are set to the
              second, and the bottom is set to the third.
              If there are four values, they apply to the top,
              right, bottom, and left, respectively.
            
          
          
           
          Defaults to:

{top:0, right:0, bottom:0, left:0}
          
	 */
	
	public String getMargins () {
		return (String) getStateHelper().eval(PropertyKeys.margins);
	}

	/**
	 * <p>
	 * Set the value of the <code>margins</code> property.
	 * </p>
	 */
	public void setMargins ( String   margins ) {
		getStateHelper().put(PropertyKeys.margins, margins);
		handleAttribute("margins", margins);
	}
    	/*
	 *
        
        
          pageX
         : Number
        The page level x coordinate for this
        component if contained within a positioning
        container.
	 */
	
	public Integer getPageX () {
		return (Integer) getStateHelper().eval(PropertyKeys.pageX);
	}

	/**
	 * <p>
	 * Set the value of the <code>pageX</code> property.
	 * </p>
	 */
	public void setPageX ( Integer   pageX ) {
		getStateHelper().put(PropertyKeys.pageX, pageX);
		handleAttribute("pageX", pageX);
	}
    	/*
	 *
        
        
          y
         : Number
        The local y (top) coordinate for this
        component if contained within a positioning
        container.
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
	 *
            True to use height:'auto', false to use fixed height
            (or allow it to be managed by its parent Container's 
            layout
            manager. Defaults to false.
            
            Note: Although many components inherit this
            config option, not all will function as expected with a
            height of 'auto'. Setting autoHeight:true means that
            the browser will manage height based on the element's
            contents, and that Ext will not manage it at all.
            If the 
            browser is managing the height, be aware that
            resizes performed by the browser in response to changes
            within the structure of the Component cannot be
            detected. Therefore changes to the height might result
            in elements needing to be synchronized with the new
            height. Example:


var w = 
new Ext.Window({
    title: 
'Window',
    width: 600,
    autoHeight: true,
    items: {
        title: 
'Collapse Me',
        height: 400,
        collapsible: true,
        border: false,
        listeners: {
            beforecollapse: 
function() {
                w.el.shadow.hide();
            },
            beforeexpand: 
function() {
                w.el.shadow.hide();
            },
            collapse: 
function() {
                w.syncShadow();
            },
            expand: 
function() {
                w.syncShadow();
            }
        }
    }
}).show();
            
          
	 */
	
	public Boolean getAutoHeight () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoHeight</code> property.
	 * </p>
	 */
	public void setAutoHeight ( Boolean   autoHeight ) {
		getStateHelper().put(PropertyKeys.autoHeight, autoHeight);
		handleAttribute("autoHeight", autoHeight);
	}
    	/*
	 *
        
        
          pageY
         : Number
        The page level y coordinate for this
        component if contained within a positioning
        container.
	 */
	
	public Integer getPageY () {
		return (Integer) getStateHelper().eval(PropertyKeys.pageY);
	}

	/**
	 * <p>
	 * Set the value of the <code>pageY</code> property.
	 * </p>
	 */
	public void setPageY ( Integer   pageY ) {
		getStateHelper().put(PropertyKeys.pageY, pageY);
		handleAttribute("pageY", pageY);
	}
    	/*
	 *
        
        
          x
         : Number
        The local x (left) coordinate for this
        component if contained within a positioning
        container.
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
	 *
          
          Note: this config is only used when this Component
          is rendered by a Container which has been configured to
          use an 
          
          AnchorLayout (or
          subclass thereof). based layout manager, for
          example:
          
            
              
                Ext.form.FormPanel
              
              specifying 
              layout: 
              'anchor' 
              // or 
              'form', or 
              'absolute'
            
          
          
           
          See 
          Ext.layout.AnchorLayout.
          anchor
          also.
	 */
	
	public String getAnchor () {
		return (String) getStateHelper().eval(PropertyKeys.anchor);
	}

	/**
	 * <p>
	 * Set the value of the <code>anchor</code> property.
	 * </p>
	 */
	public void setAnchor ( String   anchor ) {
		getStateHelper().put(PropertyKeys.anchor, anchor);
		handleAttribute("anchor", anchor);
	}
    	/*
	 *
            
            Note: this config is only used when this
            Component is rendered by a Container which has been
            configured to use a 
            
            BoxLayout. Each
            child Component with a 
            flex property will be flexed either
            vertically (by a VBoxLayout) or horizontally (by an
            HBoxLayout) according to the item's 
            relative 
            flex value compared to the sum of all
            Components with 
            flex value specified. Any child items that have
            either a flex = 0 or 
            flex = undefined will not be 'flexed' (the
            initial size will not be changed).
          
	 */
	
	public Integer getFlex () {
		return (Integer) getStateHelper().eval(PropertyKeys.flex);
	}

	/**
	 * <p>
	 * Set the value of the <code>flex</code> property.
	 * </p>
	 */
	public void setFlex ( Integer   flex ) {
		getStateHelper().put(PropertyKeys.flex, flex);
		handleAttribute("flex", flex);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "move"
					, "resize"
				));
				return superEvent;
	}
}