package com.banking.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.banking.components.NavigationComponent;
import com.banking.driver.DriverUtils;
import com.banking.utils.MyLogger;

public class BasePage {
	protected DriverUtils driver;
	protected MyLogger logger = MyLogger.getInstance();
	
	protected NavigationComponent navigationComponent;
	
	public BasePage(DriverUtils driver) {
		this.driver = driver;
		navigationComponent = new NavigationComponent(driver);
	}

	public NavigationComponent getNavigationComponent() {
		return navigationComponent;
	}
	
	public boolean isAlertPresent() {
		try {
			(new WebDriverWait(driver, 1)).until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String getAlertText() {
		logger.info("Get Alert Text.");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		logger.info("Alert Text: " + alertText);
		driver.acceptAlert();
		return alertText;
	}
}
