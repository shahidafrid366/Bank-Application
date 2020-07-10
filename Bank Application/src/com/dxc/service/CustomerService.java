package com.dxc.service;

import java.util.List;

import com.dxc.pojo.Customer;
import com.dxc.pojo.Transactions;

public interface CustomerService {

	public boolean customerLogin(int customerId, String customerPassword);

	public List<Customer> depositAmount(int custId, int amount);
	
	public boolean findCustomer(int cId);

	public boolean transferAmount(int custGiveId, int custTakeId, int money);
	
	public boolean withdrawAmount(int custId, int withdrawAmount);

	public List<Transactions> miniStatement(int customerId);
	
	public double checkBalance(int custId);
	
	public boolean changePassword(int custId, String oldPassword, String newPassword);

}
