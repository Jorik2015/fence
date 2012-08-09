package com.abner.highchart;

public class Labels {
	public static Labels getInstance() {
		return new Labels();
	}

	private Object items_;

	public Object getItems() {
		return this.items_;
	}

	public Labels setItems(Object _items) {
		this.items_ = _items;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Labels setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}
}