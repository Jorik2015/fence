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
    <p>The PivotGrid component enables rapid summarization of large
    data sets. It provides a way to reduce a large set of data down
    into a format where trends and insights become more apparent. A
    classic example is in sales data; a company will often have a
    record of all sales it makes for a given period - this will
    often encompass thousands of rows of data. The PivotGrid allows
    you to see how well each salesperson performed, which cities
    generate the most revenue, how products perform between cities
    and so on.</p>
    <p>A PivotGrid is composed of two axes (left and top), one 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="measure" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-measure">measure</a>
    and one 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="aggregator" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-aggregator">aggregation</a> function. Each
    axis can contain one or more 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="dimension" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-dimension">dimension</a>, which are ordered
    into a hierarchy. Dimensions on the left axis can also specify
    a width. Each dimension in each axis can specify its sort
    ordering, defaulting to "ASC", and must specify one of the
    fields in the 
    <a ext:cls="Ext.data.Record" href="output/Ext.data.Record.html">Record</a> used by the PivotGrid's 
    <a ext:cls="Ext.data.Store" href="output/Ext.data.Store.html">Store</a>.</p>
<pre>
<code>
<i>// This is the record representing a single sale</i>
<b>var</b> SaleRecord = Ext.data.Record.create([
    {name: 
<em>'person'</em>,   type: 
<em>'string'</em>},
    {name: 
<em>'product'</em>,  type: 
<em>'string'</em>},
    {name: 
<em>'city'</em>,     type: 
<em>'string'</em>},
    {name: 
<em>'state'</em>,    type: 
<em>'string'</em>},
    {name: 
<em>'year'</em>,     type: 
<em>'int'</em>},
    {name: 
<em>'value'</em>,    type: 
<em>'int'</em>}
]);

<i>// A simple store that loads SaleRecord data from a url</i>
<b>var</b> myStore = 
<b>new</b> Ext.data.Store({
    url: 
<em>'data.json'</em>,
    autoLoad: true,
    reader: 
<b>new</b> Ext.data.JsonReader({
        root: 
<em>'rows'</em>,
        idProperty: 
<em>'id'</em>
    }, SaleRecord)
});

<i>// Create the PivotGrid itself, referencing the store</i>
<b>var</b> pivot = 
<b>new</b> Ext.grid.PivotGrid({
    store     : myStore,
    aggregator: 
<em>'sum'</em>,
    measure   : 
<em>'value'</em>,

    leftAxis: [
        {
            width: 60,
            dataIndex: 
<em>'product'</em>
        },
        {
            width: 120,
            dataIndex: 
<em>'person'</em>,
            direction: 
<em>'DESC'</em>
        }
    ],

    topAxis: [
        {
            dataIndex: 
<em>'year'</em>
        }
    ]
});</code>
    </pre>
    <p>The specified 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="measure" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-measure">measure</a>
    is the field from SaleRecord that is extracted from each
    combination of product and person (on the left axis) and year
    on the top axis. There may be several SaleRecords in the data
    set that share this combination, so an array of measure fields
    is produced. This array is then aggregated using the 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="aggregator" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-aggregator">aggregator</a> function.</p>
    <p>The default aggregator function is sum, which simply adds up
    all of the extracted measure values. Other built-in aggregator
    functions are count, avg, min and max. In addition, you can
    specify your own function. In this example we show the code
    used to sum the measures, but you can return any value you
    like. See 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="aggregator" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-aggregator">aggregator</a> for more
    details.</p>
<pre>
<code>
<b>new</b> Ext.grid.PivotGrid({
    aggregator: 
<b>function</b>(records, measure) {
        
<b>var</b> length = records.length,
            total  = 0,
            i;

        
<b>for</b> (i = 0; i &lt; length; i++) {
            total += records[i].get(measure);
        }

        
<b>return</b> total;
    },
    
    renderer: 
<b>function</b>(value) {
        
<b>return</b> Math.round(value);
    },
    
    
<i>//your normal config here</i>
});</code>
    </pre>
    <p>
      <u>Renderers</u>
    </p>
    <p>PivotGrid optionally accepts a 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="renderer" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-renderer">renderer</a> function which can
    modify the data in each cell before it is rendered. The
    renderer is passed the value that would usually be placed in
    the cell and is expected to return the new value. For example
    let's imagine we had height data expressed as a decimal -
    here's how we might use a renderer to display the data in feet
    and inches notation:</p>
