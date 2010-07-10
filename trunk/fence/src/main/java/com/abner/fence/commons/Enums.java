package com.abner.fence.commons;

public class Enums {
	public enum PersistenceMode {
		Component, ParentProperty, InnerProperty, Custom;
	}

	public enum ReferenceMode {
		Var, Config, Build,Name
	}

	public enum JsonMode {
		Array, Custom, Ignore, Object, Raw, Value, Function
	}

	public enum LayoutType {
		container, absolute, accordion, anchor, auto, border, box, card, column, fit, form, hbox, menu, table, toolbar, vbox, none, center, row
	}

	public enum AdapterType {
		EXT, YUI, JQUERY, PROTOTYPE
	}

	public enum ButtonType {
		SUBMIT, BUTTON, RESET, LOAD, NONE
	}
}
