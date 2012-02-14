package com.abner.fence.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.faces.context.ResponseWriter;

import com.abner.fence.lifecycle.AsyncResponse;
import com.abner.fence.resources.ScriptManager;
import com.abner.fence.web.ScriptReository;

import ext.util.FacesUtils;
import ext.util.StringUtil;

public class WriterUtils {
	public final static String PARTIAL_TAG = "response";

	public static ResponseWriter writerState(ResponseWriter writer) throws IOException {
		if (writer == null)
			throw new NullPointerException("writer can't be null.");
		
		if(!RequestUtils.isPostBack())
			return writer;

		AsyncResponse async = AsyncResponse.getInstance();
		writer.write("<state>");
		String state = async.getViewState(FacesUtils.context());
		writer.write("<![CDATA[" + state + "]]>");
		writer.write("</state>");
		return writer;
	}

	public static ResponseWriter writerAjaxScript(ResponseWriter writer) throws IOException {
		if (writer == null)
			throw new NullPointerException("writer can't be null.");

		String script = writePageScript();
		if(!StringUtil.isEmpty(script)){
			writer.write("<scripts>");
			writer.write("<![CDATA[");
			writer.write(script);
			writer.write("]]>");
			writer.write("</scripts>");
		}

		return writer;
	}
	
	public static void writeExecuteScript(ResponseWriter writer) throws IOException{
		String temp = ScriptManager.ScriptBlockTemplate;
		String script = writePageScript();
		if(!StringUtil.isEmpty(script))
			writer.write(MessageFormat.format(temp, writePageScript()));
	}

	private static String writePageScript() throws IOException {
		ScriptReository sr = JSUtils.getScriptReository();
		if (sr == null || sr.isEmpty())
			return "";

		StringBuilder builder = getAjaxHeaderScript(sr.getGlobalVar());

		List<String> scripts = sr.getScriptGlobalClientInitBag();
		for (String s : scripts) {
			builder.append(s.trim() + "\n");
		}

		StringBuffer initScript = new StringBuffer(265);

		scripts = sr.getScriptBeforeClientInitBag();
		for (String s : scripts) {
			initScript.append(s.trim() + "\n");
		}

		scripts = sr.getScriptClientInitBag();
		for (String s : scripts) {
			initScript.append(s.trim() + "\n");
		}

		scripts = sr.getScriptAfterClientInitBag();
		for (String s : scripts) {
			initScript.append(s.trim() + "\n");
		}

		builder.append(initScript);
		return builder.toString();
	}
	
	private static StringBuilder getAjaxHeaderScript(String globarVar){
		StringBuilder builder = new StringBuilder(265);

		builder.append("var ajax_vars = new Ext.util.MixedCollection();");
		builder.append("ajax_vars.addAll('");
		builder.append(globarVar);
		builder.append("'.split(','));");
		builder.append("ajax_vars.each(function(item){");
		builder.append("	if(typeof item == 'undefined'){eval('var ' + item);}");
		builder.append("});\n");
		
		return builder;
	}
}
