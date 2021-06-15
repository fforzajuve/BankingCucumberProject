package com.banking.pages.fundtransfer;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;
import com.banking.pages.BasePage;

public class FundTransferInputPage extends BasePage {

	private static final By payerTxtBy = By.name("payersaccount");
	private static final By payeeTxtBy = By.name("payeeaccount");
	private static final By amountTxtBy = By.name("ammount");
	private static final By descTxtBy = By.name("desc");
	private static final By submitBtnBy = By.name("AccSubmit");
	private static final By resetBtnBy = By.name("res");

	public FundTransferInputPage(DriverUtils driver) {
		super(driver);
	}

	public void transferFund(int payerAccountId, int payeeAccountId, double amount, String desc) {
		enterPayerAccount(payerAccountId);
		enterPayeeAccount(payeeAccountId);
		enterAmount(amount);
		enterDescription(desc);
		clickSubmitButton();
	}

	public void enterPayerAccount(int accountId) {
		logger.info("Enter Payer Account Number: " + accountId);
		driver.findElement(payerTxtBy).sendKeys(String.valueOf(accountId));
	}

	public void enterPayeeAccount(int accountId) {
		logger.info("Enter Payee Account Number: " + accountId);
		driver.findElement(payeeTxtBy).sendKeys(String.valueOf(accountId));
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
