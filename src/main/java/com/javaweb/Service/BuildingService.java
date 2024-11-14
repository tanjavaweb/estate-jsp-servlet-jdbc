package com.javaweb.Service;

import java.util.List;

import com.javaweb.Service.emyeuanh.BuildingEmyeuanh;
import com.javaweb.input.BuildingSearchInput;

public interface BuildingService {
	List<BuildingEmyeuanh> findBuilding(BuildingSearchInput buildingModel); 
}
