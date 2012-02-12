package ext.direct;

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
    <p>Ext.direct.Provider is an abstract class meant to be
    extended.</p>
    <p>For example ExtJs implements the following subclasses:</p>
<pre>
<code>Provider
|
+---
<a ext:cls="Ext.direct.JsonProvider" href="output/Ext.direct.JsonProvider.html">JsonProvider</a> 
    |
    +---
<a ext:cls="Ext.direct.PollingProvider" href="output/Ext.direct.PollingProvider.html">PollingProvider</a>   
    |
    +---
<a ext:cls="Ext.direct.RemotingProvider" href="output/Ext.direct.RemotingProvider.html">RemotingProvider</a>
</code>
    </pre>
  </div>

 */

@InstanceOf("Ext.direct.Provider")

@FacesComponent(value = "Ext.direct.Provider")
public class Provider extends ext.util.Observable {
	public static final String COMPONENT_FAMILY = "Ext.direct.Provider";

	/**
	 * <p>
	 * Create a new {@link Ext.direct.Provider} instance with default property values.
	 * </p>
	 */
	public Provider() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			priority
			,type
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
<div class="long">Priority of the request. Lower is
          higher priority, 
          <tt>0</tt> means "duplex" (always on). All Providers
          default to 
          <tt>1</tt> except for PollingProvider which defaults to 
          <tt>3</tt>.</div>

	 */
	
	public Integer getPriority () {
		return (Integer) getStateHelper().eval(PropertyKeys.priority);
	}

	/**
	 * <p>
	 * Set the value of the <code>priority</code> property.
	 * </p>
	 */
	public void setPriority ( Integer   priority ) {
		getStateHelper().put(PropertyKeys.priority, priority);
		handleAttribute("priority", priority);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">
          <b>Required</b>, 
          <tt>undefined</tt> by default. The 
          <tt>type</tt> of provider specified to 
          <a ext:cls="Ext.Direct" href="output/Ext.Direct.html">Ext.Direct</a>.
          <a ext:cls="Ext.Direct" ext:member="addProvider" href="output/Ext.Direct.html#Ext.Direct-addProvider">addProvider</a> to create a new
          Provider. Acceptable values by default are:
          <div class="mdetail-params">
            <ul>
              <li>
              <b>
                <tt>polling</tt>
              </b> : 
              <a ext:cls="Ext.direct.PollingProvider" href="output/Ext.direct.PollingProvider.html">PollingProvider</a>
</li>
              <li>
              <b>
                <tt>remoting</tt>
              </b> : 
              <a ext:cls="Ext.direct.RemotingProvider" href="output/Ext.direct.RemotingProvider.html">RemotingProvider</a>
</li>
            </ul>
          </div>
</div>

	 */
	
	public String getType () {
		return (String) getStateHelper().eval(PropertyKeys.type);
	}

	/**
	 * <p>
	 * Set the value of the <code>type</code> property.
	 * </p>
	 */
	public void setType ( String   type ) {
		getStateHelper().put(PropertyKeys.type, type);
		handleAttribute("type", type);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "connect"
					, "data"
					, "disconnect"
					, "exception"
				));
				return superEvent;
	}
}