package ext.data;

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
 * DataWriter extension for writing an
  array or single 
  Ext.data.Record object(s) in
  preparation for executing a remote CRUD action.
 */

@InstanceOf("Ext.data.JsonWriter")
@ParseConfigMode(ui = false,name="writer",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.JsonWriter")
public class JsonWriter extends DataWriter {
	public static final String COMPONENT_FAMILY = "Ext.data.JsonWriter";

	/**
	 * <p>
	 * Create a new {@link Ext.data.JsonWriter} instance with default property values.
	 * </p>
	 */
	public JsonWriter() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			encodeDelete
			,encode
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
	 *False to send only the id to the server
          on delete, true to encode it in an object literal, eg: 

{id: 1}
          Defaults to 
          false
	 */
	
	public Boolean getEncodeDelete () {
		return (Boolean) getStateHelper().eval(PropertyKeys.encodeDelete);
	}

	/**
	 * <p>
	 * Set the value of the <code>encodeDelete</code> property.
	 * </p>
	 */
	public void setEncodeDelete ( Boolean   encodeDelete ) {
		getStateHelper().put(PropertyKeys.encodeDelete, encodeDelete);
		handleAttribute("encodeDelete", encodeDelete);
	}
    	/*
	 *
          true to 
          encode
          the 
          hashed
          data. Defaults to 
          true. When using 
          Ext.data.DirectProxy,
          set this to 
          false since Ext.Direct.JsonProvider will perform
          its own json-encoding. In addition, if you're using 
          Ext.data.HttpProxy,
          setting to 
          false will cause HttpProxy to transmit data
          using the 
          jsonData configuration-params of 
          Ext.Ajax.request instead of 
          params. When using a 
          Ext.data.Store.restful
          Store, some serverside frameworks are tuned to expect
          data through the jsonData mechanism. In those cases, one
          will want to set 
          encode: 
          false, as in let the lower-level connection
          object (eg: Ext.Ajax) do the encoding.
	 */
	
	public Boolean getEncode () {
		return (Boolean) getStateHelper().eval(PropertyKeys.encode);
	}

	/**
	 * <p>
	 * Set the value of the <code>encode</code> property.
	 * </p>
	 */
	public void setEncode ( Boolean   encode ) {
		getStateHelper().put(PropertyKeys.encode, encode);
		handleAttribute("encode", encode);
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