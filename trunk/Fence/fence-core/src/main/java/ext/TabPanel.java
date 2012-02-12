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
  <p>A basic tab container. TabPanels can be used exactly like a
  standard 
  <a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Ext.Panel</a>
  for layout purposes, but also have special support for containing
  child Components (
  <tt>
    <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>
  </tt>) that are managed using a 
  <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">CardLayout layout manager</a>,
  and displayed as separate tabs.</p>
  <b>Note:</b> By default, a tab's close tool 
  <i>destroys</i> the child tab Component and all its descendants.
  This makes the child tab Component, and all its descendants 
  <b>unusable</b>. To enable re-use of a tab, configure the
  TabPanel with 
  <b>
    <code>
      <a ext:cls="Ext.TabPanel" ext:member="autoDestroy" href="output/Ext.TabPanel.html#Ext.TabPanel-autoDestroy">autoDestroy:
      false</a>
    </code>
  </b>. 
  <p>
    <b>
      <u>TabPanel header/footer elements</u>
    </b>
  </p>
  <p>TabPanels use their 
  <a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a> or 
  <a ext:cls="Ext.Panel" ext:member="footer" href="output/Ext.Panel.html#Ext.Panel-footer">footer</a> element
  (depending on the 
  <a ext:cls="Ext.TabPanel" ext:member="tabPosition" href="output/Ext.TabPanel.html#Ext.TabPanel-tabPosition">tabPosition</a>
  configuration) to accommodate the tab selector buttons. This
  means that a TabPanel will not display any configured title, and
  will not display any configured header 
  <a ext:cls="Ext.Panel" ext:member="tools" href="output/Ext.Panel.html#Ext.Panel-tools">tools</a>.</p>
  <p>To display a header, embed the TabPanel in a 
  <a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Panel</a>
  which uses 
  <b>
    <tt>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout:'fit'</a>
    </tt>
  </b>.</p>
  <p>
    <b>
      <u>Tab Events</u>
    </b>
  </p>
  <p>There is no actual tab class — each tab is simply a 
  <a ext:cls="Ext.BoxComponent" href="output/Ext.BoxComponent.html">Component</a> such as a 
  <a ext:cls="Ext.Panel" href="output/Ext.Panel.html">Panel</a>.
  However, when rendered in a TabPanel, each child Component can
  fire additional events that only exist for tabs and are not
  available from other Components. These events are:</p>
  <div>
    <ul class="mdetail-params">
      <li>
      <tt>
        <b>
          <a ext:cls="Ext.Panel" ext:member="activate" href="output/Ext.Panel.html#Ext.Panel-activate">activate</a>
        </b>
      </tt> : Fires when this Component becomes the active
      tab.</li>
      <li>
      <tt>
        <b>
          <a ext:cls="Ext.Panel" ext:member="deactivate" href="output/Ext.Panel.html#Ext.Panel-deactivate">deactivate</a>
        </b>
      </tt> : Fires when the Component that was the active tab
      becomes deactivated.</li>
      <li>
      <tt>
        <b>
          <a ext:cls="Ext.Panel" ext:member="beforeclose" href="output/Ext.Panel.html#Ext.Panel-beforeclose">beforeclose</a>
        </b>
      </tt> : Fires when the user clicks on the close tool of a
      closeable tab. May be vetoed by returning 
      <code>false</code> from a handler.</li>
      <li>
      <tt>
        <b>
          <a ext:cls="Ext.Panel" ext:member="close" href="output/Ext.Panel.html#Ext.Panel-close">close</a>
        </b>
      </tt> : Fires a closeable tab has been closed by the
      user.</li>
    </ul>
  </div>
  <p>
    <b>
      <u>Creating TabPanels from Code</u>
    </b>
  </p>
  <p>TabPanels can be created and rendered completely in code, as
  in this example:</p>
