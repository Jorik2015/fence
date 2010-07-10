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
 * A specific 
  Ext.data.Record type that
  represents a name/value pair and is made to work with the 
  Ext.grid.PropertyGrid.
  Typically, PropertyRecords do not need to be created directly as
  they can be created implicitly by simply using the appropriate
  data configs either via the 
  Ext.grid.PropertyGrid.source
  config property or by calling 
  Ext.grid.PropertyGrid.setSource.
  However, if the need arises, these records can also be created
  explicitly as shwon below. Example usage: 


var rec = 
new Ext.grid.PropertyRecord({
    name: 
'Birthday',
    value: 
new Date(Date.parse(
'05/26/1972'))
});
// Add record to an already populated grid
grid.store.addSorted(rec);
  
 */

@InstanceOf("Ext.grid.PropertyRecord")

@FacesComponent(value = "Ext.grid.PropertyRecord")
public class PropertyRecord extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.grid.PropertyRecord";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PropertyRecord} instance with default property values.
	 * </p>
	 */
	public PropertyRecord() {
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