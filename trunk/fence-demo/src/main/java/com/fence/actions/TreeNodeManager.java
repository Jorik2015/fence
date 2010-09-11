package com.fence.actions;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fence.entity.TreeNode;

@Controller("treeNodeManager")
@Scope("session")
public class TreeNodeManager implements Serializable {
	
	private static final long serialVersionUID = -5754891622763122888L;
	
	private TreeNode treeNode;

	public void save() {
		System.out.println("======" + treeNode.getText());
	}

	public TreeNode getTreeNode() {
		if (treeNode == null)
			treeNode = new TreeNode();

		return treeNode;//15819552480
	}
}
