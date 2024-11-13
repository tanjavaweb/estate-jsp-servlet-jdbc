package com.javaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcMain {

	static final String DB_URL = "jdbc:mysql://localhost:3306/javacore72022";
	static final String USER = "root";
	static final String PASS = "MYSQLa123456789@";
	static final String QUERY = "SELECT * FROM building";

	public static void main(String[] args) {

		String name = null;
		String street = null;
		String district = null;
		String ward = null;
		Integer floorArea = null;
		Integer numberOfBasement = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter street: ");
		street = input.nextLine();
		System.out.print("Enter district: ");
		district = input.nextLine();
		System.out.print("Enter ward: ");
		ward = input.nextLine();
		System.out.print("Enter floorArea: ");
		while (true) {
			String line = input.nextLine();
			if (line.isEmpty()) {
				break;
			}

			try {
				floorArea = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
			}
		}
		System.out.println("Enter numberOfBasement: ");
		while (true) {
			String line = input.nextLine();
			if (line.isEmpty()) {
				break;
			}

			try {
				numberOfBasement = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
			}
		}

		input.close();

		try {
			StringBuilder query = new StringBuilder("select * from building where  1 = 1");
			if (name != null && !name.isEmpty()) {
				System.out.println("name is: " + name);
				query.append(" and name like '%" + name + "%'");
			}
			if (street != null && !street.isEmpty()) {
				System.out.println("street is: " + street);
				query.append(" and street like '%" + street + "%'");
			}
			if (ward != null && !ward.isEmpty()) {
				System.out.println("ward is: " + ward);
				query.append(" and ward like '%" + ward + "%'");
			}
			if (district != null && !district.isEmpty()) {
				System.out.println("district is: " + district);
				query.append(" and district like '%" + district + "%'");
			}
			if (floorArea != null) {
				System.out.println("floorArea is: " + floorArea);
				query.append(" and floorArea = " + floorArea + "");
			}
			if (numberOfBasement != null) {
				System.out.println("numberOfBasement is: " + numberOfBasement);
				query.append(" and numberOfBasement = " + numberOfBasement + "");
			}

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			while (rs.next()) {
				System.out.print("Name: " + rs.getString("name"));
				System.out.print(", Street: " + rs.getString("street"));
				System.out.print(", District: " + rs.getString("district"));
				System.out.print(", Ward: " + rs.getString("ward"));
				System.out.print(", FloorArea: " + rs.getString("floorarea"));
				System.out.println(", NumberOfBasement: " + rs.getString("numberofbasement"));

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
