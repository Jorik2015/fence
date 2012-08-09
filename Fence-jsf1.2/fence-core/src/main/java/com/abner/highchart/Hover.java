package com.abner.highchart;

public class Hover {
	public static Hover getInstance() {
		return new Hover();
	}

	private Boolean enabled_;

	public Boolean getEnabled() {
		return this.enabled_;
	}

	public Hover setEnabled(Boolean _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private Number lineWidth_;

	public Number getLineWidth() {
		return this.lineWidth_;
	}

	public Hover setLineWidth(Number _lineWidth) {
		this.lineWidth_ = _lineWidth;
		return this;
	}

	private Marker marker_;

	public Marker getMarker() {
		return this.marker_;
	}

	public Hover setMarker(Marker _marker) {
		this.marker_ = _marker;
		return this;
	}

	private Number brightness_;

	public Number getBrightness() {
		return this.brightness_;
	}

	public Hover setBrightness(Number _brightness) {
		this.brightness_ = _brightness;
		return this;
	}
}