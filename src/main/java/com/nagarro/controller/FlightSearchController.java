package com.nagarro.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.constants.Constants;
import com.nagarro.model.Flight;
import com.nagarro.model.FlightSearchParameters;
import com.nagarro.service.api.FileUploadService;
import com.nagarro.service.api.FlightSearchService;

@Controller
public class FlightSearchController {

	@Autowired
	FileUploadService fileUploadService;

	@Autowired
	FlightSearchService flightSearchService;

	public FlightSearchController(FileUploadService fileUploadService, FlightSearchService flightSearchService) {
		this.fileUploadService = fileUploadService;
		this.flightSearchService = flightSearchService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmer);
	}

	@GetMapping(value = "/params")
	public String showForm(Model model) {
		this.fileUploadService.readDirectory(Constants.PATH);
		model.addAttribute("flightSearchParameters", new FlightSearchParameters());
		return "flightSearch";
	}

	@RequestMapping(value = "/searchFlight", method = RequestMethod.POST)
	public String searchFlight(
			@Valid @ModelAttribute("flightSearchParameters") FlightSearchParameters flightSearchParameters,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			// return "flightSearch";
		} else {
			List<Flight> totalMatchedFlights = this.flightSearchService.getMatchedFlights(flightSearchParameters);
			model.addAttribute("totalMatchedFlights", totalMatchedFlights);
		}
		return "flightSearch";
	}
}
