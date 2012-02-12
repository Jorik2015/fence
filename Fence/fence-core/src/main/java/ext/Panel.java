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
    <p>Panel is a container that has specific functionality and
    structural components that make it the perfect building block
    for application-oriented user interfaces.</p>
    <p>Panels are, by virtue of their inheritance from 
    <a ext:cls="Ext.Container" href="output/Ext.Container.html">Ext.Container</a>, capable of being
    configured with a 
    <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>, and
    containing child Components.</p>
    <p>When either specifying child 
    <a ext:cls="Ext.Component" ext:member="items" href="output/Ext.Component.html#Ext.Component-items">items</a> of a
    Panel, or dynamically 
    <a ext:cls="Ext.Container" ext:member="add" href="output/Ext.Container.html#Ext.Container-add">adding</a> Components
    to a Panel, remember to consider how you wish the Panel to
    arrange those child elements, and whether those child elements
    need to be sized using one of Ext's built-in 
    <code>
      <b>
        <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a>
      </b>
    </code> schemes. By default, Panels use the 
    <a ext:cls="Ext.layout.ContainerLayout" href="output/Ext.layout.ContainerLayout.html">ContainerLayout</a>
    scheme. This simply renders child components, appending them
    one after the other inside the Container, and 
    <b>does not apply any sizing</b> at all.</p>
    <p>A Panel may also contain 
    <a ext:cls="Ext.Panel" ext:member="bbar" href="output/Ext.Panel.html#Ext.Panel-bbar">bottom</a> and 
    <a ext:cls="Ext.Panel" ext:member="tbar" href="output/Ext.Panel.html#Ext.Panel-tbar">top</a> toolbars, along
    with separate 
    <a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a>, 
    <a ext:cls="Ext.Panel" ext:member="footer" href="output/Ext.Panel.html#Ext.Panel-footer">footer</a> and 
    <a ext:cls="Ext.Panel" ext:member="body" href="output/Ext.Panel.html#Ext.Panel-body">body</a> sections (see 
    <a ext:cls="Ext.Panel" ext:member="frame" href="output/Ext.Panel.html#Ext.Panel-frame">frame</a> for additional
    information).</p>
    <p>Panel also provides built-in 
    <a ext:cls="Ext.Panel" ext:member="collapsible" href="output/Ext.Panel.html#Ext.Panel-collapsible">expandable and
    collapsible behavior</a>, along with a variety of 
    <a ext:cls="Ext.Panel" ext:member="tools" href="output/Ext.Panel.html#Ext.Panel-tools">prebuilt tool
    buttons</a> that can be wired up to provide other customized
    behavior. Panels can be easily dropped into any 
    <a ext:cls="Ext.Container" href="output/Ext.Container.html">Container</a> or layout, and the layout
    and rendering pipeline is 
    <a ext:cls="Ext.Container" ext:member="add" href="output/Ext.Container.html#Ext.Container-add">completely managed by
    the framework</a>.</p>
  </div>

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
			collapsible
			,baseCls
			,bodyCssClass
			,padding
			,iconCls
			,tools
			,fbar
			,bodyBorder
			,footerCfg
			,shadow
			,tbarCfg
			,applyTo
			,border
			,elements
			,bodyStyle
			,minButtonWidth
			,header
			,toolTemplate
			,collapsed
			,bbar
			,bbarCfg
			,frame
			,collapseFirst
			,bodyCfg
			,floating
			,maskDisabled
			,buttonAlign
			,hideCollapseTool
			,unstyled
			,headerAsText
			,shadowOffset
			,shim
			,preventBodyReset
			,autoHeight
			,collapsedCls
			,tbar
			,title
			,closable
			,autoLoad
			,keys
			,resizeEvent
			,buttons
			,bwrapCfg
			,footer
			,headerCfg
			,titleCollapse
			,animCollapse
			,draggable
			,disabled
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
<div class="long">True to make the panel collapsible and
          have the expand/collapse toggle button automatically
          rendered into the header tool button area, false to keep
          the panel statically sized with no button (defaults to
          false).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The base CSS class to apply to this
          panel's element (defaults to 
          <code>
            <em>'x-panel'</em>
          </code>). 
          <p>Another option available by default is to specify 
          <code>
            <em>'x-plain'</em>
          </code> which strips all styling except for required
          attributes for Ext layouts to function (e.g.
          overflow:hidden). See 
          <code>
            <a ext:cls="Ext.Panel" ext:member="unstyled" href="output/Ext.Panel.html#Ext.Panel-unstyled">unstyled</a>
          </code> also.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Additional css class selector to be
          applied to the 
          <a ext:cls="Ext.Panel" ext:member="body" href="output/Ext.Panel.html#Ext.Panel-body">body</a> element in
          the format expected by 
          <a ext:cls="Ext.Element" ext:member="addClass" href="output/Ext.Element.html#Ext.Element-addClass">Ext.Element.addClass</a> (defaults
          to null). See 
          <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A shortcut for setting a padding style
          on the body element. The value can either be a number to
          be applied to all sides, or a normal css string
          describing padding. Defaults to 
          <tt>undefined</tt>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The CSS class selector that specifies a
          background image to be used as the header icon (defaults
          to ''). 
          <p>An example of specifying a custom icon class would be
          something like:</p>