<pre>
<code>
<b>new</b> Ext.grid.PivotGrid({
    
<i>//
<b>in</b> each 
<b>case</b> the value is a decimal number of feet</i>
    renderer  : 
<b>function</b>(value) {
        
<b>var</b> feet   = Math.floor(value),
            inches = Math.round((value - feet) * 12);

        
<b>return</b> String.format(
<em>"{0}</em>' {1}\"</code>
<em>", feet, inches);
    },
    
<i>//normal config here</i>
});</em>
    </pre>
    <p>
      <u>Reconfiguring</u>
    </p>
    <p>All aspects PivotGrid's configuration can be updated at
    runtime. It is easy to change the 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="setMeasure" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-setMeasure">measure</a>, 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="setAggregator" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-setAggregator">aggregation function</a>, 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="setLeftAxis" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-setLeftAxis">left</a>
    and 
    <a ext:cls="Ext.grid.PivotGrid" ext:member="setTopAxis" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-setTopAxis">top</a>
    axes and refresh the grid.</p>
    <p>In this case we reconfigure the PivotGrid to have city and
    year as the top axis dimensions, rendering the average sale
    value into the cells:</p>
<pre>
<code>
<i>//the left axis can also be changed</i>
pivot.topAxis.setDimensions([
    {dataIndex: 
<em>'city'</em>, direction: 
<em>'DESC'</em>},
    {dataIndex: 
<em>'year'</em>, direction: 
<em>'ASC'</em>}
]);

pivot.setMeasure(
<em>'value'</em>);
pivot.setAggregator(
<em>'avg'</em>);

pivot.view.refresh(true);</code>
    </pre>
    <p>See the 
    <a ext:cls="Ext.grid.PivotAxis" href="output/Ext.grid.PivotAxis.html">PivotAxis</a> documentation for
    further detail on reconfiguring axes.</p>
  </div>

 */

@InstanceOf("Ext.grid.PivotGrid")
public class PivotGrid extends GridPanel {
	public static final String COMPONENT_FAMILY = "Ext.grid.PivotGrid";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PivotGrid} instance with default property values.
	 * </p>
	 */
	public PivotGrid() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			topAxis
			,leftAxis
			,aggregator
			,measure
			,renderer
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
	
		
	private Object topAxis;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Either and array of 
          <a ext:cls="Ext.grid.PivotGrid" ext:member="dimension" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-dimension">dimension</a> to use on the
          top axis, or a 
          <a ext:cls="Ext.grid.PivotAxis" href="output/Ext.grid.PivotAxis.html">Ext.grid.PivotAxis</a>
          instance. If an array is passed, it is turned into a
          PivotAxis internally.</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getTopAxis () {
		if (null != this.topAxis) {
			return this.topAxis;
		}
		ValueExpression _ve = getValueExpression("topAxis");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>topAxis</code> property.
	 * </p>
	 */
	public void setTopAxis (Object  topAxis) {
		this.topAxis = topAxis;
		this.handleConfig("topAxis", topAxis);
	}
    	
	private Object leftAxis;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Either and array of 
          <a ext:cls="Ext.grid.PivotGrid" ext:member="dimension" href="output/Ext.grid.PivotGrid.html#Ext.grid.PivotGrid-dimension">dimension</a> to use on the
          left axis, or a 
          <a ext:cls="Ext.grid.PivotAxis" href="output/Ext.grid.PivotAxis.html">Ext.grid.PivotAxis</a>
          instance. If an array is passed, it is turned into a
          PivotAxis internally.</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getLeftAxis () {
		if (null != this.leftAxis) {
			return this.leftAxis;
		}
		ValueExpression _ve = getValueExpression("leftAxis");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>leftAxis</code> property.
	 * </p>
	 */
	public void setLeftAxis (Object  leftAxis) {
		this.leftAxis = leftAxis;
		this.handleConfig("leftAxis", leftAxis);
	}
    	
	private String aggregator;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The aggregation function to use to
          combine the measures extracted for each dimension
          combination. Can be any of the built-in aggregators (sum,
          count, avg, min, max). Can also be a function which
          accepts two arguments (an array of Records to aggregate,
          and the measure to aggregate them on) and should return a
          String.</div>

	 */
	
	public String getAggregator () {
		if (null != this.aggregator) {
			return this.aggregator;
		}
		ValueExpression _ve = getValueExpression("aggregator");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>aggregator</code> property.
	 * </p>
	 */
	public void setAggregator (String  aggregator) {
		this.aggregator = aggregator;
		this.handleConfig("aggregator", aggregator);
	}
    	
	private String measure;
	
	/*
	 *
        
        
          measure
         : String
        The field to extract from each Record
        when pivoting around the two axes. See the class
        introduction docs for usage
	 */
	
	public String getMeasure () {
		if (null != this.measure) {
			return this.measure;
		}
		ValueExpression _ve = getValueExpression("measure");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>measure</code> property.
	 * </p>
	 */
	public void setMeasure (String  measure) {
		this.measure = measure;
		this.handleConfig("measure", measure);
	}
    	
	private Object renderer;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional renderer to pass values
          through before they are rendered to the dom. This gives
          an opportunity to modify cell contents after the value
          has been computed.</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getRenderer () {
		if (null != this.renderer) {
			return this.renderer;
		}
		ValueExpression _ve = getValueExpression("renderer");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>renderer</code> property.
	 * </p>
	 */
	public void setRenderer (Object  renderer) {
		this.renderer = renderer;
		this.handleConfig("renderer", renderer);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[6];
		}
		_values[0] = super.saveState(_context);
				_values[1] = topAxis;	
				_values[2] = leftAxis;	
				_values[3] = aggregator;	
				_values[4] = measure;	
				_values[5] = renderer;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.topAxis = (Object) _values[1];
		this.handleConfig("topAxis", this.topAxis);
				this.leftAxis = (Object) _values[2];
		this.handleConfig("leftAxis", this.leftAxis);
				this.aggregator = (String) _values[3];
		this.handleConfig("aggregator", this.aggregator);
				this.measure = (String) _values[4];
		this.handleConfig("measure", this.measure);
				this.renderer = (Object) _values[5];
		this.handleConfig("renderer", this.renderer);
			}
}