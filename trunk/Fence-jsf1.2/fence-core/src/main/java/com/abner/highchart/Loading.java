package com.abner.highchart;

public class Loading {
	public static Loading getInstance() {
		return new Loading();
	}

	private Number hideDuration_;

	public Number getHideDuration() {
		return this.hideDuration_;
	}

	public Loading setHideDuration(Number _hideDuration) {
		this.hideDuration_ = _hideDuration;
		return this;
	}

	private Object labelStyle_;

	public Object getLabelStyle() {
		return this.labelStyle_;
	}

	public Loading setLabelStyle(Object _labelStyle) {
		this.labelStyle_ = _labelStyle;
		return this;
	}

	private Number showDuration_;

	public Number getShowDuration() {
		return this.showDuration_;
	}

	public Loading setShowDuration(Number _showDuration) {
		this.showDuration_ = _showDuration;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Loading setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}
}