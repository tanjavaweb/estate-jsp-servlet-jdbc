package com.javaweb.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.constant.SystemConstant;
import com.javaweb.dao.BuildingDao;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.util.ConnectionUtils;
import com.javaweb.util.StringUtils;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	public List<BuildingDTO> findBuilding(Integer floorArea, String name, String ward, String street, String district) {
		List<BuildingDTO> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		Statement stmtt = null;
		ResultSet rs = null;
		ResultSet rst = null;

		try {
			StringBuilder queryt = new StringBuilder("select * from typebuilding ");
			StringBuilder query = new StringBuilder("select * from building " + SystemConstant.ONE_EQUAL_ONE);
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
			stmtt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			
			while (rs.next()) {
				BuildingDTO buildingDTO = new BuildingDTO();
				buildingDTO.setName(rs.getString("name"));
				buildingDTO.setStreet(rs.getString("street"));
				buildingDTO.setWard(rs.getString("ward"));
				buildingDTO.setDistrict(rs.getString("district"));
				buildingDTO.setFloorArea(rs.getInt("floorarea"));
//
				StringBuilder variable = new StringBuilder("");
				String st = rs.getString("type");
				String[] words = st.split(",");
				for (String word : words) {
				rst = stmtt.executeQuery(queryt.toString());
				while (rst.next()) {
						if (rst.getString("code").equals(word)) {
							variable.append(rst.getString("typename")+" ");
						}
						
					}
					
				}

				buildingDTO.setType(variable.toString());
				results.add(buildingDTO);

			}

			return results;
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
				if (rst != null) {
					rst.close();
				}

			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}

		}

		return new ArrayList<>();
	}


}
