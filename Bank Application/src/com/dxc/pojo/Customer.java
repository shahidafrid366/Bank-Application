package com.dxc.pojo;

public class Customer {

	private long accountNumber;
	private String accountName;
	private double balance;
	private String password;
	
	
	public Customer() {
		
	}

	public Customer(long accountNumber, String accountName, double balance, String password) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.password = password;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", password=" + password + "]";
	}

}
