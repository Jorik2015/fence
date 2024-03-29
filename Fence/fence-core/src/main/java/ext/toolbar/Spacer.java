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
<div class="description">A simple element that adds extra
  horizontal space between items in a toolbar. By default a 2px
  wide space is added via css specification:
<pre>
<code>.x-toolbar .xtb-spacer {
    width:2px;
}</code>
  </pre>
  <p>Example usage:</p>
<pre>
<code>
<b>new</b> Ext.Panel({
    tbar : [
        
<em>'Item 1'</em>,
        {xtype: 
<em>'tbspacer'</em>}, 
<i>// or 
<em>' '</em>
</i>
        
<em>'Item 2'</em>,
        
<i>// space width is also configurable via javascript</i>
        {xtype: 
<em>'tbspacer'</em>, width: 50}, 
<i>// add a 50px space</i>
        
<em>'Item 3'</em>
    ]
});</code>
  </pre>
</div>

 */
@XType("tbspacer")
@InstanceOf("Ext.Toolbar.Spacer")
@ParseConfigMode(name="items",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Config)
@FacesComponent(value = "Ext.Toolbar.Spacer")
public class Spacer extends Item {
	public static final String COMPONENT_FAMILY = "Ext.Toolbar.Spacer";

	/**
	 * <p>
	 * Create a new {@link Ext.Toolbar.Spacer} instance with default property values.
	 * </p>
	 */
	public Spacer() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			width
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
        
        
          width
         : Number
        The width of the spacer in pixels
        (defaults to 2px via css style 
        .x-toolbar .xtb-spacer).
	 */
	
	public Integer getWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.width);
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth ( Integer   width ) {
		getStateHelper().put(PropertyKeys.width, width);
		handleAttribute("width", width);
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