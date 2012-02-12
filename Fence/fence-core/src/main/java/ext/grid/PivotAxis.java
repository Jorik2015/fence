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
<div class="description">
  <p>PivotAxis is a class that supports a 
  <a ext:cls="Ext.grid.PivotGrid" href="output/Ext.grid.PivotGrid.html">Ext.grid.PivotGrid</a>. Each
  PivotGrid contains two PivotAxis instances - the left axis and
  the top axis. Each PivotAxis defines an ordered set of
  dimensions, each of which should correspond to a field in a
  Store's Record (see 
  <a ext:cls="Ext.grid.PivotGrid" href="output/Ext.grid.PivotGrid.html">Ext.grid.PivotGrid</a> documentation
  for further explanation).</p>
  <p>Developers should have little interaction with the PivotAxis
  instances directly as most of their management is performed by
  the PivotGrid. An exception is the dynamic reconfiguration of
  axes at run time - to achieve this we use PivotAxis's 
  <a ext:cls="Ext.grid.PivotAxis" ext:member="setDimensions" href="output/Ext.grid.PivotAxis.html#Ext.grid.PivotAxis-setDimensions">setDimensions</a> function and
  refresh the grid:</p>
<pre>
<code>
<b>var</b> pivotGrid = 
<b>new</b> Ext.grid.PivotGrid({
    
<i>//some PivotGrid config here</i>
});

<i>//change the left axis dimensions</i>
pivotGrid.leftAxis.setDimensions([
    {
        dataIndex: 
<em>'person'</em>,
        direction: 
<em>'DESC'</em>,
        width    : 100
    },
    {
        dataIndex: 
<em>'product'</em>,
        direction: 
<em>'ASC'</em>,
        width    : 80
    }
]);

pivotGrid.view.refresh(true);</code>
  </pre>This clears the previous dimensions on the axis and redraws
  the grid with the new dimensions.</div>

 */

@InstanceOf("Ext.grid.PivotAxis")
@ParseConfigMode(ui = false,pmode=PersistenceMode.Custom,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.PivotAxis")
public class PivotAxis extends Component {
	public static final String COMPONENT_FAMILY = "Ext.grid.PivotAxis";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PivotAxis} instance with default property values.
	 * </p>
	 */
	public PivotAxis() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			orientation
			,defaultHeaderWidth
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
        
        
          orientation
         : String
        One of 'vertical' or 'horizontal'.
        Defaults to horizontal
	 */
	
	public String getOrientation () {
		return (String) getStateHelper().eval(PropertyKeys.orientation);
	}

	/**
	 * <p>
	 * Set the value of the <code>orientation</code> property.
	 * </p>
	 */
	public void setOrientation ( String   orientation ) {
		getStateHelper().put(PropertyKeys.orientation, orientation);
		handleAttribute("orientation", orientation);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The width to render each row header
          that does not have a width specified via 
          <a ext:cls="Ext.grid.PivotAxis" ext:member="getRowGroupHeaders" href="output/Ext.grid.PivotAxis.html#Ext.grid.PivotAxis-getRowGroupHeaders">getRowGroupHeaders</a>.
          Defaults to 80.</div>

	 */
	
	public Integer getDefaultHeaderWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.defaultHeaderWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultHeaderWidth</code> property.
	 * </p>
	 */
	public void setDefaultHeaderWidth ( Integer   defaultHeaderWidth ) {
		getStateHelper().put(PropertyKeys.defaultHeaderWidth, defaultHeaderWidth);
		handleAttribute("defaultHeaderWidth", defaultHeaderWidth);
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