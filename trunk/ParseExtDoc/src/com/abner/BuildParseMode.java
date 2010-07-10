package com.abner;

import java.text.MessageFormat;

public class BuildParseMode {
	private static String modeTemp = "@ParseConfigMode({0}pmode=PersistenceMode.{1},rmode=ReferenceMode.{2})";

	public static String getMode(String name) {
		if (name.endsWith("AsyncTreeNode")) {
			return MessageFormat.format(modeTemp, "ui = false,name=\"root\",", "ParentProperty", "Var");
		} else if (name.endsWith("Region")) {
			return MessageFormat.format(modeTemp, "ui = false,", "InnerProperty", "Config");
		} else if (name.endsWith("Layout"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"layoutConfig\",", "ParentProperty", "Config");
		else if (name.endsWith("Axis"))
			return MessageFormat.format(modeTemp, "ui = false,", "Custom", "Var");
		else if (name.endsWith("Series"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"series\",", "ParentProperty", "Var");
		else if (name.endsWith("Store"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"store\",", "ParentProperty", "Var");
		else if (name.endsWith("Reader"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"reader\",", "ParentProperty", "Var");
		else if (name.endsWith("Proxy"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"proxy\",", "ParentProperty", "Var");
		else if (name.endsWith("Writer"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"writer\",", "ParentProperty", "Var");
		else if (name.endsWith("data.Field"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"fields\",", "ParentProperty", "Config");
		else if (name.endsWith("SelectionModel"))
			return MessageFormat.format(modeTemp, "name=\"selModel\",", "ParentProperty", "Var");
		else if (name.endsWith("ColumnModel"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"cm\",", "ParentProperty", "Var");
		else if (name.endsWith("BooleanColumn"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"columns\",", "ParentProperty", "Var");
		else if (name.endsWith("NumberColumn"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"columns\",", "ParentProperty", "Var");
		else if (name.endsWith("TemplateColumn"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"columns\",", "ParentProperty", "Var");
		else if (name.endsWith("DateColumn"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"columns\",", "ParentProperty", "Var");
		else if (name.endsWith("Column"))
			return MessageFormat.format(modeTemp, "ui = false,name=\"columns\",", "ParentProperty", "Config");
		else if (name.endsWith("View"))// note
			return MessageFormat.format(modeTemp, "ui = false,name=\"view\",", "ParentProperty", "Var");
		else if (name.startsWith("Ext.menu.") && name.endsWith("Item"))
			return MessageFormat.format(modeTemp, "name=\"items\",", "ParentProperty", "Config");
		else if (name.startsWith("Ext.menu.") && name.endsWith("Menu"))
			return MessageFormat.format(modeTemp, "name=\"menu\",", "ParentProperty", "Var");
		else if (name.startsWith("Ext.Toolbar."))
			return MessageFormat.format(modeTemp, "name=\"items\",", "ParentProperty", "Config");
		else if (name.equals("Ext.Action"))
			return MessageFormat.format(modeTemp, "ui = false,", "Custom", "Var");
		else if(name.endsWith("Ext.ux.TabCloseMenu")){
			return MessageFormat.format(modeTemp,"name=\"plugins\",ui=false,","ParentProperty","Var");
		}
		return "";
	}
}
