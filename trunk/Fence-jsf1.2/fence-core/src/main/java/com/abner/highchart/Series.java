package com.abner.highchart;

public class Series {
	public static Series getInstance() {
		return new Series();
	}

	private Object data_;

	public Object getData() {
		return this.data_;
	}

	public Series setData(Object _data) {
		this.data_ = _data;
		return this;
	}

	private Object dataParser_;

	public Object getDataParser() {
		return this.dataParser_;
	}

	public Series setDataParser(Object _dataParser) {
		this.dataParser_ = _dataParser;
		return this;
	}

	private String dataURL_;

	public String getDataURL() {
		return this.dataURL_;
	}

	public Series setDataURL(String _dataURL) {
		this.dataURL_ = _dataURL;
		return this;
	}

	private Number legendIndex_;

	public Number getLegendIndex() {
		return this.legendIndex_;
	}

	public Series setLegendIndex(Number _legendIndex) {
		this.legendIndex_ = _legendIndex;
		return this;
	}

	private String name_;

	public String getName() {
		return this.name_;
	}

	public Series setName(String _name) {
		this.name_ = _name;
		return this;
	}

	private Object stack_;

	public Object getStack() {
		return this.stack_;
	}

	public Series setStack(Object _stack) {
		this.stack_ = _stack;
		return this;
	}

	private String type_;

	public String getType() {
		return this.type_;
	}

	public Series setType(String _type) {
		this.type_ = _type;
		return this;
	}

	private Number xAxis_;

	public Number getXAxis() {
		return this.xAxis_;
	}

	public Series setXAxis(Number _xAxis) {
		this.xAxis_ = _xAxis;
		return this;
	}

	private Number yAxis_;

	public Number getYAxis() {
		return this.yAxis_;
	}

	public Series setYAxis(Number _yAxis) {
		this.yAxis_ = _yAxis;
		return this;
	}
}