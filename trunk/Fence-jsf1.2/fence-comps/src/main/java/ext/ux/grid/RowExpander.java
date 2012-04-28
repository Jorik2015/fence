package ext.ux.grid;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.UXResources;
import ext.util.Observable;

/**
 * Note:This java code is auto generated by abner,do not edit it. Plugin (ptype
 * = 'rowexpander') that adds the ability to have a Column in a grid which
 * enables a second row body which expands/contracts. The expand/contract
 * behavior is configurable to react on clicking of the column, double click of
 * the row, and/or hitting enter while a row is selected.
 */
@UXResources(js = "ext[version]/ux/RowExpander.js")
@ParseConfigMode(ui = false, name = "plugins", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class RowExpander extends Observable {
	public static final String COMPONENT_TYPE = "Ext.ux.grid.RowExpander";

	/**
	 * <p>
	 * Create a new {@link RowExpander} instance with default property values.
	 * </p>
	 */
	public RowExpander() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Boolean expandOnDblClick;

	/**
	 * <tt>true</tt> to toggle a row betweenexpanded/collapsed when double
	 * clicked (defaults to <tt>true</tt>).
	 */
	public Boolean getExpandOnDblClick() {
		if (null != this.expandOnDblClick) {
			return this.expandOnDblClick;
		}
		ValueExpression _ve = getValueExpression("expandOnDblClick");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>expandOnDblClick</code> property.
	 * </p>
	 */
	public void setExpandOnDblClick(Boolean expandOnDblClick) {
		this.expandOnDblClick = expandOnDblClick;
		handleConfig("expandOnDblClick", expandOnDblClick);
	}

	private Boolean expandOnEnter;

	/**
	 * <tt>true</tt> to toggle selected row(s) betweenexpanded/collapsed when
	 * the enter key is pressed (defaults to <tt>true</tt>).
	 */
	public Boolean getExpandOnEnter() {
		if (null != this.expandOnEnter) {
			return this.expandOnEnter;
		}
		ValueExpression _ve = getValueExpression("expandOnEnter");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>expandOnEnter</code> property.
	 * </p>
	 */
	public void setExpandOnEnter(Boolean expandOnEnter) {
		this.expandOnEnter = expandOnEnter;
		handleConfig("expandOnEnter", expandOnEnter);
	}

	private String tpl;

	/**
	 */
	public String getTpl() {
		if (null != this.tpl) {
			return this.tpl;
		}
		ValueExpression _ve = getValueExpression("tpl");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>tpl</code> property.
	 * </p>
	 */
	public void setTpl(String tpl) {
		this.tpl = tpl;
		this.handleConfig("tpl", tpl);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = expandOnDblClick;
		_values[2] = expandOnEnter;
		_values[3] = tpl;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.expandOnDblClick = (Boolean) _values[1];
		this.handleConfig("expandOnDblClick", this.expandOnDblClick);
		this.expandOnEnter = (Boolean) _values[2];
		this.handleConfig("expandOnEnter", this.expandOnEnter);
		this.tpl = (String) _values[3];
		this.handleConfig("tpl", this.tpl);
	}
}