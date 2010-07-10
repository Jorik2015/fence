package ext.form;

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
 * 
    A grouping container for 
    Ext.form.Checkbox controls.
    Sample usage:


var myCheckboxGroup = 
new Ext.form.CheckboxGroup({
    id:
'myGroup',
    xtype: 
'checkboxgroup',
    fieldLabel: 
'Single Column',
    itemCls: 
'x-check-group-alt',
    
// Put all controls 
in a single column 
with width 100%
    columns: 1,
    items: [
        {boxLabel: 
'Item 1', name: 
'cb-col-1'},
        {boxLabel: 
'Item 2', name: 
'cb-col-2', checked: true},
        {boxLabel: 
'Item 3', name: 
'cb-col-3'}
    ]
});
    
  
 */
@XType("checkboxgroup")
@InstanceOf("Ext.form.CheckboxGroup")

@FacesComponent(value = "Ext.form.CheckboxGroup")
public class CheckboxGroup extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.CheckboxGroup";

	/**
	 * <p>
	 * Create a new {@link Ext.form.CheckboxGroup} instance with default property values.
	 * </p>
	 */
	public CheckboxGroup() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			allowBlank
			,items
			,blankText
			,columns
			,vertical
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
	 *False to validate that at least one
          item in the group is checked (defaults to true). If no
          items are selected at validation time, {@link
	 */
	
	public Boolean getAllowBlank () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowBlank);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowBlank</code> property.
	 * </p>
	 */
	public void setAllowBlank ( Boolean   allowBlank ) {
		getStateHelper().put(PropertyKeys.allowBlank, allowBlank);
		handleAttribute("allowBlank", allowBlank);
	}
    	/*
	 *
        
        
          items
         : Array
        An Array of 
        Checkboxes or Checkbox
        config objects to arrange in the group.
	 */
	@ClientConfig(JsonMode.Array)

	public Object getItems () {
		return (Object) getStateHelper().eval(PropertyKeys.items);
	}

	/**
	 * <p>
	 * Set the value of the <code>items</code> property.
	 * </p>
	 */
	public void setItems ( Object   items ) {
		getStateHelper().put(PropertyKeys.items, items);
		handleAttribute("items", items);
	}
    	/*
	 *Error text to display if the 
          allowBlank
          validation fails (defaults to "You must select at least
          one item in this group")
	 */
	
	public String getBlankText () {
		return (String) getStateHelper().eval(PropertyKeys.blankText);
	}

	/**
	 * <p>
	 * Set the value of the <code>blankText</code> property.
	 * </p>
	 */
	public void setBlankText ( String   blankText ) {
		getStateHelper().put(PropertyKeys.blankText, blankText);
		handleAttribute("blankText", blankText);
	}
    	/*
	 *Specifies the number of columns to use
          when displaying grouped checkbox/radio controls using
          automatic layout. This config can take several types of
          values: 
          
            
            'auto' : 
            The controls will be rendered one
            per column on one row and the width of each column will
            be evenly distributed based on the width of the overall
            field container. This is the default.
            
            Number : 
            If you specific a number (e.g., 3)
            that number of columns will be created and the
            contained controls will be automatically distributed
            based on the value of 
            vertical.
            
            Array : Object
            You can also specify an array of
            column widths, mixing integer (fixed width) and float
            (percentage width) values as needed (e.g., [100, .25,
            .75]). Any integer values will be rendered first, then
            any float values will be calculated as a percentage of
            the remaining space. Float values do not have to add up
            to 1 (100%) although if you want the controls to take
            up the entire field container you should do
            so.
          
	 */
	@ClientConfig(JsonMode.Array)

	public Object getColumns () {
		return (Object) getStateHelper().eval(PropertyKeys.columns);
	}

	/**
	 * <p>
	 * Set the value of the <code>columns</code> property.
	 * </p>
	 */
	public void setColumns ( Object   columns ) {
		getStateHelper().put(PropertyKeys.columns, columns);
		handleAttribute("columns", columns);
	}
    	/*
	 *True to distribute contained controls
          across columns, completely filling each column top to
          bottom before starting on the next column. The number of
          controls in each column will be automatically calculated
          to keep columns as even as possible. The default value is
          false, so that controls will be added to columns one at a
          time, completely filling each row left to right before
          starting on the next row.
	 */
	
	public Boolean getVertical () {
		return (Boolean) getStateHelper().eval(PropertyKeys.vertical);
	}

	/**
	 * <p>
	 * Set the value of the <code>vertical</code> property.
	 * </p>
	 */
	public void setVertical ( Boolean   vertical ) {
		getStateHelper().put(PropertyKeys.vertical, vertical);
		handleAttribute("vertical", vertical);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "change"
				));
				return superEvent;
	}
}