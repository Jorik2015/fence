package ext.ux.mif;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import ext.Panel;
import ext.annotation.ClientConfig;
import ext.annotation.InstanceOf;
import ext.annotation.JsonMode;
import ext.annotation.XType;

@XType("mif")
@InstanceOf("Ext.ux.ManagedIFrame.Component")
public class MifComponentAdapter extends Panel {
	public static final String COMPONENT_TYPE = "Ext.ux.ManagedIFrame.ComponentAdapter";
	public static final String COMPONENT_FAMILY = "Ext.ux.ManagedIFrame.ComponentAdapter";

	/**
	 * <p>
	 * Create a new {@link MifComponentAdapter} instance with default property
	 * values.
	 * </p>
	 */
	public MifComponentAdapter() {
		super();
		setRendererType(COMPONENT_FAMILY);
	}

	public String getFamily() {
		return (COMPONENT_FAMILY);
	}

	private Boolean autoScroll;

	public Boolean getAutoScroll() {
		if (null != this.autoScroll) {
			return this.autoScroll;
		}
		ValueExpression _ve = getValueExpression("autoScroll");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setAutoScroll(Boolean autoScroll) {
		this.autoScroll = autoScroll;
		this.handleConfig("autoScroll", autoScroll);
	}

	private String defaultSrc;

	public String getDefaultSrc() {
		if (null != this.defaultSrc) {
			return this.defaultSrc;
		}
		ValueExpression _ve = getValueExpression("defaultSrc");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setDefaultSrc(String defaultSrc) {
		this.defaultSrc = defaultSrc;
		this.handleConfig("defaultSrc", defaultSrc);
	}

	private Boolean focusOnLoad;

	public Boolean getFocusOnLoad() {
		if (null != this.focusOnLoad) {
			return this.focusOnLoad;
		}
		ValueExpression _ve = getValueExpression("focusOnLoad");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setFocusOnLoad(Boolean focusOnLoad) {
		this.focusOnLoad = focusOnLoad;
		this.handleConfig("focusOnLoad", focusOnLoad);
	}

	private Object frameConfig;

	@ClientConfig(JsonMode.Object)
	public Object getFrameConfig() {
		if (null != this.frameConfig) {
			return this.frameConfig;
		}
		ValueExpression _ve = getValueExpression("frameConfig");
		if (_ve != null) {
			return (Object) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setFrameConfig(Object frameConfig) {
		this.frameConfig = frameConfig;
		this.handleConfig("frameConfig", frameConfig);
	}

	private String unsupportedText;

	public String getUnsupportedText() {
		if (null != this.unsupportedText) {
			return this.unsupportedText;
		}
		ValueExpression _ve = getValueExpression("unsupportedText");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setUnsupportedText(String unsupportedText) {
		this.unsupportedText = unsupportedText;
		this.handleConfig("unsupportedText", unsupportedText);
	}

	private Boolean useShim;

	public Boolean getUseShim() {
		if (null != this.useShim) {
			return this.useShim;
		}
		ValueExpression _ve = getValueExpression("useShim");
		if (_ve != null) {
			return (Boolean) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setUseShim(Boolean useShim) {
		this.useShim = useShim;
		this.handleConfig("useShim", useShim);
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[7];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.autoScroll;
		_values[2] = this.defaultSrc;
		_values[3] = this.focusOnLoad;
		_values[4] = this.frameConfig;
		_values[5] = this.unsupportedText;
		_values[6] = this.useShim;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.autoScroll = (Boolean) _values[1];
		this.handleConfig("autoScroll", this.autoScroll);
		this.defaultSrc = (String) _values[2];
		this.handleConfig("defaultSrc", this.defaultSrc);
		this.focusOnLoad = (Boolean) _values[3];
		this.handleConfig("focusOnLoad", this.focusOnLoad);
		this.frameConfig = (Object) _values[4];
		this.handleConfig("frameConfig", this.frameConfig);
		this.unsupportedText = (String) _values[5];
		this.handleConfig("unsupportedText", this.unsupportedText);
		this.useShim = (Boolean) _values[6];
		this.handleConfig("useShim", this.useShim);
	}
}
