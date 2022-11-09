package com.indianpolice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	public static Connection getConnection() {

		
		Connection connection = null;
		
		
		// Loading Driver to primary memory
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
		}
		
		
		
		String url = "jdbc:mysql://localhost:3306/crime_information_management_system";
		
		
		
		// Making connection with database;
		
		try {
			connection = DriverManager.getConnection(url,"root","root");
			
			System.out.println("Database connection successful....");
			
		} catch (SQLException e) {
			
			System.out.println("Database Connection Fails.....");
			e.printStackTrace();
		}
		
		
		return connection;
	}

}
