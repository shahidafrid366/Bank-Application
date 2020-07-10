package com.dxc.service;

import java.util.List;

import com.dxc.pojo.Customer;

public interface AdminService {

	public boolean confirmAdmin(int adminId, String adminPassword);

	public void createCustomer(int customerId, String customerName, double balance, String password);

	public boolean findCustomer(int customerId);

	public List<Customer> getCustomer(int customerId);

	public boolean searchCustomer(int customerId);

	public void updateCustomer(Customer c);

	public double getBalance(int custId);

	public boolean deleteCustomer(int custId);

	public List<Customer> getAllCustomers();

}
