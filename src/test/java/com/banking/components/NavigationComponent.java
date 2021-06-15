package com.banking.components;

import org.openqa.selenium.By;

import com.banking.driver.DriverUtils;
import com.banking.enums.NavigationMenu;

public class NavigationComponent extends BaseComponent {
	private static final By navigationContainerBy = By.className("menusubnav");
	private static final By addNewCustomerLnkBy = By.linkText("New Customer");
	private static final By addNewAccountLnkBy = By.linkText("New Account");
	private static final By editAccountLnkBy = By.linkText("Edit Account");
	private static final By deleteAccountLnkBy = By.linkText("Delete Account");
	private static final By balanceEnquiryLnkBy = By.linkText("Balance Enquiry");
	private static final By depositLnkBy = By.linkText("Deposit");
	private static final By withdrawalLnkBy = By.linkText("Withdrawal");
	private static final By miniStatementLnkBy = By.linkText("Mini Statement");
	private static final By customStatementLnkBy = By.linkText("Customised Statement");
	private static final By fundTransferLnkBy = By.linkText("Fund Transfer");
	private static final By logoutLnkBy = By.linkText("Log out");
	private static final String NAVIGATION_LINK_FORMAT  = "//a[text()='%s']"; 
	

	public NavigationComponent(DriverUtils driver) {
		super(driver);
	}
	
	public void selectNavigationMenu(NavigationMenu navigationMenu){
		logger.info("Open " + navigationMenu.getName()  +" Menu");
		String navLink = String.format(NAVIGATION_LINK_FORMAT, navigationMenu.getName());
		driver.findElement(navigationContainerBy).findElement(By.xpath(navLink)).click();
	}
	
	
	public void selectNavigationMenuWithJS(NavigationMenu navigationMenu){
		logger.info("Open " + navigationMenu.getName()  +" Menu");
		String navLink = String.format(NAVIGATION_LINK_FORMAT, navigationMenu.getName());
		driver.clickElementWithJS(driver.findElement(navigationContainerBy).findElement(By.xpath(navLink)));
	}

	public boolean isNavigationMenuDisplayed() {
		boolean isNavigationDisplayed = driver.isElementDisplayed(navigationContainerBy);
		logger.info("Is Navigation Menu Displayed? " + isNavigationDisplayed);
		return isNavigationDisplayed;
	}

	
	public int getTotaNavMenuNumber() {
		logger.info("Get Nav Menu Number.");
		int navMenuNumber = driver.findElement(navigationContainerBy).findElements(By.tagName("li")).size();
		logger.info("Nav menu Number: " + navMenuNumber);
		return navMenuNumber;
	}
}
