package ext;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.base.ExtOutput;

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
@ParseConfigMode(ui = false)
public class Template extends ExtOutput {
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
	
		
	private Boolean disableFormats;
	
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
		if (null != this.disableFormats) {
			return this.disableFormats;
		}
		ValueExpression _ve = getValueExpression("disableFormats");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>disableFormats</code> property.
	 * </p>
	 */
	public void setDisableFormats (Boolean  disableFormats) {
		this.disableFormats = disableFormats;
		this.handleConfig("disableFormats", disableFormats);
	}
    	
	private Boolean compiled;
	
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
		if (null != this.compiled) {
			return this.compiled;
		}
		ValueExpression _ve = getValueExpression("compiled");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>compiled</code> property.
	 * </p>
	 */
	public void setCompiled (Boolean  compiled) {
		this.compiled = compiled;
		this.handleConfig("compiled", compiled);
	}
    	
	private String re;
	
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
		if (null != this.re) {
			return this.re;
		}
		ValueExpression _ve = getValueExpression("re");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>re</code> property.
	 * </p>
	 */
	public void setRe (String  re) {
		this.re = re;
		this.handleConfig("re", re);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
				_values[1] = disableFormats;	
				_values[2] = compiled;	
				_values[3] = re;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.disableFormats = (Boolean) _values[1];
		this.handleConfig("disableFormats", this.disableFormats);
				this.compiled = (Boolean) _values[2];
		this.handleConfig("compiled", this.compiled);
				this.re = (String) _values[3];
		this.handleConfig("re", this.re);
			}
}