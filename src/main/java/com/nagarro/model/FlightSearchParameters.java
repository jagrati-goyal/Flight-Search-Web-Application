package com.nagarro.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class FlightSearchParameters {

	@NotEmpty(message = "Departure Location can't be empty")
	@Size(min = 3, max = 3, message = "Departure Location should be in 3 letter code only")
	private String departureLocation;

	@NotEmpty(message = "Arrival Location can't be empty")
	@Size(min = 3, max = 3, message = "Arrival location should be in 3 letter code only")
	private String arrivalLocation;

	@NotNull(message = "Please select a date first")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;

	@NotEmpty(message = "Please select flight class")
	private String flightClass;

	@NotEmpty(message = "Please select output preference")
	private String outputPreference;

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}

	@Override
	public String toString() {
		return "FlightSearchParameters [departureLocation=" + departureLocation + ", arrivalLocation=" + arrivalLocation
				+ ", date=" + date + ", flightClass=" + flightClass + ", outputPreference=" + outputPreference + "]";
	}
}
