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
@ParseConfigMode(ui = false,name="view",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.grid.PivotGridView")
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
	
		/*
	 *
        
        
          title
         : String
        Optional title to be placed in the top
        left corner of the PivotGrid. Defaults to an empty
        string.
	 */
	
	public String getTitle () {
		return (String) getStateHelper().eval(PropertyKeys.title);
	}

	/**
	 * <p>
	 * Set the value of the <code>title</code> property.
	 * </p>
	 */
	public void setTitle ( String   title ) {
		getStateHelper().put(PropertyKeys.title, title);
		handleAttribute("title", title);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional function which should return a
          CSS class name for each cell value. This is useful when
          color coding cells based on their value. Defaults to
          undefined.</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getGetCellCls () {
		return (Object) getStateHelper().eval(PropertyKeys.getCellCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>getCellCls</code> property.
	 * </p>
	 */
	public void setGetCellCls ( Object   getCellCls ) {
		getStateHelper().put(PropertyKeys.getCellCls, getCellCls);
		handleAttribute("getCellCls", getCellCls);
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