package ext.ux;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.Container;

public class GroupTab extends Container {
	public static final String COMPONENT_TYPE = "Ext.ux.GroupTab";

	/**
	 * <p>
	 * Create a new {@link GroupTab} instance with default property values.
	 * </p>
	 */
	public GroupTab() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Integer mainItem;

	public Integer getMainItem() {
		if (null != this.mainItem) {
			return this.mainItem;
		}
		ValueExpression _ve = getValueExpression("mainItem");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setMainItem(Integer mainItem) {
		this.mainItem = mainItem;
		this.handleConfig("mainItem", mainItem);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[2];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.mainItem;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);

		this.mainItem = (Integer) _values[1];
		this.handleConfig("mainItem", mainItem);

	}
}
