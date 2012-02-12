package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.abner.fence.component.ExtComponent;
import com.abner.fence.component.ExtInput;
import com.abner.fence.utils.ComponentUtils;
import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.web.ExtFacesMessage;

import ext.Toolbar;
import ext.form.Checkbox;
import ext.form.CheckboxGroup;
import ext.form.Field;
import ext.form.FieldSet;
import ext.form.FormPanel;
import ext.form.RadioGroup;
import ext.grid.Column;

public class ExtInputRenderer extends ExtBasicRenderer<ExtInput> {

	@Override
	public void beforeEncodeBegin(FacesContext context, ExtInput component) throws IOException {
		String configTo = null;
		ExtComponent toComp = null;

		FormPanel form = ComponentUtils.inNested(FormPanel.class, component);
		if (form != null) {
			configTo = "items";
			toComp = form;
		}

		FieldSet fieldSet = ComponentUtils.inNested(FieldSet.class, component);
		if (fieldSet != null) {
			configTo = "items";
			toComp = fieldSet;
		}

		Toolbar tb = ComponentUtils.inNested(Toolbar.class, component, true);
		if (tb != null) {
			configTo = "items";
			toComp = tb;
		}

		CheckboxGroup chkGroup = ComponentUtils.inNested(CheckboxGroup.class, component);
		if (chkGroup != null) {
			configTo = "items";
			toComp = chkGroup;
		}
		RadioGroup radGroup = ComponentUtils.inNested(RadioGroup.class, component);
		if (radGroup != null) {
			configTo = "items";
			toComp = radGroup;
		}

		Column col = ComponentUtils.inNested(Column.class, component, true);
		if (col != null) {
			configTo = "editor";
			toComp = col;
		}

		if (configTo != null)
			ConfigUtils.configTo(configTo, component.getVar(), component, toComp);
	}

	@Override
	public void beforeEncodeEnd(FacesContext context, ExtInput component) throws IOException {
		super.beforeEncodeEnd(context, component);
		//for checkbox ,we can use a converter
		String value = getCurrentValue(context, (UIComponent) component);
		component.handleConfig("value", value);
		if(component instanceof Checkbox){
			component.handleConfig("checked","true".equals(value));
		}
	}

	@Override
	public void afterEncodeEnd(FacesContext context, ExtInput component) throws IOException {
		Iterator<?> messageIter = getMessageIter(context, component.getClientId(context), component);
		if (messageIter.hasNext()) {
			FacesMessage curMessage = (FacesMessage) messageIter.next();
			// 给form加上验证提示信息
			if (curMessage instanceof ExtFacesMessage) {
				ExtFacesMessage emsg = (ExtFacesMessage) curMessage;
				String script = emsg.getCompId() + ".markInvalid(\"" + emsg.getSummary() + "\");";
				JSUtils.RegisterAfterClientInitScript(script);
			}
		}
	}

	private boolean hasStringConverter = false;
	private boolean hasStringConverterSet = false;

	// ---------------------------------------------------------- Public Methods
	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue)
			throws ConverterException {

		String newValue = (String) submittedValue;
		// if we have no local value, try to get the valueExpression.
		ValueExpression valueExpression = component.getValueExpression("value");

		// 支持解释form的model属性
		if (valueExpression == null && component instanceof Field) {
			Field field = (Field) component;
			valueExpression = field.getFormValueExpression(context);
		}

		Converter converter = null;

		// If there is a converter attribute, use it to to ask application
		// instance for a converter with this identifer.
		if (component instanceof ValueHolder) {
			converter = ((ValueHolder) component).getConverter();
		}

		if (null == converter && null != valueExpression) {
			Class<?> converterType = valueExpression.getType(context.getELContext());
			// if converterType is null, assume the modelType is "String".
			if (converterType == null || converterType == Object.class)
				return newValue;

			// If the converterType is a String, and we don't have a
			// converter-for-class for java.lang.String, assume the type is
			// "String".
			if (converterType == String.class && !hasStringConverter(context))
				return newValue;
			// if getType returns a type for which we support a default
			// conversion, acquire an appropriate converter instance.

			try {
				Application application = context.getApplication();
				converter = application.createConverter(converterType);
			} catch (Exception e) {
				return (null);
			}
		} else if (converter == null) {
			return newValue;
		}

		if (converter != null) {
			// If the conversion eventually falls to needing to use EL type
			// coercion,
			// make sure our special ConverterPropertyEditor knows about this
			// value.
			// Map<String, Object> requestMap =
			// context.getExternalContext().getRequestMap();
			// TODO
			// requestMap.put(FieldRenderer.TARGET_COMPONENT_ATTRIBUTE_NAME,
			// component);
			return converter.getAsObject(context, component, newValue);
		} else {
			// throw converter exception.
			Object[] params = { newValue, "null Converter" };

			throw new ConverterException("convert error :" + params);
		}
	}

	@Override
	public void setSubmittedValue(UIComponent component, Object value) {
		if (component instanceof Field) {
			((Field) component).setSubmittedValue(value);
		}
	}

	// ------------------------------------------------------- Protected Methods

	@Override
	protected Object getValue(UIComponent component) {
		if (component instanceof Field) {
			Field extField = (Field) component;
			// 此处加上支持formpanel的model属性支持.
			ValueExpression ve = component.getValueExpression("value");
			// 自身表达式优先
			if (ve != null) {
				return extField.getValue();
			} else {
				ValueExpression formVe = extField.getFormValueExpression(FacesUtils.context());

				if (formVe != null)
					return formVe.getValue(FacesUtils.context().getELContext());

				return null;
			}
		}

		return null;
	}

	// --------------------------------------------------------- Private Methods

	private boolean hasStringConverter(FacesContext context) {
		if (!hasStringConverterSet) {
			hasStringConverter = (null != context.getApplication().createConverter(String.class));
			hasStringConverterSet = true;
		}
		return hasStringConverter;
	}
}
