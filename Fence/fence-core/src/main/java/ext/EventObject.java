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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">Just as 
  <a ext:cls="Ext.Element" href="output/Ext.Element.html">Ext.Element</a> wraps around a native DOM
  node, Ext.EventObject wraps the browser's native event-object
  normalizing cross-browser differences, such as which mouse button
  is clicked, keys pressed, mechanisms to stop event-propagation
  along with a method to prevent default actions from taking place.
  
  <p>For example:</p>
<pre>
<code>
<b>function</b> handleClick(e, t){ 
<i>// e is not a standard event object, it is a Ext.EventObject</i>
    e.preventDefault();
    
<b>var</b> target = e.getTarget(); 
<i>// same as t (the target HTMLElement)</i>
    ...
}
<b>var</b> myDiv = 
<a ext:cls="Ext" ext:member="get" href="output/Ext.html#Ext-get">Ext.get</a>(
<em>"myDiv"</em>);  
<i>// get reference to an 
<a ext:cls="Ext.Element" href="output/Ext.Element.html">Ext.Element</a>
</i>
myDiv.on(         
<i>// 
<em>'on'</em> is shorthand 
<b>for</b> addListener</i>
    
<em>"click"</em>,      
<i>// perform an action on click of myDiv</i>
    handleClick   
<i>// reference to the action handler</i>
);
<i>// other methods to 
<b>do</b> the same:</i>
Ext.EventManager.on(
<em>"myDiv"</em>, 
<em>'click'</em>, handleClick);
Ext.EventManager.addListener(
<em>"myDiv"</em>, 
<em>'click'</em>, handleClick);</code>
  </pre>
  <br/>
  <br/>
  <i>This class is a singleton and cannot be created
  directly.</i>
</div>

 */

@InstanceOf("Ext.EventObject")

@FacesComponent(value = "Ext.EventObject")
public class EventObject extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.EventObject";

	/**
	 * <p>
	 * Create a new {@link Ext.EventObject} instance with default property values.
	 * </p>
	 */
	public EventObject() {
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