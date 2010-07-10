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
    Panel is a container that has specific functionality and
    structural components that make it the perfect building block
    for application-oriented user interfaces.
    Panels are, by virtue of their inheritance from 
    Ext.Container, capable of being
    configured with a 
    layout, and
    containing child Components.
    When either specifying child 
    items of a
    Panel, or dynamically 
    adding Components
    to a Panel, remember to consider how you wish the Panel to
    arrange those child elements, and whether those child elements
    need to be sized using one of Ext's built-in 
    
      
        layout
      
     schemes. By default, Panels use the 
    ContainerLayout
    scheme. This simply renders child components, appending them
    one after the other inside the Container, and 
    does not apply any sizing at all.
    A Panel may also contain 
    bottom and 
    top toolbars, along
    with separate 
    header, 
    footer and 
    body sections (see 
    frame for additional
    information).
    Panel also provides built-in 
    expandable and
    collapsible behavior, along with a variety of 
    prebuilt tool
    buttons that can be wired up to provide other customized
    behavior. Panels can be easily dropped into any 
    Container or layout, and the layout
    and rendering pipeline is 
    completely managed by
    the framework.
  
 */
@XType("panel")
@InstanceOf("Ext.Panel")

@FacesComponent(value = "Ext.Panel")
public class Panel extends Container {
	public static final String COMPONENT_FAMILY = "Ext.Panel";

