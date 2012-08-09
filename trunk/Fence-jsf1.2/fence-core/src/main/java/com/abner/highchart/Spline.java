package com.abner.highchart;

public class Spline {
	public static Spline getInstance() {
		return new Spline();
	}

	private Boolean allowPointSelect_;

	public Boolean getAllowPointSelect() {
		return this.allowPointSelect_;
	}

	public Spline setAllowPointSelect(Boolean _allowPointSelect) {
		this.allowPointSelect_ = _allowPointSelect;
		return this;
	}

	private Boolean animation_;

	public Boolean getAnimation() {
		return this.animation_;
	}

	public Spline setAnimation(Boolean _animation) {
		this.animation_ = _animation;
		return this;
	}

	private String color_;

	public String getColor() {
		return this.color_;
	}

	public Spline setColor(String _color) {
		this.color_ = _color;
		return this;
	}

	private Boolean connectNulls_;

	public Boolean getConnectNulls() {
		return this.connectNulls_;
	}

	public Spline setConnectNulls(Boolean _connectNulls) {
		this.connectNulls_ = _connectNulls;
		return this;
	}

	private Number cropThreshold_;

	public Number getCropThreshold() {
		return this.cropThreshold_;
	}

	public Spline setCropThreshold(Number _cropThreshold) {
		this.cropThreshold_ = _cropThreshold;
		return this;
	}

	private String cursor_;

	public String getCursor() {
		return this.cursor_;
	}

	public Spline setCursor(String _cursor) {
		this.cursor_ = _cursor;
		return this;
	}

	private String dashStyle_;

	public String getDashStyle() {
		return this.dashStyle_;
	}

	public Spline setDashStyle(String _dashStyle) {
		this.dashStyle_ = _dashStyle;
		return this;
	}

	private DataLabels dataLabels_;

	public DataLabels getDataLabels() {
		return this.dataLabels_;
	}

	public Spline setDataLabels(DataLabels _dataLabels) {
		this.dataLabels_ = _dataLabels;
		return this;
	}

	private Boolean enableMouseTracking_;

	public Boolean getEnableMouseTracking() {
		return this.enableMouseTracking_;
	}

	public Spline setEnableMouseTracking(Boolean _enableMouseTracking) {
		this.enableMouseTracking_ = _enableMouseTracking;
		return this;
	}

	private Events events_;

	public Events getEvents() {
		return this.events_;
	}

	public Spline setEvents(Events _events) {
		this.events_ = _events;
		return this;
	}

	private String id_;

	public String getId() {
		return this.id_;
	}

	public Spline setId(String _id) {
		this.id_ = _id;
		return this;
	}

	private Number lineWidth_;

	public Number getLineWidth() {
		return this.lineWidth_;
	}

	public Spline setLineWidth(Number _lineWidth) {
		this.lineWidth_ = _lineWidth;
		return this;
	}

	private Marker marker_;

	public Marker getMarker() {
		return this.marker_;
	}

	public Spline setMarker(Marker _marker) {
		this.marker_ = _marker;
		return this;
	}

	private Point point_;

	public Point getPoint() {
		return this.point_;
	}

	public Spline setPoint(Point _point) {
		this.point_ = _point;
		return this;
	}

	private Number pointStart_;

	public Number getPointStart() {
		return this.pointStart_;
	}

	public Spline setPointStart(Number _pointStart) {
		this.pointStart_ = _pointStart;
		return this;
	}

	private Number pointInterval_;

	public Number getPointInterval() {
		return this.pointInterval_;
	}

	public Spline setPointInterval(Number _pointInterval) {
		this.pointInterval_ = _pointInterval;
		return this;
	}

	private Boolean selected_;

	public Boolean getSelected() {
		return this.selected_;
	}

	public Spline setSelected(Boolean _selected) {
		this.selected_ = _selected;
		return this;
	}

	private Boolean shadow_;

	public Boolean getShadow() {
		return this.shadow_;
	}

	public Spline setShadow(Boolean _shadow) {
		this.shadow_ = _shadow;
		return this;
	}

	private Boolean showCheckbox_;

	public Boolean getShowCheckbox() {
		return this.showCheckbox_;
	}

	public Spline setShowCheckbox(Boolean _showCheckbox) {
		this.showCheckbox_ = _showCheckbox;
		return this;
	}

	private Boolean showInLegend_;

	public Boolean getShowInLegend() {
		return this.showInLegend_;
	}

	public Spline setShowInLegend(Boolean _showInLegend) {
		this.showInLegend_ = _showInLegend;
		return this;
	}

	private String stacking_;

	public String getStacking() {
		return this.stacking_;
	}

	public Spline setStacking(String _stacking) {
		this.stacking_ = _stacking;
		return this;
	}

	private States states_;

	public States getStates() {
		return this.states_;
	}

	public Spline setStates(States _states) {
		this.states_ = _states;
		return this;
	}

	private Boolean stickyTracking_;

	public Boolean getStickyTracking() {
		return this.stickyTracking_;
	}

	public Spline setStickyTracking(Boolean _stickyTracking) {
		this.stickyTracking_ = _stickyTracking;
		return this;
	}

	private Object tooltip_;

	public Object getTooltip() {
		return this.tooltip_;
	}

	public Spline setTooltip(Object _tooltip) {
		this.tooltip_ = _tooltip;
		return this;
	}

	private Number turboThreshold_;

	public Number getTurboThreshold() {
		return this.turboThreshold_;
	}

	public Spline setTurboThreshold(Number _turboThreshold) {
		this.turboThreshold_ = _turboThreshold;
		return this;
	}

	private Boolean visible_;

	public Boolean getVisible() {
		return this.visible_;
	}

	public Spline setVisible(Boolean _visible) {
		this.visible_ = _visible;
		return this;
	}

	private Number zIndex_;

	public Number getZIndex() {
		return this.zIndex_;
	}

	public Spline setZIndex(Number _zIndex) {
		this.zIndex_ = _zIndex;
		return this;
	}
}