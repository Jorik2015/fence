package ext.ux.grid;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
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
 * GridPanel plugin to add a column with
  check boxes to a grid. 
  Example usage:


// create the column

var checkColumn = 
new Ext.grid.CheckColumn({
   header: 
'Indoor?',
   dataIndex: 
'indoor',
   id: 
'check',
   width: 55
});

// add the column to the column model

var cm = 
new Ext.grid.ColumnModel([{
       header: 
'Foo',
       ...
    },
    checkColumn
]);

// create the grid

var grid = 
new Ext.grid.EditorGridPanel({
    ...
    cm: cm,
    plugins: [checkColumn], 
// include plugin

    ...
});
  In addition to storing a Boolean value within the record
  data, this class toggles a css class between 
  'x-grid3-check-col' and 
  'x-grid3-check-col-on' to alter the background image
  used for a column.
 */

@InstanceOf("Ext.ux.grid.CheckColumn")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "CHeckColumn.js")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.ux.grid.CheckColumn")
public class CheckColumn extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.CheckColumn";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.CheckColumn} instance with default property values.
	 * </p>
	 */
	public CheckColumn() {
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