package com.javaweb.Service;

import java.util.List;

import com.javaweb.Service.emyeuanh.BuildingEmyeuanh;
import com.javaweb.model.BuildingModel;

public interface BuildingService {
	List<BuildingEmyeuanh> findBuilding(BuildingModel buildingModel); 
}
