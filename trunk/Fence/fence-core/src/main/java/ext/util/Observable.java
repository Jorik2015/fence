package ext.util;

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
<div class="description">Base class that provides a common
  interface for publishing events. Subclasses are expected to to
  have a property "events" with all the events defined, and,
  optionally, a property "listeners" with configured listeners
  defined.
  <br/>For example: 
<pre>
<code>Employee = Ext.extend(Ext.util.Observable, {
    constructor: 
<b>function</b>(config){
        this.name = config.name;
        this.addEvents({
            
<em>"fired"</em> : true,
            
<em>"quit"</em> : true
        });

        
<i>// Copy configured listeners into *this* object so that the base
class's</i>
        
<i>// constructor will add them.</i>
        this.listeners = config.listeners;

        
<i>// Call our superclass constructor to complete construction
process.</i>
        Employee.superclass.constructor.call(this, config)
    }
});</code>
  </pre>This could then be used like this:
<pre>
<code>
<b>var</b> newEmployee = 
<b>new</b> Employee({
    name: employeeName,
    listeners: {
        quit: 
<b>function</b>() {
            
<i>// By 
<b>default</b>, 
<em>"this"</em> will be the object that fired the event.</i>
            alert(this.name + 
<em>" has quit!"</em>);
        }
    }
});</code>
  </pre>
</div>

 */

@InstanceOf("Ext.util.Observable")

@FacesComponent(value = "Ext.util.Observable")
public class Observable extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.util.Observable";

	/**
	 * <p>
	 * Create a new {@link Ext.util.Observable} instance with default property values.
	 * </p>
	 */
	public Observable() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			listeners
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
<div class="long">
            <p>A config object containing one or more event
            handlers to be added to this object during
            initialization. This should be a valid listeners config
            object as specified in the 
            <a ext:cls="Ext.util.Observable" ext:member="addListener" href="output/Ext.util.Observable.html#Ext.util.Observable-addListener">addListener</a> example
            for attaching multiple handlers at once.</p>
            <br/>
            <p>
              <b>
                <u>DOM events from ExtJs 
                <a ext:cls="Ext.Component" href="output/Ext.Component.html">Components</a>
</u>
              </b>
            </p>
            <br/>
            <p>While 
            <i>some</i> ExtJs Component classes export selected DOM
            events (e.g. "click", "mouseover" etc), this is usually
            only done when extra value can be added. For example
            the 
            <a ext:cls="Ext.DataView" href="output/Ext.DataView.html">DataView</a>'s 
            <b>
              <code>
                <a ext:cls="Ext.DataView" ext:member="click" href="output/Ext.DataView.html#Ext.DataView-click">click</a>
              </code>
            </b> event passing the node clicked on. To access DOM
            events directly from a Component's HTMLElement,
            listeners must be added to the 
            <i>
              <a ext:cls="Ext.Component" ext:member="getEl" href="output/Ext.Component.html#Ext.Component-getEl">Element</a>
            </i> after the Component has been rendered. A plugin
            can simplify this step:</p>
<pre>
<code>
<i>// Plugin is configured 
<b>with</b> a listeners config object.</i>
<i>// The Component is appended to the argument list of all handler
functions.</i>
Ext.DomObserver = Ext.extend(Object, {
    constructor: 
<b>function</b>(config) {
        this.listeners = config.listeners ? config.listeners :
config;
    },

    
<i>// Component passes itself into plugin's init method</i>
    init: 
<b>function</b>(c) {
        
<b>var</b> p, l = this.listeners;
        
<b>for</b> (p 
<b>in</b> l) {
            
<b>if</b> (Ext.isFunction(l[p])) {
                l[p] = this.createHandler(l[p], c);
            } 
<b>else</b> {
                l[p].fn = this.createHandler(l[p].fn, c);
            }
        }

        
<i>// Add the listeners to the Element immediately following the
render call</i>
        c.render = c.render.
<a ext:cls="Function" ext:member="createSequence" href="output/Function.html#Function-createSequence">createSequence</a>(
<b>function</b>() {
            
<b>var</b> e = c.getEl();
            
<b>if</b> (e) {
                e.on(l);
            }
        });
    },

    createHandler: 
<b>function</b>(fn, c) {
        
<b>return</b> 
<b>function</b>(e) {
            fn.call(this, e, c);
        };
    }
});

<b>var</b> combo = 
<b>new</b> Ext.form.ComboBox({

    
<i>// Collapse combo when its element is clicked on</i>
    plugins: [ 
<b>new</b> Ext.DomObserver({
        click: 
<b>function</b>(evt, comp) {
            comp.collapse();
        }
    })],
    store: myStore,
    typeAhead: true,
    mode: 
<em>'local'</em>,
    triggerAction: 
<em>'all'</em>
});</code>
            </pre>
            <br/>
            <br/>
          </div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getListeners () {
		return (Object) getStateHelper().eval(PropertyKeys.listeners);
	}

	/**
	 * <p>
	 * Set the value of the <code>listeners</code> property.
	 * </p>
	 */
	public void setListeners ( Object   listeners ) {
		getStateHelper().put(PropertyKeys.listeners, listeners);
		handleAttribute("listeners", listeners);
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