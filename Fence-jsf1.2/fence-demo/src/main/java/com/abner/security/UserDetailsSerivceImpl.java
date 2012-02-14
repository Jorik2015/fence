package com.abner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abner.dao.UserDao;
import com.abner.model.UserEntity;

@Service("userDetailsService")
public class UserDetailsSerivceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	public UserEntity loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserEntity user = userDao.getUserByName(username);
		if (user == null)
			throw new UsernameNotFoundException("user " + username + " not found.");

		return user;
	}
}
