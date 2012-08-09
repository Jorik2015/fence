package com.abner.highchart;

public class StackLabels {
	public static StackLabels getInstance() {
		return new StackLabels();
	}

	private String align_;

	public String getAlign() {
		return this.align_;
	}

	public StackLabels setAlign(String _align) {
		this.align_ = _align;
		return this;
	}

	private String textAlign_;

	public String getTextAlign() {
		return this.textAlign_;
	}

	public StackLabels setTextAlign(String _textAlign) {
		this.textAlign_ = _textAlign;
		return this;
	}

	private String verticalAlign_;

	public String getVerticalAlign() {
		return this.verticalAlign_;
	}

	public StackLabels setVerticalAlign(String _verticalAlign) {
		this.verticalAlign_ = _verticalAlign;
		return this;
	}

	private Boolean enabled_;

	public Boolean getEnabled() {
		return this.enabled_;
	}

	public StackLabels setEnabled(Boolean _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private Object formatter_;

	public Object getFormatter() {
		return this.formatter_;
	}

	public StackLabels setFormatter(Object _formatter) {
		this.formatter_ = _formatter;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public StackLabels setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}

	private Number rotation_;

	public Number getRotation() {
		return this.rotation_;
	}

	public StackLabels setRotation(Number _rotation) {
		this.rotation_ = _rotation;
		return this;
	}

	private Number x_;

	public Number getX() {
		return this.x_;
	}

	public StackLabels setX(Number _x) {
		this.x_ = _x;
		return this;
	}

	private Number y_;

	public Number getY() {
		return this.y_;
	}

	public StackLabels setY(Number _y) {
		this.y_ = _y;
		return this;
	}
}