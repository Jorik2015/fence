package com.abner.fence.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ext.base.IExt;
import ext.util.StringUtil;

public final class ScriptReository {
	public final static String SCRIPT_REPOSITORY = "ScriptReository";
	public final static String SCRIPT_REPOSITORY_KEY = "jsres_key_";
	private final Set<String> globalVar = new HashSet<String>();
	private final List<String> scriptGlobalClientBag = new ArrayList<String>();
	private final List<String> scriptBeforeClientInitBag = new ArrayList<String>();
	private final List<String> scriptAfterClientInitBag = new ArrayList<String>();
	private final List<String> scriptClientInitBag = new ArrayList<String>();
	private final Map<IExt, List<String>> scriptClickListener = new HashMap<IExt, List<String>>();

	public List<String> getScriptGlobalClientInitBag() {
		return this.scriptGlobalClientBag;
	}

	public void RegisterGlobalClientScript(String script) {
		if (StringUtil.isEmpty(script)
				|| scriptGlobalClientBag.contains(script))
			return;
		this.scriptGlobalClientBag.add(script);
	}

	public List<String> getScriptBeforeClientInitBag() {
		return this.scriptBeforeClientInitBag;
	}

	public void RegisterBeforeClientInitScript(String script) {
		if (StringUtil.isEmpty(script)
				|| scriptBeforeClientInitBag.contains(script))
			return;
		this.scriptBeforeClientInitBag.add(script);
	}

	public List<String> getScriptAfterClientInitBag() {
		return this.scriptAfterClientInitBag;
	}

	public void RegisterAfterClientInitScript(String script) {
		if (StringUtil.isEmpty(script)
				|| scriptAfterClientInitBag.contains(script))
			return;

		this.scriptAfterClientInitBag.add(script);
	}

	public List<String> getScriptClientInitBag() {
		return this.scriptClientInitBag;
	}

	public void RegisterClientInitScript(String script) {
		if (StringUtil.isEmpty(script) || scriptClientInitBag.contains(script))
			return;

		this.scriptClientInitBag.add(script);
	}

	public Map<IExt, List<String>> getScriptClientListener() {
		return scriptClickListener;
	}

	@SuppressWarnings("unchecked")
	public List<String> getClickListener(IExt comp) {
		List<String> listeners = this.scriptClickListener.get(comp);
		if (listeners == null)
			return Collections.EMPTY_LIST;

		return listeners;
	}

	public void addClickListener(IExt comp, String listener) {
		List<String> listeners = this.scriptClickListener.get(comp);
		if (listeners == null) {
			listeners = new ArrayList<String>();
			this.scriptClickListener.put(comp, listeners);
		}
		listeners.add(listener);
	}

	public void putGlobalVar(String... var) {
		for (String s : var) {
			this.globalVar.add(s);
		}
	}

	public String getGlobalVar() {
		String result = "unavailable";
		for (Iterator<String> v = this.globalVar.iterator(); v.hasNext();) {
			result += ",";
			result += v.next();
		}
		return result;
	}

	public boolean isEmpty() {
		return this.globalVar.isEmpty()
				&& this.scriptBeforeClientInitBag.isEmpty()
				&& this.scriptAfterClientInitBag.isEmpty()
				&& this.scriptClientInitBag.isEmpty()
				&& this.scriptClickListener.isEmpty();
	}

	public void reset() {
		globalVar.clear();
		scriptBeforeClientInitBag.clear();
		scriptAfterClientInitBag.clear();
		scriptClientInitBag.clear();
		scriptGlobalClientBag.clear();
	}
}
