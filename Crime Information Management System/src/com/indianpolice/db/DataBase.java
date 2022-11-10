package com.indianpolice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBase {
	
	private static String driverName;
	private static String url;
	private static String userName;
	private static String userPassword;
	
	
	static {
		
		ResourceBundle rsBundle = ResourceBundle.getBundle("dbDetails");
		
		driverName = rsBundle.getString("db.driverName");
		url = rsBundle.getString("db.url");
		userName = rsBundle.getString("db.userName");
		userPassword = rsBundle.getString("db.userPassword");
		
	}
	
	
	public static Connection getConnection() {

		
		Connection connection = null;
		
		
		// Loading Driver to primary memory
		
		try {
			Class.forName(driverName);
			
		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
		}
		
		
		
		// Making connection with database;
		
		try {
			connection = DriverManager.getConnection(url,userName,userPassword);
			
			System.out.println("Database connection successful....");
			
		} catch (SQLException e) {
			
			System.out.println("Database Connection Fails.....");
			e.printStackTrace();
		}
		
		
		return connection;
	}

}
