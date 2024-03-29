package ext.data;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.XType;

/**
 *Note:This java code is auto generated by abner,do not edit it. A specialized
 * store implementation that provides for grouping records by one of the
 * available fields. This is usually used in conjunction with an <a
 * href="output/Ext.grid.GroupingView.html"
 * ext:cls="Ext.grid.GroupingView">Ext.grid.GroupingView</a> to proved the data
 * model for a grouped GridPanel.
 */
@XType("groupingstore")
@InstanceOf("Ext.data.GroupingStore")
@ParseConfigMode(ui = false, name = "store", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class GroupingStore extends Store {
	private static final long serialVersionUID = 3566477032336592723L;
	public static final String COMPONENT_TYPE = "Ext.data.GroupingStore";
	public static final String COMPONENT_FAMILY = "Ext.data.GroupingStore";

	/**
	 * <p>
	 * Create a new {@link GroupingStore} instance with default property values.
	 * </p>
	 */
	public GroupingStore() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private String groupField;

	/**
	 * The field name by which to sort the store's data(defaults to '').
	 */
	public String getGroupField() {
		if (null != this.groupField) {
			return this.groupField;
		}
		ValueExpression _ve = getValueExpression("groupField");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>groupField</code> property.
	 * </p>
	 */
	public void setGroupField(String groupField) {
		this.groupField = groupField;
		this.handleConfig("groupField", groupField);
	}

	private Boolean groupOnSort;

	/**
	 * True to sort the data on the grouping field whena grouping operation
	 * occurs, false to sort based on the existing sort info (defaults to
	 * false).
	 */
	public Boolean getGroupOnSort() {
		if (null != this.groupOnSort) {
			return this.groupOnSort;
		}
		ValueExpression _ve = getValueExpression("groupOnSort");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>groupOnSort</code> property.
	 * </p>
	 */
	public void setGroupOnSort(Boolean groupOnSort) {
		this.groupOnSort = groupOnSort;
		this.handleConfig("groupOnSort", groupOnSort);
	}

	private Boolean remoteGroup;

	/**
	 * True if the grouping should apply on the serverside, false if it is local
	 * only (defaults to false). If the grouping is local, it can be applied
	 * immediately to the data. If it is remote, then it will simply act as a
	 * helper, automatically sending the grouping field name as the 'groupBy'
	 * param with each XHR call.
	 */
	public Boolean getRemoteGroup() {
		if (null != this.remoteGroup) {
			return this.remoteGroup;
		}
		ValueExpression _ve = getValueExpression("remoteGroup");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>remoteGroup</code> property.
	 * </p>
	 */
	public void setRemoteGroup(Boolean remoteGroup) {
		this.remoteGroup = remoteGroup;
		this.handleConfig("remoteGroup", remoteGroup);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = groupField;
		_values[2] = groupOnSort;
		_values[3] = remoteGroup;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.groupField = (String) _values[1];
		this.handleConfig("groupField", this.groupField);
		this.groupOnSort = (Boolean) _values[2];
		this.handleConfig("groupOnSort", this.groupOnSort);
		this.remoteGroup = (Boolean) _values[3];
		this.handleConfig("remoteGroup", this.remoteGroup);

	}
}