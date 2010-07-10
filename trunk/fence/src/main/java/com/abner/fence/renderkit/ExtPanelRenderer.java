package com.abner.fence.renderkit;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.math.NumberUtils;

import com.abner.fence.component.ScriptManager;
import com.abner.fence.component.ux.MifPanel;
import com.abner.fence.utils.AjaxJSUtils;
import com.abner.fence.utils.ComponentUtils;
import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.ExtUtils;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.RequestUtils;
import com.abner.fence.utils.Strings;

import ext.BoxComponent;
import ext.Container;
import ext.Panel;
import ext.TabPanel;
import ext.Viewport;
import ext.Window;
import ext.grid.GridPanel;
import ext.tree.TreePanel;

public class ExtPanelRenderer<T extends BoxComponent> extends ExtBasicRenderer<BoxComponent> {
	private static final String CONTENT_TAG = "div";

	private boolean canRenderContentEl(FacesContext context, BoxComponent component) {
		if (!(component instanceof Container))
			return false;

		if (component instanceof Viewport)
			return false;

		if (component instanceof TreePanel || component instanceof GridPanel) {
			return false;
		}

		if (!ComponentUtils.hasNotExtComponetChild(component))
			return false;

		String layout = ((Container) component).getLayout();
		List<String> lays = Arrays.asList(new String[] { "accordion", "anchor", "card", "form", "menu", "table", "fit",
				"border", "toolbar", "vbox", "vbox" });

		if (lays.contains(layout)) {
			return false;
		}

		if (component.getChildCount() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void beforeEncodeBegin(FacesContext context, BoxComponent component) throws IOException {
		if (component instanceof Panel) {
			Panel panel = ((Panel) component);
			Object autoLoad = panel.getAutoLoad();
			if (autoLoad != null && !JSONUtils.mayBeJSON(autoLoad.toString())) {
				// first is true,custom encode;
				if ("true".equalsIgnoreCase(autoLoad.toString())) {
					panel.handleConfig("autoLoad", AjaxJSUtils.encodeUpdaterOptions(context, panel));
				} else if (!JSONUtils.isFunction(autoLoad)) {
					JSONObject cusAutoLoad = new JSONObject();
					cusAutoLoad.put("url", FacesUtils.getActionUrl(autoLoad.toString()));
					panel.handleConfig("autoLoad", cusAutoLoad.toString());
				}
			}
		}
		// the tabpanel support activeTab use index
		if (component instanceof TabPanel) {
			String activeTab = ((TabPanel) component).getActiveTab();
			if (NumberUtils.isNumber(activeTab)) {
				((TabPanel) component).handleConfig("activeTab", ExtUtils.PREFIX_RAW_VALUE + activeTab);
			}
		}

		ResponseWriter writer = context.getResponseWriter();
		if (canRenderContentEl(context, component)) {
			String contentId = component.getContainerId() + ExtUtils.SUFFIX_CONTENT_ID;
			writer.startElement(CONTENT_TAG, component);
			writer.writeAttribute("id", contentId, "id");
			ConfigUtils.configToSelf("contentEl", contentId, component);
			// skip the window
			Window window = ComponentUtils.inNested(Window.class, component);
			if (window == null) {
				JSUtils.RegisterBeforeClientInitScript(ScriptManager.All_HTML_CONTENT_DIV_VAR + ".clear();");
				UIComponent parent = component.getParent();
				if (!RequestUtils.isAjaxRequest()) {
					if (parent instanceof TabPanel && !ComponentUtils.isActiveItem(component)) {
						writer.writeAttribute("class", "x-hide-display", "class");
					} else {
						writer.writeAttribute("style", "visibility: hidden", "style");
						this.appendScriptAfter(component, ScriptManager.All_HTML_CONTENT_DIV_VAR + ".add(\""
								+ contentId + "\");");
					}
				}
			}
		}

		UIComponent parent = component.getParent();
		if (parent instanceof BoxComponent) {
			if (isNeedUpdateInClient(component)) {
				String parentVar = ((BoxComponent) parent).getVar();

				String script = "if(typeof " + component.getVar() + " != 'undefined'){" + parentVar + ".remove("
						+ component.getVar() + ");}";
				this.appendScriptBefore(component, script);

				script = parentVar + ".add(" + component.getVar() + ");";
				this.appendScriptAfter(component, script);

				script = parentVar + ".doLayout();";
				this.appendScriptAfter(component, script);
			}
			if (ComponentUtils.isHaeresNatus(component) && !isFloating(component)) {
				component.setRenderTo(ExtUtils.NULL);
				ConfigUtils.configTo("items", component.getVar(), component);
			}
		} else if (component instanceof Viewport) {
			component.setRenderTo(ExtUtils.NULL);
			component.handleConfig("contentEl", null);
		}
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		BoxComponent box = (BoxComponent) component;
		boolean notRenderChildren = !RequestUtils.isAjaxRequest() && box instanceof Panel
				&& this.isAutoLoad((Panel) box) && !ComponentUtils.isActiveItem(box);
		if (notRenderChildren) {
			ResponseWriter writer = context.getResponseWriter();
			writer.write("<!-- The content is updated lazy use ajax by fence -->");
		} else {
			super.encodeChildren(context, component);
		}
	}

	private boolean isNeedUpdateInClient(BoxComponent component) {
		/*
		 * AsyncResponse async = AsyncResponse.getInstance(); if (RequestUtils.isAjaxRequest() &&
		 * ComponentUtil.isHaeresNatus(component)) { if (async.isRenderRoot(component) &&
		 * !RequestUtils.isUpdaterRequest()) { return true; } if (RequestUtils.isUpdaterRequest() &&
		 * async.isRenderRoot(component.getParent())) { return true; } }
		 */
		return false;
	}

	@Override
	public boolean getRendersChildren() {
		return Boolean.TRUE;
	}

	@Override
	public void beforeEncodeEnd(FacesContext context, BoxComponent component) throws IOException {
		// the mifpanel defaultSrc
		if (component instanceof MifPanel) {
			String defaultSrc = ((MifPanel) component).getDefaultSrc();
			if (!Strings.isEmpty(defaultSrc)) {
				String actionPath = FacesUtils.getActionUrl(defaultSrc);
				component.handleConfig("defaultSrc", actionPath);
			}
		}
	}

	@Override
	public void afterEncodeEnd(FacesContext context, BoxComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		if (canRenderContentEl(context, component)) {
			writer.endElement(CONTENT_TAG);
		}
	}

	private boolean isAutoLoad(Panel box) {
		Object autoLoad = box.getAutoLoad();
		if (autoLoad != null && !"false".equalsIgnoreCase(autoLoad.toString()))
			return true;

		return false;
	}

	private boolean isFloating(BoxComponent comp) {
		if (!(comp instanceof Panel))
			return false;

		Panel panel = (Panel) comp;
		Object floating = panel.getFloating();
		if (floating == null || "false".equalsIgnoreCase(floating.toString())) {
			return false;
		}

		return true;
	}
}
