package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.abner.fence.ajax.UpdateOptions;
import com.abner.fence.utils.AjaxJSUtils;
import com.abner.fence.utils.ConfigUtils;
import com.abner.fence.utils.Strings;

import ext.Updater;

public class ExtUpdaterRenderer extends ExtBasicRenderer<Updater> {

	@Override
	public void beforeEncodeBegin(FacesContext context, Updater updater) throws IOException {
		String refer = updater.getRefer();
		if (Strings.isEmpty(refer)) {
			refer = updater.getContainerId();
		}
		updater.setRefer("Ext.get(\"" + refer + "\")");

		StringBuffer script = new StringBuffer(256);
		script.append(updater.getVar());
		script.append(".showLoadIndicator = false;");

		UpdateOptions options = AjaxJSUtils.updaterOptions(context, updater);

		script.append(updater.getVar());
		script.append(".executeUpdate = function(){");
		script.append(updater.getVar());
		script.append(".update(");
		script.append(ConfigUtils.interpretConfig(options));
		script.append(");};\n");

		script.append(updater.getVar());
		script.append(".executeAutoRefresh = function(){");
		Integer interval = options.getInterval();
		if (interval != null) {
			script.append(updater.getVar());
			script.append(".startAutoRefresh(");
			script.append(interval + ",'");
			script.append(options.getUrl() + "',");
			script.append(options.getConfig("params") + ",");
			script.append(options.getCallback() + ",");
			script.append(options.getRefreshNow());
			script.append(");");
		}
		script.append("};\n");
		script.insert(0, "\n");

		Boolean refreshNow = options.getRefreshNow();
		if (interval != null && refreshNow != null && refreshNow.booleanValue()) {
			script.append(updater.getVar() + ".executeAutoRefresh();");
		}

		this.appendScriptAfter(updater, script.toString());
	}
}
