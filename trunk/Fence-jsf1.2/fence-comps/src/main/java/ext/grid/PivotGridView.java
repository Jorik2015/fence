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
<div class="description">Specialised GridView for rendering Pivot
  Grid components. Config can be passed to the PivotGridView via
  the PivotGrid constructor's viewConfig option: 
<pre>
<code>
<b>new</b> Ext.grid.PivotGrid({
    viewConfig: {
        title: 
<em>'My Pivot Grid'</em>,
        getCellCls: 
<b>function</b>(value) {
            
<b>return</b> value &gt; 10 
<em>'red'</em> : 
<em>'green'</em>;
        }
    }
});</code>
  </pre>
  <p>Currently 
  <a ext:cls="Ext.grid.PivotGridView" ext:member="title" href="output/Ext.grid.PivotGridView.html#Ext.grid.PivotGridView-title">title</a>
  and 
  <a ext:cls="Ext.grid.PivotGridView" ext:member="getCellCls" href="output/Ext.grid.PivotGridView.html#Ext.grid.PivotGridView-getCellCls">getCellCls</a> are the only
  configuration options accepted by PivotGridView. All other
  interaction is performed via the 
  <a ext:cls="Ext.grid.PivotGrid" href="output/Ext.grid.PivotGrid.html">PivotGrid</a> class.</p>
</div>

 */

@InstanceOf("Ext.grid.PivotGridView")
@ParseConfigMode(ui = false, name = "view", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class PivotGridView extends GridView {
	public static final String COMPONENT_FAMILY = "Ext.grid.PivotGridView";

	/**
	 * <p>
	 * Create a new {@link Ext.grid.PivotGridView} instance with default property values.
	 * </p>
	 */
	public PivotGridView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			title
			,getCellCls
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
	
		
	private String title;
	
	/*
	 *
        
        
          title
         : String
        Optional title to be placed in the top
        left corner of the PivotGrid. Defaults to an empty
        string.
	 */
	
	public String getTitle () {
		if (null != this.title) {
			return this.title;
		}
		ValueExpression _ve = getValueExpression("title");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>title</code> property.
	 * </p>
	 */
	public void setTitle (String  title) {
		this.title = title;
		this.handleConfig("title", title);
	}
    	
	private Object getCellCls;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional function which should return a
          CSS class name for each cell value. This is useful when
          color coding cells based on their value. Defaults to
          undefined.</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getGetCellCls () {
		if (null != this.getCellCls) {
			return this.getCellCls;
		}
		ValueExpression _ve = getValueExpression("getCellCls");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>getCellCls</code> property.
	 * </p>
	 */
	public void setGetCellCls (Object  getCellCls) {
		this.getCellCls = getCellCls;
		this.handleConfig("getCellCls", getCellCls);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
				_values[1] = title;	
				_values[2] = getCellCls;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.title = (String) _values[1];
		this.handleConfig("title", this.title);
				this.getCellCls = (Object) _values[2];
		this.handleConfig("getCellCls", this.getCellCls);
			}
}