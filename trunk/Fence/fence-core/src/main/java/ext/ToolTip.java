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
<div class="description">A standard tooltip implementation for
  providing additional information when hovering over a target
  element.</div>

 */

@InstanceOf("Ext.ToolTip")

@FacesComponent(value = "Ext.ToolTip")
public class ToolTip extends Tip {
	public static final String COMPONENT_FAMILY = "Ext.ToolTip";

	/**
	 * <p>
	 * Create a new {@link Ext.ToolTip} instance with default property values.
	 * </p>
	 */
	public ToolTip() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			trackMouse
			,dismissDelay
			,showDelay
			,hideDelay
			,autoHide
			,anchorOffset
			,target
			,mouseOffset
			,anchorToTarget
			,delegate
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
        
        
          trackMouse
         : Boolean
        True to have the tooltip follow the
        mouse as it moves over the target element (defaults to
        false).
	 */
	
	public Boolean getTrackMouse () {
		return (Boolean) getStateHelper().eval(PropertyKeys.trackMouse);
	}

	/**
	 * <p>
	 * Set the value of the <code>trackMouse</code> property.
	 * </p>
	 */
	public void setTrackMouse ( Boolean   trackMouse ) {
		getStateHelper().put(PropertyKeys.trackMouse, trackMouse);
		handleAttribute("trackMouse", trackMouse);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Delay in milliseconds before the
          tooltip automatically hides (defaults to 5000). To
          disable automatic hiding, set dismissDelay = 0.</div>

	 */
	
	public Integer getDismissDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.dismissDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>dismissDelay</code> property.
	 * </p>
	 */
	public void setDismissDelay ( Integer   dismissDelay ) {
		getStateHelper().put(PropertyKeys.dismissDelay, dismissDelay);
		handleAttribute("dismissDelay", dismissDelay);
	}
    	/*
	 *
        
        
          showDelay
         : Number
        Delay in milliseconds before the tooltip
        displays after the mouse enters the target element
        (defaults to 500)
	 */
	
	public Integer getShowDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.showDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>showDelay</code> property.
	 * </p>
	 */
	public void setShowDelay ( Integer   showDelay ) {
		getStateHelper().put(PropertyKeys.showDelay, showDelay);
		handleAttribute("showDelay", showDelay);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Delay in milliseconds after the mouse
          exits the target element but before the tooltip actually
          hides (defaults to 200). Set to 0 for the tooltip to hide
          immediately.</div>

	 */
	
	public Integer getHideDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.hideDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideDelay</code> property.
	 * </p>
	 */
	public void setHideDelay ( Integer   hideDelay ) {
		getStateHelper().put(PropertyKeys.hideDelay, hideDelay);
		handleAttribute("hideDelay", hideDelay);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to automatically hide the tooltip
          after the mouse exits the target element or after the 
          <code>
            <a ext:cls="Ext.ToolTip" ext:member="dismissDelay" href="output/Ext.ToolTip.html#Ext.ToolTip-dismissDelay">dismissDelay</a>
          </code> has expired if set (defaults to true). If 
          <code>
          <a ext:cls="closable" href="output/closable.html">closable</a> = true</code> a close
          tool button will be rendered into the tooltip
          header.</div>

	 */
	
	public Boolean getAutoHide () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoHide);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoHide</code> property.
	 * </p>
	 */
	public void setAutoHide ( Boolean   autoHide ) {
		getStateHelper().put(PropertyKeys.autoHide, autoHide);
		handleAttribute("autoHide", autoHide);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A numeric pixel value used to offset
          the default position of the anchor arrow (defaults to 0).
          When the anchor position is on the top or bottom of the
          tooltip, 
          <code>anchorOffset</code> will be used as a horizontal
          offset. Likewise, when the anchor position is on the left
          or right side, 
          <code>anchorOffset</code> will be used as a vertical
          offset.</div>

	 */
	
	public Integer getAnchorOffset () {
		return (Integer) getStateHelper().eval(PropertyKeys.anchorOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>anchorOffset</code> property.
	 * </p>
	 */
	public void setAnchorOffset ( Integer   anchorOffset ) {
		getStateHelper().put(PropertyKeys.anchorOffset, anchorOffset);
		handleAttribute("anchorOffset", anchorOffset);
	}
    	/*
	 *
        
        
          target
         : Mixed
        The target HTMLElement, Ext.Element or
        id to monitor for mouseover events to trigger showing this
        ToolTip.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTarget () {
		return (Object) getStateHelper().eval(PropertyKeys.target);
	}

	/**
	 * <p>
	 * Set the value of the <code>target</code> property.
	 * </p>
	 */
	public void setTarget ( Object   target ) {
		getStateHelper().put(PropertyKeys.target, target);
		handleAttribute("target", target);
	}
    	/*
	 *
        
        
          mouseOffset
         : Array
        An XY offset from the mouse position
        where the tooltip should be shown (defaults to
        [15,18]).
	 */
	@ClientConfig(JsonMode.Array)

	public Object getMouseOffset () {
		return (Object) getStateHelper().eval(PropertyKeys.mouseOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>mouseOffset</code> property.
	 * </p>
	 */
	public void setMouseOffset ( Object   mouseOffset ) {
		getStateHelper().put(PropertyKeys.mouseOffset, mouseOffset);
		handleAttribute("mouseOffset", mouseOffset);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to anchor the tooltip to the
          target element, false to anchor it relative to the mouse
          coordinates (defaults to true). When 
          <code>anchorToTarget</code> is true, use 
          <code>
            <a ext:cls="Ext.ToolTip" ext:member="defaultAlign" href="output/Ext.ToolTip.html#Ext.ToolTip-defaultAlign">defaultAlign</a>
          </code> to control tooltip alignment to the target
          element. When 
          <code>anchorToTarget</code> is false, use 
          <code>
            <a ext:cls="Ext.ToolTip" ext:member="anchorPosition" href="output/Ext.ToolTip.html#Ext.ToolTip-anchorPosition">anchorPosition</a>
          </code> instead to control alignment.</div>

	 */
	
	public Boolean getAnchorToTarget () {
		return (Boolean) getStateHelper().eval(PropertyKeys.anchorToTarget);
	}

	/**
	 * <p>
	 * Set the value of the <code>anchorToTarget</code> property.
	 * </p>
	 */
	public void setAnchorToTarget ( Boolean   anchorToTarget ) {
		getStateHelper().put(PropertyKeys.anchorToTarget, anchorToTarget);
		handleAttribute("anchorToTarget", anchorToTarget);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Optional. A 
            <a ext:cls="Ext.DomQuery" href="output/Ext.DomQuery.html">DomQuery</a> selector which
            allows selection of individual elements within the 
            <code>
              <a ext:cls="Ext.ToolTip" ext:member="target" href="output/Ext.ToolTip.html#Ext.ToolTip-target">target</a>
            </code> element to trigger showing and hiding the
            ToolTip as the mouse moves within the target.</p>
            <p>When specified, the child element of the target
            which caused a show event is placed into the 
            <code>
              <a ext:cls="Ext.ToolTip" ext:member="triggerElement" href="output/Ext.ToolTip.html#Ext.ToolTip-triggerElement">triggerElement</a>
            </code> property before the ToolTip is shown.</p>
            <p>This may be useful when a Component has regular,
            repeating elements in it, each of which need a Tooltip
            which contains information specific to that element.
            For example:</p>
<pre>
<code>
<b>var</b> myGrid = 
<b>new</b> Ext.grid.gridPanel(gridConfig);
myGrid.on(
<em>'render'</em>, 
<b>function</b>(grid) {
    
<b>var</b> store = grid.getStore();  
<i>// Capture the Store.</i>
    
<b>var</b> view = grid.getView();    
<i>// Capture the GridView.</i>
    myGrid.tip = 
<b>new</b> Ext.ToolTip({
        target: view.mainBody,    
<i>// The overall target element.</i>
        delegate: 
<em>'.x-grid3-row'</em>, 
<i>// Each grid row causes its own seperate show and hide.</i>
        trackMouse: true,         
<i>// Moving within the row should not hide the tip.</i>
        renderTo: document.body,  
<i>// Render immediately so that tip.body can be</i>
                                  
<i>//  referenced prior to the first show.</i>
        listeners: {              
<i>// Change content dynamically depending on which element</i>
                                  
<i>//  triggered the show.</i>
            beforeshow: 
<b>function</b> updateTipBody(tip) {
                
<b>var</b> rowIndex = view.findRowIndex(tip.triggerElement);
                tip.body.dom.innerHTML = 
<em>'Over Record ID '</em> + store.getAt(rowIndex).id;
            }
        }
    });
});</code>
            </pre>
          </div>

	 */
	
	public String getDelegate () {
		return (String) getStateHelper().eval(PropertyKeys.delegate);
	}

	/**
	 * <p>
	 * Set the value of the <code>delegate</code> property.
	 * </p>
	 */
	public void setDelegate ( String   delegate ) {
		getStateHelper().put(PropertyKeys.delegate, delegate);
		handleAttribute("delegate", delegate);
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