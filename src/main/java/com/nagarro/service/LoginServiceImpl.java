package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.api.UserDao;
import com.nagarro.model.User;
import com.nagarro.service.api.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserDao userDao;

	@Override
	public boolean isValidUser(String name, String password) {
		boolean validUser = false;
		User user = userDao.getUser(name, password);
		if (user != null) {
			validUser = true;
		}

		return validUser;
	}
}
