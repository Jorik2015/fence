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

import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.resources.ScriptManager;
import com.abner.fence.util.AjaxJSUtils;
import com.abner.fence.util.ConfigHelper;
import com.abner.fence.util.Ext;
import com.abner.fence.util.JSUtils;
import com.abner.fence.util.RequestUtils;

import ext.BoxComponent;
import ext.Container;
import ext.Panel;
import ext.TabPanel;
import ext.Viewport;
import ext.Window;
import ext.annotation.Layout;
import ext.base.IExt;
import ext.grid.GridPanel;
import ext.layout.ContainerLayout;
import ext.tree.TreePanel;
import ext.util.ComponentUtil;
import ext.util.FacesUtils;
import ext.util.StringUtil;
import ext.ux.mif.MifPanel;

public class ExtPanelRenderer<T extends BoxComponent> extends ExtBasicRenderer<BoxComponent> {
	private static final String CONTENT_TAG = "div";

	private void encodeSkipLayout(BoxComponent component, UIComponent baseComp) {
		if (baseComp == null || !(baseComp instanceof IExt))
			return;

		UIComponent parent = baseComp.getParent();
		if (parent instanceof ContainerLayout) {
			if (ComponentUtil.isHaeresNatus((IExt) parent)) {
				this.encodeSkipLayout(component, parent);
			}
		} else if (parent instanceof BoxComponent) {
			if (ComponentUtil.isHaeresNatus((IExt) baseComp)) {
				component.setRenderTo(Ext.NULL);
				ConfigHelper.configTo("items", component.getVar(), component, (IExt) parent);
			}
		}
	}

	private boolean canRenderContentEl(FacesContext context, BoxComponent component) {
		if (!(component instanceof Container))
			return false;

		if (component instanceof Viewport)
			return false;

		if (component instanceof TreePanel || component instanceof GridPanel) {
			return false;
		}

		if (!ComponentUtil.hasNotExtComponetChild(component))
			return false;

		UIComponent parent = component.getParent();
		String layout = ((Container) component).getLayout();
		if (layout == null && parent instanceof ContainerLayout) {
			Layout layoutType = parent.getClass().getAnnotation(Layout.class);
			if (layoutType != null)
				layout = layoutType.value().toString();
		}
		List<String> lays = Arrays.asList(new String[] { "accordion", "anchor", "card", "form", "menu", "table", "fit", "border", "toolbar", "vbox",
				"vbox" });

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
					cusAutoLoad.put("url", autoLoad);
					panel.handleConfig("autoLoad", cusAutoLoad.toString());
				}
			}
		}
		// the tabpanel support activeTab use index
		if (component instanceof TabPanel) {
			String activeTab = ((TabPanel) component).getActiveTab();
			if (NumberUtils.isNumber(activeTab)) {
				((TabPanel) component).handleConfig("activeTab", Ext.PREFIX_RAW_VALUE + activeTab);
			}
		}
	}

	@Override
	public void afterEncodeBegin(FacesContext context, BoxComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		if (canRenderContentEl(context, component)) {
			String contentId = this.getContainerId() + Ext.SUFFIX_CONTENT_ID;
			writer.startElement(CONTENT_TAG, component);
			writer.writeAttribute("id", contentId, "id");
			writer.writeAttribute("class","htmlcontainer","class");
			
			ConfigHelper.configToSelf("contentEl", contentId, component);
			// skip the window
			Window window = ComponentUtil.inNested(Window.class, component);
			if (window == null) {
				JSUtils.RegisterBeforeClientInitScript(ScriptManager.All_HTML_CONTENT_DIV_VAR + ".clear();");
				UIComponent parent = component.getParent();
				if (!RequestUtils.isAjaxRequest()) {
					if (parent instanceof TabPanel && !ComponentUtil.isActiveItem(component)) {
						writer.writeAttribute("class", "x-hide-display", "class");
					} else {
						writer.writeAttribute("style", "visibility: hidden", "style");
						this.appendScriptAfter(component, ScriptManager.All_HTML_CONTENT_DIV_VAR + ".add(\"" + contentId + "\");");
					}
				}
			}
		}

		UIComponent parent = component.getParent();
		if (parent instanceof ContainerLayout) {
			encodeSkipLayout(component, component);
		} else if (parent instanceof BoxComponent) {
			if (isNeedUpdateInClient(component)) {
				String parentVar = ((BoxComponent) parent).getVar();

				String script = "if(typeof " + component.getVar() + " != 'undefined'){" + parentVar + ".remove(" + component.getVar() + ");}";
				this.appendScriptBefore(component, script);

				script = parentVar + ".add(" + component.getVar() + ");";
				this.appendScriptAfter(component, script);

				script = parentVar + ".doLayout();";
				this.appendScriptAfter(component, script);
			}
			if (ComponentUtil.isHaeresNatus(component) && !isFloating(component)) {
				component.setRenderTo(Ext.NULL);
				ConfigHelper.configTo("items", component.getVar(), component);
			}
		} else if (component instanceof Viewport) {
			component.setRenderTo(Ext.NULL);
			component.handleConfig("contentEl", null);
		}
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		BoxComponent box = (BoxComponent) component;
		boolean notRenderChildren = !RequestUtils.isAjaxRequest() && box instanceof Panel && this.isAutoLoad((Panel) box)
				&& !ComponentUtil.isActiveItem(box);
		if (notRenderChildren) {
			ResponseWriter writer = context.getResponseWriter();
			writer.write("<!-- The content is updated lazy use ajax by fence -->");
		} else {
			super.encodeChildren(context, component);
		}
	}

	private boolean isNeedUpdateInClient(BoxComponent component) {
		AsyncResponse async = AsyncResponse.getInstance();
		if (RequestUtils.isAjaxRequest() && ComponentUtil.isHaeresNatus(component)) {
			if (async.isRenderRoot(component) && !RequestUtils.isUpdaterRequest()) {
				return true;
			}
			if (RequestUtils.isUpdaterRequest() && async.isRenderRoot(component.getParent())) {
				return true;
			}
		}
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
			if (!StringUtil.isEmpty(defaultSrc)) {
				String actionPath = FacesUtils.getViewHandler(context).getActionURL(context, defaultSrc);
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
