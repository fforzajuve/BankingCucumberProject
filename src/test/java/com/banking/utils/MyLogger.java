package com.banking.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MyLogger {
	private static MyLogger instance = null;
	private Logger logger = Logger.getLogger("BankingProject");

	private MyLogger() {
		logger.setLevel(Level.DEBUG);
	}

	public synchronized static MyLogger getInstance() {
		if (instance == null) {
			instance = new MyLogger();
		}
		return instance;
	}

	public void error(Object message) {
		logger.error(message);
	}

	public void warn(Object message) {
		logger.warn(message);
	}

	public void info(Object message) {
		logger.info(message);
	}
}
