package com.simplilearn.workshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyJDBCConnector {

	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/sportyshowsdb";
	private final String username = "root";
	private final String password = "admin";
	private Statement statement = null;
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public Connection getConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Calling getConnection");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	public boolean findAdmin(String name, String pass) throws SQLException {

		String SELECT_QUERY = "SELECT * FROM users where user=? and password=?";
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(SELECT_QUERY);			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				if (resultSet.getString(5).equals(name) && resultSet.getString(6).equals(pass)) {
					System.out.println("Found admin");					
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	public boolean adminPasswordChange(String user, String newPassword) throws SQLException {
		
		String UPDATE_QUERY = "UPDATE users SET password = ? WHERE user = ?";
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(UPDATE_QUERY);			
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, user);
			int rows = preparedStatement.executeUpdate();
			if (rows == 1) {				
				return true;			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean addUser(String fname, String lname, String email, String user, String pass) {
		
		String INSERT_QUERY = "INSERT INTO users (fname, lname, email, user, password) VALUES (?, ?, ?, ?, ?)";
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(INSERT_QUERY);			
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, user);
			preparedStatement.setString(5, pass);
			int rows = preparedStatement.executeUpdate();
			if (rows == 1) {				
				return true;			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;		
	}
	
	public String findUserByEmail(String email) throws SQLException {
		
		String SELECT_USER_QUERY = "SELECT * FROM users WHERE email = ?"; 
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(SELECT_USER_QUERY);			
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String user = String.format("%5d %10s %10s %25s %10s %10s", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;		
	}
	
public List<User> findAllUsers() throws SQLException {
		
		String SELECT_ALL_USERS_QUERY = "SELECT * FROM users";
		List<User> allUsers = new ArrayList<User>();
		User user;
		connection = getConnection();
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS_QUERY);
			resultSet.next(); // Skipping admin information
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setFname(resultSet.getString(2));
				user.setLname(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setUsername(resultSet.getString(5));
				user.setPassword(resultSet.getString(6));							
				allUsers.add(user);				
			}
			return allUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;		
	}

	public List<Products> manageProductsByCategory(String choice) {
		String SELECT_PRODUCTS_BY_QUERY = "SELECT * FROM products WHERE category = ?";
		List<Products> products = new ArrayList<>();
		Products product;
		connection = getConnection();
		if (choice.equals("all")) {
			try {
				String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
				statement = connection.createStatement();				
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS);			
				while(resultSet.next()) {
					product = new Products();
					product.setId(resultSet.getInt(1));
					product.setCategory(resultSet.getString(2));
					product.setBrand(resultSet.getString(3));
					product.setProductName(resultSet.getString(4));
					product.setQuantity(resultSet.getInt(5));
					product.setPrice(resultSet.getDouble(6));
					products.add(product);
				}
				
				return products;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else {
			try {
				preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_QUERY);
				preparedStatement.setString(1, choice);
				ResultSet resultSet = preparedStatement.executeQuery();			
				while(resultSet.next()) {
					product = new Products();
					product.setId(resultSet.getInt(1));
					product.setCategory(resultSet.getString(2));
					product.setBrand(resultSet.getString(3));
					product.setProductName(resultSet.getString(4));
					product.setQuantity(resultSet.getInt(5));
					product.setPrice(resultSet.getDouble(6));
					products.add(product);
				}
				
				return products;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
		return null;
	}	

	public List<Report> getReportByDate(String choice) {
		String SELECT_ORDER_BY_DATE_QUERY = "SELECT * FROM report ORDER BY purchase_date ASC";
		List<Report> reports = new ArrayList<>();
		Report report;
		connection = getConnection();
		try {
			statement = connection.createStatement();			
			ResultSet resultSet = statement.executeQuery(SELECT_ORDER_BY_DATE_QUERY);		
			while(resultSet.next()) {
				report = new Report();
				report.setId(resultSet.getInt(1));
				report.setCategory(resultSet.getString(2));
				report.setBrand(resultSet.getString(3));
				report.setProduct_name(resultSet.getString(4));
				report.setPrice(resultSet.getInt(5));
				report.setPurchase_date(resultSet.getDate(6));
				reports.add(report);
			}
			
			return reports;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	public List<Report> getReportByCategory(String choice) {
		String SELECT_ORDER_BY_CATEGORY_QUERY = "SELECT * FROM report ORDER BY category ASC";
		List<Report> reports = new ArrayList<>();
		Report report;
		connection = getConnection();
		try {
			statement = connection.createStatement();			
			ResultSet resultSet = statement.executeQuery(SELECT_ORDER_BY_CATEGORY_QUERY);		
			while(resultSet.next()) {
				report = new Report();
				report.setId(resultSet.getInt(1));
				report.setCategory(resultSet.getString(2));
				report.setBrand(resultSet.getString(3));
				report.setProduct_name(resultSet.getString(4));
				report.setPrice(resultSet.getInt(5));
				report.setPurchase_date(resultSet.getDate(6));
				reports.add(report);
			}
			
			return reports;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	public void closingFindAdminResources() throws SQLException {
		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
	
	public void closingAdminPassResources() throws SQLException {		
		preparedStatement.close();
		connection.close();
	}
	
	public void closingAddUserResources() throws SQLException {
		preparedStatement.close();
		connection.close();
	}
	
	public void closingFindUserResources() throws SQLException {
		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
	
	public void closingFindUserByEmailResources() throws SQLException {
		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
	
	public void closingFindAllUsersResources() throws SQLException {
		resultSet.close();
		statement.close();
		connection.close();
	}
}
