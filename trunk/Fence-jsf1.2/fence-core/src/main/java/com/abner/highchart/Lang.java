package com.abner.highchart;

public class Lang {
	public static Lang getInstance() {
		return new Lang();
	}

	private String decimalPoint_;

	public String getDecimalPoint() {
		return this.decimalPoint_;
	}

	public Lang setDecimalPoint(String _decimalPoint) {
		this.decimalPoint_ = _decimalPoint;
		return this;
	}

	private String downloadPNG_;

	public String getDownloadPNG() {
		return this.downloadPNG_;
	}

	public Lang setDownloadPNG(String _downloadPNG) {
		this.downloadPNG_ = _downloadPNG;
		return this;
	}

	private String downloadJPEG_;

	public String getDownloadJPEG() {
		return this.downloadJPEG_;
	}

	public Lang setDownloadJPEG(String _downloadJPEG) {
		this.downloadJPEG_ = _downloadJPEG;
		return this;
	}

	private String downloadPDF_;

	public String getDownloadPDF() {
		return this.downloadPDF_;
	}

	public Lang setDownloadPDF(String _downloadPDF) {
		this.downloadPDF_ = _downloadPDF;
		return this;
	}

	private String downloadSVG_;

	public String getDownloadSVG() {
		return this.downloadSVG_;
	}

	public Lang setDownloadSVG(String _downloadSVG) {
		this.downloadSVG_ = _downloadSVG;
		return this;
	}

	private String exportButtonTitle_;

	public String getExportButtonTitle() {
		return this.exportButtonTitle_;
	}

	public Lang setExportButtonTitle(String _exportButtonTitle) {
		this.exportButtonTitle_ = _exportButtonTitle;
		return this;
	}

	private String loading_;

	public String getLoading() {
		return this.loading_;
	}

	public Lang setLoading(String _loading) {
		this.loading_ = _loading;
		return this;
	}

	private Object months_;

	public Object getMonths() {
		return this.months_;
	}

	public Lang setMonths(Object _months) {
		this.months_ = _months;
		return this;
	}

	private Object shortMonths_;

	public Object getShortMonths() {
		return this.shortMonths_;
	}

	public Lang setShortMonths(Object _shortMonths) {
		this.shortMonths_ = _shortMonths;
		return this;
	}

	private String printButtonTitle_;

	public String getPrintButtonTitle() {
		return this.printButtonTitle_;
	}

	public Lang setPrintButtonTitle(String _printButtonTitle) {
		this.printButtonTitle_ = _printButtonTitle;
		return this;
	}

	private String resetZoom_;

	public String getResetZoom() {
		return this.resetZoom_;
	}

	public Lang setResetZoom(String _resetZoom) {
		this.resetZoom_ = _resetZoom;
		return this;
	}

	private String resetZoomTitle_;

	public String getResetZoomTitle() {
		return this.resetZoomTitle_;
	}

	public Lang setResetZoomTitle(String _resetZoomTitle) {
		this.resetZoomTitle_ = _resetZoomTitle;
		return this;
	}

	private String thousandsSep_;

	public String getThousandsSep() {
		return this.thousandsSep_;
	}

	public Lang setThousandsSep(String _thousandsSep) {
		this.thousandsSep_ = _thousandsSep;
		return this;
	}

	private Object weekdays_;

	public Object getWeekdays() {
		return this.weekdays_;
	}

	public Lang setWeekdays(Object _weekdays) {
		this.weekdays_ = _weekdays;
		return this;
	}
}