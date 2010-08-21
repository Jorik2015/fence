package com.fence.actions;

import org.springframework.stereotype.Controller;

import com.fence.entity.TreeNode;

@Controller("treeNodeManager")
public class TreeNodeManager {

	private TreeNode treeNode;

	public void save() {
		System.out.println("======" + treeNode);
	}

	public TreeNode getTreeNode() {
		if (treeNode == null)
			treeNode = new TreeNode();

		return treeNode;
	}
}
