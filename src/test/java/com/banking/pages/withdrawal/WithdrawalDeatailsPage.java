package com.banking.pages.withdrawal;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;
import com.banking.pages.BasePage;

public class WithdrawalDeatailsPage extends BasePage {

	private static final By withdrawalContainerBy = By.id("withdraw");
	private static final By accountIdLblBy = By.xpath("//td[text()='Account No']/following-sibling::td[1]");
	private static final By amountLblBy = By.xpath("//td[text()='Amount Debited']/following-sibling::td[1]");
	private static final By transactionTypeLblBy = By
			.xpath("//td[text()='Type of Transaction']/following-sibling::td[1]");
	private static final By descriptionLblBy = By.xpath("//td[text()='Description']/following-sibling::td[1]");
	private static final By balanceLblBy = By.xpath("//td[text()='Current Balance']/following-sibling::td[1]");

	public WithdrawalDeatailsPage(DriverUtils driver) {
		super(driver);
	}

	public int getAccountId() {
		logger.info("Get Account Id.");
		String accountId = driver.findElement(withdrawalContainerBy).findElement(accountIdLblBy).getText();
		logger.info("Account Id: " + accountId);
		return Integer.parseInt(accountId);
	}

	public double getAmount() {
		logger.info("Get Amount.");
		String accountId = driver.findElement(withdrawalContainerBy).findElement(amountLblBy).getText();
		logger.info("Amount: " + accountId);
		return Double.parseDouble(accountId);
	}

	public String getTransactionType() {
		logger.info("Get Transaction Type.");
		String transactionType = driver.findElement(withdrawalContainerBy).findElement(transactionTypeLblBy).getText();
		logger.info("Transaction Type: " + transactionType);
		return transactionType;
	}

	public String getDescription() {
		logger.info("Get Description.");
		String desc = driver.findElement(withdrawalContainerBy).findElement(descriptionLblBy).getText();
		logger.info("Description: " + desc);
		return desc;
	}

	public double getBalance() {
		logger.info("Get Balance.");
		String balance = driver.findElement(withdrawalContainerBy).findElement(balanceLblBy).getText();
		logger.info("Balance: " + balance);
		return Double.parseDouble(balance);
	}
}
