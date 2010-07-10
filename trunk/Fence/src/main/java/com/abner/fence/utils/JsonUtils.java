package com.abner.fence.utils;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONUtils;

import com.abner.fence.commons.DateJsonValueProcessor;

public class JsonUtils {

	public static final String EMPTY_JSON = "{}";

	public static JSON getJSON(Object obj) {
		return getJSON(obj, null);
	}

	public static JSON getJSON(Object obj, JsonConfig cfg) {
		if (obj instanceof JSON)
			return (JSON) obj;
		
		if(obj == null)
			return new JSONObject();

		if (cfg == null)
			cfg = new JsonConfig();

		JSON jsonObj;
		if (obj instanceof Enum<?> || JSONUtils.isArray(obj)
				|| (obj instanceof String && obj.toString().startsWith("["))) {
			jsonObj = JSONArray.fromObject(obj, cfg);
		} else if (obj instanceof String || obj instanceof Character) {
			if (JSONUtils.mayBeJSON(obj.toString())) {
				if (obj.toString().startsWith("["))
					jsonObj = JSONArray.fromObject(obj, cfg);
				else
					jsonObj = JSONObject.fromObject(obj, cfg);
			} else {
				jsonObj = JSONObject.fromObject("{value:'" + obj + "'}", cfg);
			}
		} else if (ClassUtils.isRepresentsPrimitive(obj.getClass())) {
			jsonObj = JSONObject.fromObject("{value:" + obj + "}", cfg);
		} else {
			jsonObj = JSONObject.fromObject(obj, cfg);
		}

		return jsonObj;
	}

	public static JSONArray getJSONArray(Object obj) {
		JSON json = getJSON(obj);
		if (json instanceof JSONArray)
			return (JSONArray) json;
		else if (json instanceof JSONObject) {
			JSONArray jsonArray = new JSONArray();
			jsonArray.add(json);
			return jsonArray;
		}
		return new JSONArray();
	}

	public static String toJson(Object obj) {
		return getJSON(obj).toString();
	}

	public static String toJson(Object obj, JsonConfig cfg) {
		return getJSON(obj, cfg).toString();
	}

	public static JsonConfig getDateJsonConfig() {
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
		cfg.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor());
		return cfg;
	}

	public static JsonConfig getDateJsonConfig(String pattern) {
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(pattern));
		cfg.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor(pattern));
		return cfg;
	}

	public static JsonConfig getFilterConfig(String... excludes) {
		JsonConfig cfg = new JsonConfig();
		cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		cfg.setExcludes(excludes);

		return cfg;
	}
}
