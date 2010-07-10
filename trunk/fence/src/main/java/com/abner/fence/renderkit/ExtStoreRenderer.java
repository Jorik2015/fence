package com.abner.fence.renderkit;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.abner.fence.commons.Api;
import com.abner.fence.commons.StringPredicate;
import com.abner.fence.component.ExtComponent;
import com.abner.fence.handler.StoreEvent;
import com.abner.fence.handler.StoreHandler;
import com.abner.fence.utils.AjaxJSUtils;
import com.abner.fence.utils.ComponentUtils;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.JsonUtils;
import com.abner.fence.utils.RequestUtils;
import com.abner.fence.utils.StoreHelper;
import com.abner.fence.utils.Strings;
import com.abner.fence.web.Params;
import com.abner.fence.web.RequestContext;
import com.abner.fence.web.StoreAction;

import ext.data.DataProxy;
import ext.data.DataWriter;
import ext.data.HttpProxy;
import ext.data.JsonStore;
import ext.data.JsonWriter;
import ext.data.Store;

public class ExtStoreRenderer extends ExtBasicRenderer<Store> {

	private void createDataProxy(FacesContext context, Store store) {
		if (store.getProxy() != null)
			return;

		String url = store.getUrl();

		DataProxy proxy = ComponentUtils.getFirstExtChild(store, DataProxy.class);
		if (proxy == null)
			proxy = new HttpProxy();
		else {
			url = Strings.ifEmpty(proxy.getUrl(), url);
		}

		url = Strings.ifEmpty(url, RequestUtils.getAjaxActionPath());
		proxy.setUrl(url);
		store.getChildren().add(proxy);
	}

	private void createDataWriter(FacesContext context, Store store) {
		if (store.getWriter() != null)
			return;

		DataWriter writer = ComponentUtils.getFirstExtChild(store, DataWriter.class);
		if (writer == null)
			writer = new JsonWriter();

		store.getChildren().add(writer);
	}

	@Override
	public void beforeEncodeBegin(FacesContext context, Store store) throws IOException {

		this.createDataProxy(context, store);
		this.createDataWriter(context, store);

		if (store instanceof JsonStore) {
			JsonStore jsonStore = (JsonStore) store;
			if (Strings.isEmpty(jsonStore.getRoot())) {
				jsonStore.setRoot(StoreHelper.getRoot(jsonStore));
			}
		}
	}

	@Override
	public void beforeEncodeEnd(FacesContext context, Store store) throws IOException {
		AjaxJSUtils.handleEvent(store, "exception", JSUtils.StoreException);

		encodeStoreBaseParams(context, store);

		boolean isAutoLoad = StoreHelper.isAutoLoad(store);
		String dataKey = store.getClientId(context) + "_data";
		String data = StoreHelper.encodeDataSource(store, isAutoLoad);
		JSUtils.putGlobalVar(dataKey);

		appendScriptBefore(store, dataKey + " = " + data + ";\n");

		store.handleConfig("data", (isAutoLoad || RequestUtils.isAjaxRequest()) ? null : dataKey);

		if (RequestUtils.isAjaxRequest()) {
			store.setAutoLoad(Boolean.FALSE);
			appendScriptAfter(store, store.getVar() + ".loadData(" + dataKey + ");");
		}
	}

	@Override
	protected boolean needRenderScript(ExtComponent comp) {
		boolean need = super.needRenderScript(comp);
		if (RequestUtils.isAjaxRequest()) {
			need = false;
		}
		return need;
	}

