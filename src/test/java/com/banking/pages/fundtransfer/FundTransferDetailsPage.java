package com.banking.pages.fundtransfer;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;
import com.banking.pages.BasePage;

public class FundTransferDetailsPage extends BasePage {
	
	private static final By fromAccountIdLblBy = By.xpath("//td[text()='From Account Number']/following-sibling::td[1]");
	private static final By toAccountIdLblBy = By.xpath("//td[text()='To Account Number']/following-sibling::td[1]");
	private static final By amountLblBy = By.xpath("//td[text()='Amount']/following-sibling::td[1]");
	private static final By descriptionLblBy = By.xpath("//td[text()='Description']/following-sibling::td[1]");


	public FundTransferDetailsPage(DriverUtils driver) {
		super(driver);
	}

	public int getPayerAccountId() {
		logger.info("Get Payer Account Id.");
		String payerId = driver.findElement(fromAccountIdLblBy).getText();
		logger.info("Payer Account Id: " + payerId);
		return Integer.parseInt(payerId);
	}

	public int getPayeeAccountId() {
		logger.info("Get Payee Account Id.");
		String payeeId = driver.findElement(toAccountIdLblBy).getText();
		logger.info("Payee Account Id: " + payeeId);
		return Integer.parseInt(payeeId);
	}
	
	public double getAmount() {
		logger.info("Get Amount.");
		String accountId = driver.findElement(amountLblBy).getText();
		logger.info("Amount: " + accountId);
		return Double.parseDouble(accountId);
	}
	
	public String getDescription() {
		logger.info("Get Description.");
		String desc = driver.findElement(descriptionLblBy).getText();
		logger.info("Description: " + desc);
		return desc;
	}
}
