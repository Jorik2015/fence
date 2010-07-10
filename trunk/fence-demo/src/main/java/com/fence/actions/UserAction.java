package com.fence.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fence.dao.UserDao;
import com.fence.entity.User;

@Controller
@Scope("request")
public class UserAction {
	private User user;
	private User editUser;
	private List<User> list = new ArrayList<User>();

	@Autowired
	private UserDao userDao;

	private Random random = new Random();

	public User getUser() {
		if (user == null)
			user = userDao.getUserByName("arron");

		return user;
	}

	public User getEditUser() {
		if (editUser == null)
			editUser = new User();

		return editUser;
	}

	public void add() {
		userDao.save(editUser);

		System.out.println("the edituser name : " + editUser.getUsername());
		System.out.println("the edituser age : " + editUser.getAge());
		System.out.println("the edituser salary : " + editUser.getSalary());
		System.out.println("the edituser birthdate : " + editUser.getBirthdate());
	}

	@SuppressWarnings("unchecked")
	public List<User> getList() {
		if (list.isEmpty()) {
			list = userDao.findAll();
			for (User u : list) {
				u.setSalary(u.getSalary() * random.nextInt(10));
			}
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public String[][] getArray() {
		if (list.isEmpty()) {
			list = userDao.findAll();
			String[][] result = new String[list.size()][2];
			int i = 0;
			for (User u : list) {
				u.setSalary(u.getSalary() * random.nextInt(10));
				result[i][0] = u.getUsername();
				result[i][1] = String.valueOf(u.getSalary());
				i++;
			}
			return result;
		}

		return null;
	}

	public void login() {
		System.out.println("user login ========================");
		// throw new RuntimeException("custom exception.");
	}

	public double getRandom() {
		return random.nextDouble();
	}

	public String getLabelText() {
		// throw new RuntimeException("asfdsadf");
		return "Label Text " + random.nextDouble();
	}
}
