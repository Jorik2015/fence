package ext.ux.form;

import javax.el.ValueExpression;
import com.abner.fence.annotation.*;
import com.abner.fence.commons.Enums.*;
import com.abner.fence.component.*;

import javax.faces.application.ResourceDependency;
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
 * A control that allows selection and form
  submission of multiple list items.
 */

@InstanceOf("Ext.ux.form.MultiSelect")
@ResourceDependency(library = "ext#{ext.version}/ux", name = "MultiSelect.js")
@FacesComponent(value = "Ext.ux.form.MultiSelect")
public class MultiSelect extends ext.form.Field {
	public static final String COMPONENT_FAMILY = "Ext.ux.form.MultiSelect";

	/**
	 * <p>
	 * Create a new {@link ExtUtils.ux.form.MultiSelect} instance with default property values.
	 * </p>
	 */
	public MultiSelect() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			view
			,delimiter
			,width
			,minSelectionsText
			,appendOnly
			,allowBlank
			,maxSelectionsText
			,dropGroup
			,dragGroup
			,minSelections
			,valueField
			,tbar
			,displayField
			,legend
			,store
			,height
			,maxSelections
			,blankText
			,ddReorder
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
        
        
          view
         : Ext.ListView
        The 
        Ext.ListView used to render the
        multiselect list.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getView () {
		return (Object) getStateHelper().eval(PropertyKeys.view);
	}

	/**
	 * <p>
	 * Set the value of the <code>view</code> property.
	 * </p>
	 */
	public void setView ( Object   view ) {
		getStateHelper().put(PropertyKeys.view, view);
		handleAttribute("view", view);
	}
    	/*
	 *
        
        
          delimiter
         : String
        The string used to delimit between items
        when set or returned as a string of values (defaults to
        ',').
	 */
	
	public String getDelimiter () {
		return (String) getStateHelper().eval(PropertyKeys.delimiter);
	}

	/**
	 * <p>
	 * Set the value of the <code>delimiter</code> property.
	 * </p>
	 */
	public void setDelimiter ( String   delimiter ) {
		getStateHelper().put(PropertyKeys.delimiter, delimiter);
		handleAttribute("delimiter", delimiter);
	}
    	/*
	 *
        
        
          width
         : Number
        Width in pixels of the control (defaults
        to 100).
	 */
	
	public Integer getWidth () {
		return (Integer) getStateHelper().eval(PropertyKeys.width);
	}

	/**
	 * <p>
	 * Set the value of the <code>width</code> property.
	 * </p>
	 */
	public void setWidth ( Integer   width ) {
		getStateHelper().put(PropertyKeys.width, width);
		handleAttribute("width", width);
	}
    	/*
	 *Validation message displayed when 
          minSelections is
          not met (defaults to 'Minimum {0} item(s) required'). The
          {0} token will be replaced by the value of 
          minSelections.
	 */
	
	public String getMinSelectionsText () {
		return (String) getStateHelper().eval(PropertyKeys.minSelectionsText);
	}

	/**
	 * <p>
	 * Set the value of the <code>minSelectionsText</code> property.
	 * </p>
	 */
	public void setMinSelectionsText ( String   minSelectionsText ) {
		getStateHelper().put(PropertyKeys.minSelectionsText, minSelectionsText);
		handleAttribute("minSelectionsText", minSelectionsText);
	}
    	/*
	 *True if the list should only allow
          append drops when drag/drop is enabled (use for lists
          which are sorted, defaults to false).
	 */
	
	public String getAppendOnly () {
		return (String) getStateHelper().eval(PropertyKeys.appendOnly);
	}

	/**
	 * <p>
	 * Set the value of the <code>appendOnly</code> property.
	 * </p>
	 */
	public void setAppendOnly ( String   appendOnly ) {
		getStateHelper().put(PropertyKeys.appendOnly, appendOnly);
		handleAttribute("appendOnly", appendOnly);
	}
    	/*
	 *
        
        
          allowBlank
         : Boolean
        False to require at least one item in
        the list to be selected, true to allow no selection
        (defaults to true).
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
	 *Validation message displayed when 
          maxSelections is
          not met (defaults to 'Maximum {0} item(s) allowed'). The
          {0} token will be replaced by the value of 
          maxSelections.
	 */
	
