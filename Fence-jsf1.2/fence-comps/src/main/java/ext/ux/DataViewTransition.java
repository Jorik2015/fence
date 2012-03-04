package ext.ux;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;
import ext.base.ExtOutput;

/**
 * 
 */
@XType("dataviewtransition")
@InstanceOf("Ext.ux.DataViewTransition")
@ParseConfigMode(name = "plugins",id=false, pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class DataViewTransition extends ExtOutput {
	public static final String COMPONENT_FAMILY = "Ext.ux.DataViewTransition";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.DataViewTransition} instance with default property values.
	 * </p>
	 */
	public DataViewTransition() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			duration
			,idProperty
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
	
		
	private Integer duration;
	
	/*
	 *$cfg.commonts
	 */
	
	public Integer getDuration () {
		if (null != this.duration) {
			return this.duration;
		}
		ValueExpression _ve = getValueExpression("duration");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>duration</code> property.
	 * </p>
	 */
	public void setDuration (Integer  duration) {
		this.duration = duration;
		this.handleConfig("duration", duration);
	}
    	
	private String idProperty;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getIdProperty () {
		if (null != this.idProperty) {
			return this.idProperty;
		}
		ValueExpression _ve = getValueExpression("idProperty");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>idProperty</code> property.
	 * </p>
	 */
	public void setIdProperty (String  idProperty) {
		this.idProperty = idProperty;
		this.handleConfig("idProperty", idProperty);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
				_values[1] = duration;	
				_values[2] = idProperty;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.duration = (Integer) _values[1];
		this.handleConfig("duration", this.duration);
				this.idProperty = (String) _values[2];
		this.handleConfig("idProperty", this.idProperty);
			}
}