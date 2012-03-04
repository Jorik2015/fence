package ext.list;

import javax.faces.context.FacesContext;

import ext.annotation.InstanceOf;
import ext.annotation.ParseConfigMode;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;

/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div class="description">
    <p>A Column definition class which renders a passed date
    according to the default locale, or a configured 
    <a ext:cls="Ext.list.DateColumn" ext:member="format" href="output/Ext.list.DateColumn.html#Ext.list.DateColumn-format">format</a>.
    See the 
    <a ext:cls="Ext.list.Column" ext:member="xtype" href="output/Ext.list.Column.html#Ext.list.Column-xtype">xtype</a> config
    option of 
    <a ext:cls="Ext.list.Column" href="output/Ext.list.Column.html">Ext.list.Column</a> for more
    details.</p>
  </div>

 */

@InstanceOf("Ext.list.DateColumn")
@ParseConfigMode(ui = false, name = "columns", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Config)
public class DateColumn extends Column {
	public static final String COMPONENT_FAMILY = "Ext.list.DateColumn";

	/**
	 * <p>
	 * Create a new {@link Ext.list.DateColumn} instance with default property values.
	 * </p>
	 */
	public DateColumn() {
		super();
		this.setRendererType(COMPONENT_FAMILY);
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