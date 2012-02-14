package ext.base;

import java.io.IOException;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import javax.naming.InvalidNameException;

import ext.util.AttributeValue;
import ext.util.StringUtil;

public class ExtOutput extends UIOutput implements IExt {
	public static final String COMPONENT_TYPE = "Ext.Output";
	private ExtBase extBase;
	private String var;
	private String refer;
	private StringBuilder beforeScript;
	private StringBuilder afterScript;

	public ExtOutput() {
		super();
		init();
		setRendererType(COMPONENT_TYPE);
	}

	private void init() {
		if (extBase == null)
			extBase = new ExtBase(this);
	}

	@Override
	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	public ExtBase getExtBase() {
		return extBase;
	}

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		if (!isRendered()) {
			return;
		}

		try {
			extBase.checkConflictId(context);
		} catch (InvalidNameException e) {
			throw new RuntimeException(e);
		}
		extBase.mergeAttribute(context, this.bindings);
		super.encodeAll(context);
	}

	@Override
	protected Renderer getRenderer(FacesContext context) {
		return extBase.getRenderer(context);
	}

	public void handleConfig(String name, Object value) {
		extBase.handleConfig(name, value);
	}

	public AttributeValue getConfigValue(String key) {
		return extBase.getAllConfig().get(key);
	}

	public Object getConfig(String key) {
		AttributeValue av = this.getConfigValue(key);
		if (av != null)
			return av.getRawValue();

		return null;
	}

	public Map<String, AttributeValue> getAllConfig() {
		return extBase.getAllConfig();
	}

	public String getVar() {
		if (null != this.var) {
			return this.var;
		}
		ValueExpression _ve = getValueExpression("var");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return this.getClientId(getFacesContext());
		}
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getRefer() {
		if (null != this.refer) {
			return this.refer;
		}
		ValueExpression _ve = getValueExpression("refer");
		if (_ve != null) {
			return (String) _ve.getValue(getFacesContext().getELContext());
		} else {
			return null;
		}
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	private String ns;

	public String getNs() {
		UIComponent parent = this.getParent();
		if (parent instanceof IExt) {
			String pns = ((IExt) parent).getNs();
			if (StringUtil.isEmpty(this.ns))
				return pns;
			else if (StringUtil.isEmpty(pns)) {
				return ns;
			} else {
				return pns + "." + this.ns;
			}
		}
		return this.ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public StringBuilder getBeforeScript() {
		if (beforeScript == null)
			beforeScript = new StringBuilder(128);
		return beforeScript;
	}

	public StringBuilder getAfterScript() {
		if (afterScript == null)
			afterScript = new StringBuilder(128);
		return afterScript;
	}

	private Object[] _values;

	public Object saveState(FacesContext _context) {
		if (_values == null) {
			_values = new Object[4];
		}
		_values[0] = super.saveState(_context);
		_values[1] = this.var;
		_values[2] = this.refer;
		_values[3] = this.ns;
		return _values;
	}

	public void restoreState(FacesContext _context, Object _state) {
		_values = (Object[]) _state;
		super.restoreState(_context, _values[0]);
		this.var = (String) _values[1];
		this.refer = (String) _values[2];
		this.ns = (String) _values[3];
	}
}
