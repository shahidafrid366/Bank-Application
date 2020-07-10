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
import com.dxc.pojo.Transactions;

public class CustomerDaoImpl implements CustomerDao {

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
	public boolean customerLogin(int customerId, String customerPassword) {

		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"select accountNumber, password from customer where accountNumber=? and password=?");
			pstmt.setInt(1, customerId);
			pstmt.setString(2, customerPassword);

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
	public List<Customer> depositAmount(int custId, int amount) {
		double balance = 0;
		
		List<Customer> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from customer where accountNumber=?");
			pstmt.setInt(1, custId);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			balance = rs.getDouble(3);
			balance = balance + amount;

			PreparedStatement pstmt1 = conn.prepareStatement("update customer set balance=? where accountNumber=?");
			pstmt1.setDouble(1, balance);
			pstmt1.setInt(2, custId);
			pstmt1.executeUpdate();

			PreparedStatement pstmt4 = conn.prepareStatement("select * from customer where accountNumber=?");
			pstmt4.setInt(1, custId);
			ResultSet rs3 = pstmt4.executeQuery();
			while (rs3.next()) {
				list.add(new Customer(rs3.getInt(1), rs3.getString(2), rs3.getDouble(3), rs3.getString(4)));
			}

			String sql = "insert into transactions (accountNumber, TransactionType, amount) values(?,?,?)";
			PreparedStatement pstmt3 = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt3.setInt(1, custId);
			pstmt3.setString(2, "deposit");
			pstmt3.setDouble(3, amount);
			pstmt3.execute();
			
			ResultSet rs1 = pstmt3.getGeneratedKeys();
			
			int id = 0;
			if(rs1.next()) {
				id = rs.getInt(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean findCustomer(int cId) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				if (cId == rs.getInt(1)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean transferAmount(int custGiveId, int custTakeId, int money) {

		double bal = 0;
		double bal1 = 0;

		try {
			PreparedStatement pstmt1 = conn.prepareStatement("select * from customer where accountNumber=?");
			pstmt1.setInt(1, custGiveId);
			ResultSet rs1 = pstmt1.executeQuery(); 
			rs1.next();
			bal = rs1.getDouble(3);

			double bala = bal - money;

			if(bal >= money) {

				PreparedStatement pstmt2 = conn.prepareStatement("update customer set balance = ? where accountNumber=? ");
				pstmt2.setDouble(1, bala);
				pstmt2.setInt(2, custGiveId);
				pstmt2.execute();

				PreparedStatement pstmt3 = conn.prepareStatement("select * from customer where accountNumber=?");
				pstmt3.setInt(1, custTakeId);
				ResultSet rs2 = pstmt3.executeQuery();
				rs2.next();
				bal1 = rs2.getDouble(3);
				bal1 = bal1 + money;

				PreparedStatement pstmt4 = conn.prepareStatement("update customer set balance = ? where accountNumber = ?");
				pstmt4.setDouble(1, bal1);
				pstmt4.setInt(2, custTakeId);
				pstmt4.executeUpdate();

				String sql = "insert into transactions (accountNumber, TransactionType, amount) values(?,?,?)";
				PreparedStatement pstmt5 = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pstmt5.setInt(1, custGiveId);
				pstmt5.setString(2, "transfered to "+ custGiveId);
				pstmt5.setDouble(3, money);
				pstmt5.execute();
				
				ResultSet rs3 = pstmt5.getGeneratedKeys();
				
				int id = 0;
				if(rs1.next()) {
					id = rs3.getInt(4);
				}

				PreparedStatement pstmt6 = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pstmt6.setInt(1, custGiveId);
				pstmt6.setString(2, "received from "+ custTakeId);
				pstmt6.setDouble(3, money);
				pstmt6.execute();
				
				ResultSet rs4 = pstmt5.getGeneratedKeys();
				
				int id1 = 0;
				if(rs1.next()) {
					id1 = rs4.getInt(4);
				}

				return true;

			} 
			else {
				return false;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean withdrawAmount(int custId, int withdrawAmount) {
		double balance = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from customer where accountNumber=?");
			pstmt.setInt(1, custId);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			balance = rs.getDouble(3);
			balance = balance - withdrawAmount;

			if (withdrawAmount < balance) {
				
				PreparedStatement pstmt1 = conn.prepareStatement("update customer set balance=? where accountNumber=?");
				pstmt1.setDouble(1, balance);
				pstmt1.setInt(2, custId);
				pstmt1.executeUpdate();

				String sql = "insert into transactions (accountNumber, TransactionType, amount) values(?,?,?)";
				PreparedStatement pstmt3 = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pstmt3.setInt(1, custId);
				pstmt3.setString(2, "withdraw");
				pstmt3.setDouble(3, withdrawAmount);
				pstmt3.execute();
				
				ResultSet rs1 = pstmt3.getGeneratedKeys();
				
				int id = 0;
				if(rs1.next()) {
					id = rs.getInt(4);
				}
				
			}
			return true;
		} 
	 catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

@Override
public double checkBalance(int custId) {
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
public boolean changePassword(int custId, String oldPassword, String newPassword) {
	try {
		PreparedStatement pstmt = conn.prepareStatement("select password from customer where accountNumber=?");
		pstmt.setInt(1, custId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			if(oldPassword.equals(rs.getString("password"))) {
				PreparedStatement pstmt1 = conn.prepareStatement("update customer set password=? where accountNumber=?");
				pstmt1.setString(1, newPassword);
				pstmt1.setInt(2, custId);
				pstmt1.executeUpdate();
				return true;
			} else {
				return false;
			}
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

@Override
public List<Transactions> miniStatement(int customerId) {

	List<Transactions> list = new ArrayList<>();
	try {
		PreparedStatement pstmt = conn.prepareStatement("select * from transactions where accountNumber=? order by transid desc limit 5");
		pstmt.setInt(1, customerId);
		ResultSet rs = pstmt.executeQuery();

		while(rs.next()) {
			list.add(new Transactions (rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}

}
