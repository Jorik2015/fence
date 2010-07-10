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
 * A Grid which creates itself from an
  existing HTML table element.
 */

@InstanceOf("Ext.ux.grid.TableGrid")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "TableGrid.js")
@FacesComponent(value = "Ext.ux.grid.TableGrid")
public class TableGrid extends GridPanel {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.TableGrid";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.TableGrid} instance with default property values.
	 * </p>
	 */
	public TableGrid() {
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