	@Override
	public void afterEncodeEnd(FacesContext context, Store component) throws IOException {
		if (!RequestUtils.isAjaxRequest()) {
			String actionEl = getActionEl(component);
			if (actionEl != null) {
				ActionListener listener = FacesUtils.createActionListener(actionEl);
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

		if (actionEl == null && storeAction == null && !Api.ACTION_READ.equals(xaction)) {
			throw new RuntimeException("You must set the beanMethod or beanAction when CURD data。");
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
				storeAction.execute(storeEvent.getRemoved(), Api.ACTION_DESTORY);
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
				ExtUtils.applyBean(targetBean, rawJson);
				result.add(targetBean);
			} else if (rawJson instanceof JSONArray) {
				JSONArray formObjs = (JSONArray) rawJson;
				for (Iterator<?> iter = formObjs.iterator(); iter.hasNext();) {
					targetBean = beanClass.newInstance();
					ExtUtils.applyBean(targetBean, iter.next());
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
			throw new IllegalArgumentException("you must select data record when delete.");

		for (Object id : ids) {
			Predicate pred = new StringPredicate(idProp, id.toString());
			if (data instanceof Collection<?>) {
				Object origObj = CollectionUtils.find((Collection<?>) data, pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id + " is not exist.");

				result.add(origObj);
			} else if (data.getClass().isArray()) {
				List<?> origObjs = Arrays.asList((Object[]) data);
				Object origObj = CollectionUtils.find(origObjs, pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id + " is not exist.");

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
			throw new IllegalArgumentException("you must select data record when update.");

		for (Iterator<?> iter = jsonArray.iterator(); iter.hasNext();) {
			JSONObject jsonObj = (JSONObject) iter.next();
			if (jsonObj == null)
				throw new RuntimeException("This may be ext occur error.");

			String id = jsonObj.get(idProp).toString();

			Predicate pred = new StringPredicate(idProp, id);
			if (data instanceof Collection<?>) {
				Object origObj = CollectionUtils.find((Collection<?>) data, pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id + " is not exist.");

				ExtUtils.applyBean(origObj, jsonObj);
				result.add(origObj);
			} else if (data.getClass().isArray()) {
				List<?> origObjs = Arrays.asList((Object[]) data);
				Object origObj = CollectionUtils.find(origObjs, pred);
				if (origObj == null)
					throw new IllegalStateException("The object with id :" + id + " is not exist.");

				ExtUtils.applyBean(origObj, jsonObj);
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

		Object handlerId = Params.getParam(RequestUtils.HANDLER_PARAM).getRawValue();
		Object source = Params.getParam(RequestUtils.SOURCE_PARAM).getRawValue();
		boolean result = StoreHandler.HANDLER_ID.equals(handlerId.toString());
		return result && store.getClientId(context).equals(source);
	}

	private void encodeStoreBaseParams(FacesContext context, Store store) {
		StringBuilder builder = new StringBuilder(256);

		String temp = store.getVar() + ".setBaseParam(''{0}'',{1});";
		String name = RequestUtils.VIEW_STATE_KEY;
		String value = "Fence.getViewState()";
		String script = MessageFormat.format(temp, name, value);
		builder.append(script);

		temp = store.getVar() + ".setBaseParam(''{0}'',''{1}'');";

		name = RequestUtils.AJAX_PARAM;
		value = String.valueOf(true);
		script = MessageFormat.format(temp, name, value);
		builder.append(script);

		name = RequestUtils.SOURCE_PARAM;
		value = store.getClientId(context);
		script = MessageFormat.format(temp, name, value);
		builder.append(script);

		name = RequestUtils.EXECUTE_PARAM;
		value = store.getClientId();
		script = MessageFormat.format(temp, name, value);
		builder.append(script);

		name = RequestUtils.HANDLER_PARAM;
		value = StoreHandler.HANDLER_ID;
		script = MessageFormat.format(temp, name, value);
		builder.append(script);

		super.appendScriptAfter(store, builder.toString());
	}

	public StoreEvent getStoreEvent(Store store) {
		String eventKey = store.getClientId(FacesUtils.context()) + "_event";
		StoreEvent storeEvent = (StoreEvent) RequestContext.instance().get(eventKey);
		if (storeEvent == null) {
			storeEvent = new StoreEvent(store);
			RequestContext.instance().put(eventKey, storeEvent);
		}
		return storeEvent;
	}

	private String getActionEl(Store store) {
		String result = null;
		/*
		 * if (!StringUtil.isEmpty(store.getBeanMethod())) { return ELUtils.getELExpr(store.getBeanMethod()); }
		 */
		return result;
	}
}
