package com.abner.highchart;

public class PlotOptions {
	public static PlotOptions getInstance() {
		return new PlotOptions();
	}

	private Area area_;

	public Area getArea() {
		return this.area_;
	}

	public PlotOptions setArea(Area _area) {
		this.area_ = _area;
		return this;
	}

	private Areaspline areaspline_;

	public Areaspline getAreaspline() {
		return this.areaspline_;
	}

	public PlotOptions setAreaspline(Areaspline _areaspline) {
		this.areaspline_ = _areaspline;
		return this;
	}

	private Bar bar_;

	public Bar getBar() {
		return this.bar_;
	}

	public PlotOptions setBar(Bar _bar) {
		this.bar_ = _bar;
		return this;
	}

	private Column column_;

	public Column getColumn() {
		return this.column_;
	}

	public PlotOptions setColumn(Column _column) {
		this.column_ = _column;
		return this;
	}

	private Line line_;

	public Line getLine() {
		return this.line_;
	}

	public PlotOptions setLine(Line _line) {
		this.line_ = _line;
		return this;
	}

	private Pie pie_;

	public Pie getPie() {
		return this.pie_;
	}

	public PlotOptions setPie(Pie _pie) {
		this.pie_ = _pie;
		return this;
	}

	private Series series_;

	public Series getSeries() {
		return this.series_;
	}

	public PlotOptions setSeries(Series _series) {
		this.series_ = _series;
		return this;
	}

	private Scatter scatter_;

	public Scatter getScatter() {
		return this.scatter_;
	}

	public PlotOptions setScatter(Scatter _scatter) {
		this.scatter_ = _scatter;
		return this;
	}

	private Spline spline_;

	public Spline getSpline() {
		return this.spline_;
	}

	public PlotOptions setSpline(Spline _spline) {
		this.spline_ = _spline;
		return this;
	}
}