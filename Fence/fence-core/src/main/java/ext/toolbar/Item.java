package ext.toolbar;

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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">The base class that other
  non-interacting Toolbar Item classes should extend in order to
  get some basic common toolbar item functionality.</div>

 */
@XType("tbitem")
@InstanceOf("Ext.Toolbar.Item")
@ParseConfigMode(name="items",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.Toolbar.Item")
public class Item extends BoxComponent {
	public static final String COMPONENT_FAMILY = "Ext.Toolbar.Item";

	/**
	 * <p>
	 * Create a new {@link Ext.Toolbar.Item} instance with default property values.
	 * </p>
	 */
	public Item() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			overflowText
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
        
        
          overflowText
         : String
        Text to be used for the menu if the item
        is overflowed.
	 */
	
	public String getOverflowText () {
		return (String) getStateHelper().eval(PropertyKeys.overflowText);
	}

	/**
	 * <p>
	 * Set the value of the <code>overflowText</code> property.
	 * </p>
	 */
	public void setOverflowText ( String   overflowText ) {
		getStateHelper().put(PropertyKeys.overflowText, overflowText);
		handleAttribute("overflowText", overflowText);
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