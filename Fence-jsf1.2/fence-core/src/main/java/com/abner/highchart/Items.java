package com.abner.highchart;

public class Items {
	public static Items getInstance() {
		return new Items();
	}

	private String html_;

	public String getHtml() {
		return this.html_;
	}

	public Items setHtml(String _html) {
		this.html_ = _html;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Items setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}
}