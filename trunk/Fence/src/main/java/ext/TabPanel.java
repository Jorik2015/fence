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
  A basic tab container. TabPanels can be used exactly like a
  standard 
  Ext.Panel
  for layout purposes, but also have special support for containing
  child Components (
  
    items
  ) that are managed using a 
  CardLayout layout manager,
  and displayed as separate tabs.
  Note: By default, a tab's close tool 
  destroys the child tab Component and all its descendants.
  This makes the child tab Component, and all its descendants 
  unusable. To enable re-use of a tab, configure the
  TabPanel with 
  
    
      autoDestroy:
      false
    
  . 
  
    
      TabPanel header/footer elements
    
  
  TabPanels use their 
  header or 
  footer element
  (depending on the 
  tabPosition
  configuration) to accommodate the tab selector buttons. This
  means that a TabPanel will not display any configured title, and
  will not display any configured header 
  tools.
  To display a header, embed the TabPanel in a 
  Panel
  which uses 
  
    
      layout:'fit'
    
  .
  
    
      Tab Events
    
  
  There is no actual tab class — each tab is simply a 
  Component such as a 
  Panel.
  However, when rendered in a TabPanel, each child Component can
  fire additional events that only exist for tabs and are not
  available from other Components. These events are:
  
    
      
      
        
          activate
        
       : Fires when this Component becomes the active
      tab.
      
      
        
          deactivate
        
       : Fires when the Component that was the active tab
      becomes deactivated.
      
      
        
          beforeclose
        
       : Fires when the user clicks on the close tool of a
      closeable tab. May be vetoed by returning 
      false from a handler.
      
      
        
          close
        
       : Fires a closeable tab has been closed by the
      user.
    
  
  
    
      Creating TabPanels from Code
    
  
  TabPanels can be created and rendered completely in code, as
  in this example:


var tabs = 
new Ext.TabPanel({
    renderTo: Ext.getBody(),
    activeTab: 0,
    items: [{
        title: 
'Tab 1',
        html: 
'A simple tab'
    },{
        title: 
'Tab 2',
        html: 
'Another one'
    }]
});
  
  
    
      Creating TabPanels from Existing Markup
    
  
  TabPanels can also be rendered from pre-existing markup in a
  couple of ways.
  
    
      Pre-Structured Markup
      
        
          A container div with one or more nested tab divs with
          class 
          'x-tab' can be rendered entirely from existing
          markup (See the 
          autoTabs
          example).
        
      
      Un-Structured Markup
      
        
        A TabPanel can also be rendered from markup that is not
        strictly structured by simply specifying by id which
        elements should be the container and the tabs. Using this
        method tab content can be pulled from different elements
        within the page by id regardless of page structure. For
        example:


var tabs = 
new Ext.TabPanel({
    renderTo: 
'my-tabs',
    activeTab: 0,
    items:[
        {contentEl:
'tab1', title:
'Tab 1'},
        {contentEl:
'tab2', title:
'Tab 2'}
    ]
});

// Note that the tabs 
do not have to be nested within the container (although they
can be)
<div id=
"my-tabs"></div>
<div id=
"tab1" class=
"x-hide-display">A simple tab</div>
<div id=
"tab2" class=
"x-hide-display">Another one</div>
        Note that the tab divs in this example contain the
        class 
        'x-hide-display' so that they can be rendered
        deferred without displaying outside the tabs. You could
        alternately set 
        
        deferredRender = false to
        render all content tabs on page load.
      
    
  
 */
@XType("tabpanel")
@InstanceOf("Ext.TabPanel")

