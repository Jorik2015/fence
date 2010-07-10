package com.abner.fence.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.el.ValueExpression;

import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.abner.fence.annotation.ClientConfig;
import com.abner.fence.commons.AttributeValue;
import com.abner.fence.commons.ConfigArray;
import com.abner.fence.commons.ExtComponentMetaData;
import com.abner.fence.commons.Enums.ReferenceMode;
import com.abner.fence.component.ExtComponent;

public class ConfigUtils {
	private static Log log = LogFactory.getLog(ConfigUtils.class);

	@SuppressWarnings("unchecked")
	public static void appendConfig(ExtComponent from, ExtComponent to) {
		if (from == null || to == null)
			throw new IllegalArgumentException("the from and to arg can not be null.");

		String fromConfig = interpretConfig(from);
		JSONObject fromJson = JSONObject.fromObject(fromConfig);
		for (Iterator<String> iter = fromJson.keys(); iter.hasNext();) {
			String key = iter.next();
			if ("id".equalsIgnoreCase(key))
				continue;

			Object value = fromJson.get(key);
			to.handleConfig(key, value);
		}
	}

	public static void valueTo(String configName, Object configValue, ExtComponent self) {
		valueTo(configName, configValue, self, null);
	}

	public static void valueTo(String configName, Object configValue, ExtComponent self, ExtComponent toComp) {
		ExtComponent p = checkParent(self, toComp);
		if (configValue == null)
			return;
		String getMethodName = "get" + Strings.upperFirstChar(configName);
		String methodName = "set" + Strings.upperFirstChar(configName);
		Method m = ClassUtils.lookupMethod(p.getClass(), getMethodName);
		m = ClassUtils.lookupMethod(p.getClass(), methodName, new Class<?>[] { m.getReturnType() });
		if (m == null) {
			if (log.isWarnEnabled()) {
				log.warn("The component " + p + " with id (" + p.getId() + ") no config '" + configName + "',but the "
						+ self + " set a config to it");
			}
		} else {
			try {
				m.invoke(p, configValue);
			} catch (Exception e) {
				e.printStackTrace();
				if (log.isWarnEnabled()) {
					log.warn("The value set failed with component:" + p.getClass());
				}
			}
		}
	}

	public static void configToSelf(String configName, String configValue, ExtComponent self) {
		configTo(configName, configValue, null, self);
	}

	public static void configTo(String configName, String configValue, ExtComponent self) {
		String[] names = configName.split(",");
		for (String name : names) {
			configTo(name, configValue, self, null);
		}
	}

	public static void configTo(String configName, String configValue, ExtComponent self, ExtComponent toComp) {
		ExtComponent p = checkParent(self, toComp);
		AttributeValue oldConfigValue = p.getAllConfig().get(configName);
		// new
		String methodName = "get" + Strings.upperFirstChar(configName);

		if (log.isWarnEnabled()) {
			if (ClassUtils.lookupMethod(p.getClass(), methodName) == null)
				log.warn("The component " + p + " with id (" + p.getId() + ") no config '" + configName + "',but the "
						+ self + " set a config to it");
		}

		ClientConfig cc = ClassUtils.lookupAnno(p.getClass(), methodName, ClientConfig.class);
		if (cc == null) {
			p.handleConfig(configName, configValue);
		} else {
			switch (cc.value()) {
			case Array:
				if (oldConfigValue == null || oldConfigValue.isNull()) {
					p.handleConfig(configName, ConfigArray.getArray(configValue));
				} else {
					Object oldValue = oldConfigValue.getRawValue();
					ConfigArray array;
					if (oldValue instanceof ConfigArray)
						array = (ConfigArray) oldValue;
					else
						array = ConfigArray.getArray(oldValue);

					array.addConfig(configValue);

					p.handleConfig(configName, array);
				}
				break;
			default:
				p.handleConfig(configName, configValue);
				break;
			}
		}
	}

	private static ExtComponent checkParent(ExtComponent self, ExtComponent toComp) {
		if (self instanceof ExtComponent) {
			((ExtComponent) self).handleConfig("renderTo", null);
			((ExtComponent) self).handleConfig("applyTo", null);
		}

		ExtComponent parent = toComp;
		if (parent == null) {
			if (self == null)
				throw new IllegalArgumentException("The config component can not be null both from and to.");

			parent = (ExtComponent) self.getParent();
		}

		if (parent == null)
			throw new NullPointerException("The parent of " + self.getId() + " is null.");
		else if (!(parent instanceof ExtComponent))
			throw new IllegalArgumentException("the component " + self + " must used in Ext Component.");

		return ((ExtComponent) parent);
	}

	public static String interpretConfig(ExtComponent component) {
		if (!Strings.isEmpty(component.getRefer()))
			return component.getRefer();

		String result = "{";
		for (Map.Entry<String, AttributeValue> entry : component.getAllConfig().entrySet()) {
			String k = entry.getKey();
			ExtComponentMetaData metadata = ComponentUtils.getMetadata(component);
			if (metadata != null && metadata.getPmode() != null && metadata.getRmode() != null) {

				if ("id".equalsIgnoreCase(k) && !metadata.isId())
					continue;
			}

			AttributeValue v = entry.getValue();
			if (!Strings.isEmpty(k) && !v.isEmpty()) {
				String config = getConfig(k, v.getRawValue(), component);
				if (Strings.isEmpty(config))
					continue;

				if (result.length() > 1)
					result += ",";

				result += config;
			}
		}

		return result + "}";
	}

