package com.nagarro.flightsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.flightsearch.dao.api.FlightDao;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;
import com.nagarro.flightsearch.service.api.FlightService;

/**
 * The class {@link FlightServiceImpl} is a service class. <br>
 * It is an implementation class of {@link FlightService} from which user
 * interacts for getting the facilities of database services
 * 
 * @author jagratigoyal
 */
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	public FlightServiceImpl(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	@Override
	public List<Flight> getMatchedFlights(FlightSearchParameters searchParams) {
		List<Flight> matchedFlights = this.flightDao.retrieveMatchedFlights(searchParams);
		if ("B".equalsIgnoreCase(searchParams.getFlightClass())) {
			matchedFlights.forEach((Flight flight) -> {
				double originalFare = flight.getFare();
				flight.setFare(originalFare + (originalFare * 0.4));
			});
		}
		return matchedFlights;
	}

}
