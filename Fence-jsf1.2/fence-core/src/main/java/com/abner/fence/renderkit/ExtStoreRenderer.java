package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.abner.fence.event.StoreEvent;
import com.abner.fence.handler.StoreHandler;
import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.util.AjaxJSUtils;
import com.abner.fence.util.Ext;
import com.abner.fence.util.JSUtils;
import com.abner.fence.util.RequestUtils;
import com.abner.fence.util.StoreFieldFilter;
import com.abner.fence.util.StoreHelper;
import com.abner.fence.util.StringPredicate;
import com.abner.fence.web.RequestContext;
import com.abner.fence.web.StoreAction;

import ext.data.Api;
import ext.data.DataProxy;
import ext.data.DataWriter;
import ext.data.HttpProxy;
import ext.data.JsonStore;
import ext.data.JsonWriter;
import ext.data.Store;
import ext.util.ComponentUtil;
import ext.util.ELUtils;
import ext.util.FacesUtils;
import ext.util.JsonUtils;
import ext.util.StringUtil;

public class ExtStoreRenderer extends ExtBasicRenderer<Store> {

	private boolean isRenderRoot;

	@Override
	public String getStructureTemplate() {
		if (isRenderRoot)
			return null;

		return super.getStructureTemplate();
	}

	private boolean isAutoLoad(Store store) {
		Boolean autoLoad = store.getAutoLoad();
		if (autoLoad == null)
			return false;
		return autoLoad.booleanValue();
	}

	@Override
	public void beforeEncodeBegin(FacesContext context, Store store)
			throws IOException {
		AsyncResponse async = AsyncResponse.getInstance();
		isRenderRoot = async.isRenderRoot(store);

		this.createDataProxy(context, store);
		this.createDataWriter(context, store);

		if (store instanceof JsonStore) {
			JsonStore jsonStore = (JsonStore) store;
			if (StringUtil.isEmpty(jsonStore.getRoot())) {
				jsonStore.setRoot(StoreHelper.getRoot(jsonStore));
			}
			if (StringUtil.isEmpty(jsonStore.getIdProperty())) {
				jsonStore.setRoot(StoreHelper.getIdProperty(jsonStore));
			}
		}
	}

	private void createDataProxy(FacesContext context, Store store) {
		if (store.getProxy() != null)
			return;

		String url = store.getUrl();

		DataProxy proxy = ComponentUtil
				.getFirstExtChild(store, DataProxy.class);
		if (proxy == null)
			proxy = new HttpProxy();
		else {
			url = StringUtil.ifEmpty(proxy.getUrl(), url);
		}

		url = StringUtil.ifEmpty(url, RequestUtils.getAjaxActionPath());
		proxy.setUrl(url);
		store.getChildren().add(proxy);
	}

	private void createDataWriter(FacesContext context, Store store) {
		if (store.getWriter() != null)
			return;

		DataWriter writer = ComponentUtil.getFirstExtChild(store,
				DataWriter.class);
		if (writer == null)
			writer = new JsonWriter();

		store.getChildren().add(writer);
	}

	@Override
	public void beforeEncodeEnd(FacesContext context, Store store)
			throws IOException {
		AjaxJSUtils.handleEvent(store, "exception", JSUtils.StoreException);

		encodeStoreBaseParams(context, store);

		String dataKey = store.getClientId(context) + "_data";
		String data = encodeDataSource(store, this.isAutoLoad(store));
		JSUtils.puGlobalVar(dataKey);

		appendScriptBefore(store, dataKey + " = " + data + ";\n");

		if (!this.isAutoLoad(store))
			store.handleConfig("data", dataKey);
		else
			store.handleConfig("data", null);

		if (RequestUtils.isAjaxRequest()) {
			store.setAutoLoad(Boolean.FALSE);
			appendScriptAfter(store, store.getVar() + ".loadData(" + dataKey + ");");
		}
	}

