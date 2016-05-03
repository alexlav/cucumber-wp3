package com.swql.myapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	//Private constructor to prohibit access from another classes
	private static Database instance = new Database();
	private Connection connection;
	private Database(){
		
	}
	public static Database getInstance(){
		return instance;
	}
	/*
	 * Add methods to singleton class 
	 */
	public Connection getConnection(){
		return connection;
	}
	public void connect() throws Exception{
		if(connection!=null){
			return; //with void return just exits out of the method at that statement, not running the following statements
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}
		String url = String.format("jdbc:mysql://localhost:%d/wordpress?useSSL=false", 3306);
		connection = DriverManager.getConnection(url, "admin", "admin");
	}
	public void Disconnect() {
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Can't close connection");
			}
			connection=null;
		}
	}
}
