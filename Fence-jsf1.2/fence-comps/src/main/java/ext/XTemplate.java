package ext;

import javax.el.ValueExpression;
import ext.annotation.*;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
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
@ParseConfigMode(ui = false)
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
	
	    
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[1];
		}
		_values[0] = super.saveState(_context);
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
			}
}