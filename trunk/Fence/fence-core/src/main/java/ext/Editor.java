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
<div class="description">A base editor field that handles
  displaying/hiding on demand and has some built-in sizing and
  event handling logic.</div>

 */
@XType("editor")
@InstanceOf("Ext.Editor")

@FacesComponent(value = "Ext.Editor")
public class Editor extends Component {
	public static final String COMPONENT_FAMILY = "Ext.Editor";

	/**
	 * <p>
	 * Create a new {@link Ext.Editor} instance with default property values.
	 * </p>
	 */
	public Editor() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			alignment
			,allowBlur
			,constrain
			,offsets
			,autoSize
			,swallowKeys
			,ignoreNoChange
			,field
			,cancelOnEsc
			,updateEl
			,shadow
			,hideEl
			,value
			,completeOnEnter
			,revertInvalid
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
        
        
          alignment
         : String
        The position to align to (see 
        Ext.Element.alignTo for more
        details, defaults to "c-c?").
	 */
	
	public String getAlignment () {
		return (String) getStateHelper().eval(PropertyKeys.alignment);
	}

	/**
	 * <p>
	 * Set the value of the <code>alignment</code> property.
	 * </p>
	 */
	public void setAlignment ( String   alignment ) {
		getStateHelper().put(PropertyKeys.alignment, alignment);
		handleAttribute("alignment", alignment);
	}
    	/*
	 *
        
        
          allowBlur
         : Boolean
        True to 
        complete the
        editing process if in edit mode when the field is
        blurred. Defaults to 
        true.
	 */
	
	public Boolean getAllowBlur () {
		return (Boolean) getStateHelper().eval(PropertyKeys.allowBlur);
	}

	/**
	 * <p>
	 * Set the value of the <code>allowBlur</code> property.
	 * </p>
	 */
	public void setAllowBlur ( Boolean   allowBlur ) {
		getStateHelper().put(PropertyKeys.allowBlur, allowBlur);
		handleAttribute("allowBlur", allowBlur);
	}
    	/*
	 *
        
        
          constrain
         : Boolean
        True to constrain the editor to the
        viewport
	 */
	
	public Boolean getConstrain () {
		return (Boolean) getStateHelper().eval(PropertyKeys.constrain);
	}

	/**
	 * <p>
	 * Set the value of the <code>constrain</code> property.
	 * </p>
	 */
	public void setConstrain ( Boolean   constrain ) {
		getStateHelper().put(PropertyKeys.constrain, constrain);
		handleAttribute("constrain", constrain);
	}
    	/*
	 *
        
        
          offsets
         : Array
        The offsets to use when aligning (see 
        Ext.Element.alignTo for more
        details. Defaults to 
        [0, 0].
	 */
	@ClientConfig(JsonMode.Array)

	public Object getOffsets () {
		return (Object) getStateHelper().eval(PropertyKeys.offsets);
	}

	/**
	 * <p>
	 * Set the value of the <code>offsets</code> property.
	 * </p>
	 */
	public void setOffsets ( Object   offsets ) {
		getStateHelper().put(PropertyKeys.offsets, offsets);
		handleAttribute("offsets", offsets);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True for the editor to automatically
          adopt the size of the underlying field, "width" to adopt
          the width only, or "height" to adopt the height only,
          "none" to always use the field dimensions. (defaults to
          false)</div>

	 */
	
	public Boolean getAutoSize () {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoSize);
	}

	/**
	 * <p>
	 * Set the value of the <code>autoSize</code> property.
	 * </p>
	 */
	public void setAutoSize ( Boolean   autoSize ) {
		getStateHelper().put(PropertyKeys.autoSize, autoSize);
		handleAttribute("autoSize", autoSize);
	}
    	/*
	 *
        
        
          swallowKeys
         : Boolean
        Handle the keydown/keypress events so
        they don't propagate (defaults to true)
	 */
	
	public Boolean getSwallowKeys () {
		return (Boolean) getStateHelper().eval(PropertyKeys.swallowKeys);
	}

