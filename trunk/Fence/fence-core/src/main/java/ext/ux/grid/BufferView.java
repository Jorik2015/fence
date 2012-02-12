package ext.ux.grid;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
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
 * A custom GridView which renders rows on
  an as-needed basis.
 */

@InstanceOf("Ext.ux.grid.BufferView")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "BufferView.js")
@ParseConfigMode(ui = false,name="view",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.ux.grid.BufferView")
public class BufferView extends GridView {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.BufferView";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.grid.BufferView} instance with default property values.
	 * </p>
	 */
	public BufferView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			cleanDelay
			,borderHeight
			,rowHeight
			,cacheSize
			,scrollDelay
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
        
        
          cleanDelay
         : Number
        The number of milliseconds to buffer
        cleaning of extra rows not in the cache.
	 */
	
	public Integer getCleanDelay () {
		return (Integer) getStateHelper().eval(PropertyKeys.cleanDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>cleanDelay</code> property.
	 * </p>
	 */
	public void setCleanDelay ( Integer   cleanDelay ) {
		getStateHelper().put(PropertyKeys.cleanDelay, cleanDelay);
		handleAttribute("cleanDelay", cleanDelay);
	}
    	/*
	 *
        
        
          borderHeight
         : Number
        The combined height of border-top and
        border-bottom of a row.
	 */
	
	public Integer getBorderHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.borderHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>borderHeight</code> property.
	 * </p>
	 */
	public void setBorderHeight ( Integer   borderHeight ) {
		getStateHelper().put(PropertyKeys.borderHeight, borderHeight);
		handleAttribute("borderHeight", borderHeight);
	}
    	/*
	 *
        
        
          rowHeight
         : Number
        The height of a row in the
        grid.
	 */
	
	public Integer getRowHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.rowHeight);
	}

	/**
	 * <p>
	 * Set the value of the <code>rowHeight</code> property.
	 * </p>
	 */
	public void setRowHeight ( Integer   rowHeight ) {
		getStateHelper().put(PropertyKeys.rowHeight, rowHeight);
		handleAttribute("rowHeight", rowHeight);
	}
    	/*
	 *The number of rows to look forward and
          backwards from the currently viewable area. The cache
          applies only to rows that have been rendered
          already.
	 */
	
	public Integer getCacheSize () {
		return (Integer) getStateHelper().eval(PropertyKeys.cacheSize);
	}

	/**
	 * <p>
	 * Set the value of the <code>cacheSize</code> property.
	 * </p>
	 */
	public void setCacheSize ( Integer   cacheSize ) {
		getStateHelper().put(PropertyKeys.cacheSize, cacheSize);
		handleAttribute("cacheSize", cacheSize);
	}
    	/*
	 *The number of milliseconds before
          rendering rows out of the visible viewing area. Defaults
          to 100. Rows will render immediately with a config of
          false.
	 */
	
	public Boolean getScrollDelay () {
		return (Boolean) getStateHelper().eval(PropertyKeys.scrollDelay);
	}

	/**
	 * <p>
	 * Set the value of the <code>scrollDelay</code> property.
	 * </p>
	 */
	public void setScrollDelay ( Boolean   scrollDelay ) {
		getStateHelper().put(PropertyKeys.scrollDelay, scrollDelay);
		handleAttribute("scrollDelay", scrollDelay);
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