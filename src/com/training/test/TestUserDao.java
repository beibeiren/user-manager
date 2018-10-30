package com.training.test;

import org.junit.Test;

import com.training.entity.User;
import com.training.login.dao.UserDao;

public class TestUserDao {
	@Test
	public void testFindUserByUsernameAndPassword() {
		UserDao userDao = new UserDao();
		User user;
		try {
			user = userDao.findUserByUsernameAndPassword("admin", "admin");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
