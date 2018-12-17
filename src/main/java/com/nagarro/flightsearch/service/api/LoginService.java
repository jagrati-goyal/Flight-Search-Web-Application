package com.nagarro.flightsearch.service.api;

/**
 * The class {@link LoginService} is a service class.<br>
 * This class provides the database related services.
 * 
 * @author jagratigoyal
 */
public interface LoginService {
	/**
	 * check for valid {@link User} by specified username and password
	 * 
	 * @param name
	 *            - {@link User}'s name
	 * @param password
	 *            - {@link User}'s password
	 * @return boolean
	 */
	public boolean isValidUser(String name, String password);
}
