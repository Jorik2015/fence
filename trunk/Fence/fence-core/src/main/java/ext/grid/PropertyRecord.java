package ext.grid;

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
<div class="description">A specific 
  <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Ext.data.Record</a> type that
  represents a name/value pair and is made to work with the 
  <a ext:cls="Ext.grid.PropertyGrid" href="output/Ext.grid.PropertyGrid.html">Ext.grid.PropertyGrid</a>.
  Typically, PropertyRecords do not need to be created directly as
  they can be created implicitly by simply using the appropriate
  data configs either via the 
  <a ext:cls="Ext.grid.PropertyGrid" ext:member="source" href="output/Ext.grid.PropertyGrid.html#Ext.grid.PropertyGrid-source">Ext.grid.PropertyGrid.source</a>
  config property or by calling 
  <a ext:cls="Ext.grid.PropertyGrid" ext:member="setSource" href="output/Ext.grid.PropertyGrid.html#Ext.grid.PropertyGrid-setSource">Ext.grid.PropertyGrid.setSource</a>.
  However, if the need arises, these records can also be created
  explicitly as shwon below. Example usage: 
<pre>
<code>
<b>var</b> rec = 
<b>new</b> Ext.grid.PropertyRecord({
    name: 
<em>'Birthday'</em>,
    value: 
<b>new</b> Date(Date.parse(
<em>'05/26/1972'</em>))
});
<i>// Add record to an already populated grid</i>
grid.store.addSorted(rec);</code>
  </pre>
</div>

 */

@InstanceOf("Ext.grid.PropertyRecord")

@FacesComponent(value = "Ext.grid.PropertyRecord")
public class PropertyRecord extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.grid.PropertyRecord";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PropertyRecord} instance with default property values.
	 * </p>
	 */
	public PropertyRecord() {
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