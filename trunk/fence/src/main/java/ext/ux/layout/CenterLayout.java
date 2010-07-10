package ext.ux.layout;

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
    This is a very simple layout style used to center contents
    within a container. This layout works within nested containers
    and can also be used as expected as a Viewport layout to center
    the page layout.
    As a subclass of FitLayout, CenterLayout expects to have a
    single child panel of the container that uses the layout. The
    layout does not require any config options, although the child
    panel contained within the layout must provide a fixed or
    percentage width. The child panel's height will fit to the
    container by default, but you can specify 
    autoHeight:true to allow it to autosize based on its
    content height. Example usage:


// The content panel is centered 
in the container
var p = 
new Ext.Panel({
    title: 
'Center Layout',
    layout: 
'ux.center',
    items: [{
        title: 
'Centered Content',
        width: 
'75%',
        html: 
'Some content'
    }]
});

// If you leave the title blank and specify no border
// you
'll create a non-visual, structural panel just
// 
for centering the contents 
in the main container.
var p = 
new Ext.Panel({
    layout: 'ux.center
',
    border: false,
    items: [{
        title: 'Centered Content
',
        width: 300,
        autoHeight: true,
        html: 'Some content
'
    }]
});
    
  
 */

@Layout(LayoutType.center)
@InstanceOf("Ext.ux.layout.CenterLayout")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "CenterLayout.js")
@ParseConfigMode(ui = false,name="layoutConfig",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.ux.layout.CenterLayout")
public class CenterLayout extends FitLayout {
	public static final String COMPONENT_FAMILY = "Ext.ux.layout.CenterLayout";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.layout.CenterLayout} instance with default property values.
	 * </p>
	 */
	public CenterLayout() {
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