package ext.splitbar;

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
 * Default Adapter. It assumes the splitter
  and resizing element are not positioned elements and only
  gets/sets the width of the element. Generally used for table
  based layouts.
 */

@InstanceOf("Ext.SplitBar.BasicLayoutAdapter")

@FacesComponent(value = "Ext.SplitBar.BasicLayoutAdapter")
public class BasicLayoutAdapter extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.SplitBar.BasicLayoutAdapter";

	/**
	 * <p>
	 * Create a new {@link Ext.SplitBar.BasicLayoutAdapter} instance with default property values.
	 * </p>
	 */
	public BasicLayoutAdapter() {
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