	@Override
	public void afterEncodeEnd(FacesContext context, Store component)
			throws IOException {
		if (!RequestUtils.hasRenderViewState()) {
			ViewHandler viewHandler = context.getApplication().getViewHandler();
			viewHandler.writeState(context);
			RequestContext.instance().put(RequestUtils.VIEW_STATE_RENDER,
					Boolean.TRUE);
		}

		if (!RequestUtils.isAjaxRequest()) {
			String actionEl = getActionEl(component);
			if (actionEl != null) {
				ActionListener listener = FacesUtils
						.createActionListener(actionEl);
				component.addActionListener(listener);
			}
		}
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		super.decode(context, component);
		Store store = (Store) component;

		String xaction = StoreHelper.getActionType();

		if (!this.wasHandler(context, store))
			return;

		String actionEl = getActionEl(store);
		StoreAction storeAction = StoreHelper.getStoreAction(store);

		if (actionEl == null && storeAction == null
				&& !Api.ACTION_READ.equals(xaction)) {
			throw new RuntimeException(
					"You must set the beanMethod or beanAction when CURD data。");
		}

		StoreEvent storeEvent = getStoreEvent(store);
		String rawData = RequestUtils.getParam(StoreHelper.getRoot(store));
		storeEvent.setData(rawData);

		if (Api.ACTION_READ.equals(xaction)) {
			storeEvent.setXaction(Api.ACTION_READ);
			store.queueEvent(storeEvent);
			return;
		}

		String idProp = StoreHelper.getIdProperty(store);
		if (Api.ACTION_CREATE.equals(xaction)) {
			storeEvent.setCreated(decodeCreated(store, rawData, idProp));
			storeEvent.setXaction(Api.ACTION_CREATE);
			store.queueEvent(storeEvent);

			if (storeAction != null) {
				storeAction.execute(storeEvent.getCreated(), Api.ACTION_CREATE);
			}
			return;
		}

		if (Api.ACTION_UPDATE.equals(xaction)) {
			storeEvent.setChanged(decodeUpdate(store, rawData, idProp));
			storeEvent.setXaction(Api.ACTION_UPDATE);
			store.queueEvent(storeEvent);

			if (storeAction != null) {
				storeAction.execute(storeEvent.getChanged(), Api.ACTION_UPDATE);
			}
			return;
		}

		if (Api.ACTION_DESTORY.equals(xaction)) {
			storeEvent.setRemoved(decodeDelete(store, rawData, idProp));
			storeEvent.setXaction(Api.ACTION_DESTORY);
			store.queueEvent(storeEvent);

			if (storeAction != null) {
				storeAction
						.execute(storeEvent.getRemoved(), Api.ACTION_DESTORY);
			}
			return;
		}
	}

