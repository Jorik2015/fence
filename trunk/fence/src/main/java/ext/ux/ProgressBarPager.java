package ext.ux;

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
 * Plugin (ptype = 'tabclosemenu') for
  displaying a progressbar inside of a paging toolbar instead of
  plain text
 */

@InstanceOf("Ext.ux.ProgressBarPager")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "ProgressBarPager.js")
@FacesComponent(value = "Ext.ux.ProgressBarPager")
public class ProgressBarPager extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.ux.ProgressBarPager";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.ProgressBarPager} instance with default property values.
	 * </p>
	 */
	public ProgressBarPager() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			defaultText
			,defaultAnimCfg
			,progBarWidth
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
        
        
          defaultText
         : String
        
          The text to display while the store is loading.
          Default is 'Loading...'
        
	 */
	
	public String getDefaultText () {
		return (String) getStateHelper().eval(PropertyKeys.defaultText);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultText</code> property.
	 * </p>
	 */
	public void setDefaultText ( String   defaultText ) {
		getStateHelper().put(PropertyKeys.defaultText, defaultText);
		handleAttribute("defaultText", defaultText);
	}
    	/*
	 *
        
        
          defaultAnimCfg
         : Object
        
          A 
          Ext.Fx
          configuration object. Default is { duration : 1, easing :
          'bounceOut' }.
        
	 */
	@ClientConfig(JsonMode.Object)

	public Object getDefaultAnimCfg () {
		return (Object) getStateHelper().eval(PropertyKeys.defaultAnimCfg);
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultAnimCfg</code> property.
	 * </p>
	 */
	public void setDefaultAnimCfg ( Object   defaultAnimCfg ) {
		getStateHelper().put(PropertyKeys.defaultAnimCfg, defaultAnimCfg);
		handleAttribute("defaultAnimCfg", defaultAnimCfg);
	}
    	/*
	 *
        
        
          progBarWidth
         : Integer
        
          The default progress bar width. Default is 225.
        
	 */
	
	public Integer getProgBarWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.progBarWidth);
	}

	/**
	 * <p>
	 * Set the value of the <code>progBarWidth</code> property.
	 * </p>
	 */
	public void setProgBarWidth ( Integer   progBarWidth ) {
		getStateHelper().put(PropertyKeys.progBarWidth, progBarWidth);
		handleAttribute("progBarWidth", progBarWidth);
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