@FacesComponent(value = "Ext.TabPanel")
public class TabPanel extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.TabPanel";

	/**
	 * <p>
	 * Create a new {@link Ext.TabPanel} instance with default property values.
	 * </p>
	 */
	public TabPanel() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			wheelIncrement
			,scrollDuration
			,tabCls
			,autoTabSelector
			,tabWidth
			,layoutConfig
			,plain
			,layoutOnTabChange
			,scrollIncrement
			,activeTab
			,baseCls
			,enableTabScroll
			,minTabWidth
			,tabPosition
			,itemTpl
			,animScroll
			,autoTabs
			,deferredRender
			,resizeTabs
			,tabMargin
			,scrollRepeatInterval
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
        
        
          wheelIncrement
         : Number
        For scrolling tabs, the number of pixels
        to increment on mouse wheel scrolling (defaults to 
        20).
	 */
	
	public Integer getWheelIncrement () {
		return (Integer) getStateHelper().eval(PropertyKeys.wheelIncrement);
	}

	/**
	 * <p>
	 * Set the value of the <code>wheelIncrement</code> property.
	 * </p>
	 */
	public void setWheelIncrement ( Integer   wheelIncrement ) {
		getStateHelper().put(PropertyKeys.wheelIncrement, wheelIncrement);
		handleAttribute("wheelIncrement", wheelIncrement);
	}
    	/*
	 *The number of milliseconds that each
          scroll animation should last (defaults to 
          .35). Only applies when 
          
          animScroll = true.
	 */
	
	public Float getScrollDuration () {
		return (Float) getStateHelper().eval(PropertyKeys.scrollDuration);
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollDuration</code> property.
	 * </p>
	 */
	public void setScrollDuration ( Float   scrollDuration ) {
		getStateHelper().put(PropertyKeys.scrollDuration, scrollDuration);
		handleAttribute("scrollDuration", scrollDuration);
	}
    	/*
	 *
          This config option is used on 
          child Components of ths TabPanel. A CSS class
          name applied to the tab strip item representing the child
          Component, allowing special styling to be applied.
	 */
	
	public String getTabCls () {
		return (String) getStateHelper().eval(PropertyKeys.tabCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>tabCls</code> property.
	 * </p>
	 */
	public void setTabCls ( String   tabCls ) {
		getStateHelper().put(PropertyKeys.tabCls, tabCls);
		handleAttribute("tabCls", tabCls);
	}
    	/*
	 *The CSS selector used to search for
          tabs in existing markup when 
          
          autoTabs
          = true (defaults to 
          'div.x-tab'). This can be any valid selector
          supported by 
          Ext.DomQuery.select. Note that
          the query will be executed within the scope of this tab
          panel only (so that multiple tab panels from markup can
          be supported on a page).
	 */
	
	public String getAutoTabSelector () {
		return (String) getStateHelper().eval(PropertyKeys.autoTabSelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoTabSelector</code> property.
	 * </p>
	 */
	public void setAutoTabSelector ( String   autoTabSelector ) {
		getStateHelper().put(PropertyKeys.autoTabSelector, autoTabSelector);
		handleAttribute("autoTabSelector", autoTabSelector);
	}
    	/*
	 *
        
        
          tabWidth
         : Number
        The initial width in pixels of each new
        tab (defaults to 120).
	 */
	
	public Integer getTabWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.tabWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>tabWidth</code> property.
	 * </p>
	 */
	public void setTabWidth ( Integer   tabWidth ) {
		getStateHelper().put(PropertyKeys.tabWidth, tabWidth);
		handleAttribute("tabWidth", tabWidth);
	}
    	/*
	 *TabPanel implicitly uses 
          Ext.layout.CardLayout
          as its layout manager. 
          layoutConfig may be used to configure this
          layout manager. 
          
            deferredRender
           and 
          
            layoutOnTabChange
           configured on the TabPanel will be applied as
          configs to the layout manager.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getLayoutConfig () {
		return (Object) getStateHelper().eval(PropertyKeys.layoutConfig);
	}

	/**
	 * <p>
	 * Set the value of the <code>layoutConfig</code> property.
	 * </p>
	 */
	public void setLayoutConfig ( Object   layoutConfig ) {
		getStateHelper().put(PropertyKeys.layoutConfig, layoutConfig);
		handleAttribute("layoutConfig", layoutConfig);
	}
    	/*
	 *
        
        
          plain
         : Boolean
        true to render the tab strip without a
        background container image (defaults to 
        false).
	 */
	
	public Boolean getPlain () {
		return (Boolean) getStateHelper().eval(PropertyKeys.plain);
	}

	/**
	 * <p>
	 * Set the value of the <code>plain</code> property.
	 * </p>
	 */
	public void setPlain ( Boolean   plain ) {
		getStateHelper().put(PropertyKeys.plain, plain);
		handleAttribute("plain", plain);
	}
    	/*
	 *Set to true to force a layout of the
          active tab when the tab is changed. Defaults to false.
          See 
          Ext.layout.CardLayout.
          
            layoutOnCardChange
          .
	 */
	
	public Boolean getLayoutOnTabChange () {
		return (Boolean) getStateHelper().eval(PropertyKeys.layoutOnTabChange);
	}

	/**
	 * <p>
	 * Set the value of the <code>layoutOnTabChange</code> property.
	 * </p>
	 */
	public void setLayoutOnTabChange ( Boolean   layoutOnTabChange ) {
		getStateHelper().put(PropertyKeys.layoutOnTabChange, layoutOnTabChange);
		handleAttribute("layoutOnTabChange", layoutOnTabChange);
	}
    	/*
	 *The number of pixels to scroll each
          time a tab scroll button is pressed (defaults to 
          100, or if 
          
          resizeTabs = true, the
          calculated tab width). Only applies when 
          
          enableTabScroll =
          true.
	 */
	
	public Integer getScrollIncrement () {
		return (Integer) getStateHelper().eval(PropertyKeys.scrollIncrement);
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollIncrement</code> property.
	 * </p>
	 */
	public void setScrollIncrement ( Integer   scrollIncrement ) {
		getStateHelper().put(PropertyKeys.scrollIncrement, scrollIncrement);
		handleAttribute("scrollIncrement", scrollIncrement);
	}
    	/*
	 *
        
        
          activeTab
         : String/Number
        A string id or the numeric index of the
        tab that should be initially activated on render (defaults
        to undefined).
	 */
	
	public String getActiveTab () {
		return (String) getStateHelper().eval(PropertyKeys.activeTab);
	}

	/**
	 * <p>
	 * Set the value of the <code>activeTab</code> property.
	 * </p>
	 */
	public void setActiveTab ( String   activeTab ) {
		getStateHelper().put(PropertyKeys.activeTab, activeTab);
		handleAttribute("activeTab", activeTab);
	}
    	/*
	 *
        
        
          baseCls
         : String
        The base CSS class applied to the panel
        (defaults to 
        'x-tab-panel').
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
	 *True to enable scrolling to tabs that
          may be invisible due to overflowing the overall TabPanel
          width. Only available with tabPosition:'top' (defaults to
          false).
	 */
	
	public Boolean getEnableTabScroll () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableTabScroll);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableTabScroll</code> property.
	 * </p>
	 */
	public void setEnableTabScroll ( Boolean   enableTabScroll ) {
		getStateHelper().put(PropertyKeys.enableTabScroll, enableTabScroll);
		handleAttribute("enableTabScroll", enableTabScroll);
	}
    	/*
	 *
        
        
          minTabWidth
         : Number
        The minimum width in pixels for each tab
        when 
        resizeTabs = true (defaults to
        30).
	 */
	
	public Integer getMinTabWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minTabWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minTabWidth</code> property.
	 * </p>
	 */
	public void setMinTabWidth ( Integer   minTabWidth ) {
		getStateHelper().put(PropertyKeys.minTabWidth, minTabWidth);
		handleAttribute("minTabWidth", minTabWidth);
	}
    	/*
	 *The position where the tab strip should
          be rendered (defaults to 
          'top'). The only other supported value is 
          'bottom'. 
          Note: tab scrolling is only supported for 
          tabPosition: 'top'.
	 */
	
	public String getTabPosition () {
		return (String) getStateHelper().eval(PropertyKeys.tabPosition);
	}

	/**
	 * <p>
	 * Set the value of the <code>tabPosition</code> property.
	 * </p>
	 */
	public void setTabPosition ( String   tabPosition ) {
		getStateHelper().put(PropertyKeys.tabPosition, tabPosition);
		handleAttribute("tabPosition", tabPosition);
	}
    	/*
	 *
          (Optional) A 
          Template or 
          XTemplate which may be
          provided to process the data object returned from 
          
            getTemplateArgs
           to produce a clickable selector element in the tab
          strip.
          The main element created should be a 
          <li> element. In order for a click event
          on a selector element to be connected to its item, it
          must take its 
          id from the TabPanel's native 
          
            getTemplateArgs
          .
          The child element which contains the title text must
          be marked by the CSS class 
          x-tab-strip-inner.
          To enable closability, the created element should
          contain an element marked by the CSS class 
          x-tab-strip-close.
          If a custom 
          itemTpl is supplied, it is the developer's
          responsibility to create CSS style rules to create the
          desired appearance.Below is an example of how to
          create customized tab selector items:


new Ext.TabPanel({
    renderTo: document.body,
    minTabWidth: 115,
    tabWidth: 135,
    enableTabScroll: true,
    width: 600,
    height: 250,
    defaults: {autoScroll:true},
    itemTpl: 
new Ext.XTemplate(
    
'<li class="{cls}" id=
"{id}" style=
"overflow:hidden">',
         
'<tpl 
if="closable">',
            
'<a class="x-tab-strip-close"></a>',
         
'</tpl>',
         
'<a class="x-tab-right" href=
"#" style=
"padding-left:6px">',
            
'<em class="x-tab-left">',
                
'<span class="x-tab-strip-inner">',
                    
'<img src="{src}" style=
"float:left;margin:3px 3px 0 0">',
                    
'<span style="margin-left:20px" class=
"x-tab-strip-text {iconCls}">{text}
{extra}</span>',
                
'</span>',
            
'</em>',
        
'</a>',
    
'</li>'
    ),
    getTemplateArgs: 
function(item) {
//      Call the native method to collect the base data. Like
the ID!
        
var result =
Ext.TabPanel.prototype.getTemplateArgs.call(this, item);

//      Add stuff used 
in our template
        
return Ext.apply(result, {
            closable: item.closable,
            src: item.iconSrc,
            extra: item.extraText || 
''
        });
    },
    items: [{
        title: 
'New Tab 1',
        iconSrc: 
'../shared/icons/fam/grid.png',
        html: 
'Tab Body 1',
        closable: true
    }, {
        title: 
'New Tab 2',
        iconSrc: 
'../shared/icons/fam/grid.png',
        html: 
'Tab Body 2',
        extraText: 
'Extra stuff 
in the tab button'
    }]
});
          
	 */
	@ClientConfig(JsonMode.Object)

	public Object getItemTpl () {
		return (Object) getStateHelper().eval(PropertyKeys.itemTpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemTpl</code> property.
	 * </p>
	 */
	public void setItemTpl ( Object   itemTpl ) {
		getStateHelper().put(PropertyKeys.itemTpl, itemTpl);
		handleAttribute("itemTpl", itemTpl);
	}
    	/*
	 *True to animate tab scrolling so that
          hidden tabs slide smoothly into view (defaults to 
          true). Only applies when 
          
          enableTabScroll =
          true.
	 */
	
	public Boolean getAnimScroll () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animScroll);
	}

	/**
	 * <p>
	 * Set the value of the <code>animScroll</code> property.
	 * </p>
	 */
	public void setAnimScroll ( Boolean   animScroll ) {
		getStateHelper().put(PropertyKeys.animScroll, animScroll);
		handleAttribute("animScroll", animScroll);
	}
    	/*
	 *
          
          true to query the DOM for any divs with a class
          of 'x-tab' to be automatically converted to tabs and
          added to this panel (defaults to 
          false). Note that the query will be executed
          within the scope of the container element only (so that
          multiple tab panels from markup can be supported via this
          method).
          This method is only possible when the markup is
          structured correctly as a container with nested divs
          containing the class 
          'x-tab'. To create TabPanels without these
          limitations, or to pull tab content from other elements
          on the page, see the example at the top of the class for
          generating tabs from markup.
          There are a couple of things to note when using this
          method:
          
            When using the 
            autoTabs config (as opposed to passing
            individual tab configs in the TabPanel's 
            items
            collection), you must use 
            
              applyTo
             to correctly use the specified 
            id as the tab container. The 
            autoTabs method 
            replaces existing content with the TabPanel
            components.
            Make sure that you set 
            
            deferredRender: false
            so that the content elements for each tab will be
            rendered into the TabPanel immediately upon page load,
            otherwise they will not be transformed until each tab
            is activated and will be visible outside the
            TabPanel.
          Example usage:
          
           


var tabs = 
new Ext.TabPanel({
    applyTo: 
'my-tabs',
    activeTab: 0,
    deferredRender: false,
    autoTabs: true
});

// This markup will be converted to a TabPanel from the code
above
<div id=
"my-tabs">
    <div class=
"x-tab" title=
"Tab 1">A simple tab</div>
    <div class=
"x-tab" title=
"Tab 2">Another one</div>
</div>
          
	 */
	
	public Boolean getAutoTabs () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoTabs);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoTabs</code> property.
	 * </p>
	 */
	public void setAutoTabs ( Boolean   autoTabs ) {
		getStateHelper().put(PropertyKeys.autoTabs, autoTabs);
		handleAttribute("autoTabs", autoTabs);
	}
    	/*
	 *
            
            true by default to defer the rendering of
            child 
            
              items
             to the browsers DOM until a tab is activated. 
            false will render all contained 
            
              items
             as soon as the 
            layout is rendered.
            If there is a significant amount of content or a lot of
            heavy controls being rendered into panels that are not
            displayed by default, setting this to 
            true might improve performance.
            
            The 
            deferredRender property is internally passed
            to the layout manager for TabPanels (
            Ext.layout.CardLayout)
            as its 
            Ext.layout.CardLayout.deferredRender
            configuration value.
            
            
            Note: leaving 
            deferredRender as 
            true means that the content within an
            unactivated tab will not be available. For example,
            this means that if the TabPanel is within a 
            form, then until a tab
            is activated, any Fields within unactivated tabs will
            not be rendered, and will therefore not be submitted
            and will not be available to either 
            getValues or 
            setValues.
          
	 */
	
	public Boolean getDeferredRender () {
		return (Boolean) getStateHelper().eval(PropertyKeys.deferredRender);
	}

	/**
	 * <p>
	 * Set the value of the <code>deferredRender</code> property.
	 * </p>
	 */
	public void setDeferredRender ( Boolean   deferredRender ) {
		getStateHelper().put(PropertyKeys.deferredRender, deferredRender);
		handleAttribute("deferredRender", deferredRender);
	}
    	/*
	 *True to automatically resize each tab
          so that the tabs will completely fill the tab strip
          (defaults to false). Setting this to true may cause
          specific widths that might be set per tab to be
          overridden in order to fit them all into view (although 
          minTabWidth will always be
          honored).
	 */
	
	public Boolean getResizeTabs () {
		return (Boolean) getStateHelper().eval(PropertyKeys.resizeTabs);
	}

	/**
	 * <p>
	 * Set the value of the <code>resizeTabs</code> property.
	 * </p>
	 */
	public void setResizeTabs ( Boolean   resizeTabs ) {
		getStateHelper().put(PropertyKeys.resizeTabs, resizeTabs);
		handleAttribute("resizeTabs", resizeTabs);
	}
    	/*
	 *The number of pixels of space to
          calculate into the sizing and scrolling of tabs. If you
          change the margin in CSS, you will need to update this
          value so calculations are correct with either 
          
            resizeTabs
           or scrolling tabs. (defaults to 
          2)
	 */
	
	public Integer getTabMargin () {
		return (Integer) getStateHelper().eval(PropertyKeys.tabMargin);
	}

	/**
	 * <p>
	 * Set the value of the <code>tabMargin</code> property.
	 * </p>
	 */
	public void setTabMargin ( Integer   tabMargin ) {
		getStateHelper().put(PropertyKeys.tabMargin, tabMargin);
		handleAttribute("tabMargin", tabMargin);
	}
    	/*
	 *
        
        
          scrollRepeatInterval
         : Number
        Number of milliseconds between each
        scroll while a tab scroll button is continuously pressed
        (defaults to 
        400).
	 */
	
	public Integer getScrollRepeatInterval () {
		return (Integer) getStateHelper().eval(PropertyKeys.scrollRepeatInterval);
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollRepeatInterval</code> property.
	 * </p>
	 */
	public void setScrollRepeatInterval ( Integer   scrollRepeatInterval ) {
		getStateHelper().put(PropertyKeys.scrollRepeatInterval, scrollRepeatInterval);
		handleAttribute("scrollRepeatInterval", scrollRepeatInterval);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforetabchange"
					, "contextmenu"
					, "tabchange"
				));
				return superEvent;
	}
}