package com.abner.highchart;

public class Buttons {
	public static Buttons getInstance() {
		return new Buttons();
	}

	private ExportButton exportButton_;

	public ExportButton getExportButton() {
		return this.exportButton_;
	}

	public Buttons setExportButton(ExportButton _exportButton) {
		this.exportButton_ = _exportButton;
		return this;
	}

	private PrintButton printButton_;

	public PrintButton getPrintButton() {
		return this.printButton_;
	}

	public Buttons setPrintButton(PrintButton _printButton) {
		this.printButton_ = _printButton;
		return this;
	}
}