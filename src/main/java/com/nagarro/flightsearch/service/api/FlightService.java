package com.nagarro.flightsearch.service.api;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;

/**
 * The interface {@link FlightService} should be implemented to find out all the
 * flights based on the input parameters from the database.
 * 
 * @author jagratigoyal
 */
public interface FlightService {

	/**
	 * To get all matched {@link Flight}(s) based on
	 * {@link FlightSearchParameters} object.
	 * 
	 * @param searchParams
	 *            - {@link FlightSearchParameters} object
	 * @return - list of {@link Flight}(s)
	 */
	public List<Flight> getMatchedFlights(FlightSearchParameters searchParams);
}
