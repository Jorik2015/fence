package com.abner.highchart;

import java.util.List;

public class HighChartOption {
	public static HighChartOption getInstance() {
		return new HighChartOption();
	}

	private Chart chart_;

	public Chart getChart() {
		return this.chart_;
	}

	public HighChartOption setChart(Chart _chart) {
		this.chart_ = _chart;
		return this;
	}

	private String[] colors_;

	public String[] getColors() {
		return this.colors_;
	}

	public HighChartOption setColors(String[] _colors) {
		this.colors_ = _colors;
		return this;
	}

	private Credits credits_;

	public Credits getCredits() {
		return this.credits_;
	}

	public HighChartOption setCredits(Credits _credits) {
		this.credits_ = _credits;
		return this;
	}

	private Global global_;

	public Global getGlobal() {
		return this.global_;
	}

	public HighChartOption setGlobal(Global _global) {
		this.global_ = _global;
		return this;
	}

	private Labels labels_;

	public Labels getLabels() {
		return this.labels_;
	}

	public HighChartOption setLabels(Labels _labels) {
		this.labels_ = _labels;
		return this;
	}

	private Lang lang_;

	public Lang getLang() {
		return this.lang_;
	}

	public HighChartOption setLang(Lang _lang) {
		this.lang_ = _lang;
		return this;
	}

	private Legend legend_;

	public Legend getLegend() {
		return this.legend_;
	}

	public HighChartOption setLegend(Legend _legend) {
		this.legend_ = _legend;
		return this;
	}

	private Loading loading_;

	public Loading getLoading() {
		return this.loading_;
	}

	public HighChartOption setLoading(Loading _loading) {
		this.loading_ = _loading;
		return this;
	}

	private PlotOptions plotOptions_;

	public PlotOptions getPlotOptions() {
		return this.plotOptions_;
	}

	public HighChartOption setPlotOptions(PlotOptions _plotOptions) {
		this.plotOptions_ = _plotOptions;
		return this;
	}

	private Point point_;

	public Point getPoint() {
		return this.point_;
	}

	public HighChartOption setPoint(Point _point) {
		this.point_ = _point;
		return this;
	}

	private List series_;

	public List getSeries() {
		return this.series_;
	}

	public HighChartOption setSeries(List _series) {
		this.series_ = _series;
		return this;
	}

	private Subtitle subtitle_;

	public Subtitle getSubtitle() {
		return this.subtitle_;
	}

	public HighChartOption setSubtitle(Subtitle _subtitle) {
		this.subtitle_ = _subtitle;
		return this;
	}

	private String[] symbols_;

	public String[] getSymbols() {
		return this.symbols_;
	}

	public HighChartOption setSymbols(String[] _symbols) {
		this.symbols_ = _symbols;
		return this;
	}

	private Title title_;

	public Title getTitle() {
		return this.title_;
	}

	public HighChartOption setTitle(Title _title) {
		this.title_ = _title;
		return this;
	}

	private Tooltip tooltip_;

	public Tooltip getTooltip() {
		return this.tooltip_;
	}

	public HighChartOption setTooltip(Tooltip _tooltip) {
		this.tooltip_ = _tooltip;
		return this;
	}

	private XAxis xAxis_;

	public XAxis getXAxis() {
		return this.xAxis_;
	}

	public HighChartOption setXAxis(XAxis _xAxis) {
		this.xAxis_ = _xAxis;
		return this;
	}

	private YAxis yAxis_;

	public YAxis getYAxis() {
		return this.yAxis_;
	}

	public HighChartOption setYAxis(YAxis _yAxis) {
		this.yAxis_ = _yAxis;
		return this;
	}

	private Exporting exporting_;

	public Exporting getExporting() {
		return this.exporting_;
	}

	public HighChartOption setExporting(Exporting _exporting) {
		this.exporting_ = _exporting;
		return this;
	}

	private Navigation navigation_;

	public Navigation getNavigation() {
		return this.navigation_;
	}

	public HighChartOption setNavigation(Navigation _navigation) {
		this.navigation_ = _navigation;
		return this;
	}
}