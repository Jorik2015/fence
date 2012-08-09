package com.abner.highchart;

public class Credits {
	public static Credits getInstance() {
		return new Credits();
	}

	private Boolean enabled_;

	public Boolean getEnabled() {
		return this.enabled_;
	}

	public Credits setEnabled(Boolean _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private Object position_;

	public Object getPosition() {
		return this.position_;
	}

	public Credits setPosition(Object _position) {
		this.position_ = _position;
		return this;
	}

	private String href_;

	public String getHref() {
		return this.href_;
	}

	public Credits setHref(String _href) {
		this.href_ = _href;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Credits setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}

	private String text_;

	public String getText() {
		return this.text_;
	}

	public Credits setText(String _text) {
		this.text_ = _text;
		return this;
	}
}