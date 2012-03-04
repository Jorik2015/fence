package ext.ux.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;
import ext.grid.Column;

/**
 * 
 */
@XType("groupcolumn")
@InstanceOf("Ext.ux.grid.GroupColumn")
@ParseConfigMode(ui = false, name = "rows", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class GroupColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.GroupColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.grid.GroupColumn} instance with default property values.
	 * </p>
	 */
	public GroupColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			colspan
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
	
		
	private Integer colspan;
	
	/*
	 *$cfg.commonts
	 */
	
	public Integer getColspan () {
		if (null != this.colspan) {
			return this.colspan;
		}
		ValueExpression _ve = getValueExpression("colspan");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>colspan</code> property.
	 * </p>
	 */
	public void setColspan (Integer  colspan) {
		this.colspan = colspan;
		this.handleConfig("colspan", colspan);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
				_values[1] = colspan;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.colspan = (Integer) _values[1];
		this.handleConfig("colspan", this.colspan);
			}
}