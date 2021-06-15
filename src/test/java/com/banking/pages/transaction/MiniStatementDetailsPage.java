package com.banking.pages.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.banking.bo.Transaction;
import com.banking.driver.DriverUtils;
import com.banking.pages.BasePage;

public class MiniStatementDetailsPage extends BasePage {
	
	private static final By miniStatementContainerBy = By.cssSelector("#ministmt,#customstmt");
	private static final By transactionHeadersBy = By.xpath("//tbody/tr/th");
	private static final By transactionRowBy = By.xpath(".//tr");

	public MiniStatementDetailsPage(DriverUtils driver) {
		super(driver);
	}
	
	public List<String> getTransctionHeaders() {
		logger.info("Get Transaction Headers.");
		List<String> headers = driver.findElement(miniStatementContainerBy).findElements(transactionHeadersBy).stream()
				.map(element -> element.getText()).collect(Collectors.toList());
		logger.info("Transaction Headers: " + headers);
		return headers;
	}
	
	public Transaction getTransactionByIndex(int index) {
		logger.info("Get Transaction by index: " + index);
		WebElement row = driver.findElement(miniStatementContainerBy).findElements(transactionRowBy).get(index);
		String id = row.findElement(By.xpath(".//td[1]")).getText();
		String amount =  row.findElement(By.xpath(".//td[2]")).getText();
		String type =  row.findElement(By.xpath(".//td[3]")).getText();
		String desc =  row.findElement(By.xpath(".//td[5]")).getText();
		Transaction transaction = new Transaction(Integer.parseInt(id),Double.parseDouble(amount),type,desc);
		return transaction;
	}
	
	public List<Transaction> getAllTransactions() {
		logger.info("Get All Transactions.");
		List<Transaction> transactions = new ArrayList<>();
		List<WebElement> rows = driver.findElement(miniStatementContainerBy).findElements(transactionRowBy);
		for(int i =1; i < rows.size()-1; i++) {
			WebElement transactionRow = driver.findElement(miniStatementContainerBy).findElements(transactionRowBy).get(i);
			String id = transactionRow.findElement(By.xpath(".//td[1]")).getText();
			String amount =  transactionRow.findElement(By.xpath(".//td[2]")).getText();
			String type =  transactionRow.findElement(By.xpath(".//td[3]")).getText();
			String desc =  transactionRow.findElement(By.xpath(".//td[5]")).getText();
			Transaction transaction = new Transaction(Integer.parseInt(id),Double.parseDouble(amount),type,desc);
			transactions.add(transaction);
		}
		logger.info("Transactions: " + transactions);
		return transactions;
	}

}
