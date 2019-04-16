package com.dao;

import org.springframework.stereotype.Repository;

import com.pojo.User;

@Repository
public interface UserDao {

	User loginServlet(User user);



}
