package ext.list;

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
    <p>A Column definition class which renders boolean data fields.
    See the 
    <a ext:cls="Ext.list.Column" ext:member="xtype" href="output/Ext.list.Column.html#Ext.list.Column-xtype">xtype</a> config
    option of 
    <a ext:cls="Ext.list.Column" href="output/Ext.list.Column.html">Ext.list.Column</a> for more
    details.</p>
  </div>

 */

@InstanceOf("Ext.list.BooleanColumn")
@ParseConfigMode(ui = false,name="columns",pmode=PersistenceMode.ParentProperty,rmode=ReferenceMode.Var)
@FacesComponent(value = "Ext.list.BooleanColumn")
public class BooleanColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.list.BooleanColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.list.BooleanColumn} instance with default property values.
	 * </p>
	 */
	public BooleanColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			undefinedText
			,falseText
			,trueText
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
        
        
          undefinedText
         : String
        The string returned by the renderer when
        the column value is undefined (defaults to 
        ' ').
	 */
	
	public String getUndefinedText () {
		return (String) getStateHelper().eval(PropertyKeys.undefinedText);
	}

	/**
	 * <p>
	 * Set the value of the <code>undefinedText</code> property.
	 * </p>
	 */
	public void setUndefinedText ( String   undefinedText ) {
		getStateHelper().put(PropertyKeys.undefinedText, undefinedText);
		handleAttribute("undefinedText", undefinedText);
	}
    	/*
	 *
        
        
          falseText
         : String
        The string returned by the renderer when
        the column value is falsey (but not undefined) (defaults to
        
        'false').
	 */
	
	public String getFalseText () {
		return (String) getStateHelper().eval(PropertyKeys.falseText);
	}

	/**
	 * <p>
	 * Set the value of the <code>falseText</code> property.
	 * </p>
	 */
	public void setFalseText ( String   falseText ) {
		getStateHelper().put(PropertyKeys.falseText, falseText);
		handleAttribute("falseText", falseText);
	}
    	/*
	 *
        
        
          trueText
         : String
        The string returned by the renderer when
        the column value is not falsey (defaults to 
        'true').
	 */
	
	public String getTrueText () {
		return (String) getStateHelper().eval(PropertyKeys.trueText);
	}

	/**
	 * <p>
	 * Set the value of the <code>trueText</code> property.
	 * </p>
	 */
	public void setTrueText ( String   trueText ) {
		getStateHelper().put(PropertyKeys.trueText, trueText);
		handleAttribute("trueText", trueText);
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