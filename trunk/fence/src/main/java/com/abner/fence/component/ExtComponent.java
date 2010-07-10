package com.abner.fence.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.abner.fence.annotation.XType;
import com.abner.fence.commons.AttributeValue;
import com.abner.fence.renderkit.ExtBasicRenderer;
import com.abner.fence.utils.AjaxJSUtils;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.Strings;

@FacesComponent("Ext.ExtComponent")
public class ExtComponent extends UIOutput implements ClientBehaviorHolder {
	private final Map<String, AttributeValue> allConfig = new HashMap<String, AttributeValue>();
	public static final String COMPONENT_TYPE = "Ext.ExtComponent";
	private StringBuilder beforeScript;
	private StringBuilder afterScript;

	enum PropertyKeys {
		var, refer, ns, containerId;
		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((toString != null) ? toString : super.toString());
		}
	}

	public ExtComponent() {
		super();
		init();
		setRendererType(COMPONENT_TYPE);
	}

	private void init() {
		XType xtype = this.getClass().getAnnotation(XType.class);
		if (xtype != null) {
			if (Strings.isEmpty(xtype.value()))
				throw new IllegalArgumentException("The XType annotation value can not be empty.");

			this.handleConfig("xtype", xtype.value());
		}
	}

	@Override
	public String getFamily() {
		return (COMPONENT_TYPE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void encodeAll(FacesContext context) throws IOException {
		this.handleConfig("id", this.getClientId(context));

		Map<String, Object> atts = this.getAttributes();
		for (Map.Entry<String, Object> entry : atts.entrySet()) {
			String key = entry.getKey();
			Object obj = entry.getValue();
			if (key.endsWith("MARK_ID"))
				continue;

			if (key.endsWith("APPLIED"))
				continue;

			if (key.endsWith("VIEW_LOCATION_KEY"))
				continue;

			if (key.endsWith("DYNAMIC_COMPONENT"))
				continue;

			this.handleConfig(key, obj);
		}

		Renderer render = this.getRenderer(context);
		if (render instanceof ExtBasicRenderer) {
			ExtBasicRenderer extRender = (ExtBasicRenderer) render;
			String tag = extRender.getUITag(this);
			String containerId = getContainerId();
			ResponseWriter writer = context.getResponseWriter();
			writer.startElement(tag, this);
			writer.writeAttribute("id", containerId, "id");

			if (tag.equals(AjaxJSUtils.Input)) {
				writer.writeAttribute("name", containerId, "name");
				writer.writeAttribute("type", "hidden", "type");
			}

			super.encodeAll(context);

			writer.endElement(tag);
		} else {
			super.encodeAll(context);
		}
	}

	@Override
	public void setValueExpression(String name, ValueExpression binding) {
		super.setValueExpression(name, binding);
		this.handleAttribute(name, binding);
	}

	@Override
	public Renderer getRenderer(FacesContext context) {
		Renderer result = super.getRenderer(context);
		if (result != null)
			return result;

		String rendererType = this.getRendererType();
		String family = this.getFamily();

		if (rendererType != null)
			result = context.getRenderKit().getRenderer(family, rendererType);
		if (result == null)
			result = context.getRenderKit().getRenderer(COMPONENT_TYPE, COMPONENT_TYPE);

		return result;
	}

	public String getVar() {
		Object var = this.getStateHelper().eval(PropertyKeys.var, this.getClientId());
		return (String) var;
	}

	public void setVar(String var) {
		getStateHelper().put(PropertyKeys.var, var);
	}

	public String getRefer() {
		return (String) this.getStateHelper().eval(PropertyKeys.refer);
	}

	public void setRefer(String refer) {
		getStateHelper().put(PropertyKeys.refer, refer);
	}

	public String getNs() {
		Object ns = this.getStateHelper().eval(PropertyKeys.ns);
		UIComponent parent = this.getParent();
		if (parent instanceof ExtComponent) {
			String pns = ((ExtComponent) parent).getNs();
			if (Strings.isEmpty(ns))
				return pns;
			else if (Strings.isEmpty(pns)) {
				return (String) ns;
			} else {
				return pns + "." + ns;
			}
		}
		return (String) ns;
	}

	public void setNs(String ns) {
		getStateHelper().put(PropertyKeys.ns, ns);
	}

	public String getContainerId() {
		Object containerId = this.getStateHelper().eval(PropertyKeys.containerId,
				this.getClientId() + ExtUtils.SUFFIX_HTML_ID);
		return (String) containerId;
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

	public void handleConfig(String name, Object value) {
		if (this.allConfig.containsKey(name)) {
			this.allConfig.get(name).setObj(value);
		} else {
			AttributeValue av = new AttributeValue(value);
			this.allConfig.put(name, av);
		}
	}

	public AttributeValue getConfigValue(String key) {
		return getAllConfig().get(key);
	}

	public Object getConfig(String key) {
		AttributeValue av = this.getConfigValue(key);
		if (av != null)
			return av.getRawValue();

		return null;
	}

	public Map<String, AttributeValue> getAllConfig() {
		return allConfig;
	}

	protected void handleAttribute(String name, Object value) {
		this.handleConfig(name, value);
	}

	private static final Collection<String> EVENT_NAMES = new ArrayList<String>();

	public Collection<String> getEventNames() {
		return EVENT_NAMES;
	}

	public String getDefaultEventName() {
		return "action";
	}
}
