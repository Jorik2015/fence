package com.abner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abner.model.Config;
import com.abner.model.ExtClass;

public class ExtClassHelper {

	private static Map<String, String> mergeConfig = new HashMap<String, String>();
	private static Map<String, String> aliasConfig = new HashMap<String, String>();

	static {
		mergeConfig.put("FormPanel", "Ext.form.BasicForm");
		mergeConfig.put("ArrayStore", "Ext.data.ArrayReader");
		mergeConfig.put("JsonStore", "Ext.data.JsonReader");
		mergeConfig.put("DataProxy", "Ext.data.Connection");

		mergeConfig.put("ExtLayout", "Ext.layout.ContainerLayout");
		mergeConfig.put("ContainerLayout", "Ext.layout.AbsoluteLayout");
		mergeConfig.put("AbsoluteLayout", "Ext.layout.AccordionLayout");
		mergeConfig.put("AccordionLayout", "Ext.layout.AnchorLayout");
		mergeConfig.put("AnchorLayout", "Ext.layout.AutoLayout");
		mergeConfig.put("AutoLayout", "Ext.layout.BorderLayout");
		mergeConfig.put("BorderLayout", "Ext.layout.BoxLayout");
		mergeConfig.put("BoxLayout", "Ext.layout.CardLayout");
		mergeConfig.put("CardLayout", "Ext.layout.ColumnLayout");
		mergeConfig.put("ColumnLayout", "Ext.layout.FitLayout");
		mergeConfig.put("FitLayout", "Ext.layout.FormLayout");
		mergeConfig.put("FormLayout", "Ext.layout.HBoxLayout");
		mergeConfig.put("HBoxLayout", "Ext.layout.MenuLayout");
		mergeConfig.put("MenuLayout", "Ext.layout.TableLayout");
		mergeConfig.put("TableLayout", "Ext.layout.ToolbarLayout");
		mergeConfig.put("ToolbarLayout", "Ext.layout.VBoxLayout");
		mergeConfig.put("VBoxLayout", "Ext.layout.BorderLayout.Region");
		mergeConfig.put("Region", "Ext.layout.BorderLayout.SplitRegion");

		aliasConfig.put("ext.form.TextField.validator", "eValidator");
	}

	public static String getMerge(ExtClass pclass) {
		return mergeConfig.get(pclass.getClazz());
	}

	public static String getAlias(String configName) {
		return aliasConfig.get(configName);
	}

	private static void hackConfig(ExtClass ext) {
		if (ext.getClazz().equals("Node") && ext.getPk().equals("ext.data")) {
			Config cfg = new Config("childs", "Object");
			cfg.setClientConfig("@ClientConfig(value = JsonMode.Array, name = \"children\")");
			cfg.setMsource("Node");
			cfg.setUpname("Childs");
			ext.getConfigs().add(cfg);
		}
		if (ext.getClazz().equals("Chart")) {
			Config cfg = new Config("store", "Object");
			cfg.setClientConfig("@ClientConfig(value = JsonMode.Object)");
			cfg.setMsource("Chart");
			cfg.setUpname("Store");
			ext.getConfigs().add(cfg);
		}

		if (ext.getClazz().equals("Store")) {
			for (Config config : ext.getConfigs()) {
				if (config.getName().equalsIgnoreCase("data")) {
					config.setClientConfig("@ClientConfig(value = JsonMode.Object)");
				}
			}
		}

		if (ext.getClazz().equals("Panel")) {
			for (Config config : ext.getConfigs()) {
				if (config.getName().equalsIgnoreCase("padding")) {
					config.setType("String");
				} 
			}
		}

		if (ext.getClazz().equals("Field")) {
			List<Config> cfg = new ArrayList<Config>();
			for (Config config : ext.getConfigs()) {
				if (config.getName().equalsIgnoreCase("value")) {
					// config.setClientConfig("");
					continue;
				}
				cfg.add(config);
			}
			ext.setConfigs(cfg);
			
			if(ext.getPk().equals("ext.data")){
				for (Config config : ext.getConfigs()) {
					if (config.getName().equalsIgnoreCase("type")) {
						config.setClientConfig("");
					}
				}
			}
		}

		if (ext.getClazz().equals("Menu")) {
			for (Config config : ext.getConfigs()) {
				if (config.getName().equalsIgnoreCase("items")) {
					config.setClientConfig("@ClientConfig(JsonMode.Array)");
				}
			}
		}
		if (ext.getClazz().equals("TextItem")) {
			ext.setXtype("//@XType(\"menutextitem\")");
		}
		if (ext.getClazz().equals("BaseItem")) {
			Config cfg = new Config();
			cfg.setClientConfig("@ClientConfig(JsonMode.Object)");
			cfg.setMsource("BaseItem");
			cfg.setName("menu");
			cfg.setType("Object");
			cfg.setUpname("Menu");
			ext.getConfigs().add(cfg);
		}
	}

	public static String getExtends(ExtClass ext) {
		hackConfig(ext);
		String result = ext.getExtend();
		if (null == result || "Object".equalsIgnoreCase(result))
			result = "ExtComponent";

		if (result.indexOf(".") > 0) {
			result = result.substring(result.lastIndexOf(".") + 1);
		}

		if (ext.getPk().equalsIgnoreCase("Ext") && ext.getClazz().equalsIgnoreCase("Action")) {
			result = "HackAction";
		}
		
		if (ext.getPk().equalsIgnoreCase("Ext.slider") && ext.getClazz().equalsIgnoreCase("Tip")) {
			result = "ext.Tip";
		}

		if (ext.getClazz().equalsIgnoreCase("BaseItem")) {
			result = "ExtCommand";
		}

		if (ext.getClazz().equals("Container"))
			return "com.abner.fence.component.ExtLayout";

		if (ext.getClazz().equalsIgnoreCase("Button"))
			result = "HackButton";

		if (ext.getPk().equalsIgnoreCase("Ext.form") && ext.getClazz().equalsIgnoreCase("Field"))
			result = "com.abner.fence.component.ExtInput";

		if (ext.getClazz().equals("ItemSelector") || ext.getClazz().equals("MultiSelect"))
			return "ext.form.Field";

		if (ext.getClazz().equals("Store"))
			return "com.abner.fence.component.ExtCommand";

		if (result.equals("Observable"))
			return "ext.util.Observable";

		return result;
	}
}
