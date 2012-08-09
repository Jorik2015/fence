package com.abner.highchart;

public class Chart {
	public static Chart getInstance() {
		return new Chart();
	}

	private Boolean alignTicks_;

	public Boolean getAlignTicks() {
		return this.alignTicks_;
	}

	public Chart setAlignTicks(Boolean _alignTicks) {
		this.alignTicks_ = _alignTicks;
		return this;
	}

	private Object animation_;

	public Object getAnimation() {
		return this.animation_;
	}

	public Chart setAnimation(Object _animation) {
		this.animation_ = _animation;
		return this;
	}

	private String backgroundColor_;

	public String getBackgroundColor() {
		return this.backgroundColor_;
	}

	public Chart setBackgroundColor(String _backgroundColor) {
		this.backgroundColor_ = _backgroundColor;
		return this;
	}

	private String borderColor_;

	public String getBorderColor() {
		return this.borderColor_;
	}

	public Chart setBorderColor(String _borderColor) {
		this.borderColor_ = _borderColor;
		return this;
	}

	private Number borderRadius_;

	public Number getBorderRadius() {
		return this.borderRadius_;
	}

	public Chart setBorderRadius(Number _borderRadius) {
		this.borderRadius_ = _borderRadius;
		return this;
	}

	private Number borderWidth_;

	public Number getBorderWidth() {
		return this.borderWidth_;
	}

	public Chart setBorderWidth(Number _borderWidth) {
		this.borderWidth_ = _borderWidth;
		return this;
	}

	private String className_;

	public String getClassName() {
		return this.className_;
	}

	public Chart setClassName(String _className) {
		this.className_ = _className;
		return this;
	}

	private String defaultSeriesType_;

	public String getDefaultSeriesType() {
		return this.defaultSeriesType_;
	}

	public Chart setDefaultSeriesType(String _defaultSeriesType) {
		this.defaultSeriesType_ = _defaultSeriesType;
		return this;
	}

	private Events events_;

	public Events getEvents() {
		return this.events_;
	}

	public Chart setEvents(Events _events) {
		this.events_ = _events;
		return this;
	}

	private Number height_;

	public Number getHeight() {
		return this.height_;
	}

	public Chart setHeight(Number _height) {
		this.height_ = _height;
		return this;
	}

	private Boolean ignoreHiddenSeries_;

	public Boolean getIgnoreHiddenSeries() {
		return this.ignoreHiddenSeries_;
	}

	public Chart setIgnoreHiddenSeries(Boolean _ignoreHiddenSeries) {
		this.ignoreHiddenSeries_ = _ignoreHiddenSeries;
		return this;
	}

	private Boolean inverted_;

	public Boolean getInverted() {
		return this.inverted_;
	}

	public Chart setInverted(Boolean _inverted) {
		this.inverted_ = _inverted;
		return this;
	}

	private Object margin_;

	public Object getMargin() {
		return this.margin_;
	}

	public Chart setMargin(Object _margin) {
		this.margin_ = _margin;
		return this;
	}

	private Number marginTop_;

	public Number getMarginTop() {
		return this.marginTop_;
	}

	public Chart setMarginTop(Number _marginTop) {
		this.marginTop_ = _marginTop;
		return this;
	}

	private Number marginRight_;

	public Number getMarginRight() {
		return this.marginRight_;
	}

	public Chart setMarginRight(Number _marginRight) {
		this.marginRight_ = _marginRight;
		return this;
	}

	private Number marginBottom_;

	public Number getMarginBottom() {
		return this.marginBottom_;
	}

	public Chart setMarginBottom(Number _marginBottom) {
		this.marginBottom_ = _marginBottom;
		return this;
	}

	private Number marginLeft_;

	public Number getMarginLeft() {
		return this.marginLeft_;
	}

	public Chart setMarginLeft(Number _marginLeft) {
		this.marginLeft_ = _marginLeft;
		return this;
	}

	private String plotBackgroundColor_;

	public String getPlotBackgroundColor() {
		return this.plotBackgroundColor_;
	}

	public Chart setPlotBackgroundColor(String _plotBackgroundColor) {
		this.plotBackgroundColor_ = _plotBackgroundColor;
		return this;
	}

