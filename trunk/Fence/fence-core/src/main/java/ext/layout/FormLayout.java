package ext.layout;

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
import ext.form.Action;
import java.util.Date;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
  <p>This layout manager is specifically designed for rendering and
  managing child Components of 
  <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">forms</a>. It is responsible for
  rendering the labels of 
  <a ext:cls="Ext.form.Field" href="output/Ext.form.Field.html">Field</a>s.</p>
  <p>This layout manager is used when a Container is configured
  with the 
  <tt>layout:'form'</tt> 
  <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">layout</a> config
  option, and should generally not need to be created directly via
  the new keyword. See 
  <tt>
    <b>
      <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">Ext.Container.layout</a>
    </b>
  </tt> for additional details.</p>
  <p>In an application, it will usually be preferrable to use a 
  <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">FormPanel</a> (which is configured
  with FormLayout as its layout class by default) since it also
  provides built-in functionality for 
  <a ext:cls="Ext.form.BasicForm" ext:member="doAction" href="output/Ext.form.BasicForm.html#Ext.form.BasicForm-doAction">loading,
  validating and submitting</a> the form.</p>
  <p>A 
  <a ext:cls="Ext.Container" href="output/Ext.Container.html">Container</a> 
  <i>using</i> the FormLayout layout manager (e.g. 
  <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">Ext.form.FormPanel</a> or specifying
  
  <tt>layout:'form'</tt>) can also accept the following
  layout-specific config properties:</p>
  <div class="mdetail-params">
    <ul>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.form.FormPanel" ext:member="hideLabels" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-hideLabels">hideLabels</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.form.FormPanel" ext:member="labelAlign" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-labelAlign">labelAlign</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.form.FormPanel" ext:member="labelPad" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-labelPad">labelPad</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.form.FormPanel" ext:member="labelSeparator" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-labelSeparator">labelSeparator</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.form.FormPanel" ext:member="labelWidth" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-labelWidth">labelWidth</a>
          </tt>
        </b>
      </li>
    </ul>
  </div>
  <br/>
  <br/> 
  <p>Any Component (including Fields) managed by FormLayout accepts
  the following as a config option:</p>
  <div class="mdetail-params">
    <ul>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.Component" ext:member="anchor" href="output/Ext.Component.html#Ext.Component-anchor">anchor</a>
          </tt>
        </b>
      </li>
    </ul>
  </div>
  <br/>
  <br/> 
  <p>Any Component managed by FormLayout may be rendered as a form
  field (with an associated label) by configuring it with a
  non-null 
  <b>
    <tt>
      <a ext:cls="Ext.Component" ext:member="fieldLabel" href="output/Ext.Component.html#Ext.Component-fieldLabel">fieldLabel</a>
    </tt>
  </b>. Components configured in this way may be configured with
  the following options which affect the way the FormLayout renders
  them:</p>
  <div class="mdetail-params">
    <ul>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.Component" ext:member="clearCls" href="output/Ext.Component.html#Ext.Component-clearCls">clearCls</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.Component" ext:member="fieldLabel" href="output/Ext.Component.html#Ext.Component-fieldLabel">fieldLabel</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.Component" ext:member="hideLabel" href="output/Ext.Component.html#Ext.Component-hideLabel">hideLabel</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.Component" ext:member="itemCls" href="output/Ext.Component.html#Ext.Component-itemCls">itemCls</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.Component" ext:member="labelSeparator" href="output/Ext.Component.html#Ext.Component-labelSeparator">labelSeparator</a>
          </tt>
        </b>
      </li>
      <li>
        <b>
          <tt>
            <a ext:cls="Ext.Component" ext:member="labelStyle" href="output/Ext.Component.html#Ext.Component-labelStyle">labelStyle</a>
          </tt>
        </b>
      </li>
    </ul>
  </div>
  <br/>
  <br/> 
  <p>Example usage:</p>
