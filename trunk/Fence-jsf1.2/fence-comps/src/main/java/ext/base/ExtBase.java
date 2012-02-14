package ext.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import javax.naming.InvalidNameException;

import ext.annotation.ClientConfig;
import ext.annotation.JsonMode;
import ext.annotation.XType;
import ext.util.AttributeValue;
import ext.util.ClassUtils;
import ext.util.ComponentUtil;
import ext.util.StringUtil;

public class ExtBase {
	private final Map<String, AttributeValue> allConfig = new HashMap<String, AttributeValue>();
	public static final String COMPONENT_TYPE = "Ext.ExtComponent";
	private IExt component;

	public ExtBase(IExt comp) {
		this.component = comp;
		this.init();
	}

	void init() {
		XType xtype = component.getClass().getAnnotation(XType.class);
		if (xtype != null) {
			if (StringUtil.isEmpty(xtype.value()))
				throw new IllegalArgumentException(
						"The XType annotation value can not be empty.");

			this.handleConfig("xtype", xtype.value());
		}
	}

	public String getDefaultComponentType() {
		return (COMPONENT_TYPE);
	}

	public void checkConflictId(FacesContext context)
			throws InvalidNameException {
		List<UIComponent> result = ComponentUtil.findComponents(context.getViewRoot(), component.getId());
		if (result.size() > 1)
			throw new InvalidNameException("The component with id:"	+ component.getId() + " is exist.");
	}

	public void mergeAttribute(FacesContext context,Map<String, ValueExpression> bindings) {
		if (!StringUtil.isEmpty(component.getRefer()))
			return;

		if (bindings != null) {
			for (Map.Entry<String, ValueExpression> entry : bindings.entrySet()) {
				String key = entry.getKey();
				if("rendered".equalsIgnoreCase(key))
					continue;
				Class<?> clazz = component.getClass();
				String methodName = "get" + StringUtil.upperFirstChar(key);
				ClientConfig cfg = ClassUtils.lookupAnno(clazz, methodName, ClientConfig.class);
				if(cfg != null && cfg.value() == JsonMode.Ignore){
					continue;
				}
				
				ValueExpression vExp = entry.getValue();
				//Object val = vExp.getValue(context.getELContext());
				this.handleConfig(key, vExp);
			}
		}
		for (Map.Entry<String, Object> entry : component.getAttributes().entrySet()) {
			String key = entry.getKey();
			Object obj = entry.getValue();
			if (key.endsWith("MARK_ID") || key.endsWith("APPLIED"))
				continue;

			this.handleConfig(key, obj);
		}
		this.handleConfig("id", component.getClientId(context));
	}

	public Renderer getRenderer(FacesContext context) {
		String rendererType = ((UIComponent) component).getRendererType();
		String family = component.getFamily();

		Renderer result = null;
		if (rendererType != null) {
			result = context.getRenderKit().getRenderer(family, rendererType);
			if (null == result) {
			}
		} else {
			String id = component.getId();
			id = (null != id) ? id : this.getClass().getName();
		}
		if (result == null) {
			result = context.getRenderKit().getRenderer(COMPONENT_TYPE,COMPONENT_TYPE);
		}
		return result;
	}

	public void handleConfig(String name, Object value) {
		if (this.allConfig.containsKey(name)) {
			this.allConfig.get(name).setObj(value);
		} else {
			AttributeValue av = new AttributeValue(value);
			this.allConfig.put(name, av);
		}
	}

	public Map<String, AttributeValue> getAllConfig() {
		return allConfig;
	}
}
