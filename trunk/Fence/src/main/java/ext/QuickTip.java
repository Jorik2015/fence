package ext;

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
import java.util.Date;

/**
 * ${ext.commonts}
 */

@InstanceOf("Ext.QuickTip")

@FacesComponent(value = "Ext.QuickTip")
public class QuickTip extends ToolTip {
	public static final String COMPONENT_FAMILY = "Ext.QuickTip";

	/**
	 * <p>
	 * Create a new {@link Ext.QuickTip} instance with default property values.
	 * </p>
	 */
	public QuickTip() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			interceptTitles
			,target
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
        
        
          interceptTitles
         : Boolean
        True to automatically use the element's
        DOM title value if available (defaults to
        false).
	 */
	
	public Boolean getInterceptTitles () {
		return (Boolean) getStateHelper().eval(PropertyKeys.interceptTitles);
	}

	/**
	 * <p>
	 * Set the value of the <code>interceptTitles</code> property.
	 * </p>
	 */
	public void setInterceptTitles ( Boolean   interceptTitles ) {
		getStateHelper().put(PropertyKeys.interceptTitles, interceptTitles);
		handleAttribute("interceptTitles", interceptTitles);
	}
    	/*
	 *
        
        
          target
         : Mixed
        The target HTMLElement, Ext.Element or
        id to associate with this quicktip (defaults to the
        document).
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTarget () {
		return (Object) getStateHelper().eval(PropertyKeys.target);
	}

	/**
	 * <p>
	 * Set the value of the <code>target</code> property.
	 * </p>
	 */
	public void setTarget ( Object   target ) {
		getStateHelper().put(PropertyKeys.target, target);
		handleAttribute("target", target);
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