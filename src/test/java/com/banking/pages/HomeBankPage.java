package com.banking.pages;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;

public class HomeBankPage extends BasePage {
	
	private static final By userIdLblBy = By.xpath("//tr[@class='heading3']/td");

	public HomeBankPage(DriverUtils driver) {
		super(driver);
	}

	public String getUserId() {
		logger.info("Get User Id.");
		String id = driver.findElement(userIdLblBy).getText().split(":")[1].trim();
		logger.info("User Id: " + id);
		return id;
	}
}
