package ext.grid;

import javax.el.ValueExpression;
import ext.annotation.*;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
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
@ParseConfigMode(ui = false, name = "leftAxis", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class LeftPivotAxis extends Component {
	public static final String COMPONENT_FAMILY = "Ext.grid.LeftPivotAxis";

	/**
	 * <p>
	 * Create a new {@link LeftPivotAxis.grid.PivotAxis} instance with default property values.
	 * </p>
	 */
	public LeftPivotAxis() {
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
	
		
	private String orientation;
	
	/*
	 *
        
        
          orientation
         : String
        One of 'vertical' or 'horizontal'.
        Defaults to horizontal
	 */
	
	public String getOrientation () {
		if (null != this.orientation) {
			return this.orientation;
		}
		ValueExpression _ve = getValueExpression("orientation");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>orientation</code> property.
	 * </p>
	 */
	public void setOrientation (String  orientation) {
		this.orientation = orientation;
		this.handleConfig("orientation", orientation);
	}
    	
	private Integer defaultHeaderWidth;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The width to render each row header
          that does not have a width specified via 
          <a ext:cls="Ext.grid.PivotAxis" ext:member="getRowGroupHeaders" href="output/Ext.grid.PivotAxis.html#Ext.grid.PivotAxis-getRowGroupHeaders">getRowGroupHeaders</a>.
          Defaults to 80.</div>

	 */
	
	public Integer getDefaultHeaderWidth () {
		if (null != this.defaultHeaderWidth) {
			return this.defaultHeaderWidth;
		}
		ValueExpression _ve = getValueExpression("defaultHeaderWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultHeaderWidth</code> property.
	 * </p>
	 */
	public void setDefaultHeaderWidth (Integer  defaultHeaderWidth) {
		this.defaultHeaderWidth = defaultHeaderWidth;
		this.handleConfig("defaultHeaderWidth", defaultHeaderWidth);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
				_values[1] = orientation;	
				_values[2] = defaultHeaderWidth;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.orientation = (String) _values[1];
		this.handleConfig("orientation", this.orientation);
				this.defaultHeaderWidth = (Integer) _values[2];
		this.handleConfig("defaultHeaderWidth", this.defaultHeaderWidth);
			}
}