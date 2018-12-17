package com.nagarro.flightsearch.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.nagarro.flightsearch.constants.Constants;

/**
 * The class {@link Flight} is used as the blueprint for the flight. Contains
 * the parameters associated with flight.
 * 
 * @author jagratigoyal
 */
@Entity
public class Flight {

	@Id
	@Column(nullable = false, columnDefinition = Constants.COLUMN_SIZE)
	private String number;

	@Column(nullable = false)
	private String departureLocation;

	@Column(nullable = false)
	private String arrivalLocation;

	@Column(nullable = false)
	@DateTimeFormat(pattern = Constants.DATE_FORMAT)
	private Date validTill;

	@Column(nullable = false)
	private int time;

	@Column(nullable = false)
	private float duration;

	@Column(nullable = false)
	private double fare;

	@Column(nullable = false)
	private char seatAvailability;

	@Column(nullable = false)
	private String flightClass;

	/**
	 * constructs a new Flight instance with the default values
	 * 
	 */
	public Flight() {
	}

	/**
	 * constructs a new instance of Flight with the specified values provided as
	 * string array
	 * 
	 * @param flight
	 *            {@link String[]}
	 */
	public Flight(String[] flight) {
		/*
		 * Pattern is [FLIGHT_NO, DEP_LOC, ARR_LOC, VALID_TILL, FLIGHT_TIME,
		 * FLIGHT_DUR, FARE, SEAT_AVAILABILITY, CLASS]
		 */
		this.number = flight[0];
		this.departureLocation = flight[1];
		this.arrivalLocation = flight[2];
		try {
			this.validTill = new SimpleDateFormat(Constants.DATE_FORMAT).parse(flight[3]);
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		this.time = Integer.parseInt(flight[4]);
		this.duration = Float.parseFloat(flight[5]);
		this.fare = Double.parseDouble(flight[6]);
		this.seatAvailability = flight[7].charAt(0);
		this.flightClass = flight[8];
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

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

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public char getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(char seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		return "Flight [number=" + number + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", validTill=" + validTill + ", time=" + time + ", duration=" + duration + ", fare="
				+ fare + ", seatAvailability=" + seatAvailability + ", flightClass=" + flightClass + "]";
	}

}
