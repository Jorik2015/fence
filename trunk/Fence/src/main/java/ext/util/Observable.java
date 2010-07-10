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
 * Base class that provides a common
  interface for publishing events. Subclasses are expected to to
  have a property "events" with all the events defined, and,
  optionally, a property "listeners" with configured listeners
  defined.
  For example: 

Employee = Ext.extend(Ext.util.Observable, {
    constructor: 
function(config){
        this.name = config.name;
        this.addEvents({
            
"fired" : true,
            
"quit" : true
        });

        
// Copy configured listeners into *this* object so that the base
class's
        
// constructor will add them.
        this.listeners = config.listeners;

        
// Call our superclass constructor to complete construction
process.
        Employee.superclass.constructor.call(config)
    }
});
  This could then be used like this:


var newEmployee = 
new Employee({
    name: employeeName,
    listeners: {
        quit: 
function() {
            
// By 
default, 
"this" will be the object that fired the event.
            alert(this.name + 
" has quit!");
        }
    }
});
  
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
	 *
            A config object containing one or more event
            handlers to be added to this object during
            initialization. This should be a valid listeners config
            object as specified in the 
            addListener example
            for attaching multiple handlers at once.
            
            
              
                DOM events from ExtJs 
                Components
              
            
            
            While 
            some ExtJs Component classes export selected DOM
            events (e.g. "click", "mouseover" etc), this is usually
            only done when extra value can be added. For example
            the 
            DataView's 
            
              
                click
              
             event passing the node clicked on. To access DOM
            events directly from a Component's HTMLElement,
            listeners must be added to the 
            
              Element
             after the Component has been rendered. A plugin
            can simplify this step:


// Plugin is configured 
with a listeners config object.
// The Component is appended to the argument list of all handler
functions.
Ext.DomObserver = Ext.extend(Object, {
    constructor: 
function(config) {
        this.listeners = config.listeners ? config.listeners :
config;
    },

    
// Component passes itself into plugin's init method
    init: 
function(c) {
        
var p, l = this.listeners;
        
for (p 
in l) {
            
if (Ext.isFunction(l[p])) {
                l[p] = this.createHandler(l[p], c);
            } 
else {
                l[p].fn = this.createHandler(l[p].fn, c);
            }
        }

        
// Add the listeners to the Element immediately following the
render call
        c.render = c.render.
createSequence(
function() {
            
var e = c.getEl();
            
if (e) {
                e.on(l);
            }
        });
    },

    createHandler: 
function(fn, c) {
        
return 
function(e) {
            fn.call(this, e, c);
        };
    }
});

var combo = 
new Ext.form.ComboBox({

    
// Collapse combo when its element is clicked on
    plugins: [ 
new Ext.DomObserver({
        click: 
function(evt, comp) {
            comp.collapse();
        }
    })],
    store: myStore,
    typeAhead: true,
    mode: 
'local',
    triggerAction: 
'all'
});
            
            
            
          
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