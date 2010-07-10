package com.fence.dao;

import com.fence.entity.User;

@SuppressWarnings("unchecked")
public interface UserDao extends GenericDao {
	public User getUserByName(String username);

	public User save(User user);
}
