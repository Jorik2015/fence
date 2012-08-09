package com.abner.highchart;

public class States {
	public static States getInstance() {
		return new States();
	}

	private Hover hover_;

	public Hover getHover() {
		return this.hover_;
	}

	public States setHover(Hover _hover) {
		this.hover_ = _hover;
		return this;
	}
}