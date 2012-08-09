package com.abner.highchart;

public class Select {
	public static Select getInstance() {
		return new Select();
	}

	private Boolean enabled_;

	public Boolean getEnabled() {
		return this.enabled_;
	}

	public Select setEnabled(Boolean _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private String fillColor_;

	public String getFillColor() {
		return this.fillColor_;
	}

	public Select setFillColor(String _fillColor) {
		this.fillColor_ = _fillColor;
		return this;
	}

	private String lineColor_;

	public String getLineColor() {
		return this.lineColor_;
	}

	public Select setLineColor(String _lineColor) {
		this.lineColor_ = _lineColor;
		return this;
	}

	private Number lineWidth_;

	public Number getLineWidth() {
		return this.lineWidth_;
	}

	public Select setLineWidth(Number _lineWidth) {
		this.lineWidth_ = _lineWidth;
		return this;
	}

	private Number radius_;

	public Number getRadius() {
		return this.radius_;
	}

	public Select setRadius(Number _radius) {
		this.radius_ = _radius;
		return this;
	}
}