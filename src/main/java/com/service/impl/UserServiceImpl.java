package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements  UserService{
	
	@Autowired
	UserDao userDao;
	

	@Override
	public User login(String username, String pwd) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(pwd);
		return userDao.loginServlet(user);
	}
	
	

}
