package com.banking.steps;

import java.util.List;

import com.banking.bo.Transaction;
import com.banking.driver.DriverManager;
import com.banking.pages.transaction.MiniStatementDetailsPage;
import com.banking.pages.transaction.MiniStatementInputPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TransactionSteps {

	@When("user selects transactions for {int} account")
	public void user_selects_transactions_for_account(int accountId) {
		MiniStatementInputPage miniStatementInputPage = new MiniStatementInputPage(DriverManager.getDriver());
		miniStatementInputPage.selectAccount(accountId);
	}

	@Then("transaction should have following parts")
	public void transaction_should_have_following_parts(DataTable transactionTable) {
		List<String> transactionHeaders = transactionTable.asList();
		MiniStatementDetailsPage miniStatementDetailsPage = new MiniStatementDetailsPage(DriverManager.getDriver());

		// Verify Transaction Headers
		List<String> transactionHeadersActual = miniStatementDetailsPage.getTransctionHeaders();
		Assert.assertEquals("Transaction Headers are wrong.", transactionHeaders, transactionHeadersActual);
	}

	@Then("last five transactions should be displayed")
	public void last_five_transactions_should_be_displayed() {
		MiniStatementDetailsPage miniStatementDetailsPage = new MiniStatementDetailsPage(DriverManager.getDriver());

		// Verify Number of Transactions Transactions
		List<Transaction> transactions = miniStatementDetailsPage.getAllTransactions();
		Assert.assertTrue("Number of transactions is wrong.", transactions.size() > 0 && transactions.size() <= 5);
	}

}
