package com.service;

import com.pojo.User;

public interface UserService {

	User login(String username, String pwd);

}