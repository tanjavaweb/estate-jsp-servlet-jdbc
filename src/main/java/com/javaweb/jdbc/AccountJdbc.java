package com.javaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.javaweb.constant.SystemConstant;
import com.javaweb.util.StringUtils;

public class AccountJdbc {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/javacore72022";
	static final String USER = "root";
	static final String PASS = "MYSQLa123456789@";

	public static void main(String[] args) {
		String userName = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter name: ");
		userName = input.nextLine();

		input.close();

		try {
			StringBuilder query = new StringBuilder("select * from account "+SystemConstant.ONE_EQUAL_ONE);
			if (!StringUtils.isNullOrEmpty(userName)) {
				System.out.println("name is: " + userName);
				query.append(" and name like '%" + userName + "%'");
			}

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			while (rs.next()) {
//				System.out.print("Name: " + rs.getString("name"));
//				System.out.print(", Street: " + rs.getString("street"));
//				System.out.print(", District: " + rs.getString("district"));
//				System.out.print(", Ward: " + rs.getString("ward"));
//				System.out.print(", FloorArea: " + rs.getString("floorarea"));
//				System.out.println(", NumberOfBasement: " + rs.getString("numberofbasement"));

			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Eror: " + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}

		}
	}

}
