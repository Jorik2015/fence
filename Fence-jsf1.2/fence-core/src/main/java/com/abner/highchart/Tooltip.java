package com.abner.highchart;

public class Tooltip {
	public static Tooltip getInstance() {
		return new Tooltip();
	}

	private String backgroundColor_;

	public String getBackgroundColor() {
		return this.backgroundColor_;
	}

	public Tooltip setBackgroundColor(String _backgroundColor) {
		this.backgroundColor_ = _backgroundColor;
		return this;
	}

	private String borderColor_;

	public String getBorderColor() {
		return this.borderColor_;
	}

	public Tooltip setBorderColor(String _borderColor) {
		this.borderColor_ = _borderColor;
		return this;
	}

	private Number borderRadius_;

	public Number getBorderRadius() {
		return this.borderRadius_;
	}

	public Tooltip setBorderRadius(Number _borderRadius) {
		this.borderRadius_ = _borderRadius;
		return this;
	}

	private Number borderWidth_;

	public Number getBorderWidth() {
		return this.borderWidth_;
	}

	public Tooltip setBorderWidth(Number _borderWidth) {
		this.borderWidth_ = _borderWidth;
		return this;
	}

	private Object crosshairs_;

	public Object getCrosshairs() {
		return this.crosshairs_;
	}

	public Tooltip setCrosshairs(Object _crosshairs) {
		this.crosshairs_ = _crosshairs;
		return this;
	}

	private Boolean enabled_;

	public Boolean getEnabled() {
		return this.enabled_;
	}

	public Tooltip setEnabled(Boolean _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private String footerFormat_;

	public String getFooterFormat() {
		return this.footerFormat_;
	}

	public Tooltip setFooterFormat(String _footerFormat) {
		this.footerFormat_ = _footerFormat;
		return this;
	}

	private Object formatter_;

	public Object getFormatter() {
		return this.formatter_;
	}

	public Tooltip setFormatter(Object _formatter) {
		this.formatter_ = _formatter;
		return this;
	}

	private String pointFormat_;

	public String getPointFormat() {
		return this.pointFormat_;
	}

	public Tooltip setPointFormat(String _pointFormat) {
		this.pointFormat_ = _pointFormat;
		return this;
	}

	private Object positioner_;

	public Object getPositioner() {
		return this.positioner_;
	}

	public Tooltip setPositioner(Object _positioner) {
		this.positioner_ = _positioner;
		return this;
	}

	private Boolean shadow_;

	public Boolean getShadow() {
		return this.shadow_;
	}

	public Tooltip setShadow(Boolean _shadow) {
		this.shadow_ = _shadow;
		return this;
	}

	private Boolean shared_;

	public Boolean getShared() {
		return this.shared_;
	}

	public Tooltip setShared(Boolean _shared) {
		this.shared_ = _shared;
		return this;
	}

	private Number snap_;

	public Number getSnap() {
		return this.snap_;
	}

	public Tooltip setSnap(Number _snap) {
		this.snap_ = _snap;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Tooltip setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}

	private Number valueDecimals_;

	public Number getValueDecimals() {
		return this.valueDecimals_;
	}

	public Tooltip setValueDecimals(Number _valueDecimals) {
		this.valueDecimals_ = _valueDecimals;
		return this;
	}

	private String valuePrefix_;

	public String getValuePrefix() {
		return this.valuePrefix_;
	}

	public Tooltip setValuePrefix(String _valuePrefix) {
		this.valuePrefix_ = _valuePrefix;
		return this;
	}

	private String valueSuffix_;

	public String getValueSuffix() {
		return this.valueSuffix_;
	}

	public Tooltip setValueSuffix(String _valueSuffix) {
		this.valueSuffix_ = _valueSuffix;
		return this;
	}

	private String xDateFormat_;

	public String getXDateFormat() {
		return this.xDateFormat_;
	}

	public Tooltip setXDateFormat(String _xDateFormat) {
		this.xDateFormat_ = _xDateFormat;
		return this;
	}

	private Boolean useHTML_;

	public Boolean getUseHTML() {
		return this.useHTML_;
	}

	public Tooltip setUseHTML(Boolean _useHTML) {
		this.useHTML_ = _useHTML;
		return this;
	}
}