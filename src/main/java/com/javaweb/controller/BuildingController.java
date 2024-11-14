package com.javaweb.controller;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.Service.BuildingService;
import com.javaweb.Service.Impl.BuildingServiceImpl;
import com.javaweb.Service.emyeuanh.BuildingEmyeuanh;
import com.javaweb.input.BuildingSearchInput;
import com.javaweb.output.BuildingOutput;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImpl() ;
	
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch) {
		List<BuildingOutput> results = new ArrayList<>();
		List<BuildingEmyeuanh> emyeuanhs= buildingService.findBuilding(buildingSearch);
		
		for (BuildingEmyeuanh emyeuanh : emyeuanhs) {
			BuildingOutput buildingModel = new BuildingOutput();
			buildingModel.setName(emyeuanh.getName()+" ");
			buildingModel.setAddress(emyeuanh.getStreet()+" "+emyeuanh.getWard()+" "+emyeuanh.getDistrict());
			results.add(buildingModel);
		}
		return results;
	}

}
	