package ext.ux.menu;

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
 * This is a supporting class for 
  Ext.ux.grid.filter.ListFilter.
  Although not listed as configuration options for this class, this
  class also accepts all configuration options from 
  Ext.ux.grid.filter.ListFilter.
 */

@InstanceOf("Ext.ux.menu.ListMenu")
@ResourceDependency(library = "ext#{ext.version}/ux/filter", name = "DateFilter.js")
@FacesComponent(value = "Ext.ux.menu.ListMenu")
public class ListMenu extends Menu {
	public static final String COMPONENT_FAMILY = "Ext.ux.menu.ListMenu";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.menu.ListMenu} instance with default property values.
	 * </p>
	 */
	public ListMenu() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			labelField
			,paramPrefix
			,loadOnShow
			,single
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
        
        
          labelField
         : String
        Defaults to 'text'.
	 */
	
	public String getLabelField () {
		return (String) getStateHelper().eval(PropertyKeys.labelField);
	}

	/**
	 * <p>
	 * Set the value of the <code>labelField</code> property.
	 * </p>
	 */
	public void setLabelField ( String   labelField ) {
		getStateHelper().put(PropertyKeys.labelField, labelField);
		handleAttribute("labelField", labelField);
	}
    	/*
	 *
        
        
          paramPrefix
         : String
        Defaults to 'Loading...'.
	 */
	
	public String getParamPrefix () {
		return (String) getStateHelper().eval(PropertyKeys.paramPrefix);
	}

	/**
	 * <p>
	 * Set the value of the <code>paramPrefix</code> property.
	 * </p>
	 */
	public void setParamPrefix ( String   paramPrefix ) {
		getStateHelper().put(PropertyKeys.paramPrefix, paramPrefix);
		handleAttribute("paramPrefix", paramPrefix);
	}
    	/*
	 *
        
        
          loadOnShow
         : Boolean
        Defaults to true.
	 */
	
	public Boolean getLoadOnShow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.loadOnShow);
	}

	/**
	 * <p>
	 * Set the value of the <code>loadOnShow</code> property.
	 * </p>
	 */
	public void setLoadOnShow ( Boolean   loadOnShow ) {
		getStateHelper().put(PropertyKeys.loadOnShow, loadOnShow);
		handleAttribute("loadOnShow", loadOnShow);
	}
    	/*
	 *
        
        
          single
         : Boolean
        Specify true to group all items in this
        list into a single-select radio button group. Defaults to
        false.
	 */
	
	public Boolean getSingle () {
		return (Boolean) getStateHelper().eval(PropertyKeys.single);
	}

	/**
	 * <p>
	 * Set the value of the <code>single</code> property.
	 * </p>
	 */
	public void setSingle ( Boolean   single ) {
		getStateHelper().put(PropertyKeys.single, single);
		handleAttribute("single", single);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "checkchange"
				));
				return superEvent;
	}
}