<pre>
<code>
<i>// specify the property 
<b>in</b> the config 
<b>for</b> the class:</i>
     ...
     iconCls: 
<em>'my-icon'</em>

<i>// css class that specifies background image to be used as the
icon image:</i>
.my-icon { background-image: url(../images/my-icon.gif) 0 6px
no-repeat !important; }</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array of tool button configs to be
          added to the header tool area. When rendered, each tool
          is stored as an 
          <a ext:cls="Ext.Element" href="output/Ext.Element.html">Element</a> referenced by a public
          property called 
          <code>tools.
          <i>&lt;tool-type&gt;</i>
</code> 
          <p>Each tool config may contain the following
          properties:</p>
          <div class="mdetail-params">
            <ul>
              <li>
              <b>id</b> : String
              <div class="sub-desc">
              <b>Required.</b> The type of tool to create. By
              default, this assigns a CSS class of the form 
              <code>x-tool-
              <i>&lt;tool-type&gt;</i>
</code> to the resulting tool
              Element. Ext provides CSS rules, and an icon sprite
              containing images for the tool types listed below.
              The developer may implement custom tools by supplying
              alternate CSS rules and background images: 
              <div style="margin-left: 2em">
                <div>
                <code>toggle</code> (Created by default when 
                <a ext:cls="Ext.Panel" ext:member="collapsible" href="output/Ext.Panel.html#Ext.Panel-collapsible">collapsible</a> is 
                <code>true</code>)</div>
                <div>
                  <code>close</code>
                </div>
                <div>
                  <code>minimize</code>
                </div>
                <div>
                  <code>maximize</code>
                </div>
                <div>
                  <code>restore</code>
                </div>
                <div>
                  <code>gear</code>
                </div>
                <div>
                  <code>pin</code>
                </div>
                <div>
                  <code>unpin</code>
                </div>
                <div>
                  <code>right</code>
                </div>
                <div>
                  <code>left</code>
                </div>
                <div>
                  <code>up</code>
                </div>
                <div>
                  <code>down</code>
                </div>
                <div>
                  <code>refresh</code>
                </div>
                <div>
                  <code>minus</code>
                </div>
                <div>
                  <code>plus</code>
                </div>
                <div>
                  <code>help</code>
                </div>
                <div>
                  <code>search</code>
                </div>
                <div>
                  <code>save</code>
                </div>
                <div>
                  <code>print</code>
                </div>
              </div>
</div>
</li>
              <li>
              <b>handler</b> : Function
              <div class="sub-desc">
              <b>Required.</b> The function to call when clicked.
              Arguments passed are:
              <ul>
                <li>
                <b>event</b> : Ext.EventObject
                <div class="sub-desc">The click event.</div>
</li>
                <li>
                <b>toolEl</b> : Ext.Element
                <div class="sub-desc">The tool Element.</div>
</li>
                <li>
                <b>panel</b> : Ext.Panel
                <div class="sub-desc">The host Panel</div>
</li>
                <li>
                <b>tc</b> : Object
                <div class="sub-desc">The tool configuration
                object</div>
</li>
              </ul>
</div>
</li>
              <li>
              <b>stopEvent</b> : Boolean
              <div class="sub-desc">Defaults to true. Specify as
              false to allow click event to propagate.</div>
</li>
              <li>
              <b>scope</b> : Object
              <div class="sub-desc">The scope in which to call the
              handler.</div>
</li>
              <li>
              <b>qtip</b> : String/Object
              <div class="sub-desc">A tip string, or a config
              argument to 
              <a ext:cls="Ext.QuickTip" ext:member="register" href="output/Ext.QuickTip.html#Ext.QuickTip-register">Ext.QuickTip.register</a>
</div>
</li>
              <li>
              <b>hidden</b> : Boolean
              <div class="sub-desc">True to initially render
              hidden.</div>
</li>
              <li>
              <b>on</b> : Object
              <div class="sub-desc">A listener config object
              specifiying event listeners in the format of an
              argument to 
              <a ext:cls="Ext.Panel" ext:member="addListener" href="output/Ext.Panel.html#Ext.Panel-addListener">addListener</a>
</div>
</li>
            </ul>
          </div>
          <p>Note that, apart from the toggle tool which is
          provided when a panel is collapsible, these tools only
          provide the visual button. Any required functionality
          must be provided by adding handlers that implement the
          necessary behavior.</p>
          <p>Example usage:</p>
<pre>
<code>tools:[{
    id:
<em>'refresh'</em>,
    qtip: 
<em>'Refresh form Data'</em>,
    
<i>// hidden:true,</i>
    handler: 
<b>function</b>(event, toolEl, panel){
        
<i>// refresh logic</i>
    }
},
{
    id:
<em>'help'</em>,
    qtip: 
<em>'Get Help'</em>,
    handler: 
<b>function</b>(event, toolEl, panel){
        
<i>// whatever</i>
    }
}]</code>
          </pre>
          <p>For the custom id of 
          <code>
            <em>'help'</em>
          </code> define two relevant css classes with a link to a
          15x15 image:</p>
