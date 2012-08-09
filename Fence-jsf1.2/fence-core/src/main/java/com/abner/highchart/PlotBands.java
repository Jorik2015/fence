package com.abner.highchart;

public class PlotBands {
	public static PlotBands getInstance() {
		return new PlotBands();
	}

	private String color_;

	public String getColor() {
		return this.color_;
	}

	public PlotBands setColor(String _color) {
		this.color_ = _color;
		return this;
	}

	private Object events_;

	public Object getEvents() {
		return this.events_;
	}

	public PlotBands setEvents(Object _events) {
		this.events_ = _events;
		return this;
	}

	private Number from_;

	public Number getFrom() {
		return this.from_;
	}

	public PlotBands setFrom(Number _from) {
		this.from_ = _from;
		return this;
	}

	private String id_;

	public String getId() {
		return this.id_;
	}

	public PlotBands setId(String _id) {
		this.id_ = _id;
		return this;
	}

	private Label label_;

	public Label getLabel() {
		return this.label_;
	}

	public PlotBands setLabel(Label _label) {
		this.label_ = _label;
		return this;
	}

	private Number to_;

	public Number getTo() {
		return this.to_;
	}

	public PlotBands setTo(Number _to) {
		this.to_ = _to;
		return this;
	}

	private Number zIndex_;

	public Number getZIndex() {
		return this.zIndex_;
	}

	public PlotBands setZIndex(Number _zIndex) {
		this.zIndex_ = _zIndex;
		return this;
	}
}