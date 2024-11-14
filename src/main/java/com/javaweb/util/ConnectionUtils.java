package com.javaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionUtils {	
	private static String DB_URL = "jdbc:mysql://localhost:3306/javacore72022";
	private static String USER = "root";
	private static String PASS = "MYSQLa123456789@";
	
	public static Connection getConnection() {
//		Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = null;
		ResultSet rs = null;

			return	null;
	}

}
