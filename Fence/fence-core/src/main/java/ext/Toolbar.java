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
  <p>Basic Toolbar class. Although the 
  <tt>
    <a ext:cls="Ext.Container" ext:member="defaultType" href="output/Ext.Container.html#Ext.Container-defaultType">defaultType</a>
  </tt> for Toolbar is 
  <tt>
    <a ext:cls="Ext.Button" href="output/Ext.Button.html">button</a>
  </tt>, Toolbar elements (child items for the Toolbar container)
  may be virtually any type of Component. Toolbar elements can be
  created explicitly via their constructors, or implicitly via
  their xtypes, and can be 
  <tt>
    <a ext:cls="Ext.Toolbar" ext:member="add" href="output/Ext.Toolbar.html#Ext.Toolbar-add">add</a>
  </tt>ed dynamically.</p>
  <p>Some items have shortcut strings for creation:</p>
<pre>
<u>Shortcut</u>  
<u>xtype</u>          
<u>Class</u>                  
<u>Description</u>
'-&gt;'      'tbfill'       
<a ext:cls="Ext.Toolbar.Fill" href="output/Ext.Toolbar.Fill.html">Ext.Toolbar.Fill</a>       begin using
the right-justified button container
'-'       'tbseparator'  
<a ext:cls="Ext.Toolbar.Separator" href="output/Ext.Toolbar.Separator.html">Ext.Toolbar.Separator</a>  add a
vertical separator bar between toolbar items
' '       'tbspacer'     
<a ext:cls="Ext.Toolbar.Spacer" href="output/Ext.Toolbar.Spacer.html">Ext.Toolbar.Spacer</a>     add
horiztonal space between elements
  </pre>Example usage of various elements: 
<pre>
<code>
<b>var</b> tb = 
<b>new</b> Ext.Toolbar({
    renderTo: document.body,
    width: 600,
    height: 100,
    items: [
        {
            
<i>// xtype: 
<em>'button'</em>, // 
<b>default</b> 
<b>for</b> Toolbars, same as 
<em>'tbbutton'</em>
</i>
            text: 
<em>'Button'</em>
        },
        {
            xtype: 
<em>'splitbutton'</em>, 
<i>// same as 
<em>'tbsplitbutton'</em>
</i>
            text: 
<em>'Split Button'</em>
        },
        
<i>// begin using the right-justified button container</i>
        
<em>'-&gt;'</em>, 
<i>// same as {xtype: 
<em>'tbfill'</em>}, // Ext.Toolbar.Fill</i>
        {
            xtype: 
<em>'textfield'</em>,
            name: 
<em>'field1'</em>,
            emptyText: 
<em>'enter search term'</em>
        },
        
<i>// add a vertical separator bar between toolbar items</i>
        
<em>'-'</em>, 
<i>// same as {xtype: 
<em>'tbseparator'</em>} to create Ext.Toolbar.Separator</i>
        
<em>'text 1'</em>, 
<i>// same as {xtype: 
<em>'tbtext'</em>, text: 
<em>'text1'</em>} to create Ext.Toolbar.TextItem</i>
        {xtype: 
<em>'tbspacer'</em>},
<i>// same as 
<em>' '</em> to create Ext.Toolbar.Spacer</i>
        
<em>'text 2'</em>,
        {xtype: 
<em>'tbspacer'</em>, width: 50}, 
<i>// add a 50px space</i>
        
<em>'text 3'</em>
    ]
});</code>
  </pre>Example adding a ComboBox within a menu of a button: 
<pre>
<code>
<i>// ComboBox creation</i>
<b>var</b> combo = 
<b>new</b> Ext.form.ComboBox({
    store: 
<b>new</b> Ext.data.ArrayStore({
        autoDestroy: true,
        fields: [
<em>'initials'</em>, 
<em>'fullname'</em>],
        data : [
            [
<em>'FF'</em>, 
<em>'Fred Flintstone'</em>],
            [
<em>'BR'</em>, 
<em>'Barney Rubble'</em>]
        ]
    }),
    displayField: 
<em>'fullname'</em>,
    typeAhead: true,
    mode: 
<em>'local'</em>,
    forceSelection: true,
    triggerAction: 
<em>'all'</em>,
    emptyText: 
<em>'Select a name...'</em>,
    selectOnFocus: true,
    width: 135,
    getListParent: 
<b>function</b>() {
        
<b>return</b> this.el.up(
<em>'.x-menu'</em>);
    },
    iconCls: 
<em>'no-icon'</em> 
<i>//use iconCls 
<b>if</b> placing within menu to shift to right side of menu</i>
});

<i>// put ComboBox 
<b>in</b> a Menu</i>
<b>var</b> menu = 
<b>new</b> Ext.menu.Menu({
    id: 
<em>'mainMenu'</em>,
    items: [
        combo 
<i>// A Field 
<b>in</b> a Menu</i>
    ]
});

<i>// add a Button 
<b>with</b> the menu</i>
tb.add({
        text:
<em>'Button w/ Menu'</em>,
        menu: menu  
<i>// assign menu by instance</i>
    });
tb.doLayout();</code>
  </pre>
</div>

 */
@XType("toolbar")
@InstanceOf("Ext.Toolbar")

@FacesComponent(value = "Ext.Toolbar")
public class Toolbar extends Container {
	public static final String COMPONENT_FAMILY = "Ext.Toolbar";

	/**
	 * <p>
	 * Create a new {@link Ext.Toolbar} instance with default property values.
	 * </p>
	 */
	public Toolbar() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			layout
			,enableOverflow
			,buttonAlign
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
<div class="long">This class assigns a default layout (
          <code>layout:
          <em>'
          <b>toolbar</b>'</em>
</code>). Developers 
          <i>may</i> override this configuration option if another
          layout is required (the constructor must be passed a
          configuration object in this case instead of an array).
          See 
          <a ext:cls="Ext.Container" ext:member="layout" href="output/Ext.Container.html#Ext.Container-layout">Ext.Container.layout</a> for
          additional information.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Defaults to false. Configure 
          <tt>true</tt> to make the toolbar provide a button which
          activates a dropdown Menu to show items which overflow
          the Toolbar's width.</div>

	 */
	
	public Boolean getEnableOverflow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.enableOverflow);
	}

	/**
	 * <p>
	 * Set the value of the <code>enableOverflow</code> property.
	 * </p>
	 */
	public void setEnableOverflow ( Boolean   enableOverflow ) {
		getStateHelper().put(PropertyKeys.enableOverflow, enableOverflow);
		handleAttribute("enableOverflow", enableOverflow);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
            <p>The default position at which to align child items.
            Defaults to 
            <code>
              <em>"left"</em>
            </code>
</p>
            <p>May be specified as 
            <code>
              <em>"center"</em>
            </code> to cause items added before a Fill (A 
            <code>
              <em>"-&gt;"</em>
            </code>) item to be centered in the Toolbar. Items
            added after a Fill are still right-aligned.</p>
            <p>Specify as 
            <code>
              <em>"right"</em>
            </code> to right align all child items.</p>
          </div>

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
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "overflowchange"
				));
				return superEvent;
	}
}