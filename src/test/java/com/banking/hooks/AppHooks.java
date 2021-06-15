package com.banking.hooks;


import com.banking.driver.DriverManager;
import com.banking.utils.PropertiesUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppHooks {
	@Before(order = 0)
	public void setUp() {
		DriverManager.getDriver().get(PropertiesUtil.getBaseUrl());
	}

	@After(order = 0)
	public void tearDown() {
		DriverManager.closeDefaultDriver();
	}

}
