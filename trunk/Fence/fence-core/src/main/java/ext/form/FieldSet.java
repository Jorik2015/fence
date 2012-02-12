package ext.form;

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
<div class="description">Standard container used for grouping
  items within a 
  <a ext:cls="Ext.form.FormPanel" href="output/Ext.form.FormPanel.html">form</a>. 
<pre>
<code>
<b>var</b> form = 
<b>new</b> Ext.FormPanel({
    title: 
<em>'Simple Form 
<b>with</b> FieldSets'</em>,
    labelWidth: 75, 
<i>// 
<b>label</b> settings here cascade unless overridden</i>
    url: 
<em>'save-form.php'</em>,
    frame:true,
    bodyStyle:
<em>'padding:5px 5px 0'</em>,
    width: 700,
    renderTo: document.body,
    layout:
<em>'column'</em>, 
<i>// arrange items 
<b>in</b> columns</i>
    defaults: {      
<i>// defaults applied to items</i>
        layout: 
<em>'form'</em>,
        border: false,
        bodyStyle: 
<em>'padding:4px'</em>
    },
    items: [{
        
<i>// Fieldset 
<b>in</b> Column 1</i>
        xtype:
<em>'fieldset'</em>,
        columnWidth: 0.5,
        title: 
<em>'Fieldset 1'</em>,
        collapsible: true,
        autoHeight:true,
        defaults: {
            anchor: 
<em>'-20'</em> 
<i>// leave room 
<b>for</b> error icon</i>
        },
        defaultType: 
<em>'textfield'</em>,
        items :[{
                fieldLabel: 
<em>'Field 1'</em>
            }, {
                fieldLabel: 
<em>'Field 2'</em>
            }, {
                fieldLabel: 
<em>'Field 3'</em>
            }
        ]
    },{
        
<i>// Fieldset 
<b>in</b> Column 2 - Panel inside</i>
        xtype:
<em>'fieldset'</em>,
        title: 
<em>'Show Panel'</em>, 
<i>// title, header, or checkboxToggle creates fieldset header</i>
        autoHeight:true,
        columnWidth: 0.5,
        checkboxToggle: true,
        collapsed: true, 
<i>// fieldset initially collapsed</i>
        layout:
<em>'anchor'</em>,
        items :[{
            xtype: 
<em>'panel'</em>,
            anchor: 
<em>'100%'</em>,
            title: 
<em>'Panel inside a fieldset'</em>,
            frame: true,
            height: 100
        }]
    }]
});</code>
  </pre>
</div>

 */
@XType("fieldset")
@InstanceOf("Ext.form.FieldSet")

@FacesComponent(value = "Ext.form.FieldSet")
public class FieldSet extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.form.FieldSet";

	/**
	 * <p>
	 * Create a new {@link Ext.form.FieldSet} instance with default property values.
	 * </p>
	 */
	public FieldSet() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			labelWidth
			,itemCls
			,collapsible
			,layout
			,checkboxName
			,baseCls
			,animCollapse
			,checkboxToggle
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
        
        
          labelWidth
         : Number
        The width of labels. This property
        cascades to child containers.
	 */
	
	public Integer getLabelWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.labelWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelWidth</code> property.
	 * </p>
	 */
	public void setLabelWidth ( Integer   labelWidth ) {
		getStateHelper().put(PropertyKeys.labelWidth, labelWidth);
		handleAttribute("labelWidth", labelWidth);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A css class to apply to the 
          <tt>x-form-item</tt> of fields (see 
          <a ext:cls="Ext.layout.FormLayout" href="output/Ext.layout.FormLayout.html">Ext.layout.FormLayout</a>.
          <a ext:cls="Ext.layout.FormLayout" ext:member="fieldTpl" href="output/Ext.layout.FormLayout.html#Ext.layout.FormLayout-fieldTpl">fieldTpl</a> for
          details). This property cascades to child
          containers.</div>

	 */
	
	public String getItemCls () {
		return (String) getStateHelper().eval(PropertyKeys.itemCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemCls</code> property.
	 * </p>
	 */
	public void setItemCls ( String   itemCls ) {
		getStateHelper().put(PropertyKeys.itemCls, itemCls);
		handleAttribute("itemCls", itemCls);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to make the fieldset collapsible and have
          the expand/collapse toggle button automatically rendered
          into the legend element, 
          <tt>false</tt> to keep the fieldset statically sized with
          no collapse button (defaults to 
          <tt>false</tt>). Another option is to configure 
          <tt>
            <a ext:cls="Ext.form.FieldSet" ext:member="checkboxToggle" href="output/Ext.form.FieldSet.html#Ext.form.FieldSet-checkboxToggle">checkboxToggle</a>
          </tt>.</div>

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
	 *
        
        
          layout
         : String
        The 
        Ext.Container.layout to use
        inside the fieldset (defaults to 
        'form').
	 */
	
	public String getLayout () {
		return (String) getStateHelper().eval(PropertyKeys.layout);
	}

	/**
	 * <p>
	 * Set the value of the <code>layout</code> property.
	 * </p>
	 */
	public void setLayout ( String   layout ) {
		getStateHelper().put(PropertyKeys.layout, layout);
		handleAttribute("layout", layout);
	}
    	/*
	 *
        
        
          checkboxName
         : String
        The name to assign to the fieldset's
        checkbox if 
        
        checkboxToggle = true
        (defaults to 
        '[checkbox id]-checkbox').
	 */
	
	public String getCheckboxName () {
		return (String) getStateHelper().eval(PropertyKeys.checkboxName);
	}

	/**
	 * <p>
	 * Set the value of the <code>checkboxName</code> property.
	 * </p>
	 */
	public void setCheckboxName ( String   checkboxName ) {
		getStateHelper().put(PropertyKeys.checkboxName, checkboxName);
		handleAttribute("checkboxName", checkboxName);
	}
    	/*
	 *
        
        
          baseCls
         : String
        The base CSS class applied to the
        fieldset (defaults to 
        'x-fieldset').
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
        
        
          animCollapse
         : Boolean
        
        true to animate the transition when the panel is
        collapsed, 
        false to skip the animation (defaults to 
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <tt>true</tt> to render a checkbox into the fieldset
          frame just in front of the legend to expand/collapse the
          fieldset when the checkbox is toggled. (defaults to 
          <tt>false</tt>). 
          <p>A 
          <a ext:cls="Ext.DomHelper" href="output/Ext.DomHelper.html">DomHelper</a> element spec may
          also be specified to create the checkbox. If 
          <tt>true</tt> is specified, the default DomHelper config
          object used to create the element is:</p>
<pre>
<code>{tag: 
<em>'input'</em>, type: 
<em>'checkbox'</em>, name: this.checkboxName || this.id+
<em>'-checkbox'</em>}</code>
          </pre>
</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getCheckboxToggle () {
		return (Object) getStateHelper().eval(PropertyKeys.checkboxToggle);
	}

	/**
	 * <p>
	 * Set the value of the <code>checkboxToggle</code> property.
	 * </p>
	 */
	public void setCheckboxToggle ( Object   checkboxToggle ) {
		getStateHelper().put(PropertyKeys.checkboxToggle, checkboxToggle);
		handleAttribute("checkboxToggle", checkboxToggle);
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