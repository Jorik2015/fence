package com.abner;

import java.util.HashMap;
import java.util.Map;

public class XtypeMap {
	public static Map<String, String> xytpes = new HashMap<String, String>();

	public static String getXtype(String name) {
		for (Map.Entry<String, String> entry : xytpes.entrySet()) {
			String key = entry.getKey().trim();
			String value = entry.getValue().trim();
			if (value.equals(name))
				return "@XType(\"" + key + "\")";
		}
		return "";
	}

	static {
		xytpes.put("box", "Ext.BoxComponent");
		xytpes.put("button          ", "Ext.Button                 ");
		xytpes.put("buttongroup     ", "Ext.ButtonGroup            ");
		xytpes.put("colorpalette    ", "Ext.ColorPalette           ");
		xytpes.put("component       ", "Ext.Component              ");
		xytpes.put("container       ", "Ext.Container              ");
		xytpes.put("cycle           ", "Ext.CycleButton            ");
		xytpes.put("dataview        ", "Ext.DataView               ");
		xytpes.put("datepicker      ", "Ext.DatePicker             ");
		xytpes.put("editor          ", "Ext.Editor                 ");
		xytpes.put("editorgrid      ", "Ext.grid.EditorGridPanel   ");
		xytpes.put("flash           ", "Ext.FlashComponent         ");
		xytpes.put("grid            ", "Ext.grid.GridPanel         ");
		xytpes.put("listview        ", "Ext.ListView               ");
		xytpes.put("panel           ", "Ext.Panel                  ");
		xytpes.put("progress        ", "Ext.ProgressBar            ");
		xytpes.put("propertygrid    ", "Ext.grid.PropertyGrid      ");
		xytpes.put("slider          ", "Ext.Slider                 ");
		xytpes.put("spacer          ", "Ext.Spacer                 ");
		xytpes.put("splitbutton     ", "Ext.SplitButton            ");
		xytpes.put("tabpanel        ", "Ext.TabPanel               ");
		xytpes.put("treepanel       ", "Ext.tree.TreePanel         ");
		xytpes.put("viewport        ", "Ext.ViewPort               ");
		xytpes.put("window          ", "Ext.Window                 ");

		// Toolbar components
		// ---------------------------------------
		xytpes.put("paging          ", " Ext.PagingToolbar         ");
		xytpes.put("toolbar         ", " Ext.Toolbar               ");
		xytpes.put("tbfill          ", " Ext.Toolbar.Fill          ");
		xytpes.put("tbitem          ", " Ext.Toolbar.Item          ");
		xytpes.put("tbseparator     ", " Ext.Toolbar.Separator     ");
		xytpes.put("tbspacer        ", " Ext.Toolbar.Spacer        ");
		xytpes.put("tbtext          ", " Ext.Toolbar.TextItem      ");

		// Menu components
		// ---------------------------------------
		xytpes.put("menu           ", " Ext.menu.Menu      ");
		xytpes.put("colormenu      ", " Ext.menu.ColorMenu ");
		xytpes.put("datemenu       ", " Ext.menu.DateMenu  ");
		xytpes.put("menubaseitem   ", " Ext.menu.BaseItem  ");
		xytpes.put("menucheckitem  ", " Ext.menu.CheckItem ");
		xytpes.put("menuitem       ", " Ext.menu.Item      ");
		xytpes.put("menuseparator  ", " Ext.menu.Separator ");
		xytpes.put("menutextitem   ", " Ext.menu.TextItem  ");

		// Form components
		// ---------------------------------------
		xytpes.put("form           ", " Ext.form.FormPanel      ");
		xytpes.put("checkbox       ", " Ext.form.Checkbox       ");
		xytpes.put("checkboxgroup  ", " Ext.form.CheckboxGroup  ");
		xytpes.put("combo          ", " Ext.form.ComboBox       ");
		xytpes.put("compositefield ", "Ext.form.CompositeField");
		xytpes.put("datefield      ", " Ext.form.DateField      ");
		xytpes.put("displayfield   ", " Ext.form.DisplayField   ");
		xytpes.put("field          ", " Ext.form.Field          ");
		xytpes.put("fieldset       ", " Ext.form.FieldSet       ");
		xytpes.put("hidden         ", " Ext.form.Hidden         ");
		xytpes.put("htmleditor     ", " Ext.form.HtmlEditor     ");
		xytpes.put("label          ", " Ext.form.Label          ");
		xytpes.put("numberfield    ", " Ext.form.NumberField    ");
		xytpes.put("radio          ", " Ext.form.Radio          ");
		xytpes.put("radiogroup     ", " Ext.form.RadioGroup     ");
		xytpes.put("textarea       ", " Ext.form.TextArea       ");
		xytpes.put("textfield      ", " Ext.form.TextField      ");
		xytpes.put("timefield      ", " Ext.form.TimeField      ");
		xytpes.put("trigger        ", " Ext.form.TriggerField   ");

		// Chart components
		// ---------------------------------------
		xytpes.put("chart           ", " Ext.chart.Chart         ");
		xytpes.put("barchart        ", " Ext.chart.BarChart      ");
		xytpes.put("cartesianchart  ", " Ext.chart.CartesianChart");
		xytpes.put("columnchart     ", " Ext.chart.ColumnChart   ");
		xytpes.put("linechart       ", " Ext.chart.LineChart     ");
		xytpes.put("piechart        ", " Ext.chart.PieChart      ");

		// Store xtypes
		// ---------------------------------------
		xytpes.put("arraystore      ", "Ext.data.ArrayStore    ");
		xytpes.put("directstore     ", "Ext.data.DirectStore   ");
		xytpes.put("groupingstore   ", "Ext.data.GroupingStore ");
		xytpes.put("jsonstore       ", "Ext.data.JsonStore     ");
		xytpes.put("simplestore     ", "Ext.data.SimpleStore   ");
		xytpes.put("store           ", "Ext.data.Store         ");
		xytpes.put("xmlstore        ", "Ext.data.XmlStore      ");
	}
}
