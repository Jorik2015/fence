package ext;

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
import java.util.Date;

/**
 * 
    Represents an HTML fragment template. Templates may be 
    precompiled for
    greater performance.
    For example usage 
    see the
    constructor.
  
 */

@InstanceOf("Ext.Template")

@FacesComponent(value = "Ext.Template")
public class Template extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.Template";

	/**
	 * <p>
	 * Create a new {@link Ext.Template} instance with default property values.
	 * </p>
	 */
	public Template() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			re
			,compiled
			,disableFormats
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
	 *The regular expression used to match
          template variables. Defaults to:

re : /\{([\w-]+)\}/g                                     
// 
for Ext Core
re : /\{([\w-]+)(?:\:([\w\.]*)(?:\((.*?)?\))?)?\}/g      
// 
for Ext JS
          
	 */
	@ClientConfig(JsonMode.Object)

	public String getRe () {
		return (String) getStateHelper().eval(PropertyKeys.re);
	}

	/**
	 * <p>
	 * Set the value of the <code>re</code> property.
	 * </p>
	 */
	public void setRe ( String   re ) {
		getStateHelper().put(PropertyKeys.re, re);
		handleAttribute("re", re);
	}
    	/*
	 *
        
        
          compiled
         : Boolean
        Specify 
        true to compile the template immediately (see 
        
          compile
        ). Defaults to 
        false.
	 */
	
	public Boolean getCompiled () {
		return (Boolean) getStateHelper().eval(PropertyKeys.compiled);
	}

	/**
	 * <p>
	 * Set the value of the <code>compiled</code> property.
	 * </p>
	 */
	public void setCompiled ( Boolean   compiled ) {
		getStateHelper().put(PropertyKeys.compiled, compiled);
		handleAttribute("compiled", compiled);
	}
    	/*
	 *Specify 
          true to disable format functions in the
          template. If the template does not contain 
          format functions, setting 
          disableFormats to true will reduce 
          
            apply
           time. Defaults to 
          false. 


var t = 
new Ext.Template(
    
'<div name="{id}">',
        
'<span class="{cls}">{name} {value}</span>',
    
'</div>',
    {
        compiled: true,      
// 
compile immediately

        disableFormats: true 
// reduce 

  apply
 time since no formatting
    }    
);
          For a list of available format functions, see 
          Ext.util.Format.
	 */
	
	public Boolean getDisableFormats () {
		return (Boolean) getStateHelper().eval(PropertyKeys.disableFormats);
	}

	/**
	 * <p>
	 * Set the value of the <code>disableFormats</code> property.
	 * </p>
	 */
	public void setDisableFormats ( Boolean   disableFormats ) {
		getStateHelper().put(PropertyKeys.disableFormats, disableFormats);
		handleAttribute("disableFormats", disableFormats);
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