package com.nagarro.flightsearch.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.nagarro.flightsearch.constants.Constants;

/**
 * Whenever a user queries for a flight search, an object of this class will be
 * created
 * 
 * @author jagratigoyal
 */
public class FlightSearchParameters {

	@NotEmpty(message = Constants.FIELD_EMPTY_ERROR)
	@Size(min = 3, max = 3, message = Constants.LOCATION_FORMAT_ERROR)
	private String departureLocation;

	@NotEmpty(message = Constants.FIELD_EMPTY_ERROR)
	@Size(min = 3, max = 3, message = Constants.LOCATION_FORMAT_ERROR)
	private String arrivalLocation;

	@NotNull(message = Constants.FIELD_EMPTY_ERROR)
	@DateTimeFormat(pattern = Constants.DATE_PICKER_FORMAT)
	private Date date;

	@NotEmpty(message = Constants.FIELD_EMPTY_ERROR)
	private String flightClass;

	@NotEmpty(message = Constants.FIELD_EMPTY_ERROR)
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
