package com.banking.pages.account;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;
import com.banking.enums.AccountType;
import com.banking.pages.BasePage;

public class AccountCreateMessagePage extends BasePage {

	private static final By accountContainerBy = By.id("account");
	private static final By accountIdLblBy = By.xpath("//td[text()='Account ID']/following-sibling::td[1]");
	private static final By customerIdLblBy = By.xpath("//td[text()='Customer ID']/following-sibling::td[1]");
	private static final By accountTypeLblBy = By.xpath("//td[text()='Account Type']/following-sibling::td[1]");
	private static final By amountLblBy = By.xpath("//td[text()='Current Amount']/following-sibling::td[1]");
	private static final By messageLblBy = By.className("heading3");

	public AccountCreateMessagePage(DriverUtils driver) {
		super(driver);
	}

	public String getInfoMessage() {
		logger.info("Get Message.");
		String message = driver.findElement(messageLblBy).getText();
		logger.info("Message: " + message);
		return message;
	}

	public int getAccountId() {
		logger.info("Get Account Id.");
		String accountId = driver.findElement(accountContainerBy).findElement(accountIdLblBy).getText();
		logger.info("Account Id: " + accountId);
		return Integer.parseInt(accountId);
	}

	public int getCustomerId() {
		logger.info("Get Customer Id.");
		String customerId = driver.findElement(accountContainerBy).findElement(customerIdLblBy).getText();
		logger.info("Customer Id: " + customerId);
		return Integer.parseInt(customerId);
	}

	public AccountType getAccountType() {
		logger.info("Get Account Type.");
		String accountType = driver.findElement(accountContainerBy).findElement(accountTypeLblBy).getText();
		logger.info("Account Type: " + accountType);
		return AccountType.getFrom(accountType);
	}

	public double getAccountAmount() {
		logger.info("Get Amount.");
		String amount = driver.findElement(accountContainerBy).findElement(amountLblBy).getText();
		logger.info("Amount: " + amount);
		return Double.parseDouble(amount);
	}

}
