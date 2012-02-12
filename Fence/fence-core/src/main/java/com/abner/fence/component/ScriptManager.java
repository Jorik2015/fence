package com.abner.fence.component;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.context.FacesContext;

import com.abner.fence.annotation.ParseConfigMode;
import com.abner.fence.commons.Enums.PersistenceMode;
import com.abner.fence.resources.ExtResources;
import com.abner.fence.utils.AjaxJSUtils;
import com.abner.fence.utils.FacesUtils;
import com.abner.fence.utils.JSUtils;
import com.abner.fence.utils.RequestUtils;
import com.abner.fence.web.RequestContext;
import com.abner.fence.web.ScriptReository;

@ParseConfigMode(pmode = PersistenceMode.Component)
@ResourceDependencies({
	    @ResourceDependency(library = "ext#{ext.version}/resources/css", name = "ext-all#{ext.debugSuffix}.css"),
		@ResourceDependency(library = "ext#{ext.version}/adapter/#{ext.adapter}", name = "#{ext.adapter}#{ext.debugSuffix}.js"),
		@ResourceDependency(library = "ext#{ext.version}/adapter/#{ext.adapter}", name = "ext-#{ext.adapter}-adapter#{ext.debugSuffix}.js"),
		@ResourceDependency(library = "ext#{ext.version}", name = "ext-all#{ext.debugSuffix}.js"),
		@ResourceDependency(name = "fencebase#{ext.debugSuffix}.js"), })
public class ScriptManager extends ExtComponent {
	private static final String CHART_URL_KEY = "Ext.chart.Chart.CHART_URL";
	private static final String ComponentType = "Ext.ScriptManager";
	public static final String ScriptManager = "fence_runtime_script.js";
	public static final String ExecuteMethodTemp = "{0}.{1}({2});";
	public static final String IncludeJSTemp = "Fence.includeJS(''{0}'');";
	public static final String IncludeCssTemp = "Fence.includeCss(''{0}'');";
	public static final String OnReadyTemplate = "Ext.onReady(function(){0});";
	public static final String NewComponentTemp = "{0} = new {1}({2});";
	public static final String NewConfigTemp = "{0} = {2};";
	public static final String OnWindowResizeTemplate = "Ext.EventManager.onWindowResize({0});";
	public static final String ScriptBlockTemplate = "\t<script type=\"text/javascript\">\n\t//<![CDATA[\n\t\t{0}\n\t//]]>\n\t</script>\n";
	public static final String ScriptIncludeTemplate = "\t<script type=\"text/javascript\" src=\"{0}\"></script>\n";
	public static final String StyleBlockTemplate = "\t<style type=\"text/css\">\n{0}\t</style>\n";
	public static final String StyleIncludeTemplate = "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"{0}\" />\n";
	public static final String CommentTemplate = "\n\t<!-- {0} -->\n";
	public static final String EmptyFn = "Ext.EmptyFn";
	public static final String FunctionTemplate = "function()'{'{0}'}'";
	public static final String FunctionTemplateWithParams = "function({0})'{'{1}'}'";
	public static final String AJAX_PATH = "Fence.ActionPath";
	public static final String AJAX_REQUEST_TEMP = "Fence.request({0},{1},{2});";
	public static final String ADDLISTENER_TEMP = "{0}.on(''{1}'',{2});";
	public static final String REMOVELISTENER_TEMP = "{0}.un(''{1}'',{2});";
	public static final String ConfirmTemp = "Fence.confirm(''{0}'',{1});";
	public static final String MESSAGE_WIN_VAR = "Fence_MW";
	public static final String All_HTML_CONTENT_DIV_VAR = "FenceHtmlContentDiv";

	private String adapter;
	private boolean debug;
	private String theme;
	private String version = com.abner.fence.utils.ExtUtils.VERSION;
	private boolean jsSingleFile = true;
	private ScriptReository scriptReository;
	private boolean ux = false;
	private List<String> icons = new ArrayList<String>();

	@Override
	public String getFamily() {
		this.setRendererType(ComponentType);
		return (ComponentType);
	}

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		scriptReository = JSUtils.getScriptReository();
		ScriptManager manager = (ScriptManager) RequestContext.instance().get(ComponentType);
		if (manager != null) {
			throw new IllegalArgumentException("The ScriptManager only one in page.");
		}

		RequestContext.instance().put(ComponentType, this);

		scriptReository.RegisterGlobalClientScript("Fence.AppPath = '" + FacesUtils.getHostAppPath() + "';");
		scriptReository.RegisterGlobalClientScript(AJAX_PATH + " = '" + RequestUtils.getAjaxActionPath() + "';");
		scriptReository.RegisterGlobalClientScript("Ext.BLANK_IMAGE_URL = '"
				+ FacesUtils.extContext().getRequestContextPath() + "/"
				+ MessageFormat.format(ExtResources.BLANK_IMAGE_URL, version) + "';");
		scriptReository.RegisterGlobalClientScript(CHART_URL_KEY + " = '" + FacesUtils.extContext().getRequestContextPath()
				+ "/" + MessageFormat.format(ExtResources.CHART_URL, version) + "';");
		scriptReository.RegisterGlobalClientScript(JSUtils.getGlobalScript());

		// show all the content div
		if (!RequestUtils.isAjaxRequest()) {
			scriptReository.putGlobalVar(All_HTML_CONTENT_DIV_VAR);
			scriptReository.RegisterBeforeClientInitScript(All_HTML_CONTENT_DIV_VAR + " = new Ext.util.MixedCollection();");
			AjaxJSUtils.showAllContentDiv();
		}

		super.encodeAll(context);
	}

	public String getAdapter() {
		return adapter;
	}

	public void setAdapter(String adapter) {
		this.adapter = adapter;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isUx() {
		return ux;
	}

	public void setUx(boolean ux) {
		RequestContext.instance().put("ux", ux);
		this.ux = ux;
	}

	public List<String> getIcons() {
		return icons;
	}

	public void addIcons(String icons) {
		if (!this.icons.contains(icons)) {
			this.icons.add(icons);
		}
	}

	private Object[] _values;

	@Override
	public void restoreState(FacesContext context, Object state) {
		_values = (Object[]) state;
		super.restoreState(context, _values[0]);
		this.adapter = (String) _values[1];
		this.debug = Boolean.parseBoolean(_values[2].toString());
		this.theme = (String) _values[3];
		this.version = (String) _values[4];
		this.jsSingleFile = Boolean.parseBoolean(_values[5].toString());
		this.ux = Boolean.parseBoolean(_values[6].toString());
	}

	@Override
	public Object saveState(FacesContext context) {
		if (_values == null)
			_values = new Object[7];

		_values[0] = super.saveState(context);
		_values[1] = adapter;
		_values[2] = debug;
		_values[3] = theme;
		_values[4] = version;
		_values[5] = jsSingleFile;
		_values[6] = ux;
		return _values;
	}

	public void reset() {
		scriptReository.reset();
	}
}
