package com.javaweb.Service;

import java.util.List;

import com.javaweb.input.BuildingSearchInput;
import com.javaweb.output.BuildingOutput;

public interface BuildingService {
	List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel); 
}
