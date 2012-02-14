package ext.ux;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.UXResources;
import ext.base.ExtOutput;

@UXResources(js = "ext[version]/ux/PanelResizer.js",css="ext[version]/ux/css/PanelResizer.css")
@ParseConfigMode(name = "plugins",id=false, pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
@InstanceOf("Ext.ux.PanelResizer")
public class PanelResizer extends ExtOutput {
	public static final String COMPONENT_TYPE = "Ext.ux.PanelResizer";

	/**
	 * <p>
	 * Create a new {@link TabCloseMenu} instance with default property values.
	 * </p>
	 */
	public PanelResizer() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}
	
	private Integer minHeight;

	public Integer getMinHeight() {
		if (null != this.minHeight) {
			return this.minHeight;
		}
		ValueExpression _ve = getValueExpression("minHeight");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setMinHeight(Integer minHeight) {
		this.minHeight = minHeight;
		this.handleConfig("minHeight", minHeight);
	}
	
	private Integer maxHeight;

	public Integer getMaxHeight() {
		if (null != this.maxHeight) {
			return this.maxHeight;
		}
		ValueExpression _ve = getValueExpression("maxHeight");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
		this.handleConfig("maxHeight", maxHeight);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[3];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.minHeight;
		_values[2] = this.maxHeight;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);

		this.minHeight = (Integer) _values[1];
		this.handleConfig("minHeight", minHeight);
		this.maxHeight = (Integer) _values[2];
		this.handleConfig("maxHeight", maxHeight);
	}
}