	private List<?> decodeCreated(Store store, String rawData, String idProp) {
		JSON rawJson = JsonUtils.getJSON(rawData);
		List<Object> result = new ArrayList<Object>();

		Class<?> beanClass = StoreHelper.guessBeanClass(store);
		assert beanClass != null;

		Object targetBean = null;
		try {
			if (rawJson instanceof JSONObject) {
				targetBean = beanClass.newInstance();
				Ext.applyBean(targetBean, rawJson);
				result.add(targetBean);
			} else if (rawJson instanceof JSONArray) {
				JSONArray formObjs = (JSONArray) rawJson;
				for (Iterator<?> iter = formObjs.iterator(); iter.hasNext();) {
					targetBean = beanClass.newInstance();
					Ext.applyBean(targetBean, iter.next());
					result.add(targetBean);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	private List<?> decodeDelete(Store store, String rawData, String idProp) {
		Object data = StoreHelper.getData(store);

		if (data == null)
			throw new IllegalStateException("The update data is not exist.");

		Object[] ids = null;

		if (rawData.startsWith("[") && rawData.endsWith("]")) {
			ids = (Object[]) JSONArray.toArray(JSONArray.fromObject(rawData));
		} else if (rawData.startsWith("\"") && rawData.endsWith("\"")) {
			ids = new String[] { rawData.substring(1, rawData.length() - 1) };
		} else {
			ids = new String[] { rawData };
		}

		List result = new ArrayList();
		if (ids == null)
			throw new IllegalArgumentException(
					"you must select data record when delete.");

		for (Object id : ids) {
			Predicate pred = new StringPredicate(idProp, id.toString());
			if (data instanceof Collection<?>) {
				Object origObj = CollectionUtils.find((Collection<?>) data,
						pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id
							+ " is not exist.");

				result.add(origObj);
			} else if (data.getClass().isArray()) {
				List<?> origObjs = Arrays.asList((Object[]) data);
				Object origObj = CollectionUtils.find(origObjs, pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id
							+ " is not exist.");

				result.add(origObj);
			} else if (data instanceof String) {
				// TODO
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	private List<?> decodeUpdate(Store store, String rawData, String idProp) {
		Object data = StoreHelper.getData(store);

		if (data == null)
			throw new IllegalStateException("The update data is not exist.");

		JSONArray jsonArray = null;
		if (rawData.startsWith("{") && rawData.endsWith("}")) {
			jsonArray = JSONArray.fromObject("[" + rawData + "]");
		} else {
			jsonArray = JSONArray.fromObject(rawData);
		}

		List result = new ArrayList();
		if (jsonArray == null)
			throw new IllegalArgumentException(
					"you must select data record when update.");

		for (Iterator<?> iter = jsonArray.iterator(); iter.hasNext();) {
			JSONObject jsonObj = (JSONObject) iter.next();
			if (jsonObj == null)
				throw new RuntimeException("This may be ext occur error.");

			String id = jsonObj.get(idProp).toString();

			Predicate pred = new StringPredicate(idProp, id);
			if (data instanceof Collection<?>) {
				Object origObj = CollectionUtils.find((Collection<?>) data,
						pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id
							+ " is not exist.");

				Ext.applyBean(origObj, jsonObj);
				result.add(origObj);
			} else if (data.getClass().isArray()) {
				List<?> origObjs = Arrays.asList((Object[]) data);
				Object origObj = CollectionUtils.find(origObjs, pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id
							+ " is not exist.");

				Ext.applyBean(origObj, jsonObj);
				result.add(origObj);
			} else if (data instanceof String) {
				// TODO
			}
		}

		return result;
	}

	private boolean wasHandler(FacesContext context, Store store) {
		if (!RequestUtils.isHandlerRequest())
			return false;

		AsyncResponse async = AsyncResponse.getInstance();
		List<String> renders = async.getRenderSubtrees();
		if (renders.size() != 1)
			return false;

		return store.getClientId(context).equals(renders.get(0));
	}

	private void encodeStoreBaseParams(FacesContext context, Store store) {
		StringBuilder sb = new StringBuilder(256);
		sb.append(store.getVar());
		sb.append(".setBaseParam(");
		sb.append(StringUtil.dotString(RequestUtils.AJAX_PARAM) + ",");
		sb.append(String.valueOf(true));
		sb.append(");");

		sb.append(store.getVar());
		sb.append(".setBaseParam(");
		sb.append(StringUtil.dotString(RequestUtils.RENDER_PARAM) + ",");
		sb.append(StringUtil.dotString(store.getClientId(context)));
		sb.append(");");

		sb.append(store.getVar());
		sb.append(".setBaseParam(");
		sb.append(StringUtil.dotString(RequestUtils.HANDLER_PARAM) + ",");
		sb.append(StringUtil.dotString(StoreHandler.HANDLER_ID));
		sb.append(");");

		sb.append(store.getVar());
		sb.append(".setBaseParam(");
		sb.append(StringUtil.dotString(RequestUtils.VIEW_STATE_KEY) + ",");
		sb.append("Fence.getViewState()");
		sb.append(");");

		super.appendScriptAfter(store, sb.toString());
	}

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

		Integer count = store.getTotalCount();
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

		if (count == null)
			count = size;

		dataSource.put(StoreHelper.getRoot(store), data);
		dataSource.put(StoreHelper.getSuccessProperty(store), Boolean.TRUE);
		dataSource.put(StoreHelper.getTotalProperty(store), count);
		dataSource.put("message", "The store load data successfully.");
		return JsonUtils.toJson(dataSource);
	}

	public StoreEvent getStoreEvent(Store store) {
		String eventKey = store.getClientId(FacesUtils.context()) + "_event";
		StoreEvent storeEvent = (StoreEvent) RequestContext.instance().get(
				eventKey);
		if (storeEvent == null) {
			storeEvent = new StoreEvent(store);
			RequestContext.instance().put(eventKey, storeEvent);
		}
		return storeEvent;
	}

	private String getActionEl(Store store) {
		String result = null;
		if (!StringUtil.isEmpty(store.getBeanMethod())) {
			return ELUtils.getELExpr(store.getBeanMethod());
		}
		return result;
	}
}