<pre>
<code>.x-tool-help {background-image: url(images/help.png);}
.x-tool-help-over {background-image: url(images/help_over.png);}
<i>// 
<b>if</b> using an image sprite:</i>
.x-tool-help {background-image: url(images/help.png) no-repeat 0
0;}
.x-tool-help-over {background-position:-15px 0;}</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>A 
          <a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Toolbar</a> object, a Toolbar
          config, or an array of 
          <a ext:cls="Ext.Button" href="output/Ext.Button.html">Button</a>s/
          <a ext:cls="Ext.Button" href="output/Ext.Button.html">Button</a> configs, describing a 
          <a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Toolbar</a> to be rendered into
          this Panel's footer element.</p>
          <p>After render, the 
          <code>fbar</code> property will be an 
          <a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Toolbar</a> instance.</p>
          <p>If 
          <code>
            <a ext:cls="Ext.Panel" ext:member="buttons" href="output/Ext.Panel.html#Ext.Panel-buttons">buttons</a>
          </code> are specified, they will supersede the 
          <code>fbar</code> configuration property.</p>The Panel's 
          <code>
            <a ext:cls="Ext.Panel" ext:member="buttonAlign" href="output/Ext.Panel.html#Ext.Panel-buttonAlign">buttonAlign</a>
          </code> configuration affects the layout of these items,
          for example: 
<pre>
<code>
<b>var</b> w = 
<b>new</b> Ext.Window({
    height: 250,
    width: 500,
    bbar: 
<b>new</b> Ext.Toolbar({
        items: [{
            text: 
<em>'bbar Left'</em>
        },
<em>'-&gt;'</em>,{
            text: 
<em>'bbar Right'</em>
        }]
    }),
    
<a ext:cls="Ext.Panel" ext:member="buttonAlign" href="output/Ext.Panel.html#Ext.Panel-buttonAlign">buttonAlign</a>: 
<em>'left'</em>, 
<i>// anything but 
<em>'center'</em> or 
<em>'right'</em> and you can use 
<em>'-'</em>, and 
<em>'-&gt;'</em>
</i>
                                  
<i>// to control the alignment of fbar items</i>
    fbar: [{
        text: 
<em>'fbar Left'</em>
    },
<em>'-&gt;'</em>,{
        text: 
<em>'fbar Right'</em>
    }]
}).show();</code>
          </pre>
          <p>
          <b>Note:</b> Although a Toolbar may contain Field
          components, these will 
          <b>not</b> be updated by a load of an ancestor FormPanel.
          A Panel's toolbars are not part of the standard
          Container-&gt;Component hierarchy, and so are not scanned
          to collect form items. However, the values 
          <b>will</b> be submitted because form submission
          parameters are collected from the DOM tree.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to display an interior border on
          the body element of the panel, false to hide it (defaults
          to true). This only applies when 
          <a ext:cls="Ext.Panel" ext:member="border" href="output/Ext.Panel.html#Ext.Panel-border">border</a> ==
          true. If border == true and bodyBorder == false, the
          border will display as a 1px wide inset border, giving
          the entire body element an inset appearance.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element
            specification object specifying the element structure
            of this Panel's 
            <a ext:cls="Ext.Panel" ext:member="footer" href="output/Ext.Panel.html#Ext.Panel-footer">footer</a>
            Element. See 
            <code>
              <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>
            </code> also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> (or a valid Ext.Shadow 
          <a ext:cls="Ext.Shadow" ext:member="mode" href="output/Ext.Shadow.html#Ext.Shadow-mode">Ext.Shadow.mode</a> value) to
          display a shadow behind the panel, 
          <code>false</code> to display no shadow (defaults to 
          <code>
            <em>'sides'</em>
          </code>). Note that this option only applies when 
          <code>
          <a ext:cls="Ext.Panel" ext:member="floating" href="output/Ext.Panel.html#Ext.Panel-floating">floating</a> =
          true</code>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element
            specification object specifying the element structure
            of this Panel's 
            <a ext:cls="Ext.Panel" ext:member="tbar" href="output/Ext.Panel.html#Ext.Panel-tbar">tbar</a> Element.
            See 
            <code>
              <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>
            </code> also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The id of the node, a DOM node or an existing
            Element corresponding to a DIV that is already present
            in the document that specifies some panel-specific
            structural markup. When 
            <code>applyTo</code> is used, constituent parts of the
            panel can be specified by CSS class name within the
            main element, and the panel will automatically create
            those components from that markup. Any required
            components not specified in the markup will be
            autogenerated if necessary.</p>
            <p>The following class names are supported (baseCls
            will be replaced by 
            <a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>):</p>
            <ul>
              <li>baseCls + '-header'</li>
              <li>baseCls + '-header-text'</li>
              <li>baseCls + '-bwrap'</li>
              <li>baseCls + '-tbar'</li>
              <li>baseCls + '-body'</li>
              <li>baseCls + '-bbar'</li>
              <li>baseCls + '-footer'</li>
            </ul>
            <p>Using this config, a call to render() is not
            required. If applyTo is specified, any value passed for
            
            <a ext:cls="Ext.Panel" ext:member="renderTo" href="output/Ext.Panel.html#Ext.Panel-renderTo">renderTo</a>
            will be ignored and the target element's parent node
            will automatically be used as the panel's
            container.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to display the borders of the
          panel's body element, false to hide them (defaults to
          true). By default, the border is a 2px wide inset border,
          but this can be further altered by setting 
          <a ext:cls="Ext.Panel" ext:member="bodyBorder" href="output/Ext.Panel.html#Ext.Panel-bodyBorder">bodyBorder</a> to false.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A comma-delimited list of panel
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
          <div class="mdetail-params">
            <ul>
              <li>
                <code>header</code>
              </li>
              <li>
              <code>tbar</code> (top bar)</li>
              <li>
                <code>body</code>
              </li>
              <li>
              <code>bbar</code> (bottom bar)</li>
              <li>
                <code>footer</code>
              </li>
            </ul>
          </div>Defaults to '
          <code>body</code>'.</div>

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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Custom CSS styles to be applied to the 
          <a ext:cls="Ext.Panel" ext:member="body" href="output/Ext.Panel.html#Ext.Panel-body">body</a> element in
          the format expected by 
          <a ext:cls="Ext.Element" ext:member="applyStyles" href="output/Ext.Element.html#Ext.Element-applyStyles">Ext.Element.applyStyles</a>
          (defaults to null). See 
          <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to create the Panel's header element
          explicitly, 
          <code>false</code> to skip creating it. If a 
          <code>
            <a ext:cls="Ext.Panel" ext:member="title" href="output/Ext.Panel.html#Ext.Panel-title">title</a>
          </code> is set the header will be created automatically,
          otherwise it will not. If a 
          <code>
            <a ext:cls="Ext.Panel" ext:member="title" href="output/Ext.Panel.html#Ext.Panel-title">title</a>
          </code> is set but 
          <code>header</code> is explicitly set to 
          <code>false</code>, the header will not be
          rendered.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A Template used to create 
            <a ext:cls="Ext.Panel" ext:member="tools" href="output/Ext.Panel.html#Ext.Panel-tools">tools</a> in the
            
            <a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a>
            Element. Defaults to:</p>
