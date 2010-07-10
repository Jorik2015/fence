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
 * Provides AJAX-style update capabilities
  for Element objects. Updater can be used to 
  update an 
  Ext.Element once, or you can use 
  startAutoRefresh to set up an
  auto-updating 
  Element on a specific interval.
  
  Usage:
  


var el = Ext.get(
"foo"); 
// Get Ext.Element object
var mgr = el.getUpdater();
mgr.update({
        url: 
"http:
//myserver.com/index.php",
        params: {
            param1: 
"foo",
            param2: 
"bar"
        }
});
...
mgr.formUpdate(
"myFormId", 
"http:
//myserver.com/index.php");

// or directly (returns the same Updater instance)
var mgr = 
new Ext.Updater(
"myElementId");
mgr.startAutoRefresh(60, 
"http:
//myserver.com/index.php");
mgr.on(
"update", myFcnNeedsToKnow);

// short handed call directly from the element object
Ext.get(
"foo").load({
        url: 
"bar.php",
        scripts: true,
        params: 
"param1=foo&param2=bar",
        text: 
"Loading Foo..."
});
  
 */

@InstanceOf("Ext.Updater")

@FacesComponent(value = "Ext.Updater")
public class Updater extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.Updater";

	/**
	 * <p>
	 * Create a new {@link Ext.Updater} instance with default property values.
	 * </p>
	 */
	public Updater() {
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
					 "beforeupdate"
					, "failure"
					, "update"
				));
				return superEvent;
	}
}