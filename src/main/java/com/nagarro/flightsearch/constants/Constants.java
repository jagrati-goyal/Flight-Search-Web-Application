package com.nagarro.flightsearch.constants;

/**
 * Abstract Class {@link Constant} consists global constants that may used
 * through the application
 * 
 * @author jagratigoyal
 */

public abstract class Constants {

	public static final String PATH = "C:\\Users\\jagratigoyal\\Documents\\Assignments\\Advance Java Assignment\\Assignment Links";
	public static final String NO_FLIGHTS = "No flights are available";
	public static final String BEFORE_ASPECT_INFO = "Information in @Before advice: Calling the method: ";
	public static final String AFTER_RETURNING_INFO = "Information in @AfterReturning: Calling the method: ";
	public static final String AFTER_RETURNING_RESULT_INFO = "Information: data returned by the method: ";
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String DATE_PICKER_FORMAT = "MM/dd/yyyy";
	public static final String COLUMN_SIZE = "VARCHAR(64)";
	public static final String FILE_EXTENSION = "*.{csv}";

	public static final String FIELD_EMPTY_ERROR = "Please fill out this field";
	public static final String LOCATION_FORMAT_ERROR = "Location should be in 3 letter code only";
	
	private Constants(){ }
}
