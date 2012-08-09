package com.abner.highchart;

public class PlotLines {
	public static PlotLines getInstance() {
		return new PlotLines();
	}

	private String color_;

	public String getColor() {
		return this.color_;
	}

	public PlotLines setColor(String _color) {
		this.color_ = _color;
		return this;
	}

	private String dashStyle_;

	public String getDashStyle() {
		return this.dashStyle_;
	}

	public PlotLines setDashStyle(String _dashStyle) {
		this.dashStyle_ = _dashStyle;
		return this;
	}

	private Object events_;

	public Object getEvents() {
		return this.events_;
	}

	public PlotLines setEvents(Object _events) {
		this.events_ = _events;
		return this;
	}

	private String id_;

	public String getId() {
		return this.id_;
	}

	public PlotLines setId(String _id) {
		this.id_ = _id;
		return this;
	}

	private Label label_;

	public Label getLabel() {
		return this.label_;
	}

	public PlotLines setLabel(Label _label) {
		this.label_ = _label;
		return this;
	}

	private Number value_;

	public Number getValue() {
		return this.value_;
	}

	public PlotLines setValue(Number _value) {
		this.value_ = _value;
		return this;
	}

	private Number width_;

	public Number getWidth() {
		return this.width_;
	}

	public PlotLines setWidth(Number _width) {
		this.width_ = _width;
		return this;
	}

	private Number zIndex_;

	public Number getZIndex() {
		return this.zIndex_;
	}

	public PlotLines setZIndex(Number _zIndex) {
		this.zIndex_ = _zIndex;
		return this;
	}
}