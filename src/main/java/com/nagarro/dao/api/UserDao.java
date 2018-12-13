package com.nagarro.dao.api;

import com.nagarro.model.User;

public interface UserDao {
	public User getUser(String name, String password);
}