	private String plotBackgroundImage_;

	public String getPlotBackgroundImage() {
		return this.plotBackgroundImage_;
	}

	public Chart setPlotBackgroundImage(String _plotBackgroundImage) {
		this.plotBackgroundImage_ = _plotBackgroundImage;
		return this;
	}

	private String plotBorderColor_;

	public String getPlotBorderColor() {
		return this.plotBorderColor_;
	}

	public Chart setPlotBorderColor(String _plotBorderColor) {
		this.plotBorderColor_ = _plotBorderColor;
		return this;
	}

	private Number plotBorderWidth_;

	public Number getPlotBorderWidth() {
		return this.plotBorderWidth_;
	}

	public Chart setPlotBorderWidth(Number _plotBorderWidth) {
		this.plotBorderWidth_ = _plotBorderWidth;
		return this;
	}

	private Boolean plotShadow_;

	public Boolean getPlotShadow() {
		return this.plotShadow_;
	}

	public Chart setPlotShadow(Boolean _plotShadow) {
		this.plotShadow_ = _plotShadow;
		return this;
	}

	private Boolean reflow_;

	public Boolean getReflow() {
		return this.reflow_;
	}

	public Chart setReflow(Boolean _reflow) {
		this.reflow_ = _reflow;
		return this;
	}

	private Object renderTo_;

	public Object getRenderTo() {
		return this.renderTo_;
	}

	public Chart setRenderTo(Object _renderTo) {
		this.renderTo_ = _renderTo;
		return this;
	}

	private ResetZoomButton resetZoomButton_;

	public ResetZoomButton getResetZoomButton() {
		return this.resetZoomButton_;
	}

	public Chart setResetZoomButton(ResetZoomButton _resetZoomButton) {
		this.resetZoomButton_ = _resetZoomButton;
		return this;
	}

	private String selectionMarkerFill_;

	public String getSelectionMarkerFill() {
		return this.selectionMarkerFill_;
	}

	public Chart setSelectionMarkerFill(String _selectionMarkerFill) {
		this.selectionMarkerFill_ = _selectionMarkerFill;
		return this;
	}

	private Boolean shadow_;

	public Boolean getShadow() {
		return this.shadow_;
	}

	public Chart setShadow(Boolean _shadow) {
		this.shadow_ = _shadow;
		return this;
	}

	private Boolean showAxes_;

	public Boolean getShowAxes() {
		return this.showAxes_;
	}

	public Chart setShowAxes(Boolean _showAxes) {
		this.showAxes_ = _showAxes;
		return this;
	}

	private Number spacingTop_;

	public Number getSpacingTop() {
		return this.spacingTop_;
	}

	public Chart setSpacingTop(Number _spacingTop) {
		this.spacingTop_ = _spacingTop;
		return this;
	}

	private Number spacingRight_;

	public Number getSpacingRight() {
		return this.spacingRight_;
	}

	public Chart setSpacingRight(Number _spacingRight) {
		this.spacingRight_ = _spacingRight;
		return this;
	}

	private Number spacingBottom_;

	public Number getSpacingBottom() {
		return this.spacingBottom_;
	}

	public Chart setSpacingBottom(Number _spacingBottom) {
		this.spacingBottom_ = _spacingBottom;
		return this;
	}

	private Number spacingLeft_;

	public Number getSpacingLeft() {
		return this.spacingLeft_;
	}

	public Chart setSpacingLeft(Number _spacingLeft) {
		this.spacingLeft_ = _spacingLeft;
		return this;
	}

	private Object style_;

	public Object getStyle() {
		return this.style_;
	}

	public Chart setStyle(Object _style) {
		this.style_ = _style;
		return this;
	}

	private String type_;

	public String getType() {
		return this.type_;
	}

	public Chart setType(String _type) {
		this.type_ = _type;
		return this;
	}

	private Number width_;

	public Number getWidth() {
		return this.width_;
	}

	public Chart setWidth(Number _width) {
		this.width_ = _width;
		return this;
	}

	private String zoomType_;

	public String getZoomType() {
		return this.zoomType_;
	}

	public Chart setZoomType(String _zoomType) {
		this.zoomType_ = _zoomType;
		return this;
	}
}