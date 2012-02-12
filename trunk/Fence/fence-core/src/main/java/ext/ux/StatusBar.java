package ext.ux;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
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
 * 
    Basic status bar component that can be used as the bottom
    toolbar of any 
    Ext.Panel. In addition to supporting
    the standard 
    Ext.Toolbar interface for adding
    buttons, menus and other items, the StatusBar provides a greedy
    status element that can be aligned to either side and has
    convenient methods for setting the status text and icon. You
    can also indicate that something is processing using the 
    showBusy
    method.


new Ext.Panel({
    title: 
'StatusBar',
    
// etc.
    bbar: 
new Ext.ux.StatusBar({
        id: 
'my-status',

        
// defaults to use when the status is cleared:
        defaultText: 
'Default status text',
        defaultIconCls: 
'
default-icon',

        
// values to set initially:
        text: 
'Ready',
        iconCls: 
'ready-icon',

        
// any standard Toolbar items:
        items: [{
            text: 
'A Button'
        }, 
'-', 
'Plain Text']
    })
});

// Update the status bar later 
in code:
var sb = Ext.getCmp(
'my-status');
sb.setStatus({
    text: 
'OK',
    iconCls: 
'ok-icon',
    clear: true 
// auto-clear after a set interval
});

// Set the status bar to show that something is processing:
sb.showBusy();

// processing....

sb.clearStatus(); 
// once completeed
    
  
 */

@InstanceOf("Ext.ux.StatusBar")
@ResourceDependencies({
	@ResourceDependency(library = "ext#{ext.version}/ux/statusbar", name = "StatusBar.js"),
	@ResourceDependency(library = "ext#{ext.version}/ux/statusbar", name = "ValidationStatus.js"),
	@ResourceDependency(library = "ext#{ext.version}/ux/statusbar/css", name = "statusbar.css")
})

