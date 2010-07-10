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
 * Adds capability to specify the summary
  data for the group via json as illustrated here: 

{
    data: [
        {
            projectId: 100,     project: 
'House',
            taskId:    112, description: 
'Paint',
            estimate:    6,        rate:     150,
            due:
'06/24/2007'
        },
        ...
    ],

    summaryData: {
        
'House': {
            description: 14, estimate: 9,
                   rate: 99, due: 
new Date(2009, 6, 29),
                   cost: 999
        }
    }
}
  
 */

@InstanceOf("Ext.ux.grid.HybridSummary")
@ParseConfigMode(ui = false,name="plugins",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@ResourceDependency(library = "ext#{ext.version}/ux", name = "GroupSummary.js")
@FacesComponent(value = "Ext.ux.grid.HybridSummary")
public class HybridSummary extends GroupSummary {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.HybridSummary";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.HybridSummary} instance with default property values.
	 * </p>
	 */
	public HybridSummary() {
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