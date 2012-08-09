package com.abner.highchart;

public class Events {
	public static Events getInstance() {
		return new Events();
	}

	private Object click_;

	public Object getClick() {
		return this.click_;
	}

	public Events setClick(Object _click) {
		this.click_ = _click;
		return this;
	}

	private Object mouseOver_;

	public Object getMouseOver() {
		return this.mouseOver_;
	}

	public Events setMouseOver(Object _mouseOver) {
		this.mouseOver_ = _mouseOver;
		return this;
	}

	private Object mouseOut_;

	public Object getMouseOut() {
		return this.mouseOut_;
	}

	public Events setMouseOut(Object _mouseOut) {
		this.mouseOut_ = _mouseOut;
		return this;
	}

	private Object remove_;

	public Object getRemove() {
		return this.remove_;
	}

	public Events setRemove(Object _remove) {
		this.remove_ = _remove;
		return this;
	}

	private Object select_;

	public Object getSelect() {
		return this.select_;
	}

	public Events setSelect(Object _select) {
		this.select_ = _select;
		return this;
	}

	private Object unselect_;

	public Object getUnselect() {
		return this.unselect_;
	}

	public Events setUnselect(Object _unselect) {
		this.unselect_ = _unselect;
		return this;
	}

	private Object update_;

	public Object getUpdate() {
		return this.update_;
	}

	public Events setUpdate(Object _update) {
		this.update_ = _update;
		return this;
	}
}