	/**
	 * <p>
	 * Create a new {@link Ext.Panel} instance with default property values.
	 * </p>
	 */
	public Panel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			keys
			,footer
			,bodyStyle
			,padding
			,closable
			,bbarCfg
			,minButtonWidth
			,draggable
			,buttons
			,applyTo
			,autoLoad
			,collapseFirst
			,footerCfg
			,hideCollapseTool
			,fbar
			,tbarCfg
			,bodyBorder
			,shadowOffset
			,bodyCssClass
			,unstyled
			,animCollapse
			,disabled
			,header
			,toolTemplate
			,tbar
			,collapsible
			,tools
			,autoHeight
			,titleCollapse
			,shadow
			,buttonAlign
			,shim
			,title
			,iconCls
			,floating
			,bwrapCfg
			,border
			,headerCfg
			,headerAsText
			,bodyCfg
			,maskDisabled
			,baseCls
			,preventBodyReset
			,frame
			,collapsedCls
			,collapsed
			,resizeEvent
			,bbar
			,elements
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
	 *A 
          Ext.KeyMap config object (in the
          format expected by 
          Ext.KeyMap.addBinding used to
          assign custom key handling to this panel (defaults to 
          null).
	 */
	@ClientConfig(JsonMode.Array)

	public Object getKeys () {
		return (Object) getStateHelper().eval(PropertyKeys.keys);
	}

	/**
	 * <p>
	 * Set the value of the <code>keys</code> property.
	 * </p>
	 */
	public void setKeys ( Object   keys ) {
		getStateHelper().put(PropertyKeys.keys, keys);
		handleAttribute("keys", keys);
	}
    	/*
	 *
          true to create the footer element
          explicitly, false to skip creating it. The footer will be
          created automatically if 
          
            buttons
           or a 
          
            fbar
           have been configured. See 
          
            bodyCfg
           for an example.
	 */
	
	public Boolean getFooter () {
		return (Boolean) getStateHelper().eval(PropertyKeys.footer);
	}

	/**
	 * <p>
	 * Set the value of the <code>footer</code> property.
	 * </p>
	 */
	public void setFooter ( Boolean   footer ) {
		getStateHelper().put(PropertyKeys.footer, footer);
		handleAttribute("footer", footer);
	}
    	/*
	 *Custom CSS styles to be applied to the 
          body element in
          the format expected by 
          Ext.Element.applyStyles
          (defaults to null). See 
          bodyCfg.
	 */
	
	public String getBodyStyle () {
		return (String) getStateHelper().eval(PropertyKeys.bodyStyle);
	}

	/**
	 * <p>
	 * Set the value of the <code>bodyStyle</code> property.
	 * </p>
	 */
	public void setBodyStyle ( String   bodyStyle ) {
		getStateHelper().put(PropertyKeys.bodyStyle, bodyStyle);
		handleAttribute("bodyStyle", bodyStyle);
	}
    	/*
	 *A shortcut for setting a padding style
          on the body element. The value can either be a number to
          be applied to all sides, or a normal css string
          describing padding. Defaults to 
          undefined.
	 */
	
	public String getPadding () {
		return (String) getStateHelper().eval(PropertyKeys.padding);
	}

	/**
	 * <p>
	 * Set the value of the <code>padding</code> property.
	 * </p>
	 */
	public void setPadding ( String   padding ) {
		getStateHelper().put(PropertyKeys.padding, padding);
		handleAttribute("padding", padding);
	}
    	/*
	 *Panels themselves do not directly
          support being closed, but some Panel subclasses do (like 
          Ext.Window) or a Panel Class
          within an 
          Ext.TabPanel. Specify 
          true to enable closing in such situations.
          Defaults to 
          false.
	 */
	
	public Boolean getClosable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.closable);
	}

	/**
	 * <p>
	 * Set the value of the <code>closable</code> property.
	 * </p>
	 */
	public void setClosable ( Boolean   closable ) {
		getStateHelper().put(PropertyKeys.closable, closable);
		handleAttribute("closable", closable);
	}
    	/*
	 *
            A 
            DomHelper element
            specification object specifying the element structure
            of this Panel's 
            bbar Element.
            See 
            
              bodyCfg
             also.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getBbarCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.bbarCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>bbarCfg</code> property.
	 * </p>
	 */
	public void setBbarCfg ( Object   bbarCfg ) {
		getStateHelper().put(PropertyKeys.bbarCfg, bbarCfg);
		handleAttribute("bbarCfg", bbarCfg);
	}
    	/*
	 *
        
        
          minButtonWidth
         : Number
        Minimum width in pixels of all 
        buttons in
        this panel (defaults to 
        75)
	 */
	
	public Integer getMinButtonWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minButtonWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minButtonWidth</code> property.
	 * </p>
	 */
	public void setMinButtonWidth ( Integer   minButtonWidth ) {
		getStateHelper().put(PropertyKeys.minButtonWidth, minButtonWidth);
		handleAttribute("minButtonWidth", minButtonWidth);
	}
    	/*
	 *
            
            true to enable dragging of this Panel
            (defaults to 
            false).
            For custom drag/drop implementations, an 
            Ext.Panel.DD config could also be passed in this
            config instead of 
            true. Ext.Panel.DD is an internal,
            undocumented class which moves a proxy Element around
            in place of the Panel's element, but provides no other
            behaviour during dragging or on drop. It is a subclass
            of 
            Ext.dd.DragSource, so
            behaviour may be added by implementing the interface
            methods of 
            Ext.dd.DragDrop e.g.:


new Ext.Panel({
    title: 
'Drag me',
    x: 100,
    y: 100,
    renderTo: Ext.getBody(),
    floating: true,
    frame: true,
    width: 400,
    height: 200,
    draggable: {
//      Config option of Ext.Panel.DD class.
//      It's a floating Panel, so 
do not show a placeholder proxy 
in the original position.
        insertProxy: false,

//      Called 
for each mousemove event 
while dragging the DD object.
        onDrag : 
function(e){
//          Record the x,y position of the drag proxy so that we
can
//          position the Panel at end of drag.
            
var pel = this.proxy.getEl();
            this.x = pel.getLeft(true);
            this.y = pel.getTop(true);

//          Keep the Shadow aligned 
if there is one.
            
var s = this.panel.getEl().shadow;
            
if (s) {
                s.realign(this.x, this.y, pel.getWidth(),
pel.getHeight());
            }
        },

//      Called on the mouseup event.
        endDrag : 
function(e){
            this.panel.setPosition(this.x, this.y);
        }
    }
}).show();
            
          
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
          buttons will be used as 
          
            items
           for the toolbar in the footer (
          
            fbar
          ). Typically the value of this configuration
          property will be an array of 
          Ext.Buttons or 
          Ext.Button configuration
          objects. If an item is configured with 
          minWidth or the Panel is configured with 
          minButtonWidth, that width will be applied
          to the item.
	 */
	@ClientConfig(JsonMode.Array)

	public Object getButtons () {
		return (Object) getStateHelper().eval(PropertyKeys.buttons);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttons</code> property.
	 * </p>
	 */
	public void setButtons ( Object   buttons ) {
		getStateHelper().put(PropertyKeys.buttons, buttons);
		handleAttribute("buttons", buttons);
	}
    	/*
	 *
            The id of the node, a DOM node or an existing
            Element corresponding to a DIV that is already present
            in the document that specifies some panel-specific
            structural markup. When 
            applyTo is used, constituent parts of the
            panel can be specified by CSS class name within the
            main element, and the panel will automatically create
            those components from that markup. Any required
            components not specified in the markup will be
            autogenerated if necessary.
            The following class names are supported (baseCls
            will be replaced by 
            baseCls):
            
              baseCls + '-header'
              baseCls + '-header-text'
              baseCls + '-bwrap'
              baseCls + '-tbar'
              baseCls + '-body'
              baseCls + '-bbar'
              baseCls + '-footer'
            
            Using this config, a call to render() is not
            required. If applyTo is specified, any value passed for
            
            renderTo
            will be ignored and the target element's parent node
            will automatically be used as the panel's
            container.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getApplyTo () {
		return (Object) getStateHelper().eval(PropertyKeys.applyTo);
	}

	/**
	 * <p>
	 * Set the value of the <code>applyTo</code> property.
	 * </p>
	 */
	public void setApplyTo ( Object   applyTo ) {
		getStateHelper().put(PropertyKeys.applyTo, applyTo);
		handleAttribute("applyTo", applyTo);
	}
    	/*
	 *A valid url spec according to the
          Updater 
          Ext.Updater.update method. If
          autoLoad is not null, the panel will attempt to load its
          contents immediately upon render.
          The URL will become the default URL for this panel's 
          body element,
          so it may be 
          refreshed
          at any time.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getAutoLoad () {
		return (Object) getStateHelper().eval(PropertyKeys.autoLoad);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoLoad</code> property.
	 * </p>
	 */
	public void setAutoLoad ( Object   autoLoad ) {
		getStateHelper().put(PropertyKeys.autoLoad, autoLoad);
		handleAttribute("autoLoad", autoLoad);
	}
    	/*
	 *
          true to make sure the collapse/expand toggle
          button always renders first (to the left of) any other
          tools in the panel's title bar, 
          false to render it last (defaults to 
          true).
	 */
	
	public Boolean getCollapseFirst () {
		return (Boolean) getStateHelper().eval(PropertyKeys.collapseFirst);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapseFirst</code> property.
	 * </p>
	 */
	public void setCollapseFirst ( Boolean   collapseFirst ) {
		getStateHelper().put(PropertyKeys.collapseFirst, collapseFirst);
		handleAttribute("collapseFirst", collapseFirst);
	}
    	/*
	 *
            A 
            DomHelper element
            specification object specifying the element structure
            of this Panel's 
            footer
            Element. See 
            
              bodyCfg
             also.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFooterCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.footerCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>footerCfg</code> property.
	 * </p>
	 */
	public void setFooterCfg ( Object   footerCfg ) {
		getStateHelper().put(PropertyKeys.footerCfg, footerCfg);
		handleAttribute("footerCfg", footerCfg);
	}
    	/*
	 *
        
        
          hideCollapseTool
         : Boolean
        
        true to hide the expand/collapse toggle button
        when 
        
        collapsible == true, 
        false to display it (defaults to 
        false).
	 */
	
	public Boolean getHideCollapseTool () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideCollapseTool);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideCollapseTool</code> property.
	 * </p>
	 */
	public void setHideCollapseTool ( Boolean   hideCollapseTool ) {
		getStateHelper().put(PropertyKeys.hideCollapseTool, hideCollapseTool);
		handleAttribute("hideCollapseTool", hideCollapseTool);
	}
    	/*
	 *
          A 
          Toolbar object, a Toolbar
          config, or an array of 
          Buttons/
          Button configs, describing a 
          Toolbar to be rendered into
          this Panel's footer element.
          After render, the 
          fbar property will be an 
          Toolbar instance.
          If 
          
            buttons
           are specified, they will supersede the 
          fbar configuration property.The Panel's 
          
            buttonAlign
           configuration affects the layout of these items,
          for example: 


var w = 
new Ext.Window({
    height: 250,
    width: 500,
    bbar: 
new Ext.Toolbar({
        items: [{
            text: 
'bbar Left'
        },
'->',{
            text: 
'bbar Right'
        }]
    }),
    
buttonAlign: 
'left', 
// anything but 
'center' or 
'right' and you can use 
'-', and 
'->'
                                  
// to control the alignment of fbar items
    fbar: [{
        text: 
'fbar Left'
    },
'->',{
        text: 
'fbar Right'
    }]
}).show();
          
          
          Note: Although a Toolbar may contain Field
          components, these will 
          not be updated by a load of an ancestor FormPanel.
          A Panel's toolbars are not part of the standard
          Container->Component hierarchy, and so are not scanned
          to collect form items. However, the values 
          will be submitted because form submission
          parameters are collected from the DOM tree.
	 */
	@ClientConfig(JsonMode.Array)

	public Object getFbar () {
		return (Object) getStateHelper().eval(PropertyKeys.fbar);
	}

	/**
	 * <p>
	 * Set the value of the <code>fbar</code> property.
	 * </p>
	 */
	public void setFbar ( Object   fbar ) {
		getStateHelper().put(PropertyKeys.fbar, fbar);
		handleAttribute("fbar", fbar);
	}
    	/*
	 *
            A 
            DomHelper element
            specification object specifying the element structure
            of this Panel's 
            tbar Element.
            See 
            
              bodyCfg
             also.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTbarCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.tbarCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>tbarCfg</code> property.
	 * </p>
	 */
	public void setTbarCfg ( Object   tbarCfg ) {
		getStateHelper().put(PropertyKeys.tbarCfg, tbarCfg);
		handleAttribute("tbarCfg", tbarCfg);
	}
    	/*
	 *True to display an interior border on
          the body element of the panel, false to hide it (defaults
          to true). This only applies when 
          border ==
          true. If border == true and bodyBorder == false, the
          border will display as a 1px wide inset border, giving
          the entire body element an inset appearance.
	 */
	
	public Boolean getBodyBorder () {
		return (Boolean) getStateHelper().eval(PropertyKeys.bodyBorder);
	}

	/**
	 * <p>
	 * Set the value of the <code>bodyBorder</code> property.
	 * </p>
	 */
	public void setBodyBorder ( Boolean   bodyBorder ) {
		getStateHelper().put(PropertyKeys.bodyBorder, bodyBorder);
		handleAttribute("bodyBorder", bodyBorder);
	}
    	/*
	 *The number of pixels to offset the
          shadow if displayed (defaults to 
          4). Note that this option only applies when 
          
          floating =
          true.
	 */
	
	public Integer getShadowOffset () {
		return (Integer) getStateHelper().eval(PropertyKeys.shadowOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>shadowOffset</code> property.
	 * </p>
	 */
	public void setShadowOffset ( Integer   shadowOffset ) {
		getStateHelper().put(PropertyKeys.shadowOffset, shadowOffset);
		handleAttribute("shadowOffset", shadowOffset);
	}
    	/*
	 *Additional css class selector to be
          applied to the 
          body element in
          the format expected by 
          Ext.Element.addClass (defaults
          to null). See 
          bodyCfg.
	 */
	
	public String getBodyCssClass () {
		return (String) getStateHelper().eval(PropertyKeys.bodyCssClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>bodyCssClass</code> property.
	 * </p>
	 */
	public void setBodyCssClass ( String   bodyCssClass ) {
		getStateHelper().put(PropertyKeys.bodyCssClass, bodyCssClass);
		handleAttribute("bodyCssClass", bodyCssClass);
	}
    	/*
	 *Overrides the 
          
            baseCls
           setting to 
          
          baseCls = 
          'x-plain' which renders the panel
          unstyled except for required attributes for Ext layouts
          to function (e.g. overflow:hidden).
	 */
	
	public Boolean getUnstyled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.unstyled);
	}

	/**
	 * <p>
	 * Set the value of the <code>unstyled</code> property.
	 * </p>
	 */
	public void setUnstyled ( Boolean   unstyled ) {
		getStateHelper().put(PropertyKeys.unstyled, unstyled);
		handleAttribute("unstyled", unstyled);
	}
    	/*
	 *
          true to animate the transition when the
          panel is collapsed, 
          false to skip the animation (defaults to 
          true if the 
          Ext.Fx
          class is available, otherwise 
          false).
	 */
	
	public Boolean getAnimCollapse () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animCollapse);
	}

	/**
	 * <p>
	 * Set the value of the <code>animCollapse</code> property.
	 * </p>
	 */
	public void setAnimCollapse ( Boolean   animCollapse ) {
		getStateHelper().put(PropertyKeys.animCollapse, animCollapse);
		handleAttribute("animCollapse", animCollapse);
	}
    	/*
	 *Render this panel disabled (default is 
          false). An important note when using the
          disabled config on panels is that IE will often fail to
          initialize the disabled mask element correectly if the
          panel's layout has not yet completed by the time the
          Panel is disabled during the render process. If you
          experience this issue, you may need to instead use the 
          afterlayout event to initialize
          the disabled state: 


new Ext.Panel({
    ...
    listeners: {
        
'afterlayout': {
            fn: 
function(p){
                p.disable();
            },
            single: true 
// important, as many layouts can occur
        }
    }
});
          
	 */
	
	public Boolean getDisabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setDisabled ( Boolean   disabled ) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
		handleAttribute("disabled", disabled);
	}
    	/*
	 *
          true to create the Panel's header element
          explicitly, 
          false to skip creating it. If a 
          
            title
           is set the header will be created automatically,
          otherwise it will not. If a 
          
            title
           is set but 
          header is explicitly set to 
          false, the header will not be
          rendered.
	 */
	
	public Boolean getHeader () {
		return (Boolean) getStateHelper().eval(PropertyKeys.header);
	}

	/**
	 * <p>
	 * Set the value of the <code>header</code> property.
	 * </p>
	 */
	public void setHeader ( Boolean   header ) {
		getStateHelper().put(PropertyKeys.header, header);
		handleAttribute("header", header);
	}
    	/*
	 *
            A Template used to create 
            tools in the
            
            header
            Element. Defaults to:


new Ext.Template(
'<div class="x-tool
x-tool-{id}">&#160;</div>')
            
            This may may be overridden to provide a custom DOM
            structure for tools based upon a more complex
            XTemplate. The template's data is a single tool
            configuration object (Not the entire Array) as
            specified in 
            tools. In
            the following example an <a> tag is used to
            provide a visual indication when hovering over the
            tool:


var win = 
new Ext.Window({
    tools: [{
        id: 
'download',
        href: 
'/MyPdfDoc.pdf'
    }],
    toolTemplate: 
new Ext.XTemplate(
        
'<tpl 
if="id==\'download\
'">',
            
'<a class="x-tool x-tool-pdf" href=
"{href}"></a>',
        
'</tpl>',
        
'<tpl 
if="id!=\'download\
'">',
            
'<div class="x-tool
x-tool-{id}">&#160;</div>',
        
'</tpl>'
    ),
    width:500,
    height:300,
    closeAction:
'hide'
});
            
            Note that the CSS class 'x-tool-pdf' should have an
            associated style rule which provides an appropriate
            background image, something like:

a.x-tool-pdf {background-image:
url(../shared/extjs/images/pdf.gif)!important;}
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getToolTemplate () {
		return (Object) getStateHelper().eval(PropertyKeys.toolTemplate);
	}

	/**
	 * <p>
	 * Set the value of the <code>toolTemplate</code> property.
	 * </p>
	 */
	public void setToolTemplate ( Object   toolTemplate ) {
		getStateHelper().put(PropertyKeys.toolTemplate, toolTemplate);
		handleAttribute("toolTemplate", toolTemplate);
	}
    	/*
	 *
            The top toolbar of the panel. This can be a 
            Ext.Toolbar object, a toolbar
            config, or an array of buttons/button configs to be
            added to the toolbar. Note that this is not available
            as a property after render. To access the top toolbar
            after render, use 
            getTopToolbar.
            
            Note: Although a Toolbar may contain Field
            components, these will 
            not be updated by a load of an ancestor
            FormPanel. A Panel's toolbars are not part of the
            standard Container->Component hierarchy, and so are
            not scanned to collect form items. However, the values 
            will be submitted because form submission
            parameters are collected from the DOM tree.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTbar () {
		return (Object) getStateHelper().eval(PropertyKeys.tbar);
	}

	/**
	 * <p>
	 * Set the value of the <code>tbar</code> property.
	 * </p>
	 */
	public void setTbar ( Object   tbar ) {
		getStateHelper().put(PropertyKeys.tbar, tbar);
		handleAttribute("tbar", tbar);
	}
    	/*
	 *True to make the panel collapsible and
          have the expand/collapse toggle button automatically
          rendered into the header tool button area, false to keep
          the panel statically sized with no button (defaults to
          false).
	 */
	
	public Boolean getCollapsible () {
		return (Boolean) getStateHelper().eval(PropertyKeys.collapsible);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsible</code> property.
	 * </p>
	 */
	public void setCollapsible ( Boolean   collapsible ) {
		getStateHelper().put(PropertyKeys.collapsible, collapsible);
		handleAttribute("collapsible", collapsible);
	}
    	/*
	 *An array of tool button configs to be
          added to the header tool area. When rendered, each tool
          is stored as an 
          Element referenced by a public
          property called 
          tools.
          <tool-type> 
          Each tool config may contain the following
          properties:
          
            
              
              id : String
              
              Required. The type of tool to create. By
              default, this assigns a CSS class of the form 
              x-tool-
              <tool-type> to the resulting tool
              Element. Ext provides CSS rules, and an icon sprite
              containing images for the tool types listed below.
              The developer may implement custom tools by supplying
              alternate CSS rules and background images: 
              
                
                toggle (Created by default when 
                collapsible is 
                true)
                
                  close
                
                
                  minimize
                
                
                  maximize
                
                
                  restore
                
                
                  gear
                
                
                  pin
                
                
                  unpin
                
                
                  right
                
                
                  left
                
                
                  up
                
                
                  down
                
                
                  refresh
                
                
                  minus
                
                
                  plus
                
                
                  help
                
                
                  search
                
                
                  save
                
                
                  print
                
              
              
              handler : Function
              
              Required. The function to call when clicked.
              Arguments passed are:
              
                
                event : Ext.EventObject
                The click event.
                
                toolEl : Ext.Element
                The tool Element.
                
                panel : Ext.Panel
                The host Panel
                
                tc : Object
                The tool configuration
                object
              
              
              stopEvent : Boolean
              Defaults to true. Specify as
              false to allow click event to propagate.
              
              scope : Object
              The scope in which to call the
              handler.
              
              qtip : String/Object
              A tip string, or a config
              argument to 
              Ext.QuickTip.register
              
              hidden : Boolean
              True to initially render
              hidden.
              
              on : Object
              A listener config object
              specifiying event listeners in the format of an
              argument to 
              addListener
            
          
          Note that, apart from the toggle tool which is
          provided when a panel is collapsible, these tools only
          provide the visual button. Any required functionality
          must be provided by adding handlers that implement the
          necessary behavior.
          Example usage:

tools:[{
    id:
'refresh',
    qtip: 
'Refresh form Data',
    
// hidden:true,
    handler: 
function(event, toolEl, panel){
        
// refresh logic
    }
},
{
    id:
'help',
    qtip: 
'Get Help',
    handler: 
function(event, toolEl, panel){
        
// whatever
    }
}]
          
          For the custom id of 
          
            'help'
           define two relevant css classes with a link to a
          15x15 image:

.x-tool-help {background-image: url(images/help.png);}
.x-tool-help-over {background-image: url(images/help_over.png);}
// 
if using an image sprite:
.x-tool-help {background-image: url(images/help.png) no-repeat 0
0;}
.x-tool-help-over {background-position:-15px 0;}
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getTools () {
		return (Object) getStateHelper().eval(PropertyKeys.tools);
	}

	/**
	 * <p>
	 * Set the value of the <code>tools</code> property.
	 * </p>
	 */
	public void setTools ( Object   tools ) {
		getStateHelper().put(PropertyKeys.tools, tools);
		handleAttribute("tools", tools);
	}
    	/*
	 *
          true to use height:'auto', 
          false to use fixed height (defaults to 
          false). 
          Note: Setting 
          autoHeight: true means that the browser will
          manage the panel's height based on its contents, and that
          Ext will not manage it at all. If the panel is within a
          layout that manages dimensions (
          fit, 
          border, etc.) then setting 
          autoHeight: true can cause issues with
          scrolling and will not generally work as expected since
          the panel will take on the height of its contents rather
          than the height required by the Ext layout.
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
          true to allow expanding and collapsing the
          panel (when 
          
          collapsible = true) by
          clicking anywhere in the header bar, 
          false) to allow it only by clicking to tool
          button (defaults to 
          false)). If this panel is a child item of a
          border layout also see the 
          BorderLayout.Region
          
          
            floatable
           config option.
	 */
	
	public Boolean getTitleCollapse () {
		return (Boolean) getStateHelper().eval(PropertyKeys.titleCollapse);
	}

	/**
	 * <p>
	 * Set the value of the <code>titleCollapse</code> property.
	 * </p>
	 */
	public void setTitleCollapse ( Boolean   titleCollapse ) {
		getStateHelper().put(PropertyKeys.titleCollapse, titleCollapse);
		handleAttribute("titleCollapse", titleCollapse);
	}
    	/*
	 *
          true (or a valid Ext.Shadow 
          Ext.Shadow.mode value) to
          display a shadow behind the panel, 
          false to display no shadow (defaults to 
          
            'sides'
          ). Note that this option only applies when 
          
          floating =
          true.
	 */
	
	public Boolean getShadow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.shadow);
	}

	/**
	 * <p>
	 * Set the value of the <code>shadow</code> property.
	 * </p>
	 */
	public void setShadow ( Boolean   shadow ) {
		getStateHelper().put(PropertyKeys.shadow, shadow);
		handleAttribute("shadow", shadow);
	}
    	/*
	 *The alignment of any 
          buttons
          added to this panel. Valid values are 
          
            'right'
          , 
          
            'left'
           and 
          
            'center'
           (defaults to 
          
            'right'
          ).
	 */
	
	public String getButtonAlign () {
		return (String) getStateHelper().eval(PropertyKeys.buttonAlign);
	}

	/**
	 * <p>
	 * Set the value of the <code>buttonAlign</code> property.
	 * </p>
	 */
	public void setButtonAlign ( String   buttonAlign ) {
		getStateHelper().put(PropertyKeys.buttonAlign, buttonAlign);
		handleAttribute("buttonAlign", buttonAlign);
	}
    	/*
	 *
          false to disable the iframe shim in browsers
          which need one (defaults to 
          true). Note that this option only applies
          when 
          
          floating =
          true.
	 */
	
	public Boolean getShim () {
		return (Boolean) getStateHelper().eval(PropertyKeys.shim);
	}

	/**
	 * <p>
	 * Set the value of the <code>shim</code> property.
	 * </p>
	 */
	public void setShim ( Boolean   shim ) {
		getStateHelper().put(PropertyKeys.shim, shim);
		handleAttribute("shim", shim);
	}
    	/*
	 *The title text to be used as innerHTML
          (html tags are accepted) to display in the panel 
          
            header
           (defaults to ''). When a 
          title is specified the 
          
            header
           element will automatically be created and
          displayed unless 
          header is
          explicitly set to 
          false. If you do not want to specify a 
          title at config time, but you may want one
          later, you must either specify a non-empty 
          title (a blank space ' ' will do) or 
          header:true so that the container element
          will get created.
	 */
	
	public String getTitle () {
		return (String) getStateHelper().eval(PropertyKeys.title);
	}

	/**
	 * <p>
	 * Set the value of the <code>title</code> property.
	 * </p>
	 */
	public void setTitle ( String   title ) {
		getStateHelper().put(PropertyKeys.title, title);
		handleAttribute("title", title);
	}
    	/*
	 *The CSS class selector that specifies a
          background image to be used as the header icon (defaults
          to ''). 
          An example of specifying a custom icon class would be
          something like:


// specify the property 
in the config 
for the class:
     ...
     iconCls: 
'my-icon'

// css class that specifies background image to be used as the
icon image:
.my-icon { background-image: url(../images/my-icon.gif) 0 6px
no-repeat !important; }
          
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
	 *
            This property is used to configure the underlying 
            Ext.Layer. Acceptable values
            for this configuration property are:
            
              
                
                
                  false
                 : 
                Default.
                Display the panel inline
                where it is rendered.
                
                
                  true
                 : 
                Float the panel (absolute
                position it with automatic shimming and shadow).
                
                  Setting floating to true
                  will create an Ext.Layer for this panel and
                  display the panel at negative offsets so that it
                  is hidden.
                  Since the panel will be
                  absolute positioned, the position must be set
                  explicitly 
                  after render (e.g., 
                  myPanel.setPosition(100,100);).
                  
                  Note: when floating a panel you should
                  always assign a fixed width, otherwise it will be
                  auto width and will expand to fill to the right
                  edge of the viewport.
                
                
                
                  
                    object
                  
                 : 
                The specified object will be
                used as the configuration object for the 
                Ext.Layer that will be
                created.
              
            
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getFloating () {
		return (Object) getStateHelper().eval(PropertyKeys.floating);
	}

	/**
	 * <p>
	 * Set the value of the <code>floating</code> property.
	 * </p>
	 */
	public void setFloating ( Object   floating ) {
		getStateHelper().put(PropertyKeys.floating, floating);
		handleAttribute("floating", floating);
	}
    	/*
	 *
            A 
            DomHelper element
            specification object specifying the element structure
            of this Panel's 
            bwrap
            Element. See 
            
              bodyCfg
             also.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getBwrapCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.bwrapCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>bwrapCfg</code> property.
	 * </p>
	 */
	public void setBwrapCfg ( Object   bwrapCfg ) {
		getStateHelper().put(PropertyKeys.bwrapCfg, bwrapCfg);
		handleAttribute("bwrapCfg", bwrapCfg);
	}
    	/*
	 *True to display the borders of the
          panel's body element, false to hide them (defaults to
          true). By default, the border is a 2px wide inset border,
          but this can be further altered by setting 
          bodyBorder to false.
	 */
	
	public Boolean getBorder () {
		return (Boolean) getStateHelper().eval(PropertyKeys.border);
	}

	/**
	 * <p>
	 * Set the value of the <code>border</code> property.
	 * </p>
	 */
	public void setBorder ( Boolean   border ) {
		getStateHelper().put(PropertyKeys.border, border);
		handleAttribute("border", border);
	}
    	/*
	 *
            A 
            DomHelper element
            specification object specifying the element structure
            of this Panel's 
            header
            Element. See 
            
              bodyCfg
             also.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getHeaderCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.headerCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>headerCfg</code> property.
	 * </p>
	 */
	public void setHeaderCfg ( Object   headerCfg ) {
		getStateHelper().put(PropertyKeys.headerCfg, headerCfg);
		handleAttribute("headerCfg", headerCfg);
	}
    	/*
	 *
        
        
          headerAsText
         : Boolean
        
        true to display the panel 
        
          title
         in the 
        
          header
        , 
        false to hide it (defaults to 
        true).
	 */
	
	public Boolean getHeaderAsText () {
		return (Boolean) getStateHelper().eval(PropertyKeys.headerAsText);
	}

	/**
	 * <p>
	 * Set the value of the <code>headerAsText</code> property.
	 * </p>
	 */
	public void setHeaderAsText ( Boolean   headerAsText ) {
		getStateHelper().put(PropertyKeys.headerAsText, headerAsText);
		handleAttribute("headerAsText", headerAsText);
	}
    	/*
	 *
            A 
            DomHelper element
            specification object may be specified for any Panel
            Element.
            By default, the Default element in the table below
            will be used for the html markup to create a child
            element with the commensurate Default class name (
            baseCls will be replaced by 
            
              baseCls
            ):

Panel      Default  Default             Custom      Additional     
 Additional
Element    element  class               element     class          
 style
========   ==========================   =========   ============== 
 ===========
header     div      
baseCls+'-header'   
headerCfg  
headerCssClass   headerStyle
bwrap      div      
baseCls+'-bwrap'     
bwrapCfg   
bwrapCssClass    bwrapStyle
+ tbar     div      
baseCls+'-tbar'       
tbarCfg    
tbarCssClass     tbarStyle
+ 
body     div      
baseCls+'-body'       
bodyCfg     
bodyCssClass     
bodyStyle
+ bbar     div      
baseCls+'-bbar'       
bbarCfg    
bbarCssClass     bbarStyle
+ 
footer   div      
baseCls+'-footer'   
footerCfg  
footerCssClass   footerStyle
            
            Configuring a Custom element may be used, for
            example, to force the 
            body Element
            to use a different form of markup than is created by
            default. An example of this might be to 
            create a
            child Panel containing a custom content, such as a
            header, or forcing centering of all Panel content by
            having the body be a <center> element:


new Ext.Panel({
    title: 
'Message Title',
    renderTo: Ext.getBody(),
    width: 200, height: 130,
    
bodyCfg: {
        tag: 
'center',
        cls: 
'x-panel-body',  
// Default class not applied 
if Custom element specified
        html: 
'Message'
    },
    footerCfg: {
        tag: 
'h2',
        cls: 
'x-panel-footer'        
// same as the Default class
        html: 
'footer html'
    },
    footerCssClass: 
'custom-footer', 
// additional css class, see 
addClass
    footerStyle:    
'background-color:red' 
// see 
bodyStyle
});
            
            The example above also explicitly creates a 
            
              footer
             with custom markup and styling applied.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getBodyCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.bodyCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>bodyCfg</code> property.
	 * </p>
	 */
	public void setBodyCfg ( Object   bodyCfg ) {
		getStateHelper().put(PropertyKeys.bodyCfg, bodyCfg);
		handleAttribute("bodyCfg", bodyCfg);
	}
    	/*
	 *
          true to mask the panel when it is 
          disabled, 
          false to not mask it (defaults to 
          true). Either way, the panel will always
          tell its contained elements to disable themselves when it
          is disabled, but masking the panel can provide an
          additional visual cue that the panel is disabled.
	 */
	
	public Boolean getMaskDisabled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.maskDisabled);
	}

	/**
	 * <p>
	 * Set the value of the <code>maskDisabled</code> property.
	 * </p>
	 */
	public void setMaskDisabled ( Boolean   maskDisabled ) {
		getStateHelper().put(PropertyKeys.maskDisabled, maskDisabled);
		handleAttribute("maskDisabled", maskDisabled);
	}
    	/*
	 *The base CSS class to apply to this
          panel's element (defaults to 
          
            'x-panel'
          ). 
          Another option available by default is to specify 
          
            'x-plain'
           which strips all styling except for required
          attributes for Ext layouts to function (e.g.
          overflow:hidden). See 
          
            unstyled
           also.
	 */
	
	public String getBaseCls () {
		return (String) getStateHelper().eval(PropertyKeys.baseCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>baseCls</code> property.
	 * </p>
	 */
	public void setBaseCls ( String   baseCls ) {
		getStateHelper().put(PropertyKeys.baseCls, baseCls);
		handleAttribute("baseCls", baseCls);
	}
    	/*
	 *Defaults to 
          false. When set to 
          true, an extra css class 
          
            'x-panel-normal'
           will be added to the panel's element, effectively
          applying css styles suggested by the W3C (see
          http://www.w3.org/TR/CSS21/sample.html) to the Panel's 
          body element (not the header, footer, etc.).
	 */
	
	public Boolean getPreventBodyReset () {
		return (Boolean) getStateHelper().eval(PropertyKeys.preventBodyReset);
	}

	/**
	 * <p>
	 * Set the value of the <code>preventBodyReset</code> property.
	 * </p>
	 */
	public void setPreventBodyReset ( Boolean   preventBodyReset ) {
		getStateHelper().put(PropertyKeys.preventBodyReset, preventBodyReset);
		handleAttribute("preventBodyReset", preventBodyReset);
	}
    	/*
	 *
          false by default to render with plain 1px
          square borders. 
          true to render with 9 elements, complete
          with custom rounded corners (also see 
          Ext.Element.boxWrap). 
          The template generated for each condition is depicted
          below:


// frame = false
<div id=
"developer-specified-id-goes-here" class=
"x-panel">

    <div class=
"x-panel-header"><span class=
"x-panel-header-text">Title:
(frame:false)</span></div>

    <div class=
"x-panel-bwrap">
        <div class=
"x-panel-body"><p>html value goes
here</p></div>
    </div>
</div>

// frame = true (create 9 elements)
<div id=
"developer-specified-id-goes-here" class=
"x-panel">
    <div class=
"x-panel-tl"><div class=
"x-panel-tr"><div class=
"x-panel-tc">
        <div class=
"x-panel-header"><span class=
"x-panel-header-text">Title:
(frame:true)</span></div>
    </div></div></div>

    <div class=
"x-panel-bwrap">
        <div class=
"x-panel-ml"><div class=
"x-panel-mr"><div class=
"x-panel-mc">
            <div class=
"x-panel-body"><p>html value goes
here</p></div>
        </div></div></div>

        <div class=
"x-panel-bl"><div class=
"x-panel-br"><div class=
"x-panel-bc"/>
        </div></div></div>
</div>
          
	 */
	
	public Boolean getFrame () {
		return (Boolean) getStateHelper().eval(PropertyKeys.frame);
	}

	/**
	 * <p>
	 * Set the value of the <code>frame</code> property.
	 * </p>
	 */
	public void setFrame ( Boolean   frame ) {
		getStateHelper().put(PropertyKeys.frame, frame);
		handleAttribute("frame", frame);
	}
    	/*
	 *
        
        
          collapsedCls
         : String
        A CSS class to add to the panel's
        element after it has been collapsed (defaults to 
        
          'x-panel-collapsed'
        ).
	 */
	
	public String getCollapsedCls () {
		return (String) getStateHelper().eval(PropertyKeys.collapsedCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsedCls</code> property.
	 * </p>
	 */
	public void setCollapsedCls ( String   collapsedCls ) {
		getStateHelper().put(PropertyKeys.collapsedCls, collapsedCls);
		handleAttribute("collapsedCls", collapsedCls);
	}
    	/*
	 *
        
        
          collapsed
         : Boolean
        
        true to render the panel collapsed, 
        false to render it expanded (defaults to 
        false).
	 */
	
	public Boolean getCollapsed () {
		return (Boolean) getStateHelper().eval(PropertyKeys.collapsed);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapsed</code> property.
	 * </p>
	 */
	public void setCollapsed ( Boolean   collapsed ) {
		getStateHelper().put(PropertyKeys.collapsed, collapsed);
		handleAttribute("collapsed", collapsed);
	}
    	/*
	 *
        
        
          resizeEvent
         : String
        The event to listen to for resizing in
        layouts. Defaults to 
        'bodyresize'.
	 */
	
	public String getResizeEvent () {
		return (String) getStateHelper().eval(PropertyKeys.resizeEvent);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizeEvent</code> property.
	 * </p>
	 */
	public void setResizeEvent ( String   resizeEvent ) {
		getStateHelper().put(PropertyKeys.resizeEvent, resizeEvent);
		handleAttribute("resizeEvent", resizeEvent);
	}
    	/*
	 *
            The bottom toolbar of the panel. This can be a 
            Ext.Toolbar object, a toolbar
            config, or an array of buttons/button configs to be
            added to the toolbar. Note that this is not available
            as a property after render. To access the bottom
            toolbar after render, use 
            getBottomToolbar.
            
            Note: Although a Toolbar may contain Field
            components, these will 
            not be updated by a load of an ancestor
            FormPanel. A Panel's toolbars are not part of the
            standard Container->Component hierarchy, and so are
            not scanned to collect form items. However, the values 
            will be submitted because form submission
            parameters are collected from the DOM tree.
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getBbar () {
		return (Object) getStateHelper().eval(PropertyKeys.bbar);
	}

	/**
	 * <p>
	 * Set the value of the <code>bbar</code> property.
	 * </p>
	 */
	public void setBbar ( Object   bbar ) {
		getStateHelper().put(PropertyKeys.bbar, bbar);
		handleAttribute("bbar", bbar);
	}
    	/*
	 *A comma-delimited list of panel
          elements to initialize when the panel is rendered.
          Normally, this list will be generated automatically based
          on the items added to the panel at config time, but
          sometimes it might be useful to make sure a structural
          element is rendered even if not specified at config time
          (for example, you may want to add a button or toolbar
          dynamically after the panel has been rendered). Adding
          those elements to this list will allocate the required
          placeholders in the panel when it is rendered. Valid
          values are
          
            
              
                header
              
              
              tbar (top bar)
              
                body
              
              
              bbar (bottom bar)
              
                footer
              
            
          Defaults to '
          body'.
	 */
	
	public String getElements () {
		return (String) getStateHelper().eval(PropertyKeys.elements);
	}

	/**
	 * <p>
	 * Set the value of the <code>elements</code> property.
	 * </p>
	 */
	public void setElements ( String   elements ) {
		getStateHelper().put(PropertyKeys.elements, elements);
		handleAttribute("elements", elements);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "activate"
					, "beforeclose"
					, "beforecollapse"
					, "beforeexpand"
					, "bodyresize"
					, "close"
					, "collapse"
					, "deactivate"
					, "expand"
					, "iconchange"
					, "titlechange"
				));
				return superEvent;
	}
}