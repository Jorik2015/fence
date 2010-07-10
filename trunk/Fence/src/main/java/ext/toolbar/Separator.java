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
 * A simple class that adds a vertical
  separator bar between toolbar items (css class:
  'xtb-sep'). Example usage: 


new Ext.Panel({
    tbar : [
        
'Item 1',
        {xtype: 
'tbseparator'}, 
// or 
'-'
        
'Item 2'
    ]
});
  
 */
@XType("tbseparator")
@InstanceOf("Ext.Toolbar.Separator")
@ParseConfigMode(name="items",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.Toolbar.Separator")
public class Separator extends Item {
	public static final String COMPONENT_FAMILY = "Ext.Toolbar.Separator";

	/**
	 * <p>
	 * Create a new {@link Ext.Toolbar.Separator} instance with default property values.
	 * </p>
	 */
	public Separator() {
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