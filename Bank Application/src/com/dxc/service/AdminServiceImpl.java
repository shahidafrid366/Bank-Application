package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDao;
import com.dxc.dao.AdminDaoImpl;
import com.dxc.pojo.Customer;

public class AdminServiceImpl implements AdminService {

	AdminDao adminDao = new AdminDaoImpl();

	@Override
	public boolean confirmAdmin(int adminId, String adminPassword) {
		return adminDao.confirmAdmin(adminId, adminPassword);
	}

	@Override
	public void createCustomer(int customerId, String customerName, double balance, String password) {
		adminDao.createCustomer(customerId, customerName, balance, password);
	}

	@Override
	public boolean findCustomer(int customerId) {
		return adminDao.findCustomer(customerId);
	}

	@Override
	public List<Customer> getCustomer(int accountNumber) {
		return adminDao.getCustomer(accountNumber);
	}

	@Override
	public boolean searchCustomer(int customerId) {
		return adminDao.searchCustomer(customerId);
	}

	@Override
	public void updateCustomer(Customer c) {
		adminDao.updateCustomer(c);
	}

	@Override
	public double getBalance(int custId) {
		return adminDao.getBalance(custId);
	}

	@Override
	public boolean deleteCustomer(int custId) {
		return adminDao.deleteCustomer(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return adminDao.getAllCustomers();
	}




}
