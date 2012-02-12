package com.fence;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fence.dao.UserDao;

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

	}
}
