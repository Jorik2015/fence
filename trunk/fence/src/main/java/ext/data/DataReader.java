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
 * Abstract base class for reading
  structured data from a data source and converting it into an
  object containing 
  Ext.data.Record objects and
  metadata for use by an 
  Ext.data.Store. This class is
  intended to be extended and should not be created directly. For
  existing implementations, see 
  Ext.data.ArrayReader, 
  Ext.data.JsonReader and 
  Ext.data.XmlReader.
 */

@InstanceOf("Ext.data.DataReader")
@ParseConfigMode(id=false,ui = false,name="reader",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.data.DataReader")
public class DataReader extends ExtComponent {
	public static final String COMPONENT_FAMILY = "Ext.data.DataReader";

	/**
	 * <p>
	 * Create a new {@link Ext.data.DataReader} instance with default property values.
	 * </p>
	 */
	public DataReader() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			messageProperty
			,fields
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
        
        
          messageProperty
         : String
        [undefined] Optional name of a property
        within a server-response that represents a user-feedback
        message.
	 */
	
	public String getMessageProperty () {
		return (String) getStateHelper().eval(PropertyKeys.messageProperty);
	}

	/**
	 * <p>
	 * Set the value of the <code>messageProperty</code> property.
	 * </p>
	 */
	public void setMessageProperty ( String   messageProperty ) {
		getStateHelper().put(PropertyKeys.messageProperty, messageProperty);
		handleAttribute("messageProperty", messageProperty);
	}
    	/*
	 *
            Either an Array of 
            Field definition objects
            (which will be passed to 
            Ext.data.Record.create,
            or a 
            Record constructor
            created from 
            Ext.data.Record.create.
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getFields () {
		return (Object) getStateHelper().eval(PropertyKeys.fields);
	}

	/**
	 * <p>
	 * Set the value of the <code>fields</code> property.
	 * </p>
	 */
	public void setFields ( Object   fields ) {
		getStateHelper().put(PropertyKeys.fields, fields);
		handleAttribute("fields", fields);
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