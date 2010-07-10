package ext.ux.form;

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
 * 
    Makes a ComboBox more closely mimic an HTML SELECT. Supports
    clicking and dragging through the list, with item selection
    occurring when the mouse button is released. When used will
    automatically set 
    editable to false and call 
    Ext.Element.unselectable on inner
    elements. Re-enabling editable after calling this will NOT
    work.
  
 */

@InstanceOf("Ext.ux.form.SelectBox")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "SelectBox.js")
@FacesComponent(value = "Ext.ux.form.SelectBox")
public class SelectBox extends ComboBox {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.SelectBox";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.form.SelectBox} instance with default property values.
	 * </p>
	 */
	public SelectBox() {
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