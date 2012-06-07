/**
 * 
 */
package com.abner.model;

import java.util.Set;

import com.abner.fence.web.ExtNode;

/**
 * @author Administrator
 * 
 */
public class MenuNode implements ExtNode {

	String text;
	String href;
	String icon;
	String iconCls;
	boolean expanded;
	boolean leaf;
	boolean qtip;
	Set<? extends ExtNode> children;

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

	public Set<? extends ExtNode> getChildren() {
		return children;
	}

	public void setChildren(Set<? extends ExtNode> children) {
		this.children = children;
	}

}
