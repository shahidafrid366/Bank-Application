package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojo.Customer;

public class AdminDaoImpl implements AdminDao {

	private static Connection conn;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean confirmAdmin(int adminId, String adminPassword) {

		try {
			PreparedStatement pstmt = conn.prepareStatement("select id, password from admin where id=? and password=?");
			pstmt.setInt(1, adminId);
			pstmt.setString(2, adminPassword);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void createCustomer(int customerId, String customerName, double balance, String password) {

		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into customer values(?,?,?,?)");
			pstmt.setInt(1, customerId);
			pstmt.setString(2, customerName);
			pstmt.setDouble(3, balance);
			pstmt.setString(4, password);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean findCustomer(int customerId) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				if (customerId == rs.getInt(1)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Customer> getCustomer(int accountNumber) {
		List<Customer> list = new ArrayList<>();
		try {

			PreparedStatement pstmt = conn.prepareStatement("select * from customer where accountNumber=?");
			pstmt.setInt(1, accountNumber);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean searchCustomer(int customerId) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				if (customerId == rs.getInt(1)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateCustomer(Customer c) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"update customer set accountName=?, balance=?, password=?  where accountNumber=?");
			pstmt.setString(1, c.getAccountName());
			pstmt.setDouble(2, c.getBalance());
			pstmt.setString(3, c.getPassword());
			pstmt.setLong(4, c.getAccountNumber());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public double getBalance(int custId) {
		double bal = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				if (custId == rs.getInt(1)) {
					bal = rs.getDouble(3);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bal;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from customer where accountNumber=?");
			pstmt.setInt(1, custId);
			pstmt.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			
			while (rs.next()) {
				list.add(new Customer(rs.getLong(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
