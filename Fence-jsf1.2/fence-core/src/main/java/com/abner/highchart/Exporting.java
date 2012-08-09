package com.abner.highchart;

public class Exporting {
	public static Exporting getInstance() {
		return new Exporting();
	}

	private Buttons buttons_;

	public Buttons getButtons() {
		return this.buttons_;
	}

	public Exporting setButtons(Buttons _buttons) {
		this.buttons_ = _buttons;
		return this;
	}

	private Boolean enabled_;

	public Boolean getEnabled() {
		return this.enabled_;
	}

	public Exporting setEnabled(Boolean _enabled) {
		this.enabled_ = _enabled;
		return this;
	}

	private Boolean enableImages_;

	public Boolean getEnableImages() {
		return this.enableImages_;
	}

	public Exporting setEnableImages(Boolean _enableImages) {
		this.enableImages_ = _enableImages;
		return this;
	}

	private String filename_;

	public String getFilename() {
		return this.filename_;
	}

	public Exporting setFilename(String _filename) {
		this.filename_ = _filename;
		return this;
	}

	private String type_;

	public String getType() {
		return this.type_;
	}

	public Exporting setType(String _type) {
		this.type_ = _type;
		return this;
	}

	private String url_;

	public String getUrl() {
		return this.url_;
	}

	public Exporting setUrl(String _url) {
		this.url_ = _url;
		return this;
	}

	private Number width_;

	public Number getWidth() {
		return this.width_;
	}

	public Exporting setWidth(Number _width) {
		this.width_ = _width;
		return this;
	}
}