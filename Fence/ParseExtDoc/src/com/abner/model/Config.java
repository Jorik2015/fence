package com.abner.model;

public class Config {
	private String commonts;
	private String name;
	private String type;
	private String clientConfig;
	private String msource;
	private String upname;
	
	public Config() {
		super();
	}
	public Config(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCommonts() {
		return commonts;
	}
	public void setCommonts(String commonts) {
		this.commonts = commonts;
	}
	public String getClientConfig() {
		return clientConfig;
	}
	public void setClientConfig(String clientConfig) {
		this.clientConfig = clientConfig;
	}
	public String getMsource() {
		return msource;
	}
	public void setMsource(String msource) {
		this.msource = msource;
	}
	public String getUpname() {
		return upname;
	}
	public void setUpname(String upname) {
		this.upname = upname;
	}
}
