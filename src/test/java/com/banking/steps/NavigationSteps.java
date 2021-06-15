package com.banking.steps;



import org.junit.Assert;

import com.banking.driver.DriverManager;
import com.banking.enums.NavigationMenu;
import com.banking.pages.HomeBankPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationSteps {
	HomeBankPage homePage = new HomeBankPage(DriverManager.getDriver());

	@Then("user with name {string} should be logged in")
	public void user_with_name_should_be_logged_in(String userName) {
		String userId = homePage.getUserId();
		Assert.assertTrue("User Name is wrong", userName.equals(userId));
	}

	@Then("^navigation menu should be displayed")
	public void navigation_menu_should_be_displayed() {
		boolean isNavMenuDisplayed = homePage.getNavigationComponent().isNavigationMenuDisplayed();
		Assert.assertTrue("Navigation Menu is not dispalyed", isNavMenuDisplayed);
	}
	
	@When("user opens {string} Navigation Menu")
	public void user_opens_navigation_menu(String menu) {
		homePage.getNavigationComponent().selectNavigationMenu(NavigationMenu.getFrom(menu));
	}


}
