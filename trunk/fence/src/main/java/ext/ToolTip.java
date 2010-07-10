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
 * A standard tooltip implementation for
  providing additional information when hovering over a target
  element.
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
			delegate
			,anchorOffset
			,mouseOffset
			,autoHide
			,trackMouse
			,anchorToTarget
			,target
			,dismissDelay
			,showDelay
			,hideDelay
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
            Optional. A 
            DomQuery selector which
            allows selection of individual elements within the 
            
              target
             element to trigger showing and hiding the
            ToolTip as the mouse moves within the target.
            When specified, the child element of the target
            which caused a show event is placed into the 
            
              triggerElement
             property before the ToolTip is shown.
            This may be useful when a Component has regular,
            repeating elements in it, each of which need a Tooltip
            which contains information specific to that element.
            For example:


var myGrid = 
new Ext.grid.gridPanel(gridConfig);
myGrid.on(
'render', 
function(grid) {
    
var store = grid.getStore();  
// Capture the Store.

    
var view = grid.getView();    
// Capture the GridView.

    myGrid.tip = 
new Ext.ToolTip({
        target: view.mainBody,    
// The overall target element.

        delegate: 
'.x-grid3-row', 
// Each grid row causes its own seperate show and hide.

        trackMouse: true,         
// Moving within the row should not hide the tip.

        renderTo: document.body,  
// Render immediately so that tip.body can be

                                  
//  referenced prior to the first show.

        listeners: {              
// Change content dynamically depending on which element

                                  
//  triggered the show.

            beforeshow: 
function updateTipBody(tip) {
                
var rowIndex = view.findRowIndex(tip.triggerElement);
                tip.body.dom.innerHTML = 
'Over Record ID ' + store.getAt(rowIndex).id;
            }
        }
    });
});
            
          
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
    	/*
	 *A numeric pixel value used to offset
          the default position of the anchor arrow (defaults to 0).
          When the anchor position is on the top or bottom of the
          tooltip, 
          anchorOffset will be used as a horizontal
          offset. Likewise, when the anchor position is on the left
          or right side, 
          anchorOffset will be used as a vertical
          offset.
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
	 *True to automatically hide the tooltip
          after the mouse exits the target element or after the 
          
            dismissDelay
           has expired if set (defaults to true). If 
          
          closable = true a close
          tool button will be rendered into the tooltip
          header.
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
	 *True to anchor the tooltip to the
          target element, false to anchor it relative to the mouse
          coordinates (defaults to true). When 
          anchorToTarget is true, use 
          
            defaultAlign
           to control tooltip alignment to the target
          element. When 
          anchorToTarget is false, use 
          
            anchorPosition
           instead to control alignment.
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
	 *Delay in milliseconds before the
          tooltip automatically hides (defaults to 5000). To
          disable automatic hiding, set dismissDelay = 0.
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
	 *Delay in milliseconds after the mouse
          exits the target element but before the tooltip actually
          hides (defaults to 200). Set to 0 for the tooltip to hide
          immediately.
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