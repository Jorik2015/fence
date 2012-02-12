package com.abner;

import java.io.File;
import java.io.FileFilter;

public class XhtmlFileFilter implements FileFilter {

	private static String[] endWiths = { "Mgr.html", "Error.html", "CompositeElementLite.html",
			"CompositeElement.html", "Ajax.html", "Cookies.html", "Css.html", "Api.html", "Fx.html", "VTypes.html",
			"Ext.html", "Ext.History.html", "KeyMap.html", "KeyNav.html", "Layer.html", ".Shadow.html",
			"QuickTips.html", ".DomHelper.html", "DomQuery.html" };

	public boolean accept(File pathname) {
		String name = pathname.getName();
		if (!name.endsWith(".html"))
			return false;

		if (!name.startsWith("Ext."))
			return false;

		if (name.startsWith("Ext.state."))
			return false;

		if (name.startsWith("Ext.util.") && !name.endsWith(".Observable.html"))
			return false;

		for (String ends : endWiths) {
			if (name.endsWith(ends))
				return false;
		}

		return true;
	}

}