<pre>
<code>
<i>// Required 
<b>if</b> showing validation messages</i>
Ext.QuickTips.init();

<i>// While you can create a basic Panel 
<b>with</b> layout:
<em>'form'</em>, practically</i>
<i>// you should usually use a FormPanel to also get its form
functionality</i>
<i>// since it already creates a FormLayout internally.</i>
<b>var</b> form = 
<b>new</b> Ext.form.FormPanel({
    title: 
<em>'Form Layout'</em>,
    bodyStyle: 
<em>'padding:15px'</em>,
    width: 350,
    defaultType: 
<em>'textfield'</em>,
    defaults: {
        
<i>// applied to each contained item</i>
        width: 230,
        msgTarget: 
<em>'side'</em>
    },
    items: [{
            fieldLabel: 
<em>'First Name'</em>,
            name: 
<em>'first'</em>,
            allowBlank: false,
            
<a ext:cls="Ext.Component" ext:member="labelSeparator" href="output/Ext.Component.html#Ext.Component-labelSeparator">labelSeparator</a>: 
<em>':'</em> 
<i>// override labelSeparator layout config</i>
        },{
            fieldLabel: 
<em>'Last Name'</em>,
            name: 
<em>'last'</em>
        },{
            fieldLabel: 
<em>'Email'</em>,
            name: 
<em>'email'</em>,
            vtype:
<em>'email'</em>
        }, {
            xtype: 
<em>'textarea'</em>,
            hideLabel: true,     
<i>// override hideLabels layout config</i>
            name: 
<em>'msg'</em>,
            anchor: 
<em>'100% -53'</em>
        }
    ],
    buttons: [
        {text: 
<em>'Save'</em>},
        {text: 
<em>'Cancel'</em>}
    ],
    layoutConfig: {
        
<a ext:cls="Ext.layout.FormLayout" ext:member="labelSeparator" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelSeparator">labelSeparator</a>: 
<em>'~'</em> 
<i>// superseded by assignment below</i>
    },
    
<i>// config options applicable to container when layout=
<em>'form'</em>:</i>
    hideLabels: false,
    labelAlign: 
<em>'left'</em>,   
<i>// or 
<em>'right'</em> or 
<em>'top'</em>
</i>
    
<a ext:cls="Ext.form.FormPanel" ext:member="labelSeparator" href="output/Ext.form.FormPanel.html#Ext.form.FormPanel-labelSeparator">labelSeparator</a>: 
<em>'&gt;&gt;'</em>, 
<i>// takes precedence over layoutConfig value</i>
    labelWidth: 65,       
<i>// defaults to 100</i>
    labelPad: 8           
<i>// defaults to 5, must specify labelWidth to be honored</i>
});</code>
  </pre>
</div>

 */

