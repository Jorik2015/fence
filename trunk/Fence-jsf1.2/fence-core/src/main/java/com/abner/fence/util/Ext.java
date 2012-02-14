package com.abner.fence.util;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;

import ext.base.IExt;
import ext.util.ClassUtils;
import ext.util.DateJsonValueProcessor;
import ext.util.ELUtils;
import ext.util.FacesUtils;
import ext.util.JsonUtils;
import ext.util.StringUtil;

public class Ext {
	public static final String VERSION = "310";
	public static final String NULL = null;
	public static final String PREFIX_RAW_VALUE = "@";
	public static final String SUFFIX_HTML_ID = "_html";
	public static final String SUFFIX_CONTENT_ID = "_content";

	public static void applyConfig(IExt toComp, Object config) {
		if (toComp == null || config == null)
			return;

		JSONObject configJson = (JSONObject) JsonUtils.getJSON(config);
		for (Iterator<?> keys = configJson.keys(); keys.hasNext();) {
			String key = (String) keys.next();
			Object value = configJson.get(key);
			if(ELUtils.isEL(value.toString())){
				value = ELUtils.evaluate(FacesUtils.context(),value.toString());
			}
			if(key == null || value == null)
				continue;
			
			toComp.handleConfig(key, value);
		}
	}

	public static JSONObject apply(Object obj, Object config) {
		return apply(obj, config, true);
	}

	public static JSONObject applyIf(Object obj, Object config) {
		return apply(obj, config, false);
	}

	public static Object applyBean(Object bean, Object config) {
		if (bean == null)
			throw new NullPointerException("bean");

		JSONObject configJson = (JSONObject) JsonUtils.getJSON(config);

		// note:this tobean can't process the date;
		Object jsonBean = JSONObject.toBean(configJson, bean.getClass());
		for (Iterator<?> keys = configJson.keys(); keys.hasNext();) {
			String key = (String) keys.next();
			Object value = configJson.get(key);
			try {
				Class<?> clazz = PropertyUtils.getPropertyType(bean, key);
				if (clazz.isPrimitive()
						|| ClassUtils.isRepresentsPrimitive(clazz)
						|| clazz.equals(String.class)) {

					value = PropertyUtils.getProperty(jsonBean, key);
					PropertyUtils.setProperty(bean, key, value);
				} else if (ClassUtils.isDate(clazz)) {
					if (StringUtil.isEmpty(value)) {
						PropertyUtils.setProperty(bean, key, value);
						continue;
					} else {// for ext json date
						if (value instanceof String) {
							value = value.toString().replace('T', ' ');
							SimpleDateFormat df = new SimpleDateFormat(
									DateJsonValueProcessor.DEFAULT_PATTERN);
							java.util.Date date = null;
							try {
								date = df.parse(value.toString());
							} catch (ParseException e) {
								throw new RuntimeException(e);
							}
							if (clazz.equals(java.sql.Date.class)) {
								PropertyUtils.setProperty(bean, key,
										new java.sql.Date(date.getTime()));
							} else {
								PropertyUtils.setProperty(bean, key, date);
							}
						}
					}
				} else {
					value = PropertyUtils.getProperty(jsonBean, key);
					// TODO if the prop is array or interface ...
					if (StringUtil.isEmpty(value))
						continue;

					Object origPropValue = PropertyUtils.getProperty(bean, key);
					if (origPropValue == null) {
						try {
							origPropValue = clazz.newInstance();
						} catch (InstantiationException e) {
							e.printStackTrace();
						}
					}
					applyBean(origPropValue, value);
					PropertyUtils
							.setProperty(bean, (String) key, origPropValue);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException(
						"The store bean can write with some property.");
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
		}
		return bean;
	}

	@SuppressWarnings("unchecked")
	private static JSONObject apply(Object obj, Object config, boolean replace) {
		JSONObject json = (JSONObject) JsonUtils.getJSON(obj);
		JSONObject configJson = (JSONObject) JsonUtils.getJSON(config);

		if (json == null || configJson == null)
			return null;

		for (Iterator keys = configJson.keys(); keys.hasNext();) {
			Object key = keys.next();
			if (json.containsKey(key) && !replace)
				continue;

			json.put(key, configJson.get(key));
		}
		return json;
	}

	public static void ns(String... nss) {
		for (String ns : nss) {
			JSUtils.RegisterClientInitScript("Ext.ns('" + ns + "')");
		}
	}
}
