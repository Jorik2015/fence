package com.abner.fence.renderkit;

import java.io.IOException;
import java.text.MessageFormat;

import javax.faces.context.FacesContext;

import com.abner.fence.resources.ExtResources;
import com.abner.fence.util.Ext;
import com.abner.fence.util.JSUtils;
import com.abner.fence.web.RequestContext;

import ext.annotation.UXResources;
import ext.base.IExt;
import ext.util.FacesUtils;
import ext.util.StringUtil;

@SuppressWarnings("unchecked")
public class ExtPluginRenderer extends ExtBasicRenderer {
	private static final String includeJSTemp = "Fence.includeJS(''{0}'');";
	private static final String includeCssTemp = "Fence.includeCss(''{0}'');";

	@Override
	public void beforeEncodeBegin(FacesContext context, IExt component)
			throws IOException {
		addPluginResources(component);
	}

	public static void addPluginResources(IExt component) {
		Boolean ux = (Boolean) RequestContext.instance().get("ux");
		if (ux != null && ux.booleanValue())
			return;

		Class<?> clazz = component.getClass();
		UXResources resources = clazz.getAnnotation(UXResources.class);
		if (resources != null) {
			String[] jss = resources.js();
			String css = resources.css();
			for (String js : jss) {
				if (!StringUtil.isEmpty(js)) {
					js = FacesUtils.extContext().getRequestContextPath()
							+ ExtResources.PREFIX + js;
					js = js.replaceAll("\\[version\\]", Ext.VERSION);
					js = MessageFormat.format(includeJSTemp, js);
					JSUtils.getScriptReository()
							.RegisterGlobalClientScript(js);
				}
			}

			if (!StringUtil.isEmpty(css)) {
				css = FacesUtils.extContext().getRequestContextPath()
						+ ExtResources.PREFIX + css;
				css = css.replaceAll("\\[version\\]", Ext.VERSION);
				css = MessageFormat.format(includeCssTemp, css);
				JSUtils.getScriptReository()
						.RegisterGlobalClientScript(css);
			}
		}
	}
}
