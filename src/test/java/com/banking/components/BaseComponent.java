package com.banking.components;

import com.banking.driver.DriverUtils;
import com.banking.utils.MyLogger;

public class BaseComponent {
	protected DriverUtils driver;

	protected MyLogger logger = MyLogger.getInstance();

	public BaseComponent(DriverUtils driver) {
		this.driver = driver;
	}
}
