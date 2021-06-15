package com.banking.pages.deposit;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;
import com.banking.pages.BasePage;

public class DepositInputPage extends BasePage {

	private static final By accountIdTxtBy = By.name("accountno");
	private static final By amountTxtBy = By.name("ammount");
	private static final By descTxtBy = By.name("desc");
	private static final By submitBtnBy = By.name("AccSubmit");
	private static final By resetBtnBy = By.name("res");

	public DepositInputPage(DriverUtils driver) {
		super(driver);
	}
	
	public void putDepositToAccount(int accountId, double amount, String desc) {
		enterAccountId(accountId);
		enterAmount(amount);
		enterDescription(desc);
		clickSubmitButton();
	}

	public void enterAccountId(int accountId) {
		logger.info("Enter Account ID: " + accountId);
		driver.findElement(accountIdTxtBy).sendKeys(String.valueOf(accountId));
	}

	public void enterAmount(double amount) {
		logger.info("Enter Amount: " + amount);
		driver.findElement(amountTxtBy).sendKeys(String.valueOf(amount));
	}
	
	public void enterDescription(String desc) {
		logger.info("Enter Description: " + desc);
		driver.findElement(descTxtBy).sendKeys(desc);
	}
	
	public void clickSubmitButton() {
		logger.info("Click Submit Button");
		driver.findElement(submitBtnBy).click();
	}
	
	public void clickResetButton() {
		logger.info("Click Reset Button");
		driver.findElement(resetBtnBy).click();
	}
}
