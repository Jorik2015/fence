package com.abner.model;

import java.util.ArrayList;
import java.util.List;

public class ExtClass {
	private String pk;
	private String definedIn;
	private String clazz;
	private String extend;
	private String commonts;
	private String instanceOf;
	private String xtype;
	private String mode;
	private String layout="";
	private List<String> events = new ArrayList<String>();
	private List<Config> configs = new ArrayList<Config>();

	public ExtClass() {
		super();
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getDefinedIn() {
		return definedIn;
	}

	public void setDefinedIn(String definedIn) {
		this.definedIn = definedIn;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getCommonts() {
		return commonts;
	}

	public void setCommonts(String commonts) {
		this.commonts = commonts;
	}

	public List<Config> getConfigs() {
		return configs;
	}

	public void setConfigs(List<Config> configs) {
		this.configs = configs;
	}

	public String getInstanceOf() {
		return instanceOf;
	}

	public void setInstanceOf(String instanceOf) {
		this.instanceOf = instanceOf;
	}

	public String getXtype() {
		return xtype;
	}

	public void setXtype(String xtype) {
		this.xtype = xtype;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}
}
