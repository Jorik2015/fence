package com.abner.fence.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;

import com.abner.fence.web.StoreAction;

import ext.data.Api;
import ext.data.DataReader;
import ext.data.JsonReader;
import ext.data.JsonStore;
import ext.data.Store;
import ext.util.ELUtils;
import ext.util.FacesUtils;
import ext.util.StringUtil;

public final class StoreHelper {

	public static String getActionType() {
		Map<String, Object> params = FacesUtils.extContext().getRequestMap();
		if (params.containsKey("xaction"))
			return params.get("xaction").toString();

		Map<String, String> rparams = FacesUtils.extContext()
				.getRequestParameterMap();
		if (rparams.containsKey("xaction")) {
			String action = rparams.get("xaction");
			params.put("xaction", action);
			return action;
		}
		return null;
	}

	public static StoreAction getStoreAction(Store store) {
		Object beanAction = store.getBeanAction();

		if (beanAction == null) {
			beanAction = store.getConfig("beanAction");
		}
		if(beanAction == null)
			return null;

		StoreAction storeAction = null;
		if (beanAction instanceof String) {
			beanAction = ELUtils.evaluate(FacesUtils.context(),
					(String) beanAction);
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
					data = storeAction.execute(Collections.emptyList(),
							Api.ACTION_READ);
				}
			}
		}
		return data;
	}

	public static Class<?> guessBeanClass(Store store) {
		String beanClassStr = store.getBeanClass();
		if (!StringUtil.isEmpty(beanClassStr)) {
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
		return getProperty(store, "root", JsonStore.ROOT_KEY);
	}

	public static String getTotalProperty(Store store) {
		return getProperty(store, "totalProperty", JsonStore.TOTALPROPERTY_KEY);
	}

	public static String getSuccessProperty(Store store) {
		return getProperty(store, "successProperty",
				JsonStore.SUCCESSPROPERTY_KEY);
	}

	private static String getProperty(Store store, String key,
			String defaultValue) {
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
				throw new IllegalArgumentException(
						"The store must have a DataReader.");

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
