package com.abner.highchart;

public class Subtitle {
	public static Subtitle getInstance() {
		return new Subtitle();
	}

	private String align_;

	public String getAlign() {
		return this.align_;
	}

	public Subtitle setAlign(String _align) {
		this.align_ = _align;
		return this;
	}

	private Boolean floating_;

	public Boolean getFloating() {
		return this.floating_;
	}

	public Subtitle setFloating(Boolean _floating) {
		this.floating_ = _floating;
		return this;
	}

	private String text_;

	public String getText() {
		return this.text_;
	}

	public Subtitle setText(String _text) {
		this.text_ = _text;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Subtitle setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}

	private String verticalAlign_;

	public String getVerticalAlign() {
		return this.verticalAlign_;
	}

	public Subtitle setVerticalAlign(String _verticalAlign) {
		this.verticalAlign_ = _verticalAlign;
		return this;
	}

	private Number x_;

	public Number getX() {
		return this.x_;
	}

	public Subtitle setX(Number _x) {
		this.x_ = _x;
		return this;
	}

	private Number y_;

	public Number getY() {
		return this.y_;
	}

	public Subtitle setY(Number _y) {
		this.y_ = _y;
		return this;
	}
}