	public String getMaxSelectionsText () {
		return (String) getStateHelper().eval(PropertyKeys.maxSelectionsText);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxSelectionsText</code> property.
	 * </p>
	 */
	public void setMaxSelectionsText ( String   maxSelectionsText ) {
		getStateHelper().put(PropertyKeys.maxSelectionsText, maxSelectionsText);
		handleAttribute("maxSelectionsText", maxSelectionsText);
	}
    	/*
	 *
        
        
          dropGroup
         : String/Array
        The ddgroup name(s) for the MultiSelect
        DropZone (defaults to undefined).
	 */
	@ClientConfig(JsonMode.Array)

	public Object getDropGroup () {
		return (Object) getStateHelper().eval(PropertyKeys.dropGroup);
	}

	/**
	 * <p>
	 * Set the value of the <code>dropGroup</code> property.
	 * </p>
	 */
	public void setDropGroup ( Object   dropGroup ) {
		getStateHelper().put(PropertyKeys.dropGroup, dropGroup);
		handleAttribute("dropGroup", dropGroup);
	}
    	/*
	 *
        
        
          dragGroup
         : String/Array
        The ddgroup name(s) for the MultiSelect
        DragZone (defaults to undefined).
	 */
	@ClientConfig(JsonMode.Array)

	public Object getDragGroup () {
		return (Object) getStateHelper().eval(PropertyKeys.dragGroup);
	}

	/**
	 * <p>
	 * Set the value of the <code>dragGroup</code> property.
	 * </p>
	 */
	public void setDragGroup ( Object   dragGroup ) {
		getStateHelper().put(PropertyKeys.dragGroup, dragGroup);
		handleAttribute("dragGroup", dragGroup);
	}
    	/*
	 *
        
        
          minSelections
         : Number
        Minimum number of selections allowed
        (defaults to 0).
	 */
	
	public Integer getMinSelections () {
		return (Integer) getStateHelper().eval(PropertyKeys.minSelections);
	}

	/**
	 * <p>
	 * Set the value of the <code>minSelections</code> property.
	 * </p>
	 */
	public void setMinSelections ( Integer   minSelections ) {
		getStateHelper().put(PropertyKeys.minSelections, minSelections);
		handleAttribute("minSelections", minSelections);
	}
    	/*
	 *
        
        
          valueField
         : String/Number
        Name/Index of the desired value field in
        the dataset (defaults to 1).
	 */
	
	public String getValueField () {
		return (String) getStateHelper().eval(PropertyKeys.valueField);
	}

	/**
	 * <p>
	 * Set the value of the <code>valueField</code> property.
	 * </p>
	 */
	public void setValueField ( String   valueField ) {
		getStateHelper().put(PropertyKeys.valueField, valueField);
		handleAttribute("valueField", valueField);
	}
    	/*
	 *The top toolbar of the control. This
          can be a 
          Ext.Toolbar object, a toolbar
          config, or an array of buttons/button configs to be added
          to the toolbar.
	 */
	@ClientConfig(JsonMode.Object)

	public Object getTbar () {
		return (Object) getStateHelper().eval(PropertyKeys.tbar);
	}

	/**
	 * <p>
	 * Set the value of the <code>tbar</code> property.
	 * </p>
	 */
	public void setTbar ( Object   tbar ) {
		getStateHelper().put(PropertyKeys.tbar, tbar);
		handleAttribute("tbar", tbar);
	}
    	/*
	 *
        
        
          displayField
         : String/Number
        Name/Index of the desired display field
        in the dataset (defaults to 0).
	 */
	
	public String getDisplayField () {
		return (String) getStateHelper().eval(PropertyKeys.displayField);
	}

	/**
	 * <p>
	 * Set the value of the <code>displayField</code> property.
	 * </p>
	 */
	public void setDisplayField ( String   displayField ) {
		getStateHelper().put(PropertyKeys.displayField, displayField);
		handleAttribute("displayField", displayField);
	}
    	/*
	 *
        
        
          legend
         : String
        Wraps the object with a fieldset and
        specified legend.
	 */
	
	public String getLegend () {
		return (String) getStateHelper().eval(PropertyKeys.legend);
	}

	/**
	 * <p>
	 * Set the value of the <code>legend</code> property.
	 * </p>
	 */
	public void setLegend ( String   legend ) {
		getStateHelper().put(PropertyKeys.legend, legend);
		handleAttribute("legend", legend);
	}
    	/*
	 *The data source to which this
          MultiSelect is bound (defaults to 
          undefined). Acceptable values for this property
          are: 
          
            
              
                any 
                Store subclass
              
              
              an Array : Arrays will be converted to a 
              Ext.data.ArrayStore
              internally. 
              
                
                  
                  1-dimensional array : (e.g., 
                  ['Foo','Bar'])
                  A 1-dimensional array will
                  automatically be expanded (each array item will
                  be the combo 
                  value and 
                  text)
                  
                  2-dimensional array : (e.g., 
                  [['f','Foo'],['b','Bar']])
                  For a multi-dimensional
                  array, the value in index 0 of each item will be
                  assumed to be the combo 
                  value,
                  while the value at index 1 is assumed to be the
                  combo 
                  text.
                
              
            
          
	 */
	@ClientConfig(JsonMode.Array)

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
	 *
        
        
          height
         : Number
        Height in pixels of the control
        (defaults to 100).
	 */
	
	public Integer getHeight () {
		return (Integer) getStateHelper().eval(PropertyKeys.height);
	}

	/**
	 * <p>
	 * Set the value of the <code>height</code> property.
	 * </p>
	 */
	public void setHeight ( Integer   height ) {
		getStateHelper().put(PropertyKeys.height, height);
		handleAttribute("height", height);
	}
    	/*
	 *
        
        
          maxSelections
         : Number
        Maximum number of selections allowed
        (defaults to Number.MAX_VALUE).
	 */
	
	public Integer getMaxSelections () {
		return (Integer) getStateHelper().eval(PropertyKeys.maxSelections);
	}

	/**
	 * <p>
	 * Set the value of the <code>maxSelections</code> property.
	 * </p>
	 */
	public void setMaxSelections ( Integer   maxSelections ) {
		getStateHelper().put(PropertyKeys.maxSelections, maxSelections);
		handleAttribute("maxSelections", maxSelections);
	}
    	/*
	 *Default text displayed when the control
          contains no items (defaults to the same value as 
          Ext.form.TextField.blankText.
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
	 *
        
        
          ddReorder
         : Boolean
        Whether the items in the MultiSelect
        list are drag/drop reorderable (defaults to
        false).
	 */
	
	public Boolean getDdReorder () {
		return (Boolean) getStateHelper().eval(PropertyKeys.ddReorder);
	}

	/**
	 * <p>
	 * Set the value of the <code>ddReorder</code> property.
	 * </p>
	 */
	public void setDdReorder ( Boolean   ddReorder ) {
		getStateHelper().put(PropertyKeys.ddReorder, ddReorder);
		handleAttribute("ddReorder", ddReorder);
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