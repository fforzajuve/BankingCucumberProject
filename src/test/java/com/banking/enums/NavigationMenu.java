package com.banking.enums;

public enum NavigationMenu {
	MANAGER("Manager"),
	NEW_CUSTOMER("New Customer"),
	EDIT_CUSTOMER("Edit Customer"),
	DELETE_CUSTOMER("Delete Customer"),
	NEW_ACCOUNT("New Account"),
	EDIT_ACCOUNT("Edit Account"),
	DELETE_ACCOUNT("Delete Account"),
	DEPOSIT("Deposit"),
	WITHDRAWAL("Withdrawal"),
	FUND_TRANSFER("Fund Transfer"),
	CHANGE_PASSWORD("Change Password"),
	BALANCE_ENQUIRY("Balance Enquiry"),
	MINI_STATEMENT("Mini Statement"),
	CUSTOM_STATEMENT("Customised Statement");
	
	private  NavigationMenu(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	public static NavigationMenu getFrom(String menu) {
		for(NavigationMenu navMenu :  NavigationMenu.values()) {
			if(navMenu.getName().equals(menu)) {
				return navMenu;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}
}
