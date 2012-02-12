package ext.list;

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
@ParseConfigMode(ui = false,name="view",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.list.ListView")
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
		return (Boolean) getStateHelper().eval(PropertyKeys.reserveScrollOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>reserveScrollOffset</code> property.
	 * </p>
	 */
	public void setReserveScrollOffset ( Boolean   reserveScrollOffset ) {
		getStateHelper().put(PropertyKeys.reserveScrollOffset, reserveScrollOffset);
		handleAttribute("reserveScrollOffset", reserveScrollOffset);
	}
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
		return (String) getStateHelper().eval(PropertyKeys.overClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>overClass</code> property.
	 * </p>
	 */
	public void setOverClass ( String   overClass ) {
		getStateHelper().put(PropertyKeys.overClass, overClass);
		handleAttribute("overClass", overClass);
	}
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
		return (String) getStateHelper().eval(PropertyKeys.itemSelector);
	}

	/**
	 * <p>
	 * Set the value of the <code>itemSelector</code> property.
	 * </p>
	 */
	public void setItemSelector ( String   itemSelector ) {
		getStateHelper().put(PropertyKeys.itemSelector, itemSelector);
		handleAttribute("itemSelector", itemSelector);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Specify 
          <tt>true</tt> or specify a configuration object for 
          <a ext:cls="Ext.list.ListView.Sorter" href="output/Ext.list.ListView.Sorter.html">Ext.list.ListView.Sorter</a>
          to enable the columns to be sortable (defaults to 
          <tt>true</tt>).</div>

	 */
	
	public Boolean getColumnSort () {
		return (Boolean) getStateHelper().eval(PropertyKeys.columnSort);
	}

	/**
	 * <p>
	 * Set the value of the <code>columnSort</code> property.
	 * </p>
	 */
	public void setColumnSort ( Boolean   columnSort ) {
		getStateHelper().put(PropertyKeys.columnSort, columnSort);
		handleAttribute("columnSort", columnSort);
	}
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
		return (Object) getStateHelper().eval(PropertyKeys.columns);
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns ( Object   columns ) {
		getStateHelper().put(PropertyKeys.columns, columns);
		handleAttribute("columns", columns);
	}
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
		return (String) getStateHelper().eval(PropertyKeys.selectedClass);
	}

	/**
	 * <p>
	 * Set the value of the <code>selectedClass</code> property.
	 * </p>
	 */
	public void setSelectedClass ( String   selectedClass ) {
		getStateHelper().put(PropertyKeys.selectedClass, selectedClass);
		handleAttribute("selectedClass", selectedClass);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Specify 
          <tt>true</tt> or specify a configuration object for 
          <a ext:cls="Ext.list.ListView.ColumnResizer" href="output/Ext.list.ListView.ColumnResizer.html">Ext.list.ListView.ColumnResizer</a>
          to enable the columns to be resizable (defaults to 
          <tt>true</tt>).</div>

	 */
	
	public Boolean getColumnResize () {
		return (Boolean) getStateHelper().eval(PropertyKeys.columnResize);
	}

	/**
	 * <p>
	 * Set the value of the <code>columnResize</code> property.
	 * </p>
	 */
	public void setColumnResize ( Boolean   columnResize ) {
		getStateHelper().put(PropertyKeys.columnResize, columnResize);
		handleAttribute("columnResize", columnResize);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The amount of space to reserve for the
          scrollbar (defaults to 
          <tt>undefined</tt>). If an explicit value isn't
          specified, this will be automatically calculated.</div>

	 */
	
	public Integer getScrollOffset () {
		return (Integer) getStateHelper().eval(PropertyKeys.scrollOffset);
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollOffset</code> property.
	 * </p>
	 */
	public void setScrollOffset ( Integer   scrollOffset ) {
		getStateHelper().put(PropertyKeys.scrollOffset, scrollOffset);
		handleAttribute("scrollOffset", scrollOffset);
	}
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
		return (Object) getStateHelper().eval(PropertyKeys.internalTpl);
	}

	/**
	 * <p>
	 * Set the value of the <code>internalTpl</code> property.
	 * </p>
	 */
	public void setInternalTpl ( Object   internalTpl ) {
		getStateHelper().put(PropertyKeys.internalTpl, internalTpl);
		handleAttribute("internalTpl", internalTpl);
	}
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
		return (Boolean) getStateHelper().eval(PropertyKeys.hideHeaders);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideHeaders</code> property.
	 * </p>
	 */
	public void setHideHeaders ( Boolean   hideHeaders ) {
		getStateHelper().put(PropertyKeys.hideHeaders, hideHeaders);
		handleAttribute("hideHeaders", hideHeaders);
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