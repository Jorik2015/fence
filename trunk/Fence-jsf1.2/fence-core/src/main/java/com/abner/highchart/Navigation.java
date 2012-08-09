package com.abner.highchart;

public class Navigation {
	public static Navigation getInstance() {
		return new Navigation();
	}

	private Object menuStyle_;

	public Object getMenuStyle() {
		return this.menuStyle_;
	}

	public Navigation setMenuStyle(Object _menuStyle) {
		this.menuStyle_ = _menuStyle;
		return this;
	}

	private Object menuItemStyle_;

	public Object getMenuItemStyle() {
		return this.menuItemStyle_;
	}

	public Navigation setMenuItemStyle(Object _menuItemStyle) {
		this.menuItemStyle_ = _menuItemStyle;
		return this;
	}

	private Object menuItemHoverStyle_;

	public Object getMenuItemHoverStyle() {
		return this.menuItemHoverStyle_;
	}

	public Navigation setMenuItemHoverStyle(Object _menuItemHoverStyle) {
		this.menuItemHoverStyle_ = _menuItemHoverStyle;
		return this;
	}

	private ButtonOptions buttonOptions_;

	public ButtonOptions getButtonOptions() {
		return this.buttonOptions_;
	}

	public Navigation setButtonOptions(ButtonOptions _buttonOptions) {
		this.buttonOptions_ = _buttonOptions;
		return this;
	}
}