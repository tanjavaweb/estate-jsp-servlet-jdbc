package com.javaweb.controller;

import java.util.List;

import com.javaweb.Service.BuildingService;
import com.javaweb.Service.Impl.BuildingServiceImpl;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.input.BuildingSearchInput;
import com.javaweb.output.BuildingOutput;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImpl() ;
	
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch) {
		List<BuildingOutput> results = buildingService.findBuilding(buildingSearch);		
		return results;
	}
	
	public BuildingDTO insert(BuildingDTO newBuilding) {
		return null;
	}

}
	