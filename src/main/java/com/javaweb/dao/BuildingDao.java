package com.javaweb.dao;

import java.util.List;

import com.javaweb.dao.anhyeuem.BuildingAnhyeuem;

public interface BuildingDao {
	List<BuildingAnhyeuem> findBuilding(Integer floorArea, String name, String ward, String street, String district);

}
