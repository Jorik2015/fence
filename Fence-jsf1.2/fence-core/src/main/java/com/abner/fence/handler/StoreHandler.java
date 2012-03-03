package com.abner.fence.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import net.sf.json.JSON;
import net.sf.json.JsonConfig;

import com.abner.fence.event.StoreEvent;
import com.abner.fence.renderkit.ExtStoreRenderer;
import com.abner.fence.util.StoreFieldFilter;
import com.abner.fence.util.StoreHelper;

import ext.base.ExtBase;
import ext.data.Api;
import ext.data.Store;
import ext.util.JsonUtils;

public class StoreHandler implements ExtHandler {
	public final static String HANDLER_ID = "storeHandler";
	private Store store;

	public void render(FacesContext context, UIComponent target) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		this.store = (Store) target;

		ExtBase extBase = this.store.getExtBase();
		Renderer renderer = extBase.getRenderer(context);

		assert renderer instanceof ExtStoreRenderer;

		ExtStoreRenderer storeRender = (ExtStoreRenderer) renderer;
		JsonConfig cfg = JsonUtils.getDateJsonConfig();
		cfg.setJsonPropertyFilter(new StoreFieldFilter(store));

		String actionType = StoreHelper.getActionType();

		if (actionType == null) {
			actionType = Api.ACTION_READ;
		}
		
		Object result = null;
		Map<Object, Object> dataSource = new HashMap<Object, Object>();
		dataSource.put(StoreHelper.getSuccessProperty(store), Boolean.TRUE);

		if (Api.ACTION_READ.equalsIgnoreCase(actionType)) {
			String storeStr = storeRender.encodeDataSource(store, false);
			writer.write(storeStr);
			return;
		} else if (Api.ACTION_CREATE.equalsIgnoreCase(actionType)) {
			StoreEvent storeEvent = storeRender.getStoreEvent(store);
			dataSource.put("message", "create successfully.");
			JSON data = JsonUtils.getJSON(storeEvent.getCreated(), cfg);
			dataSource.put(StoreHelper.getRoot(store), data);
		} else if (Api.ACTION_UPDATE.equalsIgnoreCase(actionType)) {
			StoreEvent storeEvent = storeRender.getStoreEvent(store);
			JSON data = JsonUtils.getJSON(storeEvent.getChanged(), cfg);
			dataSource.put(StoreHelper.getRoot(store), data);
			dataSource.put("message", "update successfully.");
		} else if (Api.ACTION_DESTORY.equalsIgnoreCase(actionType)) {
			StoreEvent storeEvent = storeRender.getStoreEvent(store);
			JSON data = JsonUtils.getJSON(storeEvent.getRemoved(), cfg);
			dataSource.put(StoreHelper.getRoot(store), data);
			dataSource.put("message", "delete successfully.");
		}

		result = JsonUtils.toJson(dataSource);
		writer.write(result.toString());
	}
}
