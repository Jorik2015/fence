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
 * A non-rendering placeholder item which
  instructs the Toolbar's Layout to begin using the right-justified
  button container. 


new Ext.Panel({
    tbar : [
        
'Item 1',
        {xtype: 
'tbfill'}, 
// or 
'->'
        
'Item 2'
    ]
});
  
 */
@XType("tbfill")
@InstanceOf("Ext.Toolbar.Fill")
@ParseConfigMode(name="items",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.Toolbar.Fill")
public class Fill extends Spacer {
	public static final String COMPONENT_FAMILY = "Ext.Toolbar.Fill";

	/**
	 * <p>
	 * Create a new {@link Ext.Toolbar.Fill} instance with default property values.
	 * </p>
	 */
	public Fill() {
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