package com.abner.model;

import java.util.Set;

import javax.persistence.Transient;

import com.abner.fence.web.ExtNode;

public class TreeMenu implements ExtNode {

	private String text;
	private String href;
	private String icon;
	private String iconCls;
	private boolean expanded;
	private boolean leaf;
	private boolean qtip;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isQtip() {
		return qtip;
	}

	public void setQtip(boolean qtip) {
		this.qtip = qtip;
	}
	
	@Transient
	public Set<? extends ExtNode> getChildren() {
		return null;
	}
}
