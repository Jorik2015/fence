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
  <p>Base class for any 
  <a ext:cls="Ext.Component" href="output/Ext.Component.html">Component</a> that is to be sized as a
  box, using width and height.</p>
  <p>BoxComponent provides automatic box model adjustments for
  sizing and positioning and will work correctly within the
  Component rendering model.</p>
  <p>A BoxComponent may be created as a custom Component which
  encapsulates any HTML element, either a pre-existing element, or
  one that is created to your specifications at render time.
  Usually, to participate in layouts, a Component will need to be a
  
  <b>Box</b>Component in order to have its width and height
  managed.</p>
  <p>To use a pre-existing element as a BoxComponent, configure it
  so that you preset the 
  <b>el</b> property to the element to reference:</p>
<pre>
<code>
<b>var</b> pageHeader = 
<b>new</b> Ext.BoxComponent({
    el: 
<em>'my-header-div'</em>
});</code>
  </pre>This may then be 
  <a ext:cls="Ext.Container" ext:member="add" href="output/Ext.Container.html#Ext.Container-add">added</a> to a 
  <a ext:cls="Ext.Container" href="output/Ext.Container.html">Container</a> as a child item.
  <br/>
  <br/> 
  <p>To create a BoxComponent based around a HTML element to be
  created at render time, use the 
  <a ext:cls="Ext.Component" ext:member="autoEl" href="output/Ext.Component.html#Ext.Component-autoEl">autoEl</a> config
  option which takes the form of a 
  <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> specification:</p>
<pre>
<code>
<b>var</b> myImage = 
<b>new</b> Ext.BoxComponent({
    autoEl: {
        tag: 
<em>'img'</em>,
        src: 
<em>'/images/my-image.jpg'</em>
    }
});</code>
  </pre>
  <br/>
  <br/>
