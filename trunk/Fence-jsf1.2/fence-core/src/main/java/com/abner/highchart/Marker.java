package com.abner.highchart;

public class Marker {
	public static Marker getInstance() {
		return new Marker();
	}

	private Boolean enabled_;

	public Boolean getEnabled() {
		return this.enabled_;
	}

	public Marker setEnabled(Boolean _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private String fillColor_;

	public String getFillColor() {
		return this.fillColor_;
	}

	public Marker setFillColor(String _fillColor) {
		this.fillColor_ = _fillColor;
		return this;
	}

	private String lineColor_;

	public String getLineColor() {
		return this.lineColor_;
	}

	public Marker setLineColor(String _lineColor) {
		this.lineColor_ = _lineColor;
		return this;
	}

	private Number lineWidth_;

	public Number getLineWidth() {
		return this.lineWidth_;
	}

	public Marker setLineWidth(Number _lineWidth) {
		this.lineWidth_ = _lineWidth;
		return this;
	}

	private Number radius_;

	public Number getRadius() {
		return this.radius_;
	}

	public Marker setRadius(Number _radius) {
		this.radius_ = _radius;
		return this;
	}

	private States states_;

	public States getStates() {
		return this.states_;
	}

	public Marker setStates(States _states) {
		this.states_ = _states;
		return this;
	}

	private String symbol_;

	public String getSymbol() {
		return this.symbol_;
	}

	public Marker setSymbol(String _symbol) {
		this.symbol_ = _symbol;
		return this;
	}
}