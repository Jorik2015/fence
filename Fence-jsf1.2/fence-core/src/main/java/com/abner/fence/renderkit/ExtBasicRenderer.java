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
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.render.Renderer;

import org.apache.commons.collections.MapUtils;

import com.abner.fence.resources.ScriptManager;
import com.abner.fence.util.AjaxJSUtils;
import com.abner.fence.util.ConfigHelper;
import com.abner.fence.util.Ext;
import com.abner.fence.util.JSUtils;

import ext.Window;
import ext.annotation.PersistenceMode;
import ext.annotation.ReferenceMode;
import ext.base.ExtComponentMetaData;
import ext.base.IExt;
import ext.form.ComboBox;
import ext.form.Field;
import ext.form.Hidden;
import ext.util.ComponentUtil;
import ext.util.FacesUtils;
import ext.util.StringUtil;
import ext.util.Utils;

/**
 * @author abner
 * 
 */
public class ExtBasicRenderer<T extends IExt> extends Renderer {
	private Map<String, String> tagAttributes;
	protected String containerId;

	@SuppressWarnings("unchecked")
	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		super.encodeBegin(context, component);

		this.tagAttributes = new HashMap<String, String>();
		containerId = component.getClientId(context) + Ext.SUFFIX_HTML_ID;

		IExt comp = (IExt) component;
		ExtComponentMetaData metadata = ComponentUtil.getMetadata(comp);
		if (metadata == null || metadata.isUi())
			comp.handleConfig("renderTo", this.getContainerId());

		beforeEncodeBegin(context, (T) comp);

		if (metadata == null || metadata.isUi()) {
			ResponseWriter writer = context.getResponseWriter();
			writer.startElement(this.getRenderHtmlTag(), (UIComponent) comp);
			writer.writeAttribute("id", containerId, "id");

			if (this.getRenderHtmlTag().equals(AjaxJSUtils.Input)) {
				writer.writeAttribute("name", containerId, "name");
				writer.writeAttribute("type", "hidden", "type");
			}

			if (!tagAttributes.isEmpty()) {
				for (Map.Entry<String, String> att : tagAttributes.entrySet()) {
					writer.writeAttribute(att.getKey(), att.getValue(), att.getKey());
				}
			}
		}

		this.afterEncodeBegin(context, (T) comp);

		ExtPluginRenderer.addPluginResources(comp);

