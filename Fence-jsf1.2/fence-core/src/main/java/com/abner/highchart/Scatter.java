package com.abner.highchart;

public class Scatter {
	public static Scatter getInstance() {
		return new Scatter();
	}

	private Boolean allowPointSelect_;

	public Boolean getAllowPointSelect() {
		return this.allowPointSelect_;
	}

	public Scatter setAllowPointSelect(Boolean _allowPointSelect) {
		this.allowPointSelect_ = _allowPointSelect;
		return this;
	}

	private Boolean animation_;

	public Boolean getAnimation() {
		return this.animation_;
	}

	public Scatter setAnimation(Boolean _animation) {
		this.animation_ = _animation;
		return this;
	}

	private String color_;

	public String getColor() {
		return this.color_;
	}

	public Scatter setColor(String _color) {
		this.color_ = _color;
		return this;
	}

	private Boolean connectNulls_;

	public Boolean getConnectNulls() {
		return this.connectNulls_;
	}

	public Scatter setConnectNulls(Boolean _connectNulls) {
		this.connectNulls_ = _connectNulls;
		return this;
	}

	private Number cropThreshold_;

	public Number getCropThreshold() {
		return this.cropThreshold_;
	}

	public Scatter setCropThreshold(Number _cropThreshold) {
		this.cropThreshold_ = _cropThreshold;
		return this;
	}

	private String cursor_;

	public String getCursor() {
		return this.cursor_;
	}

	public Scatter setCursor(String _cursor) {
		this.cursor_ = _cursor;
		return this;
	}

	private String dashStyle_;

	public String getDashStyle() {
		return this.dashStyle_;
	}

	public Scatter setDashStyle(String _dashStyle) {
		this.dashStyle_ = _dashStyle;
		return this;
	}

	private DataLabels dataLabels_;

	public DataLabels getDataLabels() {
		return this.dataLabels_;
	}

	public Scatter setDataLabels(DataLabels _dataLabels) {
		this.dataLabels_ = _dataLabels;
		return this;
	}

	private Boolean enableMouseTracking_;

	public Boolean getEnableMouseTracking() {
		return this.enableMouseTracking_;
	}

	public Scatter setEnableMouseTracking(Boolean _enableMouseTracking) {
		this.enableMouseTracking_ = _enableMouseTracking;
		return this;
	}

	private Events events_;

	public Events getEvents() {
		return this.events_;
	}

	public Scatter setEvents(Events _events) {
		this.events_ = _events;
		return this;
	}

	private String id_;

	public String getId() {
		return this.id_;
	}

	public Scatter setId(String _id) {
		this.id_ = _id;
		return this;
	}

	private Number lineWidth_;

	public Number getLineWidth() {
		return this.lineWidth_;
	}

	public Scatter setLineWidth(Number _lineWidth) {
		this.lineWidth_ = _lineWidth;
		return this;
	}

	private Marker marker_;

	public Marker getMarker() {
		return this.marker_;
	}

	public Scatter setMarker(Marker _marker) {
		this.marker_ = _marker;
		return this;
	}

	private Point point_;

	public Point getPoint() {
		return this.point_;
	}

	public Scatter setPoint(Point _point) {
		this.point_ = _point;
		return this;
	}

	private Number pointStart_;

	public Number getPointStart() {
		return this.pointStart_;
	}

	public Scatter setPointStart(Number _pointStart) {
		this.pointStart_ = _pointStart;
		return this;
	}

	private Number pointInterval_;

	public Number getPointInterval() {
		return this.pointInterval_;
	}

	public Scatter setPointInterval(Number _pointInterval) {
		this.pointInterval_ = _pointInterval;
		return this;
	}

	private Boolean selected_;

	public Boolean getSelected() {
		return this.selected_;
	}

	public Scatter setSelected(Boolean _selected) {
		this.selected_ = _selected;
		return this;
	}

	private Boolean shadow_;

	public Boolean getShadow() {
		return this.shadow_;
	}

	public Scatter setShadow(Boolean _shadow) {
		this.shadow_ = _shadow;
		return this;
	}

	private Boolean showCheckbox_;

	public Boolean getShowCheckbox() {
		return this.showCheckbox_;
	}

	public Scatter setShowCheckbox(Boolean _showCheckbox) {
		this.showCheckbox_ = _showCheckbox;
		return this;
	}

	private Boolean showInLegend_;

	public Boolean getShowInLegend() {
		return this.showInLegend_;
	}

	public Scatter setShowInLegend(Boolean _showInLegend) {
		this.showInLegend_ = _showInLegend;
		return this;
	}

	private String stacking_;

	public String getStacking() {
		return this.stacking_;
	}

	public Scatter setStacking(String _stacking) {
		this.stacking_ = _stacking;
		return this;
	}

	private States states_;

	public States getStates() {
		return this.states_;
	}

	public Scatter setStates(States _states) {
		this.states_ = _states;
		return this;
	}

	private Boolean stickyTracking_;

	public Boolean getStickyTracking() {
		return this.stickyTracking_;
	}

	public Scatter setStickyTracking(Boolean _stickyTracking) {
		this.stickyTracking_ = _stickyTracking;
		return this;
	}

	private Object tooltip_;

	public Object getTooltip() {
		return this.tooltip_;
	}

	public Scatter setTooltip(Object _tooltip) {
		this.tooltip_ = _tooltip;
		return this;
	}

	private Number turboThreshold_;

	public Number getTurboThreshold() {
		return this.turboThreshold_;
	}

	public Scatter setTurboThreshold(Number _turboThreshold) {
		this.turboThreshold_ = _turboThreshold;
		return this;
	}

	private Boolean visible_;

	public Boolean getVisible() {
		return this.visible_;
	}

	public Scatter setVisible(Boolean _visible) {
		this.visible_ = _visible;
		return this;
	}

	private Number zIndex_;

	public Number getZIndex() {
		return this.zIndex_;
	}

	public Scatter setZIndex(Number _zIndex) {
		this.zIndex_ = _zIndex;
		return this;
	}
}