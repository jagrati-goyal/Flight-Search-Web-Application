package com.nagarro.flightsearch.constants;

/**
 * Abstract Class {@link SpringConstant} contains constants for spring mvc
 * 
 * @author jagratigoyal
 */

public abstract class SpringConstants {
	public static final String REQUEST_DEFAULT_PAGE = "/";
	public static final String REQUEST_SEARCH_FLIGHT = "/searchFlight";
	public static final String REQUEST_LOGIN = "/login";
	public static final String REQUEST_LOGOUT = "/logout";

	public static final String REDIRECT_SEARCH_FLIGHT = "redirect:searchFlight";
	public static final String REDIRECT_DEFAULT_PAGE = "redirect:/";

	public static final String MODEL_FLIGHT_SEARCH_PARAMS = "flightSearchParameters";
	public static final String MODEL_MATCHED_FLIGHTS = "totalMatchedFlights";
	public static final String MODEL_USER = "user";
	public static final String MODEL_INVALID_USER = "invalidUser";

	public static final String VIEW_FLIGHT_SEARCH = "flightSearch";
	public static final String VIEW_LOGIN = "login";

	private SpringConstants() {
	}
}
