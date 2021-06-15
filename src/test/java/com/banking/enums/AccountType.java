package com.banking.enums;

public enum AccountType {

	SAVINGS("Savings"),
	CURRENT("Current");
	
	private  AccountType(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public static AccountType getFrom(String type) {
		for(AccountType accountType :  AccountType.values()) {
			if(accountType.getName().equals(type)) {
				return accountType;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}
}
