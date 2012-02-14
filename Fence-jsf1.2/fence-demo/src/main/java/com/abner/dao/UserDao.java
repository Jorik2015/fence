package com.abner.dao;

import com.abner.model.UserEntity;

@SuppressWarnings("unchecked")
public interface UserDao extends GenericDao{
	public UserEntity getUserByName(String username);
	
	public UserEntity save(UserEntity user);
}
