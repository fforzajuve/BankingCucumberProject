package com.banking.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.banking.bo.User;
import com.banking.driver.DriverManager;
import com.banking.pages.LoginPage;
import com.banking.utils.PropertiesUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

	private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverManager.getDriver().get(PropertiesUtil.getBaseUrl());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginPage.enterUserId(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
	}
	
	@Given("user is logged in to application")
	public void user_is_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("userName");
		String password = credList.get(0).get("password");
		User user = new User(userName, password);
		loginPage.doLogin(user);
	}

	@Then("{string} alert should be displayed")
	public void alert_should_be_displayed(String alertMessage) {
		String actualAlertMessage = loginPage.getAlertText();
		Assert.assertEquals("", alertMessage, actualAlertMessage);
	}

}
