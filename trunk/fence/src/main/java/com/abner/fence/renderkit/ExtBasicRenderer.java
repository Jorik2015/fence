package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.ValueHolder;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.render.Renderer;

import org.apache.commons.collections.MapUtils;

import com.abner.fence.commons.ExtComponentMetaData;
import com.abner.fence.commons.Enums.PersistenceMode;
import com.abner.fence.commons.Enums.ReferenceMode;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.component.ScriptManager;
import com.abner.fence.utils.AjaxJSUtils;
import com.abner.fence.utils.ComponentUtils;
import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.RenderKitUtils;
import com.abner.fence.utils.Strings;
import com.abner.fence.utils.Utils;

import ext.Window;
import ext.form.Checkbox;
import ext.form.ComboBox;
import ext.form.Field;
import ext.form.Hidden;

/**
 * @author abner
 * 
 */
public class ExtBasicRenderer<T extends ExtComponent> extends Renderer {
	private Map<String, String> tagAttributes;
	protected String containerId;
	
	public static final String RENDER_SCRIPT = "RENDER_SCRIPT";

	@SuppressWarnings("unchecked")
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		super.encodeBegin(context, component);

		ExtComponent comp = (ExtComponent) component;
		ExtComponentMetaData metadata = ComponentUtils.getMetadata(comp);
		if (metadata == null || metadata.isUi())
			comp.handleConfig("renderTo", comp.getContainerId());

		beforeEncodeBegin(context, (T) comp);

		if (metadata != null) {
			String name = metadata.getRefName();
			if (metadata.getPmode() == PersistenceMode.InnerProperty) {
				List<UIComponent> childs = comp.getChildren();
				for (UIComponent child : childs) {
					if (!(child instanceof ExtComponent))
						continue;

					if (child instanceof Window)
						continue;

					if (Strings.isEmpty(name)) {
						ConfigUtils.appendConfig(comp, (ExtComponent) child);
					} else {
						String configValue = ConfigUtils.interpretConfig(comp);
						ConfigUtils.configTo(name, configValue, comp, (ExtComponent) child);
					}
				}
			}
		}
		RenderKitUtils.renderBehaviors(context, (ExtComponent) component);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		super.encodeEnd(context, component);
		ExtComponent comp = (ExtComponent) component;

		this.beforeEncodeEnd(context, (T) comp);

		ExtComponentMetaData metadata = ComponentUtils.getMetadata(comp);

		// 此处决定组件的渲染方式，如果有元数据，则根据组件的元数据信息进行渲染
		if (metadata != null) {
			String name = metadata.getRefName();
			if (metadata.getPmode() == PersistenceMode.ParentProperty) {
				if (Strings.isEmpty(name))
					throw new IllegalArgumentException("The ParentProperty name can not be empty.");

				UIComponent parent = component.getParent();
				if (parent instanceof ExtComponent) {
					comp.handleConfig("renderTo", null);
					String configValue = ConfigUtils.getRefence(comp, metadata.getRmode(), this.getStructureTemplate());
					ConfigUtils.configTo(name, configValue, comp);
				}
			}
		}

		this.afterEncodeEnd(context, (T) comp);

