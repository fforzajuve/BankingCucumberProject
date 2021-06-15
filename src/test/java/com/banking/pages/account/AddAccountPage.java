package com.banking.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.banking.driver.DriverUtils;
import com.banking.enums.AccountType;
import com.banking.pages.BasePage;

public class AddAccountPage extends BasePage {
	
	private static final By customerIdTxtBy = By.name("cusid");
	private static final By accountTypeSelectBy = By.name("selaccount");
	private static final By initDepositTxtBy = By.name("inideposit");
	private static final By submitBtnBy = By.name("button2");
	private static final By resetBtnBy = By.name("reset");


	public AddAccountPage(DriverUtils driver) {
		super(driver);
	}

	public void addNewAccount(int customerId,AccountType accountType, double initDeposit) {
		enterCustomerId(customerId);
		selectAccountType(accountType);
		enterInitialDeposit(initDeposit);
		clickSubmitButton();
	}
	
	public void enterCustomerId(int customerId) {
		logger.info("Enter Customer ID: " + customerId);
		driver.findElement(customerIdTxtBy).sendKeys(String.valueOf(customerId));
	}
	
	public void selectAccountType(AccountType accountType) {
		logger.info("Select Account Type: " + accountType);
		Select accountTypeSelect = new Select(driver.findElement(accountTypeSelectBy));
		accountTypeSelect.selectByVisibleText(accountType.getName());
	}
	
	public void enterInitialDeposit(double deposit) {
		logger.info("Enter InitialDeposit: " + deposit);
		driver.findElement(initDepositTxtBy).sendKeys(String.valueOf(deposit));
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