<pre>
<code>
<b>var</b> tabs = 
<b>new</b> Ext.TabPanel({
    renderTo: Ext.getBody(),
    activeTab: 0,
    items: [{
        title: 
<em>'Tab 1'</em>,
        html: 
<em>'A simple tab'</em>
    },{
        title: 
<em>'Tab 2'</em>,
        html: 
<em>'Another one'</em>
    }]
});</code>
  </pre>
  <p>
    <b>
      <u>Creating TabPanels from Existing Markup</u>
    </b>
  </p>
  <p>TabPanels can also be rendered from pre-existing markup in a
  couple of ways.</p>
  <div>
    <ul class="mdetail-params">
      <li>Pre-Structured Markup</li>
      <li style="list-style: none">
        <div class="sub-desc">
          <p>A container div with one or more nested tab divs with
          class 
          <tt>'x-tab'</tt> can be rendered entirely from existing
          markup (See the 
          <a ext:cls="Ext.TabPanel" ext:member="autoTabs" href="output/Ext.TabPanel.html#Ext.TabPanel-autoTabs">autoTabs</a>
          example).</p>
        </div>
      </li>
      <li>Un-Structured Markup</li>
      <li style="list-style: none">
        <div class="sub-desc">
        <p>A TabPanel can also be rendered from markup that is not
        strictly structured by simply specifying by id which
        elements should be the container and the tabs. Using this
        method tab content can be pulled from different elements
        within the page by id regardless of page structure. For
        example:</p>
<pre>
<code>
<b>var</b> tabs = 
<b>new</b> Ext.TabPanel({
    renderTo: 
<em>'my-tabs'</em>,
    activeTab: 0,
    items:[
        {contentEl:
<em>'tab1'</em>, title:
<em>'Tab 1'</em>},
        {contentEl:
<em>'tab2'</em>, title:
<em>'Tab 2'</em>}
    ]
});

<i>// Note that the tabs 
<b>do</b> not have to be nested within the container (although they
can be)</i>
&lt;div id=
<em>"my-tabs"</em>&gt;&lt;/div&gt;
&lt;div id=
<em>"tab1"</em> class=
<em>"x-hide-display"</em>&gt;A simple tab&lt;/div&gt;
&lt;div id=
<em>"tab2"</em> class=
<em>"x-hide-display"</em>&gt;Another one&lt;/div&gt;</code>
        </pre>Note that the tab divs in this example contain the
        class 
        <tt>'x-hide-display'</tt> so that they can be rendered
        deferred without displaying outside the tabs. You could
        alternately set 
        <tt>
        <a ext:cls="Ext.TabPanel" ext:member="deferredRender" href="output/Ext.TabPanel.html#Ext.TabPanel-deferredRender">deferredRender</a> = false</tt> to
        render all content tabs on page load.</div>
      </li>
    </ul>
  </div>
