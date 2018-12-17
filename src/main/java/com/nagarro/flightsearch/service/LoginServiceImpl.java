package com.nagarro.flightsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.flightsearch.dao.api.UserDao;
import com.nagarro.flightsearch.model.User;
import com.nagarro.flightsearch.service.api.LoginService;

/**
 * The Class {@link LoginServiceImpl} is an implementation class of
 * {@link LoginService} can be used to perform operations related to database.
 * 
 * @author jagratigoyal
 */
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
