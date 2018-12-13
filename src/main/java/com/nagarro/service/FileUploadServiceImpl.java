package com.nagarro.service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.api.FlightDao;
import com.nagarro.model.Flight;
import com.nagarro.service.api.FileUploadService;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	FlightDao flightDao;
	
	public FileUploadServiceImpl(FlightDao flightDao) {
		this.flightDao = flightDao;
	}
	
	@Override
	public void readDirectory(String directory) {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory), "*.{csv}")) {
			for (Path path : directoryStream) {
				readFile(path.toString());
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public void readFile(String file) {
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1)
					.withCSVParser(new CSVParserBuilder().withSeparator('|').build()).build();
			List<String[]> allFlights = reader.readAll();
			for (String[] data : allFlights) {
				Flight flight = new Flight(data);
				flightDao.save(flight);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
