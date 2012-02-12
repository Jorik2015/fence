package com.fence.dao;

import com.fence.entity.User;

public interface UserDao extends GenericDao<User> {
	public User getUserByName(String username);
}
