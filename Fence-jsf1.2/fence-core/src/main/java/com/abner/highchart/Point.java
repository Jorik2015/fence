package com.abner.highchart;

public class Point {
	public static Point getInstance() {
		return new Point();
	}

	private String color_;

	public String getColor() {
		return this.color_;
	}

	public Point setColor(String _color) {
		this.color_ = _color;
		return this;
	}

	private Object dataLabels_;

	public Object getDataLabels() {
		return this.dataLabels_;
	}

	public Point setDataLabels(Object _dataLabels) {
		this.dataLabels_ = _dataLabels;
		return this;
	}

	private Events events_;

	public Events getEvents() {
		return this.events_;
	}

	public Point setEvents(Events _events) {
		this.events_ = _events;
		return this;
	}

	private String id_;

	public String getId() {
		return this.id_;
	}

	public Point setId(String _id) {
		this.id_ = _id;
		return this;
	}

	private Marker marker_;

	public Marker getMarker() {
		return this.marker_;
	}

	public Point setMarker(Marker _marker) {
		this.marker_ = _marker;
		return this;
	}

	private Number legendIndex_;

	public Number getLegendIndex() {
		return this.legendIndex_;
	}

	public Point setLegendIndex(Number _legendIndex) {
		this.legendIndex_ = _legendIndex;
		return this;
	}

	private String name_;

	public String getName() {
		return this.name_;
	}

	public Point setName(String _name) {
		this.name_ = _name;
		return this;
	}

	private Boolean sliced_;

	public Boolean getSliced() {
		return this.sliced_;
	}

	public Point setSliced(Boolean _sliced) {
		this.sliced_ = _sliced;
		return this;
	}

	private Number x_;

	public Number getX() {
		return this.x_;
	}

	public Point setX(Number _x) {
		this.x_ = _x;
		return this;
	}

	private Number y_;

	public Number getY() {
		return this.y_;
	}

	public Point setY(Number _y) {
		this.y_ = _y;
		return this;
	}
}