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
  <p>A template class that supports advanced functionality
  like:</p>
  <div class="mdetail-params">
    <ul>
      <li>Autofilling arrays using templates and sub-templates</li>
      <li>Conditional processing with basic comparison
      operators</li>
      <li>Basic math function support</li>
      <li>Execute arbitrary inline code with special built-in
      template variables</li>
      <li>Custom member functions</li>
      <li>Many special tags and built-in operators that aren't
      defined as part of the API, but are supported in the
      templates that can be created</li>
    </ul>
  </div>
  <br/>
  <br/> 
  <p>XTemplate provides the templating mechanism built into:</p>
  <div class="mdetail-params">
    <ul>
      <li>
        <a ext:cls="Ext.DataView" href="output/Ext.DataView.html">Ext.DataView</a>
      </li>
      <li>
        <a ext:cls="Ext.ListView" href="output/Ext.ListView.html">Ext.ListView</a>
      </li>
      <li>
        <a ext:cls="Ext.form.ComboBox" href="output/Ext.form.ComboBox.html">Ext.form.ComboBox</a>
      </li>
      <li>
        <a ext:cls="Ext.grid.TemplateColumn" href="output/Ext.grid.TemplateColumn.html">Ext.grid.TemplateColumn</a>
      </li>
      <li>
        <a ext:cls="Ext.grid.GroupingView" href="output/Ext.grid.GroupingView.html">Ext.grid.GroupingView</a>
      </li>
      <li>
        <a ext:cls="Ext.menu.Item" href="output/Ext.menu.Item.html">Ext.menu.Item</a>
      </li>
      <li>
        <a ext:cls="Ext.layout.MenuLayout" href="output/Ext.layout.MenuLayout.html">Ext.layout.MenuLayout</a>
      </li>
      <li>
        <a ext:cls="Ext.ColorPalette" href="output/Ext.ColorPalette.html">Ext.ColorPalette</a>
      </li>
    </ul>
  </div>
  <br/>
  <br/> 
  <p>For example usage 
  <a ext:cls="Ext.XTemplate" ext:member="XTemplate" href="output/Ext.XTemplate.html#Ext.XTemplate-XTemplate">see the
  constructor</a>.</p>
</div>

 */

@InstanceOf("Ext.XTemplate")

@FacesComponent(value = "Ext.XTemplate")
public class XTemplate extends Template {
	public static final String COMPONENT_FAMILY = "Ext.XTemplate";

	/**
	 * <p>
	 * Create a new {@link Ext.XTemplate} instance with default property values.
	 * </p>
	 */
	public XTemplate() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
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