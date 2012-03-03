package ext.form;

import javax.el.ValueExpression;
import ext.annotation.*;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
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
<div class="description">Wraps a 
  <a ext:cls="Ext.slider.MultiSlider" href="output/Ext.slider.MultiSlider.html">Slider</a> so it can be used as
  a form field.</div>

 */

@InstanceOf("Ext.form.SliderField")
public class SliderField extends Field {
	public static final String COMPONENT_FAMILY = "Ext.form.SliderField";

	/**
	 * <p>
	 * Create a new {@link Ext.form.SliderField} instance with default property values.
	 * </p>
	 */
	public SliderField() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			useTips
			,tipText
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
	
		
	private Boolean useTips;
	
	/*
	 *
        
        
          useTips
         : Boolean
        True to use an Ext.slider.Tip to display
        tips for the value. Defaults to 
        true.
	 */
	
	public Boolean getUseTips () {
		if (null != this.useTips) {
			return this.useTips;
		}
		ValueExpression _ve = getValueExpression("useTips");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>useTips</code> property.
	 * </p>
	 */
	public void setUseTips (Boolean  useTips) {
		this.useTips = useTips;
		this.handleConfig("useTips", useTips);
	}
    	
	private Object tipText;
	
	/*
	 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="long">A function used to display custom text
          for the slider tip. Defaults to 
          <tt>null</tt>, which will use the default on the
          plugin.</div>

	 */
	@ClientConfig(JsonMode.Function)

	public Object getTipText () {
		if (null != this.tipText) {
			return this.tipText;
		}
		ValueExpression _ve = getValueExpression("tipText");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tipText</code> property.
	 * </p>
	 */
	public void setTipText (Object  tipText) {
		this.tipText = tipText;
		this.handleConfig("tipText", tipText);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
				_values[1] = useTips;	
				_values[2] = tipText;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.useTips = (Boolean) _values[1];
		this.handleConfig("useTips", this.useTips);
				this.tipText = (Object) _values[2];
		this.handleConfig("tipText", this.tipText);
			}
}