@FacesComponent(value = "Ext.ux.StatusBar")
public class StatusBar extends Toolbar {
	public static final String COMPONENT_FAMILY = "Ext.ux.StatusBar";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.StatusBar} instance with default property values.
	 * </p>
	 */
	public StatusBar() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			text
			,defaultText
			,iconCls
			,emptyText
			,statusAlign
			,busyIconCls
			,defaultIconCls
			,cls
			,busyText
			,autoClear
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
	 *A string that will be 
          initially set as the status message. This string
          will be set as innerHTML (html tags are accepted) for the
          toolbar item. If not specified, the value set for 
          
            defaultText
           will be used.
	 */
	
	public String getText () {
		return (String) getStateHelper().eval(PropertyKeys.text);
	}

	/**
	 * <p>
	 * Set the value of the <code>text</code> property.
	 * </p>
	 */
	public void setText ( String   text ) {
		getStateHelper().put(PropertyKeys.text, text);
		handleAttribute("text", text);
	}
    	/*
	 *The default 
          text
          value. This will be used anytime the status bar is
          cleared with the 
          useDefaults:true option (defaults to '').
	 */
	
	public String getDefaultText () {
		return (String) getStateHelper().eval(PropertyKeys.defaultText);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultText</code> property.
	 * </p>
	 */
	public void setDefaultText ( String   defaultText ) {
		getStateHelper().put(PropertyKeys.defaultText, defaultText);
		handleAttribute("defaultText", defaultText);
	}
    	/*
	 *A CSS class that will be 
          initially set as the status bar icon and is
          expected to provide a background image (defaults to '').
          Example usage:


// Example CSS rule:
.x-statusbar .x-status-custom {
    padding-left: 25px;
    background: transparent url(images/custom-icon.gif) no-repeat
3px 2px;
}

// Setting a 
default icon:
var sb = 
new Ext.ux.StatusBar({
    defaultIconCls: 
'x-status-custom'
});

// Changing the icon:
sb.setStatus({
    text: 
'New status',
    iconCls: 
'x-status-custom'
});
          
	 */
	
	public String getIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.iconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>iconCls</code> property.
	 * </p>
	 */
	public void setIconCls ( String   iconCls ) {
		getStateHelper().put(PropertyKeys.iconCls, iconCls);
		handleAttribute("iconCls", iconCls);
	}
    	/*
	 *The text string to use if no text has
          been set. Defaults to 
          ' '). If there are no other items in the
          toolbar using an empty string (
          '') for this value would end up in the toolbar
          height collapsing since the empty string will not
          maintain the toolbar height. Use 
          '' if the toolbar should collapse in height
          vertically when no text is specified and there are no
          other items in the toolbar.
	 */
	
	public String getEmptyText () {
		return (String) getStateHelper().eval(PropertyKeys.emptyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>emptyText</code> property.
	 * </p>
	 */
	public void setEmptyText ( String   emptyText ) {
		getStateHelper().put(PropertyKeys.emptyText, emptyText);
		handleAttribute("emptyText", emptyText);
	}
    	/*
	 *The alignment of the status element
          within the overall StatusBar layout. When the StatusBar
          is rendered, it creates an internal div containing the
          status text and icon. Any additional Toolbar items added
          in the StatusBar's 
          items
          config, or added via 
          add or
          any of the supported add* methods, will be rendered, in
          added order, to the opposite side. The status element is
          greedy, so it will automatically expand to take up all
          sapce left over by any other items. Example usage: 


// Create a left-aligned status bar containing a button,
// separator and text item that will be right-aligned (
default):
new Ext.Panel({
    title: 
'StatusBar',
    
// etc.
    bbar: 
new Ext.ux.StatusBar({
        defaultText: 
'Default status text',
        id: 
'status-id',
        items: [{
            text: 
'A Button'
        }, 
'-', 
'Plain Text']
    })
});

// By adding the statusAlign config, this will create the
// exact same toolbar, except the status and toolbar item
// layout will be reversed from the previous example:
new Ext.Panel({
    title: 
'StatusBar',
    
// etc.
    bbar: 
new Ext.ux.StatusBar({
        defaultText: 
'Default status text',
        id: 
'status-id',
        statusAlign: 
'right',
        items: [{
            text: 
'A Button'
        }, 
'-', 
'Plain Text']
    })
});
          
	 */
	
	public String getStatusAlign () {
		return (String) getStateHelper().eval(PropertyKeys.statusAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>statusAlign</code> property.
	 * </p>
	 */
	public void setStatusAlign ( String   statusAlign ) {
		getStateHelper().put(PropertyKeys.statusAlign, statusAlign);
		handleAttribute("statusAlign", statusAlign);
	}
    	/*
	 *The default 
          
            iconCls
           applied when calling 
          
            showBusy
           (defaults to 
          'x-status-busy'). It can be overridden at any
          time by passing the 
          iconCls argument into 
          
            showBusy
          .
	 */
	
	public String getBusyIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.busyIconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>busyIconCls</code> property.
	 * </p>
	 */
	public void setBusyIconCls ( String   busyIconCls ) {
		getStateHelper().put(PropertyKeys.busyIconCls, busyIconCls);
		handleAttribute("busyIconCls", busyIconCls);
	}
    	/*
	 *The default 
          iconCls value (see the
          iconCls docs for additional details about customizing the
          icon). This will be used anytime the status bar is
          cleared with the 
          useDefaults:true option (defaults to '').
	 */
	
	public String getDefaultIconCls () {
		return (String) getStateHelper().eval(PropertyKeys.defaultIconCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultIconCls</code> property.
	 * </p>
	 */
	public void setDefaultIconCls ( String   defaultIconCls ) {
		getStateHelper().put(PropertyKeys.defaultIconCls, defaultIconCls);
		handleAttribute("defaultIconCls", defaultIconCls);
	}
    	/*
	 *
        
        
          cls
         : String
        The base class applied to the containing
        element for this component on render (defaults to
        'x-statusbar')
	 */
	
	public String getCls () {
		return (String) getStateHelper().eval(PropertyKeys.cls);
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls ( String   cls ) {
		getStateHelper().put(PropertyKeys.cls, cls);
		handleAttribute("cls", cls);
	}
    	/*
	 *The default 
          
            text
           applied when calling 
          
            showBusy
           (defaults to 
          'Loading...'). It can be overridden at any time
          by passing the 
          text argument into 
          
            showBusy
          .
	 */
	
	public String getBusyText () {
		return (String) getStateHelper().eval(PropertyKeys.busyText);
	}

	/**
	 * <p>
	 * Set the value of the <code>busyText</code> property.
	 * </p>
	 */
	public void setBusyText ( String   busyText ) {
		getStateHelper().put(PropertyKeys.busyText, busyText);
		handleAttribute("busyText", busyText);
	}
    	/*
	 *The number of milliseconds to wait
          after setting the status via 
          
            setStatus
           before automatically clearing the status text and
          icon (defaults to 
          5000). Note that this only applies when passing
          the 
          clear argument to 
          
            setStatus
           since that is the only way to defer clearing the
          status. This can be overridden by specifying a different 
          wait value in 
          
            setStatus
          . Calls to 
          
            clearStatus
           always clear the status bar immediately and
          ignore this value.
	 */
	
	public Integer getAutoClear () {
		return (Integer) getStateHelper().eval(PropertyKeys.autoClear);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoClear</code> property.
	 * </p>
	 */
	public void setAutoClear ( Integer   autoClear ) {
		getStateHelper().put(PropertyKeys.autoClear, autoClear);
		handleAttribute("autoClear", autoClear);
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