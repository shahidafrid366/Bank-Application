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
import com.dxc.pojo.Transactions;
import com.dxc.service.CustomerService;
import com.dxc.service.CustomerServiceImpl;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CustomerService customerService = new CustomerServiceImpl();

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = "";
		String message = "";
		String temp = request.getParameter("btn");

		if (temp != null)
			action = request.getParameter("btn");

		HttpSession session = request.getSession();

		if (action.equals("login")) {
			int customerId = Integer.parseInt(request.getParameter("cid"));
			String customerPassword = request.getParameter("cname");
			session.setAttribute("customerId", customerId);
			boolean b = customerService.customerLogin(customerId, customerPassword);

			if (b == true) {
				message = "Customer Login Successful";
				session.setAttribute("message", message);
				response.sendRedirect("CustomerServices.jsp");

			} else {
				message = "Customer Login Failed";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}
		} else if (action.equals("deposit")) {
			int custId = (int) session.getAttribute("customerId");
			int amount = Integer.parseInt(request.getParameter("amount"));

			List<Customer> list = customerService.depositAmount(custId, amount);
			session.setAttribute("list", list);
			response.sendRedirect("AfterDeposit.jsp");

		} else if (action.equals("Find Customer")) {
			int cId = Integer.parseInt(request.getParameter("depositor"));
			session.setAttribute("cId", cId);
			boolean b = customerService.findCustomer(cId);

			if (b == true) {
				response.sendRedirect("TransferMoney1.jsp");
			} else {
				message = "Account With Id " + cId + " Is Not Present";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}
		} else if (action.equals("Deposit Amount")) {
			int custGiveId = (int) session.getAttribute("customerId");
			int custTakeId = (int) session.getAttribute("cId");
			int money = Integer.parseInt(request.getParameter("amount"));

			boolean list = customerService.transferAmount(custGiveId, custTakeId, money);
			if(list == true) {
				message = "Amount Transfer Successful";
				session.setAttribute("message", message);
			response.sendRedirect("View.jsp");
			} else {
				message = "Transfer Declined Check Balance And Try Again";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}
		} else if (action.equals("Withdraw Amount")) {
			int custId = (int) session.getAttribute("customerId");
			int withdrawAmount = Integer.parseInt(request.getParameter("amount"));

			boolean list = customerService.withdrawAmount(custId, withdrawAmount);
			if(list == true) {
				message = "Succesful !! Your Account has debited with Rs."+withdrawAmount+"/-";
			session.setAttribute("message", message);
			response.sendRedirect("View.jsp");
			} else {
				message = "Withdraw lesser amount";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}
		}

		else if (action.equals("Change")) {
			int custId = (int) session.getAttribute("customerId");
			String oldPassword = request.getParameter("oldpassword");
			String newPassword = request.getParameter("newpassword");
			boolean b = customerService.changePassword(custId, oldPassword, newPassword);
			if (b == true) {
				message = "Password Change Successful";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			} else {
				message = "Password Change Unsuccessful !! Change Entering Correct Current Password";
				session.setAttribute("message", message);
				response.sendRedirect("View.jsp");
			}
		} else if(action.equals("Check Balance")){
			int custId = (int) session.getAttribute("customerId");
			double bal = customerService.checkBalance(custId);

			message = "Balance For The Customer Id : " + custId + " is Rs." + bal + "/-";
			session.setAttribute("message", message);
			response.sendRedirect("View.jsp");
		} else if(action.equals("Mini Statement")) {
			int customerId = (int) session.getAttribute("customerId");
			List<Transactions> list = customerService.miniStatement(customerId);
			session.setAttribute("list", list);
			response.sendRedirect("MiniStatement.jsp");
		
		} else {
			try {
				session.invalidate();
				response.sendRedirect("home.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


}
