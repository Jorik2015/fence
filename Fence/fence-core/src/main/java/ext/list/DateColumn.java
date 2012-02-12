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
    <p>A Column definition class which renders a passed date
    according to the default locale, or a configured 
    <a ext:cls="Ext.list.DateColumn" ext:member="format" href="output/Ext.list.DateColumn.html#Ext.list.DateColumn-format">format</a>.
    See the 
    <a ext:cls="Ext.list.Column" ext:member="xtype" href="output/Ext.list.Column.html#Ext.list.Column-xtype">xtype</a> config
    option of 
    <a ext:cls="Ext.list.Column" href="output/Ext.list.Column.html">Ext.list.Column</a> for more
    details.</p>
  </div>

 */

@InstanceOf("Ext.list.DateColumn")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.list.DateColumn")
public class DateColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.list.DateColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.list.DateColumn} instance with default property values.
	 * </p>
	 */
	public DateColumn() {
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