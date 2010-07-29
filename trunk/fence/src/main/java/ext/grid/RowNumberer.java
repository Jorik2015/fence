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
 * This is a utility class that can be
  passed into a 
  Ext.grid.ColumnModel as a
  column config that provides an automatic row numbering column.
  Usage:
   


// This is a typical column config 
with the first column providing row numbers
 
var colModel = 
new Ext.grid.ColumnModel([
    
new Ext.grid.RowNumberer(),
    {header: 
"Name", width: 80, sortable: true},
    {header: 
"Code", width: 50, sortable: true},
    {header: 
"Description", width: 200, sortable: true}
 ]);
  
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