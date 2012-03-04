package ext.list;

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
    <p>Ext.list.ListView is a fast and light-weight implentation of
    a 
    <a ext:cls="Ext.grid.GridPanel" href="output/Ext.grid.GridPanel.html">Grid</a> like view with the
    following characteristics:</p>
    <div class="mdetail-params">
      <ul>
        <li>resizable columns</li>
        <li>selectable</li>
        <li>column widths are initially proportioned by percentage
        based on the container width and number of columns</li>
        <li>uses templates to render the data in any required
        format</li>
        <li>no horizontal scrolling</li>
        <li>no editing</li>
      </ul>
    </div>
    <p>Example usage:</p>
<pre>
<code>
<i>// consume JSON of this form:</i>
{
   
<em>"images"</em>:[
      {
         
<em>"name"</em>:
<em>"dance_fever.jpg"</em>,
         
<em>"size"</em>:2067,
         
<em>"lastmod"</em>:1236974993000,
         
<em>"url"</em>:
<em>"images\/thumbs\/dance_fever.jpg"</em>
      },
      {
         
<em>"name"</em>:
<em>"zack_sink.jpg"</em>,
         
<em>"size"</em>:2303,
         
<em>"lastmod"</em>:1236974993000,
         
<em>"url"</em>:
<em>"images\/thumbs\/zack_sink.jpg"</em>
      }
   ]
}
<b>var</b> store = 
<b>new</b> Ext.data.JsonStore({
    url: 
<em>'get-images.php'</em>,
    root: 
<em>'images'</em>,
    fields: [
        
<em>'name'</em>, 
<em>'url'</em>,
        {name:
<em>'size'</em>, type: 
<em>'float'</em>},
        {name:
<em>'lastmod'</em>, type:
<em>'date'</em>, dateFormat:
<em>'timestamp'</em>}
    ]
});
store.load();

<b>var</b> listView = 
<b>new</b> Ext.list.ListView({
    store: store,
    multiSelect: true,
    emptyText: 
<em>'No images to display'</em>,
    reserveScrollOffset: true,
    columns: [{
        header: 
<em>'File'</em>,
        width: .5,
        dataIndex: 
<em>'name'</em>
    },{
        header: 
<em>'Last Modified'</em>,
        width: .35,
        dataIndex: 
<em>'lastmod'</em>,
        tpl: 
<em>'{lastmod:date(</em>"m-d h:i a"</code>)}'
    },{
        header: 
<em>'Size'</em>,
        dataIndex: 
<em>'size'</em>,
        tpl: 
<em>'{size:fileSize}'</em>, 
<i>// format using Ext.util.Format.fileSize()</i>
        align: 
<em>'right'</em>
    }]
});

<i>// put it 
<b>in</b> a Panel so it looks pretty</i>
<b>var</b> panel = 
<b>new</b> Ext.Panel({
    id:
<em>'images-view'</em>,
    width:425,
    height:250,
    collapsible:true,
    layout:
<em>'fit'</em>,
    title:
<em>'Simple ListView 
<i>(0 items selected)</i>'</em>,
    items: listView
});
panel.render(document.body);

