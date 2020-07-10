package com.dxc.pojo;

public class Transactions {

	private int accountNumber;
	private String transactionType;
	private double amount;
	private int transid;

	public Transactions() {

	}

	public Transactions(int accountNumber, String transactionType, double amount, int transid) {
		super();
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transid = transid;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	@Override
	public String toString() {
		return "Transactions [accountNumber=" + accountNumber + ", transactionType=" + transactionType + ", amount="
				+ amount + ", transid=" + transid + "]";
	}

}
