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
<div class="description">Simple color palette class for choosing
  colors. The palette can be rendered to any container.
  <br/>Here's an example of typical usage: 
<pre>
<code>
<b>var</b> cp = 
<b>new</b> Ext.ColorPalette({value:
<em>'993300'</em>});  
<i>// initial selected color</i>
cp.render(
<em>'my-div'</em>);

cp.on(
<em>'select'</em>, 
<b>function</b>(palette, selColor){
    
<i>// 
<b>do</b> something 
<b>with</b> selColor</i>
});</code>
  </pre>
</div>

 */
@XType("colorpalette")
@InstanceOf("Ext.ColorPalette")

@FacesComponent(value = "Ext.ColorPalette")
public class ColorPalette extends Component {
	public static final String COMPONENT_FAMILY = "Ext.ColorPalette";

	/**
	 * <p>
	 * Create a new {@link Ext.ColorPalette} instance with default property values.
	 * </p>
	 */
	public ColorPalette() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			scope
			,allowReselect
			,itemCls
			,clickEvent
			,value
			,tpl
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
	 *
        
        
          scope
         : Object
        The scope (
        
          this
         reference) in which the 
        
          handler
         function will be called. Defaults to this
        ColorPalette instance.
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
	 *
        
        
          allowReselect
         : Boolean
        If set to true then reselecting a color
        that is already selected fires the 
        select
        event
	 */
	
	public Boolean getAllowReselect () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowReselect);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowReselect</code> property.
	 * </p>
	 */
	public void setAllowReselect ( Boolean   allowReselect ) {
		getStateHelper().put(PropertyKeys.allowReselect, allowReselect);
		handleAttribute("allowReselect", allowReselect);
	}
    	/*
	 *
        
        
          itemCls
         : String
        The CSS class to apply to the containing
        element (defaults to 'x-color-palette')
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
<div class="long">The DOM event that will cause a color
          to be selected. This can be any valid event name
          (dblclick, contextmenu). Defaults to 
          <tt>'click'</tt>.</div>

	 */
	
	public String getClickEvent () {
		return (String) getStateHelper().eval(PropertyKeys.clickEvent);
	}

	/**
	 * <p>
	 * Set the value of the <code>clickEvent</code> property.
	 * </p>
	 */
	public void setClickEvent ( String   clickEvent ) {
		getStateHelper().put(PropertyKeys.clickEvent, clickEvent);
		handleAttribute("clickEvent", clickEvent);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The initial color to highlight (should
          be a valid 6-digit color hex code without the # symbol).
          Note that the hex codes are case-sensitive.</div>

	 */
	
	public String getValue () {
		return (String) getStateHelper().eval(PropertyKeys.value);
	}

	/**
	 * <p>
	 * Set the value of the <code>value</code> property.
	 * </p>
	 */
	public void setValue ( String   value ) {
		getStateHelper().put(PropertyKeys.value, value);
		handleAttribute("value", value);
	}
    	/*
	 *
        
        
          tpl
         : String
        An existing XTemplate instance to be
        used in place of the default template for rendering the
        component.
	 */
	
	public String getTpl () {
		return (String) getStateHelper().eval(PropertyKeys.tpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>tpl</code> property.
	 * </p>
	 */
	public void setTpl ( String   tpl ) {
		getStateHelper().put(PropertyKeys.tpl, tpl);
		handleAttribute("tpl", tpl);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. A function that will handle
          the select event of this palette. The handler is passed
          the following parameters:
          <div class="mdetail-params">
            <ul>
              <li>
              <code>palette</code> : ColorPalette
              <div class="sub-desc">The 
              <a ext:cls="Ext.ColorPalette" ext:member="palette" href="output/Ext.ColorPalette.html#Ext.ColorPalette-palette">Ext.ColorPalette</a>.</div>
</li>
              <li>
              <code>color</code> : String
              <div class="sub-desc">The 6-digit color hex code
              (without the # symbol).</div>
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
				superEvent.addAll(Arrays.asList(
					 "select"
				));
				return superEvent;
	}
}