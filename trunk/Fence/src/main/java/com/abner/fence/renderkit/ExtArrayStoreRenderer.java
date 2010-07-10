package com.abner.fence.renderkit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.abner.fence.commons.StoreFieldFilter;
import com.abner.fence.utils.JsonUtils;
import com.abner.fence.utils.RequestUtils;
import com.abner.fence.utils.StoreHelper;

import ext.data.Store;

public class ExtArrayStoreRenderer extends ExtStoreRenderer {

	public String encodeDataSource(Store store, boolean autoLoad) {
		if (!RequestUtils.isAjaxRequest() && autoLoad) {
			StoreHelper.guessDefaultProperty(store);
			return null;
		}
		Map<String, Object> dataSource = new HashMap<String, Object>();

		Object data = StoreHelper.getData(store);

		JsonConfig cfg = JsonUtils.getDateJsonConfig();
		cfg.setJsonPropertyFilter(new StoreFieldFilter(store));
		cfg.setExcludes(new String[] { "children" });

		Integer count = (Integer) store.getConfig("totalCount");
		int size = 0;
		if (data == null) {
			data = new JSONArray();
		} else if (data instanceof Collection<?>) {
			size = ((Collection<?>) data).size();
			Object[] adata = new Object[size];
			int i = 0;
			for (Iterator<?> iter = ((Collection<?>) data).iterator(); iter.hasNext();) {
				Object item = iter.next();
				if (item == null || !item.getClass().isArray()) {
					adata[i] = new Object[] { item };
				} else {
					adata[i] = item;
				}
				i++;
			}
			data = JsonUtils.getJSON(adata, cfg);
		} else if (data.getClass().isArray()) {
			size = ((Object[]) data).length;
			for (int i = 0; i < size; i++) {
				Object item = ((Object[]) data)[i];
				if (item == null || !item.getClass().isArray()) {
					((Object[]) data)[i] = new Object[] { item };
				}
			}
			data = JsonUtils.getJSON(data, cfg);
		} else if (data instanceof String) {
			JSONArray jsonArray = JSONArray.fromObject(data, cfg);
			data = jsonArray;
			size = jsonArray.size();
		} else {
			throw new IllegalArgumentException(
					"Unable to identify the data type，The type maybe Collection,Map or array.");
		}

		if (count == null)
			count = size;

		dataSource.put(StoreHelper.getRoot(store), data);
		dataSource.put(StoreHelper.getSuccessProperty(store), Boolean.TRUE);
		dataSource.put(StoreHelper.getTotalProperty(store), count);
		return JsonUtils.toJson(dataSource);
	}
}
