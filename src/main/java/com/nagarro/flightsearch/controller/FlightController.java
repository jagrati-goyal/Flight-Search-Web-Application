package com.nagarro.flightsearch.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagarro.flightsearch.constants.Constants;
import com.nagarro.flightsearch.constants.SpringConstants;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;
import com.nagarro.flightsearch.service.WatcherService;
import com.nagarro.flightsearch.service.api.FileUploadService;
import com.nagarro.flightsearch.service.api.FlightService;

/**
 * The class {@link FlightController} is a Spring Controller class.<br>
 * This class handles the requests that are concerns for the flight searching
 * and listing matched flights operations. <br>
 * <br>
 * The user should not create the instance of this class as the Spring container
 * automatically registers this class as bean in the application context.
 * 
 * @author jagratigoyal
 */

@Controller
public class FlightController {

	@Autowired
	FileUploadService fileUploadService;

	@Autowired
	FlightService flightService;

	@Autowired
	Runnable watchService;

	public FlightController(FileUploadService fileUploadService, FlightService flightService,
			Runnable watchService) {
		this.fileUploadService = fileUploadService;
		this.flightService = flightService;
		this.watchService = watchService;
	}

	/**
	 * this preprocessor used to trim whitespaces from string and to start {@link WatcherService} thread
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		((WatcherService) this.watchService).start();
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmer);
	}

	/**
	 * this method handles request to show flight search page 
	 * 
	 * @param model
	 * @return flight search view
	 */
	@GetMapping(SpringConstants.REQUEST_SEARCH_FLIGHT)
	public String showForm(Model model) {
		this.fileUploadService.readDirectory(Constants.PATH);
		model.addAttribute(SpringConstants.MODEL_FLIGHT_SEARCH_PARAMS, new FlightSearchParameters());
		return SpringConstants.VIEW_FLIGHT_SEARCH;
	}

	/**
	 * method that performs searching of flights.<br>
	 * 
	 * @param flightSearchParameters
	 * @param result
	 *            used to store the errors that may arise while validating the
	 *            search parameters
	 * @param model
	 *            used to store the list of all matched flights<br>
	 * @return flight search view that contains flights that matched the
	 *         criteria
	 */
	@PostMapping(SpringConstants.REQUEST_SEARCH_FLIGHT)
	public String searchFlight(
			@Valid @ModelAttribute(SpringConstants.MODEL_FLIGHT_SEARCH_PARAMS) FlightSearchParameters flightSearchParameters,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return SpringConstants.VIEW_FLIGHT_SEARCH;
		} else {
			List<Flight> totalMatchedFlights = this.flightService.getMatchedFlights(flightSearchParameters);
			model.addAttribute(SpringConstants.MODEL_MATCHED_FLIGHTS, totalMatchedFlights);
			return SpringConstants.VIEW_FLIGHT_SEARCH;
		}
	}
}
