package com.nagarro.flightsearch.constants;

/**
 * Abstract Class {@link HQLConstant} contains constants for HQL 
 * 
 * @author jagratigoyal
 */

public abstract class HQLConstants {
	// flight object fields
	public static final String FIELD_DEPARTURE_LOCATION = "departureLocation";
	public static final String FIELD_ARRIVAL_LOCATION = "arrivalLocation";
	public static final String FIELD_VALID_TILL = "validTill";
	public static final String FIELD_FLIGHT_CLASS = "flightClass";
	public static final String FILED_DURATION = "duration";
	public static final String FIELD_FARE = "fare";
	
	// query and its parameters
	public static final String QUERY_DELETE_FLIGHT = "delete from Flight";
	public static final String QUERY_SELECT_USER = "from User u where u.name = :name and u.password = :password";
	public static final String QUERY_NAME_PARAM = "name";
	public static final String QUERY_PASSWORD_PARAM = "password";

	private HQLConstants() {
	}

}
