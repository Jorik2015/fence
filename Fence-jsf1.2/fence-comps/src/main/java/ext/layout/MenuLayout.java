package ext.layout;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.Layout;
import ext.annotation.LayoutType;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 *Note:This java code is auto generated by abner,do not edit it.
 * 
 * <p>
 * Layout manager used by <a href="output/Ext.menu.Menu.html"
 * ext:cls="Ext.menu.Menu">Ext.menu.Menu</a>. Generally this class should not
 * need to be used directly.
 * </p>
 */
@Layout(LayoutType.menu)
@InstanceOf("Ext.layout.MenuLayout")
@ParseConfigMode(ui = false, pmode = PersistenceMode.InnerProperty, rmode = ReferenceMode.Config)
public class MenuLayout extends ContainerLayout {
	public static final String COMPONENT_TYPE = "Ext.layout.MenuLayout";
	public static final String COMPONENT_FAMILY = "Ext.layout.MenuLayout";

	/**
	 * <p>
	 * Create a new {@link MenuLayout} instance with default property values.
	 * </p>
	 */
	public MenuLayout() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
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