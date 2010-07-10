package ext.ux.grid;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependencies;
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
 * Plugin (ptype = 'roweditor') that adds
  the ability to rapidly edit full rows in a grid. A validation
  mode may be enabled which uses AnchorTips to notify the user of
  all validation errors at once.
 */

@InstanceOf("Ext.ux.grid.RowEditor")
@ParseConfigMode(ui = false,name="plugins",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@ResourceDependencies({
	@ResourceDependency(library = "ext#{ext.version}/ux", name = "RowEditor.js"),
	@ResourceDependency(name = "ext#{ext.version}/ux/css/RowEditor.css")
})
@FacesComponent(value = "Ext.ux.grid.RowEditor")
public class RowEditor extends Panel {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.RowEditor";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.RowEditor} instance with default property values.
	 * </p>
	 */
	public RowEditor() {
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
				superEvent.addAll(Arrays.asList(
					 "afteredit"
					, "beforeedit"
					, "canceledit"
					, "validateedit"
				));
				return superEvent;
	}
}