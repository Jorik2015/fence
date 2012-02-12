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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>This class encapsulates column configuration data to be used
    in the initialization of a 
    <a ext:cls="Ext.list.ListView" href="output/Ext.list.ListView.html">ListView</a>.</p>
    <p>While subclasses are provided to render data in different
    ways, this class renders a passed data field unchanged and is
    usually used for textual columns.</p>
  </div>

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
			cls
			,width
			,align
			,tpl
			,dataIndex
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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. Percentage of the container
          width this column should be allocated. Columns that have
          no width specified will be allocated with an equal
          percentage to fill 100% of the container width. To easily
          take advantage of the full container width, leave the
          width of at least one column undefined. Note that if you
          do not want to take up the full width of the container,
          the width of every column needs to be explicitly
          defined.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. Specify a string to pass as
          the configuration string for 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a>. By default an 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> will be
          implicitly created using the 
          <tt>dataIndex</tt>.</div>

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
<div class="long">
            <p>
            <b>Required</b>. The name of the field in the
            ListViews's 
            <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Ext.data.Store</a>'s 
            <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a>
            definition from which to draw the column's value.</p>
          </div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional. The header text to be used as
          innerHTML (html tags are accepted) to display in the
          ListView. 
          <b>Note</b>: to have a clickable header with no text
          displayed use 
          <tt>' '</tt>.</div>

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