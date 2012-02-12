package com.fence.actions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fence.entity.TreeNode;

@Controller("treeNodeManager")
@Scope("request")
public class TreeNodeManager {
	
	private static final long serialVersionUID = -5754891622763122888L;
	
	private TreeNode treeNode;

	public void save() {
		System.out.println("======" + treeNode.getText());
	}

	public TreeNode getTreeNode() {
		if (treeNode == null)
			treeNode = new TreeNode();

		return treeNode;
	}
}
