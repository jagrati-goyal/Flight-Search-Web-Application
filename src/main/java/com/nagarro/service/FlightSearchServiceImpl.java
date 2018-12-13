package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.api.FlightDao;
import com.nagarro.model.Flight;
import com.nagarro.model.FlightSearchParameters;
import com.nagarro.service.api.FlightSearchService;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	@Autowired
	FlightDao flightDao;

	public FlightSearchServiceImpl(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	@Override
	public List<Flight> getMatchedFlights(FlightSearchParameters searchParams) {
		return this.flightDao.retrieveMatchedFlights(searchParams);
	}

}
