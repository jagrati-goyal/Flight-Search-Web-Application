package com.nagarro.dao.api;

import java.util.List;

import com.nagarro.model.Flight;
import com.nagarro.model.FlightSearchParameters;

public interface FlightDao {
	public void save(Flight flight);
	public List<Flight> retrieveMatchedFlights(FlightSearchParameters searchParams);
}