@Layout(LayoutType.form)
@InstanceOf("Ext.layout.FormLayout")
@ParseConfigMode(ui = false,name="layoutConfig",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.layout.FormLayout")
public class FormLayout extends AnchorLayout {
	public static final String COMPONENT_FAMILY = "Ext.layout.FormLayout";

	/**
	 * <p>
	 * Create a new {@link Ext.layout.FormLayout} instance with default property values.
	 * </p>
	 */
	public FormLayout() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			fieldTpl
			,labelSeparator
			,trackLabels
			,align
			,extraCls
			,renderHidden
			,pack
			,padding
			,flex
			,defaultMargins
			,tableAttrs
			,columns
			,minHeight
			,collapseMode
			,floatable
			,autoHide
			,minWidth
			,collapsible
			,animFloat
			,split
			,cmargins
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
<div class="long">A 
          <a ext:cls="Ext.Template" ext:member="compile" href="output/Ext.Template.html#Ext.Template-compile">compile</a>d 
          <a ext:cls="Ext.Template" href="output/Ext.Template.html">Ext.Template</a> for rendering the
          fully wrapped, labeled and styled form Field. Defaults
          to:
          <br/>
          <br/>
<pre>
<code>
<b>new</b> Ext.Template(
    '&lt;div class=
<em>"x-form-item {itemCls}"</em> tabIndex=
<em>"-1"</em>&gt;',
        '&lt;label 
<b>for</b>=
<em>"{id}"</em> style=
<em>"{labelStyle}"</em> class=
<em>"x-form-item-label"</em>&gt;{label}{labelSeparator}&lt;/label&gt;',
        '&lt;div class=
<em>"x-form-element"</em> id=
<em>"x-form-el-{id}"</em> style=
<em>"{elementStyle}"</em>&gt;',
        '&lt;/div&gt;&lt;div class=
<em>"{clearCls}"</em>&gt;&lt;/div&gt;',
    
<em>'&lt;/div&gt;'</em>
);</code>
          </pre>
          <p>This may be specified to produce a different DOM
          structure when rendering form Fields.</p>
          <p>A description of the properties within the template
          follows:</p>
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>itemCls</tt>
              </b> : String
              <div class="sub-desc">The CSS class applied to the
              outermost div wrapper that contains this field label
              and field element (the default class is 
              <tt>'x-form-item'</tt> and 
              <tt>itemCls</tt> will be added to that). If supplied,
              
              <tt>itemCls</tt> at the field level will override the
              default 
              <tt>itemCls</tt> supplied at the container
              level.</div>
</li>
              <li>
              <b>
                <tt>id</tt>
              </b> : String
              <div class="sub-desc">The id of the Field</div>
</li>
              <li>
              <b>
                <tt>
                  <a ext:cls="Ext.layout.FormLayout" ext:member="labelStyle" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelStyle">labelStyle</a>
                </tt>
              </b> : String
              <div class="sub-desc">A CSS style specification
              string to add to the field label for this field
              (defaults to 
              <tt>''</tt> or the 
              <a ext:cls="Ext.layout.FormLayout" ext:member="labelStyle" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelStyle">layout's value for 
              <tt>labelStyle</tt>
</a>).</div>
</li>
              <li>
              <b>
                <tt>label</tt>
              </b> : String
              <div class="sub-desc">The text to display as the
              label for this field (defaults to 
              <tt>''</tt>)</div>
</li>
              <li>
              <b>
                <tt>
                  <a ext:cls="Ext.layout.FormLayout" ext:member="labelSeparator" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelSeparator">labelSeparator</a>
                </tt>
              </b> : String
              <div class="sub-desc">The separator to display after
              the text of the label for this field (defaults to a
              colon 
              <tt>':'</tt> or the 
              <a ext:cls="Ext.layout.FormLayout" ext:member="labelSeparator" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-labelSeparator">layout's value for
              labelSeparator</a>). To hide the separator use empty
              string ''.</div>
</li>
              <li>
              <b>
                <tt>elementStyle</tt>
              </b> : String
              <div class="sub-desc">The styles text for the input
              element's wrapper.</div>
</li>
              <li>
              <b>
                <tt>clearCls</tt>
              </b> : String
              <div class="sub-desc">The CSS class to apply to the
              special clearing div rendered directly after each
              form field wrapper (defaults to 
              <tt>'x-form-clear-left'</tt>)</div>
</li>
            </ul>
          </div>
          <p>Also see 
          <tt>
            <a ext:cls="Ext.layout.FormLayout" ext:member="getTemplateArgs" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-getTemplateArgs">getTemplateArgs</a>
          </tt>
</p>
</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getFieldTpl () {
		return (Object) getStateHelper().eval(PropertyKeys.fieldTpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>fieldTpl</code> property.
	 * </p>
	 */
	public void setFieldTpl ( Object   fieldTpl ) {
		getStateHelper().put(PropertyKeys.fieldTpl, fieldTpl);
		handleAttribute("fieldTpl", fieldTpl);
	}
    	/*
	 *
        
        
          labelSeparator
         : String
        See 
        Ext.form.FormPanel.
        labelSeparator.
        Configuration of this property at the 
        container level takes precedence.
	 */
	
	public String getLabelSeparator () {
		return (String) getStateHelper().eval(PropertyKeys.labelSeparator);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelSeparator</code> property.
	 * </p>
	 */
	public void setLabelSeparator ( String   labelSeparator ) {
		getStateHelper().put(PropertyKeys.labelSeparator, labelSeparator);
		handleAttribute("labelSeparator", labelSeparator);
	}
    	/*
	 *
        
        
          trackLabels
         : Boolean
        True to show/hide the field label when
        the field is hidden. Defaults to 
        true.
	 */
	
	public Boolean getTrackLabels () {
		return (Boolean) getStateHelper().eval(PropertyKeys.trackLabels);
	}

	/**
	 * <p>
	 * Set the value of the <code>trackLabels</code> property.
	 * </p>
	 */
	public void setTrackLabels ( Boolean   trackLabels ) {
		getStateHelper().put(PropertyKeys.trackLabels, trackLabels);
		handleAttribute("trackLabels", trackLabels);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Controls how the child items of the
          container are aligned. Acceptable configuration values
          for this property are: 
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>top</tt>
              </b> : 
              <b>Default</b>
              <div class="sub-desc">child items are aligned
              vertically at the 
              <b>top</b> of the container</div>
</li>
              <li>
              <b>
                <tt>middle</tt>
              </b> : 
              <div class="sub-desc">child items are aligned
              vertically in the 
              <b>middle</b> of the container</div>
</li>
              <li>
              <b>
                <tt>stretch</tt>
              </b> : 
              <div class="sub-desc">child items are stretched
              vertically to fill the height of the
              container</div>
</li>
              <li>
              <b>
                <tt>stretchmax</tt>
              </b> : 
              <div class="sub-desc">child items are stretched
              vertically to the height of the largest
              item.</div>
</li>
            </ul>
          </div>
</div>

	 */
	
	public String getAlign () {
		return (String) getStateHelper().eval(PropertyKeys.align);
	}

	/**
	 * <p>
	 * Set the value of the <code>align</code> property.
	 * </p>
	 */
	public void setAlign ( String   align ) {
		getStateHelper().put(PropertyKeys.align, align);
		handleAttribute("align", align);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <p>An optional extra CSS class that will be added to the
          container. This can be useful for adding customized
          styles to the container or any of its children using
          standard CSS rules. See 
          <a ext:cls="Ext.Component" href="output/Ext.Component.html">Ext.Component</a>.
          <a ext:cls="Ext.Component" ext:member="ctCls" href="output/Ext.Component.html#Ext.Component-ctCls">ctCls</a>
          also.</p>
          <p>
          <b>Note</b>: 
          <tt>extraCls</tt> defaults to 
          <tt>''</tt> except for the following classes which assign
          a value by default:</p>
          <div class="mdetail-params">
            <ul>
              <li>
              <a ext:cls="Ext.layout.AbsoluteLayout" href="output/Ext.layout.AbsoluteLayout.html">Absolute
              Layout</a> : 
              <tt>'x-abs-layout-item'</tt>
</li>
              <li>
              <a ext:cls="Ext.layout.Box" href="output/Ext.layout.Box.html">Box Layout</a> : 
              <tt>'x-box-item'</tt>
</li>
              <li>
              <a ext:cls="Ext.layout.ColumnLayout" href="output/Ext.layout.ColumnLayout.html">Column Layout</a> :
              
              <tt>'x-column'</tt>
</li>
            </ul>
          </div>To configure the above Classes with an extra CSS
          class append to the default. For example, for
          ColumnLayout:
<pre>
<code>extraCls: 
<em>'x-column custom-class'</em>
</code>
          </pre>
          <br/>
          <br/>
</div>

	 */
	
	public String getExtraCls () {
		return (String) getStateHelper().eval(PropertyKeys.extraCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>extraCls</code> property.
	 * </p>
	 */
	public void setExtraCls ( String   extraCls ) {
		getStateHelper().put(PropertyKeys.extraCls, extraCls);
		handleAttribute("extraCls", extraCls);
	}
    	/*
	 *
        
        
          renderHidden
         : Boolean
        True to hide each contained item on
        render (defaults to false).
	 */
	
	public Boolean getRenderHidden () {
		return (Boolean) getStateHelper().eval(PropertyKeys.renderHidden);
	}

	/**
	 * <p>
	 * Set the value of the <code>renderHidden</code> property.
	 * </p>
	 */
	public void setRenderHidden ( Boolean   renderHidden ) {
		getStateHelper().put(PropertyKeys.renderHidden, renderHidden);
		handleAttribute("renderHidden", renderHidden);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Controls how the child items of the
          container are packed together. Acceptable configuration
          values for this property are: 
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>start</tt>
              </b> : 
              <b>Default</b>
              <div class="sub-desc">child items are packed together
              at 
              <b>left</b> side of container</div>
</li>
              <li>
              <b>
                <tt>center</tt>
              </b> : 
              <div class="sub-desc">child items are packed together
              at 
              <b>mid-width</b> of container</div>
</li>
              <li>
              <b>
                <tt>end</tt>
              </b> : 
              <div class="sub-desc">child items are packed together
              at 
              <b>right</b> side of container</div>
</li>
            </ul>
          </div>
</div>

	 */
	
	public String getPack () {
		return (String) getStateHelper().eval(PropertyKeys.pack);
	}

	/**
	 * <p>
	 * Set the value of the <code>pack</code> property.
	 * </p>
	 */
	public void setPack ( String   pack ) {
		getStateHelper().put(PropertyKeys.pack, pack);
		handleAttribute("pack", pack);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>Sets the padding to be applied to all child items
            managed by this layout.</p>
            <p>This property must be specified as a string
            containing space-separated, numeric padding values. The
            order of the sides associated with each value matches
            the way CSS processes padding values:</p>
            <div class="mdetail-params">
              <ul>
                <li>If there is only one value, it applies to all
                sides.</li>
                <li>If there are two values, the top and bottom
                borders are set to the first value and the right
                and left are set to the second.</li>
                <li>If there are three values, the top is set to
                the first value, the left and right are set to the
                second, and the bottom is set to the third.</li>
                <li>If there are four values, they apply to the
                top, right, bottom, and left, respectively.</li>
              </ul>
            </div>
            <p>Defaults to: 
            <code>
              <em>"0"</em>
            </code>
</p>
          </div>

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
<div class="long">This configuation option is to be
          applied to 
          <b>child 
          <tt>items</tt>
</b> of the container managed by this
          layout. Each child item with a 
          <tt>flex</tt> property will be flexed 
          <b>horizontally</b> according to each item's 
          <b>relative</b> 
          <tt>flex</tt> value compared to the sum of all items with
          a 
          <tt>flex</tt> value specified. Any child items that have
          either a 
          <tt>flex = 0</tt> or 
          <tt>flex = undefined</tt> will not be 'flexed' (the
          initial size will not be changed).</div>

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
            <p>If the individual contained items do not have a 
            <tt>margins</tt> property specified, the default
            margins from this property will be applied to each
            item.</p>
            <br/>
            <p>This property may be specified as an object
            containing margins to apply in the format:</p>
<pre>
<code>{
    top: (top margin),
    right: (right margin),
    bottom: (bottom margin),
    left: (left margin)
}</code>
            </pre>
            <p>This property may also be specified as a string
            containing space-separated, numeric margin values. The
            order of the sides associated with each value matches
            the way CSS processes margin values:</p>
            <div class="mdetail-params">
              <ul>
                <li>If there is only one value, it applies to all
                sides.</li>
                <li>If there are two values, the top and bottom
                borders are set to the first value and the right
                and left are set to the second.</li>
                <li>If there are three values, the top is set to
                the first value, the left and right are set to the
                second, and the bottom is set to the third.</li>
                <li>If there are four values, they apply to the
                top, right, bottom, and left, respectively.</li>
              </ul>
            </div>
            <p>Defaults to:</p>
<pre>
<code>{top:0, right:0, bottom:0, left:0}</code>
            </pre>
          </div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaultMargins () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultMargins);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultMargins</code> property.
	 * </p>
	 */
	public void setDefaultMargins ( Object   defaultMargins ) {
		getStateHelper().put(PropertyKeys.defaultMargins, defaultMargins);
		handleAttribute("defaultMargins", defaultMargins);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>An object containing properties which are added to
            the 
            <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> specification
            used to create the layout's 
            <tt>&lt;table&gt;</tt> element. Example:</p>
<pre>
<code>{
    xtype: 
<em>'panel'</em>,
    layout: 
<em>'table'</em>,
    layoutConfig: {
        tableAttrs: {
            style: {
                width: 
<em>'100%'</em>
            }
        },
        columns: 3
    }
}</code>
            </pre>
          </div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getTableAttrs () {
		return (Object) getStateHelper().eval(PropertyKeys.tableAttrs);
	}

	/**
	 * <p>
	 * Set the value of the <code>tableAttrs</code> property.
	 * </p>
	 */
	public void setTableAttrs ( Object   tableAttrs ) {
		getStateHelper().put(PropertyKeys.tableAttrs, tableAttrs);
		handleAttribute("tableAttrs", tableAttrs);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The total number of columns to create
          in the table for this layout. If not specified, all
          Components added to this layout will be rendered into a
          single row using one column per Component.</div>

	 */
	
	public Integer getColumns () {
		return (Integer) getStateHelper().eval(PropertyKeys.columns);
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns ( Integer   columns ) {
		getStateHelper().put(PropertyKeys.columns, columns);
		handleAttribute("columns", columns);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The minimum allowable height in pixels
          for this region (defaults to 
          <tt>50</tt>) 
          <tt>maxHeight</tt> may also be specified.
          <br/>
          <br/>
          <br/>
          <p>
          <b>Note</b>: setting the 
          <tt>
            <a ext:cls="Ext.SplitBar" ext:member="minSize" href="output/Ext.SplitBar.html#Ext.SplitBar-minSize">minSize</a>
          </tt> / 
          <tt>
            <a ext:cls="Ext.SplitBar" ext:member="maxSize" href="output/Ext.SplitBar.html#Ext.SplitBar-maxSize">maxSize</a>
          </tt> supersedes any specified 
          <tt>minHeight</tt> / 
          <tt>maxHeight</tt>.</p>
</div>

	 */
	
	public Integer getMinHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.minHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>minHeight</code> property.
	 * </p>
	 */
	public void setMinHeight ( Integer   minHeight ) {
		getStateHelper().put(PropertyKeys.minHeight, minHeight);
		handleAttribute("minHeight", minHeight);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>collapseMode</tt> supports two configuration values:
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>undefined</tt>
              </b> (default)
              <div class="sub-desc">By default, 
              <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="collapsible" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapsible">collapsible</a>
              regions are collapsed by clicking the expand/collapse
              tool button that renders into the region's title
              bar.</div>
</li>
              <li>
                <b>
                  <tt>'mini'</tt>
                </b>
                <div class="sub-desc">Optionally, when 
                <tt>collapseMode</tt> is set to 
                <tt>'mini'</tt> the region's split bar will also
                display a small collapse button in the center of
                the bar. In 
                <tt>'mini'</tt> mode the region will collapse to a
                thinner bar than in normal mode.</div>
              </li>
            </ul>
          </div>
          <br/>
          <br/> 
          <p>
          <b>Note</b>: if a collapsible region does not have a
          title bar, then set 
          <tt>collapseMode = 'mini'</tt> and 
          <tt>
          <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="split" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-split">split</a> =
          true</tt> in order for the region to be 
          <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="collapsible" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapsible">collapsible</a>
          by the user as the expand/collapse tool button (that
          would go in the title bar) will not be rendered.</p>
          <p>See also 
          <tt>
            <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="cmargins" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-cmargins">cmargins</a>
          </tt>.</p>
</div>

	 */
	
	public String getCollapseMode () {
		return (String) getStateHelper().eval(PropertyKeys.collapseMode);
	}

	/**
	 * <p>
	 * Set the value of the <code>collapseMode</code> property.
	 * </p>
	 */
	public void setCollapseMode ( String   collapseMode ) {
		getStateHelper().put(PropertyKeys.collapseMode, collapseMode);
		handleAttribute("collapseMode", collapseMode);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to allow clicking a collapsed region's bar
          to display the region's panel floated above the layout, 
          <tt>false</tt> to force the user to fully expand a
          collapsed region by clicking the expand button to see it
          again (defaults to 
          <tt>true</tt>).</div>

	 */
	
	public Boolean getFloatable () {
		return (Boolean) getStateHelper().eval(PropertyKeys.floatable);
	}

	/**
	 * <p>
	 * Set the value of the <code>floatable</code> property.
	 * </p>
	 */
	public void setFloatable ( Boolean   floatable ) {
		getStateHelper().put(PropertyKeys.floatable, floatable);
		handleAttribute("floatable", floatable);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">When a collapsed region's bar is
          clicked, the region's panel will be displayed as a
          floated panel. If 
          <tt>autoHide = true</tt>, the panel will automatically
          hide after the user mouses out of the panel. If 
          <tt>autoHide = false</tt>, the panel will continue to
          display until the user clicks outside of the panel
          (defaults to 
          <tt>true</tt>).</div>

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
<div class="long">
            <p>The minimum allowable width in pixels for this
            region (defaults to 
            <tt>50</tt>). 
            <tt>maxWidth</tt> may also be specified.</p>
            <br/>
            <p>
            <b>Note</b>: setting the 
            <tt>
              <a ext:cls="Ext.SplitBar" ext:member="minSize" href="output/Ext.SplitBar.html#Ext.SplitBar-minSize">minSize</a>
            </tt> / 
            <tt>
              <a ext:cls="Ext.SplitBar" ext:member="maxSize" href="output/Ext.SplitBar.html#Ext.SplitBar-maxSize">maxSize</a>
            </tt> supersedes any specified 
            <tt>minWidth</tt> / 
            <tt>maxWidth</tt>.</p>
          </div>

	 */
	
	public Integer getMinWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.minWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>minWidth</code> property.
	 * </p>
	 */
	public void setMinWidth ( Integer   minWidth ) {
		getStateHelper().put(PropertyKeys.minWidth, minWidth);
		handleAttribute("minWidth", minWidth);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <tt>true</tt> to allow the user to collapse this region
            (defaults to 
            <tt>false</tt>). If 
            <tt>true</tt>, an expand/collapse tool button will
            automatically be rendered into the title bar of the
            region, otherwise the button will not be shown.</p>
            <p>
            <b>Note</b>: that a title bar is required to display
            the collapse/expand toggle button -- if no 
            <tt>title</tt> is specified for the region's panel, the
            region will only be collapsible if 
            <tt>
            <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="collapseMode" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapseMode">collapseMode</a>
            = 'mini'</tt> and 
            <tt>
            <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="split" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-split">split</a> =
            true</tt>.</p>
          </div>

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
<div class="long">When a collapsed region's bar is
          clicked, the region's panel will be displayed as a
          floated panel that will close again once the user mouses
          out of that panel (or clicks out if 
          <tt>
          <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="autoHide" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-autoHide">autoHide</a> =
          false</tt>). Setting 
          <tt>
          <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="animFloat" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-animFloat">animFloat</a> =
          false</tt> will prevent the open and close of these
          floated panels from being animated (defaults to 
          <tt>true</tt>).</div>

	 */
	
	public Boolean getAnimFloat () {
		return (Boolean) getStateHelper().eval(PropertyKeys.animFloat);
	}

	/**
	 * <p>
	 * Set the value of the <code>animFloat</code> property.
	 * </p>
	 */
	public void setAnimFloat ( Boolean   animFloat ) {
		getStateHelper().put(PropertyKeys.animFloat, animFloat);
		handleAttribute("animFloat", animFloat);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>
            <tt>true</tt> to create a 
            <a ext:cls="Ext.layout.BorderLayout.SplitRegion" href="output/Ext.layout.BorderLayout.SplitRegion.html">SplitRegion</a>
            and display a 5px wide 
            <a ext:cls="Ext.SplitBar" href="output/Ext.SplitBar.html">Ext.SplitBar</a> between this
            region and its neighbor, allowing the user to resize
            the regions dynamically. Defaults to 
            <tt>false</tt> creating a 
            <a ext:cls="Ext.layout.BorderLayout.Region" href="output/Ext.layout.BorderLayout.Region.html">Region</a>.</p>
            <br/>
            <p>
            <b>Notes</b>:</p>
            <div class="mdetail-params">
              <ul>
                <li>this configuration option is ignored if 
                <tt>region='center'</tt>
</li>
                <li>when 
                <tt>split == true</tt>, it is common to specify a 
                <tt>
                  <a ext:cls="Ext.SplitBar" ext:member="minSize" href="output/Ext.SplitBar.html#Ext.SplitBar-minSize">minSize</a>
                </tt> and 
                <tt>
                  <a ext:cls="Ext.SplitBar" ext:member="maxSize" href="output/Ext.SplitBar.html#Ext.SplitBar-maxSize">maxSize</a>
                </tt> for the 
                <a ext:cls="Ext.BoxComponent" href="output/Ext.BoxComponent.html">BoxComponent</a>
                representing the region. These are not native
                configs of 
                <a ext:cls="Ext.BoxComponent" href="output/Ext.BoxComponent.html">BoxComponent</a>, and
                are used only by this class.</li>
                <li>if 
                <tt>
                <a ext:cls="Ext.layout.BorderLayout.Region" ext:member="collapseMode" href="output/Ext.layout.BorderLayout.Region.html#Ext.layout.BorderLayout.Region-collapseMode">collapseMode</a>
                = 'mini'</tt> requires 
                <tt>split = true</tt> to reserve space for the
                collapse tool</li>
              </ul>
            </div>
          </div>

	 */
	
	public Boolean getSplit () {
		return (Boolean) getStateHelper().eval(PropertyKeys.split);
	}

	/**
	 * <p>
	 * Set the value of the <code>split</code> property.
	 * </p>
	 */
	public void setSplit ( Boolean   split ) {
		getStateHelper().put(PropertyKeys.split, split);
		handleAttribute("split", split);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An object containing margins to apply
          to the region when in the collapsed state in the format:
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
          values.</p>
          <ul>
            <li>If there is only one value, it applies to all
            sides.</li>
            <li>If there are two values, the top and bottom borders
            are set to the first value and the right and left are
            set to the second.</li>
            <li>If there are three values, the top is set to the
            first value, the left and right are set to the second,
            and the bottom is set to the third.</li>
            <li>If there are four values, they apply to the top,
            right, bottom, and left, respectively.</li>
          </ul>
          <br/>
          <br/>
</div>

	 */
	
	public String getCmargins () {
		return (String) getStateHelper().eval(PropertyKeys.cmargins);
	}

	/**
	 * <p>
	 * Set the value of the <code>cmargins</code> property.
	 * </p>
	 */
	public void setCmargins ( String   cmargins ) {
		getStateHelper().put(PropertyKeys.cmargins, cmargins);
		handleAttribute("cmargins", cmargins);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An object containing margins to apply
          to the region when in the expanded state in the format:
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
				return superEvent;
	}
}