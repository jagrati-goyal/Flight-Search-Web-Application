package com.nagarro.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {

	@Id
	@Column(nullable = false, columnDefinition="VARCHAR(64)")
	private String number;

	@Column(nullable = false)
	private String departureLocation;

	@Column(nullable = false)
	private String arrivalLocation;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date validTill;

	@Column(nullable = false)
	private int time;

	@Column(nullable = false)
	private float duration;

	@Column(nullable = false)
	private double fare;

	@Column(nullable = false)
	@NotNull
	private char seatAvailability;

	@Column(nullable = false)
	private String flightClass;

	public Flight(){}
	
	public Flight(String[] flight) {
		/*
		 * Pattern is
		 * [FLIGHT_NO, DEP_LOC, ARR_LOC, VALID_TILL, FLIGHT_TIME, FLIGHT_DUR, FARE,
		 * SEAT_AVAILABILITY, CLASS]
		 */
		this.number = flight[0];
		this.departureLocation = flight[1];
		this.arrivalLocation = flight[2];
		try {
			this.validTill = new SimpleDateFormat("dd-mm-yyyy").parse(flight[3]);
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		this.time = Integer.parseInt(flight[4]);
		this.duration = Float.parseFloat(flight[5]);
		this.fare = Double.parseDouble(flight[6]);
		this.seatAvailability = flight[7].charAt(0);
		this.flightClass = flight[8];
		/*
		 * if (this.getFlightClass().contains("B")) { this.setFare((0.4 *
		 * this.getFare()) + this.getFare()); }
		 */
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalLocation == null) ? 0 : arrivalLocation.hashCode());
		result = prime * result + ((departureLocation == null) ? 0 : departureLocation.hashCode());
		result = prime * result + Float.floatToIntBits(duration);
		long temp;
		temp = Double.doubleToLongBits(fare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((flightClass == null) ? 0 : flightClass.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + seatAvailability;
		result = prime * result + time;
		result = prime * result + ((validTill == null) ? 0 : validTill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (arrivalLocation == null) {
			if (other.arrivalLocation != null)
				return false;
		} else if (!arrivalLocation.equals(other.arrivalLocation))
			return false;
		if (departureLocation == null) {
			if (other.departureLocation != null)
				return false;
		} else if (!departureLocation.equals(other.departureLocation))
			return false;
		if (Float.floatToIntBits(duration) != Float.floatToIntBits(other.duration))
			return false;
		if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
			return false;
		if (flightClass == null) {
			if (other.flightClass != null)
				return false;
		} else if (!flightClass.equals(other.flightClass))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (seatAvailability != other.seatAvailability)
			return false;
		if (time != other.time)
			return false;
		if (validTill == null) {
			if (other.validTill != null)
				return false;
		} else if (!validTill.equals(other.validTill))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [number=" + number + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", validTill=" + validTill + ", time=" + time + ", duration=" + duration + ", fare="
				+ fare + ", seatAvailability=" + seatAvailability + ", flightClass=" + flightClass + "]";
	}

}
