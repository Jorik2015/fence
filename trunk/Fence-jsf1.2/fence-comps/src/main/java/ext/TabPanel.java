package ext;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * A basic tab container. TabPanels can be used exactly like a standard <a
 * href="output/Ext.Panel.html" ext:cls="Ext.Panel">Ext.Panel</a> for layout
 * purposes, but also have special support for containing child Components (
 * 
 * <tt><a href="output/Ext.Container.html#Ext.Container-items" ext:member="items" ext:cls="Ext.Container">items</a></tt>
 * ) that are managed using a <a href="output/Ext.layout.CardLayout.html"
 * ext:cls="Ext.layout.CardLayout">CardLayout layout manager</a>, and displayed
 * as separate tabs.
 * </p>
 * 
 * <b>Note:</b> By default, a tab's close tool <i>destroys</i> the child tab
 * Component and all its descendants. This makes the child tab Component, and
 * all its descendants <b>unusable</b>. To enable re-use of a tab, configure the
 * TabPanel with <b>
 * <code><a href="output/Ext.TabPanel.html#Ext.TabPanel-autoDestroy" ext:member="autoDestroy" ext:cls="Ext.TabPanel">autoDestroy:
false</a></code></b>.
 * 
 * <p>
 * <b><u>TabPanel header/footer elements</u></b>
 * </p>
 * 
 * <p>
 * TabPanels use their <a href="output/Ext.Panel.html#Ext.Panel-header"
 * ext:member="header" ext:cls="Ext.Panel">header</a> or <a
 * href="output/Ext.Panel.html#Ext.Panel-footer" ext:member="footer"
 * ext:cls="Ext.Panel">footer</a> element (depending on the <a
 * href="output/Ext.TabPanel.html#Ext.TabPanel-tabPosition"
 * ext:member="tabPosition" ext:cls="Ext.TabPanel">tabPosition</a>
 * configuration) to accommodate the tab selector buttons. This means that a
 * TabPanel will not display any configured title, and will not display any
 * configured header <a href="output/Ext.Panel.html#Ext.Panel-tools"
 * ext:member="tools" ext:cls="Ext.Panel">tools</a>.
 * </p>
 * 
 * <p>
 * To display a header, embed the TabPanel in a <a href="output/Ext.Panel.html"
 * ext:cls="Ext.Panel">Panel</a> which uses <b><tt><a href="output/Ext.Container.html#Ext.Container-layout" ext:member="layout" ext:cls="Ext.Container">layout:'fit'</a></tt>
 * </b>.
 * </p>
 * 
 * <p>
 * <b><u>Tab Events</u></b>
 * </p>
 * 
 * <p>
 * There is no actual tab class — each tab is simply a <a
 * href="output/Ext.BoxComponent.html" ext:cls="Ext.BoxComponent">Component</a>
 * such as a <a href="output/Ext.Panel.html" ext:cls="Ext.Panel">Panel</a>.
 * However, when rendered in a TabPanel, each child Component can fire
 * additional events that only exist for tabs and are not available from other
 * Components. These events are:
 * </p>
 * 
 * <div>
 * <ul class="mdetail-params">
 * <li>
 * <tt><b><a href="output/Ext.Panel.html#Ext.Panel-activate" ext:member="activate" ext:cls="Ext.Panel">activate</a></b></tt>
 * : Fires when this Component becomes the active tab.</li>
 * 
 * <li>
 * <tt><b><a href="output/Ext.Panel.html#Ext.Panel-deactivate" ext:member="deactivate" ext:cls="Ext.Panel">deactivate</a></b></tt>
 * : Fires when the Component that was the active tab becomes deactivated.</li>
 * </ul>
 * </div>
 * 
 * <p>
 * <b><u>Creating TabPanels from Code</u></b>
 * </p>
 * 
 * <p>
 * TabPanels can be created and rendered completely in code, as in this example:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; tabs = &lt;b&gt;new&lt;/b&gt; Ext.TabPanel({
 *     renderTo: Ext.getBody(),
 *     activeTab: 0,
 *     items: [{
 *         title: &lt;em&gt;'Tab 1'&lt;/em&gt;,
 *         html: &lt;em&gt;'A simple tab'&lt;/em&gt;
 *     },{
 *         title: &lt;em&gt;'Tab 2'&lt;/em&gt;,
 *         html: &lt;em&gt;'Another one'&lt;/em&gt;
 *     }]
 * });&lt;/code&gt;
 * </pre>
 * 
 * <p>
 * <b><u>Creating TabPanels from Existing Markup</u></b>
 * </p>
 * 
 * <p>
 * TabPanels can also be rendered from pre-existing markup in a couple of ways.
 * </p>
 * 
 * <div>
 * <ul class="mdetail-params">
 * <li>Pre-Structured Markup</li>
 * 
 * <li style="list-style: none">
 * <div class="sub-desc">
 * <p>
 * A container div with one or more nested tab divs with class <tt>'x-tab'</tt> can be
 * rendered entirely from existing markup (See the <a
 * href="output/Ext.TabPanel.html#Ext.TabPanel-autoTabs" ext:member="autoTabs"
 * ext:cls="Ext.TabPanel">autoTabs</a> example).
 * </p>
 * </div></li>
 * 
 * <li>Un-Structured Markup</li>
 * 
 * <li style="list-style: none">
 * <div class="sub-desc">
 * <p>
 * A TabPanel can also be rendered from markup that is not strictly structured
 * by simply specifying by id which elements should be the container and the
 * tabs. Using this method tab content can be pulled from different elements
 * within the page by id regardless of page structure. For example:
 * </p>
 * 
 * <pre>
 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; tabs = &lt;b&gt;new&lt;/b&gt; Ext.TabPanel({
 *     renderTo: &lt;em&gt;'my-tabs'&lt;/em&gt;,
 *     activeTab: 0,
 *     items:[
 *         {contentEl:&lt;em&gt;'tab1'&lt;/em&gt;, title:&lt;em&gt;'Tab 1'&lt;/em&gt;},
 *         {contentEl:&lt;em&gt;'tab2'&lt;/em&gt;, title:&lt;em&gt;'Tab 2'&lt;/em&gt;}
 *     ]
 * });
 * 
 * &lt;i&gt;// Note that the tabs &lt;b&gt;do&lt;/b&gt; not have to be nested within the container (although they can be)&lt;/i&gt;
 * &lt;div id=&lt;em&gt;&quot;my-tabs&quot;&lt;/em&gt;&gt;&lt;/div&gt;
 * &lt;div id=&lt;em&gt;&quot;tab1&quot;&lt;/em&gt; class=&lt;em&gt;&quot;x-hide-display&quot;&lt;/em&gt;&gt;A simple tab&lt;/div&gt;
 * &lt;div id=&lt;em&gt;&quot;tab2&quot;&lt;/em&gt; class=&lt;em&gt;&quot;x-hide-display&quot;&lt;/em&gt;&gt;Another one&lt;/div&gt;&lt;/code&gt;
 * </pre>
 * 
 * Note that the tab divs in this example contain the class <tt>'x-hide-display'</tt> so that they
 * can be rendered deferred without displaying outside the tabs. You could
 * alternately set
 * 
 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-deferredRender" ext:member="deferredRender" ext:cls="Ext.TabPanel">deferredRender</a> = false</tt>
 * to render all content tabs on page load.</div></li>
 * </ul>
 * </div>
 */
