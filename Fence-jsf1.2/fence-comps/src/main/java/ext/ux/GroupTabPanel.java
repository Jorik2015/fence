package ext.ux;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.TabPanel;
import ext.annotation.InstanceOf;
import ext.annotation.UXResources;
import ext.annotation.XType;

@XType("grouptabpanel")
@InstanceOf("Ext.ux.GroupTabPanel")
@UXResources(js = { "ext[version]/ux/GroupTab.js", "ext30/ux/GroupTabPanel.js" }, css = "ext30/ux/css/GroupTab.css")
public class GroupTabPanel extends TabPanel {
	public static final String COMPONENT_TYPE = "Ext.ux.GroupTabPanel";

	/**
	 * <p>
	 * Create a new {@link GroupTabPanel} instance with default property values.
	 * </p>
	 */
	public GroupTabPanel() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}
	
	private Integer tabWidth;
	public Integer getTabWidth() {
		if (null != this.tabWidth) {
			return this.tabWidth;
		}
		ValueExpression _ve = getValueExpression("tabWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}
	public void setTabWidth(Integer tabWidth) {
		this.tabWidth = tabWidth;
		this.handleConfig("tabWidth", tabWidth);
	}
	
	private Integer activeGroup;
	public Integer getActiveGroup() {
		if (null != this.activeGroup) {
			return this.activeGroup;
		}
		ValueExpression _ve = getValueExpression("activeGroup");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}
	public void setActiveGroup(Integer activeGroup) {
		this.activeGroup = activeGroup;
		this.handleConfig("activeGroup", activeGroup);
	}
	
	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.tabWidth;
		_values[2] = this.activeGroup;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);

		this.tabWidth = (Integer)_values[1];
		this.handleConfig("tabWidth", tabWidth);
		
		this.activeGroup = (Integer)_values[2];
		this.handleConfig("activeGroup", activeGroup);
	}
	
}