<i>// little bit of feedback</i>
listView.on(
<em>'selectionchange'</em>, 
<b>function</b>(view, nodes){
    
<b>var</b> l = nodes.length;
    
<b>var</b> s = l != 1 ? 
<em>'s'</em> : 
<em>''</em>;
    panel.setTitle(
<em>'Simple ListView 
<i>('</i>+l+</em>' item'+s+
<em>' selected)</em>');
});
    </pre>
  </div>

 */

@InstanceOf("Ext.list.ListView")
@ParseConfigMode(ui = false, name = "items", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class ListView extends DataView {
	public static final String COMPONENT_FAMILY = "Ext.list.ListView";

	/**
	 * <p>
	 * Create a new {@link Ext.list.ListView} instance with default property values.
	 * </p>
	 */
	public ListView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			reserveScrollOffset
			,overClass
			,itemSelector
			,columnSort
			,columns
			,selectedClass
			,columnResize
			,scrollOffset
			,internalTpl
			,hideHeaders
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
	
		
	private Boolean reserveScrollOffset;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">By default will defer accounting for
          the configured 
          <b>
            <tt>
              <a ext:cls="Ext.list.ListView" ext:member="scrollOffset" href="output/Ext.list.ListView.html#Ext.list.ListView-scrollOffset">scrollOffset</a>
            </tt>
          </b> for 10 milliseconds. Specify 
          <tt>true</tt> to account for the configured 
          <b>
            <tt>
              <a ext:cls="Ext.list.ListView" ext:member="scrollOffset" href="output/Ext.list.ListView.html#Ext.list.ListView-scrollOffset">scrollOffset</a>
            </tt>
          </b> immediately.</div>

	 */
	
	public Boolean getReserveScrollOffset () {
		if (null != this.reserveScrollOffset) {
			return this.reserveScrollOffset;
		}
		ValueExpression _ve = getValueExpression("reserveScrollOffset");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>reserveScrollOffset</code> property.
	 * </p>
	 */
	public void setReserveScrollOffset (Boolean  reserveScrollOffset) {
		this.reserveScrollOffset = reserveScrollOffset;
		this.handleConfig("reserveScrollOffset", reserveScrollOffset);
	}
    	
	private String overClass;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The CSS class applied when over a row
          (defaults to 
          <tt>'x-list-over'</tt>). An example overriding the
          default styling: 
<pre>
<code>.x-list-over {background-color: orange;}</code>
          </pre>
</div>

	 */
	
	public String getOverClass () {
		if (null != this.overClass) {
			return this.overClass;
		}
		ValueExpression _ve = getValueExpression("overClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>overClass</code> property.
	 * </p>
	 */
	public void setOverClass (String  overClass) {
		this.overClass = overClass;
		this.handleConfig("overClass", overClass);
	}
    	
	private String itemSelector;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Defaults to 
          <tt>'dl'</tt> to work with the preconfigured 
          <b>
            <tt>
              <a ext:cls="Ext.DataView" ext:member="tpl" href="output/Ext.DataView.html#Ext.DataView-tpl">tpl</a>
            </tt>
          </b>. This setting specifies the CSS selector (e.g. 
          <tt>div.some-class</tt> or 
          <tt>span:first-child</tt>) that will be used to determine
          what nodes the ListView will be working with.</div>

	 */
	
	public String getItemSelector () {
		if (null != this.itemSelector) {
			return this.itemSelector;
		}
		ValueExpression _ve = getValueExpression("itemSelector");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>itemSelector</code> property.
	 * </p>
	 */
	public void setItemSelector (String  itemSelector) {
		this.itemSelector = itemSelector;
		this.handleConfig("itemSelector", itemSelector);
	}
    	
	private Boolean columnSort;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Specify 
          <tt>true</tt> or specify a configuration object for 
          <a ext:cls="Ext.list.ListView.Sorter" href="output/Ext.list.ListView.Sorter.html">Ext.list.ListView.Sorter</a>
          to enable the columns to be sortable (defaults to 
          <tt>true</tt>).</div>

	 */
	
	public Boolean getColumnSort () {
		if (null != this.columnSort) {
			return this.columnSort;
		}
		ValueExpression _ve = getValueExpression("columnSort");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>columnSort</code> property.
	 * </p>
	 */
	public void setColumnSort (Boolean  columnSort) {
		this.columnSort = columnSort;
		this.handleConfig("columnSort", columnSort);
	}
    	
	private Object columns;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">An array of column configuration
          objects, for example: 
<pre>
<code>{
    align: 
<em>'right'</em>,
    dataIndex: 
<em>'size'</em>,
    header: 
<em>'Size'</em>,
    tpl: 
<em>'{size:fileSize}'</em>,
    width: .35
}</code>
          </pre>Acceptable properties for each column configuration
          object are: 
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>align</tt>
              </b> : String
              <div class="sub-desc">Set the CSS text-align property
              of the column. Defaults to 
              <tt>'left'</tt>.</div>
</li>
              <li>
              <b>
                <tt>dataIndex</tt>
              </b> : String
              <div class="sub-desc">See 
              <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a>. 
              <a ext:cls="Ext.grid.Column" ext:member="dataIndex" href="output/Ext.grid.Column.html#Ext.grid.Column-dataIndex">dataIndex</a> for
              details.</div>
</li>
              <li>
              <b>
                <tt>header</tt>
              </b> : String
              <div class="sub-desc">See 
              <a ext:cls="Ext.grid.Column" href="output/Ext.grid.Column.html">Ext.grid.Column</a>. 
              <a ext:cls="Ext.grid.Column" ext:member="header" href="output/Ext.grid.Column.html#Ext.grid.Column-header">header</a> for
              details.</div>
</li>
              <li>
              <b>
                <tt>tpl</tt>
              </b> : String
              <div class="sub-desc">Specify a string to pass as the
              configuration string for 
              <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a>. By default
              an 
              <a ext:cls="Ext.XTemplate" href="output/Ext.XTemplate.html">Ext.XTemplate</a> will be
              implicitly created using the 
              <tt>dataIndex</tt>.</div>
</li>
              <li>
              <b>
                <tt>width</tt>
              </b> : Number
              <div class="sub-desc">Percentage of the container
              width this column should be allocated. Columns that
              have no width specified will be allocated with an
              equal percentage to fill 100% of the container width.
              To easily take advantage of the full container width,
              leave the width of at least one column undefined.
              Note that if you do not want to take up the full
              width of the container, the width of every column
              needs to be explicitly defined.</div>
</li>
            </ul>
          </div>
</div>

	 */
	@ClientConfig(JsonMode.Array)

	public Object getColumns () {
		if (null != this.columns) {
			return this.columns;
		}
		ValueExpression _ve = getValueExpression("columns");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns (Object  columns) {
		this.columns = columns;
		this.handleConfig("columns", columns);
	}
    	
	private String selectedClass;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The CSS class applied to a selected row
          (defaults to 
          <tt>'x-list-selected'</tt>). An example overriding the
          default styling: 
<pre>
<code>.x-list-selected {background-color: yellow;}</code>
          </pre>
</div>

	 */
	
	public String getSelectedClass () {
		if (null != this.selectedClass) {
			return this.selectedClass;
		}
		ValueExpression _ve = getValueExpression("selectedClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>selectedClass</code> property.
	 * </p>
	 */
	public void setSelectedClass (String  selectedClass) {
		this.selectedClass = selectedClass;
		this.handleConfig("selectedClass", selectedClass);
	}
    	
	private Boolean columnResize;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Specify 
          <tt>true</tt> or specify a configuration object for 
          <a ext:cls="Ext.list.ListView.ColumnResizer" href="output/Ext.list.ListView.ColumnResizer.html">Ext.list.ListView.ColumnResizer</a>
          to enable the columns to be resizable (defaults to 
          <tt>true</tt>).</div>

	 */
	
	public Boolean getColumnResize () {
		if (null != this.columnResize) {
			return this.columnResize;
		}
		ValueExpression _ve = getValueExpression("columnResize");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>columnResize</code> property.
	 * </p>
	 */
	public void setColumnResize (Boolean  columnResize) {
		this.columnResize = columnResize;
		this.handleConfig("columnResize", columnResize);
	}
    	
	private Integer scrollOffset;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The amount of space to reserve for the
          scrollbar (defaults to 
          <tt>undefined</tt>). If an explicit value isn't
          specified, this will be automatically calculated.</div>

	 */
	
	public Integer getScrollOffset () {
		if (null != this.scrollOffset) {
			return this.scrollOffset;
		}
		ValueExpression _ve = getValueExpression("scrollOffset");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollOffset</code> property.
	 * </p>
	 */
	public void setScrollOffset (Integer  scrollOffset) {
		this.scrollOffset = scrollOffset;
		this.handleConfig("scrollOffset", scrollOffset);
	}
    	
	private Object internalTpl;
	
	/*
	 *
        
        
          internalTpl
         : String/Array
        The template to be used for the header
        row. See 
        tpl for
        more details.
	 */
	@ClientConfig(JsonMode.Array)

	public Object getInternalTpl () {
		if (null != this.internalTpl) {
			return this.internalTpl;
		}
		ValueExpression _ve = getValueExpression("internalTpl");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>internalTpl</code> property.
	 * </p>
	 */
	public void setInternalTpl (Object  internalTpl) {
		this.internalTpl = internalTpl;
		this.handleConfig("internalTpl", internalTpl);
	}
    	
	private Boolean hideHeaders;
	
	/*
	 *
        
        
          hideHeaders
         : Boolean
        
        true to hide the 
        header row (defaults to 
        false so the 
        header row will be
        shown).
	 */
	
	public Boolean getHideHeaders () {
		if (null != this.hideHeaders) {
			return this.hideHeaders;
		}
		ValueExpression _ve = getValueExpression("hideHeaders");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>hideHeaders</code> property.
	 * </p>
	 */
	public void setHideHeaders (Boolean  hideHeaders) {
		this.hideHeaders = hideHeaders;
		this.handleConfig("hideHeaders", hideHeaders);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[11];
		}
		_values[0] = super.saveState(_context);
				_values[1] = reserveScrollOffset;	
				_values[2] = overClass;	
				_values[3] = itemSelector;	
				_values[4] = columnSort;	
				_values[5] = columns;	
				_values[6] = selectedClass;	
				_values[7] = columnResize;	
				_values[8] = scrollOffset;	
				_values[9] = internalTpl;	
				_values[10] = hideHeaders;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.reserveScrollOffset = (Boolean) _values[1];
		this.handleConfig("reserveScrollOffset", this.reserveScrollOffset);
				this.overClass = (String) _values[2];
		this.handleConfig("overClass", this.overClass);
				this.itemSelector = (String) _values[3];
		this.handleConfig("itemSelector", this.itemSelector);
				this.columnSort = (Boolean) _values[4];
		this.handleConfig("columnSort", this.columnSort);
				this.columns = (Object) _values[5];
		this.handleConfig("columns", this.columns);
				this.selectedClass = (String) _values[6];
		this.handleConfig("selectedClass", this.selectedClass);
				this.columnResize = (Boolean) _values[7];
		this.handleConfig("columnResize", this.columnResize);
				this.scrollOffset = (Integer) _values[8];
		this.handleConfig("scrollOffset", this.scrollOffset);
				this.internalTpl = (Object) _values[9];
		this.handleConfig("internalTpl", this.internalTpl);
				this.hideHeaders = (Boolean) _values[10];
		this.handleConfig("hideHeaders", this.hideHeaders);
			}
}