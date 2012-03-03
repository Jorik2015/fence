package ext.dd;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

/**
 *Note:This java code is auto generated by abner,do not edit it. A simple class
 * that provides the basic implementation needed to make any element a drop
 * target that can have draggable items dropped onto it. The drop has no effect
 * until an implementation of notifyDrop is provided.
 */
public class DropTarget extends DDTarget {
	public static final String COMPONENT_TYPE = "Ext.dd.DropTarget";

	/**
	 * <p>
	 * Create a new {@link DropTarget} instance with default property values.
	 * </p>
	 */
	public DropTarget() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private String ddGroup;

	/**
	 * A named drag drop group to which this objectbelongs. If a group is
	 * specified, then this object will only interact with other drag drop
	 * objects in the same group (defaults to undefined).
	 */
	public String getDdGroup() {
		if (null != this.ddGroup) {
			return this.ddGroup;
		}
		ValueExpression _ve = getValueExpression("ddGroup");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>ddGroup</code> property.
	 * </p>
	 */
	public void setDdGroup(String ddGroup) {
		this.ddGroup = ddGroup;
		handleConfig("ddGroup", ddGroup);
	}

	private String dropAllowed;

	/**
	 * The CSS class returned to the drag source whendrop is allowed (defaults
	 * to "x-dd-drop-ok").
	 */
	public String getDropAllowed() {
		if (null != this.dropAllowed) {
			return this.dropAllowed;
		}
		ValueExpression _ve = getValueExpression("dropAllowed");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>dropAllowed</code> property.
	 * </p>
	 */
	public void setDropAllowed(String dropAllowed) {
		this.dropAllowed = dropAllowed;
		handleConfig("dropAllowed", dropAllowed);
	}

	private String dropNotAllowed;

	/**
	 * The CSS class returned to the drag source whendrop is not allowed
	 * (defaults to "x-dd-drop-nodrop").
	 */
	public String getDropNotAllowed() {
		if (null != this.dropNotAllowed) {
			return this.dropNotAllowed;
		}
		ValueExpression _ve = getValueExpression("dropNotAllowed");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>dropNotAllowed</code> property.
	 * </p>
	 */
	public void setDropNotAllowed(String dropNotAllowed) {
		this.dropNotAllowed = dropNotAllowed;
		handleConfig("dropNotAllowed", dropNotAllowed);
	}

	private String overClass;

	/**
	 * The CSS class applied to the drop target elementwhile the drag source is
	 * over it (defaults to "").
	 */
	public String getOverClass() {
		if (null != this.overClass) {
			return this.overClass;
		}
		ValueExpression _ve = getValueExpression("overClass");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>overClass</code> property.
	 * </p>
	 */
	public void setOverClass(String overClass) {
		this.overClass = overClass;
		handleConfig("overClass", overClass);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[5];
		}
		_values[0] = super.saveState(_context);
		_values[1] = ddGroup;
		_values[2] = dropAllowed;
		_values[3] = dropNotAllowed;
		_values[4] = overClass;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.ddGroup = (String) _values[1];
		this.handleConfig("ddGroup", this.ddGroup);
		this.dropAllowed = (String) _values[2];
		this.handleConfig("dropAllowed", this.dropAllowed);
		this.dropNotAllowed = (String) _values[3];
		this.handleConfig("dropNotAllowed", this.dropNotAllowed);
		this.overClass = (String) _values[4];
		this.handleConfig("overClass", this.overClass);

	}
}