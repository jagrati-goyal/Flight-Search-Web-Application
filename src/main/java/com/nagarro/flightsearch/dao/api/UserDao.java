package com.nagarro.flightsearch.dao.api;

import com.nagarro.flightsearch.model.User;

/**
 * The interface {@link UserDao} specifies basic DB operations on {@link User}
 * 
 * @author jagratigoyal
 */
public interface UserDao {

	/**
	 * gets the login details for the user with the specified username and
	 * password
	 * 
	 * @param name
	 *            - the username of {@link User}
	 * @param password
	 *            - password of {@link User}
	 * @return {@link User} object
	 */
	public User getUser(String name, String password);
}
