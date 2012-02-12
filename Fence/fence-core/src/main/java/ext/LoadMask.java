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
<div class="description">A simple utility class for generically
  masking elements while loading data. If the 
  <a ext:cls="Ext.LoadMask" ext:member="store" href="output/Ext.LoadMask.html#Ext.LoadMask-store">store</a> config option
  is specified, the masking will be automatically synchronized with
  the store's loading process and the mask element will be cached
  for reuse. For all other elements, this mask will replace the
  element's Updater load indicator and will be destroyed after the
  initial load. 
  <p>Example usage:</p>
<pre>
<code>
<i>// Basic mask:</i>
<b>var</b> myMask = 
<b>new</b> Ext.LoadMask(Ext.getBody(), {msg:
<em>"Please wait..."</em>});
myMask.show();</code>
  </pre>
</div>

 */

@InstanceOf("Ext.LoadMask")

@FacesComponent(value = "Ext.LoadMask")
public class LoadMask extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.LoadMask";

	/**
	 * <p>
	 * Create a new {@link Ext.LoadMask} instance with default property values.
	 * </p>
	 */
	public LoadMask() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			msgCls
			,store
			,removeMask
			,msg
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
        
        
          msgCls
         : String
        The CSS class to apply to the loading
        message element (defaults to "x-mask-loading")
	 */
	
	public String getMsgCls () {
		return (String) getStateHelper().eval(PropertyKeys.msgCls);
	}

	/**
	 * <p>
	 * Set the value of the <code>msgCls</code> property.
	 * </p>
	 */
	public void setMsgCls ( String   msgCls ) {
		getStateHelper().put(PropertyKeys.msgCls, msgCls);
		handleAttribute("msgCls", msgCls);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">Optional Store to which the mask is
          bound. The mask is displayed when a load request is
          issued, and hidden on either load sucess, or load
          fail.</div>

	 */
	@ClientConfig(JsonMode.Object)

	public Object getStore () {
		return (Object) getStateHelper().eval(PropertyKeys.store);
	}

	/**
	 * <p>
	 * Set the value of the <code>store</code> property.
	 * </p>
	 */
	public void setStore ( Object   store ) {
		getStateHelper().put(PropertyKeys.store, store);
		handleAttribute("store", store);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to create a single-use mask that
          is automatically destroyed after loading (useful for page
          loads), False to persist the mask element reference for
          multiple uses (e.g., for paged data widgets). Defaults to
          false.</div>

	 */
	
	public Boolean getRemoveMask () {
		return (Boolean) getStateHelper().eval(PropertyKeys.removeMask);
	}

	/**
	 * <p>
	 * Set the value of the <code>removeMask</code> property.
	 * </p>
	 */
	public void setRemoveMask ( Boolean   removeMask ) {
		getStateHelper().put(PropertyKeys.removeMask, removeMask);
		handleAttribute("removeMask", removeMask);
	}
    	/*
	 *
        
        
          msg
         : String
        The text to display in a centered
        loading message box (defaults to 'Loading...')
	 */
	
	public String getMsg () {
		return (String) getStateHelper().eval(PropertyKeys.msg);
	}

	/**
	 * <p>
	 * Set the value of the <code>msg</code> property.
	 * </p>
	 */
	public void setMsg ( String   msg ) {
		getStateHelper().put(PropertyKeys.msg, msg);
		handleAttribute("msg", msg);
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