@XType("tabpanel")
@InstanceOf("Ext.TabPanel")
public class TabPanel extends Panel {
	public static final String COMPONENT_TYPE = "Ext.TabPanel";
	public static final String COMPONENT_FAMILY = "Ext.TabPanel";

	/**
	 * <p>
	 * Create a new {@link TabPanel} instance with default property values.
	 * </p>
	 */
	public TabPanel() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String activeTab;

	/**
	 * A string id or the numeric index of the tab thatshould be initially
	 * activated on render (defaults to none).
	 */
	public String getActiveTab() {
		if (null != this.activeTab) {
			return this.activeTab;
		}
		ValueExpression _ve = getValueExpression("activeTab");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>activeTab</code> property.
	 * </p>
	 */
	public void setActiveTab(String activeTab) {
		this.activeTab = activeTab;
		this.handleConfig("activeTab", activeTab);
	}

	private Boolean animScroll;

	/**
	 * True to animate tab scrolling so that hidden tabsslide smoothly into view
	 * (defaults to <tt>true</tt>). Only applies when
	 * 
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-enableTabScroll" ext:member="enableTabScroll" ext:cls="Ext.TabPanel">enableTabScroll</a> = true</tt>
	 * .
	 */
	public Boolean getAnimScroll() {
		if (null != this.animScroll) {
			return this.animScroll;
		}
		ValueExpression _ve = getValueExpression("animScroll");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>animScroll</code> property.
	 * </p>
	 */
	public void setAnimScroll(Boolean animScroll) {
		this.animScroll = animScroll;
		this.handleConfig("animScroll", animScroll);
	}

	private String autoTabSelector;

	/**
	 * The CSS selector used to search for tabs inexisting markup when
	 * 
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-autoTabs" ext:member="autoTabs" ext:cls="Ext.TabPanel">autoTabs</a> =
true</tt> (defaults to <tt>'div.x-tab'</tt>). This can be any valid selector supported by
	 * <a href="output/Ext.DomQuery.html#Ext.DomQuery-select"
	 * ext:member="select" ext:cls="Ext.DomQuery">Ext.DomQuery.select</a>. Note
	 * that the query will be executed within the scope of this tab panel only
	 * (so that multiple tab panels from markup can be supported on a page).
	 */
	public String getAutoTabSelector() {
		if (null != this.autoTabSelector) {
			return this.autoTabSelector;
		}
		ValueExpression _ve = getValueExpression("autoTabSelector");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoTabSelector</code> property.
	 * </p>
	 */
	public void setAutoTabSelector(String autoTabSelector) {
		this.autoTabSelector = autoTabSelector;
		this.handleConfig("autoTabSelector", autoTabSelector);
	}

	private Boolean autoTabs;

	/**
	 * <p>
	 * <tt>true</tt> to query the DOM for any divs with a class of 'x-tab' to be
	 * automatically converted to tabs and added to this panel (defaults to
	 * <tt>false</tt>). Note that the query will be executed within the scope of
	 * the container element only (so that multiple tab panels from markup can
	 * be supported via this method).
	 * </p>
	 * 
	 * <p>
	 * This method is only possible when the markup is structured correctly as a
	 * container with nested divs containing the class <tt>'x-tab'</tt>. To create TabPanels
	 * without these limitations, or to pull tab content from other elements on
	 * the page, see the example at the top of the class for generating tabs
	 * from markup.
	 * </p>
	 * 
	 * <p>
	 * There are a couple of things to note when using this method:
	 * </p>
	 * 
	 * <ul>
	 * <li>When using the <tt>autoTabs</tt> config (as opposed to passing
	 * individual tab configs in the TabPanel's <a
	 * href="output/Ext.TabPanel.html#Ext.TabPanel-items" ext:member="items"
	 * ext:cls="Ext.TabPanel">items</a> collection), you must use
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-applyTo" ext:member="applyTo" ext:cls="Ext.TabPanel">applyTo</a></tt>
	 * to correctly use the specified <tt>id</tt> as the tab container. The
	 * <tt>autoTabs</tt> method <em>replaces</em> existing content with the
	 * TabPanel components.</li>
	 * 
	 * <li>Make sure that you set
	 * 
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-deferredRender" ext:member="deferredRender" ext:cls="Ext.TabPanel">deferredRender</a>: false</tt>
	 * so that the content elements for each tab will be rendered into the
	 * TabPanel immediately upon page load, otherwise they will not be
	 * transformed until each tab is activated and will be visible outside the
	 * TabPanel.</li>
	 * </ul>
	 * 
	 * Example usage:<br>
	 * <br>
	 * 
	 * 
	 * <pre>
	 * &lt;code&gt;&lt;b&gt;var&lt;/b&gt; tabs = &lt;b&gt;new&lt;/b&gt; Ext.TabPanel({
	 *     applyTo: &lt;em&gt;'my-tabs'&lt;/em&gt;,
	 *     activeTab: 0,
	 *     deferredRender: false,
	 *     autoTabs: true
	 * });
	 * 
	 * &lt;i&gt;// This markup will be converted to a TabPanel from the code above&lt;/i&gt;
	 * &lt;div id=&lt;em&gt;&quot;my-tabs&quot;&lt;/em&gt;&gt;
	 *     &lt;div class=&lt;em&gt;&quot;x-tab&quot;&lt;/em&gt; title=&lt;em&gt;&quot;Tab 1&quot;&lt;/em&gt;&gt;A simple tab&lt;/div&gt;
	 *     &lt;div class=&lt;em&gt;&quot;x-tab&quot;&lt;/em&gt; title=&lt;em&gt;&quot;Tab 2&quot;&lt;/em&gt;&gt;Another one&lt;/div&gt;
	 * &lt;/div&gt;&lt;/code&gt;
	 * </pre>
	 */
	public Boolean getAutoTabs() {
		if (null != this.autoTabs) {
			return this.autoTabs;
		}
		ValueExpression _ve = getValueExpression("autoTabs");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>autoTabs</code> property.
	 * </p>
	 */
	public void setAutoTabs(Boolean autoTabs) {
		this.autoTabs = autoTabs;
		this.handleConfig("autoTabs", autoTabs);
	}

	private String baseCls;

	/**
	 * The base CSS class applied to the panel(defaults to <tt>'x-tab-panel'</tt>).
	 */
	public String getBaseCls() {
		if (null != this.baseCls) {
			return this.baseCls;
		}
		ValueExpression _ve = getValueExpression("baseCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>baseCls</code> property.
	 * </p>
	 */
	public void setBaseCls(String baseCls) {
		this.baseCls = baseCls;
		this.handleConfig("baseCls", baseCls);
	}

	private Boolean deferredRender;

	/**
	 * <p>
	 * <tt>true</tt> by default to defer the rendering of child
	 * <tt><a href="output/Ext.Container.html#Ext.Container-items" ext:member="items" ext:cls="Ext.Container">items</a></tt>
	 * to the browsers DOM until a tab is activated. <tt>false</tt> will render
	 * all contained
	 * <tt><a href="output/Ext.Container.html#Ext.Container-items" ext:member="items" ext:cls="Ext.Container">items</a></tt>
	 * as soon as the <a href="output/Ext.layout.CardLayout.html"
	 * ext:cls="Ext.layout.CardLayout">layout</a> is rendered. If there is a
	 * significant amount of content or a lot of heavy controls being rendered
	 * into panels that are not displayed by default, setting this to
	 * <tt>true</tt> might improve performance.
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * The <tt>deferredRender</tt> property is internally passed to the layout
	 * manager for TabPanels (<a href="output/Ext.layout.CardLayout.html"
	 * ext:cls="Ext.layout.CardLayout">Ext.layout.CardLayout</a>) as its <a
	 * href=
	 * "output/Ext.layout.CardLayout.html#Ext.layout.CardLayout-deferredRender"
	 * ext:member="deferredRender"
	 * ext:cls="Ext.layout.CardLayout">Ext.layout.CardLayout.deferredRender</a>
	 * configuration value.
	 * </p>
	 * 
	 * <br>
	 * <p>
	 * <b>Note</b>: leaving <tt>deferredRender</tt> as <tt>true</tt> means that
	 * the content within an unactivated tab will not be available. For example,
	 * this means that if the TabPanel is within a <a
	 * href="output/Ext.form.FormPanel.html"
	 * ext:cls="Ext.form.FormPanel">form</a>, then until a tab is activated, any
	 * Fields within unactivated tabs will not be rendered, and will therefore
	 * not be submitted and will not be available to either <a
	 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-getValues"
	 * ext:member="getValues" ext:cls="Ext.form.BasicForm">getValues</a> or <a
	 * href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-setValues"
	 * ext:member="setValues" ext:cls="Ext.form.BasicForm">setValues</a>.
	 * </p>
	 */
	public Boolean getDeferredRender() {
		if (null != this.deferredRender) {
			return this.deferredRender;
		}
		ValueExpression _ve = getValueExpression("deferredRender");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>deferredRender</code> property.
	 * </p>
	 */
	public void setDeferredRender(Boolean deferredRender) {
		this.deferredRender = deferredRender;
		this.handleConfig("deferredRender", deferredRender);
	}

	private Boolean enableTabScroll;

	/**
	 * True to enable scrolling to tabs that may beinvisible due to overflowing
	 * the overall TabPanel width. Only available with tabPosition:'top'
	 * (defaults to false).
	 */
	public Boolean getEnableTabScroll() {
		if (null != this.enableTabScroll) {
			return this.enableTabScroll;
		}
		ValueExpression _ve = getValueExpression("enableTabScroll");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>enableTabScroll</code> property.
	 * </p>
	 */
	public void setEnableTabScroll(Boolean enableTabScroll) {
		this.enableTabScroll = enableTabScroll;
		this.handleConfig("enableTabScroll", enableTabScroll);
	}

	private Object itemTpl;

	/**
	 * <p>
	 * (Optional) A <a href="output/Ext.Template.html"
	 * ext:cls="Ext.Template">Template</a> or <a
	 * href="output/Ext.XTemplate.html" ext:cls="Ext.XTemplate">XTemplate</a>
	 * which may be provided to process the data object returned from
	 * 
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-getTemplateArgs" ext:member="getTemplateArgs" ext:cls="Ext.TabPanel">getTemplateArgs</a></tt>
	 * to produce a clickable selector element in the tab strip.
	 * </p>
	 * 
	 * <p>
	 * The main element created should be a <tt>&lt;li&gt;</tt> element. In
	 * order for a click event on a selector element to be connected to its
	 * item, it must take its <i>id</i> from the TabPanel's native
	 * 
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-getTemplateArgs" ext:member="getTemplateArgs" ext:cls="Ext.TabPanel">getTemplateArgs</a></tt>
	 * .
	 * </p>
	 * 
	 * <p>
	 * The child element which contains the title text must be marked by the CSS
	 * class <tt>x-tab-strip-inner</tt>.
	 * </p>
	 * 
	 * <p>
	 * To enable closability, the created element should contain an element
	 * marked by the CSS class <tt>x-tab-strip-close</tt>.
	 * </p>
	 * 
	 * <p>
	 * If a custom <tt>itemTpl</tt> is supplied, it is the developer's
	 * responsibility to create CSS style rules to create the desired
	 * appearance.
	 * </p>
	 * 
	 * Below is an example of how to create customized tab selector items:
	 * 
	 * <pre>
	 * &lt;code&gt;&lt;b&gt;new&lt;/b&gt; Ext.TabPanel({
	 *     renderTo: document.body,
	 *     minTabWidth: 115,
	 *     tabWidth: 135,
	 *     enableTabScroll: true,
	 *     width: 600,
	 *     height: 250,
	 *     defaults: {autoScroll:true},
	 *     itemTpl: &lt;b&gt;new&lt;/b&gt; Ext.XTemplate(
	 *     &lt;em&gt;'&lt;li class=&lt;/em&gt;&quot;{cls}&quot;&lt;/code&gt; id=&lt;em&gt;&quot;{id}&quot;&lt;/em&gt; style=&lt;em&gt;&quot;overflow:hidden&quot;&lt;/em&gt;&gt;',
	 *          &lt;em&gt;'&lt;tpl &lt;b&gt;if&lt;/b&gt;=&lt;/em&gt;&quot;closable&quot;&gt;',
	 *             &lt;em&gt;'&lt;a class=&lt;/em&gt;&quot;x-tab-strip-close&quot; onclick=&lt;em&gt;&quot;&lt;b&gt;return&lt;/b&gt; false;&quot;&lt;/em&gt;&gt;&lt;/a&gt;',
	 *          &lt;em&gt;'&lt;/tpl&gt;'&lt;/em&gt;,
	 *          &lt;em&gt;'&lt;a class=&lt;/em&gt;&quot;x-tab-right&quot; href=&lt;em&gt;&quot;#&quot;&lt;/em&gt; onclick=&lt;em&gt;&quot;&lt;b&gt;return&lt;/b&gt; false;&quot;&lt;/em&gt; style=&lt;em&gt;&quot;padding-left:6px&quot;&lt;/em&gt;&gt;',
	 *             &lt;em&gt;'&lt;em class=&lt;/em&gt;&quot;x-tab-left&quot;&gt;',
	 *                 &lt;em&gt;'&lt;span class=&lt;/em&gt;&quot;x-tab-strip-inner&quot;&gt;',
	 *                     &lt;em&gt;'&lt;img src=&lt;/em&gt;&quot;{src}&quot; style=&lt;em&gt;&quot;float:left;margin:3px 3px 0 0&quot;&lt;/em&gt;&gt;',
	 *                     &lt;em&gt;'&lt;span style=&lt;/em&gt;&quot;margin-left:20px&quot; class=&lt;em&gt;&quot;x-tab-strip-text {iconCls}&quot;&lt;/em&gt;&gt;{text} {extra}&lt;/span&gt;',
	 *                 &lt;em&gt;'&lt;/span&gt;'&lt;/em&gt;,
	 *             &lt;em&gt;'&lt;/em&gt;'&lt;/em&gt;,
	 *         &lt;em&gt;'&lt;/a&gt;'&lt;/em&gt;,
	 *     &lt;em&gt;'&lt;/li&gt;'&lt;/em&gt;
	 *     ),
	 *     getTemplateArgs: &lt;b&gt;function&lt;/b&gt;(item) {
	 * &lt;i&gt;//      Call the native method to collect the base data. Like the ID!&lt;/i&gt;
	 *         &lt;b&gt;var&lt;/b&gt; result = Ext.TabPanel.prototype.getTemplateArgs.call(this, item);
	 * 
	 * &lt;i&gt;//      Add stuff used &lt;b&gt;in&lt;/b&gt; our template&lt;/i&gt;
	 *         &lt;b&gt;return&lt;/b&gt; Ext.apply(result, {
	 *             closable: item.closable,
	 *             src: item.iconSrc,
	 *             extra: item.extraText || &lt;em&gt;''&lt;/em&gt;
	 *         });
	 *     },
	 *     items: [{
	 *         title: &lt;em&gt;'New Tab 1'&lt;/em&gt;,
	 *         iconSrc: &lt;em&gt;'../shared/icons/fam/grid.png'&lt;/em&gt;,
	 *         html: &lt;em&gt;'Tab Body 1'&lt;/em&gt;,
	 *         closable: true
	 *     }, {
	 *         title: &lt;em&gt;'New Tab 2'&lt;/em&gt;,
	 *         iconSrc: &lt;em&gt;'../shared/icons/fam/grid.png'&lt;/em&gt;,
	 *         html: &lt;em&gt;'Tab Body 2'&lt;/em&gt;,
	 *         extraText: &lt;em&gt;'Extra stuff &lt;b&gt;in&lt;/b&gt; the tab button'&lt;/em&gt;
	 *     }]
	 * });
	 * </pre>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getItemTpl() {
		if (null != this.itemTpl) {
			return this.itemTpl;
		}
		ValueExpression _ve = getValueExpression("itemTpl");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>itemTpl</code> property.
	 * </p>
	 */
	public void setItemTpl(Object itemTpl) {
		this.itemTpl = itemTpl;
		this.handleConfig("itemTpl", itemTpl);
	}

	private Object layoutConfig;

	/**
	 * TabPanel implicitly uses <a href="output/Ext.layout.CardLayout.html"
	 * ext:cls="Ext.layout.CardLayout">Ext.layout.CardLayout</a> as itslayout
	 * manager. <code>layoutConfig</code> may be used to configure this layout
	 * manager.
	 * 
	 * <code><a href="output/Ext.TabPanel.html#Ext.TabPanel-deferredRender" ext:member="deferredRender" ext:cls="Ext.TabPanel">deferredRender</a></code>
	 * and
	 * 
	 * <code><a href="output/Ext.TabPanel.html#Ext.TabPanel-layoutOnTabChange" ext:member="layoutOnTabChange" ext:cls="Ext.TabPanel">layoutOnTabChange</a></code>
	 * configured on the TabPanel will be applied as configs to the layout
	 * manager.
	 */
	@ClientConfig(JsonMode.Object)
	public Object getLayoutConfig() {
		if (null != this.layoutConfig) {
			return this.layoutConfig;
		}
		ValueExpression _ve = getValueExpression("layoutConfig");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>layoutConfig</code> property.
	 * </p>
	 */
	public void setLayoutConfig(Object layoutConfig) {
		this.layoutConfig = layoutConfig;
		this.handleConfig("layoutConfig", layoutConfig);
	}

	private Boolean layoutOnTabChange;

	/**
	 * Set to true to force a layout of the active tabwhen the tab is changed.
	 * Defaults to false. See <a href="output/Ext.layout.CardLayout.html"
	 * ext:cls="Ext.layout.CardLayout">Ext.layout.CardLayout</a>.
	 * 
	 * <code><a href="output/Ext.layout.CardLayout.html#Ext.layout.CardLayout-layoutOnCardChange" ext:member="layoutOnCardChange" ext:cls="Ext.layout.CardLayout">layoutOnCardChange</a></code>
	 * .
	 */
	public Boolean getLayoutOnTabChange() {
		if (null != this.layoutOnTabChange) {
			return this.layoutOnTabChange;
		}
		ValueExpression _ve = getValueExpression("layoutOnTabChange");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>layoutOnTabChange</code> property.
	 * </p>
	 */
	public void setLayoutOnTabChange(Boolean layoutOnTabChange) {
		this.layoutOnTabChange = layoutOnTabChange;
		this.handleConfig("layoutOnTabChange", layoutOnTabChange);
	}

	private Integer minTabWidth;

	/**
	 * The minimum width in pixels for each tab when <a
	 * href="output/Ext.TabPanel.html#Ext.TabPanel-resizeTabs"
	 * ext:member="resizeTabs" ext:cls="Ext.TabPanel">resizeTabs</a> =true
	 * (defaults to 30).
	 */
	public Integer getMinTabWidth() {
		if (null != this.minTabWidth) {
			return this.minTabWidth;
		}
		ValueExpression _ve = getValueExpression("minTabWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>minTabWidth</code> property.
	 * </p>
	 */
	public void setMinTabWidth(Integer minTabWidth) {
		this.minTabWidth = minTabWidth;
		this.handleConfig("minTabWidth", minTabWidth);
	}

	private Boolean monitorResize;

	/**
	 * True to automatically monitor window resizeevents and rerender the layout
	 * on browser resize (defaults to true).
	 */
	public Boolean getMonitorResize() {
		if (null != this.monitorResize) {
			return this.monitorResize;
		}
		ValueExpression _ve = getValueExpression("monitorResize");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>monitorResize</code> property.
	 * </p>
	 */
	public void setMonitorResize(Boolean monitorResize) {
		this.monitorResize = monitorResize;
		this.handleConfig("monitorResize", monitorResize);
	}

	private Boolean plain;

	/**
	 * true to render the tab strip without abackground container image
	 * (defaults to <tt>false</tt>).
	 */
	public Boolean getPlain() {
		if (null != this.plain) {
			return this.plain;
		}
		ValueExpression _ve = getValueExpression("plain");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>plain</code> property.
	 * </p>
	 */
	public void setPlain(Boolean plain) {
		this.plain = plain;
		this.handleConfig("plain", plain);
	}

	private Boolean resizeTabs;

	/**
	 * True to automatically resize each tab so that thetabs will completely
	 * fill the tab strip (defaults to false). Setting this to true may cause
	 * specific widths that might be set per tab to be overridden in order to
	 * fit them all into view (although <a
	 * href="output/Ext.TabPanel.html#Ext.TabPanel-minTabWidth"
	 * ext:member="minTabWidth" ext:cls="Ext.TabPanel">minTabWidth</a> will
	 * always be honored).
	 */
	public Boolean getResizeTabs() {
		if (null != this.resizeTabs) {
			return this.resizeTabs;
		}
		ValueExpression _ve = getValueExpression("resizeTabs");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>resizeTabs</code> property.
	 * </p>
	 */
	public void setResizeTabs(Boolean resizeTabs) {
		this.resizeTabs = resizeTabs;
		this.handleConfig("resizeTabs", resizeTabs);
	}

	private Float scrollDuration;

	/**
	 * The number of milliseconds that each scrollanimation should last
	 * (defaults to <tt>.35</tt>). Only applies when
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-animScroll" ext:member="animScroll" ext:cls="Ext.TabPanel">animScroll</a> =
true</tt>.
	 */
	public Float getScrollDuration() {
		if (null != this.scrollDuration) {
			return this.scrollDuration;
		}
		ValueExpression _ve = getValueExpression("scrollDuration");
		if (_ve != null) {
			return (Float) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollDuration</code> property.
	 * </p>
	 */
	public void setScrollDuration(Float scrollDuration) {
		this.scrollDuration = scrollDuration;
		this.handleConfig("scrollDuration", scrollDuration);
	}

	private Integer scrollIncrement;

	/**
	 * The number of pixels to scroll each time a tabscroll button is pressed
	 * (defaults to <tt>100</tt>, or if
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-resizeTabs" ext:member="resizeTabs" ext:cls="Ext.TabPanel">resizeTabs</a> =
true</tt>, the calculated tab width). Only applies when
	 * 
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-enableTabScroll" ext:member="enableTabScroll" ext:cls="Ext.TabPanel">enableTabScroll</a> = true</tt>
	 * .
	 */
	public Integer getScrollIncrement() {
		if (null != this.scrollIncrement) {
			return this.scrollIncrement;
		}
		ValueExpression _ve = getValueExpression("scrollIncrement");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollIncrement</code> property.
	 * </p>
	 */
	public void setScrollIncrement(Integer scrollIncrement) {
		this.scrollIncrement = scrollIncrement;
		this.handleConfig("scrollIncrement", scrollIncrement);
	}

	private Integer scrollRepeatInterval;

	/**
	 * Number of milliseconds between each scroll whilea tab scroll button is
	 * continuously pressed (defaults to <tt>400</tt>).
	 */
	public Integer getScrollRepeatInterval() {
		if (null != this.scrollRepeatInterval) {
			return this.scrollRepeatInterval;
		}
		ValueExpression _ve = getValueExpression("scrollRepeatInterval");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollRepeatInterval</code> property.
	 * </p>
	 */
	public void setScrollRepeatInterval(Integer scrollRepeatInterval) {
		this.scrollRepeatInterval = scrollRepeatInterval;
		this.handleConfig("scrollRepeatInterval", scrollRepeatInterval);
	}

	private String tabCls;

	/**
	 * <b>This config option is used on <u>childComponents</u> of ths
	 * TabPanel.</b> A CSS class name applied to the tab strip item representing
	 * the child Component, allowing special styling to be applied.
	 */
	public String getTabCls() {
		if (null != this.tabCls) {
			return this.tabCls;
		}
		ValueExpression _ve = getValueExpression("tabCls");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tabCls</code> property.
	 * </p>
	 */
	public void setTabCls(String tabCls) {
		this.tabCls = tabCls;
		this.handleConfig("tabCls", tabCls);
	}

	private Integer tabMargin;

	/**
	 * The number of pixels of space to calculate intothe sizing and scrolling
	 * of tabs. If you change the margin in CSS, you will need to update this
	 * value so calculations are correct with either
	 * <tt><a href="output/Ext.TabPanel.html#Ext.TabPanel-resizeTabs" ext:member="resizeTabs" ext:cls="Ext.TabPanel">resizeTabs</a></tt>
	 * or scrolling tabs. (defaults to <tt>2</tt>)
	 */
	public Integer getTabMargin() {
		if (null != this.tabMargin) {
			return this.tabMargin;
		}
		ValueExpression _ve = getValueExpression("tabMargin");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tabMargin</code> property.
	 * </p>
	 */
	public void setTabMargin(Integer tabMargin) {
		this.tabMargin = tabMargin;
		this.handleConfig("tabMargin", tabMargin);
	}

	private String tabPosition;

	/**
	 * The position where the tab strip should berendered (defaults to <tt>'top'</tt>).
	 * The only other supported value is <tt>'bottom'</tt>. <b>Note</b>: tab scrolling is
	 * only supported for <tt>tabPosition: 'top'</tt>.
	 */
	public String getTabPosition() {
		if (null != this.tabPosition) {
			return this.tabPosition;
		}
		ValueExpression _ve = getValueExpression("tabPosition");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tabPosition</code> property.
	 * </p>
	 */
	public void setTabPosition(String tabPosition) {
		this.tabPosition = tabPosition;
		this.handleConfig("tabPosition", tabPosition);
	}

	private Integer tabWidth;

	/**
	 * The initial width in pixels of each new tab(defaults to 120).
	 */
	public Integer getTabWidth() {
		if (null != this.tabWidth) {
			return this.tabWidth;
		}
		ValueExpression _ve = getValueExpression("tabWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tabWidth</code> property.
	 * </p>
	 */
	public void setTabWidth(Integer tabWidth) {
		this.tabWidth = tabWidth;
		this.handleConfig("tabWidth", tabWidth);
	}

	private Integer wheelIncrement;

	/**
	 * For scrolling tabs, the number of pixels toincrement on mouse wheel
	 * scrolling (defaults to <tt>20</tt>).
	 */
	public Integer getWheelIncrement() {
		if (null != this.wheelIncrement) {
			return this.wheelIncrement;
		}
		ValueExpression _ve = getValueExpression("wheelIncrement");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>wheelIncrement</code> property.
	 * </p>
	 */
	public void setWheelIncrement(Integer wheelIncrement) {
		this.wheelIncrement = wheelIncrement;
		this.handleConfig("wheelIncrement", wheelIncrement);
	}

	private String type;

	/**
	 * submit, reset or button - defaults to 'button'
	 */
	public String getType() {
		if (null != this.type) {
			return this.type;
		}
		ValueExpression _ve = getValueExpression("type");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType(String type) {
		this.type = type;
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[24];
		}
		_values[0] = super.saveState(_context);
		_values[1] = activeTab;
		_values[2] = animScroll;
		_values[3] = autoTabSelector;
		_values[4] = autoTabs;
		_values[5] = baseCls;
		_values[6] = deferredRender;
		_values[7] = enableTabScroll;
		_values[8] = itemTpl;
		_values[9] = layoutConfig;
		_values[10] = layoutOnTabChange;
		_values[11] = minTabWidth;
		_values[12] = monitorResize;
		_values[13] = plain;
		_values[14] = resizeTabs;
		_values[15] = scrollDuration;
		_values[16] = scrollIncrement;
		_values[17] = scrollRepeatInterval;
		_values[18] = tabCls;
		_values[19] = tabMargin;
		_values[20] = tabPosition;
		_values[21] = tabWidth;
		_values[22] = wheelIncrement;
		_values[23] = type;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.activeTab = (String) _values[1];
		this.handleConfig("activeTab", this.activeTab);
		this.animScroll = (Boolean) _values[2];
		this.handleConfig("animScroll", this.animScroll);
		this.autoTabSelector = (String) _values[3];
		this.handleConfig("autoTabSelector", this.autoTabSelector);
		this.autoTabs = (Boolean) _values[4];
		this.handleConfig("autoTabs", this.autoTabs);
		this.baseCls = (String) _values[5];
		this.handleConfig("baseCls", this.baseCls);
		this.deferredRender = (Boolean) _values[6];
		this.handleConfig("deferredRender", this.deferredRender);
		this.enableTabScroll = (Boolean) _values[7];
		this.handleConfig("enableTabScroll", this.enableTabScroll);
		this.itemTpl = (Object) _values[8];
		this.handleConfig("itemTpl", this.itemTpl);
		this.layoutConfig = (Object) _values[9];
		this.handleConfig("layoutConfig", this.layoutConfig);
		this.layoutOnTabChange = (Boolean) _values[10];
		this.handleConfig("layoutOnTabChange", this.layoutOnTabChange);
		this.minTabWidth = (Integer) _values[11];
		this.handleConfig("minTabWidth", this.minTabWidth);
		this.monitorResize = (Boolean) _values[12];
		this.handleConfig("monitorResize", this.monitorResize);
		this.plain = (Boolean) _values[13];
		this.handleConfig("plain", this.plain);
		this.resizeTabs = (Boolean) _values[14];
		this.handleConfig("resizeTabs", this.resizeTabs);
		this.scrollDuration = (Float) _values[15];
		this.handleConfig("scrollDuration", this.scrollDuration);
		this.scrollIncrement = (Integer) _values[16];
		this.handleConfig("scrollIncrement", this.scrollIncrement);
		this.scrollRepeatInterval = (Integer) _values[17];
		this.handleConfig("scrollRepeatInterval", this.scrollRepeatInterval);
		this.tabCls = (String) _values[18];
		this.handleConfig("tabCls", this.tabCls);
		this.tabMargin = (Integer) _values[19];
		this.handleConfig("tabMargin", this.tabMargin);
		this.tabPosition = (String) _values[20];
		this.handleConfig("tabPosition", this.tabPosition);
		this.tabWidth = (Integer) _values[21];
		this.handleConfig("tabWidth", this.tabWidth);
		this.wheelIncrement = (Integer) _values[22];
		this.handleConfig("wheelIncrement", this.wheelIncrement);

		this.type = (String) _values[23];
	}
}