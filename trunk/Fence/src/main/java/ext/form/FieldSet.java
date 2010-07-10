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
 * Standard container used for grouping
  items within a 
  form. 


var form = 
new Ext.FormPanel({
    title: 
'Simple Form 
with FieldSets',
    labelWidth: 75, 
// 
label settings here cascade unless overridden

    url: 
'save-form.php',
    frame:true,
    bodyStyle:
'padding:5px 5px 0',
    width: 700,
    renderTo: document.body,
    layout:
'column', 
// arrange items 
in columns

    defaults: {      
// defaults applied to items

        layout: 
'form',
        border: false,
        bodyStyle: 
'padding:4px'
    },
    items: [{
        
// Fieldset 
in Column 1

        xtype:
'fieldset',
        columnWidth: 0.5,
        title: 
'Fieldset 1',
        collapsible: true,
        autoHeight:true,
        defaults: {
            anchor: 
'-20' 
// leave room 
for error icon

        },
        defaultType: 
'textfield',
        items :[{
                fieldLabel: 
'Field 1'
            }, {
                fieldLabel: 
'Field 2'
            }, {
                fieldLabel: 
'Field 3'
            }
        ]
    },{
        
// Fieldset 
in Column 2 - Panel inside

        xtype:
'fieldset',
        title: 
'Show Panel', 
// title, header, or checkboxToggle creates fieldset header

        autoHeight:true,
        columnWidth: 0.5,
        checkboxToggle: true,
        collapsed: true, 
// fieldset initially collapsed

        layout:
'anchor',
        items :[{
            xtype: 
'panel',
            anchor: 
'100%',
            title: 
'Panel inside a fieldset',
            frame: true,
            height: 100
        }]
    }]
});
  
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
			checkboxName
			,collapsible
			,labelWidth
			,checkboxToggle
			,layout
			,animCollapse
			,itemCls
			,baseCls
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
          true to make the fieldset collapsible and have
          the expand/collapse toggle button automatically rendered
          into the legend element, 
          false to keep the fieldset statically sized with
          no collapse button (defaults to 
          false). Another option is to configure 
          
            checkboxToggle
          .
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
	 *
          true to render a checkbox into the fieldset
          frame just in front of the legend to expand/collapse the
          fieldset when the checkbox is toggled. (defaults to 
          false). 
          A 
          DomHelper element spec may
          also be specified to create the checkbox. If 
          true is specified, the default DomHelper config
          object used to create the element is:

{tag: 
'input', type: 
'checkbox', name: this.checkboxName || this.id+
'-checkbox'}
          
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
	 *A css class to apply to the 
          x-form-item of fields (see 
          Ext.layout.FormLayout.
          fieldTpl for
          details). This property cascades to child
          containers.
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