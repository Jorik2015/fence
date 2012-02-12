package ext.grid;

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
    <p>A Grid column type which renders an icon, or a series of
    icons in a grid cell, and offers a scoped click handler for
    each icon. Example usage:</p>
<pre>
<code>
<b>new</b> Ext.grid.GridPanel({
    store: myStore,
    columns: [
        {
            xtype: 
<em>'actioncolumn'</em>,
            width: 50,
            items: [
                {
                    icon   : 
<em>'sell.gif'</em>,                
<i>// Use a URL 
<b>in</b> the icon config</i>
                    tooltip: 
<em>'Sell stock'</em>,
                    handler: 
<b>function</b>(grid, rowIndex, colIndex) {
                        
<b>var</b> rec = store.getAt(rowIndex);
                        alert(
<em>"Sell "</em> + rec.get(
<em>'company'</em>));
                    }
                },
                {
                    getClass: 
<b>function</b>(v, meta, rec) {  
<i>// Or 
<b>return</b> a class from a 
<b>function</b>
</i>
                        
<b>if</b> (rec.get(
<em>'change'</em>) &lt; 0) {
                            this.items[1].tooltip = 
<em>'Do not buy!'</em>;
                            
<b>return</b> 
<em>'alert-col'</em>;
                        } 
<b>else</b> {
                            this.items[1].tooltip = 
<em>'Buy stock'</em>;
                            
<b>return</b> 
<em>'buy-col'</em>;
                        }
                    },
                    handler: 
<b>function</b>(grid, rowIndex, colIndex) {
                        
<b>var</b> rec = store.getAt(rowIndex);
                        alert(
<em>"Buy "</em> + rec.get(
<em>'company'</em>));
                    }
                }
            ]
        }
        
<i>//any other columns here</i>
    ]
});
</code>
    </pre>
    <p>The action column can be at any index in the columns array,
    and a grid can have any number of action columns.</p>
  </div>

 */

@InstanceOf("Ext.grid.ActionColumn")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.grid.ActionColumn")
public class ActionColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.grid.ActionColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.ActionColumn} instance with default property values.
	 * </p>
	 */
	public ActionColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			getClass
			,icon
			,stopSelection
			,scope
			,items
			,altText
			,iconCls
			,tooltip
			,handler
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
<div class="long">A function which returns the CSS class
          to apply to the icon image. The function is passed the
          following parameters:
          <div class="mdetail-params">
            <ul>
              <li>
              <b>v</b> : Object
              <p class="sub-desc">The value of the column's
              configured field (if any).</p>
</li>
              <li>
              <b>metadata</b> : Object
              <p class="sub-desc">An object in which you may set
              the following attributes:</p>
              <ul>
                <li>
                <b>css</b> : String
                <p class="sub-desc">A CSS class name to add to the
                cell's TD element.</p>
</li>
                <li>
                <b>attr</b> : String
                <p class="sub-desc">An HTML attribute definition
                string to apply to the data container element 
                <i>within</i> the table cell (e.g.
                'style="color:red;"').</p>
</li>
              </ul>
              <br/>
              <br/>
</li>
              <li>
              <b>r</b> : Ext.data.Record
              <p class="sub-desc">The Record providing the
              data.</p>
</li>
              <li>
              <b>rowIndex</b> : Number
              <p class="sub-desc">The row index..</p>
</li>
              <li>
              <b>colIndex</b> : Number
              <p class="sub-desc">The column index.</p>
</li>
              <li>
              <b>store</b> : Ext.data.Store
              <p class="sub-desc">The Store which is providing the
              data Model.</p>
</li>
            </ul>
          </div>
