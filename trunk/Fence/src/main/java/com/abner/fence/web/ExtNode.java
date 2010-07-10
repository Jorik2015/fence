package com.abner.fence.web;

import java.util.Set;

public interface ExtNode {

	String getText();

	String getHref();

	String getIcon();

	String getIconCls();

	boolean isExpanded();

	boolean isLeaf();

	boolean isQtip();

	Set<? extends ExtNode> getChildren();

	void setText(String text);

	void setHref(String href);

	void setIcon(String icon);

	void setIconCls(String iconCls);

	void setExpanded(boolean expanded);

	void setLeaf(boolean leaf);

	void setQtip(boolean qtip);
}
