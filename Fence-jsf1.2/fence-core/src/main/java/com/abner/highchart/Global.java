package com.abner.highchart;

public class Global {
	public static Global getInstance() {
		return new Global();
	}

	private String canvasToolsURL_;

	public String getCanvasToolsURL() {
		return this.canvasToolsURL_;
	}

	public Global setCanvasToolsURL(String _canvasToolsURL) {
		this.canvasToolsURL_ = _canvasToolsURL;
		return this;
	}

	private Boolean useUTC_;

	public Boolean getUseUTC() {
		return this.useUTC_;
	}

	public Global setUseUTC(Boolean _useUTC) {
		this.useUTC_ = _useUTC;
		return this;
	}
}