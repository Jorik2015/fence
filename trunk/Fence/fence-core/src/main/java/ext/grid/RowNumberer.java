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
<div class="description">This is a utility class that can be
  passed into a 
  <a ext:cls="Ext.grid.ColumnModel" href="output/Ext.grid.ColumnModel.html">Ext.grid.ColumnModel</a> as a
  column config that provides an automatic row numbering column.
  <br/>Usage:
  <br/> 
<pre>
<code>
<i>// This is a typical column config 
<b>with</b> the first column providing row numbers</i>
 
<b>var</b> colModel = 
<b>new</b> Ext.grid.ColumnModel([
    
<b>new</b> Ext.grid.RowNumberer(),
    {header: 
<em>"Name"</em>, width: 80, sortable: true},
    {header: 
<em>"Code"</em>, width: 50, sortable: true},
    {header: 
<em>"Description"</em>, width: 200, sortable: true}
 ]);</code>
  </pre>
</div>

 */

@InstanceOf("Ext.grid.RowNumberer")

@FacesComponent(value = "Ext.grid.RowNumberer")
public class RowNumberer extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.grid.RowNumberer";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.RowNumberer} instance with default property values.
	 * </p>
	 */
	public RowNumberer() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			width
			,header
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
        
        
          width
         : Number
        The default width in pixels of the row
        number column (defaults to 23).
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
	 *
        
        
          header
         : String
        Any valid text or HTML fragment to
        display in the header cell for the row number column
        (defaults to '').
	 */
	
	public String getHeader () {
		return (String) getStateHelper().eval(PropertyKeys.header);
	}

	/**
	 * <p>
	 * Set the value of the <code>header</code> property.
	 * </p>
	 */
	public void setHeader ( String   header ) {
		getStateHelper().put(PropertyKeys.header, header);
		handleAttribute("header", header);
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