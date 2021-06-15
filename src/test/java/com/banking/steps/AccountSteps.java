package com.banking.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.banking.driver.DriverManager;
import com.banking.enums.AccountType;
import com.banking.pages.account.AccountCreateMessagePage;
import com.banking.pages.account.AddAccountPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AccountSteps {
	
	AccountCreateMessagePage accountCreateMessagePage = new AccountCreateMessagePage(DriverManager.getDriver());

	@When("user creates new account with following data")
	public void user_creates_new_account_with_following_data(DataTable table) {
		List<Map<String, String>> credList = table.asMaps();
		int customerId = Integer.parseInt(credList.get(0).get("customerId"));
		AccountType accountType = AccountType.getFrom(credList.get(0).get("accountType"));
		double initDeposit = Double.parseDouble(credList.get(0).get("initialDeposit"));
		
		AddAccountPage addAccountPage = new AddAccountPage(DriverManager.getDriver());
		addAccountPage.addNewAccount(customerId, accountType, initDeposit);
	}
	
	@Then("new account should be created")
	public void new_account_should_be_created() {
		String infoMessage = accountCreateMessagePage.getInfoMessage();
		Assert.assertEquals("Account is not created", "Account Generated Successfully!!!", infoMessage);
	}
	
	@Then("customer id should be {int}")
	public void customer_id_should_be(int customerId) {
		int customerIdActual = accountCreateMessagePage.getCustomerId();
		Assert.assertEquals("Customer Id is wrong", customerId, customerIdActual);
	}
	
	@Then("account type should be {string}")
	public void account_type_should_be(String accountType) {
	   AccountType accountTypeActual = accountCreateMessagePage.getAccountType();
	   Assert.assertEquals("Account Type is wrong",AccountType.getFrom(accountType) , accountTypeActual);
	}
	
	@Then("account amount should be {double}")
	public void deposit_should_be(double amount ) {
	    double amountActual = accountCreateMessagePage.getAccountAmount();
	    Assert.assertEquals("Account Amount is wrong", amount , amountActual,0);
	}

}