		if (metadata != null) {
			String name = metadata.getRefName();
			if (metadata.getPmode() == PersistenceMode.InnerProperty) {
				List<UIComponent> childs = comp.getChildren();
				for (UIComponent child : childs) {
					if (!(child instanceof IExt))
						continue;

					if (child instanceof Window)
						continue;

					if (StringUtil.isEmpty(name)) {
						ConfigHelper.appendConfig(comp, (IExt) child);
					} else {
						String configValue = ConfigHelper.interpretConfig(comp);
						ConfigHelper.configTo(name, configValue, comp,(IExt) child);
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		super.encodeEnd(context, component);
		IExt comp = (IExt) component;

		this.beforeEncodeEnd(context, (T) comp);

		ExtComponentMetaData metadata = ComponentUtil.getMetadata(comp);

		// 此处决定组件的渲染方式，如果有元数据，则根据组件的元数据信息进行渲染
		if (metadata != null) {
			String name = metadata.getRefName();
			if (metadata.getPmode() == PersistenceMode.ParentProperty) {
				if (StringUtil.isEmpty(name))
					throw new IllegalArgumentException("The ParentProperty name can not be empty.");

				UIComponent parent = component.getParent();
				if (parent instanceof IExt) {
					comp.handleConfig("renderTo", null);
					String configValue = ConfigHelper.getRefence(comp, metadata
							.getRmode(), this.getStructureTemplate());
					ConfigHelper.configTo(name, configValue, comp);
				}
			}
		}

		this.afterEncodeEnd(context, (T) comp);

		if (metadata != null
				&& metadata.getPmode() == PersistenceMode.ParentProperty
				&& metadata.getRmode() == ReferenceMode.Config
				&& comp.getConfigValue("renderTo").getRawValue() != null) {
			throw new IllegalStateException("the component <" + comp + "> is meaningless.");
		}

		StringBuilder script = new StringBuilder(128);
		script.append(comp.getBeforeScript());
		if (metadata == null || metadata.getRmode() == ReferenceMode.Var) {
			JSUtils.getScriptReository().putGlobalVar(comp.getVar());
			script.append(this.buildInstanceWithTemplate(comp));
		}
		script.append(comp.getAfterScript());
		JSUtils.RegisterClientInitScript(script.toString());

		// 此处条件应该和encodeBegin中保持一致
		if (metadata == null || metadata.isUi()) {
			ResponseWriter writer = context.getResponseWriter();
			writer.endElement(this.getRenderHtmlTag());
			writer.write("\n");
		}
	}

	public void beforeEncodeBegin(FacesContext context, T component)
			throws IOException {
	}

	public void afterEncodeBegin(FacesContext context, T component)
			throws IOException {
	}

	public void beforeEncodeEnd(FacesContext context, T component)
			throws IOException {
	}

	public void afterEncodeEnd(FacesContext context, T component)
			throws IOException {
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		super.decode(context, component);

		if (!(component instanceof Field))
			return;

		if (!shouldDecode(component))
			return;

		Field field = (Field) component;

		String submitParamName = null;
		if (field instanceof ComboBox
				&& ((ComboBox) field).getHiddenName() != null) {
			submitParamName = ((ComboBox) field).getHiddenName();
		} else if (!StringUtil.isEmpty(field.getName()))
			submitParamName = field.getName();
		else
			submitParamName = field.getClientId(context);

		assert (submitParamName != null);

		Map<String, String> requestMap = context.getExternalContext()
				.getRequestParameterMap();
		// Don't overwrite the value unless you have to!
		String newValue = requestMap.get(submitParamName);
		if (newValue != null) {
			setSubmittedValue(component, newValue);
		}
	}

	protected String buildInstanceWithTemplate(IExt component) {
		return ConfigHelper.buildInstanceWithTemplate(component, this.getStructureTemplate());
	}

	protected void rendererParamsNotNull(FacesContext context,
			UIComponent component) {
		Utils.notNull("context", context);
		Utils.notNull("component", component);
	}

	public void appendScriptBefore(IExt comp, String script) {
		comp.getBeforeScript().append(script);
	}

	public void appendScriptAfter(IExt comp, String script) {
		comp.getAfterScript().append(script);
	}

	/**
	 * Renderers override this method to store the previous value of the
	 * associated component.
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
	 * @return the value to be rendered and formats it if required. Sets to
	 *         empty string if value is null.
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

	protected String getFormattedValue(FacesContext context,
			UIComponent component, Object currentValue)
			throws ConverterException {

		return getFormattedValue(context, component, currentValue, null);
	}

	/**
	 * Overloads getFormattedValue to take a advantage of a previously obtained
	 * converter.
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
	protected String getFormattedValue(FacesContext context,
			UIComponent component, Object currentValue, Converter converter)
			throws ConverterException {

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

	protected Iterator<?> getMessageIter(FacesContext context,
			String forComponent, UIComponent component) {

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
				UIComponent result = getForComponent(context, forComponent,
						component);
				if (result == null) {
					messageIter = Collections.EMPTY_LIST.iterator();
				} else {
					messageIter = context.getMessages(result
							.getClientId(context));
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
	 * @return the component with the the <code>id</code that matches
	 *         <code>forComponent</code> otheriwse null if no match is found.
	 */
	protected UIComponent getForComponent(FacesContext context,
			String forComponent, UIComponent component) {

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
				result = findUIComponentBelow(context.getViewRoot(),
						forComponent);
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

	private static UIComponent findUIComponentBelow(UIComponent startPoint,
			String forComponent) {

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

	public Map<String, String> getTagAttributes() {
		return tagAttributes;
	}

	protected String getRenderHtmlTag() {
		return (AjaxJSUtils.Div);
	}

	public String getContainerId() {
		return containerId;
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
     * @param command the command which may have parameters
     *
     * @return an array of parameters
     */
    @SuppressWarnings("unchecked")
	public static Map<String,Object> getParamList(UIComponent command,boolean includeHidden) {
        if (command.getChildCount() > 0) {
        	Map<String,Object> parameterList = new HashMap<String,Object>();
            for (UIComponent kid : command.getChildren()) {
                if (kid instanceof UIParameter) {
                    UIParameter uiParam = (UIParameter) kid;
                    Object value = uiParam.getValue();
                    parameterList.put(uiParam.getName(), value);
                }
                if(includeHidden && kid instanceof Hidden){
                	Hidden hidden = (Hidden)kid;
                	String name = hidden.getName();
    				name = name == null ? hidden.getClientId(FacesUtils.context()) : name;
    				parameterList.put(hidden.getName(), Ext.PREFIX_RAW_VALUE	+ hidden.getVar() + ".getValue()");
                }
            }
            return parameterList;
        } else {
            return MapUtils.EMPTY_MAP;
        }
    }
    public static Map<String,Object> getParamList(UIComponent command){
    	return getParamList(command,false);
    }
}
