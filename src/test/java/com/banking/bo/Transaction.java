package com.banking.bo;

public class Transaction {
	private int transactionId;
	private double amount;
	private String transactionType;
	private String description;

	public Transaction() {
	}

	public Transaction(int transactionId, double amount, String transactionType, String description) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.description = description;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
				+ transactionType + ", description=" + description + "]";
	}
}
