package ext.ux.grid;

import javax.faces.context.FacesContext;

import ext.Panel;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.annotation.UXResources;

/**
 *Note:This java code is auto generated by abner,do not edit it. Plugin (ptype
 * = 'roweditor') that adds the ability to rapidly edit full rows in a grid. A
 * validation mode may be enabled which uses AnchorTips to notify the user of
 * all validation errors at once.
 */
@UXResources(js = "ext[version]/ux/RowEditor.js",css="ext[version]/ux/css/RowEditor.css")
@ParseConfigMode(ui = false, name = "plugins", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class RowEditor extends Panel {
	public static final String COMPONENT_TYPE = "Ext.ux.grid.RowEditor";

	/**
	 * <p>
	 * Create a new {@link RowEditor} instance with default property values.
	 * </p>
	 */
	public RowEditor() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[1];
		}
		_values[0] = super.saveState(_context);

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);

	}
}