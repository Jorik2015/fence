package ext.ux;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.context.FacesContext;

import com.abner.fence.annotation.ClientConfig;
import com.abner.fence.annotation.InstanceOf;
import com.abner.fence.annotation.ParseConfigMode;
import com.abner.fence.commons.Enums.JsonMode;
import com.abner.fence.commons.Enums.PersistenceMode;
import com.abner.fence.commons.Enums.ReferenceMode;
import com.abner.fence.component.ExtComponent;

/**
 *Note:This java code is auto generated by abner,do not edit it. Plugin (ptype
 * = 'tabclosemenu') for displaying a progressbar inside of a paging toolbar
 * instead of plain text
 */
@ResourceDependencies({
	@ResourceDependency(library = "ext#{ext.version}/ux", name = "SlidingPager.js"),
	@ResourceDependency(library = "ext#{ext.version}/ux", name = "SliderTip.js")
})

@InstanceOf("Ext.ux.SlidingPager")
@ParseConfigMode(name = "plugins", pmode = PersistenceMode.ParentProperty, rmode = ReferenceMode.Var)
public class SlidingPager extends ExtComponent {
	public static final String COMPONENT_TYPE = "Ext.ux.SlidingPager";

	/**
	 * <p>
	 * Create a new {@link SlidingPager} instance with default property
	 * values.
	 * </p>
	 */
	public SlidingPager() {
		super();
		setRendererType(COMPONENT_TYPE);
	}

	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	private Object defaultAnimCfg;

	/**
	 * <p>
	 * A <a href="output/Ext.Fx.html" ext:cls="Ext.Fx">Ext.Fx</a> configuration
	 * object. Default is { duration : 1, easing : 'bounceOut' }.
	 * </p>
	 */
	@ClientConfig(JsonMode.Object)
	public Object getDefaultAnimCfg() {
		if (null != this.defaultAnimCfg) {
			return this.defaultAnimCfg;
		}
		ValueExpression _ve = getValueExpression("defaultAnimCfg");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultAnimCfg</code> property.
	 * </p>
	 */
	public void setDefaultAnimCfg(Object defaultAnimCfg) {
		this.defaultAnimCfg = defaultAnimCfg;
		handleConfig("defaultAnimCfg", defaultAnimCfg);
	}

	private String defaultText;

	/**
	 * <p>
	 * The text to display while the store is loading. Default is 'Loading...'
	 * </p>
	 */
	public String getDefaultText() {
		if (null != this.defaultText) {
			return this.defaultText;
		}
		ValueExpression _ve = getValueExpression("defaultText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>defaultText</code> property.
	 * </p>
	 */
	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
		handleConfig("defaultText", defaultText);
	}

	private Integer progBarWidth;

	/**
	 * <p>
	 * The default progress bar width. Default is 225.
	 * </p>
	 */
	public Integer getProgBarWidth() {
		if (null != this.progBarWidth) {
			return this.progBarWidth;
		}
		ValueExpression _ve = getValueExpression("progBarWidth");
		if (_ve != null) {
			return (Integer) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Set the value of the <code>progBarWidth</code> property.
	 * </p>
	 */
	public void setProgBarWidth(Integer progBarWidth) {
		this.progBarWidth = progBarWidth;
		handleConfig("progBarWidth", progBarWidth);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = defaultAnimCfg;
		_values[2] = defaultText;
		_values[3] = progBarWidth;

		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.defaultAnimCfg = (Object) _values[1];
		this.handleConfig("defaultAnimCfg", this.defaultAnimCfg);
		this.defaultText = (String) _values[2];
		this.handleConfig("defaultText", this.defaultText);
		this.progBarWidth = (Integer) _values[3];
		this.handleConfig("progBarWidth", this.progBarWidth);

	}
}