package ext.ux.grid;

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
 * 
 */
@XType("lockinggridview")
@InstanceOf("Ext.ux.grid.LockingGridView")
@ParseConfigMode(ui = false, name = "view", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class LockingGridView extends GridView {
	public static final String COMPONENT_FAMILY = "Ext.ux.grid.LockingGridView";

	/**
	 * <p>
	 * Create a new {@link Ext.ux.grid.LockingGridView} instance with default property values.
	 * </p>
	 */
	public LockingGridView() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}
		enum PropertyKeys {
			lockText
			,unlockText
			,rowBorderWidth
			,lockedBorderWidth
			,syncHeights
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
	
		
	private String lockText;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getLockText () {
		if (null != this.lockText) {
			return this.lockText;
		}
		ValueExpression _ve = getValueExpression("lockText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>lockText</code> property.
	 * </p>
	 */
	public void setLockText (String  lockText) {
		this.lockText = lockText;
		this.handleConfig("lockText", lockText);
	}
    	
	private String unlockText;
	
	/*
	 *$cfg.commonts
	 */
	
	public String getUnlockText () {
		if (null != this.unlockText) {
			return this.unlockText;
		}
		ValueExpression _ve = getValueExpression("unlockText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>unlockText</code> property.
	 * </p>
	 */
	public void setUnlockText (String  unlockText) {
		this.unlockText = unlockText;
		this.handleConfig("unlockText", unlockText);
	}
    	
	private Integer rowBorderWidth;
	
	/*
	 *$cfg.commonts
	 */
	
	public Integer getRowBorderWidth () {
		if (null != this.rowBorderWidth) {
			return this.rowBorderWidth;
		}
		ValueExpression _ve = getValueExpression("rowBorderWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>rowBorderWidth</code> property.
	 * </p>
	 */
	public void setRowBorderWidth (Integer  rowBorderWidth) {
		this.rowBorderWidth = rowBorderWidth;
		this.handleConfig("rowBorderWidth", rowBorderWidth);
	}
    	
	private Integer lockedBorderWidth;
	
	/*
	 *$cfg.commonts
	 */
	
	public Integer getLockedBorderWidth () {
		if (null != this.lockedBorderWidth) {
			return this.lockedBorderWidth;
		}
		ValueExpression _ve = getValueExpression("lockedBorderWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>lockedBorderWidth</code> property.
	 * </p>
	 */
	public void setLockedBorderWidth (Integer  lockedBorderWidth) {
		this.lockedBorderWidth = lockedBorderWidth;
		this.handleConfig("lockedBorderWidth", lockedBorderWidth);
	}
    	
	private Boolean syncHeights;
	
	/*
	 *$cfg.commonts
	 */
	
	public Boolean getSyncHeights () {
		if (null != this.syncHeights) {
			return this.syncHeights;
		}
		ValueExpression _ve = getValueExpression("syncHeights");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>syncHeights</code> property.
	 * </p>
	 */
	public void setSyncHeights (Boolean  syncHeights) {
		this.syncHeights = syncHeights;
		this.handleConfig("syncHeights", syncHeights);
	}
        
  	private Object[] _values;
		public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[6];
		}
		_values[0] = super.saveState(_context);
				_values[1] = lockText;	
				_values[2] = unlockText;	
				_values[3] = rowBorderWidth;	
				_values[4] = lockedBorderWidth;	
				_values[5] = syncHeights;	
				return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
				this.lockText = (String) _values[1];
		this.handleConfig("lockText", this.lockText);
				this.unlockText = (String) _values[2];
		this.handleConfig("unlockText", this.unlockText);
				this.rowBorderWidth = (Integer) _values[3];
		this.handleConfig("rowBorderWidth", this.rowBorderWidth);
				this.lockedBorderWidth = (Integer) _values[4];
		this.handleConfig("lockedBorderWidth", this.lockedBorderWidth);
				this.syncHeights = (Boolean) _values[5];
		this.handleConfig("syncHeights", this.syncHeights);
			}
}