package com.nagarro.flightsearch.service.api;

/**
 * Interface {@link FileUploadService} should be implemented to provide
 * file/directory reading functionalities
 * 
 * @author jagratigoyal
 */
public interface FileUploadService {

	/**
	 * To read a specified file
	 * 
	 * @param file
	 *            - {@link String}
	 */
	public void readFile(String file);

	/**
	 * To read a specified directory
	 * 
	 * @param directory-
	 *            {@link String}
	 */
	public void readDirectory(String directory);
}
