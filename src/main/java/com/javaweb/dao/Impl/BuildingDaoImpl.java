package com.javaweb.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.constant.SystemConstant;
import com.javaweb.dao.BuildingDao;
import com.javaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.javaweb.util.ConnectionUtils;
import com.javaweb.util.StringUtils;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	public List<BuildingAnhyeuem> findBuilding(Integer floorArea, String name, String ward, String street, String district) {
//		BuildingAnhyeuem[] results = new BuildingAnhyeuem[1];
		List<BuildingAnhyeuem> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	

		try {
			StringBuilder query = new StringBuilder("select * from building "+SystemConstant.ONE_EQUAL_ONE);
			if (!StringUtils.isNullOrEmpty(name)) {
				System.out.println("name is: " + name);
				query.append(" and name like '%" + name + "%'");
			}
			if (!StringUtils.isNullOrEmpty(street)) {
				System.out.println("street is: " + street);
				query.append(" and street like '%" + street + "%'");
			}
			if (!StringUtils.isNullOrEmpty(ward)) {
				System.out.println("ward is: " + ward);
				query.append(" and ward like '%" + ward + "%'");
			}
			if (!StringUtils.isNullOrEmpty(district)) {
				System.out.println("district is: " + district);
				query.append(" and district like '%" + district + "%'");
			}
			if (floorArea != null) {
				System.out.println("floorArea is: " + floorArea);
				query.append(" and floorArea = " + floorArea + "");
			}
			

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
//			int i =0;
			while (rs.next()) {
			BuildingAnhyeuem buildingAnhyeuem = new BuildingAnhyeuem();
			buildingAnhyeuem.setName(rs.getString("name"));
			buildingAnhyeuem.setStreet(rs.getString("street"));
			buildingAnhyeuem.setWard(rs.getString("ward"));
			buildingAnhyeuem.setDistrict(rs.getString("district"));
			buildingAnhyeuem.setFloorArea(rs.getInt("floorarea"));
//			results[i] = buildingAnhyeuem;
//			i++;
			results.add(buildingAnhyeuem);

			}
			return	results;
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
		
		return new ArrayList<>();
	}
//	public static void main(String[] args) {
//		BuildingAnhyeuem[] results = new BuildingDaoImpl().findBuilding(100, "",  "",  "",  "");
//		for (BuildingAnhyeuem item : results) {
//			System.out.println(item.getName());
//		}
//	}

}
