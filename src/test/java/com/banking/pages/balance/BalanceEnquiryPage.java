package com.banking.pages.balance;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;
import com.banking.enums.AccountType;
import com.banking.pages.BasePage;

public class BalanceEnquiryPage extends BasePage {

	private static final By balanceContainerBy = By.id("balenquiry");
	private static final By accountIdLblBy = By.xpath("//td[text()='Account No']/following-sibling::td[1]");
	private static final By accountTypeLblBy = By.xpath("//td[text()='Type of Account']/following-sibling::td[1]");
	private static final By balanceLblBy = By.xpath("//td[text()='Balance']/following-sibling::td[1]");

	public BalanceEnquiryPage(DriverUtils driver) {
		super(driver);
	}

	public int getAccountId() {
		logger.info("Get Account Id.");
		String accountId = driver.findElement(balanceContainerBy).findElement(accountIdLblBy).getText();
		logger.info("Account Id: " + accountId);
		return Integer.parseInt(accountId);
	}

	public AccountType getAccountType() {
		logger.info("Get Account Type.");
		String accountType = driver.findElement(balanceContainerBy).findElement(accountTypeLblBy).getText();
		logger.info("Account Type: " + accountType);
		return AccountType.getFrom(accountType);
	}

	public double getBalance() {
		logger.info("Get Balance.");
		String balance = driver.findElement(balanceContainerBy).findElement(balanceLblBy).getText();
		logger.info("Balance: " + balance);
		return Double.parseDouble(balance);
	}
}