	/**
	 * <p>
	 * Set the value of the <code>swallowKeys</code> property.
	 * </p>
	 */
	public void setSwallowKeys ( Boolean   swallowKeys ) {
		getStateHelper().put(PropertyKeys.swallowKeys, swallowKeys);
		handleAttribute("swallowKeys", swallowKeys);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to skip the edit completion
          process (no save, no events fired) if the user completes
          an edit and the value has not changed (defaults to
          false). Applies only to string values - edits for other
          data types will never be ignored.</div>

	 */
	
	public Boolean getIgnoreNoChange () {
		return (Boolean) getStateHelper().eval(PropertyKeys.ignoreNoChange);
	}

	/**
	 * <p>
	 * Set the value of the <code>ignoreNoChange</code> property.
	 * </p>
	 */
	public void setIgnoreNoChange ( Boolean   ignoreNoChange ) {
		getStateHelper().put(PropertyKeys.ignoreNoChange, ignoreNoChange);
		handleAttribute("ignoreNoChange", ignoreNoChange);
	}
    	/*
	 *
        
        
          field
         : Ext.form.Field
        The Field object (or descendant) or
        config object for field
	 */
	@ClientConfig(JsonMode.Object)

	public Object getField () {
		return (Object) getStateHelper().eval(PropertyKeys.field);
	}

	/**
	 * <p>
	 * Set the value of the <code>field</code> property.
	 * </p>
	 */
	public void setField ( Object   field ) {
		getStateHelper().put(PropertyKeys.field, field);
		handleAttribute("field", field);
	}
    	/*
	 *
        
        
          cancelOnEsc
         : Boolean
        True to cancel the edit when the escape
        key is pressed. Defaults to 
        true.
	 */
	
	public Boolean getCancelOnEsc () {
		return (Boolean) getStateHelper().eval(PropertyKeys.cancelOnEsc);
	}

	/**
	 * <p>
	 * Set the value of the <code>cancelOnEsc</code> property.
	 * </p>
	 */
	public void setCancelOnEsc ( Boolean   cancelOnEsc ) {
		getStateHelper().put(PropertyKeys.cancelOnEsc, cancelOnEsc);
		handleAttribute("cancelOnEsc", cancelOnEsc);
	}
    	/*
	 *
        
        
          updateEl
         : Boolean
        True to update the innerHTML of the
        bound element when the update completes (defaults to
        false)
	 */
	
	public Boolean getUpdateEl () {
		return (Boolean) getStateHelper().eval(PropertyKeys.updateEl);
	}

	/**
	 * <p>
	 * Set the value of the <code>updateEl</code> property.
	 * </p>
	 */
	public void setUpdateEl ( Boolean   updateEl ) {
		getStateHelper().put(PropertyKeys.updateEl, updateEl);
		handleAttribute("updateEl", updateEl);
	}
    	/*
	 *
        
        
          shadow
         : Boolean/String
        "sides" for sides/bottom only, "frame"
        for 4-way shadow, and "drop" for bottom-right shadow
        (defaults to "frame")
	 */
	
	public Boolean getShadow () {
		return (Boolean) getStateHelper().eval(PropertyKeys.shadow);
	}

	/**
	 * <p>
	 * Set the value of the <code>shadow</code> property.
	 * </p>
	 */
	public void setShadow ( Boolean   shadow ) {
		getStateHelper().put(PropertyKeys.shadow, shadow);
		handleAttribute("shadow", shadow);
	}
    	/*
	 *
        
        
          hideEl
         : Boolean
        False to keep the bound element visible
        while the editor is displayed (defaults to true)
	 */
	
	public Boolean getHideEl () {
		return (Boolean) getStateHelper().eval(PropertyKeys.hideEl);
	}

	/**
	 * <p>
	 * Set the value of the <code>hideEl</code> property.
	 * </p>
	 */
	public void setHideEl ( Boolean   hideEl ) {
		getStateHelper().put(PropertyKeys.hideEl, hideEl);
		handleAttribute("hideEl", hideEl);
	}
    	/*
	 *
        
        
          value
         : Mixed
        The data value of the underlying field
        (defaults to "")
	 */
	@ClientConfig(JsonMode.Object)

	public Object getValue () {
		return (Object) getStateHelper().eval(PropertyKeys.value);
	}

	/**
	 * <p>
	 * Set the value of the <code>value</code> property.
	 * </p>
	 */
	public void setValue ( Object   value ) {
		getStateHelper().put(PropertyKeys.value, value);
		handleAttribute("value", value);
	}
    	/*
	 *
        
        
          completeOnEnter
         : Boolean
        True to complete the edit when the enter
        key is pressed. Defaults to 
        true.
	 */
	
	public Boolean getCompleteOnEnter () {
		return (Boolean) getStateHelper().eval(PropertyKeys.completeOnEnter);
	}

	/**
	 * <p>
	 * Set the value of the <code>completeOnEnter</code> property.
	 * </p>
	 */
	public void setCompleteOnEnter ( Boolean   completeOnEnter ) {
		getStateHelper().put(PropertyKeys.completeOnEnter, completeOnEnter);
		handleAttribute("completeOnEnter", completeOnEnter);
	}
    	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">True to automatically revert the field
          value and cancel the edit when the user completes an edit
          and the field validation fails (defaults to true)</div>

	 */
	
	public Boolean getRevertInvalid () {
		return (Boolean) getStateHelper().eval(PropertyKeys.revertInvalid);
	}

	/**
	 * <p>
	 * Set the value of the <code>revertInvalid</code> property.
	 * </p>
	 */
	public void setRevertInvalid ( Boolean   revertInvalid ) {
		getStateHelper().put(PropertyKeys.revertInvalid, revertInvalid);
		handleAttribute("revertInvalid", revertInvalid);
	}
        
    @Override
	public String getDefaultEventName() {
		return super.getDefaultEventName();
	}

	@Override
	public Collection<String> getEventNames() {
		Collection<String> superEvent = super.getEventNames();
				superEvent.addAll(Arrays.asList(
					 "beforecomplete"
					, "beforestartedit"
					, "canceledit"
					, "complete"
					, "specialkey"
					, "startedit"
				));
				return superEvent;
	}
}