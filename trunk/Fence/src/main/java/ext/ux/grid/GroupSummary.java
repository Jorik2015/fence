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
 * A GridPanel plugin that enables dynamic
  column calculations and a dynamically updated grouped summary
  row.
 */

@InstanceOf("Ext.ux.grid.GroupSummary")
@ParseConfigMode(ui = false,name="plugins",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@ResourceDependency(library = "ext#{ext.version}/ux", name = "GroupSummary.js")
@FacesComponent(value = "Ext.ux.grid.GroupSummary")
public class GroupSummary extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.GroupSummary";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.GroupSummary} instance with default property values.
	 * </p>
	 */
	public GroupSummary() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			summaryRenderer
			,summaryType
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
	 *Renderer example:

summaryRenderer: 
function(v, params, data){
    
return ((v === 0 || v > 1) ? 
'(' + v +
' Tasks)' : 
'(1 Task)');
},
          
	 */
	@ClientConfig(JsonMode.Function)

	public Object getSummaryRenderer () {
		return (Object) getStateHelper().eval(PropertyKeys.summaryRenderer);
	}

	/**
	 * <p>
	 * Set the value of the <code>summaryRenderer</code> property.
	 * </p>
	 */
	public void setSummaryRenderer ( Object   summaryRenderer ) {
		getStateHelper().put(PropertyKeys.summaryRenderer, summaryRenderer);
		handleAttribute("summaryRenderer", summaryRenderer);
	}
    	/*
	 *
        
        
          summaryType
         : String
        The type of calculation to be used for
        the column. For options available see 
        Calculations.
	 */
	
	public String getSummaryType () {
		return (String) getStateHelper().eval(PropertyKeys.summaryType);
	}

	/**
	 * <p>
	 * Set the value of the <code>summaryType</code> property.
	 * </p>
	 */
	public void setSummaryType ( String   summaryType ) {
		getStateHelper().put(PropertyKeys.summaryType, summaryType);
		handleAttribute("summaryType", summaryType);
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