</div>

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
			region
			,boxMinWidth
			,autoScroll
			,width
			,autoWidth
			,autoHeight
			,boxMinHeight
			,pageX
			,boxMaxHeight
			,flex
			,anchor
			,pageY
			,tabTip
			,height
			,boxMaxWidth
			,y
			,x
			,margins
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
<div class="long">
            <p>
            <b>Note</b>: this config is only used when this
            BoxComponent is rendered by a Container which has been
            configured to use the 
            <b>
              <a ext:cls="Ext.layout.BorderLayout" href="output/Ext.layout.BorderLayout.html">BorderLayout</a>
            </b> layout manager (e.g. specifying 
            <tt>layout:'border'</tt>).</p>
            <br/>
            <p>See 
            <a ext:cls="Ext.layout.BorderLayout" href="output/Ext.layout.BorderLayout.html">Ext.layout.BorderLayout</a>
            also.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The minimum value in pixels which this BoxComponent
            will set its width to.</p>
            <p>
            <b>Warning:</b> This will override any size management
            applied by layout managers.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <code>true</code> to use overflow:'auto' on the
          components layout element and show scroll bars
          automatically when necessary, 
          <code>false</code> to clip any overflowing content
          (defaults to 
          <code>false</code>).</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The width of this component in pixels
          (defaults to auto). 
          <b>Note</b> to express this dimension as a percentage or
          offset see 
          <a ext:cls="Ext.Component" ext:member="anchor" href="output/Ext.Component.html#Ext.Component-anchor">Ext.Component.anchor</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>True to use width:'auto', false to use fixed width (or
          allow it to be managed by its parent Container's 
          <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout
          manager</a>. Defaults to false.</p>
          <p>
          <b>Note</b>: Although many components inherit this config
          option, not all will function as expected with a width of
          'auto'. Setting autoWidth:true means that the browser
          will manage width based on the element's contents, and
          that Ext will not manage it at all.</p>
          <p>If the 
          <i>browser</i> is managing the width, be aware that
          resizes performed by the browser in response to changes
          within the structure of the Component cannot be detected.
          Therefore changes to the width might result in elements
          needing to be synchronized with the new width. For
          example, where the target element is:</p>
<pre>
<code>&lt;div id=
<em>'grid-container'</em> style=
<em>'margin-left:25%;width:50%'</em>&gt;&lt;/div&gt;</code>
          </pre>A Panel rendered into that target element must
          listen for browser window resize in order to relay its
          child items when the browser changes its width:
<pre>
<code>
<b>var</b> myPanel = 
<b>new</b> Ext.Panel({
    renderTo: 
<em>'grid-container'</em>,
    monitorResize: true, 
<i>// relay on browser resize</i>
    title: 
<em>'Panel'</em>,
    height: 400,
    autoWidth: true,
    layout: 
<em>'hbox'</em>,
    layoutConfig: {
        align: 
<em>'stretch'</em>
    },
    defaults: {
        flex: 1
    },
    items: [{
        title: 
<em>'Box 1'</em>,
    }, {
        title: 
<em>'Box 2'</em>
    }, {
        title: 
<em>'Box 3'</em>
    }],
});</code>
          </pre>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>True to use height:'auto', false to use fixed height
            (or allow it to be managed by its parent Container's 
            <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout
            manager</a>. Defaults to false.</p>
            <p>
            <b>Note</b>: Although many components inherit this
            config option, not all will function as expected with a
            height of 'auto'. Setting autoHeight:true means that
            the browser will manage height based on the element's
            contents, and that Ext will not manage it at all.</p>
            <p>If the 
            <i>browser</i> is managing the height, be aware that
            resizes performed by the browser in response to changes
            within the structure of the Component cannot be
            detected. Therefore changes to the height might result
            in elements needing to be synchronized with the new
            height. Example:</p>
<pre>
<code>
<b>var</b> w = 
<b>new</b> Ext.Window({
    title: 
<em>'Window'</em>,
    width: 600,
    autoHeight: true,
    items: {
        title: 
<em>'Collapse Me'</em>,
        height: 400,
        collapsible: true,
        border: false,
        listeners: {
            beforecollapse: 
<b>function</b>() {
                w.el.shadow.hide();
            },
            beforeexpand: 
<b>function</b>() {
                w.el.shadow.hide();
            },
            collapse: 
<b>function</b>() {
                w.syncShadow();
            },
            expand: 
<b>function</b>() {
                w.syncShadow();
            }
        }
    }
}).show();</code>
            </pre>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The minimum value in pixels which this BoxComponent
            will set its height to.</p>
            <p>
            <b>Warning:</b> This will override any size management
            applied by layout managers.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The maximum value in pixels which this BoxComponent
            will set its height to.</p>
            <p>
            <b>Warning:</b> This will override any size management
            applied by layout managers.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <b>Note</b>: this config is only used when this
            Component is rendered by a Container which has been
            configured to use a 
            <b>
            <a ext:cls="Ext.layout.BoxLayout" href="output/Ext.layout.BoxLayout.html">BoxLayout</a>.</b> Each
            child Component with a 
            <code>flex</code> property will be flexed either
            vertically (by a VBoxLayout) or horizontally (by an
            HBoxLayout) according to the item's 
            <b>relative</b> 
            <code>flex</code> value compared to the sum of all
            Components with 
            <code>flex value specified. Any child items that have
            either a</code> flex = 0 or 
            <code>flex = undefined</code> will not be 'flexed' (the
            initial size will not be changed).</p>
          </div>

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
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>
          <b>Note</b>: this config is only used when this Component
          is rendered by a Container which has been configured to
          use an 
          <b>
          <a ext:cls="Ext.layout.AnchorLayout" href="output/Ext.layout.AnchorLayout.html">AnchorLayout</a> (or
          subclass thereof).</b> based layout manager, for
          example:</p>
          <div class="mdetail-params">
            <ul>
              <li>
                <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">Ext.form.FormPanel</a>
              </li>
              <li>specifying 
              <code>layout: 
              <em>'anchor'</em> 
              <i>// or 
              <em>'form'</em>, or 
              <em>'absolute'</em>
</i>
</code>
</li>
            </ul>
          </div>
          <br/>
          <br/> 
          <p>See 
          <a ext:cls="Ext.layout.AnchorLayout" href="output/Ext.layout.AnchorLayout.html">Ext.layout.AnchorLayout</a>.
          <a ext:cls="Ext.layout.AnchorLayout" ext:member="anchor" href="output/Ext.layout.AnchorLayout.html#Ext.layout.AnchorLayout-anchor">anchor</a>
          also.</p>
</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>
          <b>Note</b>: this config is only used when this
          BoxComponent is a child item of a TabPanel.</p>A string
          to be used as innerHTML (html tags are accepted) to show
          in a tooltip when mousing over the associated tab
          selector element. 
          <a ext:cls="Ext.QuickTips" href="output/Ext.QuickTips.html">Ext.QuickTips</a>.init() must be
          called in order for the tips to render.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The height of this component in pixels
          (defaults to auto). 
          <b>Note</b> to express this dimension as a percentage or
          offset see 
          <a ext:cls="Ext.Component" ext:member="anchor" href="output/Ext.Component.html#Ext.Component-anchor">Ext.Component.anchor</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The maximum value in pixels which this BoxComponent
            will set its width to.</p>
            <p>
            <b>Warning:</b> This will override any size management
            applied by layout managers.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>
          <b>Note</b>: this config is only used when this
          BoxComponent is rendered by a Container which has been
          configured to use the 
          <b>
            <a ext:cls="Ext.layout.BorderLayout" href="output/Ext.layout.BorderLayout.html">BorderLayout</a>
          </b> or one of the two 
          <b>
          <a ext:cls="Ext.layout.BoxLayout" href="output/Ext.layout.BoxLayout.html">BoxLayout</a>
          subclasses.</b>
</p>
          <p>An object containing margins to apply to this
          BoxComponent in the format:</p>
<pre>
<code>{
    top: (top margin),
    right: (right margin),
    bottom: (bottom margin),
    left: (left margin)
}</code>
          </pre>
          <p>May also be a string containing space-separated,
          numeric margin values. The order of the sides associated
          with each value matches the way CSS processes margin
          values:</p>
          <div class="mdetail-params">
            <ul>
              <li>If there is only one value, it applies to all
              sides.</li>
              <li>If there are two values, the top and bottom
              borders are set to the first value and the right and
              left are set to the second.</li>
              <li>If there are three values, the top is set to the
              first value, the left and right are set to the
              second, and the bottom is set to the third.</li>
              <li>If there are four values, they apply to the top,
              right, bottom, and left, respectively.</li>
            </ul>
          </div>
          <br/>
          <br/> 
          <p>Defaults to:</p>
<pre>
<code>{top:0, right:0, bottom:0, left:0}</code>
          </pre>
</div>

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