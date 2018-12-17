package com.nagarro.flightsearch.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.flightsearch.constants.Constants;
import com.nagarro.flightsearch.dao.api.FlightDao;
import com.nagarro.flightsearch.service.api.FileUploadService;

/**
 * The Class {@link WatcherService} is a thread, used to watch the changes in a
 * specified directory.
 * 
 * @author jagratigoyal
 */
@Service
public class WatcherService implements Runnable {
	private static Thread server;

	@Autowired
	FileUploadService fileUploadService;

	@Autowired
	FlightDao flightDao;

	/**
	 * This <code>start</code> function creates a new single thread
	 */
	public void start() {
		server = new Thread(this);
		server.start();
	}

	/**
	 * This <code>stop</code> function stops a thread
	 */
	public void stop() {
		Thread temp = server;
		temp.interrupt();
	}

	@Override
	public void run() {
		try {
			Path dir = Paths.get(Constants.PATH);
			WatchService watcher = dir.getFileSystem().newWatchService();
			dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			WatchKey watchKey;
			while ((watchKey = watcher.take()) != null) {
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE
							|| event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
						this.fileUploadService.readDirectory(Constants.PATH);
					} else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
						this.flightDao.deleteAll();
						this.fileUploadService.readDirectory(Constants.PATH);
					}
					watchKey.reset();
				}
			}
		} catch (IOException | SecurityException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
