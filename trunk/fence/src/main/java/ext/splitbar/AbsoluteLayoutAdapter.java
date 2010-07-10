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
 * Adapter that moves the splitter element
  to align with the resized sizing element. Used with an absolute
  positioned SplitBar.
 */

@InstanceOf("Ext.SplitBar.AbsoluteLayoutAdapter")

@FacesComponent(value = "Ext.SplitBar.AbsoluteLayoutAdapter")
public class AbsoluteLayoutAdapter extends BasicLayoutAdapter {
	public static final String COMPONENT_FAMILY = "Ext.SplitBar.AbsoluteLayoutAdapter";

	/**
	 * <p>
	 * Create a new {@link Ext.SplitBar.AbsoluteLayoutAdapter} instance with default property values.
	 * </p>
	 */
	public AbsoluteLayoutAdapter() {
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