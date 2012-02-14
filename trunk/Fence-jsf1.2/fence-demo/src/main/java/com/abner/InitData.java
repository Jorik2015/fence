package com.abner;

import java.util.Calendar;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abner.dao.UserDao;
import com.abner.model.Role;
import com.abner.model.UserEntity;

@Repository
public class InitData implements ApplicationListener {
	private final static Log log = LogFactory.getLog(InitData.class);

	private static final long serialVersionUID = 8671306572341357725L;

	@Autowired
	private UserDao userDao;

	@Transactional
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			log.info("Fence demo init data when Spring context init.");
			initData();
		}
	}

	private void initData() {
		if (userDao.getUserByName("arron") != null)
			return;
		Calendar cal = Calendar.getInstance();

		UserEntity user = new UserEntity();
		user.setUsername("arron");
		user.setAge(50);
		user.setBirthDate(cal.getTime());
		user.setMobile("137143597");
		user.setSalary(1000000);
		user.setPassword(DigestUtils.md5Hex("111"));
		Role role = new Role("SUPER");
		user.getRoles().add(role);
		userDao.save(user);

		user = new UserEntity();
		user.setUsername("abner");
		user.setAge(50);
		user.setBirthDate(cal.getTime());
		user.setMobile("137143597");
		user.setSalary(1000000);
		user.setPassword(DigestUtils.md5Hex("111"));
		user.getRoles().add(new Role("ADMIN"));
		userDao.save(user);

		for (int i = 0; i < 10; i++) {
			cal.add(Calendar.YEAR, -i);
			user = new UserEntity();
			user.setUsername("arron" + i);
			user.setAge(i);
			user.setBirthDate(cal.getTime());
			user.setMobile("137143597" + i);
			user.setSalary(3000 + i);
			user.setPassword(DigestUtils.md5Hex("111"));
			userDao.save(user);
		}
	}
}
