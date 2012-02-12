package ext.slider;

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
<div class="description">Simple plugin for using an Ext.Tip with
  a slider to show the slider value. Example usage: 
<pre>
new Ext.Slider({
    width: 214,
    minValue: 0,
    maxValue: 100,
    plugins: new Ext.slider.Tip()
});
  </pre>Optionally provide your own tip text by overriding getText:
  
<pre>
 new Ext.Slider({
     width: 214,
     minValue: 0,
     maxValue: 100,
     plugins: new Ext.slider.Tip({
         getText: function(thumb){
             return String.format('
<b>{0}% complete</b>', thumb.value);
         }
     })
 });
  </pre>
</div>

 */

@InstanceOf("Ext.slider.Tip")

@FacesComponent(value = "Ext.slider.Tip")
public class Tip extends ext.Tip {
	public static final String COMPONENT_FAMILY = "Ext.slider.Tip";

	/**
	 * <p>
	 * Create a new {@link Ext.slider.Tip} instance with default property values.
	 * </p>
	 */
	public Tip() {
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