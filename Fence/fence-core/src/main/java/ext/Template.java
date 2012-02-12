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
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>Represents an HTML fragment template. Templates may be 
    <a ext:cls="Ext.Template" ext:member="compile" href="output/Ext.Template.html#Ext.Template-compile">precompiled</a> for
    greater performance.</p>
    <p>For example usage 
    <a ext:cls="Ext.Template" ext:member="Template" href="output/Ext.Template.html#Ext.Template-Template">see the
    constructor</a>.</p>
  </div>

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
			disableFormats
			,compiled
			,re
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
<div class="long">Specify 
          <tt>true</tt> to disable format functions in the
          template. If the template does not contain 
          <a ext:cls="Ext.util.Format" href="output/Ext.util.Format.html">format functions</a>, setting 
          <code>disableFormats</code> to true will reduce 
          <code>
            <a ext:cls="Ext.Template" ext:member="apply" href="output/Ext.Template.html#Ext.Template-apply">apply</a>
          </code> time. Defaults to 
          <tt>false</tt>. 
<pre>
<code>
<b>var</b> t = 
<b>new</b> Ext.Template(
    
<em>'&lt;div name=</em>"{id}"</code>&gt;',
        
<em>'&lt;span class=</em>"{cls}"&gt;{name} {value}&lt;/span&gt;',
    
<em>'&lt;/div&gt;'</em>,
    {
        compiled: true,      
<i>// 
<a ext:cls="Ext.Template" ext:member="compile" href="output/Ext.Template.html#Ext.Template-compile">compile</a>
immediately</i>
        disableFormats: true 
<i>// reduce 
<code>
  <a ext:cls="Ext.Template" ext:member="apply" href="output/Ext.Template.html#Ext.Template-apply">apply</a>
</code>
</i> time since no formatting
    }
);
          </pre>For a list of available format functions, see 
          <a ext:cls="Ext.util.Format" href="output/Ext.util.Format.html">Ext.util.Format</a>.</div>

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
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">The regular expression used to match
          template variables. Defaults to:
<pre>
<code>re : /\{([\w\-]+)\}/g                                     
<i>// 
<b>for</b> Ext Core</i>
re : /\{([\w\-]+)(?:\:([\w\.]*)(?:\((.*?)?\))?)?\}/g      
<i>// 
<b>for</b> Ext JS</i>
</code>
          </pre>
</div>

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