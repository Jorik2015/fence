package com.abner.highchart;

public class Title {
	public static Title getInstance() {
		return new Title();
	}

	private String align_;

	public String getAlign() {
		return this.align_;
	}

	public Title setAlign(String _align) {
		this.align_ = _align;
		return this;
	}

	private String enabled_;

	public String getEnabled() {
		return this.enabled_;
	}

	public Title setEnabled(String _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private Number margin_;

	public Number getMargin() {
		return this.margin_;
	}

	public Title setMargin(Number _margin) {
		this.margin_ = _margin;
		return this;
	}

	private Number offset_;

	public Number getOffset() {
		return this.offset_;
	}

	public Title setOffset(Number _offset) {
		this.offset_ = _offset;
		return this;
	}

	private Number rotation_;

	public Number getRotation() {
		return this.rotation_;
	}

	public Title setRotation(Number _rotation) {
		this.rotation_ = _rotation;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Title setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}

	private String text_;

	public String getText() {
		return this.text_;
	}

	public Title setText(String _text) {
		this.text_ = _text;
		return this;
	}
}