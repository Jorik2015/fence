package com.abner.fence.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;

import org.apache.commons.lang.math.NumberUtils;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.abner.fence.commons.Api;
import com.abner.fence.commons.StoreFieldFilter;
import com.abner.fence.web.StoreAction;

import ext.data.DataReader;
import ext.data.JsonReader;
import ext.data.Store;

public final class StoreHelper {

	public static String ROOT_KEY = "data";
	public static String TOTALPROPERTY_KEY = "total";
	public static String SUCCESSPROPERTY_KEY = "success";

	public static boolean isAutoLoad(Store store) {
		Boolean autoLoad = store.getAutoLoad();
		if (autoLoad == null)
			return false;

		return autoLoad.booleanValue();
	}

	public static String encodeDataSource(Store store, boolean autoLoad) {
		if (!RequestUtils.isAjaxRequest() && autoLoad) {
			StoreHelper.guessDefaultProperty(store);
			return null;
		}
		Map<String, Object> dataSource = new HashMap<String, Object>();

		Object data = StoreHelper.getData(store);

		JsonConfig cfg = JsonUtils.getDateJsonConfig();
		cfg.setJsonPropertyFilter(new StoreFieldFilter(store));
		cfg.setExcludes(new String[] { "children" });
		

		int count = getStoreCount(store);
		int size = 0;
		if (data == null) {
			data = new JSONArray();
		} else if (data instanceof Collection<?>) {
			size = ((Collection<?>) data).size();
			data = JsonUtils.getJSON(data, cfg);
		} else if (data.getClass().isArray()) {
			size = ((Object[]) data).length;
			data = JsonUtils.getJSON(data, cfg);
		} else if (data instanceof String) {
			JSONArray jsonArray = JSONArray.fromObject(data, cfg);
			data = jsonArray;
			size = jsonArray.size();
		} else {
			throw new IllegalArgumentException(
					"Unable to identify the data type，The type maybe Collection,Map or array.");
		}

		if (count == 0)
			count = size;

		dataSource.put(StoreHelper.getRoot(store), data);
		dataSource.put(StoreHelper.getSuccessProperty(store), Boolean.TRUE);
		dataSource.put(StoreHelper.getTotalProperty(store), count);
		dataSource.put("message", "The store load data successfully.");
		return JsonUtils.toJson(dataSource);
	}

	public static String getActionType() {
		Map<String, Object> params = FacesUtils.extContext().getRequestMap();
		if (params.containsKey("xaction"))
			return params.get("xaction").toString();

		Map<String, String> rparams = FacesUtils.extContext().getRequestParameterMap();
		if (rparams.containsKey("xaction")) {
			String action = rparams.get("xaction");
			params.put("xaction", action);
			return action;
		}
		return null;
	}
	
	public static int getStoreCount(Store store){
		Object tcount = store.getConfig("totalCount");
		if(tcount == null){
			return 0;
		}else	if(tcount instanceof ValueExpression){
			return (Integer)((ValueExpression)tcount).getValue(FacesUtils.context().getELContext());
		}else if(NumberUtils.isNumber(tcount.toString())){
			return NumberUtils.toInt(tcount.toString());
		}else{
			throw new IllegalArgumentException("the total count must be a number.");
		}
	}

	public static StoreAction getStoreAction(Store store) {
		ValueExpression ve = store.getValueExpression("beanAction");
		if(ve != null){
			Object result = ve.getValue(FacesUtils.context().getELContext());
			if(!(result instanceof StoreAction)){
				throw new IllegalArgumentException("the beanaction valueexpression must implements StoreAction.");
			}
			return (StoreAction) result;
		}
		Object beanAction = (String) store.getConfig("beanAction");

		if (beanAction == null) {
			beanAction = store.getConfig("beanAction");
		}
		if (beanAction == null)
			return null;

		StoreAction storeAction = null;
		if (beanAction instanceof String) {
			beanAction = ELUtils.evaluate(FacesUtils.context(), (String) beanAction);
		}

		if (beanAction instanceof StoreAction) {
			storeAction = (StoreAction) beanAction;
		}

		return storeAction;
	}

	public static Object getData(Store store) {
		Object data = store.getData();
		if (data == null) {
			ValueExpression datave = store.getValueExpression("data");
			if (datave == null) {
				StoreAction storeAction = StoreHelper.getStoreAction(store);
				if (storeAction != null) {
					data = storeAction.execute(Collections.emptyList(), Api.ACTION_READ);
				}
			}
		}
		return data;
	}

	public static Class<?> guessBeanClass(Store store) {
		String beanClassStr = (String) store.getConfig("beanClass");
		if (!Strings.isEmpty(beanClassStr)) {
			try {
				return Class.forName(beanClassStr);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		Object data = getData(store);
		Class<?> beanClass = null;
		if (data instanceof Collection<?>) {
			Iterator<?> iter = ((Collection<?>) data).iterator();
			if (iter.hasNext())
				beanClass = iter.next().getClass();
		} else if (data.getClass().isArray()) {
			Object[] objs = ((Object[]) data);
			if (objs.length > 0)
				beanClass = objs[0].getClass();
		}

		if (beanClass == null)
			throw new RuntimeException("Can not guess the store bean class type,you must set the 'beanClass' property.");

		return beanClass;
	}

	public static void guessDefaultProperty(Store store) {
		getIdProperty(store);
		getRoot(store);
		getTotalProperty(store);
		getSuccessProperty(store);
	}

	public static String getIdProperty(Store store) {
		return getProperty(store, "idProperty", "id");
	}

	public static String getRoot(Store store) {
		return getProperty(store, "root", ROOT_KEY);
	}

	public static String getTotalProperty(Store store) {
		return getProperty(store, "totalProperty", TOTALPROPERTY_KEY);
	}

	public static String getSuccessProperty(Store store) {
		return getProperty(store, "successProperty", SUCCESSPROPERTY_KEY);
	}

	private static String getProperty(Store store, String key, String defaultValue) {
		String result = null;
		if (!Store.class.equals(store.getClass())) {
			if (store.getConfig(key) != null) {
				result = store.getConfig(key).toString();
			}
			if (result == null) {
				ValueExpression ve = store.getValueExpression(key);
				if (ve != null)
					result = ve.getValue(FacesUtils.context().getELContext()).toString();
			}
			if (result == null) {
				result = defaultValue;
				store.handleConfig(key, result);
			}
		} else {
			DataReader dataReader = getDataReader(store);
			if (dataReader == null)
				throw new IllegalArgumentException("The store must have a DataReader.");

			if (JsonReader.class.isAssignableFrom(dataReader.getClass())) {
				if (dataReader.getConfig(key) != null)
					result = dataReader.getConfig(key).toString();
			}

			if (result == null) {
				result = defaultValue;
				dataReader.handleConfig(key, result);
			}
		}

		return result;
	}

	private static DataReader getDataReader(Store store) {
		List<UIComponent> childs = store.getChildren();
		for (UIComponent child : childs) {
			if (child instanceof DataReader) {
				return (DataReader) child;
			}
		}
		return null;
	}
}