</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getGetClass () {
		return (Object) getStateHelper().eval(PropertyKeys.getClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>getClass</code> property.
	 * </p>
	 */
	public void setGetClass ( Object   getClass ) {
		getStateHelper().put(PropertyKeys.getClass, getClass);
		handleAttribute("getClass", getClass);
	}
    	/*
	 *
        
        
          icon
         : String
        The URL of an image to display as the
        clickable element in the column. Optional - defaults to 
        
          Ext.BLANK_IMAGE_URL
        .
	 */
	
	public String getIcon () {
		return (String) getStateHelper().eval(PropertyKeys.icon);
	}

	/**
	 * <p>
	 * Set the value of the <code>icon</code> property.
	 * </p>
	 */
	public void setIcon ( String   icon ) {
		getStateHelper().put(PropertyKeys.icon, icon);
		handleAttribute("icon", icon);
	}
    	/*
	 *
        
        
          stopSelection
         : Boolean
        Defaults to 
        true. Prevent grid 
        row selection upon mousedown.
	 */
	
	public Boolean getStopSelection () {
		return (Boolean) getStateHelper().eval(PropertyKeys.stopSelection);
	}

	/**
	 * <p>
	 * Set the value of the <code>stopSelection</code> property.
	 * </p>
	 */
	public void setStopSelection ( Boolean   stopSelection ) {
		getStateHelper().put(PropertyKeys.stopSelection, stopSelection);
		handleAttribute("stopSelection", stopSelection);
	}
    	/*
	 *
        
        
          scope
         : Object
        The scope (
        
          this
         reference) in which the 
        
          handler
         and 
        
          getClass
         fuctions are executed. Defaults to this
        Column.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getScope () {
		return (Object) getStateHelper().eval(PropertyKeys.scope);
	}

	/**
	 * <p>
	 * Set the value of the <code>scope</code> property.
	 * </p>
	 */
	public void setScope ( Object   scope ) {
		getStateHelper().put(PropertyKeys.scope, scope);
		handleAttribute("scope", scope);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An Array which may contain multiple
          icon definitions, each element of which may contain: 
          <div class="mdetail-params">
            <ul>
              <li>
              <code>icon</code> : String
              <div class="sub-desc">The url of an image to display
              as the clickable element in the column.</div>
</li>
              <li>
              <code>iconCls</code> : String
              <div class="sub-desc">A CSS class to apply to the
              icon image. To determine the class dynamically,
              configure the item with a 
              <code>getClass</code> function.</div>
</li>
              <li>
              <code>getClass</code> : Function
              <div class="sub-desc">A function which returns the
              CSS class to apply to the icon image. The function is
              passed the following parameters:
              <ul>
                <li>
                <b>v</b> : Object
                <p class="sub-desc">The value of the column's
                configured field (if any).</p>
</li>
                <li>
                <b>metadata</b> : Object
                <p class="sub-desc">An object in which you may set
                the following attributes:</p>
                <ul>
                  <li>
                  <b>css</b> : String
                  <p class="sub-desc">A CSS class name to add to
                  the cell's TD element.</p>
</li>
                  <li>
                  <b>attr</b> : String
                  <p class="sub-desc">An HTML attribute definition
                  string to apply to the data container element 
                  <i>within</i> the table cell (e.g.
                  'style="color:red;"').</p>
</li>
                </ul>
                <br/>
                <br/>
</li>
                <li>
                <b>r</b> : Ext.data.Record
                <p class="sub-desc">The Record providing the
                data.</p>
</li>
                <li>
                <b>rowIndex</b> : Number
                <p class="sub-desc">The row index..</p>
</li>
                <li>
                <b>colIndex</b> : Number
                <p class="sub-desc">The column index.</p>
</li>
                <li>
                <b>store</b> : Ext.data.Store
                <p class="sub-desc">The Store which is providing
                the data Model.</p>
</li>
              </ul>
</div>
</li>
              <li>
              <code>handler</code> : Function
              <div class="sub-desc">A function called when the icon
              is clicked.</div>
</li>
              <li>
              <code>scope</code> : Scope
              <div class="sub-desc">The scope (
              <code>
                <b>this</b>
              </code> reference) in which the 
              <code>handler</code> and 
              <code>getClass</code> functions are executed.
              Fallback defaults are this Column's configured scope,
              then this Column.</div>
</li>
              <li>
              <code>tooltip</code> : String
              <div class="sub-desc">A tooltip message to be
              displayed on hover. 
              <a ext:cls="Ext.QuickTips" ext:member="init" href="output/Ext.QuickTips.html#Ext.QuickTips-init">Ext.QuickTips</a> must have
              been initialized.</div>
</li>
            </ul>
          </div>
</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getItems () {
		return (Object) getStateHelper().eval(PropertyKeys.items);
	}

	/**
	 * <p>
	 * Set the value of the <code>items</code> property.
	 * </p>
	 */
	public void setItems ( Object   items ) {
		getStateHelper().put(PropertyKeys.items, items);
		handleAttribute("items", items);
	}
    	/*
	 *
        
        
          altText
         : String
        The alt text to use for the image
        element. Defaults to 
        ''.
	 */
	
	public String getAltText () {
		return (String) getStateHelper().eval(PropertyKeys.altText);
	}

	/**
	 * <p>
	 * Set the value of the <code>altText</code> property.
	 * </p>
	 */
	public void setAltText ( String   altText ) {
		getStateHelper().put(PropertyKeys.altText, altText);
		handleAttribute("altText", altText);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A CSS class to apply to the icon image.
          To determine the class dynamically, configure the Column
          with a 
          <code>
            <a ext:cls="Ext.grid.ActionColumn" ext:member="getClass" href="output/Ext.grid.ActionColumn.html#Ext.grid.ActionColumn-getClass">getClass</a>
          </code> function.</div>

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
        
        
          tooltip
         : String
        A tooltip message to be displayed on
        hover. 
        Ext.QuickTips
        must have been initialized.
	 */
	
	public String getTooltip () {
		return (String) getStateHelper().eval(PropertyKeys.tooltip);
	}

	/**
	 * <p>
	 * Set the value of the <code>tooltip</code> property.
	 * </p>
	 */
	public void setTooltip ( String   tooltip ) {
		getStateHelper().put(PropertyKeys.tooltip, tooltip);
		handleAttribute("tooltip", tooltip);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A function called when the icon is
          clicked. The handler is passed the following parameters:
          <div class="mdetail-params">
            <ul>
              <li>
              <code>grid</code> : GridPanel
              <div class="sub-desc">The owning
              GridPanel.</div>
</li>
              <li>
              <code>rowIndex</code> : Number
              <div class="sub-desc">The row index clicked
              on.</div>
</li>
              <li>
              <code>colIndex</code> : Number
              <div class="sub-desc">The column index clicked
              on.</div>
</li>
              <li>
              <code>item</code> : Object
              <div class="sub-desc">The clicked item (or this
              Column if multiple 
              <a ext:cls="Ext.grid.ActionColumn" ext:member="items" href="output/Ext.grid.ActionColumn.html#Ext.grid.ActionColumn-items">items</a> were not
              configured).</div>
</li>
              <li>
              <code>e</code> : Event
              <div class="sub-desc">The click event.</div>
</li>
            </ul>
          </div>
</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getHandler () {
		return (Object) getStateHelper().eval(PropertyKeys.handler);
	}

	/**
	 * <p>
	 * Set the value of the <code>handler</code> property.
	 * </p>
	 */
	public void setHandler ( Object   handler ) {
		getStateHelper().put(PropertyKeys.handler, handler);
		handleAttribute("handler", handler);
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