package com.abner.highchart;

public class ResetZoomButton {
	public static ResetZoomButton getInstance() {
		return new ResetZoomButton();
	}

	private Object position_;

	public Object getPosition() {
		return this.position_;
	}

	public ResetZoomButton setPosition(Object _position) {
		this.position_ = _position;
		return this;
	}

	private String relativeTo_;

	public String getRelativeTo() {
		return this.relativeTo_;
	}

	public ResetZoomButton setRelativeTo(String _relativeTo) {
		this.relativeTo_ = _relativeTo;
		return this;
	}

	private Object theme_;

	public Object getTheme() {
		return this.theme_;
	}

	public ResetZoomButton setTheme(Object _theme) {
		this.theme_ = _theme;
		return this;
	}
}