</div>

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
			layoutConfig
			,resizeTabs
			,scrollRepeatInterval
			,wheelIncrement
			,autoTabSelector
			,baseCls
			,minTabWidth
			,scrollDuration
			,animScroll
			,deferredRender
			,autoTabs
			,scrollIncrement
			,itemTpl
			,tabWidth
			,tabMargin
			,layoutOnTabChange
			,activeTab
			,tabPosition
			,plain
			,tabCls
			,enableTabScroll
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">TabPanel implicitly uses 
          <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">Ext.layout.CardLayout</a>
          as its layout manager. 
          <code>layoutConfig</code> may be used to configure this
          layout manager. 
          <code>
            <a ext:cls="Ext.TabPanel" ext:member="deferredRender" href="output/Ext.TabPanel.html#Ext.TabPanel-deferredRender">deferredRender</a>
          </code> and 
          <code>
            <a ext:cls="Ext.TabPanel" ext:member="layoutOnTabChange" href="output/Ext.TabPanel.html#Ext.TabPanel-layoutOnTabChange">layoutOnTabChange</a>
          </code> configured on the TabPanel will be applied as
          configs to the layout manager.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to automatically resize each tab
          so that the tabs will completely fill the tab strip
          (defaults to false). Setting this to true may cause
          specific widths that might be set per tab to be
          overridden in order to fit them all into view (although 
          <a ext:cls="Ext.TabPanel" ext:member="minTabWidth" href="output/Ext.TabPanel.html#Ext.TabPanel-minTabWidth">minTabWidth</a> will always be
          honored).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The CSS selector used to search for
          tabs in existing markup when 
          <tt>
          <a ext:cls="Ext.TabPanel" ext:member="autoTabs" href="output/Ext.TabPanel.html#Ext.TabPanel-autoTabs">autoTabs</a>
          = true</tt> (defaults to 
          <tt>'div.x-tab'</tt>). This can be any valid selector
          supported by 
          <a ext:cls="Ext.DomQuery" ext:member="select" href="output/Ext.DomQuery.html#Ext.DomQuery-select">Ext.DomQuery.select</a>. Note that
          the query will be executed within the scope of this tab
          panel only (so that multiple tab panels from markup can
          be supported on a page).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The number of milliseconds that each
          scroll animation should last (defaults to 
          <tt>.35</tt>). Only applies when 
          <tt>
          <a ext:cls="Ext.TabPanel" ext:member="animScroll" href="output/Ext.TabPanel.html#Ext.TabPanel-animScroll">animScroll</a> = true</tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to animate tab scrolling so that
          hidden tabs slide smoothly into view (defaults to 
          <tt>true</tt>). Only applies when 
          <tt>
          <a ext:cls="Ext.TabPanel" ext:member="enableTabScroll" href="output/Ext.TabPanel.html#Ext.TabPanel-enableTabScroll">enableTabScroll</a> =
          true</tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <tt>true</tt> by default to defer the rendering of
            child 
            <tt>
              <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>
            </tt> to the browsers DOM until a tab is activated. 
            <tt>false</tt> will render all contained 
            <tt>
              <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>
            </tt> as soon as the 
            <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">layout</a> is rendered.
            If there is a significant amount of content or a lot of
            heavy controls being rendered into panels that are not
            displayed by default, setting this to 
            <tt>true</tt> might improve performance.</p>
            <br/>
            <p>The 
            <tt>deferredRender</tt> property is internally passed
            to the layout manager for TabPanels (
            <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">Ext.layout.CardLayout</a>)
            as its 
            <a ext:cls="Ext.layout.CardLayout" ext:member="deferredRender" href="output/Ext.layout.CardLayout.html#Ext.layout.CardLayout-deferredRender">Ext.layout.CardLayout.deferredRender</a>
            configuration value.</p>
            <br/>
            <p>
            <b>Note</b>: leaving 
            <tt>deferredRender</tt> as 
            <tt>true</tt> means that the content within an
            unactivated tab will not be available. For example,
            this means that if the TabPanel is within a 
            <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">form</a>, then until a tab
            is activated, any Fields within unactivated tabs will
            not be rendered, and will therefore not be submitted
            and will not be available to either 
            <a ext:cls="Ext.form.BasicForm" ext:member="getValues" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-getValues">getValues</a> or 
            <a ext:cls="Ext.form.BasicForm" ext:member="setValues" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-setValues">setValues</a>.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>
          <tt>true</tt> to query the DOM for any divs with a class
          of 'x-tab' to be automatically converted to tabs and
          added to this panel (defaults to 
          <tt>false</tt>). Note that the query will be executed
          within the scope of the container element only (so that
          multiple tab panels from markup can be supported via this
          method).</p>
          <p>This method is only possible when the markup is
          structured correctly as a container with nested divs
          containing the class 
          <tt>'x-tab'</tt>. To create TabPanels without these
          limitations, or to pull tab content from other elements
          on the page, see the example at the top of the class for
          generating tabs from markup.</p>
          <p>There are a couple of things to note when using this
          method:</p>
          <ul>
            <li>When using the 
            <tt>autoTabs</tt> config (as opposed to passing
            individual tab configs in the TabPanel's 
            <a ext:cls="Ext.TabPanel" ext:member="items" href="output/Ext.TabPanel.html#Ext.TabPanel-items">items</a>
            collection), you must use 
            <tt>
              <a ext:cls="Ext.TabPanel" ext:member="applyTo" href="output/Ext.TabPanel.html#Ext.TabPanel-applyTo">applyTo</a>
            </tt> to correctly use the specified 
            <tt>id</tt> as the tab container. The 
            <tt>autoTabs</tt> method 
            <em>replaces</em> existing content with the TabPanel
            components.</li>
            <li>Make sure that you set 
            <tt>
            <a ext:cls="Ext.TabPanel" ext:member="deferredRender" href="output/Ext.TabPanel.html#Ext.TabPanel-deferredRender">deferredRender</a>: false</tt>
            so that the content elements for each tab will be
            rendered into the TabPanel immediately upon page load,
            otherwise they will not be transformed until each tab
            is activated and will be visible outside the
            TabPanel.</li>
          </ul>Example usage:
          <br/>
          <br/> 
<pre>
<code>
<b>var</b> tabs = 
<b>new</b> Ext.TabPanel({
    applyTo: 
<em>'my-tabs'</em>,
    activeTab: 0,
    deferredRender: false,
    autoTabs: true
});

<i>// This markup will be converted to a TabPanel from the code
above</i>
&lt;div id=
<em>"my-tabs"</em>&gt;
    &lt;div class=
<em>"x-tab"</em> title=
<em>"Tab 1"</em>&gt;A simple tab&lt;/div&gt;
    &lt;div class=
<em>"x-tab"</em> title=
<em>"Tab 2"</em>&gt;Another one&lt;/div&gt;
&lt;/div&gt;</code>
          </pre>
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The number of pixels to scroll each
          time a tab scroll button is pressed (defaults to 
          <tt>100</tt>, or if 
          <tt>
          <a ext:cls="Ext.TabPanel" ext:member="resizeTabs" href="output/Ext.TabPanel.html#Ext.TabPanel-resizeTabs">resizeTabs</a> = true</tt>, the
          calculated tab width). Only applies when 
          <tt>
          <a ext:cls="Ext.TabPanel" ext:member="enableTabScroll" href="output/Ext.TabPanel.html#Ext.TabPanel-enableTabScroll">enableTabScroll</a> =
          true</tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>(Optional) A 
          <a ext:cls="Ext.Template" href="output/Ext.Template.html">Template</a> or 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">XTemplate</a> which may be
          provided to process the data object returned from 
          <tt>
            <a ext:cls="Ext.TabPanel" ext:member="getTemplateArgs" href="output/Ext.TabPanel.html#Ext.TabPanel-getTemplateArgs">getTemplateArgs</a>
          </tt> to produce a clickable selector element in the tab
          strip.</p>
          <p>The main element created should be a 
          <tt>&lt;li&gt;</tt> element. In order for a click event
          on a selector element to be connected to its item, it
          must take its 
          <i>id</i> from the TabPanel's native 
          <tt>
            <a ext:cls="Ext.TabPanel" ext:member="getTemplateArgs" href="output/Ext.TabPanel.html#Ext.TabPanel-getTemplateArgs">getTemplateArgs</a>
          </tt>.</p>
          <p>The child element which contains the title text must
          be marked by the CSS class 
          <tt>x-tab-strip-inner</tt>.</p>
          <p>To enable closability, the created element should
          contain an element marked by the CSS class 
          <tt>x-tab-strip-close</tt>.</p>
          <p>If a custom 
          <tt>itemTpl</tt> is supplied, it is the developer's
          responsibility to create CSS style rules to create the
          desired appearance.</p>Below is an example of how to
          create customized tab selector items:
<pre>
<code>
<b>new</b> Ext.TabPanel({
    renderTo: document.body,
    minTabWidth: 115,
    tabWidth: 135,
    enableTabScroll: true,
    width: 600,
    height: 250,
    defaults: {autoScroll:true},
    itemTpl: 
<b>new</b> Ext.XTemplate(
    
<em>'&lt;li class=</em>"{cls}"</code> id=
<em>"{id}"</em> style=
<em>"overflow:hidden"</em>&gt;',
         
<em>'&lt;tpl 
<b>if</b>=</em>"closable"&gt;',
            
<em>'&lt;a class=</em>"x-tab-strip-close"&gt;&lt;/a&gt;',
         
<em>'&lt;/tpl&gt;'</em>,
         
<em>'&lt;a class=</em>"x-tab-right" href=
<em>"#"</em> style=
<em>"padding-left:6px"</em>&gt;',
            
<em>'&lt;em class=</em>"x-tab-left"&gt;',
                
<em>'&lt;span class=</em>"x-tab-strip-inner"&gt;',
                    
<em>'&lt;img src=</em>"{src}" style=
<em>"float:left;margin:3px 3px 0 0"</em>&gt;',
                    
<em>'&lt;span style=</em>"margin-left:20px" class=
<em>"x-tab-strip-text {iconCls}"</em>&gt;{text}
{extra}&lt;/span&gt;',
                
<em>'&lt;/span&gt;'</em>,
            
<em>'&lt;/em&gt;'</em>,
        
<em>'&lt;/a&gt;'</em>,
    
<em>'&lt;/li&gt;'</em>
    ),
    getTemplateArgs: 
<b>function</b>(item) {
<i>//      Call the native method to collect the base data. Like
the ID!</i>
        
<b>var</b> result =
Ext.TabPanel.prototype.getTemplateArgs.call(this, item);

<i>//      Add stuff used 
<b>in</b> our template</i>
        
<b>return</b> Ext.apply(result, {
            closable: item.closable,
            src: item.iconSrc,
            extra: item.extraText || 
<em>''</em>
        });
    },
    items: [{
        title: 
<em>'New Tab 1'</em>,
        iconSrc: 
<em>'../shared/icons/fam/grid.png'</em>,
        html: 
<em>'Tab Body 1'</em>,
        closable: true
    }, {
        title: 
<em>'New Tab 2'</em>,
        iconSrc: 
<em>'../shared/icons/fam/grid.png'</em>,
        html: 
<em>'Tab Body 2'</em>,
        extraText: 
<em>'Extra stuff 
<b>in</b> the tab button'</em>
    }]
});
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The number of pixels of space to
          calculate into the sizing and scrolling of tabs. If you
          change the margin in CSS, you will need to update this
          value so calculations are correct with either 
          <tt>
            <a ext:cls="Ext.TabPanel" ext:member="resizeTabs" href="output/Ext.TabPanel.html#Ext.TabPanel-resizeTabs">resizeTabs</a>
          </tt> or scrolling tabs. (defaults to 
          <tt>2</tt>)</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Set to true to force a layout of the
          active tab when the tab is changed. Defaults to false.
          See 
          <a ext:cls="Ext.layout.CardLayout" href="output/Ext.layout.CardLayout.html">Ext.layout.CardLayout</a>.
          <code>
            <a ext:cls="Ext.layout.CardLayout" ext:member="layoutOnCardChange" href="output/Ext.layout.CardLayout.html#Ext.layout.CardLayout-layoutOnCardChange">layoutOnCardChange</a>
          </code>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The position where the tab strip should
          be rendered (defaults to 
          <tt>'top'</tt>). The only other supported value is 
          <tt>'bottom'</tt>. 
          <b>Note</b>: tab scrolling is only supported for 
          <tt>tabPosition: 'top'</tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <b>This config option is used on 
          <u>child Components</u> of ths TabPanel.</b> A CSS class
          name applied to the tab strip item representing the child
          Component, allowing special styling to be applied.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to enable scrolling to tabs that
          may be invisible due to overflowing the overall TabPanel
          width. Only available with tabPosition:'top' (defaults to
          false).</div>

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