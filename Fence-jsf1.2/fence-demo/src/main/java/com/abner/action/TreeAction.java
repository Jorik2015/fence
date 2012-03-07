package com.abner.action;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;

import com.abner.model.TreeMenu;
import com.abner.model.TreeModel;

@Controller("treeAction")
public class TreeAction {
	public Set<TreeModel> getMenus() {
		Set<TreeModel> result = new HashSet<TreeModel>();
		for (int i = 0; i < 10; i++) {
			TreeModel treeModel = new TreeModel();
			treeModel.setAuth(i % 2 == 0);
			treeModel.setCreateDate(Calendar.getInstance().getTime());
			treeModel.setMenuName("Demo Menu  Name " + i);
			treeModel.setOrder(i);
			result.add(treeModel);

			if (i == 2) {
				for (int n = 0; n < 10; n++) {
					TreeModel treeModelChild = new TreeModel();
					treeModelChild.setAuth(n % 2 == 0);
					treeModelChild.setCreateDate(Calendar.getInstance().getTime());
					treeModelChild.setMenuName("Sub  Menu  Name " + i);
					treeModelChild.setOrder(i);
					treeModel.getChildren().add(treeModelChild);
				}
			}
		}
		return result;
	}

	public Set<TreeMenu> getTreeMenus() {
		Set<TreeMenu> result = new HashSet<TreeMenu>();
		for (int i = 0; i < 10; i++) {
			TreeMenu treeMenu = new TreeMenu();
			treeMenu.setHref("#");
			treeMenu.setText("Menu " + i);
			treeMenu.setLeaf(false);

			result.add(treeMenu);
		}
		return result;
	}
}
