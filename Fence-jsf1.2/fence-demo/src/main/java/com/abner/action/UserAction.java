package com.abner.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.event.ActionEvent;

import net.sf.json.JSONFunction;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.abner.dao.UserDao;
import com.abner.fence.web.ExtMessage;
import com.abner.fence.web.Params;
import com.abner.fence.web.StoreAction;
import com.abner.model.UserEntity;

import ext.data.Api;

@SuppressWarnings("unchecked")
@Controller("userAction")
@Scope("request")
public class UserAction implements StoreAction {
	private Random rand = new Random();
	private UserEntity user;
	private List<UserEntity> users;

	@Autowired
	private UserDao userDao;

	public JSONFunction getFn() {
		return new JSONFunction("function(){}");
	}

	// store action implements=============================
	public Object execute(List<?> objs, String api) {

		System.out.println("Store Action execute : " + api);

		if (Api.ACTION_READ.equals(api)) {
			return this.getUsers();
		}

		return null;
	}

	// store action implements=============================

	public void insert() {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		userDao.save(user);
	}

	public void update() {
		System.out.println("The store update action:");
	}

	public void update(ActionEvent e) {
		System.out.println("The store update action:" + e.getPhaseId());
	}

	public void login(ActionEvent e) {
		System.out.println("User login come here!");
	}

	public void login() {
		System.out.println("User login come here!");

		ExtMessage.info("Custom info but not throw.");
	}
	
	public List<UserEntity> getPagingUsers(){
		int start = Params.getParam("start").getIntValue();
		int limit = Params.getParam("limit").getIntValue();
		if(limit == 0)
			limit = 5;
		
		if (users == null)
			users = userDao.findAll(start,limit);

		for (UserEntity user : users) {
			user.setMobile(user.getMobile() + rand.nextInt(20));
			user.setSalary(user.getSalary() * rand.nextDouble());
		}

		return users;
	}
	
	public int getPagingCount(){
		return userDao.getCount();
	}

	public List<UserEntity> getUsers() {
		System.out.println("Request find list method ====================== " + users);

		if (users == null)
			users = userDao.findAll();

		for (UserEntity user : users) {
			user.setMobile(user.getMobile() + rand.nextInt(20));
			user.setSalary(user.getSalary() * rand.nextDouble());
		}

		return users;
	}

	public UserEntity getUser() {
		if (user == null)
			user = userDao.getUserByName("arron0");
		
		user.setMobile(user.getMobile() + rand.nextInt(20));
		user.setSalary(user.getSalary() * rand.nextDouble());

		return user;
	}

	public Map<String, UserEntity> getUserMap() {
		List<UserEntity> users = userDao.findAll();
		Map<String, UserEntity> result = new HashMap<String, UserEntity>();
		for (int i = 0; i < users.size(); i++) {
			result.put(users.get(i).getUsername(), users.get(i));
		}
		return result;
	}

	public UserEntity[] getUserArray() {
		List<UserEntity> users = userDao.findAll();
		for (UserEntity user : users) {
			user.setMobile(user.getMobile() + rand.nextInt(20));
			user.setSalary(user.getSalary() * rand.nextDouble());
		}
		UserEntity[] result = new UserEntity[users.size()];
		for (int i = 0; i < users.size(); i++) {
			result[i] = users.get(i);
		}
		return result;
	}

	public List getStringList() {
		List result = new ArrayList();
		result.add(new String[] { "arron" });
		for (int i = 0; i < 10; i++) {
			result.add(rand.nextInt(100));
		}
		result.add(1000);
		return result;
	}

	public String getLabelText() {
		return "Label" + rand.nextInt(100);
	}
}
