package com.nagarro.service.api;

import java.util.List;

import com.nagarro.model.Flight;
import com.nagarro.model.FlightSearchParameters;

public interface FlightSearchService {
	public List<Flight> getMatchedFlights(FlightSearchParameters searchParams);
}