<pre>
<code>
<b>new</b> Ext.Template(
<em>'&lt;div class=</em>"x-tool
x-tool-{id}"</code>&gt;&amp;#160;&lt;/div&gt;')
            </pre>
            <p>This may may be overridden to provide a custom DOM
            structure for tools based upon a more complex
            XTemplate. The template's data is a single tool
            configuration object (Not the entire Array) as
            specified in 
            <a ext:cls="Ext.Panel" ext:member="tools" href="output/Ext.Panel.html#Ext.Panel-tools">tools</a>. In
            the following example an &lt;a&gt; tag is used to
            provide a visual indication when hovering over the
            tool:</p>
<pre>
<code>
<b>var</b> win = 
<b>new</b> Ext.Window({
    tools: [{
        id: 
<em>'download'</em>,
        href: 
<em>'/MyPdfDoc.pdf'</em>
    }],
    toolTemplate: 
<b>new</b> Ext.XTemplate(
        
<em>'&lt;tpl 
<b>if</b>=</em>"id==\'</code>download\
<em>'"</em>&gt;',
            
<em>'&lt;a class=</em>"x-tool x-tool-pdf" href=
<em>"{href}"</em>&gt;&lt;/a&gt;',
        
<em>'&lt;/tpl&gt;'</em>,
        
<em>'&lt;tpl 
<b>if</b>=</em>"id!=\'download\
<em>'"</em>&gt;',
            
<em>'&lt;div class=</em>"x-tool
x-tool-{id}"&gt;&amp;#160;&lt;/div&gt;',
        
<em>'&lt;/tpl&gt;'</em>
    ),
    width:500,
    height:300,
    closeAction:
<em>'hide'</em>
});
            </pre>
            <p>Note that the CSS class 'x-tool-pdf' should have an
            associated style rule which provides an appropriate
            background image, something like:</p>
<pre>
<code>a.x-tool-pdf {background-image:
url(../shared/extjs/images/pdf.gif)!important;}</code>
            </pre>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The bottom toolbar of the panel. This can be a 
            <a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Ext.Toolbar</a> object, a toolbar
            config, or an array of buttons/button configs to be
            added to the toolbar. Note that this is not available
            as a property after render. To access the bottom
            toolbar after render, use 
            <a ext:cls="Ext.Panel" ext:member="getBottomToolbar" href="output/Ext.Panel.html#Ext.Panel-getBottomToolbar">getBottomToolbar</a>.</p>
            <p>
            <b>Note:</b> Although a Toolbar may contain Field
            components, these will 
            <b>not</b> be updated by a load of an ancestor
            FormPanel. A Panel's toolbars are not part of the
            standard Container-&gt;Component hierarchy, and so are
            not scanned to collect form items. However, the values 
            <b>will</b> be submitted because form submission
            parameters are collected from the DOM tree.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element
            specification object specifying the element structure
            of this Panel's 
            <a ext:cls="Ext.Panel" ext:member="bbar" href="output/Ext.Panel.html#Ext.Panel-bbar">bbar</a> Element.
            See 
            <code>
              <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>
            </code> also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>false</code> by default to render with plain 1px
          square borders. 
          <code>true</code> to render with 9 elements, complete
          with custom rounded corners (also see 
          <a ext:cls="Ext.Element" ext:member="boxWrap" href="output/Ext.Element.html#Ext.Element-boxWrap">Ext.Element.boxWrap</a>). 
          <p>The template generated for each condition is depicted
          below:</p>
<pre>
<code>
<i>// frame = false</i>
&lt;div id=
<em>"developer-specified-id-goes-here"</em> class=
<em>"x-panel"</em>&gt;

    &lt;div class=
<em>"x-panel-header"</em>&gt;&lt;span class=
<em>"x-panel-header-text"</em>&gt;Title:
(frame:false)&lt;/span&gt;&lt;/div&gt;

    &lt;div class=
<em>"x-panel-bwrap"</em>&gt;
        &lt;div class=
<em>"x-panel-body"</em>&gt;&lt;p&gt;html value goes
here&lt;/p&gt;&lt;/div&gt;
    &lt;/div&gt;
&lt;/div&gt;

<i>// frame = true (create 9 elements)</i>
&lt;div id=
<em>"developer-specified-id-goes-here"</em> class=
<em>"x-panel"</em>&gt;
    &lt;div class=
<em>"x-panel-tl"</em>&gt;&lt;div class=
<em>"x-panel-tr"</em>&gt;&lt;div class=
<em>"x-panel-tc"</em>&gt;
        &lt;div class=
<em>"x-panel-header"</em>&gt;&lt;span class=
<em>"x-panel-header-text"</em>&gt;Title:
(frame:true)&lt;/span&gt;&lt;/div&gt;
    &lt;/div&gt;&lt;/div&gt;&lt;/div&gt;

    &lt;div class=
<em>"x-panel-bwrap"</em>&gt;
        &lt;div class=
<em>"x-panel-ml"</em>&gt;&lt;div class=
<em>"x-panel-mr"</em>&gt;&lt;div class=
<em>"x-panel-mc"</em>&gt;
            &lt;div class=
<em>"x-panel-body"</em>&gt;&lt;p&gt;html value goes
here&lt;/p&gt;&lt;/div&gt;
        &lt;/div&gt;&lt;/div&gt;&lt;/div&gt;

        &lt;div class=
<em>"x-panel-bl"</em>&gt;&lt;div class=
<em>"x-panel-br"</em>&gt;&lt;div class=
<em>"x-panel-bc"</em>/&gt;
        &lt;/div&gt;&lt;/div&gt;&lt;/div&gt;
&lt;/div&gt;</code>
          </pre>
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to make sure the collapse/expand toggle
          button always renders first (to the left of) any other
          tools in the panel's title bar, 
          <code>false</code> to render it last (defaults to 
          <code>true</code>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element
            specification object may be specified for any Panel
            Element.</p>
            <p>By default, the Default element in the table below
            will be used for the html markup to create a child
            element with the commensurate Default class name (
            <code>baseCls</code> will be replaced by 
            <code>
              <a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>
            </code>):</p>
<pre>
Panel      Default  Default             Custom      Additional     
 Additional
Element    element  class               element     class          
 style
========   ==========================   =========   ============== 
 ===========
<a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a>     div      
<a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>+'-header'   
<a ext:cls="Ext.Panel" ext:member="headerCfg" href="output/Ext.Panel.html#Ext.Panel-headerCfg">headerCfg</a>  
headerCssClass   headerStyle
<a ext:cls="Ext.Panel" ext:member="bwrap" href="output/Ext.Panel.html#Ext.Panel-bwrap">bwrap</a>      div      
<a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>+'-bwrap'     
<a ext:cls="Ext.Panel" ext:member="bwrapCfg" href="output/Ext.Panel.html#Ext.Panel-bwrapCfg">bwrapCfg</a>   
bwrapCssClass    bwrapStyle
+ tbar     div      
<a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>+'-tbar'       
<a ext:cls="Ext.Panel" ext:member="tbarCfg" href="output/Ext.Panel.html#Ext.Panel-tbarCfg">tbarCfg</a>    
tbarCssClass     tbarStyle
+ 
<a ext:cls="Ext.Panel" ext:member="body" href="output/Ext.Panel.html#Ext.Panel-body">body</a>     div      
<a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>+'-body'       
<a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>     
<a ext:cls="Ext.Panel" ext:member="bodyCssClass" href="output/Ext.Panel.html#Ext.Panel-bodyCssClass">bodyCssClass</a>     
<a ext:cls="Ext.Panel" ext:member="bodyStyle" href="output/Ext.Panel.html#Ext.Panel-bodyStyle">bodyStyle</a>
+ bbar     div      
<a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>+'-bbar'       
<a ext:cls="Ext.Panel" ext:member="bbarCfg" href="output/Ext.Panel.html#Ext.Panel-bbarCfg">bbarCfg</a>    
bbarCssClass     bbarStyle
+ 
<a ext:cls="Ext.Panel" ext:member="footer" href="output/Ext.Panel.html#Ext.Panel-footer">footer</a>   div      
<a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>+'-footer'   
<a ext:cls="Ext.Panel" ext:member="footerCfg" href="output/Ext.Panel.html#Ext.Panel-footerCfg">footerCfg</a>  
footerCssClass   footerStyle
            </pre>
            <p>Configuring a Custom element may be used, for
            example, to force the 
            <a ext:cls="Ext.Panel" ext:member="body" href="output/Ext.Panel.html#Ext.Panel-body">body</a> Element
            to use a different form of markup than is created by
            default. An example of this might be to 
            <a ext:cls="Ext.Element" ext:member="createChild" href="output/Ext.Element.html#Ext.Element-createChild">create a
            child</a> Panel containing a custom content, such as a
            header, or forcing centering of all Panel content by
            having the body be a &lt;center&gt; element:</p>
<pre>
<code>
<b>new</b> Ext.Panel({
    title: 
<em>'Message Title'</em>,
    renderTo: Ext.getBody(),
    width: 200, height: 130,
    
<b>bodyCfg</b>: {
        tag: 
<em>'center'</em>,
        cls: 
<em>'x-panel-body'</em>,  
<i>// Default class not applied 
<b>if</b> Custom element specified</i>
        html: 
<em>'Message'</em>
    },
    footerCfg: {
        tag: 
<em>'h2'</em>,
        cls: 
<em>'x-panel-footer'</em>,        
<i>// same as the Default class</i>
        html: 
<em>'footer html'</em>
    },
    footerCssClass: 
<em>'custom-footer'</em>, 
<i>// additional css class, see 
<a ext:cls="Ext.element" ext:member="addClass" href="output/Ext.element.html#Ext.element-addClass">addClass</a>
</i>
    footerStyle:    
<em>'background-color:red'</em> 
<i>// see 
<a ext:cls="Ext.Panel" ext:member="bodyStyle" href="output/Ext.Panel.html#Ext.Panel-bodyStyle">bodyStyle</a>
</i>
});</code>
            </pre>
            <p>The example above also explicitly creates a 
            <code>
              <a ext:cls="Ext.Panel" ext:member="footer" href="output/Ext.Panel.html#Ext.Panel-footer">footer</a>
            </code> with custom markup and styling applied.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>This property is used to configure the underlying 
            <a ext:cls="Ext.Layer" href="output/Ext.Layer.html">Ext.Layer</a>. Acceptable values
            for this configuration property are:</p>
            <div class="mdetail-params">
              <ul>
                <li>
                <b>
                  <code>false</code>
                </b> : 
                <b>Default.</b>
                <div class="sub-desc">Display the panel inline
                where it is rendered.</div>
</li>
                <li>
                <b>
                  <code>true</code>
                </b> : 
                <div class="sub-desc">Float the panel (absolute
                position it with automatic shimming and shadow).
                <div style="margin-left: 2em">
                  <div class="sub-desc">Setting floating to true
                  will create an Ext.Layer for this panel and
                  display the panel at negative offsets so that it
                  is hidden.</div>
                  <div class="sub-desc">Since the panel will be
                  absolute positioned, the position must be set
                  explicitly 
                  <i>after</i> render (e.g., 
                  <code>myPanel.setPosition(100,100);</code>).</div>
                  <div class="sub-desc">
                  <b>Note</b>: when floating a panel you should
                  always assign a fixed width, otherwise it will be
                  auto width and will expand to fill to the right
                  edge of the viewport.</div>
                </div>
</div>
</li>
                <li>
                <b>
                  <code>
                    <a ext:cls="Ext.Layer" href="output/Ext.Layer.html">object</a>
                  </code>
                </b> : 
                <div class="sub-desc">The specified object will be
                used as the configuration object for the 
                <a ext:cls="Ext.Layer" href="output/Ext.Layer.html">Ext.Layer</a> that will be
                created.</div>
</li>
              </ul>
            </div>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to mask the panel when it is 
          <a ext:cls="Ext.Panel" ext:member="disabled" href="output/Ext.Panel.html#Ext.Panel-disabled">disabled</a>, 
          <code>false</code> to not mask it (defaults to 
          <code>true</code>). Either way, the panel will always
          tell its contained elements to disable themselves when it
          is disabled, but masking the panel can provide an
          additional visual cue that the panel is disabled.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The alignment of any 
          <a ext:cls="Ext.Panel" ext:member="buttons" href="output/Ext.Panel.html#Ext.Panel-buttons">buttons</a>
          added to this panel. Valid values are 
          <code>
            <em>'right'</em>
          </code>, 
          <code>
            <em>'left'</em>
          </code> and 
          <code>
            <em>'center'</em>
          </code> (defaults to 
          <code>
            <em>'right'</em>
          </code>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Overrides the 
          <code>
            <a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a>
          </code> setting to 
          <code>
          <a ext:cls="Ext.Panel" ext:member="baseCls" href="output/Ext.Panel.html#Ext.Panel-baseCls">baseCls</a> = 
          <em>'x-plain'</em>
</code> which renders the panel
          unstyled except for required attributes for Ext layouts
          to function (e.g. overflow:hidden).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The number of pixels to offset the
          shadow if displayed (defaults to 
          <code>4</code>). Note that this option only applies when 
          <code>
          <a ext:cls="Ext.Panel" ext:member="floating" href="output/Ext.Panel.html#Ext.Panel-floating">floating</a> =
          true</code>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>false</code> to disable the iframe shim in browsers
          which need one (defaults to 
          <code>true</code>). Note that this option only applies
          when 
          <code>
          <a ext:cls="Ext.Panel" ext:member="floating" href="output/Ext.Panel.html#Ext.Panel-floating">floating</a> =
          true</code>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Defaults to 
          <code>false</code>. When set to 
          <code>true</code>, an extra css class 
          <code>
            <em>'x-panel-normal'</em>
          </code> will be added to the panel's element, effectively
          applying css styles suggested by the W3C (see
          http://www.w3.org/TR/CSS21/sample.html) to the Panel's 
          <b>body</b> element (not the header, footer, etc.).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to use height:'auto', 
          <code>false</code> to use fixed height (defaults to 
          <code>false</code>). 
          <b>Note</b>: Setting 
          <code>autoHeight: true</code> means that the browser will
          manage the panel's height based on its contents, and that
          Ext will not manage it at all. If the panel is within a
          layout that manages dimensions (
          <code>fit</code>, 
          <code>border</code>, etc.) then setting 
          <code>autoHeight: true</code> can cause issues with
          scrolling and will not generally work as expected since
          the panel will take on the height of its contents rather
          than the height required by the Ext layout.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The top toolbar of the panel. This can be a 
            <a ext:cls="Ext.Toolbar" href="output/Ext.Toolbar.html">Ext.Toolbar</a> object, a toolbar
            config, or an array of buttons/button configs to be
            added to the toolbar. Note that this is not available
            as a property after render. To access the top toolbar
            after render, use 
            <a ext:cls="Ext.Panel" ext:member="getTopToolbar" href="output/Ext.Panel.html#Ext.Panel-getTopToolbar">getTopToolbar</a>.</p>
            <p>
            <b>Note:</b> Although a Toolbar may contain Field
            components, these will 
            <b>not</b> be updated by a load of an ancestor
            FormPanel. A Panel's toolbars are not part of the
            standard Container-&gt;Component hierarchy, and so are
            not scanned to collect form items. However, the values 
            <b>will</b> be submitted because form submission
            parameters are collected from the DOM tree.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The title text to be used as innerHTML
          (html tags are accepted) to display in the panel 
          <code>
            <a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a>
          </code> (defaults to ''). When a 
          <code>title</code> is specified the 
          <code>
            <a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a>
          </code> element will automatically be created and
          displayed unless 
          <a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a> is
          explicitly set to 
          <code>false</code>. If you do not want to specify a 
          <code>title</code> at config time, but you may want one
          later, you must either specify a non-empty 
          <code>title</code> (a blank space ' ' will do) or 
          <code>header:true</code> so that the container element
          will get created.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Panels themselves do not directly
          support being closed, but some Panel subclasses do (like 
          <a ext:cls="Ext.Window" href="output/Ext.Window.html">Ext.Window</a>) or a Panel Class
          within an 
          <a ext:cls="Ext.TabPanel" href="output/Ext.TabPanel.html">Ext.TabPanel</a>. Specify 
          <code>true</code> to enable closing in such situations.
          Defaults to 
          <code>false</code>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A valid url spec according to the
          Updater 
          <a ext:cls="Ext.Updater" ext:member="update" href="output/Ext.Updater.html#Ext.Updater-update">Ext.Updater.update</a> method. If
          autoLoad is not null, the panel will attempt to load its
          contents immediately upon render.
          <p>The URL will become the default URL for this panel's 
          <a ext:cls="Ext.Panel" ext:member="body" href="output/Ext.Panel.html#Ext.Panel-body">body</a> element,
          so it may be 
          <a ext:cls="Ext.Element" ext:member="refresh" href="output/Ext.Element.html#Ext.Element-refresh">refresh</a>ed
          at any time.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A 
          <a ext:cls="Ext.KeyMap" href="output/Ext.KeyMap.html">Ext.KeyMap</a> config object (in the
          format expected by 
          <a ext:cls="Ext.KeyMap" ext:member="addBinding" href="output/Ext.KeyMap.html#Ext.KeyMap-addBinding">Ext.KeyMap.addBinding</a> used to
          assign custom key handling to this panel (defaults to 
          <code>null</code>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>buttons</code> will be used as 
          <code>
            <a ext:cls="Ext.Container" ext:member="items" href="output/Ext.Container.html#Ext.Container-items">items</a>
          </code> for the toolbar in the footer (
          <code>
            <a ext:cls="Ext.Panel" ext:member="fbar" href="output/Ext.Panel.html#Ext.Panel-fbar">fbar</a>
          </code>). Typically the value of this configuration
          property will be an array of 
          <a ext:cls="Ext.Button" href="output/Ext.Button.html">Ext.Button</a>s or 
          <a ext:cls="Ext.Button" href="output/Ext.Button.html">Ext.Button</a> configuration
          objects. If an item is configured with 
          <code>minWidth</code> or the Panel is configured with 
          <code>minButtonWidth</code>, that width will be applied
          to the item.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element
            specification object specifying the element structure
            of this Panel's 
            <a ext:cls="Ext.Panel" ext:member="bwrap" href="output/Ext.Panel.html#Ext.Panel-bwrap">bwrap</a>
            Element. See 
            <code>
              <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>
            </code> also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to create the footer element
          explicitly, false to skip creating it. The footer will be
          created automatically if 
          <code>
            <a ext:cls="Ext.Panel" ext:member="buttons" href="output/Ext.Panel.html#Ext.Panel-buttons">buttons</a>
          </code> or a 
          <code>
            <a ext:cls="Ext.Panel" ext:member="fbar" href="output/Ext.Panel.html#Ext.Panel-fbar">fbar</a>
          </code> have been configured. See 
          <code>
            <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>
          </code> for an example.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>A 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element
            specification object specifying the element structure
            of this Panel's 
            <a ext:cls="Ext.Panel" ext:member="header" href="output/Ext.Panel.html#Ext.Panel-header">header</a>
            Element. See 
            <code>
              <a ext:cls="Ext.Panel" ext:member="bodyCfg" href="output/Ext.Panel.html#Ext.Panel-bodyCfg">bodyCfg</a>
            </code> also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to allow expanding and collapsing the
          panel (when 
          <code>
          <a ext:cls="Ext.Panel" ext:member="collapsible" href="output/Ext.Panel.html#Ext.Panel-collapsible">collapsible</a> = true</code>) by
          clicking anywhere in the header bar, 
          <code>false</code>) to allow it only by clicking to tool
          button (defaults to 
          <code>false</code>)). If this panel is a child item of a
          border layout also see the 
          <a ext:cls="Ext.layout.BorderLayout.Region" href="output/Ext.layout.BorderLayout.Region.html">BorderLayout.Region</a>
          
          <code>
            <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="floatable" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-floatable">floatable</a>
          </code> config option.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to animate the transition when the
          panel is collapsed, 
          <code>false</code> to skip the animation (defaults to 
          <code>true</code> if the 
          <a ext:cls="Ext.Fx" href="output/Ext.Fx.html">Ext.Fx</a>
          class is available, otherwise 
          <code>false</code>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <code>true</code> to enable dragging of this Panel
            (defaults to 
            <code>false</code>).</p>
            <p>For custom drag/drop implementations, an 
            <b>Ext.Panel.DD</b> config could also be passed in this
            config instead of 
            <code>true</code>. Ext.Panel.DD is an internal,
            undocumented class which moves a proxy Element around
            in place of the Panel's element, but provides no other
            behaviour during dragging or on drop. It is a subclass
            of 
            <a ext:cls="Ext.dd.DragSource" href="output/Ext.dd.DragSource.html">Ext.dd.DragSource</a>, so
            behaviour may be added by implementing the interface
            methods of 
            <a ext:cls="Ext.dd.DragDrop" href="output/Ext.dd.DragDrop.html">Ext.dd.DragDrop</a> e.g.:</p>
<pre>
<code>
<b>new</b> Ext.Panel({
    title: 
<em>'Drag me'</em>,
    x: 100,
    y: 100,
    renderTo: Ext.getBody(),
    floating: true,
    frame: true,
    width: 400,
    height: 200,
    draggable: {
<i>//      Config option of Ext.Panel.DD class.</i>
<i>//      It's a floating Panel, so 
<b>do</b> not show a placeholder proxy 
<b>in</b> the original position.</i>
        insertProxy: false,

<i>//      Called 
<b>for</b> each mousemove event 
<b>while</b> dragging the DD object.</i>
        onDrag : 
<b>function</b>(e){
<i>//          Record the x,y position of the drag proxy so that we
can</i>
<i>//          position the Panel at end of drag.</i>
            
<b>var</b> pel = this.proxy.getEl();
            this.x = pel.getLeft(true);
            this.y = pel.getTop(true);

<i>//          Keep the Shadow aligned 
<b>if</b> there is one.</i>
            
<b>var</b> s = this.panel.getEl().shadow;
            
<b>if</b> (s) {
                s.realign(this.x, this.y, pel.getWidth(),
pel.getHeight());
            }
        },

<i>//      Called on the mouseup event.</i>
        endDrag : 
<b>function</b>(e){
            this.panel.setPosition(this.x, this.y);
        }
    }
}).show();</code>
            </pre>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Render this panel disabled (default is 
          <code>false</code>). An important note when using the
          disabled config on panels is that IE will often fail to
          initialize the disabled mask element correectly if the
          panel's layout has not yet completed by the time the
          Panel is disabled during the render process. If you
          experience this issue, you may need to instead use the 
          <a ext:cls="Ext.Panel" ext:member="afterlayout" href="output/Ext.Panel.html#Ext.Panel-afterlayout">afterlayout</a> event to initialize
          the disabled state: 
<pre>
<code>
<b>new</b> Ext.Panel({
    ...
    listeners: {
        
<em>'afterlayout'</em>: {
            fn: 
<b>function</b>(p){
                p.disable();
            },
            single: true 
<i>// important, as many layouts can occur</i>
        }
    }
});</code>
          </pre>
</div>

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