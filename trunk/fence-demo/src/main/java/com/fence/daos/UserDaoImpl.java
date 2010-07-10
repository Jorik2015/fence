package com.fence.daos;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fence.dao.HibernateDao;
import com.fence.dao.UserDao;
import com.fence.entity.User;

@Transactional
public class UserDaoImpl extends HibernateDao<User> implements UserDao {

	public User getUserByName(String username) {
		List<User> users = findByProperty("username", username);
		if (users.isEmpty())
			return null;

		return users.get(0);
	}

	public User save(User user) {
		return super.save(user);
	}
}