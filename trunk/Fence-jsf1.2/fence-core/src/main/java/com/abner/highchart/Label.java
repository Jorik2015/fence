package com.abner.highchart;

public class Label {
	public static Label getInstance() {
		return new Label();
	}

	private String align_;

	public String getAlign() {
		return this.align_;
	}

	public Label setAlign(String _align) {
		this.align_ = _align;
		return this;
	}

	private String verticalAlign_;

	public String getVerticalAlign() {
		return this.verticalAlign_;
	}

	public Label setVerticalAlign(String _verticalAlign) {
		this.verticalAlign_ = _verticalAlign;
		return this;
	}

	private Number rotation_;

	public Number getRotation() {
		return this.rotation_;
	}

	public Label setRotation(Number _rotation) {
		this.rotation_ = _rotation;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Label setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}

	private String textAlign_;

	public String getTextAlign() {
		return this.textAlign_;
	}

	public Label setTextAlign(String _textAlign) {
		this.textAlign_ = _textAlign;
		return this;
	}

	private Number x_;

	public Number getX() {
		return this.x_;
	}

	public Label setX(Number _x) {
		this.x_ = _x;
		return this;
	}

	private Number y_;

	public Number getY() {
		return this.y_;
	}

	public Label setY(Number _y) {
		this.y_ = _y;
		return this;
	}
}