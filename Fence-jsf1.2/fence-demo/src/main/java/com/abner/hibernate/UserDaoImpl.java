package com.abner.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.abner.dao.UserDao;
import com.abner.model.UserEntity;

@Transactional
public class UserDaoImpl extends HibernateDao<UserEntity> implements UserDao {

	public UserEntity getUserByName(String username) {
		List<UserEntity> users = findByProperty("username", username);
		if (users.isEmpty())
			return null;

		return users.get(0);
	}

	public UserEntity save(UserEntity user) {
		return super.save(user);
	}
}