		if (metadata != null && metadata.getPmode() == PersistenceMode.ParentProperty
				&& metadata.getRmode() == ReferenceMode.Config && comp.getConfigValue("renderTo").getRawValue() != null) {
			throw new IllegalStateException("the component <" + comp + "> is meaningless.");
		}
		StringBuilder script = new StringBuilder(128);
		script.append(comp.getBeforeScript());
		if (needRenderScript(comp) && (metadata == null || metadata.getRmode() == ReferenceMode.Var)) {
			JSUtils.getScriptReository().putGlobalVar(comp.getVar());
			script.append(this.buildInstanceWithTemplate(comp));

			if (!Strings.isEmpty(comp.getRefer()) && comp.getConfig("renderTo") != null) {
				script.append(comp.getVar() + ".render('" + comp.getContainerId() + "');");
			}
		}
		script.append(comp.getAfterScript());
		JSUtils.RegisterClientInitScript(script.toString());
	}

	protected boolean needRenderScript(ExtComponent comp) {
		Object obj = comp.getAttributes().get(RENDER_SCRIPT);
		if (obj != null && "false".equals(obj))
			return false;

		return true;
	}

	protected void getEndTextToRender(FacesContext context, UIComponent component, String currentValue)
			throws IOException {
	}

	public void beforeEncodeBegin(FacesContext context, T component) throws IOException {
	}

	public void beforeEncodeEnd(FacesContext context, T component) throws IOException {
	}

	public void afterEncodeEnd(FacesContext context, T component) throws IOException {
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		super.decode(context, component);

		if (!(component instanceof Field))
			return;

		if (!shouldDecode(component))
			return;

		String clientId = decodeBehaviors(context, component);
		if (clientId == null) {
			clientId = component.getClientId(context);
		}

		assert (clientId != null);

		Field field = (Field) component;

		String submitParamName = clientId;
		if (field instanceof ComboBox && ((ComboBox) field).getHiddenName() != null) {
			submitParamName = ((ComboBox) field).getHiddenName();
		} else if (!Strings.isEmpty(field.getName()))
			submitParamName = field.getName();
		else
			submitParamName = clientId;

		assert (submitParamName != null);

		Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
		// Don't overwrite the value unless you have to!
		String newValue = requestMap.get(submitParamName);
		if(field instanceof Checkbox){
			//note:don't set not string value,the value is always String from client form
			if("on".equals(newValue) || "true".equals(newValue))
				setSubmittedValue(component,"true");
			else
				setSubmittedValue(component, "false");
		}else if (newValue != null) {
			setSubmittedValue(component, newValue);
		}
	}

	// Decodes Behaviors if any match the behavior source/event.
	// As a convenience, returns component id, but only if it
	// was retrieved. This allows us to avoid duplicating
	// calls to getClientId(), which can be expensive for
	// deep component trees.
	protected final String decodeBehaviors(FacesContext context, UIComponent component) {

		if (!(component instanceof ClientBehaviorHolder)) {
			return null;
		}

		ClientBehaviorHolder holder = (ClientBehaviorHolder) component;
		Map<String, List<ClientBehavior>> behaviors = holder.getClientBehaviors();
		if (behaviors.isEmpty()) {
			return null;
		}

		ExternalContext external = context.getExternalContext();
		Map<String, String> params = external.getRequestParameterMap();
		String behaviorEvent = params.get("javax.faces.behavior.event");

		if (null != behaviorEvent) {
			List<ClientBehavior> behaviorsForEvent = behaviors.get(behaviorEvent);

			if (behaviors.size() > 0) {
				String behaviorSource = params.get("javax.faces.source");
				String clientId = component.getClientId();
				if (isBehaviorSource(context, behaviorSource, clientId)) {
					for (ClientBehavior behavior : behaviorsForEvent) {
						behavior.decode(context, component);
					}
				}

				return clientId;
			}
		}

		return null;
	}

	/**
	 * @param ctx
	 *            the <code>FacesContext</code> for the current request
	 * @param behaviorSourceId
	 *            the ID of the behavior source
	 * @param componentClientId
	 *            the client ID of the component being decoded
	 * @return <code>true</code> if the behavior source is for the component being decoded, otherwise <code>false</code>
	 */
	protected boolean isBehaviorSource(FacesContext ctx, String behaviorSourceId, String componentClientId) {

		return (behaviorSourceId != null && behaviorSourceId.equals(componentClientId));

	}

	protected String buildInstanceWithTemplate(ExtComponent component) {
		return ConfigUtils.buildInstanceWithTemplate(component, this.getStructureTemplate());
	}

	protected void rendererParamsNotNull(FacesContext context, UIComponent component) {
		Utils.notNull("context", context);
		Utils.notNull("component", component);
	}

	public void appendScriptBefore(ExtComponent comp, String script) {
		comp.getBeforeScript().append(script);
	}

	public void appendScriptAfter(ExtComponent comp, String script) {
		comp.getAfterScript().append(script);
	}

	/**
	 * Renderers override this method to store the previous value of the associated component.
	 * 
	 * @param component
	 *            the target component to which the submitted value will be set
	 * @param value
	 *            the value to set
	 */
	protected void setSubmittedValue(UIComponent component, Object value) {
		// no-op unless overridden
	}

	protected Object getValue(UIComponent component) {
		// Make sure this method isn't being called except
		// from subclasses that override getValue()!
		throw new UnsupportedOperationException();
	}

	/**
	 * @param context
	 *            the FacesContext for the current request
	 * @param component
	 *            the UIComponent whose value we're interested in
	 * 
	 * @return the value to be rendered and formats it if required. Sets to empty string if value is null.
	 */
	protected String getCurrentValue(FacesContext context, UIComponent component) {

		if (component instanceof Field) {
			Object submittedValue = ((Field) component).getSubmittedValue();
			if (submittedValue != null) {
				return (String) submittedValue;
			}
		}

		String currentValue = null;
		Object currentObj = getValue(component);
		if (currentObj != null) {
			currentValue = getFormattedValue(context, component, currentObj);
		}
		return currentValue;

	}

	protected String getFormattedValue(FacesContext context, UIComponent component, Object currentValue)
			throws ConverterException {

		return getFormattedValue(context, component, currentValue, null);
	}

	/**
	 * Overloads getFormattedValue to take a advantage of a previously obtained converter.
	 * 
	 * @param context
	 *            the FacesContext for the current request
	 * @param component
	 *            UIComponent of interest
	 * @param currentValue
	 *            the current value of <code>component</code>
	 * @param converter
	 *            the component's converter
	 * @return the currentValue after any associated Converter has been applied
	 * 
	 * @throws ConverterException
	 *             if the value cannot be converted
	 */
	protected String getFormattedValue(FacesContext context, UIComponent component, Object currentValue,
			Converter converter) throws ConverterException {

		// formatting is supported only for components that support
		// converting value attributes.
		if (!(component instanceof ValueHolder)) {
			if (currentValue != null) {
				return currentValue.toString();
			}
			return null;
		}

		if (converter == null) {
			// If there is a converter attribute, use it to to ask application
			// instance for a converter with this identifer.
			converter = ((ValueHolder) component).getConverter();
		}

		if (converter == null) {
			// if value is null and no converter attribute is specified, then
			// return a zero length String.
			if (currentValue == null) {
				return "";
			}
			// Do not look for "by-type" converters for Strings
			if (currentValue instanceof String) {
				return (String) currentValue;
			}

			// if converter attribute set, try to acquire a converter
			// using its class type.

			Class<? extends Object> converterType = currentValue.getClass();
			converter = Utils.getConverterForClass(converterType, context);

			// if there is no default converter available for this identifier,
			// assume the model type to be String.
			if (converter == null) {
				return currentValue.toString();
			}
		}

		return converter.getAsString(context, component, currentValue);
	}

	protected Iterator<?> getMessageIter(FacesContext context, String forComponent, UIComponent component) {

		Iterator<?> messageIter;
		// Attempt to use the "for" attribute to locate
		// messages. Three possible scenarios here:
		// 1. valid "for" attribute - messages returned
		// for valid component identified by "for" expression.
		// 2. zero length "for" expression - global errors
		// not associated with any component returned
		// 3. no "for" expression - all messages returned.
		if (null != forComponent) {
			if (forComponent.length() == 0) {
				messageIter = context.getMessages(null);
			} else {
				UIComponent result = getForComponent(context, forComponent, component);
				if (result == null) {
					messageIter = Collections.EMPTY_LIST.iterator();
				} else {
					messageIter = context.getMessages(result.getClientId(context));
				}
			}
		} else {
			messageIter = context.getMessages();
		}
		return messageIter;
	}

	/**
	 * Locates the component identified by <code>forComponent</code>
	 * 
	 * @param context
	 *            the FacesContext for the current request
	 * @param forComponent
	 *            - the component to search for
	 * @param component
	 *            - the starting point in which to begin the search
	 * 
	 * @return the component with the the <code>id</code that matches <code>forComponent</code> otheriwse null if no
	 *         match is found.
	 */
	protected UIComponent getForComponent(FacesContext context, String forComponent, UIComponent component) {

		if (null == forComponent || forComponent.length() == 0) {
			return null;
		}

		UIComponent result = null;
		UIComponent currentParent = component;
		try {
			// Check the naming container of the current
			// component for component identified by
			// 'forComponent'
			while (currentParent != null) {
				// If the current component is a NamingContainer,
				// see if it contains what we're looking for.
				result = currentParent.findComponent(forComponent);
				if (result != null) {
					break;
				}
				// if not, start checking further up in the view
				currentParent = currentParent.getParent();
			}

			// no hit from above, scan for a NamingContainer
			// that contains the component we're looking for from the root.
			if (result == null) {
				result = findUIComponentBelow(context.getViewRoot(), forComponent);
			}
		} catch (Exception e) {
			// ignore - log the warning
		}
		// log a message if we were unable to find the specified
		// component (probably a misconfigured 'for' attribute
		if (result == null) {
		}
		return result;

	}

	private static UIComponent findUIComponentBelow(UIComponent startPoint, String forComponent) {

		UIComponent retComp = null;
		if (startPoint.getChildCount() > 0) {
			List<UIComponent> children = startPoint.getChildren();
			for (int i = 0, size = children.size(); i < size; i++) {
				UIComponent comp = children.get(i);

				if (comp instanceof NamingContainer) {
					try {
						retComp = comp.findComponent(forComponent);
					} catch (IllegalArgumentException iae) {
						continue;
					}
				}

				if (retComp == null) {
					if (comp.getChildCount() > 0) {
						retComp = findUIComponentBelow(comp, forComponent);
					}
				}

				if (retComp != null) {
					break;
				}
			}
		}
		return retComp;

	}

	public String getUITag(ExtComponent comp) {
		ExtComponentMetaData metadata = ComponentUtils.getMetadata(comp);
		if (metadata != null && !metadata.isUi())
			return AjaxJSUtils.Span;

		return this.getRenderHtmlTag();
	}

	public Map<String, String> getTagAttributes() {
		return tagAttributes;
	}

	protected String getRenderHtmlTag() {
		return (AjaxJSUtils.Div);
	}

	public String getStructureTemplate() {
		return ScriptManager.NewComponentTemp;
	}

	protected boolean shouldEncode(UIComponent component) {
		if (!component.isRendered()) {
			return false;
		}
		return true;
	}

	protected boolean shouldDecode(UIComponent component) {
		if (Utils.componentIsDisabledOrReadonly(component)) {
			return false;
		}
		return true;
	}

	protected boolean shouldEncodeChildren(UIComponent component) {
		if (!component.isRendered()) {
			return false;
		}
		return true;
	}

	public static class Param {
		public String name;
		public String value;

		public Param(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	/**
	 * @param command
	 *            the command which may have parameters
	 * 
	 * @return an array of parameters
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getParamList(UIComponent command, boolean includeHidden) {
		if (command.getChildCount() > 0) {
			Map<String, Object> parameterList = new HashMap<String, Object>();
			for (UIComponent kid : command.getChildren()) {
				if (kid instanceof UIParameter) {
					UIParameter uiParam = (UIParameter) kid;
					Object value = uiParam.getValue();
					parameterList.put(uiParam.getName(), value);
				}
				if (includeHidden && kid instanceof Hidden) {
					Hidden hidden = (Hidden) kid;
					String name = hidden.getName();
					name = name == null ? hidden.getClientId(FacesUtils.context()) : name;
					parameterList.put(name, ExtUtils.PREFIX_RAW_VALUE + hidden.getVar() + ".getValue()");
				}
			}
			return parameterList;
		} else {
			return MapUtils.EMPTY_MAP;
		}
	}

	public static Map<String, Object> getParamList(UIComponent command) {
		return getParamList(command, false);
	}
}
