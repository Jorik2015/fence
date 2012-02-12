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
    <p>A Column definition class which renders a value by
    processing a 
    <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a>'s 
    <a ext:cls="Ext.data.Record" ext:member="data" href="output/Ext.data.Record.html#Ext.data.Record-data">data</a> using a 
    <a ext:cls="Ext.grid.TemplateColumn" ext:member="tpl" href="output/Ext.grid.TemplateColumn.html#Ext.grid.TemplateColumn-tpl">configured</a> 
    <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">XTemplate</a>. See the 
    <a ext:cls="Ext.grid.Column" ext:member="xtype" href="output/Ext.grid.Column.html#Ext.grid.Column-xtype">xtype</a> config
    option of 
    <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a> for more
    details.</p>
  </div>

 */

@InstanceOf("Ext.grid.TemplateColumn")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.TemplateColumn")
public class TemplateColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.grid.TemplateColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.TemplateColumn} instance with default property values.
	 * </p>
	 */
	public TemplateColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			tpl
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
<div class="long">An 
          <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">XTemplate</a>, or an XTemplate 
          <i>definition string</i> to use to process a 
          <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a>'s 
          <a ext:cls="Ext.data.Record" ext:member="data" href="output/Ext.data.Record.html#Ext.data.Record-data">data</a> to
          produce a column's rendered value.</div>

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