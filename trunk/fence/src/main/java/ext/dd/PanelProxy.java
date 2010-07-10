package ext.dd;

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
 * A custom drag proxy implementation
  specific to 
  Ext.Panels. This class is primarily used
  internally for the Panel's drag drop implementation, and should
  never need to be created directly.
 */

@InstanceOf("Ext.dd.PanelProxy")
@ParseConfigMode(ui = false,name="proxy",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.dd.PanelProxy")
public class PanelProxy extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.dd.PanelProxy";

	/**
	 * <p>
	 * Create a new {@link Ext.dd.PanelProxy} instance with default property values.
	 * </p>
	 */
	public PanelProxy() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			insertProxy
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
	 *
        
        
          insertProxy
         : Boolean
        True to insert a placeholder proxy
        element while dragging the panel, false to drag with no
        proxy (defaults to true).
	 */
	
	public Boolean getInsertProxy () {
		return (Boolean) getStateHelper().eval(PropertyKeys.insertProxy);
	}

	/**
	 * <p>
	 * Set the value of the <code>insertProxy</code> property.
	 * </p>
	 */
	public void setInsertProxy ( Boolean   insertProxy ) {
		getStateHelper().put(PropertyKeys.insertProxy, insertProxy);
		handleAttribute("insertProxy", insertProxy);
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