	private static String getConfig(String configName, Object value, ExtComponent comp) {
		AttributeValue v = null;
		String config = "";
		if (value instanceof AttributeValue)
			v = (AttributeValue) value;
		else {
			if (value instanceof ValueExpression) {
				value = ((ValueExpression) value).getValue(FacesUtils.context().getELContext());
			}
			v = new AttributeValue(value);
		}

		if (Strings.isEmpty(configName) || v.isEmpty())
			return "";

		String methodName = "get" + Strings.upperFirstChar(configName);
		ClientConfig cc = ClassUtils.lookupAnno(comp.getClass(), methodName, ClientConfig.class);
		if (cc != null && !Strings.isEmpty(cc.name())) {
			configName = cc.name();
		}

		if (v.getStringValue().startsWith(ExtUtils.PREFIX_RAW_VALUE)) {
			config = configName + ":" + v.getStringValue().substring(1);
		} else if (v.getRawValue() instanceof ConfigArray) {
			config = configName + ":" + ((ConfigArray) v.getRawValue()).getConfig();
		} else if (v.isBooleanValue()) {
			config = configName + ":" + v.getStringValue().toLowerCase();
		} else {
			boolean flag = false;
			Method method = ClassUtils.lookupMethod(comp.getClass(), methodName);
			if (method != null) {
				Class<?> returnType = method.getReturnType();
				if (Number.class.isAssignableFrom(returnType)) {
					config = configName + ":" + v.getRawValue();
					flag = true;
				}
			}

			if (!flag) {
				if (cc != null) {
					switch (cc.value()) {
					case Ignore:
						break;
					case Function:
						if (JSUtils.isFunction(v.getStringValue()))
							config = configName + ":" + v.getRawValue();
						else
							config = configName + ":" + new JSONFunction(v.getStringValue());
						break;
					case Raw:
						config = configName + ":" + v.getRawValue();
						break;
					case Object:
						if (ClassUtils.isRepresentsPrimitive(v.getRawValue().getClass())) {
							config = configName + ":" + v.getRawValue();
						} else if (v.getRawValue() instanceof String) {
							config = configName + ":" + v.getRawValue();
						} else {
							config = configName + ":" + JsonUtils.toJson(v.getRawValue());
						}
						break;
					case Array:
						Object rawValue = JsonUtils.getJSON(v.getRawValue());
						if (rawValue instanceof JSONArray) {
							config = configName + ":" + rawValue.toString();
						} else {
							config = configName + ": [" + rawValue.toString() + "]";
						}
						break;
					default:
						config = configName + ":" + "'" + v + "'";
						break;
					}
				} else {
					config = configName + ":" + "'" + v + "'";
				}
			}
		}
		return config;
	}

	private static String getConfigValue(String configName, Object value) {
		return getConfig(configName, value, null);
	}

	@SuppressWarnings("unchecked")
	public static String jsonConfig(Object obj) {
		String result = "";
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
		if (obj instanceof Collection) {
			result = "[";

			Iterator iterator = ((Collection) obj).iterator();
			while (iterator.hasNext()) {
				Object oo = iterator.next();
				result += jsonConfig(oo);
				if (iterator.hasNext())
					result += ",";
			}

			return result + "]";
		} else if (obj instanceof Map) {
			result = "{";
			for (Object entry : ((Map) obj).entrySet()) {
				Map.Entry oo = (Map.Entry) entry;
				if (result.length() > 1)
					result += ",";

				result += "'" + oo.getKey() + "':" + getConfigValue(oo.getKey().toString(), oo.getValue());
			}
			return result + "}";
		}
		result = "{";

		for (PropertyDescriptor pd : pds) {
			String k = pd.getName();
			if (k.equals("class"))
				continue;

			Object rawV = null;
			try {
				rawV = PropertyUtils.getSimpleProperty(obj, k);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error occur in read property:" + k);
			}
			AttributeValue v = new AttributeValue(rawV);
			String value = "";
			if (!Strings.isEmpty(k) && !v.isEmpty()) {
				if (result.length() > 1)
					result += ",";

				if (v.getRawValue() instanceof Collection || v.getRawValue() instanceof Map) {
					value = jsonConfig(v.getRawValue());
				} else {
					value = getConfigValue(k, v.getRawValue());
				}
				result += k + ":" + value;
			}
		}
		return result + "}";
	}

	public static String getRefence(ExtComponent comp, ReferenceMode refMode, String template) {
		switch (refMode) {
		case Var:
			return comp.getVar();
		case Config:
			return ConfigUtils.interpretConfig(comp);
		case Build:
			return buildInstanceWithTemplate(comp, template);
		case Name:
			return comp.getFamily();
		default:
			return "{}";
		}
	}

	public static String buildInstanceWithTemplate(ExtComponent comp, String template) {
		if (template == null)
			return "";

		ExtComponentMetaData metadata = ComponentUtils.getMetadata(comp);
		String instance = comp.getFamily();
		if (metadata != null && metadata.getInstanceOf() != null) {
			instance = metadata.getInstanceOf();
		}
		String var = comp.getVar();
		if (!Strings.isEmpty(comp.getNs())) {
			ExtUtils.ns(comp.getNs());
			var = comp.getNs() + "." + var;
		}

		String config = MessageFormat.format(template, var, instance, ConfigUtils.interpretConfig(comp));
		return config;
	}
}
