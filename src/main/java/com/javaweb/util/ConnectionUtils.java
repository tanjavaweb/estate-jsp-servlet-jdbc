package com.javaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {	
	private static String DB_URL = "jdbc:mysql://localhost:3306/javacore72022";
	private static String USER = "root";
	private static String PASS = "MYSQLa123456789@";
	
	public static Connection getConnection() throws SQLException {
		Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
		return	conn;
	}

}
