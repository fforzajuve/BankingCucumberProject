package com.banking.steps;

import org.junit.Assert;

import com.banking.driver.DriverManager;
import com.banking.pages.balance.BalanceEnquiryInputPage;
import com.banking.pages.balance.BalanceEnquiryPage;
import com.banking.pages.deposit.DepositInputPage;
import com.banking.pages.deposit.DepositPage;
import com.banking.pages.fundtransfer.FundTransferDetailsPage;
import com.banking.pages.fundtransfer.FundTransferInputPage;
import com.banking.pages.withdrawal.WithdrawalDeatailsPage;
import com.banking.pages.withdrawal.WithdrawalInputPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BalanceSteps {

	@When("user selects account {int}")
	public void user_selects_account(int accountId) {
		BalanceEnquiryInputPage balanceEnquiryInputPage = new BalanceEnquiryInputPage(DriverManager.getDriver());
		balanceEnquiryInputPage.selectAccount(accountId);
	}

	@Then("balance should be displayed for {int} account")
	public void balance_should_be_displayed_for_account(int accountId) {
		BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage(DriverManager.getDriver());

		// Verify Account Id
		int actualAccountId = balanceEnquiryPage.getAccountId();
		Assert.assertEquals("Account Id is wrong", accountId, actualAccountId);

		// Verify Balance
		double balance = balanceEnquiryPage.getBalance();
		Assert.assertTrue("Balance is wrong", balance > 0);
	}

	@When("user adds {double} dollars to account {int}")
	public void user_adds_dollars_to_account(double amount, int accountId) {
		DepositInputPage depositInputPage = new DepositInputPage(DriverManager.getDriver());
		depositInputPage.putDepositToAccount(accountId, amount, "deposit");
	}

	@Then("{double} dollars should be added to account {int}")
	public void dollars_should_be_added_to_account(double amount, int accountId) {
		DepositPage depositPage = new DepositPage(DriverManager.getDriver());

		// Verify deposit amount
		double amountActual = depositPage.getAmount();
		Assert.assertEquals("Amount is wrong", amount, amountActual, 0);

		// Verify AccountID
		int accountIdActual = depositPage.getAccountId();
		Assert.assertEquals("Account Id is wrong", accountId, accountIdActual);

	}

	@When("user withdraws {double} dollars from account {int}")
	public void user_withdraws_dollars_from_account(double amount, int accountId) {
		WithdrawalInputPage withdrawalInputPage = new WithdrawalInputPage(DriverManager.getDriver());
		withdrawalInputPage.withdrawMoneyFromAccount(accountId, amount, "withdraw money");
	}

	@Then("{double} dollars should be taken from account {int}")
	public void dollars_should_be_taken_from_account(double amount, int accountId) {
		WithdrawalDeatailsPage withdrawalDeatailsPage = new WithdrawalDeatailsPage(DriverManager.getDriver());

		// Verify Account Id
		int accountIdActual = withdrawalDeatailsPage.getAccountId();
		Assert.assertEquals("Account Id is wrong", accountId, accountIdActual);

		// Verify Amount
		double amountActual = withdrawalDeatailsPage.getAmount();
		Assert.assertEquals("Amount is wrong", amount, amountActual, 0);
	}

	@When("user transfers {double} dollars from account {int} to account {int}")
	public void user_transfers_dollars_from_account_to_account(double amount, int payerId, int payeeId) {
		FundTransferInputPage fundTransferInputPage = new FundTransferInputPage(DriverManager.getDriver());
		fundTransferInputPage.transferFund(payerId, payeeId, amount, "fund transfer");
	}

	@Then("{double} dollars should be transfered from account {int} to account {int}")
	public void dollars_should_be_transfered_from_account_to_account(double amount, int payerId, int payeeId) {
		FundTransferDetailsPage fundTransferDetailsPage = new FundTransferDetailsPage(DriverManager.getDriver());

		// Verify Payer Id
		int payerIdActual = fundTransferDetailsPage.getPayerAccountId();
		Assert.assertEquals("Payer Id is wrong", payerId, payerIdActual);

		// Verify Payee Id
		int payeeIdActual = fundTransferDetailsPage.getPayeeAccountId();
		Assert.assertEquals("Payee Id is wrong", payeeId, payeeIdActual);

		// Verify Amount
		double amountActual = fundTransferDetailsPage.getAmount();
		Assert.assertEquals("Amount is wrong", amount, amountActual, 0);
	}

}
