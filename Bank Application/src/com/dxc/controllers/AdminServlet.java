package com.dxc.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojo.Customer;
import com.dxc.service.AdminService;
import com.dxc.service.AdminServiceImpl;

@WebServlet("/admin_Login")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminService adminService = new AdminServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = "";
		String message = "";
		String temp = request.getParameter("btn");

		if (temp != null)
			action = request.getParameter("btn");

		HttpSession session = request.getSession();

		if (action.equals("login")) {
			int adminId = Integer.parseInt(request.getParameter("id"));
			String adminPassword = request.getParameter("password");
			session.setAttribute("adminId", adminId);
			boolean bo = adminService.confirmAdmin(adminId, adminPassword);

			if (bo == true) {
				message = "Admin Login successfully!";
				session.setAttribute("message", message);
				response.sendRedirect("AdminServices.jsp");
			} else {
				message = "Admin Login Failed!";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}

		} else if (action.equals("create customer")) {
			int customerId = Integer.parseInt(request.getParameter("accNum"));
			String customerName = request.getParameter("accName");
			double balance = Double.parseDouble(request.getParameter("balance"));
			String password = request.getParameter("password");

			adminService.createCustomer(customerId, customerName, balance, password);
			message = "Customer With Id - `" + customerId + "` & Name `" + customerName + "` Successfully Added";
			session.setAttribute("message", message);
			response.sendRedirect("View.jsp");

		} else if (action.equals("Search Id")) {

			int customerId = Integer.parseInt(request.getParameter("customerId"));
			session.setAttribute("customer_Id", customerId);
			boolean searchCustomer = adminService.findCustomer(customerId);

			if (searchCustomer == true) {
				List<Customer> list = adminService.getCustomer(customerId);
				session.setAttribute("list", list);
				response.sendRedirect("GetCustomerDetails.jsp");

			} else {
				message = "Customer Not Found";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}

		} else if (action.equals("Search Customer")) {
			int customerId = Integer.parseInt(request.getParameter("cid"));
			session.setAttribute("customer_id", customerId);
			boolean findCustomer = adminService.searchCustomer(customerId);

			if (findCustomer == true) {
				response.sendRedirect("UpdateCustomer1.jsp");

			} else {
				message = "Customer Not Found!";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}

		} else if (action.equals("Update Customer")) {
			int customerId = (int) session.getAttribute("customer_id");
			String customerName = request.getParameter("name");
			double balance = Double.parseDouble(request.getParameter("balance"));
			String password = request.getParameter("password");

			Customer c = new Customer(customerId, customerName, balance, password);
			adminService.updateCustomer(c);
			message = "Customer Details Updated!";
			session.setAttribute("message", message);
			response.sendRedirect("View.jsp");

		} else if (action.equals("Show Balance")) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			session.setAttribute("customerId", customerId);
			boolean searchCustomer = adminService.findCustomer(customerId);

			if (searchCustomer == true) {
				int custId = (int) session.getAttribute("customerId");
				double bal = adminService.getBalance(custId);
				
				message = "Balance For The Customer Id : " + custId + " is Rs." + bal + "/-";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			} else {
				message = "Customer Is Not Present In Bank";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}

		}

		else if (action.equals("Delete Customer")) {
			int customerId = Integer.parseInt(request.getParameter("delcust"));
			session.setAttribute("customerId", customerId);
			boolean searchCustomer = adminService.searchCustomer(customerId);
			if(searchCustomer== true) {
				int custId = (int) session.getAttribute("customerId");
				adminService.deleteCustomer(custId);
				message = "Customer Id "+custId+" Deleted";
			} else {
				message = "Customer Not Deleted";
			}
			session.setAttribute("message", message);
			response.sendRedirect("View.jsp");
		} 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		List<Customer> list = adminService.getAllCustomers();
		session.setAttribute("list", list);
		response.sendRedirect("GetCustomerDetails.jsp");

	}
	

}
