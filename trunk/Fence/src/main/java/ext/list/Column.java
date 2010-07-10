package ext.list;

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
 * 
    This class encapsulates column configuration data to be used
    in the initialization of a 
    ListView.
    While subclasses are provided to render data in different
    ways, this class renders a passed data field unchanged and is
    usually used for textual columns.
  
 */

@InstanceOf("Ext.list.Column")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.list.Column")
public class Column extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.list.Column";

	/**
	 * <p>
	 * Create a new {@link Ext.list.Column} instance with default property values.
	 * </p>
	 */
	public Column() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			width
			,align
			,header
			,cls
			,dataIndex
			,tpl
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
	 *Optional. Percentage of the container
          width this column should be allocated. Columns that have
          no width specified will be allocated with an equal
          percentage to fill 100% of the container width. To easily
          take advantage of the full container width, leave the
          width of at least one column undefined. Note that if you
          do not want to take up the full width of the container,
          the width of every column needs to be explicitly
          defined.
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
        
        
          align
         : String
        Set the CSS text-align property of the
        column. Defaults to 
        'left'.
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
	 *Optional. The header text to be used as
          innerHTML (html tags are accepted) to display in the
          ListView. 
          Note: to have a clickable header with no text
          displayed use 
          ' '.
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
    	/*
	 *
        
        
          cls
         : String
        Optional. This option can be used to add
        a CSS class to the cell of each row for this
        column.
	 */
	
	public String getCls () {
		return (String) getStateHelper().eval(PropertyKeys.cls);
	}

	/**
	 * <p>
	 * Set the value of the <code>cls</code> property.
	 * </p>
	 */
	public void setCls ( String   cls ) {
		getStateHelper().put(PropertyKeys.cls, cls);
		handleAttribute("cls", cls);
	}
    	/*
	 *
            
            Required. The name of the field in the
            ListViews's 
            Ext.data.Store's 
            Ext.data.Record
            definition from which to draw the column's value.
          
	 */
	
	public String getDataIndex () {
		return (String) getStateHelper().eval(PropertyKeys.dataIndex);
	}

	/**
	 * <p>
	 * Set the value of the <code>dataIndex</code> property.
	 * </p>
	 */
	public void setDataIndex ( String   dataIndex ) {
		getStateHelper().put(PropertyKeys.dataIndex, dataIndex);
		handleAttribute("dataIndex", dataIndex);
	}
    	/*
	 *Optional. Specify a string to pass as
          the configuration string for 
          Ext.XTemplate. By default an 
          Ext.XTemplate will be
          implicitly created using the 
          dataIndex.
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