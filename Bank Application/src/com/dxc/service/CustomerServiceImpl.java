package com.dxc.service;

import java.util.List;

import com.dxc.dao.CustomerDao;
import com.dxc.dao.CustomerDaoImpl;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Transactions;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public boolean customerLogin(int customerId, String customerPassword) {
		return customerDao.customerLogin(customerId, customerPassword);
	}

	@Override
	public List<Customer> depositAmount(int custId, int amount) {
		return customerDao.depositAmount(custId, amount);
	}

	@Override
	public boolean findCustomer(int cId) {
		return customerDao.findCustomer(cId);
	}

	@Override
	public boolean transferAmount(int custGiveId, int custTakeId, int money) {
		return customerDao.transferAmount(custGiveId, custTakeId, money);
	}

	@Override
	public boolean withdrawAmount(int custId, int withdrawAmount) {
		return customerDao.withdrawAmount(custId, withdrawAmount);
	}

	@Override
	public double checkBalance(int custId) {
		return customerDao.checkBalance(custId);
	}

	@Override
	public boolean changePassword(int custId, String oldPassword, String newPassword) {
		return customerDao.changePassword(custId, oldPassword, newPassword);
	}

	@Override
	public List<Transactions> miniStatement(int customerId) {
		System.out.println("mini servuce");
		return customerDao.miniStatement(customerId);
	}

	
	

}
