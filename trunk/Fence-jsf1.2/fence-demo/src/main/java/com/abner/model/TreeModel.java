package com.abner.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TreeModel {
	private String menuName;
	private Date createDate;
	private boolean auth;
	private int order;
	private Set<TreeModel> children = new HashSet<TreeModel>();

	public Set<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(Set<TreeModel> children) {
		this.children = children;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
