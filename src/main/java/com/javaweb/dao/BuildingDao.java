package com.javaweb.dao;

import java.util.List;

import com.javaweb.dto.BuildingDTO;

public interface BuildingDao {
	List<BuildingDTO> findBuilding(Integer floorArea, String name, String ward, String street, String district);

}
