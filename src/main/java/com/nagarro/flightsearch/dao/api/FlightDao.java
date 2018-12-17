package com.nagarro.flightsearch.dao.api;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;

/**
 * Interface {@link FlightDao} specifies basic {@link Flight} operations
 * 
 * @author jagratigoyal
 */
public interface FlightDao {

	/**
	 * saves the {@link Flight} object
	 * 
	 * @param flight
	 *            - {@link Flight} object
	 */
	public void save(Flight flight);

	/**
	 * retrieves flight(s) that matches the specified flight parameters
	 * 
	 * @param searchParams
	 *            - {@link FlightSearchParameters} object
	 * @return the {@link List} of {@link Flight}
	 */
	public List<Flight> retrieveMatchedFlights(FlightSearchParameters searchParams);

	/**
	 * deletes flight records
	 */
	public void deleteAll();
}
